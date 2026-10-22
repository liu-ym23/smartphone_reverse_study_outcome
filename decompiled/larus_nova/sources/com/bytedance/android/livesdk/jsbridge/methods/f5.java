package com.bytedance.android.livesdk.jsbridge.methods;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.browser.jsbridge.base.UserInfoResultModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.HostUserDetail;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import w20.e7;
import w20.rf;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "userInfo")
public final class f5 extends e7<rf, UserInfoResultModel> {
    public f5() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        rf r102 = (rf) r100;
        int r103 = 1;
        if (r102.a() == null) goto L5;
        boolean r104 = r102.a().booleanValue();
    L7:
        if (r104 == false) goto L21;
        com.bytedance.android.livesdk.user.f r105 = ((IUserService) jc1.k.f(IUserService.class)).user();
        UserAttr r106 = (UserAttr) r105.b().getUserAttr();
        IUser r107 = r105.b();
        UserInfoResultModel r108 = new UserInfoResultModel();
        if (r105.isLogin() == false) goto L11;
        r108.g(1);
    L13:
        if (r105.isLogin() == false) goto L15;
        r108.e(String.valueOf(r107.getShortId()));
        r108.f(r107.getIdString());
        r108.d(r107.getCastSecUid());
        r108.c(r107.getRealNickName());
    L15:
        if (r106 != null) goto L17;
    L19:
        r103 = 0;
    L20:
        r108.h(Integer.valueOf(r103));
        r108.b(UserInfoResultModel.Code.Success);
        finishWithResult(r108);
        return;
    L17:
        if (r106.isMuted() == false) goto L19;
    L11:
        r108.g(0);
        goto L13
    L21:
        UserInfoResultModel r109 = new UserInfoResultModel();
        long r110 = TTLiveSDK.hostService().user().hostUserId();
        if (r110 == 0) goto L24;
        r109.g(1);
    L25:
        if (r110 == 0) goto L27;
        r109.f(String.valueOf(r110));
    L27:
        HostUserDetail r111 = TTLiveSDK.hostService().user().hostUserDetail();
        if (r111 != null) goto L30;
    L38:
        r109.b(UserInfoResultModel.Code.Success);
        finishWithResult(r109);
        return;
    L30:
        if (TextUtils.isEmpty(r111.nickName) == true) goto L33;
        r109.c(r111.nickName);
    L33:
        if (TextUtils.isEmpty(r111.secUid) == true) goto L36;
        r109.d(r111.secUid);
    L36:
        if (TextUtils.isEmpty(r111.avatarURL) == true) goto L38;
        r109.a(r111.avatarURL);
        goto L38
    L24:
        r109.g(0);
        goto L25
    L5:
        r104 = true;
        goto L7
    }
}
