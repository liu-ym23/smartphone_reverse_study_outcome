package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o extends b {
    public o(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Map<String, Object> r102 = r100.getParams();
        String r103 = "";
        if (r102 == null) goto L12;
        Object r104 = r102.get("tag");
        if ((r104 instanceof String) == true) goto L7;
        r104 = null;
    L7:
        String r105 = (String) r104;
        if (r105 == null) goto L12;
        r103 = r105;
    L12:
        if (r103.length() <= 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L17;
        this.f173398c.h(r101, r103);
    L17:
        return false;
    L14:
        r106 = false;
        goto L15
    }
}
