package com.stepos.pps.logpull;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public class LogPullNotification {
    public static final String ACTION_UPLOAD_NOW = "com.stepos.pps.logpull.UPLOAD_NOW";
    private static final String CHANNEL_PROGRESS = "pps_logpull_progress";
    private static final String CHANNEL_PROGRESS_NAME = "日志回传进度";
    private static final String CHANNEL_STATUS = "pps_logpull";
    private static final String CHANNEL_STATUS_NAME = "日志拉取";
    public static final String EXTRA_CONFIG_ID = "config_id";
    private static final int NOTIFY_ID_AUTH = 9000;
    private static final int NOTIFY_ID_CHOICE = 9005;
    private static final int NOTIFY_ID_IDLE = 9002;
    private static final int NOTIFY_ID_PACK = 9004;
    private static final int NOTIFY_ID_PROGRESS = 9001;
    private static final int NOTIFY_ID_STATUS = 9003;
    private final Context context;
    private final NotificationManager nm;

    private static int pendingFlags() {
        return 201326592;
    }

    public LogPullNotification(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.nm = (NotificationManager) applicationContext.getSystemService("notification");
        createChannels();
    }

    private static String tag(long j) {
        return String.valueOf(j);
    }

    private void createChannels() {
        if (this.nm == null) {
            return;
        }
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_STATUS, CHANNEL_STATUS_NAME, 3);
        notificationChannel.setDescription("远程日志拉取状态通知");
        this.nm.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel(CHANNEL_PROGRESS, CHANNEL_PROGRESS_NAME, 2);
        notificationChannel2.setDescription("日志回传进度（静音）");
        notificationChannel2.setSound(null, null);
        notificationChannel2.enableVibration(false);
        notificationChannel2.setVibrationPattern(null);
        notificationChannel2.enableLights(false);
        this.nm.createNotificationChannel(notificationChannel2);
    }

    public void showAuthPending(LogPullConfig logPullConfig, String str) {
        if (logPullConfig == null || this.nm == null) {
            return;
        }
        String strJoin = logPullConfig.logTypes != null ? String.join(",", logPullConfig.logTypes) : "";
        StringBuilder sb = new StringBuilder();
        sb.append(logPullConfig.logStartTime != null ? logPullConfig.logStartTime : "");
        sb.append(" ~ ");
        sb.append(logPullConfig.logEndTime != null ? logPullConfig.logEndTime : "");
        String string = sb.toString();
        this.nm.notify(tag(logPullConfig.configId), NOTIFY_ID_AUTH, new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_dialog_info).setContentTitle("PPS 服务 · 申请拉取日志").setContentText(strJoin + " · " + string).setStyle(new Notification.BigTextStyle().bigText("点击确认：立即上报 / 闲时上报，或不同意本次任务。\n划掉通知或点「删除」将取消任务并清理本地日志。\n" + strJoin + "\n" + string)).setContentIntent(PendingIntent.getActivity(this.context, requestCode(logPullConfig.configId, 1), buildAuthIntent(logPullConfig, str), pendingFlags())).setDeleteIntent(deletePending(logPullConfig.configId, 2)).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).addAction(0, "删除", deletePending(logPullConfig.configId, 3)).build());
    }

    public void showAuthRejected(long j) {
        if (this.nm == null) {
            return;
        }
        this.nm.notify(tag(j), NOTIFY_ID_AUTH, new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_menu_close_clear_cancel).setContentTitle("PPS 服务 · 已拒绝日志拉取").setContentText("本次任务已取消").setOngoing(false).setAutoCancel(true).build());
    }

    public void dismissAuth(long j) {
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.cancel(tag(j), NOTIFY_ID_AUTH);
        }
    }

    public void showIdleWaiting(long j, boolean z, boolean z2, boolean z3) {
        String str;
        if (z && z2 && z3) {
            str = "闲时条件已满足，即将采集上报";
        } else {
            str = "等待 Wi‑Fi、充电且熄屏后继续";
        }
        Notification.Builder builderAddAction = new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_menu_upload).setContentTitle("PPS 服务 · 等待闲时条件").setContentText(str).setStyle(new Notification.BigTextStyle().bigText(str.concat("\n可点「立即上报」马上执行，或「删除」取消并清理本地包"))).setOngoing(true).setAutoCancel(false).setOnlyAlertOnce(true).addAction(0, "立即上报", actionPending(ACTION_UPLOAD_NOW, j, 11)).addAction(0, "删除", deletePending(j, 13));
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.notify(tag(j), NOTIFY_ID_IDLE, builderAddAction.build());
        }
    }

    public void showWaitingNetwork(long j) {
        if (this.nm == null) {
            return;
        }
        this.nm.notify(tag(j), NOTIFY_ID_IDLE, new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_menu_upload).setContentTitle("PPS 服务 · 等待网络续传").setContentText("连接 Wi‑Fi 后将自动继续回传").setStyle(new Notification.BigTextStyle().bigText("日志回传未完成。连接 Wi‑Fi 有效网络后自动续传；\n也可点「立即上报」用当前网络续传，或「删除」取消并清理本地包")).setOngoing(true).setAutoCancel(false).setOnlyAlertOnce(true).addAction(0, "立即上报", actionPending(ACTION_UPLOAD_NOW, j, 11)).addAction(0, "删除", deletePending(j, 13)).build());
    }

    public void showCellularChoice(long j) {
        if (this.nm == null) {
            return;
        }
        Intent intent = new Intent(this.context, (Class<?>) LogPullUploadChoiceActivity.class);
        intent.addFlags(872415232);
        intent.putExtra("config_id", j);
        this.nm.notify(tag(j), NOTIFY_ID_CHOICE, new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_dialog_info).setContentTitle("PPS 服务 · 当前为移动数据网络").setContentText("点击选择：立即上传 / 闲时上传").setStyle(new Notification.BigTextStyle().bigText("日志回传未完成，当前非 Wi‑Fi 网络。点击选择立即上传或闲时上传。")).setContentIntent(PendingIntent.getActivity(this.context, requestCode(j, 41), intent, pendingFlags())).setOngoing(true).setAutoCancel(false).setOnlyAlertOnce(true).addAction(0, "删除", deletePending(j, 43)).build());
    }

    public void dismissChoice(long j) {
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.cancel(tag(j), NOTIFY_ID_CHOICE);
        }
    }

    public void showUploadStarted(long j, long j2) {
        String str;
        if (this.nm == null) {
            return;
        }
        dismissIdle(j);
        if (j2 > 0) {
            str = "开始回传，约 " + j2 + " MB";
        } else {
            str = "开始回传";
        }
        this.nm.notify(tag(j), NOTIFY_ID_STATUS, new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_menu_upload).setContentTitle("PPS 服务 · 开始回传").setContentText(str).setOngoing(false).setAutoCancel(true).build());
    }

    public void showUploadProgress(long j, long j2, long j3, int i) {
        Notification.Builder builderAddAction = new Notification.Builder(this.context, CHANNEL_PROGRESS).setSmallIcon(R.drawable.ic_menu_upload).setContentTitle("日志回传中").setContentText("已上传 " + j2 + " / " + j3 + " MB").setProgress(100, i, false).setOngoing(true).setAutoCancel(false).setOnlyAlertOnce(true).addAction(0, "删除", deletePending(j, 22));
        builderAddAction.setSilent(true);
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.notify(tag(j), NOTIFY_ID_PROGRESS, builderAddAction.build());
        }
    }

    public void dismissIdle(long j) {
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.cancel(tag(j), NOTIFY_ID_IDLE);
        }
    }

    public void showComplete(long j) {
        dismissActiveTaskNotifs(j);
        Notification.Builder autoCancel = new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_menu_upload).setContentTitle("PPS 服务 · 日志拉取").setContentText("日志回传完成").setAutoCancel(true);
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.notify(tag(j), NOTIFY_ID_STATUS, autoCancel.build());
        }
    }

    public void showFailed(long j, String str) {
        dismissActiveTaskNotifs(j);
        Notification.Builder autoCancel = new Notification.Builder(this.context, CHANNEL_STATUS).setSmallIcon(R.drawable.ic_menu_close_clear_cancel).setContentTitle("PPS 服务 · 日志拉取失败").setContentText(str).setAutoCancel(true);
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.notify(tag(j), NOTIFY_ID_STATUS, autoCancel.build());
        }
    }

    public void showPacking(long j, int i, int i2) {
        String str;
        if (this.nm == null) {
            return;
        }
        boolean z = i2 <= 0;
        int iMin = z ? 0 : (int) Math.min(100L, (i * 100) / i2);
        if (z) {
            str = "正在打包日志…";
        } else {
            str = "已打包 " + i + " / " + i2 + " 项";
        }
        Notification.Builder builderAddAction = new Notification.Builder(this.context, CHANNEL_PROGRESS).setSmallIcon(R.drawable.ic_menu_save).setContentTitle("日志打包中").setContentText(str).setProgress(100, iMin, z).setOngoing(true).setAutoCancel(false).setOnlyAlertOnce(true).addAction(0, "停止", packStopPending(j));
        builderAddAction.setSilent(true);
        this.nm.notify(tag(j), NOTIFY_ID_PACK, builderAddAction.build());
    }

    public void dismissPacking(long j) {
        NotificationManager notificationManager = this.nm;
        if (notificationManager != null) {
            notificationManager.cancel(tag(j), NOTIFY_ID_PACK);
        }
    }

    public void dismissActiveTaskNotifs(long j) {
        if (this.nm == null) {
            return;
        }
        String strTag = tag(j);
        this.nm.cancel(strTag, NOTIFY_ID_PROGRESS);
        this.nm.cancel(strTag, NOTIFY_ID_IDLE);
        this.nm.cancel(strTag, NOTIFY_ID_PACK);
        this.nm.cancel(strTag, NOTIFY_ID_CHOICE);
        this.nm.cancel(strTag, NOTIFY_ID_STATUS);
    }

    public void dismissAllFor(long j) {
        if (this.nm == null) {
            return;
        }
        dismissActiveTaskNotifs(j);
        this.nm.cancel(tag(j), NOTIFY_ID_AUTH);
    }

    private Intent buildAuthIntent(LogPullConfig logPullConfig, String str) {
        Intent intent = new Intent(this.context, (Class<?>) LogPullAuthActivity.class);
        intent.addFlags(872415232);
        intent.putExtra("config_id", logPullConfig.configId);
        if (str == null) {
            str = logPullConfig.oaid;
        }
        intent.putExtra(LogPullAuthActivity.EXTRA_OAID, str);
        intent.putExtra(LogPullAuthActivity.EXTRA_LOG_TYPES, logPullConfig.logTypes != null ? String.join(",", logPullConfig.logTypes) : "");
        intent.putExtra("start_time", logPullConfig.logStartTime);
        intent.putExtra("end_time", logPullConfig.logEndTime);
        intent.putExtra(LogPullAuthActivity.EXTRA_MAX_LIMIT, logPullConfig.maxLimit);
        intent.putExtra(LogPullAuthActivity.EXTRA_DEADLINE, logPullConfig.deadlineTime);
        return intent;
    }

    private PendingIntent deletePending(long j, int i) {
        Intent intent = new Intent(LogPullUserDeleteReceiver.ACTION_USER_DELETE);
        intent.setClass(this.context, LogPullUserDeleteReceiver.class);
        intent.setPackage(this.context.getPackageName());
        intent.putExtra("config_id", j);
        return PendingIntent.getBroadcast(this.context, requestCode(j, i), intent, pendingFlags());
    }

    private PendingIntent actionPending(String str, long j, int i) {
        Intent intent = new Intent(str);
        intent.setPackage(this.context.getPackageName());
        intent.putExtra("config_id", j);
        return PendingIntent.getBroadcast(this.context, requestCode(j, i), intent, pendingFlags());
    }

    private PendingIntent packStopPending(long j) {
        return actionPending(LogPullPackStopReceiver.ACTION_PACK_STOP, j, 31);
    }

    private static int requestCode(long j, int i) {
        return (int) (((j % 100000) * 100) + (i % 100));
    }
}
