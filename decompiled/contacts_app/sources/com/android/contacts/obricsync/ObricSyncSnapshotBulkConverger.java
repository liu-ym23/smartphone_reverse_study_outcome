package com.android.contacts.obricsync;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\rJ8\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0014\b\u0004\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0013H\u0082\b¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u000bJ\u0010\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0011R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/contacts/obricsync/ObricSyncSnapshotBulkConverger;", "", "store", "Lcom/android/contacts/obricsync/SnapshotBulkConvergeStore;", "gateway", "Lcom/android/contacts/obricsync/SnapshotBulkConvergeGateway;", "scheduler", "Lcom/android/contacts/obricsync/CleanupScheduler;", "infoLogger", "Lkotlin/Function1;", "", "", "errorLogger", "(Lcom/android/contacts/obricsync/SnapshotBulkConvergeStore;Lcom/android/contacts/obricsync/SnapshotBulkConvergeGateway;Lcom/android/contacts/obricsync/CleanupScheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "measureMillis", ExifInterface.GPS_DIRECTION_TRUE, "onElapsed", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runOnce", "schedule", "delayMillis", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricSyncSnapshotBulkConverger {
    public static final Companion Companion = null;
    private static final String LOG_PREFIX = "[SYNC-BULK-CLEANUP]";
    private final Function1<String, Unit> errorLogger;
    private final SnapshotBulkConvergeGateway gateway;
    private final Function1<String, Unit> infoLogger;
    private final CleanupScheduler scheduler;
    private final SnapshotBulkConvergeStore store;

    /* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/obricsync/ObricSyncSnapshotBulkConverger$Companion;", "", "()V", "LOG_PREFIX", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.obricsync.ObricSyncSnapshotBulkConverger$runOnce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C02071 extends FunctionReferenceImpl implements Function0<Unit> {
        C02071(Object r8) {
            super(0, r8, ObricSyncSnapshotBulkConverger.class, "runOnce", "runOnce()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ObricSyncSnapshotBulkConverger) this.receiver).runOnce();
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.obricsync.ObricSyncSnapshotBulkConverger$runOnce$6, reason: invalid class name */
    /* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class AnonymousClass6 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass6(Object r8) {
            super(0, r8, ObricSyncSnapshotBulkConverger.class, "runOnce", "runOnce()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ObricSyncSnapshotBulkConverger) this.receiver).runOnce();
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.obricsync.ObricSyncSnapshotBulkConverger$schedule$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* synthetic */ class C02081 extends FunctionReferenceImpl implements Function0<Unit> {
        C02081(Object r8) {
            super(0, r8, ObricSyncSnapshotBulkConverger.class, "runOnce", "runOnce()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ObricSyncSnapshotBulkConverger) this.receiver).runOnce();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricSyncSnapshotBulkConverger(SnapshotBulkConvergeStore r2, SnapshotBulkConvergeGateway r3, CleanupScheduler r4, Function1<? super String, Unit> r5, Function1<? super String, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "store");
        Intrinsics.checkNotNullParameter(r3, "gateway");
        Intrinsics.checkNotNullParameter(r5, "infoLogger");
        Intrinsics.checkNotNullParameter(r6, "errorLogger");
        this.store = r2;
        this.gateway = r3;
        this.scheduler = r4;
        this.infoLogger = r5;
        this.errorLogger = r6;
    }

    public /* synthetic */ ObricSyncSnapshotBulkConverger(SnapshotBulkConvergeStore r7, SnapshotBulkConvergeGateway r8, CleanupScheduler r9, AnonymousClass1 r10, AnonymousClass2 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = null;
    L5:
        CleanupScheduler r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = AnonymousClass1.INSTANCE;
    L8:
        Function1 r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = AnonymousClass2.INSTANCE;
    L11:
        this(r7, r8, r3, r4, r11);
    }

    public static /* synthetic */ void schedule$default(ObricSyncSnapshotBulkConverger r0, long r1, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = 30000;
    L5:
        r0.schedule(r1);
    }

    public final void schedule(long r3) {
        CleanupScheduler r0 = this.scheduler;
        if (r0 == null) goto L6;
        r0.schedule(r3, new C02081(this));
        return;
    }

    public final void runOnce() {
        long r1 = System.nanoTime();
        if (this.store.markRunning() == true) goto L8;
        this.errorLogger.invoke("[SYNC-BULK-CLEANUP] mark running failed");
        CleanupScheduler r2 = this.scheduler;
        if (r2 == null) goto L35;
        r2.schedule(60000, new C02071(this));
        return;
    L35:
        return;
    L8:
        long r6 = System.nanoTime();
        SnapshotBulkPlan r3 = this.gateway.scanDuplicateGroups();
        long r8 = System.nanoTime() - r6;
        long r7 = 1000000;
        long r11 = r8 / r7;
        if (r3.getRedundantIds().isEmpty() == false) goto L12;
        SnapshotBulkConvergeSummary r4 = new SnapshotBulkConvergeSummary(0, 0, 0, 0);
        this.store.markComplete(r4);
        this.infoLogger.invoke("[SYNC-BULK-CLEANUP] scan complete, " + r4.toLogString() + ", " + new SnapshotBulkTiming(r11, 0, 0, 0, (System.nanoTime() - r1) / r7).toLogString());
        return;
    L12:
        this.infoLogger.invoke("[SYNC-BULK-CLEANUP] start, groups=" + r3.getGroups().size() + ", redundant=" + r3.getRedundantIds().size() + ", canonical=" + r3.getCanonicalPairs().size() + ", chunkSize=1000, scanMs=" + r11);
        List r9 = CollectionsKt.chunked(r3.getRedundantIds(), 1000);
        long r15 = System.nanoTime();
        List r13 = r9;
        Iterator r17 = r13.iterator();
    L14:
        if (r17.hasNext() == false) goto L16;
        this.gateway.stageDeleted((List) r17.next());
        goto L14
    L16:
        Unit r5 = Unit.INSTANCE;
        long r10 = (System.nanoTime() - r15) / r7;
        this.infoLogger.invoke("[SYNC-BULK-CLEANUP] phase=setDeleted, chunks=" + r9.size() + ", redundant=" + r3.getRedundantIds().size() + ", elapsedMs=" + r10);
        long r12 = System.nanoTime();
        Iterator r16 = r3.getCanonicalPairs().iterator();
    L18:
        if (r16.hasNext() == false) goto L20;
        Pair r18 = (Pair) r16.next();
        long r22 = r10;
        long r14 = ((Number) r18.component1()).longValue();
        long r19 = r11;
        long r110 = ((Number) r18.component2()).longValue();
        this.gateway.refreshCanonical(r14, r110);
        r16 = r16;
        r11 = r19;
        r10 = r22;
        goto L18
    L20:
        long r23 = r10;
        long r111 = r11;
        Unit r20 = Unit.INSTANCE;
        long r21 = (System.nanoTime() - r12) / r7;
        this.infoLogger.invoke("[SYNC-BULK-CLEANUP] phase=refreshCanonical, canonical=" + r3.getCanonicalPairs().size() + ", elapsedMs=" + r21);
        long r24 = System.nanoTime();
        Iterator r112 = r13.iterator();
        int r113 = 0;
    L22:
        if (r112.hasNext() == false) goto L24;
        r113 = r113 + this.gateway.deleteSnapshots((List) r112.next());
        goto L22
    L24:
        long r25 = (System.nanoTime() - r24) / r7;
        this.infoLogger.invoke("[SYNC-BULK-CLEANUP] phase=deleteSnapshots, chunks=" + r9.size() + ", deleted=" + r113 + ", elapsedMs=" + r25);
        SnapshotBulkConvergeSummary r26 = new SnapshotBulkConvergeSummary(r3.getGroups().size(), r3.getRedundantIds().size(), r3.getCanonicalPairs().size(), r113);
        if (this.store.markComplete(r26) == true) goto L30;
        this.errorLogger.invoke("[SYNC-BULK-CLEANUP] mark complete failed, " + r26.toLogString());
        CleanupScheduler r27 = this.scheduler;
        if (r27 == null) goto L36;
        r27.schedule(60000, new AnonymousClass6(this));
        return;
    L36:
        return;
    L30:
        this.infoLogger.invoke("[SYNC-BULK-CLEANUP] done, " + r26.toLogString() + ", " + new SnapshotBulkTiming(r111, r23, r21, r25, (System.nanoTime() - r1) / r7).toLogString());
    }

    private final <T> T measureMillis(Function1<? super Long, Unit> r5, Function0<? extends T> r6) {
        long r0 = System.nanoTime();
        T r4 = r6.invoke();
        r5.invoke(Long.valueOf((System.nanoTime() - r0) / ((long) 1000000)));
        return r4;
    }
}
