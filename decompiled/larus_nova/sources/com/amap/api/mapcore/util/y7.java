package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.net.Proxy;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public abstract class y7 {
    public static final int DEFAULT_RETRY_TIMEOUT = 5000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f28438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f28440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f28441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Proxy f28442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    r7.a f28443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f28444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f28445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f28446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f28447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f28448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f28449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private b f28450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f28451n;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f28452a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f28453b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f28454c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f28455d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f28456e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ a[] f28457f = null;

        static {
            a r100 = new a(EffectConstants.NORMAL, 0, 0);
            f28452a = r100;
            a r101 = new a("INTERRUPT_IO", 1, 1);
            f28453b = r101;
            a r102 = new a("NEVER", 2, 2);
            f28454c = r102;
            a r103 = new a("FIX", 3, 3);
            f28455d = r103;
            a r104 = new a("SINGLE", 4, 4);
            f28456e = r104;
            f28457f = new a[]{r100, r101, r102, r103, r104};
        }

        public static a[] values() {
            return (a[]) f28457f.clone();
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        private a(String r100, int r101, int r102) {
            super(r100, r101);
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f28458b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f28459c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f28460d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f28461e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f28462f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final b f28463g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f28464h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ b[] f28465i = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f28466a;

        static {
            b r100 = new b("FIRST_NONDEGRADE", 0, 0);
            f28458b = r100;
            b r101 = new b("NEVER_GRADE", 1, 1);
            f28459c = r101;
            b r102 = new b("DEGRADE_BYERROR", 2, 2);
            f28460d = r102;
            b r103 = new b("DEGRADE_ONLY", 3, 3);
            f28461e = r103;
            b r104 = new b("FIX_NONDEGRADE", 4, 4);
            f28462f = r104;
            b r105 = new b("FIX_DEGRADE_BYERROR", 5, 5);
            f28463g = r105;
            b r110 = new b("FIX_DEGRADE_ONLY", 6, 6);
            f28464h = r110;
            f28465i = new b[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static b[] values() {
            return (b[]) f28465i.clone();
        }

        public final boolean b() {
            int r100 = this.f28466a;
            if (r100 != 2) goto L5;
            return true;
        L5:
            if (r100 != 3) goto L7;
            return true;
        L7:
            if (r100 != 5) goto L9;
            return true;
        L9:
            if (r100 == 6) goto L17;
            return false;
        L17:
            return true;
        }

        public final boolean c() {
            int r100 = this.f28466a;
            if (r100 != 2) goto L5;
            return true;
        L5:
            if (r100 == 5) goto L11;
            return false;
        L11:
            return true;
        }

        public final boolean d() {
            if (this.f28466a != 1) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean e() {
            int r100 = this.f28466a;
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L10;
            if (r100 == 4) goto L10;
            return false;
        L10:
            return true;
        }

        public final int a() {
            return this.f28466a;
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        private b(String r100, int r101, int r102) {
            super(r100, r101);
            this.f28466a = r102;
        }
    }

    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f28467a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f28468b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ c[] f28469c = null;

        static {
            c r100 = new c("HTTP", 0, 0);
            f28467a = r100;
            c r101 = new c("HTTPS", 1, 1);
            f28468b = r101;
            f28469c = new c[]{r100, r101};
        }

        public static c[] values() {
            return (c[]) f28469c.clone();
        }

        public static c valueOf(String r100) {
            return (c) r27.a.a(c.class, r100);
        }

        private c(String r100, int r101, int r102) {
            super(r100, r101);
        }
    }

    public byte[] getEntityBytes() {
        return null;
    }

    public String getIPDNSName() {
        return "";
    }

    public abstract Map<String, String> getParams();

    public abstract Map<String, String> getRequestHead();

    public String getSDKName() {
        return "";
    }

    public abstract String getURL();

    public boolean isIgnoreGZip() {
        return false;
    }

    public boolean isSupportIPV6() {
        return false;
    }

    public y7() {
        this.f28440c = 20000;
        this.f28441d = 20000;
        this.f28442e = null;
        this.f28438a = false;
        this.f28439b = 20000;
        this.f28444g = true;
        this.f28448k = false;
        this.f28449l = a.f28452a;
        this.f28450m = b.f28458b;
        this.f28451n = false;
    }

    final String a() {
        return a(getURL());
    }

    final String b() {
        return a(getIPV6URL());
    }

    public String getIPV6URL() {
        return getURL();
    }

    public boolean isIPRequest() {
        if (TextUtils.isEmpty(getIPDNSName()) == true) goto L6;
        return true;
    L6:
        return false;
    }

    public String parseSdkNameFromRequest() {
        String r100 = getSDKName();     // Catch: Throwable -> L12
    L10:
        th = th;
    L14:
        p6.a(th, "ht", "pnfr");
    L15:
        return r100;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L6;
    L16:
        goto L15
    L6:
        if (this.f28438a == false) goto L8;
        r100 = parseSDKNameFromPlatInfo(((s7) this).g());     // Catch: Throwable -> L10
        goto L16
    L8:
        r100 = parseSdkNameFromHeader(getRequestHead());     // Catch: Throwable -> L10
    L12:
        th = th;
        r100 = "";
        goto L14
    }

    public int getConntectionTimeout() {
        return this.f28440c;
    }

    public a getDegradeAbility() {
        return this.f28449l;
    }

    public b getDegradeType() {
        return this.f28450m;
    }

    public String getNon_degrade_final_Host() {
        return this.f28445h;
    }

    public Proxy getProxy() {
        return this.f28442e;
    }

    public int getReal_max_timeout() {
        return this.f28439b;
    }

    public int getSoTimeout() {
        return this.f28441d;
    }

    public r7.a getUrlConnectionImpl() {
        return this.f28443f;
    }

    public boolean isBinary() {
        return this.f28438a;
    }

    public boolean isHostToIP() {
        return this.f28444g;
    }

    public boolean isHttps() {
        return this.f28447j;
    }

    public boolean isIPV6Request() {
        return this.f28446i;
    }

    public boolean isKeepAlive() {
        return this.f28448k;
    }

    public boolean isTLSv3() {
        return this.f28451n;
    }

    private String a(String r100) {
        byte[] r101 = getEntityBytes();
        if (r101 != null) goto L5;
        return r100;
    L5:
        if (r101.length == 0) goto L13;
        Map<String, String> r102 = getParams();
        if (r102 != null) goto L10;
        return r100;
    L10:
        String r103 = v7.a(r102);
        StringBuffer r104 = new StringBuffer();
        r104.append(r100);
        r104.append("?");
        r104.append(r103);
        return r104.toString();
    L13:
        return r100;
    }

    public String parseSDKNameFromPlatInfo(String r100) {
        String r101 = "";
    L29:
        th = move-exception;
        p6.a(th, "ht", "pnfp");
    L31:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L31;
        String[] r102 = r100.split("&");     // Catch: Throwable -> L29
        if (r102.length <= 1) goto L31;
        int r103 = r102.length;     // Catch: Throwable -> L29
        int r104 = 0;
        String r105 = "";
    L8:
        if (r104 >= r103) goto L16;
        String r106 = r102[r104];     // Catch: Throwable -> L29
        if (r106.contains("sdkversion") == false) goto L13;
        r105 = r106;
    L13:
        if (r106.contains("product") == true) goto L18;
        r104 = r104 + 1;     // Catch: Throwable -> L29
    L18:
        if (TextUtils.isEmpty(r106) == true) goto L31;
        String[] r107 = r106.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L29
        if (r107.length <= 1) goto L31;
        r101 = r107[1].trim();     // Catch: Throwable -> L29
        if (TextUtils.isEmpty(r105) == true) goto L31;
        if (TextUtils.isEmpty(m6.a(r101)) == false) goto L31;
        String[] r108 = r105.split(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Throwable -> L29
        if (r108.length <= 1) goto L31;
        m6.a(r101, r108[1].trim());     // Catch: Throwable -> L29
        goto L31
    L16:
        r106 = "";
        goto L18
    }

    public String parseSdkNameFromHeader(Map<String, String> r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
    L9:
        th = move-exception;
        p6.a(th, "ht", "pnfh");
        return null;
    L6:
        if (r100.containsKey("platinfo") == false) goto L14;
        return parseSDKNameFromPlatInfo(r100.get("platinfo"));
    L14:
        return null;
    }

    public void setBinary(boolean r100) {
        this.f28438a = r100;
    }

    public final void setConnectionTimeout(int r100) {
        this.f28440c = r100;
    }

    public void setDegradeAbility(a r100) {
        this.f28449l = r100;
    }

    public void setDegradeType(b r100) {
        this.f28450m = r100;
    }

    public void setHostToIP(boolean r100) {
        this.f28444g = r100;
    }

    public void setHttpProtocol(c r100) {
        if (r100 != c.f28468b) goto L5;
        boolean r101 = true;
    L6:
        this.f28447j = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setIPV6Request(boolean r100) {
        this.f28446i = r100;
    }

    public void setKeepAlive(boolean r100) {
        this.f28448k = r100;
    }

    public void setNon_degrade_final_Host(String r100) {
        this.f28445h = r100;
    }

    public final void setProxy(Proxy r100) {
        this.f28442e = r100;
    }

    public void setReal_max_timeout(int r100) {
        this.f28439b = r100;
    }

    public final void setSoTimeout(int r100) {
        this.f28441d = r100;
    }

    public void setTLSv3(boolean r100) {
        this.f28451n = r100;
    }

    public void setUrlConnectionImpl(r7.a r100) {
        this.f28443f = r100;
    }
}
