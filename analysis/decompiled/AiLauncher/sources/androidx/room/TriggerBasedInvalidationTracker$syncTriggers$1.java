package androidx.room;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {306}, m = "syncTriggers$room_runtime")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$syncTriggers$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14606a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14607b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14608c;

    /* renamed from: d, reason: collision with root package name */
    public int f14609d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$syncTriggers$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super TriggerBasedInvalidationTracker$syncTriggers$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14608c = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14607b = obj;
        this.f14609d |= Integer.MIN_VALUE;
        return this.f14608c.x(this);
    }
}
