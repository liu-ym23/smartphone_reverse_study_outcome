package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j extends b {
    public j(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Map<String, Object> r102 = r100.getParams();
        if (r102 == null) goto L5;
        Object r103 = r102.get("query");
    L7:
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        if (r104.length() != 0) goto L15;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        return false;
    L18:
        Map<String, Object> r106 = r100.getParams();
        if (r106 == null) goto L21;
        Object r107 = r106.get("feature_info_list");
    L23:
        if ((r107 instanceof List) == true) goto L25;
        r107 = null;
    L25:
        List r108 = (List) r107;
        if (r108 == null) goto L36;
        List<String> r109 = new ArrayList();
        Iterator r110 = r108.iterator();
    L29:
        if (r110.hasNext() == false) goto L37;
        Object r111 = r110.next();
        if ((r111 instanceof String) == true) goto L33;
        r111 = null;
    L33:
        String r112 = (String) r111;
        if (r112 == null) goto L29;
        r109.add(r112);
    L37:
        this.f173398c.d(r104, r109, r101);
        return false;
    L36:
        r109 = CollectionsKt.emptyList();
        goto L37
    L21:
        r107 = null;
        goto L23
    L15:
        r105 = false;
        goto L16
    L5:
        r103 = null;
        goto L7
    }
}
