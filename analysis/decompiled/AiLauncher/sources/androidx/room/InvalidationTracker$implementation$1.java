package androidx.room;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5074l;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class InvalidationTracker$implementation$1 extends FunctionReferenceImpl implements InterfaceC5074l<Set<? extends Integer>, Y8.t> {
    public InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Y8.t invoke(Set<? extends Integer> set) {
        l(set);
        return Y8.t.f7040a;
    }

    public final void l(Set<Integer> p02) {
        kotlin.jvm.internal.p.i(p02, "p0");
        ((InvalidationTracker) this.receiver).p(p02);
    }
}
