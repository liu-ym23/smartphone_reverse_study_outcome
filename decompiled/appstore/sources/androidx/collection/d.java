package androidx.collection;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1218e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1219f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1220g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1221h;

    public d(int r10) {
        if (r10 <= 0) goto L7;
        this.f1216c = r10;
        this.f1214a = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public Object a(Object r10) {
        return null;
    }

    public void b(boolean r10, Object r11, Object r12, Object r13) {
    }

    public final Object c(Object r10) {
        if (r10 == null) goto L35;
        monitor-enter(this);
        Object r11 = this.f1214a.get(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L11;
        this.f1220g++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r11;
    L11:
        this.f1221h++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        Object r12 = a(r10);
        if (r12 != null) goto L17;
        return null;
    L17:
        monitor-enter(this);
        this.f1218e++;     // Catch: Throwable -> L21
        Object r13 = this.f1214a.put(r10, r12);     // Catch: Throwable -> L21
        if (r13 == null) goto L23;
        this.f1214a.put(r10, r13);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L21
        if (r13 == null) goto L28;
        b(false, r10, r12, r13);
        return r13;
    L28:
        g(this.f1216c);
        return r12;
    L23:
        this.f1215b += e(r10, r12);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    L35:
        throw new NullPointerException("key == null");
    }

    public final Object d(Object r10, Object r11) {
        if (r10 == null) goto L18;
        if (r11 == null) goto L18;
        monitor-enter(this);
        this.f1217d++;     // Catch: Throwable -> L8
        this.f1215b += e(r10, r11);     // Catch: Throwable -> L8
        Object r12 = this.f1214a.put(r10, r11);     // Catch: Throwable -> L8
        if (r12 == null) goto L10;
        this.f1215b -= e(r10, r12);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r12 == null) goto L13;
        b(false, r10, r12, r11);
    L13:
        g(this.f1216c);
        return r12;
    L8:
        th = move-exception;
        throw th;
    L18:
        throw new NullPointerException("key == null || value == null");
    }

    public final int e(Object r10, Object r11) {
        int r12 = f(r10, r11);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Negative size: " + r10 + "=" + r11);
    }

    public int f(Object r10, Object r11) {
        return 1;
    }

    public void g(int r10) {
    L2:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f1215b < 0) goto L23;
        if (this.f1214a.isEmpty() == false) goto L13;
        if (this.f1215b != 0) goto L23;
    L13:
        if (this.f1215b <= r10) goto L20;
        if (this.f1214a.isEmpty() == true) goto L20;
        Map.Entry r11 = (Map.Entry) this.f1214a.entrySet().iterator().next();     // Catch: Throwable -> L10
        Object r12 = r11.getKey();     // Catch: Throwable -> L10
        Object r13 = r11.getValue();     // Catch: Throwable -> L10
        this.f1214a.remove(r12);     // Catch: Throwable -> L10
        this.f1215b -= e(r12, r13);     // Catch: Throwable -> L10
        this.f1219f++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        b(true, r12, r13, null);
    L20:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L23:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L10
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r10 = this.f1220g;     // Catch: Throwable -> L6
        int r11 = this.f1221h + r10;     // Catch: Throwable -> L6
        if (r11 == 0) goto L8;
        int r12 = (r10 * 100) / r11;     // Catch: Throwable -> L6
    L9:
        String r13 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f1216c), Integer.valueOf(this.f1220g), Integer.valueOf(this.f1221h), Integer.valueOf(r12)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L8:
        r12 = 0;
    L6:
        th = move-exception;
        throw th;
    }
}
