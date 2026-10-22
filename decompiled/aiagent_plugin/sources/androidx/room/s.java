package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: RoomSQLiteQuery.java */
/* JADX INFO: loaded from: classes.dex */
public class s implements androidx.sqlite.db.e, androidx.sqlite.db.f {
    static final TreeMap<Integer, s> g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long[] f2690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final double[] f2691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String[] f2692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final byte[][] f2693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f2694e;
    int f;
    private volatile String h;
    private final int[] i;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    static {
        g = new TreeMap();
    }

    public static s a(String r4, int r5) {
        TreeMap<Integer, s> r0 = g;
        monitor-enter(r0);
        Map.Entry<Integer, s> r1 = r0.ceilingEntry(Integer.valueOf(r5));     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r0.remove(r1.getKey());     // Catch: Throwable -> L12
        s r2 = (s) ZeusTransformUtils.preCheckCast(r1.getValue(), s.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        r2.b(r4, r5);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        s r3 = new s(r5);
        r3.b(r4, r5);
        return r3;
    L12:
        th = move-exception;
        throw th;
    }

    private s(int r2) {
        this.f2694e = r2;
        int r3 = r2 + 1;
        this.i = new int[r3];
        this.f2690a = new long[r3];
        this.f2691b = new double[r3];
        this.f2692c = new String[r3];
        this.f2693d = new byte[r3][];
    }

    void b(String r1, int r2) {
        this.h = r1;
        this.f = r2;
    }

    public void a() {
        TreeMap<Integer, s> r0 = g;
        monitor-enter(r0);
        r0.put(Integer.valueOf(this.f2694e), this);     // Catch: Throwable -> L7
        c();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void c() {
        TreeMap<Integer, s> r0 = g;
        if (r0.size() <= 15) goto L8;
        int r1 = r0.size() - 10;
        Iterator<Integer> r2 = r0.descendingKeySet().iterator();
    L5:
        int r3 = r1 - 1;
        if (r1 <= 0) goto L10;
        r2.next();
        r2.remove();
        r1 = r3;
        goto L5
    L10:
        return;
    }

    @Override // androidx.sqlite.db.f
    public String b() {
        return this.h;
    }

    @Override // androidx.sqlite.db.f
    public void a(androidx.sqlite.db.e r5) {
        androidx.sqlite.db.e r6 = (androidx.sqlite.db.e) ZeusTransformUtils.wrapperContextForParams(r5, androidx.sqlite.db.e.class, "com.obric.aiagent.plugin");
        int r1 = 1;
    L4:
        if (r1 > this.f) goto L22;
        int r2 = this.i[r1];
        if (r2 != 1) goto L8;
        r6.a(r1);
    L21:
        r1 = r1 + 1;
        goto L4
    L8:
        if (r2 != 2) goto L10;
        r6.a(r1, this.f2690a[r1]);
        goto L21
    L10:
        if (r2 != 3) goto L12;
        r6.a(r1, this.f2691b[r1]);
        goto L21
    L12:
        if (r2 != 4) goto L14;
        r6.a(r1, this.f2692c[r1]);
        goto L21
    L14:
        if (r2 != 5) goto L21;
        r6.a(r1, this.f2693d[r1]);
        goto L21
    }

    @Override // androidx.sqlite.db.e
    public void a(int r2) {
        this.i[r2] = 1;
    }

    @Override // androidx.sqlite.db.e
    public void a(int r3, long r4) {
        this.i[r3] = 2;
        this.f2690a[r3] = r4;
    }

    @Override // androidx.sqlite.db.e
    public void a(int r3, double r4) {
        this.i[r3] = 3;
        this.f2691b[r3] = r4;
    }

    @Override // androidx.sqlite.db.e
    public void a(int r3, String r4) {
        this.i[r3] = 4;
        this.f2692c[r3] = r4;
    }

    @Override // androidx.sqlite.db.e
    public void a(int r3, byte[] r4) {
        this.i[r3] = 5;
        this.f2693d[r3] = r4;
    }
}
