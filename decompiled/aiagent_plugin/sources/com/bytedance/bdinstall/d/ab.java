package com.bytedance.bdinstall.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SstLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class ab extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6206e;
    private final an f;

    ab(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6206e = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f = r5;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r8) {
        if (this.f.M() == true) goto L36;
        com.bytedance.bdinstall.g.a r0 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, String.valueOf(this.f.a())), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
        String[] r1 = null;
        if (ZeusTransformUtils.instanceOf(r0, com.bytedance.bdinstall.h.c.class) == false) goto L9;
        String r3 = ((com.bytedance.bdinstall.h.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.bdinstall.h.c.class, "com.obric.aiagent.plugin")).d();
        JSONArray r4 = ((com.bytedance.bdinstall.h.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.bdinstall.h.c.class, "com.obric.aiagent.plugin")).g();
        String r5 = ((com.bytedance.bdinstall.h.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.bdinstall.h.c.class, "com.obric.aiagent.plugin")).f();
        if (this.f.z() == false) goto L12;
        r1 = ((com.bytedance.bdinstall.h.c) ZeusTransformUtils.preCheckCast(r0, com.bytedance.bdinstall.h.c.class, "com.obric.aiagent.plugin")).e();
    L12:
        ba.a(r8, "build_serial", r3);
        ba.a(r8, "aliyun_uuid", a.a().b());
        if (a(r4) == false) goto L15;
        r8.put("udid_list", r4);
    L15:
        String r2 = com.bytedance.bdinstall.j.q.h(this.f6206e, this.f);
        if (TextUtils.isEmpty(r2) == true) goto L19;
        r8.put("mc", r2);
    L19:
        if (this.f.W() == false) goto L25;
        JSONArray r6 = com.bytedance.bdinstall.j.q.i(this.f6206e, this.f);
        if (r6 == null) goto L25;
        if (r6.length() == 0) goto L25;
        r8.put("ipv6_list", r6);
    L25:
        ba.a(r8, "udid", r5);
        ba.a(r8, "serial_number", r3);
        if (this.f.z() == false) goto L34;
        if (r1 == null) goto L34;
        JSONArray r7 = new JSONArray();
        int r9 = r1.length;
        int r10 = 0;
    L30:
        if (r10 >= r9) goto L32;
        r7.put(new JSONObject().put("sim_serial_number", r1[r10]));
        r10 = r10 + 1;
        goto L30
    L32:
        r8.put("sim_serial_number", r7);
    L34:
        if (com.bytedance.bdinstall.i.f().b() == false) goto L36;
        ba.a(r8, "miid", com.bytedance.bdinstall.j.q.e(this.f));
        goto L36
    L9:
        r3 = com.bytedance.bdinstall.j.q.g(this.f6206e, this.f);
        r4 = com.bytedance.bdinstall.j.q.d(this.f6206e, this.f);
        r5 = com.bytedance.bdinstall.j.q.a(this.f6206e, this.f);
        if (this.f.z() == false) goto L12;
        r1 = com.bytedance.bdinstall.j.q.c(this.f6206e, this.f);
    L36:
        com.bytedance.bdinstall.oaid.n.f();
        if (this.f.o() == false) goto L39;
        long r11 = com.bytedance.bdinstall.i.e().a();
    L40:
        Map<String, String> r12 = com.bytedance.bdinstall.oaid.j.a(this.f6206e).a(r11);
        com.bytedance.bdinstall.oaid.n.g();
        com.bytedance.bdinstall.t.a("getOaid: returned=" + r12);
        r8.put("oaid_may_support", com.bytedance.bdinstall.oaid.j.a(this.f6206e).d());
        if (r12 == null) goto L46;
        r8.put("oaid", new JSONObject(r12));
        return true;
    L46:
        return true;
    L39:
        r11 = com.bytedance.bdinstall.i.a(String.valueOf(this.f.a())).k().a();
        goto L40
    }

    private static boolean a(JSONArray r5) {
        if (r5 == null) goto L14;
        int r1 = r5.length();
        if (r1 <= 0) goto L19;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.optString(DbHelper.COL_ID)) == true) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    L14:
        return false;
    }
}
