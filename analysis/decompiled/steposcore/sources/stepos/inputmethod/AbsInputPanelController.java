package stepos.inputmethod;

import android.content.Context;
import android.content.IntentExt;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.QsActionExecutorBridge;
import android.widget.EditText;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public abstract class AbsInputPanelController implements ViewTreeObserver.OnWindowAttachListener {
    private static final boolean DEBUG = true;
    private static final String TAG = "AbsInputPanelController";
    protected boolean isAddPanelView;
    protected final QsActionManager mActionManager;
    protected final Context mContext;
    private InputDeathRecipient mDeathRecipient;
    protected final int mDisplayId;
    private EditText mEditText;
    private boolean mEnable;
    private QsActionExecutorBridge mExecutorBridge;
    protected final Handler mHandler;
    private IBinder mInputWindow;
    private QsActionItem mQsActionItem;
    protected View mRootPanelView;
    protected View mRootSubView;
    protected final QsItemActionService mService;
    protected WindowManager.LayoutParams mSubParams;
    protected final Context mUiContext;
    protected final WindowManager mWindowManager;
    protected boolean isAddSubView = false;
    protected final WindowManager.LayoutParams mPanelParams = createPanelLayoutParams();

    protected abstract View createRootView(Context context);

    protected abstract View createSubView(Context context);

    protected abstract void initLayoutParams(WindowManager.LayoutParams layoutParams);

    protected abstract void onAddPanelWindow(boolean z);

    protected abstract void onInEditState();

    protected abstract void onInNormalState();

    protected abstract void onRemovePanelWindow();

    protected abstract boolean userSubWindow();

    /* JADX INFO: Access modifiers changed from: private */
    static final class InputDeathRecipient implements IBinder.DeathRecipient {
        private final AbsInputPanelController mController;

        InputDeathRecipient(AbsInputPanelController controller) {
            this.mController = controller;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            if (this.mController != null) {
                this.mController.mHandler.post(new Runnable() { // from class: stepos.inputmethod.AbsInputPanelController$InputDeathRecipient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$binderDied$0();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$binderDied$0() {
            this.mController.removeAllWindow();
            if (this.mController.mInputWindow != null) {
                try {
                    this.mController.mInputWindow.unlinkToDeath(this.mController.mDeathRecipient, 0);
                } catch (NoSuchElementException e) {
                }
            }
            this.mController.mInputWindow = null;
            this.mController.mDeathRecipient = null;
        }
    }

    public AbsInputPanelController(QsItemActionService service, int displayId) {
        this.mDisplayId = displayId;
        this.mService = service;
        this.mQsActionItem = this.mService.getActionItemData();
        this.mEnable = this.mService.isEnable(displayId);
        this.mContext = this.mService.getApplicationContext();
        this.mUiContext = createUiContext(displayId, this.mContext);
        this.mHandler = new Handler(this.mService.getMainLooper());
        this.mActionManager = QsActionManager.getInstance(this.mContext);
        this.mWindowManager = this.mUiContext == null ? null : (WindowManager) this.mUiContext.getSystemService("window");
    }

    private Context createUiContext(int displayId, Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            Slog.e(TAG, "createUiContext fail because displayManager is null");
            return null;
        }
        Display display = displayManager.getDisplay(displayId);
        if (display == null) {
            Slog.e(TAG, "createUiContext fail because display is null,displayId =" + displayId);
            return null;
        }
        return this.mContext.createWindowContext(display, 2061, null);
    }

    private WindowManager.LayoutParams createPanelLayoutParams() {
        WindowManager.LayoutParams layoutParams = createLayoutParams();
        layoutParams.type = 2061;
        return layoutParams;
    }

    protected WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.width = -1;
        layoutParams.gravity = 83;
        layoutParams.flags = 8;
        layoutParams.setFitInsetsTypes(0);
        return layoutParams;
    }

    protected int getCurrentState() {
        return 0;
    }

    public void onIconClick(int userId, Bundle data) throws RemoteException {
        if (userSubWindow()) {
            addSubView();
        } else {
            addPanelWindow(0);
        }
    }

    public void onItemDataChange(QsActionItem actionItem) {
        boolean showNow = this.mEnable && actionItem.getPosition() != 0;
        boolean lastShow = (!this.mEnable || this.mQsActionItem == null || this.mQsActionItem.getPosition() == 0) ? false : true;
        if (lastShow != showNow) {
            Slog.i(TAG, "onShowStateChange show=" + showNow);
            if (showNow) {
                updateActionState(getCurrentState());
            } else {
                removeAllWindow();
            }
        }
        if (this.mQsActionItem != null && actionItem.getToken() != this.mQsActionItem.getToken()) {
            this.mExecutorBridge = null;
        }
        this.mQsActionItem = actionItem;
    }

    public void onItemActionEnable(boolean enable) {
        if (this.mEnable != enable) {
            this.mEnable = enable;
            Slog.i(TAG, "onItemActionEnable mEnable=" + this.mEnable);
            if (!this.mEnable) {
                removeAllWindow();
            }
        }
    }

    public void onSystemUIVisibilityChange(boolean removeWindow) {
        Slog.i(TAG, "onSystemUIVisibilityChange removeWindow=" + removeWindow);
        if (removeWindow) {
            removeAllWindow();
        }
    }

    public void onStartListening(int userId, Bundle data) {
    }

    public void onStopListening(int userId, Bundle data) {
        removeAllWindow();
    }

    public void onInputMethodShow(int userId, Bundle data) {
    }

    public void onInputMethodHide(int userId, Bundle data, boolean fromApp) {
        if (fromApp) {
            removeAllWindow();
        } else if (inEditState()) {
            this.mHandler.postDelayed(new Runnable() { // from class: stepos.inputmethod.AbsInputPanelController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onInputMethodHide$0();
                }
            }, 350L);
        } else {
            removePanelWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onInputMethodHide$0() {
        endEdit(false, true);
    }

    public void onKeyguardShow(int userId, Bundle data) {
        removeAllWindow();
    }

    public void onKeyguardHide(int userId, Bundle data) {
    }

    protected final boolean inEditState() {
        boolean z;
        synchronized (this) {
            z = (this.mPanelParams.steposFlags & IntentExt.STEPOS_FLAG_START_FROM_REMOTE) != 0;
        }
        return z;
    }

    protected void removeAllWindow() {
        endEdit(true, false);
        removeSubView();
        removePanelWindow();
    }

    protected void addPanelWindow(int editTextId) {
        synchronized (this) {
            if (this.mWindowManager == null) {
                return;
            }
            if (!this.isAddPanelView) {
                initLayoutParams(this.mPanelParams);
                this.mRootPanelView = createRootView(this.mUiContext);
                this.mPanelParams.steposFlags &= -524289;
                boolean z = false;
                try {
                    this.mWindowManager.addView(this.mRootPanelView, this.mPanelParams);
                    this.isAddPanelView = true;
                    updateActionState(false);
                    this.mEditText = editTextId == 0 ? null : (EditText) this.mRootPanelView.findViewById(editTextId);
                    if (this.mEditText != null) {
                        z = true;
                    }
                    onAddPanelWindow(z);
                    if (this.mEditText == null) {
                        onInNormalState();
                    } else {
                        this.mRootPanelView.getViewTreeObserver().addOnWindowAttachListener(this);
                    }
                } catch (Exception e) {
                    this.isAddPanelView = false;
                    Slog.i(TAG, "addPanelWindow fail", e);
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowAttached() {
        if (this.mEditText != null) {
            Slog.i(TAG, "onWindowAttached mEditText=" + this.mEditText);
            beginEditInner(this.mEditText);
            this.mEditText = null;
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowDetached() {
    }

    public void updateActionState(boolean enable) {
        updateActionState(enable ? 0 : 2);
    }

    public void updateActionState(int state) {
        QsActionItem item = this.mService.getActionItemData();
        if (state != item.getState()) {
            item.setState(state);
            this.mActionManager.updateActionItem(item);
        }
    }

    protected void removePanelWindow() {
        synchronized (this) {
            if (this.mWindowManager == null) {
                return;
            }
            if (this.isAddPanelView) {
                this.isAddPanelView = false;
                this.mRootPanelView.getViewTreeObserver().removeOnWindowAttachListener(this);
                try {
                    this.mWindowManager.removeView(this.mRootPanelView);
                } catch (Exception e) {
                    Slog.e(TAG, "removePanelWindow fail", e);
                }
                this.mRootPanelView = null;
                this.mEditText = null;
                updateActionState(this.mService.getCurrentState());
                onRemovePanelWindow();
            }
        }
    }

    protected QsActionExecutorBridge getOrCreateBridge() {
        QsActionExecutorBridge qsActionExecutorBridge;
        synchronized (this) {
            if (this.mExecutorBridge == null || !this.mExecutorBridge.isValid()) {
                this.mQsActionItem = this.mQsActionItem == null ? this.mService.getActionItemData() : this.mQsActionItem;
                this.mExecutorBridge = new QsActionExecutorBridge(this.mContext, this.mQsActionItem, this.mDisplayId);
                Slog.i(TAG, "create QsActionExecutorBridge: mQsActionItem: " + this.mQsActionItem);
            }
            qsActionExecutorBridge = this.mExecutorBridge;
        }
        return qsActionExecutorBridge;
    }

    private void beginEditInner(final EditText editText) {
        synchronized (this) {
            if (this.mWindowManager == null) {
                return;
            }
            if (this.isAddPanelView) {
                execAction(new Consumer() { // from class: stepos.inputmethod.AbsInputPanelController$$ExternalSyntheticLambda2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((QsActionExecutorBridge) obj).startInput(editText);
                    }
                });
                this.mPanelParams.steposFlags |= IntentExt.STEPOS_FLAG_START_FROM_REMOTE;
                this.mWindowManager.updateViewLayout(this.mRootPanelView, this.mPanelParams);
                onInEditState();
            }
        }
    }

    private void endEditInner(boolean showInput) {
        synchronized (this) {
            if (this.mWindowManager == null) {
                return;
            }
            if (this.isAddPanelView) {
                execAction(new Consumer() { // from class: stepos.inputmethod.AbsInputPanelController$$ExternalSyntheticLambda0
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        ((QsActionExecutorBridge) obj).endInput(null);
                    }
                });
                this.mPanelParams.steposFlags &= -524289;
                this.mWindowManager.updateViewLayout(this.mRootPanelView, this.mPanelParams);
                onInNormalState();
                if (showInput) {
                    execAction(new Consumer() { // from class: stepos.inputmethod.AbsInputPanelController$$ExternalSyntheticLambda1
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            ((QsActionExecutorBridge) obj).showMySoftInput();
                        }
                    });
                }
            }
        }
    }

    protected void execAction(Consumer<QsActionExecutorBridge> executor) {
        executor.accept(getOrCreateBridge());
    }

    protected void beginEdit(EditText editText) {
        synchronized (this) {
            if ((this.mPanelParams.steposFlags & IntentExt.STEPOS_FLAG_START_FROM_REMOTE) == 0) {
                beginEditInner(editText);
            }
        }
    }

    protected void endEdit(boolean removeWindow, boolean showInput) {
        synchronized (this) {
            if (removeWindow || (this.mPanelParams.steposFlags & IntentExt.STEPOS_FLAG_START_FROM_REMOTE) != 0) {
                endEditInner(showInput);
            }
        }
    }

    protected void removeSubView() {
        if (this.mWindowManager != null && this.isAddSubView) {
            this.isAddSubView = false;
            try {
                this.mWindowManager.removeView(this.mRootSubView);
            } catch (Exception e) {
                Slog.e(TAG, "removeSubView fail", e);
            }
            this.mRootSubView = null;
        }
    }

    protected void addSubView() throws RemoteException {
        if (this.mWindowManager != null && !this.isAddSubView) {
            this.mSubParams = createLayoutParams();
            this.mSubParams.type = 1005;
            this.mSubParams.token = getOrCreateBridge().getWindowToken();
            if (this.mSubParams.token != null) {
                InputDeathRecipient deathRecipient = new InputDeathRecipient(this);
                try {
                    this.mInputWindow = this.mSubParams.token;
                    this.mDeathRecipient = deathRecipient;
                    this.mInputWindow.linkToDeath(deathRecipient, 0);
                } catch (RemoteException e) {
                    Slog.i(TAG, "addSubView input method linkToDeath failed");
                }
                this.isAddSubView = true;
                this.mRootSubView = createSubView(this.mUiContext);
                this.mSubParams.steposFlags |= IntentExt.STEPOS_FLAG_START_FROM_REMOTE;
                this.mSubParams.height = this.mActionManager.getImeHeight(this.mDisplayId);
                try {
                    this.mWindowManager.addView(this.mRootSubView, this.mSubParams);
                } catch (Exception e2) {
                    Slog.e(TAG, "addSubView fail", e2);
                    this.isAddSubView = false;
                }
            }
        }
    }
}
