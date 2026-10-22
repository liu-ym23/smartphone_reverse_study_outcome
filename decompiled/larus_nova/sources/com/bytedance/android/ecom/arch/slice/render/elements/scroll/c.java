package com.bytedance.android.ecom.arch.slice.render.elements.scroll;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.n;
import com.bytedance.android.ecom.arch.slice.action.ui.SlcUIActionErrorCode;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.bindinfo.d;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcItemView;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaOverflow;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class c extends BaseSlcViewGroupManager<SlcScrollElementView> {
    public IAction V3;
    public yq.a W3;
    public b X3;

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final YogaNode B0() {
        YogaNode r100 = com.bytedance.android.ecom.arch.slice.render.widget.yoga.c.f(this, false);
        r100.setOverflow(YogaOverflow.SCROLL);
        return r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final int r1() {
        return -Math.round(this.f50272f.getLayoutBorder(YogaEdge.LEFT));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final int s1() {
        return -Math.round(this.f50272f.getLayoutBorder(YogaEdge.TOP));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final ViewGroup B1() {
        return ((SlcScrollElementView) getView()).getContentView();
    }

    public c(SlcTemplateContext r100) {
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public /* bridge */ /* synthetic */ View A0(Context r100) {
        return I1(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final void C1(BaseSlcViewManager<?> r100) {
        r100.f50272f.setFlexShrink(0.0f);
        r100.J0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void G0(Map<String, ? extends Object> r100) {
        IAction r101 = n.a(r100.get("on_scroll"));
        if (Intrinsics.areEqual(r101, this.V3) == false) goto L6;
    L26:
        this.V3 = r101;
        return;
    L6:
        if (this.V3 == null) goto L12;
        b r102 = this.X3;
        if (r102 == null) goto L12;
        ArrayList<Function4<Integer, Integer, Integer, Integer, Unit>> r103 = ((SlcScrollElementView) getView()).f50477c;
        if (r103 == null) goto L12;
        r103.remove(r102);
    L12:
        if (r101 == null) goto L26;
        yq.a r104 = this.W3;
        if (r104 != null) goto L17;
        r104 = new yq.a();
        this.W3 = r104;
    L17:
        r104.f568738a = 0;
        b r105 = this.X3;
        if (r105 != null) goto L20;
        r105 = new b(this);
        this.X3 = r105;
    L20:
        SlcScrollElementView r106 = (SlcScrollElementView) getView();
        ArrayList<Function4<Integer, Integer, Integer, Integer, Unit>> r107 = r106.f50477c;
        if (r107 != null) goto L24;
        r107 = new ArrayList();
        r106.f50477c = r107;
    L24:
        if (r107.contains(r105) == true) goto L26;
        r107.add(r105);
        goto L26
    }

    public SlcScrollElementView I1(Context r100) {
        AttributeSet r101 = null;
        return new SlcScrollElementView(r100, r101, 6, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    @SlcUIActionErrorCode
    public final int k0(lq.b r100) {
        String r101 = r100.getType();
        if (r101.hashCode() == (-402165208)) goto L6;
    L52:
        return 3;
    L6:
        if (r101.equals("scrollTo") == false) goto L52;
        Map<String, Object> r102 = r100.f510283b;
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L51;
        int r104 = getChildCount();
        if (r104 == 0) goto L60;
        int r105 = com.bytedance.android.ecom.arch.slice.render.util.b.f(r102.get("index"), -1);
        if (r105 < r104) goto L22;
        r105 = r104 - 1;
    L22:
        String r106 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r102.get("align"));
        if (r106 != null) goto L26;
        r106 = "start";
    L26:
        int r107 = SlcDimensExtensionsKt.a(Float.valueOf(com.bytedance.android.ecom.arch.slice.render.util.b.c(r102.get("offset"), 0.0f)), this.f50260a.m());
        boolean r108 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r102.get("smooth"));
        if (r105 >= 0) goto L32;
        if (r107 == 0) goto L54;
        if (r108 == false) goto L31;
        ((SlcScrollElementView) getView()).smoothScrollBy(-r107, 0);
        return 0;
    L31:
        ((SlcScrollElementView) getView()).scrollBy(-r107, 0);
        return 0;
    L54:
        return 0;
    L32:
        BaseSlcViewManager<?> r109 = getChildAt(r105);
        if (r109 == null) goto L51;
        View r110 = r109.getView();
        int r111 = r106.hashCode();
        if (r111 == (-1364013995)) goto L43;
        if (r111 == 100571) goto L40;
    L46:
        int r112 = r110.getLeft();
    L47:
        int r113 = r112 - r107;
        if (r108 == false) goto L50;
        ((SlcScrollElementView) getView()).smoothScrollTo(r113, 0);
        return 0;
    L50:
        ((SlcScrollElementView) getView()).scrollTo(r113, 0);
        return 0;
    L40:
        if (r106.equals("end") == false) goto L46;
        int r114 = (((SlcScrollElementView) getView()).getWidth() - ((SlcScrollElementView) getView()).getPaddingLeft()) - ((SlcScrollElementView) getView()).getPaddingRight();
        int r115 = r110.getWidth();
        int r116 = r110.getLeft();
        int r117 = r114 - r115;
    L45:
        r112 = r116 - r117;
        goto L47
    L43:
        if (r106.equals("center") == false) goto L46;
        int r118 = (((SlcScrollElementView) getView()).getWidth() - ((SlcScrollElementView) getView()).getPaddingLeft()) - ((SlcScrollElementView) getView()).getPaddingRight();
        int r119 = r110.getWidth();
        r116 = r110.getLeft();
        r117 = (r118 - r119) / 2;
        goto L45
    L60:
        return 0;
    L51:
        return 4;
    L10:
        if (r102.isEmpty() == true) goto L13;
        r103 = false;
        goto L14
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager, com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void w0(Map<String, ? extends Object> r100) {
        super.w0(r100);
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == false) goto L5;
        return;
    L5:
        if (nq.a.h() == false) goto L23;
        BaseSlcViewGroupManager<?> r101 = this.f50268d;
        if (r101 == null) goto L24;
        SlcElement r102 = r101.f50270e;
        if (r102 == null) goto L25;
        Map<String, Object> r103 = r102.getStyle();
        if (r103 != null) goto L13;
    L14:
        d r104 = r102.bindInfo;
        if (r104 == null) goto L26;
        Map<String, String> r105 = r104.f50131b;
        if (r105 != null) goto L19;
        return;
    L19:
        if (r105.containsKey("overflow") != true) goto L28;
    L20:
        nq.a.f(null, "Scroll的parent节点不能设置overflow:visible");
        nq.a.i(getContext(), "Scroll的parent节点不能设置overflow:visible");
        return;
    L28:
        return;
    L26:
        return;
    L13:
        if (r103.containsKey("overflow") == true) goto L20;
    L25:
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void x0(View r100) {
        ((SlcScrollElementView) r100).setYogaNode$slice_render_release(this.f50272f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void T0(String r100, boolean r101) {
        SliceRender.f50121o.getClass();
        if (SliceRender.f() == false) goto L20;
        Object r102 = ((SlcScrollElementView) getView()).getParent();
        if (r102 == null) goto L17;
        if (r100 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        boolean r104 = !r103;
        if ((r102 instanceof SlcRootView) == false) goto L15;
        ((View) r102).setTag(Boolean.valueOf(r104));
        goto L17
    L15:
        if ((r102 instanceof SlcItemView) == false) goto L17;
        ((View) r102).setTag(Boolean.valueOf(r104));
        goto L17
    L8:
        if ("visible".equals(r100) == false) goto L10;
        r103 = true;
    L17:
        ?? r105 = getView();
        if (Build.VERSION.SDK_INT < 24) goto L22;
        r105.forceHasOverlappingRendering(!r101);
        return;
    L22:
        return;
    L20:
        super.T0(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void V0(List<?> r100, float r101) {
        int r102 = SlcDimensExtensionsKt.a(Float.valueOf(r101), this.f50260a.m());
        ((SlcScrollElementView) getView()).setPadding(r102, r102, r102, r102);
        this.f50272f.setBorder(YogaEdge.ALL, r102);
        SlcViewExtensionsKt.j(this, com.bytedance.android.ecom.arch.slice.render.util.b.d(r100));
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final boolean x1(BaseSlcViewManager<?> r100, RectF r101) {
        ViewGroup r102 = B1();
        r101.offset(com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf((r102.getLeft() + r100.getView().getLeft()) - h0()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf((r102.getTop() + r100.getView().getTop()) - i0()), 0.0f));
        return true;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final long u0(float r100, YogaMeasureMode r101, float r102, YogaMeasureMode r103) {
        return YogaMeasureOutput.make(0, 0);
    }
}
