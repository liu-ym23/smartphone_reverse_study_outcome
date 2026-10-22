package com.bytedance.android.latch.prefetch.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f58480b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f58481a;

    public static final class a implements q {
        @Override // com.bytedance.android.latch.prefetch.internal.q
        public final h a(String r100, com.bytedance.android.latch.a.b r101) {
            Intrinsics.checkNotNullParameter(r100, "pageUrl");
            Intrinsics.checkNotNullParameter(r101, "dataHolder");
            g r102 = g.f58480b;
            if (r102 != null) goto L7;
            return null;
        L7:
            return r102.a(r100, r101);
        }
    }

    static {
    }

    @Override // com.bytedance.android.latch.prefetch.internal.q
    public final h a(String r100, com.bytedance.android.latch.a.b r101) {
        Intrinsics.checkNotNullParameter(r100, "pageUrl");
        Intrinsics.checkNotNullParameter(r101, "dataHolder");
        t r102 = this.f58481a.b(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return new h(this, r102);
    }

    public g(String r100, y r101, b r102) {
        this.f58481a = r101;
    }
}
