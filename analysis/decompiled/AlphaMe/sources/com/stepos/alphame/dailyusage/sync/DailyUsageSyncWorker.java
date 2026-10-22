package com.stepos.alphame.dailyusage.sync;

import B0.r;
import Z2.A;
import Z2.F;
import Z2.Q;
import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import ch.qos.logback.core.CoreConstants;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.data.repo.DailyUsageRepository;
import com.stepos.alphame.data.repo.DefaultDailyUsageRepository;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s0.C0847e;
import s0.C0850h;
import s0.D;
import s0.E;
import s0.I;
import s0.p;
import s0.q;
import s0.t;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/stepos/alphame/dailyusage/sync/DailyUsageSyncWorker;", "Landroidx/work/CoroutineWorker;", "Ls0/r;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LZ2/A;", "dispatcher", "LZ2/A;", "Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "repo$delegate", "Lkotlin/Lazy;", "getRepo", "()Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "repo", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroidx/work/WorkerParameters;", "workerParameters", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "dailyusage_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DailyUsageSyncWorker extends CoroutineWorker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "DailyUsageSyncWorker";

    @NotNull
    private final A dispatcher;

    /* renamed from: repo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy repo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/stepos/alphame/dailyusage/sync/DailyUsageSyncWorker$Companion;", "", "Ls0/E;", "startUpDailyUsageWork", "()Ls0/E;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "dailyusage_release"}, k = 1, mv = {1, 9, 0})
    @SourceDebugExtension({"SMAP\nDailyUsageSyncWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyUsageSyncWorker.kt\ncom/stepos/alphame/dailyusage/sync/DailyUsageSyncWorker$Companion\n+ 2 PeriodicWorkRequest.kt\nandroidx/work/PeriodicWorkRequestKt\n*L\n1#1,51:1\n33#2:52\n*S KotlinDebug\n*F\n+ 1 DailyUsageSyncWorker.kt\ncom/stepos/alphame/dailyusage/sync/DailyUsageSyncWorker$Companion\n*L\n45#1:52\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final E startUpDailyUsageWork() {
            TimeUnit timeUnit = TimeUnit.MINUTES;
            Intrinsics.checkNotNullParameter(DailyUsageSyncWorker.class, "workerClass");
            Intrinsics.checkNotNullParameter(timeUnit, "repeatIntervalTimeUnit");
            D d4 = new D(DailyUsageSyncWorker.class);
            r rVar = d4.f14161b;
            long millis = timeUnit.toMillis(30L);
            rVar.getClass();
            String str = r.f166x;
            if (millis < 900000) {
                t.d().g(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
            }
            long jCoerceAtLeast = RangesKt.coerceAtLeast(millis, 900000L);
            long jCoerceAtLeast2 = RangesKt.coerceAtLeast(millis, 900000L);
            if (jCoerceAtLeast < 900000) {
                t.d().g(str, "Interval duration lesser than minimum allowed value; Changed to 900000");
            }
            rVar.f174h = RangesKt.coerceAtLeast(jCoerceAtLeast, 900000L);
            if (jCoerceAtLeast2 < VehicleBluetoothManager.FAIL_RETRY_TIMEOUT) {
                t.d().g(str, "Flex duration lesser than minimum allowed value; Changed to 300000");
            }
            if (jCoerceAtLeast2 > rVar.f174h) {
                t.d().g(str, "Flex duration greater than interval duration; Changed to " + jCoerceAtLeast);
            }
            rVar.f175i = RangesKt.coerceIn(jCoerceAtLeast2, VehicleBluetoothManager.FAIL_RETRY_TIMEOUT, rVar.f174h);
            C0847e constraints = DailyUsageSyncKt.getSyncConstraints();
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            d4.f14161b.f176j = constraints;
            Intrinsics.checkNotNullParameter(DailyUsageSyncWorker.TAG, "tag");
            d4.f14162c.add(DailyUsageSyncWorker.TAG);
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            d4.f14161b.f173g = timeUnit.toMillis(3L);
            if (LongCompanionObject.MAX_VALUE - System.currentTimeMillis() <= d4.f14161b.f173g) {
                throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
            }
            I iA = d4.a();
            Intrinsics.checkNotNullExpressionValue(iA, "build(...)");
            return (E) iA;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker", f = "DailyUsageSyncWorker.kt", i = {}, l = {24}, m = "doWork", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DailyUsageSyncWorker.this.doWork(this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "Ls0/r;", "<anonymous>", "(LZ2/F;)Ls0/r;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$2", f = "DailyUsageSyncWorker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<F, Continuation<? super s0.r>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DailyUsageSyncWorker.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super s0.r> continuation) {
            return ((AnonymousClass2) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Object systemService = DailyUsageSyncWorker.this.getApplicationContext().getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            if (!((PowerManager) systemService).isInteractive()) {
                Log.d(DailyUsageSyncWorker.TAG, "defer sync: screen off at " + System.currentTimeMillis());
                return new p();
            }
            try {
                Log.d(DailyUsageSyncWorker.TAG, "Starting DailyUsageSyncWorker at " + System.currentTimeMillis());
                DailyUsageSyncWorker.this.getRepo().saveDailyUsages();
                Log.d(DailyUsageSyncWorker.TAG, "DailyUsageSyncWorker finished at " + System.currentTimeMillis());
                return new q(C0850h.f14200c);
            } catch (Exception e4) {
                Log.e(DailyUsageSyncWorker.TAG, "sync failed. " + e4);
                return new p();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyUsageSyncWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.dispatcher = Q.f2190b;
        this.repo = LazyKt.lazy(new Function0<DefaultDailyUsageRepository>() { // from class: com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$repo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DefaultDailyUsageRepository invoke() {
                return DefaultDailyUsageRepository.Companion.getINSTANCE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DailyUsageRepository getRepo() {
        return (DailyUsageRepository) this.repo.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super s0.r> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$1 r0 = (com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$1 r0 = new com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r6)
            Z2.A r6 = r5.dispatcher
            com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$2 r2 = new com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker$doWork$2
            r4 = 0
            r2.<init>(r4)
            r0.label = r3
            java.lang.Object r6 = t0.J.O(r0, r6, r2)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.lang.String r5 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.dailyusage.sync.DailyUsageSyncWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
