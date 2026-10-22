package com.bytedance.android.livesdkapi.business;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.user.k;
import com.bytedance.android.livesdkapi.commerce.param.ConfigObserver;
import com.bytedance.android.livesdkapi.commerce.param.IECEventParams;
import com.bytedance.android.livesdkapi.commerce.param.ILivePromotionActionListener;
import com.bytedance.android.livesdkapi.commerce.param.IToggle;
import com.bytedance.android.livesdkapi.reactivex.Observer;

/* JADX INFO: loaded from: classes12.dex */
public interface ILiveRoomProvider {
    int flashTotal();

    IECEventParams getEventParams();

    ViewGroup getLeftAnchorLayout();

    ILivePromotionActionListener getLivePromotionActionListener();

    String getSecAuthorId();

    IToggle getToggle();

    boolean insertLegalMessage(long r100, String r101);

    boolean isAnchor();

    boolean isAnchorWithCommercePermission();

    boolean isFollowedBroadcast();

    boolean isLogin();

    boolean isRoomHasCommerceGoods();

    boolean isRoomPortraitMode();

    void login(Context r100, k r101, Observer<IBaseUser> r102);

    boolean roomHasInitGoods();

    void takeLiveRoomScreenshot(ConfigObserver<String, String> r100);

    int total();
}
