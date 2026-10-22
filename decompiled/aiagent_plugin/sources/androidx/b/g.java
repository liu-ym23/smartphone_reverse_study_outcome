package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: SimpleArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {
    private static final String TAG = "ArrayMap";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Object[] f555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static int f556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static Object[] f557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f558e;
    int[] f;
    Object[] g;
    int h;

    private static int a(int[] r0, int r1, int r2) {
        return c.a(r0, r1, r2);
    L5:
        throw new ConcurrentModificationException();
    }

    int a(Object r6, int r7) {
        int r0 = this.h;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = a(this.f, r0, r7);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (r6.equals(this.g[r1 << 1]) == false) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.f[r2] != r7) goto L20;
        if (r6.equals(this.g[r2 << 1]) == true) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.f[r3] != r7) goto L29;
        if (r6.equals(this.g[r3 << 1]) == true) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    int a() {
        int r0 = this.h;
        if (r0 != 0) goto L6;
        return -1;
    L6:
        int r1 = a(this.f, r0, 0);
        if (r1 >= 0) goto L10;
        return r1;
    L10:
        if (this.g[r1 << 1] != null) goto L12;
        return r1;
    L12:
        int r2 = r1 + 1;
    L13:
        if (r2 >= r0) goto L20;
        if (this.f[r2] != 0) goto L20;
        if (this.g[r2 << 1] == null) goto L18;
        r2 = r2 + 1;
        goto L13
    L18:
        return r2;
    L20:
        int r3 = r1 - 1;
    L21:
        if (r3 < 0) goto L29;
        if (this.f[r3] != 0) goto L29;
        if (this.g[r3 << 1] == null) goto L26;
        r3 = r3 - 1;
        goto L21
    L26:
        return r3;
    L29:
        return ~r2;
    }

    private void e(int r9) {
        if (r9 != 8) goto L16;
        monitor-enter(g.class);
        Object[] r5 = f557d;     // Catch: Throwable -> L12
        if (r5 == null) goto L10;
        this.g = r5;     // Catch: Throwable -> L12
        f557d = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r5[0], Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        this.f = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r5[1], int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r5[1] = null;     // Catch: Throwable -> L12
        r5[0] = null;     // Catch: Throwable -> L12
        f558e--;     // Catch: Throwable -> L12
        monitor-exit(g.class);     // Catch: Throwable -> L12
        return;
    L10:
        monitor-exit(g.class);     // Catch: Throwable -> L12
    L28:
        this.f = new int[r9];
        this.g = new Object[r9 << 1];
        return;
    L12:
        th = move-exception;
        throw th;
    L16:
        if (r9 != 4) goto L28;
        monitor-enter(g.class);
        Object[] r6 = f555b;     // Catch: Throwable -> L25
        if (r6 == null) goto L23;
        this.g = r6;     // Catch: Throwable -> L25
        f555b = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r6[0], Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        this.f = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r6[1], int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        r6[1] = null;     // Catch: Throwable -> L25
        r6[0] = null;     // Catch: Throwable -> L25
        f556c--;     // Catch: Throwable -> L25
        monitor-exit(g.class);     // Catch: Throwable -> L25
        return;
    L23:
        monitor-exit(g.class);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private static void a(int[] r8, Object[] r9, int r10) {
        if (r8.length != 8) goto L17;
        monitor-enter(g.class);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (f558e >= 10) goto L11;
        r9[0] = f557d;     // Catch: Throwable -> L13
        r9[1] = r8;     // Catch: Throwable -> L13
        int r11 = (r10 << 1) - 1;     // Catch: Throwable -> L13
    L8:
        if (r11 < 2) goto L10;
        r9[r11] = null;     // Catch: Throwable -> L13
        r11 = r11 - 1;     // Catch: Throwable -> L13
        goto L8
    L10:
        f557d = r9;     // Catch: Throwable -> L13
        f558e++;     // Catch: Throwable -> L13
    L11:
        monitor-exit(g.class);     // Catch: Throwable -> L13
        return;
    L17:
        if (r8.length != 4) goto L37;
        monitor-enter(g.class);
    L27:
        th = move-exception;
        throw th;
    L20:
        if (f556c >= 10) goto L25;
        r9[0] = f555b;     // Catch: Throwable -> L27
        r9[1] = r8;     // Catch: Throwable -> L27
        int r12 = (r10 << 1) - 1;     // Catch: Throwable -> L27
    L22:
        if (r12 < 2) goto L24;
        r9[r12] = null;     // Catch: Throwable -> L27
        r12 = r12 - 1;     // Catch: Throwable -> L27
        goto L22
    L24:
        f555b = r9;     // Catch: Throwable -> L27
        f556c++;     // Catch: Throwable -> L27
    L25:
        monitor-exit(g.class);     // Catch: Throwable -> L27
        return;
    }

    public g() {
        this.f = c.f527a;
        this.g = c.f529c;
        this.h = 0;
    }

    public g(int r1) {
        if (r1 != 0) goto L5;
        this.f = c.f527a;
        this.g = c.f529c;
    L6:
        this.h = 0;
        return;
    L5:
        e(r1);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> r1) {
        this();
        if (r1 == 0) goto L6;
        a(r1);
        return;
    }

    public void clear() {
        int r0 = this.h;
        if (r0 <= 0) goto L6;
        int[] r1 = this.f;
        Object[] r2 = this.g;
        this.f = c.f527a;
        this.g = c.f529c;
        this.h = 0;
        a(r1, r2, r0);
    L6:
        if (this.h > 0) goto L9;
        return;
    L9:
        throw new ConcurrentModificationException();
    }

    public void a(int r6) {
        int r0 = this.h;
        int[] r1 = this.f;
        if (r1.length >= r6) goto L9;
        Object[] r2 = this.g;
        e(r6);
        if (this.h <= 0) goto L7;
        System.arraycopy(r1, 0, this.f, 0, r0);
        System.arraycopy(r2, 0, this.g, 0, r0 << 1);
    L7:
        a(r1, r2, r0);
    L9:
        if (this.h != r0) goto L12;
        return;
    L12:
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object r1) {
        if (a(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int a(Object r2) {
        if (r2 != null) goto L5;
        return a();
    L5:
        return a(r2, r2.hashCode());
    }

    int b(Object r5) {
        int r0 = this.h * 2;
        Object[] r4 = this.g;
        if (r5 != null) goto L11;
        int r6 = 1;
    L5:
        if (r6 >= r0) goto L18;
        if (r4[r6] == null) goto L9;
        r6 = r6 + 2;
        goto L5
    L9:
        return r6 >> 1;
    L18:
        return -1;
    L11:
        int r2 = 1;
    L12:
        if (r2 >= r0) goto L24;
        if (r5.equals(r4[r2]) == true) goto L16;
        r2 = r2 + 2;
        goto L12
    L16:
        return r2 >> 1;
    L24:
        return -1;
    }

    public boolean containsValue(Object r1) {
        if (b(r1) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public V get(Object r2) {
        return getOrDefault(r2, null);
    }

    public V getOrDefault(Object r1, V r2) {
        int r3 = a(r1);
        if (r3 >= 0) goto L5;
        return r2;
    L5:
        return (V) this.g[(r3 << 1) + 1];
    }

    public K b(int r1) {
        return (K) this.g[r1 << 1];
    }

    public V c(int r1) {
        return (V) this.g[(r1 << 1) + 1];
    }

    public V a(int r2, V r3) {
        int r4 = (r2 << 1) + 1;
        Object[] r1 = this.g;
        V r0 = (V) r1[r4];
        r1[r4] = r3;
        return r0;
    }

    public boolean isEmpty() {
        if (this.h > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public V put(K r10, V r11) {
        int r0 = this.h;
        if (r10 != null) goto L5;
        int r2 = a();
        int r3 = 0;
    L6:
        if (r2 < 0) goto L9;
        int r12 = (r2 << 1) + 1;
        Object[] r9 = this.g;
        V r1 = (V) r9[r12];
        r9[r12] = r11;
        return r1;
    L9:
        int r4 = ~r2;
        int[] r5 = this.f;
        if (r0 < r5.length) goto L24;
        int r6 = 4;
        if (r0 < 8) goto L14;
        r6 = (r0 >> 1) + r0;
    L16:
        Object[] r7 = this.g;
        e(r6);
        if (r0 != this.h) goto L23;
        int[] r8 = this.f;
        if (r8.length <= 0) goto L21;
        System.arraycopy(r5, 0, r8, 0, r5.length);
        System.arraycopy(r7, 0, this.g, 0, r7.length);
    L21:
        a(r5, r7, r0);
        goto L24
    L23:
        throw new ConcurrentModificationException();
    L14:
        if (r0 < 4) goto L16;
        r6 = 8;
    L24:
        if (r4 >= r0) goto L26;
        int[] r13 = this.f;
        int r14 = r4 + 1;
        System.arraycopy(r13, r4, r13, r14, r0 - r4);
        Object[] r15 = this.g;
        System.arraycopy(r15, r4 << 1, r15, r14 << 1, (this.h - r4) << 1);
    L26:
        int r16 = this.h;
        if (r0 != r16) goto L33;
        int[] r17 = this.f;
        if (r4 >= r17.length) goto L33;
        r17[r4] = r3;
        Object[] r18 = this.g;
        int r19 = r4 << 1;
        r18[r19] = r10;
        r18[r19 + 1] = r11;
        this.h = r16 + 1;
        return null;
    L33:
        throw new ConcurrentModificationException();
    L5:
        int r20 = r10.hashCode();
        r3 = r20;
        r2 = a(r10, r20);
        goto L6
    }

    public void a(g<? extends K, ? extends V> r5) {
        int r0 = r5.h;
        a(this.h + r0);
        int r2 = 0;
        if (this.h != 0) goto L6;
        if (r0 <= 0) goto L8;
        System.arraycopy(r5.f, 0, this.f, 0, r0);
        System.arraycopy(r5.g, 0, this.g, 0, r0 << 1);
        this.h = r0;
        return;
    L8:
        return;
    L6:
        if (r2 >= r0) goto L11;
        put(r5.b(r2), r5.c(r2));
        r2 = r2 + 1;
        goto L6
    }

    public V putIfAbsent(K r2, V r3) {
        V r0 = get(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return put(r2, r3);
    }

    public V remove(Object r1) {
        int r2 = a(r1);
        if (r2 >= 0) goto L5;
        return null;
    L5:
        return d(r2);
    }

    public boolean remove(Object r2, Object r3) {
        int r4 = a(r2);
        if (r4 < 0) goto L11;
        V r0 = c(r4);
        if (r3 == r0) goto L9;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.equals(r0) == true) goto L9;
        return false;
    L9:
        d(r4);
        return true;
    L11:
        return false;
    }

    public V d(int r11) {
        Object[] r0 = this.g;
        int r1 = r11 << 1;
        V r2 = (V) r0[r1 + 1];
        int r3 = this.h;
        int r4 = 0;
        if (r3 > 1) goto L5;
        a(this.f, r0, r3);
        this.f = c.f527a;
        this.g = c.f529c;
    L24:
        if (r3 != this.h) goto L28;
        this.h = r4;
        return r2;
    L28:
        throw new ConcurrentModificationException();
    L5:
        int r6 = r3 - 1;
        int[] r7 = this.f;
        int r9 = 8;
        if (r7.length > 8) goto L8;
    L19:
        if (r11 >= r6) goto L21;
        int r5 = r11 + 1;
        int r8 = r6 - r11;
        System.arraycopy(r7, r5, r7, r11, r8);
        Object[] r12 = this.g;
        System.arraycopy(r12, r5 << 1, r12, r1, r8 << 1);
    L21:
        Object[] r13 = this.g;
        int r10 = r6 << 1;
        r13[r10] = null;
        r13[r10 + 1] = null;
    L22:
        r4 = r6;
        goto L24
    L8:
        if (r3 >= (r7.length / 3)) goto L19;
        if (r3 <= 8) goto L11;
        r9 = r3 + (r3 >> 1);
    L11:
        e(r9);
        if (r3 != this.h) goto L18;
        if (r11 <= 0) goto L15;
        System.arraycopy(r7, 0, this.f, 0, r11);
        System.arraycopy(r0, 0, this.g, 0, r1);
    L15:
        if (r11 >= r6) goto L22;
        int r14 = r11 + 1;
        int r15 = r6 - r11;
        System.arraycopy(r7, r14, this.f, r11, r15);
        System.arraycopy(r0, r14 << 1, this.g, r1, r15 << 1);
        goto L22
    L18:
        throw new ConcurrentModificationException();
    }

    public V replace(K r1, V r2) {
        int r3 = a(r1);
        if (r3 >= 0) goto L5;
        return null;
    L5:
        return a(r3, r2);
    }

    public boolean replace(K r2, V r3, V r4) {
        int r5 = a(r2);
        if (r5 < 0) goto L11;
        V r0 = c(r5);
        if (r0 == r3) goto L9;
        if (r3 != null) goto L8;
        return false;
    L8:
        if (r3.equals(r0) == true) goto L9;
        return false;
    L9:
        a(r5, r4);
        return true;
    L11:
        return false;
    }

    public int size() {
        return this.h;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, g.class) == false) goto L26;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r7, g.class, "com.obric.aiagent.plugin");
        if (size() == r8.size()) goto L10;
        return false;
    L10:
        int r0 = 0;
    L46:
        if (r0 >= this.h) goto L23;
        K r2 = b(r0);     // Catch: Throwable -> L24
        V r3 = c(r0);     // Catch: Throwable -> L24
        Object r5 = r8.get(r2);     // Catch: Throwable -> L24
        if (r3 != null) goto L20;
        if (r5 != null) goto L18;
        if (r8.containsKey(r2) == false) goto L18;
    L22:
        r0 = r0 + 1;
    L18:
        return false;
    L20:
        if (r3.equals(r5) == true) goto L22;
        return false;
    L23:
        return true;
    L24:
        return false;
    L26:
        if (ZeusTransformUtils.instanceOf(r7, Map.class) == false) goto L44;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.aiagent.plugin");
        if (size() == r9.size()) goto L30;
        return false;
    L30:
        int r1 = 0;
    L48:
        if (r1 >= this.h) goto L43;
        K r4 = b(r1);     // Catch: Throwable -> L45
        V r6 = c(r1);     // Catch: Throwable -> L45
        Object r10 = r9.get(r4);     // Catch: Throwable -> L45
        if (r6 != null) goto L40;
        if (r10 != null) goto L38;
        if (r9.containsKey(r4) == false) goto L38;
    L42:
        r1 = r1 + 1;
    L38:
        return false;
    L40:
        if (r6.equals(r10) == true) goto L42;
        return false;
    L43:
        return true;
    L44:
        return false;
    }

    public int hashCode() {
        int[] r0 = this.f;
        Object[] r1 = this.g;
        int r8 = this.h;
        int r2 = 1;
        int r4 = 0;
        int r5 = 0;
    L3:
        if (r4 >= r8) goto L9;
        Object r6 = r1[r2];
        int r7 = r0[r4];
        if (r6 != null) goto L7;
        int r9 = 0;
    L8:
        r5 = r5 + (r9 ^ r7);
        r4 = r4 + 1;
        r2 = r2 + 2;
        goto L3
    L7:
        r9 = r6.hashCode();
        goto L8
    L9:
        return r5;
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "{}";
    L6:
        StringBuilder r0 = new StringBuilder(this.h * 28);
        r0.append('{');
        int r1 = 0;
    L8:
        if (r1 >= this.h) goto L20;
        if (r1 <= 0) goto L11;
        r0.append(", ");
    L11:
        K r2 = b(r1);
        if (r2 == this) goto L14;
        r0.append(r2);
    L15:
        r0.append('=');
        V r3 = c(r1);
        if (r3 == this) goto L18;
        r0.append(r3);
    L19:
        r1 = r1 + 1;
        goto L8
    L18:
        r0.append("(this Map)");
        goto L19
    L14:
        r0.append("(this Map)");
        goto L15
    L20:
        r0.append('}');
        return r0.toString();
    }
}
