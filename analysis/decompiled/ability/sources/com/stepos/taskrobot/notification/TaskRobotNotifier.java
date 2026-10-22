package com.stepos.taskrobot.notification;

import android.app.PendingIntent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import m6.C1679a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016JC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/notification/TaskRobotNotifier;", "", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "title", "subtitle", "", "iconRes", "Landroid/app/PendingIntent;", "contentIntent", "capsuleIconRes", "LC7/r;", "showRunning", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/app/PendingIntent;I)V", "thumbnailRes", "actionLabel", "actionIntent", "showTakeover", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Landroid/app/PendingIntent;I)V", "dismiss", "(Ljava/lang/String;)V", "Companion", "m6/a", "notification_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaskRobotNotifier {
    public static final String CHANNEL_ID = "com.stepos.taskrobot.task_notification";
    public static final String CHANNEL_NAME = "TaskRobot 任务通知";
    public static final C1679a Companion = C1679a.f5303a;
    public static final String DEFAULT_RUNNING_SUBTITLE = "任务运行中";

    static /* synthetic */ void showRunning$default(TaskRobotNotifier taskRobotNotifier, String str, String str2, String str3, int i, PendingIntent pendingIntent, int i6, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showRunning");
        }
        if ((i10 & 32) != 0) {
            i6 = i;
        }
        taskRobotNotifier.showRunning(str, str2, str3, i, pendingIntent, i6);
    }

    static /* synthetic */ void showTakeover$default(TaskRobotNotifier taskRobotNotifier, String str, String str2, String str3, int i, int i6, String str4, PendingIntent pendingIntent, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showTakeover");
        }
        if ((i11 & 128) != 0) {
            i10 = i;
        }
        taskRobotNotifier.showTakeover(str, str2, str3, i, i6, str4, pendingIntent, i10);
    }

    void dismiss(String taskId);

    void showRunning(String taskId, String title, String subtitle, int iconRes, PendingIntent contentIntent, int capsuleIconRes);

    void showTakeover(String taskId, String title, String subtitle, int iconRes, int thumbnailRes, String actionLabel, PendingIntent actionIntent, int capsuleIconRes);
}
