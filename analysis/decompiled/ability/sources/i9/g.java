package i9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final i f4621a;
    public final S7.k b;
    public final S7.k c;

    public g(i iVar, S7.k transformer, S7.k iterator) {
        kotlin.jvm.internal.k.f(transformer, "transformer");
        kotlin.jvm.internal.k.f(iterator, "iterator");
        this.f4621a = iVar;
        this.b = transformer;
        this.c = iterator;
    }

    @Override // i9.i
    public final Iterator iterator() {
        return new C1570e(this);
    }
}
