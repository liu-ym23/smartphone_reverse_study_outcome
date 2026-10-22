package r9;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes3.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p9.a f23813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Socket f23814b;

    public e(Socket r10, p9.a r11) {
        this.f23813a = r11;
        this.f23814b = r10;
    }

    @Override // java.lang.Runnable
    public void run() {
        OutputStream r10 = null;
        InputStream r11 = null;
        r11 = null;
        r10 = null;
        OutputStream r12 = this.f23814b.getOutputStream();     // Catch: Throwable -> L15 Exception -> L17
    L29:
        r11 = this.f23814b.getInputStream();     // Catch: Throwable -> L9 Exception -> L11
        c r13 = new c(r11, this.f23814b.getInetAddress());     // Catch: Throwable -> L9 Exception -> L11
    L6:
        if (this.f23814b.isClosed() == true) goto L13;
        r13.h();     // Catch: Throwable -> L9 Exception -> L11
        new d(r13, this.f23813a).e(r12);     // Catch: Throwable -> L9 Exception -> L11
    L13:
        u9.d.b(r12);
        u9.d.b(r11);
    L14:
        u9.d.b(this.f23814b);
        return;
    L11:
        e = e;
        InputStream r14 = r11;
        r10 = r12;
    L25:
        o0.a.d("socket request failed, exception=" + e);     // Catch: Throwable -> L22
        u9.d.b(r10);
        u9.d.b(r14);
    L22:
        th = th;
    L23:
        u9.d.b(r10);
        u9.d.b(r14);
        u9.d.b(this.f23814b);
        throw th;
    L9:
        th = th;
        r14 = r11;
        r10 = r12;
    L17:
        e = e;
        r14 = null;
    L15:
        th = th;
        r14 = null;
        goto L23
    }
}
