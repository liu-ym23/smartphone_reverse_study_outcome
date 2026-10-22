package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends b {
    public r(w r100) {
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
        Object r104 = r102.get(JSEventListener.ACTION_TOGGLE_MUTE);
    L7:
        if ((r104 instanceof Boolean) == true) goto L9;
        r104 = null;
    L9:
        Boolean r105 = (Boolean) r104;
        Map<String, Object> r106 = r100.getParams();
        if (r106 == null) goto L12;
        Object r107 = r106.get("togglePlaying");
    L14:
        if ((r107 instanceof Boolean) == false) goto L17;
        r103 = r107;
    L17:
        Boolean r108 = (Boolean) r103;
        if (r105 == null) goto L20;
        this.f173398c.y(r105.booleanValue());
    L20:
        if (r108 == null) goto L24;
        this.f173398c.b(r108.booleanValue());
        return false;
    L24:
        return false;
    L12:
        r107 = null;
        goto L14
    L5:
        r104 = null;
        goto L7
    }
}
