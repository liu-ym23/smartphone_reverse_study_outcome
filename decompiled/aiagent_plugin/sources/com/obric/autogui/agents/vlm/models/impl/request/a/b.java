package com.obric.autogui.agents.vlm.models.impl.request.a;

import android.content.Context;
import android.content.Intent;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.e;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.h;
import d.h.b.o;
import d.l;
import d.n;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a.d;
import kotlinx.coroutines.a.g;

/* JADX INFO: compiled from: AADebugModelReplyHookImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.obric.autogui.agents.vlm.models.impl.request.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28023a = null;
    private static final C0704b f = null;
    private static b g;
    private static boolean h;
    private static int i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f28024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<com.obric.autogui.agents.vlm.models.impl.request.a.c> f28026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d<com.obric.autogui.agents.vlm.models.impl.request.a.c> f28027e;

    /* JADX INFO: compiled from: AADebugModelReplyHookImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final C0704b a() {
            return b.a();
        }

        public final b b() {
            return b.b();
        }

        public final void a(boolean r1) {
            b.a(r1);
        }

        public final boolean c() {
            return b.c();
        }

        public final void a(int r1) {
            b.a(r1);
        }

        public final int d() {
            return b.d();
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AADebugModelReplyHookImpl.kt */
    public static final class C0704b extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0704b f28028a = null;

        /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.request.a.b$b$a */
        /* JADX INFO: compiled from: AADebugModelReplyHookImpl.kt */
        public static final class a extends com.obric.autogui.agents.vlm.models.impl.request.a.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ JsonObject f28029b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f28030c;

            a(JsonObject r1) {
                this.f28029b = r1;
                this.f28030c = true;
            }

            @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
            public boolean a() {
                return this.f28030c;
            }

            @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
            public Object a(d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.d> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return new com.obric.autogui.agents.vlm.models.impl.request.a.e(this.f28029b);
            }

            @Override // com.obric.autogui.agents.vlm.models.impl.request.a.c
            public com.obric.autogui.agents.vlm.models.impl.request.b.a a(Context r2) {
                o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
                throw new l("An operation is not implemented: Not yet implemented");
            }
        }

        static {
            f28028a = new C0704b();
        }

        private C0704b() {
        }

        public void onReceive(Context r13, Intent r14) {
            o.e((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin"), "context");
            o.e(r14, MemorySourceLinkType.INTENT);
            if (r14.getBooleanExtra("mock_session_id", false) == false) goto L17;
            String r15 = r14.getStringExtra("session_id");
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L7;
        L10:
            boolean r8 = true;
        L11:
            if (r8 == true) goto L17;
            com.obric.autogui.session.a r12 = com.obric.autogui.session.c.f30777a.b();
            if (r12 == null) goto L81;
            r12.a(r15, true);
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(r12), "current session (k=" + r12.a() + ") id changed to " + r15 + '.');
            return;
        L81:
            return;
        L7:
            if (d.o.o.d(r7) == true) goto L10;
            r8 = false;
        L17:
            if (r14.getBooleanExtra("mock_queue", false) == false) goto L23;
            int r16 = Math.max(r14.getIntExtra("mock_queue_time", 0), DownloadErrorCode.ERROR_CRONET_ERROR_BASE);
            if (IAppContext.Companion.isDebug() == false) goto L82;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DEBUG] mock queue (time = " + r16 + "/ms)");
            b.f28023a.a(true);
            b.f28023a.a(r16);
            return;
        L82:
            return;
        L23:
            if (r14.getBooleanExtra("set_hook", false) == false) goto L26;
            boolean r17 = r14.getBooleanExtra("hook_on", false);
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DEBUG] set hook = " + r17 + ", isDebug = " + IAppContext.Companion.isDebug());
            com.obric.autogui.agents.vlm.models.impl.request.a.a.f28021a.a(r17);
            return;
        L26:
            r14.getBooleanExtra("ok", true);
            String r18 = r14.getStringExtra("content_json");
            Object r4 = null;
            if (r18 != null) goto L79;
            n.a r9 = n.f38560a;     // Catch: Throwable -> L44
            String r10 = r14.getStringExtra("action");     // Catch: Throwable -> L44
            String r11 = "";
            if (r10 != null) goto L32;
            r10 = "";
        L32:
            String r19 = r14.getStringExtra("action_type");     // Catch: Throwable -> L44
            if (r19 != null) goto L35;
            r19 = "";
        L35:
            String r110 = r14.getStringExtra("action_params");     // Catch: Throwable -> L44
            if (r110 != null) goto L38;
            r110 = "";
        L38:
            String r111 = r14.getStringExtra(VDPlayerEffectProviderImpl.KEY_THOUGHT);     // Catch: Throwable -> L44
            if (r111 == null) goto L42;
            r11 = r111;
        L42:
            JsonObject r112 = new JsonObject();     // Catch: Throwable -> L44
            r112.addProperty("action", r10);     // Catch: Throwable -> L44
            r112.addProperty("action_type", r19);     // Catch: Throwable -> L44
            r112.add("action_args", (JsonElement) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r110, JsonArray.class), JsonElement.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L44
            r112.addProperty(VDPlayerEffectProviderImpl.KEY_THOUGHT, r11);     // Catch: Throwable -> L44
            Object r0 = n.f(r112);     // Catch: Throwable -> L44
        L46:
            Throwable r1 = n.c(r0);
            if (r1 == null) goto L51;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(n.g(r0)), " - [DEBUG] fake response error (JSON) = " + r1);
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(n.g(r0)), " - [DEBUG] params = " + r14.getStringExtra("action_params"));
            return;
        L51:
            if (n.b(r0) == true) goto L54;
            r4 = r0;
        L54:
            JsonObject r113 = (JsonObject) ZeusTransformUtils.preCheckCast(r4, JsonObject.class, "com.obric.aiagent.plugin");
        L68:
            if (r113 != null) goto L71;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DEBUG] fake response error (JSON) = " + r18);
            return;
        L71:
            a r114 = new a(r113);
            Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DEBUG] fake response = " + r114);
            b r115 = b.f28023a.b();
            if (r115 == null) goto L83;
            d r116 = b.a(r115);
            if (r116 == null) goto L84;
            kotlinx.coroutines.a.h.i(r116.a_(r114));
            return;
        L84:
            return;
        L83:
            return;
        L44:
            th = move-exception;
            n.a r2 = n.f38560a;
            r0 = n.f(d.o.a(th));
            goto L46
        L79:
            n.a r117 = n.f38560a;     // Catch: Throwable -> L57
            Object r118 = n.f((JsonObject) ZeusTransformUtils.preCheckCast(com.obric.autogui.util.b.f31495a.a().fromJson(r18, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L57
        L59:
            Throwable r3 = n.c(r118);
            if (r3 == null) goto L64;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(n.g(r118)), " - [DEBUG] fake response error = " + r3);
            return;
        L64:
            if (n.b(r118) == true) goto L67;
            r4 = r118;
        L67:
            r113 = (JsonObject) ZeusTransformUtils.preCheckCast(r4, JsonObject.class, "com.obric.aiagent.plugin");
        L57:
            th = move-exception;
            n.a r5 = n.f38560a;
            r118 = n.f(d.o.a(th));
            goto L59
        }
    }

    /* JADX INFO: compiled from: AADebugModelReplyHookImpl.kt */
    @f(b = "AADebugModelReplyHookImpl.kt", c = {91}, d = "requestModel", e = "com.obric.autogui.agents.vlm.models.impl.request.debug.AADebugModelReplyHookImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f28032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28033c;

        c(b r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28032b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            this.f28031a = r8;
            this.f28033c |= Integer.MIN_VALUE;
            return this.f28032b.a(null, null, null, 0, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public void a(com.obric.autogui.agents.vlm.models.impl.d.C0690d r1) {
        o.e(r1, "inferenceContext");
    }

    public static final /* synthetic */ C0704b a() {
        return f;
    }

    public static final /* synthetic */ d a(b r0) {
        return r0.f28026d;
    }

    public static final /* synthetic */ void a(int r0) {
        i = r0;
    }

    public static final /* synthetic */ void a(boolean r0) {
        h = r0;
    }

    public static final /* synthetic */ b b() {
        return g;
    }

    public static final /* synthetic */ boolean c() {
        return h;
    }

    public static final /* synthetic */ int d() {
        return i;
    }

    public b(boolean r4) {
        this.f28024b = r4;
        this.f28025c = "";
        this.f28026d = g.a(0, null, null, 6, null);
        this.f28027e = g.a(0, null, null, 6, null);
    }

    static {
        f28023a = new a(null);
        f = C0704b.f28028a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(d.c.d<? super e> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        g = this;
        return e.f29014b.a();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object b(d.c.d<? super x> r2) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin");
        g = null;
        return x.f38692a;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.request.a
    public Object a(com.obric.autogui.agents.vlm.b.C0677b r4, String r5, String r6, int r7, JsonObject r8, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r11 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r11.f28033c & Integer.MIN_VALUE) == 0) goto L7;
        r11.f28033c -= Integer.MIN_VALUE;
    L8:
        Object r12 = r11.f28031a;
        Object r0 = d.c.a.b.a();
        int r1 = r11.f28033c;
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        d.o.a(r12);     // Catch: CancellationException -> L21
    L19:
        return (com.obric.autogui.agents.vlm.models.impl.request.a.c) ZeusTransformUtils.preCheckCast(r12, com.obric.autogui.agents.vlm.models.impl.request.a.c.class, "com.obric.aiagent.plugin");
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        d.o.a(r12);
        com.obric.autogui.session.a r13 = r4.a();     // Catch: CancellationException -> L21
        r11.f28033c = 1;     // Catch: CancellationException -> L21
        r12 = a(r13, r7, r8, r11);     // Catch: CancellationException -> L21
        if (r12 != r0) goto L19;
        return r0;
    L22:
        return new com.obric.autogui.agents.vlm.models.impl.request.a.b((com.obric.autogui.agents.vlm.models.impl.request.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.agents.vlm.models.impl.request.b.a.a(com.obric.autogui.agents.vlm.models.impl.request.b.b.f28051b, com.obric.autogui.agents.vlm.models.impl.request.b.a.EnumC0705a.f28035a, "请求终止。"), com.obric.autogui.agents.vlm.models.impl.request.b.a.class, "com.obric.aiagent.plugin"));
    L7:
        r11 = new c(this, r10);
        goto L8
    }

    private final Object a(com.obric.autogui.session.a r3, int r4, JsonObject r5, d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r6) {
        d.c.d<? super com.obric.autogui.agents.vlm.models.impl.request.a.c> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - [DEBUG] requested fake = " + r5);
        this.f28025c = "";
        return this.f28026d.a(r7);
    }
}
