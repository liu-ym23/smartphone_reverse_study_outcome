package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f3943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f3944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProfileInstaller.DiagnosticsCallback f3945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f3946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final File f3947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f3949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f3950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d[] f3952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f3953k;

    public c(AssetManager r10, Executor r11, ProfileInstaller.DiagnosticsCallback r12, String r13, String r14, String r15, File r16) {
        this.f3951i = false;
        this.f3943a = r10;
        this.f3944b = r11;
        this.f3945c = r12;
        this.f3948f = r13;
        this.f3949g = r14;
        this.f3950h = r15;
        this.f3947e = r16;
        this.f3946d = d();
    }

    public static /* synthetic */ void a(c r10, int r11, Object r12) {
        r10.g(r11, r12);
    }

    public static byte[] d() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 <= 33) goto L5;
        return null;
    L5:
        switch(r10) {
            case 30: goto L10;
            case 31: goto L8;
            case 32: goto L8;
            case 33: goto L8;
            default: goto L6;
        };
    L6:
        return null;
    L8:
        return m.f3973a;
    L10:
        return m.f3974b;
    }

    public static boolean k() {
        int r10 = Build.VERSION.SDK_INT;
        if (r10 <= 33) goto L5;
        return false;
    L5:
        switch(r10) {
            case 31: goto L7;
            case 32: goto L7;
            case 33: goto L7;
            default: goto L6;
        };
    L6:
        return false;
    L7:
        return true;
    }

    public final c b(d[] r10, byte[] r11) {
        InputStream r12 = h(this.f3943a, this.f3950h);     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
        if (r12 != null) goto L27;
        if (r12 == null) goto L26;
        r12.close();     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
    L26:
        return null;
    L27:
        this.f3952j = l.q(r12, l.o(r12, l.f3972b), r11, r10);     // Catch: Throwable -> L14
        r12.close();     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
        return this;
    L14:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L8 IOException -> L10 FileNotFoundException -> L12
    L12:
        e = move-exception;
        this.f3945c.onResultReceived(9, e);
    L10:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);
    L8:
        e = move-exception;
        this.f3952j = null;
        this.f3945c.onResultReceived(8, e);
        goto L26
    }

    public final void c() {
        if (this.f3951i == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
    }

    public boolean e() {
        if (this.f3946d != null) goto L7;
        l(3, Integer.valueOf(Build.VERSION.SDK_INT));
        return false;
    L7:
        if (this.f3947e.canWrite() == true) goto L10;
        l(4, null);
        return false;
    L10:
        this.f3951i = true;
        return true;
    }

    public final InputStream f(AssetManager r10) {
    L14:
        return h(r10, this.f3949g);
    L6:
        e = move-exception;
        this.f3945c.onResultReceived(6, e);
    L10:
        return null;
    L4:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);
        goto L10
    }

    public final /* synthetic */ void g(int r10, Object r11) {
        this.f3945c.onResultReceived(r10, r11);
    }

    public final InputStream h(AssetManager r10, String r11) {
        return r10.openFd(r11).createInputStream();
    L4:
        e = move-exception;
        String r12 = e.getMessage();
        if (r12 == null) goto L11;
        if (r12.contains("compressed") == false) goto L11;
        this.f3945c.onDiagnosticReceived(5, null);
    L11:
        return null;
    }

    public c i() {
        c();
        if (this.f3946d != null) goto L5;
        return this;
    L5:
        InputStream r10 = f(this.f3943a);
        if (r10 == null) goto L8;
        this.f3952j = j(r10);
    L8:
        d[] r11 = this.f3952j;
        if (r11 != null) goto L11;
    L15:
        return this;
    L11:
        if (k() == false) goto L15;
        c r12 = b(r11, this.f3946d);
        if (r12 == null) goto L15;
        return r12;
    }

    public final d[] j(InputStream r10) {
        d[] r11 = l.w(r10, l.o(r10, l.f3971a), this.f3948f);     // Catch: Throwable -> L8 IllegalStateException -> L10 IOException -> L12
        r10.close();     // Catch: IOException -> L6
        return r11;
    L6:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);
        return r11;
    L17:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);
    L21:
        return null;
    L10:
        e = move-exception;
        this.f3945c.onResultReceived(8, e);     // Catch: Throwable -> L8
        r10.close();     // Catch: IOException -> L17
    L12:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);     // Catch: Throwable -> L8
        r10.close();     // Catch: IOException -> L17
    L8:
        th = move-exception;
        r10.close();     // Catch: IOException -> L25
    L27:
        throw th;
    L25:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);
        goto L27
    }

    public final void l(final int r10, final Object r11) {
        this.f3944b.execute(new b(this, r10, r11));
    }

    public c m() {
        d[] r10 = this.f3952j;
        byte[] r11 = this.f3946d;
        if (r10 == null) goto L30;
        if (r11 == null) goto L30;
        c();
        ByteArrayOutputStream r12 = new ByteArrayOutputStream();     // Catch: IllegalStateException -> L13 IOException -> L15
        l.E(r12, r11);     // Catch: Throwable -> L17
        if (l.B(r12, r11, r10) == true) goto L19;
        this.f3945c.onResultReceived(5, null);     // Catch: Throwable -> L17
        this.f3952j = null;     // Catch: Throwable -> L17
        r12.close();     // Catch: IllegalStateException -> L13 IOException -> L15
        return this;
    L19:
        this.f3953k = r12.toByteArray();     // Catch: Throwable -> L17
        r12.close();     // Catch: IllegalStateException -> L13 IOException -> L15
    L29:
        this.f3952j = null;
    L17:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: IllegalStateException -> L13 IOException -> L15
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalStateException -> L13 IOException -> L15
    L15:
        e = move-exception;
        this.f3945c.onResultReceived(7, e);
    L13:
        e = move-exception;
        this.f3945c.onResultReceived(8, e);
    L30:
        return this;
    }

    public boolean n() {
        byte[] r10 = this.f3953k;
        if (r10 != null) goto L5;
        return false;
    L5:
        c();
        ByteArrayInputStream r11 = new ByteArrayInputStream(r10);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        FileOutputStream r12 = new FileOutputStream(this.f3947e);     // Catch: Throwable -> L19
        e.l(r11, r12);     // Catch: Throwable -> L21
        l(1, null);     // Catch: Throwable -> L21
        r12.close();     // Catch: Throwable -> L19
        r11.close();     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
        this.f3953k = null;
        this.f3952j = null;
        return true;
    L21:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L19
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13 IOException -> L15 FileNotFoundException -> L17
    L13:
        th = move-exception;
        this.f3953k = null;
        this.f3952j = null;
        throw th;
    L17:
        e = move-exception;
        l(6, e);     // Catch: Throwable -> L13
    L34:
        this.f3953k = null;
        this.f3952j = null;
        return false;
    L15:
        e = move-exception;
        l(7, e);     // Catch: Throwable -> L13
        goto L34
    }
}
