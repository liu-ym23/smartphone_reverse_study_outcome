package android.view.inputmethod;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.InputMethodHelper;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.KeyEvent;
import android.view.autofill.AutofillId;
import android.widget.EditText;
import com.android.internal.inputmethod.CancellationGroup;
import com.android.internal.inputmethod.IRemoteInputConnection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import stepos.inputmethod.IQsActionExecutor;
import stepos.inputmethod.QsActionItem;
import stepos.inputmethod.QsActionManager;

/* loaded from: classes.dex */
public class QsActionExecutorBridge {
    private static final boolean DEBUG = true;
    private static final String TAG = "QsActionExecutorBridge";
    private final CancellationGroup cancellationGroup = new CancellationGroup();
    private final QsActionItem mActionItem;
    private final Context mContext;
    private final int mDisplayId;
    private final InputMethodManager mInputMethodManager;
    private final QsActionManager mQsActionManager;
    private RemoteInputConnectionImpl mRemoteInputConnection;

    public QsActionExecutorBridge(Context context, QsActionItem actionItem, int displayId) {
        this.mContext = context.getApplicationContext();
        this.mActionItem = actionItem;
        this.mDisplayId = displayId;
        this.mQsActionManager = QsActionManager.getInstance(this.mContext);
        this.mInputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
    }

    public boolean isValid() {
        return this.mActionItem != null;
    }

    private IQsActionExecutor getQsActionExecutor() {
        if (this.mActionItem != null) {
            return this.mQsActionManager.getActionExecutor(this.mDisplayId, this.mActionItem.getToken());
        }
        Slog.e(TAG, "getQsActionExecutor mActionItem is null");
        return null;
    }

    private <T> T exec(Function<IQsActionExecutor, T> callback) {
        IQsActionExecutor actionExecutor = getQsActionExecutor();
        if (actionExecutor != null) {
            return callback.apply(actionExecutor);
        }
        Slog.e(TAG, "IQsActionExecutor is died");
        return null;
    }

    private void exec(Consumer<IQsActionExecutor> callback) {
        IQsActionExecutor actionExecutor = getQsActionExecutor();
        if (actionExecutor != null) {
            callback.accept(actionExecutor);
        } else {
            Slog.e(TAG, "IQsActionExecutor is died");
        }
    }

    private <T> T invoker(Function<InputConnection, T> callback) {
        InputConnection inputConnection = getAppInputConnection();
        if (inputConnection != null) {
            return callback.apply(inputConnection);
        }
        return null;
    }

    private boolean invokerBoolean(Predicate<InputConnection> callback) {
        InputConnection inputConnection = getAppInputConnection();
        if (inputConnection != null) {
            return callback.test(inputConnection);
        }
        return false;
    }

    public final InputConnection getAppInputConnection() {
        return (InputConnection) exec(new Function() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.lambda$getAppInputConnection$0((IQsActionExecutor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InputConnection lambda$getAppInputConnection$0(IQsActionExecutor executor) {
        try {
            IRemoteInputConnection remoteInputConnection = executor.getInputConnection();
            if (remoteInputConnection != null) {
                return InputMethodHelper.createRemoteInputConnection(null, remoteInputConnection, this.cancellationGroup);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Deprecated
    public final boolean commitText(final CharSequence charSequence, boolean verificationCode) {
        return invokerBoolean(new Predicate() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda11
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                CharSequence charSequence2 = charSequence;
                return ((InputConnection) obj).commitText(charSequence2, charSequence2.length());
            }
        });
    }

    @Deprecated
    public final CharSequence getTextBeforeCursor(final int n, final int flags) {
        return (CharSequence) invoker(new Function() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda10
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((InputConnection) obj).getTextBeforeCursor(n, flags);
            }
        });
    }

    @Deprecated
    public final CharSequence getTextAfterCursor(final int n, final int flags) {
        return (CharSequence) invoker(new Function() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda15
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((InputConnection) obj).getTextAfterCursor(n, flags);
            }
        });
    }

    @Deprecated
    public final CharSequence getSelectedText(final int flags) {
        return (CharSequence) invoker(new Function() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda13
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((InputConnection) obj).getSelectedText(flags);
            }
        });
    }

    @Deprecated
    public final boolean sendKeyEvent(final KeyEvent event) {
        return invokerBoolean(new Predicate() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda8
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InputConnection) obj).sendKeyEvent(event);
            }
        });
    }

    @Deprecated
    public boolean replaceText(final int start, final int end, final CharSequence text, final int newCursorPosition, final TextAttribute textAttribute) {
        return invokerBoolean(new Predicate() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda9
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InputConnection) obj).replaceText(start, end, text, newCursorPosition, textAttribute);
            }
        });
    }

    @Deprecated
    public boolean deleteSurroundingText(final int beforeLength, final int afterLength) {
        return invokerBoolean(new Predicate() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda12
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InputConnection) obj).deleteSurroundingText(beforeLength, afterLength);
            }
        });
    }

    @Deprecated
    public boolean deleteSurroundingTextInCodePoints(final int beforeLength, final int afterLength) {
        return invokerBoolean(new Predicate() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda1
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((InputConnection) obj).deleteSurroundingTextInCodePoints(beforeLength, afterLength);
            }
        });
    }

    public final void showInputMethodPicker() {
        exec(new Consumer() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                QsActionExecutorBridge.lambda$showInputMethodPicker$9((IQsActionExecutor) obj);
            }
        });
    }

    static /* synthetic */ void lambda$showInputMethodPicker$9(IQsActionExecutor executor) {
        try {
            Slog.i(TAG, "showInputMethodPicker");
            executor.showInputMethodPicker();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void startActivity(final Intent intent, final Bundle bundle) {
        exec(new Consumer() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda16
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                QsActionExecutorBridge.lambda$startActivity$10(intent, bundle, (IQsActionExecutor) obj);
            }
        });
    }

    static /* synthetic */ void lambda$startActivity$10(Intent intent, Bundle bundle, IQsActionExecutor executor) {
        try {
            Slog.i(TAG, "startActivity intent=" + intent);
            executor.startActivity(intent, bundle);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void showMySoftInput() {
        exec(new Consumer() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                QsActionExecutorBridge.lambda$showMySoftInput$11((IQsActionExecutor) obj);
            }
        });
    }

    static /* synthetic */ void lambda$showMySoftInput$11(IQsActionExecutor executor) {
        try {
            Slog.i(TAG, "showMySoftInput");
            executor.showMySoftInput();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void hideMySoftInput() {
        exec(new Consumer() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                QsActionExecutorBridge.lambda$hideMySoftInput$12((IQsActionExecutor) obj);
            }
        });
    }

    static /* synthetic */ void lambda$hideMySoftInput$12(IQsActionExecutor executor) {
        try {
            Slog.i(TAG, "hideMySoftInput");
            executor.hideMySoftInput();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void startInput(EditText editText) {
        final EditorInfo editorInfo = new EditorInfo();
        editorInfo.packageName = this.mContext.getOpPackageName();
        editorInfo.setAutofillId(editText.getAutofillId());
        editorInfo.fieldId = editText.getId();
        InputConnection ic = editText.onCreateInputConnection(editorInfo);
        if (ic == null) {
            Slog.e(TAG, "InputConnection is null");
            editorInfo.setAutofillId(AutofillId.NO_AUTOFILL_ID);
            editorInfo.fieldId = 0;
        } else {
            if (editText.getDisplay() == null) {
                Slog.e(TAG, "editText display id null ");
                return;
            }
            if (this.mDisplayId != editText.getDisplay().getDisplayId()) {
                Slog.e(TAG, "editText display id is " + editText.getDisplay().getDisplayId() + ",but bridge display id is" + this.mDisplayId);
                return;
            }
            if (this.mRemoteInputConnection != null) {
                this.mRemoteInputConnection.deactivate();
            }
            Handler icHandler = editText.getHandler();
            this.mRemoteInputConnection = new RemoteInputConnectionImpl(icHandler.getLooper(), ic, this.mInputMethodManager, editText);
            editText.getViewRootImpl().windowFocusChanged(true);
            editText.requestFocus();
            exec(new Consumer() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$startInput$13(editorInfo, (IQsActionExecutor) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startInput$13(EditorInfo editorInfo, IQsActionExecutor executor) {
        try {
            Slog.i(TAG, "bindInput mRemoteInputConnection=" + this.mRemoteInputConnection);
            executor.bindInput(this.mRemoteInputConnection, editorInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void endInput(final EditText editText) {
        if (this.mRemoteInputConnection != null) {
            this.mRemoteInputConnection.deactivate();
            this.mRemoteInputConnection = null;
            exec(new Consumer() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda14
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    QsActionExecutorBridge.lambda$endInput$14(editText, (IQsActionExecutor) obj);
                }
            });
        }
    }

    static /* synthetic */ void lambda$endInput$14(EditText editText, IQsActionExecutor executor) {
        try {
            Slog.i(TAG, "unbindInput editText=" + editText);
            executor.bindInput(null, null);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final IBinder getWindowToken() {
        return (IBinder) exec(new Function() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return QsActionExecutorBridge.lambda$getWindowToken$15((IQsActionExecutor) obj);
            }
        });
    }

    static /* synthetic */ IBinder lambda$getWindowToken$15(IQsActionExecutor executor) {
        try {
            return executor.getWindowToken();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final EditorInfo getEditorInfo() {
        return (EditorInfo) exec(new Function() { // from class: android.view.inputmethod.QsActionExecutorBridge$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return QsActionExecutorBridge.lambda$getEditorInfo$16((IQsActionExecutor) obj);
            }
        });
    }

    static /* synthetic */ EditorInfo lambda$getEditorInfo$16(IQsActionExecutor executor) {
        try {
            return executor.getEditorInfo();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
