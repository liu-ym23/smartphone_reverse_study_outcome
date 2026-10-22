package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: c, reason: collision with root package name */
    public static final b2 f2317c = new b2(0);

    /* renamed from: a, reason: collision with root package name */
    public final v3 f2318a = v3.f();

    /* renamed from: b, reason: collision with root package name */
    public boolean f2319b;

    public b2() {
    }

    public static int b(s4 s4Var, int i2, Object obj) {
        int size;
        int iV;
        int iU = r.U(i2);
        if (s4Var == s4.f2525i) {
            iU *= 2;
        }
        int iW = 4;
        switch (s4Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = r.f2504b;
                iW = 8;
                return iW + iU;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = r.f2504b;
                return iW + iU;
            case 2:
                iW = r.W(((Long) obj).longValue());
                return iW + iU;
            case 3:
                iW = r.W(((Long) obj).longValue());
                return iW + iU;
            case 4:
                iW = r.W(((Integer) obj).intValue());
                return iW + iU;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = r.f2504b;
                iW = 8;
                return iW + iU;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = r.f2504b;
                return iW + iU;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = r.f2504b;
                iW = 1;
                return iW + iU;
            case 8:
                if (!(obj instanceof l)) {
                    iW = r.T((String) obj);
                    return iW + iU;
                }
                Logger logger6 = r.f2504b;
                size = ((l) obj).size();
                iV = r.V(size);
                iW = iV + size;
                return iW + iU;
            case 9:
                Logger logger7 = r.f2504b;
                iW = ((MessageLite) obj).getSerializedSize();
                return iW + iU;
            case 10:
                Logger logger8 = r.f2504b;
                size = ((MessageLite) obj).getSerializedSize();
                iV = r.V(size);
                iW = iV + size;
                return iW + iU;
            case 11:
                if (obj instanceof l) {
                    Logger logger9 = r.f2504b;
                    size = ((l) obj).size();
                    iV = r.V(size);
                } else {
                    Logger logger10 = r.f2504b;
                    size = ((byte[]) obj).length;
                    iV = r.V(size);
                }
                iW = iV + size;
                return iW + iU;
            case 12:
                iW = r.V(((Integer) obj).intValue());
                return iW + iU;
            case 13:
                iW = obj instanceof k2 ? r.W(((k2) obj).getNumber()) : r.W(((Integer) obj).intValue());
                return iW + iU;
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                ((Integer) obj).getClass();
                Logger logger11 = r.f2504b;
                return iW + iU;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                ((Long) obj).getClass();
                Logger logger12 = r.f2504b;
                iW = 8;
                return iW + iU;
            case 16:
                iW = r.R(((Integer) obj).intValue());
                return iW + iU;
            case 17:
                iW = r.S(((Long) obj).longValue());
                return iW + iU;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void f(r rVar, s4 s4Var, int i2, Object obj) {
        if (s4Var == s4.f2525i) {
            rVar.p0(i2, 3);
            ((MessageLite) obj).writeTo(rVar);
            rVar.p0(i2, 4);
        }
        rVar.p0(i2, s4Var.f2529g);
        switch (s4Var.ordinal()) {
            case 0:
                rVar.g0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                rVar.e0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                rVar.t0(((Long) obj).longValue());
                break;
            case 3:
                rVar.t0(((Long) obj).longValue());
                break;
            case 4:
                rVar.i0(((Integer) obj).intValue());
                break;
            case 5:
                rVar.g0(((Long) obj).longValue());
                break;
            case 6:
                rVar.e0(((Integer) obj).intValue());
                break;
            case 7:
                rVar.Y(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof l)) {
                    rVar.o0((String) obj);
                    break;
                } else {
                    rVar.c0((l) obj);
                    break;
                }
            case 9:
                ((MessageLite) obj).writeTo(rVar);
                break;
            case 10:
                rVar.k0((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof l)) {
                    byte[] bArr = (byte[]) obj;
                    rVar.a0(bArr.length, bArr);
                    break;
                } else {
                    rVar.c0((l) obj);
                    break;
                }
            case 12:
                rVar.r0(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof k2)) {
                    rVar.i0(((Integer) obj).intValue());
                    break;
                } else {
                    rVar.i0(((k2) obj).getNumber());
                    break;
                }
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                rVar.e0(((Integer) obj).intValue());
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                rVar.g0(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                rVar.r0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                rVar.t0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final b2 clone() {
        b2 b2Var = new b2();
        v3 v3Var = this.f2318a;
        if (v3Var.f2591g > 0) {
            w3 w3VarC = v3Var.c(0);
            if (w3VarC.f2622f != null) {
                throw new ClassCastException();
            }
            Object obj = w3VarC.f2623g;
            throw null;
        }
        Iterator it = v3Var.d().iterator();
        if (!it.hasNext()) {
            return b2Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        entry.getValue();
        throw null;
    }

    public final void c() {
        v3 v3Var = this.f2318a;
        if (v3Var.f2591g > 0) {
            v3Var.c(0).getKey().getClass();
            throw new ClassCastException();
        }
        Iterator it = v3Var.d().iterator();
        if (it.hasNext()) {
            ((Map.Entry) it.next()).getKey().getClass();
            throw new ClassCastException();
        }
    }

    public final Iterator d() {
        v3 v3Var = this.f2318a;
        return v3Var.isEmpty() ? Collections.emptyIterator() : ((androidx.datastore.preferences.protobuf.h1) v3Var.entrySet()).iterator();
    }

    public final void e() {
        if (this.f2319b) {
            return;
        }
        v3 v3Var = this.f2318a;
        int i2 = v3Var.f2591g;
        for (int i10 = 0; i10 < i2; i10++) {
            Object obj = v3Var.c(i10).f2623g;
            if (obj instanceof i2) {
                ((i2) obj).i();
            }
        }
        Iterator it = v3Var.d().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof i2) {
                ((i2) value).i();
            }
        }
        if (!v3Var.f2593i) {
            if (v3Var.f2591g > 0) {
                v3Var.c(0).f2622f.getClass();
                throw new ClassCastException();
            }
            Iterator it2 = v3Var.d().iterator();
            if (it2.hasNext()) {
                ((Map.Entry) it2.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!v3Var.f2593i) {
            v3Var.f2592h = v3Var.f2592h.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(v3Var.f2592h);
            v3Var.f2595k = v3Var.f2595k.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(v3Var.f2595k);
            v3Var.f2593i = true;
        }
        this.f2319b = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b2) {
            return this.f2318a.equals(((b2) obj).f2318a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2318a.hashCode();
    }

    public b2(int i2) {
        e();
        e();
    }
}
