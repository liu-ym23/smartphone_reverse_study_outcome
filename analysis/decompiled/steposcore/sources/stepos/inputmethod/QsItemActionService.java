package stepos.inputmethod;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Slog;
import android.util.SparseBooleanArray;
import stepos.inputmethod.QsActionManager;

/* loaded from: classes.dex */
public class QsItemActionService extends Service implements QsActionManager.QsActionCallback {
    private static final boolean DEBUG = true;
    private static final String TAG = "QsItemActionService";
    private IBinder iBinder;
    protected QsActionItem mActionItemData;
    protected SparseBooleanArray mDisplayEnables = new SparseBooleanArray();

    public QsActionItem getActionItemData() {
        return this.mActionItemData;
    }

    public boolean isEnable(int displayId) {
        if (this.mDisplayEnables.indexOfKey(displayId) == -1) {
            boolean enable = QsActionManager.getInstance(this).isEnable(displayId);
            this.mDisplayEnables.put(displayId, enable);
            return enable;
        }
        return this.mDisplayEnables.get(displayId);
    }

    public void onItemDataChange(QsActionItem actionItem) {
        Slog.i(TAG, "onItemDataChange old=" + this.mActionItemData + ",new=" + actionItem);
        this.mActionItemData = actionItem;
    }

    public void onItemActionEnable(int displayId, boolean enable) {
        Slog.i(TAG, "onItemActionEnable displayId=" + enable);
        this.mDisplayEnables.put(displayId, enable);
    }

    public int getCurrentState() {
        return 0;
    }

    public void onInputMethodShow(int displayId, int userId, Bundle data) {
        Slog.d(TAG, "onInputMethodShow displayId=" + displayId);
    }

    public void onInputMethodHideByApp(int displayId, int userId, Bundle data) {
        Slog.d(TAG, "onInputMethodHideByApp displayId=" + displayId);
    }

    public void onInputMethodHideByIme(int displayId, int userId, Bundle data) {
        Slog.d(TAG, "onInputMethodHideByIme displayId=" + displayId);
    }

    public void onStartListening(int displayId, int userId, Bundle data) {
        Slog.i(TAG, "onStartListening displayId=" + displayId + ",userId=" + userId);
    }

    public void onStopListening(int displayId, int userId, Bundle data) {
        Slog.i(TAG, "onStopListening displayId=" + displayId + ",userId=" + userId);
    }

    public void onClick(int displayId, int userId, Bundle data) {
        Slog.i(TAG, "onClick displayId=" + displayId + ",userId=" + userId);
    }

    @Override // stepos.inputmethod.QsActionManager.QsActionCallback
    public void onLongPress(int displayId, int userId, Bundle data) {
        Slog.i(TAG, "onLongPress displayId=" + displayId + ",userId=" + userId);
    }

    public void onKeyguardShow(int displayId, int userId, Bundle data) {
        Slog.d(TAG, "onKeyguardShow displayId=" + displayId + ",userId=" + userId);
    }

    public void onKeyguardHide(int displayId, int userId, Bundle data) {
        Slog.d(TAG, "onKeyguardHide displayId=" + displayId + ",userId=" + userId);
    }

    public void onSystemUIVisibilityChange(int displayId, boolean removeWindow) {
        Slog.d(TAG, "onSystemUIVisibilityChange displayId=" + displayId + ",removeWindow=" + removeWindow);
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        readQsActionItem(intent, "onStart");
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        readQsActionItem(intent, "onRebind");
    }

    private void readQsActionItem(Intent intent, String tag) {
        QsActionItem item = intent != null ? (QsActionItem) intent.getParcelableExtra(QsActionManager.DATA_KEY) : null;
        Slog.i(TAG, tag + " new=" + item + ",old=" + this.mActionItemData);
        this.mActionItemData = item != null ? item : this.mActionItemData;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder;
        synchronized (this) {
            readQsActionItem(intent, "onBind");
            if (this.iBinder == null) {
                this.iBinder = QsActionManager.createActionCallback(this, getMainLooper());
            }
            iBinder = this.iBinder;
        }
        return iBinder;
    }
}
