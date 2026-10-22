package sc;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import kotlinx.serialization.SerializationException;
import tc.t0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a implements d, b {
    @Override // sc.d
    public abstract byte A();

    @Override // sc.b
    public final byte B(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return A();
    }

    public final void C() {
        throw new SerializationException(i.a(getClass()) + " can't retrieve untyped values");
    }

    public void a(rc.e descriptor) {
        g.f(descriptor, "descriptor");
    }

    @Override // sc.d
    public b b(rc.e descriptor) {
        g.f(descriptor, "descriptor");
        return this;
    }

    public <T> T c(rc.e descriptor, int i10, pc.a deserializer, T t8) {
        g.f(descriptor, "descriptor");
        g.f(deserializer, "deserializer");
        return (T) z(deserializer);
    }

    @Override // sc.b
    public final float d(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return m();
    }

    @Override // sc.b
    public final char e(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return p();
    }

    @Override // sc.d
    public abstract int h();

    @Override // sc.b
    public final boolean i(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return o();
    }

    @Override // sc.d
    public abstract long j();

    @Override // sc.b
    public final d k(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return u(descriptor.h(i10));
    }

    @Override // sc.d
    public abstract short l();

    @Override // sc.d
    public float m() {
        C();
        throw null;
    }

    @Override // sc.d
    public double n() {
        C();
        throw null;
    }

    @Override // sc.d
    public boolean o() {
        C();
        throw null;
    }

    @Override // sc.d
    public char p() {
        C();
        throw null;
    }

    @Override // sc.b
    public final String q(rc.e descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return v();
    }

    @Override // sc.b
    public final Object r(rc.e descriptor, int i10, pc.a aVar, Object obj) {
        g.f(descriptor, "descriptor");
        if (aVar.d().b() || x()) {
            return z(aVar);
        }
        return null;
    }

    @Override // sc.b
    public final short s(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return l();
    }

    @Override // sc.b
    public final int t(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return h();
    }

    @Override // sc.d
    public d u(rc.e descriptor) {
        g.f(descriptor, "descriptor");
        return this;
    }

    @Override // sc.d
    public String v() {
        C();
        throw null;
    }

    @Override // sc.b
    public final long w(rc.e descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return j();
    }

    @Override // sc.d
    public boolean x() {
        return true;
    }

    @Override // sc.b
    public final double y(t0 descriptor, int i10) {
        g.f(descriptor, "descriptor");
        return n();
    }

    @Override // sc.d
    public <T> T z(pc.a deserializer) {
        g.f(deserializer, "deserializer");
        return (T) deserializer.b(this);
    }
}
