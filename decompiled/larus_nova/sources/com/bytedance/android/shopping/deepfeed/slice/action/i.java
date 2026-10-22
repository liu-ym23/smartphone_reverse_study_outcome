package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i extends b {
    public i(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Map<String, Object> r102 = r100.getParams();
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get("type");
    L7:
        if ((r104 instanceof String) == true) goto L9;
        r104 = null;
    L9:
        String r105 = (String) r104;
        String r106 = "";
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        Map<String, Object> r107 = r100.getParams();
        if (r107 == null) goto L15;
        Object r108 = r107.get(TemplateNodeType.REF);
    L17:
        if ((r108 instanceof String) == false) goto L20;
        r103 = r108;
    L20:
        String r109 = (String) r103;
        if (r109 == null) goto L24;
        r106 = r109;
    L24:
        vc3.b r110 = this.f173398c.q();
        int r111 = r105.hashCode();
        if (r111 != (-1903464234)) goto L27;
        String r112 = "show_over";
        if (r105.equals("show_over") == false) goto L40;
    L39:
        r105 = r112;
    L40:
        int r113 = ie3.b.f489470a;
        InFeedProductV2 r114 = r110.f554093a;
        ie3.b.a(r105, r106);
        return false;
    L27:
        if (r111 != 3529469) goto L29;
        r112 = "show";
        if (r105.equals("show") == false) goto L40;
    L29:
        if (r111 != 94750088) goto L40;
        if (r105.equals("click") == false) goto L40;
        r105 = "realtime_click";
        goto L40
    L15:
        r108 = null;
        goto L17
    L5:
        r104 = null;
        goto L7
    }
}
