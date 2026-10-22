package com.bytedance.android.ecom.arch.slice.render.elements;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public abstract class b<ContentViewType extends View> extends BaseSlcViewManager<SlcElementContainer> {
    public void m1(ContentViewType r100) {
    }

    public abstract ContentViewType n1(Context r100);

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View E0() {
        View r100 = k1();
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getView();
    }

    public final ContentViewType k1() {
        ContentViewType r100 = (ContentViewType) getView().getContentView();
        if ((r100 instanceof View) == true) goto L6;
        return null;
    L6:
        return r100;
    }

    public final ContentViewType l1() {
        ContentViewType r100 = (ContentViewType) k1();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public b(SlcTemplateContext r100) {
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final View A0(Context r100) {
        AttributeSet r101 = null;
        SlcElementContainer r102 = new SlcElementContainer(r100, r101, 6, 0);
        r102.setContentView(n1(r100));
        return r102;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public com.bytedance.android.ecom.arch.slice.render.util.accessibility.b E(MotionEvent r100) {
        if (getView().dispatchHoverEvent(r100) == true) goto L5;
        return null;
    L5:
        return new com.bytedance.android.ecom.arch.slice.render.util.accessibility.b(this, true);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void U0(List<Float> r100) {
        super.U0(r100);
        SlcViewExtensionsKt.j(this, r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void x0(View r100) {
        View r101 = ((SlcElementContainer) r100).getContentView();
        if ((r101 instanceof View) == true) goto L5;
        r101 = null;
    L5:
        if (r101 == null) goto L8;
        m1(r101);
        return;
    }
}
