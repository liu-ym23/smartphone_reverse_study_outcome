package com.bytedance.android.live.revlink.impl.pk.randompkcheck;

import com.bytedance.android.live.revlink.impl.constants.RandomMatchCheckSource;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f96761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f96762b = null;

    static {
        int[] r100 = new int[RandomMatchCheckSource.values().length];
        f96761a = r100;
        RandomMatchCheckSource r101 = RandomMatchCheckSource.PKUserListFragment;
        r100[r101.ordinal()] = 1;
        RandomMatchCheckSource r102 = RandomMatchCheckSource.MultiPKUserListFragment;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[RandomMatchCheckSource.values().length];
        f96762b = r103;
        r103[RandomMatchCheckSource.Setting.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
        r103[r102.ordinal()] = 3;
    }
}
