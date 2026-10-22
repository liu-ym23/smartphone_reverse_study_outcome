package y1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map f25983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f25984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25989h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25990a = null;

        static {
            f25990a = new b();
        }

        public static /* synthetic */ b a() {
            return f25990a;
        }
    }

    public b() {
        this.f25985d = 50;
        this.f25986e = 20;
        this.f25987f = 50;
        this.f25988g = Math.min(3, 50 / 2);
        this.f25989h = 0;
    }

    public static b d() {
        return a.a();
    }

    public synchronized void a(long r16, String r18, String r19) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f25984c != null) goto L10;
        this.f25984c = new HashMap();     // Catch: Throwable -> L7
    L10:
        if (this.f25984c.containsKey(r18) == false) goto L14;
        g r10 = (g) this.f25984c.get(r18);     // Catch: Throwable -> L7
        r10.f26035d++;     // Catch: Throwable -> L7
        r10.f26036e = System.currentTimeMillis();     // Catch: Throwable -> L7
        int r11 = r10.f26035d;     // Catch: Throwable -> L7
        if (r11 <= this.f25989h) goto L45;
        this.f25989h = r11;     // Catch: Throwable -> L7
    L45:
        monitor-exit(this);
        return;
    L14:
        Map r12 = this.f25983b;     // Catch: Throwable -> L7
        if (r12 == null) goto L44;
        String r13 = null;
        long r14 = Long.MAX_VALUE;
        if (r12.containsKey(r18) == false) goto L34;
        g r15 = (g) this.f25983b.get(r18);     // Catch: Throwable -> L7
        int r17 = r15.f26035d;     // Catch: Throwable -> L7
        r15.f26035d = r17 + 1;     // Catch: Throwable -> L7
        r15.f26036e = System.currentTimeMillis();     // Catch: Throwable -> L7
        if (r17 <= this.f25988g) goto L45;
        this.f25983b.remove(r18);     // Catch: Throwable -> L7
        if (this.f25984c.size() < this.f25986e) goto L32;
        long r20 = this.f25982a + ((System.currentTimeMillis() - this.f25982a) / 2);     // Catch: Throwable -> L7
        Iterator r21 = this.f25984c.entrySet().iterator();     // Catch: Throwable -> L7
    L24:
        if (r21.hasNext() == false) goto L30;
        Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L7
        if (((g) r22.getValue()).f26036e >= r20) goto L24;
        if (((g) r22.getValue()).f26035d >= r14) goto L24;
        long r23 = ((g) r22.getValue()).f26035d;     // Catch: Throwable -> L7
        r13 = ((g) r22.getValue()).f26032a;     // Catch: Throwable -> L7
        r14 = r23;
        goto L24
    L30:
        if (r13 == null) goto L32;
        this.f25984c.remove(r13);     // Catch: Throwable -> L7
    L32:
        this.f25984c.put(r18, r15);     // Catch: Throwable -> L7
        goto L45
    L34:
        if (this.f25983b.size() < this.f25985d) goto L43;
        Iterator r24 = this.f25983b.entrySet().iterator();     // Catch: Throwable -> L7
    L37:
        if (r24.hasNext() == false) goto L41;
        Map.Entry r25 = (Map.Entry) r24.next();     // Catch: Throwable -> L7
        if (((g) r25.getValue()).f26036e >= r14) goto L37;
        long r26 = ((g) r25.getValue()).f26036e;     // Catch: Throwable -> L7
        r13 = ((g) r25.getValue()).f26032a;     // Catch: Throwable -> L7
        r14 = r26;
        goto L37
    L41:
        if (r13 == null) goto L43;
        this.f25983b.remove(r13);     // Catch: Throwable -> L7
    L43:
        this.f25983b.put(r18, new g(r18, r16, r19));     // Catch: Throwable -> L7
        goto L45
    L44:
        HashMap r27 = new HashMap();     // Catch: Throwable -> L7
        this.f25983b = r27;     // Catch: Throwable -> L7
        r27.put(r18, new g(r18, r16, r19));     // Catch: Throwable -> L7
        goto L45
    }

    public void b() {
        this.f25982a = 0;
        this.f25989h = 0;
        Map r10 = this.f25983b;
        if (r10 == null) goto L5;
        r10.clear();
        this.f25983b = null;
    L5:
        Map r11 = this.f25984c;
        if (r11 == null) goto L9;
        r11.clear();
        this.f25984c = null;
        return;
    }

    public synchronized Map c() {
        monitor-enter(this);
        Map r10 = this.f25984c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public int e() {
        return this.f25989h;
    }
}
