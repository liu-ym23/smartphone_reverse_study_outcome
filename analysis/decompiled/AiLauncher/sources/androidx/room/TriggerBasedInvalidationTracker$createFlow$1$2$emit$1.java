package androidx.room;

import androidx.room.TriggerBasedInvalidationTracker$createFlow$1;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.TriggerBasedInvalidationTracker$createFlow$1$2", f = "InvalidationTracker.kt", l = {247, 256}, m = "emit")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TriggerBasedInvalidationTracker$createFlow$1$2$emit$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14572a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14573b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2<T> f14574c;

    /* renamed from: d, reason: collision with root package name */
    public int f14575d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TriggerBasedInvalidationTracker$createFlow$1$2$emit$1(TriggerBasedInvalidationTracker$createFlow$1.AnonymousClass2<? super T> anonymousClass2, InterfaceC4014c<? super TriggerBasedInvalidationTracker$createFlow$1$2$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14574c = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14573b = obj;
        this.f14575d |= Integer.MIN_VALUE;
        return this.f14574c.emit(null, this);
    }
}
