package androidx.room;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {347}, m = "stopTrackingTable")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$stopTrackingTable$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14598a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14599b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14600c;

    /* renamed from: d, reason: collision with root package name */
    public int f14601d;

    /* renamed from: e, reason: collision with root package name */
    public int f14602e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f14603f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker f14604g;

    /* renamed from: h, reason: collision with root package name */
    public int f14605h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$stopTrackingTable$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, InterfaceC4014c<? super TriggerBasedInvalidationTracker$stopTrackingTable$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14604g = triggerBasedInvalidationTracker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14603f = obj;
        this.f14605h |= Integer.MIN_VALUE;
        return this.f14604g.w(null, 0, this);
    }
}
