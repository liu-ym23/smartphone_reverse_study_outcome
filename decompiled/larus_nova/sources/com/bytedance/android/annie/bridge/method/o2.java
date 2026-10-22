package com.bytedance.android.annie.bridge.method;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class o2 implements com.bytedance.android.annie.websocket.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CallContext f38742a;

    public final CallContext getContext() {
        return this.f38742a;
    }

    public o2(CallContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f38742a = r100;
    }

    @Override // com.bytedance.android.annie.websocket.d
    public final void a(com.bytedance.android.annie.websocket.e r100) {
        Intrinsics.checkNotNullParameter(r100, "requestState");
        String r101 = r100.f40111a;
        switch(r101.hashCode()) {
            case -1987107780: goto L18;
            case -1357520532: goto L14;
            case -1281977283: goto L10;
            case -579210487: goto L6;
            default: goto L31;
        };
    L31:
        return;
    L6:
        if (r101.equals(PTYSocketStateCallback.CONNECTED) == false) goto L32;
        JSONObject r102 = new JSONObject();
        r102.put("status", PTYSocketStateCallback.CONNECTED);
        r102.put("socketTaskID", r100.f40112b);
        this.f38742a.b("socketStatusChanged", r102);
        return;
    L32:
        return;
    L10:
        if (r101.equals("failed") == false) goto L33;
        JSONObject r103 = new JSONObject();
        r103.put("status", "failed");
        r103.put("message", r100.f40113c);
        r103.put("socketTaskID", r100.f40112b);
        this.f38742a.b("socketStatusChanged", r103);
        return;
    L33:
        return;
    L14:
        if (r101.equals(PTYSocketStateCallback.CLOSED) == false) goto L34;
        JSONObject r104 = new JSONObject();
        r104.put("status", PTYSocketStateCallback.CLOSED);
        r104.put("socketTaskID", r100.f40112b);
        this.f38742a.b("socketStatusChanged", r104);
        return;
    L34:
        return;
    L18:
        if (r101.equals("onMessaged") == false) goto L35;
        JSONObject r105 = new JSONObject();
        r105.put("socketTaskID", r100.f40112b);
        String r106 = r100.f40114d;
        if (r106 == null) goto L23;
        r105.put("data", r106);
    L23:
        String r107 = r100.f40115e;
        if (r107 == null) goto L26;
        r105.put("dataType", r107);
    L26:
        this.f38742a.b("socketDataReceived", r105);
        return;
    }
}
