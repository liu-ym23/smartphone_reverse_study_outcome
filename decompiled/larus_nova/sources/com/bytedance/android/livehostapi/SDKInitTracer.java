package com.bytedance.android.livehostapi;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/livehostapi/SDKInitTracer;", "", "()V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "initCommerceEndTime", "getInitCommerceEndTime", "setInitCommerceEndTime", "initCommerceTime", "getInitCommerceTime", "setInitCommerceTime", "initComponentsTime", "getInitComponentsTime", "setInitComponentsTime", "initHostServiceTime", "getInitHostServiceTime", "setInitHostServiceTime", "initSdkLauncherEndTime", "getInitSdkLauncherEndTime", "setInitSdkLauncherEndTime", "initSdkLauncherTime", "getInitSdkLauncherTime", "setInitSdkLauncherTime", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "getOptType", "", "reportInitDuration", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SDKInitTracer {
    public static final SDKInitTracer INSTANCE = null;
    private static long endTime;
    private static long initCommerceEndTime;
    private static long initCommerceTime;
    private static long initComponentsTime;
    private static long initHostServiceTime;
    private static long initSdkLauncherEndTime;
    private static long initSdkLauncherTime;
    private static long startTime;

    private SDKInitTracer() {
    }

    static {
        INSTANCE = new SDKInitTracer();
    }

    public final void reportInitDuration() {
        new Handler(Looper.getMainLooper()).postDelayed(AnonymousClass1.INSTANCE, 2000);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private final int getOptType() {
        boolean r100 = LiveSdkInitHelper.isEnableSettingOpt();
        ?? r101 = r100;
        if (LiveSdkInitHelper.isEnableLauncherOpt() == false) goto L5;
        r101 = (r100 ? 1 : 0) | 2;
    L5:
        ?? r102 = r101;
        if (LiveSdkInitHelper.isEnableServiceOpt() == false) goto L9;
        r102 = (r101 == true ? 1 : 0) | 4;
    L9:
        if (LiveSdkInitHelper.isEnableFeedOpt() == true) goto L11;
        return r102;
    L11:
        return r102 | 8;
    }

    public final long getEndTime() {
        return endTime;
    }

    public final long getInitCommerceEndTime() {
        return initCommerceEndTime;
    }

    public final long getInitCommerceTime() {
        return initCommerceTime;
    }

    public final long getInitComponentsTime() {
        return initComponentsTime;
    }

    public final long getInitHostServiceTime() {
        return initHostServiceTime;
    }

    public final long getInitSdkLauncherEndTime() {
        return initSdkLauncherEndTime;
    }

    public final long getInitSdkLauncherTime() {
        return initSdkLauncherTime;
    }

    public final long getStartTime() {
        return startTime;
    }

    public static final /* synthetic */ int access$getOptType(SDKInitTracer r100) {
        return r100.getOptType();
    }

    public final void setEndTime(long r100) {
        endTime = r100;
    }

    public final void setInitCommerceEndTime(long r100) {
        initCommerceEndTime = r100;
    }

    public final void setInitCommerceTime(long r100) {
        initCommerceTime = r100;
    }

    public final void setInitComponentsTime(long r100) {
        initComponentsTime = r100;
    }

    public final void setInitHostServiceTime(long r100) {
        initHostServiceTime = r100;
    }

    public final void setInitSdkLauncherEndTime(long r100) {
        initSdkLauncherEndTime = r100;
    }

    public final void setInitSdkLauncherTime(long r100) {
        initSdkLauncherTime = r100;
    }

    public final void setStartTime(long r100) {
        startTime = r100;
    }
}
