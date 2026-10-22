package Z7;

import com.autonavi.aps.amapapi.config.Const;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f7328a;

    /* renamed from: b, reason: collision with root package name */
    public String f7329b = Const.STR_APS_ENCODE;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f7330a;

        /* renamed from: b, reason: collision with root package name */
        public int f7331b;
    }

    public K() {
    }

    public static int e(a aVar, ByteBuffer byteBuffer) {
        byte b10 = byteBuffer.get();
        aVar.f7330a = (byte) (b10 & 15);
        int i10 = (b10 & 240) >> 4;
        aVar.f7331b = i10;
        if (i10 != 15) {
            return 1;
        }
        aVar.f7331b = byteBuffer.get();
        return 2;
    }

    public final short[] A(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        short[] sArr = new short[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            sArr[i11] = m(sArr[0], 0, true);
        }
        return sArr;
    }

    public final int[] B(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        int[] iArr = new int[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            iArr[i11] = d(iArr[0], 0, true);
        }
        return iArr;
    }

    public final long[] C(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        long[] jArr = new long[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            jArr[i11] = g(jArr[0], 0, true);
        }
        return jArr;
    }

    public final float[] D(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        float[] fArr = new float[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            fArr[i11] = c(fArr[0], 0, true);
        }
        return fArr;
    }

    public final double[] E(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        double[] dArr = new double[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            dArr[i11] = b(dArr[0], 0, true);
        }
        return dArr;
    }

    public final byte a(byte b10, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return b10;
        }
        a aVar = new a();
        q(aVar);
        byte b11 = aVar.f7330a;
        if (b11 == 0) {
            return this.f7328a.get();
        }
        if (b11 == 12) {
            return (byte) 0;
        }
        throw new com.tencent.bugly.proguard.h("type mismatch.");
    }

    public final double b(double d10, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return d10;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 4) {
            return this.f7328a.getFloat();
        }
        if (b10 == 5) {
            return this.f7328a.getDouble();
        }
        if (b10 == 12) {
            return 0.0d;
        }
        throw new com.tencent.bugly.proguard.h("type mismatch.");
    }

    public final float c(float f10, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return f10;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 4) {
            return this.f7328a.getFloat();
        }
        if (b10 == 12) {
            return 0.0f;
        }
        throw new com.tencent.bugly.proguard.h("type mismatch.");
    }

    public final int d(int i10, int i11, boolean z10) {
        if (!w(i11)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return i10;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 0) {
            return this.f7328a.get();
        }
        if (b10 == 1) {
            return this.f7328a.getShort();
        }
        if (b10 == 2) {
            return this.f7328a.getInt();
        }
        if (b10 == 12) {
            return 0;
        }
        throw new com.tencent.bugly.proguard.h("type mismatch.");
    }

    public final int f(String str) {
        this.f7329b = str;
        return 0;
    }

    public final long g(long j10, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return j10;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 0) {
            return this.f7328a.get();
        }
        if (b10 == 1) {
            return this.f7328a.getShort();
        }
        if (b10 == 2) {
            return this.f7328a.getInt();
        }
        if (b10 == 3) {
            return this.f7328a.getLong();
        }
        if (b10 == 12) {
            return 0L;
        }
        throw new com.tencent.bugly.proguard.h("type mismatch.");
    }

    public final com.tencent.bugly.proguard.m h(com.tencent.bugly.proguard.m mVar, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        try {
            com.tencent.bugly.proguard.m mVar2 = (com.tencent.bugly.proguard.m) mVar.getClass().newInstance();
            a aVar = new a();
            q(aVar);
            if (aVar.f7330a != 10) {
                throw new com.tencent.bugly.proguard.h("type mismatch.");
            }
            mVar2.a(this);
            n();
            return mVar2;
        } catch (Exception e10) {
            throw new com.tencent.bugly.proguard.h(e10.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object i(T t10, int i10, boolean z10) {
        if (t10 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i10, z10));
        }
        if (t10 instanceof Boolean) {
            return Boolean.valueOf(s(i10, z10));
        }
        if (t10 instanceof Short) {
            return Short.valueOf(m((short) 0, i10, z10));
        }
        if (t10 instanceof Integer) {
            return Integer.valueOf(d(0, i10, z10));
        }
        if (t10 instanceof Long) {
            return Long.valueOf(g(0L, i10, z10));
        }
        if (t10 instanceof Float) {
            return Float.valueOf(c(0.0f, i10, z10));
        }
        if (t10 instanceof Double) {
            return Double.valueOf(b(0.0d, i10, z10));
        }
        if (t10 instanceof String) {
            return String.valueOf(u(i10, z10));
        }
        if (t10 instanceof Map) {
            return j((Map) t10, i10, z10);
        }
        if (t10 instanceof List) {
            return k((List) t10, i10, z10);
        }
        if (t10 instanceof com.tencent.bugly.proguard.m) {
            return h((com.tencent.bugly.proguard.m) t10, i10, z10);
        }
        if (t10.getClass().isArray()) {
            return ((t10 instanceof byte[]) || (t10 instanceof Byte[])) ? y(i10, z10) : t10 instanceof boolean[] ? z(i10, z10) : t10 instanceof short[] ? A(i10, z10) : t10 instanceof int[] ? B(i10, z10) : t10 instanceof long[] ? C(i10, z10) : t10 instanceof float[] ? D(i10, z10) : t10 instanceof double[] ? E(i10, z10) : t((Object[]) t10, i10, z10);
        }
        throw new com.tencent.bugly.proguard.h("read object error: unsupport type.");
    }

    public final <K, V> HashMap<K, V> j(Map<K, V> map, int i10, boolean z10) {
        return (HashMap) l(new HashMap(), map, i10, z10);
    }

    public final <T> List<T> k(List<T> list, int i10, boolean z10) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] objArrX = x(list.get(0), i10, z10);
        if (objArrX == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArrX) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> Map<K, V> l(Map<K, V> map, Map<K, V> map2, int i10, boolean z10) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (w(i10)) {
            a aVar = new a();
            q(aVar);
            if (aVar.f7330a != 8) {
                throw new com.tencent.bugly.proguard.h("type mismatch.");
            }
            int iD = d(0, 0, true);
            if (iD < 0) {
                throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
            }
            for (int i11 = 0; i11 < iD; i11++) {
                map.put(i(key, 0, true), i(value, 1, true));
            }
        } else if (z10) {
            throw new com.tencent.bugly.proguard.h("require field not exist.");
        }
        return map;
    }

    public final short m(short s10, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return s10;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 0) {
            return this.f7328a.get();
        }
        if (b10 == 1) {
            return this.f7328a.getShort();
        }
        if (b10 == 12) {
            return (short) 0;
        }
        throw new com.tencent.bugly.proguard.h("type mismatch.");
    }

    public final void n() {
        a aVar = new a();
        do {
            q(aVar);
            o(aVar.f7330a);
        } while (aVar.f7330a != 11);
    }

    public final void o(byte b10) {
        int i10 = 0;
        switch (b10) {
            case 0:
                p(1);
                return;
            case 1:
                p(2);
                return;
            case 2:
                p(4);
                return;
            case 3:
                p(8);
                return;
            case 4:
                p(4);
                return;
            case 5:
                p(8);
                return;
            case 6:
                int i11 = this.f7328a.get();
                if (i11 < 0) {
                    i11 += 256;
                }
                p(i11);
                return;
            case 7:
                p(this.f7328a.getInt());
                return;
            case 8:
                int iD = d(0, 0, true);
                while (i10 < iD * 2) {
                    v();
                    i10++;
                }
                return;
            case 9:
                int iD2 = d(0, 0, true);
                while (i10 < iD2) {
                    v();
                    i10++;
                }
                return;
            case 10:
                n();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                q(aVar);
                if (aVar.f7330a == 0) {
                    p(d(0, 0, true));
                    return;
                }
                throw new com.tencent.bugly.proguard.h("skipField with invalid type, type value: " + ((int) b10) + ", " + ((int) aVar.f7330a));
            default:
                throw new com.tencent.bugly.proguard.h("invalid type.");
        }
    }

    public final void p(int i10) {
        ByteBuffer byteBuffer = this.f7328a;
        byteBuffer.position(byteBuffer.position() + i10);
    }

    public final void q(a aVar) {
        e(aVar, this.f7328a);
    }

    public final void r(byte[] bArr) {
        ByteBuffer byteBuffer = this.f7328a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f7328a = ByteBuffer.wrap(bArr);
    }

    public final boolean s(int i10, boolean z10) {
        return a((byte) 0, i10, z10) != 0;
    }

    public final <T> T[] t(T[] tArr, int i10, boolean z10) {
        if (tArr == null || tArr.length == 0) {
            throw new com.tencent.bugly.proguard.h("unable to get type of key and value.");
        }
        return (T[]) x(tArr[0], i10, z10);
    }

    public final String u(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 6) {
            int i11 = this.f7328a.get();
            if (i11 < 0) {
                i11 += 256;
            }
            byte[] bArr = new byte[i11];
            this.f7328a.get(bArr);
            try {
                return new String(bArr, this.f7329b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b10 != 7) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int i12 = this.f7328a.getInt();
        if (i12 > 104857600 || i12 < 0) {
            throw new com.tencent.bugly.proguard.h("String too long: ".concat(String.valueOf(i12)));
        }
        byte[] bArr2 = new byte[i12];
        this.f7328a.get(bArr2);
        try {
            return new String(bArr2, this.f7329b);
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr2);
        }
    }

    public final void v() {
        a aVar = new a();
        q(aVar);
        o(aVar.f7330a);
    }

    public final boolean w(int i10) {
        int i11;
        try {
            a aVar = new a();
            while (true) {
                int iE = e(aVar, this.f7328a.duplicate());
                i11 = aVar.f7331b;
                if (i10 <= i11 || aVar.f7330a == 11) {
                    break;
                }
                p(iE);
                o(aVar.f7330a);
            }
        } catch (com.tencent.bugly.proguard.h | BufferUnderflowException unused) {
        }
        return i10 == i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] x(T t10, int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t10.getClass(), iD));
        for (int i11 = 0; i11 < iD; i11++) {
            tArr[i11] = i(t10, 0, true);
        }
        return tArr;
    }

    public final byte[] y(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        byte b10 = aVar.f7330a;
        if (b10 == 9) {
            int iD = d(0, 0, true);
            if (iD < 0) {
                throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
            }
            byte[] bArr = new byte[iD];
            for (int i11 = 0; i11 < iD; i11++) {
                bArr[i11] = a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b10 != 13) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        a aVar2 = new a();
        q(aVar2);
        if (aVar2.f7330a != 0) {
            throw new com.tencent.bugly.proguard.h("type mismatch, tag: " + i10 + ", type: " + ((int) aVar.f7330a) + ", " + ((int) aVar2.f7330a));
        }
        int iD2 = d(0, 0, true);
        if (iD2 >= 0) {
            byte[] bArr2 = new byte[iD2];
            this.f7328a.get(bArr2);
            return bArr2;
        }
        throw new com.tencent.bugly.proguard.h("invalid size, tag: " + i10 + ", type: " + ((int) aVar.f7330a) + ", " + ((int) aVar2.f7330a) + ", size: " + iD2);
    }

    public final boolean[] z(int i10, boolean z10) {
        if (!w(i10)) {
            if (z10) {
                throw new com.tencent.bugly.proguard.h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        q(aVar);
        if (aVar.f7330a != 9) {
            throw new com.tencent.bugly.proguard.h("type mismatch.");
        }
        int iD = d(0, 0, true);
        if (iD < 0) {
            throw new com.tencent.bugly.proguard.h("size invalid: ".concat(String.valueOf(iD)));
        }
        boolean[] zArr = new boolean[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            zArr[i11] = s(0, true);
        }
        return zArr;
    }

    public K(byte[] bArr) {
        this.f7328a = ByteBuffer.wrap(bArr);
    }

    public K(byte[] bArr, byte b10) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f7328a = byteBufferWrap;
        byteBufferWrap.position(4);
    }
}
