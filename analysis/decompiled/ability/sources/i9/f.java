package i9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    public final i f4620a;
    public final boolean b;
    public final S7.k c;

    public f(i sequence, boolean z10, S7.k predicate) {
        kotlin.jvm.internal.k.f(sequence, "sequence");
        kotlin.jvm.internal.k.f(predicate, "predicate");
        this.f4620a = sequence;
        this.b = z10;
        this.c = predicate;
    }

    @Override // i9.i
    public final Iterator iterator() {
        return new C1570e(this);
    }
}
