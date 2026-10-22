package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends b {

    public static final class a {
    }

    static {
    }

    public m(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Map<String, Object> r102 = r100.getParams();
        if (r102 == null) goto L5;
        Object r103 = r102.get("type");
    L7:
        if ((r103 instanceof String) == true) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r104 != null) goto L12;
        return false;
    L12:
        Map<String, Object> r105 = r100.getParams();
        if (r105 == null) goto L15;
        Object r106 = r105.get("link");
    L17:
        if ((r106 instanceof String) == true) goto L19;
        r106 = null;
    L19:
        String r107 = (String) r106;
        if (r107 != null) goto L23;
        return false;
    L23:
        if (StringsKt.startsWith$default(r107, "$", false, 2, null) == false) goto L27;
        r107 = this.f173398c.s(r107);
    L27:
        if (r104.hashCode() == (-313440398)) goto L30;
    L34:
        return false;
    L30:
        if (r104.equals("feedback_popup") == false) goto L34;
        if (r107 != null) goto L33;
        return false;
    L33:
        this.f173398c.g(r107, r104);
        goto L34
    L15:
        r106 = null;
        goto L17
    L5:
        r103 = null;
        goto L7
    }
}
