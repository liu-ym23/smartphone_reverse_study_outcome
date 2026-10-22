package com.bytedance.android.shopping.buynow.eventcenter.handle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends com.bytedance.kmp.ec.yata.event.common.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia3.a f170952a;

    public static final class a {
    }

    static {
    }

    public e(ia3.a r100) {
        this.f170952a = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.b
    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        ia3.a r101 = this.f170952a;
        if (r101 == null) goto L5;
        r101.f488859a.setVisibility(8);
    L5:
        int r102 = com.bytedance.kmp.ec.yata.chain.event.b.f251281h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    }
}
