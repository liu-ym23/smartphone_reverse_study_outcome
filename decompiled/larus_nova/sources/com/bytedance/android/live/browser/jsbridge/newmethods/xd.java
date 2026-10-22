package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class xd extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zd f63722a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public xd(zd r100) {
        this.f63722a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONArray r103 = r102.optJSONArray("types");
        if (r103 == null) goto L5;
        int r104 = r103.length();
    L6:
        int r105 = 0;
    L7:
        boolean r106 = true;
        if (r105 >= r104) goto L24;
        if (r103 == null) goto L12;
        String r107 = JSONArrayProtectorUtils.getString(r103, r105);
        if (r107 == null) goto L12;
    L14:
        if (r107.length() > 0) goto L17;
        r106 = false;
    L17:
        if (r106 == false) goto L23;
        zd r108 = this.f63722a;
        r108.getClass();
        Integer r109 = MessageType.getMessageIntType(MessageType.WEBCAST.concat(r107));
        if (r109 == null) goto L23;
        int r110 = r109.intValue();
        vlc.d r111 = r108.f63753a;
        if (r111 == null) goto L23;
        r111.addMessageListener(r110, new sd(r108, r107));
    L23:
        r105 = r105 + 1;
    L12:
        r107 = "";
        goto L14
    L24:
        JSONObject r112 = new JSONObject();
        r112.put("code", 1);
        Unit r113 = Unit.INSTANCE;
        finishWithResult(r112);
        return;
    L5:
        r104 = 0;
        goto L6
    }
}
