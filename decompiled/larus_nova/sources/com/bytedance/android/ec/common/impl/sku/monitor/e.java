package com.bytedance.android.ec.common.impl.sku.monitor;

import com.bytedance.android.ec.core.monitor.k;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.sku.SkuParams;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SkuParams f43105b;

    public e(SkuParams r100) {
        Intrinsics.checkNotNullParameter(r100, "skuParams");
        this.f43105b = r100;
    }

    public final void a(boolean r100) {
        int r101 = this.f43104a + 1;
        this.f43104a = r101;
        if (r101 <= 1) goto L5;
        return;
    L5:
        if (r100 == true) goto L8;
        Map r102 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("status", "1")});
        r102.putAll(z1.j(this.f43105b.asJsonDescription()));
        Map<String, String> r103 = k.f45162a;
        k.c(com.bytedance.android.ec.hybrid.list.util.k.b(r102));
        return;
    }
}
