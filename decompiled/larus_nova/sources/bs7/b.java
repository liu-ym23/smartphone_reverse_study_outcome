package bs7;

import android.text.TextUtils;
import com.danikula.videocache.ProxyCacheException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f20272a;

    public b(e r100) {
        this.f20272a = r100;
    }

    public final void a(a r110, Socket r111) throws IOException, ProxyCacheException {
        BufferedOutputStream r100 = new BufferedOutputStream(r111.getOutputStream());
        e r112 = this.f20272a;
        monitor-enter(r112);
    L48:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r112.f20284b.f20294c) == false) goto L7;
        r112.b();     // Catch: Throwable -> L48
    L7:
        String r101 = r112.f20284b.f20294c;     // Catch: Throwable -> L48
        monitor-exit(r112);
        boolean r113 = !TextUtils.isEmpty(r101);
        long r102 = this.f20272a.c();
        if (r102 < 0) goto L12;
        boolean r103 = true;
    L13:
        boolean r104 = r110.f20269c;
        if (r104 == false) goto L16;
        long r105 = r102 - r110.f20268b;
    L17:
        if (r103 == false) goto L20;
        if (r104 == false) goto L20;
        boolean r106 = true;
    L21:
        StringBuilder r114 = new StringBuilder();
        if (r110.f20269c == false) goto L24;
        String r115 = "HTTP/1.1 206 PARTIAL CONTENT\n";
    L25:
        r114.append(r115);
        r114.append("Accept-Ranges: bytes\n");
        if (r103 == false) goto L28;
        String r107 = String.format(Locale.US, "Content-Length: %d\n", new Object[]{Long.valueOf(r105)});
    L29:
        r114.append(r107);
        if (r106 == false) goto L32;
        String r108 = String.format(Locale.US, "Content-Range: bytes %d-%d/%d\n", new Object[]{Long.valueOf(r110.f20268b), Long.valueOf(r102 - 1), Long.valueOf(r102)});
    L33:
        r114.append(r108);
        if (r113 == false) goto L36;
        String r116 = String.format(Locale.US, "Content-Type: %s\n", new Object[]{r101});
    L37:
        r114.append(r116);
        r114.append("\n");
        r100.write(r114.toString().getBytes("UTF-8"));
        long r117 = r110.f20268b;
        e r109 = new e(this.f20272a);
        r109.d((int) r117);     // Catch: Throwable -> L45
        byte[] r118 = new byte[8192];     // Catch: Throwable -> L45
    L39:
        int r119 = r109.f(r118);     // Catch: Throwable -> L45
        if (r119 == (-1)) goto L42;
        r100.write(r118, 0, r119);     // Catch: Throwable -> L45
        goto L39
    L42:
        r100.flush();     // Catch: Throwable -> L45
        r109.a();
        return;
    L45:
        th = move-exception;
        r109.a();
        throw th;
    L36:
        r116 = "";
        goto L37
    L32:
        r108 = "";
        goto L33
    L28:
        r107 = "";
        goto L29
    L24:
        r115 = "HTTP/1.1 200 OK\n";
    L20:
        r106 = false;
        goto L21
    L16:
        r105 = r102;
        goto L17
    L12:
        r103 = false;
        goto L13
    }
}
