package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class d<T> implements h {
    public d() {
    }

    public abstract void a(Context r100, T r101, Object r102, il2.a r103, e r104);

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(e r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100 == null) goto L5;
        e.a.a(r100, 0, r101, 1);
    L5:
        ((tg2.b) this).logE(r101);
    }
}
