package com.bytedance.android.livesdk.dslservice.slice;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import com.bytedance.android.livesdk.dslservice.util.o;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class SliceViewUtilsKt {
    public static final void b(r r100, String r101, Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r100, "$this$dispatchAction");
        Intrinsics.checkNotNullParameter(r101, "name");
        BaseSlcViewManager<?> r102 = r100.f50700b.f50218f;
        Map<String, ? extends Object> r103 = null;
        if (r102 == null) goto L5;
        SlcElement r104 = r102.f50270e;
    L6:
        if (r104 == null) goto L20;
        Map<String, IAction> r105 = r104.getAction();
        if (r105 == null) goto L21;
        IAction r106 = r105.get(r101);
        if (r106 == null) goto L22;
        Map<String, ? extends Object> r107 = r100.f50700b.f50222j;
        if ((r107 instanceof HashMap) == false) goto L15;
        r103 = r107;
    L15:
        HashMap r108 = (HashMap) r103;
        if (r108 == null) goto L18;
        r108.put("resp", r110);
    L18:
        SlcTemplateContext.e(r100.f50700b, r106, r100.f50701c, null, null, 16);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void a(r r100, String r101, Map<String, ? extends Object> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$bindDataLive");
        final long r104 = System.currentTimeMillis();
        if (r102 != null) goto L7;
        if (r101 == null) goto L6;
        r102 = com.bytedance.android.livesdk.dsl.util.c.g(r101);
        goto L7
    L6:
        r102 = null;
    L7:
        if (r102 != null) goto L10;
        r102 = MapsKt.emptyMap();
    L10:
        if (r103 != 1) goto L23;
        Map<String, ? extends Object> r105 = r100.f50700b.f50222j;
        if (r105 == null) goto L17;
        Object r106 = r105.get("data");
        if (r106 == null) goto L17;
        Map<String, ? extends Object> r107 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r106);
    L18:
        if (r107 == null) goto L20;
        r107.putAll(r102);
    L20:
        if (r107 != null) goto L22;
        r102 = MapsKt.emptyMap();
        goto L23
    L22:
        r102 = r107;
    L17:
        r107 = null;
    L23:
        Map<String, ? extends Object> r108 = JsonTemplate.a.b(JsonTemplate.f51054c, r102);
        r.a r109 = r.f50698d;
        r100.a(r108, null);
        o.f123008f.d(new SliceViewUtilsKt$bindDataLive$1(r104));
    }
}
