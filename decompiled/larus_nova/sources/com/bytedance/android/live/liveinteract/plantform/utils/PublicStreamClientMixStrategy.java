package com.bytedance.android.live.liveinteract.plantform.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/PublicStreamClientMixStrategy;", "", "None", "Purpose", "Using", "Fallback", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PublicStreamClientMixStrategy extends Enum<PublicStreamClientMixStrategy> {
    public static final PublicStreamClientMixStrategy Fallback = null;
    public static final PublicStreamClientMixStrategy None = null;
    public static final PublicStreamClientMixStrategy Purpose = null;
    public static final PublicStreamClientMixStrategy Using = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicStreamClientMixStrategy[] f77431a = null;

    static {
        PublicStreamClientMixStrategy r100 = new PublicStreamClientMixStrategy("None", 0);
        None = r100;
        PublicStreamClientMixStrategy r101 = new PublicStreamClientMixStrategy("Purpose", 1);
        Purpose = r101;
        PublicStreamClientMixStrategy r102 = new PublicStreamClientMixStrategy("Using", 2);
        Using = r102;
        PublicStreamClientMixStrategy r103 = new PublicStreamClientMixStrategy("Fallback", 3);
        Fallback = r103;
        f77431a = new PublicStreamClientMixStrategy[]{r100, r101, r102, r103};
    }

    public static PublicStreamClientMixStrategy valueOf(String r100) {
        return (PublicStreamClientMixStrategy) r27.a.a(PublicStreamClientMixStrategy.class, r100);
    }

    public static PublicStreamClientMixStrategy[] values() {
        return (PublicStreamClientMixStrategy[]) f77431a.clone();
    }

    public PublicStreamClientMixStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
