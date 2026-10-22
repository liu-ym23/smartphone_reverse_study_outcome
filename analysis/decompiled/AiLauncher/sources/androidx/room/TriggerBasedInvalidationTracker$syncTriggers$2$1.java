package androidx.room;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/room/Transactor;", "connection", "LY8/t;", "<anonymous>", "(Landroidx/room/Transactor;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1", f = "InvalidationTracker.kt", l = {307, 314}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$2$1 extends SuspendLambda implements p9.p<Transactor, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f14610a;

    /* renamed from: b, reason: collision with root package name */
    public int f14611b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14612c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14613d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$2$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super TriggerBasedInvalidationTracker$syncTriggers$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14613d = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        TriggerBasedInvalidationTracker$syncTriggers$2$1 triggerBasedInvalidationTracker$syncTriggers$2$1 = new TriggerBasedInvalidationTracker$syncTriggers$2$1(this.f14613d, interfaceC4014c);
        triggerBasedInvalidationTracker$syncTriggers$2$1.f14612c = obj;
        return triggerBasedInvalidationTracker$syncTriggers$2$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Transactor transactor, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TriggerBasedInvalidationTracker$syncTriggers$2$1) create(transactor, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
