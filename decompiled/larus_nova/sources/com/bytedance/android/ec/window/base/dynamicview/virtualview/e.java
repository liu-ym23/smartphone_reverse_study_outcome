package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements g<FrameLayout.LayoutParams, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f49301b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final po.b f49302a;

    public static final class a {
    }

    static {
        f49301b = MapsKt.mapOf(new Pair[]{TuplesKt.to("left", 3), TuplesKt.to("top", 48), TuplesKt.to("right", 5), TuplesKt.to("bottom", 80), TuplesKt.to("center_vertical", 16), TuplesKt.to("center_horizontal", 1)});
    }

    public e(po.b r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLp");
        this.f49302a = r100;
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final ViewGroup.LayoutParams b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "uiParam");
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(r100.f49307a, r100.f49308b);
        com.bytedance.android.ec.window.base.dynamicview.common.a.b(r101, r100.f49312f);
        return r101;
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final void a(Object r100, ViewGroup.LayoutParams r101, List r102) {
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r101;
        Intrinsics.checkNotNullParameter(r103, "lp");
        Intrinsics.checkNotNullParameter(r102, "allElements");
        List<String> r104 = this.f49302a.f530018a;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L9;
        String r107 = (String) r106.next();
        Integer r108 = f49301b.get(r107);
        if (r108 == null) goto L4;
        r105.add(r108);
        goto L4
    L9:
        if (r105.isEmpty() == true) goto L27;
        Iterator r109 = r105.iterator();
        if (r109.hasNext() == false) goto L20;
        Object r110 = r109.next();
    L15:
        if (r109.hasNext() == false) goto L17;
        int r111 = ((Number) r109.next()).intValue();
        r110 = Integer.valueOf(((Number) r110).intValue() | r111);
        goto L15
    L17:
        r103.gravity = ((Number) r110).intValue();
        return;
    L20:
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }
}
