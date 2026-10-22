package com.bytedance.android.ecom.arch.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.BaseSlice;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.template.JsonTemplate;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {
    public static final SlcContext d(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$slcContext");
        Object r101 = r100.f49982c.get("slc-context");
        if ((r101 instanceof SlcContext) == true) goto L6;
        r101 = null;
    L6:
        return (SlcContext) r101;
    }

    public static final com.bytedance.android.ecom.arch.slice.g e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$slice");
        Object r101 = r100.f49982c.get("slice-data");
        if ((r101 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L6;
        r101 = null;
    L6:
        return (com.bytedance.android.ecom.arch.slice.g) r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map<java.lang.String, java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static final Map<String, Object> f(com.bytedance.android.ecom.arch.slice.g r100) {
        if (r100 == null) goto L5;
        Map<String, Object> r101 = r100.getData();
        ?? r102 = r101;
        if (r101 == null) goto L5;
    L6:
        String r103 = null;
        if (r100 == null) goto L11;
        Map<String, Object> r104 = r100.getData();
        if (r104 == null) goto L11;
        Object r105 = r104.get(BaseSlice.KEY_SLICE_ID);
    L12:
        if (r105 != null) goto L31;
        if (r100 == null) goto L15;
        String r106 = r100.getSliceId();
    L16:
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L31;
        r102 = new HashMap();
        if (r100 == null) goto L26;
        r103 = r100.getSliceId();
    L26:
        r102.put(BaseSlice.KEY_SLICE_ID, r103);
        if (r100 == null) goto L31;
        Map<String, Object> r108 = r100.getData();
        if (r108 == null) goto L31;
        r102.putAll(r108);
        goto L31
    L18:
        if (r106.length() == 0) goto L21;
        r107 = false;
        goto L22
    L15:
        r106 = null;
    L31:
        return r102;
    L11:
        r105 = null;
    L5:
        r102 = new HashMap();
        goto L6
    }

    public static final Map<String, Object> a(c r100, com.bytedance.android.ecom.arch.slice.g r101) {
        HashMap r102 = new HashMap();
        Map<String, Object> r103 = f(r101);
        String r104 = null;
        if (r100 == null) goto L5;
        com.bytedance.android.ecom.arch.slice.g r105 = e(r100);
    L6:
        if (r100 == null) goto L8;
        View r106 = r100.f49980a;
    L9:
        if (r106 == null) goto L11;
        Object r107 = r106.getTag(R.id.slc_view_manager);
    L13:
        if ((r107 instanceof com.bytedance.android.ecom.arch.slice.render.elements.g) == true) goto L15;
        r107 = null;
    L15:
        com.bytedance.android.ecom.arch.slice.render.elements.g r108 = (com.bytedance.android.ecom.arch.slice.render.elements.g) r107;
        if (r108 == null) goto L18;
        Map<String, Object> r109 = r108.l();
    L19:
        boolean r110 = true;
        if (r109 != null) goto L22;
    L25:
        boolean r111 = true;
    L26:
        if (r111 == false) goto L28;
        Map<String, Object> r112 = f(r105);
    L45:
        r102.putAll(r112);
        r102.put(PickerReporterConstants.KEY.TARGET, r103);
        return r102;
    L28:
        HashMap r113 = new HashMap();
        r113.putAll(r109);
        if (r105 == null) goto L31;
        String r114 = r105.getSliceId();
    L32:
        if (r114 != null) goto L34;
    L37:
        if (r110 == true) goto L44;
        Object r115 = r109.get("data");
        if ((r115 instanceof Map) == false) goto L44;
        HashMap r116 = new HashMap((Map) r115);
        if (r105 == null) goto L43;
        r104 = r105.getSliceId();
    L43:
        r116.put(BaseSlice.KEY_SLICE_ID, r104);
        r113.put("data", r116);
    L44:
        r112 = r113;
        goto L45
    L34:
        if (r114.length() == 0) goto L37;
        r110 = false;
        goto L37
    L31:
        r114 = null;
        goto L32
    L22:
        if (r109.isEmpty() == true) goto L25;
        r111 = false;
        goto L26
    L18:
        r109 = null;
        goto L19
    L11:
        r107 = null;
        goto L13
    L8:
        r106 = null;
        goto L9
    L5:
        r105 = null;
        goto L6
    }

    public static final void g(c r100, SlcContext r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setSlcContext");
        Intrinsics.checkNotNullParameter(r101, "slcContext");
        r100.f49982c.put("slc-context", r101);
    }

    public static final void h(c r100, com.bytedance.android.ecom.arch.slice.g r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setSlice");
        r100.f49982c.put("slice-data", r101);
    }

    public static Object b(c r100, String r101, com.bytedance.android.ecom.arch.slice.g r102) {
        Intrinsics.checkNotNullParameter(r101, "expr");
        if (r100 == null) goto L10;
        SlcContext r103 = d(r100);
        if (r103 == null) goto L11;
        SlcExprContext r104 = r103.f50187m0;
        if (r104 != null) goto L9;
        return null;
    L9:
        return r104.a(r101, a(r100, r102), null);
    L11:
        return null;
    L10:
        return null;
    }

    public static Map c(c r100, Map r101, com.bytedance.android.ecom.arch.slice.g r102, int r103, int r110) {
        if ((r110 & 8) == 0) goto L5;
        int r104 = 0;
    L6:
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        Object r105 = null;
        if (r100 == null) goto L18;
        SlcContext r111 = d(r100);
        if (r111 == null) goto L19;
        SlcExprContext r112 = r111.f50187m0;
        if (r112 == null) goto L20;
        Object r106 = new JsonTemplate(r101, r112).a(r101, a(r100, r102), r104, 0, null);
        if ((r106 instanceof Map) == false) goto L17;
        r105 = r106;
    L17:
        return (Map) r105;
    L20:
        return null;
    L19:
        return null;
    L18:
        return null;
    L5:
        r104 = r103;
        goto L6
    }
}
