package com.obric.matrix.sdk.push;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: compiled from: PushApi.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f33768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f33769b = null;

    /* JADX INFO: compiled from: PushApi.kt */
    static final class a extends p implements d.h.a.a<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33770a = null;

        static {
            f33770a = new a();
        }

        a() {
            super(0);
        }

        public final e a() {
            return new e();
        }

        @Override // d.h.a.a
        public /* synthetic */ e invoke() {
            return a();
        }
    }

    private c() {
    }

    static {
        f33768a = new c();
        f33769b = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(a.f33770a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final e a() {
        return (e) ZeusTransformUtils.preCheckCast(f33769b.b(), e.class, "com.obric.aiagent.plugin");
    }

    public static final void a(Context r2, d r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r3, "pushConfiguration");
        o.e(r6, "registerCallback");
        f33768a.a().a(r5, r3, r6);
    }
}
