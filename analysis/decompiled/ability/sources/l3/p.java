package l3;

/* loaded from: classes3.dex */
public class p extends h {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5279a;
    public final int b;
    public final y c;
    public volatile r d = com.google.common.cache.e.f2738v;

    public p(Object obj, int i, y yVar) {
        this.f5279a = obj;
        this.b = i;
        this.c = yVar;
    }

    @Override // l3.h, l3.y
    public final r d() {
        return this.d;
    }

    @Override // l3.h, l3.y
    public final int g() {
        return this.b;
    }

    @Override // l3.h, l3.y
    public final Object getKey() {
        return this.f5279a;
    }

    @Override // l3.h, l3.y
    public final y getNext() {
        return this.c;
    }

    @Override // l3.h, l3.y
    public final void k(r rVar) {
        this.d = rVar;
    }
}
