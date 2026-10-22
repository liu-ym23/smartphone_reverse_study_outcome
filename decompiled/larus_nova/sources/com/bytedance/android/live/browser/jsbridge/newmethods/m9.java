package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.OpenVSMessageBoardInputPanelResultModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openVSMessageBoardInputPanel")
public final class m9 extends w20.v4<w20.vc, OpenVSMessageBoardInputPanelResultModel> implements OpenVSMsgBoardInputEvent.Callback {
    @Override // com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent.Callback
    public final void onCancel() {
        OpenVSMessageBoardInputPanelResultModel r100 = new OpenVSMessageBoardInputPanelResultModel();
        r100.a(OpenVSMessageBoardInputPanelResultModel.Code.Success);
        r100.b(new OpenVSMessageBoardInputPanelResultModel.a());
        Unit r101 = Unit.INSTANCE;
        finishWithResult(r100);
    }

    public m9() {
    }

    public final void j(w20.vc r110) {
        xs2.b r100 = xs2.b.a();
        JsonObject r101 = r110.a();
        if (r101 == null) goto L7;
        JsonElement r102 = r101.get("source");
        if (r102 == null) goto L7;
        String r103 = r102.getAsString();
    L8:
        JsonObject r104 = r110.a();
        if (r104 == null) goto L13;
        JsonElement r105 = r104.get("show_type");
        if (r105 == null) goto L13;
        String r106 = r105.getAsString();
    L14:
        JsonObject r107 = r110.a();
        if (r107 == null) goto L19;
        JsonElement r108 = r107.get("gradient_type");
        if (r108 == null) goto L19;
        int r109 = r108.getAsInt();
    L20:
        JsonObject r111 = r110.a();
        if (r111 == null) goto L27;
        JsonElement r112 = r111.get("tab_type");
        if (r112 == null) goto L27;
        if (r112.getAsInt() != 0) goto L27;
        String r113 = "hot";
    L35:
        String r114 = r113;
        JsonObject r115 = r110.a();
        if (r115 == null) goto L40;
        JsonElement r116 = r115.get("parent_comment_id");
        if (r116 == null) goto L40;
        String r117 = r116.getAsString();
    L41:
        JsonObject r118 = r110.a();
        if (r118 == null) goto L46;
        JsonElement r119 = r118.get("reply_comment_id");
        if (r119 == null) goto L46;
        String r120 = r119.getAsString();
    L47:
        JsonObject r121 = r110.a();
        if (r121 == null) goto L52;
        JsonElement r122 = r121.get("reply_user_id");
        if (r122 == null) goto L52;
        String r123 = r122.getAsString();
    L53:
        JsonObject r124 = r110.a();
        if (r124 == null) goto L58;
        JsonElement r125 = r124.get("enter_from_merge");
        if (r125 == null) goto L58;
        String r126 = r125.getAsString();
    L59:
        JsonObject r127 = r110.a();
        if (r127 == null) goto L64;
        JsonElement r128 = r127.get("is_select_to_story");
        if (r128 == null) goto L64;
        boolean r129 = r128.getAsBoolean();
    L65:
        JsonObject r130 = r110.a();
        if (r130 == null) goto L70;
        JsonElement r131 = r130.get("title");
        if (r131 == null) goto L70;
        String r132 = r131.getAsString();
    L71:
        r100.post(new OpenVSMsgBoardInputEvent(this, r103, r106, r109, r114, r117, r120, r123, r126, r129, r132));
        return;
    L70:
        r132 = null;
    L64:
        r129 = false;
    L58:
        r126 = null;
    L52:
        r123 = null;
    L46:
        r120 = null;
    L40:
        r117 = null;
    L27:
        JsonObject r133 = r110.a();
        if (r133 == null) goto L34;
        JsonElement r134 = r133.get("tab_type");
        if (r134 == null) goto L34;
        if (r134.getAsInt() != 1) goto L34;
        r113 = "latest";
    L34:
        r113 = "";
    L19:
        r109 = 0;
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.vc r102 = (w20.vc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IUserService r103 = (IUserService) jc1.k.f(IUserService.class);
        if (r103 == null) goto L10;
        com.bytedance.android.livesdk.user.f r104 = r103.user();
        if (r104 == null) goto L10;
        if (r104.isLogin() != true) goto L10;
        j(r102);
        return;
    L10:
        IUserService r105 = (IUserService) jc1.k.f(IUserService.class);
        if (r105 == null) goto L19;
        com.bytedance.android.livesdk.user.f r106 = r105.user();
        if (r106 == null) goto L20;
        Observable<IBaseUser> r107 = r106.login(r101.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a()));
        if (r107 == null) goto L21;
        r107.subscribe(new k9(this, r102, r101), new l9(this));
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent.Callback
    public final void onSend(String r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        OpenVSMessageBoardInputPanelResultModel r107 = new OpenVSMessageBoardInputPanelResultModel();
        r107.a(OpenVSMessageBoardInputPanelResultModel.Code.Success);
        OpenVSMessageBoardInputPanelResultModel.a r108 = new OpenVSMessageBoardInputPanelResultModel.a();
        r108.c(r100);
        r108.b(r101);
        r108.g(r102);
        r108.a(r103);
        r108.d(r104);
        r108.e(r105);
        r108.f(r105);
        Unit r109 = Unit.INSTANCE;
        r107.b(r108);
        finishWithResult(r107);
    }
}
