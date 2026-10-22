package com.obric.aiagent.assistant_card.provider_core.a;

import android.content.Context;
import android.content.res.Configuration;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ContextEx.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final boolean a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "<this>");
        if ((ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Context b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        Configuration r0 = new Configuration(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getConfiguration());
        r0.uiMode = (r0.uiMode & (-49)) | 32;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.createConfigurationContext(r0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "createConfigurationContext(...)");
        return r5;
    }

    public static final Context c(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        Configuration r0 = new Configuration(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin").getConfiguration());
        r0.uiMode = (r0.uiMode & (-49)) | 16;
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.createConfigurationContext(r0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r5, "createConfigurationContext(...)");
        return r5;
    }
}
