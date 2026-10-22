package D1;

import A1.o;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends G1.c {

    /* renamed from: o, reason: collision with root package name */
    private static final Writer f1058o = new a();

    /* renamed from: p, reason: collision with root package name */
    private static final o f1059p = new o("closed");

    /* renamed from: l, reason: collision with root package name */
    private final List<A1.j> f1060l;

    /* renamed from: m, reason: collision with root package name */
    private String f1061m;

    /* renamed from: n, reason: collision with root package name */
    private A1.j f1062n;

    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i5, int i6) {
            throw new AssertionError();
        }
    }

    public f() {
        super(f1058o);
        this.f1060l = new ArrayList();
        this.f1062n = A1.l.f64a;
    }

    private A1.j j0() {
        return this.f1060l.get(r1.size() - 1);
    }

    private void k0(A1.j jVar) {
        if (this.f1061m != null) {
            if (!jVar.i() || v()) {
                ((A1.m) j0()).o(this.f1061m, jVar);
            }
            this.f1061m = null;
            return;
        }
        if (this.f1060l.isEmpty()) {
            this.f1062n = jVar;
            return;
        }
        A1.j jVarJ0 = j0();
        if (!(jVarJ0 instanceof A1.g)) {
            throw new IllegalStateException();
        }
        ((A1.g) jVarJ0).o(jVar);
    }

    @Override // G1.c
    public G1.c A(String str) {
        if (this.f1060l.isEmpty() || this.f1061m != null) {
            throw new IllegalStateException();
        }
        if (!(j0() instanceof A1.m)) {
            throw new IllegalStateException();
        }
        this.f1061m = str;
        return this;
    }

    @Override // G1.c
    public G1.c D() {
        k0(A1.l.f64a);
        return this;
    }

    @Override // G1.c
    public G1.c V(long j5) {
        k0(new o(Long.valueOf(j5)));
        return this;
    }

    @Override // G1.c
    public G1.c W(Boolean bool) {
        if (bool == null) {
            return D();
        }
        k0(new o(bool));
        return this;
    }

    @Override // G1.c
    public G1.c X(Number number) {
        if (number == null) {
            return D();
        }
        if (!x()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        k0(new o(number));
        return this;
    }

    @Override // G1.c
    public G1.c Y(String str) {
        if (str == null) {
            return D();
        }
        k0(new o(str));
        return this;
    }

    @Override // G1.c
    public G1.c c0(boolean z5) {
        k0(new o(Boolean.valueOf(z5)));
        return this;
    }

    @Override // G1.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f1060l.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f1060l.add(f1059p);
    }

    @Override // G1.c
    public G1.c f() {
        A1.g gVar = new A1.g();
        k0(gVar);
        this.f1060l.add(gVar);
        return this;
    }

    @Override // G1.c, java.io.Flushable
    public void flush() {
    }

    public A1.j h0() {
        if (this.f1060l.isEmpty()) {
            return this.f1062n;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f1060l);
    }

    @Override // G1.c
    public G1.c m() {
        A1.m mVar = new A1.m();
        k0(mVar);
        this.f1060l.add(mVar);
        return this;
    }

    @Override // G1.c
    public G1.c r() {
        if (this.f1060l.isEmpty() || this.f1061m != null) {
            throw new IllegalStateException();
        }
        if (!(j0() instanceof A1.g)) {
            throw new IllegalStateException();
        }
        this.f1060l.remove(r0.size() - 1);
        return this;
    }

    @Override // G1.c
    public G1.c u() {
        if (this.f1060l.isEmpty() || this.f1061m != null) {
            throw new IllegalStateException();
        }
        if (!(j0() instanceof A1.m)) {
            throw new IllegalStateException();
        }
        this.f1060l.remove(r0.size() - 1);
        return this;
    }
}
