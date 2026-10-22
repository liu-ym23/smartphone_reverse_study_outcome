package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f11277a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f11278b;

    /* renamed from: c, reason: collision with root package name */
    private final i.c f11279c;

    /* renamed from: e, reason: collision with root package name */
    private final File f11281e;

    /* renamed from: f, reason: collision with root package name */
    private final String f11282f;

    /* renamed from: g, reason: collision with root package name */
    private final String f11283g;

    /* renamed from: h, reason: collision with root package name */
    private final String f11284h;

    /* renamed from: j, reason: collision with root package name */
    private d[] f11286j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f11287k;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11285i = false;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f11280d = d();

    public c(AssetManager assetManager, Executor executor, i.c cVar, String str, String str2, String str3, File file) {
        this.f11277a = assetManager;
        this.f11278b = executor;
        this.f11279c = cVar;
        this.f11282f = str;
        this.f11283g = str2;
        this.f11284h = str3;
        this.f11281e = file;
    }

    private c b(d[] dVarArr, byte[] bArr) throws IOException {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.f11277a, this.f11284h);
        } catch (FileNotFoundException e6) {
            this.f11279c.b(9, e6);
        } catch (IOException e7) {
            this.f11279c.b(7, e7);
        } catch (IllegalStateException e8) {
            this.f11286j = null;
            this.f11279c.b(8, e8);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.f11286j = n.q(inputStreamG, n.o(inputStreamG, n.f11315b), bArr, dVarArr);
            inputStreamG.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamG.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void c() {
        if (!this.f11285i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 34) {
            return null;
        }
        if (i5 == 33 || i5 == 34) {
            return p.f11326a;
        }
        return null;
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f11283g);
        } catch (FileNotFoundException e6) {
            this.f11279c.b(6, e6);
            return null;
        } catch (IOException e7) {
            this.f11279c.b(7, e7);
            return null;
        }
    }

    private InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e6) {
            String message = e6.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f11279c.a(5, null);
            }
            return null;
        }
    }

    private d[] i(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    d[] dVarArrW = n.w(inputStream, n.o(inputStream, n.f11314a), this.f11282f);
                    try {
                        inputStream.close();
                        return dVarArrW;
                    } catch (IOException e6) {
                        this.f11279c.b(7, e6);
                        return dVarArrW;
                    }
                } catch (IllegalStateException e7) {
                    this.f11279c.b(8, e7);
                    return null;
                }
            } catch (IOException e8) {
                this.f11279c.b(7, e8);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e9) {
                this.f11279c.b(7, e9);
            }
        }
    }

    private static boolean j() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 > 34) {
            return false;
        }
        return i5 == 33 || i5 == 34;
    }

    private void k(final int i5, final Object obj) {
        this.f11278b.execute(new Runnable() { // from class: androidx.profileinstaller.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f11274a.f11279c.b(i5, obj);
            }
        });
    }

    public boolean e() throws IOException {
        if (this.f11280d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f11281e.exists()) {
            try {
                this.f11281e.createNewFile();
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f11281e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f11285i = true;
        return true;
    }

    public c h() {
        c cVarB;
        c();
        if (this.f11280d != null) {
            InputStream inputStreamF = f(this.f11277a);
            if (inputStreamF != null) {
                this.f11286j = i(inputStreamF);
            }
            d[] dVarArr = this.f11286j;
            if (dVarArr != null && j() && (cVarB = b(dVarArr, this.f11280d)) != null) {
                return cVarB;
            }
        }
        return this;
    }

    public c l() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.f11286j;
        byte[] bArr = this.f11280d;
        if (dVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    n.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e6) {
                this.f11279c.b(7, e6);
            } catch (IllegalStateException e7) {
                this.f11279c.b(8, e7);
            }
            if (!n.B(byteArrayOutputStream, bArr, dVarArr)) {
                this.f11279c.b(5, null);
                this.f11286j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f11287k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f11286j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.f11287k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f11281e);
                    try {
                        e.l(byteArrayInputStream, fileOutputStream);
                        k(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.f11287k = null;
                this.f11286j = null;
            }
        } catch (FileNotFoundException e6) {
            k(6, e6);
            return false;
        } catch (IOException e7) {
            k(7, e7);
            return false;
        }
    }
}
