package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.k;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f182989a = null;

    static {
        f182989a = CollectionsKt.listOf(new Integer[]{101, 201, 301});
    }

    public static boolean a(int r100, int r101, int r102) {
        cl.d r103 = k.a();
        if (r103 == null) goto L5;
        r103.b();
    L5:
        ECAppInfoService r104 = ECAppInfoService.f48114e;
        r104.i();
        r104.i();
        if (r100 > 0) goto L8;
    L12:
        return false;
    L8:
        if (f182989a.contains(Integer.valueOf(r101)) == false) goto L12;
        if (r102 != 1) goto L12;
        return true;
    }
}
