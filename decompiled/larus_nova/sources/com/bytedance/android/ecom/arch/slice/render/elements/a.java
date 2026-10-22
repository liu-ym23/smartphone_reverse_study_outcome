package com.bytedance.android.ecom.arch.slice.render.elements;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<ContentViewType extends ViewGroup> extends BaseSlcViewGroupManager<SlcElementContainer> {
    public ContentViewType V3;

    public void J1(ContentViewType r100) {
    }

    public abstract ContentViewType K1(Context r100);

    public final ContentViewType I1() {
        ContentViewType r100 = this.V3;
        if (r100 != null) goto L6;
        ContentViewType r101 = (ContentViewType) K1(getContext());
        this.V3 = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final ViewGroup B1() {
        return I1();
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View E0() {
        return I1();
    }

    public a(SlcTemplateContext r100) {
        super(r100);
        this.O3 = false;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View A0(Context r100) {
        SlcElementContainer r101 = new SlcElementContainer(r100, null, 6, 0);
        r101.setContentView(I1());
        return r101;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void U0(List<Float> r100) {
        super.U0(r100);
        SlcViewExtensionsKt.j(this, r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void x0(View r100) {
        SlcElementContainer r101 = (SlcElementContainer) r100;
        J1(I1());
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewGroupManager
    public final boolean x1(BaseSlcViewManager<?> r100, RectF r101) {
        r101.offset(com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf((I1().getLeft() + r100.getView().getLeft()) - h0()), 0.0f), com.bytedance.android.ecom.arch.slice.render.util.b.c(Integer.valueOf((I1().getTop() + r100.getView().getTop()) - i0()), 0.0f));
        return true;
    }
}
