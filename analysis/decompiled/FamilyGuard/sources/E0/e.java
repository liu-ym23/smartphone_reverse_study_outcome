package E0;

import E0.a;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import w0.C1200a;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private final File f1286b;

    /* renamed from: c, reason: collision with root package name */
    private final long f1287c;

    /* renamed from: e, reason: collision with root package name */
    private C1200a f1289e;

    /* renamed from: d, reason: collision with root package name */
    private final c f1288d = new c();

    /* renamed from: a, reason: collision with root package name */
    private final j f1285a = new j();

    @Deprecated
    protected e(File file, long j5) {
        this.f1286b = file;
        this.f1287c = j5;
    }

    public static a c(File file, long j5) {
        return new e(file, j5);
    }

    private synchronized C1200a d() {
        try {
            if (this.f1289e == null) {
                this.f1289e = C1200a.L(this.f1286b, 1, 1, this.f1287c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f1289e;
    }

    @Override // E0.a
    public File a(InterfaceC1340f interfaceC1340f) {
        String strB = this.f1285a.b(interfaceC1340f);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + interfaceC1340f);
        }
        try {
            C1200a.e eVarG = d().G(strB);
            if (eVarG != null) {
                return eVarG.a(0);
            }
            return null;
        } catch (IOException e6) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e6);
            return null;
        }
    }

    @Override // E0.a
    public void b(InterfaceC1340f interfaceC1340f, a.b bVar) {
        String strB = this.f1285a.b(interfaceC1340f);
        this.f1288d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + interfaceC1340f);
            }
            try {
                C1200a c1200aD = d();
                if (c1200aD.G(strB) == null) {
                    C1200a.c cVarD = c1200aD.D(strB);
                    if (cVarD == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                    }
                    try {
                        if (bVar.a(cVarD.f(0))) {
                            cVarD.e();
                        }
                        cVarD.b();
                    } catch (Throwable th) {
                        cVarD.b();
                        throw th;
                    }
                }
            } catch (IOException e6) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e6);
                }
            }
        } finally {
            this.f1288d.b(strB);
        }
    }
}
