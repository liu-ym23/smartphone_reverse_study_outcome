package H8;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType;

/* loaded from: classes4.dex */
public final class i {
    public static final i c = new i(0);

    /* renamed from: a, reason: collision with root package name */
    public final x f773a = new x(16);
    public boolean b;

    public i() {
    }

    public static int c(WireFormat$FieldType wireFormat$FieldType, Object obj) throws UnsupportedEncodingException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                return 8;
            case 1:
                ((Float) obj).getClass();
                return 4;
            case 2:
                return A0.d.k(((Long) obj).longValue());
            case 3:
                return A0.d.k(((Long) obj).longValue());
            case 4:
                return A0.d.g(((Integer) obj).intValue());
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
                    return A0.d.j(bytes.length) + bytes.length;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("UTF-8 not supported.", e);
                }
            case 9:
                return ((AbstractC0241b) obj).a();
            case 10:
                return A0.d.i((AbstractC0241b) obj);
            case 11:
                if (obj instanceof AbstractC0244e) {
                    AbstractC0244e abstractC0244e = (AbstractC0244e) obj;
                    return abstractC0244e.size() + A0.d.j(abstractC0244e.size());
                }
                byte[] bArr = (byte[]) obj;
                return A0.d.j(bArr.length) + bArr.length;
            case 12:
                return A0.d.j(((Integer) obj).intValue());
            case 13:
                return obj instanceof m ? A0.d.g(((m) obj).getNumber()) : A0.d.g(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                return 4;
            case 15:
                ((Long) obj).getClass();
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return A0.d.j((iIntValue >> 31) ^ (iIntValue << 1));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return A0.d.k((jLongValue >> 63) ^ (jLongValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int d(k kVar, Object obj) {
        WireFormat$FieldType wireFormat$FieldType = kVar.b;
        int i = kVar.f775a;
        if (!kVar.c) {
            int iL = A0.d.l(i);
            if (wireFormat$FieldType == WireFormat$FieldType.e) {
                iL *= 2;
            }
            return c(wireFormat$FieldType, obj) + iL;
        }
        int iC = 0;
        for (Object obj2 : (List) obj) {
            int iL2 = A0.d.l(i);
            if (wireFormat$FieldType == WireFormat$FieldType.e) {
                iL2 *= 2;
            }
            iC += c(wireFormat$FieldType, obj2) + iL2;
        }
        return iC;
    }

    public static boolean e(Map.Entry entry) {
        k kVar = (k) entry.getKey();
        if (kVar.b.f5101a != WireFormat$JavaType.MESSAGE) {
            return true;
        }
        if (!kVar.c) {
            Object value = entry.getValue();
            if (value instanceof AbstractC0241b) {
                return ((AbstractC0241b) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((AbstractC0241b) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public static Object h(C0245f c0245f, WireFormat$FieldType wireFormat$FieldType) {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                return Double.valueOf(Double.longBitsToDouble(c0245f.j()));
            case 1:
                return Float.valueOf(Float.intBitsToFloat(c0245f.i()));
            case 2:
                return Long.valueOf(c0245f.l());
            case 3:
                return Long.valueOf(c0245f.l());
            case 4:
                return Integer.valueOf(c0245f.k());
            case 5:
                return Long.valueOf(c0245f.j());
            case 6:
                return Integer.valueOf(c0245f.i());
            case 7:
                return Boolean.valueOf(c0245f.l() != 0);
            case 8:
                int iK = c0245f.k();
                int i = c0245f.b;
                int i6 = c0245f.d;
                if (iK > i - i6 || iK <= 0) {
                    return iK == 0 ? "" : new String(c0245f.h(iK), "UTF-8");
                }
                String str = new String(c0245f.f770a, i6, iK, "UTF-8");
                c0245f.d += iK;
                return str;
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return c0245f.e();
            case 12:
                return Integer.valueOf(c0245f.k());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(c0245f.i());
            case 15:
                return Long.valueOf(c0245f.j());
            case 16:
                int iK2 = c0245f.k();
                return Integer.valueOf((-(iK2 & 1)) ^ (iK2 >>> 1));
            case 17:
                long jL = c0245f.l();
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
    public static void j(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType r2, java.lang.Object r3) {
        /*
            r3.getClass()
            kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$JavaType r2 = r2.f5101a
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
            boolean r1 = r3 instanceof H8.AbstractC0241b
            goto L38
        L12:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L1c
            boolean r2 = r3 instanceof H8.m
            if (r2 == 0) goto L1b
            goto L1c
        L1b:
            r0 = r1
        L1c:
            r1 = r0
            goto L38
        L1e:
            boolean r2 = r3 instanceof H8.AbstractC0244e
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
        throw new UnsupportedOperationException("Method not decompiled: H8.i.j(kotlin.reflect.jvm.internal.impl.protobuf.WireFormat$FieldType, java.lang.Object):void");
    }

    public static void k(A0.d dVar, WireFormat$FieldType wireFormat$FieldType, Object obj) throws IOException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                double dDoubleValue = ((Double) obj).doubleValue();
                dVar.getClass();
                dVar.y(Double.doubleToRawLongBits(dDoubleValue));
                break;
            case 1:
                float fFloatValue = ((Float) obj).floatValue();
                dVar.getClass();
                dVar.x(Float.floatToRawIntBits(fFloatValue));
                break;
            case 2:
                dVar.A(((Long) obj).longValue());
                break;
            case 3:
                dVar.A(((Long) obj).longValue());
                break;
            case 4:
                dVar.r(((Integer) obj).intValue());
                break;
            case 5:
                dVar.y(((Long) obj).longValue());
                break;
            case 6:
                dVar.x(((Integer) obj).intValue());
                break;
            case 7:
                dVar.u(((Boolean) obj).booleanValue() ? 1 : 0);
                break;
            case 8:
                dVar.getClass();
                byte[] bytes = ((String) obj).getBytes("UTF-8");
                dVar.z(bytes.length);
                dVar.w(bytes);
                break;
            case 9:
                dVar.getClass();
                ((AbstractC0241b) obj).d(dVar);
                break;
            case 10:
                dVar.t((AbstractC0241b) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC0244e)) {
                    byte[] bArr = (byte[]) obj;
                    dVar.getClass();
                    dVar.z(bArr.length);
                    dVar.w(bArr);
                    break;
                } else {
                    AbstractC0244e abstractC0244e = (AbstractC0244e) obj;
                    dVar.getClass();
                    dVar.z(abstractC0244e.size());
                    dVar.v(abstractC0244e);
                    break;
                }
            case 12:
                dVar.z(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof m)) {
                    dVar.r(((Integer) obj).intValue());
                    break;
                } else {
                    dVar.r(((m) obj).getNumber());
                    break;
                }
            case 14:
                dVar.x(((Integer) obj).intValue());
                break;
            case 15:
                dVar.y(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                dVar.z((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                dVar.A((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a(k kVar, Object obj) {
        List arrayList;
        if (!kVar.c) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        j(kVar.b, obj);
        x xVar = this.f773a;
        Object obj2 = xVar.get(kVar);
        if (obj2 == null) {
            arrayList = new ArrayList();
            xVar.put(kVar, arrayList);
        } else {
            arrayList = (List) obj2;
        }
        arrayList.add(obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final i clone() {
        x xVar;
        i iVar = new i();
        int i = 0;
        while (true) {
            xVar = this.f773a;
            if (i >= xVar.b.size()) {
                break;
            }
            Map.Entry entry = (Map.Entry) xVar.b.get(i);
            iVar.i((k) entry.getKey(), entry.getValue());
            i++;
        }
        for (Map.Entry entry2 : xVar.d()) {
            iVar.i((k) entry2.getKey(), entry2.getValue());
        }
        return iVar;
    }

    public final void f() {
        if (this.b) {
            return;
        }
        x xVar = this.f773a;
        if (!xVar.d) {
            for (int i = 0; i < xVar.b.size(); i++) {
                Map.Entry entry = (Map.Entry) xVar.b.get(i);
                if (((k) entry.getKey()).c) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : xVar.d()) {
                if (((k) entry2.getKey()).c) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!xVar.d) {
            xVar.c = xVar.c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(xVar.c);
            xVar.d = true;
        }
        this.b = true;
    }

    public final void g(Map.Entry entry) {
        k kVar = (k) entry.getKey();
        Object value = entry.getValue();
        boolean z10 = kVar.c;
        x xVar = this.f773a;
        if (z10) {
            Object arrayList = xVar.get(kVar);
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
            xVar.put(kVar, arrayList);
            return;
        }
        if (kVar.b.f5101a != WireFormat$JavaType.MESSAGE) {
            if (value instanceof byte[]) {
                byte[] bArr3 = (byte[]) value;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                value = bArr4;
            }
            xVar.put(kVar, value);
            return;
        }
        Object obj2 = xVar.get(kVar);
        if (obj2 != null) {
            xVar.put(kVar, ((AbstractC0241b) obj2).c().c((GeneratedMessageLite) ((AbstractC0241b) value)).a());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        xVar.put(kVar, value);
    }

    public final void i(k kVar, Object obj) {
        boolean z10 = kVar.c;
        WireFormat$FieldType wireFormat$FieldType = kVar.b;
        if (!z10) {
            j(wireFormat$FieldType, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                j(wireFormat$FieldType, it.next());
            }
            obj = arrayList;
        }
        this.f773a.put(kVar, obj);
    }

    public i(int i) {
        f();
    }
}
