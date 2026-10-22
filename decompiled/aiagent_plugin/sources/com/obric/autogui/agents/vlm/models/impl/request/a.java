package com.obric.autogui.agents.vlm.models.impl.request;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.JsonObject;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
    public static final class C0702a {
        public static Object a(a r2, d.c.d<? super x> r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.agents.vlm.models.impl.request.b.a f28012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f28013c;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ b(com.obric.autogui.agents.vlm.models.impl.request.b.a r2, int r3, h r4) {
            com.obric.autogui.agents.vlm.models.impl.request.b.a r5 = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = null;
        L5:
            this(r5);
        }

        public b(com.obric.autogui.agents.vlm.models.impl.request.b.a r3) {
            this.f28012b = (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
        public boolean a() {
            return this.f28013c;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
        public Object a(d.c.d<? super d> r2) {
            d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException("awaitResponse() called on a failed request.");
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
        public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r3) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
            com.obric.autogui.agents.vlm.models.impl.request.b.a r2 = this.f28012b;
            if (r2 == null) goto L5;
            return r2;
        L5:
            return (com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(f.f28018a, com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0703a f28014a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f28015b;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
        public static final class C0703a {
            public /* synthetic */ C0703a(h r1) {
                this();
            }

            private C0703a() {
            }
        }

        static {
            f28014a = new C0703a(null);
        }

        public abstract com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r1);

        public abstract Object a(d.c.d<? super d> r1);

        public abstract boolean a();

        public c() {
        }

        public final void a(int r1) {
            this.f28015b = r1;
        }

        public final int b() {
            return this.f28015b;
        }
    }

    /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
    public interface d {
        com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r1);

        boolean a();

        JsonObject b();
    }

    /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
    public static final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final JsonObject f28016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f28017b;

        public e(JsonObject r2) {
            o.e(r2, "body");
            this.f28016a = r2;
            this.f28017b = true;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
        public boolean a() {
            return this.f28017b;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
        public JsonObject b() {
            return this.f28016a;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.a.d
        public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r2) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
            throw new UnsupportedOperationException("analyseError() called on ImmediateModelResponse.");
        }
    }

    /* JADX INFO: compiled from: IStdModelRequestDelegate.kt */
    public static final class f implements com.obric.autogui.agents.vlm.models.impl.request.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f28018a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final com.obric.autogui.agents.vlm.models.impl.request.b.b f28019b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a f28020c = null;

        private f() {
        }

        static {
            f28018a = new f();
            f28019b = com.obric.autogui.agents.vlm.models.impl.request.b.b.f28050a;
            f28020c = com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28036b;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
        public com.obric.autogui.agents.vlm.models.impl.request.b.b a() {
            return f28019b;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
        public com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a b() {
            return f28020c;
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.request.b.a
        public String a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r2, "context");
            String r4 = r2.getString(ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"));
            o.c(r4, "getString(...)");
            return r4;
        }
    }

    Object a(com.obric.autogui.agents.vlm.b.C0677b r1, String r2, String r3, int r4, JsonObject r5, d.c.d<? super c> r6);

    Object a(d.c.d<? super com.obric.autogui.common.e> r1);

    void a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r1);

    Object b(d.c.d<? super x> r1);
}
