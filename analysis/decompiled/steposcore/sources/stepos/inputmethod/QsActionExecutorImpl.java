package stepos.inputmethod;

import android.content.Intent;
import android.inputmethodservice.InputMethodHelper;
import android.inputmethodservice.InputMethodService;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Slog;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import com.android.internal.inputmethod.CancellationGroup;
import com.android.internal.inputmethod.IRemoteInputConnection;
import stepos.inputmethod.IQsActionExecutor;

/* loaded from: classes.dex */
class QsActionExecutorImpl extends IQsActionExecutor.Stub {
    private static final String TAG = "QsActionManager";
    private EditorInfo mAppEditorInfo;
    private InputBinding mAppInputBinding;
    private InputConnection mAppInputConnection;
    private final H mHandler;
    private final InputMethodService mIms;
    private final QsActionItemsView mItemsView;
    private EditorInfo mPanelEditorInfo;
    private InputConnection mPanelInputConnection;
    private IBinder.DeathRecipient mRemoteDeathRecipient;
    private IRemoteInputConnection mTrackedRemoteInputConnection;
    private final CancellationGroup cancellationGroup = new CancellationGroup();
    private final int MSG_START_INPUT = 0;
    private final int MSG_RESET_INPUT = 1;

    private class H extends Handler {
        H(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    InputMethod inputMethod = QsActionExecutorImpl.this.mIms.getInputMethodInternal();
                    if (inputMethod != null && QsActionExecutorImpl.this.mPanelInputConnection != null) {
                        InputBinding binding = new InputBinding(QsActionExecutorImpl.this.mPanelInputConnection, new Binder(), 0, 0);
                        inputMethod.bindInput(binding);
                        inputMethod.startInput(QsActionExecutorImpl.this.mPanelInputConnection, QsActionExecutorImpl.this.mPanelEditorInfo);
                        break;
                    }
                    break;
                case 1:
                    InputMethod inputMethod2 = QsActionExecutorImpl.this.mIms.getInputMethodInternal();
                    if (QsActionExecutorImpl.this.mAppInputBinding != null && inputMethod2 != null) {
                        inputMethod2.bindInput(QsActionExecutorImpl.this.mAppInputBinding);
                        inputMethod2.startInput(QsActionExecutorImpl.this.mAppInputConnection, QsActionExecutorImpl.this.mAppEditorInfo);
                        QsActionExecutorImpl.this.mAppInputBinding = null;
                        QsActionExecutorImpl.this.mAppEditorInfo = null;
                        QsActionExecutorImpl.this.mAppInputConnection = null;
                        break;
                    }
                    break;
            }
        }
    }

    public QsActionExecutorImpl(QsActionItemsView qsActionItemsView, InputMethodService ims) {
        this.mIms = ims;
        this.mItemsView = qsActionItemsView;
        this.mHandler = new H(this.mItemsView.getHandler().getLooper());
    }

    private void clearRemoteDeath() {
        if (this.mTrackedRemoteInputConnection != null && this.mRemoteDeathRecipient != null) {
            try {
                this.mTrackedRemoteInputConnection.asBinder().unlinkToDeath(this.mRemoteDeathRecipient, 0);
            } catch (Exception e) {
                Slog.w("QsActionManager", "unlinkToDeath", e);
            }
        }
        this.mTrackedRemoteInputConnection = null;
        this.mRemoteDeathRecipient = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: resetInputInputConnection, reason: merged with bridge method [inline-methods] */
    public void lambda$bindInput$0() {
        synchronized (this) {
            this.cancellationGroup.cancelAll();
            this.mPanelInputConnection = null;
            this.mPanelEditorInfo = null;
            clearRemoteDeath();
            if (this.mAppInputBinding != null) {
                this.mHandler.removeMessages(1);
                this.mHandler.removeMessages(0);
                this.mHandler.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public boolean commitText(CharSequence charSequence, boolean verificationCode) {
        InputConnection connection;
        QsActionManager.enforceCallingPermission(this.mIms, "commitText");
        long origId = Binder.clearCallingIdentity();
        try {
            synchronized (this) {
                connection = this.mAppInputConnection != null ? this.mAppInputConnection : this.mIms.getCurrentInputConnection();
            }
            if (connection != null) {
                return connection.commitText(charSequence, charSequence.length());
            }
            Binder.restoreCallingIdentity(origId);
            return false;
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public void bindInput(IRemoteInputConnection remoteInputConnection, EditorInfo editorInfo) throws RemoteException {
        QsActionManager.enforceCallingPermission(this.mIms, "bindInput");
        long origId = Binder.clearCallingIdentity();
        try {
            Slog.i("QsActionManager", "bindInput editorInfo=" + editorInfo);
            InputMethod inputMethod = this.mIms.getInputMethodInternal();
            if (inputMethod == null) {
                throw new RemoteException("inputMethod is null");
            }
            if (remoteInputConnection != null) {
                synchronized (this) {
                    clearRemoteDeath();
                    this.mTrackedRemoteInputConnection = remoteInputConnection;
                    this.mRemoteDeathRecipient = new IBinder.DeathRecipient() { // from class: stepos.inputmethod.QsActionExecutorImpl$$ExternalSyntheticLambda0
                        @Override // android.os.IBinder.DeathRecipient
                        public final void binderDied() {
                            this.f$0.lambda$bindInput$0();
                        }
                    };
                    try {
                        remoteInputConnection.asBinder().linkToDeath(this.mRemoteDeathRecipient, 0);
                    } catch (RemoteException e) {
                        Slog.e("QsActionManager", "linkToDeath", e);
                    }
                    this.mAppInputBinding = this.mAppInputBinding == null ? this.mIms.getCurrentInputBinding() : this.mAppInputBinding;
                    this.mAppInputConnection = this.mAppInputConnection == null ? this.mIms.getCurrentInputConnection() : this.mAppInputConnection;
                    this.mAppEditorInfo = this.mAppEditorInfo == null ? this.mIms.getCurrentInputEditorInfo() : this.mAppEditorInfo;
                    this.mPanelInputConnection = InputMethodHelper.createRemoteInputConnection(this.mIms, remoteInputConnection, this.cancellationGroup);
                    this.mPanelEditorInfo = editorInfo;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(0);
                    this.mHandler.obtainMessage(0).sendToTarget();
                }
            } else {
                lambda$bindInput$0();
            }
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    public void resetState() {
        lambda$bindInput$0();
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public IBinder getWindowToken() {
        QsActionManager.enforceCallingPermission(this.mIms, "getWindowToken");
        long origId = Binder.clearCallingIdentity();
        try {
            return this.mItemsView.getWindowToken();
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public IRemoteInputConnection getInputConnection() {
        IRemoteInputConnection inputConnection;
        QsActionManager.enforceCallingPermission(this.mIms, "getInputConnection");
        long origId = Binder.clearCallingIdentity();
        try {
            synchronized (this) {
                InputConnection connection = this.mAppInputConnection != null ? this.mAppInputConnection : this.mIms.getCurrentInputConnection();
                inputConnection = InputMethodHelper.getInputConnection(connection);
            }
            return inputConnection;
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public EditorInfo getEditorInfo() {
        EditorInfo currentInputEditorInfo;
        QsActionManager.enforceCallingPermission(this.mIms, "getEditorInfo");
        long origId = Binder.clearCallingIdentity();
        try {
            synchronized (this) {
                currentInputEditorInfo = this.mAppEditorInfo != null ? this.mAppEditorInfo : this.mIms.getCurrentInputEditorInfo();
            }
            return currentInputEditorInfo;
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public void showMySoftInput() {
        QsActionManager.enforceCallingPermission(this.mIms, "showMySoftInput");
        long origId = Binder.clearCallingIdentity();
        try {
            Slog.i("QsActionManager", "showMySoftInput");
            this.mIms.requestShowSelf(0);
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public void hideMySoftInput() {
        QsActionManager.enforceCallingPermission(this.mIms, "hideMySoftInput");
        long origId = Binder.clearCallingIdentity();
        try {
            Slog.i("QsActionManager", "hideMySoftInput");
            this.mIms.requestHideSelf(0);
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public void startActivity(Intent intent, Bundle options) {
        this.mIms.enforceCallingPermission(StepOSInputMethodQsPermissions.BIND_INPUT_METHOD_ITEM, "startActivity");
        long origId = Binder.clearCallingIdentity();
        if (intent != null) {
            try {
                Slog.i("QsActionManager", "startActivity intent=" + intent);
                this.mIms.startActivity(intent, options);
            } finally {
                Binder.restoreCallingIdentity(origId);
            }
        }
    }

    @Override // stepos.inputmethod.IQsActionExecutor
    public void showInputMethodPicker() {
        this.mIms.enforceCallingPermission(StepOSInputMethodQsPermissions.BIND_INPUT_METHOD_ITEM, "showInputMethodPicker");
        long origId = Binder.clearCallingIdentity();
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) this.mIms.getSystemService(InputMethodManager.class);
            if (inputMethodManager != null) {
                Slog.i("QsActionManager", "showInputMethodPicker");
                inputMethodManager.showInputMethodPicker();
            }
        } finally {
            Binder.restoreCallingIdentity(origId);
        }
    }
}
