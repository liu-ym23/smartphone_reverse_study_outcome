package com.obric.autogui.net.ttnet;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.product.feature.api.IFeatureService;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.LoggedInUserInfo;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.net.ttnet.b.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.v;

/* JADX INFO: compiled from: AOTTNetTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f29240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f29241b = null;

    private c() {
    }

    public final ArrayList<com.bytedance.retrofit2.b.b> a(Map<String, String> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        o.e(r8, "header");
        ArrayList<com.bytedance.retrofit2.b.b> r0 = new ArrayList();
        Iterator r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.aiagent.plugin")));
        goto L4
    L7:
        return a(r0);
    }

    public final ArrayList<com.bytedance.retrofit2.b.b> a(ArrayList<com.bytedance.retrofit2.b.b> r6) {
        o.e(r6, "header");
        ArrayList<com.bytedance.retrofit2.b.b> r5 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin"));
        f.a r7 = f.f29233a.a();
        if (r7.a() == false) goto L5;
        r5.add(new com.bytedance.retrofit2.b.b("x-use-ppe", "1"));
        r5.add(new com.bytedance.retrofit2.b.b("x-tt-env", r7.b()));
    L5:
        LoggedInUserInfo r8 = AOPlatformTools.INSTANCE.account().acquireUserInfo().getUserInfo();
        if (r8 == null) goto L13;
        Map<String, String> r9 = r8.getAuthHeaders();
        if (r9 == null) goto L13;
        Iterator<Map.Entry<String, String>> r10 = r9.entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r5.add(new com.bytedance.retrofit2.b.b((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.aiagent.plugin")));
    L13:
        return r5;
    }

    public final String a(String r6) {
        o.e(r6, "url");
        v r1 = v.c(r6);     // Catch: Exception -> L12
        if (r1 != null) goto L6;
        return r6;
    L6:
        v.a r2 = r1.n();     // Catch: Exception -> L12
        Iterator r5 = ((Map) ZeusTransformUtils.preCheckCast(a(), Map.class, "com.obric.aiagent.plugin")).entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L12
        r2.a((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L12
        goto L8
    L10:
        String r7 = r2.c().toString();     // Catch: Exception -> L12
        o.c(r7, "toString(...)");     // Catch: Exception -> L12
        return r7;
    L12:
        return r6;
    }

    public final HashMap<String, String> a() {
        HashMap<String, String> r2 = new HashMap();
        if (IAppContext.Companion.isReleaseChannel() == true) goto L5;
        r2.put("device_id", AODeviceInfo.INSTANCE.getDid());
        r2.put(WsConstants.KEY_APP_ID, String.valueOf(IAppContext.Companion.getAppId()));
    L5:
        r2.put("flow_app_variant", IFeatureService.Companion.get().appVariant());
        r2.put("obric_os_build_type", f29241b);
        return r2;
    }

    static {
        f29240a = new c();
        String r0 = com.bytedance.common.utility.c.a("ro.os.ota.version");
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r4 = "userroot";
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userroot", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L9;
    L15:
        f29241b = r4;
        return;
    L9:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userdebug", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L12;
        r4 = "userdebug";
        goto L15
    L12:
        if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("user", CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null) == false) goto L14;
        r4 = "user";
        goto L15
    L14:
        r4 = SensitiveType.UNKNOWN;
        goto L15
    }
}
