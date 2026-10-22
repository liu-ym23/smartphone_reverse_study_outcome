package com.bytedance.android.shopping.store.aggregate.classification;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static final ECUrlModel a(ECUrlModel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$copy");
        ECUrlModel r101 = new ECUrlModel();
        r101.setUri(r100.getUri());
        List<String> r102 = r100.getUrlList();
        if (r102 == null) goto L5;
        List<String> r103 = CollectionsKt.toList(r102);
    L6:
        r101.setUrlList(r103);
        r101.setWidth(r100.getWidth());
        r101.setHeight(r100.getHeight());
        r101.setUrlKey(r100.getUrlKey());
        r101.setSize(r100.getSize());
        r101.setFileHash(r100.getFileHash());
        return r101;
    L5:
        r103 = null;
        goto L6
    }
}
