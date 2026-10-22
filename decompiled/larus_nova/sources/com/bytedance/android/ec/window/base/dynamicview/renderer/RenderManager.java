package com.bytedance.android.ec.window.base.dynamicview.renderer;

import android.view.View;
import com.bytedance.android.ec.window.base.dynamicview.virtualview.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import so.d;
import to.c;
import to.e;

/* JADX INFO: loaded from: classes44.dex */
public abstract class RenderManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f49261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.ec.window.base.dynamicview.renderer.a<?, ?>> f49262b;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RenderManager(List<? extends com.bytedance.android.ec.window.base.dynamicview.renderer.a<?, ?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "enabledRenderers");
        this.f49262b = r100;
        this.f49261a = LazyKt.lazy(new RenderManager$transformers$2(this));
    }

    public final void b(d r100, to.d r110) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        Intrinsics.checkNotNullParameter(r110, "data");
        Map<e, ? extends c<? extends to.a>> r101 = r110.f546889b;
        if (r101 == null) goto L19;
        Map<e, String> r102 = r110.f546888a;
        if (r102 != null) goto L8;
    L16:
        boolean r103 = true;
    L17:
        if (r103 == false) goto L19;
    L50:
        if (r101 == null) goto L52;
        a(r101, r100, r110);
        return;
    L52:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == false) goto L55;
        return;
    L55:
        return;
    L8:
        if (r101.size() < r102.size()) goto L15;
        Iterator<Map.Entry<e, String>> r104 = r102.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        if (r101.containsKey(r104.next().getKey()) == true) goto L12;
    L15:
        r103 = false;
    L19:
        Map<e, String> r105 = r110.f546888a;
        if (r105 != null) goto L22;
    L49:
        r101 = null;
        goto L50
    L22:
        if (r105.isEmpty() == true) goto L49;
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator<Map.Entry<e, String>> r107 = r105.entrySet().iterator();
    L26:
        if (r107.hasNext() == false) goto L48;
        Map.Entry<e, String> r108 = r107.next();
        e r109 = r108.getKey();
        String r111 = r108.getValue();
        View r112 = r100.a(r109);
        if (r112 == null) goto L30;
    L33:
        if (r112 == null) goto L26;
        k.f49316i.getClass();
        Object r113 = r112.getTag(k.f49315h);
        if ((r113 instanceof String) == true) goto L38;
        r113 = null;
    L38:
        String r114 = (String) r113;
        com.bytedance.android.ec.window.base.dynamicview.common.a.a(r114, "viewType");
        if (r114 == null) goto L26;
        Object r115 = ((Map) this.f49261a.getValue()).get(r114);
        com.bytedance.android.ec.window.base.dynamicview.common.a.a(r115, "transformer");
        KFunction r116 = (KFunction) r115;
        if (r116 == null) goto L44;
        Object r117 = ((Function1) r116).invoke(r111);
        com.bytedance.android.ec.window.base.dynamicview.common.a.a(r117, "generated vo");
        to.a r118 = (to.a) r117;
    L45:
        if (r118 == null) goto L26;
        r106.put(r109, new c(r118.getClass(), r114, r118));
        goto L26
    L44:
        r118 = so.a.f542691d.d(r111);
        goto L45
    L30:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L33;
        Objects.toString(r109);
        goto L33
    L48:
        r110.f546889b = r106;
        r101 = r106;
        goto L50
    }

    public final void c(d r100, to.d r101) {
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        Intrinsics.checkNotNullParameter(r101, "data");
        Map<e, ? extends c<? extends to.a>> r102 = r101.f546889b;
        if (r102 != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<e, ? extends c<? extends to.a>>> r103 = r102.entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L30;
        Map.Entry<e, ? extends c<? extends to.a>> r104 = r103.next();
        e r105 = r104.getKey();
        c<? extends to.a> r106 = r104.getValue();
        Iterator<T> r107 = this.f49262b.iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.window.base.dynamicview.renderer.a) r108).f49265c, r106.f546885b) == false) goto L10;
    L15:
        com.bytedance.android.ec.window.base.dynamicview.renderer.a r109 = (com.bytedance.android.ec.window.base.dynamicview.renderer.a) r108;
        if (r109 == null) goto L7;
        Intrinsics.checkNotNullParameter(r105, "uniqueId");
        Intrinsics.checkNotNullParameter(r100, "viewProvider");
        View r110 = r100.a(r105);
        if (r110 == null) goto L20;
        if (r110.getClass().isAssignableFrom(r109.f49263a) == false) goto L26;
        r109.c(r110);
        goto L7
    L26:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L7;
        Objects.toString(r109.f49263a);
        r110.getClass().toString();
        goto L7
    L20:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L7;
        Objects.toString(r105);
        goto L7
    L14:
        r108 = null;
        goto L15
    }

    public final void a(Map r100, d r110, b r111) {
        Iterator r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L80;
        Map.Entry r102 = (Map.Entry) r101.next();
        e r103 = (e) r102.getKey();
        c r104 = (c) r102.getValue();
        Iterator<T> r105 = this.f49262b.iterator();
    L6:
        View r106 = null;
        if (r105.hasNext() == false) goto L11;
        Object r107 = r105.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.window.base.dynamicview.renderer.a) r107).f49265c, r104.f546885b) == false) goto L6;
    L12:
        com.bytedance.android.ec.window.base.dynamicview.renderer.a r108 = (com.bytedance.android.ec.window.base.dynamicview.renderer.a) r107;
        if (r108 != null) goto L19;
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L22;
        String r109 = r104.f546885b;
    L22:
        if (r108 != null) goto L24;
        r108 = so.a.f542691d;
    L24:
        r108.getClass();
        Intrinsics.checkNotNullParameter(r103, "uniqueId");
        Intrinsics.checkNotNullParameter(r110, "viewProvider");
        Intrinsics.checkNotNullParameter(r111, "voProvider");
        View r112 = r110.a(r103);
        if ((r112 instanceof View) == false) goto L28;
        r106 = r112;
    L28:
        if (r106 == null) goto L30;
        if (r108.f49263a.isAssignableFrom(r106.getClass()) == false) goto L36;
        c r113 = r111.a(r108.f49264b, r103);
        if (r113 == null) goto L42;
        VO r114 = r113.f546886c;
        String r115 = r114.b();
        if (r115 == null) goto L59;
        int r116 = r115.hashCode();
        if (r116 == 3178655) goto L57;
        if (r116 != 466743410) goto L59;
        if (r115.equals("visible") == false) goto L59;
        r106.setVisibility(0);
        goto L59
    L57:
        if (r115.equals("gone") == false) goto L59;
        r106.setVisibility(8);
    L59:
        to.a.C7747a r117 = r114.a();
        if (r117 == null) goto L79;
        Float r118 = r117.b();
        if (r118 == null) goto L65;
        int r119 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r120 = com.bytedance.android.ec.hybrid.list.util.c.d(r118);
    L66:
        Float r121 = r117.d();
        if (r121 == null) goto L69;
        int r122 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r123 = com.bytedance.android.ec.hybrid.list.util.c.d(r121);
    L70:
        Float r124 = r117.c();
        if (r124 == null) goto L73;
        int r125 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r126 = com.bytedance.android.ec.hybrid.list.util.c.d(r124);
    L74:
        Float r127 = r117.a();
        if (r127 == null) goto L77;
        int r128 = com.bytedance.android.ec.hybrid.list.util.c.f47296a;
        int r129 = com.bytedance.android.ec.hybrid.list.util.c.d(r127);
    L78:
        r106.setPadding(r120, r123, r126, r129);
        goto L79
    L77:
        r129 = r106.getPaddingBottom();
        goto L78
    L73:
        r126 = r106.getPaddingRight();
        goto L74
    L69:
        r123 = r106.getPaddingTop();
        goto L70
    L65:
        r120 = r106.getPaddingLeft();
    L79:
        r108.b(r106, r113.f546886c);
        goto L4
    L42:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L4;
        Objects.toString(r103);
        r111.toString();
        goto L4
    L36:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L4;
        Objects.toString(r108.f49263a);
        r106.getClass().toString();
        goto L4
    L30:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L4;
        Objects.toString(r103);
        goto L4
    L19:
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L22;
        r108.toString();
        Objects.toString(r104.f546886c);
        goto L22
    L11:
        r107 = null;
        goto L12
    }
}
