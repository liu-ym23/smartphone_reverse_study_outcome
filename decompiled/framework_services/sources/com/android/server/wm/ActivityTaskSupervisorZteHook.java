package com.android.server.wm;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ActivityTaskSupervisorZteHook {
    private static final String ACTION_UCAR = "com.ucar.intent.action.UCAR";
    private static final String CAR_DISPLAY_NAME = "vehicle_cast_virtual_display";
    private static final String CAR_DISPLAY_NAME2 = "com_zte_car_minimap";
    private static final String CAR_LAUNCHER_NAME = "com.zte.car.launcher";
    private static final String CAR_LAUNCHER_TIPS_CAR = "com.zte.car.launcher.map.CarMapTipsActivity";
    private static final String CAR_LAUNCHER_TIPS_PHONE = "com.zte.car.launcher.map.PhoneMapTipsActivity";
    private static ArrayList<String> CAR_MAP_APPS = null;
    private static final String TAG = "ActivityTaskSupervisorZteHook";
    private static final boolean ZTE_FOLDABLE_IN_SMALL_PHONE = false;
    private static final boolean ZTE_SMALLFOLD_SECONDARYSCREEN_SQUARE = false;
    private Context mContext;
    private Handler mHandler;
    private ActivityTaskSupervisor mTaskSupervisor;

    /* JADX INFO: renamed from: $r8$lambda$XsSUh-HsDESDddUolGsdQQMRb6Q, reason: not valid java name */
    public static /* synthetic */ void m9701$r8$lambda$XsSUhHsDESDddUolGsdQQMRb6Q(ActivityTaskSupervisorZteHook r0, Intent r1, Bundle r2) {
        r0.lambda$checkShouldAbortStartForCarMap$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$yNBAiUIogSkFEdgHowVRUXy0_3k(String r0, boolean[] r1, Task r2) {
        lambda$checkShouldAbortStartForCarMap$0(r0, r1, r2);
    }

    static {
        CAR_MAP_APPS = new ArrayList();
        CAR_MAP_APPS.add("com.autonavi.minimap");
        CAR_MAP_APPS.add("com.baidu.BaiduMap");
    }

    public ActivityTaskSupervisorZteHook(ActivityTaskSupervisor activityTaskSupervisor, Handler handler) {
        this.mTaskSupervisor = null;
        this.mTaskSupervisor = activityTaskSupervisor;
        this.mContext = this.mTaskSupervisor.mService.mContext;
        this.mHandler = handler;
        Slog.d(TAG, "init " + this.mTaskSupervisor);
    }

    public boolean checkShouldAbortStartForCarMap(final String r23, int r24, Intent r25, int r26) {
        boolean r8 = false;
        if (CAR_MAP_APPS.contains(r23) == true) goto L75;
        return false;
    L75:
        this.mContext.getPackageManager().getPackageInfo(CAR_LAUNCHER_NAME, 0);     // Catch: PackageManager.NameNotFoundException -> L72
        if (r24 != 0) goto L13;
        if (r25 == null) goto L13;
        if (ACTION_UCAR.equals(r25.getAction()) == false) goto L13;
        Slog.d(TAG, "block ACTION_UCAR start on default display");
        return true;
    L13:
        String r10 = "";
        r10 = this.mContext.getPackageManager().getPackagesForUid(r26)[0];     // Catch: Exception -> L16
    L18:
        if (r25 == null) goto L24;
        if (r25.getBooleanExtra("extra_intercept", true) == true) goto L24;
        if ((r25.getFlags() & 1048576) != 0) goto L24;
    L25:
        return false;
    L24:
        if (r10.equals(r23) == true) goto L25;
        int[] r9 = this.mTaskSupervisor.mRootWindowContainer.mDisplayManager.getDisplayIdByName("vehicle_cast_virtual_display");
        int[] r11 = this.mTaskSupervisor.mRootWindowContainer.mDisplayManager.getDisplayIdByName("com_zte_car_minimap");
        int[] r12 = new int[(r9.length + 1) + r11.length];
        r12[0] = 0;
        boolean r14 = false;
        if (r9.length == 0) goto L35;
        int r15 = 0;
    L29:
        boolean r16 = r8;
        if (r15 >= r9.length) goto L37;
        if (r9[r15] != r24) goto L34;
        r14 = true;
    L34:
        r12[1 + r15] = r9[r15];
        r15 = r15 + 1;
        r8 = r16 ? 1 : 0;
    L37:
        if (r11.length == 0) goto L45;
        int r13 = 0;
    L40:
        if (r13 >= r11.length) goto L45;
        if (r11[r13] != r24) goto L44;
        r14 = true;
    L44:
        r12[(r9.length + 1) + r13] = r11[r13];
        r13 = r13 + 1;
    L45:
        final boolean[] r17 = new boolean[1];
        r17[r16 ? 1 : 0] = r16;
        int r18 = -1;
        int r6 = r12.length;
        int r0 = r16 ? 1 : 0;
    L46:
        if (r0 >= r6) goto L65;
        int r19 = r0;
        int r1 = r12[r19 == true ? 1 : 0];
        if (r1 != 0) goto L50;
        boolean r20 = true;
    L51:
        boolean r21 = r20;
        if (r17[r16 ? 1 : 0] == true) goto L63;
        if (r1 == (-1)) goto L63;
        if (r1 == r24) goto L63;
        if (r14 != r21) goto L63;
        this.mTaskSupervisor.mRootWindowContainer.getDisplayContent(r1).forAllRootTasks(new ActivityTaskSupervisorZteHook$$ExternalSyntheticLambda0(r23, r17));
        if (r17[r16 ? 1 : 0] == false) goto L63;
        r18 = r1;
    L63:
        r0 = (r19 == true ? 1 : 0) + 1;
        goto L46
    L50:
        r20 = r16 ? 1 : 0;
        goto L51
    L65:
        if (r17[r16 ? 1 : 0] == true) goto L67;
        return r16;
    L67:
        ActivityOptions r2 = ActivityOptions.makeBasic();
        r2.setLaunchDisplayId(r24);
        final Bundle r5 = r2.toBundle();
        ComponentName r7 = new ComponentName(CAR_LAUNCHER_NAME, CAR_LAUNCHER_TIPS_PHONE);
        if (r24 == 0) goto L70;
        r7 = new ComponentName(CAR_LAUNCHER_NAME, CAR_LAUNCHER_TIPS_CAR);
    L70:
        final Intent r3 = new Intent();
        r3.setComponent(r7);
        r3.putExtra("extra_intent", r25);
        r3.putExtra("extra_lastDisplayId", r18);
        this.mHandler.post(new ActivityTaskSupervisorZteHook$$ExternalSyntheticLambda1(this, r3, r5));
        return true;
    L35:
        r16 = false;
    L17:
        Slog.d(TAG, "Cannot find package info for uid " + r26);
    L74:
        return false;
    }

    private static /* synthetic */ void lambda$checkShouldAbortStartForCarMap$0(String packageName, boolean[] foundTask, Task task) {
        if (task != null) goto L4;
        return;
    L4:
        if (packageName.equals(task.getBasePackageName()) == false) goto L10;
        ActivityRecord topActivity = task.getTopNonFinishingActivity();
        if (topActivity == null) goto L11;
        foundTask[0] = true;
        return;
    L11:
        return;
    }

    private /* synthetic */ void lambda$checkShouldAbortStartForCarMap$1(Intent tipsIntent, Bundle bundle) {
        this.mContext.startActivityAsUser(tipsIntent, bundle, UserHandle.CURRENT);
    }
}
