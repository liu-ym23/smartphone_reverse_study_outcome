package com.stepos.stepclaw.gateway;

import a6.f0;
import a6.i0;
import android.util.Log;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.AsyncTaskStatus;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import h5.i;
import kotlin.Metadata;
import p5.l;
import p5.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 %2\u00020\u0001:\u0002&%B\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\b\u0012\u001e\b\u0002\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u0019J\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR*\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u001eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR*\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001fR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006'"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayLauncher;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lkotlin/Function0;", "Lb5/a0;", "startRuntime", "stopRuntime", "Lkotlin/Function1;", "Lf5/c;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "checkHealth", "hasApiKey", "onReady", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "onLog", "beforeStart", "<init>", "(Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lp5/a;Lp5/a;Lp5/l;Lp5/a;Lp5/a;Lp5/l;Lp5/l;)V", "La6/f0;", "scope", "Lcom/stepos/stepclaw/gateway/GatewayLauncher$Result;", "startGateway", "(La6/f0;)Lcom/stepos/stepclaw/gateway/GatewayLauncher$Result;", "isStarted", "()Z", "isInitializing", "stop", "()V", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "Lp5/a;", "Lp5/l;", "lock", "Ljava/lang/Object;", AsyncTaskStatus.STARTED, "Z", "initializing", "Companion", "Result", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GatewayLauncher {
    private static final String TAG = "GatewayLauncher";
    private final l beforeStart;
    private final l checkHealth;
    private final p5.a hasApiKey;
    private volatile boolean initializing;
    private final Object lock;
    private final l onLog;
    private final p5.a onReady;
    private final OpenClawRuntimeConfig runtimeConfig;
    private final p5.a startRuntime;
    private volatile boolean started;
    private final p5.a stopRuntime;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID}, k = 3, mv = {2, 2, 0}, xi = 48)
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayLauncher$4", f = "GatewayLauncher.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayLauncher$4, reason: invalid class name */
    public static final class AnonymousClass4 extends i implements l {
        int label;

        public AnonymousClass4(f5.c cVar) {
            super(1, cVar);
        }

        @Override // h5.a
        public final f5.c create(f5.c cVar) {
            return new AnonymousClass4(cVar);
        }

        @Override // p5.l
        public final Object invoke(f5.c cVar) {
            return ((AnonymousClass4) create(cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayLauncher$Result;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "STARTED", "INITIALIZING", "ALREADY_RUNNING", "NEEDS_CONFIG", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Result {
        private static final /* synthetic */ i5.a $ENTRIES;
        private static final /* synthetic */ Result[] $VALUES;
        public static final Result STARTED = new Result("STARTED", 0);
        public static final Result INITIALIZING = new Result("INITIALIZING", 1);
        public static final Result ALREADY_RUNNING = new Result("ALREADY_RUNNING", 2);
        public static final Result NEEDS_CONFIG = new Result("NEEDS_CONFIG", 3);

        private static final /* synthetic */ Result[] $values() {
            return new Result[]{STARTED, INITIALIZING, ALREADY_RUNNING, NEEDS_CONFIG};
        }

        static {
            Result[] resultArr$values = $values();
            $VALUES = resultArr$values;
            $ENTRIES = a.a.F(resultArr$values);
        }

        private Result(String str, int i8) {
        }

        public static i5.a getEntries() {
            return $ENTRIES;
        }

        public static Result valueOf(String str) {
            return (Result) Enum.valueOf(Result.class, str);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayLauncher$startGateway$2", f = "GatewayLauncher.kt", l = {82, 105}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayLauncher$startGateway$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        long J$0;
        long J$1;
        Object L$0;
        boolean Z$0;
        int label;

        public AnonymousClass2(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return GatewayLauncher.this.new AnonymousClass2(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x00f6, code lost:
        
            if (r15 == r3) goto L35;
         */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 402
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayLauncher.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public GatewayLauncher(OpenClawRuntimeConfig runtimeConfig, p5.a startRuntime, p5.a stopRuntime, l checkHealth, p5.a hasApiKey, p5.a onReady, l onLog, l beforeStart) {
        kotlin.jvm.internal.p.e(runtimeConfig, "runtimeConfig");
        kotlin.jvm.internal.p.e(startRuntime, "startRuntime");
        kotlin.jvm.internal.p.e(stopRuntime, "stopRuntime");
        kotlin.jvm.internal.p.e(checkHealth, "checkHealth");
        kotlin.jvm.internal.p.e(hasApiKey, "hasApiKey");
        kotlin.jvm.internal.p.e(onReady, "onReady");
        kotlin.jvm.internal.p.e(onLog, "onLog");
        kotlin.jvm.internal.p.e(beforeStart, "beforeStart");
        this.runtimeConfig = runtimeConfig;
        this.startRuntime = startRuntime;
        this.stopRuntime = stopRuntime;
        this.checkHealth = checkHealth;
        this.hasApiKey = hasApiKey;
        this.onReady = onReady;
        this.onLog = onLog;
        this.beforeStart = beforeStart;
        this.lock = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 _init_$lambda$2(String it) {
        kotlin.jvm.internal.p.e(it, "it");
        return a0.f883a;
    }

    /* renamed from: isInitializing, reason: from getter */
    public final boolean getInitializing() {
        return this.initializing;
    }

    /* renamed from: isStarted, reason: from getter */
    public final boolean getStarted() {
        return this.started;
    }

    public final Result startGateway(f0 scope) {
        kotlin.jvm.internal.p.e(scope, "scope");
        synchronized (this.lock) {
            if (this.started) {
                return Result.ALREADY_RUNNING;
            }
            if (!this.runtimeConfig.getRootfsRoot().isDirectory()) {
                Log.i(TAG, "[GatewayDiag] INITIALIZING reason=rootfs_not_mounted path=" + this.runtimeConfig.getRootfsRoot());
                return Result.INITIALIZING;
            }
            if (!((Boolean) this.hasApiKey.invoke()).booleanValue()) {
                Log.i(TAG, "Mounted rootfs ready but no API key configured");
                return Result.NEEDS_CONFIG;
            }
            if (this.initializing) {
                Log.d(TAG, "[GatewayDiag] INITIALIZING reason=launch_already_in_progress (wait for beforeStart→startRuntime→health; concurrent startGateway ignored)");
                return Result.INITIALIZING;
            }
            this.initializing = true;
            i0.q(scope, null, new AnonymousClass2(null), 3);
            return Result.STARTED;
        }
    }

    public final void stop() {
        Throwable cause;
        String message;
        synchronized (this.lock) {
            this.started = false;
            this.initializing = false;
        }
        try {
            this.stopRuntime.invoke();
        } catch (Exception e9) {
            String message2 = e9.getMessage();
            if (message2 == null) {
                message2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (n.g1(message2, "Must be root", true) || !((cause = e9.getCause()) == null || (message = cause.getMessage()) == null || !n.g1(message, "Must be root", true))) {
                Log.w(TAG, "stopRuntime skipped (no root to stop init service) — continuing restart");
            } else {
                Log.w(TAG, "stopRuntime failed", e9);
            }
        }
    }

    public /* synthetic */ GatewayLauncher(OpenClawRuntimeConfig openClawRuntimeConfig, p5.a aVar, p5.a aVar2, l lVar, p5.a aVar3, p5.a aVar4, l lVar2, l lVar3, int i8, kotlin.jvm.internal.i iVar) {
        this(openClawRuntimeConfig, aVar, (i8 & 4) != 0 ? new a4.b(11) : aVar2, lVar, aVar3, (i8 & 32) != 0 ? new a4.b(12) : aVar4, (i8 & 64) != 0 ? new d(1) : lVar2, (i8 & 128) != 0 ? new AnonymousClass4(null) : lVar3);
    }
}
