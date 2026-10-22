package com.obric.common.oea.foundation.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OEAExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "$this$getScreenWidth");
        Resources r4 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin");
        o.c(r4, "resources");
        DisplayMetrics r5 = r4.getDisplayMetrics();
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.widthPixels;
    }
}
