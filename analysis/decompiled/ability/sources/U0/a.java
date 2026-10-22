package U0;

import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: A, reason: collision with root package name */
    public JSONObject f1250A;

    /* renamed from: B, reason: collision with root package name */
    public String f1251B;

    /* renamed from: D, reason: collision with root package name */
    public long f1253D;
    public long E;

    /* renamed from: a, reason: collision with root package name */
    public int f1254a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String l;
    public int m;
    public String n;
    public String o;
    public String p;

    /* renamed from: q, reason: collision with root package name */
    public String f1256q;

    /* renamed from: r, reason: collision with root package name */
    public long f1257r;

    /* renamed from: s, reason: collision with root package name */
    public String f1258s;

    /* renamed from: t, reason: collision with root package name */
    public String f1259t;
    public String u;

    /* renamed from: v, reason: collision with root package name */
    public long f1260v;

    /* renamed from: w, reason: collision with root package name */
    public long f1261w;

    /* renamed from: x, reason: collision with root package name */
    public String f1262x;
    public JSONObject y;

    /* renamed from: z, reason: collision with root package name */
    public JSONObject f1263z;

    /* renamed from: j, reason: collision with root package name */
    public String f1255j = "Android";
    public String k = AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME;

    /* renamed from: C, reason: collision with root package name */
    public long f1252C = -1;

    public final String toString() {
        StringBuilder sb = new StringBuilder("HeaderInfo{aid=");
        sb.append(this.f1254a);
        sb.append(", deviceId='");
        sb.append(this.b);
        sb.append("', channel='");
        sb.append(this.c);
        sb.append("', updateVersionCode='");
        sb.append(this.d);
        sb.append("', appVersion='");
        sb.append(this.e);
        sb.append("', manifestVersionCode='");
        sb.append(this.f);
        sb.append("', versionCode='");
        sb.append(this.g);
        sb.append("', versionName='");
        sb.append(this.h);
        sb.append("', releaseBuild='");
        sb.append(this.i);
        sb.append("', os='");
        sb.append(this.f1255j);
        sb.append("', devicePlatform='");
        sb.append(this.k);
        sb.append("', osVersion='");
        sb.append(this.l);
        sb.append("', apiVersion=");
        sb.append(this.m);
        sb.append(", deviceModel='");
        sb.append(this.n);
        sb.append("', deviceBrand='");
        sb.append(this.o);
        sb.append("', deviceManufacturer='");
        sb.append(this.p);
        sb.append("', processName='");
        sb.append(this.f1256q);
        sb.append("', sid=");
        sb.append(this.f1257r);
        sb.append(", romVersion='");
        sb.append(this.f1258s);
        sb.append("', packageName='");
        sb.append(this.f1259t);
        sb.append("', monitorVersion='");
        sb.append(this.u);
        sb.append("', uid=");
        sb.append(this.f1260v);
        sb.append(", phoneStartTime=");
        sb.append(this.f1261w);
        sb.append(", verifyInfo='");
        sb.append(this.f1262x);
        sb.append("', dynamicExtra=");
        sb.append(this.y);
        sb.append(", stableExtra=");
        sb.append(this.f1263z);
        sb.append(", filters=");
        sb.append(this.f1250A);
        sb.append(", currentUpdateVersionCode='");
        return B7.a.q(sb, this.f1251B, "'}");
    }
}
