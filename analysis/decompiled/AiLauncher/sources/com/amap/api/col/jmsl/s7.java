package com.amap.api.col.jmsl;

import android.text.TextUtils;
import com.amap.api.col.jmsl.C1540c1;
import com.autonavi.aps.amapapi.config.Const;
import java.net.Proxy;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class s7 {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* renamed from: d, reason: collision with root package name */
    C1540c1.a f16924d;

    /* renamed from: h, reason: collision with root package name */
    private String f16928h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f16929i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16930j;

    /* renamed from: a, reason: collision with root package name */
    int f16921a = 20000;

    /* renamed from: b, reason: collision with root package name */
    int f16922b = 20000;

    /* renamed from: c, reason: collision with root package name */
    Proxy f16923c = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16925e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f16926f = 20000;

    /* renamed from: g, reason: collision with root package name */
    private boolean f16927g = true;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16931k = false;

    /* renamed from: l, reason: collision with root package name */
    private a f16932l = a.NORMAL;

    /* renamed from: m, reason: collision with root package name */
    private b f16933m = b.FIRST_NONDEGRADE;

    /* renamed from: n, reason: collision with root package name */
    private boolean f16934n = false;

    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);

        a(int i10) {
        }
    }

    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);


        /* renamed from: a, reason: collision with root package name */
        private int f16949a;

        b(int i10) {
            this.f16949a = i10;
        }

        public final int f() {
            return this.f16949a;
        }

        public final boolean g() {
            int i10 = this.f16949a;
            return i10 == 2 || i10 == 3 || i10 == 5 || i10 == 6;
        }

        public final boolean h() {
            int i10 = this.f16949a;
            return i10 == 2 || i10 == 5;
        }

        public final boolean i() {
            return this.f16949a == 1;
        }

        public final boolean j() {
            int i10 = this.f16949a;
            return i10 == 0 || i10 == 1 || i10 == 4;
        }
    }

    public enum c {
        HTTP(0),
        HTTPS(1);

        c(int i10) {
        }
    }

    public final String a() {
        return a(getURL());
    }

    public final String b() {
        return a(getIPV6URL());
    }

    public int getConntectionTimeout() {
        return this.f16921a;
    }

    public a getDegradeAbility() {
        return this.f16932l;
    }

    public b getDegradeType() {
        return this.f16933m;
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public String getIPDNSName() {
        return "";
    }

    public String getIPV6URL() {
        return getURL();
    }

    public String getNon_degrade_final_Host() {
        return this.f16928h;
    }

    public abstract Map<String, String> getParams();

    public Proxy getProxy() {
        return this.f16923c;
    }

    public int getReal_max_timeout() {
        return this.f16926f;
    }

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public int getSoTimeout() {
        return this.f16922b;
    }

    public abstract String getURL();

    public C1540c1.a getUrlConnectionImpl() {
        return null;
    }

    public boolean isBinary() {
        return this.f16925e;
    }

    public boolean isHostToIP() {
        return this.f16927g;
    }

    public boolean isHttps() {
        return this.f16930j;
    }

    public boolean isIPRequest() {
        return !TextUtils.isEmpty(getIPDNSName());
    }

    public boolean isIPV6Request() {
        return this.f16929i;
    }

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isKeepAlive() {
        return this.f16931k;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public boolean isTLSv3() {
        return this.f16934n;
    }

    public String parseSDKNameFromPlatInfo(String str) {
        String str2;
        String strTrim = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split(Const.STR_MART_ADD);
                if (strArrSplit.length > 1) {
                    int length = strArrSplit.length;
                    int i10 = 0;
                    String str3 = "";
                    while (true) {
                        if (i10 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = strArrSplit[i10];
                        if (str2.contains("sdkversion")) {
                            str3 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i10++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] strArrSplit2 = str2.split("=");
                        if (strArrSplit2.length > 1) {
                            strTrim = strArrSplit2[1].trim();
                            if (!TextUtils.isEmpty(str3) && TextUtils.isEmpty(K0.a(strTrim))) {
                                String[] strArrSplit3 = str3.split("=");
                                if (strArrSplit3.length > 1) {
                                    K0.b(strTrim, strArrSplit3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
            return strTrim;
        } catch (Throwable th) {
            C1611u1.b(th, "ht", "pnfp");
            return strTrim;
        }
    }

    public String parseSdkNameFromHeader(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return parseSDKNameFromPlatInfo(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            C1611u1.b(th, "ht", "pnfh");
            return null;
        }
    }

    public String parseSdkNameFromRequest() {
        String sDKName;
        try {
            sDKName = getSDKName();
        } catch (Throwable th) {
            th = th;
            sDKName = "";
        }
        try {
            return TextUtils.isEmpty(sDKName) ? this.f16925e ? parseSDKNameFromPlatInfo(((AbstractC1576l1) this).getPlatInfo()) : parseSdkNameFromHeader(getRequestHead()) : sDKName;
        } catch (Throwable th2) {
            th = th2;
            C1611u1.b(th, "ht", "pnfr");
            return sDKName;
        }
    }

    public void setBinary(boolean z10) {
        this.f16925e = z10;
    }

    public final void setConnectionTimeout(int i10) {
        this.f16921a = i10;
    }

    public void setDegradeAbility(a aVar) {
        this.f16932l = aVar;
    }

    public void setDegradeType(b bVar) {
        this.f16933m = bVar;
    }

    public void setHostToIP(boolean z10) {
        this.f16927g = z10;
    }

    public void setHttpProtocol(c cVar) {
        this.f16930j = cVar == c.HTTPS;
    }

    public void setIPV6Request(boolean z10) {
        this.f16929i = z10;
    }

    public void setKeepAlive(boolean z10) {
        this.f16931k = z10;
    }

    public void setNon_degrade_final_Host(String str) {
        this.f16928h = str;
    }

    public final void setProxy(Proxy proxy) {
        this.f16923c = proxy;
    }

    public void setReal_max_timeout(int i10) {
        this.f16926f = i10;
    }

    public final void setSoTimeout(int i10) {
        this.f16922b = i10;
    }

    public void setTLSv3(boolean z10) {
        this.f16934n = z10;
    }

    public void setUrlConnectionImpl(C1540c1.a aVar) {
    }

    private String a(String str) {
        Map<String, String> params;
        byte[] entityBytes = getEntityBytes();
        if (entityBytes == null || entityBytes.length == 0 || (params = getParams()) == null) {
            return str;
        }
        String strG = E1.g(params);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(strG);
        return stringBuffer.toString();
    }
}
