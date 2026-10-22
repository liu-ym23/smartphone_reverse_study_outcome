package androidx.room;

import C7.r;
import S7.n;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ObservedTableStates;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@J7.c(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1", f = "InvalidationTracker.kt", l = {TypedValues.AttributesType.TYPE_EASING, TypedValues.AttributesType.TYPE_PIVOT_TARGET}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/room/TransactionScope;", "LC7/r;", "<anonymous>", "(Landroidx/room/TransactionScope;)V"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes2.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1 extends SuspendLambda implements n {
    final /* synthetic */ Transactor $connection;
    final /* synthetic */ ObservedTableStates.ObserveOp[] $tablesToSync;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ObservedTableStates.ObserveOp.values().length];
            try {
                iArr[ObservedTableStates.ObserveOp.NO_OP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ObservedTableStates.ObserveOp.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ObservedTableStates.ObserveOp.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, H7.c<? super TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1> cVar) {
        super(2, cVar);
        this.$tablesToSync = observeOpArr;
        this.this$0 = triggerBasedInvalidationTracker;
        this.$connection = transactor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(this.$tablesToSync, this.this$0, this.$connection, cVar);
    }

    @Override // S7.n
    public final Object invoke(TransactionScope<r> transactionScope, H7.c<? super r> cVar) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1) create(transactionScope, cVar)).invokeSuspend(r.f317a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
    
        if (r7.startTrackingTable(r12, r6, r11) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        r6 = r12;
        r5 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0084 -> B:27:0x0085). Please report as a decompilation issue!!! */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2a
            if (r1 == r3) goto Lc
            if (r1 != r2) goto L22
        Lc:
            int r1 = r11.I$2
            int r4 = r11.I$1
            int r5 = r11.I$0
            java.lang.Object r6 = r11.L$2
            androidx.room.Transactor r6 = (androidx.room.Transactor) r6
            java.lang.Object r7 = r11.L$1
            androidx.room.TriggerBasedInvalidationTracker r7 = (androidx.room.TriggerBasedInvalidationTracker) r7
            java.lang.Object r8 = r11.L$0
            androidx.room.ObservedTableStates$ObserveOp[] r8 = (androidx.room.ObservedTableStates.ObserveOp[]) r8
            kotlin.b.b(r12)
            goto L66
        L22:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L2a:
            kotlin.b.b(r12)
            androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.$tablesToSync
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.this$0
            androidx.room.Transactor r4 = r11.$connection
            int r5 = r12.length
            r6 = 0
            r8 = r12
            r7 = r1
            r12 = r4
            r1 = r5
            r4 = r6
        L3a:
            if (r4 >= r1) goto L87
            r5 = r8[r4]
            int r9 = r6 + 1
            int[] r10 = androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r10[r5]
            if (r5 == r3) goto L84
            if (r5 == r2) goto L6f
            r10 = 3
            if (r5 != r10) goto L69
            r11.L$0 = r8
            r11.L$1 = r7
            r11.L$2 = r12
            r11.I$0 = r9
            r11.I$1 = r4
            r11.I$2 = r1
            r11.label = r2
            java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.access$stopTrackingTable(r7, r12, r6, r11)
            if (r5 != r0) goto L64
            goto L83
        L64:
            r6 = r12
            r5 = r9
        L66:
            r12 = r6
            r6 = r5
            goto L85
        L69:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L6f:
            r11.L$0 = r8
            r11.L$1 = r7
            r11.L$2 = r12
            r11.I$0 = r9
            r11.I$1 = r4
            r11.I$2 = r1
            r11.label = r3
            java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.access$startTrackingTable(r7, r12, r6, r11)
            if (r5 != r0) goto L64
        L83:
            return r0
        L84:
            r6 = r9
        L85:
            int r4 = r4 + r3
            goto L3a
        L87:
            C7.r r11 = C7.r.f317a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
