package k6;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import java.util.Set;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f9949a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final Set<String> f9950b = l.s0(new String[]{ModelDownloadNotifier.CHANNEL_STATE, ModelDownloadNotifier.CHANNEL_PROGRESS, ModelDownloadNotifier.CHANNEL_CHECK});

    public static void a(Context context) {
        Object objA;
        String channelId;
        g.f(context, "context");
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
        if (notificationManager == null) {
            return;
        }
        try {
            objA = notificationManager.getActiveNotifications();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        StatusBarNotification[] statusBarNotificationArr = (StatusBarNotification[]) objA;
        if (statusBarNotificationArr == null) {
            return;
        }
        int i10 = 0;
        for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && (channelId = notification.getChannelId()) != null && f9950b.contains(channelId)) {
                notificationManager.cancel(statusBarNotification.getTag(), statusBarNotification.getId());
                i10++;
            }
        }
        if (i10 > 0) {
            AIEngineLogger.i(LogModule.OTA, "DlNotifReconciler", "cleared " + i10 + " stale download notification(s)");
        }
    }
}
