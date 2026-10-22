package androidx.room;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {328, 333}, m = "startTrackingTable")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$startTrackingTable$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14589a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14590b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14591c;

    /* renamed from: d, reason: collision with root package name */
    public int f14592d;

    /* renamed from: e, reason: collision with root package name */
    public int f14593e;

    /* renamed from: f, reason: collision with root package name */
    public int f14594f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f14595g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14596h;

    /* renamed from: i, reason: collision with root package name */
    public int f14597i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$startTrackingTable$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super TriggerBasedInvalidationTracker$startTrackingTable$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14596h = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14595g = obj;
        this.f14597i |= Integer.MIN_VALUE;
        return this.f14596h.v(null, 0, this);
    }
}
