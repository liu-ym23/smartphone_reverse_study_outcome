package com.bytedance.bdinstall.d;

import android.content.SharedPreferences;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ServerIdLoader.java */
/* JADX INFO: loaded from: classes.dex */
class y extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final an f6236e;
    private final com.bytedance.bdinstall.u f;

    y(an r3, com.bytedance.bdinstall.u r4) {
        super(true, false, false);
        this.f6236e = r3;
        this.f = r4;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r15) {
        SharedPreferences r0 = this.f.a(this.f6236e);
        String r14 = ((com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, String.valueOf(this.f6236e.a())), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin")).b();
        String r3 = r0.getString("bd_did", null);
        String r5 = r0.getString("install_id", null);
        String r7 = r0.getString("ssid", null);
        String r9 = r0.getString("klink_edi", null);
        String r11 = r0.getString("klink_eii", null);
        String r1 = r0.getString("klink_egdi", null);
        if (com.bytedance.bdinstall.t.a() == false) goto L5;
        com.bytedance.bdinstall.t.a("load d=" + r14 + " i=" + r5 + " s=" + r7 + " eDid=" + r9 + " eIid=" + r11);
    L5:
        ba.a(r15, "install_id", r5);
        ba.a(r15, "device_id", r14);
        ba.a(r15, "ssid", r7);
        ba.a(r15, "bd_did", r3);
        ba.a(r15, "klink_edi", r9);
        ba.a(r15, "klink_eii", r11);
        ba.a(r15, "klink_egdi", r1);
        return true;
    }

    @Override // com.bytedance.bdinstall.d.d
    public void b(JSONObject r1) {
        r1.remove("bd_did");
        r1.remove("install_id");
        r1.remove("ssid");
        r1.remove("device_id");
        r1.remove("klink_edi");
        r1.remove("klink_eii");
    }
}
