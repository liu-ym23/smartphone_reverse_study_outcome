package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {
    public static final ECUrlModel a(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "url");
        ECUrlModel r103 = new ECUrlModel();
        r103.setUrlList(CollectionsKt.listOf(r102));
        r103.setWidth(r100);
        r103.setHeight(r101);
        return r103;
    }
}
