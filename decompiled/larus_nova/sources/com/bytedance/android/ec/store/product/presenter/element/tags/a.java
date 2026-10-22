package com.bytedance.android.ec.store.product.presenter.element.tags;

import com.bytedance.android.ec.store.repository.vo.ECTagContainerDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final List<Map<String, String>> a(List<ECTagContainerDTO> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getHighlightTagCode");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(((ECTagContainerDTO) r102.next()).getExtraInfo());
        goto L4
    L6:
        return r101;
    }

    public static final List<String> b(List<ECTagContainerDTO> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getTagCodeList");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        String r103 = ((ECTagContainerDTO) r102.next()).getExtraInfo().get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
        if (r103 == null) goto L4;
        if ((!StringsKt.isBlank(r103)) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L14:
        return CollectionsKt.toList(r101);
    }
}
