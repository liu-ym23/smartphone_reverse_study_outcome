package android.window;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.window.ImeOnBackInvokedDispatcher;
import java.util.NoSuchElementException;
import java.util.function.BiConsumer;

/* loaded from: classes.dex */
public class StepOSImeOnBackInvokedDispatcherExtImpl implements IStepOSImeOnBackInvokedDispatcherExt {
    private static final String TAG = "StepOSImeOnBackExt";
    private Handler mHandler;
    private final SparseArray<Recipient> mRecipients = new SparseArray<>();
    private BiConsumer<Integer, OnBackInvokedDispatcher> mUnregisterReceivedInvoker;

    public void onAttach(ImeOnBackInvokedDispatcher host) {
    }

    public void onDetach() {
        this.mRecipients.clear();
        this.mHandler = null;
        this.mUnregisterReceivedInvoker = null;
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void bindUnregisterReceivedInvoker(BiConsumer<Integer, OnBackInvokedDispatcher> invoker) {
        this.mUnregisterReceivedInvoker = invoker;
    }

    public void onQueuedReceiveWhileNoReceivingDispatcher(int resultCode, Bundle resultData) {
        if (resultCode != 1 || resultData == null || this.mUnregisterReceivedInvoker == null) {
            return;
        }
        int callbackId = resultData.getInt("id");
        this.mUnregisterReceivedInvoker.accept(Integer.valueOf(callbackId), null);
    }

    public void linkBinderDeathOrRollback(IOnBackInvokedCallback iCallback, int callbackId, WindowOnBackInvokedDispatcher receivingDispatcher, Runnable rollbackIfLinkFails) throws RemoteException {
        if (iCallback == null) {
            Log.w(TAG, "linkBinderDeathOrRollback: iCallback is null, callbackId=" + callbackId);
            if (rollbackIfLinkFails != null) {
                rollbackIfLinkFails.run();
                return;
            }
            return;
        }
        try {
            Recipient recipient = new Recipient(callbackId, receivingDispatcher);
            iCallback.asBinder().linkToDeath(recipient, 0);
            this.mRecipients.put(callbackId, recipient);
        } catch (RemoteException e) {
            Log.e(TAG, "linkToDeath failed for ime back callback, rolling back registration.", e);
            if (rollbackIfLinkFails != null) {
                rollbackIfLinkFails.run();
            }
        }
    }

    public void removeRecipientIfOrphan(int callbackId) {
        this.mRecipients.remove(callbackId);
    }

    public void unregisterOnReceivingDispatcher(int callbackId, ImeOnBackInvokedDispatcher.ImeOnBackInvokedCallback imeCallback, OnBackInvokedDispatcher receivingDispatcher) {
        Recipient recipient = this.mRecipients.get(callbackId);
        if (recipient != null) {
            try {
                imeCallback.getIOnBackInvokedCallbackForDeathLink().asBinder().unlinkToDeath(recipient, 0);
            } catch (NoSuchElementException e) {
                Log.d(TAG, "unlinkToDeath: already unlinked (e.g. binder died), ignored. callbackId=" + callbackId, e);
            }
            this.mRecipients.remove(callbackId);
        }
        if (receivingDispatcher != null) {
            receivingDispatcher.unregisterOnBackInvokedCallback(imeCallback);
        }
    }

    public void unlinkAllForClear(Iterable<ImeOnBackInvokedDispatcher.ImeOnBackInvokedCallback> callbacks) {
        for (ImeOnBackInvokedDispatcher.ImeOnBackInvokedCallback imeCallback : callbacks) {
            int callbackId = imeCallback.getId();
            Recipient recipient = this.mRecipients.get(callbackId);
            if (recipient != null) {
                try {
                    imeCallback.getIOnBackInvokedCallbackForDeathLink().asBinder().unlinkToDeath(recipient, 0);
                } catch (NoSuchElementException e) {
                    Log.d(TAG, "unlinkToDeath: already unlinked (e.g. binder died), ignored. callbackId=" + callbackId, e);
                }
                this.mRecipients.remove(callbackId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class Recipient implements IBinder.DeathRecipient {
        private final int mCallbackId;
        private final WindowOnBackInvokedDispatcher mReceivingDispatcher;

        Recipient(int callbackId, WindowOnBackInvokedDispatcher receivingDispatcher) {
            this.mCallbackId = callbackId;
            this.mReceivingDispatcher = receivingDispatcher;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            final BiConsumer<Integer, OnBackInvokedDispatcher> invoker = StepOSImeOnBackInvokedDispatcherExtImpl.this.mUnregisterReceivedInvoker;
            if (invoker == null) {
                return;
            }
            if (StepOSImeOnBackInvokedDispatcherExtImpl.this.mHandler != null) {
                StepOSImeOnBackInvokedDispatcherExtImpl.this.mHandler.post(new Runnable() { // from class: android.window.StepOSImeOnBackInvokedDispatcherExtImpl$Recipient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$binderDied$0(invoker);
                    }
                });
            } else {
                invoker.accept(Integer.valueOf(this.mCallbackId), this.mReceivingDispatcher);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$binderDied$0(BiConsumer invoker) {
            invoker.accept(Integer.valueOf(this.mCallbackId), this.mReceivingDispatcher);
        }
    }
}
