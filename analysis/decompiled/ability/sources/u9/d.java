package u9;

import m9.AbstractC1729v;
import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public final class d extends g {
    public static final d b;

    static {
        int i = j.c;
        int i6 = j.d;
        long j5 = j.e;
        String str = j.f6747a;
        d dVar = new d();
        dVar.f6745a = new b(j5, str, i, i6);
        b = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // m9.AbstractC1729v
    public final AbstractC1729v limitedParallelism(int i, String str) {
        AbstractC1921a.a(i);
        return i >= j.c ? str != null ? new s9.l(this, str) : this : super.limitedParallelism(i, str);
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return "Dispatchers.Default";
    }
}
