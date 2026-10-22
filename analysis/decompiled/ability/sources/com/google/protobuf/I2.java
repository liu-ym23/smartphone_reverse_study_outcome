package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class I2 implements W1 {

    /* renamed from: a, reason: collision with root package name */
    public TreeMap f2841a;

    @Override // com.google.protobuf.W1
    /* renamed from: buildPartial */
    public final X1 m() {
        return k();
    }

    public final Object clone() {
        I2 i2G = M2.g();
        for (Map.Entry entry : this.f2841a.entrySet()) {
            i2G.f2841a.put((Integer) entry.getKey(), ((J2) entry.getValue()).clone());
        }
        return i2G;
    }

    @Override // com.google.protobuf.W1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final M2 k() {
        TreeMap treeMap = this.f2841a;
        if (treeMap.isEmpty()) {
            return M2.b;
        }
        TreeMap treeMap2 = new TreeMap();
        for (Map.Entry entry : treeMap.entrySet()) {
            treeMap2.put((Integer) entry.getKey(), ((J2) entry.getValue()).a());
        }
        return new M2(treeMap2);
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return true;
    }

    public final J2 j(int i) {
        TreeMap treeMap = this.f2841a;
        if (i == 0) {
            return null;
        }
        J2 j22 = (J2) treeMap.get(Integer.valueOf(i));
        if (j22 != null) {
            return j22;
        }
        int i6 = K2.f;
        J2 j23 = new J2();
        treeMap.put(Integer.valueOf(i), j23);
        return j23;
    }

    public final void k(int i, K2 k22) {
        TreeMap treeMap = this.f2841a;
        if (i <= 0) {
            throw new IllegalArgumentException(i + " is not a valid field number.");
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            j(i).c(k22);
            return;
        }
        if (i <= 0) {
            throw new IllegalArgumentException(i + " is not a valid field number.");
        }
        Integer numValueOf = Integer.valueOf(i);
        int i6 = K2.f;
        J2 j22 = new J2();
        j22.c(k22);
        treeMap.put(numValueOf, j22);
    }

    public final boolean m(int i, AbstractC0972o abstractC0972o) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int i6 = i >>> 3;
        int i10 = i & 7;
        if (i10 == 0) {
            J2 j2J = j(i6);
            long jT = abstractC0972o.t();
            K2 k22 = j2J.f2845a;
            if (k22.f2849a == null) {
                k22.f2849a = new ArrayList();
            }
            j2J.f2845a.f2849a.add(Long.valueOf(jT));
            return true;
        }
        if (i10 == 1) {
            J2 j2J2 = j(i6);
            long jP = abstractC0972o.p();
            K2 k23 = j2J2.f2845a;
            if (k23.c == null) {
                k23.c = new ArrayList();
            }
            j2J2.f2845a.c.add(Long.valueOf(jP));
            return true;
        }
        if (i10 == 2) {
            J2 j2J3 = j(i6);
            ByteString byteStringL = abstractC0972o.l();
            K2 k24 = j2J3.f2845a;
            if (k24.d == null) {
                k24.d = new ArrayList();
            }
            j2J3.f2845a.d.add(byteStringL);
            return true;
        }
        if (i10 == 3) {
            I2 i2G = M2.g();
            abstractC0972o.r(i6, i2G, O0.h);
            J2 j2J4 = j(i6);
            M2 m2K = i2G.k();
            K2 k25 = j2J4.f2845a;
            if (k25.e == null) {
                k25.e = new ArrayList();
            }
            j2J4.f2845a.e.add(m2K);
            return true;
        }
        if (i10 == 4) {
            return false;
        }
        if (i10 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        J2 j2J5 = j(i6);
        int iO = abstractC0972o.o();
        K2 k26 = j2J5.f2845a;
        if (k26.b == null) {
            k26.b = new ArrayList();
        }
        j2J5.f2845a.b.add(Integer.valueOf(iO));
        return true;
    }

    @Override // com.google.protobuf.W1
    public final W1 mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
        try {
            C0960l c0960lH = AbstractC0972o.h(bArr, 0, bArr.length, false);
            n(c0960lH);
            c0960lH.a(0);
            return this;
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e6);
        }
    }

    public final void n(AbstractC0972o abstractC0972o) {
        int iD;
        do {
            iD = abstractC0972o.D();
            if (iD == 0) {
                return;
            }
        } while (m(iD, abstractC0972o));
    }

    public final void o(M2 m2) {
        if (m2 != M2.b) {
            for (Map.Entry entry : m2.f2854a.entrySet()) {
                k(((Integer) entry.getKey()).intValue(), (K2) entry.getValue());
            }
        }
    }

    public final void p(int i, int i6) {
        if (i <= 0) {
            throw new IllegalArgumentException(i + " is not a valid field number.");
        }
        J2 j2J = j(i);
        long j5 = i6;
        K2 k22 = j2J.f2845a;
        if (k22.f2849a == null) {
            k22.f2849a = new ArrayList();
        }
        j2J.f2845a.f2849a.add(Long.valueOf(j5));
    }

    @Override // com.google.protobuf.W1
    public final W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        n(abstractC0972o);
        return this;
    }
}
