package com.stepos.stepclaw.gateway;

import a6.f0;
import a6.h1;
import a6.i0;
import a6.w;
import a6.z;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.StepOSProxyServer;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.config.ConfigGuardObserver;
import com.stepos.stepclaw.config.JsonConfigStore;
import com.stepos.stepclaw.gateway.GatewayLauncher;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import com.stepos.stepclaw.runtime.SystemChrootRuntimeController;
import h5.i;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import p5.l;
import p5.p;
import p5.s;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001ZB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J_\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u0015\u0010\u0016J¡\u0001\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00102\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2@\b\u0002\u0010\u0019\u001a:\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u0003J_\u0010\u001f\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00102\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u001f\u0010\u0016JA\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¢\u0006\u0004\b\"\u0010#J+\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¢\u0006\u0004\b$\u0010%J3\u0010&\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010!\u001a\u00020 2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u0002¢\u0006\u0004\b&\u0010'J<\u0010,\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010H\u0082@¢\u0006\u0004\b,\u0010-J\u0017\u00100\u001a\u00020\u00142\u0006\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b0\u00101J\u0018\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020(H\u0082@¢\u0006\u0004\b3\u00104J\u001f\u00106\u001a\u00020\u00042\u0006\u00102\u001a\u00020(2\u0006\u00105\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010=R\u0014\u0010@\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010AR\u0014\u0010C\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010AR\u0014\u0010D\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020?8\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u0010AR\u0014\u0010F\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\bF\u0010=R\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010U\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010X¨\u0006["}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayAutoStart;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isStarted", "()Z", "Landroid/content/Context;", "context", "La6/f0;", "scope", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_PORT, "Lkotlin/Function0;", "Lb5/a0;", "onGatewayReady", "Lkotlin/Function1;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "onLog", "onNeedsConfig", "Lcom/stepos/stepclaw/gateway/GatewayAutoStart$Result;", "startGateway", "(Landroid/content/Context;La6/f0;ILp5/a;Lp5/l;Lp5/a;)Lcom/stepos/stepclaw/gateway/GatewayAutoStart$Result;", "isGatewayLaunchInProgress", "Lkotlin/Function5;", "restartGatewayAction", "handlePersistentConnectFailure", "(Landroid/content/Context;La6/f0;ILp5/a;Lp5/l;Lp5/a;Lp5/s;)V", "ensureOpenClawEnvStarted", "(Landroid/content/Context;)V", "stopGateway", "restartGateway", "Lcom/stepos/stepclaw/config/JsonConfigStore;", "configStore", "wrappedOnGatewayReady", "(Lcom/stepos/stepclaw/config/JsonConfigStore;La6/f0;Lp5/a;Lp5/l;)V", "enforceGatewayConfig", "(Lcom/stepos/stepclaw/config/JsonConfigStore;Lp5/l;)V", "startServiceWatchdog", "(La6/f0;Lcom/stepos/stepclaw/config/JsonConfigStore;Lp5/l;)V", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "Lcom/stepos/stepclaw/runtime/SystemChrootRuntimeController;", "runtimeController", "runOtaCheck", "(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lcom/stepos/stepclaw/runtime/SystemChrootRuntimeController;Lp5/l;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/gateway/GatewayLauncher$Result;", "launcherResult", "mapResult", "(Lcom/stepos/stepclaw/gateway/GatewayLauncher$Result;)Lcom/stepos/stepclaw/gateway/GatewayAutoStart$Result;", "config", "checkGatewayHealth", "(Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Lf5/c;)Ljava/lang/Object;", "isFirstAttempt", "checkGatewayHealthOnce", "(Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;Z)Z", "startStepOSProxy", "(La6/f0;)V", "TAG", "Ljava/lang/String;", "HEALTH_CONNECT_TIMEOUT_MS", "I", "HEALTH_READ_TIMEOUT_MS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "HEALTH_POLL_TOTAL_MS", "J", "HEALTH_POLL_AGGRESSIVE_PHASE_MS", "HEALTH_POLL_INTERVAL_FAST_MS", "HEALTH_POLL_INTERVAL_MS", "SERVICE_WATCHDOG_INTERVAL_MS", "SERVICE_WATCHDOG_STOPPED_THRESHOLD", "Lcom/stepos/stepclaw/gateway/GatewayLauncher;", "launcher", "Lcom/stepos/stepclaw/gateway/GatewayLauncher;", "Lcom/stepos/stepclaw/base/net/StepOSProxyServer;", "steposProxyServer", "Lcom/stepos/stepclaw/base/net/StepOSProxyServer;", "gatewayContext", "Landroid/content/Context;", "La6/h1;", "serviceWatchdogJob", "La6/h1;", "Lcom/stepos/stepclaw/config/ConfigGuardObserver;", "configGuardObserver", "Lcom/stepos/stepclaw/config/ConfigGuardObserver;", "lock", "Ljava/lang/Object;", "gatewayFieldsRestoreAttempted", "Z", "fullRestoreAttempted", "Result", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class GatewayAutoStart {
    private static final int HEALTH_CONNECT_TIMEOUT_MS = 1500;
    private static final long HEALTH_POLL_AGGRESSIVE_PHASE_MS = 30000;
    private static final long HEALTH_POLL_INTERVAL_FAST_MS = 400;
    private static final long HEALTH_POLL_INTERVAL_MS = 2000;
    private static final long HEALTH_POLL_TOTAL_MS = 60000;
    private static final int HEALTH_READ_TIMEOUT_MS = 3000;
    private static final long SERVICE_WATCHDOG_INTERVAL_MS = 10000;
    private static final int SERVICE_WATCHDOG_STOPPED_THRESHOLD = 2;
    private static final String TAG = "GatewayAutoStart";
    private static ConfigGuardObserver configGuardObserver;
    private static volatile boolean fullRestoreAttempted;
    private static Context gatewayContext;
    private static volatile boolean gatewayFieldsRestoreAttempted;
    private static GatewayLauncher launcher;
    private static h1 serviceWatchdogJob;
    private static StepOSProxyServer steposProxyServer;
    public static final GatewayAutoStart INSTANCE = new GatewayAutoStart();
    private static final Object lock = new Object();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/gateway/GatewayAutoStart$Result;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "STARTED", "INITIALIZING", "ALREADY_RUNNING", "NEEDS_CONFIG", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GatewayLauncher.Result.values().length];
            try {
                iArr[GatewayLauncher.Result.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GatewayLauncher.Result.INITIALIZING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GatewayLauncher.Result.ALREADY_RUNNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GatewayLauncher.Result.NEEDS_CONFIG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayAutoStart", f = "GatewayAutoStart.kt", l = {494}, m = "checkGatewayHealth", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayAutoStart$checkGatewayHealth$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        int I$0;
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayAutoStart.this.checkGatewayHealth(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayAutoStart$handlePersistentConnectFailure$3", f = "GatewayAutoStart.kt", l = {250}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayAutoStart$handlePersistentConnectFailure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ JsonConfigStore $configStore;
        final /* synthetic */ Context $context;
        final /* synthetic */ p5.a $onGatewayReady;
        final /* synthetic */ l $onLog;
        final /* synthetic */ int $port;
        final /* synthetic */ s $restart;
        final /* synthetic */ f0 $scope;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(JsonConfigStore jsonConfigStore, l lVar, s sVar, Context context, f0 f0Var, int i8, p5.a aVar, f5.c cVar) {
            super(2, cVar);
            this.$configStore = jsonConfigStore;
            this.$onLog = lVar;
            this.$restart = sVar;
            this.$context = context;
            this.$scope = f0Var;
            this.$port = i8;
            this.$onGatewayReady = aVar;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass3(this.$configStore, this.$onLog, this.$restart, this.$context, this.$scope, this.$port, this.$onGatewayReady, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass3) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                JsonConfigStore jsonConfigStore = this.$configStore;
                this.label = 1;
                obj = jsonConfigStore.restoreFromBackup(this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            Log.w(GatewayAutoStart.TAG, "handlePersistentConnectFailure: tier-2 full restoreFromBackup → " + zBooleanValue);
            this.$onLog.invoke("[Recovery] Tier-2: full config restore from backup (ok=" + zBooleanValue + ")");
            this.$restart.b(this.$context, this.$scope, new Integer(this.$port), this.$onGatewayReady, this.$onLog);
            return a0.f883a;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayAutoStart", f = "GatewayAutoStart.kt", l = {428}, m = "runOtaCheck", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayAutoStart$runOtaCheck$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00191 extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C00191(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayAutoStart.this.runOtaCheck(null, null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.gateway.GatewayAutoStart$startServiceWatchdog$1", f = "GatewayAutoStart.kt", l = {371}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.gateway.GatewayAutoStart$startServiceWatchdog$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00201 extends i implements p {
        final /* synthetic */ JsonConfigStore $configStore;
        final /* synthetic */ l $onLog;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00201(l lVar, JsonConfigStore jsonConfigStore, f5.c cVar) {
            super(2, cVar);
            this.$onLog = lVar;
            this.$configStore = jsonConfigStore;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            C00201 c00201 = new C00201(this.$onLog, this.$configStore, cVar);
            c00201.L$0 = obj;
            return c00201;
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00201) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Path cross not found for [B:24:0x00a0, B:32:0x00c8], limit reached: 46 */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00fa A[Catch: Exception -> 0x00c3, TRY_LEAVE, TryCatch #1 {Exception -> 0x00c3, blocks: (B:22:0x0081, B:24:0x00a0, B:28:0x00a9, B:32:0x00c8, B:34:0x00fa, B:38:0x0120, B:35:0x010f), top: B:46:0x0081, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:42:0x015d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007e -> B:6:0x0025). Please report as a decompilation issue!!! */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 355
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayAutoStart.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private GatewayAutoStart() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object checkGatewayHealth(com.stepos.stepclaw.runtime.OpenClawRuntimeConfig r19, f5.c r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayAutoStart.checkGatewayHealth(com.stepos.stepclaw.runtime.OpenClawRuntimeConfig, f5.c):java.lang.Object");
    }

    private final boolean checkGatewayHealthOnce(OpenClawRuntimeConfig config, boolean isFirstAttempt) throws IOException {
        try {
            String healthCheckUrl = config.getHealthCheckUrl();
            if (isFirstAttempt) {
                Log.i(TAG, "[GatewayDiag] health GET " + healthCheckUrl + " (per-probe connect=1500ms read=3000ms; fast poll 400ms for 30000ms then 2000ms; max 60000ms)");
            }
            URLConnection uRLConnectionOpenConnection = new URL(healthCheckUrl).openConnection();
            kotlin.jvm.internal.p.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            httpURLConnection.setConnectTimeout(HEALTH_CONNECT_TIMEOUT_MS);
            httpURLConnection.setReadTimeout(HEALTH_READ_TIMEOUT_MS);
            httpURLConnection.setRequestMethod("GET");
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            boolean z = 200 <= responseCode && responseCode < 500;
            if (z) {
                Log.i(TAG, "[GatewayDiag] health ok http=" + responseCode);
                return z;
            }
            Log.w(TAG, "[GatewayDiag] health unexpected http=" + responseCode + " (treat as fail; gateway may be misconfigured)");
            return z;
        } catch (Exception e9) {
            String strQ = a8.b.q("[GatewayDiag] health exception ", e9.getClass().getSimpleName(), ": ", e9.getMessage(), e9 instanceof ConnectException ? " — 常见：本机尚未监听（openclaw_env 刚拉起 / 进程仍启动中）" : e9 instanceof SocketTimeoutException ? " — 连接或读超时（网关极慢或端口错）" : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
            if (isFirstAttempt) {
                Log.w(TAG, strQ);
            } else {
                Log.d(TAG, strQ);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enforceGatewayConfig(JsonConfigStore configStore, l onLog) {
        if (configStore.ensureGatewayAuthTokenMode()) {
            Log.w(TAG, "enforceGatewayConfig: corrected gateway.auth to token mode");
            onLog.invoke("[ConfigGuard] corrected gateway.auth to token mode");
        }
        if (configStore.ensureGatewayPort()) {
            Log.w(TAG, "enforceGatewayConfig: corrected gateway.port to 18789");
            onLog.invoke("[ConfigGuard] corrected gateway.port to 18789");
        }
        if (configStore.ensureGatewayBind()) {
            Log.w(TAG, "enforceGatewayConfig: corrected gateway.bind to 'loopback'");
            onLog.invoke("[ConfigGuard] corrected gateway.bind to 'loopback'");
        }
    }

    public static /* synthetic */ void handlePersistentConnectFailure$default(GatewayAutoStart gatewayAutoStart, Context context, f0 f0Var, int i8, p5.a aVar, l lVar, p5.a aVar2, s sVar, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = 18789;
        }
        int i10 = i8;
        if ((i9 & 8) != 0) {
            aVar = new a4.b(9);
        }
        p5.a aVar3 = aVar;
        if ((i9 & 16) != 0) {
            lVar = new z(29);
        }
        gatewayAutoStart.handlePersistentConnectFailure(context, f0Var, i10, aVar3, lVar, (i9 & 32) != 0 ? null : aVar2, (i9 & 64) != 0 ? null : sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 handlePersistentConnectFailure$lambda$1(String it) {
        kotlin.jvm.internal.p.e(it, "it");
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handlePersistentConnectFailure$lambda$2() {
        boolean z;
        synchronized (lock) {
            GatewayLauncher gatewayLauncher = launcher;
            z = false;
            if (gatewayLauncher != null) {
                if (gatewayLauncher.getInitializing()) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object handlePersistentConnectFailure$lambda$3(Context restartContext, f0 restartScope, int i8, p5.a onReady, l restartLog) {
        kotlin.jvm.internal.p.e(restartContext, "restartContext");
        kotlin.jvm.internal.p.e(restartScope, "restartScope");
        kotlin.jvm.internal.p.e(onReady, "onReady");
        kotlin.jvm.internal.p.e(restartLog, "restartLog");
        return restartGateway$default(INSTANCE, restartContext, restartScope, i8, onReady, restartLog, null, 32, null);
    }

    private final Result mapResult(GatewayLauncher.Result launcherResult) {
        int i8 = WhenMappings.$EnumSwitchMapping$0[launcherResult.ordinal()];
        if (i8 == 1) {
            return Result.STARTED;
        }
        if (i8 == 2) {
            return Result.INITIALIZING;
        }
        if (i8 == 3) {
            return Result.ALREADY_RUNNING;
        }
        if (i8 == 4) {
            return Result.NEEDS_CONFIG;
        }
        throw new w();
    }

    public static /* synthetic */ Result restartGateway$default(GatewayAutoStart gatewayAutoStart, Context context, f0 f0Var, int i8, p5.a aVar, l lVar, p5.a aVar2, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = 18789;
        }
        int i10 = i8;
        if ((i9 & 8) != 0) {
            aVar = new a4.b(8);
        }
        p5.a aVar3 = aVar;
        if ((i9 & 16) != 0) {
            lVar = new z(27);
        }
        l lVar2 = lVar;
        if ((i9 & 32) != 0) {
            aVar2 = null;
        }
        return gatewayAutoStart.restartGateway(context, f0Var, i10, aVar3, lVar2, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 restartGateway$lambda$1(String it) {
        kotlin.jvm.internal.p.e(it, "it");
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runOtaCheck(android.content.Context r14, com.stepos.stepclaw.runtime.OpenClawRuntimeConfig r15, com.stepos.stepclaw.runtime.SystemChrootRuntimeController r16, p5.l r17, f5.c r18) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewayAutoStart.runOtaCheck(android.content.Context, com.stepos.stepclaw.runtime.OpenClawRuntimeConfig, com.stepos.stepclaw.runtime.SystemChrootRuntimeController, p5.l, f5.c):java.lang.Object");
    }

    public static /* synthetic */ Result startGateway$default(GatewayAutoStart gatewayAutoStart, Context context, f0 f0Var, int i8, p5.a aVar, l lVar, p5.a aVar2, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i8 = 18789;
        }
        int i10 = i8;
        if ((i9 & 8) != 0) {
            aVar = new a4.b(7);
        }
        p5.a aVar3 = aVar;
        if ((i9 & 16) != 0) {
            lVar = new z(28);
        }
        l lVar2 = lVar;
        if ((i9 & 32) != 0) {
            aVar2 = null;
        }
        return gatewayAutoStart.startGateway(context, f0Var, i10, aVar3, lVar2, aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 startGateway$lambda$1(String it) {
        kotlin.jvm.internal.p.e(it, "it");
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 startGateway$lambda$2$0$0(SystemChrootRuntimeController systemChrootRuntimeController) {
        systemChrootRuntimeController.startOpenClawEnv();
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 startGateway$lambda$2$0$1(SystemChrootRuntimeController systemChrootRuntimeController) {
        systemChrootRuntimeController.stopRuntime();
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 startGateway$lambda$2$0$3(GatewayAutoStart gatewayAutoStart, JsonConfigStore jsonConfigStore, f0 f0Var, p5.a aVar, l lVar) {
        gatewayAutoStart.wrappedOnGatewayReady(jsonConfigStore, f0Var, aVar, lVar);
        return a0.f883a;
    }

    private final void startServiceWatchdog(f0 scope, JsonConfigStore configStore, l onLog) {
        h1 h1Var = serviceWatchdogJob;
        if (h1Var != null) {
            h1Var.e(null);
        }
        serviceWatchdogJob = i0.q(scope, null, new C00201(onLog, configStore, null), 3);
    }

    private final void startStepOSProxy(f0 scope) {
        try {
            StepOSProxyServer orCreate = StepOSProxyServer.INSTANCE.getOrCreate();
            orCreate.start(scope);
            steposProxyServer = orCreate;
        } catch (Exception e9) {
            Log.e(TAG, "Failed to start stepos proxy", e9);
        }
    }

    private final void wrappedOnGatewayReady(JsonConfigStore configStore, f0 scope, p5.a onGatewayReady, l onLog) {
        gatewayFieldsRestoreAttempted = false;
        fullRestoreAttempted = false;
        configStore.backupKnownGood();
        Log.i(TAG, "Backed up known-good config after gateway healthy");
        try {
            onGatewayReady.invoke();
        } catch (CancellationException e9) {
            Log.w(TAG, "onGatewayReady cancelled");
            throw e9;
        } catch (Exception e10) {
            Log.e(TAG, "onGatewayReady threw: " + e10.getMessage() + " — continuing", e10);
        }
        startServiceWatchdog(scope, configStore, onLog);
        OpenClawRuntimeConfig.Companion companion = OpenClawRuntimeConfig.INSTANCE;
        Context context = gatewayContext;
        if (context == null) {
            return;
        }
        ConfigGuardObserver configGuardObserver2 = new ConfigGuardObserver(companion.fromContext(context).resolveRootfsPath("root/.openclaw"), configStore, onLog);
        configGuardObserver2.start();
        configGuardObserver = configGuardObserver2;
    }

    public final void ensureOpenClawEnvStarted(Context context) {
        kotlin.jvm.internal.p.e(context, "context");
        OpenClawRuntimeConfig.Companion companion = OpenClawRuntimeConfig.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.d(applicationContext, "getApplicationContext(...)");
        OpenClawRuntimeConfig openClawRuntimeConfigFromContext = companion.fromContext(applicationContext);
        SystemChrootRuntimeController systemChrootRuntimeController = new SystemChrootRuntimeController(openClawRuntimeConfigFromContext, null, null, 6, null);
        String runtimeStartProperty = openClawRuntimeConfigFromContext.getRuntimeStartProperty();
        String runtimeStartValue = openClawRuntimeConfigFromContext.getRuntimeStartValue();
        String runtimeServiceName = openClawRuntimeConfigFromContext.getRuntimeServiceName();
        StringBuilder sbV = a8.b.v("[GatewayDiag] ensureOpenClawEnvStarted: ", runtimeStartProperty, "=", runtimeStartValue, " (pull up ");
        sbV.append(runtimeServiceName);
        sbV.append(")");
        Log.i(TAG, sbV.toString());
        systemChrootRuntimeController.startOpenClawEnv();
        Log.i(TAG, "[GatewayDiag] ensureOpenClawEnvStarted: init reports non-stopped state OK");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void handlePersistentConnectFailure(Context context, f0 scope, int port, p5.a onGatewayReady, l onLog, p5.a isGatewayLaunchInProgress, s restartGatewayAction) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(scope, "scope");
        kotlin.jvm.internal.p.e(onGatewayReady, "onGatewayReady");
        kotlin.jvm.internal.p.e(onLog, "onLog");
        if (((Boolean) (isGatewayLaunchInProgress == null ? new a4.b(10) : isGatewayLaunchInProgress).invoke()).booleanValue()) {
            Log.i(TAG, "handlePersistentConnectFailure: launcher still initializing, skip recovery");
            onLog.invoke("[Recovery] Skip: gateway launcher still initializing");
            return;
        }
        s cVar = restartGatewayAction == null ? new c() : restartGatewayAction;
        JsonConfigStore jsonConfigStore = new JsonConfigStore(context, null, 2, 0 == true ? 1 : 0);
        if (jsonConfigStore.ensureGatewayAuthTokenMode()) {
            Log.w(TAG, "handlePersistentConnectFailure: gateway.auth drifted — corrected, restarting");
            onLog.invoke("[Recovery] Tier-0: corrected gateway.auth to token mode");
            cVar.b(context, scope, Integer.valueOf(port), onGatewayReady, onLog);
            return;
        }
        if (jsonConfigStore.ensureGatewayPort()) {
            Log.w(TAG, "handlePersistentConnectFailure: gateway.port was not " + port + " — corrected, restarting");
            StringBuilder sb = new StringBuilder("[Recovery] Tier-0: corrected gateway.port to ");
            sb.append(port);
            onLog.invoke(sb.toString());
            cVar.b(context, scope, Integer.valueOf(port), onGatewayReady, onLog);
            return;
        }
        if (jsonConfigStore.ensureGatewayBind()) {
            Log.w(TAG, "handlePersistentConnectFailure: gateway.bind was not 'loopback' — corrected, restarting");
            onLog.invoke("[Recovery] Tier-0: corrected gateway.bind to 'loopback'");
            cVar.b(context, scope, Integer.valueOf(port), onGatewayReady, onLog);
            return;
        }
        if (!gatewayFieldsRestoreAttempted) {
            gatewayFieldsRestoreAttempted = true;
            boolean zRestoreGatewayFields = jsonConfigStore.restoreGatewayFields();
            Log.w(TAG, "handlePersistentConnectFailure: tier-1 restoreGatewayFields → " + zRestoreGatewayFields);
            onLog.invoke("[Recovery] Tier-1: surgical gateway restore → " + zRestoreGatewayFields);
            if (zRestoreGatewayFields) {
                cVar.b(context, scope, Integer.valueOf(port), onGatewayReady, onLog);
                return;
            }
        }
        if (fullRestoreAttempted) {
            Log.e(TAG, "handlePersistentConnectFailure: all tiers exhausted, not retrying");
            onLog.invoke("[Recovery] All recovery tiers exhausted — manual intervention required");
        } else {
            fullRestoreAttempted = true;
            i0.q(scope, null, new AnonymousClass3(jsonConfigStore, onLog, cVar, context, scope, port, onGatewayReady, null), 3);
        }
    }

    public final boolean isStarted() {
        GatewayLauncher gatewayLauncher = launcher;
        if (gatewayLauncher != null) {
            return gatewayLauncher.getStarted();
        }
        return false;
    }

    public final Result restartGateway(Context context, f0 scope, int port, p5.a onGatewayReady, l onLog, p5.a onNeedsConfig) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(scope, "scope");
        kotlin.jvm.internal.p.e(onGatewayReady, "onGatewayReady");
        kotlin.jvm.internal.p.e(onLog, "onLog");
        stopGateway();
        Log.i(TAG, "Gateway stopped, restarting...");
        return startGateway(context, scope, port, onGatewayReady, onLog, onNeedsConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Result startGateway(Context context, final f0 scope, int port, final p5.a onGatewayReady, final l onLog, p5.a onNeedsConfig) {
        GatewayAutoStart gatewayAutoStart;
        Result resultMapResult;
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(scope, "scope");
        kotlin.jvm.internal.p.e(onGatewayReady, "onGatewayReady");
        kotlin.jvm.internal.p.e(onLog, "onLog");
        synchronized (lock) {
            try {
                gatewayContext = context.getApplicationContext();
                final GatewayAutoStart gatewayAutoStart2 = INSTANCE;
                gatewayAutoStart2.startStepOSProxy(scope);
                GatewayLauncher gatewayLauncher = launcher;
                if (gatewayLauncher == null) {
                    Context applicationContext = context.getApplicationContext();
                    OpenClawRuntimeConfig openClawRuntimeConfigFromContext = OpenClawRuntimeConfig.INSTANCE.fromContext(context);
                    final SystemChrootRuntimeController systemChrootRuntimeController = new SystemChrootRuntimeController(openClawRuntimeConfigFromContext, null, null, 6, null);
                    final JsonConfigStore jsonConfigStore = new JsonConfigStore(context, null, 2, 0 == true ? 1 : 0);
                    final int i8 = 0;
                    p5.a aVar = new p5.a() { // from class: com.stepos.stepclaw.gateway.a
                        @Override // p5.a
                        public final Object invoke() {
                            int i9 = i8;
                            SystemChrootRuntimeController systemChrootRuntimeController2 = systemChrootRuntimeController;
                            switch (i9) {
                                case 0:
                                    return GatewayAutoStart.startGateway$lambda$2$0$0(systemChrootRuntimeController2);
                                default:
                                    return GatewayAutoStart.startGateway$lambda$2$0$1(systemChrootRuntimeController2);
                            }
                        }
                    };
                    final int i9 = 1;
                    gatewayAutoStart = gatewayAutoStart2;
                    GatewayLauncher gatewayLauncher2 = new GatewayLauncher(openClawRuntimeConfigFromContext, aVar, new p5.a() { // from class: com.stepos.stepclaw.gateway.a
                        @Override // p5.a
                        public final Object invoke() {
                            int i92 = i9;
                            SystemChrootRuntimeController systemChrootRuntimeController2 = systemChrootRuntimeController;
                            switch (i92) {
                                case 0:
                                    return GatewayAutoStart.startGateway$lambda$2$0$0(systemChrootRuntimeController2);
                                default:
                                    return GatewayAutoStart.startGateway$lambda$2$0$1(systemChrootRuntimeController2);
                            }
                        }
                    }, new GatewayAutoStart$startGateway$3$currentLauncher$1$3(gatewayAutoStart2, openClawRuntimeConfigFromContext, null), new b7.c(8, jsonConfigStore), new p5.a() { // from class: com.stepos.stepclaw.gateway.b
                        @Override // p5.a
                        public final Object invoke() {
                            return GatewayAutoStart.startGateway$lambda$2$0$3(this.f1563a, jsonConfigStore, scope, onGatewayReady, onLog);
                        }
                    }, onLog, new GatewayAutoStart$startGateway$3$currentLauncher$1$6(gatewayAutoStart2, applicationContext, openClawRuntimeConfigFromContext, systemChrootRuntimeController, onLog, jsonConfigStore, null));
                    launcher = gatewayLauncher2;
                    gatewayLauncher = gatewayLauncher2;
                } else {
                    gatewayAutoStart = gatewayAutoStart2;
                }
                resultMapResult = gatewayAutoStart.mapResult(gatewayLauncher.startGateway(scope));
                Log.i(TAG, "startGateway → " + resultMapResult + " (port=" + port + ")");
                if (resultMapResult == Result.NEEDS_CONFIG && onNeedsConfig != null) {
                    onNeedsConfig.invoke();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return resultMapResult;
    }

    public final void stopGateway() {
        synchronized (lock) {
            try {
                h1 h1Var = serviceWatchdogJob;
                if (h1Var != null) {
                    h1Var.e(null);
                }
                serviceWatchdogJob = null;
                ConfigGuardObserver configGuardObserver2 = configGuardObserver;
                if (configGuardObserver2 != null) {
                    configGuardObserver2.stop();
                }
                configGuardObserver = null;
                GatewayLauncher gatewayLauncher = launcher;
                if (gatewayLauncher != null) {
                    gatewayLauncher.stop();
                }
                launcher = null;
                gatewayContext = null;
                StepOSProxyServer stepOSProxyServer = steposProxyServer;
                if (stepOSProxyServer != null) {
                    stepOSProxyServer.stop();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
