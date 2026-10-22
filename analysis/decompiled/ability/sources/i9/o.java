package i9;

import java.util.Iterator;

/* loaded from: classes4.dex */
public final class o implements i {

    /* renamed from: a, reason: collision with root package name */
    public final i f4627a;
    public final S7.k b;

    public o(i iVar, S7.k transformer) {
        kotlin.jvm.internal.k.f(transformer, "transformer");
        this.f4627a = iVar;
        this.b = transformer;
    }

    @Override // i9.i
    public final Iterator iterator() {
        return new n(this);
    }
}
