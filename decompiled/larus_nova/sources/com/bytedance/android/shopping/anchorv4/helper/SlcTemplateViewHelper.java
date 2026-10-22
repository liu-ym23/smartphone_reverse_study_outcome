package com.bytedance.android.shopping.anchorv4.helper;

import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class SlcTemplateViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SlcContext f166927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SlcTemplateView f166928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f166929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f166930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x f166931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f166932f;

    public SlcTemplateViewHelper() {
        this(null);
    }

    public SlcTemplateViewHelper(h r100) {
        this.f166932f = r100;
    }

    public static View e(SlcTemplateViewHelper r100) {
        View r101 = r100.f166929c;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r101.getParent(), r100.f166928b) == false) goto L9;
        wg.a.a(r101);
        return r101;
    L9:
        return r101;
    }

    public final View d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sliceKey");
        View r101 = this.f166929c;
        if (r101 != null) goto L5;
    L7:
        return null;
    L5:
        if (this.f166927a == null) goto L7;
        return SlcRenderContext.f(r101, r100);
    }

    public final void f(SlcContext r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f166927a = r100;
        AttributeSet r101 = null;
        this.f166928b = new SlcTemplateView(r100.getContext(), r101, 6, 0);
    }

    public final void a(com.bytedance.android.ecom.arch.slice.slices.template.d r100, Map<String, ? extends Object> r101, String r102) {
        SlcContext r103 = this.f166927a;
        if (r103 != null) goto L5;
        return;
    L5:
        Map<String, Object> r104 = r100.getData();
        HashMap r105 = null;
        Object r106 = null;
        if ((r104 instanceof HashMap) == true) goto L8;
        r104 = null;
    L8:
        HashMap r107 = (HashMap) r104;
        if (r107 == null) goto L12;
        Object r108 = r107.clone();
        if (r108 == null) goto L12;
    L13:
        HashMap<String, JSONObject> r109 = com.bytedance.android.ec.core.hybrid.utils.j.f44312a;
        if (com.bytedance.android.ec.core.hybrid.utils.j.e(r102) == false) goto L46;
        if ((r108 instanceof HashMap) == true) goto L18;
        r108 = null;
    L18:
        HashMap r110 = (HashMap) r108;
        if (r110 == null) goto L21;
        r110.put("global", r103.f49960u0);
    L22:
        if (r110 == null) goto L24;
        Object r111 = r110.get(r102);
    L26:
        if (TypeIntrinsics.isMutableMap(r111) == false) goto L29;
        r106 = r111;
    L29:
        Map r112 = (Map) r106;
        if (r112 != null) goto L32;
        r112 = new LinkedHashMap();
    L32:
        if (r101 == null) goto L37;
        Iterator<Map.Entry<String, ? extends Object>> r113 = r101.entrySet().iterator();
    L35:
        if (r113.hasNext() == false) goto L37;
        Map.Entry<String, ? extends Object> r114 = r113.next();
        r112.put(r114.getKey(), r114.getValue());
    L37:
        if (r102 == null) goto L40;
        if (r110 == null) goto L40;
        r110.put(r102, r112);
    L40:
        Map<String, ? extends Object> r115 = SliceRender.a(r110);
        SlcTemplateView r116 = this.f166928b;
        if (r116 == null) goto L65;
        String r117 = r100.getSliceId();
        Intrinsics.checkNotNullParameter(r115, "dataCtx");
        com.bytedance.android.ecom.arch.slice.render.r r118 = r116.f51041c;
        if (r118 == null) goto L66;
        r118.a(r115, r117);
        return;
    L66:
        return;
    L65:
        return;
    L24:
        r111 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L46:
        if ((r108 instanceof HashMap) == true) goto L48;
        r108 = null;
    L48:
        HashMap r119 = (HashMap) r108;
        if (r119 == null) goto L57;
        r119.put("global", r103.f49960u0);
        if (r101 == null) goto L56;
        Iterator<Map.Entry<String, ? extends Object>> r120 = r101.entrySet().iterator();
    L54:
        if (r120.hasNext() == false) goto L56;
        Map.Entry<String, ? extends Object> r121 = r120.next();
        r119.put(r121.getKey(), r121.getValue());
    L56:
        r105 = r119;
    L57:
        Map<String, ? extends Object> r122 = JsonTemplate.a.b(JsonTemplate.f51054c, r105);
        SlcTemplateView r123 = this.f166928b;
        if (r123 == null) goto L68;
        String r124 = r100.getSliceId();
        Intrinsics.checkNotNullParameter(r122, "dataCtx");
        com.bytedance.android.ecom.arch.slice.render.r r125 = r123.f51041c;
        if (r125 == null) goto L69;
        r125.a(r122, r124);
        return;
    L69:
        return;
    L68:
        return;
    L12:
        r108 = new HashMap();
        goto L13
    }

    public final void b(final com.bytedance.android.ecom.arch.slice.g r100, Map<String, ? extends Object> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "slice");
        View r103 = null;
        if ((r100 instanceof com.bytedance.android.ecom.arch.slice.slices.template.d) == true) goto L6;
        nq.a.c(null, new SlcTemplateViewHelper$bindSlice$1(r100), 1);
        return;
    L6:
        com.bytedance.android.ecom.arch.slice.slices.template.d r104 = (com.bytedance.android.ecom.arch.slice.slices.template.d) r100;
        if (r104.b() != null) goto L10;
        nq.a.c(null, new SlcTemplateViewHelper$bindSlice$2(r100), 1);
        return;
    L10:
        SlcTemplateView r105 = this.f166928b;
        if (r105 != null) goto L13;
    L16:
        SlcContext r106 = this.f166927a;
        if (r106 == null) goto L31;
        this.f166931e = new x(this);
        com.bytedance.android.ecom.arch.slice.render.r r107 = r106.c(r104.c(), this.f166931e);
        SlcTemplateView r108 = this.f166928b;
        if (r108 == null) goto L22;
        r108.b(r106, r107);
    L22:
        SlcTemplateView r109 = this.f166928b;
        if (r109 == null) goto L25;
        r103 = r109.getSlcRootView();
    L25:
        this.f166929c = r103;
        SlcTemplateView r110 = this.f166928b;
        if (r110 == null) goto L28;
        r110.setActionHandler(new y(this, r104));
    L28:
        a(r104, r101, r102);
        return;
    L31:
        return;
    L13:
        if (r105.f51042d != true) goto L16;
        a(r104, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(SlcTemplateViewHelper r100, com.bytedance.android.ecom.arch.slice.g r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.b(r101, r102, null);
    }
}
