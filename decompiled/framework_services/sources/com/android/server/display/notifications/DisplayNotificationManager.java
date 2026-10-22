package com.android.server.display.notifications;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.UserHandle;
import android.util.Slog;
import com.android.server.display.ExternalDisplayStatsService;
import com.android.server.display.feature.DisplayManagerFlags;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayNotificationManager implements ConnectedDisplayUsbErrorsDetector.Listener {
    private static final int DISPLAY_NOTIFICATION_ID = 1;
    private static final String DISPLAY_NOTIFICATION_TAG = "DisplayNotificationManager";
    private static final String NOTIFICATION_GROUP_NAME = "DisplayNotificationManager";
    private static final long NOTIFICATION_TIMEOUT_MILLISEC = 30000;
    private static final String TAG = "DisplayNotificationManager";
    private final boolean mConnectedDisplayErrorHandlingEnabled;
    private ConnectedDisplayUsbErrorsDetector mConnectedDisplayUsbErrorsDetector;
    private final Context mContext;
    private final ExternalDisplayStatsService mExternalDisplayStatsService;
    private final Injector mInjector;
    private NotificationManager mNotificationManager;

    public interface Injector {
        ExternalDisplayStatsService getExternalDisplayStatsService();

        NotificationManager getNotificationManager();

        ConnectedDisplayUsbErrorsDetector getUsbErrorsDetector();
    }

    public DisplayNotificationManager(final DisplayManagerFlags flags, final Context context, final ExternalDisplayStatsService statsService) {
        this(flags, context, new AnonymousClass1(context, flags, statsService));
    }

    DisplayNotificationManager(DisplayManagerFlags flags, Context context, Injector injector) {
        this.mConnectedDisplayErrorHandlingEnabled = flags.isConnectedDisplayErrorHandlingEnabled();
        this.mContext = context;
        this.mInjector = injector;
        this.mExternalDisplayStatsService = injector.getExternalDisplayStatsService();
    }

    public void onBootCompleted() {
        this.mNotificationManager = this.mInjector.getNotificationManager();
        if (this.mNotificationManager != null) goto L6;
        Slog.e("DisplayNotificationManager", "onBootCompleted: NotificationManager is null");
        return;
    L6:
        this.mConnectedDisplayUsbErrorsDetector = this.mInjector.getUsbErrorsDetector();
        if (this.mConnectedDisplayUsbErrorsDetector == null) goto L10;
        this.mConnectedDisplayUsbErrorsDetector.registerListener(this);
        return;
    }

    @Override // com.android.server.display.notifications.ConnectedDisplayUsbErrorsDetector.Listener
    public void onDisplayPortLinkTrainingFailure() {
        if (this.mConnectedDisplayErrorHandlingEnabled == true) goto L6;
        Slog.d("DisplayNotificationManager", "onDisplayPortLinkTrainingFailure: mConnectedDisplayErrorHandlingEnabled is false");
        return;
    L6:
        this.mExternalDisplayStatsService.onDisplayPortLinkTrainingFailure();
        sendErrorNotification(createErrorNotification(R.string.default_audio_route_name, R.string.default_audio_route_id, 17305529));
    }

    @Override // com.android.server.display.notifications.ConnectedDisplayUsbErrorsDetector.Listener
    public void onCableNotCapableDisplayPort() {
        if (this.mConnectedDisplayErrorHandlingEnabled == true) goto L6;
        Slog.d("DisplayNotificationManager", "onCableNotCapableDisplayPort: mConnectedDisplayErrorHandlingEnabled is false");
        return;
    L6:
        this.mExternalDisplayStatsService.onCableNotCapableDisplayPort();
        sendErrorNotification(createErrorNotification(R.string.default_audio_route_name, R.string.default_audio_route_id, 17305529));
    }

    public void onHotplugConnectionError() {
        if (this.mConnectedDisplayErrorHandlingEnabled == true) goto L6;
        Slog.d("DisplayNotificationManager", "onHotplugConnectionError: mConnectedDisplayErrorHandlingEnabled is false");
        return;
    L6:
        this.mExternalDisplayStatsService.onHotplugConnectionError();
        sendErrorNotification(createErrorNotification(R.string.default_audio_route_name, R.string.default_audio_route_id, 17305529));
    }

    public void onHighTemperatureExternalDisplayNotAllowed() {
        if (this.mConnectedDisplayErrorHandlingEnabled == true) goto L6;
        Slog.d("DisplayNotificationManager", "onHighTemperatureExternalDisplayNotAllowed: mConnectedDisplayErrorHandlingEnabled is false");
        return;
    L6:
        sendErrorNotification(createErrorNotification(R.string.default_audio_route_name, R.string.default_audio_route_category_name, R.drawable.pointer_wait_vector_24));
    }

    public void cancelNotifications() {
        if (this.mNotificationManager != null) goto L6;
        Slog.e("DisplayNotificationManager", "Can't cancelNotifications: NotificationManager is null");
        return;
    L6:
        this.mNotificationManager.cancelAsUser("DisplayNotificationManager", 1, UserHandle.CURRENT);
    }

    private void sendErrorNotification(Notification notification) {
        if (this.mNotificationManager != null) goto L6;
        Slog.e("DisplayNotificationManager", "Can't sendErrorNotification: NotificationManager is null");
        return;
    L6:
        this.mNotificationManager.notifyAsUser("DisplayNotificationManager", 1, notification, UserHandle.CURRENT);
    }

    private Notification createErrorNotification(int titleId, int messageId, int icon) {
        Resources resources = this.mContext.getResources();
        CharSequence title = resources.getText(titleId);
        CharSequence message = resources.getText(messageId);
        int color = 0;
        TypedArray attrs = this.mContext.obtainStyledAttributes(new int[]{R.attr.colorError});     // Catch: Resources.NotFoundException -> L8
        color = attrs.getColor(0, 0);     // Catch: Throwable -> L10
        attrs.close();     // Catch: Resources.NotFoundException -> L8
    L20:
        return new Notification.Builder(this.mContext, "ALERTS").setGroup("DisplayNotificationManager").setSmallIcon(icon).setWhen(0).setTimeoutAfter(30000).setOngoing(false).setTicker(title).setColor(color).setContentTitle(title).setContentText(message).setVisibility(1).setCategory("err").build();
    L10:
        th = move-exception;
        if (attrs != null) goto L21;
    L17:
        throw th;     // Catch: Resources.NotFoundException -> L8
    L21:
        attrs.close();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Resources.NotFoundException -> L8
    L8:
        e = move-exception;
        Slog.e("DisplayNotificationManager", "colorError attribute is not found: " + e.getMessage());
        goto L20
    }
}
