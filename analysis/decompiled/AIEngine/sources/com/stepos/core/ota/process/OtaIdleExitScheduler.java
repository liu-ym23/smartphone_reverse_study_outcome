package com.stepos.core.ota.process;

import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.OtaContainer;
import com.stepos.core.ota.domain.OtaStateSnapshot;
import com.stepos.core.ota.storage.OtaTaskSnapshotStore;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import lb.n;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaIdleExitScheduler {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "OtaIdleExit";
    private volatile Job exitJob;
    private final zb.a<n> onRequestExit;
    private final CoroutineScope scope;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaIdleExitScheduler$onSnapshotsChanged$2", f = "OtaIdleExitScheduler.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaIdleExitScheduler$onSnapshotsChanged$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        int label;

        public AnonymousClass2(qb.b<? super AnonymousClass2> bVar) {
            super(2, bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            return OtaIdleExitScheduler.this.new AnonymousClass2(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.c.b(obj);
            OtaIdleExitScheduler.this.onRequestExit.invoke();
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.process.OtaIdleExitScheduler$onSnapshotsChanged$3", f = "OtaIdleExitScheduler.kt", l = {37}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.process.OtaIdleExitScheduler$onSnapshotsChanged$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<CoroutineScope, qb.b<? super n>, Object> {
        final /* synthetic */ long $delayMs;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ OtaIdleExitScheduler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j10, OtaIdleExitScheduler otaIdleExitScheduler, qb.b<? super AnonymousClass3> bVar) {
            super(2, bVar);
            this.$delayMs = j10;
            this.this$0 = otaIdleExitScheduler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qb.b<n> create(Object obj, qb.b<?> bVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$delayMs, this.this$0, bVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
            int i10 = this.label;
            if (i10 == 0) {
                kotlin.c.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                long j10 = this.$delayMs;
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(j10, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.c.b(obj);
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
            if (OtaIdleExitPolicy.INSTANCE.shouldExitNow((Map) objA, SystemClock.elapsedRealtime())) {
                AIEngineLogger.i(LogModule.OTA, OtaIdleExitScheduler.TAG, "idle exit firing after delay");
                this.this$0.onRequestExit.invoke();
            }
            return n.f10413a;
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, qb.b<? super n> bVar) {
            return ((AnonymousClass3) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    public OtaIdleExitScheduler(CoroutineScope scope, zb.a<n> onRequestExit) {
        g.f(scope, "scope");
        g.f(onRequestExit, "onRequestExit");
        this.scope = scope;
        this.onRequestExit = onRequestExit;
    }

    public final void cancelPending() {
        Job job = this.exitJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.exitJob = null;
    }

    public final void onSnapshotsChanged(Map<String, OtaStateSnapshot> snapshots) {
        g.f(snapshots, "snapshots");
        try {
            OtaTaskSnapshotStore.INSTANCE.sync(snapshots);
            n nVar = n.f10413a;
        } catch (Throwable th) {
            kotlin.c.a(th);
        }
        Job job = this.exitJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        Long lMillisUntilExit = OtaIdleExitPolicy.INSTANCE.millisUntilExit(snapshots, SystemClock.elapsedRealtime());
        if (lMillisUntilExit != null) {
            long jLongValue = lMillisUntilExit.longValue();
            if (jLongValue == 0) {
                AIEngineLogger.i(LogModule.OTA, TAG, "idle exit due now, tasks=" + snapshots.size());
                BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass2(null), 3, null);
                return;
            }
            AIEngineLogger.d(LogModule.OTA, TAG, "idle exit scheduled in " + jLongValue + "ms, tasks=" + snapshots.size());
            this.exitJob = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass3(jLongValue, this, null), 3, null);
        }
    }

    public final void stop() {
        Job job = this.exitJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        this.exitJob = null;
    }
}
