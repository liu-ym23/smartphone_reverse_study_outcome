package com.amap.api.col.jmsl;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class X1 extends s7 {

    /* renamed from: B, reason: collision with root package name */
    public Context f16466B;

    /* renamed from: C, reason: collision with root package name */
    public String f16467C;

    /* renamed from: z, reason: collision with root package name */
    public Object f16470z;

    /* renamed from: y, reason: collision with root package name */
    public boolean f16469y = true;

    /* renamed from: A, reason: collision with root package name */
    public int f16465A = 1;

    /* renamed from: D, reason: collision with root package name */
    public boolean f16468D = false;

    public X1(Context context, Object obj) {
        e(context, obj);
    }

    private void e(Context context, Object obj) {
        this.f16466B = context;
        this.f16470z = obj;
        this.f16465A = 1;
        setSoTimeout(Const.I_LOC_JUMP_DELAY);
        setConnectionTimeout(Const.I_LOC_JUMP_DELAY);
    }

    public Object c(C1577l2 c1577l2) throws C1599r1 {
        return null;
    }

    public abstract Object d(byte[] bArr) throws C1599r1;

    public Object f() throws C1599r1 {
        if (this.f16470z == null) {
            return null;
        }
        try {
            return g();
        } catch (C1599r1 e10) {
            C1570k.j(e10);
            throw e10;
        } catch (Exception e11) {
            C1570k.j(e11);
            return null;
        }
    }

    public Object g() throws Exception {
        Object objC = null;
        int i10 = 0;
        while (i10 < this.f16465A) {
            try {
                setProxy(L1.d(this.f16466B));
                objC = this.f16468D ? c(j()) : d(i());
                i10 = this.f16465A;
            } catch (g5 e10) {
                if (304 == e10.g()) {
                    throw e10;
                }
                i10++;
                if (i10 >= this.f16465A) {
                    if (AMapException.ERROR_CONNECTION.equals(e10.getMessage()) || AMapException.ERROR_SOCKET.equals(e10.getMessage()) || AMapException.ERROR_UNKNOWN.equals(e10.h()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e10.getMessage())) {
                        throw new C1599r1(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new C1599r1(e10.h());
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    if (AMapException.ERROR_CONNECTION.equals(e10.getMessage()) || AMapException.ERROR_SOCKET.equals(e10.getMessage()) || AMapException.ERROR_UNKNOW_SERVICE.equals(e10.getMessage())) {
                        throw new C1599r1(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
                    }
                    throw new C1599r1(e10.h());
                }
            } catch (C1599r1 e11) {
                i10++;
                if (i10 >= this.f16465A) {
                    if (C1623x1.f17030a) {
                        e11.printStackTrace();
                    }
                    throw new C1599r1(e11.a());
                }
            }
        }
        return objC;
    }

    @Override // com.amap.api.col.jmsl.s7
    public Map<String, String> getRequestHead() {
        C1569j2 c1569j2C = C1570k.c();
        String strH = c1569j2C != null ? c1569j2C.h() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30853l, C1623x1.f17031b);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", strH, "3dmap-lite"));
        hashtable.put("X-INFO", J0.c(this.f16466B));
        hashtable.put("key", C1567j0.n(this.f16466B));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.jmsl.s7
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Map<String, String> getParams() {
        return null;
    }

    public byte[] i() throws g5 {
        int protocol = MapsInitializer.getProtocol();
        U1 u1N = U1.n(false);
        if (protocol == 1) {
            if (this.f16469y) {
                return u1N.k(this);
            }
            u1N.getClass();
            try {
                return u1N.p(this, false).f16719a;
            } catch (g5 e10) {
                throw e10;
            }
        }
        if (protocol != 2) {
            return null;
        }
        if (this.f16469y) {
            u1N.getClass();
            try {
                return u1N.h(this, true).f16719a;
            } catch (g5 e11) {
                throw e11;
            }
        }
        u1N.getClass();
        try {
            return u1N.p(this, true).f16719a;
        } catch (g5 e12) {
            throw e12;
        }
    }

    public C1577l2 j() {
        int protocol = MapsInitializer.getProtocol();
        U1 u1N = U1.n(false);
        if (protocol == 1) {
            return this.f16469y ? u1N.h(this, false) : u1N.p(this, false);
        }
        if (protocol == 2) {
            return this.f16469y ? u1N.h(this, true) : u1N.p(this, true);
        }
        return null;
    }
}
