package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.AnchorInfo;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.BaseInfoResultModel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "baseInfo")
public final class d0 extends w20.j<JsonObject, BaseInfoResultModel> {
    public d0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        JsonObject r102 = (JsonObject) r100;
        BaseInfoResultModel r103 = new BaseInfoResultModel();
        com.bytedance.android.livesdk.p4.f154192a.getValue().booleanValue();
        IBaseUser r104 = ((IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class)).user().b().cloneFrom();
        BaseInfoResultModel.c r105 = new BaseInfoResultModel.c();
        r105.e(String.valueOf(r104.getShortId()));
        r105.b(r104.getDisplayId());
        r105.f(r104.getIdString());
        r105.d(r104.getCastSecUid());
        if (r104.getAvatarThumbKt() == null) goto L5;
        r105.a((String) ListProtector.get(r104.getAvatarThumbKt().getUrls(), 0));
    L5:
        r105.c(r104.getNickName());
        r105.g(Integer.valueOf(r104.getLevel()));
        if (r104.getAnchorInfoExt() == null) goto L8;
        r105.h(Long.valueOf(r104.getAnchorInfoExt().getLevel()));
    L9:
        r103.e(r105);
        Room r106 = com.bytedance.android.live.liveinteract.api.utils.m.i().getCurrentRoom();
        if (r106 == null) goto L31;
        BaseInfoResultModel.b r107 = new BaseInfoResultModel.b();
        r107.d(r106.getIdStr());
        r107.e(Long.valueOf(r106.getRoomLayout()));
        if (r106.getPaidLiveData() == null) goto L16;
        boolean r108 = true;
        if (r106.getPaidLiveData().getPaidType() != 1) goto L16;
    L17:
        r107.g(Boolean.valueOf(r108));
        r107.b(Long.valueOf(r106.getLiveRoomMode()));
        if (r106.getRoomAuthStatus() == null) goto L21;
        r107.a(Integer.valueOf(r106.isGameRoom()));
        r107.c(Long.valueOf(r106.getRoomAuthStatus().getQuizGamePointsPlaying()));
    L21:
        if (r106.getSceneTypeInfo() == null) goto L23;
        r107.f(Boolean.valueOf(r106.getSceneTypeInfo().isLife()));
    L23:
        r103.d(String.valueOf(r106.getCreateTime()));
        r103.c(r107);
        BaseInfoResultModel.a r109 = new BaseInfoResultModel.a();
        IBaseUser r110 = r106.getOwner();
        r109.g(String.valueOf(r110.getShortId()));
        r109.d(r110.getDisplayId());
        r109.h(r110.getIdString());
        r109.f(r110.getCastSecUid());
        if (r110.getAvatarThumbKt() == null) goto L26;
        r109.c((String) ListProtector.get(r110.getAvatarThumbKt().getUrls(), 0));
    L26:
        r109.e(r110.getNickName());
        if (r110.getAnchorInfoExt() == null) goto L29;
        r109.a(Long.valueOf(r110.getAnchorInfoExt().getLevel()));
        r109.b(String.valueOf(((AnchorInfo) r110.getAnchorInfoExt()).getType()));
    L30:
        r103.a(r109);
        goto L31
    L29:
        r109.a(0);
        r109.b("");
    L16:
        r108 = false;
    L31:
        r103.b(BaseInfoResultModel.Code.Success);
        finishWithResult(r103);
        return;
    L8:
        r105.h(0);
        goto L9
    }
}
