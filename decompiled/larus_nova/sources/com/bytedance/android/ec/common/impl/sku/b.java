package com.bytedance.android.ec.common.impl.sku;

import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43071a = 0;

    static {
    }

    public static SkuItemInfoVO a(SkuInfoVO r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        Intrinsics.checkNotNullParameter(r101, "selectSkuId");
        Iterator<T> r102 = r100.getSkuList().values().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((SkuItemInfoVO) r103).getId(), r101) == false) goto L4;
    L10:
        return (SkuItemInfoVO) r103;
    L8:
        r103 = null;
        goto L10
    }
}
