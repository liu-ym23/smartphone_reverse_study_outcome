package com.obric.autogui.session.d;

import android.content.Context;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: FirstRoundFrameworkBlackListAsyncResource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.obric.autogui.session.d.a<x> {
    private static final String TAG = "1stRoundBLAsyncRes";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f30894b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.obric.autogui.session.a f30895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c<x> f30896d;

    /* JADX INFO: compiled from: FirstRoundFrameworkBlackListAsyncResource.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: FirstRoundFrameworkBlackListAsyncResource.kt */
    /* synthetic */ class b extends d.h.b.l implements d.h.a.b<d.c.d<? super x>, Object> {
        b(Object r8) {
            super(1, r8, f.class, "syncFrameworkBlackList", "syncFrameworkBlackList(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object a(d.c.d<? super x> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return f.a((f) ZeusTransformUtils.preCheckCast(this.receiver, f.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f30894b = new a(null);
    }

    public static /* synthetic */ x lambda$0vGnXeHtyvzqHp5wn2ZUkqJYcV4() {
        return f();
    }

    public static /* synthetic */ boolean lambda$rGv0aefG2vr1yROLb6YpWEt7lfY() {
        return g();
    }

    public static final /* synthetic */ Object a(f r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public f(com.obric.autogui.session.a r11) {
        o.e(r11, SensitiveType.SESSION);
        super(null, 1, null);
        this.f30895c = r11;
        this.f30896d = new c(TAG, (d.h.a.b) ZeusTransformUtils.preCheckCast((d.m.e) ZeusTransformUtils.preCheckCast(new b(this), d.m.e.class, "com.obric.aiagent.plugin"), d.h.a.b.class, "com.obric.aiagent.plugin"), $$Lambda$f$0vGnXeHtyvzqHp5wn2ZUkqJYcV4.INSTANCE, $$Lambda$f$rGv0aefG2vr1yROLb6YpWEt7lfY.INSTANCE, null, 16, null);
    }

    @Override // com.obric.autogui.session.d.a
    public c<x> a() {
        return this.f30896d;
    }

    private static final boolean g() {
        return com.obric.autogui.common.a.d.f28974a.q();
    }

    private static final x f() {
        return x.f38692a;
    }

    private final Object b(d.c.d<? super x> r4) {
        d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r0 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f30895c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "getApplicationContext(...)");
        Object r6 = r0.a(r3, true, r5);
        if (r6 != d.c.a.b.a()) goto L6;
        return r6;
    L6:
        return x.f38692a;
    }
}
