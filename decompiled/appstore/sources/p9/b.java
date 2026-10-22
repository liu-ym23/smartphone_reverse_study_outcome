package p9;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f23368a;

    public class a implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f23369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f23370b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f23371c;

        public a(b r10, File r11, long r12) {
            this.f23371c = r10;
            this.f23369a = r11;
            this.f23370b = r12;
        }

        public Void a() {
            u9.d.k(this.f23369a);
            b.a(this.f23371c, this.f23369a.getParentFile(), this.f23370b);
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    static {
    }

    public b() {
    }

    public static /* synthetic */ void a(b r10, File r11, long r12) {
        r10.e(r11, r12);
    }

    public static b c() {
        if (f23368a != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23368a != null) goto L11;
        f23368a = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f23368a;
    }

    public void b(File r10, long r11) {
        u9.c.a(new a(this, r10, r11));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        o0.a.d("VideoDownloadTask checkCacheFile " + r10 + " failed, exception=" + e);
    }

    public final boolean d(long r10, int r11, long r12) {
        if (r11 > 1) goto L6;
        return false;
    L6:
        if (r10 > r12) goto L8;
        return false;
    L8:
        return true;
    }

    public final void e(File r10, long r11) {
        f(u9.e.d(r10), r11);
    }

    public final void f(List r11, long r12) {
        long r10 = u9.e.b(r11);
        int r13 = r11.size();
        Iterator r14 = r11.iterator();
    L4:
        if (r14.hasNext() == false) goto L11;
        File r15 = (File) r14.next();
        if (d(r10, r13, r12) == false) goto L4;
        long r16 = u9.e.a(r15);
        if (u9.e.c(r15) == true) goto L9;
        o0.a.d("trimCacheFile delete file " + r15.getAbsolutePath() + " failed.");
        goto L4
    L9:
        r10 = r10 - r16;
        r13 = r13 - 1;
        o0.a.c("trimCacheFile okay.");
        goto L4
    }
}
