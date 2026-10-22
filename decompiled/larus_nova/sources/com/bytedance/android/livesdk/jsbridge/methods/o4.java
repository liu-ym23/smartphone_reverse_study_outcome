package com.bytedance.android.livesdk.jsbridge.methods;

import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "syncReplayStatus")
public final class o4 extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    public static final class a {

        @SerializedName("replay")
        int replay;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public o4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) throws Exception {
        a r102 = r100;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r103 = com.bytedance.android.livesdk.sharedpref.b.L0;
        boolean r104 = true;
        if (r102.replay != 1) goto L5;
        boolean r105 = true;
    L6:
        Boolean r106 = Boolean.valueOf(r105);
        r103.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r103, r106);
        HashMap r107 = new HashMap();
        if (r102.replay != 1) goto L9;
        boolean r108 = true;
    L10:
        if (r108 == false) goto L12;
        String r109 = "open";
    L13:
        r107.put("is_open", r109);
        r107.put("request_page", "live_end");
        Context r110 = r101.getContext();
        if (r110 != null) goto L16;
    L18:
        r104 = false;
    L19:
        if (r104 == false) goto L21;
        String r111 = "0";
    L22:
        r107.put("room_orientation", r111);
        r107.put("live_type", com.bytedance.android.livesdk.utils.j.a(null));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_record_status", r107, new Object[0]);
        return;
    L21:
        r111 = "1";
        goto L22
    L16:
        if (r110.getResources().getConfiguration().orientation != 1) goto L18;
    L12:
        r109 = "close";
        goto L13
    L9:
        r108 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }
}
