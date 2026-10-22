package Z7;

import android.content.Context;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.as;
import java.io.IOException;
import java.util.Map;

/* renamed from: Z7.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1152y implements Y7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7653a;

    /* renamed from: b, reason: collision with root package name */
    public final as f7654b;

    /* renamed from: c, reason: collision with root package name */
    public final C1130b f7655c;

    /* renamed from: d, reason: collision with root package name */
    public final C1131c f7656d;

    public C1152y(Context context, C1130b c1130b, as asVar, C1131c c1131c) {
        this.f7653a = context;
        this.f7654b = asVar;
        this.f7655c = c1130b;
        this.f7656d = c1131c;
    }

    @Override // Y7.a
    public final CrashDetailBean a(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, byte[] bArr, Map<String, String> map, boolean z10, boolean z11) throws IOException {
        int i10;
        String str12;
        int iIndexOf;
        boolean zH = r.a().h();
        if (zH) {
            C1139k.j("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f31498b = 1;
        crashDetailBean.f31501e = this.f7655c.u();
        C1130b c1130b = this.f7655c;
        crashDetailBean.f31502f = c1130b.f7422D;
        crashDetailBean.f31503g = c1130b.E();
        crashDetailBean.f31509m = this.f7655c.t();
        crashDetailBean.f31510n = str3;
        crashDetailBean.f31511o = zH ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.f31512p = str4;
        String str13 = str5 != null ? str5 : "";
        crashDetailBean.f31513q = str13;
        crashDetailBean.f31514r = j10;
        crashDetailBean.f31517u = C1143o.I(str13.getBytes());
        crashDetailBean.f31470A = str;
        crashDetailBean.f31471B = str2;
        crashDetailBean.f31481L = this.f7655c.G();
        crashDetailBean.f31504h = this.f7655c.D();
        crashDetailBean.f31505i = this.f7655c.a();
        crashDetailBean.f31518v = str8;
        String strQ = NativeCrashHandler.r() != null ? NativeCrashHandler.q() : null;
        String strG = z.g(strQ, str8);
        if (!C1143o.G(strG)) {
            crashDetailBean.f31495Z = strG;
        }
        crashDetailBean.f31497aa = z.k(strQ);
        crashDetailBean.f31519w = z.f(str9, r.f7584n, r.f7588r, r.f7593w);
        crashDetailBean.f31520x = z.f(str10, r.f7584n, null, true);
        crashDetailBean.f31483N = str7;
        crashDetailBean.f31484O = str6;
        crashDetailBean.f31485P = str11;
        crashDetailBean.f31475F = this.f7655c.y();
        crashDetailBean.f31476G = this.f7655c.x();
        crashDetailBean.f31477H = this.f7655c.z();
        crashDetailBean.f31478I = ab.c(this.f7653a);
        crashDetailBean.f31479J = ab.j();
        crashDetailBean.f31480K = ab.k();
        if (!z10) {
            crashDetailBean.f31472C = -1L;
            crashDetailBean.f31473D = -1L;
            crashDetailBean.f31474E = -1L;
            if (crashDetailBean.f31519w == null) {
                crashDetailBean.f31519w = "This crash occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.f31486Q = -1L;
            crashDetailBean.f31490U = -1;
            crashDetailBean.f31491V = -1;
            crashDetailBean.f31492W = map;
            crashDetailBean.f31493X = this.f7655c.J();
            crashDetailBean.f31522z = null;
            if (str == null) {
                crashDetailBean.f31470A = "unknown(record)";
            }
            if (bArr != null) {
                crashDetailBean.f31521y = bArr;
            }
            return crashDetailBean;
        }
        crashDetailBean.f31472C = ab.m();
        crashDetailBean.f31473D = ab.i();
        crashDetailBean.f31474E = ab.o();
        crashDetailBean.f31521y = C1142n.b();
        C1130b c1130b2 = this.f7655c;
        crashDetailBean.f31486Q = c1130b2.f7449c;
        crashDetailBean.f31487R = c1130b2.k();
        crashDetailBean.f31522z = C1143o.q(this.f7655c.f7470m0, r.f7585o);
        int iIndexOf2 = crashDetailBean.f31513q.indexOf("java:\n");
        if (iIndexOf2 > 0 && (i10 = iIndexOf2 + 6) < crashDetailBean.f31513q.length()) {
            String str14 = crashDetailBean.f31513q;
            String strSubstring = str14.substring(i10, str14.length() - 1);
            if (strSubstring.length() > 0 && crashDetailBean.f31522z.containsKey(crashDetailBean.f31471B) && (iIndexOf = (str12 = crashDetailBean.f31522z.get(crashDetailBean.f31471B)).indexOf(strSubstring)) > 0) {
                String strSubstring2 = str12.substring(iIndexOf);
                crashDetailBean.f31522z.put(crashDetailBean.f31471B, strSubstring2);
                crashDetailBean.f31513q = crashDetailBean.f31513q.substring(0, i10);
                crashDetailBean.f31513q += strSubstring2;
            }
        }
        if (str == null) {
            crashDetailBean.f31470A = this.f7655c.f7455f;
        }
        crashDetailBean.f31490U = this.f7655c.K();
        C1130b c1130b3 = this.f7655c;
        crashDetailBean.f31491V = c1130b3.f7435Q;
        crashDetailBean.f31492W = c1130b3.H();
        crashDetailBean.f31493X = this.f7655c.J();
        return crashDetailBean;
    }
}
