package com.amap.api.col.jmsl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.amap.api.col.jmsl.O1;
import com.amap.api.col.jmsl.s7;
import com.amap.api.maps.model.AMapException;

/* loaded from: classes.dex */
public class U1 extends C1540c1 {

    /* renamed from: e, reason: collision with root package name */
    public static U1 f16366e;

    /* renamed from: d, reason: collision with root package name */
    public V1 f16367d;

    public static class a extends Handler {
        public /* synthetic */ a(Looper looper, byte b10) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i10 = message.what;
                if (i10 == 0) {
                    ((C2) message.obj).getClass();
                    throw null;
                }
                if (i10 != 1) {
                    return;
                }
                ((C2) message.obj).getClass();
                throw null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    public U1(boolean z10) {
        if (z10) {
            try {
                this.f16367d = V1.g(new O1.a().b("amap-netmanger-threadpool-%d").d());
            } catch (Throwable th) {
                C1541c2.b(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            new a(Looper.getMainLooper(), (byte) 0);
        } else {
            new a();
        }
    }

    public static synchronized U1 m(boolean z10) {
        try {
            U1 u12 = f16366e;
            if (u12 == null) {
                f16366e = new U1(z10);
            } else if (z10 && u12.f16367d == null) {
                u12.f16367d = V1.g(new O1.a().b("amap-netmanger-threadpool-%d").d());
            }
        } finally {
            return f16366e;
        }
        return f16366e;
    }

    public static U1 n(boolean z10) {
        return m(z10);
    }

    @Override // com.amap.api.col.jmsl.C1540c1
    @Deprecated
    public byte[] k(s7 s7Var) throws g5 {
        try {
            return h(s7Var, false).f16719a;
        } catch (g5 e10) {
            throw e10;
        } catch (Throwable th) {
            th.printStackTrace();
            C1541c2.d().h(th, "NetManager", "makeSyncPostRequest");
            throw new g5(AMapException.ERROR_UNKNOWN);
        }
    }

    public final C1577l2 o(s7 s7Var, s7.b bVar, int i10) throws g5 {
        try {
            l(s7Var);
            s7Var.setDegradeType(bVar);
            s7Var.setReal_max_timeout(i10);
            return new E1().d(s7Var);
        } catch (g5 e10) {
            throw e10;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new g5(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    public C1577l2 p(s7 s7Var, boolean z10) throws g5 {
        boolean z11;
        byte[] bArr;
        l(s7Var);
        s7Var.setHttpProtocol(z10 ? s7.c.HTTPS : s7.c.HTTP);
        C1577l2 c1577l2O = null;
        long jElapsedRealtime = 0;
        if (i(s7Var)) {
            boolean zG = g(s7Var);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                c1577l2O = o(s7Var, f(s7Var, zG), j(s7Var, zG));
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
        return (c1577l2O == null || (bArr = c1577l2O.f16719a) == null || bArr.length <= 0) ? o(s7Var, c(s7Var, z11), a(s7Var, jElapsedRealtime)) : c1577l2O;
    }

    public C1577l2 q(s7 s7Var) throws g5 {
        return p(s7Var, s7Var.isHttps());
    }
}
