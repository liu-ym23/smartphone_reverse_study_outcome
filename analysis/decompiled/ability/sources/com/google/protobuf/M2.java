package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class M2 implements X1 {
    public static final M2 b = new M2(new TreeMap());

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f2854a;

    public M2(TreeMap treeMap) {
        this.f2854a = treeMap;
    }

    public static I2 g() {
        I2 i22 = new I2();
        i22.f2841a = new TreeMap();
        return i22;
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        for (Map.Entry entry : this.f2854a.entrySet()) {
            K2 k22 = (K2) entry.getValue();
            int iIntValue = ((Integer) entry.getKey()).intValue();
            Iterator it = k22.f2849a.iterator();
            while (it.hasNext()) {
                c0980q.m0(iIntValue, ((Long) it.next()).longValue());
            }
            Iterator it2 = k22.b.iterator();
            while (it2.hasNext()) {
                c0980q.Y(iIntValue, ((Integer) it2.next()).intValue());
            }
            Iterator it3 = k22.c.iterator();
            while (it3.hasNext()) {
                c0980q.a0(iIntValue, ((Long) it3.next()).longValue());
            }
            Iterator it4 = k22.d.iterator();
            while (it4.hasNext()) {
                c0980q.X(iIntValue, (ByteString) it4.next());
            }
            Iterator it5 = k22.e.iterator();
            while (it5.hasNext()) {
                c0980q.c0(iIntValue, (M2) it5.next());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof M2) {
            return this.f2854a.equals(((M2) obj).f2854a);
        }
        return false;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return b;
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        TreeMap treeMap = this.f2854a;
        if (treeMap.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (Map.Entry entry : treeMap.entrySet()) {
            K2 k22 = (K2) entry.getValue();
            int iIntValue = ((Integer) entry.getKey()).intValue();
            Iterator it = k22.f2849a.iterator();
            int serializedSize = 0;
            while (it.hasNext()) {
                serializedSize += C0980q.T(((Long) it.next()).longValue()) + C0980q.R(iIntValue);
            }
            Iterator it2 = k22.b.iterator();
            while (it2.hasNext()) {
                ((Integer) it2.next()).getClass();
                serializedSize += C0980q.R(iIntValue) + 4;
            }
            Iterator it3 = k22.c.iterator();
            while (it3.hasNext()) {
                ((Long) it3.next()).getClass();
                serializedSize += C0980q.R(iIntValue) + 8;
            }
            Iterator it4 = k22.d.iterator();
            while (it4.hasNext()) {
                serializedSize += C0980q.K(iIntValue, (ByteString) it4.next());
            }
            Iterator it5 = k22.e.iterator();
            while (it5.hasNext()) {
                serializedSize += ((M2) it5.next()).getSerializedSize() + (C0980q.R(iIntValue) * 2);
            }
            i += serializedSize;
        }
        return i;
    }

    public final int hashCode() {
        TreeMap treeMap = this.f2854a;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return treeMap.hashCode();
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return g();
    }

    @Override // com.google.protobuf.X1
    public final W1 toBuilder() {
        I2 i2G = g();
        i2G.o(this);
        return i2G;
    }

    public final String toString() {
        Logger logger = E2.f2828a;
        D2.b.getClass();
        try {
            StringBuilder sb = new StringBuilder();
            D2.e(this, new C1012y0(sb));
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
