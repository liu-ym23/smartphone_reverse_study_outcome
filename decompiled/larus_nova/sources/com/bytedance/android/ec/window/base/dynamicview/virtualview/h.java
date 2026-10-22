package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements g<ConstraintLayout.LayoutParams, LinearGroupViewElement.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qo.c f49304a;

    public h(qo.c r100) {
        Intrinsics.checkNotNullParameter(r100, "lp");
        this.f49304a = r100;
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final ViewGroup.LayoutParams b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "uiParam");
        ConstraintLayout.LayoutParams r101 = new ConstraintLayout.LayoutParams(r100.f49307a, r100.f49308b);
        r101.constrainedWidth = true;
        r101.constrainedHeight = true;
        r101.horizontalChainStyle = 2;
        r101.verticalChainStyle = 2;
        com.bytedance.android.ec.window.base.dynamicview.common.a.b(r101, r100.f49312f);
        return r101;
    }

    @Override // com.bytedance.android.ec.window.base.dynamicview.virtualview.g
    public final void a(LinearGroupViewElement.b r100, ViewGroup.LayoutParams r101, List r102) {
        LinearGroupViewElement.b r103 = r100;
        ConstraintLayout.LayoutParams r104 = (ConstraintLayout.LayoutParams) r101;
        Intrinsics.checkNotNullParameter(r104, "lp");
        Intrinsics.checkNotNullParameter(r102, "allElements");
        Iterator<String> r105 = this.f49304a.f534144a.iterator();
    L4:
        if (r105.hasNext() == false) goto L41;
        String r106 = r105.next();
        if (r103 == null) goto L25;
        if ((!r103.a()) != true) goto L25;
        int r107 = r106.hashCode();
        if (r107 != (-1383228885)) goto L12;
        if (r106.equals("bottom") == false) goto L4;
        r104.bottomToBottom = 0;
        goto L4
    L12:
        if (r107 != (-348726240)) goto L14;
        if (r106.equals("center_vertical") == false) goto L4;
        r104.verticalBias = 0.5f;
        r104.topToTop = 0;
        r104.bottomToBottom = 0;
        goto L4
    L14:
        if (r107 != 115029) goto L4;
        if (r106.equals("top") == false) goto L4;
        r104.topToTop = 0;
    L25:
        int r108 = r106.hashCode();
        if (r108 != 3317767) goto L28;
        if (r106.equals("left") == false) goto L4;
        r104.leftToLeft = 0;
        goto L4
    L28:
        if (r108 != 108511772) goto L30;
        if (r106.equals("right") == false) goto L4;
        r104.rightToRight = 0;
        goto L4
    L30:
        if (r108 != 1063616078) goto L4;
        if (r106.equals("center_horizontal") == false) goto L4;
        r104.horizontalBias = 0.5f;
        r104.leftToLeft = 0;
        r104.rightToRight = 0;
        goto L4
    }
}
