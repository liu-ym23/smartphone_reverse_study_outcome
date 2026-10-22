package com.bytedance.bdinstall.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ConfigLoader.java */
/* JADX INFO: loaded from: classes.dex */
class g extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6215e;
    private final an f;
    private final com.bytedance.bdinstall.u g;

    g(Context r4, an r5, com.bytedance.bdinstall.u r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(false, true);
        this.f6215e = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.f = r5;
        this.g = r6;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r8) {
        r8.put("channel", this.f.k());
        r8.put("not_request_sender", 1);
        r8.put(WsConstants.KEY_APP_ID, this.f.a());
        String r0 = this.f.m();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        r8.put("release_build", r0);
        ba.a(r8, "user_agent", this.f.p());
        ba.a(r8, "ab_version", this.f.u());
        String r1 = this.f.q();
        if (TextUtils.isEmpty(r1) == false) goto L8;
        r1 = this.f.w();
    L8:
        ba.a(r8, "app_language", r1);
        String r2 = this.f.r();
        if (TextUtils.isEmpty(r2) == false) goto L11;
        r2 = this.f.x();
    L11:
        ba.a(r8, "app_region", r2);
        JSONObject r3 = this.f.s();
        if (r3 != null) goto L38;
    L17:
        JSONObject r4 = r8.optJSONObject(MonitorConstants.CUSTOM);
        if (r4 != null) goto L21;
        r4 = new JSONObject();
    L21:
        if (TextUtils.isEmpty(this.f.d()) == true) goto L36;
        r4.put("real_package_name", ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
    L36:
        Map<String, Object> r7 = this.f.A();     // Catch: Throwable -> L32
        if (r7 != null) goto L26;
    L34:
        r8.put(MonitorConstants.CUSTOM, r4);
        return true;
    L26:
        if (r7.size() <= 0) goto L34;
        Iterator<String> r5 = r7.keySet().iterator();     // Catch: Throwable -> L32
    L29:
        if (r5.hasNext() == false) goto L34;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        r4.put(r6, r7.get(r6));     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        th.printStackTrace();
        goto L34
    L38:
        r8.put("app_track", r3);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.bytedance.bdinstall.t.a(th);
        goto L17
    }

    @Override // com.bytedance.bdinstall.d.d
    public void b(JSONObject r1) {
        super.b(r1);
        r1.remove("channel");
        r1.remove("not_request_sender");
        r1.remove(WsConstants.KEY_APP_ID);
        r1.remove("release_build");
        r1.remove("user_agent");
        r1.remove("ab_version");
        r1.remove("app_language");
        r1.remove("app_region");
        r1.remove("app_track");
        r1.remove(MonitorConstants.CUSTOM);
    }
}
