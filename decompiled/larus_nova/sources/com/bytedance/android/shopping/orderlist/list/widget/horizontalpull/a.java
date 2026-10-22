package com.bytedance.android.shopping.orderlist.list.widget.horizontalpull;

import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final View a(HashMap<View, BaseHorizontalPullLayout.a> r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getByType");
        Iterator<Map.Entry<View, BaseHorizontalPullLayout.a>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        View r103 = r102.next().getKey();
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L14;
        int r105 = ((BaseHorizontalPullLayout.LayoutParams) r104).getType();
        if (r101 == null) goto L4;
        if (r105 != r101.intValue()) goto L4;
        return r103;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.orderlist.list.widget.horizontalpull.BaseHorizontalPullLayout.LayoutParams");
    L15:
        return null;
    }
}
