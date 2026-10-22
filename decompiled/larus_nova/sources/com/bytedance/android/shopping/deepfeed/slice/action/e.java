package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends b {
    public e(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        List<IAction> r102 = r100.getActions();
        List<IAction> r103 = r102;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L10:
        if (r105 == true) goto L27;
        v r106 = this.f173396a;
        if (r106 == null) goto L14;
        r106.dispose();
    L14:
        this.f173396a = null;
        Iterator<T> r107 = r102.iterator();
        e r108 = this;
    L16:
        if (r107.hasNext() == false) goto L26;
        IAction r109 = (IAction) r107.next();
        String r110 = r109.getType();
        v r111 = d.a(r110, this.f173398c);
        if (r111 != null) goto L20;
        r111 = this.f173398c.r(r110);
    L20:
        if (r111 == null) goto L16;
        Map<String, Object> r112 = r109.getParams();
        if (r112 == null) goto L25;
        r111.b(r112);
    L25:
        r108.a(r111);
        r108 = r111;
        goto L16
    L26:
        return false;
    L27:
        Map<String, Object> r113 = r100.getParams();
        if (r113 == null) goto L30;
        Object r114 = r113.get(SlcCommonAction.KEY_ACTIONS);
    L32:
        if ((r114 instanceof List) == true) goto L34;
        r114 = null;
    L34:
        List r115 = (List) r114;
        List r116 = r115;
        if (r116 != null) goto L37;
    L40:
        boolean r117 = true;
    L41:
        if (r117 == false) goto L58;
        if (r113 == null) goto L57;
        Object r118 = r113.get("params");
        if (r118 == null) goto L57;
        if ((r118 instanceof Map) == true) goto L49;
        r118 = null;
    L49:
        Map r119 = (Map) r118;
        if (r119 == null) goto L52;
        Object r120 = r119.get(SlcCommonAction.KEY_ACTIONS);
    L54:
        if ((r120 instanceof List) == true) goto L56;
        r120 = null;
    L56:
        r115 = (List) r120;
        goto L58
    L52:
        r120 = null;
    L57:
        r115 = null;
    L58:
        List r121 = r115;
        if (r121 != null) goto L61;
    L64:
        if (r104 == false) goto L66;
        return false;
    L66:
        v r122 = this.f173396a;
        if (r122 == null) goto L69;
        r122.dispose();
    L69:
        this.f173396a = null;
        Iterator r123 = r115.iterator();
        e r124 = this;
    L71:
        if (r123.hasNext() == false) goto L99;
        Map r125 = (Map) r123.next();
        Object r126 = r125.get("disable");
        if ((r126 instanceof Boolean) == true) goto L75;
        r126 = null;
    L75:
        Boolean r127 = (Boolean) r126;
        if (r127 == null) goto L78;
        boolean r128 = r127.booleanValue();
    L79:
        if (r128 == true) goto L71;
        Object r129 = r125.get("type");
        if ((r129 instanceof String) == true) goto L84;
        r129 = null;
    L84:
        String r130 = (String) r129;
        if (r130 == null) goto L71;
        v r131 = d.a(r130, this.f173398c);
        if (r131 != null) goto L90;
        r131 = this.f173398c.r(r130);
    L90:
        if (r131 == null) goto L71;
        Object r132 = r125.get(SlcCommonAction.KEY_PARAMS);
        if ((r132 instanceof Map) == true) goto L95;
        r132 = null;
    L95:
        Map r133 = (Map) r132;
        if (r133 == null) goto L98;
        r131.b(r133);
    L98:
        r124.a(r131);
        r124 = r131;
        goto L71
    L78:
        r128 = false;
        goto L79
    L99:
        return false;
    L61:
        if (r121.isEmpty() == true) goto L64;
        r104 = false;
        goto L64
    L37:
        if (r116.isEmpty() == true) goto L40;
        r117 = false;
        goto L41
    L30:
        r114 = null;
        goto L32
    L5:
        if (r103.isEmpty() == true) goto L8;
        r105 = false;
        goto L10
    }
}
