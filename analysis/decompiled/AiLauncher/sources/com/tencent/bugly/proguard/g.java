package com.tencent.bugly.proguard;

import Z7.I;
import Z7.J;
import Z7.K;
import Z7.L;
import Z7.M;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class g extends m {

    /* renamed from: k, reason: collision with root package name */
    public static byte[] f31684k = null;

    /* renamed from: l, reason: collision with root package name */
    public static Map<String, String> f31685l = null;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ boolean f31686m = true;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f31693g;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, String> f31695i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f31696j;

    /* renamed from: a, reason: collision with root package name */
    public short f31687a = 0;

    /* renamed from: b, reason: collision with root package name */
    public byte f31688b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f31689c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f31690d = 0;

    /* renamed from: e, reason: collision with root package name */
    public String f31691e = null;

    /* renamed from: f, reason: collision with root package name */
    public String f31692f = null;

    /* renamed from: h, reason: collision with root package name */
    public int f31694h = 0;

    @Override // com.tencent.bugly.proguard.m
    public final void a(K k10) {
        try {
            this.f31687a = k10.m(this.f31687a, 1, true);
            this.f31688b = k10.a(this.f31688b, 2, true);
            this.f31689c = k10.d(this.f31689c, 3, true);
            this.f31690d = k10.d(this.f31690d, 4, true);
            this.f31691e = k10.u(5, true);
            this.f31692f = k10.u(6, true);
            if (f31684k == null) {
                f31684k = new byte[]{0};
            }
            this.f31693g = k10.y(7, true);
            this.f31694h = k10.d(this.f31694h, 8, true);
            if (f31685l == null) {
                HashMap map = new HashMap();
                f31685l = map;
                map.put("", "");
            }
            this.f31695i = (Map) k10.i(f31685l, 9, true);
            if (f31685l == null) {
                HashMap map2 = new HashMap();
                f31685l = map2;
                map2.put("", "");
            }
            this.f31696j = (Map) k10.i(f31685l, 10, true);
        } catch (Exception e10) {
            e10.printStackTrace();
            System.out.println("RequestPacket decode error " + I.a(this.f31693g));
            throw new RuntimeException(e10);
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f31686m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void d(L l10) throws UnsupportedEncodingException {
        l10.m(this.f31687a, 1);
        l10.b(this.f31688b, 2);
        l10.f(this.f31689c, 3);
        l10.f(this.f31690d, 4);
        l10.j(this.f31691e, 5);
        l10.j(this.f31692f, 6);
        l10.o(this.f31693g, 7);
        l10.f(this.f31694h, 8);
        l10.l(this.f31695i, 9);
        l10.l(this.f31696j, 10);
    }

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        return M.a(1, gVar.f31687a) && M.a(1, gVar.f31688b) && M.a(1, gVar.f31689c) && M.a(1, gVar.f31690d) && M.c(1, gVar.f31691e) && M.c(1, gVar.f31692f) && M.c(1, gVar.f31693g) && M.a(1, gVar.f31694h) && M.c(1, gVar.f31695i) && M.c(1, gVar.f31696j);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void f(StringBuilder sb2, int i10) {
        J j10 = new J(sb2, i10);
        j10.l(this.f31687a, "iVersion");
        j10.a(this.f31688b, "cPacketType");
        j10.e(this.f31689c, "iMessageType");
        j10.e(this.f31690d, "iRequestId");
        j10.i(this.f31691e, "sServantName");
        j10.i(this.f31692f, "sFuncName");
        j10.n(this.f31693g, "sBuffer");
        j10.e(this.f31694h, "iTimeout");
        j10.k(this.f31695i, "context");
        j10.k(this.f31696j, "status");
    }
}
