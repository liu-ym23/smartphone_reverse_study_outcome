package m6;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import com.stepos.taskrobot.notification.TaskRobotNotifier;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.k;
import w0.C2085f;

/* loaded from: classes3.dex */
public final class b implements TaskRobotNotifier {
    public static final C2085f d = new C2085f(8);
    public static volatile b e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5304a;
    public final NotificationManager b;
    public final AtomicBoolean c;

    public b(Context context) {
        this.f5304a = context;
        Object systemService = context.getSystemService("notification");
        k.d(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        this.b = (NotificationManager) systemService;
        this.c = new AtomicBoolean(false);
    }

    public final void a() {
        AtomicBoolean atomicBoolean = this.c;
        if (atomicBoolean.get()) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(TaskRobotNotifier.CHANNEL_ID, TaskRobotNotifier.CHANNEL_NAME, 4);
        notificationChannel.setDescription("TaskRobot 任务执行实时通知");
        notificationChannel.setShowBadge(false);
        notificationChannel.enableVibration(false);
        this.b.createNotificationChannel(notificationChannel);
        atomicBoolean.set(true);
    }

    @Override // com.stepos.taskrobot.notification.TaskRobotNotifier
    public final void dismiss(String taskId) {
        k.f(taskId, "taskId");
        this.b.cancel(taskId.hashCode());
    }

    @Override // com.stepos.taskrobot.notification.TaskRobotNotifier
    public final void showRunning(String taskId, String title, String subtitle, int i, PendingIntent pendingIntent, int i6) {
        k.f(taskId, "taskId");
        k.f(title, "title");
        k.f(subtitle, "subtitle");
        a();
        Context context = this.f5304a;
        k.f(context, "context");
        Notification.Builder onlyAlertOnce = new Notification.Builder(context, TaskRobotNotifier.CHANNEL_ID).setContentTitle(title).setContentText(subtitle).setSmallIcon(i).setOngoing(true).setOnlyAlertOnce(true);
        k.e(onlyAlertOnce, "setOnlyAlertOnce(...)");
        if (pendingIntent != null) {
            onlyAlertOnce.setContentIntent(pendingIntent);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("notification.live.operation", 1);
        bundle.putInt("notification.live.type", 1);
        bundle.putBoolean("notification.live.pinned", true);
        bundle.putBoolean("notification.live.feature.progressHide", true);
        bundle.putString("notification.live.titleOverlay", title);
        bundle.putString("notification.live.contentOverlay", subtitle);
        bundle.putString("notification.live.event", "BOT");
        bundle.putParcelable("notification.live.iconOverlay", Icon.createWithResource(context, i));
        Bundle bundle2 = new Bundle();
        bundle2.putInt("notification.live.capsuleStatus", 1);
        bundle2.putInt("notification.live.capsuleType", 1);
        bundle2.putParcelable("notification.live.capsuleIcon", Icon.createWithResource(context, i6));
        bundle2.putInt("notification.live.capsuleContentColor", -1);
        bundle2.putString("notification.live.capsuleContent", "任务执行中");
        bundle2.putInt("notification.live.capsuleBgColor", 0);
        bundle.putBundle("notification.live.capsule", bundle2);
        onlyAlertOnce.addExtras(bundle);
        Notification notificationBuild = onlyAlertOnce.build();
        k.e(notificationBuild, "build(...)");
        this.b.notify(taskId.hashCode(), notificationBuild);
    }

    @Override // com.stepos.taskrobot.notification.TaskRobotNotifier
    public final void showTakeover(String taskId, String title, String subtitle, int i, int i6, String actionLabel, PendingIntent actionIntent, int i10) {
        k.f(taskId, "taskId");
        k.f(title, "title");
        k.f(subtitle, "subtitle");
        k.f(actionLabel, "actionLabel");
        k.f(actionIntent, "actionIntent");
        a();
        Context context = this.f5304a;
        k.f(context, "context");
        Notification.Builder contentIntent = new Notification.Builder(context, TaskRobotNotifier.CHANNEL_ID).setContentTitle(title).setContentText(subtitle).setSmallIcon(i).setOngoing(true).setOnlyAlertOnce(false).setContentIntent(actionIntent);
        k.e(contentIntent, "setContentIntent(...)");
        Icon iconCreateWithResource = Icon.createWithResource(context, R.color.transparent);
        k.e(iconCreateWithResource, "createWithResource(...)");
        contentIntent.addAction(new Notification.Action.Builder(iconCreateWithResource, actionLabel, actionIntent).build());
        Bundle bundle = new Bundle();
        bundle.putInt("notification.live.operation", 1);
        bundle.putInt("notification.live.type", 6);
        bundle.putBoolean("notification.live.pinned", true);
        bundle.putString("notification.live.titleOverlay", title);
        bundle.putString("notification.live.contentOverlay", subtitle);
        bundle.putInt("notification.live.titleColor", -419430401);
        bundle.putInt("notification.live.contentColor", -1711276033);
        bundle.putInt("notification.live.bgColorOverlay", -1306912230);
        bundle.putString("notification.live.event", "BOT");
        bundle.putParcelable("notification.live.iconOverlay", Icon.createWithResource(context, i));
        bundle.putParcelable("notification.live.card.image", Icon.createWithResource(context, i6));
        bundle.putString("notification.live.task.state.desc", "待处理");
        bundle.putInt("notification.live.task.state.desc.color", -1480402);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("notification.live.capsuleStatus", 1);
        bundle2.putInt("notification.live.capsuleType", 1);
        bundle2.putParcelable("notification.live.capsuleIcon", Icon.createWithResource(context, i10));
        bundle2.putInt("notification.live.capsuleContentColor", -1);
        bundle2.putString("notification.live.capsuleContent", "任务待接管");
        bundle2.putInt("notification.live.capsuleBgColor", 0);
        bundle.putBundle("notification.live.capsule", bundle2);
        contentIntent.addExtras(bundle);
        Notification notificationBuild = contentIntent.build();
        k.e(notificationBuild, "build(...)");
        this.b.notify(taskId.hashCode(), notificationBuild);
    }
}
