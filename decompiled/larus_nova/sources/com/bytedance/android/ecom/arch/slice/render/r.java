package com.bytedance.android.ecom.arch.slice.render;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.widget.SlcRootView;
import com.facebook.drawee.backends.pipeline.Fresco;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f50698d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ? extends Object> f50699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SlcTemplateContext f50700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f50701c;

    public static final class a {
        public a() {
        }

        public static r a(SlcRenderContext r100, SlcElement r101, p r102) {
            Context r103 = r100.getContext();
            if (Fresco.hasBeenInitialized() == true) goto L5;
            Fresco.initialize(r103);
        L5:
            boolean r104 = com.bytedance.android.ecom.arch.slice.render.util.h.b();
            SlcTemplateContext r105 = new SlcTemplateContext(r100, r102);
            boolean r106 = !r104;
            r105.f50214b = r106;
            r105.f50216d = r104;
            r105.f50215c = r106;
            SlcRootView r107 = new SlcRootView(r100.getContext(), null, 6, 0);
            BaseSlcViewManager<?> r108 = r105.c(r101.getType(), true, false);
            r105.f50218f = r108;
            r107.setRootViewManager$slice_render_release(r108);
            r108.m0(r101);
            r107.setCreateLayoutListener$slice_render_release(r105.f50220h.f50632f);
            r105.f50214b = false;
            return new r(r105, r107);
        }
    }

    static {
        f50698d = new a();
    }

    public final void b(b r100) {
        this.f50700b.t(r100);
    }

    public r(SlcTemplateContext r100, SlcRootView r101) {
        this.f50700b = r100;
        this.f50701c = r101;
        r100.f50217e = this;
    }

    public final void a(Map<String, ? extends Object> r100, String r101) {
        this.f50700b.a(r100, r101);
    }
}
