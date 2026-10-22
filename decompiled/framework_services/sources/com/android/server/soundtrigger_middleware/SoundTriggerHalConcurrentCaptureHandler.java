package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.ModelParameterRange;
import android.media.soundtrigger.PhraseSoundModel;
import android.media.soundtrigger.Properties;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.PhraseRecognitionEventSys;
import android.media.soundtrigger_middleware.RecognitionEventSys;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerHalConcurrentCaptureHandler implements ISoundTriggerHal, ICaptureStateNotifier.Listener {
    private final Set<Integer> mActiveModels;
    private final CallbackThread mCallbackThread;
    private boolean mCaptureState;
    private final Map<IBinder.DeathRecipient, IBinder.DeathRecipient> mDeathRecipientMap;
    private final ISoundTriggerHal mDelegate;
    private ISoundTriggerHal.GlobalCallback mGlobalCallback;
    private final Map<Integer, LoadedModel> mLoadedModels;
    private final ICaptureStateNotifier mNotifier;
    private final Object mStartStopLock;

    private static class CallbackThread implements Runnable {
        private final Queue<Runnable> mList;
        private int mProcessedCount;
        private int mPushCount;
        private boolean mQuitting;
        private final Thread mThread;

        CallbackThread() {
            this.mList = new LinkedList();
            this.mPushCount = 0;
            this.mProcessedCount = 0;
            this.mQuitting = false;
            this.mThread = new Thread(this, "STHAL Concurrent Capture Handler Callback");
            this.mThread.start();
        }

        @Override // java.lang.Runnable
        public void run() {
        L15:
            Runnable toRun = pop();     // Catch: InterruptedException -> L13
            if (toRun == null) goto L4;
            toRun.run();     // Catch: InterruptedException -> L13
            Queue<Runnable> r1 = this.mList;     // Catch: InterruptedException -> L13
            monitor-enter(r1);     // Catch: InterruptedException -> L13
            this.mProcessedCount++;     // Catch: Throwable -> L10
            this.mList.notifyAll();     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L13
        L4:
            return;
        }

        boolean push(Runnable runnable) {
            Queue<Runnable> r0 = this.mList;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mQuitting == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L11:
            this.mList.add(runnable);     // Catch: Throwable -> L9
            this.mPushCount++;     // Catch: Throwable -> L9
            this.mList.notifyAll();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        }

        void flush() {
            Queue<Runnable> r0 = this.mList;     // Catch: InterruptedException -> L15
            monitor-enter(r0);     // Catch: InterruptedException -> L15
            int pushCount = this.mPushCount;     // Catch: Throwable -> L8
        L6:
            if (this.mProcessedCount == pushCount) goto L11;
            this.mList.wait();     // Catch: Throwable -> L8
            goto L6
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L8
            goto L16
        L21:
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
        }

        void quit() {
            Queue<Runnable> r0 = this.mList;
            monitor-enter(r0);
            this.mQuitting = true;     // Catch: Throwable -> L8
            this.mList.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private Runnable pop() throws InterruptedException {
            Queue<Runnable> r0 = this.mList;
            monitor-enter(r0);
        L23:
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mList.isEmpty() == false) goto L12;
            if (this.mQuitting == true) goto L12;
            this.mList.wait();     // Catch: Throwable -> L9
        L12:
            if (this.mList.isEmpty() == true) goto L14;
        L18:
            Runnable r1 = this.mList.remove();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L14:
            if (this.mQuitting == false) goto L18;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        }
    }

    private class CallbackWrapper implements ISoundTriggerHal.ModelCallback {
        private final ISoundTriggerHal.ModelCallback mDelegateCallback;
        final /* synthetic */ SoundTriggerHalConcurrentCaptureHandler this$0;

        public static /* synthetic */ void $r8$lambda$GjzZncg3PTXvyZegXHXDnrt37jQ(CallbackWrapper r0, int r1) {
            r0.lambda$modelUnloaded$2(r1);
        }

        public static /* synthetic */ void $r8$lambda$_b4NsC6hKZ70bF4yexGXgSIwy4Y(CallbackWrapper r0, int r1, PhraseRecognitionEventSys r2) {
            r0.lambda$phraseRecognitionCallback$1(r1, r2);
        }

        public static /* synthetic */ void $r8$lambda$m1F4suypdXLwNWP9l8YjzPF_v60(CallbackWrapper r0, int r1, RecognitionEventSys r2) {
            r0.lambda$recognitionCallback$0(r1, r2);
        }

        /* synthetic */ CallbackWrapper(SoundTriggerHalConcurrentCaptureHandler r1, ISoundTriggerHal.ModelCallback r2, SoundTriggerHalConcurrentCaptureHandlerIA r3) {
            this(r1, r2);
        }

        private CallbackWrapper(SoundTriggerHalConcurrentCaptureHandler r1, ISoundTriggerHal.ModelCallback delegateCallback) {
            this.this$0 = r1;
            this.mDelegateCallback = delegateCallback;
        }

        @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
        public void recognitionCallback(final int modelHandle, final RecognitionEventSys event) {
            Set r0 = SoundTriggerHalConcurrentCaptureHandler.m8252$$Nest$fgetmActiveModels(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (SoundTriggerHalConcurrentCaptureHandler.m8252$$Nest$fgetmActiveModels(this.this$0).contains(Integer.valueOf(modelHandle)) == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (event.recognitionEvent.recognitionStillActive == true) goto L13;
            SoundTriggerHalConcurrentCaptureHandler.m8252$$Nest$fgetmActiveModels(this.this$0).remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L8
        L13:
            SoundTriggerHalConcurrentCaptureHandler.m8253$$Nest$fgetmCallbackThread(this.this$0).push(new SoundTriggerHalConcurrentCaptureHandler$CallbackWrapper$$ExternalSyntheticLambda0(this, modelHandle, event));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$recognitionCallback$0(int modelHandle, RecognitionEventSys event) {
            this.mDelegateCallback.recognitionCallback(modelHandle, event);
        }

        @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
        public void phraseRecognitionCallback(final int modelHandle, final PhraseRecognitionEventSys event) {
            Set r0 = SoundTriggerHalConcurrentCaptureHandler.m8252$$Nest$fgetmActiveModels(this.this$0);
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (SoundTriggerHalConcurrentCaptureHandler.m8252$$Nest$fgetmActiveModels(this.this$0).contains(Integer.valueOf(modelHandle)) == true) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (event.phraseRecognitionEvent.common.recognitionStillActive == true) goto L13;
            SoundTriggerHalConcurrentCaptureHandler.m8252$$Nest$fgetmActiveModels(this.this$0).remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L8
        L13:
            SoundTriggerHalConcurrentCaptureHandler.m8253$$Nest$fgetmCallbackThread(this.this$0).push(new SoundTriggerHalConcurrentCaptureHandler$CallbackWrapper$$ExternalSyntheticLambda2(this, modelHandle, event));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
        }

        private /* synthetic */ void lambda$phraseRecognitionCallback$1(int modelHandle, PhraseRecognitionEventSys event) {
            this.mDelegateCallback.phraseRecognitionCallback(modelHandle, event);
        }

        private /* synthetic */ void lambda$modelUnloaded$2(int modelHandle) {
            this.mDelegateCallback.modelUnloaded(modelHandle);
        }

        @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal.ModelCallback
        public void modelUnloaded(final int modelHandle) {
            SoundTriggerHalConcurrentCaptureHandler.m8253$$Nest$fgetmCallbackThread(this.this$0).push(new SoundTriggerHalConcurrentCaptureHandler$CallbackWrapper$$ExternalSyntheticLambda1(this, modelHandle));
        }
    }

    private static class LoadedModel {
        public final ISoundTriggerHal.ModelCallback callback;
        public final int type;

        LoadedModel(int type, ISoundTriggerHal.ModelCallback callback) {
            this.type = type;
            this.callback = callback;
        }
    }

    public static /* synthetic */ void $r8$lambda$JXS8AAjwZM7iC1JaUPaGbgmgln8(SoundTriggerHalConcurrentCaptureHandler r0, IBinder.DeathRecipient r1) {
        r0.lambda$linkToDeath$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$aSnjbR9orftVGAFLJBuyQPERK7Y(int r0, LoadedModel r1) {
        lambda$abortAllActiveModels$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$j4m6ahclSaa4iqAjwqizlcfaRDU(SoundTriggerHalConcurrentCaptureHandler r0, ISoundTriggerHal.GlobalCallback r1) {
        r0.lambda$registerCallback$1(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveModels, reason: not valid java name */
    static /* bridge */ /* synthetic */ Set m8252$$Nest$fgetmActiveModels(SoundTriggerHalConcurrentCaptureHandler r0) {
        return r0.mActiveModels;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbackThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ CallbackThread m8253$$Nest$fgetmCallbackThread(SoundTriggerHalConcurrentCaptureHandler r0) {
        return r0.mCallbackThread;
    }

    public SoundTriggerHalConcurrentCaptureHandler(ISoundTriggerHal delegate, ICaptureStateNotifier notifier) {
        this.mStartStopLock = new Object();
        this.mLoadedModels = new ConcurrentHashMap();
        this.mActiveModels = new HashSet();
        this.mDeathRecipientMap = new ConcurrentHashMap();
        this.mCallbackThread = new CallbackThread();
        this.mDelegate = delegate;
        this.mNotifier = notifier;
        this.mCaptureState = this.mNotifier.registerListener(this);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void startRecognition(int modelHandle, int deviceHandle, int ioHandle, RecognitionConfig config) {
        Object r0 = this.mStartStopLock;
        monitor-enter(r0);
        Set<Integer> r1 = this.mActiveModels;     // Catch: Throwable -> L12
        monitor-enter(r1);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L7:
        if (this.mCaptureState == true) goto L17;
        this.mDelegate.startRecognition(modelHandle, deviceHandle, ioHandle, config);     // Catch: Throwable -> L14
        this.mActiveModels.add(Integer.valueOf(modelHandle));     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L17:
        throw new RecoverableException(1);     // Catch: Throwable -> L14
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void stopRecognition(int modelHandle) {
        Object r0 = this.mStartStopLock;
        monitor-enter(r0);
        Set<Integer> r1 = this.mActiveModels;     // Catch: Throwable -> L10
        monitor-enter(r1);     // Catch: Throwable -> L10
        boolean wasActive = this.mActiveModels.remove(Integer.valueOf(modelHandle));     // Catch: Throwable -> L15
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (wasActive == false) goto L12;
        this.mDelegate.stopRecognition(modelHandle);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        this.mCallbackThread.flush();
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.soundtrigger_middleware.ICaptureStateNotifier.Listener
    public void onCaptureStateChange(boolean active) {
        Object r0 = this.mStartStopLock;
        monitor-enter(r0);
        if (active == false) goto L9;
        abortAllActiveModels();     // Catch: Throwable -> L6
    L11:
        this.mCaptureState = active;     // Catch: Throwable -> L6
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L9:
        if (this.mGlobalCallback == null) goto L11;
        this.mGlobalCallback.onResourcesAvailable();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    private void abortAllActiveModels() {
    L2:
        Set<Integer> r0 = this.mActiveModels;
        monitor-enter(r0);
        Iterator<Integer> iterator = this.mActiveModels.iterator();     // Catch: Throwable -> L8
        if (iterator.hasNext() == false) goto L6;
        final int toStop = iterator.next().intValue();     // Catch: Throwable -> L8
        this.mActiveModels.remove(Integer.valueOf(toStop));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mDelegate.stopRecognition(toStop);
        final LoadedModel model = this.mLoadedModels.get(Integer.valueOf(toStop));
        this.mCallbackThread.push(new SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda2(toStop, model));
        goto L2
    L6:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$abortAllActiveModels$0(int toStop, LoadedModel model) {
        notifyAbort(toStop, model);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadSoundModel(SoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        int handle = this.mDelegate.loadSoundModel(soundModel, new CallbackWrapper(this, callback, null));
        this.mLoadedModels.put(Integer.valueOf(handle), new LoadedModel(1, callback));
        return handle;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int loadPhraseSoundModel(PhraseSoundModel soundModel, ISoundTriggerHal.ModelCallback callback) {
        int handle = this.mDelegate.loadPhraseSoundModel(soundModel, new CallbackWrapper(this, callback, null));
        this.mLoadedModels.put(Integer.valueOf(handle), new LoadedModel(0, callback));
        return handle;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unloadSoundModel(int modelHandle) {
        this.mLoadedModels.remove(Integer.valueOf(modelHandle));
        this.mDelegate.unloadSoundModel(modelHandle);
    }

    private /* synthetic */ void lambda$registerCallback$1(ISoundTriggerHal.GlobalCallback callback) {
        CallbackThread r0 = this.mCallbackThread;
        callback.getClass();
        r0.push(new SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda0(callback));
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void registerCallback(final ISoundTriggerHal.GlobalCallback callback) {
        this.mGlobalCallback = new SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda1(this, callback);
        this.mDelegate.registerCallback(this.mGlobalCallback);
    }

    private /* synthetic */ void lambda$linkToDeath$2(final IBinder.DeathRecipient recipient) {
        CallbackThread r0 = this.mCallbackThread;
        recipient.getClass();
        r0.push(new SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda4(recipient));
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void linkToDeath(final IBinder.DeathRecipient recipient) {
        IBinder.DeathRecipient wrapper = new SoundTriggerHalConcurrentCaptureHandler$$ExternalSyntheticLambda3(this, recipient);
        this.mDelegate.linkToDeath(wrapper);
        this.mDeathRecipientMap.put(recipient, wrapper);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void unlinkToDeath(IBinder.DeathRecipient recipient) {
        this.mDelegate.unlinkToDeath(this.mDeathRecipientMap.remove(recipient));
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void flushCallbacks() {
        this.mDelegate.flushCallbacks();
        this.mCallbackThread.flush();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientAttached(IBinder binder) {
        this.mDelegate.clientAttached(binder);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void clientDetached(IBinder binder) {
        this.mDelegate.clientDetached(binder);
    }

    private static void notifyAbort(int modelHandle, LoadedModel model) {
        switch(model.type) {
            case 0: goto L6;
            case 1: goto L5;
            default: goto L9;
        };
    L5:
        model.callback.recognitionCallback(modelHandle, AidlUtil.newAbortEvent());
        return;
    L6:
        model.callback.phraseRecognitionCallback(modelHandle, AidlUtil.newAbortPhraseEvent());
        return;
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void detach() {
        this.mDelegate.detach();
        this.mNotifier.unregisterListener(this);
        this.mCallbackThread.quit();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void reboot() {
        this.mDelegate.reboot();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public Properties getProperties() {
        return this.mDelegate.getProperties();
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void forceRecognitionEvent(int modelHandle) {
        this.mDelegate.forceRecognitionEvent(modelHandle);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public int getModelParameter(int modelHandle, int param) {
        return this.mDelegate.getModelParameter(modelHandle, param);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public void setModelParameter(int modelHandle, int param, int value) {
        this.mDelegate.setModelParameter(modelHandle, param, value);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public ModelParameterRange queryParameter(int modelHandle, int param) {
        return this.mDelegate.queryParameter(modelHandle, param);
    }

    @Override // com.android.server.soundtrigger_middleware.ISoundTriggerHal
    public String interfaceDescriptor() {
        return this.mDelegate.interfaceDescriptor();
    }
}
