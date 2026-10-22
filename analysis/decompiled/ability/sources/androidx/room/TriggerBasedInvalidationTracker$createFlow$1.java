package androidx.room;

import C7.r;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import m9.InterfaceC1733z;
import p9.d;

@J7.c(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1", f = "InvalidationTracker.kt", l = {238, 238, 242}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lp9/d;", "", "", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes2.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1 extends SuspendLambda implements n {
    final /* synthetic */ boolean $emitInitialState;
    final /* synthetic */ String[] $resolvedTableNames;
    final /* synthetic */ int[] $tableIds;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    @J7.c(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1", f = "InvalidationTracker.kt", l = {238}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;
        final /* synthetic */ TriggerBasedInvalidationTracker this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = triggerBasedInvalidationTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
                this.label = 1;
                if (triggerBasedInvalidationTracker.syncTriggers$room_runtime(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements d {
        final /* synthetic */ d $$this$flow;
        final /* synthetic */ Ref$ObjectRef<int[]> $currentVersions;
        final /* synthetic */ boolean $emitInitialState;
        final /* synthetic */ String[] $resolvedTableNames;
        final /* synthetic */ int[] $tableIds;

        public AnonymousClass2(Ref$ObjectRef<int[]> ref$ObjectRef, boolean z10, d dVar, String[] strArr, int[] iArr) {
            this.$currentVersions = ref$ObjectRef;
            this.$emitInitialState = z10;
            this.$$this$flow = dVar;
            this.$resolvedTableNames = strArr;
            this.$tableIds = iArr;
        }

        @Override // p9.d
        public /* bridge */ /* synthetic */ Object emit(Object obj, H7.c cVar) {
            return emit((int[]) obj, (H7.c<? super r>) cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
        
            if (r14.emit(r2, r0) == r1) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
        
            return r1;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(int[] r13, H7.c<? super C7.r> r14) {
            /*
                r12 = this;
                boolean r0 = r14 instanceof androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r14
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2$emit$1
                r0.<init>(r12, r14)
            L18:
                java.lang.Object r14 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L37
                if (r2 == r4) goto L2f
                if (r2 != r3) goto L27
                goto L2f
            L27:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L2f:
                java.lang.Object r13 = r0.L$0
                int[] r13 = (int[]) r13
                kotlin.b.b(r14)
                goto L9d
            L37:
                kotlin.b.b(r14)
                kotlin.jvm.internal.Ref$ObjectRef<int[]> r14 = r12.$currentVersions
                java.lang.Object r2 = r14.f4920a
                if (r2 != 0) goto L57
                boolean r14 = r12.$emitInitialState
                if (r14 == 0) goto L9d
                p9.d r14 = r12.$$this$flow
                java.lang.String[] r2 = r12.$resolvedTableNames
                java.util.Set r2 = D7.q.K0(r2)
                r0.L$0 = r13
                r0.label = r4
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto L9d
                goto L9c
            L57:
                java.lang.String[] r2 = r12.$resolvedTableNames
                int[] r4 = r12.$tableIds
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                int r6 = r2.length
                r7 = 0
                r8 = r7
            L63:
                if (r7 >= r6) goto L86
                r9 = r2[r7]
                int r10 = r8 + 1
                java.lang.Object r11 = r14.f4920a
                if (r11 == 0) goto L7e
                int[] r11 = (int[]) r11
                r8 = r4[r8]
                r11 = r11[r8]
                r8 = r13[r8]
                if (r11 == r8) goto L7a
                r5.add(r9)
            L7a:
                int r7 = r7 + 1
                r8 = r10
                goto L63
            L7e:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "Required value was null."
                r12.<init>(r13)
                throw r12
            L86:
                boolean r14 = r5.isEmpty()
                if (r14 != 0) goto L9d
                p9.d r14 = r12.$$this$flow
                java.util.Set r2 = D7.v.j1(r5)
                r0.L$0 = r13
                r0.label = r3
                java.lang.Object r14 = r14.emit(r2, r0)
                if (r14 != r1) goto L9d
            L9c:
                return r1
            L9d:
                kotlin.jvm.internal.Ref$ObjectRef<int[]> r12 = r12.$currentVersions
                r12.f4920a = r13
                C7.r r12 = C7.r.f317a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2.emit(int[], H7.c):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$createFlow$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, int[] iArr, boolean z10, String[] strArr, H7.c<? super TriggerBasedInvalidationTracker$createFlow$1> cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$tableIds = iArr;
        this.$emitInitialState = z10;
        this.$resolvedTableNames = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        TriggerBasedInvalidationTracker$createFlow$1 triggerBasedInvalidationTracker$createFlow$1 = new TriggerBasedInvalidationTracker$createFlow$1(this.this$0, this.$tableIds, this.$emitInitialState, this.$resolvedTableNames, cVar);
        triggerBasedInvalidationTracker$createFlow$1.L$0 = obj;
        return triggerBasedInvalidationTracker$createFlow$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (m9.AbstractC1683A.w((H7.h) r12, r5, r11) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        if (r12.collect(r4, r11) != r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L31
            if (r1 == r5) goto L29
            if (r1 == r4) goto L21
            if (r1 == r3) goto L18
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L18:
            kotlin.b.b(r12)     // Catch: java.lang.Throwable -> L1d
            goto L93
        L1d:
            r0 = move-exception
            r12 = r0
            goto L99
        L21:
            java.lang.Object r1 = r11.L$0
            p9.d r1 = (p9.d) r1
            kotlin.b.b(r12)
            goto L6f
        L29:
            java.lang.Object r1 = r11.L$0
            p9.d r1 = (p9.d) r1
            kotlin.b.b(r12)
            goto L5b
        L31:
            kotlin.b.b(r12)
            java.lang.Object r12 = r11.L$0
            p9.d r12 = (p9.d) r12
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.ObservedTableStates r1 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r1)
            int[] r6 = r11.$tableIds
            boolean r1 = r1.onObserverAdded$room_runtime(r6)
            if (r1 == 0) goto L71
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.RoomDatabase r1 = androidx.room.TriggerBasedInvalidationTracker.access$getDatabase$p(r1)
            r11.L$0 = r12
            r11.label = r5
            r5 = 0
            java.lang.Object r1 = androidx.room.util.DBUtil.getCoroutineContext(r1, r5, r11)
            if (r1 != r0) goto L58
            goto L92
        L58:
            r10 = r1
            r1 = r12
            r12 = r10
        L5b:
            H7.h r12 = (H7.h) r12
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$1
            androidx.room.TriggerBasedInvalidationTracker r6 = r11.this$0
            r5.<init>(r6, r2)
            r11.L$0 = r1
            r11.label = r4
            java.lang.Object r12 = m9.AbstractC1683A.w(r12, r5, r11)
            if (r12 != r0) goto L6f
            goto L92
        L6f:
            r7 = r1
            goto L72
        L71:
            r7 = r12
        L72:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> L1d
            r5.<init>()     // Catch: java.lang.Throwable -> L1d
            androidx.room.TriggerBasedInvalidationTracker r12 = r11.this$0     // Catch: java.lang.Throwable -> L1d
            androidx.room.ObservedTableVersions r12 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableVersions$p(r12)     // Catch: java.lang.Throwable -> L1d
            androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2 r4 = new androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2     // Catch: java.lang.Throwable -> L1d
            boolean r6 = r11.$emitInitialState     // Catch: java.lang.Throwable -> L1d
            java.lang.String[] r8 = r11.$resolvedTableNames     // Catch: java.lang.Throwable -> L1d
            int[] r9 = r11.$tableIds     // Catch: java.lang.Throwable -> L1d
            r4.<init>(r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L1d
            r11.L$0 = r2     // Catch: java.lang.Throwable -> L1d
            r11.label = r3     // Catch: java.lang.Throwable -> L1d
            java.lang.Object r12 = r12.collect(r4, r11)     // Catch: java.lang.Throwable -> L1d
            if (r12 != r0) goto L93
        L92:
            return r0
        L93:
            kotlin.KotlinNothingValueException r12 = new kotlin.KotlinNothingValueException     // Catch: java.lang.Throwable -> L1d
            r12.<init>()     // Catch: java.lang.Throwable -> L1d
            throw r12     // Catch: java.lang.Throwable -> L1d
        L99:
            androidx.room.TriggerBasedInvalidationTracker r0 = r11.this$0
            androidx.room.ObservedTableStates r0 = androidx.room.TriggerBasedInvalidationTracker.access$getObservedTableStates$p(r0)
            int[] r11 = r11.$tableIds
            r0.onObserverRemoved$room_runtime(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$createFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(d dVar, H7.c<? super r> cVar) {
        return ((TriggerBasedInvalidationTracker$createFlow$1) create(dVar, cVar)).invokeSuspend(r.f317a);
    }
}
