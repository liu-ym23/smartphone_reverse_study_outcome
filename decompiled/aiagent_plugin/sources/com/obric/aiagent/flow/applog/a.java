package com.obric.aiagent.flow.applog;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogDataObserverIDL;
import com.obric.aiagent.flow.applog.idl.IFlowAppLogIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.m;
import d.n;
import d.s;
import d.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: FlowAppLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "FlowAppLog";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f18578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f18579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f18580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f18581e;
    private static String f;
    private static IBinder g;
    private static IFlowAppLogIDL h;
    private static IBinder.DeathRecipient i;
    private static volatile boolean j;
    private static volatile boolean k;
    private static int l;
    private static long m;
    private static final HandlerThread n = null;
    private static final Handler o = null;
    private static final Runnable p = null;
    private static final C0386a<b> q = null;
    private static final C0386a<b> r = null;
    private static final C0386a<String> s = null;
    private static final C0386a<m<String, JSONObject>> t = null;
    private static final C0386a<m<String, Bundle>> u = null;
    private static final C0386a<d.h.a.a<x>> v = null;
    private static final FlowAppLog$dataObserver$1 w = null;
    private static final FlowAppLog$serviceConnection$1 x = null;

    /* JADX INFO: renamed from: com.obric.aiagent.flow.applog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FlowAppLog.kt */
    public static final class C0386a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<T> f18583b;

        public C0386a(int r3) {
            this.f18582a = r3;
            this.f18583b = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
        }

        public final void a(T r3) {
            List<T> r0 = this.f18583b;
            o.c(r0, "list");
            monitor-enter(r0);
            this.f18583b.add(r3);     // Catch: Throwable -> L11
        L6:
            if (this.f18583b.size() <= this.f18582a) goto L8;
            List<T> r4 = this.f18583b;     // Catch: Throwable -> L11
            o.c(r4, "list");     // Catch: Throwable -> L11
            p.e(r4);     // Catch: Throwable -> L11
            goto L6
        L8:
            x r2 = x.f38692a;     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public final List<T> a() {
            List<T> r0 = this.f18583b;
            o.c(r0, "list");
            monitor-enter(r0);
            List<T> r3 = this.f18583b;     // Catch: Throwable -> L7
            o.c(r3, "list");     // Catch: Throwable -> L7
            List<T> r4 = p.o((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            monitor-exit(r0);
            return r4;
        L7:
            th = move-exception;
            throw th;
        }

        public final void b() {
            List<T> r0 = this.f18583b;
            o.c(r0, "list");
            monitor-enter(r0);
            this.f18583b.clear();     // Catch: Throwable -> L7
            x r2 = x.f38692a;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ void lambda$0eD_eewnUuMIudjAJ2fLCK3Thqo() {
        m();
    }

    /* JADX INFO: renamed from: lambda$AHO2-v3RsSVxMR0pa8jdUZTgx2U, reason: not valid java name */
    public static /* synthetic */ void m193lambda$AHO2v3RsSVxMR0pa8jdUZTgx2U(List r0, List r1, List r2, List r3, List r4, List r5) {
        a(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ x lambda$AZqeANDwH0j3luXq6JsLEI0KRsc(IFlowAppLogDataObserverIDL r0) {
        return d(r0);
    }

    public static /* synthetic */ x lambda$D8P9cwqcs2LkgqZlk1F4RY9XBUk(IFlowAppLogDataObserverIDL r0) {
        return c(r0);
    }

    public static /* synthetic */ x lambda$E71IAGp7zdjQeX01ZGy4aTt_7kI() {
        return n();
    }

    public static /* synthetic */ x lambda$HA2GUAQbqN2hQe6uWSOuvRCzyZU(String r0) {
        return h(r0);
    }

    /* JADX INFO: renamed from: lambda$JkwXBigmHZ6z68HuIk-45JaLa74, reason: not valid java name */
    public static /* synthetic */ x m194lambda$JkwXBigmHZ6z68HuIk45JaLa74(String r0, int r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ void lambda$Okoh1tDMBuznGK7ZbrFpnWT0Pxo(List r0) {
        a(r0);
    }

    public static /* synthetic */ x lambda$pZdZyK_O5asuCzX0cyo0WNPjCfA() {
        return p();
    }

    public static /* synthetic */ x lambda$z1AnU3BOfDJVVZsw7WyDQF7I24Q(Map r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$zvraQGMm0uTUdI5w-637QWU9PrM, reason: not valid java name */
    public static /* synthetic */ x m195lambda$zvraQGMm0uTUdI5w637QWU9PrM() {
        return o();
    }

    private a() {
    }

    public static final /* synthetic */ void a(IBinder r2) {
        g = (IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(a r0) {
        r0.i();
    }

    public static final /* synthetic */ void a(IFlowAppLogIDL r2) {
        h = (IFlowAppLogIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogIDL.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(boolean r0) {
        j = r0;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.h();
    }

    public static final /* synthetic */ void b(boolean r0) {
        k = r0;
    }

    public static final /* synthetic */ void c(a r0) {
        r0.j();
    }

    public static final /* synthetic */ void c(String r0) {
        f18579c = r0;
    }

    public static final /* synthetic */ void d(a r0) {
        r0.k();
    }

    public static final /* synthetic */ void d(String r0) {
        f18580d = r0;
    }

    public static final /* synthetic */ void e(a r0) {
        r0.f();
    }

    public static final /* synthetic */ void e(String r0) {
        f18581e = r0;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.aiagent.flow.applog.FlowAppLog$dataObserver$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.obric.aiagent.flow.applog.FlowAppLog$serviceConnection$1] */
    static {
        f18577a = new a();
        l = 1;
        m = -1;
        HandlerThread r0 = new HandlerThread(TAG);
        r0.start();
        n = r0;
        o = new Handler(r0.getLooper());
        p = $$Lambda$a$0eD_eewnUuMIudjAJ2fLCK3Thqo.INSTANCE;
        q = new C0386a(10);
        r = new C0386a(100);
        s = new C0386a(DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        t = new C0386a(DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        u = new C0386a(DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        v = new C0386a(100);
        w = new FlowAppLog$dataObserver$1();
        x = new FlowAppLog$serviceConnection$1();
    }

    private static final void m() {
        a r0 = f18577a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (j == true) goto L7;
    L10:
        x r1 = x.f38692a;     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L7:
        if (m <= 0) goto L10;
        ILogDepend.Companion.i(TAG, "auto unbind triggered, delayMs: " + m);     // Catch: Throwable -> L13
        r0.k();     // Catch: Throwable -> L13
        goto L10
    }

    private final void f() {
        C0386a<b> r5 = r;     // Catch: Exception -> L14
        monitor-enter(r5);     // Catch: Exception -> L14
        final List<b> r0 = r5.a();     // Catch: Throwable -> L11
        monitor-exit(r5);     // Catch: Exception -> L14
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Exception -> L14
    L8:
        if (r6.hasNext() == false) goto L10;
        ((b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin")).b();     // Catch: Exception -> L14
        goto L8
    L10:
        o.post(new $$Lambda$a$Okoh1tDMBuznGK7ZbrFpnWT0Pxo(r0));     // Catch: Exception -> L14
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "handleDisconnectListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private static final void a(List r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L9
    L5:
        if (r5.hasNext() == false) goto L7;
        ((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.aiagent.plugin")).b();     // Catch: Throwable -> L9
        goto L5
    L7:
        Object r6 = n.f(x.f38692a);     // Catch: Throwable -> L9
    L11:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L18;
        ILogDepend.Companion.e(TAG, "handleDisconnectListener async error", r7);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        n.a r1 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L11
    }

    private final void g() {
        C0386a<b> r8 = q;     // Catch: Exception -> L45
        monitor-enter(r8);     // Catch: Exception -> L45
        final List<b> r1 = r8.a();     // Catch: Throwable -> L42
        r8.b();     // Catch: Throwable -> L42
        monitor-exit(r8);     // Catch: Exception -> L45
        C0386a<b> r9 = r;     // Catch: Exception -> L45
        monitor-enter(r9);     // Catch: Exception -> L45
        final List<b> r2 = r9.a();     // Catch: Throwable -> L39
        monitor-exit(r9);     // Catch: Exception -> L45
        C0386a<String> r10 = s;     // Catch: Exception -> L45
        monitor-enter(r10);     // Catch: Exception -> L45
        final List<String> r3 = r10.a();     // Catch: Throwable -> L36
        r10.b();     // Catch: Throwable -> L36
        monitor-exit(r10);     // Catch: Exception -> L45
        C0386a<m<String, JSONObject>> r11 = t;     // Catch: Exception -> L45
        monitor-enter(r11);     // Catch: Exception -> L45
        final List<m<String, JSONObject>> r4 = r11.a();     // Catch: Throwable -> L33
        r11.b();     // Catch: Throwable -> L33
        monitor-exit(r11);     // Catch: Exception -> L45
        C0386a<m<String, Bundle>> r12 = u;     // Catch: Exception -> L45
        monitor-enter(r12);     // Catch: Exception -> L45
        final List<m<String, Bundle>> r5 = r12.a();     // Catch: Throwable -> L30
        r12.b();     // Catch: Throwable -> L30
        monitor-exit(r12);     // Catch: Exception -> L45
        C0386a<d.h.a.a<x>> r13 = v;     // Catch: Exception -> L45
        monitor-enter(r13);     // Catch: Exception -> L45
        final List<d.h.a.a<x>> r6 = r13.a();     // Catch: Throwable -> L27
        r13.b();     // Catch: Throwable -> L27
        monitor-exit(r13);     // Catch: Exception -> L45
        o.post(new $$Lambda$a$AHO2v3RsSVxMR0pa8jdUZTgx2U(r1, r2, r3, r4, r5, r6));     // Catch: Exception -> L45
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L36:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L39:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L42:
        th = move-exception;
        throw th;     // Catch: Exception -> L45
    L45:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "handleCacheAndListener error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    private static final void a(List r4, List r5, List r6, List r7, List r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        a r0 = f18577a;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L29
        r0.a((IFlowAppLogDataObserverIDL) ZeusTransformUtils.preCheckCast(w, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L29
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L5:
        if (r16.hasNext() == false) goto L7;
        ((b) ZeusTransformUtils.preCheckCast(r16.next(), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L29
        goto L5
    L7:
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L9:
        if (r17.hasNext() == false) goto L11;
        ((b) ZeusTransformUtils.preCheckCast(r17.next(), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L29
        goto L9
    L11:
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L13:
        if (r18.hasNext() == false) goto L15;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        f18577a.a(r19);     // Catch: Throwable -> L29
        goto L13
    L15:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L17:
        if (r20.hasNext() == false) goto L19;
        m r21 = (m) ZeusTransformUtils.preCheckCast(r20.next(), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        f18577a.a((String) ZeusTransformUtils.preCheckCast(r21.a(), String.class, "com.obric.aiagent.plugin"), (JSONObject) ZeusTransformUtils.preCheckCast(r21.b(), JSONObject.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L29
        goto L17
    L19:
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L21:
        if (r22.hasNext() == false) goto L23;
        m r23 = (m) ZeusTransformUtils.preCheckCast(r22.next(), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        f18577a.a((String) ZeusTransformUtils.preCheckCast(r23.a(), String.class, "com.obric.aiagent.plugin"), (Bundle) ZeusTransformUtils.preCheckCast(r23.b(), Bundle.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L29
        goto L21
    L23:
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L29
    L25:
        if (r24.hasNext() == false) goto L27;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r24.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();     // Catch: Throwable -> L29
        goto L25
    L27:
        Object r25 = n.f(x.f38692a);     // Catch: Throwable -> L29
    L31:
        Throwable r26 = n.c(r25);
        if (r26 == null) goto L43;
        ILogDepend.Companion.e(TAG, "handleCacheAndListener async error", r26);
        return;
    L43:
        return;
    L29:
        th = move-exception;
        n.a r27 = n.f38560a;
        r25 = n.f(d.o.a(th));
        goto L31
    }

    private final void h() {
        monitor-enter(this);
        f18577a.j();     // Catch: Throwable -> L36
        x r0 = x.f38692a;     // Catch: Throwable -> L36
        monitor-exit(this);
        n.a r1 = n.f38560a;     // Catch: Throwable -> L23
        final a r4 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        IBinder.DeathRecipient r2 = new FlowAppLog$handleConnected$2$dr$1(r4);     // Catch: Throwable -> L23
        monitor-enter(r4);     // Catch: Throwable -> L23
        IBinder r3 = g;     // Catch: Throwable -> L20
        if (r3 == null) goto L10;
        r3.linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r2, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: Throwable -> L20
    L10:
        i = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(r2, IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        x r5 = x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(r4);     // Catch: Throwable -> L23
        r4.g();     // Catch: Throwable -> L23
        monitor-enter(r4);     // Catch: Throwable -> L23
        r4.g("service connected");     // Catch: Throwable -> L17
        x r6 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L23
        ILogDepend.Companion.i(TAG, "handleConnected: linkToDeath success");     // Catch: Throwable -> L23
        Object r7 = n.f(x.f38692a);     // Catch: Throwable -> L23
    L25:
        Throwable r8 = n.c(r7);
        if (r8 == null) goto L35;
        ILogDepend.Companion.e(TAG, "handleConnected: fail " + d.a.a(r8), r8);
        a r9 = f18577a;
        monitor-enter(r9);
        r9.j();     // Catch: Throwable -> L32
        r9.k();     // Catch: Throwable -> L32
        g = null;     // Catch: Throwable -> L32
        h = null;     // Catch: Throwable -> L32
        x r10 = x.f38692a;     // Catch: Throwable -> L32
        monitor-exit(r9);
        return;
    L32:
        th = move-exception;
        throw th;
    L35:
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        n.a r11 = n.f38560a;
        r7 = n.f(d.o.a(th));
    L36:
        th = move-exception;
        throw th;
    }

    private final void i() {
        monitor-enter(this);
        a r0 = f18577a;     // Catch: Throwable -> L6
        r0.j();     // Catch: Throwable -> L6
        r0.k();     // Catch: Throwable -> L6
        g = null;     // Catch: Throwable -> L6
        h = null;     // Catch: Throwable -> L6
        x r1 = x.f38692a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final void j() {
        IBinder.DeathRecipient r2 = i;
        if (r2 == null) goto L15;
        IBinder r0 = g;
        if (r0 != null) goto L13;
    L11:
        i = null;
        return;
    L13:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        Object r3 = n.f(Boolean.valueOf(r0.unlinkToDeath(r2, 0)));     // Catch: Throwable -> L8
    L10:
        n.g(r3);
    L8:
        th = move-exception;
        n.a r4 = n.f38560a;
        r3 = n.f(d.o.a(th));
        goto L10
    }

    private final void k() {
        if (j == true) goto L5;
        return;
    L5:
        f("safeUnbind");
        h = null;
        j = false;
        k = false;
        j();
        Context r4 = f18578b;
        if (r4 == null) goto L18;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        ZeusTransformUtils.unbindService(r4, (ServiceConnection) ZeusTransformUtils.preCheckCast(x, ServiceConnection.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L9
    L11:
        Throwable r0 = n.c(r5);
        if (r0 == null) goto L14;
        ILogDepend.Companion.e(TAG, "safeUnbind error", r0);
    L14:
        n.g(r5);
        return;
    L9:
        th = move-exception;
        n.a r2 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L11
    }

    private final void a(long r4) {
        m = r4;
        if (r4 > 0) goto L6;
        f("disabled");
        ILogDepend.Companion.i(TAG, "auto unbind disabled, delay: " + r4);
        return;
    L6:
        ILogDepend.Companion.i(TAG, "auto unbind enabled, delay: " + r4);
    }

    private final void f(String r3) {
        o.removeCallbacks(p);
        ILogDepend.Companion.i(TAG, "cancelAutoUnbindLocked, reason: " + r3);
    }

    private final void g(String r5) {
        long r0 = m;
        f("reschedule: " + r5);
        if (r0 > 0) goto L5;
        return;
    L5:
        if (j == false) goto L10;
        o.postDelayed(p, r0);
        ILogDepend.Companion.i(TAG, "scheduleAutoUnbindLocked, delayMs: " + r0 + ", reason: " + r5);
        return;
    }

    public static /* synthetic */ void a(a r3, Context r4, b r5, int r6, long r7, int r9, Object r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        b r11 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        if ((r9 & 4) == 0) goto L5;
        r6 = 1;
    L5:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L8;
        r7 = -1;
    L8:
        r3.a(r8, r11, r0, r7);
    }

    public final void a(Context r3, b r4, int r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r8, "listener");
        monitor-enter(this);
        a r0 = f18577a;     // Catch: Throwable -> L17
        r0.a(r6);     // Catch: Throwable -> L17
        if (j == false) goto L10;
        ILogDepend.Companion.i(TAG, "has bind success, skip bind");     // Catch: Throwable -> L17
        r8.a();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L10:
        if (k == false) goto L14;
        ILogDepend.Companion.i(TAG, "is binding, skip bind");     // Catch: Throwable -> L17
        q.a(r8);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        ILogDepend.Companion.i(TAG, "bind: " + r5 + ", context: " + r7);     // Catch: Throwable -> L17
        l = r5;     // Catch: Throwable -> L17
        f18578b = r7;     // Catch: Throwable -> L17
        r0.l();     // Catch: Throwable -> L17
        x r9 = x.f38692a;     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private final void l() {
        if (j == false) goto L5;
    L38:
        ILogDepend.Companion.i(TAG, "has binded or binding, skip executeBind, onBindSuccess: " + j + ", isBinding: " + k);
        return;
    L5:
        if (k == true) goto L38;
        if (f18578b != null) goto L11;
        ILogDepend.Companion.i(TAG, "context is null, skip executeBind");
        return;
    L11:
        ILogDepend.Companion.i(TAG, "executeBind: " + d.a.a(new Throwable()));
        k();
        ILogDepend.Companion.i(TAG, "executeBind started");
        Intent r7 = new Intent("com.obric.memorydata.awareness.FLOW_APPLOG_IPC");
        r7.setPackage("com.larus.nova");
        Context r0 = f18578b;
        String r2 = null;
        if (r0 != null) goto L40;
        n r8 = null;
    L22:
        boolean r1 = false;
        if (r8 == null) goto L28;
        Object r4 = r8.a();
        if (n.b(r4) == false) goto L27;
        r4 = false;
    L27:
        r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L28:
        if (r8 == null) goto L30;
        Throwable r9 = n.c(r8.a());
    L31:
        if (r1 == false) goto L33;
        k = true;
    L33:
        ILogDepend.Companion r3 = ILogDepend.Companion;
        StringBuilder r5 = new StringBuilder().append("bind res: ").append(r1).append(", error: ");
        if (r9 == null) goto L36;
        r2 = d.a.a(r9);
    L36:
        r3.i(TAG, r5.append(r2).toString());
        return;
    L30:
        r9 = null;
        goto L31
    L40:
        n.a r6 = n.f38560a;     // Catch: Throwable -> L15
        ZeusTransformUtils.startService(r0, r7, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        Object r10 = n.f(Boolean.valueOf(ZeusTransformUtils.bindService(r0, r7, (ServiceConnection) ZeusTransformUtils.preCheckCast(x, ServiceConnection.class, "com.obric.aiagent.plugin"), 32, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L15
    L17:
        Throwable r11 = n.c(r10);
        if (r11 == null) goto L20;
        ILogDepend.Companion.e(TAG, "executeBind error: " + r11.getMessage(), r11);
    L20:
        r8 = n.g(r10);
    L15:
        th = move-exception;
        n.a r12 = n.f38560a;
        r10 = n.f(d.o.a(th));
        goto L17
    }

    public final void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (j == false) goto L7;
        r4.a();     // Catch: Throwable -> L11
    L8:
        r.a(r4);     // Catch: Throwable -> L11
        x r5 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L7:
        f18577a.l();     // Catch: Throwable -> L11
        goto L8
    }

    public final void a(Map<Object, Object> r6) {
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "setHeaderInfo, params: " + r7 + ", onBindSuccess: " + j);     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "setHeaderInfo error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L19:
        x r8 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (j == false) goto L15;
        IFlowAppLogIDL r0 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        o.a(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.setHeaderInfo(r7);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f18577a.g("setHeaderInfo");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        v.a(new $$Lambda$a$z1AnU3BOfDJVVZsw7WyDQF7I24Q(r7));     // Catch: Exception -> L17 Throwable -> L22
        f18577a.l();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static final x b(Map r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.setHeaderInfo(r3);
    L6:
        return x.f38692a;
    }

    public final void a(String r6) {
        o.e(r6, "event");
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L18:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onEventV3 error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L20:
        x r7 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L5:
        if (j == false) goto L14;
        IFlowAppLogIDL r0 = h;     // Catch: Throwable -> L16 Exception -> L18
        if (r0 == null) goto L14;
        o.a(r0);     // Catch: Throwable -> L16 Exception -> L18
        if (r0.asBinder().isBinderAlive() == false) goto L14;
        IFlowAppLogIDL r1 = h;     // Catch: Throwable -> L16 Exception -> L18
        if (r1 == null) goto L13;
        r1.onEventV3(r6);     // Catch: Throwable -> L16 Exception -> L18
    L13:
        f18577a.g("onEventV3");     // Catch: Throwable -> L16 Exception -> L18
    L14:
        s.a(r6);     // Catch: Throwable -> L16 Exception -> L18
        f18577a.l();     // Catch: Throwable -> L16 Exception -> L18
        goto L20
    }

    public final void a(String r5, JSONObject r6) {
        o.e(r5, "event");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onEventV3Json error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
    L23:
        x r7 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L5:
        if (j == false) goto L17;
        IFlowAppLogIDL r0 = h;     // Catch: Throwable -> L19 Exception -> L21
        if (r0 == null) goto L17;
        o.a(r0);     // Catch: Throwable -> L19 Exception -> L21
        if (r0.asBinder().isBinderAlive() == false) goto L17;
        IFlowAppLogIDL r1 = h;     // Catch: Throwable -> L19 Exception -> L21
        if (r1 == null) goto L16;
        if (r6 == null) goto L14;
        String r8 = r6.toString();     // Catch: Throwable -> L19 Exception -> L21
    L15:
        r1.onEventV3Json(r5, r8);     // Catch: Throwable -> L19 Exception -> L21
        goto L16
    L14:
        r8 = null;
    L16:
        f18577a.g("onEventV3Json");     // Catch: Throwable -> L19 Exception -> L21
    L17:
        t.a(s.a(r5, r6));     // Catch: Throwable -> L19 Exception -> L21
        f18577a.l();     // Catch: Throwable -> L19 Exception -> L21
        goto L23
    }

    public final void a(String r5, Bundle r6) {
        o.e(r5, "event");
        monitor-enter(this);
    L18:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onEventV3Bundle error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
    L20:
        x r7 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L5:
        if (j == false) goto L14;
        IFlowAppLogIDL r0 = h;     // Catch: Throwable -> L16 Exception -> L18
        if (r0 == null) goto L14;
        o.a(r0);     // Catch: Throwable -> L16 Exception -> L18
        if (r0.asBinder().isBinderAlive() == false) goto L14;
        IFlowAppLogIDL r1 = h;     // Catch: Throwable -> L16 Exception -> L18
        if (r1 == null) goto L13;
        r1.onEventV3Bundle(r5, r6);     // Catch: Throwable -> L16 Exception -> L18
    L13:
        f18577a.g("onEventV3Bundle");     // Catch: Throwable -> L16 Exception -> L18
    L14:
        u.a(s.a(r5, r6));     // Catch: Throwable -> L16 Exception -> L18
        f18577a.l();     // Catch: Throwable -> L16 Exception -> L18
    L16:
        th = move-exception;
        throw th;
    }

    public final void a(IFlowAppLogDataObserverIDL r6) {
        final IFlowAppLogDataObserverIDL r7 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        o.e(r7, "listener");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "addDataObserver");     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "addDataObserver error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L19:
        x r8 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (j == false) goto L15;
        IFlowAppLogIDL r0 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        o.a(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.addDataObserver(r7);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f18577a.g("addDataObserver");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        v.a(new $$Lambda$a$D8P9cwqcs2LkgqZlk1F4RY9XBUk(r7));     // Catch: Exception -> L17 Throwable -> L22
        f18577a.l();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static final x c(IFlowAppLogDataObserverIDL r2) {
        IFlowAppLogDataObserverIDL r3 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.addDataObserver(r3);
    L6:
        return x.f38692a;
    }

    public final void b(IFlowAppLogDataObserverIDL r6) {
        final IFlowAppLogDataObserverIDL r7 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r6, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        o.e(r7, "listener");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "removeDataObserver");     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "removeDataObserver error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L19:
        x r8 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (j == false) goto L15;
        IFlowAppLogIDL r0 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        o.a(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.removeDataObserver(r7);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f18577a.g("removeDataObserver");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        v.a(new $$Lambda$a$AZqeANDwH0j3luXq6JsLEI0KRsc(r7));     // Catch: Exception -> L17 Throwable -> L22
        f18577a.l();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static final x d(IFlowAppLogDataObserverIDL r2) {
        IFlowAppLogDataObserverIDL r3 = (IFlowAppLogDataObserverIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowAppLogDataObserverIDL.class, "com.obric.aiagent.plugin");
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.removeDataObserver(r3);
    L6:
        return x.f38692a;
    }

    public final void a(final String r5, final int r6) {
        o.e(r5, "activity");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "onResume");     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onResume error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L19:
        x r7 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (j == false) goto L15;
        IFlowAppLogIDL r0 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        o.a(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        ILogDepend.Companion.i(TAG, "onBindSuccess onResume " + r5);     // Catch: Exception -> L17 Throwable -> L22
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.onResume(r5, r6);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f18577a.g("onResume");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        ILogDepend.Companion.i(TAG, "Cache onResume " + r5);     // Catch: Exception -> L17 Throwable -> L22
        v.a(new $$Lambda$a$JkwXBigmHZ6z68HuIk45JaLa74(r5, r6));     // Catch: Exception -> L17 Throwable -> L22
        f18577a.l();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static final x b(String r3, int r4) {
        ILogDepend.Companion.i(TAG, "Cache onResume report " + r3);
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.onResume(r3, r4);
    L6:
        return x.f38692a;
    }

    public final void a() {
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "onPause");     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onPause error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L18:
        x r0 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L5:
        if (j == false) goto L14;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        o.a(r1);     // Catch: Exception -> L16 Throwable -> L21
        if (r1.asBinder().isBinderAlive() == false) goto L14;
        IFlowAppLogIDL r2 = h;     // Catch: Exception -> L16 Throwable -> L21
        if (r2 == null) goto L13;
        r2.onPause();     // Catch: Exception -> L16 Throwable -> L21
    L13:
        f18577a.g("onPause");     // Catch: Exception -> L16 Throwable -> L21
    L14:
        v.a($$Lambda$a$E71IAGp7zdjQeX01ZGy4aTt_7kI.INSTANCE);     // Catch: Exception -> L16 Throwable -> L21
        f18577a.l();     // Catch: Exception -> L16 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private static final x n() {
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.onPause();
    L6:
        return x.f38692a;
    }

    public final void b() {
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "onStop");     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "onStop error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L18:
        x r0 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L5:
        if (j == false) goto L14;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        o.a(r1);     // Catch: Exception -> L16 Throwable -> L21
        if (r1.asBinder().isBinderAlive() == false) goto L14;
        IFlowAppLogIDL r2 = h;     // Catch: Exception -> L16 Throwable -> L21
        if (r2 == null) goto L13;
        r2.onStop();     // Catch: Exception -> L16 Throwable -> L21
    L13:
        f18577a.g("onStop");     // Catch: Exception -> L16 Throwable -> L21
    L14:
        v.a($$Lambda$a$zvraQGMm0uTUdI5w637QWU9PrM.INSTANCE);     // Catch: Exception -> L16 Throwable -> L21
        f18577a.l();     // Catch: Exception -> L16 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private static final x o() {
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.onStop();
    L6:
        return x.f38692a;
    }

    public final void b(final String r6) {
        o.e(r6, "launchService");
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "setLaunchService " + r6);     // Catch: Throwable -> L22
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "setLaunchService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
    L19:
        x r7 = x.f38692a;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (j == false) goto L15;
        IFlowAppLogIDL r0 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r0 == null) goto L15;
        o.a(r0);     // Catch: Exception -> L17 Throwable -> L22
        if (r0.asBinder().isBinderAlive() == false) goto L15;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L17 Throwable -> L22
        if (r1 == null) goto L14;
        r1.setLaunchService(r6);     // Catch: Exception -> L17 Throwable -> L22
    L14:
        f18577a.g("setLaunchService");     // Catch: Exception -> L17 Throwable -> L22
    L15:
        v.a(new $$Lambda$a$HA2GUAQbqN2hQe6uWSOuvRCzyZU(r6));     // Catch: Exception -> L17 Throwable -> L22
        f18577a.l();     // Catch: Exception -> L17 Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private static final x h(String r1) {
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.setLaunchService(r1);
    L6:
        return x.f38692a;
    }

    public final void c() {
        monitor-enter(this);
        ILogDepend.Companion.i(TAG, "clearLaunchService");     // Catch: Throwable -> L21
    L16:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "clearLaunchService error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L21
    L18:
        x r0 = x.f38692a;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L5:
        if (j == false) goto L14;
        IFlowAppLogIDL r1 = h;     // Catch: Exception -> L16 Throwable -> L21
        if (r1 == null) goto L14;
        o.a(r1);     // Catch: Exception -> L16 Throwable -> L21
        if (r1.asBinder().isBinderAlive() == false) goto L14;
        IFlowAppLogIDL r2 = h;     // Catch: Exception -> L16 Throwable -> L21
        if (r2 == null) goto L13;
        r2.clearLaunchService();     // Catch: Exception -> L16 Throwable -> L21
    L13:
        f18577a.g("clearLaunchService");     // Catch: Exception -> L16 Throwable -> L21
    L14:
        v.a($$Lambda$a$pZdZyK_O5asuCzX0cyo0WNPjCfA.INSTANCE);     // Catch: Exception -> L16 Throwable -> L21
        f18577a.l();     // Catch: Exception -> L16 Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private static final x p() {
        IFlowAppLogIDL r0 = h;
        if (r0 == null) goto L6;
        r0.clearLaunchService();
    L6:
        return x.f38692a;
    }

    public final String d() {
        monitor-enter(this);
        String r1 = f18579c;     // Catch: Throwable -> L15 Exception -> L17
        if (r1 != null) goto L12;
        IFlowAppLogIDL r2 = h;     // Catch: Throwable -> L15 Exception -> L17
        if (r2 == null) goto L11;
        r1 = r2.getDid();     // Catch: Throwable -> L15 Exception -> L17
        if (r1 == null) goto L11;
        f18579c = r1;     // Catch: Throwable -> L15 Exception -> L17
    L11:
        r1 = null;
    L12:
        ISecureLogDepend.Companion.d(TAG, "getDid, res: " + r1);     // Catch: Throwable -> L15 Exception -> L17
        monitor-exit(this);
        return r1;
    L15:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getDid error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L15
        return null;
    }

    public final String e() {
        monitor-enter(this);
        String r0 = f;     // Catch: Throwable -> L16 Exception -> L18
        if (r0 != null) goto L13;
        IFlowAppLogIDL r1 = h;     // Catch: Throwable -> L16 Exception -> L18
        if (r1 == null) goto L10;
        r0 = r1.getUserID();     // Catch: Throwable -> L16 Exception -> L18
        if (r0 == null) goto L10;
        f = r0;     // Catch: Throwable -> L16 Exception -> L18
    L11:
        if (r0 != null) goto L13;
        r0 = "";
    L10:
        r0 = null;
    L13:
        ISecureLogDepend.Companion.d(TAG, "getUserID, res: " + r0);     // Catch: Throwable -> L16 Exception -> L18
        f18577a.g("getUserID");     // Catch: Throwable -> L16 Exception -> L18
        monitor-exit(this);
        return r0;
    L18:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getUserID error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16
        return "";
    L16:
        th = move-exception;
        throw th;
    }
}
