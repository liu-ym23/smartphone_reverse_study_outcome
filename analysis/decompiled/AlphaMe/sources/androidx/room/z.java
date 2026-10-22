package androidx.room;

import android.util.Log;
import h0.AbstractC0587a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import s0.C0850h;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4268a;

    public z(int i4) {
        if (i4 == 1) {
            this.f4268a = new HashMap();
            return;
        }
        if (i4 == 2) {
            this.f4268a = new HashMap();
        } else if (i4 != 3) {
            this.f4268a = new LinkedHashMap();
        } else {
            this.f4268a = new HashMap();
        }
    }

    public final void a(AbstractC0587a... migrations) {
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        for (AbstractC0587a abstractC0587a : migrations) {
            int i4 = abstractC0587a.startVersion;
            int i5 = abstractC0587a.endVersion;
            HashMap map = this.f4268a;
            Integer numValueOf = Integer.valueOf(i4);
            Object treeMap = map.get(numValueOf);
            if (treeMap == null) {
                treeMap = new TreeMap();
                map.put(numValueOf, treeMap);
            }
            TreeMap treeMap2 = (TreeMap) treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i5))) {
                Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i5)) + " with " + abstractC0587a);
            }
            treeMap2.put(Integer.valueOf(i5), abstractC0587a);
        }
    }

    public final C2.d b(ClassLoader classLoader, String str) {
        Map map = (Map) this.f4268a.get(classLoader);
        if (map == null) {
            map = new HashMap();
            this.f4268a.put(classLoader, map);
        }
        C2.d dVar = (C2.d) map.get(str);
        if (dVar != null) {
            return dVar;
        }
        C2.d dVar2 = new C2.d(classLoader.loadClass(str));
        map.put(str, dVar2);
        return dVar2;
    }

    public final m2.f c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        Map map = (Map) this.f4268a.get(classLoader);
        if (map == null) {
            map = new HashMap();
            this.f4268a.put(classLoader, map);
        }
        m2.f fVar = (m2.f) map.get(str);
        if (fVar != null) {
            return fVar;
        }
        Class<?> clsLoadClass = classLoader.loadClass(str);
        m2.f fVar2 = new m2.f();
        new HashMap();
        fVar2.f13570b = new HashMap();
        fVar2.f13571c = new HashMap();
        fVar2.f13569a = clsLoadClass;
        map.put(str, fVar2);
        return fVar2;
    }

    public final void d(HashMap map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                this.f4268a.put(str, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f4268a.put(str, value);
                } else {
                    int i4 = 0;
                    if (cls == boolean[].class) {
                        HashMap map2 = this.f4268a;
                        boolean[] zArr = (boolean[]) value;
                        String str2 = C0850h.f14199b;
                        Boolean[] boolArr = new Boolean[zArr.length];
                        while (i4 < zArr.length) {
                            boolArr[i4] = Boolean.valueOf(zArr[i4]);
                            i4++;
                        }
                        map2.put(str, boolArr);
                    } else if (cls == byte[].class) {
                        HashMap map3 = this.f4268a;
                        byte[] bArr = (byte[]) value;
                        String str3 = C0850h.f14199b;
                        Byte[] bArr2 = new Byte[bArr.length];
                        while (i4 < bArr.length) {
                            bArr2[i4] = Byte.valueOf(bArr[i4]);
                            i4++;
                        }
                        map3.put(str, bArr2);
                    } else if (cls == int[].class) {
                        HashMap map4 = this.f4268a;
                        int[] iArr = (int[]) value;
                        String str4 = C0850h.f14199b;
                        Integer[] numArr = new Integer[iArr.length];
                        while (i4 < iArr.length) {
                            numArr[i4] = Integer.valueOf(iArr[i4]);
                            i4++;
                        }
                        map4.put(str, numArr);
                    } else if (cls == long[].class) {
                        HashMap map5 = this.f4268a;
                        long[] jArr = (long[]) value;
                        String str5 = C0850h.f14199b;
                        Long[] lArr = new Long[jArr.length];
                        while (i4 < jArr.length) {
                            lArr[i4] = Long.valueOf(jArr[i4]);
                            i4++;
                        }
                        map5.put(str, lArr);
                    } else if (cls == float[].class) {
                        HashMap map6 = this.f4268a;
                        float[] fArr = (float[]) value;
                        String str6 = C0850h.f14199b;
                        Float[] fArr2 = new Float[fArr.length];
                        while (i4 < fArr.length) {
                            fArr2[i4] = Float.valueOf(fArr[i4]);
                            i4++;
                        }
                        map6.put(str, fArr2);
                    } else {
                        if (cls != double[].class) {
                            throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
                        }
                        HashMap map7 = this.f4268a;
                        double[] dArr = (double[]) value;
                        String str7 = C0850h.f14199b;
                        Double[] dArr2 = new Double[dArr.length];
                        while (i4 < dArr.length) {
                            dArr2[i4] = Double.valueOf(dArr[i4]);
                            i4++;
                        }
                        map7.put(str, dArr2);
                    }
                }
            }
        }
    }
}
