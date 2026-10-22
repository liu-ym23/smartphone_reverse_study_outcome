package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livesdkapi.hybridapi.ILiveHybridContainer;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "webcastSdk.setSideslip")
public final class jc extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveHybridContainer f63494a;

    public jc(ILiveHybridContainer r100) {
        this.f63494a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        ILiveHybridContainer r113 = this.f63494a;
        if ((r113 instanceof v40.c) == false) goto L18;
        String r114 = r112.optString("forbid_right_back", "");
        if (r114 == null) goto L42;
        int r115 = r114.hashCode();
        if (r115 == 48) goto L15;
        if (r115 == 49) goto L12;
        return null;
    L12:
        if (r114.equals("1") == false) goto L34;
        ((v40.c) this.f63494a).setCloseByGesture(false);
        return null;
    L34:
        return null;
    L15:
        if (r114.equals("0") == false) goto L36;
        ((v40.c) this.f63494a).setCloseByGesture(true);
        return null;
    L36:
        return null;
    L42:
        return null;
    L18:
        if ((r113 instanceof v40.b) == false) goto L38;
        String r116 = r112.optString("forbid_right_back", "");
        if (r116 == null) goto L44;
        int r117 = r116.hashCode();
        if (r117 == 48) goto L30;
        if (r117 == 49) goto L27;
        return null;
    L27:
        if (r116.equals("1") == false) goto L39;
        ((v40.b) this.f63494a).setCloseByGesture(false);
        return null;
    L39:
        return null;
    L30:
        if (r116.equals("0") == false) goto L41;
        ((v40.b) this.f63494a).setCloseByGesture(true);
        return null;
    L41:
        return null;
    L44:
        return null;
    L38:
        return null;
    }
}
