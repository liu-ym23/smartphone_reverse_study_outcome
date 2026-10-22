package r;

import android.app.Application;
import com.bytedance.apm.common.utility.NetworkUtils$NetworkType;

/* renamed from: r.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1869a {

    /* renamed from: a, reason: collision with root package name */
    public final C1871c f5661a;
    public int b;
    public volatile boolean c;
    public long d;
    public boolean e;

    public AbstractC1869a(C1871c c1871c) {
        this.f5661a = c1871c;
    }

    public final long a() {
        String strConcat;
        long jB = b();
        if (jB > System.currentTimeMillis()) {
            return jB;
        }
        try {
            try {
                boolean zC = c();
                this.d = System.currentTimeMillis();
                if (zC) {
                    this.b = 0;
                } else {
                    this.b++;
                }
                strConcat = d() + " worked:" + zC;
            } catch (Exception e) {
                w.h.b(e);
                this.d = System.currentTimeMillis();
                this.b++;
                strConcat = d().concat(" worked:false");
            }
            w.h.a(strConcat, null);
            return b();
        } catch (Throwable th) {
            this.d = System.currentTimeMillis();
            this.b++;
            w.h.a(d().concat(" worked:false"), null);
            throw th;
        }
    }

    public final long b() {
        h hVar = this.f5661a.f5664j;
        long jF = 0;
        if (hVar != null && ((!hVar.g || hVar.h != 0) && (this instanceof f))) {
            return f() + this.d;
        }
        Application application = this.f5661a.b;
        NetworkUtils$NetworkType networkUtils$NetworkType = D2.b.f373a;
        NetworkUtils$NetworkType networkUtils$NetworkType2 = NetworkUtils$NetworkType.UNKNOWN;
        if (networkUtils$NetworkType == networkUtils$NetworkType2) {
            D2.b.f373a = D2.b.d(application);
        }
        if (System.currentTimeMillis() - D2.b.b > 2000) {
            D2.b.f373a = D2.b.d(application);
            D2.b.b = System.currentTimeMillis();
        }
        NetworkUtils$NetworkType networkUtils$NetworkType3 = D2.b.f373a;
        networkUtils$NetworkType3.getClass();
        if (networkUtils$NetworkType3 == networkUtils$NetworkType2 || networkUtils$NetworkType3 == NetworkUtils$NetworkType.NONE) {
            return System.currentTimeMillis() + 15000;
        }
        if (this.c) {
            this.d = 0L;
            this.c = false;
        } else {
            int i = this.b;
            if (i > 0) {
                long[] jArrE = e();
                jF = jArrE[(i - 1) % jArrE.length];
            } else {
                jF = f();
            }
        }
        return this.d + jF;
    }

    public abstract boolean c();

    public abstract String d();

    public abstract long[] e();

    public abstract long f();

    public AbstractC1869a(C1871c c1871c, long j5) {
        this.f5661a = c1871c;
        this.d = j5;
    }
}
