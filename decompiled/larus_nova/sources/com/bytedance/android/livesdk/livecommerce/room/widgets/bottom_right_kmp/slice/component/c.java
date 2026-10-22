package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right_kmp.slice.component;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.ECAtmosphere;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.livesdk.livecommerce.iron.ui.atmosphere.ECAtmosphereView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends com.bytedance.android.ecom.arch.slice.render.elements.b<ECAtmosphereView> {

    public static final class a {
    }

    static {
    }

    public c(SlcTemplateContext r100) {
        Intrinsics.checkNotNullParameter(r100, "templateContext");
        super(r100);
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager
    public final void H0(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Object r101 = r100.get("hot_sale_model");
        if (r101 == null) goto L16;
        ECHotAtmosphere r102 = (ECHotAtmosphere) u0.b(u0.d(r101), ECHotAtmosphere.class);
        if (r102 == null) goto L12;
        ECAtmosphereView r103 = k1();
        if (r103 == null) goto L9;
        r103.setVisibility(0);
    L9:
        ECAtmosphereView r104 = k1();
        if (r104 == null) goto L34;
        r104.b(r102);
        return;
    L34:
        return;
    L12:
        ECAtmosphereView r105 = k1();
        if (r105 == null) goto L36;
        r105.setVisibility(8);
        return;
    L36:
        return;
    L16:
        Object r106 = r100.get("goods_atmosphere");
        if (r106 == null) goto L30;
        ECAtmosphere r107 = (ECAtmosphere) u0.b(u0.d(r106), ECAtmosphere.class);
        if (r107 == null) goto L26;
        ECAtmosphereView r108 = k1();
        if (r108 == null) goto L23;
        r108.setVisibility(0);
    L23:
        ECAtmosphereView r109 = k1();
        if (r109 == null) goto L37;
        r109.a(r107);
        return;
    L37:
        return;
    L26:
        ECAtmosphereView r110 = k1();
        if (r110 == null) goto L39;
        r110.setVisibility(8);
        return;
    L39:
        return;
    L30:
        ECAtmosphereView r111 = k1();
        if (r111 == null) goto L40;
        r111.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.elements.b
    public final View n1(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ECAtmosphereView(r100, null, 6, 0);
    }
}
