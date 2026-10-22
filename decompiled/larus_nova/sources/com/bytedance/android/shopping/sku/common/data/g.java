package com.bytedance.android.shopping.sku.common.data;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f182680a = 0;

    static {
    }

    public static h a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        int r101 = t0.f45720a;
        return (h) GsonProtectorUtils.fromJson(t0.a.f45721a, k.b(r100).toString(), h.class);
    }
}
