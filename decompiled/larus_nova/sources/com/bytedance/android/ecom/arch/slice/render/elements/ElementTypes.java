package com.bytedance.android.ecom.arch.slice.render.elements;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcAsyncImageElementViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.blurview.SlcBackdropBlurElementViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.input.SlcInputElementViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.text.SlcTextElementViewManager;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class ElementTypes {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Function1<SlcTemplateContext, BaseSlcViewManager<?>>> f50336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, com.bytedance.android.ecom.arch.slice.render.cache.a> f50337b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, HashMap<String, com.bytedance.android.ecom.arch.slice.render.cache.a>> f50338c = null;

    static {
        f50336a = new HashMap();
        f50337b = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("Text", new com.bytedance.android.ecom.arch.slice.render.elements.text.a()), TuplesKt.to("Image", new com.bytedance.android.ecom.arch.slice.render.elements.image.a()), TuplesKt.to("View", new com.bytedance.android.ecom.arch.slice.render.elements.flexbox.a())});
        f50338c = new HashMap();
    }

    public static void b(final String r100, Function1 r101) {
        HashMap<String, Function1<SlcTemplateContext, BaseSlcViewManager<?>>> r102 = f50336a;
        if (r102.containsKey(r100) == false) goto L6;
        nq.a.c(null, new ElementTypes$registerCustomElement$1(r100), 1);
        return;
    L6:
        r102.put(r100, r101);
    }

    public static void c(final String r100, List r101) {
        nq.a.a();
        HashMap<String, HashMap<String, com.bytedance.android.ecom.arch.slice.render.cache.a>> r102 = f50338c;
        if (r102.containsKey(r100) == false) goto L6;
        nq.a.c(null, new ElementTypes$registerCustomManagerPoolCreator$1(r100), 1);
        return;
    L6:
        HashMap<String, com.bytedance.android.ecom.arch.slice.render.cache.a> r103 = new HashMap();
        Iterator r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        com.bytedance.android.ecom.arch.slice.render.cache.a r105 = (com.bytedance.android.ecom.arch.slice.render.cache.a) r104.next();
        r103.put(r105.getElementType(), r105);
        goto L8
    L10:
        r102.put(r100, r103);
    }

    public static BaseSlcViewManager a(SlcTemplateContext r100, String r101, boolean r102) {
        BaseSlcViewManager<?> r103 = null;
        switch(r101.hashCode()) {
            case -1873236506: goto L33;
            case -1823812883: goto L30;
            case -1334240144: goto L27;
            case -1052092231: goto L24;
            case 2368702: goto L21;
            case 2603341: goto L18;
            case 2666181: goto L15;
            case 70760763: goto L12;
            case 945911421: goto L9;
            case 1032891970: goto L6;
            default: goto L61;
        };
    L61:
        BaseSlcViewManager<?> r104 = null;
    L36:
        if (r104 != null) goto L41;
        SliceRender.f50121o.getClass();
        pq.a r105 = SliceRender.f50108b;
        if (r105 == null) goto L40;
        r104 = r105.a(r101, r100);
        goto L41
    L40:
        r104 = null;
    L41:
        if (r104 != null) goto L46;
        Function1<SlcTemplateContext, BaseSlcViewManager<?>> r106 = f50336a.get(r101);
        if (r106 == null) goto L45;
        r103 = r106.invoke(r100);
    L45:
        r104 = r103;
    L46:
        if (r104 != null) goto L48;
        r104 = new qq.a(r100);
    L48:
        if (r102 == false) goto L50;
        r104.f50306r3 = true;
    L51:
        return r104;
    L50:
        r104.getView().setTag(R.id.slc_view_manager, r104);
        goto L51
    L6:
        if (r101.equals("BackdropBlurView") == false) goto L35;
        r104 = new SlcBackdropBlurElementViewManager(r100);
        goto L36
    L35:
        r104 = null;
        goto L36
    L9:
        if (r101.equals("TextInput") == false) goto L52;
        r104 = new SlcInputElementViewManager(r100);
        goto L36
    L52:
        r104 = null;
        goto L36
    L12:
        if (r101.equals("Image") == false) goto L53;
        r104 = new SlcAsyncImageElementViewManager(r100);
        goto L36
    L53:
        r104 = null;
        goto L36
    L15:
        if (r101.equals("View") == false) goto L54;
        r104 = new com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b(r100);
        goto L36
    L54:
        r104 = null;
        goto L36
    L18:
        if (r101.equals("Text") == false) goto L55;
        r104 = new SlcTextElementViewManager(r100);
        goto L36
    L55:
        r104 = null;
        goto L36
    L21:
        if (r101.equals("List") == false) goto L56;
        r104 = new com.bytedance.android.ecom.arch.slice.render.elements.list.c(r100);
        goto L36
    L56:
        r104 = null;
        goto L36
    L24:
        if (r101.equals("XCountdown") == false) goto L57;
        r104 = new com.bytedance.android.ecom.arch.slice.render.elements.xelements.countdown.a(r100);
        goto L36
    L57:
        r104 = null;
        goto L36
    L27:
        if (r101.equals("XFlowLayout") == false) goto L58;
        r104 = new com.bytedance.android.ecom.arch.slice.render.elements.xelements.flowlayout.a(r100);
        goto L36
    L58:
        r104 = null;
        goto L36
    L30:
        if (r101.equals("Scroll") == false) goto L59;
        r104 = new com.bytedance.android.ecom.arch.slice.render.elements.scroll.c(r100);
        goto L36
    L59:
        r104 = null;
        goto L36
    L33:
        if (r101.equals("ScrollBar") == false) goto L60;
        r104 = new rq.a(r100);
        goto L36
    L60:
        r104 = null;
        goto L36
    }
}
