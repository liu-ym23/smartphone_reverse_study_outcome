package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DeviceProfileWriter.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f2240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f2241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a f2242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f2243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f2244e;
    private final String f;
    private final String g;
    private final String h;
    private boolean i;
    private b[] j;
    private byte[] k;

    public static /* synthetic */ void lambda$G4OXpYpyEwHtDrv32oAKPKOdN_0(a r0, int r1, Object r2) {
        r0.b(r1, r2);
    }

    private void a(final int r3, final Object r4) {
        this.f2241b.execute(new $$Lambda$a$G4OXpYpyEwHtDrv32oAKPKOdN_0(this, r3, r4));
    }

    private /* synthetic */ void b(int r1, Object r2) {
        this.f2242c.b(r1, r2);
    }

    public a(AssetManager r3, Executor r4, e.a r5, String r6, String r7, String r8, File r9) {
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin");
        e.a r11 = (e.a) ZeusTransformUtils.wrapperContextForParams(r5, e.a.class, "com.obric.aiagent.plugin");
        this.i = false;
        this.f2240a = r3;
        this.f2241b = r10;
        this.f2242c = r11;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.f2244e = r9;
        this.f2243d = f();
    }

    public boolean a() {
        if (this.f2243d != null) goto L7;
        a(3, Integer.valueOf(Build.VERSION.SDK_INT));
        return false;
    L7:
        if (this.f2244e.canWrite() == true) goto L10;
        a(4, null);
        return false;
    L10:
        this.i = true;
        return true;
    }

    private void e() {
        if (this.i == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    public a b() {
        e();
        if (this.f2243d != null) goto L5;
        return this;
    L5:
        InputStream r0 = a(this.f2240a);
        if (r0 == null) goto L8;
        this.j = a(r0);
    L8:
        b[] r1 = this.j;
        if (r1 != null) goto L11;
    L15:
        return this;
    L11:
        if (g() == false) goto L15;
        a r2 = a(r1, this.f2243d);
        if (r2 == null) goto L15;
        return r2;
    }

    private InputStream a(AssetManager r2, String r3) {
        return r2.openFd(r3).createInputStream();
    L5:
        e = move-exception;
        String r4 = e.getMessage();
        if (r4 != null) goto L9;
        return null;
    L9:
        if (r4.contains("compressed") == false) goto L15;
        this.f2242c.a(5, null);
        return null;
    L15:
        return null;
    }

    private InputStream a(AssetManager r2) {
    L12:
        return a(r2, this.g);
    L6:
        e = move-exception;
        this.f2242c.b(6, e);
    L8:
        return null;
    L4:
        e = move-exception;
        this.f2242c.b(7, e);
        goto L8
    }

    private b[] a(InputStream r5) {
        b[] r1 = f.a(r5, f.a(r5, f.f2257a), this.f);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L14
        r5.close();     // Catch: IOException -> L6
        return r1;
    L6:
        e = move-exception;
        this.f2242c.b(7, e);
        return r1;
    L8:
        th = move-exception;
        r5.close();     // Catch: IOException -> L24
    L26:
        throw th;
    L24:
        e = move-exception;
        this.f2242c.b(7, e);
    L14:
        e = move-exception;
        this.f2242c.b(7, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L18
    L30:
    L20:
        return null;
    L10:
        e = move-exception;
        this.f2242c.b(8, e);     // Catch: Throwable -> L8
        r5.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        this.f2242c.b(7, e);
        goto L20
    }

    private a a(b[] r4, byte[] r5) {
        InputStream r1 = a(this.f2240a, this.h);     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
        if (r1 != null) goto L28;
        if (r1 == null) goto L25;
        r1.close();     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L25:
        return null;
    L28:
        this.j = f.a(r1, f.a(r1, f.f2258b), r5, r4);     // Catch: Throwable -> L9
        if (r1 == null) goto L8;
        r1.close();     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L8:
        return this;
    L9:
        th = move-exception;
        if (r1 != null) goto L26;
    L15:
        throw th;     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L26:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L19 IOException -> L21 FileNotFoundException -> L23
    L23:
        e = move-exception;
        this.f2242c.b(9, e);
    L21:
        e = move-exception;
        this.f2242c.b(7, e);
    L19:
        e = move-exception;
        this.j = null;
        this.f2242c.b(8, e);
        goto L25
    }

    public a c() {
        b[] r0 = this.j;
        byte[] r1 = this.f2243d;
        if (r0 == null) goto L27;
        if (r1 == null) goto L27;
        e();
        ByteArrayOutputStream r3 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L22 IOException -> L24
        f.a(r3, r1);     // Catch: Throwable -> L16
        if (f.a(r3, r1, r0) == true) goto L13;
        this.f2242c.b(5, null);     // Catch: Throwable -> L16
        this.j = null;     // Catch: Throwable -> L16
        r3.close();     // Catch: IllegalStateException -> L22 IOException -> L24
        return this;
    L13:
        this.k = r3.toByteArray();     // Catch: Throwable -> L16
        r3.close();     // Catch: IllegalStateException -> L22 IOException -> L24
    L26:
        this.j = null;
    L16:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IllegalStateException -> L22 IOException -> L24
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L22 IOException -> L24
    L24:
        e = move-exception;
        this.f2242c.b(7, e);
    L22:
        e = move-exception;
        this.f2242c.b(8, e);
    L27:
        return this;
    }

    public boolean d() {
        byte[] r0 = this.k;
        if (r0 != null) goto L5;
        return false;
    L5:
        e();
        ByteArrayInputStream r3 = new ByteArrayInputStream(r0);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        FileOutputStream r1 = new FileOutputStream(this.f2244e);     // Catch: Throwable -> L19
        c.a(r3, r1);     // Catch: Throwable -> L13
        a(1, null);     // Catch: Throwable -> L13
        r1.close();     // Catch: Throwable -> L19
        r3.close();     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
        this.k = null;
        this.j = null;
        return true;
    L13:
        th = move-exception;
        r1.close();     // Catch: Throwable -> L16
    L18:
        throw th;     // Catch: Throwable -> L19
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25 IOException -> L27 FileNotFoundException -> L30
    L25:
        th = move-exception;
        this.k = null;
        this.j = null;
        throw th;
    L30:
        e = move-exception;
        a(6, e);     // Catch: Throwable -> L25
    L32:
        this.k = null;
        this.j = null;
        return false;
    L27:
        e = move-exception;
        a(7, e);     // Catch: Throwable -> L25
        goto L32
    }

    private static byte[] f() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L20:
        return null;
    L5:
        if (Build.VERSION.SDK_INT > 33) goto L20;
        switch(Build.VERSION.SDK_INT) {
            case 24: goto L19;
            case 25: goto L19;
            case 26: goto L17;
            case 27: goto L15;
            case 28: goto L13;
            case 29: goto L13;
            case 30: goto L13;
            case 31: goto L11;
            case 32: goto L11;
            case 33: goto L11;
            default: goto L9;
        };
    L9:
        return null;
    L11:
        return h.f2269a;
    L13:
        return h.f2270b;
    L15:
        return h.f2271c;
    L17:
        return h.f2272d;
    L19:
        return h.f2273e;
    }

    private static boolean g() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L14:
        return false;
    L5:
        if (Build.VERSION.SDK_INT > 33) goto L14;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 != 24) goto L10;
    L13:
        return true;
    L10:
        if (r0 == 25) goto L13;
        switch(r0) {
            case 31: goto L13;
            case 32: goto L13;
            case 33: goto L13;
            default: goto L12;
        };
    L12:
        return false;
    }
}
