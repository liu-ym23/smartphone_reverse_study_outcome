package p2;

import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f23315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f23316b;

    public class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f23317a;

        public a(c r10) {
            this.f23317a = r10;
        }

        @Override // java.io.FileFilter
        public boolean accept(File r10) {
            String r11 = r10.getName();     // Catch: Throwable -> L13
            int r12 = r11.lastIndexOf(".bin");     // Catch: Throwable -> L13
            if (r12 == (-1)) goto L9;
            if ((System.currentTimeMillis() - d.b(Long.parseLong(r11.substring(0, r12)))) >= 604800000) goto L9;
        L12:
            return false;
        L9:
            if (r3.a.c() == false) goto L11;
            s3.a.a(n2.a.f22354a, "deleteExpireHeader:" + r10.getName());
        L11:
            r3.c.a(r10);
            goto L12
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f23318a = null;

        static {
            f23318a = new c();
        }

        public static /* synthetic */ c a() {
            return f23318a;
        }
    }

    public c() {
    }

    public static c d() {
        return b.a();
    }

    public void a() {
        e();
        File r10 = this.f23316b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.listFiles(new a(this));
    }

    public final String b(String r10) {
        return r10 + ".bin";
    }

    public p2.a c(String r10) {
        e();
        if (this.f23316b != null) goto L5;
        return null;
    L5:
        byte[] r11 = r3.c.e(new File(this.f23316b, b(r10)));
        if (r11 != null) goto L8;
        return null;
    L8:
        return d.a(r11);
    }

    public final synchronized void e() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f23315a == false) goto L19;
        monitor-exit(this);
        return;
    L19:
        File r10 = new File(n2.b.f(), "header");     // Catch: Throwable -> L11
        this.f23316b = r10;     // Catch: Throwable -> L11
        if (r10.exists() == true) goto L13;
        this.f23316b.mkdirs();     // Catch: Throwable -> L11
    L13:
        this.f23315a = true;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        s3.a.b("APM", "header store init error " + th.toString());     // Catch: Throwable -> L16
        goto L13
    }

    public void f(String r10, p2.a r11) {
        e();
        if (this.f23316b != null) goto L5;
        return;
    L5:
        JSONObject r12 = d.d(r11);
        if (r12 != null) goto L8;
        return;
    L8:
        File r13 = new File(this.f23316b, b(r10));
        FileChannel r14 = null;
        r14 = new FileOutputStream(r13).getChannel();     // Catch: Throwable -> L11
        r14.write(ByteBuffer.wrap(r12.toString().getBytes()));     // Catch: Throwable -> L11
    L10:
        r3.d.a(r14);
        return;
    L11:
        th = move-exception;
        Log.e("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r3.d.a(r14);
        throw th;
    }
}
