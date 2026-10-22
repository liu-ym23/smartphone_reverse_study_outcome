package com.bytedance.apm6.consumer.slardar.send;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IConfigManager;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import ff7.j;
import ff7.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap<h, g> f190744j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile int f190745k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f190746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f190747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f190748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f190749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f190750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f190751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f190752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f190753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f190754i;

    static {
        f190744j = new HashMap();
    }

    public final String f() {
        List<String> r100 = this.f190751f;
        if (TextUtils.isEmpty(this.f190746a) == true) goto L13;
        if (r100 != null) goto L7;
    L11:
        return null;
    L7:
        if (r100.size() <= 0) goto L11;
        return "https://" + this.f190746a + new URL((String) ListProtector.get(r100, 0)).getPath();
    L13:
        if (TextUtils.isEmpty(this.f190749d) == true) goto L17;
        return this.f190749d;
    L17:
        if (this.f190747b == false) goto L19;
        this.f190748c++;
    L19:
        int r101 = r100.size();
        int r102 = this.f190748c;
        if (r101 <= r102) goto L23;
        if (r102 < 0) goto L23;
        return (String) ListProtector.get(r100, r102);
    L23:
        this.f190748c = 0;
        return (String) ListProtector.get(r100, 0);
    }

    public g(h r100) {
        this.f190749d = null;
        this.f190754i = 0;
        this.f190751f = r100.getUrls();
    }

    public static byte[] a(byte[] r100) throws JSONException {
        JSONObject r101 = new JSONObject(new String(r100));
        IConfigManager r102 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (r102 == null) goto L10;
        JSONObject r103 = r102.retrieveSettingsParams();
        JSONObject r104 = new JSONObject();
        String r105 = String.valueOf(du3.a.b());
        if (TextUtils.isEmpty(r105) == true) goto L10;
        if (r105.equals("0") == true) goto L10;
        r104.put(r105, r103);
        r101.put("settings_params", r104);
    L10:
        return r101.toString().getBytes();
    }

    public static JSONObject d(ff7.b r100) {
        JSONObject r101 = new JSONObject(new String(r100.f476669c));     // Catch: Exception -> L33
        Map<String, String> r102 = r100.f476668b;     // Catch: Exception -> L33
        if (r102 != null) goto L6;
    L11:
        String r103 = null;
    L35:
        String r104 = r101.optString("data");     // Catch: Throwable -> L31
        boolean r105 = true;
        if (r104.isEmpty() == true) goto L19;
        if (TextUtils.isEmpty(r103) == true) goto L17;
        String r106 = c(r104.getBytes(), r103);     // Catch: Throwable -> L31
        r101 = new JSONObject(r106);     // Catch: Throwable -> L31
        r105 = true ^ TextUtils.isEmpty(r106);     // Catch: Throwable -> L31
        goto L19
    L17:
        r101 = new JSONObject(new String(r104.getBytes()));     // Catch: Throwable -> L31
    L19:
        if (xu3.d.c(r101) == true) goto L27;
        JSONObject r107 = r101.optJSONObject(FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);     // Catch: Throwable -> L31
        if (xu3.d.c(r107) == true) goto L27;
        mt3.j r108 = (mt3.j) qu3.c.a(mt3.j.class);     // Catch: Throwable -> L31
        if (r108 == null) goto L27;
        r108.onResponse(r107);     // Catch: Throwable -> L31
    L27:
        if (r105 == true) goto L30;
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L31
        r109.put("message", "success");     // Catch: Throwable -> L31
        return r109;
    L30:
        return r101;
    L31:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L33
        r110.put("message", "success");     // Catch: Exception -> L33
        return r110;
    L6:
        if (r102.isEmpty() == true) goto L11;
        r103 = r102.get("ran");     // Catch: Exception -> L33
        if (TextUtils.isEmpty(r103) == false) goto L35;
        r103 = r102.get("Ran");     // Catch: Exception -> L33
    L33:
        return null;
    }

    public static g e(h r100) {
        HashMap<h, g> r101 = f190744j;
        if (r101.containsKey(r100) == true) goto L5;
        r101.put(r100, new g(r100));
        return r101.get(r100);
    L5:
        return r101.get(r100);
    }

    public final boolean g(byte[] r210) {
        if (r210 != null) goto L5;
    L118:
        return true;
    L5:
        if (r210.length == 0) goto L118;
        String r110 = f();     // Catch: Throwable -> L115
        if (this.f190753h != null) goto L12;
        this.f190753h = (k) qu3.c.a(k.class);     // Catch: Throwable -> L115
    L12:
        if (this.f190753h != null) goto L125;
    L123:
        byte[] r100 = a(r210);     // Catch: JSONException -> L16 Throwable -> L115
    L19:
        tu3.a r101 = b(r110, r100);     // Catch: Throwable -> L115
        if (xu3.a.a() == false) goto L23;
        DoctorManager.getInstance().b("APM_SEND_DATA", "url:" + r101.f547615a + " header:" + r101.f547616b);     // Catch: Throwable -> L115
        List<String> r102 = mt3.a.f515607a;     // Catch: Throwable -> L115
        av3.b.a("APM-Slardar", "sendLog createRequest: origin Bytes=" + r100.length + " compressed Bytes=" + r101.f547617c.length + " url=" + r101.f547615a + " headers=" + r101.f547616b);     // Catch: Throwable -> L115
    L23:
        String r103 = r101.f547615a;     // Catch: Throwable -> L115
        Map<String, String> r104 = r101.f547616b;     // Catch: Throwable -> L115
        ff7.b r105 = ((IHttpService) qu3.c.a(IHttpService.class)).doPost(r103, r101.f547617c, r104);     // Catch: Throwable -> L115
        if (xu3.a.a() == false) goto L30;
        List<String> r106 = mt3.a.f515607a;     // Catch: Throwable -> L115
        StringBuilder r107 = new StringBuilder("http result:");     // Catch: Throwable -> L115
        if (r105 != null) goto L28;
        Object r108 = -1;     // Catch: Throwable -> L115
    L29:
        r107.append(r108);     // Catch: Throwable -> L115
        av3.b.a("APM-Slardar", r107.toString());     // Catch: Throwable -> L115
        goto L30
    L28:
        r108 = r105.f476667a + " header:" + r105.f476668b;     // Catch: Throwable -> L115
    L30:
        this.f190746a = null;     // Catch: Throwable -> L115
        this.f190749d = null;     // Catch: Throwable -> L115
        if (r105 != null) goto L33;
    L107:
        this.f190747b = true;     // Catch: Throwable -> L115
        Boolean r109 = this.f190750e;     // Catch: Throwable -> L115
        if (r109 != null) goto L110;
    L112:
        this.f190750e = Boolean.TRUE;     // Catch: Throwable -> L115
        return false;
    L110:
        if (r109.booleanValue() == false) goto L112;
        d.a.f190725a.d();     // Catch: Throwable -> L115
        goto L112
    L33:
        if (r105.f476667a <= 0) goto L107;
        this.f190747b = false;     // Catch: Throwable -> L115
        int r111 = r105.f476667a;     // Catch: Throwable -> L115
        if (500 <= r111) goto L38;
    L46:
        JSONObject r112 = d(r105);     // Catch: Throwable -> L115
        if (r112 != null) goto L49;
    L105:
        this.f190750e = Boolean.TRUE;     // Catch: Throwable -> L115
        return false;
    L49:
        if (r105.f476667a != 200) goto L105;
        String r113 = r112.optString("message");     // Catch: Throwable -> L115
        String r114 = r112.optString("redirect");     // Catch: Throwable -> L115
        long r115 = r112.optLong("delay");     // Catch: Throwable -> L115
        if (r112.optLong("server_code", 0) == 10001) goto L54;
    L61:
        JSONObject r116 = r112.optJSONObject("settings_info");     // Catch: Throwable -> L115
        if (r116 == null) goto L69;
        IConfigManager r117 = (IConfigManager) ServiceManager.getService(IConfigManager.class);     // Catch: Throwable -> L115
        if (r117 == null) goto L69;
        JSONObject r118 = r116.optJSONObject(String.valueOf(du3.a.b()));     // Catch: Throwable -> L115
        if (r118 == null) goto L69;
        r117.updateWithSpecificAidResult(r118);     // Catch: Throwable -> L115
    L69:
        if ("success".equals(r113) == false) goto L71;
        d r119 = d.a.f190725a;     // Catch: Throwable -> L115
        r119.f190720i = true;     // Catch: Throwable -> L115
        r119.f190724m = false;     // Catch: Throwable -> L115
        r119.f190712a = 0;     // Catch: Throwable -> L115
        r119.f190713b = 0;     // Catch: Throwable -> L115
        r119.f190714c = 0;     // Catch: Throwable -> L115
        r119.f190715d = 0;     // Catch: Throwable -> L115
        r119.f190716e = 0;     // Catch: Throwable -> L115
        r119.f190722k.set(0);     // Catch: Throwable -> L115
        r119.f190721j.set(0);     // Catch: Throwable -> L115
        this.f190749d = r110;     // Catch: Throwable -> L115
        this.f190750e = Boolean.FALSE;     // Catch: Throwable -> L115
        boolean r120 = false;
        boolean r121 = true;
    L127:
    L90:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L115
    L92:
        JSONObject r122 = r112.optJSONObject("downgrade_rule");     // Catch: Throwable -> L115
        if (r122 == null) goto L95;
        com.bytedance.apm6.consumer.slardar.send.downgrade.a.C2766a.f190733a.b(DowngradeInfo.a(r122), true);     // Catch: Throwable -> L115
    L95:
        this.f190746a = r114;     // Catch: Throwable -> L115
        if (r115 <= 0) goto L98;
        d r123 = d.a.f190725a;     // Catch: Throwable -> L115
        r123.f190716e = (int) (r115 * 1000);     // Catch: Throwable -> L115
        r123.f190720i = false;     // Catch: Throwable -> L115
        r123.f190721j.set(System.currentTimeMillis());     // Catch: Throwable -> L115
    L98:
        if (r120 == false) goto L103;
        d r124 = d.a.f190725a;     // Catch: Throwable -> L115
        r124.c();     // Catch: Throwable -> L115
        r124.f190724m = true;     // Catch: Throwable -> L115
        r124.f190722k.set(System.currentTimeMillis());     // Catch: Throwable -> L115
        Map<String, String> r125 = r105.f476668b;     // Catch: Throwable -> L115
        if (r125 == null) goto L102;
        DropDataMonitor.a.f190700a.f190697d = r125.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L115
    L102:
        DropDataMonitor.a.f190700a.f190698e = System.currentTimeMillis();     // Catch: Throwable -> L115
    L104:
        return r121;
    L103:
        d.a.f190725a.f190724m = false;     // Catch: Throwable -> L115
        goto L104
    L76:
        if (xu3.a.a() == false) goto L92;
        JSONObject r126 = new JSONObject();     // Catch: Throwable -> L90
        r126.put("RESPONSE_DATA_URL", r101.f547615a);     // Catch: Throwable -> L90
        if (r105.f476668b == null) goto L88;
        JSONObject r127 = new JSONObject();     // Catch: Throwable -> L90
        Iterator<Map.Entry<String, String>> r128 = r105.f476668b.entrySet().iterator();     // Catch: Throwable -> L90
    L81:
        if (r128.hasNext() == false) goto L87;
        Map.Entry<String, String> r129 = r128.next();     // Catch: Throwable -> L90
        if (r129.getKey() == null) goto L81;
        r127.put(r129.getKey(), r129.getValue());     // Catch: Throwable -> L120
        goto L81
    L87:
        r126.put("RESPONSE_DATA_HEADERS", r127);     // Catch: Throwable -> L90
    L88:
        r126.put("RESPONSE_DATA_BODY_TEXT", r112);     // Catch: Throwable -> L90
        ls3.a.c(r100, r126);     // Catch: Throwable -> L90
    L71:
        this.f190750e = Boolean.TRUE;     // Catch: Throwable -> L115
        r120 = "drop data".equals(r113);     // Catch: Throwable -> L115
        if (xu3.a.a() == false) goto L74;
        List<String> r130 = mt3.a.f515607a;     // Catch: Throwable -> L115
        av3.b.a("APM-Slardar", "responseMessage:" + r113);     // Catch: Throwable -> L115
    L74:
        r121 = false;
        goto L127
    L54:
        if (f190745k != 2) goto L61;
        if (this.f190752g == null) goto L61;
        if (this.f190754i != 0) goto L61;
        f190745k = 1;     // Catch: Throwable -> L115
        xu3.a.getContext().getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", 0).putLong("force_zstd_timestamp", System.currentTimeMillis()).commit();     // Catch: Throwable -> L115
        this.f190754i++;     // Catch: Throwable -> L115
        boolean r131 = g(r100);     // Catch: Throwable -> L115
        this.f190754i--;     // Catch: Throwable -> L115
        return r131;
    L38:
        if (r111 > 600) goto L46;
        Boolean r132 = this.f190750e;     // Catch: Throwable -> L115
        if (r132 != null) goto L42;
    L44:
        this.f190750e = Boolean.TRUE;     // Catch: Throwable -> L115
        return false;
    L42:
        if (r132.booleanValue() == false) goto L44;
        d.a.f190725a.c();     // Catch: Throwable -> L115
        goto L44
    L16:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L115
        List<String> r133 = mt3.a.f515607a;     // Catch: Throwable -> L115
        av3.b.b("APM-Slardar", " appendSettingsParams wrong ");     // Catch: Throwable -> L115
        r100 = r210;
        goto L19
    L125:
        this.f190753h.setDomain(new URL(r110).getHost());     // Catch: MalformedURLException -> L119 Throwable -> L115
    L115:
        th = move-exception;
        List<String> r134 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "sendLog failed.", th);
        return false;
    }

    public static String c(byte[] r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r102 = new SecretKeySpec(r101.getBytes(), CryptoConst.ALGORITHM_AES);     // Catch: Throwable -> L7
        Cipher r103 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r103.init(2, r102);     // Catch: Throwable -> L7
        return new String(r103.doFinal(Base64.decode(r100, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (xu3.a.a() == false) goto L11;
        List<String> r104 = mt3.a.f515607a;
        av3.b.c("APM-Slardar", "decodeData", th);
    L11:
        return "";
    }

    public final tu3.a b(String r110, byte[] r111) {
        HashMap r100 = new HashMap();
        HashMap r101 = new HashMap(du3.a.m());
        r100.put("Accept-Encoding", DownloadHelper.GZIP);
        boolean r102 = true;
        String r103 = null;
        GZIPOutputStream r104 = null;
        if (r111.length > 128) goto L5;
        byte[] r105 = null;
    L48:
        if (r105 == null) goto L51;
        r111 = r105;
    L51:
        r100.put("Content-Type", "application/json; charset=utf-8");
        nt3.a r106 = d.a.f190725a.f190723l;
        if (r106 == null) goto L54;
        r102 = r106.f520480e;
    L54:
        if (r102 == false) goto L74;
        ff7.d r107 = (ff7.d) qu3.c.a(ff7.d.class);
        if (r107 == null) goto L58;
        byte[] r108 = r107.a(r111);
    L59:
        if (r108 == null) goto L73;
        r101.put("tt_data", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
        String r112 = xu3.h.a(r110, r101);
        r100.put("Content-Type", DownloadNetworkFactory.ContentType.TT_DATA);
        if (xu3.a.a() == false) goto L63;
        List<String> r113 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "before encrypt url:" + r112);
    L63:
        LinkedList r114 = new LinkedList();
        su3.a r109 = (su3.a) qu3.c.a(su3.a.class);
        if (r109 == null) goto L67;
        r103 = r109.a(r112, r114);
    L67:
        if (TextUtils.isEmpty(r103) == true) goto L70;
        r112 = r103;
    L70:
        if (xu3.a.a() == false) goto L72;
        List<String> r115 = mt3.a.f515607a;
        av3.b.a("APM-Slardar", "after encrypt url:" + r112);
    L72:
        r100.putAll(xu3.e.c(r114));
        r111 = r108;
    L75:
        r100.put("Version-Code", "1");
        return new tu3.a(r112, r100, r111);
    L73:
        r112 = xu3.h.a(r110, r101);
        goto L75
    L58:
        r108 = null;
        goto L59
    L74:
        r112 = xu3.h.a(r110, r101);
        goto L75
    L5:
        if (this.f190752g != null) goto L8;
        this.f190752g = (j) qu3.c.a(j.class);
    L8:
        if (f190745k != 1) goto L15;
        j r116 = this.f190752g;
        if (r116 == null) goto L15;
        r105 = r116.a(r111);
        if (r105 == null) goto L33;
        r100.put("Content-Encoding", "zstd");
        r100.put("Content-Encoding-Level", String.valueOf(15));
    L33:
        if (r105 != null) goto L48;
        ByteArrayOutputStream r117 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r118 = new GZIPOutputStream(r117);     // Catch: Throwable -> L40 IOException -> L43
    L80:
        r118.write(r111);     // Catch: Throwable -> L38 IOException -> L77
        xu3.c.a(r118);
        r105 = r117.toByteArray();
    L45:
        if (r105 == null) goto L48;
        r100.put("Content-Encoding", DownloadHelper.GZIP);
        goto L48
    L38:
        th = th;
        r104 = r118;
    L41:
        xu3.c.a(r104);
        throw th;
    L44:
        xu3.c.a(r118);
        r105 = null;
    L43:
        r118 = null;
    L40:
        th = th;
    L15:
        if (f190745k == 2) goto L17;
    L32:
        r105 = null;
        goto L33
    L17:
        if (this.f190752g == null) goto L32;
        if (this.f190753h != null) goto L21;
        this.f190753h = (k) qu3.c.a(k.class);
    L21:
        k r119 = this.f190753h;
        if (r119 == null) goto L27;
        Pair<byte[], String> r120 = r119.a();
        byte[] r121 = (byte[]) r120.first;
        String r122 = (String) r120.second;
        if (r121 == null) goto L26;
        byte[] r123 = this.f190752g.b(r111, r121);
        String r124 = r122;
        r105 = r123;
    L28:
        if (r105 == null) goto L33;
        r100.put("Content-Encoding", "zstd/dict_monitor");
        r100.put("Content-Encoding-Level", String.valueOf(15));
        if (TextUtils.isEmpty(r124) == true) goto L33;
        r100.put("slardar-zstd-version", r124);
        r101.put("slardar-zstd-version", r124);
        goto L33
    L26:
        r124 = r122;
        r105 = null;
        goto L28
    L27:
        r105 = null;
        r124 = null;
        goto L28
    }
}
