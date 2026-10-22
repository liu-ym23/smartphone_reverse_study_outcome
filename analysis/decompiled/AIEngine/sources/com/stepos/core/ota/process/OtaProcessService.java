package com.stepos.core.ota.process;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ForegroundHost;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.download.control.DownloadControlCenter;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import lb.n;
import mb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessService extends Service implements ForegroundHost {
    public static final String ACTION = "com.stepos.aiengine.action.OTA_PROCESS";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OtaProcessService";
    private OtaIdleExitScheduler idleExitScheduler;
    private volatile boolean isForeground;
    private volatile int lastStartId;
    private final OtaProcessControlBinder binder = new OtaProcessControlBinder();
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessService$handleIdleExitDump$1", f = "OtaProcessService.kt", l = {211}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessService$handleIdleExitDump$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(qb.b<? super AnonymousClass1> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass1 anonymousClass1 = OtaProcessService.this.new AnonymousClass1(bVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                try {
                    OtaTaskSnapshotStore.INSTANCE.flushForProcessExit(OtaContainer.INSTANCE.snapshot());
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                try {
                    OtaContainer.INSTANCE.getNotifier().releaseAnyForegroundAnchor();
                    n nVar2 = n.f10413a;
                } catch (Throwable th2) {
                    kotlin.c.a(th2);
                }
                try {
                    OtaProcessService.this.binder.notifyIdleExitRequested();
                    n nVar3 = n.f10413a;
                } catch (Throwable th3) {
                    kotlin.c.a(th3);
                }
                this.label = 1;
                if (DelayKt.delay(300L, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            AIEngineLogger.w(LogModule.OTA, OtaProcessService.TAG, "idle-exit force: killing :ota pid=" + Process.myPid());
            Process.killProcess(Process.myPid());
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass1) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaProcessService$onCreate$2", f = "OtaProcessService.kt", l = {56}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaProcessService$onCreate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return OtaProcessService.this.new AnonymousClass2(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                StateFlow<Map<String, OtaStateSnapshot>> state = OtaContainer.INSTANCE.getState();
                final OtaProcessService otaProcessService = OtaProcessService.this;
                FlowCollector<? super Map<String, OtaStateSnapshot>> flowCollector = new FlowCollector() { // from class: com.stepos.core.ota.process.OtaProcessService.onCreate.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, qb.b bVar) {
                        return emit((Map<String, OtaStateSnapshot>) obj2, (qb.b<? super n>) bVar);
                    }

                    public final Object emit(Map<String, OtaStateSnapshot> map, qb.b<? super n> bVar) {
                        OtaIdleExitScheduler otaIdleExitScheduler = otaProcessService.idleExitScheduler;
                        if (otaIdleExitScheduler != null) {
                            otaIdleExitScheduler.onSnapshotsChanged(map);
                        }
                        return n.f10413a;
                    }
                };
                this.label = 1;
                if (state.collect(flowCollector, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    private final void handleFgsTimeout(int i10) {
        AIEngineLogger.w(LogModule.OTA, TAG, "dataSync FGS timeout startId=" + i10 + ", releasing anchor & stopping");
        try {
            OtaTaskSnapshotStore.INSTANCE.flushForProcessExit(OtaContainer.INSTANCE.snapshot());
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        try {
            OtaContainer.INSTANCE.getNotifier().releaseAnyForegroundAnchor();
            n nVar2 = n.f10413a;
        } catch (Throwable th2) {
            kotlin.c.a(th2);
        }
        this.isForeground = false;
        try {
            stopForeground(1);
            n nVar3 = n.f10413a;
        } catch (Throwable th3) {
            kotlin.c.a(th3);
        }
        try {
            this.binder.notifyIdleExitRequested();
            n nVar4 = n.f10413a;
        } catch (Throwable th4) {
            kotlin.c.a(th4);
        }
        stopSelf(i10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void handleIdleExitDump(java.io.PrintWriter r14, java.util.List<java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.process.OtaProcessService.handleIdleExitDump(java.io.PrintWriter, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence handleIdleExitDump$lambda$18(OtaStateSnapshot it) {
        g.f(it, "it");
        return it.getOtaId() + ":" + i.a(it.getState().getClass()).c() + "(" + it.getProgress() + "%)";
    }

    private static final String handleIdleExitDump$ovr(Long l10) {
        if (l10 == null) {
            return "null";
        }
        String str = (l10.longValue() / 1000) + "s";
        return str == null ? "null" : str;
    }

    private static final n handleIdleExitDump$reschedule(OtaProcessService otaProcessService) {
        Object objA;
        OtaIdleExitScheduler otaIdleExitScheduler = otaProcessService.idleExitScheduler;
        if (otaIdleExitScheduler == null) {
            return null;
        }
        try {
            objA = OtaContainer.INSTANCE.snapshot();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object objD0 = kotlin.collections.b.d0();
        if (objA instanceof Result.Failure) {
            objA = objD0;
        }
        otaIdleExitScheduler.onSnapshotsChanged((Map) objA);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreate$lambda$1(OtaProcessService otaProcessService) {
        OtaProcessShutdown.requestIdleExit$default(OtaProcessShutdown.INSTANCE, otaProcessService.binder, false, new b(otaProcessService, 0), 2, null);
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreate$lambda$1$lambda$0(OtaProcessService otaProcessService) {
        otaProcessService.stopSelf();
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreate$lambda$3(OtaProcessService otaProcessService) {
        OtaProcessShutdown.INSTANCE.requestIdleExit(otaProcessService.binder, true, new c(otaProcessService, 1));
        return n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n onCreate$lambda$3$lambda$2(OtaProcessService otaProcessService) {
        otaProcessService.stopSelf();
        return n.f10413a;
    }

    @Override // com.stepos.core.common.notification.ForegroundHost
    public void attachForeground(int i10, Notification notification) {
        Object objA;
        g.f(notification, "notification");
        try {
            startForeground(i10, notification, 1);
            this.isForeground = true;
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("attachForeground failed: ", thB.getMessage(), LogModule.OTA, TAG);
        }
    }

    @Override // com.stepos.core.common.notification.ForegroundHost
    public void detachForeground() {
        if (this.isForeground) {
            this.isForeground = false;
            stopForeground(2);
        }
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter writer, String[] strArr) {
        List<String> listQ0;
        g.f(writer, "writer");
        if (strArr == null || (listQ0 = l.q0(strArr)) == null) {
            listQ0 = EmptyList.f10001a;
        }
        if (g.b(kotlin.collections.a.v0(listQ0), "idle-exit")) {
            handleIdleExitDump(writer, kotlin.collections.a.p0(1, listQ0));
            return;
        }
        DownloadControlCenter companion = DownloadControlCenter.Companion.getInstance();
        if (companion == null) {
            writer.println("Download control: (not initialized in :ota)");
        } else {
            companion.handleDump(writer, listQ0);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Object objA;
        OtaIdleExitScheduler otaIdleExitScheduler = this.idleExitScheduler;
        if (otaIdleExitScheduler != null) {
            try {
                objA = OtaContainer.INSTANCE.snapshot();
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Object objD0 = kotlin.collections.b.d0();
            if (objA instanceof Result.Failure) {
                objA = objD0;
            }
            otaIdleExitScheduler.onSnapshotsChanged((Map) objA);
        }
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AIEngineLogger.i(LogModule.OTA, TAG, "OtaProcessService onCreate pid=" + Process.myPid());
        OtaProcessShutdown.INSTANCE.reset();
        OtaProcessBootstrap otaProcessBootstrap = OtaProcessBootstrap.INSTANCE;
        Context applicationContext = getApplicationContext();
        g.e(applicationContext, "getApplicationContext(...)");
        otaProcessBootstrap.start(applicationContext);
        this.binder.startObserving();
        this.idleExitScheduler = new OtaIdleExitScheduler(this.scope, new c(this, 0));
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
        this.binder.setOnShutdownRequested(new b(this, 1));
        OtaContainer.INSTANCE.getNotifier().setForegroundHost(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        OtaIdleExitScheduler otaIdleExitScheduler = this.idleExitScheduler;
        if (otaIdleExitScheduler != null) {
            otaIdleExitScheduler.stop();
        }
        this.idleExitScheduler = null;
        OtaProcessShutdown otaProcessShutdown = OtaProcessShutdown.INSTANCE;
        boolean zIsExiting = otaProcessShutdown.isExiting();
        otaProcessShutdown.reset();
        try {
            OtaContainer.INSTANCE.getNotifier().setForegroundHost(null);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        OtaProcessBootstrap otaProcessBootstrap = OtaProcessBootstrap.INSTANCE;
        Context applicationContext = getApplicationContext();
        g.e(applicationContext, "getApplicationContext(...)");
        otaProcessBootstrap.stop(applicationContext);
        super.onDestroy();
        if (zIsExiting) {
            AIEngineLogger.i(LogModule.OTA, TAG, "idle exit: killing empty :ota process pid=" + Process.myPid());
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        Object objA;
        OtaIdleExitScheduler otaIdleExitScheduler = this.idleExitScheduler;
        if (otaIdleExitScheduler != null) {
            try {
                objA = OtaContainer.INSTANCE.snapshot();
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Object objD0 = kotlin.collections.b.d0();
            if (objA instanceof Result.Failure) {
                objA = objD0;
            }
            otaIdleExitScheduler.onSnapshotsChanged((Map) objA);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        Object objA;
        this.lastStartId = i11;
        OtaProcessShutdown.INSTANCE.reset();
        OtaIdleExitScheduler otaIdleExitScheduler = this.idleExitScheduler;
        if (otaIdleExitScheduler != null) {
            otaIdleExitScheduler.cancelPending();
        }
        OtaIdleExitScheduler otaIdleExitScheduler2 = this.idleExitScheduler;
        if (otaIdleExitScheduler2 == null) {
            return 2;
        }
        try {
            objA = OtaContainer.INSTANCE.snapshot();
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object objD0 = kotlin.collections.b.d0();
        if (objA instanceof Result.Failure) {
            objA = objD0;
        }
        otaIdleExitScheduler2.onSnapshotsChanged((Map) objA);
        return 2;
    }

    @Override // android.app.Service
    public void onTimeout(int i10) {
        handleFgsTimeout(i10);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override // com.stepos.core.common.notification.ForegroundHost
    public void removeForeground() {
        Object objA;
        if (this.isForeground) {
            this.isForeground = false;
            try {
                stopForeground(1);
                objA = n.f10413a;
            } catch (Throwable th) {
                objA = kotlin.c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                ai.onnxruntime.a.w("removeForeground failed: ", thB.getMessage(), LogModule.OTA, TAG);
            }
        }
    }

    public void onTimeout(int i10, int i11) {
        handleFgsTimeout(i10);
    }
}
