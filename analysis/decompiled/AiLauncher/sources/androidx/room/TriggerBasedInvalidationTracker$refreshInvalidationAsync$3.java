package androidx.room;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$refreshInvalidationAsync$3", f = "InvalidationTracker.kt", l = {394}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$refreshInvalidationAsync$3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14586a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14587b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5063a<Y8.t> f14588c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC4014c<? super TriggerBasedInvalidationTracker$refreshInvalidationAsync$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14587b = triggerBasedInvalidationTracker;
        this.f14588c = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this.f14587b, this.f14588c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((TriggerBasedInvalidationTracker$refreshInvalidationAsync$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14586a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.f14587b;
                this.f14586a = 1;
                obj = triggerBasedInvalidationTracker.n(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            this.f14588c.invoke();
            return Y8.t.f7040a;
        } catch (Throwable th) {
            this.f14588c.invoke();
            throw th;
        }
    }
}
