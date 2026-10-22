package com.bytedance.android.livehostapi.business.flavor.hotsoon;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.base.IBaseHostBusiness;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostBusinessForHS extends IService, IBaseHostBusiness {
    boolean isEnablePersonalRecommend();

    void openLiveCommonVerifyActivity(Context r100, Intent r101);

    void openTaobaoApp(Context r100, String r101, IMiddlewareHostBusiness.OnActionCallback r102);

    void openVideoDetailPage(String r100, String r101);

    void requestForShoppingAccess(Context r100, String r101);

    void showVcdContentGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103);

    void showVcdRelationshipGrant(FragmentActivity r100, String r101, String r102, IMiddlewareHostBusiness.AuthorizeCallback r103);

    boolean tryOpenAdByOpenUrl(Context r100, long r101, String r102, String r103);
}
