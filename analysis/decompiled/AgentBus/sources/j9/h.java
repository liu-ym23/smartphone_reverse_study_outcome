package j9;

import f8.z;
import i8.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class h {
    public static b a(List list, z zVar, c8.j jVar) {
        List listM1 = d7.r.m1(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            g gVarB = b(it.next(), null);
            if (gVarB != null) {
                arrayList.add(gVarB);
            }
        }
        return zVar != null ? new x(arrayList, zVar.n().q(jVar)) : new b(arrayList, new c1.w(13, jVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d7.z] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v24, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.ArrayList] */
    public static g b(Object obj, a0 a0Var) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new v(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new k(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new t(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e((Character) obj);
        }
        if (obj instanceof Float) {
            return new c(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new c(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c((Boolean) obj);
        }
        if (obj instanceof String) {
            return new w((String) obj);
        }
        boolean z4 = obj instanceof byte[];
        ?? S = d7.z.f2978f;
        int i2 = 0;
        if (z4) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            if (length != 0) {
                if (length != 1) {
                    S = new ArrayList(bArr.length);
                    int length2 = bArr.length;
                    while (i2 < length2) {
                        S.add(Byte.valueOf(bArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Byte.valueOf(bArr[0]));
                }
            }
            return a(S, a0Var, c8.j.BYTE);
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length3 = sArr.length;
            if (length3 != 0) {
                if (length3 != 1) {
                    S = new ArrayList(sArr.length);
                    int length4 = sArr.length;
                    while (i2 < length4) {
                        S.add(Short.valueOf(sArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Short.valueOf(sArr[0]));
                }
            }
            return a(S, a0Var, c8.j.SHORT);
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length5 = iArr.length;
            if (length5 != 0) {
                if (length5 != 1) {
                    S = new ArrayList(iArr.length);
                    int length6 = iArr.length;
                    while (i2 < length6) {
                        S.add(Integer.valueOf(iArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Integer.valueOf(iArr[0]));
                }
            }
            return a(S, a0Var, c8.j.INT);
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            if (length7 != 0) {
                if (length7 != 1) {
                    S = new ArrayList(jArr.length);
                    int length8 = jArr.length;
                    while (i2 < length8) {
                        S.add(Long.valueOf(jArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Long.valueOf(jArr[0]));
                }
            }
            return a(S, a0Var, c8.j.LONG);
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length9 = cArr.length;
            if (length9 != 0) {
                if (length9 != 1) {
                    S = new ArrayList(cArr.length);
                    int length10 = cArr.length;
                    while (i2 < length10) {
                        S.add(Character.valueOf(cArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Character.valueOf(cArr[0]));
                }
            }
            return a(S, a0Var, c8.j.CHAR);
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length11 = fArr.length;
            if (length11 != 0) {
                if (length11 != 1) {
                    S = new ArrayList(fArr.length);
                    int length12 = fArr.length;
                    while (i2 < length12) {
                        S.add(Float.valueOf(fArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Float.valueOf(fArr[0]));
                }
            }
            return a(S, a0Var, c8.j.FLOAT);
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length13 = dArr.length;
            if (length13 != 0) {
                if (length13 != 1) {
                    S = new ArrayList(dArr.length);
                    int length14 = dArr.length;
                    while (i2 < length14) {
                        S.add(Double.valueOf(dArr[i2]));
                        i2++;
                    }
                } else {
                    S = a.a.S(Double.valueOf(dArr[0]));
                }
            }
            return a(S, a0Var, c8.j.DOUBLE);
        }
        if (!(obj instanceof boolean[])) {
            if (obj == null) {
                return new u(null);
            }
            return null;
        }
        boolean[] zArr = (boolean[]) obj;
        int length15 = zArr.length;
        if (length15 != 0) {
            if (length15 != 1) {
                S = new ArrayList(zArr.length);
                int length16 = zArr.length;
                while (i2 < length16) {
                    S.add(Boolean.valueOf(zArr[i2]));
                    i2++;
                }
            } else {
                S = a.a.S(Boolean.valueOf(zArr[0]));
            }
        }
        return a(S, a0Var, c8.j.BOOLEAN);
    }
}
