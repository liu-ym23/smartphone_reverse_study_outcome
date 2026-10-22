package androidx.room;

import android.util.Log;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1626a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap f1627b;

    public t() {
        this.f1626a = 1;
        this.f1627b = new LinkedHashMap();
    }

    public void a(q4.a aVar) {
        aVar.getClass();
        int i = aVar.f10073a;
        int i3 = aVar.f10074b;
        LinkedHashMap linkedHashMap = this.f1627b;
        Integer numValueOf = Integer.valueOf(i);
        Object treeMap = linkedHashMap.get(numValueOf);
        if (treeMap == null) {
            treeMap = new TreeMap();
            linkedHashMap.put(numValueOf, treeMap);
        }
        TreeMap treeMap2 = (TreeMap) treeMap;
        if (treeMap2.containsKey(Integer.valueOf(i3))) {
            Log.w("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i3)) + " with " + aVar);
        }
        treeMap2.put(Integer.valueOf(i3), aVar);
    }

    public void b(x7.a aVar) {
        ((List) this.f1627b.computeIfAbsent(aVar.f15585b, new reactor.util.context.b(2))).add(aVar);
    }

    public void c(HashMap map) {
        Object[] objArr;
        map.getClass();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            str.getClass();
            LinkedHashMap linkedHashMap = this.f1627b;
            if (value == null) {
                value = null;
            } else {
                yb.e eVarA = yb.v.a(value.getClass());
                if (eVarA.equals(yb.v.a(Boolean.TYPE)) ? true : eVarA.equals(yb.v.a(Byte.TYPE)) ? true : eVarA.equals(yb.v.a(Integer.TYPE)) ? true : eVarA.equals(yb.v.a(Long.TYPE)) ? true : eVarA.equals(yb.v.a(Float.TYPE)) ? true : eVarA.equals(yb.v.a(Double.TYPE)) ? true : eVarA.equals(yb.v.a(String.class)) ? true : eVarA.equals(yb.v.a(Boolean[].class)) ? true : eVarA.equals(yb.v.a(Byte[].class)) ? true : eVarA.equals(yb.v.a(Integer[].class)) ? true : eVarA.equals(yb.v.a(Long[].class)) ? true : eVarA.equals(yb.v.a(Float[].class)) ? true : eVarA.equals(yb.v.a(Double[].class)) ? true : eVarA.equals(yb.v.a(String[].class))) {
                    continue;
                } else {
                    int i = 0;
                    if (eVarA.equals(yb.v.a(boolean[].class))) {
                        boolean[] zArr = (boolean[]) value;
                        String str2 = g5.i.f4320a;
                        int length = zArr.length;
                        objArr = new Boolean[length];
                        while (i < length) {
                            objArr[i] = Boolean.valueOf(zArr[i]);
                            i++;
                        }
                    } else if (eVarA.equals(yb.v.a(byte[].class))) {
                        byte[] bArr = (byte[]) value;
                        String str3 = g5.i.f4320a;
                        int length2 = bArr.length;
                        objArr = new Byte[length2];
                        while (i < length2) {
                            objArr[i] = Byte.valueOf(bArr[i]);
                            i++;
                        }
                    } else if (eVarA.equals(yb.v.a(int[].class))) {
                        int[] iArr = (int[]) value;
                        String str4 = g5.i.f4320a;
                        int length3 = iArr.length;
                        objArr = new Integer[length3];
                        while (i < length3) {
                            objArr[i] = Integer.valueOf(iArr[i]);
                            i++;
                        }
                    } else if (eVarA.equals(yb.v.a(long[].class))) {
                        long[] jArr = (long[]) value;
                        String str5 = g5.i.f4320a;
                        int length4 = jArr.length;
                        objArr = new Long[length4];
                        while (i < length4) {
                            objArr[i] = Long.valueOf(jArr[i]);
                            i++;
                        }
                    } else if (eVarA.equals(yb.v.a(float[].class))) {
                        float[] fArr = (float[]) value;
                        String str6 = g5.i.f4320a;
                        int length5 = fArr.length;
                        objArr = new Float[length5];
                        while (i < length5) {
                            objArr[i] = Float.valueOf(fArr[i]);
                            i++;
                        }
                    } else {
                        if (!eVarA.equals(yb.v.a(double[].class))) {
                            g5.f.h("Key ", str, " has invalid type ", eVarA);
                            return;
                        }
                        double[] dArr = (double[]) value;
                        String str7 = g5.i.f4320a;
                        int length6 = dArr.length;
                        objArr = new Double[length6];
                        while (i < length6) {
                            objArr[i] = Double.valueOf(dArr[i]);
                            i++;
                        }
                    }
                    value = objArr;
                }
            }
            linkedHashMap.put(str, value);
        }
    }

    public String toString() {
        switch (this.f1626a) {
            case 3:
                LinkedHashMap linkedHashMap = this.f1627b;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    for (x7.a aVar : (List) it.next()) {
                        String str = aVar.f15584a;
                        String string = aVar.f15585b.toString();
                        ((Map) ((Map) linkedHashMap2.computeIfAbsent(string, new reactor.util.context.b(3))).computeIfAbsent(str, new reactor.util.context.b(4))).put(aVar.f15587d.toString(), aVar.f15588e);
                    }
                }
                try {
                    return f8.c.f4042a.writerWithDefaultPrettyPrinter().writeValueAsString(linkedHashMap2);
                } catch (JsonProcessingException unused) {
                    return "";
                }
            default:
                return super.toString();
        }
    }

    public /* synthetic */ t(int i) {
        this.f1626a = i;
    }
}
