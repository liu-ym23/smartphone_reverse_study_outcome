package com.bytedance.android.shopping.store.hybridproduct.presenter;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t {
    public static final rn.d a(dj3.c r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        List r100 = CollectionsKt.listOf(new sn.d.c(3000));
        int r101 = com.bytedance.android.ec.core.utils.s.f45717a;
        Integer r102 = com.bytedance.android.ec.core.utils.s.b(r110.a());
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        int r104 = r103;
        float r105 = 11;
        float r106 = 12;
        tn.a.c r107 = new tn.a.c(10, 10, true, r104, new tn.a.C7744a(r105, r105, r106, r106));
        rn.c[] r108 = new rn.c[3];
        r108[0] = new rn.b(new tn.a.b());
        List r109 = CollectionsKt.emptyList();
        Long r111 = r110.b();
        if (r111 == null) goto L9;
        int r112 = (int) r111.longValue();
    L10:
        int r113 = com.bytedance.android.ec.core.utils.s.a(r110.f(), -1);
        String r114 = r110.e();
        if (r114 != null) goto L13;
        r114 = "";
    L13:
        String r115 = r114;
        if (com.bytedance.android.shopping.extensions.k.h(r110.c()) <= 400) goto L16;
        boolean r116 = true;
    L17:
        r108[1] = new rn.f(r109, new tn.a.e(-2, r112, r113, r115, r116));
        r108[2] = new rn.b(new tn.a.b());
        return new rn.d(r100, r107, CollectionsKt.listOf(r108));
    L16:
        r116 = false;
        goto L17
    L9:
        r112 = 13;
        goto L10
    L5:
        r103 = (int) 3862510404L;
        goto L6
    }
}
