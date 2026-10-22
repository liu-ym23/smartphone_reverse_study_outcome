package com.bytedance.android.latch.prefetch.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/latch/prefetch/internal/PrefetchPartial;", "", "LATCH", "NATIVE", "latch-prefetch_release"}, k = 1, mv = {1, 4, 3})
public final enum PrefetchPartial extends Enum<PrefetchPartial> {
    public static final PrefetchPartial LATCH = null;
    public static final PrefetchPartial NATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PrefetchPartial[] f58426a = null;

    public static PrefetchPartial valueOf(String r100) {
        return (PrefetchPartial) r27.a.a(PrefetchPartial.class, r100);
    }

    public static PrefetchPartial[] values() {
        return (PrefetchPartial[]) f58426a.clone();
    }

    static {
        PrefetchPartial r100 = new PrefetchPartial("LATCH", 0);
        LATCH = r100;
        PrefetchPartial r101 = new PrefetchPartial("NATIVE", 1);
        NATIVE = r101;
        f58426a = new PrefetchPartial[]{r100, r101};
    }

    public PrefetchPartial(String r100, int r101) {
        super(r100, r101);
    }
}
