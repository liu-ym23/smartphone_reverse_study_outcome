package com.alipay.sdk.m.k;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.c;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class b {
    public static final String A = "SSLDenied";
    public static final String A0 = "out_trade_no";
    public static final String B = "H5PayDataAnalysisError";
    public static final String B0 = "trade_no";
    public static final String C = "H5AuthDataAnalysisError";
    public static final String C0 = "biz_content";
    public static final String D = "PublicKeyUnmatch";
    public static final String D0 = "app_id";
    public static final String E = "ClientBindFailed";
    public static final String F = "TriDesEncryptError";
    public static final String G = "TriDesDecryptError";
    public static final String H = "ClientBindException";
    public static final String I = "SaveTradeTokenError";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final String f25395J = "ClientBindServiceFailed";
    public static final String K = "TryStartServiceEx";
    public static final String L = "BindWaitTimeoutEx";
    public static final String M = "CheckClientExistEx";
    public static final String N = "CheckClientSignEx";
    public static final String O = "GetInstalledAppEx";
    public static final String P = "ParserTidClientKeyEx";
    public static final String Q = "PgApiInvoke";
    public static final String R = "PgBindStarting";
    public static final String S = "PgBinded";
    public static final String T = "PgBindEnd";
    public static final String U = "PgBindPay";
    public static final String V = "PgReturn";
    public static final String W = "PgReturnV";
    public static final String X = "PgWltVer";
    public static final String Y = "PgOpenStarting";
    public static final String Z = "ErrIntentEx";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f25396a0 = "ErrActNull";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f25397b0 = "ErrActEx";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f25398c0 = "ErrActNull2";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f25399d0 = "ErrActEx2";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f25400e0 = "ErrActNotCreated";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f25401f0 = "GetInstalledAppEx";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f25402g0 = "StartLaunchAppTransEx";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f25403h0 = "CheckLaunchAppExistEx";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f25404i0 = "LogBindCalledH5";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f25405j0 = "LogCalledH5";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25406k = "net";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f25407k0 = "LogHkLoginByIntent";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25408l = "biz";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f25409l0 = "SchemePayWrongHashEx";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25410m = "cp";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final String f25411m0 = "LogAppFetchConfigTimeout";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25412n = "auth";

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final String f25413n0 = "H5CbUrlEmpty";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25414o = "third";

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final String f25415o0 = "H5CbEx";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25416p = "wlt";

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final String f25417p0 = "StartActivityEx";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f25418q = "FormatResultEx";

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final String f25419q0 = "JSONEx";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f25420r = "GetApdidEx";

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final String f25421r0 = "ParseBundleSerializableError";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f25422s = "GetApdidNull";

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final String f25423s0 = "ParseSchemeQueryError";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f25424t = "GetApdidTimeout";

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final String f25425t0 = "TbChk";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f25426u = "GetUtdidEx";

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final String f25427u0 = "TbStart";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f25428v = "GetPackageInfoEx";

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final String f25429v0 = "TbCancel";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f25430w = "NotIncludeSignatures";

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String f25431w0 = "TbUnknown";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f25432x = "GetPublicKeyFromSignEx";

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final String f25433x0 = "TbOk";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f25434y = "webError";

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final String f25435y0 = "TbActFail";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f25436z = "SSLError";

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f25437z0 = "partner";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f25439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f25443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f25444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f25445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f25446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f25447j;

    public static String b() {
        return String.format("%s,%s", new Object[]{e(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date())});
    }

    public static String c() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    private boolean d() {
        return TextUtils.isEmpty(this.f25446i);
    }

    public static String a() {
        return String.format("%s,%s,-,-,-", new Object[]{c(com.alipay.sdk.m.t.a.a(com.alipay.sdk.m.s.b.d().b()).d()), c(com.alipay.sdk.m.s.b.d().c())});
    }

    public static String e() {
        return UUID.randomUUID().toString();
    L4:
        return "12345678uuid";
    }

    public static String a(PackageInfo r100) {
        if (r100 == null) goto L22;
        Signature[] r101 = r100.signatures;
        if (r101 != null) goto L7;
        return "0";
    L7:
        if (r101.length == 0) goto L33;
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L21
        r102.append(r100.signatures.length);     // Catch: Throwable -> L21
        Signature[] r103 = r100.signatures;     // Catch: Throwable -> L21
        int r104 = r103.length;     // Catch: Throwable -> L21
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L19;
        String r106 = n.a(null, r103[r105].toByteArray());     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r106) == true) goto L17;
        String r107 = n.g(r106).substring(0, 8);     // Catch: Throwable -> L24
    L18:
        r102.append("-");     // Catch: Throwable -> L21
        r102.append(r107);     // Catch: Throwable -> L21
        r105 = r105 + 1;     // Catch: Throwable -> L21
    L17:
        r107 = "?";
        goto L18
    L19:
        return r102.toString();
    L21:
        return "?";
    L33:
        return "0";
    L22:
        return "0";
    }

    public static String b(String r110) {
        if (r110 != null) goto L5;
        r110 = "";
    L5:
        String[] r111 = r110.split("&");
        String r100 = null;
        if (r111 == null) goto L34;
        int r101 = r111.length;
        String r102 = null;
        String r103 = null;
        int r104 = 0;
    L8:
        if (r104 >= r101) goto L36;
        String[] r105 = r111[r104].split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r105 == null) goto L33;
        if (r105.length != 2) goto L33;
        if (r105[0].equalsIgnoreCase(f25437z0) == false) goto L17;
        r100 = r105[1].replace("\"", "");
        goto L33
    L17:
        if (r105[0].equalsIgnoreCase(A0) == false) goto L20;
        r102 = r105[1].replace("\"", "");
        goto L33
    L20:
        if (r105[0].equalsIgnoreCase(B0) == false) goto L23;
        r103 = r105[1].replace("\"", "");
        goto L33
    L23:
        if (r105[0].equalsIgnoreCase(C0) == false) goto L29;
        JSONObject r112 = new JSONObject(n.e(com.alipay.sdk.m.s.a.h(), r105[1]));     // Catch: Throwable -> L37
        if (TextUtils.isEmpty(r102) == false) goto L33;
        r102 = r112.getString(A0);     // Catch: Throwable -> L37
        goto L33
    L29:
        if (r105[0].equalsIgnoreCase("app_id") == false) goto L33;
        if (TextUtils.isEmpty(r100) == false) goto L33;
        r100 = r105[1];     // Catch: Throwable -> L37
    L33:
        r104 = r104 + 1;
    L36:
        return String.format("%s,%s,-,%s,-,-,-", new Object[]{c(r103), c(r102), c(r100)});
    L34:
        r102 = null;
        r103 = null;
        goto L36
    }

    public static String c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return "";
    L7:
        return r100.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", Constants.WAVE_SEPARATOR).replace("#", "＃");
    }

    public static String d(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "-";
    L6:
        return r100;
    }

    public static String a(Context r100) {
        String r101 = "-";
        if (r100 != null) goto L12;
    L7:
        String r102 = "-";
    L9:
        return String.format("%s,%s,-,-,-", new Object[]{c(r102), c(r101)});
    L12:
        Context r103 = r100.getApplicationContext();     // Catch: Throwable -> L11
        r102 = r103.getPackageName();     // Catch: Throwable -> L11
        PackageInfo r104 = r103.getPackageManager().getPackageInfo(r102, 64);     // Catch: Throwable -> L10
        r101 = r104.versionName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + a(r104);     // Catch: Throwable -> L10
        goto L9
    }

    public static String b(Context r100) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[]{c(c.c(r100)), "android", c(Build.VERSION.RELEASE), c(Build.MODEL), "-", "0", c(c.d(r100).b()), "gw", c(com.alipay.sdk.m.w.b.b(null, r100))});
    }

    public String a(String r100) {
        String r101 = b(r100);
        this.f25439b = r101;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[]{this.f25438a, r101, this.f25440c, this.f25441d, this.f25442e, this.f25443f, this.f25444g, d(this.f25445h), d(this.f25446i), this.f25447j});
    }

    public static String a(Throwable r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        StringBuffer r101 = new StringBuffer();
        r101.append(r100.getClass().getName());     // Catch: Throwable -> L18
        r101.append(":");     // Catch: Throwable -> L18
        r101.append(r100.getMessage());     // Catch: Throwable -> L18
        r101.append(" 》 ");     // Catch: Throwable -> L18
        StackTraceElement[] r102 = r100.getStackTrace();     // Catch: Throwable -> L18
        if (r102 == null) goto L17;
        int r103 = r102.length;     // Catch: Throwable -> L18
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r104 >= r103) goto L17;
        r101.append(r102[r104].toString());     // Catch: Throwable -> L18
        r101.append(" 》 ");     // Catch: Throwable -> L18
        r105 = r105 + 1;
        if (r105 > 5) goto L17;
        r104 = r104 + 1;
    L17:
        return r101.toString();
    }

    public static String a(long r100) {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", new Object[]{c("15.8.15"), c("h.a.3.8.15"), Constants.WAVE_SEPARATOR + r100});
    }

    public b(Context r100, boolean r101) {
        this.f25445h = "";
        this.f25446i = "";
        if (r100 == null) goto L5;
        r100 = r100.getApplicationContext();
    L5:
        this.f25438a = b();
        this.f25440c = a(r100);
        if (r101 == false) goto L8;
        long r102 = 0;
    L9:
        this.f25441d = a(r102);
        this.f25442e = a();
        this.f25443f = b(r100);
        this.f25444g = "-";
        this.f25447j = "-";
        return;
    L8:
        r102 = a.e.a(r100);
        goto L9
    }

    public void a(String r100, String r101) {
        c("", r100, r101);
    }

    private synchronized void c(String r100, String r110, String r111) {
        monitor-enter(this);
        e.d(com.alipay.sdk.m.l.a.A, String.format("event %s %s %s", new Object[]{r100, r110, r111}));     // Catch: Throwable -> L14
        String r101 = "";
        if (TextUtils.isEmpty(this.f25445h) == true) goto L7;
        r101 = "^";
    L7:
        StringBuilder r102 = new StringBuilder();     // Catch: Throwable -> L14
        r102.append(r101);     // Catch: Throwable -> L14
        Object[] r103 = new Object[4];     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r100) == false) goto L10;
        String r104 = "-";
    L11:
        r103[0] = r104;     // Catch: Throwable -> L14
        r103[1] = c(r110);     // Catch: Throwable -> L14
        r103[2] = c(r111);     // Catch: Throwable -> L14
        r103[3] = c(c());     // Catch: Throwable -> L14
        r102.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", r103));     // Catch: Throwable -> L14
        this.f25445h += r102.toString();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r104 = c(r100);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private synchronized void d(String r100, String r101, String r110) {
        monitor-enter(this);
        e.c(com.alipay.sdk.m.l.a.A, String.format("err %s %s %s", new Object[]{r100, r101, r110}));     // Catch: Throwable -> L14
        String r102 = "";
        if (TextUtils.isEmpty(this.f25446i) == true) goto L7;
        r102 = "^";
    L7:
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L14
        r103.append(r102);     // Catch: Throwable -> L14
        Object[] r104 = new Object[4];     // Catch: Throwable -> L14
        r104[0] = r100;     // Catch: Throwable -> L14
        r104[1] = r101;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r110) == false) goto L10;
        String r105 = "-";
    L11:
        r104[2] = r105;     // Catch: Throwable -> L14
        r104[3] = c(c());     // Catch: Throwable -> L14
        r103.append(String.format("%s,%s,%s,%s", r104));     // Catch: Throwable -> L14
        this.f25446i += r103.toString();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r105 = c(r110);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public void a(String r100, String r101, String r102) {
        c("", r100, r101 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + r102);
    }

    public void b(String r100, String r101, String r102) {
        d(r100, r101, r102);
    }

    public void a(String r100, String r101, Throwable r102) {
        d(r100, r101, a(r102));
    }

    public void a(String r100, String r101, Throwable r102, String r103) {
        d(r100, r101, r103 + ": " + a(r102));
    }
}
