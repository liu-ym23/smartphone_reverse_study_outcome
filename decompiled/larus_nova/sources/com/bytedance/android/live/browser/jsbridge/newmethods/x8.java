package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.os.Bundle;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.OpenPaidRightsFullViewResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_api.paidlive.IPaidOuterService;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.android.livesdkapi.paid.SimpleVideoItem;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openPaidRightsFullView")
public final class x8 extends w20.q4<w20.pc, OpenPaidRightsFullViewResultModel> {
    public x8() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.pc r102 = (w20.pc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        PaidPrivilegeItem r103 = new PaidPrivilegeItem();
        r103.setType(r102.getType());
        w20.pc.a r104 = r102.e();
        String r105 = "";
        if (r104 == null) goto L6;
        String r106 = r104.b();
        if (r106 == null) goto L6;
    L7:
        r103.setTitle(r106);
        w20.pc.a r107 = r102.e();
        if (r107 == null) goto L11;
        String r108 = r107.a();
        if (r108 == null) goto L11;
    L12:
        r103.setDescription(r108);
        String r109 = r102.a();
        if (r109 == null) goto L16;
        r105 = r109;
    L16:
        r103.setHybridSchema(r105);
        Integer r110 = r102.f();
        int r111 = 0;
        if (r110 == null) goto L19;
        int r112 = r110.intValue();
    L20:
        r103.setClickVideoIndex(r112);
        r103.setVideoList(new ArrayList());
        Boolean r113 = r102.c();
        if (r113 == null) goto L23;
        boolean r114 = r113.booleanValue();
    L24:
        r103.setNeedBanRecord4Paid(r114);
        Boolean r115 = r102.d();
        if (r115 == null) goto L27;
        boolean r116 = r115.booleanValue();
    L28:
        r103.setNeedHistoryStart(r116);
        JsonObject r117 = r102.b();
        if (r117 != null) goto L48;
    L33:
        w20.pc.a r118 = r102.e();
        if (r118 == null) goto L43;
        List<String> r119 = r118.c();
        if (r119 == null) goto L43;
        int r120 = r119.size();
    L38:
        if (r111 >= r120) goto L43;
        List<SimpleVideoItem> r121 = r103.getVideoList();
        if (r121 == null) goto L42;
        SimpleVideoItem r122 = new SimpleVideoItem();
        r122.setVideoModelStr((String) ListProtector.get(r119, r111));
        Unit r123 = Unit.INSTANCE;
        r121.add(r122);
    L42:
        r111 = r111 + 1;
    L43:
        Bundle r124 = new Bundle();
        r124.putSerializable("paid_privilege_item", r103);
        IPaidOuterService r125 = (IPaidOuterService) jc1.k.f(IPaidOuterService.class);
        if (r125 == null) goto L46;
        r125.startPaidPrivilegeFullPage(r101.getContext(), r124);
    L46:
        finishWithResult(null);
        return;
    L48:
        r103.setExtraLogMap((Map) GsonHelper.get().fromJson(r117.toString(), Map.class));     // Catch: Exception -> L32
        ALogger.i("OpenPaidRightsFullViewMethod", String.valueOf(r103.getExtraLogMap()));     // Catch: Exception -> L32
        goto L33
    L27:
        r116 = false;
        goto L28
    L23:
        r114 = false;
        goto L24
    L19:
        r112 = 0;
    L11:
        r108 = "";
    L6:
        r106 = "";
        goto L7
    }
}
