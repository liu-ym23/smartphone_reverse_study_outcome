package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p implements k, com.bytedance.android.shopping.prepurchase.arch.container.intf.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.i f180714a;

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.intf.i
    public final void ensureNotReachHere(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        this.f180714a.ensureNotReachHere(r100);
    }

    public p(com.bytedance.android.shopping.prepurchase.arch.container.intf.i r100) {
        Intrinsics.checkNotNullParameter(r100, "monitorService");
        this.f180714a = r100;
    }
}
