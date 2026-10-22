package com.android.server.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.UserHandle;
import android.service.notification.Condition;
import android.service.notification.ZenModeConfig;
import android.text.format.DateUtils;
import android.util.Log;
import android.util.Slog;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class CountdownConditionProvider extends SystemConditionProviderService {
    private static final String ACTION = null;
    private static final boolean DEBUG = false;
    private static final String EXTRA_CONDITION_ID = "condition_id";
    private static final int REQUEST_CODE = 100;
    private static final String TAG = "ConditionProviders.CCP";
    private boolean mConnected;
    private final Context mContext;
    private boolean mIsAlarm;
    private final Receiver mReceiver;
    private long mTime;

    private final class Receiver extends BroadcastReceiver {
        final /* synthetic */ CountdownConditionProvider this$0;

        /* synthetic */ Receiver(CountdownConditionProvider r1, CountdownConditionProviderIA r2) {
            this(r1);
        }

        private Receiver(CountdownConditionProvider r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (CountdownConditionProvider.m6040$$Nest$sfgetACTION().equals(intent.getAction()) == false) goto L11;
            Uri conditionId = (Uri) intent.getParcelableExtra(CountdownConditionProvider.EXTRA_CONDITION_ID, Uri.class);
            boolean alarm = ZenModeConfig.isValidCountdownToAlarmConditionId(conditionId);
            long time = ZenModeConfig.tryParseCountdownConditionId(conditionId);
            if (CountdownConditionProvider.m6041$$Nest$sfgetDEBUG() == false) goto L8;
            Slog.d(CountdownConditionProvider.TAG, "Countdown condition fired: " + conditionId);
        L8:
            if (time <= 0) goto L12;
            this.this$0.notifyCondition(CountdownConditionProvider.m6042$$Nest$smnewCondition(time, alarm, 0));
            return;
        L12:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetACTION, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6040$$Nest$sfgetACTION() {
        return ACTION;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6041$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$smnewCondition, reason: not valid java name */
    static /* bridge */ /* synthetic */ Condition m6042$$Nest$smnewCondition(long r0, boolean r2, int r3) {
        return newCondition(r0, r2, r3);
    }

    static {
        DEBUG = Log.isLoggable("ConditionProviders", 3);
        ACTION = CountdownConditionProvider.class.getName();
    }

    public CountdownConditionProvider() {
        this.mContext = this;
        this.mReceiver = new Receiver(this, null);
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "new CountdownConditionProvider()");
        return;
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public boolean isValidConditionId(Uri id) {
        return ZenModeConfig.isValidCountdownConditionId(id);
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onBootComplete() {
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void onUserSwitched(UserHandle user) {
    }

    @Override // com.android.server.notification.SystemConditionProviderService
    public void dump(PrintWriter pw, NotificationManagerService.DumpFilter filter) {
        pw.println("    CountdownConditionProvider:");
        pw.print("      mConnected=");
        pw.println(this.mConnected);
        pw.print("      mTime=");
        pw.println(this.mTime);
    }

    @Override // android.service.notification.ConditionProviderService
    public void onConnected() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "onConnected");
    L5:
        this.mContext.registerReceiver(this.mReceiver, new IntentFilter(ACTION), 2);
        this.mConnected = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "onDestroy");
    L6:
        if (this.mConnected == false) goto L8;
        this.mContext.unregisterReceiver(this.mReceiver);
    L8:
        this.mConnected = false;
    }

    @Override // android.service.notification.ConditionProviderService
    public void onSubscribe(Uri conditionId) {
        if (DEBUG == false) goto L5;
        StringBuilder r1 = new StringBuilder();
        r1.append("onSubscribe ");
        Uri r3 = conditionId;
        r1.append(r3);
        Slog.d(TAG, r1.toString());
    L6:
        this.mTime = ZenModeConfig.tryParseCountdownConditionId(r3);
        this.mIsAlarm = ZenModeConfig.isValidCountdownToAlarmConditionId(r3);
        AlarmManager alarms = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        PendingIntent pendingIntent = getPendingIntent(conditionId);
        alarms.cancel(pendingIntent);
        if (this.mTime <= 0) goto L21;
        long now = System.currentTimeMillis();
        CharSequence span = DateUtils.getRelativeTimeSpanString(this.mTime, now, 60000);
        if (this.mTime > now) goto L11;
        notifyCondition(newCondition(this.mTime, this.mIsAlarm, 0));
    L13:
        if (DEBUG == true) goto L15;
        return;
    L15:
        if (this.mTime > now) goto L18;
        String r5 = "Not scheduling";
    L17:
        String r12 = r5;
        Slog.d(TAG, String.format("%s %s for %s, %s in the future (%s), now=%s", new Object[]{r12, ACTION, SystemConditionProviderService.ts(this.mTime), Long.valueOf(this.mTime - now), span, SystemConditionProviderService.ts(now)}));
        return;
    L18:
        r5 = "Scheduling";
        goto L17
    L11:
        alarms.setExact(0, this.mTime, pendingIntent);
        goto L13
    L21:
        return;
    L5:
        r3 = conditionId;
        goto L6
    }

    PendingIntent getPendingIntent(Uri conditionId) {
        Intent intent = new Intent(ACTION).setPackage(PackageManagerService.PLATFORM_PACKAGE_NAME).putExtra(EXTRA_CONDITION_ID, conditionId).setFlags(1073741824);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.mContext, 100, intent, AudioFormat.DTS_HD);
        return pendingIntent;
    }

    @Override // android.service.notification.ConditionProviderService
    public void onUnsubscribe(Uri conditionId) {
    }

    private static final Condition newCondition(long time, boolean alarm, int state) {
        return new Condition(ZenModeConfig.toCountdownConditionId(time, alarm), "", "", "", 0, state, 1);
    }

    public static String tryParseDescription(Uri conditionUri) {
        long time = ZenModeConfig.tryParseCountdownConditionId(conditionUri);
        if (time != 0) goto L6;
        return null;
    L6:
        long now = System.currentTimeMillis();
        CharSequence span = DateUtils.getRelativeTimeSpanString(time, now, 60000);
        return String.format("Scheduled for %s, %s in the future (%s), now=%s", new Object[]{SystemConditionProviderService.ts(time), Long.valueOf(time - now), span, SystemConditionProviderService.ts(now)});
    }
}
