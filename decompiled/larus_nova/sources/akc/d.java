package akc;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: loaded from: classes40.dex */
public final class d<E> extends a<E> implements Set<E>, KMutableSet {
    public d(Set<E> r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        super(r100, r101);
    }
}
