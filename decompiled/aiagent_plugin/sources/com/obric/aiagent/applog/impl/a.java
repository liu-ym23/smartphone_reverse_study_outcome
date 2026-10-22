package com.obric.aiagent.applog.impl;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bytedance.applog.h;
import com.bytedance.applog.i;
import com.bytedance.applog.p;
import com.bytedance.bdinstall.ah;
import com.bytedance.bdinstall.ai;
import com.bytedance.bdinstall.am;
import com.bytedance.bdinstall.ar;
import com.bytedance.bdinstall.as;
import com.bytedance.bdinstall.aw;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppLogHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AiagentAppLogHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16126a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static com.obric.aiagent.applog.a f16128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<com.obric.aiagent.applog.b> f16129d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, d.h.a.a<Object>> f16130e = null;
    private static final ConcurrentHashMap<String, Object> f = null;
    private static final List<com.bytedance.applog.collector.a> g = null;
    private static final h h = null;
    private static final HandlerThread i = null;
    private static final Handler j = null;
    private static volatile int k;
    private static volatile boolean l;
    private static final Runnable m = null;
    private static final d n = null;
    private static final c o = null;
    private static final C0326a p = null;
    private static final b q = null;
    private static final String r = null;

    /* JADX INFO: renamed from: com.obric.aiagent.applog.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AppLogHelper.kt */
    public static final class C0326a implements i {
        C0326a() {
        }

        @Override // com.bytedance.applog.i
        public void a(String r6, String r7, String r8) {
            a.b(a.f16126a, r6, r7, r8);
            a.a(a.f16126a, r6, "onIdLoaded");
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
        L8:
            boolean r9 = true;
        L9:
            if (r9 == false) goto L11;
        L23:
            a.a(a.f16126a, r6, r7, "onIdLoaded");
            return;
        L11:
            if (o.a(r6, "0") == true) goto L23;
            Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(a.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L14:
            if (r10.hasNext() == false) goto L23;
            com.obric.aiagent.applog.b r2 = (com.obric.aiagent.applog.b) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.aiagent.applog.b.class, "com.obric.aiagent.plugin");
            String r3 = "";
            if (r7 != null) goto L18;
            String r4 = "";
        L19:
            if (r8 == null) goto L22;
            r3 = r8;
        L22:
            r2.a(r6, r4, r3);
            goto L14
        L18:
            r4 = r7;
            goto L19
        L5:
            if (r5.length() == 0) goto L8;
            r9 = false;
            goto L9
        }

        @Override // com.bytedance.applog.i
        public void a(boolean r9, String r10, String r11, String r12, String r13, String r14, String r15) {
            a.a(a.f16126a, r9, r10, r11, r12, r13, r14, r15);
            a.a(a.f16126a, r11, "onRemoteIdGet");
            if (r9 == false) goto L35;
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L7;
        L10:
            boolean r16 = true;
        L11:
            if (r16 == false) goto L13;
            return;
        L13:
            if (o.a(r11, "0") == true) goto L37;
            Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(a.d(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L16:
            if (r17.hasNext() == false) goto L25;
            com.obric.aiagent.applog.b r18 = (com.obric.aiagent.applog.b) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aiagent.applog.b.class, "com.obric.aiagent.plugin");
            String r19 = "";
            if (r13 != null) goto L20;
            String r0 = "";
        L21:
            if (r15 == null) goto L24;
            r19 = r15;
        L24:
            r18.a(r11, r0, r19);
            goto L16
        L20:
            r0 = r13;
            goto L21
        L25:
            a.a(a.f16126a, r11, r13, "onRemoteIdGet");
            BdTuringConfig r20 = com.bytedance.bdturing.b.a().b();
            if (r20 == null) goto L28;
            r20.setDeviceId(r11);
        L28:
            BdTuringConfig r21 = com.bytedance.bdturing.b.a().b();
            if (r21 == null) goto L38;
            r21.setInstallId(r13);
            return;
        L38:
            return;
        L37:
            return;
        L7:
            if (r8.length() == 0) goto L10;
            r16 = false;
            goto L11
        }

        @Override // com.bytedance.applog.i
        public void a(boolean r3, JSONObject r4) {
            ISecureLogDepend.Companion.i(a.TAG, "onRemoteConfigGet: changed = " + r3 + ", config = " + r4);
        }
    }

    /* JADX INFO: compiled from: AppLogHelper.kt */
    public static final class b implements com.bytedance.applog.collector.a {
        b() {
        }

        @Override // com.bytedance.applog.collector.a
        public void a(String r4, JSONObject r5) {
            o.e(r5, "flatParams");
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a.e(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bytedance.applog.collector.a) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.collector.a.class, "com.obric.aiagent.plugin")).a(r4, r5);
            goto L4
        }

        @Override // com.bytedance.applog.collector.a
        public void b(String r4, JSONObject r5) {
            o.e(r5, "flatParams");
            Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a.e(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bytedance.applog.collector.a) ZeusTransformUtils.preCheckCast(r3.next(), com.bytedance.applog.collector.a.class, "com.obric.aiagent.plugin")).b(r4, r5);
            goto L4
        }
    }

    /* JADX INFO: compiled from: AppLogHelper.kt */
    public static final class c implements ai {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.article.common.network.a f16131a;

        c() {
            this.f16131a = new com.bytedance.article.common.network.a();
        }

        @Override // com.bytedance.bdinstall.ai
        public String a(String r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            String r2 = this.f16131a.a(r3, r5, null);     // Catch: Exception -> L5
            o.a(r2);     // Catch: Exception -> L5
            return r2;
        L5:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e, com.bytedance.common.utility.b.class) == false) goto L11;
            throw new aw(((com.bytedance.common.utility.b) ZeusTransformUtils.preCheckCast(e, com.bytedance.common.utility.b.class, "com.obric.aiagent.plugin")).a(), e.getCause());
        L11:
            throw new aw(400, e.getCause());
        }

        @Override // com.bytedance.bdinstall.ai
        public String a(String r3, byte[] r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            String r2 = this.f16131a.a(r3, r4, r6, null);     // Catch: com.bytedance.common.utility.b -> L5
            o.a(r2);     // Catch: com.bytedance.common.utility.b -> L5
            return r2;
        L5:
            e = move-exception;
            throw new aw(e.a(), e.getCause());
        }

        @Override // com.bytedance.bdinstall.ai
        public String a(String r4, byte[] r5, String r6) {
            Map<String, String> r0 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.aiagent.plugin");
            if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L10;
            r0.put(DownloadHelper.CONTENT_TYPE, r6);
        L10:
            String r3 = this.f16131a.a(r4, r5, r0, null);     // Catch: com.bytedance.common.utility.b -> L7
            o.a(r3);     // Catch: com.bytedance.common.utility.b -> L7
            return r3;
        L7:
            e = move-exception;
            throw new aw(e.a(), e.getCause());
        }

        @Override // com.bytedance.bdinstall.ai
        public byte[] b(String r3, byte[] r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            byte[] r2 = this.f16131a.b(r3, r4, r6, null);     // Catch: com.bytedance.common.utility.b -> L5
            o.a(r2);     // Catch: com.bytedance.common.utility.b -> L5
            return r2;
        L5:
            e = move-exception;
            throw new aw(e.a(), e.getCause());
        }
    }

    /* JADX INFO: compiled from: AppLogHelper.kt */
    public static final class d implements as {
        d() {
        }

        @Override // com.bytedance.bdinstall.as
        public void a(am r3) {
            ISecureLogDepend.Companion.i(a.TAG, "resetAndReInstall onDidUpdate: installInfo = " + r3);
            if (r3 == null) goto L6;
            String r2 = r3.f();
            if (r2 == null) goto L6;
        L7:
            a.a(a.f16126a, r2, "onDidUpdate");
            return;
        L6:
            r2 = "";
            goto L7
        }

        @Override // com.bytedance.bdinstall.as
        public void a() {
            ISecureLogDepend.Companion.w(a.TAG, "resetAndReInstall timeout, schedule retry after 2000ms", (Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException(), Throwable.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AppLogHelper.kt */
    static final class e implements com.obric.aiagent.utils.a.b.a, d.h.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ d.h.a.b f16132a;

        e(d.h.a.b r3) {
            d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r4, "function");
            this.f16132a = r4;
        }

        @Override // d.h.b.i
        public final d.c<?> a() {
            return (d.c) ZeusTransformUtils.preCheckCast(this.f16132a, d.c.class, "com.obric.aiagent.plugin");
        }

        public final boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, com.obric.aiagent.utils.a.b.a.class) == true) goto L5;
            return false;
        L5:
            if (ZeusTransformUtils.instanceOf(r3, d.h.b.i.class) == true) goto L7;
            return false;
        L7:
            return o.a(((d.h.b.i) ZeusTransformUtils.preCheckCast(this, d.h.b.i.class, "com.obric.aiagent.plugin")).a(), ((d.h.b.i) ZeusTransformUtils.preCheckCast(r3, d.h.b.i.class, "com.obric.aiagent.plugin")).a());
        }

        public final int hashCode() {
            return ((d.h.b.i) ZeusTransformUtils.preCheckCast(this, d.h.b.i.class, "com.obric.aiagent.plugin")).a().hashCode();
        }

        @Override // com.obric.aiagent.utils.a.b.a
        public final /* synthetic */ void onScreenStateChanged(boolean r1) {
            this.f16132a.invoke(Boolean.valueOf(r1));
        }
    }

    /* JADX INFO: renamed from: lambda$758HLFnH_EWd1PXAyhGZ-cUJdhI, reason: not valid java name */
    public static /* synthetic */ HashMap m120lambda$758HLFnH_EWd1PXAyhGZcUJdhI(ar r0) {
        return a(r0);
    }

    public static /* synthetic */ void lambda$OzaDy7kXljGiDTUDxaw2qWfk5H8() {
        f();
    }

    public static /* synthetic */ x lambda$Ud8ypXP7WMDktJepJ6jdan6smaQ(boolean r0) {
        return a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(a r0, String r1, String r2, String r3) {
        r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ void a(a r0, boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        r0.a(r1, r2, r3, r4, r5, r6, r7);
    }

    public static final /* synthetic */ void b(a r0, String r1, String r2, String r3) {
        r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ List d() {
        return f16129d;
    }

    public static final /* synthetic */ List e() {
        return g;
    }

    static {
        f16126a = new a();
        f16129d = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.aiagent.plugin");
        f16130e = (Map) ZeusTransformUtils.preCheckCast(new ConcurrentHashMap(), Map.class, "com.obric.aiagent.plugin");
        f = new ConcurrentHashMap();
        g = (List) ZeusTransformUtils.preCheckCast(new CopyOnWriteArrayList(), List.class, "com.obric.aiagent.plugin");
        h = com.bytedance.applog.a.b();
        HandlerThread r0 = new HandlerThread("AppLogResetAndReInstall");
        r0.start();
        i = r0;
        j = new Handler(r0.getLooper());
        m = $$Lambda$a$OzaDy7kXljGiDTUDxaw2qWfk5H8.INSTANCE;
        n = new d();
        o = new c();
        p = new C0326a();
        q = new b();
        String r1 = com.bytedance.common.utility.c.a("ro.os.ota.version");
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        String r4 = "userroot";
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userroot", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L9;
    L15:
        r = r4;
        return;
    L9:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userdebug", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L12;
        r4 = "userdebug";
        goto L15
    L12:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("user", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L14;
        r4 = "user";
        goto L15
    L14:
        r4 = SensitiveType.UNKNOWN;
        goto L15
    }

    private static final void f() {
        a r0 = f16126a;
        l = false;
        r0.b("delayed_retry");
    }

    public final h a() {
        h r1 = h;
        o.c(r1, "instance");
        return r1;
    }

    public final void a(com.obric.aiagent.applog.a r8) {
        o.e(r8, "configInfo");
        f16127b = true;
        ILogDepend.Companion.i(TAG, "init: called, configInfo = " + r8);
        f16128c = r8;
        p r1 = new p(String.valueOf(r8.a()), r8.f());
        r1.b(r8.b());
        r1.a(com.obric.aiagent.applog.impl.c.f16134a.a(r8.g()));
        r1.a((ai) ZeusTransformUtils.preCheckCast(o, ai.class, "com.obric.aiagent.plugin"));
        boolean r2 = false;
        r1.a(false);
        r1.c(true);
        r1.a(r8.c());
        r1.c(r8.d());
        r1.b(r8.e());
        r1.d(r8.i());
        r1.a((ah) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.applog.impl.b("AiagentAppLog_" + r8.a()), ah.class, "com.obric.aiagent.plugin"));
        if (IAppContext.Companion.isTestChannel() == false) goto L5;
    L6:
        r2 = true;
    L7:
        r1.e(r2);
        r1.a("zh-cn");
        r1.b(true);
        com.obric.aiagent.applog.impl.c.f16134a.a(r1);
        h r3 = h;
        r3.a(!r8.h());
        r3.b(r8.j());
        r3.e(r8.k());
        r3.f(r8.l());
        com.bytedance.applog.monitor.v3.c.h = r8.m();
        com.bytedance.applog.monitor.v3.c.i = r8.n();
        com.bytedance.applog.monitor.v3.c.f = r8.o();
        com.bytedance.applog.monitor.v3.c.f5777e = r8.p();
        com.bytedance.applog.a.b.f5495a = r8.q();
        com.bytedance.applog.a.b.g = r8.r();
        com.bytedance.applog.a.b.f = r8.s();
        r3.g(true);
        com.bytedance.applog.a.a($$Lambda$a$758HLFnH_EWd1PXAyhGZcUJdhI.INSTANCE);
        r3.a((com.bytedance.applog.collector.a) ZeusTransformUtils.preCheckCast(q, com.bytedance.applog.collector.a.class, "com.obric.aiagent.plugin"));
        r3.a((i) ZeusTransformUtils.preCheckCast(p, i.class, "com.obric.aiagent.plugin"));
        r3.c(true);
        r3.a((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1);
        b();
        return;
    L5:
        if (IAppContext.Companion.isDebugChannel() == false) goto L7;
        goto L6
    }

    private static final HashMap a(ar r4) {
        HashMap r5 = new HashMap();
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin")).put("flow_app_variant", String.valueOf(com.obric.aiagent.assistant.ipc.a.f16298a.b()));
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin")).put("obric_os_build_type", r);
        return r5;
    }

    private static final x a(boolean r0) {
        if (r0 == false) goto L4;
        h.c();
    L6:
        return x.f38692a;
    L4:
        h.d();
        goto L6
    }

    public final void b() {
        $$Lambda$a$Ud8ypXP7WMDktJepJ6jdan6smaQ r3 = $$Lambda$a$Ud8ypXP7WMDktJepJ6jdan6smaQ.INSTANCE;
        r3.invoke(Boolean.valueOf(com.obric.aiagent.utils.a.b.f22307a.a()));
        com.obric.aiagent.utils.a.b.f22307a.a((com.obric.aiagent.utils.a.b.a) ZeusTransformUtils.preCheckCast(new e(r3), com.obric.aiagent.utils.a.b.a.class, "com.obric.aiagent.plugin"));
    }

    private final void a(String r3, String r4) {
        if (o.a(r3, "0") == false) goto L6;
        a(r4);
        return;
    L6:
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        boolean r1 = true;
    L13:
        if (r1 == true) goto L16;
        b(r4, r3);
        return;
    L16:
        return;
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L13
    }

    private final void a(String r5) {
        if (k < 10) goto L7;
        ISecureLogDepend.Companion.i(TAG, "skip schedule resetAndReInstall in " + r5 + ": reach max times = 10");
        return;
    L7:
        if (l == false) goto L10;
        ISecureLogDepend.Companion.i(TAG, "skip schedule resetAndReInstall in " + r5 + ": already pending");
        return;
    L10:
        l = true;
        ISecureLogDepend.Companion.w(TAG, "schedule resetAndReInstall in " + r5 + " after 2000ms, current times = " + k, (Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException(), Throwable.class, "com.obric.aiagent.plugin"));
        j.postDelayed(m, 2000);
    }

    private final void b(String r5) {
        if (k < 10) goto L6;
        ISecureLogDepend.Companion.i(TAG, "resetAndReInstall skipped in " + r5 + ": reach max times = 10");
        return;
    L6:
        k++;
        ISecureLogDepend.Companion.w(TAG, "resetAndReInstall triggered in " + r5 + ", times = " + k + ", timeout = 5000ms", (Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException(), Throwable.class, "com.obric.aiagent.plugin"));
        com.bytedance.applog.a.a(5000, (as) ZeusTransformUtils.preCheckCast(n, as.class, "com.obric.aiagent.plugin"));
    }

    private final void b(String r3, String r4) {
        if (l == true) goto L5;
        return;
    L5:
        l = false;
        j.removeCallbacks(m);
        ISecureLogDepend.Companion.i(TAG, "cancel pending resetAndReInstall in " + r3 + " because did recovered: " + r4);
    }

    private final void a(boolean r17, String r18, String r19, String r20, String r21, String r22, String r23) {
        com.obric.aiagent.applog.a r7 = f16128c;
        boolean r8 = true;
        if (r7 != null) goto L5;
    L7:
        r8 = false;
    L9:
        if (r8 == false) goto L11;
        ISecureLogDepend.Companion.w(TAG, "onRemoteIdGet: called, changed = " + r17 + ", oldDid = " + r18 + ", newDid = " + r19 + ", oldIid = " + r20 + ", newIid = " + r21 + ", oldSsid = " + r22 + ", newSsid = " + r23, (Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException(), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        ISecureLogDepend.Companion.i(TAG, "onRemoteIdGet: called, changed = " + r17 + ", oldDid = " + r18 + ", newDid = " + r19 + ", oldIid = " + r20 + ", newIid = " + r21 + ", oldSsid = " + r22 + ", newSsid = " + r23);
        return;
    L5:
        if (r7.h() != true) goto L7;
        goto L7
    }

    private final void a(String r6, String r7, String r8) {
        com.obric.aiagent.applog.a r5 = f16128c;
        boolean r0 = true;
        if (r5 != null) goto L5;
    L7:
        r0 = false;
    L9:
        if (r0 == false) goto L11;
        ISecureLogDepend.Companion.w(TAG, "onIdLoaded: did = " + r6 + ", iid = " + r7 + ", ssid = " + r8, (Throwable) ZeusTransformUtils.preCheckCast(new RuntimeException(), Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        ISecureLogDepend.Companion.i(TAG, "onIdLoaded: did = " + r6 + ", iid = " + r7 + ", ssid = " + r8);
        return;
    L5:
        if (r5.h() != true) goto L7;
        goto L7
    }

    public final void a(com.obric.aiagent.applog.b r2) {
        com.obric.aiagent.applog.b r1 = (com.obric.aiagent.applog.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.applog.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        f16129d.add(r1);
    }

    public final void b(com.obric.aiagent.applog.b r2) {
        com.obric.aiagent.applog.b r1 = (com.obric.aiagent.applog.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.aiagent.applog.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "listener");
        f16129d.remove(r1);
    }

    private final void b(String r5, String r6, String r7) {
        ISecureLogDepend.Companion r4 = ISecureLogDepend.Companion;
        StringBuilder r8 = new StringBuilder().append("updateBdTuringId: ").append(r7).append(", did empty? ");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        StringBuilder r9 = r8.append(r1).append(", iid empty? ");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L12;
    L13:
        r2 = true;
    L14:
        r4.i(TAG, r9.append(r2).toString());
        BdTuringConfig r10 = com.bytedance.bdturing.b.a().b();
        if (r10 == null) goto L17;
        r10.setDeviceId(r5);
    L17:
        BdTuringConfig r11 = com.bytedance.bdturing.b.a().b();
        if (r11 == null) goto L21;
        r11.setInstallId(r6);
        return;
    L21:
        return;
    L12:
        if (r3.length() != 0) goto L14;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void a(String r7, JSONObject r8) {
        o.e(r7, "event");
        if (r8 != null) goto L5;
        r8 = new JSONObject();
    L5:
        ISecureLogDepend.Companion.i(TAG, r7 + ": " + r8);
        Iterator<Map.Entry<String, d.h.a.a<Object>>> r0 = f16130e.entrySet().iterator();     // Catch: Exception -> L18
    L8:
        if (r0.hasNext() == false) goto L13;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        Object r2 = ((d.h.a.a) ZeusTransformUtils.preCheckCast(r1.getValue(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Exception -> L18
        if (r8.has(r3) == true) goto L8;
        if (r2 == null) goto L8;
        r8.put(r3, r2);     // Catch: Exception -> L18
        goto L8
    L13:
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Exception -> L18
    L14:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18
        f16126a.a(r8, (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), r5.getValue());     // Catch: Exception -> L18
    L20:
        h.a(r7, r8);
        return;
    L18:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "reportEvent: JSONObject Params error: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L20
    }

    public final void a(String r7, Bundle r8) {
        o.e(r7, "event");
        ISecureLogDepend.Companion.i(TAG, r7 + ": " + r8);
        if (r8 != null) goto L23;
        r8 = new Bundle();
    L23:
        Iterator<Map.Entry<String, d.h.a.a<Object>>> r0 = f16130e.entrySet().iterator();     // Catch: Exception -> L19
    L7:
        if (r0.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        Object r2 = ((d.h.a.a) ZeusTransformUtils.preCheckCast(r1.getValue(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Exception -> L19
        if (r8.containsKey(r3) == true) goto L7;
        if (r2 == null) goto L7;
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        r8.putString(r3, (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L19
        goto L7
    L14:
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(f, Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Exception -> L19
    L15:
        if (r4.hasNext() == false) goto L21;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L19
        f16126a.a(r8, (String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.aiagent.plugin"), r5.getValue());     // Catch: Exception -> L19
    L21:
        h.a(r7, r8);
        return;
    L19:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "reportEvent: Bundle Params error: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L21
    }

    public final void c() {
        com.obric.aiagent.applog.a r5 = f16128c;
        if (r5 == null) goto L6;
        com.bytedance.applog.util.h.a(String.valueOf(r5.a()), true, (Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        com.bytedance.applog.util.h.a(String.valueOf(r5.a()), "https://log.snssdk.com");
        return;
    }

    private final void a(JSONObject r3, String r4, Object r5) {
        if (r3.has(r4) == false) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L9;
        r3.put(r4, r5);
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L12;
        r3.put(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L15;
        r3.put(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L17;
        r3.put(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L17:
        ILogDepend.Companion.e(TAG, "addToJSONObject -> unsupported type: " + r5.getClass().getName());
        x r2 = x.f38692a;
    }

    private final void a(Bundle r3, String r4, Object r5) {
        if (r3.containsKey(r4) == false) goto L6;
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L9;
        r3.putString(r4, (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L12;
        r3.putInt(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L15;
        r3.putLong(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).longValue());
        return;
    L15:
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == false) goto L17;
        r3.putBoolean(r4, ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
        return;
    L17:
        ILogDepend.Companion.e(TAG, "addToBundle -> unsupported type: " + r5.getClass().getName());
    }
}
