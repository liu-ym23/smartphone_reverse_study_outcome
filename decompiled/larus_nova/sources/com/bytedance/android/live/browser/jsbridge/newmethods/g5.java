package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.GetRevenueLotteryLogParamsResultModel;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.UserType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getRevenueLotteryLogParams")
public final class g5 extends w20.s1<JsonObject, GetRevenueLotteryLogParamsResultModel> {
    public g5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IMiddlewareUserService r102 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        String r103 = "";
        if (r102 == null) goto L8;
        com.bytedance.android.livesdk.user.e r104 = r102.user();
        if (r104 == null) goto L8;
        String r105 = r104.n();
        if (r105 == null) goto L8;
    L9:
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put("function_type2", ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionTypeForLog());
        com.bytedance.live.datacontext.i<LiveMode> r107 = com.bytedance.android.livesdk.chatroom.utils.o3.f().getLiveMode();
        if (r107 == null) goto L12;
        LiveMode r108 = r107.getValue();
    L14:
        if (r108 == null) goto L29;
        int r109 = f5.f63374a[r108.ordinal()];
        if (r109 == 1) goto L28;
        if (r109 == 2) goto L27;
        if (r109 == 3) goto L26;
        if (r109 != 4) goto L22;
        r103 = "voice_live";
        goto L29
    L22:
        if (r109 != 5) goto L29;
        r103 = "media";
        goto L29
    L26:
        r103 = PriorityModule.SCENE_THIRD_PARTY;
        goto L29
    L27:
        r103 = "game";
        goto L29
    L28:
        r103 = "video_live";
    L29:
        r106.put("live_type", r103);
        r106.put(FastStartLiveConfig.PLAY_MODE, com.bytedance.android.live.liveinteract.utils.w.a());
        UserType r110 = ((IInteractService) jc1.k.n(IInteractService.class)).tryGetTargetUserType(r105);
        if (r110 == null) goto L44;
        int r111 = f5.f63375b[r110.ordinal()];
        if (r111 == 1) goto L41;
        if (r111 == 2) goto L40;
        if (r111 == 3) goto L39;
        if (r111 == 4) goto L39;
        throw new NoWhenBranchMatchedException();
    L39:
        String r112 = "user";
    L42:
        r106.put("user_type", r112);
        goto L44
    L40:
        r112 = "guest";
        goto L42
    L41:
        r112 = "anchor";
    L44:
        if (((IKtvService) jc1.k.n(IKtvService.class)).isAudienceSingEnableSwitchOn() == false) goto L46;
        String r113 = "on";
    L47:
        r106.put(EventConstants.ExtraJson.KEY_ORDER_STATUS, r113);
        GetRevenueLotteryLogParamsResultModel r114 = new GetRevenueLotteryLogParamsResultModel();
        r114.a(GetRevenueLotteryLogParamsResultModel.Code.Success);
        GetRevenueLotteryLogParamsResultModel.a r115 = new GetRevenueLotteryLogParamsResultModel.a();
        r115.a(GsonProtectorUtils.toJson(GsonHelper.get(), r106));
        Unit r116 = Unit.INSTANCE;
        r114.b(r115);
        finishWithResult(r114);
        return;
    L46:
        r113 = "off";
        goto L47
    L12:
        r108 = null;
    L8:
        r105 = "";
        goto L9
    }
}
