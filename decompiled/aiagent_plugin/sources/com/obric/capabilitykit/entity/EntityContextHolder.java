package com.obric.capabilitykit.entity;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityContextHolder {
    public static final EntityContextHolder INSTANCE = null;
    public static Context context;
    public static String packageName;

    static {
        INSTANCE = new EntityContextHolder();
    }

    private EntityContextHolder() {
    }

    public final Context getContext() {
        Context r0 = context;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("context");
        return null;
    }

    public final String getPackageName() {
        String r0 = packageName;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("packageName");
        return null;
    }

    public final void init(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        setContext(r4);
        String r5 = r4.getPackageName();
        o.c(r5, "context.packageName");
        setPackageName(r5);
    }

    public final void setContext(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "<set-?>");
        context = r1;
    }

    public final void setPackageName(String r1) {
        o.e(r1, "<set-?>");
        packageName = r1;
    }
}
