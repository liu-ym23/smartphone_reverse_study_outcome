package Z7;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    public StringBuilder f7326a;

    /* renamed from: b, reason: collision with root package name */
    public int f7327b;

    public J(StringBuilder sb2, int i10) {
        this.f7326a = sb2;
        this.f7327b = i10;
    }

    public final J a(byte b10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append((int) b10);
        sb2.append('\n');
        return this;
    }

    public final J b(char c10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append(c10);
        sb2.append('\n');
        return this;
    }

    public final J c(double d10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append(d10);
        sb2.append('\n');
        return this;
    }

    public final J d(float f10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append(f10);
        sb2.append('\n');
        return this;
    }

    public final J e(int i10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append(i10);
        sb2.append('\n');
        return this;
    }

    public final J f(long j10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append(j10);
        sb2.append('\n');
        return this;
    }

    public final J g(com.tencent.bugly.proguard.m mVar, String str) {
        b('{', str);
        if (mVar == null) {
            StringBuilder sb2 = this.f7326a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            mVar.f(this.f7326a, this.f7327b + 1);
        }
        b('}', null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> J h(T t10, String str) {
        if (t10 == 0) {
            this.f7326a.append("null\n");
            return this;
        }
        if (t10 instanceof Byte) {
            a(((Byte) t10).byteValue(), str);
            return this;
        }
        if (t10 instanceof Boolean) {
            m(((Boolean) t10).booleanValue(), str);
            return this;
        }
        if (t10 instanceof Short) {
            l(((Short) t10).shortValue(), str);
            return this;
        }
        if (t10 instanceof Integer) {
            e(((Integer) t10).intValue(), str);
            return this;
        }
        if (t10 instanceof Long) {
            f(((Long) t10).longValue(), str);
            return this;
        }
        if (t10 instanceof Float) {
            d(((Float) t10).floatValue(), str);
            return this;
        }
        if (t10 instanceof Double) {
            c(((Double) t10).doubleValue(), str);
            return this;
        }
        if (t10 instanceof String) {
            i((String) t10, str);
            return this;
        }
        if (t10 instanceof Map) {
            k((Map) t10, str);
            return this;
        }
        if (t10 instanceof List) {
            j((List) t10, str);
            return this;
        }
        if (t10 instanceof com.tencent.bugly.proguard.m) {
            g((com.tencent.bugly.proguard.m) t10, str);
            return this;
        }
        if (t10 instanceof byte[]) {
            n((byte[]) t10, str);
            return this;
        }
        if (t10 instanceof boolean[]) {
            h((boolean[]) t10, str);
            return this;
        }
        if (t10 instanceof short[]) {
            t((short[]) t10, str);
            return this;
        }
        if (t10 instanceof int[]) {
            q((int[]) t10, str);
            return this;
        }
        if (t10 instanceof long[]) {
            r((long[]) t10, str);
            return this;
        }
        if (t10 instanceof float[]) {
            p((float[]) t10, str);
            return this;
        }
        if (t10 instanceof double[]) {
            o((double[]) t10, str);
            return this;
        }
        if (!t10.getClass().isArray()) {
            throw new com.tencent.bugly.proguard.j("write object error: unsupport type.");
        }
        s((Object[]) t10, str);
        return this;
    }

    public final J i(String str, String str2) {
        u(str2);
        if (str == null) {
            this.f7326a.append("null\n");
            return this;
        }
        StringBuilder sb2 = this.f7326a;
        sb2.append(str);
        sb2.append('\n');
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> J j(Collection<T> collection, String str) {
        if (collection != null) {
            return s(collection.toArray(), str);
        }
        u(str);
        this.f7326a.append("null\t");
        return this;
    }

    public final <K, V> J k(Map<K, V> map, String str) {
        u(str);
        if (map == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(map.size());
            sb2.append(", {}\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(map.size());
        sb3.append(", {\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        J j11 = new J(this.f7326a, this.f7327b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            j10.b('(', null);
            j11.h(entry.getKey(), null);
            j11.h(entry.getValue(), null);
            j10.b(')', null);
        }
        b('}', null);
        return this;
    }

    public final J l(short s10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append((int) s10);
        sb2.append('\n');
        return this;
    }

    public final J m(boolean z10, String str) {
        u(str);
        StringBuilder sb2 = this.f7326a;
        sb2.append(z10 ? 'T' : 'F');
        sb2.append('\n');
        return this;
    }

    public final J n(byte[] bArr, String str) {
        u(str);
        if (bArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(bArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(bArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (byte b10 : bArr) {
            j10.a(b10, null);
        }
        b(']', null);
        return this;
    }

    public final J o(double[] dArr, String str) {
        u(str);
        if (dArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(dArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(dArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (double d10 : dArr) {
            j10.c(d10, null);
        }
        b(']', null);
        return this;
    }

    public final J p(float[] fArr, String str) {
        u(str);
        if (fArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(fArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(fArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (float f10 : fArr) {
            j10.d(f10, null);
        }
        b(']', null);
        return this;
    }

    public final J q(int[] iArr, String str) {
        u(str);
        if (iArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(iArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(iArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (int i10 : iArr) {
            j10.e(i10, null);
        }
        b(']', null);
        return this;
    }

    public final J r(long[] jArr, String str) {
        u(str);
        if (jArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(jArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(jArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (long j11 : jArr) {
            j10.f(j11, null);
        }
        b(']', null);
        return this;
    }

    public final <T> J s(T[] tArr, String str) {
        u(str);
        if (tArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(tArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(tArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (T t10 : tArr) {
            j10.h(t10, null);
        }
        b(']', null);
        return this;
    }

    public final J t(short[] sArr, String str) {
        u(str);
        if (sArr == null) {
            this.f7326a.append("null\n");
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(sArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f7326a;
        sb3.append(sArr.length);
        sb3.append(", [\n");
        J j10 = new J(this.f7326a, this.f7327b + 1);
        for (short s10 : sArr) {
            j10.l(s10, null);
        }
        b(']', null);
        return this;
    }

    public final void u(String str) {
        for (int i10 = 0; i10 < this.f7327b; i10++) {
            this.f7326a.append('\t');
        }
        if (str != null) {
            StringBuilder sb2 = this.f7326a;
            sb2.append(str);
            sb2.append(": ");
        }
    }
}
