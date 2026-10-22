package com.bytedance.android.ecom.arch.slice.render.elements.flexbox;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.drawchild.SlcFlattenDrawChildHelper;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.c;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class b extends BaseSlcViewGroupManager<SlcFlexElementView> implements com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a.InterfaceC0866a {
    public SlcFlattenDrawChildHelper V3;

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final YogaNode B0() {
        return c.f(this, false);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public void H0(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final int h0() {
        return 0;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final int i0() {
        return 0;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void N() {
        if (this.N3 <= 0) goto L12;
        int r100 = getChildCount();
        int r101 = 0;
    L5:
        if (r101 >= r100) goto L12;
        BaseSlcViewManager<?> r102 = getChildAt(r101);
        if (r102 == null) goto L11;
        if (r102.f50306r3 != true) goto L11;
        r102.N();
    L11:
        r101 = r101 + 1;
    L12:
        super.N();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a.InterfaceC0866a
    public final com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a getSlcDrawChild() {
        SlcFlattenDrawChildHelper r100 = this.V3;
        if (r100 != null) goto L8;
        r100 = new SlcFlattenDrawChildHelper(this);
        if (this.f50306r3 == true) goto L7;
        ((SlcFlexElementView) getView()).setDrawChildProxy(r100);
    L7:
        this.V3 = r100;
    L8:
        return r100;
    }

    public b(SlcTemplateContext r100) {
        super(r100);
        this.O = SlcFlexDirection.FLEX_ROW;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public /* bridge */ /* synthetic */ View A0(Context r100) {
        return J1(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final boolean D(final Canvas r100) {
        if (this.N3 <= 0) goto L5;
    L6:
        final SlcFlattenDrawChildHelper r101 = this.V3;
        if (this.f50306r3 == false) goto L12;
        BaseSlcViewGroupManager<?> r102 = this.f50308s3;
        if (r102 == null) goto L11;
        Object r103 = r102.getView();
    L13:
        final ViewGroup r104 = (ViewGroup) r103;
    L15:
        if (r101 == null) goto L19;
        if (r104 == null) goto L19;
        SlcViewExtensionsKt.c(this, r100, new SlcFlexElementViewManager$innerDispatchDraw$1(this, r104, r100, r101));
        boolean r105 = true;
    L24:
        if (r105 == false) goto L26;
        return true;
    L26:
        return false;
    L19:
        if (this.V3 != null) goto L21;
        nq.a.c(null, new SlcFlexElementViewManager$innerDispatchDraw$2(this), 1);
    L21:
        if (r104 != null) goto L23;
        nq.a.c(null, new SlcFlexElementViewManager$innerDispatchDraw$3(this), 1);
    L23:
        r105 = false;
        goto L24
    L11:
        r104 = null;
        goto L15
    L12:
        r103 = getView();
        goto L13
    L5:
        if (this.f50306r3 == false) goto L26;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final void E1(BaseSlcViewManager<?> r100) {
        SlcFlattenDrawChildHelper r101 = this.V3;
        if (r101 == null) goto L10;
        r101.f().remove(r100);
        r101.f50904a = null;
        if (r100.f50306r3 == true) goto L11;
        b r102 = r101.f50906c;
        if (r102.f50306r3 == true) goto L12;
        ((SlcFlexElementView) r102.getView()).setChildrenDrawingOrderEnabled(!r101.f().isEmpty());
        return;
    L12:
        return;
    L11:
        return;
    }

    public void I1(SlcFlexElementView r100) {
        r100.f51020a = this.f50272f;
    }

    public SlcFlexElementView J1(Context r100) {
        return new SlcFlexElementView(r100, null, 6, 0);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void U0(List<Float> r100) {
        SlcViewExtensionsKt.j(this, r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public /* bridge */ /* synthetic */ void x0(View r100) {
        I1((SlcFlexElementView) r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager, com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void y0(SlcElement r100) {
        super.y0(r100);
        if (this.f50306r3 == false) goto L6;
        getSlcDrawChild();
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final void y1(BaseSlcViewManager<?> r100) {
        if (r100.f50306r3 == false) goto L5;
        ((SlcFlattenDrawChildHelper) getSlcDrawChild()).f50904a = null;
        return;
    L5:
        SlcFlattenDrawChildHelper r101 = this.V3;
        if (r101 == null) goto L10;
        r101.f50904a = null;
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void V0(List<?> r100, float r101) {
        this.f50272f.setBorder(YogaEdge.ALL, SlcDimensExtensionsKt.a(Float.valueOf(r101), this.f50260a.m()));
        SlcViewExtensionsKt.j(this, com.bytedance.android.ecom.arch.slice.render.util.b.d(r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public void F0(int r100, int r101, int r102, int r103) {
        if (this.f50306r3 == false) goto L5;
        h1(r100, r101, r102, r103);
        return;
    L5:
        super.F0(r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final long u0(float r100, YogaMeasureMode r101, float r102, YogaMeasureMode r103) {
        return YogaMeasureOutput.make(0, 0);
    }
}
