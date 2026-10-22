package com.bytedance.android.livesdkapi.commerce;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdkapi.commerce.base.IBaseHostCommerceService;
import com.bytedance.android.livesdkapi.commerce.param.ICommerceBehaviorLoadHandler;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ILivePlayFragmentCreatedEnv;
import com.bytedance.android.livesdkapi.service.IMiddlewareHostCommerceServiceLive;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IHostCommerceServiceLive extends IMiddlewareHostCommerceServiceLive, IBaseHostCommerceService {
    void callInjection();

    void chooseCategory(String r100, String r101);

    String getEcomSdkVersion();

    void handleWebcastInRoomSchema(Map<String, Object> r100);

    boolean initPlayFragmentEnv(ILivePlayFragmentCreatedEnv r100);

    void onToolbarCommerceBehaviorLoad(ICommerceBehaviorLoadHandler r100, ViewModel r101);

    @Override // com.bytedance.android.livesdkapi.service.IMiddlewareHostCommerceServiceLive
    void roomEnter(String r100, String r101, String r102, Map<String, String> r103);

    void sendMessage(JSONObject r100, Function1<JSONObject, Unit> r101);

    boolean showEnterRoomTicketExpandDialog(boolean r100);

    boolean showExitRoomTicketExpandDialog(boolean r100, Runnable r101);

    DialogFragment showLiveFlashFragment(Context r100, Bundle r101);

    Fragment showLivePromotionListFragment(Context r100, JSONObject r101);

    void switchFlashConfig(boolean r100);

    void tryShowSaasCouponDialog(Context r100, Bundle r101, Function1<JSONObject, Unit> r102);

    void updatePromotionList();
}
