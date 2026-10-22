package com.obric.autogui.util.doubao.settings;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.aa;
import d.n;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;

/* JADX INFO: compiled from: SettingsViaFlow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "Settings-Flow";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f31526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Gson f31527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f31528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile com.obric.autogui.common.a.a.a f31529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f31530e = null;
    private static final AtomicBoolean f = null;
    private static final AtomicBoolean g = null;
    private static final AtomicBoolean h = null;
    private static final CopyOnWriteArraySet<a> i = null;
    private static final Object j = null;

    /* JADX INFO: compiled from: SettingsViaFlow.kt */
    public interface a {
        void onSettingsApplied(long r1);
    }

    /* JADX INFO: compiled from: SettingsViaFlow.kt */
    @f(b = "SettingsViaFlow.kt", c = {61}, d = "invokeSuspend", e = "com.obric.autogui.util.doubao.settings.SettingsViaFlow$init$1$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IFlowSettingsIDL f31532b;

        b(IFlowSettingsIDL r3, d.c.d<? super b> r4) {
            IFlowSettingsIDL r5 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31532b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f31532b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31531a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r10);
        L14:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r10);
            c.a(c.f31526a, this.f31532b, "Init", false, 4, null);
            if (c.c().get() == true) goto L14;
            c r11 = c.f31526a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31531a = 1;
            if (c.a(r11, r2) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.util.doubao.settings.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SettingsViaFlow.kt */
    @f(b = "SettingsViaFlow.kt", c = {83}, d = "pollRecoverAfterInitFailure", e = "com.obric.autogui.util.doubao.settings.SettingsViaFlow")
    static final class C0866c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31535c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f31536d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31537e;

        C0866c(c r3, d.c.d<? super C0866c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31536d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31535c = r3;
            this.f31537e |= Integer.MIN_VALUE;
            return c.a(this.f31536d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SettingsViaFlow.kt */
    @f(b = "SettingsViaFlow.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.util.doubao.settings.SettingsViaFlow$recoverFromFailure$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31538a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f31538a != 0) goto L7;
            o.a(r1);
            c.a(c.f31526a);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void lambda$H6kpQ9GNzl1qSlTiNhRmg7vtlqo(IFlowSettingsIDL r0) {
        a(r0);
    }

    private c() {
    }

    public static final /* synthetic */ Object a(c r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(c r0) {
        r0.d();
    }

    public static final /* synthetic */ AtomicBoolean c() {
        return g;
    }

    static {
        f31526a = new c();
        f31527b = new GsonBuilder().create();
        f31530e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
        g = new AtomicBoolean(false);
        h = new AtomicBoolean(false);
        i = new CopyOnWriteArraySet();
        j = new Object();
    }

    public final void a() {
        if (f31530e.compareAndSet(false, true) == true) goto L6;
        Loog.INSTANCE.i(TAG, "[Settings] Initialisation settings via Flow in progress.");
        return;
    L6:
        at.a(aa.b(IFlowSettingsIDL.class), false, false, $$Lambda$c$H6kpQ9GNzl1qSlTiNhRmg7vtlqo.INSTANCE, 3, null);
    }

    private static final void a(IFlowSettingsIDL r4) {
        IFlowSettingsIDL r5 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "ipc");
        if (f.compareAndSet(false, true) == true) goto L6;
        Loog.INSTANCE.i(TAG, "[Settings] Flow settings IPC is already registered.");
        return;
    L6:
        Loog.INSTANCE.i(TAG, "[Settings-Init] flow settings ipc registered");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new b(r5, null), m.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00af -> B:28:0x00c4). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c2 -> B:27:0x00c3). Please report as a decompilation issue!!! */
    private final Object a(d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, C0866c.class) == false) goto L7;
        C0866c r0 = (C0866c) ZeusTransformUtils.preCheckCast(r10, C0866c.class, "com.obric.aiagent.plugin");
        if ((r0.f31537e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31537e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f31535c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31537e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r8 = r0.f31534b;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.f31533a, c.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L27:
        c r12 = r1;
    L28:
        r8 = r8 + 1;
    L16:
        if (r8 >= 11) goto L29;
        Loog.INSTANCE.i(TAG, "[Settings-InitPoll] tick; poll times=" + r8 + "/10");
        r12.a(false);
        if (g.get() == false) goto L22;
        Loog.INSTANCE.i(TAG, "[Settings-InitPoll] stop; recovered success; poll times=" + r8 + "/10");
        return x.f38692a;
    L22:
        if (r8 >= 10) goto L28;
        AOThreadingTools r4 = AOThreadingTools.INSTANCE;
        r0.f31533a = r12;
        r0.f31534b = r8;
        r0.f31537e = 1;
        if (r4.delayForMillis(1000, r0) != r2) goto L26;
        return r2;
    L26:
        r1 = r12;
        goto L27
    L29:
        Loog.INSTANCE.i(TAG, "[Settings-InitPoll] stop; reach max retries; success=" + g.get());
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        Loog.INSTANCE.i(TAG, "[Settings-InitPoll] start; times=10 intervalMs=1000");
        r12 = this;
        r8 = 1;
    L7:
        r0 = new C0866c(this, r10);
        goto L8
    }

    public final com.obric.autogui.common.a.a.a b() {
        return f31529d;
    }

    public final void a(a r3) {
        a r2 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "listener");
        Object r4 = j;
        monitor-enter(r4);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (i.add(r2) == true) goto L8;
        monitor-exit(r4);
        return;
    L8:
        com.obric.autogui.common.a.a.a r0 = f31529d;     // Catch: Throwable -> L20
        if (g.get() == false) goto L15;
        if (r0 == null) goto L15;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.autogui.util.doubao.settings.a.class) == true) goto L15;
        Long r1 = Long.valueOf(r0.getVersion());     // Catch: Throwable -> L20
    L16:
        monitor-exit(r4);
        if (r1 == null) goto L25;
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).longValue();
        f31526a.a(r2, r5);
        return;
    L25:
        return;
    L15:
        r1 = null;
        goto L16
    }

    public static /* synthetic */ void a(c r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.a(r1);
    }

    public final void a(boolean r5) {
        if (g.get() == false) goto L7;
        Loog.INSTANCE.i(TAG, "[Settings-Recover] settings is already fetched success.");
        return;
    L7:
        if (h.compareAndSet(false, true) == true) goto L10;
        Loog.INSTANCE.i(TAG, "[Settings-Recover] settings is already recovering.");
        return;
    L10:
        if (r5 == false) goto L12;
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new d(null), m.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        d();
    }

    private final void d() {
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        f31526a.a(r0, "Recover", true);     // Catch: Throwable -> L7
    L6:
        h.set(false);
        return;
    L7:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Settings-Recover] recover failed", th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        h.set(false);
        throw th;
    }

    static /* synthetic */ void a(c r1, IFlowSettingsIDL r2, String r3, boolean r4, int r5, Object r6) {
        IFlowSettingsIDL r7 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        r1.a(r7, r3, r4);
    }

    private final void a(IFlowSettingsIDL r9, String r10, boolean r11) {
        Object r0 = "";
        IFlowSettingsIDL r12 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r9, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        String r13 = r12.getObricFlowSettingsJson("OAutoSettings");     // Catch: Throwable -> L8
        if (r13 != null) goto L6;
        r13 = "";
    L6:
        Object r14 = n.f(r13);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = n.c(r14);
        if (r3 == null) goto L14;
        Loog.INSTANCE.e(TAG, "[Settings-" + r10 + "] failed to get settings from flow", r3);
    L14:
        if (n.b(r14) == true) goto L17;
        r0 = r14;
    L17:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L20;
        Loog.INSTANCE.d(TAG, "[Settings-" + r10 + "] got settings from flow: " + r15);
    L20:
        boolean r4 = true;
        boolean r5 = d.o.o.a(r15, "null", true);
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L23;
    L26:
        if (r4 == true) goto L32;
        if (r5 == true) goto L32;
        boolean r16 = a(r15, r11);
        g.set(r16);
        if (r16 == false) goto L31;
        Loog.INSTANCE.i(TAG, "[Settings-" + r10 + "] flow settings is fetched and applied");
        return;
    L31:
        Loog.INSTANCE.i(TAG, "[Settings-" + r10 + "] flow settings apply failed");
        e();
        return;
    L32:
        Loog.INSTANCE.i(TAG, "[Settings-" + r10 + "] flow settings is fetch failed");
        g.set(false);
        e();
        return;
    L23:
        if (d.o.o.d(r6) == true) goto L26;
        r4 = false;
    L8:
        th = move-exception;
        n.a r7 = n.f38560a;
        r14 = n.f(o.a(th));
        goto L10
    }

    private final void e() {
        if (f31529d != null) goto L5;
    L8:
        f31529d = (com.obric.autogui.common.a.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.util.doubao.settings.a(0, 1, null), com.obric.autogui.common.a.a.a.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(f31529d, com.obric.autogui.util.doubao.settings.a.class) == false) goto L8;
        Loog.INSTANCE.i(TAG, "[Settings-CreateFallback] current running settings is already a fallback repo, skip.");
    }

    private final boolean a(String r5, boolean r6) {
        if (com.obric.autogui.common.b.b.f29001a.a() == false) goto L5;
        Loog.INSTANCE.d(TAG, "[Settings] applying settings: " + r5);
    L5:
        Long r0 = null;
        if (r6 == false) goto L8;
        f31529d = null;
    L8:
        boolean r7 = false;
        JsonObject r8 = (JsonObject) ZeusTransformUtils.preCheckCast(f31527b.fromJson(r5, JsonObject.class), JsonObject.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        d.h.b.o.a(r8);     // Catch: Throwable -> L12
        r7 = a(r8);     // Catch: Throwable -> L12
    L14:
        if (r7 == false) goto L19;
        Loog r4 = Loog.INSTANCE;
        StringBuilder r9 = new StringBuilder().append("[Settings] applied settings version=");
        com.obric.autogui.common.a.a.a r2 = f31529d;
        if (r2 == null) goto L18;
        r0 = Long.valueOf(r2.getVersion());
    L18:
        r4.d(TAG, r9.append(r0).toString());
    L19:
        return r7;
    L12:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Settings] failed to apply settings. Further calls to acquire settings may lead to incomplete configs.", th);
    L20:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "[Settings] failed to parse settings.", th);
        return false;
    }

    private final boolean a(JsonObject r8) {
        JsonObject r7 = r8.getAsJsonObject("base");
        if (r7 != null) goto L7;
        Loog.INSTANCE.w(TAG, "[Settings] expect a non-null `base` part in this settings.");
        return false;
    L7:
        if (r7.get("using_settings").getAsBoolean() == true) goto L10;
        Loog.INSTANCE.e(TAG, "[Settings] current running settings (if any) is being disabled.");
        f31528c = false;
        return true;
    L10:
        f31528c = true;
        String r9 = r7.get("config_ver").getAsString();
        d.h.b.o.a(r9);
        long r0 = Long.parseLong(r9);
        com.obric.autogui.common.a.a.a r10 = f31529d;
        if (r10 == null) goto L13;
        long r3 = r10.getVersion();
    L15:
        if (r3 <= r0) goto L18;
        Loog.INSTANCE.e(TAG, "[Settings] not applying settings; downgrading config version (" + r3 + " --> " + r0 + ").");
        return true;
    L18:
        com.obric.autogui.util.doubao.settings.b r11 = new com.obric.autogui.util.doubao.settings.b(r0);
        JsonObject r12 = r8.getAsJsonObject("configs");
        if (r12 != null) goto L21;
        Loog.INSTANCE.w(TAG, "[Settings] no configs actually found in this settings.");
    L22:
        Object r13 = j;
        monitor-enter(r13);
        g.set(true);     // Catch: Throwable -> L31
        f31529d = (com.obric.autogui.common.a.a.a) ZeusTransformUtils.preCheckCast(r11, com.obric.autogui.common.a.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        List r1 = p.o((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L31
        monitor-exit(r13);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L28:
        if (r14.hasNext() == false) goto L30;
        a r2 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.aiagent.plugin");
        c r4 = f31526a;
        d.h.b.o.a(r2);
        r4.a(r2, r11.getVersion());
        goto L28
    L30:
        return true;
    L31:
        th = move-exception;
        throw th;
    L21:
        r11.a(r12);
        goto L22
    L13:
        r3 = 0;
        goto L15
    }

    private final void a(a r3, long r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        c r2 = (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        r5.onSettingsApplied(r4);     // Catch: Throwable -> L5
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L7:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L13;
        Loog.INSTANCE.e(TAG, "[Settings] settings-applied listener failed", r7);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        n.a r8 = n.f38560a;
        r6 = n.f(o.a(th));
        goto L7
    }
}
