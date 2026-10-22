package com.bytedance.android.live.revlink.impl.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/constants/RandomMatchCheckSource;", "", "Setting", "CheckFragment", "AttentionFragment", "PKUserListFragment", "MultiPKUserListFragment", "TOPBANNER", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RandomMatchCheckSource extends Enum<RandomMatchCheckSource> {
    public static final RandomMatchCheckSource AttentionFragment = null;
    public static final RandomMatchCheckSource CheckFragment = null;
    public static final RandomMatchCheckSource MultiPKUserListFragment = null;
    public static final RandomMatchCheckSource PKUserListFragment = null;
    public static final RandomMatchCheckSource Setting = null;
    public static final RandomMatchCheckSource TOPBANNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RandomMatchCheckSource[] f92209a = null;

    static {
        RandomMatchCheckSource r100 = new RandomMatchCheckSource("Setting", 0);
        Setting = r100;
        RandomMatchCheckSource r101 = new RandomMatchCheckSource("CheckFragment", 1);
        CheckFragment = r101;
        RandomMatchCheckSource r102 = new RandomMatchCheckSource("AttentionFragment", 2);
        AttentionFragment = r102;
        RandomMatchCheckSource r103 = new RandomMatchCheckSource("PKUserListFragment", 3);
        PKUserListFragment = r103;
        RandomMatchCheckSource r104 = new RandomMatchCheckSource("MultiPKUserListFragment", 4);
        MultiPKUserListFragment = r104;
        RandomMatchCheckSource r105 = new RandomMatchCheckSource("TOPBANNER", 5);
        TOPBANNER = r105;
        f92209a = new RandomMatchCheckSource[]{r100, r101, r102, r103, r104, r105};
    }

    public static RandomMatchCheckSource valueOf(String r100) {
        return (RandomMatchCheckSource) a.a(RandomMatchCheckSource.class, r100);
    }

    public static RandomMatchCheckSource[] values() {
        return (RandomMatchCheckSource[]) f92209a.clone();
    }

    public RandomMatchCheckSource(String r100, int r101) {
        super(r100, r101);
    }
}
