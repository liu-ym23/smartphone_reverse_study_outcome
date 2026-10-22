package com.obric.oui.common.util;

import android.content.Context;
import android.util.TypedValue;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAttributes.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f34567a = null;

    static {
        f34567a = new b();
    }

    private b() {
    }

    public final TypedValue a(Context r2, int r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        TypedValue r4 = new TypedValue();
        if (r1.getTheme().resolveAttribute(r3, r4, true) == true) goto L7;
        return null;
    L7:
        return r4;
    }

    public final int a(Context r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        TypedValue r2 = a(r6, r4);
        if (r2 != null) goto L5;
    L8:
        float r7 = ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDimension(r5);
    L10:
        return (int) r7;
    L5:
        if (r2.type != 5) goto L8;
        r7 = r2.getDimension(ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDisplayMetrics());
        goto L10
    }
}
