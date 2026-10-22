package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f extends b {
    public f(w r100) {
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
        Object r104 = r102.get("main_area");
    L7:
        if ((r104 instanceof String) == true) goto L9;
        r104 = null;
    L9:
        String r105 = (String) r104;
        if (r105 != null) goto L13;
        return true;
    L13:
        Map<String, Object> r106 = r100.getParams();
        if (r106 == null) goto L16;
        Object r107 = r106.get("mixed_media");
    L18:
        if ((r107 instanceof Boolean) == false) goto L21;
        r103 = r107;
    L21:
        Boolean r108 = (Boolean) r103;
        if (r108 == null) goto L24;
        boolean r109 = r108.booleanValue();
    L25:
        this.f173398c.u(r105, r109);
        return false;
    L24:
        r109 = false;
        goto L25
    L16:
        r107 = null;
        goto L18
    L5:
        r104 = null;
        goto L7
    }
}
