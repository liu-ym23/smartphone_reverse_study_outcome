package com.bytedance.android.livesdk.calendar;

import com.bytedance.timon.calendar.ResultCode;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f104433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f104434b = null;

    static {
        int[] r100 = new int[ResultCode.values().length];
        f104433a = r100;
        ResultCode r101 = ResultCode.ArgumentError;
        r100[r101.ordinal()] = 1;
        ResultCode r102 = ResultCode.NoPermission;
        r100[r102.ordinal()] = 2;
        ResultCode r103 = ResultCode.NoAccount;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[ResultCode.values().length];
        f104434b = r104;
        r104[ResultCode.NotFound.ordinal()] = 1;
        r104[r101.ordinal()] = 2;
        r104[r102.ordinal()] = 3;
        r104[r103.ordinal()] = 4;
    }
}
