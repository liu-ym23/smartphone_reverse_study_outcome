package com.obric.oui.markdown;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.ad;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: OMarkdownStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static final String a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "$this$getColorString");
        int r5 = androidx.core.content.a.c(r4, r3);
        ad r6 = ad.f38485a;
        String r7 = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(r5 & 16777215)}, 1));
        o.c(r7, "java.lang.String.format(format, *args)");
        return r7;
    }
}
