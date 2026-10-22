package com.obric.aiagent.applog.impl;

import android.os.Bundle;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.platform.depend.ITraceDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: TraceDependImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TraceDependImpl implements ITraceDepend {

    /* JADX INFO: compiled from: TraceDependImpl.kt */
    public static final class a implements com.obric.aiagent.applog.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ q<String, String, String, x> f16125a;

        a(q<? super String, ? super String, ? super String, x> r3) {
            this.f16125a = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.aiagent.applog.b
        public void a(String r2, String r3, String r4) {
            o.e(r2, "did");
            o.e(r3, WsConstants.KEY_INSTALL_ID);
            o.e(r4, "ssid");
            this.f16125a.invoke(r2, r3, r4);
            com.obric.aiagent.applog.impl.a.f16126a.b((com.obric.aiagent.applog.b) ZeusTransformUtils.preCheckCast(this, com.obric.aiagent.applog.b.class, "com.obric.aiagent.plugin"));
        }
    }

    public TraceDependImpl() {
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public void report(String r1, JSONObject r2) {
        o.e(r1, "event");
        o.e(r2, "params");
        com.obric.aiagent.applog.impl.a.f16126a.a(r1, r2);
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public void report(String r1, Bundle r2) {
        o.e(r1, "event");
        o.e(r2, "bundleParams");
        com.obric.aiagent.applog.impl.a.f16126a.a(r1, r2);
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public void enableETVerify() {
        com.obric.aiagent.applog.impl.a.f16126a.c();
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public String getSessionId() {
        String r0 = com.obric.aiagent.applog.impl.a.f16126a.a().u();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public String getDeviceId() {
        String r0 = com.obric.aiagent.applog.impl.a.f16126a.a().l();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public String getUserID() {
        String r0 = com.obric.aiagent.applog.impl.a.f16126a.a().p();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public String getUUID() {
        String r0 = com.obric.aiagent.applog.impl.a.f16126a.a().o();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public String getInstallId() {
        String r0 = com.obric.aiagent.applog.impl.a.f16126a.a().m();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public String getSsid() {
        String r0 = com.obric.aiagent.applog.impl.a.f16126a.a().n();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public void awaitTraceId(q<? super String, ? super String, ? super String, x> r3) {
        q r2 = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        o.e(r2, "callback");
        com.obric.aiagent.applog.impl.a.f16126a.a((com.obric.aiagent.applog.b) ZeusTransformUtils.preCheckCast(new a(r2), com.obric.aiagent.applog.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.platform.depend.ITraceDepend
    public void addCommonParams(Map<String, String> r4) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "params");
        Iterator r5 = r3.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.aiagent.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.applog.impl.a.f16126a.a().a(r1, r7);
        goto L4
    }
}
