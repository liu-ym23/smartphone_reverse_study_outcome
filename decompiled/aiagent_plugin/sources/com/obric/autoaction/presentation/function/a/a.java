package com.obric.autoaction.presentation.function.a;

import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutoResumeJobsHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24922a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static c f24923b;

    static {
        f24922a = new a();
    }

    private a() {
    }

    public final void a(Class<? extends c> r3, boolean r4) {
        o.e(r3, "job");
        boolean r1 = true;
        if (f24923b == null) goto L8;
        if (r4 == true) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L14;
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(this), "new job to run: " + r3.getClass());
        c r2 = f24923b;
        if (r2 == null) goto L12;
        r2.c();
    L12:
        c r5 = (c) ZeusTransformUtils.preCheckCast(r3.newInstance(), c.class, "com.obric.aiagent.plugin");
        f24923b = r5;
        r5.b();
        return;
    }

    public final <T extends c> void a(Class<T> r2) {
        o.e(r2, "jobType");
        c r1 = f24923b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (o.a(r1.getClass(), r2) == false) goto L9;
        r1.c();
        f24923b = null;
        return;
    }

    public final <T extends c> void b(Class<T> r1) {
        o.e(r1, "jobClass");
        c r0 = f24923b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (o.a(r0.getClass(), r1) == false) goto L9;
        f24923b = null;
        return;
    }

    public final <T extends c> T c(Class<T> r4) {
        o.e(r4, "jobType");
        T r3 = (T) f24923b;
        if (r3 != null) goto L5;
        return null;
    L5:
        if (o.a(r3.getClass(), r4) == false) goto L7;
        return r3;
    L7:
        Loog.INSTANCE.w("AutoResumeJobsHelper", "current job is not the same type as the given one(" + r4 + ") to (" + r3.getClass() + ')');
        return null;
    }
}
