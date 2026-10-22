package androidx.datastore.preferences.protobuf;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c1<T, B> {
    public abstract void a(int i10, int i11, Object obj);

    public abstract void b(long j10, int i10, Object obj);

    public abstract void c(int i10, Object obj, Object obj2);

    public abstract void d(B b10, int i10, ByteString byteString);

    public abstract void e(long j10, int i10, Object obj);

    public abstract d1 f(Object obj);

    public abstract d1 g(Object obj);

    public abstract int h(T t8);

    public abstract int i(T t8);

    public abstract void j(Object obj);

    public abstract d1 k(Object obj, Object obj2);

    public final boolean l(B b10, v0 v0Var) throws InvalidProtocolBufferException {
        int tag = v0Var.getTag();
        int i10 = tag >>> 3;
        int i11 = tag & 7;
        if (i11 == 0) {
            e(v0Var.L(), i10, b10);
            return true;
        }
        if (i11 == 1) {
            b(v0Var.b(), i10, b10);
            return true;
        }
        if (i11 == 2) {
            d(b10, i10, v0Var.o());
            return true;
        }
        if (i11 != 3) {
            if (i11 == 4) {
                return false;
            }
            if (i11 != 5) {
                throw InvalidProtocolBufferException.b();
            }
            a(i10, v0Var.w(), b10);
            return true;
        }
        d1 d1VarM = m();
        int i12 = 4 | (i10 << 3);
        while (v0Var.D() != Integer.MAX_VALUE && l(d1VarM, v0Var)) {
        }
        if (i12 != v0Var.getTag()) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        c(i10, b10, p(d1VarM));
        return true;
    }

    public abstract d1 m();

    public abstract void n(Object obj, B b10);

    public abstract void o(Object obj, T t8);

    public abstract d1 p(Object obj);

    public abstract void q(T t8, h1 h1Var);

    public abstract void r(T t8, h1 h1Var);
}
