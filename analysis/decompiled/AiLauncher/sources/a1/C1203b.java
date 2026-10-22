package a1;

import a1.C1207f;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* renamed from: a1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1203b {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f7824a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f7825b;

    /* renamed from: c, reason: collision with root package name */
    public final C1207f.c f7826c;

    /* renamed from: e, reason: collision with root package name */
    public final File f7828e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7829f;

    /* renamed from: g, reason: collision with root package name */
    public final String f7830g;

    /* renamed from: h, reason: collision with root package name */
    public final String f7831h;

    /* renamed from: j, reason: collision with root package name */
    public C1204c[] f7833j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f7834k;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7832i = false;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f7827d = d();

    public C1203b(AssetManager assetManager, Executor executor, C1207f.c cVar, String str, String str2, String str3, File file) {
        this.f7824a = assetManager;
        this.f7825b = executor;
        this.f7826c = cVar;
        this.f7829f = str;
        this.f7830g = str2;
        this.f7831h = str3;
        this.f7828e = file;
    }

    public static byte[] d() {
        return C1212k.f7861a;
    }

    public static boolean j() {
        return true;
    }

    public final C1203b b(C1204c[] c1204cArr, byte[] bArr) throws IOException {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.f7824a, this.f7831h);
        } catch (FileNotFoundException e10) {
            this.f7826c.a(9, e10);
        } catch (IOException e11) {
            this.f7826c.a(7, e11);
        } catch (IllegalStateException e12) {
            this.f7833j = null;
            this.f7826c.a(8, e12);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.f7833j = androidx.profileinstaller.a.r(inputStreamG, androidx.profileinstaller.a.p(inputStreamG, androidx.profileinstaller.a.f14433b), bArr, c1204cArr);
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

    public final void c() {
        if (!this.f7832i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public boolean e() {
        if (this.f7827d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f7828e.exists()) {
            try {
                if (!this.f7828e.createNewFile()) {
                    k(4, null);
                    return false;
                }
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f7828e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f7832i = true;
        return true;
    }

    public final InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f7830g);
        } catch (FileNotFoundException e10) {
            this.f7826c.a(6, e10);
            return null;
        } catch (IOException e11) {
            this.f7826c.a(7, e11);
            return null;
        }
    }

    public final InputStream g(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f7826c.b(5, null);
            }
            return null;
        }
    }

    public C1203b h() {
        C1203b c1203bB;
        c();
        if (this.f7827d != null) {
            InputStream inputStreamF = f(this.f7824a);
            if (inputStreamF != null) {
                this.f7833j = i(inputStreamF);
            }
            C1204c[] c1204cArr = this.f7833j;
            if (c1204cArr != null && j() && (c1203bB = b(c1204cArr, this.f7827d)) != null) {
                return c1203bB;
            }
        }
        return this;
    }

    public final C1204c[] i(InputStream inputStream) throws IOException {
        try {
            try {
                try {
                    C1204c[] c1204cArrX = androidx.profileinstaller.a.x(inputStream, androidx.profileinstaller.a.p(inputStream, androidx.profileinstaller.a.f14432a), this.f7829f);
                    try {
                        inputStream.close();
                        return c1204cArrX;
                    } catch (IOException e10) {
                        this.f7826c.a(7, e10);
                        return c1204cArrX;
                    }
                } catch (IllegalStateException e11) {
                    this.f7826c.a(8, e11);
                    return null;
                }
            } catch (IOException e12) {
                this.f7826c.a(7, e12);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e13) {
                this.f7826c.a(7, e13);
            }
        }
    }

    public final void k(final int i10, final Object obj) {
        this.f7825b.execute(new Runnable() { // from class: a1.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f7821a.f7826c.a(i10, obj);
            }
        });
    }

    public C1203b l() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        C1204c[] c1204cArr = this.f7833j;
        byte[] bArr = this.f7827d;
        if (c1204cArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    androidx.profileinstaller.a.F(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                this.f7826c.a(7, e10);
            } catch (IllegalStateException e11) {
                this.f7826c.a(8, e11);
            }
            if (!androidx.profileinstaller.a.C(byteArrayOutputStream, bArr, c1204cArr)) {
                this.f7826c.a(5, null);
                this.f7833j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f7834k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f7833j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.f7834k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f7828e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock fileLockTryLock = channel.tryLock();
                            try {
                                C1205d.l(byteArrayInputStream, fileOutputStream, fileLockTryLock);
                                k(1, null);
                                if (fileLockTryLock != null) {
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
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
            } catch (FileNotFoundException e10) {
                k(6, e10);
                return false;
            } catch (IOException e11) {
                k(7, e11);
                return false;
            }
        } finally {
            this.f7834k = null;
            this.f7833j = null;
        }
    }
}
