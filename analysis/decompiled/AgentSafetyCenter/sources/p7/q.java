package p7;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends u7.c {

    /* renamed from: v, reason: collision with root package name */
    public static final p f9887v = new p();

    /* renamed from: w, reason: collision with root package name */
    public static final m7.l f9888w;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f9889s;

    /* renamed from: t, reason: collision with root package name */
    public String f9890t;

    /* renamed from: u, reason: collision with root package name */
    public m7.g f9891u;

    static {
        m7.l lVar = new m7.l();
        lVar.f8267c = "closed";
        VarHandle.storeStoreFence();
        f9888w = lVar;
    }

    @Override // u7.c
    public final u7.c C() {
        W(m7.i.f8265c);
        return this;
    }

    @Override // u7.c
    public final void O(double d7) {
        if (this.f14181l != 1 && (Double.isNaN(d7) || Double.isInfinite(d7))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d7);
        }
        Double dValueOf = Double.valueOf(d7);
        m7.l lVar = new m7.l();
        lVar.f8267c = dValueOf;
        W(lVar);
    }

    @Override // u7.c
    public final void P(long j10) {
        Long lValueOf = Long.valueOf(j10);
        m7.l lVar = new m7.l();
        lVar.f8267c = lValueOf;
        W(lVar);
    }

    @Override // u7.c
    public final void Q(Boolean bool) {
        if (bool == null) {
            W(m7.i.f8265c);
            return;
        }
        m7.l lVar = new m7.l();
        lVar.f8267c = bool;
        W(lVar);
    }

    @Override // u7.c
    public final void R(Number number) {
        if (number == null) {
            W(m7.i.f8265c);
            return;
        }
        if (this.f14181l != 1) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                g5.f.p(number, "JSON forbids NaN and infinities: ");
                return;
            }
        }
        m7.l lVar = new m7.l();
        lVar.f8267c = number;
        W(lVar);
    }

    @Override // u7.c
    public final void S(String str) {
        if (str == null) {
            W(m7.i.f8265c);
            return;
        }
        m7.l lVar = new m7.l();
        lVar.f8267c = str;
        W(lVar);
    }

    @Override // u7.c
    public final void T(boolean z10) {
        Boolean boolValueOf = Boolean.valueOf(z10);
        m7.l lVar = new m7.l();
        lVar.f8267c = boolValueOf;
        W(lVar);
    }

    public final m7.g V() {
        return (m7.g) this.f9889s.get(r1.size() - 1);
    }

    public final void W(m7.g gVar) {
        if (this.f9890t != null) {
            if (!(gVar instanceof m7.i) || this.f14184o) {
                ((m7.j) V()).j(this.f9890t, gVar);
            }
            this.f9890t = null;
            return;
        }
        if (this.f9889s.isEmpty()) {
            this.f9891u = gVar;
            return;
        }
        m7.g gVarV = V();
        if (!(gVarV instanceof m7.f)) {
            throw new IllegalStateException();
        }
        ((m7.f) gVarV).k(gVar);
    }

    @Override // u7.c, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        ArrayList arrayList = this.f9889s;
        if (arrayList.isEmpty()) {
            arrayList.add(f9888w);
        } else {
            od.f.l("Incomplete document");
        }
    }

    @Override // u7.c
    public final void e() {
        m7.f fVar = new m7.f();
        W(fVar);
        this.f9889s.add(fVar);
    }

    @Override // u7.c
    public final void g() {
        m7.j jVar = new m7.j();
        W(jVar);
        this.f9889s.add(jVar);
    }

    @Override // u7.c
    public final void n() {
        ArrayList arrayList = this.f9889s;
        if (arrayList.isEmpty() || this.f9890t != null) {
            throw new IllegalStateException();
        }
        if (!(V() instanceof m7.f)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // u7.c
    public final void o() {
        ArrayList arrayList = this.f9889s;
        if (arrayList.isEmpty() || this.f9890t != null) {
            throw new IllegalStateException();
        }
        if (!(V() instanceof m7.j)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
    }

    @Override // u7.c
    public final void r(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f9889s.isEmpty() || this.f9890t != null) {
            od.f.e("Did not expect a name");
        } else if (V() instanceof m7.j) {
            this.f9890t = str;
        } else {
            od.f.e("Please begin an object before writing a name.");
        }
    }

    @Override // u7.c, java.io.Flushable
    public final void flush() {
    }
}
