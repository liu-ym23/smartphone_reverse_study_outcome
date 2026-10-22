package okhttp3.internal.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Http2Writer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40069a = null;
    private static final Logger h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.f f40070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f40071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.e f40072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f40073e;
    private boolean f;
    private final d.b g;

    /* JADX INFO: compiled from: Http2Writer.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public j(e.f r8, boolean r9) {
        e.f r10 = (e.f) ZeusTransformUtils.wrapperContextForParams(r8, e.f.class, "com.obric.aiagent.plugin");
        o.e(r10, "sink");
        this.f40070b = r10;
        this.f40071c = r9;
        e.e r4 = new e.e();
        this.f40072d = r4;
        this.f40073e = 16384;
        this.g = new d.b(0, false, r4, 3, null);
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f == true) goto L16;
        if (this.f40071c == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        Logger r0 = h;     // Catch: Throwable -> L17
        if (r0.isLoggable(Level.FINE) == false) goto L12;
        r0.fine(okhttp3.internal.c.a(">> CONNECTION " + e.f39987b.i(), new Object[0]));     // Catch: Throwable -> L17
    L12:
        this.f40070b.c(e.f39987b);     // Catch: Throwable -> L17
        this.f40070b.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    public final synchronized void a(m r3) {
        monitor-enter(this);
        o.e(r3, "peerSettings");     // Catch: Throwable -> L13
        if (this.f == true) goto L12;
        this.f40073e = r3.c(this.f40073e);     // Catch: Throwable -> L13
        if (r3.a() == (-1)) goto L8;
        this.g.a(r3.a());     // Catch: Throwable -> L13
    L8:
        a(0, 0, 4, 1);     // Catch: Throwable -> L13
        this.f40070b.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(int r8, int r9, List<c> r10) {
        monitor-enter(this);
        List<c> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        o.e(r11, "requestHeaders");     // Catch: Throwable -> L16
        if (this.f == true) goto L15;
        this.g.a(r11);     // Catch: Throwable -> L16
        long r0 = this.f40072d.b();     // Catch: Throwable -> L16
        int r12 = (int) Math.min(((long) this.f40073e) - 4, r0);     // Catch: Throwable -> L16
        int r2 = r12 + 4;     // Catch: Throwable -> L16
        long r4 = r12;
        if (r0 != r4) goto L8;
        int r6 = 4;
    L9:
        a(r8, r2, 5, r6);     // Catch: Throwable -> L16
        this.f40070b.j(r9 & Integer.MAX_VALUE);     // Catch: Throwable -> L16
        this.f40070b.a_(this.f40072d, r4);     // Catch: Throwable -> L16
        if (r0 <= r4) goto L12;
        b(r8, r0 - r4);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r6 = 0;
        goto L9
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f == true) goto L9;
        this.f40070b.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public final synchronized void a(int r4, b r5) {
        monitor-enter(this);
        o.e(r5, "errorCode");     // Catch: Throwable -> L17
        if (this.f == true) goto L16;
        if (r5.a() == (-1)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L14;
        a(r4, 4, 3, 0);     // Catch: Throwable -> L17
        this.f40070b.j(r5.a());     // Catch: Throwable -> L17
        this.f40070b.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L17
    L8:
        r0 = false;
        goto L9
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final int c() {
        return this.f40073e;
    }

    public final synchronized void a(boolean r2, int r3, e.e r4, int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f == true) goto L12;
        int r0 = 0;
        if (r2 == false) goto L8;
        r0 = 1;
    L8:
        a(r3, r0, r4, r5);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    public final void a(int r2, int r3, e.e r4, int r5) {
        a(r2, r5, 0, r3);
        if (r5 <= 0) goto L6;
        e.f r1 = this.f40070b;
        o.a(r4);
        r1.a_(r4, r5);
        return;
    }

    public final synchronized void b(m r5) {
        monitor-enter(this);
        o.e(r5, "settings");     // Catch: Throwable -> L23
        if (this.f == true) goto L22;
        int r2 = 0;
        a(0, r5.c() * 6, 4, 0);     // Catch: Throwable -> L23
    L7:
        if (r2 >= 10) goto L18;
        if (r5.a(r2) == false) goto L17;
        if (r2 != 4) goto L12;
        int r0 = 3;
    L16:
        this.f40070b.i(r0);     // Catch: Throwable -> L23
        this.f40070b.j(r5.b(r2));     // Catch: Throwable -> L23
        goto L17
    L12:
        if (r2 == 7) goto L14;
        r0 = r2;
        goto L16
    L14:
        r0 = 4;
    L17:
        r2 = r2 + 1;     // Catch: Throwable -> L23
        goto L7
    L18:
        this.f40070b.flush();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L22:
        throw new IOException("closed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(boolean r4, int r5, int r6) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f == true) goto L13;
        if (r4 == false) goto L8;
        int r7 = 1;
    L9:
        a(0, 8, 6, r7);     // Catch: Throwable -> L14
        this.f40070b.j(r5);     // Catch: Throwable -> L14
        this.f40070b.j(r6);     // Catch: Throwable -> L14
        this.f40070b.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r7 = 0;
        goto L9
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public final synchronized void a(int r5, b r6, byte[] r7) {
        monitor-enter(this);
        o.e(r6, "errorCode");     // Catch: Throwable -> L23
        o.e(r7, "debugData");     // Catch: Throwable -> L23
        if (this.f == true) goto L22;
        boolean r3 = false;
        if (r6.a() == (-1)) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L20;
        a(0, r7.length + 8, 7, 0);     // Catch: Throwable -> L23
        this.f40070b.j(r5);     // Catch: Throwable -> L23
        this.f40070b.j(r6.a());     // Catch: Throwable -> L23
        if (r7.length != 0) goto L14;
        r3 = true;
    L14:
        if ((!r3) == false) goto L16;
        this.f40070b.c(r7);     // Catch: Throwable -> L23
    L16:
        this.f40070b.flush();     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L20:
        throw new IllegalArgumentException("errorCode.httpCode == -1".toString());     // Catch: Throwable -> L23
    L8:
        r0 = false;
        goto L9
    L22:
        throw new IOException("closed");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(int r5, long r6) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f == true) goto L18;
        if (r6 != 0) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L16;
        a(r5, 4, 8, 0);     // Catch: Throwable -> L19
        this.f40070b.j((int) r6);     // Catch: Throwable -> L19
        this.f40070b.flush();     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L16:
        throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + r6).toString());     // Catch: Throwable -> L19
    L8:
        if (r6 > 2147483647L) goto L10;
        r0 = true;
        goto L11
    L18:
        throw new IOException("closed");     // Catch: Throwable -> L19
    }

    public final void a(int r9, int r10, int r11, int r12) {
        Logger r0 = h;
        if (r0.isLoggable(Level.FINE) == false) goto L5;
        r0.fine(e.f39986a.a(false, r9, r10, r11, r12));
    L5:
        boolean r1 = true;
        if (r10 > this.f40073e) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        if ((Integer.MIN_VALUE & r9) == 0) goto L14;
        r1 = false;
    L14:
        if (r1 == false) goto L18;
        okhttp3.internal.c.a(this.f40070b, r10);
        this.f40070b.h(r11 & 255);
        this.f40070b.h(r12 & 255);
        this.f40070b.j(r9 & Integer.MAX_VALUE);
        return;
    L18:
        throw new IllegalArgumentException(("reserved bit set: " + r9).toString());
    L20:
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.f40073e + ": " + r10).toString());
    L8:
        r2 = false;
        goto L9
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.f = true;     // Catch: Throwable -> L7
        this.f40070b.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void b(int r7, long r8) {
    L3:
        if (r8 <= 0) goto L9;
        long r2 = Math.min(this.f40073e, r8);
        r8 = r8 - r2;
        int r4 = (int) r2;
        if (r8 != 0) goto L7;
        int r0 = 4;
    L8:
        a(r7, r4, 9, r0);
        this.f40070b.a_(this.f40072d, r2);
        goto L3
    L7:
        r0 = 0;
        goto L8
    }

    public final synchronized void a(boolean r7, int r8, List<c> r9) {
        monitor-enter(this);
        List<c> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        o.e(r10, "headerBlock");     // Catch: Throwable -> L18
        if (this.f == true) goto L17;
        this.g.a(r10);     // Catch: Throwable -> L18
        long r0 = this.f40072d.b();     // Catch: Throwable -> L18
        long r2 = Math.min(this.f40073e, r0);     // Catch: Throwable -> L18
        if (r0 != r2) goto L8;
        int r4 = 4;
    L9:
        if (r7 == false) goto L11;
        r4 = r4 | 1;     // Catch: Throwable -> L18
    L11:
        a(r8, (int) r2, 1, r4);     // Catch: Throwable -> L18
        this.f40070b.a_(this.f40072d, r2);     // Catch: Throwable -> L18
        if (r0 <= r2) goto L14;
        b(r8, r0 - r2);     // Catch: Throwable -> L18
    L14:
        monitor-exit(this);
        return;
    L8:
        r4 = 0;
        goto L9
    L17:
        throw new IOException("closed");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    static {
        f40069a = new a(null);
        h = Logger.getLogger(e.class.getName());
    }
}
