package com.android.server.notification;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telecom.TelecomManager;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.NotificationMessagingUtil;
import com.android.server.pm.PackageManagerService;
import com.android.server.scene.SceneUtils;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class NotificationComparator implements Comparator<NotificationRecord> {
    private final Context mContext;
    private String mDefaultPhoneApp;
    private final NotificationMessagingUtil mMessagingUtil;
    private final BroadcastReceiver mPhoneAppBroadcastReceiver;
    public final Object mStateLock;

    /* JADX INFO: renamed from: com.android.server.notification.NotificationComparator$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ NotificationComparator this$0;

        public static /* synthetic */ void $r8$lambda$aPRRBU_rUCtqUIDIsorGv0uwvkA(AnonymousClass1 r0, Intent r1) {
            r0.lambda$onReceive$0(r1);
        }

        AnonymousClass1(NotificationComparator this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            BackgroundThread.getExecutor().execute(new NotificationComparator$1$$ExternalSyntheticLambda0(this, intent));
        }

        private /* synthetic */ void lambda$onReceive$0(Intent intent) {
            Object r0 = this.this$0.mStateLock;
            monitor-enter(r0);
            NotificationComparator.m6110$$Nest$fputmDefaultPhoneApp(this.this$0, intent.getStringExtra("android.telecom.extra.CHANGE_DEFAULT_DIALER_PACKAGE_NAME"));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDefaultPhoneApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6110$$Nest$fputmDefaultPhoneApp(NotificationComparator r0, String r1) {
        r0.mDefaultPhoneApp = r1;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(NotificationRecord r1, NotificationRecord r2) {
        return compare2(r1, r2);
    }

    public NotificationComparator(Context context) {
        this.mStateLock = new Object();
        this.mPhoneAppBroadcastReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mContext.registerReceiver(this.mPhoneAppBroadcastReceiver, new IntentFilter("android.telecom.action.DEFAULT_DIALER_CHANGED"));
        this.mMessagingUtil = new NotificationMessagingUtil(this.mContext, this.mStateLock);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(NotificationRecord left, NotificationRecord right) {
        int leftImportance = left.getImportance();
        int rightImportance = right.getImportance();
        boolean isRightHighImportance = false;
        if (leftImportance < 3) goto L5;
        boolean isLeftHighImportance = true;
    L6:
        if (rightImportance < 3) goto L8;
        isRightHighImportance = true;
    L8:
        if (isLeftHighImportance == isRightHighImportance) goto L12;
        return Boolean.compare(isLeftHighImportance, isRightHighImportance) * (-1);
    L12:
        if (left.getRankingScore() != right.getRankingScore()) goto L14;
        boolean leftImportantColorized = isImportantColorized(left);
        boolean rightImportantColorized = isImportantColorized(right);
        if (leftImportantColorized != rightImportantColorized) goto L18;
        boolean leftImportantOngoing = isImportantOngoing(left);
        boolean rightImportantOngoing = isImportantOngoing(right);
        if (leftImportantOngoing != rightImportantOngoing) goto L22;
        boolean leftMessaging = isImportantMessaging(left);
        boolean rightMessaging = isImportantMessaging(right);
        if (leftMessaging != rightMessaging) goto L26;
        boolean leftPeople = isImportantPeople(left);
        boolean rightPeople = isImportantPeople(right);
        int contactAffinityComparison = Float.compare(left.getContactAffinity(), right.getContactAffinity());
        if (leftPeople == false) goto L33;
        if (rightPeople == false) goto L33;
        if (contactAffinityComparison != 0) goto L32;
    L36:
        boolean leftSystemMax = isSystemMax(left);
        boolean rightSystemMax = isSystemMax(right);
        if (leftSystemMax != rightSystemMax) goto L39;
        if (leftImportance != rightImportance) goto L42;
        if (contactAffinityComparison != 0) goto L45;
        int leftPackagePriority = left.getPackagePriority();
        int rightPackagePriority = right.getPackagePriority();
        if (leftPackagePriority != rightPackagePriority) goto L49;
        int leftPriority = left.getSbn().getNotification().priority;
        int rightPriority = right.getSbn().getNotification().priority;
        if (leftPriority == rightPriority) goto L55;
        return Integer.compare(leftPriority, rightPriority) * (-1);
    L55:
        return Long.compare(left.getRankingTimeMs(), right.getRankingTimeMs()) * (-1);
    L49:
        return Integer.compare(leftPackagePriority, rightPackagePriority) * (-1);
    L45:
        return contactAffinityComparison * (-1);
    L42:
        return Integer.compare(leftImportance, rightImportance) * (-1);
    L39:
        return Boolean.compare(leftSystemMax, rightSystemMax) * (-1);
    L32:
        return contactAffinityComparison * (-1);
    L33:
        if (leftPeople == rightPeople) goto L36;
        return Boolean.compare(leftPeople, rightPeople) * (-1);
    L26:
        return Boolean.compare(leftMessaging, rightMessaging) * (-1);
    L22:
        return Boolean.compare(leftImportantOngoing, rightImportantOngoing) * (-1);
    L18:
        return Boolean.compare(leftImportantColorized, rightImportantColorized) * (-1);
    L14:
        return Float.compare(left.getRankingScore(), right.getRankingScore()) * (-1);
    L5:
        isLeftHighImportance = false;
        goto L6
    }

    private boolean isImportantColorized(NotificationRecord record) {
        if (record.getImportance() >= 2) goto L7;
        return false;
    L7:
        return record.getNotification().isColorized();
    }

    private boolean isImportantOngoing(NotificationRecord record) {
        if (record.getImportance() >= 2) goto L6;
        return false;
    L6:
        if (isCallStyle(record) == false) goto L9;
        return true;
    L9:
        if (record.getNotification().isFgsOrUij() == true) goto L12;
        return false;
    L12:
        if (isCallCategory(record) == true) goto L16;
        if (isMediaNotification(record) == true) goto L16;
        return false;
    L16:
        return true;
    }

    protected boolean isImportantPeople(NotificationRecord record) {
        if (record.getImportance() >= 2) goto L6;
        return false;
    L6:
        if (record.getContactAffinity() <= 0.0f) goto L9;
        return true;
    L9:
        return false;
    }

    protected boolean isImportantMessaging(NotificationRecord record) {
        return this.mMessagingUtil.isImportantMessaging(record.getSbn(), record.getImportance());
    }

    protected boolean isSystemMax(NotificationRecord record) {
        if (record.getImportance() >= 4) goto L5;
        return false;
    L5:
        String packageName = record.getSbn().getPackageName();
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L9;
        return true;
    L9:
        if (SceneUtils.PKG_SYS_UI.equals(packageName) == false) goto L11;
        return true;
    L11:
        return false;
    }

    private boolean isMediaNotification(NotificationRecord record) {
        return record.getNotification().isMediaNotification();
    }

    private boolean isCallCategory(NotificationRecord record) {
        if (record.isCategory("call") == true) goto L5;
    L7:
        return false;
    L5:
        if (isDefaultPhoneApp(record.getSbn().getPackageName()) == false) goto L7;
        return true;
    }

    private boolean isCallStyle(NotificationRecord record) {
        return record.getNotification().isStyle(Notification.CallStyle.class);
    }

    private boolean isDefaultPhoneApp(String pkg) {
        if (this.mDefaultPhoneApp != null) goto L10;
        TelecomManager telecomm = (TelecomManager) this.mContext.getSystemService("telecom");
        if (telecomm == null) goto L7;
        String r1 = telecomm.getDefaultDialerPackage();
    L8:
        this.mDefaultPhoneApp = r1;
        goto L10
    L7:
        r1 = null;
    L10:
        return Objects.equals(pkg, this.mDefaultPhoneApp);
    }
}
