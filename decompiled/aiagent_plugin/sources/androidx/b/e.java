package androidx.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f539e;
    private int f;
    private int g;
    private int h;

    public void a(boolean r1, K r2, V r3, V r4) {
    }

    public int b(K r1, V r2) {
        return 1;
    }

    public V c(K r1) {
        return null;
    }

    public e(int r4) {
        if (r4 <= 0) goto L7;
        this.f537c = r4;
        this.f535a = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V a(K r5) {
        Objects.requireNonNull(r5, "key == null");
        monitor-enter(this);
        V r0 = this.f535a.get(r5);     // Catch: Throwable -> L29
        if (r0 == null) goto L9;
        this.g++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return r0;
    L9:
        this.h++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        V r1 = c(r5);
        if (r1 != null) goto L15;
        return null;
    L15:
        monitor-enter(this);
        this.f539e++;     // Catch: Throwable -> L26
        V r2 = this.f535a.put(r5, r1);     // Catch: Throwable -> L26
        if (r2 == null) goto L19;
        this.f535a.put(r5, r2);     // Catch: Throwable -> L26
    L20:
        monitor-exit(this);     // Catch: Throwable -> L26
        if (r2 == null) goto L24;
        a(false, r5, r1, r2);
        return r2;
    L24:
        a(this.f537c);
        return r1;
    L19:
        this.f536b += c(r5, r1);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public final V a(K r4, V r5) {
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        monitor-enter(this);
        this.f538d++;     // Catch: Throwable -> L13
        this.f536b += c(r4, r5);     // Catch: Throwable -> L13
        V r0 = this.f535a.put(r4, r5);     // Catch: Throwable -> L13
        if (r0 == null) goto L8;
        this.f536b -= c(r4, r0);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        a(false, r4, r0, r5);
    L11:
        a(this.f537c);
        return r0;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(int r5) {
    L2:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f536b < 0) goto L20;
        if (this.f535a.isEmpty() == false) goto L10;
        if (this.f536b != 0) goto L20;
    L10:
        if (this.f536b <= r5) goto L17;
        if (this.f535a.isEmpty() == true) goto L17;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f535a.entrySet().iterator().next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Object r1 = r0.getKey();     // Catch: Throwable -> L21
        Object r2 = r0.getValue();     // Catch: Throwable -> L21
        this.f535a.remove(r1);     // Catch: Throwable -> L21
        this.f536b -= c(r1, r2);     // Catch: Throwable -> L21
        this.f++;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        a(true, r1, r2, null);
    L17:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L20:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L21
    }

    public final V b(K r4) {
        Objects.requireNonNull(r4, "key == null");
        monitor-enter(this);
        V r0 = this.f535a.remove(r4);     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        this.f536b -= c(r4, r0);     // Catch: Throwable -> L11
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r0 == null) goto L10;
        a(false, r4, r0, null);
    L10:
        return r0;
    L11:
        th = move-exception;
        throw th;
    }

    private int c(K r3, V r4) {
        int r2 = b(r3, r4);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Negative size: " + r3 + "=" + r4);
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r0 = this.g;     // Catch: Throwable -> L10
        int r1 = this.h + r0;     // Catch: Throwable -> L10
        if (r1 == 0) goto L6;
        int r2 = (r0 * 100) / r1;     // Catch: Throwable -> L10
    L7:
        String r3 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f537c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(r2)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L6:
        r2 = 0;
    L10:
        th = move-exception;
        throw th;
    }
}
