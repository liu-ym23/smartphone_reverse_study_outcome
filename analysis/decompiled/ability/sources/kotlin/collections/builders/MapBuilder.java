package kotlin.collections.builders;

import D7.AbstractC0214f;
import D7.C0211c;
import E7.b;
import E7.d;
import T7.e;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0006\u0010\u0011\u0011\u0011\u0011\u0012B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", AppAgent.CONSTRUCT, "()V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "input", "LC7/r;", "readObject", "(Ljava/io/ObjectInputStream;)V", "s2/a", "E7/b", "E7/c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, e {
    public static final MapBuilder n;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f4900a;
    public Object[] b;
    public int[] c;
    public int[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public d f4901j;
    public E7.e k;
    public d l;
    public boolean m;

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.m = true;
        n = mapBuilder;
    }

    public MapBuilder() {
        this(8);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() throws NotSerializableException {
        if (!this.m) {
            throw new NotSerializableException("The map cannot be serialized while it is being built.");
        }
        SerializedMap serializedMap = new SerializedMap();
        serializedMap.f4903a = this;
        return serializedMap;
    }

    public final int a(Object obj) {
        d();
        while (true) {
            int iL = l(obj);
            int i = this.e * 2;
            int length = this.d.length / 2;
            if (i > length) {
                i = length;
            }
            int i6 = 0;
            while (true) {
                int[] iArr = this.d;
                int i10 = iArr[iL];
                if (i10 <= 0) {
                    int i11 = this.f;
                    Object[] objArr = this.f4900a;
                    if (i11 < objArr.length) {
                        int i12 = i11 + 1;
                        this.f = i12;
                        objArr[i11] = obj;
                        this.c[i11] = iL;
                        iArr[iL] = i12;
                        this.i++;
                        this.h++;
                        if (i6 > this.e) {
                            this.e = i6;
                        }
                        return i11;
                    }
                    h(1);
                } else {
                    if (k.b(this.f4900a[i10 - 1], obj)) {
                        return -i10;
                    }
                    i6++;
                    if (i6 > i) {
                        n(this.d.length * 2);
                        break;
                    }
                    iL = iL == 0 ? this.d.length - 1 : iL - 1;
                }
            }
        }
    }

    public final MapBuilder b() {
        d();
        this.m = true;
        if (this.i > 0) {
            return this;
        }
        MapBuilder mapBuilder = n;
        k.d(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return mapBuilder;
    }

    @Override // java.util.Map
    public final void clear() {
        d();
        int i = this.f - 1;
        if (i >= 0) {
            int i6 = 0;
            while (true) {
                int[] iArr = this.c;
                int i10 = iArr[i6];
                if (i10 >= 0) {
                    this.d[i10] = 0;
                    iArr[i6] = -1;
                }
                if (i6 == i) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        com.stepos.statsrpk.d.H(this.f4900a, 0, this.f);
        Object[] objArr = this.b;
        if (objArr != null) {
            com.stepos.statsrpk.d.H(objArr, 0, this.f);
        }
        this.i = 0;
        this.f = 0;
        this.h++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return i(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return j(obj) >= 0;
    }

    public final void d() {
        if (this.m) {
            throw new UnsupportedOperationException();
        }
    }

    public final void e(boolean z10) {
        int i;
        Object[] objArr = this.b;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            i = this.f;
            if (i6 >= i) {
                break;
            }
            int[] iArr = this.c;
            int i11 = iArr[i6];
            if (i11 >= 0) {
                Object[] objArr2 = this.f4900a;
                objArr2[i10] = objArr2[i6];
                if (objArr != null) {
                    objArr[i10] = objArr[i6];
                }
                if (z10) {
                    iArr[i10] = i11;
                    this.d[i11] = i10 + 1;
                }
                i10++;
            }
            i6++;
        }
        com.stepos.statsrpk.d.H(this.f4900a, i10, i);
        if (objArr != null) {
            com.stepos.statsrpk.d.H(objArr, i10, this.f);
        }
        this.f = i10;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        d dVar = this.l;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this, 0);
        this.l = dVar2;
        return dVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.i == map.size() && f(map.entrySet());
    }

    public final boolean f(Collection m) {
        k.f(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!g((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean g(Map.Entry entry) {
        k.f(entry, "entry");
        int i = i(entry.getKey());
        if (i < 0) {
            return false;
        }
        Object[] objArr = this.b;
        k.c(objArr);
        return k.b(objArr[i], entry.getValue());
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int i = i(obj);
        if (i < 0) {
            return null;
        }
        Object[] objArr = this.b;
        k.c(objArr);
        return objArr[i];
    }

    public final void h(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.f4900a;
        int length = objArr.length;
        int i6 = this.f;
        int i10 = length - i6;
        int i11 = i6 - this.i;
        if (i10 < i && i10 + i11 >= i && i11 >= objArr.length / 4) {
            e(true);
            return;
        }
        int i12 = i6 + i;
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        if (i12 > objArr.length) {
            C0211c c0211c = AbstractC0214f.Companion;
            int length2 = objArr.length;
            c0211c.getClass();
            int iE = C0211c.e(length2, i12);
            Object[] objArr2 = this.f4900a;
            k.f(objArr2, "<this>");
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, iE);
            k.e(objArrCopyOf2, "copyOf(...)");
            this.f4900a = objArrCopyOf2;
            Object[] objArr3 = this.b;
            if (objArr3 != null) {
                objArrCopyOf = Arrays.copyOf(objArr3, iE);
                k.e(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.b = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.c, iE);
            k.e(iArrCopyOf, "copyOf(...)");
            this.c = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((iE >= 1 ? iE : 1) * 3);
            if (iHighestOneBit > this.d.length) {
                n(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        b bVar = new b(this, 0);
        int i = 0;
        while (bVar.hasNext()) {
            int i6 = bVar.b;
            MapBuilder mapBuilder = bVar.f490a;
            if (i6 >= mapBuilder.f) {
                throw new NoSuchElementException();
            }
            bVar.b = i6 + 1;
            bVar.c = i6;
            Object obj = mapBuilder.f4900a[i6];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = mapBuilder.b;
            k.c(objArr);
            Object obj2 = objArr[bVar.c];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            bVar.b();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        int iL = l(obj);
        int i = this.e;
        while (true) {
            int i6 = this.d[iL];
            if (i6 == 0) {
                return -1;
            }
            if (i6 > 0) {
                int i10 = i6 - 1;
                if (k.b(this.f4900a[i10], obj)) {
                    return i10;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iL = iL == 0 ? this.d.length - 1 : iL - 1;
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.i == 0;
    }

    public final int j(Object obj) {
        int i = this.f;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.c[i] >= 0) {
                Object[] objArr = this.b;
                k.c(objArr);
                if (k.b(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Set keySet() {
        d dVar = this.f4901j;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this, 1);
        this.f4901j = dVar2;
        return dVar2;
    }

    public final int l(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.c[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(int r6) {
        /*
            r5 = this;
            int r0 = r5.h
            int r0 = r0 + 1
            r5.h = r0
            int r0 = r5.f
            int r1 = r5.i
            r2 = 0
            if (r0 <= r1) goto L10
            r5.e(r2)
        L10:
            int[] r0 = new int[r6]
            r5.d = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.g = r6
        L1c:
            int r6 = r5.f
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f4900a
            r0 = r0[r2]
            int r0 = r5.l(r0)
            int r1 = r5.e
        L2c:
            int[] r3 = r5.d
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.c
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r5.<init>(r6)
            throw r5
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.n(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f4900a
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.k.f(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.b
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.c
            r0 = r0[r12]
            int r1 = r11.e
            int r1 = r1 * 2
            int[] r2 = r11.d
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L20
            r1 = r2
        L20:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L24:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2e
            int[] r0 = r11.d
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.e
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.d
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.d
            r7 = r5[r0]
            if (r7 != 0) goto L44
            r5[r1] = r2
            goto L6c
        L44:
            if (r7 >= 0) goto L4b
            r5[r1] = r6
        L48:
            r1 = r0
            r4 = r2
            goto L65
        L4b:
            java.lang.Object[] r5 = r11.f4900a
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.l(r5)
            int r5 = r5 - r0
            int[] r9 = r11.d
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.c
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.d
            r0[r1] = r6
        L6c:
            int[] r0 = r11.c
            r0[r12] = r6
            int r12 = r11.i
            int r12 = r12 + r6
            r11.i = r12
            int r12 = r11.h
            int r12 = r12 + 1
            r11.h = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.MapBuilder.o(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        d();
        int iA = a(obj);
        Object[] objArr = this.b;
        if (objArr == null) {
            int length = this.f4900a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.b = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        k.f(from, "from");
        d();
        Set<Map.Entry<K, V>> setEntrySet = from.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        h(setEntrySet.size());
        for (Map.Entry<K, V> entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.b;
            if (objArr == null) {
                int length = this.f4900a.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.b = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!k.b(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        d();
        int i = i(obj);
        if (i < 0) {
            return null;
        }
        Object[] objArr = this.b;
        k.c(objArr);
        Object obj2 = objArr[i];
        o(i);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.i * 3) + 2);
        sb.append("{");
        b bVar = new b(this, 0);
        int i = 0;
        while (bVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i6 = bVar.b;
            MapBuilder mapBuilder = bVar.f490a;
            if (i6 >= mapBuilder.f) {
                throw new NoSuchElementException();
            }
            bVar.b = i6 + 1;
            bVar.c = i6;
            Object obj = mapBuilder.f4900a[i6];
            if (obj == mapBuilder) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = mapBuilder.b;
            k.c(objArr);
            Object obj2 = objArr[bVar.c];
            if (obj2 == mapBuilder) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            bVar.b();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        E7.e eVar = this.k;
        if (eVar != null) {
            return eVar;
        }
        E7.e eVar2 = new E7.e(this);
        this.k = eVar2;
        return eVar2;
    }

    public MapBuilder(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f4900a = objArr;
        this.b = null;
        this.c = iArr;
        this.d = new int[iHighestOneBit];
        this.e = 2;
        this.f = 0;
        this.g = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
