package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.bmhome.share.panel.ShareChannel;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "shareScreen")
public final class q extends com.bytedance.ies.web.jsbridge2.g<JSONObject, JSONObject> {
    public q() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final JSONObject invoke(JSONObject r110, CallContext r111) {
        JSONObject r112 = r110;
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r100 = JSONObjectProtectorUtils.getInt(r112, "x");
        int r101 = JSONObjectProtectorUtils.getInt(r112, "y");
        int r102 = JSONObjectProtectorUtils.getInt(r112, "width");
        int r113 = JSONObjectProtectorUtils.getInt(r112, "height");
        float r103 = fm3.e.a(r111.getContext(), r102);
        float r114 = fm3.e.a(r111.getContext(), r113);
        fa1.a r115 = new fa1.a(r111, (int) fm3.e.a(r111.getContext(), r100), (int) fm3.e.a(r111.getContext(), r101), (int) r103, (int) r114, new n(this, r111));
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r115);
    L8:
        return new JSONObject();
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
        goto L8
    }

    public static final void j(q r100, CallContext r101, boolean r102, String r103) {
        r100.getClass();
        if (Intrinsics.areEqual("qzone", r103) == false) goto L6;
        r103 = "q_zone";
    L10:
        r101.b("H5_shareCompleted", MapsKt.mapOf(new Pair[]{TuplesKt.to("isCancel", Boolean.valueOf(r102)), TuplesKt.to("platform", r103)}));
        return;
    L6:
        if (Intrinsics.areEqual("weixin_moment", r103) == false) goto L8;
    L9:
        r103 = ShareChannel.WX_MOMENTS;
        goto L10
    L8:
        if (Intrinsics.areEqual("weixin_moments", r103) == false) goto L10;
        goto L9
    }
}
