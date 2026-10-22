package androidx.room;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {417}, m = "notifyInvalidation")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$notifyInvalidation$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14576a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14577b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14578c;

    /* renamed from: d, reason: collision with root package name */
    public int f14579d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$notifyInvalidation$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super TriggerBasedInvalidationTracker$notifyInvalidation$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14578c = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14577b = obj;
        this.f14579d |= Integer.MIN_VALUE;
        return this.f14578c.n(this);
    }
}
