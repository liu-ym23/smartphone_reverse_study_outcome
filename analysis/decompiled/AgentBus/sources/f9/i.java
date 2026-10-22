package f9;

import com.google.protobuf.x0;
import com.google.protobuf.y0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final i f3562c = new i(0);

    /* renamed from: a, reason: collision with root package name */
    public final a0 f3563a = new a0(16);

    /* renamed from: b, reason: collision with root package name */
    public boolean f3564b;

    public i() {
    }

    public static int c(m0 m0Var, Object obj) throws UnsupportedEncodingException {
        switch (m0Var.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                return 8;
            case 1:
                ((Float) obj).getClass();
                return 4;
            case 2:
                return f.g(((Long) obj).longValue());
            case 3:
                return f.g(((Long) obj).longValue());
            case 4:
                return f.c(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                return 8;
            case 6:
                ((Integer) obj).getClass();
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                return 1;
            case 8:
                try {
                    byte[] bytes = ((String) obj).getBytes("UTF-8");
                    return f.f(bytes.length) + bytes.length;
                } catch (UnsupportedEncodingException e10) {
                    throw new RuntimeException("UTF-8 not supported.", e10);
                }
            case 9:
                return ((a) obj).a();
            case 10:
                return f.e((a) obj);
            case 11:
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    return dVar.size() + f.f(dVar.size());
                }
                byte[] bArr = (byte[]) obj;
                return f.f(bArr.length) + bArr.length;
            case 12:
                return f.f(((Integer) obj).intValue());
            case 13:
                return obj instanceof p ? f.c(((p) obj).getNumber()) : f.c(((Integer) obj).intValue());
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                ((Integer) obj).getClass();
                return 4;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                ((Long) obj).getClass();
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return f.f((iIntValue >> 31) ^ (iIntValue << 1));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return f.g((jLongValue >> 63) ^ (jLongValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(m mVar, Object obj) {
        m0 m0Var = mVar.f3570g;
        int i2 = mVar.f3569f;
        if (!mVar.f3571h) {
            int iH = f.h(i2);
            if (m0Var == m0.f3574j) {
                iH *= 2;
            }
            return c(m0Var, obj) + iH;
        }
        int iC = 0;
        for (Object obj2 : (List) obj) {
            int iH2 = f.h(i2);
            if (m0Var == m0.f3574j) {
                iH2 *= 2;
            }
            iC += c(m0Var, obj2) + iH2;
        }
        return iC;
    }

    public static boolean e(Map.Entry entry) {
        m mVar = (m) entry.getKey();
        if (mVar.f3570g.f3578f != n0.f3593o) {
            return true;
        }
        if (!mVar.f3571h) {
            Object value = entry.getValue();
            if (value instanceof a) {
                return ((a) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((a) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public static Object h(e eVar, m0 m0Var) {
        switch (m0Var.ordinal()) {
            case 0:
                return Double.valueOf(Double.longBitsToDouble(eVar.j()));
            case 1:
                return Float.valueOf(Float.intBitsToFloat(eVar.i()));
            case 2:
                return Long.valueOf(eVar.l());
            case 3:
                return Long.valueOf(eVar.l());
            case 4:
                return Integer.valueOf(eVar.k());
            case 5:
                return Long.valueOf(eVar.j());
            case 6:
                return Integer.valueOf(eVar.i());
            case 7:
                return Boolean.valueOf(eVar.l() != 0);
            case 8:
                int iK = eVar.k();
                int i2 = eVar.f3540b;
                int i10 = eVar.f3542d;
                if (iK > i2 - i10 || iK <= 0) {
                    return iK == 0 ? "" : new String(eVar.h(iK), "UTF-8");
                }
                String str = new String(eVar.f3539a, i10, iK, "UTF-8");
                eVar.f3542d += iK;
                return str;
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return eVar.e();
            case 12:
                return Integer.valueOf(eVar.k());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return Integer.valueOf(eVar.i());
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return Long.valueOf(eVar.j());
            case 16:
                int iK2 = eVar.k();
                return Integer.valueOf((-(iK2 & 1)) ^ (iK2 >>> 1));
            case 17:
                long jL = eVar.l();
                return Long.valueOf((-(jL & 1)) ^ (jL >>> 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void j(f9.m0 r2, java.lang.Object r3) {
        /*
            r3.getClass()
            f9.n0 r2 = r2.f3578f
            int r2 = r2.ordinal()
            r0 = 1
            r1 = 0
            switch(r2) {
                case 0: goto L36;
                case 1: goto L33;
                case 2: goto L30;
                case 3: goto L2d;
                case 4: goto L2a;
                case 5: goto L27;
                case 6: goto L1e;
                case 7: goto L12;
                case 8: goto Lf;
                default: goto Le;
            }
        Le:
            goto L38
        Lf:
            boolean r1 = r3 instanceof f9.a
            goto L38
        L12:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof f9.p
            if (r2 == 0) goto L1b
            goto L1c
        L1b:
            r0 = r1
        L1c:
            r1 = r0
            goto L38
        L1e:
            boolean r2 = r3 instanceof f9.d
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1b
            goto L1c
        L27:
            boolean r1 = r3 instanceof java.lang.String
            goto L38
        L2a:
            boolean r1 = r3 instanceof java.lang.Boolean
            goto L38
        L2d:
            boolean r1 = r3 instanceof java.lang.Double
            goto L38
        L30:
            boolean r1 = r3 instanceof java.lang.Float
            goto L38
        L33:
            boolean r1 = r3 instanceof java.lang.Long
            goto L38
        L36:
            boolean r1 = r3 instanceof java.lang.Integer
        L38:
            if (r1 == 0) goto L3b
            return
        L3b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.i.j(f9.m0, java.lang.Object):void");
    }

    public static void k(f fVar, m0 m0Var, Object obj) {
        switch (m0Var.ordinal()) {
            case 0:
                double dDoubleValue = ((Double) obj).doubleValue();
                fVar.getClass();
                fVar.u(Double.doubleToRawLongBits(dDoubleValue));
                break;
            case 1:
                float fFloatValue = ((Float) obj).floatValue();
                fVar.getClass();
                fVar.t(Float.floatToRawIntBits(fFloatValue));
                break;
            case 2:
                fVar.w(((Long) obj).longValue());
                break;
            case 3:
                fVar.w(((Long) obj).longValue());
                break;
            case 4:
                fVar.n(((Integer) obj).intValue());
                break;
            case 5:
                fVar.u(((Long) obj).longValue());
                break;
            case 6:
                fVar.t(((Integer) obj).intValue());
                break;
            case 7:
                fVar.q(((Boolean) obj).booleanValue() ? 1 : 0);
                break;
            case 8:
                fVar.getClass();
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                fVar.v(bytes.length);
                fVar.s(bytes);
                break;
            case 9:
                fVar.getClass();
                ((a) obj).d(fVar);
                break;
            case 10:
                fVar.p((a) obj);
                break;
            case 11:
                if (!(obj instanceof d)) {
                    byte[] bArr = (byte[]) obj;
                    fVar.getClass();
                    fVar.v(bArr.length);
                    fVar.s(bArr);
                    break;
                } else {
                    d dVar = (d) obj;
                    fVar.getClass();
                    fVar.v(dVar.size());
                    fVar.r(dVar);
                    break;
                }
            case 12:
                fVar.v(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof p)) {
                    fVar.n(((Integer) obj).intValue());
                    break;
                } else {
                    fVar.n(((p) obj).getNumber());
                    break;
                }
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                fVar.t(((Integer) obj).intValue());
                break;
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                fVar.u(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                fVar.v((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                fVar.w((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a(m mVar, Object obj) {
        List arrayList;
        if (!mVar.f3571h) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        j(mVar.f3570g, obj);
        a0 a0Var = this.f3563a;
        Object obj2 = a0Var.get(mVar);
        if (obj2 == null) {
            arrayList = new ArrayList();
            a0Var.put(mVar, arrayList);
        } else {
            arrayList = (List) obj2;
        }
        arrayList.add(obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i clone() {
        a0 a0Var;
        i iVar = new i();
        int i2 = 0;
        while (true) {
            a0Var = this.f3563a;
            if (i2 >= a0Var.f3526g.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) a0Var.f3526g.get(i2);
            iVar.i((m) entry.getKey(), entry.getValue());
            i2++;
        }
        for (Map.Entry entry2 : a0Var.c()) {
            iVar.i((m) entry2.getKey(), entry2.getValue());
        }
        return iVar;
    }

    public final void f() {
        if (this.f3564b) {
            return;
        }
        a0 a0Var = this.f3563a;
        if (!a0Var.f3528i) {
            for (int i2 = 0; i2 < a0Var.f3526g.size(); i2++) {
                Map.Entry entry = (Map.Entry) a0Var.f3526g.get(i2);
                if (((m) entry.getKey()).f3571h) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : a0Var.c()) {
                if (((m) entry2.getKey()).f3571h) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!a0Var.f3528i) {
            a0Var.f3527h = a0Var.f3527h.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(a0Var.f3527h);
            a0Var.f3528i = true;
        }
        this.f3564b = true;
    }

    public final void g(Map.Entry entry) {
        m mVar = (m) entry.getKey();
        Object value = entry.getValue();
        boolean z4 = mVar.f3571h;
        a0 a0Var = this.f3563a;
        if (z4) {
            Object arrayList = a0Var.get(mVar);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (Object obj : (List) value) {
                List list = (List) arrayList;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                list.add(obj);
            }
            a0Var.put(mVar, arrayList);
            return;
        }
        if (mVar.f3570g.f3578f != n0.f3593o) {
            if (value instanceof byte[]) {
                byte[] bArr3 = (byte[]) value;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                value = bArr4;
            }
            a0Var.put(mVar, value);
            return;
        }
        Object obj2 = a0Var.get(mVar);
        if (obj2 != null) {
            a0Var.put(mVar, ((a) obj2).c().c((o) ((a) value)).a());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        a0Var.put(mVar, value);
    }

    public final void i(m mVar, Object obj) {
        boolean z4 = mVar.f3571h;
        m0 m0Var = mVar.f3570g;
        if (!z4) {
            j(m0Var, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j(m0Var, it.next());
            }
            obj = arrayList;
        }
        this.f3563a.put(mVar, obj);
    }

    public i(int i2) {
        f();
    }
}
