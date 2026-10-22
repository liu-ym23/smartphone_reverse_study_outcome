package com.amap.api.col.jmsl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.jmsl.s7;
import com.amap.api.maps.model.AMapException;
import java.net.URL;

/* renamed from: com.amap.api.col.jmsl.c1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1540c1 {

    /* renamed from: a, reason: collision with root package name */
    public static int f16543a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static String f16544b = "";

    /* renamed from: c, reason: collision with root package name */
    public static C1540c1 f16545c;

    /* renamed from: com.amap.api.col.jmsl.c1$a */
    public interface a {
    }

    public C1540c1() {
        C1602s0.N();
    }

    public static C1540c1 b() {
        if (f16545c == null) {
            f16545c = new C1540c1();
        }
        return f16545c;
    }

    public int a(s7 s7Var, long j10) {
        try {
            l(s7Var);
            long jElapsedRealtime = 0;
            if (j10 != 0) {
                jElapsedRealtime = SystemClock.elapsedRealtime() - j10;
            }
            int conntectionTimeout = s7Var.getConntectionTimeout();
            if (s7Var.getDegradeAbility() != s7.a.FIX && s7Var.getDegradeAbility() != s7.a.SINGLE) {
                long j11 = conntectionTimeout;
                if (jElapsedRealtime < j11) {
                    long j12 = j11 - jElapsedRealtime;
                    if (j12 >= 1000) {
                        return (int) j12;
                    }
                }
                return Math.min(1000, s7Var.getConntectionTimeout());
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return s7.DEFAULT_RETRY_TIMEOUT;
        }
    }

    public s7.b c(s7 s7Var, boolean z10) {
        return s7Var.getDegradeAbility() == s7.a.FIX ? z10 ? s7.b.FIX_DEGRADE_BYERROR : s7.b.FIX_DEGRADE_ONLY : z10 ? s7.b.DEGRADE_BYERROR : s7.b.DEGRADE_ONLY;
    }

    public C1577l2 d(s7 s7Var) throws g5 {
        return h(s7Var, s7Var.isHttps());
    }

    public final C1577l2 e(s7 s7Var, s7.b bVar, int i10) throws g5 {
        try {
            l(s7Var);
            s7Var.setDegradeType(bVar);
            s7Var.setReal_max_timeout(i10);
            return new E1().k(s7Var);
        } catch (g5 e10) {
            throw e10;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new g5(AMapException.ERROR_UNKNOWN);
        }
    }

    public s7.b f(s7 s7Var, boolean z10) {
        if (s7Var.getDegradeAbility() == s7.a.FIX) {
            return s7.b.FIX_NONDEGRADE;
        }
        if (s7Var.getDegradeAbility() != s7.a.SINGLE && z10) {
            return s7.b.FIRST_NONDEGRADE;
        }
        return s7.b.NEVER_GRADE;
    }

    public boolean g(s7 s7Var) throws g5 {
        l(s7Var);
        if (!i(s7Var)) {
            return true;
        }
        if (s7Var.getURL().equals(s7Var.getIPV6URL()) || s7Var.getDegradeAbility() == s7.a.SINGLE) {
            return false;
        }
        return C1602s0.f16882s;
    }

    @Deprecated
    public C1577l2 h(s7 s7Var, boolean z10) throws g5 {
        boolean z11;
        byte[] bArr;
        l(s7Var);
        s7Var.setHttpProtocol(z10 ? s7.c.HTTPS : s7.c.HTTP);
        C1577l2 c1577l2E = null;
        long jElapsedRealtime = 0;
        if (i(s7Var)) {
            boolean zG = g(s7Var);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                c1577l2E = e(s7Var, f(s7Var, zG), j(s7Var, zG));
                z11 = false;
            } catch (g5 e10) {
                if ((e10.g() == 21 && s7Var.getDegradeAbility() == s7.a.INTERRUPT_IO) || !zG) {
                    throw e10;
                }
                z11 = true;
            }
        } else {
            z11 = false;
        }
        return (c1577l2E == null || (bArr = c1577l2E.f16719a) == null || bArr.length <= 0) ? e(s7Var, c(s7Var, z11), a(s7Var, jElapsedRealtime)) : c1577l2E;
    }

    public boolean i(s7 s7Var) throws g5 {
        l(s7Var);
        try {
            String ipv6url = s7Var.getIPV6URL();
            if (TextUtils.isEmpty(ipv6url)) {
                return false;
            }
            String host = new URL(ipv6url).getHost();
            if (!TextUtils.isEmpty(s7Var.getIPDNSName())) {
                host = s7Var.getIPDNSName();
            }
            return C1602s0.M(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    public int j(s7 s7Var, boolean z10) {
        try {
            l(s7Var);
            int conntectionTimeout = s7Var.getConntectionTimeout();
            int i10 = C1602s0.f16878o;
            if (s7Var.getDegradeAbility() != s7.a.FIX) {
                if (s7Var.getDegradeAbility() != s7.a.SINGLE && conntectionTimeout >= i10 && z10) {
                    return i10;
                }
            }
            return conntectionTimeout;
        } catch (Throwable unused) {
            return s7.DEFAULT_RETRY_TIMEOUT;
        }
    }

    @Deprecated
    public byte[] k(s7 s7Var) throws g5 {
        try {
            return h(s7Var, false).f16719a;
        } catch (g5 e10) {
            throw e10;
        } catch (Throwable th) {
            C1611u1.b(th, "bm", "msp");
            throw new g5(AMapException.ERROR_UNKNOWN);
        }
    }

    public void l(s7 s7Var) throws g5 {
        if (s7Var == null) {
            throw new g5("requeust is null");
        }
        if (s7Var.getURL() == null || "".equals(s7Var.getURL())) {
            throw new g5("request url is empty");
        }
    }
}
