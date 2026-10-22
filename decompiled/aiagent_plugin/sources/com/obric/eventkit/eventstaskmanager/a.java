package com.obric.eventkit.eventstaskmanager;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f33212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f33213c;

    static {
        f33211a = new a();
    }

    private a() {
    }

    public final String a() {
        String r0 = f33213c;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("packageName");
        return null;
    }

    public final void a(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "<set-?>");
        f33212b = r1;
    }

    public final void a(String r1) {
        o.e(r1, "<set-?>");
        f33213c = r1;
    }

    public final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        a(r4);
        String r5 = r4.getPackageName();
        o.c(r5, "context.packageName");
        a(r5);
    }

    public final Context getContext() {
        Context r0 = f33212b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("context");
        return null;
    }
}
