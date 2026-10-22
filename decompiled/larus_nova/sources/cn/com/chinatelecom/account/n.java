package cn.com.chinatelecom.account;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.ClientUtils;
import cn.com.chinatelecom.account.api.CtAuth;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f24415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f24416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f24417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f24418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f24419h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f24420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f24421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f24422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f24423l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f24424m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f24425n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f24426o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f24427p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f24428q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f24429r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f24430s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f24431t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private StringBuffer f24432u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f24433v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f24434w;

    public n(String r100) {
        this.f24429r = -1;
        this.f24432u = new StringBuffer();
        this.f24414c = "";
        this.f24416e = "";
        this.f24425n = "";
        this.f24424m = "";
        this.f24427p = "";
        this.f24412a = "1.2";
        this.f24433v = SystemClock.uptimeMillis();
        this.f24413b = a(System.currentTimeMillis());
        this.f24415d = CtAuth.mAppId;
        this.f24417f = "";
        this.f24418g = Build.BRAND;
        this.f24419h = Build.MODEL;
        this.f24420i = "Android";
        this.f24421j = Build.VERSION.RELEASE;
        this.f24422k = ClientUtils.getSdkVersion();
        this.f24423l = r100;
        this.f24430s = "0";
    }

    public static String a(long r100) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA).format(new Date(r100));
    L4:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public n a(int r100) {
        this.f24426o = r100;
        return this;
    }

    public n a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        StringBuffer r101 = this.f24432u;
        r101.append(r100);
        r101.append(com.alipay.sdk.m.u.i.f25853b);
    L5:
        return this;
    }

    public void a() {
        long r100 = SystemClock.uptimeMillis();
        this.f24434w = r100;
        if (this.f24429r != (-1)) goto L6;
        this.f24429r = r100 - this.f24433v;
        return;
    }

    public n b(int r100) {
        this.f24431t = r100;
        return this;
    }

    public n b(long r100) {
        if (r100 <= 0) goto L5;
        this.f24428q = r100;
    L5:
        return this;
    }

    public n b(String r100) {
        this.f24424m = r100;
        return this;
    }

    public String b() {
        return this.f24423l;
    }

    public n c(String r100) {
        this.f24416e = r100;
        return this;
    }

    public n d(String r100) {
        this.f24427p = r100;
        return this;
    }

    public n e(String r100) {
        this.f24417f = r100;
        return this;
    }

    public n f(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.f24430s = r100;
    L5:
        return this;
    }

    public n g(String r100) {
        this.f24425n = r100;
        return this;
    }

    public String toString() {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L4
        r100.put(BaseSwitches.V, this.f24412a);     // Catch: Throwable -> L4
        r100.put("t", this.f24413b);     // Catch: Throwable -> L4
        r100.put("tag", this.f24414c);     // Catch: Throwable -> L4
        r100.put("ai", this.f24415d);     // Catch: Throwable -> L4
        r100.put("di", this.f24416e);     // Catch: Throwable -> L4
        r100.put("ns", this.f24417f);     // Catch: Throwable -> L4
        r100.put(SRStrategy.MEDIAINFO_KEY_BITRATE, this.f24418g);     // Catch: Throwable -> L4
        r100.put("ml", this.f24419h);     // Catch: Throwable -> L4
        r100.put("os", this.f24420i);     // Catch: Throwable -> L4
        r100.put("ov", this.f24421j);     // Catch: Throwable -> L4
        r100.put(com.alipay.sdk.m.s.a.f25762t, this.f24422k);     // Catch: Throwable -> L4
        r100.put("ri", this.f24423l);     // Catch: Throwable -> L4
        r100.put("api", this.f24424m);     // Catch: Throwable -> L4
        r100.put("p", this.f24425n);     // Catch: Throwable -> L4
        r100.put("rt", this.f24426o);     // Catch: Throwable -> L4
        r100.put("msg", this.f24427p);     // Catch: Throwable -> L4
        r100.put(Segment.JsonKey.START, this.f24428q);     // Catch: Throwable -> L4
        r100.put("tt", this.f24429r);     // Catch: Throwable -> L4
        r100.put("ot", this.f24430s);     // Catch: Throwable -> L4
        r100.put("rec", this.f24431t);     // Catch: Throwable -> L4
        r100.put("ep", this.f24432u.toString());     // Catch: Throwable -> L4
        return r100.toString();
    L4:
        th = move-exception;
        th.printStackTrace();
        return "";
    }
}
