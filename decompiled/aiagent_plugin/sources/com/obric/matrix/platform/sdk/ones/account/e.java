package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import java.util.Objects;

/* JADX INFO: compiled from: AppGlobals.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f33619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final d.f f33620b = null;

    /* JADX INFO: compiled from: AppGlobals.kt */
    static final class a extends p implements d.h.a.a<Application> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33621a = null;

        static {
            f33621a = new a();
        }

        a() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Application invoke() {
            return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
        }

        public final Application a() {
            Object r4 = ZeusTransformUtils.forName("android.app.ActivityThread", "com.obric.aiagent.plugin").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            Objects.requireNonNull(r4, "null cannot be cast to non-null type android.app.Application");
            return (Application) ZeusTransformUtils.preCheckCast(r4, Application.class, "com.obric.aiagent.plugin");
        }
    }

    private e() {
    }

    static {
        f33619a = new e();
        f33620b = d.g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f33621a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final Application c() {
        return (Application) ZeusTransformUtils.preCheckCast(f33620b.b(), Application.class, "com.obric.aiagent.plugin");
    }

    public final Application a() {
        return (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
    }

    public final Context b() {
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "getApplication().applicationContext");
        return r2;
    }
}
