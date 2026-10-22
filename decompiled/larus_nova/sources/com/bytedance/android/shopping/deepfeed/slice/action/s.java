package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f173402c;

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.v
    public final void c(DeepFeedSlcCardContainer r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
    }

    public s(y r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContainer");
        this.f173402c = r100;
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(IAction r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Map<String, Object> r102 = r100.getParams();
        Object r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.get("scope");
    L7:
        if ((r104 instanceof Map) == true) goto L9;
        r104 = null;
    L9:
        Map r105 = (Map) r104;
        if (r105 == null) goto L41;
        Object r106 = r105.get("start");
        if ((r106 instanceof Integer) == true) goto L14;
        r106 = null;
    L14:
        Integer r107 = (Integer) r106;
        if (r107 == null) goto L17;
        int r108 = r107.intValue();
    L18:
        Object r109 = r105.get("end");
        if ((r109 instanceof Integer) == true) goto L21;
        r109 = null;
    L21:
        Integer r110 = (Integer) r109;
        if (r110 == null) goto L24;
        int r111 = r110.intValue();
    L25:
        Map<String, Object> r112 = r100.getParams();
        if (r112 == null) goto L28;
        Object r113 = r112.get("params");
    L30:
        if ((r113 instanceof Map) == false) goto L33;
        r103 = r113;
    L33:
        Map<String, ? extends Object> r114 = (Map) r103;
        if (r114 != null) goto L36;
        r114 = MapsKt.emptyMap();
    L36:
        if (r108 != (-1)) goto L39;
        if (r111 != (-1)) goto L39;
        this.f173402c.C(r114);
        return false;
    L39:
        this.f173402c.p(r108, r111, r114);
        return false;
    L28:
        r113 = null;
        goto L30
    L24:
        r111 = -1;
        goto L25
    L17:
        r108 = -1;
        goto L18
    L41:
        if (r100.getParams() == null) goto L58;
        Map<String, Object> r115 = r100.getParams();
        if (r115 == null) goto L45;
        Object r116 = r115.get("params");
    L47:
        if ((r116 instanceof Map) == false) goto L50;
        r103 = r116;
    L50:
        Map<String, ? extends Object> r117 = (Map) r103;
        if (r117 != null) goto L53;
        r117 = MapsKt.emptyMap();
    L53:
        this.f173402c.C(r117);
        return false;
    L45:
        r116 = null;
        goto L47
    L58:
        return false;
    L5:
        r104 = null;
        goto L7
    }
}
