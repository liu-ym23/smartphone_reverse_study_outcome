package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e1 extends c1<d1, d1> {
    @Override // androidx.datastore.preferences.protobuf.c1
    public final void a(int i10, int i11, Object obj) {
        ((d1) obj).b((i10 << 3) | 5, Integer.valueOf(i11));
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void b(long j10, int i10, Object obj) {
        ((d1) obj).b((i10 << 3) | 1, Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void c(int i10, Object obj, Object obj2) {
        ((d1) obj).b((i10 << 3) | 3, (d1) obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void d(d1 d1Var, int i10, ByteString byteString) {
        d1Var.b((i10 << 3) | 2, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void e(long j10, int i10, Object obj) {
        ((d1) obj).b(i10 << 3, Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final d1 f(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        d1 d1Var = generatedMessageLite.unknownFields;
        if (d1Var != d1.f1800f) {
            return d1Var;
        }
        d1 d1Var2 = new d1();
        generatedMessageLite.unknownFields = d1Var2;
        return d1Var2;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final d1 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final int h(d1 d1Var) {
        return d1Var.a();
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final int i(d1 d1Var) {
        d1 d1Var2 = d1Var;
        int i10 = d1Var2.f1804d;
        if (i10 != -1) {
            return i10;
        }
        int iK = 0;
        for (int i11 = 0; i11 < d1Var2.f1801a; i11++) {
            int i12 = d1Var2.f1802b[i11] >>> 3;
            iK += CodedOutputStream.k(3, (ByteString) d1Var2.f1803c[i11]) + CodedOutputStream.t(2, i12) + (CodedOutputStream.s(1) * 2);
        }
        d1Var2.f1804d = iK;
        return iK;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void j(Object obj) {
        ((GeneratedMessageLite) obj).unknownFields.f1805e = false;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final d1 k(Object obj, Object obj2) {
        d1 d1Var = (d1) obj;
        d1 d1Var2 = (d1) obj2;
        if (d1Var2.equals(d1.f1800f)) {
            return d1Var;
        }
        int i10 = d1Var.f1801a + d1Var2.f1801a;
        int[] iArrCopyOf = Arrays.copyOf(d1Var.f1802b, i10);
        System.arraycopy(d1Var2.f1802b, 0, iArrCopyOf, d1Var.f1801a, d1Var2.f1801a);
        Object[] objArrCopyOf = Arrays.copyOf(d1Var.f1803c, i10);
        System.arraycopy(d1Var2.f1803c, 0, objArrCopyOf, d1Var.f1801a, d1Var2.f1801a);
        return new d1(i10, iArrCopyOf, objArrCopyOf, true);
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final d1 m() {
        return new d1();
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void n(Object obj, d1 d1Var) {
        ((GeneratedMessageLite) obj).unknownFields = d1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void o(Object obj, d1 d1Var) {
        ((GeneratedMessageLite) obj).unknownFields = d1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final d1 p(Object obj) {
        d1 d1Var = (d1) obj;
        d1Var.f1805e = false;
        return d1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void q(d1 d1Var, h1 h1Var) {
        d1 d1Var2 = d1Var;
        d1Var2.getClass();
        h1Var.getClass();
        for (int i10 = 0; i10 < d1Var2.f1801a; i10++) {
            int i11 = d1Var2.f1802b[i10] >>> 3;
            Object obj = d1Var2.f1803c[i10];
            CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
            if (obj instanceof ByteString) {
                codedOutputStream.L(i11, (ByteString) obj);
            } else {
                codedOutputStream.K(i11, (i0) obj);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.c1
    public final void r(d1 d1Var, h1 h1Var) {
        d1Var.c(h1Var);
    }
}
