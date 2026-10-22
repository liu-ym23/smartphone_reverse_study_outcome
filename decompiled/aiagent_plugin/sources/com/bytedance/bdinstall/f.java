package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: ApiParamsUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private af f6242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f6243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final aa f6245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f6246e;
    private final Map<String, String> f;
    private com.bytedance.bdinstall.j.m g;

    public f(aa r3) {
        aa r4 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
        this.f6243b = false;
        this.f6244c = 36;
        this.f6246e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.f6245d = r4;
    }

    public void a(af r3) {
        af r4 = (af) ZeusTransformUtils.wrapperContextForParams(r3, af.class, "com.obric.aiagent.plugin");
        if (this.f6242a != null) goto L7;
        if (r4 == null) goto L8;
        this.f6242a = r4;
        return;
    L8:
        return;
    }

    public void a(com.bytedance.bdinstall.j.m r1) {
        this.g = r1;
    }

    public String a(Context r10, StringBuilder r11, String r12, boolean r13, ar r14) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        String r15 = r11.toString();
        if (TextUtils.isEmpty(r15) == false) goto L5;
        return r15;
    L5:
        Uri r16 = Uri.parse(r15);
        Set<String> r0 = r16.getQueryParameterNames();
        Uri.Builder r17 = r16.buildUpon();
        LinkedHashMap r8 = new LinkedHashMap(this.f6244c);
        a(r3, r13, r12, r8, r14);
        Iterator<Map.Entry<String, String>> r18 = r8.entrySet().iterator();
    L7:
        if (r18.hasNext() == false) goto L13;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r19.getKey(), String.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r19.getValue(), String.class, "com.obric.aiagent.plugin");
        if (r0.contains(r110) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        r17.appendQueryParameter(r110, (String) ZeusTransformUtils.preCheckCast(r19.getValue(), String.class, "com.obric.aiagent.plugin"));
        goto L7
    L13:
        r11.delete(0, r11.length());
        r11.append(r17.build().toString());
        this.f6244c = r8.size();
        return r11.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context r8, boolean r9, String r10, Map<String, String> r11, ar r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L5;
        return;
    L5:
        r14.put("device_platform", "android");
        a(r14);
        if (r9 == false) goto L8;
        r14.put("ssmix", "a");
    L8:
        r14.put("_rticket", String.valueOf(System.currentTimeMillis()));
        an r15 = this.f6245d.l();
        g r0 = this.f6245d.m();
        String r2 = n.a(r15);
        if (TextUtils.isEmpty(r2) == false) goto L15;
        if (r0 == 0) goto L15;
        if (r0.i() == false) goto L15;
        r2 = n.a(r13);
    L15:
        if (TextUtils.isEmpty(r2) == true) goto L17;
        r14.put("cdid", r2);
    L17:
        HashMap<String, String> r3 = null;
        if (r15 == null) goto L20;
        com.bytedance.bdinstall.j.n r4 = new com.bytedance.bdinstall.j.n(r15);
    L21:
        if (r4 != null) goto L24;
        if (r0 == 0) goto L24;
        r4 = new com.bytedance.bdinstall.j.n(r0);
    L24:
        if (r4 == null) goto L40;
        String r5 = r4.a();
        if (TextUtils.isEmpty(r5) == true) goto L29;
        r14.put("channel", r5);
    L29:
        if (r10 == null) goto L31;
        r14.put(WsConstants.KEY_APP_ID, r10);
    L32:
        String r16 = r4.c();
        if (r16 == null) goto L35;
        r14.put(IBdInstall.PARAM_APP_NAME, r16);
    L36:
        r14.put("version_code", String.valueOf(r4.d()));
        String r17 = r4.e();
        if (r17 == null) goto L39;
        r14.put("version_name", r17);
    L39:
        r14.put("manifest_version_code", String.valueOf(r4.f()));
        r14.put("update_version_code", String.valueOf(r4.g()));
        goto L40
    L35:
        t.a(new IllegalArgumentException("app_name is null"));
        goto L36
    L31:
        r14.put(WsConstants.KEY_APP_ID, String.valueOf(r4.b()));
    L40:
        if (r15 == null) goto L42;
        z r18 = r15.n();
    L43:
        if (r18 == null) goto L46;
        r0 = r18;
    L46:
        if (r0 == 0) goto L62;
        String r19 = r0.j();
        if (TextUtils.isEmpty(r19) == true) goto L50;
        r14.put("ab_version", r19);
    L50:
        String r110 = r0.k();
        if (TextUtils.isEmpty(r110) == true) goto L53;
        r14.put("ab_client", r110);
    L53:
        String r111 = r0.l();
        if (TextUtils.isEmpty(r111) == true) goto L56;
        r14.put("ab_group", r111);
    L56:
        String r112 = r0.m();
        if (TextUtils.isEmpty(r112) == true) goto L59;
        r14.put("ab_feature", r112);
    L59:
        long r6 = r0.n();
        if (r6 <= 0) goto L62;
        r14.put("abflag", String.valueOf(r6));
    L62:
        if (r15 == null) goto L66;
        com.bytedance.bdinstall.g.c r113 = (com.bytedance.bdinstall.g.c) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.c.class, String.valueOf(r15.a())), com.bytedance.bdinstall.g.c.class, "com.obric.aiagent.plugin");
        if (r113 == null) goto L66;
        r113.a(r14);
    L66:
        String r114 = com.bytedance.bdinstall.j.x.a(r13);
        if (TextUtils.isEmpty(r114) == true) goto L69;
        r14.put(HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, r114);
    L69:
        int r115 = com.bytedance.bdinstall.j.x.b(r13);
        if (r115 <= 0) goto L73;
        r14.put("dpi", String.valueOf(r115));
    L73:
        if (Build.BRAND.equals("Pico") == false) goto L75;
        String r116 = com.bytedance.bdinstall.j.p.c();
    L76:
        r14.put("device_type", r116);
        r14.put(HardwareInfo.KEY_HW_VENDOR_BRAND, Build.BRAND);
        r14.put("language", Locale.getDefault().getLanguage());
        r14.put(RomInfo.KEY_ROM_OS_API, String.valueOf(Build.VERSION.SDK_INT));
        String r1 = Build.VERSION.RELEASE;     // Catch: Exception -> L132
        if (r1 != null) goto L80;
    L82:
        r14.put(RomInfo.KEY_ROM_OS_VERSION, r1);     // Catch: Exception -> L132
        goto L83
    L80:
        if (r1.length() <= 10) goto L82;
        r1 = r1.substring(0, 10);     // Catch: Exception -> L132
    L83:
        com.bytedance.bdinstall.j.m r7 = this.g;
        if (r7 == null) goto L88;
        String r20 = r7.b().name();
        if (TextUtils.isEmpty(r20) == true) goto L91;
        r14.put("ac", r20);
        t.a("NetworkStatusProvider network type is " + r20);
    L91:
        a(this.f6246e, r14, false);
        if (r12 != ar.f6144a) goto L135;
        a(this.f, r14, false);
    L135:
        af r117 = this.f6242a;     // Catch: Exception -> L100
        if (r117 == null) goto L98;
        r3 = r117.getExtraParams(r12);     // Catch: Exception -> L100
    L98:
        a(r3, r14, true);     // Catch: Exception -> L100
    L102:
        boolean r118 = ba.b(r13);
        am r21 = this.f6245d.f();
        if (a(r13, r15, r118, r21) == false) goto L128;
        if (r21 == null) goto L126;
        if (TextUtils.isEmpty(r21.a()) == true) goto L109;
        r14.put("klink_edi", r21.a());
    L109:
        if (TextUtils.isEmpty(r21.b()) == true) goto L112;
        r14.put("klink_eii", r21.b());
    L112:
        if (TextUtils.isEmpty(r21.c()) == true) goto L115;
        r14.put(WsConstants.KEY_INSTALL_ID, r21.c());
    L115:
        if (TextUtils.isEmpty(r21.f()) == true) goto L118;
        r14.put("device_id", r21.f());
    L118:
        if (TextUtils.isEmpty(r21.h()) == true) goto L121;
        r14.put("klink_egdi", r21.h());
    L121:
        if (r12 != ar.f6144a) goto L126;
        String r22 = r21.d();
        if (TextUtils.isEmpty(r22) == true) goto L126;
        r14.put("openudid", r22);
    L126:
        if (r12 != ar.f6144a) goto L128;
        e.a(r13, r14, r118, r15);
    L128:
        e.a(r118, r13, r15);
        com.bytedance.bdinstall.c.c r23 = this.f6245d.j();
        if (r23 == null) goto L137;
        r23.a(r14);
        return;
    L137:
        return;
    L100:
        e = move-exception;
        t.a(e);
        goto L102
    L88:
        String r24 = com.bytedance.common.utility.i.f(r13);
        if (TextUtils.isEmpty(r24) == true) goto L91;
        r14.put("ac", r24);
        t.a("NetworkUtils network type is " + r24);
        goto L91
    L75:
        r116 = Build.MODEL;
        goto L76
    L42:
        r18 = null;
        goto L43
    L20:
        r4 = null;
        goto L21
    }

    private boolean a(Context r3, an r4, boolean r5, am r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L10;
        boolean r8 = this.f6243b;
        if (r8 == true) goto L9;
        r8 = com.bytedance.bdinstall.j.j.a(r7, r4).getBoolean("_install_started_v2", false);
        if (r8 == false) goto L9;
        this.f6243b = true;
    L9:
        return r8;
    L10:
        if (r6 == null) goto L17;
        if (TextUtils.isEmpty(r6.f()) == true) goto L17;
        if (TextUtils.isEmpty(r6.c()) == true) goto L17;
        return true;
    L17:
        return false;
    }

    private void a(Map<String, String> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (com.bytedance.bdinstall.j.p.D() == false) goto L5;
        String r3 = "harmony";
    L6:
        r1.put(RomInfo.KEY_OS_TYPE, r3);
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (com.bytedance.bdinstall.j.p.D() == false) goto L16;
        r1.put("sub_os_api", String.valueOf(com.bytedance.bdinstall.j.u.a("hw_sc.build.os.apiversion")));     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L5:
        r3 = "android";
        goto L6
    }

    private static void a(Map<String, String> r4, Map<String, String> r5, boolean r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L25;
        return;
    L25:
        if (r7.isEmpty() == true) goto L42;
        Iterator r9 = r7.entrySet().iterator();     // Catch: Exception -> L24
    L7:
        if (r9.hasNext() == false) goto L44;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (r0 == null) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        if (TextUtils.isEmpty(r2) == true) goto L7;
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (r6 == false) goto L21;
        if (r8.containsKey(r2) == true) goto L7;
    L21:
        r8.put(r2, r1);     // Catch: Exception -> L24
        goto L7
    L44:
        return;
    L42:
        return;
    }
}
