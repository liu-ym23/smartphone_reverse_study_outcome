package com.android.server.notification.toast;

import android.app.ITransientNotificationCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.Preconditions;
import com.android.server.notification.NotificationManagerService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.statusbar.StatusBarManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
public class TextToastRecord extends ToastRecord {
    private static final String TAG = "NotificationService";
    private final ITransientNotificationCallback mCallback;
    private final StatusBarManagerInternal mStatusBar;
    private final int mType;
    public final CharSequence text;

    public TextToastRecord(NotificationManagerService notificationManager, StatusBarManagerInternal statusBarManager, int uid, int pid, String packageName, boolean isSystemToast, IBinder token, CharSequence text, int duration, Binder windowToken, int displayId, ITransientNotificationCallback callback) {
        this(notificationManager, statusBarManager, uid, pid, packageName, isSystemToast, token, text, duration, windowToken, displayId, callback, 2005);
    }

    public TextToastRecord(NotificationManagerService notificationManager, StatusBarManagerInternal statusBarManager, int uid, int pid, String packageName, boolean isSystemToast, IBinder token, CharSequence text, int duration, Binder windowToken, int displayId, ITransientNotificationCallback callback, int type) {
        super(notificationManager, uid, pid, packageName, isSystemToast, token, duration, windowToken, displayId);
        this.mStatusBar = statusBarManager;
        this.mCallback = callback;
        this.text = (CharSequence) Preconditions.checkNotNull(text);
        this.mType = type;
    }

    @Override // com.android.server.notification.toast.ToastRecord
    public boolean show() {
        if (NotificationManagerService.DBG == false) goto L6;
        Slog.d("NotificationService", "Show pkg=" + this.pkg + " text=" + this.text);
    L6:
        if (this.mStatusBar != null) goto L9;
        Slog.w("NotificationService", "StatusBar not available to show text toast for package " + this.pkg);
        return false;
    L9:
        this.mStatusBar.showToast(this.uid, this.pkg, this.token, this.text, this.windowToken, getDuration(), this.mCallback, this.displayId, this.mType);
        return true;
    }

    @Override // com.android.server.notification.toast.ToastRecord
    public void hide() {
        Preconditions.checkNotNull(this.mStatusBar, "Cannot hide toast that wasn't shown");
        this.mStatusBar.hideToast(this.pkg, this.token);
    }

    @Override // com.android.server.notification.toast.ToastRecord
    public boolean isAppRendered() {
        return false;
    }

    public String toString() {
        return "TextToastRecord{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.pid + ":" + this.pkg + SliceClientPermissions.SliceAuthority.DELIMITER + UserHandle.formatUid(this.uid) + " isSystemToast=" + this.isSystemToast + " token=" + this.token + " text=" + this.text + " duration=" + getDuration() + "}";
    }
}
