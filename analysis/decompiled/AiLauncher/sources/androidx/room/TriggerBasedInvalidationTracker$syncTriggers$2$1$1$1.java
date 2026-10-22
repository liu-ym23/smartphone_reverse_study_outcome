package androidx.room;

import androidx.room.ObservedTableStates;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/room/B;", "LY8/t;", "<anonymous>", "(Landroidx/room/B;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1", f = "InvalidationTracker.kt", l = {318, 319}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1 extends SuspendLambda implements p9.p<B<Y8.t>, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f14614a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14615b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14616c;

    /* renamed from: d, reason: collision with root package name */
    public int f14617d;

    /* renamed from: e, reason: collision with root package name */
    public int f14618e;

    /* renamed from: f, reason: collision with root package name */
    public int f14619f;

    /* renamed from: g, reason: collision with root package name */
    public int f14620g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ ObservedTableStates.ObserveOp[] f14621h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14622i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Transactor f14623j;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14624a;

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
            f14624a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(ObservedTableStates.ObserveOp[] observeOpArr, TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, Transactor transactor, InterfaceC4014c<? super TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14621h = observeOpArr;
        this.f14622i = triggerBasedInvalidationTracker;
        this.f14623j = transactor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1(this.f14621h, this.f14622i, this.f14623j, interfaceC4014c);
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(B<Y8.t> b10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1) create(b10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0083, code lost:
    
        if (r7.v(r12, r6, r11) == r0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
    
        r6 = r12;
        r5 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0086 -> B:27:0x0087). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.f14620g
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 == r3) goto Le
            if (r1 != r2) goto L24
        Le:
            int r1 = r11.f14619f
            int r4 = r11.f14618e
            int r5 = r11.f14617d
            java.lang.Object r6 = r11.f14616c
            androidx.room.Transactor r6 = (androidx.room.Transactor) r6
            java.lang.Object r7 = r11.f14615b
            androidx.room.TriggerBasedInvalidationTracker r7 = (androidx.room.TriggerBasedInvalidationTracker) r7
            java.lang.Object r8 = r11.f14614a
            androidx.room.ObservedTableStates$ObserveOp[] r8 = (androidx.room.ObservedTableStates.ObserveOp[]) r8
            kotlin.C4849c.b(r12)
            goto L68
        L24:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L2c:
            kotlin.C4849c.b(r12)
            androidx.room.ObservedTableStates$ObserveOp[] r12 = r11.f14621h
            androidx.room.TriggerBasedInvalidationTracker r1 = r11.f14622i
            androidx.room.Transactor r4 = r11.f14623j
            int r5 = r12.length
            r6 = 0
            r8 = r12
            r7 = r1
            r12 = r4
            r1 = r5
            r4 = r6
        L3c:
            if (r4 >= r1) goto L89
            r5 = r8[r4]
            int r9 = r6 + 1
            int[] r10 = androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.a.f14624a
            int r5 = r5.ordinal()
            r5 = r10[r5]
            if (r5 == r3) goto L86
            if (r5 == r2) goto L71
            r10 = 3
            if (r5 != r10) goto L6b
            r11.f14614a = r8
            r11.f14615b = r7
            r11.f14616c = r12
            r11.f14617d = r9
            r11.f14618e = r4
            r11.f14619f = r1
            r11.f14620g = r2
            java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.i(r7, r12, r6, r11)
            if (r5 != r0) goto L66
            goto L85
        L66:
            r6 = r12
            r5 = r9
        L68:
            r12 = r6
            r6 = r5
            goto L87
        L6b:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L71:
            r11.f14614a = r8
            r11.f14615b = r7
            r11.f14616c = r12
            r11.f14617d = r9
            r11.f14618e = r4
            r11.f14619f = r1
            r11.f14620g = r3
            java.lang.Object r5 = androidx.room.TriggerBasedInvalidationTracker.h(r7, r12, r6, r11)
            if (r5 != r0) goto L66
        L85:
            return r0
        L86:
            r6 = r9
        L87:
            int r4 = r4 + r3
            goto L3c
        L89:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
