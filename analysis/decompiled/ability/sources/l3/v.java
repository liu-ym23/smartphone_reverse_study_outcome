package l3;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class v extends WeakReference implements y {

    /* renamed from: a, reason: collision with root package name */
    public final int f5282a;
    public final y b;
    public volatile r c;

    public v(ReferenceQueue referenceQueue, Object obj, int i, y yVar) {
        super(obj, referenceQueue);
        this.c = com.google.common.cache.e.f2738v;
        this.f5282a = i;
        this.b = yVar;
    }

    public void a(y yVar) {
        throw new UnsupportedOperationException();
    }

    public y b() {
        throw new UnsupportedOperationException();
    }

    public y c() {
        throw new UnsupportedOperationException();
    }

    @Override // l3.y
    public final r d() {
        return this.c;
    }

    public y e() {
        throw new UnsupportedOperationException();
    }

    public y f() {
        throw new UnsupportedOperationException();
    }

    @Override // l3.y
    public final int g() {
        return this.f5282a;
    }

    @Override // l3.y
    public final Object getKey() {
        return get();
    }

    @Override // l3.y
    public final y getNext() {
        return this.b;
    }

    public long h() {
        throw new UnsupportedOperationException();
    }

    public void i(y yVar) {
        throw new UnsupportedOperationException();
    }

    public void j(long j5) {
        throw new UnsupportedOperationException();
    }

    @Override // l3.y
    public final void k(r rVar) {
        this.c = rVar;
    }

    public long l() {
        throw new UnsupportedOperationException();
    }

    public void m(long j5) {
        throw new UnsupportedOperationException();
    }

    public void n(y yVar) {
        throw new UnsupportedOperationException();
    }

    public void o(y yVar) {
        throw new UnsupportedOperationException();
    }
}
