package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class f0<T, B> {
    public abstract void a(B b10, int i10, int i11);

    public abstract void b(B b10, int i10, long j10);

    public abstract void c(B b10, int i10, T t10);

    public abstract void d(B b10, int i10, ByteString byteString);

    public abstract void e(B b10, int i10, long j10);

    public abstract B f(Object obj);

    public abstract T g(Object obj);

    public abstract int h(T t10);

    public abstract int i(T t10);

    public abstract void j(Object obj);

    public abstract T k(T t10, T t11);

    public final void l(B b10, Y y10) throws IOException {
        while (y10.getFieldNumber() != Integer.MAX_VALUE && m(b10, y10)) {
        }
    }

    public final boolean m(B b10, Y y10) throws IOException {
        int tag = y10.getTag();
        int iA = WireFormat.a(tag);
        int iB = WireFormat.b(tag);
        if (iB == 0) {
            e(b10, iA, y10.readInt64());
            return true;
        }
        if (iB == 1) {
            b(b10, iA, y10.readFixed64());
            return true;
        }
        if (iB == 2) {
            d(b10, iA, y10.readBytes());
            return true;
        }
        if (iB != 3) {
            if (iB == 4) {
                return false;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            a(b10, iA, y10.readFixed32());
            return true;
        }
        B bN = n();
        int iC = WireFormat.c(iA, 4);
        l(bN, y10);
        if (iC != y10.getTag()) {
            throw InvalidProtocolBufferException.a();
        }
        c(b10, iA, r(bN));
        return true;
    }

    public abstract B n();

    public abstract void o(Object obj, B b10);

    public abstract void p(Object obj, T t10);

    public abstract boolean q(Y y10);

    public abstract T r(B b10);

    public abstract void s(T t10, Writer writer) throws IOException;

    public abstract void t(T t10, Writer writer) throws IOException;
}
