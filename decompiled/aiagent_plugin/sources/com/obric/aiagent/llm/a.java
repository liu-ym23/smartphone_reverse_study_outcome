package com.obric.aiagent.llm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: ChatCompletionClient.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "ChatCompletionClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18678a = null;
    private static final ArrayList<com.bytedance.retrofit2.b.b> g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Object> f18680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<f> f18681d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.f f18682e;
    private final d.f f;

    /* JADX INFO: renamed from: com.obric.aiagent.llm.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ChatCompletionClient.kt */
    public static final class C0392a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final LinkedHashMap<String, Object> f18684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<f> f18685c;

        public C0392a(String r3, Map<String, ? extends Object> r4, List<f> r5) {
            Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "promptKey");
            o.e(r6, "variables");
            o.e(r7, "messages");
            this.f18683a = r3;
            this.f18684b = new LinkedHashMap(r6);
            this.f18685c = p.g((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.aiagent.plugin"));
        }

        public /* synthetic */ C0392a(String r2, Map r3, List r4, int r5, d.h.b.h r6) {
            Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            if ((r5 & 2) == 0) goto L6;
            r7 = ao.b();
        L6:
            if ((r5 & 4) == 0) goto L8;
            r8 = p.b();
        L8:
            this(r2, r7, r8);
        }

        public final a a() {
            return new a(this.f18683a, ao.d((Map) ZeusTransformUtils.preCheckCast(this.f18684b, Map.class, "com.obric.aiagent.plugin")), p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f18685c, Iterable.class, "com.obric.aiagent.plugin")), null);
        }
    }

    /* JADX INFO: compiled from: ChatCompletionClient.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ChatCompletionClient.kt */
    @d.c.b.a.f(b = "ChatCompletionClient.kt", c = {76}, d = Ext.KEY_REQUEST, e = "com.obric.aiagent.llm.ChatCompletionClient")
    static final class c<T> extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f18687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f18688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f18689d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f18690e;

        c(a r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18689d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18688c = r3;
            this.f18690e |= Integer.MIN_VALUE;
            return this.f18689d.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: ChatCompletionClient.kt */
    @d.c.b.a.f(b = "ChatCompletionClient.kt", c = {86}, d = "invokeSuspend", e = "com.obric.aiagent.llm.ChatCompletionClient$requestRaw$2")
    static final class d extends l implements m<am, d.c.d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f18692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f18693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f18694d;

        d(a r3, String r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18692b = r3;
            this.f18693c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super String> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            d r0 = new d(this.f18692b, this.f18693c, r6);
            r0.f18694d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18691a;
            if (r1 == 0) goto L9;
            if (r1 != 1) goto L8;
            d.o.a(r10);     // Catch: Throwable -> L15
        L13:
            Object r9 = n.f((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        L17:
            Throwable r11 = n.c(r9);
            if (r11 == null) goto L24;
            if (ZeusTransformUtils.instanceOf(r11, CancellationException.class) == true) goto L22;
            ILogDepend.Companion.e(a.TAG, "chatCompletion request failed: " + r11.getMessage(), r11);
            goto L24
        L22:
            throw r11;
        L24:
            if (n.b(r9) == false) goto L29;
            return null;
        L29:
            return r9;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r10);
            am r12 = (am) ZeusTransformUtils.preCheckCast(this.f18694d, am.class, "com.obric.aiagent.plugin");
            a r13 = this.f18692b;
            String r2 = this.f18693c;
            n.a r4 = n.f38560a;     // Catch: Throwable -> L15
            ChatCompletionApi r5 = a.a(r13);     // Catch: Throwable -> L15
            List<com.bytedance.retrofit2.b.b> r6 = a.b(r13);     // Catch: Throwable -> L15
            com.obric.aiagent.llm.b r7 = new com.obric.aiagent.llm.b(a.c(r13), a.d(r13), a.a(r13, r2));     // Catch: Throwable -> L15
            this.f18691a = 1;     // Catch: Throwable -> L15
            r10 = r5.chatCompletion(r6, r7, this);     // Catch: Throwable -> L15
            if (r10 != r0) goto L13;
            return r0;
        L15:
            th = move-exception;
            n.a r14 = n.f38560a;
            r9 = n.f(d.o.a(th));
            goto L17
        }
    }

    /* JADX INFO: compiled from: ChatCompletionClient.kt */
    @d.c.b.a.f(b = "ChatCompletionClient.kt", c = {66}, d = "requestTyped", e = "com.obric.aiagent.llm.ChatCompletionClient")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f18695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f18697c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f18698d;

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18697c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18696b = r3;
            this.f18698d |= Integer.MIN_VALUE;
            return this.f18697c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public /* synthetic */ a(String r2, Map r3, List r4, d.h.b.h r5) {
        this(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    public static /* synthetic */ ChatCompletionApi lambda$EttJkyBOYMaZ7wn0iJ5Xfgufwe0() {
        return d();
    }

    public static /* synthetic */ Gson lambda$SsdqRKTUJuv98_Wfkt_0SvGT0S4() {
        return e();
    }

    private a(String r3, Map<String, ? extends Object> r4, List<f> r5) {
        Map<String, Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        List<f> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f18679b = r3;
        this.f18680c = r6;
        this.f18681d = r7;
        this.f18682e = d.g.a($$Lambda$a$EttJkyBOYMaZ7wn0iJ5Xfgufwe0.INSTANCE);
        this.f = d.g.a($$Lambda$a$SsdqRKTUJuv98_Wfkt_0SvGT0S4.INSTANCE);
    }

    public static final /* synthetic */ ChatCompletionApi a(a r0) {
        return r0.a();
    }

    public static final /* synthetic */ List a(a r0, String r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ List b(a r0) {
        return r0.c();
    }

    public static final /* synthetic */ String c(a r0) {
        return r0.f18679b;
    }

    public static final /* synthetic */ Map d(a r0) {
        return r0.f18680c;
    }

    static {
        f18678a = new b(null);
        ArrayList<com.bytedance.retrofit2.b.b> r0 = new ArrayList();
        r0.add(new com.bytedance.retrofit2.b.b(DownloadHelper.CONTENT_TYPE, "application/json"));
        g = r0;
    }

    private final ChatCompletionApi a() {
        Object r2 = this.f18682e.b();
        o.c(r2, "getValue(...)");
        return (ChatCompletionApi) ZeusTransformUtils.preCheckCast(r2, ChatCompletionApi.class, "com.obric.aiagent.plugin");
    }

    private static final ChatCompletionApi d() {
        return (ChatCompletionApi) ZeusTransformUtils.preCheckCast(com.bytedance.ttnet.utils.d.b(com.obric.aiagent.product.a.a.f18769a.c()).a(ChatCompletionApi.class), ChatCompletionApi.class, "com.obric.aiagent.plugin");
    }

    private final Gson b() {
        return (Gson) ZeusTransformUtils.preCheckCast(this.f.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson e() {
        return new GsonBuilder().create();
    }

    public final Object a(String r7, d.c.d<? super com.obric.aiagent.llm.c> r8) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r1.f18698d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f18698d -= Integer.MIN_VALUE;
    L8:
        Object r10 = r1.f18696b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f18698d;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        a this = (a) ZeusTransformUtils.preCheckCast(r1.f18695a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r10);
    L17:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L20;
        return null;
    L20:
        String r2 = this.b(r11);
        n.a r5 = n.f38560a;     // Catch: Throwable -> L23
        Object r6 = n.f((com.obric.aiagent.llm.c) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).b().fromJson(r2, com.obric.aiagent.llm.c.class), com.obric.aiagent.llm.c.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L23
    L25:
        Throwable r0 = n.c(r6);
        if (r0 == null) goto L29;
        ILogDepend.Companion.e(TAG, "parse ChatCompletionResponse failed: " + r0.getMessage() + "； rawResponse=" + r11, r0);
    L29:
        if (n.b(r6) == false) goto L32;
        return null;
    L32:
        return r6;
    L23:
        th = move-exception;
        n.a r12 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L25
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r10);
        r1.f18695a = this;
        r1.f18698d = 1;
        r10 = b(r7, r1);
        if (r10 != r3) goto L17;
        return r3;
    L7:
        r1 = new e(this, r9);
        goto L8
    }

    public final <T> Object a(String r7, Class<T> r8, d.c.d<? super T> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, c.class) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.aiagent.plugin");
        if ((r1.f18690e & Integer.MIN_VALUE) == 0) goto L7;
        r1.f18690e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r1.f18688c;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f18690e;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r8 = (Class) ZeusTransformUtils.preCheckCast(r1.f18687b, Class.class, "com.obric.aiagent.plugin");
        a this = (a) ZeusTransformUtils.preCheckCast(r1.f18686a, a.class, "com.obric.aiagent.plugin");
        d.o.a(r11);
    L17:
        com.obric.aiagent.llm.c r12 = (com.obric.aiagent.llm.c) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.llm.c.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L42;
        List<com.obric.aiagent.llm.d> r13 = r12.a();
        if (r13 == null) goto L43;
        com.obric.aiagent.llm.d r14 = (com.obric.aiagent.llm.d) ZeusTransformUtils.preCheckCast(p.l(r13), com.obric.aiagent.llm.d.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L44;
        com.obric.aiagent.llm.e r15 = r14.a();
        if (r15 == null) goto L45;
        String r16 = r15.a();
        if (r16 == null) goto L46;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L30
        Object r6 = n.f(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).b().fromJson(r16, r8));     // Catch: Throwable -> L30
    L32:
        Throwable r17 = n.c(r6);
        if (r17 == null) goto L36;
        ILogDepend.Companion.e(TAG, "parse choice failed: " + r17.getMessage(), r17);
    L36:
        if (n.b(r6) == false) goto L39;
        return null;
    L39:
        return r6;
    L30:
        th = move-exception;
        n.a r18 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L32
    L46:
        return null;
    L45:
        return null;
    L44:
        return null;
    L43:
        return null;
    L42:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r11);
        r1.f18686a = this;
        r1.f18687b = r8;
        r1.f18690e = 1;
        r11 = a(r7, r1);
        if (r11 != r3) goto L17;
        return r3;
    L7:
        r1 = new c(this, r10);
        goto L8
    }

    private final Object b(String r5, d.c.d<? super String> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new d(this, r5, null), m.class, "com.obric.aiagent.plugin"), r7);
    }

    private final List<f> a(String r3) {
        if (r3 != null) goto L6;
        return this.f18681d;
    L6:
        return p.a((Collection) ZeusTransformUtils.preCheckCast(this.f18681d, Collection.class, "com.obric.aiagent.plugin"), new f("user", r3));
    }

    private final String b(String r3) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L11
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        JsonElement r4 = JsonParser.parseString(r3);     // Catch: Throwable -> L11
        if (r4.isJsonPrimitive() == true) goto L6;
    L8:
        String r5 = r3;
    L9:
        Object r6 = n.f(r5);     // Catch: Throwable -> L11
    L13:
        Object r7 = r3;
        if (n.b(r6) == true) goto L18;
        r7 = r6;
    L18:
        return (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L6:
        if (r4.getAsJsonPrimitive().isString() == false) goto L8;
        r5 = r4.getAsString();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L13
    }

    private final List<com.bytedance.retrofit2.b.b> c() {
        ArrayList r5 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(g, Collection.class, "com.obric.aiagent.plugin"));
        if (com.obric.aiagent.utils.shared_state.b.f22344a.f() == false) goto L10;
        Map<String, String> r0 = com.obric.aiagent.utils.shared_state.b.f22344a.e();
        if (r0 == null) goto L10;
        Iterator<Map.Entry<String, String>> r1 = r0.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r5.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
    L10:
        r5.add(new com.bytedance.retrofit2.b.b("oauto-version-code", String.valueOf(IAppContext.Companion.getVersionCode())));
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin");
    }
}
