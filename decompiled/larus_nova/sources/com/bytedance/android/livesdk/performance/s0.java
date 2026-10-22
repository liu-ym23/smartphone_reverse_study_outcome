package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdk.performance.degrade.LiveDegradeConfigHelper;
import com.bytedance.android.livesdkapi.model.PlayerOptimizeConfig;

/* JADX INFO: loaded from: classes11.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f154760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f154761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PlayerOptimizeConfig f154762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f154763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f154764e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f154765f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f154766g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f154767h = false;

    static {
        boolean r100 = LiveDegradeConfigHelper.f154519b;
        boolean r101 = false;
        if (r100 == true) goto L5;
    L9:
        boolean r102 = false;
    L10:
        f154764e = r102;
        if (r100 == true) goto L13;
    L17:
        boolean r103 = false;
    L18:
        f154765f = r103;
        if (r100 == true) goto L21;
    L25:
        f154766g = r101;
        f154767h = LiveDegradeConfigHelper.a().enableRecoverByPerformance;
        return;
    L21:
        if (LiveDegradeConfigHelper.a().enableDeviceDegradeCommon == false) goto L25;
        if (LiveDegradeConfigHelper.a().enableMoveSamplingDegrade == false) goto L25;
        r101 = true;
        goto L25
    L13:
        if (LiveDegradeConfigHelper.a().enableDeviceDegradeCommon == false) goto L17;
        if (LiveDegradeConfigHelper.a().enableInteractionMonitorDegrade == false) goto L17;
        r103 = true;
        goto L18
    L5:
        if (LiveDegradeConfigHelper.a().enableDeviceDegradeCommon == false) goto L9;
        if (LiveDegradeConfigHelper.a().enableALoggerDegrade == false) goto L9;
        r102 = true;
        goto L10
    }
}
