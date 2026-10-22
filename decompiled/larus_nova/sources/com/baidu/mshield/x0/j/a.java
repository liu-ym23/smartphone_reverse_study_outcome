package com.baidu.mshield.x0.j;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.x0.EngineImpl;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.l.c;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.l;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f32530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f32531b;

    /* JADX INFO: renamed from: com.baidu.mshield.x0.j.a$a, reason: collision with other inner class name */
    public class C0658a extends com.baidu.mshield.x0.d.h.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f32532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f32533c;

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            a.a(this.f32533c, this.f32532b);
        }

        public C0658a(a r100, b r101) {
            this.f32533c = r100;
            this.f32532b = r101;
        }
    }

    public interface b {
        void a(int r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008d -> B:89:0x0090). Please report as a decompilation issue!!! */
    public final synchronized boolean a() {
        monitor-enter(this);
        String r100 = "";
        String r101 = "";
        com.baidu.mshield.x0.l.a r102 = new com.baidu.mshield.x0.l.a(this.f32531b);     // Catch: Throwable -> L81
        HashMap<String, String> r103 = new com.baidu.mshield.x0.i.a(this.f32531b, null).b();     // Catch: Throwable -> L20
        if (r103 != null) goto L11;
        monitor-exit(this);
        return false;
    L11:
        String r110 = r103.get("decrpt");     // Catch: Throwable -> L20
        String r104 = r103.get("url");     // Catch: Throwable -> L17
        r101 = r103.get("source");     // Catch: Throwable -> L15
    L23:
        r102.d(System.currentTimeMillis());     // Catch: Throwable -> L81
        if (TextUtils.isEmpty(r110) == false) goto L27;
        monitor-exit(this);
        return false;
    L27:
        com.baidu.mshield.b.c.a.b("policy sdata====" + r110);     // Catch: Throwable -> L81
        JSONObject r105 = new JSONObject(r110);     // Catch: Throwable -> L81
        JSONObject r106 = r105.getJSONObject("sec");     // Catch: Throwable -> L33
        if (r106 == null) goto L31;
        a(r106, r110, r104, r101);     // Catch: Throwable -> L33
    L89:
        String r107 = r105.optString("fig");     // Catch: Throwable -> L40
        if (r107 == null) goto L38;
        b(r107);     // Catch: Throwable -> L40
    L100:
        String r108 = r105.optString(FaceShowElderlyFragment.MD5_KEY_PREFIX);     // Catch: Throwable -> L47
        if (r108 == null) goto L45;
        a(r108);     // Catch: Throwable -> L47
    L107:
        String r109 = r105.optString("prv");     // Catch: Throwable -> L51
        com.baidu.mshield.b.c.a.b("privacyPolicy===" + r109);     // Catch: Throwable -> L51
        new c(this.f32531b).c(r109);     // Catch: Throwable -> L51
    L88:
        JSONObject r111 = r105.optJSONObject("sgs");     // Catch: Throwable -> L58
        if (r111 == null) goto L56;
        com.baidu.mshield.b.c.a.b("sgs data ：" + r111.toString());     // Catch: Throwable -> L58
        l.f32618b = r111.optString("3", "");     // Catch: Throwable -> L58
    L99:
        JSONObject r112 = r105.optJSONObject("drf");     // Catch: Throwable -> L65
        if (r112 == null) goto L63;
        a(r112);     // Catch: Throwable -> L65
    L92:
        JSONObject r113 = r105.optJSONObject("rmf");     // Catch: Throwable -> L72
        if (r113 == null) goto L70;
        b(r113);     // Catch: Throwable -> L72
    L95:
        String r114 = r105.optString("ids");     // Catch: Throwable -> L76
        com.baidu.mshield.b.c.a.b("ids===" + r114);     // Catch: Throwable -> L76
        EngineImpl.getInstance(this.f32531b).ids = r114;     // Catch: Throwable -> L76
    L78:
        monitor-exit(this);
        return true;
    L76:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L78
    L70:
        com.baidu.mshield.b.c.a.b("rmf sdata is empty ");     // Catch: Throwable -> L72
        b(null);     // Catch: Throwable -> L72
    L72:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L95
    L63:
        com.baidu.mshield.b.c.a.b("drf sdata is empty ");     // Catch: Throwable -> L65
        a(null);     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L92
    L56:
        com.baidu.mshield.b.c.a.b("sgs sdata is empty ");     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L99
    L51:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L88
    L45:
        com.baidu.mshield.b.c.a.b("sig sdata is empty ");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L107
    L38:
        com.baidu.mshield.b.c.a.b("finger sdata is empty ");     // Catch: Throwable -> L40
        goto L100
    L40:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
        goto L100
    L31:
        com.baidu.mshield.b.c.a.b("sec sdata is empty ");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L81
    L15:
        Throwable th10 = th;
        String r115 = r104;
    L19:
        r100 = r110;
    L22:
        d.a(th10);     // Catch: Throwable -> L81
        r110 = r100;
        r104 = r115;
    L17:
        th = move-exception;
        r115 = "";
        th10 = th;
    L20:
        th = move-exception;
        r115 = "";
        th10 = th;
    L81:
        th = move-exception;
        d.a(th);     // Catch: Throwable -> L85
        return false;
    L85:
        th = move-exception;
        throw th;
    }

    public a(Context r100) {
        this.f32531b = r100;
    }

    public final void a(JSONObject r100) {
        com.baidu.mshield.b.c.a.b("handleDrfPolicy:" + r100);     // Catch: Throwable -> L9
        com.baidu.mshield.x6.b.b r101 = new com.baidu.mshield.x6.b.b(this.f32531b);     // Catch: Throwable -> L9
        if (r100 != null) goto L7;
        l.f32620d = "";     // Catch: Throwable -> L9
        return;
    L7:
        l.f32620d = r100.toString();     // Catch: Throwable -> L9
        com.baidu.mshield.b.c.a.b("handleDrfPolicy ungz:".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(r100.optString("1").getBytes(), 0)), XML.CHARSET_UTF8)));     // Catch: Throwable -> L9
        r101.g(r100.optString("2"));     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        d.a(th);
    }

    public final void b(JSONObject r100) {
        com.baidu.mshield.b.c.a.b("handleRmfPolicy:" + r100);     // Catch: Throwable -> L14
        if (r100 != null) goto L8;
        l.f32621e = "";     // Catch: Throwable -> L14
        return;
    L8:
        boolean r101 = f.a(this.f32531b, false);     // Catch: Throwable -> L14
        com.baidu.mshield.x6.b.b r102 = new com.baidu.mshield.x6.b.b(this.f32531b);     // Catch: Throwable -> L14
        if (r101 == false) goto L11;
        r102.v(r100.toString());     // Catch: Throwable -> L14
        l.f32621e = "";     // Catch: Throwable -> L14
    L12:
        com.baidu.mshield.b.c.a.b("handleRmfPolicy ungz:".concat(new String(com.baidu.mshield.b.a.c.b(Base64.decode(r100.optString("1").getBytes(), 0)), XML.CHARSET_UTF8)));     // Catch: Throwable -> L14
        return;
    L11:
        l.f32621e = r100.toString();     // Catch: Throwable -> L14
        r102.p();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.a(th);
    }

    public final int a(b r110) {
        com.baidu.mshield.x0.l.a r100 = new com.baidu.mshield.x0.l.a(this.f32531b);     // Catch: Throwable -> L22
        long r101 = r100.j();     // Catch: Throwable -> L22
        long r102 = ((long) r100.m()) * 60000;     // Catch: Throwable -> L22
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L22
        if (r102 > 0) goto L8;
        if (r110 == null) goto L6;
        r110.a(1);     // Catch: Throwable -> L22
    L6:
        return 1;
    L8:
        if ((r103 - r101) >= r102) goto L10;
        boolean r104 = false;
    L15:
        if (r104 == false) goto L19;
        if (r110 == null) goto L18;
        r110.a(0);     // Catch: Throwable -> L22
    L18:
        return 0;
    L19:
        if (r110 == null) goto L21;
        r110.a(1);     // Catch: Throwable -> L22
    L21:
        return 1;
    L10:
        if (d.n(this.f32531b) == false) goto L12;
        r104 = a();     // Catch: Throwable -> L22
    L13:
        r100.c(r103);     // Catch: Throwable -> L22
        goto L15
    L12:
        r104 = false;
    L22:
        th = move-exception;
        d.a(th);
        if (r110 == null) goto L26;
        r110.a(2);
    L26:
        return 2;
    }

    public final void b(String r100) {
        com.baidu.mshield.b.c.a.b("handleFgPolicy:" + r100);     // Catch: Throwable -> L5
        l.b(this.f32531b, r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        d.a(th);
    }

    public final void a(String r100) {
        com.baidu.mshield.b.c.a.b("handleEmulatorSig:" + r100);     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r100) == true) goto L6;
        String r101 = e.a(r100);     // Catch: Throwable -> L8
        l.f32619c = r101;     // Catch: Throwable -> L8
        new com.baidu.mshield.x6.b.b(this.f32531b).h(r101);     // Catch: Throwable -> L8
        String r102 = new String(com.baidu.mshield.b.a.c.b(Base64.decode(r100.getBytes(), 0)), XML.CHARSET_UTF8);     // Catch: Throwable -> L8
        com.baidu.mshield.b.c.a.b("handleEmulatorSig ungz:".concat(r102));     // Catch: Throwable -> L8
        l.f32617a = r102;     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        f.c(this.f32531b);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        d.a(th);
    }

    public static synchronized a a(Context r100) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f32530a != null) goto L7;
        f32530a = new a(r100);     // Catch: Throwable -> L10
    L7:
        a r101 = f32530a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r101;
    }

    public final void a(com.baidu.mshield.x0.l.a r100, JSONObject r101) {
        JSONObject r102 = r101.optJSONObject("5");
        if (r102 == null) goto L11;
        int r103 = r102.optInt("1", 0);
        if (r103 == 0) goto L7;
    L9:
        r100.b(r103);
        r100.f(r102.optInt(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, 0));
        r100.g(r102.optInt(Constants.VIA_REPORT_TYPE_WPA_STATE, 3));
        return;
    L7:
        if (r100.d() == false) goto L9;
        EngineImpl.getInstance(this.f32531b).unload();
        goto L9
    }

    public int a(b r100, boolean r101) {
        if (r101 == false) goto L6;
        com.baidu.mshield.x0.d.h.d.b().a(new C0658a(this, r100));
        return 0;
    L6:
        return a(r100);
    }

    public static /* synthetic */ int a(a r100, b r101) {
        return r100.a(r101);
    }

    public final void a(JSONObject r210, String r211, String r212, String r213) {
        com.baidu.mshield.b.c.a.b("handleSecPolicy:" + r210.toString());     // Catch: Throwable -> L146
        com.baidu.mshield.x0.l.a r110 = new com.baidu.mshield.x0.l.a(this.f32531b);     // Catch: Throwable -> L146
        JSONObject r111 = r210.optJSONObject("3");     // Catch: Throwable -> L146
        if (r111 == null) goto L8;
        r110.b("plc03", r111.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("3" + r111);     // Catch: Throwable -> L144
    L144:
        th = th;
    L148:
        d.a(th);
        return;
    L8:
        JSONObject r100 = r210.optJSONObject(Constants.VIA_REPORT_TYPE_WPA_STATE);     // Catch: Throwable -> L144
        if (r100 != null) goto L11;
    L12:
        JSONObject r101 = r210.optJSONObject(Constants.VIA_REPORT_TYPE_START_WAP);     // Catch: Throwable -> L144
        if (r101 != null) goto L15;
    L16:
        JSONObject r102 = r210.optJSONObject("18");     // Catch: Throwable -> L144
        if (r102 != null) goto L19;
    L20:
        JSONObject r103 = r210.optJSONObject("20");     // Catch: Throwable -> L144
        if (r103 != null) goto L23;
    L24:
        JSONObject r104 = r210.optJSONObject(BDLocationException.ERROR_BACKGROUND_LOCATE);     // Catch: Throwable -> L144
        if (r104 != null) goto L27;
    L28:
        JSONObject r105 = r210.optJSONObject(BDLocationException.ERROR_PROVIDER_DISABLED);     // Catch: Throwable -> L144
        if (r105 != null) goto L31;
    L32:
        JSONObject r106 = r210.optJSONObject("71");     // Catch: Throwable -> L144
        if (r106 != null) goto L35;
    L36:
        JSONObject r107 = r210.optJSONObject("83");     // Catch: Throwable -> L144
        if (r107 != null) goto L39;
    L40:
        JSONObject r108 = r210.optJSONObject(BDLocationException.ERROR_GOOGLE_FAIL);     // Catch: Throwable -> L144
        if (r108 != null) goto L43;
    L44:
        JSONObject r109 = r210.optJSONObject(BDLocationException.ERROR_START_ADVERTISING_FAILED);     // Catch: Throwable -> L144
        if (r109 != null) goto L47;
    L48:
        JSONObject r112 = r210.optJSONObject("95");     // Catch: Throwable -> L144
        if (r112 != null) goto L51;
    L52:
        JSONObject r113 = r210.optJSONObject("107");     // Catch: Throwable -> L144
        if (r113 != null) goto L56;
    L61:
        JSONObject r114 = r210.optJSONObject("51");     // Catch: Throwable -> L144
        if (r114 == null) goto L68;
        r110.b("plc51", r114.toString());     // Catch: Throwable -> L144
        a(r110, r114);     // Catch: Throwable -> L142
        com.baidu.mshield.b.c.a.b("51" + r114.toString());     // Catch: Throwable -> L142
    L142:
        th = th;
    L68:
        JSONObject r115 = r210.optJSONObject(BDLocationException.ERROR_UID_IS_EMPTY);     // Catch: Throwable -> L142
        if (r115 != null) goto L71;
    L72:
        JSONObject r116 = r210.optJSONObject("104");     // Catch: Throwable -> L142
        if (r116 != null) goto L75;
    L76:
        JSONObject r117 = r210.optJSONObject(BDLocationException.ERROR_TMAP_WGS84);     // Catch: Throwable -> L142
        if (r117 == null) goto L89;
        com.baidu.mshield.b.c.a.b(BDLocationException.ERROR_TMAP_WGS84 + r117.toString());     // Catch: Throwable -> L142
        JSONObject r118 = r117.optJSONObject("5");     // Catch: Throwable -> L142
        if (r118.has("uv6") == false) goto L88;
        if (r118.optJSONObject("uv6").has("2") == false) goto L88;
        com.baidu.mshield.x0.c.a.f32467a = r118.optJSONObject("uv6").optString("2");     // Catch: Throwable -> L142
        com.baidu.mshield.b.c.a.b("policy detect app encrypt===" + com.baidu.mshield.x0.c.a.f32467a);     // Catch: Throwable -> L142
        r118.optJSONObject("uv6").remove("2");     // Catch: Throwable -> L142
        com.baidu.mshield.b.c.a.b("policy detect encryptStr====" + com.baidu.mshield.x0.c.a.f32467a);     // Catch: Throwable -> L142
        r110.b("plc114", r117.toString());     // Catch: Throwable -> L142
    L88:
        r110.b("plc114", r117.toString());     // Catch: Throwable -> L142
    L89:
        JSONObject r119 = r210.optJSONObject("115");     // Catch: Throwable -> L142
        if (r119 == null) goto L140;
        String r120 = r110.c("plc115");     // Catch: Throwable -> L142
        String r121 = "";
        if (TextUtils.isEmpty(r120) == true) goto L106;
        JSONObject r122 = new JSONObject(r120);     // Catch: Throwable -> L142
        r110.a(r122.optInt("3"));     // Catch: Throwable -> L142
        JSONObject r123 = r122.optJSONObject("5");     // Catch: Throwable -> L142
        if (r123.has("uv4") == true) goto L97;
    L99:
        String r124 = "";
    L101:
        if (r123.has("uv4") == true) goto L103;
    L105:
        String r125 = "";
    L107:
        com.baidu.mshield.b.c.a.b("115" + r119.toString());     // Catch: Throwable -> L142
        JSONObject r126 = r119.optJSONObject("5");     // Catch: Throwable -> L142
        if (r126.has("uv4") == false) goto L139;
        JSONObject r127 = r126.optJSONObject("uv4");     // Catch: Throwable -> L142
        if (r127.has("4") == false) goto L112;
        r121 = r127.optString("4");     // Catch: Throwable -> L142
        r110.e(r121);     // Catch: Throwable -> L142
    L112:
        int r128 = 0;
        if (r127.has("7") == false) goto L115;
        int r129 = r127.optJSONObject("7").optInt("2", 0);     // Catch: Throwable -> L142
        int r130 = r127.optJSONObject("7").optInt("3", 0);     // Catch: Throwable -> L142
        r128 = r129;
    L117:
        if (r127.has("2") == false) goto L132;
        String r131 = r127.optString("2");     // Catch: Throwable -> L142
        if (r128 != 0) goto L121;
    L130:
        com.baidu.mshield.x0.c.c.f32471a = r131;     // Catch: Throwable -> L142
        r127.remove("2");     // Catch: Throwable -> L142
        goto L132
    L121:
        if (TextUtils.isEmpty(r121) == true) goto L130;
        if (TextUtils.isEmpty(r131) == false) goto L132;
        if (TextUtils.isEmpty(r121) == true) goto L132;
        if (r121.equals(r125) == false) goto L132;
        r127.put("2", r124);     // Catch: Throwable -> L142
    L132:
        if (TextUtils.isEmpty(r121) == false) goto L134;
    L138:
        r110.b("plc115", r119.toString());     // Catch: Throwable -> L142
        goto L140
    L134:
        if (r121.equals(r125) == true) goto L138;
        if (r130 != 1) goto L138;
        r110.a(0);     // Catch: Throwable -> L142
        goto L138
    L115:
        r130 = 0;
        goto L117
    L139:
        r110.b("plc115", r119.toString());     // Catch: Throwable -> L142
        goto L140
    L103:
        if (r123.optJSONObject("uv4").has("4") == false) goto L105;
        r125 = r123.optJSONObject("uv4").optString("4");     // Catch: Throwable -> L142
        goto L107
    L97:
        if (r123.optJSONObject("uv4").has("2") == false) goto L99;
        r124 = r123.optJSONObject("uv4").optString("2");     // Catch: Throwable -> L142
        goto L101
    L106:
        r125 = "";
        r124 = r125;
    L140:
        r110.a(true);     // Catch: Throwable -> L142
        return;
    L75:
        r110.b("plc104", r116.toString());     // Catch: Throwable -> L142
        com.baidu.mshield.b.c.a.b("104" + r116.toString());     // Catch: Throwable -> L142
        goto L76
    L71:
        r110.b("plc102", r115.toString());     // Catch: Throwable -> L142
        int r132 = r115.optJSONObject("5").optInt("1", 60);     // Catch: Throwable -> L142
        r110.c(r132);     // Catch: Throwable -> L142
        com.baidu.mshield.x0.g.a.f32517d = r132;     // Catch: Throwable -> L142
        com.baidu.mshield.b.c.a.b(BDLocationException.ERROR_UID_IS_EMPTY + r115.toString());     // Catch: Throwable -> L142
        goto L72
    L56:
        r110.b("plc107", r113.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("107" + r113.toString());     // Catch: Throwable -> L144
        if (r113.has("5") == false) goto L61;
        JSONObject r133 = r113.optJSONObject("5");     // Catch: Throwable -> L144
        if (r133.has("t") == false) goto L61;
        r110.d(r133.optInt("t", 180));     // Catch: Throwable -> L144
        goto L61
    L51:
        r110.b("plc95", r112.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("95" + r112.toString());     // Catch: Throwable -> L144
        goto L52
    L47:
        r110.b("plc94", r109.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b(BDLocationException.ERROR_START_ADVERTISING_FAILED + r109);     // Catch: Throwable -> L144
        goto L48
    L43:
        r110.b("plc84", r108.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b(BDLocationException.ERROR_GOOGLE_FAIL + r108);     // Catch: Throwable -> L144
        goto L44
    L39:
        r110.b("plc83", r107.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("83" + r107);     // Catch: Throwable -> L144
        goto L40
    L35:
        r110.b("plc71", r106.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("71" + r106);     // Catch: Throwable -> L144
        goto L36
    L31:
        r110.b("plc62", r105.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b(BDLocationException.ERROR_PROVIDER_DISABLED + r105.toString());     // Catch: Throwable -> L144
        goto L32
    L27:
        r110.b("plc36", r104.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b(BDLocationException.ERROR_BACKGROUND_LOCATE + r104);     // Catch: Throwable -> L144
        goto L28
    L23:
        r110.b("plc20", r103.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("20" + r103);     // Catch: Throwable -> L144
        goto L24
    L19:
        r110.b("plc18", r102.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b("18" + r102);     // Catch: Throwable -> L144
        goto L20
    L15:
        r110.b("plc16", r101.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b(Constants.VIA_REPORT_TYPE_START_WAP + r101);     // Catch: Throwable -> L144
        goto L16
    L11:
        r110.b("plc15", r100.toString());     // Catch: Throwable -> L144
        com.baidu.mshield.b.c.a.b(Constants.VIA_REPORT_TYPE_WPA_STATE + r100);     // Catch: Throwable -> L144
    L146:
        th = th;
        goto L148
    }
}
