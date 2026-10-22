package com.bytedance.android.sdk.bdticketguard;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    public static final String b(Throwable r100) {
        return r0.e(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v109 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r12v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    public static final void a(JSONObject r110, e0 r111) {
        e0.c r100 = r111.f163649e;
        e0.e r101 = r111.f163645a;
        e0.d r102 = r111.f163647c;
        e0.a r103 = r111.f163646b;
        String r104 = r101.f163687a;
        int r105 = k0.f163802b;
        String r106 = p0.a(r104);
        v r107 = r102.f163686l;
        String r108 = "";
        if (r107 == null) goto L7;
        String r109 = r107.f164094b;
        if (r109 == null) goto L7;
    L8:
        com.bytedance.android.sdk.bdticketguard.data.d r112 = r102.f163685k;
        if (r112 == null) goto L13;
        String r113 = r112.toString();
        if (r113 == null) goto L13;
    L14:
        l1 r114 = r102.f163682h;
        l1 r115 = r102.f163684j;
        r110.put("sign_path", r100.f163671j);
        r110.put("sign_ticket", r106);
        r110.put("sign_timestamp", String.valueOf(r100.f163669h));
        r110.put("sign_retry_count", r100.f163670i);
        r110.put("tee_req_sign", p0.a(r100.f163664c));
        r110.put("tee_req_sign_error_desc", r0.e(r100.f163672k));
        r110.put("tee_pub", r102.f163676b);
        r110.put("tee_create_logs", r109);
        l1 r116 = r102.f163683i;
        Throwable r117 = null;
        if (r116 == null) goto L17;
        Throwable r118 = r116.f163947a;
    L18:
        r110.put("tee_create_error_desc", r0.e(r118));
        r110.put("tee_gen_flags", r113);
        if (r114 == null) goto L21;
        Throwable r119 = r114.f163947a;
    L22:
        r110.put("tee_alias_load_error", r0.e(r119));
        long r120 = 0;
        if (r114 == null) goto L25;
        long r121 = r114.f163948b;
    L26:
        r110.put("tee_alias_load_timestamp", r121);
        if (r115 == null) goto L29;
        Throwable r122 = r115.f163947a;
    L30:
        r110.put("tee_keypair_load_error", r0.e(r122));
        if (r115 == null) goto L33;
        r120 = r115.f163948b;
    L33:
        r110.put("tee_keypair_load_timestamp", r120);
        com.bytedance.android.sdk.bdticketguard.data.e.a(r110, r102.f163685k);
        Boolean r123 = r102.f163680f;
        ?? r124 = -1;
        if (r123 == null) goto L36;
        ?? r125 = r123.booleanValue();
    L37:
        r110.put("tee_is_new_key", r125);
        r110.put("tee_create_reason", r102.f163679e);
        r110.put("tee_ts_sign", p0.a(r101.f163688b));
        r110.put("ree_ts_sign", p0.a(r101.f163689c));
        e0.f r126 = r101.f163691e;
        if (r126 == null) goto L42;
        String r127 = r126.f163694c;
        if (r127 == null) goto L42;
    L43:
        r110.put("tee_ts_sign_path", r127);
        e0.f r128 = r101.f163691e;
        if (r128 == null) goto L48;
        String r129 = r128.f163695d;
        if (r129 == null) goto L48;
    L49:
        r110.put("tee_ts_sign_logid", r129);
        e0.f r130 = r101.f163691e;
        if (r130 == null) goto L54;
        String r131 = r130.f163692a;
        if (r131 == null) goto L54;
    L55:
        r110.put("tee_ts_sign_pubkey", r131);
        e0.f r132 = r101.f163691e;
        if (r132 == null) goto L58;
        int r133 = r132.f163698g;
    L59:
        r110.put("ts_sign_info_version", r133);
        e0.f r134 = r101.f163691e;
        if (r134 == null) goto L62;
        int r135 = r134.f163698g;
    L63:
        r110.put("ts_sign_info_version", r135);
        r110.put("attest_ts_sign", p0.a(r101.f163690d));
        e0.f r136 = r101.f163691e;
        if (r136 == null) goto L68;
        String r137 = r136.f163696e;
        if (r137 == null) goto L68;
    L69:
        r110.put("attest_ts_sign_path", r137);
        e0.f r138 = r101.f163691e;
        if (r138 == null) goto L74;
        String r139 = r138.f163697f;
        if (r139 == null) goto L74;
        r108 = r139;
    L74:
        r110.put("attest_ts_sign_logid", r108);
        r110.put(ST.UUID_DEVICE, r111.f163651g.toString());
        r110.put("need_tee", r103.f163652a ? 1 : 0);
        r110.put("need_ree", r103.f163653b ? 1 : 0);
        r110.put("need_hmac", r103.f163654c ? 1 : 0);
        r110.put("need_attest_sign", r103.f163655d ? 1 : 0);
        Boolean r140 = r102.f163681g;
        if (r140 == null) goto L77;
        r124 = r140.booleanValue();
    L77:
        r110.put("is_tee_ever_fail", r124);
        r110.put("tee_init_result", String.valueOf(r102.f163675a));
        r110.put("tee_credential", r102.f163677c);
        r110.put("tee_cert_type", r102.f163678d);
        r110.put("timestamp", String.valueOf(r111.f163650f.f163699a));
        r110.put("server_timestamp", String.valueOf(r111.f163650f.f163701c));
        r110.put("system_timestamp", String.valueOf(System.currentTimeMillis()));
        r110.put("timestamp_source", r111.f163650f.f163700b);
        r110.put("timestamp_flags", r111.f163650f.f163702d);
        r110.put("ree_init_result", String.valueOf(r111.f163648d.f163656a));
        r110.put("ree_encryption_init_result", String.valueOf(r111.f163648d.f163657b));
        r110.put("ree_pub_key", r111.f163648d.f163658c);
        l1 r141 = r111.f163648d.f163660e;
        if (r141 == null) goto L80;
        Throwable r142 = r141.f163947a;
    L81:
        r110.put("ree_create_key_error", r0.e(r142));
        l1 r143 = r111.f163648d.f163661f;
        if (r143 == null) goto L84;
        r117 = r143.f163947a;
    L84:
        r110.put("ree_load_key_error", r0.e(r117));
        Iterator<Map.Entry<String, ? extends Object>> r144 = r111.f163650f.f163703e.entrySet().iterator();
    L86:
        if (r144.hasNext() == false) goto L88;
        Map.Entry<String, ? extends Object> r145 = r144.next();
        String r146 = r145.getKey();
        r110.put("timestamp_extra_" + r146, r145.getValue());
        goto L86
    L88:
        return;
    L80:
        r142 = null;
    L68:
        r137 = "";
        goto L69
    L62:
        r135 = -1;
        goto L63
    L58:
        r133 = -1;
    L54:
        r131 = "";
    L48:
        r129 = "";
    L42:
        r127 = "";
        goto L43
    L36:
        r125 = -1;
        goto L37
    L29:
        r122 = null;
        goto L30
    L25:
        r121 = 0;
        goto L26
    L21:
        r119 = null;
        goto L22
    L17:
        r118 = null;
    L13:
        r113 = "";
    L7:
        r109 = "";
        goto L8
    }
}
