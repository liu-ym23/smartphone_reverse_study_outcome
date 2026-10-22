package com.bytedance.applet.event;

import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.p1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.f2;
import com.larus.platform.api.j2;
import com.larus.platform.api.p2;
import com.larus.platform.service.DoraAudioService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes14.dex */
public final class LocalPluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalPluginService f191791a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f191792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Integer f191793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static p2 f191794d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f191795e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final p f191796f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final q f191797g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CopyOnWriteArraySet<a> f191798h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CopyOnWriteArraySet<b> f191799i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CoroutineScope f191800j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CoroutineScope f191801k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final MutexImpl f191802l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f191803m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f191804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AtomicBoolean f191805o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AtomicBoolean f191806p = null;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void g(AppAction r100);
    }

    public interface b {
        void a();
    }

    public static final class c implements com.larus.platform.api.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f191807a = null;

        static {
            f191807a = new c();
        }

        public c() {
        }

        @Override // com.larus.platform.api.o
        public final void a(int r100) {
        }

        @Override // com.larus.platform.api.o
        public final void onStateChange(int r100) {
            LocalPluginService.f191804n = r100;
            boolean r101 = true;
            if (r100 != 1) goto L5;
            FLogger.f375446a.i("LocalPluginService", "Dora WAKE_OFF");
            LocalPluginService r102 = LocalPluginService.f191791a;
            LocalPluginService.c();
            return;
        L5:
            if (r100 != 2) goto L34;
            FLogger r103 = FLogger.f375446a;
            r103.i("LocalPluginService", "Dora WAKE_UP");
            LocalPluginService r104 = LocalPluginService.f191791a;
            if (LocalPluginService.d() == false) goto L35;
            p2 r105 = LocalPluginService.f191794d;
            if (r105 != null) goto L13;
        L15:
            r101 = false;
        L16:
            if (r101 == true) goto L19;
            return;
        L19:
            if (AppHost.f326268a.a().isAppBackground() == false) goto L37;
            LocalPluginService.g();
            p2 r106 = LocalPluginService.f191794d;
            if (r106 == null) goto L32;
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L25
            r103.i("LocalPluginService", "reconnectFrontier");     // Catch: Throwable -> L25
            r106.a(null, "localPlugin");     // Catch: Throwable -> L25
            t0.b(new s(), 4000);     // Catch: Throwable -> L25
            Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            Result.m9448boximpl(r108);
            return;
        L25:
            th = move-exception;
            Result.Companion r109 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L27
        L32:
            return;
        L37:
            return;
        L13:
            if (r105.c() != 0) goto L15;
        L35:
            return;
        }
    }

    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Key r100) {
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            if (AppHost.f326268a.isDebug() == true) goto L6;
            FLogger.f375446a.e("LocalPluginService", "error , msg = " + ExceptionsKt.stackTraceToString(r101));
            return;
        L6:
            throw r101;
        }
    }

    public LocalPluginService() {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.applet.event.p] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.applet.event.q] */
    static {
        f191791a = new LocalPluginService();
        f191792b = new Gson();
        f191796f = new p();
        f191797g = new q();
        f191798h = new CopyOnWriteArraySet();
        f191799i = new CopyOnWriteArraySet();
        f191800j = CoroutineScopeKt.MainScope();
        f191801k = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(new d(CoroutineExceptionHandler.Key)));
        f191802l = kotlinx.coroutines.sync.b.a();
        f191803m = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new r()));
        f191805o = new AtomicBoolean(false);
        f191806p = new AtomicBoolean(false);
    }

    public static boolean d() {
        boolean r100 = f2.f365106a.enableReconnectFrontierForDoraWhenBackground();
        FLogger.f375446a.i("LocalPluginService", "enable reconnect frontier for dora is " + r100);
        return r100;
    }

    public static void e() {
        if (f191806p.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(f191800j, null, null, new LocalPluginService$init$1(null), 3, null);
        if (d() == false) goto L11;
        Lazy r100 = DoraAudioService.f365699a;
        c r101 = c.f191807a;
        Intrinsics.checkNotNullParameter(r101, "callback");
        j2 r102 = DoraAudioService.c();
        if (r102 == null) goto L12;
        r102.f(r101);
        return;
    L12:
        return;
    }

    public static void g() {
        jw3.c r100 = jw3.c.f500706a;
        jw3.e r101 = jw3.c.f500709d.get();
        if (r101 == null) goto L26;
        int r102 = r101.e();
        FLogger.f375446a.i("LocalPluginService", "updateFrontier " + r102);
        Integer r103 = f191793c;
        if (r103 != null) goto L8;
    L9:
        f191793c = Integer.valueOf(r102);
        p2 r104 = f191794d;
        if (r104 == null) goto L12;
        r104.d(f191796f);
    L12:
        p2 r105 = f191794d;
        if (r105 == null) goto L15;
        r105.g(f191797g);
    L15:
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L18;
        p1 r107 = r106.B(r102);
    L19:
        f191794d = r107;
        if (r107 == null) goto L22;
        r107.b(f191796f);
    L22:
        p2 r108 = f191794d;
        if (r108 == null) goto L28;
        r108.i(f191797g);
        return;
    L28:
        return;
    L18:
        r107 = null;
        goto L19
    L8:
        if (r103.intValue() != r102) goto L9;
        return;
    }

    public static final void a() {
        if (d() == false) goto L17;
        p2 r100 = f191794d;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L12;
        return;
    L12:
        if (AppHost.f326268a.a().isAppBackground() == true) goto L14;
        return;
    L14:
        if (f191804n != 1) goto L20;
        c();
        return;
    L20:
        return;
    L7:
        if (r100.c() != 1) goto L9;
        r101 = true;
        goto L10
    }

    public static void c() {
        if (d() == true) goto L5;
        return;
    L5:
        p2 r100 = f191794d;
        if (r100 == null) goto L10;
        boolean r101 = true;
        if (r100.c() != 1) goto L10;
    L11:
        if (r101 == true) goto L14;
        return;
    L14:
        if (AppHost.f326268a.a().isAppBackground() == true) goto L17;
        return;
    L17:
        if (f191805o.get() == false) goto L19;
        return;
    L19:
        p2 r102 = f191794d;
        if (r102 == null) goto L29;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
        FLogger.f375446a.i("LocalPluginService", "disconnectFrontier");     // Catch: Throwable -> L23
        r102.h("localPlugin", false);     // Catch: Throwable -> L23
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L25:
        Result.m9448boximpl(r104);
        return;
    L23:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L29:
        return;
    L10:
        r101 = false;
        goto L11
    }

    public final Object f(byte[] r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof LocalPluginService$sendPayload$1) == false) goto L7;
        LocalPluginService$sendPayload$1 r102 = (LocalPluginService$sendPayload$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        Boolean r107 = (Boolean) r104;
        if (r107 == null) goto L20;
        boolean r108 = r107.booleanValue();
    L22:
        return Boxing.boxBoolean(r108);
    L20:
        r108 = false;
        goto L22
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        LocalPluginService$sendPayload$2 r109 = new LocalPluginService$sendPayload$2(r100, null);
        r102.label = 1;
        r104 = TimeoutKt.c(2000, r109, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new LocalPluginService$sendPayload$1(this, r101);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008a -> B:34:0x008f). Please report as a decompilation issue!!! */
    public static final Object b(LocalPluginService r100, byte[] r101, int r102, Object r110, Continuation r111) {
        r100.getClass();
        if ((r111 instanceof LocalPluginService$sendPayloadWithRetry$1) == false) goto L7;
        LocalPluginService$sendPayloadWithRetry$1 r103 = (LocalPluginService$sendPayloadWithRetry$1) r111;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L20;
        if (r106 != 1) goto L19;
        int r107 = r103.I$2;
        int r108 = r103.I$1;
        int r113 = r103.I$0;
        jw3.e r109 = (jw3.e) r103.L$2;
        Object r114 = r103.L$1;
        byte[] r115 = (byte[]) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L14 Exception -> L16
    L35:
        if (((Boolean) r105).booleanValue() == false) goto L39;
        FLogger.f375446a.i("LocalPluginService", "Send ack succeeded on attempt " + (r107 + 1));     // Catch: Throwable -> L14 Exception -> L16
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L14 Exception -> L16
        if (r109 == null) goto L64;
        r109.d(r114);
        return r116;
    L64:
        return r116;
    L39:
        r107 = r108 + 1;
        r102 = r113;
        r110 = r114;
        byte[] r117 = r115;
    L21:
        if (r107 >= r102) goto L43;
        if (r109 != null) goto L63;
    L25:
        LocalPluginService r118 = f191791a;     // Catch: Throwable -> L44 Exception -> L46
        p2 r119 = f191794d;     // Catch: Throwable -> L44 Exception -> L46
        if (r119 == null) goto L28;
        int r120 = r119.c();     // Catch: Throwable -> L44 Exception -> L46
    L29:
        if (r120 != 1) goto L41;
        r103.L$0 = r117;     // Catch: Throwable -> L44 Exception -> L46
        r103.L$1 = r110;     // Catch: Throwable -> L44 Exception -> L46
        r103.L$2 = r109;     // Catch: Throwable -> L44 Exception -> L46
        r103.I$0 = r102;     // Catch: Throwable -> L44 Exception -> L46
        r103.I$1 = r107;     // Catch: Throwable -> L44 Exception -> L46
        r103.I$2 = r107;     // Catch: Throwable -> L44 Exception -> L46
        r103.label = 1;     // Catch: Throwable -> L44 Exception -> L46
        Object r121 = r118.f(r117, r103);     // Catch: Throwable -> L44 Exception -> L46
        if (r121 == r112) goto L66;
        r115 = r117;
        r105 = r121;
        r114 = r110;
        r113 = r102;
        r108 = r107;
        goto L35
    L66:
        return r112;
    L41:
        throw new IllegalStateException("Frontier disconnected");     // Catch: Throwable -> L44 Exception -> L46
    L28:
        r120 = 0;
        goto L29
    L63:
        r109.b(r110, r107 + 1);     // Catch: Throwable -> L44 Exception -> L46
    L46:
        e = e;
        r114 = r110;
    L48:
        String r122 = "Send ack failed: " + e.getMessage();     // Catch: Throwable -> L14
        if (r109 == null) goto L51;
        r109.g(r114, r122);     // Catch: Throwable -> L14
    L51:
        FLogger.f375446a.e("LocalPluginService", r122);     // Catch: Throwable -> L14
        if (r109 == null) goto L55;
        r109.d(r114);
    L55:
        return Unit.INSTANCE;
    L44:
        th = th;
    L57:
        if (r109 == null) goto L59;
        r109.d(r110);
    L59:
        throw th;
    L43:
        throw new IllegalStateException("Send ack failed after " + r102 + " retries");     // Catch: Throwable -> L44 Exception -> L46
    L16:
        e = e;
    L14:
        th = th;
        r110 = r114;
        goto L57
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r105);
        jw3.c r123 = jw3.c.f500706a;
        r109 = jw3.c.f500709d.get();
        r117 = r101;
        r107 = 0;
    L7:
        r103 = new LocalPluginService$sendPayloadWithRetry$1(r100, r111);
        goto L8
    }
}
