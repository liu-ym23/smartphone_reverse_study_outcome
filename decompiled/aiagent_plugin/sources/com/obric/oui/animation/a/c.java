package com.obric.oui.animation.a;

import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ViewPropertySpringAnimatorExt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final <T extends View> b<T> a(T r5) {
        o.e(r5, "<this>");
        Object r0 = r5.getTag(ZeusTransformUtils.mapRes(R.id.view_property_spring_animator_key, DbHelper.COL_ID, "view_property_spring_animator_key"));
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L5;
        b<T> r1 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L9;
        b<T> r2 = new b(r5);
        r5.setTag(ZeusTransformUtils.mapRes(R.id.view_property_spring_animator_key, DbHelper.COL_ID, "view_property_spring_animator_key"), r2);
        return r2;
    L9:
        return r1;
    L5:
        r1 = null;
        goto L6
    }
}
