package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import androidx.room.AbstractC0351g;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.utils.Consts;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: A, reason: collision with root package name */
    private static String f5077A = "BDLocConfigManager";

    /* renamed from: B, reason: collision with root package name */
    private SharedPreferences f5078B;

    /* renamed from: C, reason: collision with root package name */
    private long f5079C;

    /* renamed from: D, reason: collision with root package name */
    private String f5080D;

    /* renamed from: E, reason: collision with root package name */
    private C0008a f5081E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f5082F;

    /* renamed from: G, reason: collision with root package name */
    private String f5083G;

    /* renamed from: H, reason: collision with root package name */
    private String f5084H;

    /* renamed from: I, reason: collision with root package name */
    private String f5085I;

    /* renamed from: J, reason: collision with root package name */
    private Context f5086J;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5087a;

    /* renamed from: b, reason: collision with root package name */
    public int f5088b;

    /* renamed from: c, reason: collision with root package name */
    public double f5089c;

    /* renamed from: d, reason: collision with root package name */
    public int f5090d;

    /* renamed from: e, reason: collision with root package name */
    public int f5091e;

    /* renamed from: f, reason: collision with root package name */
    public double f5092f;

    /* renamed from: g, reason: collision with root package name */
    public int f5093g;

    /* renamed from: h, reason: collision with root package name */
    public int f5094h;

    /* renamed from: i, reason: collision with root package name */
    public int f5095i;

    /* renamed from: j, reason: collision with root package name */
    public int f5096j;

    /* renamed from: k, reason: collision with root package name */
    public int f5097k;

    /* renamed from: l, reason: collision with root package name */
    public int f5098l;

    /* renamed from: m, reason: collision with root package name */
    public double[] f5099m;

    /* renamed from: n, reason: collision with root package name */
    public int f5100n;

    /* renamed from: o, reason: collision with root package name */
    public int f5101o;

    /* renamed from: p, reason: collision with root package name */
    public int f5102p;

    /* renamed from: q, reason: collision with root package name */
    public int f5103q;

    /* renamed from: r, reason: collision with root package name */
    public int f5104r;

    /* renamed from: s, reason: collision with root package name */
    public float f5105s;

    /* renamed from: t, reason: collision with root package name */
    public float f5106t;

    /* renamed from: u, reason: collision with root package name */
    public int f5107u;

    /* renamed from: v, reason: collision with root package name */
    public int[] f5108v;

    /* renamed from: w, reason: collision with root package name */
    public int f5109w;

    /* renamed from: x, reason: collision with root package name */
    public int f5110x;

    /* renamed from: y, reason: collision with root package name */
    public int f5111y;

    /* renamed from: z, reason: collision with root package name */
    public int f5112z;

    /* renamed from: com.baidu.location.b.a$a, reason: collision with other inner class name */
    public class C0008a extends com.baidu.location.e.f {

        /* renamed from: a, reason: collision with root package name */
        String f5113a = null;

        /* renamed from: b, reason: collision with root package name */
        boolean f5114b = false;

        public C0008a() {
            this.el = new HashMap();
        }

        @Override // com.baidu.location.e.f
        public void a() {
            this.ei = 2;
            String strEncode = Jni.encode(this.f5113a);
            this.f5113a = null;
            this.el.put("qt", "conf");
            this.el.put("req", strEncode);
        }

        public void a(String str) {
            if (this.f5114b) {
                return;
            }
            this.f5114b = true;
            this.f5113a = str;
            b(com.baidu.location.e.d.f5844f);
        }

        @Override // com.baidu.location.e.f
        public void a(boolean z4) {
            if (z4 && this.ej != null) {
                try {
                    new JSONObject(this.ej);
                    if (a.this.f5078B != null) {
                        SharedPreferences.Editor editorEdit = a.this.f5078B.edit();
                        editorEdit.putString(a.f5077A + "_newConfig", Base64.encodeToString(com.baidu.location.e.h.a(this.ej.getBytes()), 0));
                        editorEdit.apply();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
            this.f5114b = false;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5116a = new a();
    }

    private a() {
        this.f5078B = null;
        this.f5087a = false;
        this.f5088b = 16;
        this.f5079C = 300L;
        this.f5089c = 0.75d;
        this.f5090d = 0;
        this.f5091e = 1;
        this.f5092f = -0.10000000149011612d;
        this.f5093g = 0;
        this.f5094h = 1;
        this.f5095i = 1;
        this.f5096j = 10;
        this.f5097k = 3;
        this.f5098l = 40;
        this.f5100n = 1;
        this.f5101o = 0;
        this.f5102p = 1;
        this.f5103q = 1;
        this.f5104r = 0;
        this.f5105s = 0.2f;
        this.f5106t = 0.8f;
        this.f5107u = 0;
        this.f5108v = null;
        this.f5109w = 8;
        this.f5110x = 4000;
        this.f5111y = 1;
        this.f5112z = 1;
        this.f5080D = null;
        this.f5081E = null;
        this.f5082F = false;
        this.f5083G = null;
        this.f5084H = null;
        this.f5085I = null;
        this.f5086J = null;
    }

    private String c() {
        StringBuilder sb = new StringBuilder("v9.643|");
        sb.append(this.f5084H);
        sb.append(Consts.SPLITTER_DETAIL);
        String str = Build.MODEL;
        sb.append(str);
        sb.append("&cu=");
        sb.append(this.f5084H);
        sb.append("&mb=");
        sb.append(str);
        return sb.toString();
    }

    public static a a() {
        return b.f5116a;
    }

    public synchronized void a(double d4, double d5, String str) {
        SharedPreferences sharedPreferences;
        try {
            if (this.f5085I == null && str != null) {
                try {
                    if (str.equals("bd09") || str.equals("wgs84mc")) {
                        double[] dArrCoorEncrypt = Jni.coorEncrypt(d5, d4, BDLocation.BDLOCATION_BD09_TO_GCJ02);
                        double d6 = dArrCoorEncrypt[1];
                        double d7 = dArrCoorEncrypt[0];
                        d4 = d6;
                        d5 = d7;
                    }
                    String str2 = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d5), Double.valueOf(d4));
                    this.f5085I = str2;
                    String strEncodeToString = Base64.encodeToString(str2.getBytes(Constants.UTF_8_CODE), 0);
                    if (strEncodeToString != null && (sharedPreferences = this.f5078B) != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(f5077A + "_loc", strEncodeToString);
                        editorEdit.apply();
                    }
                } catch (Exception unused) {
                    this.f5085I = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void a(Context context, LocationClientOption locationClientOption, String str) {
        try {
            if (!this.f5082F && context != null) {
                this.f5082F = true;
                this.f5086J = context;
                if (locationClientOption == null) {
                    locationClientOption = new LocationClientOption();
                }
                this.f5083G = context.getPackageName();
                l.a().a(this.f5086J);
                try {
                    this.f5084H = LBSAuthManager.getInstance(context).getCUID();
                } catch (Throwable unused) {
                    this.f5084H = null;
                }
                if (this.f5078B == null) {
                    this.f5078B = context.getSharedPreferences(f5077A + "BDLocConfig", 0);
                }
                SharedPreferences sharedPreferences = this.f5078B;
                if (sharedPreferences != null) {
                    long j4 = sharedPreferences.getLong(f5077A + "_lastCheckTime", 0L);
                    String string = this.f5078B.getString(f5077A + "_config", "");
                    String string2 = this.f5078B.getString(f5077A + "_newConfig", "");
                    if (!TextUtils.isEmpty(string2)) {
                        a(new String(com.baidu.location.e.h.b(Base64.decode(string2, 0))));
                    } else if (!TextUtils.isEmpty(string)) {
                        a(string);
                        SharedPreferences.Editor editorEdit = this.f5078B.edit();
                        editorEdit.remove(f5077A + "_config");
                        editorEdit.apply();
                    }
                    if (Math.abs((System.currentTimeMillis() / 1000) - j4) > this.f5079C) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        SharedPreferences.Editor editorEdit2 = this.f5078B.edit();
                        editorEdit2.putLong(f5077A + "_lastCheckTime", jCurrentTimeMillis);
                        editorEdit2.apply();
                        a(locationClientOption);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(LocationClientOption locationClientOption) throws Throwable {
        StringBuilder sb = new StringBuilder("&ver=");
        sb.append(com.baidu.location.e.h.f5938x);
        sb.append("&usr=");
        sb.append(c());
        sb.append("&app=");
        sb.append(this.f5083G);
        sb.append("&prod=");
        String strR = B0.g.r(sb, locationClientOption.prodName, "&newwf=1");
        String strSubstring = Build.VERSION.RELEASE;
        if (strSubstring != null && strSubstring.length() > 6) {
            strSubstring = strSubstring.substring(0, 6);
        }
        String strQ = AbstractC0351g.q(strR, "&sv=", strSubstring);
        String strB = com.baidu.location.e.h.b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(strB)) {
            strQ = AbstractC0351g.q(strQ, "&miui=", strB);
        }
        String strJ = com.baidu.location.e.h.j();
        if (!TextUtils.isEmpty(strJ)) {
            strQ = AbstractC0351g.q(strQ, "&mtk=", strJ);
        }
        SharedPreferences sharedPreferencesA = s.a(this.f5086J);
        String string = sharedPreferencesA != null ? sharedPreferencesA.getString("mapcity", null) : null;
        if (!TextUtils.isEmpty(string)) {
            strQ = AbstractC0351g.q(strQ, "&city=", string);
        }
        String strP = AbstractC0351g.p(AbstractC0351g.p(strQ, "&sdk=9.643"), "&stp=1");
        String string2 = this.f5078B.getString(f5077A + "_loc", null);
        if (!TextUtils.isEmpty(string2)) {
            try {
                strP = strP + "&loc=" + new String(Base64.decode(string2, 0), Constants.UTF_8_CODE);
            } catch (Exception unused) {
            }
        }
        StringBuilder sbV = B0.g.v(strP, "&cnloc=");
        sbV.append(l.a().b());
        String string3 = sbV.toString();
        if (this.f5081E == null) {
            this.f5081E = new C0008a();
        }
        this.f5081E.a(string3);
    }

    private void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.f5087a = true;
            }
            if (jSONObject.has("wfnum")) {
                this.f5088b = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.f5079C = jSONObject.getLong("freq");
            }
            if (jSONObject.has("wfsm")) {
                this.f5089c = jSONObject.getDouble("wfsm");
            }
            if (jSONObject.has("idmoc")) {
                this.f5090d = jSONObject.getInt("idmoc");
            }
            if (jSONObject.has("gnmcrm")) {
                this.f5092f = jSONObject.getDouble("gnmcrm");
            }
            if (jSONObject.has("gnmcon")) {
                this.f5093g = jSONObject.getInt("gnmcon");
            }
            if (jSONObject.has("lpcs")) {
                this.f5091e = jSONObject.getInt("lpcs");
            }
            if (jSONObject.has("iupl")) {
                this.f5094h = jSONObject.getInt("iupl");
            }
            if (jSONObject.has("opetco")) {
                this.f5095i = jSONObject.getInt("opetco");
            }
            if (jSONObject.has("ct")) {
                this.f5096j = jSONObject.getInt("ct");
            }
            if (jSONObject.has("suci")) {
                this.f5097k = jSONObject.getInt("suci");
            }
            if (jSONObject.has("smn")) {
                this.f5098l = jSONObject.getInt("smn");
            }
            if (jSONObject.has("bcar")) {
                a(jSONObject);
            }
            if (jSONObject.has("ums")) {
                this.f5100n = jSONObject.getInt("ums");
            }
            if (jSONObject.has("hpdts")) {
                this.f5101o = jSONObject.getInt("hpdts");
            }
            if (jSONObject.has("oldts")) {
                this.f5102p = jSONObject.getInt("oldts");
            }
            if (jSONObject.has("nlp_loc_coarse")) {
                this.f5103q = jSONObject.optInt("nlp_loc_coarse");
            }
            if (jSONObject.has("new_loc_cache_switch")) {
                this.f5104r = jSONObject.optInt("new_loc_cache_switch");
            }
            if (jSONObject.has("nc_same_rate")) {
                this.f5105s = (float) jSONObject.optDouble("nc_same_rate", 0.8d);
            }
            if (jSONObject.has("cl_str_change_rate")) {
                this.f5106t = (float) jSONObject.optDouble("cl_str_change_rate", 0.2d);
            }
            if (jSONObject.has("cl_list_switch")) {
                this.f5107u = jSONObject.optInt("cl_list_switch", 0);
            }
            if (jSONObject.has("cl_str_switch")) {
                String[] strArrSplit = jSONObject.optString("cl_str_switch", "").split(",");
                this.f5108v = new int[strArrSplit.length];
                int i4 = 0;
                for (String str2 : strArrSplit) {
                    this.f5108v[i4] = 0;
                    if (str2.length() > 0) {
                        try {
                            this.f5108v[i4] = Integer.parseInt(str2);
                        } catch (Throwable unused) {
                        }
                    }
                    i4++;
                }
            }
            if (jSONObject.has("cell_number")) {
                this.f5109w = jSONObject.optInt("cell_number", 10);
            }
            if (jSONObject.has("loc_str_length")) {
                this.f5110x = jSONObject.optInt("loc_str_length", 4000);
            }
            if (jSONObject.has("loc_to_foreground")) {
                this.f5111y = jSONObject.optInt("loc_to_foreground", 1);
            }
            if (jSONObject.has("hils")) {
                this.f5112z = jSONObject.optInt("hils", 1);
            }
            this.f5080D = str;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            double[] dArr = this.f5099m;
            if (dArr != null && dArr.length > 0) {
                this.f5099m = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.f5099m == null) {
                    this.f5099m = new double[jSONArray.length() * 4];
                }
                int i4 = 0;
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    this.f5099m[i4] = jSONArray.getJSONObject(i5).getDouble("x1");
                    this.f5099m[i4 + 1] = jSONArray.getJSONObject(i5).getDouble("y1");
                    int i6 = i4 + 3;
                    this.f5099m[i4 + 2] = jSONArray.getJSONObject(i5).getDouble("x2");
                    i4 += 4;
                    this.f5099m[i6] = jSONArray.getJSONObject(i5).getDouble("y2");
                }
            } catch (Exception unused) {
            }
        }
    }
}
