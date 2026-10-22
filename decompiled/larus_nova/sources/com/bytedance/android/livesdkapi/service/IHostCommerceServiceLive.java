package com.bytedance.android.livesdkapi.service;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerCommonFragment;
import com.bytedance.android.livesdkapi.drawer.ILiveDrawerParentAction;
import com.bytedance.android.livesdkapi.linkmic.IECLiveLinkmicService;
import com.bytedance.android.livesdkapi.livereplay.IECLiveReplayService;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ILivePlayFragmentCreatedEnv;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLayoutAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowLogAbility;
import com.bytedance.android.livesdkapi.service.floatwindow.platform.ablity.AbsLiveBizWindowWidgetAbility;
import com.bytedance.android.livesdkapi.service.userinfo.IECUserInfoService;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IHostCommerceServiceLive extends IMiddlewareHostCommerceServiceLive, IHostCommerceServiceLiveForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.service.IHostCommerceServiceLive$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ILiveDrawerCommonFragment $default$getLiveDrawerCommonFragment(IHostCommerceServiceLive r100, ILiveDrawerParentAction r101) {
            return null;
        }

        public static JSONObject $default$getLiveShoppingData(IHostCommerceServiceLive r100, int r101) {
            return null;
        }

        public static void $default$hookECOMLiveParams(IHostCommerceServiceLive r100, String r101, Bundle r102) {
        }

        public static boolean $default$initPlayFragmentEnv(IHostCommerceServiceLive r100, ILivePlayFragmentCreatedEnv r101) {
            return false;
        }
    }

    void callInjection();

    void chooseCategory(String r100, String r101);

    boolean enableFullLiveCommerce();

    IECLiveLinkmicService getECLiveLinkmicService();

    IECLiveReplayService getECLiveReplayService();

    IECUserInfoService getECUserInfoService();

    AbsLiveBizWindowLayoutAbility getLiveBizWindowLayoutAbility();

    AbsLiveBizWindowLogAbility getLiveBizWindowLogAbility();

    AbsLiveBizWindowWidgetAbility getLiveBizWindowWidgetAbility();

    ILiveDrawerCommonFragment getLiveDrawerCommonFragment(ILiveDrawerParentAction r100);

    JSONObject getLiveShoppingData(int r100);

    void handleWebcastInRoomSchema(Map<String, Object> r100);

    void hookECOMLiveParams(String r100, Bundle r101);

    boolean initPlayFragmentEnv(ILivePlayFragmentCreatedEnv r100);

    void injectMessage();

    boolean isProductDetailPageExpanded();

    void notifyPromotionNum(int r100);

    boolean onBackPressed();

    void onExistLiveSession(Activity r100, String r101, String r102);

    void sendMessage(JSONObject r100, Function1<JSONObject, Unit> r101);

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareHostCommerceServiceLive
    void setAddress(String r100, int r101, String r102);

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareHostCommerceServiceLive
    void setEnterRoomInfo(Context r100, String r101, Bundle r102);

    Fragment showLivePromotionListFragment(Context r100, JSONObject r101);

    void switchFlashConfig(boolean r100);

    void tryShowLiveFlashFragment(Context r100, Bundle r101, Function1<DialogFragment, Unit> r102);

    void updatePromotionList();
}
