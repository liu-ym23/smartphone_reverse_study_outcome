package com.stepos.alphame.dailyusage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"MIDNIGHT_ALARM_REQUEST_CODE", "", "PENDING_INTENT_FLAGS", "TAG", "", "handleBootCompleted", "", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "handleMidnightTask", "scheduleNextMidnightTask", "dailyusage_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MidnightTaskKt {
    private static final int MIDNIGHT_ALARM_REQUEST_CODE = 1001;
    private static final int PENDING_INTENT_FLAGS = 201326592;

    @NotNull
    private static final String TAG = "MidnightTask";

    public static final void handleBootCompleted(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "设备启动完成，正在设置第一个午夜任务...");
        scheduleNextMidnightTask(context);
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static final void handleMidnightTask(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "午夜闹钟已触发，正在执行跨天任务...");
        DefaultDailyUsageEventHandler.INSTANCE.getINSTANCE().handleCrossDayEvent(System.currentTimeMillis());
        scheduleNextMidnightTask(context);
        Log.d(TAG, "跨天任务执行完毕，已重新调度下一次任务。");
    }

    public static final void scheduleNextMidnightTask(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("alarm");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        AlarmManager alarmManager = (AlarmManager) systemService;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(6, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 1);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        try {
            alarmManager.setExactAndAllowWhileIdle(0, timeInMillis, PendingIntent.getBroadcast(context.getApplicationContext(), 1001, new Intent(context, (Class<?>) MidnightAlarmReceiver.class), PENDING_INTENT_FLAGS));
            Log.d(TAG, "午夜任务调度成功，触发时间戳: " + timeInMillis);
        } catch (SecurityException e4) {
            Log.e(TAG, "设置闹钟失败，权限异常: " + e4.getMessage());
        }
    }
}
