package com.bytedance.apm6.consumer.slardar.send;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeInfo;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedanceos.common.ad.param.AdReportParam;
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
import r3.j;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static HashMap f6724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile int f6725k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f6727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f6730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f6731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IZstdCompress f6732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IZstdDict f6733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6734i;

    static {
        f6724j = new HashMap();
    }

    public d(UploadLogInfo r10) {
        this.f6729d = null;
        this.f6734i = 0;
        this.f6731f = r10.getUrls();
    }

    public static d g(UploadLogInfo r10) {
        if (f6724j.containsKey(r10) == true) goto L5;
        f6724j.put(r10, new d(r10));
        return (d) f6724j.get(r10);
    L5:
        return (d) f6724j.get(r10);
    }

    public static void k(int r10) {
        if (r10 != 2) goto L8;
        long r11 = r3.a.b().getSharedPreferences("dict_interval", 0).getLong("force_zstd_timestamp", 0);
        if ((System.currentTimeMillis() - r11) > 3600000) goto L8;
        f6725k = 1;
        return;
    L8:
        f6725k = r10;
    }

    public byte[] a(byte[] r10) {
        JSONObject r11 = new JSONObject(new String(r10));
        IConfigManager r12 = (IConfigManager) n5.b.a(IConfigManager.class);
        if (r12 == null) goto L10;
        JSONObject r13 = r12.retrieveSettingsParams();
        JSONObject r14 = new JSONObject();
        String r15 = String.valueOf(d3.a.h());
        if (TextUtils.isEmpty(r15) == true) goto L10;
        if (r15.equals(AdReportParam.ClickPosType.SKIP) == true) goto L10;
        r14.put(r15, r13);
        r11.put("settings_params", r14);
    L10:
        return r11.toString().getBytes();
    }

    public final byte[] b(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r12 = null;
        GZIPOutputStream r13 = new GZIPOutputStream(r11);     // Catch: Throwable -> L9 IOException -> L11
        r13.write(r10);     // Catch: Throwable -> L7 IOException -> L16
        r3.d.a(r13);
        return r11.toByteArray();
    L7:
        th = th;
        r12 = r13;
    L12:
        r3.d.a(r12);
        throw th;
    L14:
        r3.d.a(r13);
        return null;
    L11:
        r13 = null;
    L9:
        th = th;
        goto L12
    }

    public final p3.a c(String r10, byte[] r11, boolean r12) {
        HashMap r13 = new HashMap();
        HashMap r14 = new HashMap(d3.a.w());
        r13.put("Accept-Encoding", "gzip");
        byte[] r15 = null;
        if (r11.length > 128) goto L5;
    L37:
        if (r15 == null) goto L40;
        r11 = r15;
    L40:
        r13.put("Content-Type", "application/json; charset=utf-8");
        if (b.e().i() == false) goto L55;
        byte[] r16 = e(r11);
        if (r16 == null) goto L54;
        r14.put("tt_data", "a");
        String r17 = j.a(r10, r14);
        r13.put("Content-Type", "application/octet-stream;tt-data=a");
        if (r3.a.c() == false) goto L47;
        s3.a.a(n2.a.f22354a, "before encrypt url:" + r17);
    L47:
        LinkedList r18 = new LinkedList();
        String r19 = l(r17, r18);
        if (TextUtils.isEmpty(r19) == true) goto L51;
        r17 = r19;
    L51:
        if (r3.a.c() == false) goto L53;
        s3.a.a(n2.a.f22354a, "after encrypt url:" + r17);
    L53:
        r13.putAll(ListUtils.c(r18));
        r11 = r16;
    L56:
        r13.put("Version-Code", "1");
        return new p3.a(r17, r13, r11);
    L54:
        r17 = j.a(r10, r14);
        goto L56
    L55:
        r17 = j.a(r10, r14);
        goto L56
    L5:
        if (r12 == false) goto L7;
    L33:
        if (r15 != null) goto L37;
        r15 = b(r11);
        if (r15 == null) goto L37;
        r13.put("Content-Encoding", "gzip");
        goto L37
    L7:
        if (this.f6732g != null) goto L10;
        this.f6732g = (IZstdCompress) o3.a.a(IZstdCompress.class);
    L10:
        if (f6725k != 1) goto L17;
        IZstdCompress r110 = this.f6732g;
        if (r110 == null) goto L17;
        r15 = r110.compress(r11, 15);
        if (r15 == null) goto L33;
        r13.put("Content-Encoding", "zstd");
        r13.put("Content-Encoding-Level", String.valueOf(15));
    L17:
        if (f6725k != 2) goto L33;
        if (this.f6732g == null) goto L33;
        if (this.f6733h != null) goto L23;
        this.f6733h = (IZstdDict) o3.a.a(IZstdDict.class);
    L23:
        IZstdDict r111 = this.f6733h;
        if (r111 == null) goto L28;
        Pair<byte[], String> r112 = r111.getDictAndDictVersion();
        byte[] r20 = (byte[]) r112.first;
        String r113 = (String) r112.second;
        if (r20 == null) goto L29;
        r15 = this.f6732g.compress(r11, r20, 15);
    L29:
        if (r15 == null) goto L33;
        r13.put("Content-Encoding", "zstd/dict_monitor");
        r13.put("Content-Encoding-Level", String.valueOf(15));
        if (TextUtils.isEmpty(r113) == true) goto L33;
        r13.put("slardar-zstd-version", r113);
        r14.put("slardar-zstd-version", r113);
        goto L33
    L28:
        r113 = null;
        goto L29
    }

    public final String d(byte[] r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L12;
        return "";
    L12:
        SecretKeySpec r12 = new SecretKeySpec(r11.getBytes(), "AES");     // Catch: Throwable -> L7
        Cipher r13 = Cipher.getInstance("AES/ECB/NoPadding");     // Catch: Throwable -> L7
        r13.init(2, r12);     // Catch: Throwable -> L7
        return new String(r13.doFinal(Base64.decode(r10, 0))).replaceAll("\\$+$", "");
    L7:
        th = move-exception;
        if (r3.a.c() == false) goto L11;
        s3.a.c(n2.a.f22354a, "decodeData", th);
    L11:
        return "";
    }

    public final byte[] e(byte[] r10) {
        IEncrypt r11 = (IEncrypt) o3.a.a(IEncrypt.class);
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.encrypt(r10);
    }

    public final JSONObject f(i6.c r10) {
        JSONObject r11 = new JSONObject(new String(r10.b()));     // Catch: Exception -> L25
        Map r12 = r10.a();     // Catch: Exception -> L25
        if (r12 != null) goto L6;
    L11:
        String r13 = null;
    L26:
        String r14 = r11.optString("data");     // Catch: Throwable -> L23
        boolean r15 = true;
        if (r14.isEmpty() == false) goto L15;
    L18:
        i(r11);     // Catch: Throwable -> L23
        if (r15 == true) goto L22;
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L23
        r16.put("message", "success");     // Catch: Throwable -> L23
        return r16;
    L22:
        return r11;
    L15:
        if (TextUtils.isEmpty(r13) == true) goto L17;
        String r17 = d(r14.getBytes(), r13);     // Catch: Throwable -> L23
        r11 = new JSONObject(r17);     // Catch: Throwable -> L23
        r15 = true ^ TextUtils.isEmpty(r17);     // Catch: Throwable -> L23
        goto L18
    L17:
        r11 = new JSONObject(new String(r14.getBytes()));     // Catch: Throwable -> L23
    L23:
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L25
        r18.put("message", "success");     // Catch: Exception -> L25
        return r18;
    L6:
        if (r12.isEmpty() == true) goto L11;
        r13 = (String) r12.get("ran");     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r13) == false) goto L26;
        r13 = (String) r12.get(CommonConsts.KEY_DECODE_RAN);     // Catch: Exception -> L25
    L25:
        return null;
    }

    public final String h() {
        List r10 = this.f6731f;
        if (TextUtils.isEmpty(this.f6726a) == true) goto L13;
        if (r10 != null) goto L7;
    L11:
        return null;
    L7:
        if (r10.size() <= 0) goto L11;
        return "https://" + this.f6726a + new URL((String) r10.get(0)).getPath();
    L13:
        if (TextUtils.isEmpty(this.f6729d) == true) goto L17;
        return this.f6729d;
    L17:
        if (this.f6727b == false) goto L19;
        this.f6728c++;
    L19:
        int r11 = r10.size();
        int r12 = this.f6728c;
        if (r11 <= r12) goto L23;
        if (r12 < 0) goto L23;
        return (String) r10.get(r12);
    L23:
        this.f6728c = 0;
        return (String) r10.get(0);
    }

    public final void i(JSONObject r10) {
        if (r3.e.d(r10) == false) goto L5;
        return;
    L5:
        JSONObject r11 = r10.optJSONObject("configs");
        if (r3.e.d(r11) == false) goto L8;
        return;
    L8:
        SlardarResponseService r12 = (SlardarResponseService) o3.a.a(SlardarResponseService.class);
        if (r12 == null) goto L12;
        r12.onResponse(r11);
        return;
    }

    public boolean j(byte[] r21) {
        if (r21 != null) goto L5;
    L114:
        return true;
    L5:
        if (r21.length == 0) goto L114;
        String r10 = h();     // Catch: Throwable -> L11
        m(r10);     // Catch: Throwable -> L11
        byte[] r11 = a(r21);     // Catch: Throwable -> L11 JSONException -> L13
    L16:
        p3.a r12 = c(r10, r11, false);     // Catch: Throwable -> L11
        if (r3.a.c() == false) goto L20;
        DoctorManager.getInstance().b("APM_SEND_DATA", "url:" + r12.f23320a + " header:" + r12.f23321b);     // Catch: Throwable -> L11
        s3.a.a(n2.a.f22354a, "sendLog createRequest: origin Bytes=" + r11.length + " compressed Bytes=" + r12.f23322c.length + " url=" + r12.f23320a + " headers=" + r12.f23321b);     // Catch: Throwable -> L11
    L20:
        i6.c r13 = d3.a.g(r12.f23320a, r12.f23321b, r12.f23322c);     // Catch: Throwable -> L11
        if (r3.a.c() == false) goto L27;
        String r14 = n2.a.f22354a;     // Catch: Throwable -> L11
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L11
        r15.append("http result:");     // Catch: Throwable -> L11
        if (r13 != null) goto L25;
        Object r16 = -1;     // Catch: Throwable -> L11
    L26:
        r15.append(r16);     // Catch: Throwable -> L11
        s3.a.a(r14, r15.toString());     // Catch: Throwable -> L11
        goto L27
    L25:
        r16 = r13.c() + " header:" + r13.a();     // Catch: Throwable -> L11
    L27:
        this.f6726a = null;     // Catch: Throwable -> L11
        this.f6729d = null;     // Catch: Throwable -> L11
        if (r13 != null) goto L30;
    L105:
        this.f6727b = true;     // Catch: Throwable -> L11
        Boolean r17 = this.f6730e;     // Catch: Throwable -> L11
        if (r17 != null) goto L108;
    L110:
        this.f6730e = Boolean.TRUE;     // Catch: Throwable -> L11
        return false;
    L108:
        if (r17.booleanValue() == false) goto L110;
        b.e().s();     // Catch: Throwable -> L11
        goto L110
    L30:
        if (r13.c() <= 0) goto L105;
        this.f6727b = false;     // Catch: Throwable -> L11
        if (500 <= r13.c()) goto L35;
    L43:
        JSONObject r18 = f(r13);     // Catch: Throwable -> L11
        if (r18 != null) goto L46;
    L103:
        this.f6730e = Boolean.TRUE;     // Catch: Throwable -> L11
        return false;
    L46:
        if (r13.c() != 200) goto L103;
        String r19 = r18.optString("message");     // Catch: Throwable -> L11
        String r110 = r18.optString("redirect");     // Catch: Throwable -> L11
        long r111 = r18.optLong("delay");     // Catch: Throwable -> L11
        if (r18.optLong("server_code", 0) == 10001) goto L51;
    L58:
        JSONObject r20 = r18.optJSONObject("settings_info");     // Catch: Throwable -> L11
        if (r20 == null) goto L66;
        IConfigManager r112 = (IConfigManager) n5.b.a(IConfigManager.class);     // Catch: Throwable -> L11
        if (r112 == null) goto L66;
        JSONObject r22 = r20.optJSONObject(String.valueOf(d3.a.h()));     // Catch: Throwable -> L11
        if (r22 == null) goto L66;
        r112.updateWithSpecificAidResult(r22);     // Catch: Throwable -> L11
    L66:
        if ("success".equals(r19) == false) goto L68;
        b.e().n();     // Catch: Throwable -> L11
        this.f6729d = r10;     // Catch: Throwable -> L11
        this.f6730e = Boolean.FALSE;     // Catch: Throwable -> L11
        boolean r23 = true;
        boolean r24 = false;
    L118:
    L84:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L11
    L90:
        JSONObject r25 = r18.optJSONObject("downgrade_rule");     // Catch: Throwable -> L11
        if (r25 == null) goto L93;
        com.bytedance.apm6.consumer.slardar.send.downgrade.a.a().c(DowngradeInfo.a(r25), true);     // Catch: Throwable -> L11
    L93:
        this.f6726a = r110;     // Catch: Throwable -> L11
        if (r111 <= 0) goto L96;
        b.e().a(r111);     // Catch: Throwable -> L11
    L96:
        if (r24 == false) goto L101;
        b.e().b();     // Catch: Throwable -> L11
        if (r13.a() == null) goto L100;
        DropDataMonitor.b().e((String) r13.a().get("x-tt-logid"));     // Catch: Throwable -> L11
    L100:
        DropDataMonitor.b().f(System.currentTimeMillis());     // Catch: Throwable -> L11
    L102:
        return r23;
    L101:
        b.e().m();     // Catch: Throwable -> L11
        goto L102
    L73:
        if (r3.a.c() == false) goto L90;
        JSONObject r26 = new JSONObject();     // Catch: Throwable -> L84
        r26.put("RESPONSE_DATA_URL", r12.f23320a);     // Catch: Throwable -> L84
        if (r13.a() == null) goto L87;
        JSONObject r27 = new JSONObject();     // Catch: Throwable -> L84
        Iterator r113 = r13.a().entrySet().iterator();     // Catch: Throwable -> L84
    L78:
        if (r113.hasNext() == false) goto L86;
        Map.Entry r114 = (Map.Entry) r113.next();     // Catch: Throwable -> L84
        if (r114.getKey() == null) goto L78;
        r27.put((String) r114.getKey(), r114.getValue());     // Catch: Throwable -> L115
        goto L78
    L86:
        r26.put("RESPONSE_DATA_HEADERS", r27);     // Catch: Throwable -> L84
    L87:
        r26.put("RESPONSE_DATA_BODY_TEXT", r18);     // Catch: Throwable -> L84
        o1.a.g(r11, r26);     // Catch: Throwable -> L84
    L68:
        this.f6730e = Boolean.TRUE;     // Catch: Throwable -> L11
        r24 = "drop data".equals(r19);     // Catch: Throwable -> L11
        if (r3.a.c() == false) goto L71;
        s3.a.a(n2.a.f22354a, "responseMessage:" + r19);     // Catch: Throwable -> L11
    L71:
        r23 = false;
        goto L118
    L51:
        if (f6725k != 2) goto L58;
        if (this.f6732g == null) goto L58;
        if (this.f6734i != 0) goto L58;
        f6725k = 1;     // Catch: Throwable -> L11
        r3.a.b().getSharedPreferences("dict_interval", 0).edit().putLong("dict_interval", 0).putLong("force_zstd_timestamp", System.currentTimeMillis()).commit();     // Catch: Throwable -> L11
        this.f6734i++;     // Catch: Throwable -> L11
        boolean r28 = j(r11);     // Catch: Throwable -> L11
        this.f6734i--;     // Catch: Throwable -> L11
        return r28;
    L35:
        if (r13.c() > 600) goto L43;
        Boolean r29 = this.f6730e;     // Catch: Throwable -> L11
        if (r29 != null) goto L39;
    L41:
        this.f6730e = Boolean.TRUE;     // Catch: Throwable -> L11
        return false;
    L39:
        if (r29.booleanValue() == false) goto L41;
        b.e().l();     // Catch: Throwable -> L11
        goto L41
    L13:
        e = move-exception;
        i6.a.d(e, "NetworkSender->sendLog(byte[] bytes)");     // Catch: Throwable -> L11
        s3.a.b(n2.a.f22354a, " appendSettingsParams wrong ");     // Catch: Throwable -> L11
        r11 = r21;
    L11:
        th = move-exception;
        s3.a.c(n2.a.f22354a, "sendLog failed.", th);
        return false;
    }

    public final String l(String r10, List r11) {
        EncryptService r12 = (EncryptService) o3.a.a(EncryptService.class);
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.tryEncryptRequest(r10, r11);
    }

    public final void m(String r10) {
        if (this.f6733h != null) goto L6;
        this.f6733h = (IZstdDict) o3.a.a(IZstdDict.class);
    L6:
        if (this.f6733h == null) goto L12;
        URL r11 = new URL(r10);     // Catch: MalformedURLException -> L9
        this.f6733h.setDomain(r11.getHost());     // Catch: MalformedURLException -> L9
        return;
    L13:
        return;
    }
}
