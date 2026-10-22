package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedRequestAction extends b {
    public DeepFeedRequestAction(w r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        super(r100);
    }

    @Override // com.bytedance.android.shopping.deepfeed.slice.action.a
    public final boolean d(final IAction r100, final View r101) {
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
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        int r106 = r105.hashCode();
        if (r106 == 17970594) goto L29;
        if (r106 == 949444906) goto L18;
        return false;
    L18:
        if (r105.equals(ShareChannel.COLLECT) == false) goto L32;
        w r107 = this.f173398c;
        Map<String, Object> r108 = r100.getParams();
        if (r108 == null) goto L22;
        Object r109 = r108.get("is_collected");
    L24:
        if ((r109 instanceof Boolean) == false) goto L27;
        r103 = r109;
    L27:
        r107.m((Boolean) r103, r101);
        return false;
    L22:
        r109 = null;
        goto L24
    L32:
        return false;
    L29:
        if (r105.equals("mixCoupon") == false) goto L35;
        this.f173398c.x(new DeepFeedRequestAction$onHandleAction$1(this, r100, r101));
        return true;
    L35:
        return false;
    L5:
        r104 = null;
        goto L7
    }
}
