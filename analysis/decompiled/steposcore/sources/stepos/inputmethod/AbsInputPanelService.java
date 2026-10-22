package stepos.inputmethod;

import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.SparseArray;
import java.util.function.Consumer;
import stepos.inputmethod.AbsInputPanelController;

/* loaded from: classes.dex */
public abstract class AbsInputPanelService<T extends AbsInputPanelController> extends QsItemActionService implements DisplayManager.DisplayListener {
    private DisplayManager mDisplayManager;
    private final SparseArray<T> mInputPanelControllers = new SparseArray<>();

    protected abstract T createInputPanelManager(int i);

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.mDisplayManager != null) {
            this.mDisplayManager.unregisterDisplayListener(this);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDisplayManager = (DisplayManager) getSystemService("display");
        if (this.mDisplayManager != null) {
            this.mDisplayManager.registerDisplayListener(this, getMainThreadHandler());
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int displayId) {
        this.mInputPanelControllers.delete(displayId);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int displayId) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int displayId) {
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onItemDataChange(QsActionItem actionItem) {
        super.onItemDataChange(actionItem);
        for (int i = 0; i < this.mInputPanelControllers.size(); i++) {
            this.mInputPanelControllers.valueAt(i).onItemDataChange(actionItem);
        }
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onItemActionEnable(int displayId, final boolean enable) {
        super.onItemActionEnable(displayId, enable);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onItemActionEnable(enable);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onInputMethodShow(int displayId, final int userId, final Bundle data) {
        super.onInputMethodShow(displayId, userId, data);
        callControllerFun(displayId, true, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onInputMethodShow(userId, data);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onInputMethodHideByApp(int displayId, final int userId, final Bundle data) {
        super.onInputMethodHideByApp(displayId, userId, data);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onInputMethodHide(userId, data, true);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onInputMethodHideByIme(int displayId, final int userId, final Bundle data) {
        super.onInputMethodHideByIme(displayId, userId, data);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda7
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onInputMethodHide(userId, data, false);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [stepos.inputmethod.AbsInputPanelController] */
    private T getOrCreate(int displayId, boolean create) {
        T inputPanelController;
        synchronized (this.mInputPanelControllers) {
            inputPanelController = this.mInputPanelControllers.get(displayId);
            if (inputPanelController == null && create) {
                inputPanelController = createInputPanelManager(displayId);
                this.mInputPanelControllers.put(displayId, inputPanelController);
            }
        }
        return inputPanelController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void callControllerFun(int displayId, boolean create, Consumer<T> consumer) {
        AbsInputPanelController orCreate = getOrCreate(displayId, create);
        if (orCreate != null) {
            consumer.accept(orCreate);
        }
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onStartListening(int displayId, final int userId, final Bundle data) {
        super.onStartListening(displayId, userId, data);
        callControllerFun(displayId, true, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onStartListening(userId, data);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onClick(int displayId, final int userId, final Bundle data) {
        super.onClick(displayId, userId, data);
        callControllerFun(displayId, true, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda1
            @Override // java.util.function.Consumer
            public final void accept(Object obj) throws RemoteException {
                ((AbsInputPanelController) obj).onIconClick(userId, data);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onStopListening(int displayId, final int userId, final Bundle data) {
        super.onStopListening(displayId, userId, data);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onStopListening(userId, data);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onKeyguardShow(int displayId, final int userId, final Bundle data) {
        super.onKeyguardShow(displayId, userId, data);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onKeyguardShow(userId, data);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onKeyguardHide(int displayId, final int userId, final Bundle data) {
        super.onKeyguardHide(displayId, userId, data);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda6
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onKeyguardHide(userId, data);
            }
        });
    }

    @Override // stepos.inputmethod.QsItemActionService, stepos.inputmethod.QsActionManager.QsActionCallback
    public void onSystemUIVisibilityChange(int displayId, final boolean removeWindow) {
        super.onSystemUIVisibilityChange(displayId, removeWindow);
        callControllerFun(displayId, false, new Consumer() { // from class: stepos.inputmethod.AbsInputPanelService$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((AbsInputPanelController) obj).onSystemUIVisibilityChange(removeWindow);
            }
        });
    }
}
