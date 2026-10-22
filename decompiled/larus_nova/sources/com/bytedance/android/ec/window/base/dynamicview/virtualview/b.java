package com.bytedance.android.ec.window.base.dynamicview.virtualview;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements g<ConstraintLayout.LayoutParams, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final oo.c f49291a;

    public static final class a {
    }

    static {
    }

    public b(oo.c r100) {
        Intrinsics.checkNotNullParameter(r100, "constraintLp");
        this.f49291a = r100;
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
    public final void a(Object r100, ViewGroup.LayoutParams r101, List r110) {
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        Intrinsics.checkNotNullParameter(r102, "lp");
        Intrinsics.checkNotNullParameter(r110, "allElements");
        Iterator<T> r103 = this.f49291a.f524505a.iterator();
    L4:
        if (r103.hasNext() == false) goto L28;
        com.bytedance.android.ec.window.base.dynamicview.virtualview.a r104 = (com.bytedance.android.ec.window.base.dynamicview.virtualview.a) r103.next();
        if (Intrinsics.areEqual(r104.f49288a, "parent") == false) goto L8;
        Integer r105 = 0;
    L22:
        if (r105 == null) goto L24;
        r104.f49290c.getTargetField().set(r102, r105);
        goto L4
    L24:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == false) goto L4;
        goto L4
    L8:
        Iterator r106 = r110.iterator();
    L10:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (((k) r107).f49318b != r104.f49289b) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L10;
    L18:
        k r109 = (k) r107;
        if (r109 == null) goto L21;
        r105 = Integer.valueOf(r109.f49318b);
        goto L22
    L21:
        r105 = null;
        goto L22
    L14:
        r108 = false;
        goto L15
    L17:
        r107 = null;
        goto L18
    L28:
        this.f49291a.f524506b.a(r102);
    }
}
