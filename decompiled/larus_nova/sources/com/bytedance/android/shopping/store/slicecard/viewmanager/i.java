package com.bytedance.android.shopping.store.slicecard.viewmanager;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECTagListView> {
    public float H3;
    public Map<String, ? extends Object> I3;

    public static final class a {
    }

    static {
    }

    public final gk3.a o1() {
        SlcTemplateContext r100 = this.f50260a;
        String r101 = r100.f50219g;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Object r102 = r100.o(r101);
        if ((r102 instanceof gk3.a) == true) goto L9;
        r102 = null;
    L9:
        return (gk3.a) r102;
    }

    public i(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r110) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        if (k1() != null) goto L5;
        return;
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r100 = r110.entrySet().iterator();
        Float r101 = null;
        Map<String, ? extends Object> r102 = null;
    L7:
        if (r100.hasNext() == false) goto L19;
        Map.Entry<String, ? extends Object> r103 = r100.next();
        String r104 = r103.getKey();
        if (r104.hashCode() != (-764061149)) goto L7;
        if (r104.equals("tag_list") == false) goto L7;
        Object r105 = r103.getValue();
        if (r105 == null) goto L17;
        r102 = (Map) r105;
        goto L7
    L17:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
    L19:
        if ((!Intrinsics.areEqual(r102, this.I3)) == false) goto L52;
        this.I3 = r102;
        ECTagListDTO r106 = new ECTagListDTO(r102);
        gk3.a r107 = o1();
        if (r107 == null) goto L23;
        com.bytedance.android.ec.store.view.j r108 = r107.f(r106, k1());
    L24:
        ECTagListView r109 = k1();
        if (r109 == null) goto L43;
        if (r108 == null) goto L28;
        String r111 = r108.f48933a;
    L29:
        r106.setScene(r111);
        Unit r112 = Unit.INSTANCE;
        if (r108 == null) goto L32;
        Integer r113 = r108.f48934b;
    L33:
        if (r108 == null) goto L35;
        Map<String, String> r114 = r108.f48935c;
    L36:
        if (r108 == null) goto L38;
        Function0<String> r115 = r108.f48936d;
    L39:
        if (r108 == null) goto L41;
        xm.c r116 = r108.f48937e;
    L42:
        ECTagListView.c(r109, r106, r113, r114, r115, r116, null, 32);
        goto L43
    L41:
        r116 = null;
        goto L42
    L38:
        r115 = null;
        goto L39
    L35:
        r114 = null;
        goto L36
    L32:
        r113 = null;
        goto L33
    L28:
        r111 = null;
    L43:
        gk3.a r117 = o1();
        if (r117 == null) goto L46;
        r117.e(k1(), r106);
    L46:
        ECTagListView r118 = k1();
        if (r118 == null) goto L49;
        r118.k(this.H3);
    L49:
        ECTagListView r119 = k1();
        if (r119 == null) goto L52;
        r119.post(new j(this));
        goto L52
    L23:
        r108 = null;
    L52:
        Object r120 = r110.get("color_animation_percent");
        if (r120 == null) goto L55;
        r101 = com.bytedance.android.ecom.arch.slice.render.util.b.e(r120);
    L55:
        if (r101 != null) goto L57;
        return;
    L57:
        if ((!Intrinsics.areEqual(r101, this.H3)) == false) goto L71;
        dm.a.a("ShopTagListViewManager").a("updateColorPercent: " + r101);
        this.H3 = r101.floatValue();
        ECTagListView r121 = k1();
        if (r121 == null) goto L72;
        r121.k(this.H3);
        return;
    L72:
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ECTagListView(r100, null, 6, 0);
    }
}
