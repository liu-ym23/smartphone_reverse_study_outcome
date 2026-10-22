package com.stepos.core.ota.adapter;

import android.os.SystemClock;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import com.stepos.core.ota.domain.port.ModelDownloadPort;
import com.stepos.core.ota.download.control.DeviceConditions;
import com.stepos.core.ota.download.control.DownloadControlCenter;
import com.stepos.core.ota.downloader.DownloadEngine;
import com.stepos.core.ota.downloader.DownloadListener;
import com.stepos.core.ota.downloader.DownloadRateLimiter;
import com.stepos.core.ota.downloader.DownloadTask;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Result;
import kotlin.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import qb.b;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Fetch2ModelDownloadPort implements ModelDownloadPort {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int LOG_PCT_STEP = 5;

    @Deprecated
    public static final long ORPHAN_GROWTH_THRESHOLD_BYTES = 262144;

    @Deprecated
    public static final long ORPHAN_SAMPLE_INTERVAL_MS = 2000;

    @Deprecated
    public static final long PROGRESS_CALLBACK_STALE_MS = 2000;

    @Deprecated
    public static final long PROGRESS_WATCHDOG_INTERVAL_MS = 1000;

    @Deprecated
    public static final long STOP_CONFIRM_TIMEOUT_MS = 3000;

    @Deprecated
    public static final String TAG = "Fetch2DownloadPort";
    private final zb.a<Long> elapsedMs;
    private final DownloadEngine engine;
    private final AtomicInteger lastLoggedPctBucket;
    private final ConcurrentHashMap<String, ProgressSample> samples;
    private final ConcurrentHashMap<String, Slot> slots;
    private final CoroutineScope watchdogScope;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements zb.a<Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0, SystemClock.class, "elapsedRealtime", "elapsedRealtime()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // zb.a
        public final Long invoke() {
            return Long.valueOf(SystemClock.elapsedRealtime());
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ProgressSample {
        private final long downloaded;
        private final long speedBps;
        private final long total;

        public ProgressSample(long j10, long j11, long j12) {
            this.downloaded = j10;
            this.total = j11;
            this.speedBps = j12;
        }

        public static /* synthetic */ ProgressSample copy$default(ProgressSample progressSample, long j10, long j11, long j12, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = progressSample.downloaded;
            }
            long j13 = j10;
            if ((i10 & 2) != 0) {
                j11 = progressSample.total;
            }
            long j14 = j11;
            if ((i10 & 4) != 0) {
                j12 = progressSample.speedBps;
            }
            return progressSample.copy(j13, j14, j12);
        }

        public final long component1() {
            return this.downloaded;
        }

        public final long component2() {
            return this.total;
        }

        public final long component3() {
            return this.speedBps;
        }

        public final ProgressSample copy(long j10, long j11, long j12) {
            return new ProgressSample(j10, j11, j12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProgressSample)) {
                return false;
            }
            ProgressSample progressSample = (ProgressSample) obj;
            return this.downloaded == progressSample.downloaded && this.total == progressSample.total && this.speedBps == progressSample.speedBps;
        }

        public final long getDownloaded() {
            return this.downloaded;
        }

        public final long getSpeedBps() {
            return this.speedBps;
        }

        public final long getTotal() {
            return this.total;
        }

        public int hashCode() {
            return Long.hashCode(this.speedBps) + a0.a.c(Long.hashCode(this.downloaded) * 31, this.total, 31);
        }

        public String toString() {
            long j10 = this.downloaded;
            long j11 = this.total;
            long j12 = this.speedBps;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "ProgressSample(downloaded=", ", total=");
            sbQ.append(j11);
            return a0.a.d(j12, ", speedBps=", ")", sbQ);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class Slot implements DownloadListener {
        private volatile CancellableContinuation<? super Result<String>> cont;
        private final AtomicLong deliveredBytes;
        private final String file;
        private final int groupId;
        private volatile long lastEngineEventAtMs;
        private final p<Long, Long, n> onProgress;
        private final String otaId;
        private final AtomicBoolean ownLifecycleStarted;
        private final AtomicBoolean progressWatchdogArmed;
        private final AtomicBoolean settled;
        private volatile Result<String> settledResult;
        private final AtomicInteger startedCount;
        private final CompletableDeferred<n> stopped;
        final /* synthetic */ Fetch2ModelDownloadPort this$0;
        private final AtomicBoolean watchdogArmed;
        private final AtomicBoolean watchdogRepairLogged;

        /* JADX WARN: Multi-variable type inference failed */
        public Slot(Fetch2ModelDownloadPort fetch2ModelDownloadPort, String otaId, int i10, String file, p<? super Long, ? super Long, n> onProgress) {
            g.f(otaId, "otaId");
            g.f(file, "file");
            g.f(onProgress, "onProgress");
            this.this$0 = fetch2ModelDownloadPort;
            this.otaId = otaId;
            this.groupId = i10;
            this.file = file;
            this.onProgress = onProgress;
            this.settled = new AtomicBoolean(false);
            this.stopped = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            this.startedCount = new AtomicInteger(0);
            this.ownLifecycleStarted = new AtomicBoolean(false);
            this.watchdogArmed = new AtomicBoolean(false);
            this.progressWatchdogArmed = new AtomicBoolean(false);
            this.watchdogRepairLogged = new AtomicBoolean(false);
            this.lastEngineEventAtMs = ((Number) fetch2ModelDownloadPort.elapsedMs.invoke()).longValue();
            this.deliveredBytes = new AtomicLong(0L);
        }

        /* renamed from: cancelled-IoAF18A, reason: not valid java name */
        private final Object m111cancelledIoAF18A(String str) {
            return c.a(new CancellationException(str));
        }

        private final void emit(DownloadTask downloadTask, boolean z) {
            if (z) {
                this.lastEngineEventAtMs = ((Number) this.this$0.elapsedMs.invoke()).longValue();
            }
            if (this.settled.get() || this.cont == null) {
                return;
            }
            if (z || downloadTask.getDownloaded() > this.deliveredBytes.get()) {
                this.deliveredBytes.set(downloadTask.getDownloaded());
                this.onProgress.invoke(Long.valueOf(downloadTask.getDownloaded()), Long.valueOf(downloadTask.getTotal()));
            }
        }

        private final boolean mine(DownloadTask downloadTask) {
            return Fetch2ModelDownloadPortKt.sameDownloadFile(downloadTask.getFile(), this.file);
        }

        public final void attach(CancellableContinuation<? super Result<String>> c9) {
            g.f(c9, "c");
            this.cont = c9;
            Result<String> result = this.settledResult;
            if (result != null) {
                Object obj = result.f9987a;
                this.cont = null;
                if (c9.isActive()) {
                    c9.resumeWith(new Result(obj));
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object awaitStopped(long r5, qb.b<? super java.lang.Boolean> r7) {
            /*
                r4 = this;
                boolean r0 = r7 instanceof com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$1
                if (r0 == 0) goto L13
                r0 = r7
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$1 r0 = (com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$1 r0 = new com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$1
                r0.<init>(r4, r7)
            L18:
                java.lang.Object r7 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L2f
                if (r2 != r3) goto L27
                kotlin.c.b(r7)
                goto L41
            L27:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L2f:
                kotlin.c.b(r7)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$2 r7 = new com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot$awaitStopped$2
                r2 = 0
                r7.<init>(r4, r2)
                r0.label = r3
                java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r5, r7, r0)
                if (r7 != r1) goto L41
                return r1
            L41:
                if (r7 == 0) goto L44
                goto L45
            L44:
                r3 = 0
            L45:
                java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.Slot.awaitStopped(long, qb.b):java.lang.Object");
        }

        public final void detachContinuation() {
            this.cont = null;
        }

        public final void emitFromWatchdog(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                emit(task, false);
            }
        }

        public final String getFile() {
            return this.file;
        }

        public final int getGroupId() {
            return this.groupId;
        }

        public final long getLastEngineEventAtMs() {
            return this.lastEngineEventAtMs;
        }

        public final String getOtaId() {
            return this.otaId;
        }

        public final AtomicBoolean getProgressWatchdogArmed() {
            return this.progressWatchdogArmed;
        }

        public final AtomicBoolean getWatchdogArmed() {
            return this.watchdogArmed;
        }

        public final AtomicBoolean getWatchdogRepairLogged() {
            return this.watchdogRepairLogged;
        }

        public final boolean isStopped() {
            return this.stopped.isCompleted();
        }

        public final long lastDeliveredBytes() {
            return this.deliveredBytes.get();
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onAdded(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                this.ownLifecycleStarted.set(true);
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onCancelled(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                settle(m111cancelledIoAF18A("cancelled"));
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onCompleted(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                settle(this.file);
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onDeleted(DownloadTask task) {
            g.f(task, "task");
            if (mine(task) && this.ownLifecycleStarted.get()) {
                settle(m111cancelledIoAF18A("deleted"));
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onDownloadBlockUpdated(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                emit(task, true);
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onError(DownloadTask task, Throwable th) {
            g.f(task, "task");
            if (mine(task)) {
                if (th == null) {
                    th = new IOException(ai.onnxruntime.a.k("download error: ", this.otaId));
                }
                settle(c.a(th));
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onPaused(DownloadTask downloadTask) {
            DownloadListener.DefaultImpls.onPaused(this, downloadTask);
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onProgress(DownloadTask task, long j10, long j11) {
            g.f(task, "task");
            if (mine(task)) {
                emit(task, true);
                this.this$0.samples.put(this.file, new ProgressSample(task.getDownloaded(), task.getTotal(), j11));
                this.this$0.logGlobalRate();
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onQueued(DownloadTask task, boolean z) {
            g.f(task, "task");
            if (mine(task)) {
                this.ownLifecycleStarted.set(true);
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onRemoved(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                settle(m111cancelledIoAF18A("removed"));
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onResumed(DownloadTask downloadTask) {
            DownloadListener.DefaultImpls.onResumed(this, downloadTask);
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onStarted(DownloadTask task) {
            g.f(task, "task");
            if (mine(task)) {
                this.ownLifecycleStarted.set(true);
                if (this.startedCount.incrementAndGet() > 1) {
                    this.this$0.onDuplicateRunner(this);
                } else {
                    emit(task, true);
                }
            }
        }

        @Override // com.stepos.core.ota.downloader.DownloadListener
        public void onWaitingNetwork(DownloadTask downloadTask) {
            DownloadListener.DefaultImpls.onWaitingNetwork(this, downloadTask);
        }

        public final void settle(Object obj) {
            if (this.settled.compareAndSet(false, true)) {
                this.settledResult = new Result<>(obj);
                this.this$0.samples.remove(this.file);
                if (this.this$0.samples.isEmpty()) {
                    this.this$0.lastLoggedPctBucket.set(-1);
                }
                try {
                    this.this$0.engine.removeListener(this);
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    c.a(th);
                }
                this.this$0.slots.remove(this.otaId, this);
                CancellableContinuation<? super Result<String>> cancellableContinuation = this.cont;
                if (cancellableContinuation != null) {
                    if (!cancellableContinuation.isActive()) {
                        cancellableContinuation = null;
                    }
                    if (cancellableContinuation != null) {
                        cancellableContinuation.resumeWith(new Result(obj));
                    }
                }
                this.cont = null;
                this.stopped.complete(n.f10413a);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$armOrphanWatchdog$1", f = "Fetch2ModelDownloadPort.kt", l = {212, 214}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$armOrphanWatchdog$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03831 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ Slot $slot;
        long J$0;
        int label;
        final /* synthetic */ Fetch2ModelDownloadPort this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03831(Slot slot, Fetch2ModelDownloadPort fetch2ModelDownloadPort, b<? super C03831> bVar) {
            super(2, bVar);
            this.$slot = slot;
            this.this$0 = fetch2ModelDownloadPort;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new C03831(this.$slot, this.this$0, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                long r0 = r6.J$0
                kotlin.c.b(r7)
                goto L4a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1a:
                kotlin.c.b(r7)
                goto L2e
            L1e:
                kotlin.c.b(r7)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r7 = r6.$slot
                r6.label = r3
                r3 = 3000(0xbb8, double:1.482E-320)
                java.lang.Object r7 = r7.awaitStopped(r3, r6)
                if (r7 != r0) goto L2e
                goto L48
            L2e:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r7 = r6.this$0
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r6.$slot
                java.lang.Long r7 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.access$downloadedBytesOf(r7, r1)
                if (r7 == 0) goto Lbc
                long r3 = r7.longValue()
                r6.J$0 = r3
                r6.label = r2
                r1 = 2000(0x7d0, double:9.88E-321)
                java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r1, r6)
                if (r7 != r0) goto L49
            L48:
                return r0
            L49:
                r0 = r3
            L4a:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r7 = r6.this$0
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r2 = r6.$slot
                java.lang.Long r7 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.access$downloadedBytesOf(r7, r2)
                if (r7 == 0) goto Lb9
                long r2 = r7.longValue()
                long r2 = r2 - r0
                r0 = 262144(0x40000, double:1.295163E-318)
                int r7 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r7 >= 0) goto L63
                lb.n r6 = lb.n.f10413a
                return r6
            L63:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r7 = r6.this$0
                java.util.concurrent.ConcurrentHashMap r7 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.access$getSlots$p(r7)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r0 = r6.$slot
                java.lang.String r0 = r0.getOtaId()
                java.lang.Object r7 = r7.get(r0)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r7 = (com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.Slot) r7
                java.lang.String r0 = "Fetch2DownloadPort"
                if (r7 == 0) goto L93
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r6.$slot
                if (r7 == r1) goto L93
                com.stepos.core.common.log.LogModule r6 = com.stepos.core.common.log.LogModule.OTA
                java.lang.String r7 = r1.getOtaId()
                java.lang.String r1 = "["
                java.lang.String r4 = "] bytes grew (+"
                java.lang.StringBuilder r7 = com.stepos.core.ota.d.l(r1, r2, r7, r4)
                java.lang.String r1 = "B) after cancel but a new transfer is already running; cannot tell orphan from resume → not purging"
                a0.a.x(r7, r1, r6, r0)
                lb.n r6 = lb.n.f10413a
                return r6
            L93:
                com.stepos.core.common.log.LogModule r7 = com.stepos.core.common.log.LogModule.OTA
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r6.$slot
                java.lang.String r1 = r1.getOtaId()
                java.lang.String r4 = "orphan downloader for ["
                java.lang.String r5 = "] kept downloading after cancel (+"
                java.lang.StringBuilder r1 = com.stepos.core.ota.d.l(r4, r2, r1, r5)
                java.lang.String r2 = "B in 2000ms) → purging records & partial file"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                com.stepos.core.common.log.AIEngineLogger.e(r7, r0, r1)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r7 = r6.this$0
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r6 = r6.$slot
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.access$forceReset(r7, r6)
                lb.n r6 = lb.n.f10413a
                return r6
            Lb9:
                lb.n r6 = lb.n.f10413a
                return r6
            Lbc:
                lb.n r6 = lb.n.f10413a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.C03831.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C03831) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$armProgressWatchdog$1", f = "Fetch2ModelDownloadPort.kt", l = {186}, m = "invokeSuspend")
    /* renamed from: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$armProgressWatchdog$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03841 extends SuspendLambda implements p<CoroutineScope, b<? super n>, Object> {
        final /* synthetic */ Slot $slot;
        int label;
        final /* synthetic */ Fetch2ModelDownloadPort this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03841(Slot slot, Fetch2ModelDownloadPort fetch2ModelDownloadPort, b<? super C03841> bVar) {
            super(2, bVar);
            this.$slot = slot;
            this.this$0 = fetch2ModelDownloadPort;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final b<n> create(Object obj, b<?> bVar) {
            return new C03841(this.$slot, this.this$0, bVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a9  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0028 -> B:14:0x002b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L15
                if (r1 != r2) goto Ld
                kotlin.c.b(r10)
                goto L2b
            Ld:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L15:
                kotlin.c.b(r10)
            L18:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r10 = r9.$slot
                boolean r10 = r10.isStopped()
                if (r10 != 0) goto La9
                r9.label = r2
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r3, r9)
                if (r10 != r0) goto L2b
                return r0
            L2b:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r10 = r9.$slot
                boolean r10 = r10.isStopped()
                if (r10 == 0) goto L36
                lb.n r9 = lb.n.f10413a
                return r9
            L36:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r10 = r9.this$0
                zb.a r10 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.access$getElapsedMs$p(r10)
                java.lang.Object r10 = r10.invoke()
                java.lang.Number r10 = (java.lang.Number) r10
                long r3 = r10.longValue()
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r10 = r9.$slot
                long r5 = r10.getLastEngineEventAtMs()
                long r3 = r3 - r5
                r5 = 2000(0x7d0, double:9.88E-321)
                int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r10 < 0) goto L18
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r10 = r9.this$0
                com.stepos.core.ota.downloader.DownloadEngine r10 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.access$getEngine$p(r10)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r9.$slot
                int r1 = r1.getGroupId()
                java.util.List r10 = r10.getDownloadsInGroup(r1)
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r9.$slot
                java.lang.String r1 = r1.getFile()
                com.stepos.core.ota.downloader.DownloadTask r10 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPortKt.selectDownloadTask(r10, r1)
                if (r10 != 0) goto L70
                goto L18
            L70:
                long r5 = r10.getDownloaded()
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r9.$slot
                long r7 = r1.lastDeliveredBytes()
                int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r1 <= 0) goto L18
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r9.$slot
                java.util.concurrent.atomic.AtomicBoolean r1 = r1.getWatchdogRepairLogged()
                r5 = 0
                boolean r1 = r1.compareAndSet(r5, r2)
                if (r1 == 0) goto La2
                com.stepos.core.common.log.LogModule r1 = com.stepos.core.common.log.LogModule.OTA
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r5 = r9.$slot
                java.lang.String r5 = r5.getOtaId()
                java.lang.String r6 = "["
                java.lang.String r7 = "] Fetch2 progress callback stale for "
                java.lang.StringBuilder r3 = com.stepos.core.ota.d.l(r6, r3, r5, r7)
                java.lang.String r4 = "ms; repairing UI progress from engine database"
                java.lang.String r5 = "Fetch2DownloadPort"
                a0.a.x(r3, r4, r1, r5)
            La2:
                com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r1 = r9.$slot
                r1.emitFromWatchdog(r10)
                goto L18
            La9:
                lb.n r9 = lb.n.f10413a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.C03841.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // zb.p
        public final Object invoke(CoroutineScope coroutineScope, b<? super n> bVar) {
            return ((C03841) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @rb.c(c = "com.stepos.core.ota.adapter.Fetch2ModelDownloadPort", f = "Fetch2ModelDownloadPort.kt", l = {168}, m = "awaitPreviousSlotStopped")
    /* renamed from: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$awaitPreviousSlotStopped$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03851(b<? super C03851> bVar) {
            super(bVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Fetch2ModelDownloadPort.this.awaitPreviousSlotStopped(null, this);
        }
    }

    public Fetch2ModelDownloadPort(DownloadEngine engine, zb.a<Long> elapsedMs) {
        g.f(engine, "engine");
        g.f(elapsedMs, "elapsedMs");
        this.engine = engine;
        this.elapsedMs = elapsedMs;
        this.slots = new ConcurrentHashMap<>();
        this.samples = new ConcurrentHashMap<>();
        this.lastLoggedPctBucket = new AtomicInteger(-1);
        this.watchdogScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void armOrphanWatchdog(Slot slot) {
        if (slot.getWatchdogArmed().compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(this.watchdogScope, null, null, new C03831(slot, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void armProgressWatchdog(Slot slot) {
        if (slot.getProgressWatchdogArmed().compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(this.watchdogScope, null, null, new C03841(slot, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitPreviousSlotStopped(java.lang.String r10, qb.b<? super lb.n> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.C03851
            if (r0 == 0) goto L13
            r0 = r11
            com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$awaitPreviousSlotStopped$1 r0 = (com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.C03851) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$awaitPreviousSlotStopped$1 r0 = new com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$awaitPreviousSlotStopped$1
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f10059a
            int r2 = r0.label
            java.lang.String r3 = "single-flight: ["
            java.lang.String r4 = "Fetch2DownloadPort"
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 != r5) goto L3b
            java.lang.Object r9 = r0.L$2
            com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r9 = (com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.Slot) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r0 = r0.L$0
            com.stepos.core.ota.adapter.Fetch2ModelDownloadPort r0 = (com.stepos.core.ota.adapter.Fetch2ModelDownloadPort) r0
            kotlin.c.b(r11)
            r8 = r11
            r11 = r9
            r9 = r0
            r0 = r8
            goto L8a
        L3b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L43:
            kotlin.c.b(r11)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot> r11 = r9.slots
            java.lang.Object r11 = r11.get(r10)
            com.stepos.core.ota.adapter.Fetch2ModelDownloadPort$Slot r11 = (com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.Slot) r11
            if (r11 != 0) goto L53
            lb.n r9 = lb.n.f10413a
            return r9
        L53:
            com.stepos.core.common.log.LogModule r2 = com.stepos.core.common.log.LogModule.OTA
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r3)
            r6.append(r10)
            java.lang.String r7 = "] previous transfer still registered, awaiting engine stop"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.stepos.core.common.log.AIEngineLogger.w(r2, r4, r6)
            com.stepos.core.ota.downloader.DownloadEngine r2 = r9.engine     // Catch: java.lang.Throwable -> L75
            int r6 = r11.getGroupId()     // Catch: java.lang.Throwable -> L75
            r2.cancelGroup(r6)     // Catch: java.lang.Throwable -> L75
            lb.n r2 = lb.n.f10413a     // Catch: java.lang.Throwable -> L75
            goto L79
        L75:
            r2 = move-exception
            kotlin.c.a(r2)
        L79:
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.label = r5
            r5 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r0 = r11.awaitStopped(r5, r0)
            if (r0 != r1) goto L8a
            return r1
        L8a:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L95
            lb.n r9 = lb.n.f10413a
            return r9
        L95:
            com.stepos.core.common.log.LogModule r0 = com.stepos.core.common.log.LogModule.OTA
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            r1.append(r10)
            java.lang.String r10 = "] engine never confirmed stop in 3000ms → stale downloader assumed, purging records & partial file"
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            com.stepos.core.common.log.AIEngineLogger.e(r0, r4, r10)
            r9.forceReset(r11)
            lb.n r9 = lb.n.f10413a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.awaitPreviousSlotStopped(java.lang.String, qb.b):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long downloadedBytesOf(Slot slot) {
        Object objA;
        try {
            DownloadTask downloadTaskSelectDownloadTask = Fetch2ModelDownloadPortKt.selectDownloadTask(this.engine.getDownloadsInGroup(slot.getGroupId()), slot.getFile());
            objA = downloadTaskSelectDownloadTask != null ? Long.valueOf(downloadTaskSelectDownloadTask.getDownloaded()) : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (Long) (objA instanceof Result.Failure ? null : objA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forceReset(Slot slot) {
        try {
            this.engine.deleteGroup(slot.getGroupId());
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
        slot.settle(c.a(new IOException(ai.onnxruntime.a.k("stale downloader purged for ", slot.getOtaId()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logGlobalRate() {
        long j10;
        DeviceConditions deviceConditionsCurrentConditions;
        Collection<ProgressSample> collectionValues = this.samples.values();
        g.e(collectionValues, "<get-values>(...)");
        List listO0 = kotlin.collections.a.O0(collectionValues);
        if (listO0.isEmpty()) {
            return;
        }
        long total = 0;
        long downloaded = 0;
        long speedBps = 0;
        for (Object obj : listO0) {
            g.e(obj, "next(...)");
            ProgressSample progressSample = (ProgressSample) obj;
            downloaded += progressSample.getDownloaded();
            total += progressSample.getTotal();
            speedBps += progressSample.getSpeedBps();
        }
        int i10 = total > 0 ? (int) ((100 * downloaded) / total) : 0;
        int i11 = i10 / 5;
        int i12 = this.lastLoggedPctBucket.get();
        if ((i10 >= 100 || i11 > i12) && this.lastLoggedPctBucket.compareAndSet(i12, i11)) {
            if (speedBps > 0) {
                long j11 = total - downloaded;
                if (j11 < 0) {
                    j11 = 0;
                }
                j10 = j11 / speedBps;
            } else {
                j10 = -1;
            }
            DownloadControlCenter companion = DownloadControlCenter.Companion.getInstance();
            Float f8 = (companion == null || (deviceConditionsCurrentConditions = companion.currentConditions()) == null) ? null : (Float) deviceConditionsCurrentConditions.get(DeviceConditions.Companion.getTEMPERATURE_C());
            String str = f8 != null ? String.format("%.1f℃", Arrays.copyOf(new Object[]{Float.valueOf(f8.floatValue())}, 1)) : "?";
            LogModule logModule = LogModule.OTA;
            int size = listO0.size();
            String str2 = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(speedBps / 1048576.0d)}, 1));
            long j12 = CryptoHeaderParser.MAX_BLOCK_SIZE;
            long j13 = downloaded / j12;
            long j14 = total / j12;
            String str3 = j10 >= 0 ? j10 + "s" : "?";
            StringBuilder sbD = h0.e.d(size, "dl all(", i10, "): ", "%  ");
            ai.onnxruntime.a.z(sbD, str2, "MB/s  temp=", str, "  ");
            sbD.append(j13);
            a0.a.s(j14, "/", "MB  eta=", sbD);
            a0.a.z(sbD, str3, logModule, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDuplicateRunner(Slot slot) {
        AIEngineLogger.e(LogModule.OTA, TAG, h0.e.c("duplicate downloader detected for [", slot.getOtaId(), "] file=", slot.getFile(), " → purging & failing this attempt"));
        try {
            this.engine.deleteGroup(slot.getGroupId());
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
        slot.settle(c.a(new IOException(ai.onnxruntime.a.k("duplicate downloader for ", slot.getOtaId()))));
    }

    @Override // com.stepos.core.ota.domain.port.ModelDownloadPort
    public void cancel(String otaId) {
        g.f(otaId, "otaId");
        Slot slot = this.slots.get(otaId);
        try {
            this.engine.cancelGroup(otaId.hashCode());
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
        if (slot != null) {
            armOrphanWatchdog(slot);
        }
    }

    @Override // com.stepos.core.ota.domain.port.ModelDownloadPort
    public void discardEngineRecord(String otaId) {
        Object objA;
        g.f(otaId, "otaId");
        try {
            this.engine.deleteGroup(otaId.hashCode());
            objA = n.f10413a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.OTA, TAG, "discardEngineRecord failed: ".concat(otaId), thB);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x012f, code lost:
    
        if (r1 == r3) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.stepos.core.ota.domain.port.ModelDownloadPort
    /* renamed from: download-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo110download0E7RQCE(com.stepos.core.ota.domain.port.DownloadSpec r19, zb.p<? super java.lang.Long, ? super java.lang.Long, lb.n> r20, qb.b<? super kotlin.Result<java.lang.String>> r21) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.mo110download0E7RQCE(com.stepos.core.ota.domain.port.DownloadSpec, zb.p, qb.b):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.Result$Failure] */
    @Override // com.stepos.core.ota.domain.port.ModelDownloadPort
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String findResumeFile(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "otaId"
            kotlin.jvm.internal.g.f(r2, r0)
            java.lang.String r0 = "defaultFilePath"
            kotlin.jvm.internal.g.f(r3, r0)
            com.stepos.core.ota.downloader.DownloadEngine r1 = r1.engine     // Catch: java.lang.Throwable -> L21
            int r2 = r2.hashCode()     // Catch: java.lang.Throwable -> L21
            java.util.List r1 = r1.getDownloadsInGroup(r2)     // Catch: java.lang.Throwable -> L21
            com.stepos.core.ota.downloader.DownloadTask r1 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPortKt.selectResumeTask(r1, r3)     // Catch: java.lang.Throwable -> L21
            if (r1 == 0) goto L23
            java.lang.String r1 = r1.getFile()     // Catch: java.lang.Throwable -> L21
            if (r1 != 0) goto L29
            goto L23
        L21:
            r1 = move-exception
            goto L25
        L23:
            r1 = r3
            goto L29
        L25:
            kotlin.Result$Failure r1 = kotlin.c.a(r1)
        L29:
            boolean r2 = r1 instanceof kotlin.Result.Failure
            if (r2 == 0) goto L2e
            goto L2f
        L2e:
            r3 = r1
        L2f:
            java.lang.String r3 = (java.lang.String) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.findResumeFile(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    @Override // com.stepos.core.ota.domain.port.ModelDownloadPort
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Long queryPartialDownloadedBytes(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "otaId"
            kotlin.jvm.internal.g.f(r7, r0)
            java.lang.String r0 = "targetFilePath"
            kotlin.jvm.internal.g.f(r8, r0)
            r0 = 0
            long r1 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPortKt.downloadFileLength(r8)     // Catch: java.lang.Throwable -> L45
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L16
            goto L47
        L16:
            com.stepos.core.ota.downloader.DownloadEngine r6 = r6.engine     // Catch: java.lang.Throwable -> L45
            int r7 = r7.hashCode()     // Catch: java.lang.Throwable -> L45
            java.util.List r6 = r6.getDownloadsInGroup(r7)     // Catch: java.lang.Throwable -> L45
            com.stepos.core.ota.downloader.DownloadTask r6 = com.stepos.core.ota.adapter.Fetch2ModelDownloadPortKt.selectDownloadTask(r6, r8)     // Catch: java.lang.Throwable -> L45
            if (r6 == 0) goto L47
            long r6 = r6.getDownloaded()     // Catch: java.lang.Throwable -> L45
            java.lang.Long r8 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> L45
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 <= 0) goto L33
            goto L34
        L33:
            r8 = r0
        L34:
            if (r8 == 0) goto L47
            long r6 = r8.longValue()     // Catch: java.lang.Throwable -> L45
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L3f
            goto L40
        L3f:
            r1 = r6
        L40:
            java.lang.Long r6 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L45
            goto L4d
        L45:
            r6 = move-exception
            goto L49
        L47:
            r6 = r0
            goto L4d
        L49:
            kotlin.Result$Failure r6 = kotlin.c.a(r6)
        L4d:
            boolean r7 = r6 instanceof kotlin.Result.Failure
            if (r7 == 0) goto L52
            goto L53
        L52:
            r0 = r6
        L53:
            java.lang.Long r0 = (java.lang.Long) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.adapter.Fetch2ModelDownloadPort.queryPartialDownloadedBytes(java.lang.String, java.lang.String):java.lang.Long");
    }

    @Override // com.stepos.core.ota.domain.port.ModelDownloadPort
    public void setRate(long j10) {
        DownloadRateLimiter.INSTANCE.updateRate(j10);
    }

    public /* synthetic */ Fetch2ModelDownloadPort(DownloadEngine downloadEngine, zb.a aVar, int i10, e eVar) {
        this(downloadEngine, (i10 & 2) != 0 ? AnonymousClass1.INSTANCE : aVar);
    }
}
