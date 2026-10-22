package androidx.room;

import C7.r;
import S7.k;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class InvalidationTracker$implementation$1 extends FunctionReferenceImpl implements k {
    public InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    @Override // S7.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Set<Integer>) obj);
        return r.f317a;
    }

    public final void invoke(Set<Integer> p02) {
        kotlin.jvm.internal.k.f(p02, "p0");
        ((InvalidationTracker) this.receiver).notifyInvalidatedObservers(p02);
    }
}
