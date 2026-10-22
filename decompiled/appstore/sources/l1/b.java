package l1;

import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.data.pipeline.INetSlaInnerListener;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.k;
import com.bytedance.apm.util.n;
import com.bytedanceos.common.ad.common.AdConstant;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class b extends k1.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static long f21795v = 30000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static boolean f21796w = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f21798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f21799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile List f21800j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f21801k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f21802l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f21803m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f21804n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f21805o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f21806p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21807q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f21808r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double f21809s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f21810t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public INetSlaInnerListener f21811u;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: l1.b$b, reason: collision with other inner class name */
    public static final class C0299b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21812a = null;

        static {
            f21812a = new b(null);
        }

        public static /* synthetic */ b a() {
            return f21812a;
        }
    }

    static {
    }

    public /* synthetic */ b(a r10) {
        this();
    }

    public static boolean E() {
        if (f21796w == true) goto L6;
        return false;
    L6:
        if (c.f() != 0) goto L9;
        return false;
    L9:
        if ((System.currentTimeMillis() - c.f()) <= f21795v) goto L11;
        return false;
    L11:
        return true;
    }

    public static void H(boolean r10) {
        f21796w = r10;
    }

    public static void I(long r10) {
        f21795v = r10;
    }

    public static b t() {
        return C0299b.a();
    }

    public boolean A() {
        if (this.f21807q == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f21809s == 0.0d) goto L7;
        return true;
    }

    public boolean B() {
        return this.f21798h;
    }

    public final boolean C(String r10) {
        return n.c(r10, this.f21802l, this.f21803m);
    }

    public final boolean D(String r10) {
        return n.c(r10, this.f21800j, this.f21801k);
    }

    public boolean F() {
        return this.f21807q;
    }

    public final boolean G(String r10) {
        return n.b(r10, this.f21804n);
    }

    public void J(boolean r10) {
        this.f21810t = r10;
    }

    public void K(INetSlaInnerListener r10) {
        this.f21811u = r10;
    }

    @Override // k1.a
    public /* bridge */ /* synthetic */ boolean d(ITypeData r10) {
        return q((m1.a) r10);
    }

    @Override // k1.a
    public /* bridge */ /* synthetic */ void f(ITypeData r10) {
        v((m1.a) r10);
    }

    @Override // k1.a
    public /* bridge */ /* synthetic */ void i(ITypeData r10) {
        y((m1.a) r10);
    }

    @Override // k1.a, com.bytedance.services.slardar.config.IConfigListener
    public void onRefresh(JSONObject r10, boolean r11) {
        JSONObject r12 = n.a(r10, SlardarSettingsConsts.SETTING_NETWORK_IMAGE_MODULES);
        if (r12 == null) goto L14;
        JSONObject r13 = n.a(r12, "network");
        if (r13 == null) goto L10;
        this.f21800j = n.d(r13, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);
        this.f21801k = n.g(r13, SlardarSettingsConsts.SETTING_NET_API_BLOCK_LIST);
        this.f21802l = n.e(r13, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);
        this.f21803m = n.f(r13, SlardarSettingsConsts.SETTING_NET_API_ALLOW_LIST);
        boolean r14 = false;
        this.f21797g = r13.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ALL_UPLOAD, 0);
        this.f21798h = r13.optBoolean(SlardarSettingsConsts.SETTING_NET_ENABLE_HOOK_NET_SAMPLE, true);
        this.f21799i = r13.optInt(SlardarSettingsConsts.SETTING_NET_ENABLE_API_ERROR_UPLOAD, 1);
        if (r13.optInt(SlardarSettingsConsts.SETTING_ENABLE_CANCEL_ERROR_REPORT) != 1) goto L9;
        r14 = true;
    L9:
        this.f21808r = r14;
        this.f21805o = n.e(r13, SlardarSettingsConsts.SETTING_REQUEST_ALLOW_HEADER);
        this.f21806p = n.e(r13, SlardarSettingsConsts.SETTING_RESPONSE_ALLOW_HEADER);
        this.f21809s = r13.optDouble(SlardarSettingsConsts.SETTING_ENABLE_BASE_API_ALL, 0.0d);
    L10:
        JSONObject r15 = n.a(r12, SlardarSettingsConsts.SETTING_IMAGE);
        if (r15 == null) goto L15;
        this.f21804n = n.e(r15, SlardarSettingsConsts.SETTING_IMAGE_ALLOW_LIST);
        return;
    L15:
        return;
    }

    public final void p(JSONObject r10, String r11) {
        if (r10 == null) goto L31;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.equals(r11, "api_all") == false) goto L10;
        r10.put(CommonKey.KEY_NET_LOG_TYPE, CommonServiceName.MONITOR_TYPE_API_ALL_V2);     // Catch: Exception -> L7
    L14:
        if (A() == false) goto L19;
        if (B() == false) goto L19;
        r10.put(CommonServiceName.MONITOR_INJECT_TRACE_LOG, AdConstant.OperatorCode.CHINA_UNICOM);     // Catch: Exception -> L7
    L23:
        double r12 = this.f21809s;     // Catch: Exception -> L7
        if (r12 == 0.0d) goto L32;
        r10.put(SlardarSettingsConsts.SETTING_ENABLE_BASE_API_ALL, r12);     // Catch: Exception -> L7
        return;
    L32:
        return;
    L19:
        if (u() != 1) goto L23;
        if (B() == false) goto L23;
        r10.put(CommonServiceName.MONITOR_INJECT_TRACE_LOG, "02");     // Catch: Exception -> L7
        goto L23
    L10:
        if (TextUtils.equals(r11, "api_error") == false) goto L14;
        r10.put(CommonKey.KEY_NET_LOG_TYPE, CommonServiceName.MONITOR_TYPE_API_ERROR_V2);     // Catch: Exception -> L7
        goto L14
    }

    public boolean q(m1.a r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (TextUtils.isEmpty(r10.f22022d) == true) goto L6;
        return true;
    }

    public final void r(JSONObject r10) {
        s(this.f21805o, r10, SlardarSettingsConsts.EXT_REQUEST_HEADER);
        s(this.f21806p, r10, SlardarSettingsConsts.EXT_RESPONSE_HEADER);
    }

    public final void s(List r10, JSONObject r11, String r12) {
        if (r10 == null) goto L32;
        if (r11 == null) goto L33;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (TextUtils.isEmpty(r12) == true) goto L34;
        String r13 = r11.optString(r12);     // Catch: Exception -> L14 JSONException -> L16
        if (TextUtils.isEmpty(r13) == true) goto L35;
        JSONObject r14 = new JSONObject(r13);     // Catch: Exception -> L14 JSONException -> L16
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L14 JSONException -> L16
        Iterator<String> r16 = r14.keys();     // Catch: Exception -> L14 JSONException -> L16
    L10:
        if (r16.hasNext() == false) goto L18;
        String r17 = r16.next();     // Catch: Exception -> L14 JSONException -> L16
        if (r10.contains(r17) == false) goto L10;
        r15.put(r17, r14.opt(r17));     // Catch: Exception -> L14 JSONException -> L16
        goto L10
    L18:
        r11.put(r12, r15.toString());     // Catch: Exception -> L14 JSONException -> L16
    L36:
        return;
    L35:
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L14
        return;
    L34:
        return;
    L33:
        return;
    }

    public int u() {
        return this.f21797g;
    }

    public void v(m1.a r10) {
        x(r10);
    }

    public final boolean w(String r10, JSONObject r11) {
        if (A() == false) goto L5;
    L10:
        int r12 = 1;
    L11:
        boolean r13 = b2.b.f(CommonServiceName.MONITOR_TYPE_SMART_TRAFFIC);
        if (r13 == false) goto L14;
        int r14 = r12 | 4;
    L22:
        r11.put("hit_rules", r14);     // Catch: JSONException -> L21
    L16:
        if (r12 != 0) goto L24;
        if (r13 == false) goto L20;
        return true;
    L20:
        return false;
    L24:
        return true;
    L14:
        r14 = r12;
        goto L22
    L5:
        if (this.f21797g != 0) goto L10;
        if (C(r10) == true) goto L10;
        r12 = 0;
        goto L11
    }

    public final void x(m1.a r10) {
        String r11 = r10.f22022d;
        if (G(r11) == false) goto L5;
        return;
    L5:
        if (k.b(c.g()) == true) goto L10;
        if (this.f21810t == true) goto L10;
        return;
    L10:
        if (z(r10.f22026h) == true) goto L12;
    L14:
        String r12 = r10.f22019a;
        JSONObject r13 = r10.packLog();
        i.a(r13, r10.f22026h);
        if (r13 != null) goto L17;
        return;
    L17:
        boolean r14 = true;
        if (TextUtils.equals(r12, "api_all") == false) goto L28;
        if (A() == false) goto L24;
        w(r11, r13);
    L22:
        boolean r15 = r14;
    L34:
        if (this.f21807q == false) goto L36;
        p(r13, r10.f22019a);
    L36:
        r(r13);
        if (this.f21811u != null) goto L39;
    L43:
        l(r12, r12, r13, r15, true);
        return;
    L39:
        if ("api_all".equals(r12) == false) goto L43;
        if (r10.f22026h.optBoolean("download", false) == true) goto L43;
        this.f21811u.deliver(r11, r10.f22026h);
        goto L43
    L24:
        if (D(r11) == false) goto L26;
    L25:
        r15 = false;
        goto L34
    L26:
        r15 = w(r11, r13);
        goto L34
    L28:
        if (TextUtils.equals(r12, "api_error") == false) goto L25;
        if (this.f21799i == 1) goto L22;
        r14 = false;
        goto L22
    L12:
        if (this.f21808r == true) goto L14;
    }

    public void y(m1.a r10) {
        r10.b(!k1.a.k());     // Catch: JSONException -> L7
        if (E() == false) goto L5;
        r10.c();     // Catch: JSONException -> L7
    L5:
        r10.a("ttnet");     // Catch: JSONException -> L7
        return;
    }

    public final boolean z(JSONObject r10) {
        if (r10 != null) goto L12;
        return false;
    L12:
        String r11 = r10.optString(CommonServiceName.CRONET_INTERNAL_ERROR_CODE);     // Catch: Exception -> L11
        if (CommonServiceName.CRONET_ERROR_CODE_CANCEL.equals(r10.optString(CommonServiceName.CRONET_ERROR_CODE)) == false) goto L14;
        if (CommonServiceName.CRONET_INTERNAL_ERROR_CODE_CANCEL.equals(r11) == false) goto L15;
        return true;
    L15:
        return false;
    L14:
        return false;
    L16:
        return false;
    }

    public b() {
        this.f21798h = true;
        this.f21807q = true;
        this.f21808r = false;
    }
}
