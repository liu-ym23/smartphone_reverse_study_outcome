package com.bytedance.android.livesdk.interactivity.asr;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/asr/CacheMode;", "", "TIME", "NUM", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CacheMode extends Enum<CacheMode> {
    public static final CacheMode NUM = null;
    public static final CacheMode TIME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CacheMode[] f133816a = null;

    static {
        CacheMode r100 = new CacheMode("TIME", 0);
        TIME = r100;
        CacheMode r101 = new CacheMode("NUM", 1);
        NUM = r101;
        f133816a = new CacheMode[]{r100, r101};
    }

    public static CacheMode valueOf(String r100) {
        return (CacheMode) r27.a.a(CacheMode.class, r100);
    }

    public static CacheMode[] values() {
        return (CacheMode[]) f133816a.clone();
    }

    public CacheMode(String r100, int r101) {
        super(r100, r101);
    }
}
