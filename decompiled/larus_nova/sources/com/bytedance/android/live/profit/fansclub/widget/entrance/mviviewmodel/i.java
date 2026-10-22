package com.bytedance.android.live.profit.fansclub.widget.entrance.mviviewmodel;

import com.bytedance.android.live.profit.fansclub.FansClubUserStatus;
import com.bytedance.android.live.profit.fansclub.GuardStatus;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f87598a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f87599b = null;

    static {
        int[] r100 = new int[FansClubUserStatus.values().length];
        f87598a = r100;
        r100[FansClubUserStatus.Active.ordinal()] = 1;
        r100[FansClubUserStatus.Inactive.ordinal()] = 2;
        int[] r101 = new int[GuardStatus.values().length];
        f87599b = r101;
        r101[GuardStatus.ActiveGuard.ordinal()] = 1;
    }
}
