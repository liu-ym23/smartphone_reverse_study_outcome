package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f87601a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f87602b = null;

    static {
        int[] r100 = new int[FansClubUserStatus.values().length];
        f87601a = r100;
        r100[FansClubUserStatus.Active.ordinal()] = 1;
        r100[FansClubUserStatus.Inactive.ordinal()] = 2;
        int[] r101 = new int[GuardStatus.values().length];
        f87602b = r101;
        r101[GuardStatus.ActiveGuard.ordinal()] = 1;
    }
}
