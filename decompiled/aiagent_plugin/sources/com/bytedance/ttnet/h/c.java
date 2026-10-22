package com.bytedance.ttnet.h;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.j;
import com.bytedance.frameworks.baselib.network.http.g;
import com.bytedance.frameworks.baselib.network.http.i.k;
import com.bytedance.frameworks.baselib.network.http.i.l;
import com.bytedance.retrofit2.af;
import com.bytedance.retrofit2.ak;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SsInterceptor.java */
/* JADX INFO: loaded from: classes.dex */
public final class c extends com.bytedance.frameworks.baselib.network.http.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11498a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f11499b = false;

    static {
    }

    public c() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.a
    public com.bytedance.retrofit2.b.c a(com.bytedance.retrofit2.b.c r5) {
        com.bytedance.retrofit2.b.c r6 = super.a(r5);
        if (r6 != null) goto L7;
        return null;
    L7:
        if (f11499b == true) goto L9;
        com.bytedance.ttnet.d.b.b();
        f11499b = true;
    L9:
        com.bytedance.retrofit2.b.c.a r0 = r6.m();
        String r1 = r6.b();
        ArrayList r2 = new ArrayList();
        if (r6.c() == null) goto L12;
        r2.addAll(r6.c());
    L12:
        String r3 = a(r1, r6.p());
        a(r3, r0, r2, r6.p());
        com.bytedance.ttnet.utils.c.a(r3, r2, r6.p());
        com.bytedance.ttnet.utils.a.a(r3, r2, r6.p());
        ClientKeyManager.a().a(r2, r6.p());
        r0.a(r3);
        r0.a(r2);
        return r0.b();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.g.a
    public void a(com.bytedance.retrofit2.b.c r2, ak r3) {
        super.a(r2, r3);
        if (r2 == null) goto L8;
        if (r3 == null) goto L9;
        com.bytedance.retrofit2.b.d r4 = r3.b();
        a(r2, r4);
        ClientKeyManager.a().a(r2, r4);
        a(r2, r4, null);
        com.bytedance.ttnet.utils.a.a(r2, r4, null);
        return;
    L9:
        return;
    }

    private void a(String r3, com.bytedance.retrofit2.b.c.a r4, List<com.bytedance.retrofit2.b.b> r5, af r6) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        if (f11498a == true) goto L25;
        return;
    L25:
        LinkedList r7 = new LinkedList();     // Catch: Throwable -> L22
        r6.t();     // Catch: Throwable -> L22
        String r8 = com.bytedance.frameworks.core.encrypt.a.a(r3, r7);     // Catch: Throwable -> L19
        r6.u();     // Catch: Throwable -> L22
        if (r8 == null) goto L11;
        r4.a(r8);     // Catch: Throwable -> L22
    L11:
        if (r7.isEmpty() == true) goto L34;
        Iterator r9 = r7.iterator();     // Catch: Throwable -> L22
    L14:
        if (r9.hasNext() == false) goto L35;
        Pair r10 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r10 == null) goto L14;
        r2.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r10.first, String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r10.second, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L22
        goto L14
    L35:
        return;
    L34:
        return;
    L19:
        th = move-exception;
        r6.u();     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.printStackTrace();
    }

    private String a(String r8, af r9) {
        if (j.a(r8) == false) goto L5;
        return r8;
    L5:
        r9.L();
        LinkedHashMap r7 = new LinkedHashMap();     // Catch: Throwable -> L54
        Pair<String, String> r0 = l.b(r8, r7);     // Catch: Throwable -> L54
        if (r0 != null) goto L12;
        r9.M();
        return r8;
    L12:
        if (r7.isEmpty() == true) goto L31;
        Iterator r1 = r7.entrySet().iterator();     // Catch: Throwable -> L54
    L15:
        if (r1.hasNext() == false) goto L31;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r3 == null) goto L15;
        List r4 = (List) ZeusTransformUtils.preCheckCast(r3.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r4 == null) goto L15;
        if (r4.isEmpty() == true) goto L15;
        LinkedHashSet r5 = new LinkedHashSet();     // Catch: Throwable -> L54
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L54
    L26:
        if (r6.hasNext() == false) goto L15;
        String r10 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r5.contains(r10) == true) goto L29;
        r5.add(r10);     // Catch: Throwable -> L54
        goto L26
    L29:
        r6.remove();     // Catch: Throwable -> L54
    L31:
        k r2 = new k(((String) ZeusTransformUtils.preCheckCast(r0.first, String.class, "com.obric.aiagent.plugin")) + ((String) ZeusTransformUtils.preCheckCast(r0.second, String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L54
        if (r7.isEmpty() == true) goto L51;
        Iterator r11 = r7.entrySet().iterator();     // Catch: Throwable -> L54
    L35:
        if (r11.hasNext() == false) goto L51;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r12 == null) goto L35;
        if (r12.getKey() == null) goto L35;
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12.getValue(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r13 == null) goto L35;
        if (r13.isEmpty() == true) goto L35;
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L54
    L49:
        if (r14.hasNext() == false) goto L35;
        r2.a((String) ZeusTransformUtils.preCheckCast(r12.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L54
    L51:
        String r15 = r2.a();     // Catch: Throwable -> L54
        r9.M();
        return r15;
    L54:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L58
        r9.M();
        return r8;
    L58:
        th = move-exception;
        r9.M();
        throw th;
    }

    private void a(com.bytedance.retrofit2.b.c r4, com.bytedance.retrofit2.b.d r5) {
        if (g.c() == null) goto L23;
        r4.p().x();
        String r3 = g.c().a();     // Catch: Throwable -> L17
        if (j.a(r3) == true) goto L19;
        List<com.bytedance.retrofit2.b.b> r6 = r5.b(r3);     // Catch: Throwable -> L17
        if (r6 == null) goto L19;
        if (r6.size() <= 0) goto L19;
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L17
        Iterator<com.bytedance.retrofit2.b.b> r8 = r6.iterator();     // Catch: Throwable -> L17
    L13:
        if (r8.hasNext() == false) goto L15;
        r7.add(((com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r8.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L17
        goto L13
    L15:
        g.c().a(r7);     // Catch: Throwable -> L17
    L19:
        r4.p().y();
        return;
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r4.p().y();
        throw th;
    }

    private void a(com.bytedance.retrofit2.b.c r18, com.bytedance.retrofit2.b.d r19, com.bytedance.ttnet.d.b r20) {
        com.bytedance.retrofit2.b.d r1 = r19;
        r18.p().z();
        Object r0 = r19.f();     // Catch: Throwable -> L89
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.ttnet.d.b.class) == false) goto L26;
        com.bytedance.ttnet.d.b r3 = (com.bytedance.ttnet.d.b) ZeusTransformUtils.preCheckCast(r0, com.bytedance.ttnet.d.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L89
        if (r3.f8137c == 0) goto L96;
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L89
        List<com.bytedance.retrofit2.b.b> r7 = r19.c();     // Catch: Throwable -> L89
        int r8 = 0;
    L10:
        if (r8 >= r7.size()) goto L22;
        com.bytedance.retrofit2.b.b r2 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r7.get(r8), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L18 Throwable -> L89
        if (r2 == null) goto L20;
        if (TextUtils.isEmpty(r2.a()) == true) goto L20;
        r6.put(r2.a().toUpperCase(), r2.b());     // Catch: Exception -> L18 Throwable -> L89
    L20:
        r8 = r8 + 1;     // Catch: Throwable -> L89
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L89
        goto L20
    L22:
        if (ZeusTransformUtils.instanceOf(r3.f8137c, com.bytedance.ttnet.d.d.class) == false) goto L24;
        ((com.bytedance.ttnet.d.d) ZeusTransformUtils.preCheckCast(r3.f8137c, com.bytedance.ttnet.d.d.class, "com.obric.aiagent.plugin")).H = r6;     // Catch: Throwable -> L89
    L24:
        ((com.bytedance.ttnet.d.d) ZeusTransformUtils.preCheckCast(r3.f8137c, com.bytedance.ttnet.d.d.class, "com.obric.aiagent.plugin")).f8188b = r19.b();     // Catch: Throwable -> L89
        ((com.bytedance.ttnet.d.d) ZeusTransformUtils.preCheckCast(r3.f8137c, com.bytedance.ttnet.d.d.class, "com.obric.aiagent.plugin")).f8187a = r3.w;     // Catch: Throwable -> L89
    L96:
        String r4 = r19.a();     // Catch: Throwable -> L40
        com.bytedance.retrofit2.b.b r9 = r18.a("X-SS-REQ-TICKET");     // Catch: Throwable -> L38
        String r10 = null;
        if (r9 == null) goto L32;
        String r11 = r9.b();     // Catch: Throwable -> L38
    L33:
        com.bytedance.retrofit2.b.b r5 = r1.a("X-SS-REQ-TICKET");     // Catch: Throwable -> L38
        if (r5 == null) goto L36;
        r10 = r5.b();     // Catch: Throwable -> L38
    L36:
        com.bytedance.ttnet.utils.c.a(r4, r11, r10, r3);     // Catch: Throwable -> L38
    L94:
        String r12 = r18.b();     // Catch: Throwable -> L83
        Uri r13 = Uri.parse(r12);     // Catch: Throwable -> L83
        if (r13.getHost().endsWith(com.bytedance.ttnet.b.a()) == true) goto L47;
        r18.p().A();
        return;
    L47:
        String[] r14 = {"Set-Cookie"};     // Catch: Throwable -> L83
        int r15 = 2;
        String[] r16 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L83
        int r17 = 0;
    L49:
        if (r17 >= 1) goto L85;
        List<com.bytedance.retrofit2.b.b> r110 = r1.b(r14[r17]);     // Catch: Throwable -> L83
        if (r110 == null) goto L82;
        if (r110.size() <= 0) goto L82;
        Iterator<com.bytedance.retrofit2.b.b> r111 = r110.iterator();     // Catch: Throwable -> L83
    L57:
        if (r111.hasNext() == false) goto L82;
        com.bytedance.retrofit2.b.b r112 = (com.bytedance.retrofit2.b.b) ZeusTransformUtils.preCheckCast(r111.next(), com.bytedance.retrofit2.b.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L83
        int r113 = 0;
    L59:
        if (r113 >= r15) goto L57;
        String r114 = com.bytedance.frameworks.baselib.network.http.f.a.a(r112.b(), r16[r113]);     // Catch: Throwable -> L83
        if (Logger.debug() == false) goto L64;
        Logger.d("SsOkHttpClient", r114);     // Catch: Throwable -> L83
    L64:
        if (j.a(r114) == true) goto L80;
        int r115 = r19.b();     // Catch: Throwable -> L83
        boolean r116 = r3.ad;     // Catch: Throwable -> L83
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L83
        String r22 = r13.getEncodedQuery();     // Catch: Throwable -> L93
        if (j.a(r22) == true) goto L71;
        r21.put("url_query", r22);     // Catch: Throwable -> L93
    L71:
        if (j.a(r3.w) == true) goto L74;
        r21.put("remote_ip", r3.w);     // Catch: Throwable -> L83
    L74:
        if (r19.c() == null) goto L76;
        r21.put("header_list", r19.c().toString());     // Catch: Throwable -> L83
    L76:
        int r23 = r12.indexOf("?");     // Catch: Throwable -> L83
        if (r23 != (-1)) goto L79;
        r23 = r12.length();     // Catch: Throwable -> L83
    L79:
        com.bytedance.ttnet.utils.c.a("set_cookie", r12.substring(0, r23), r115, r116, r21);     // Catch: Throwable -> L83
    L80:
        r113 = r113 + 1;
        r15 = 2;
    L82:
        r17 = r17 + 1;
        r1 = r19;
        r15 = 2;
        goto L49
    L85:
        r18.p().A();
        return;
    L83:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L87
    L87:
        th = th;
    L91:
        r18.p().A();
        throw th;
    L32:
        r11 = null;
    L38:
        th = th;
    L102:
        th.printStackTrace();     // Catch: Throwable -> L87
    L40:
        th = th;
        goto L102
    L26:
        r3 = r20;
    L89:
        th = th;
        goto L91
    }

    public static void a(boolean r0) {
        f11498a = r0;
    }
}
