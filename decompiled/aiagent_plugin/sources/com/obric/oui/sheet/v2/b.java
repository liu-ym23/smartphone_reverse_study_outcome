package com.obric.oui.sheet.v2;

import android.content.Context;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: OSheetBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final int a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        if (h.f34570a.a(r4) == true) goto L5;
        return r3;
    L5:
        return n.d(r3, g.a(r4, 480));
    }

    public static final float a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        if ((ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        return 0.5f;
    L8:
        return 0.16f;
    L5:
        r4 = false;
        goto L6
    }
}
