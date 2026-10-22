package com.bytedance.android.ec.adapter.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface f {
    void callInjection();

    void chooseCategory(String r100, String r101);

    void handleWebcastInRoomSchema(Map<String, Object> r100);

    void roomEnter(String r100, String r101, String r102, Map<String, String> r103);

    void sendMessage(JSONObject r100, Function1<? super JSONObject, Unit> r101);

    boolean showEnterRoomTicketExpandDialog(boolean r100);

    boolean showExitRoomTicketExpandDialog(boolean r100, Runnable r101);

    DialogFragment showLiveFlashFragment(Context r100, Bundle r101);

    Fragment showLivePromotionListFragment(Context r100, JSONObject r101);

    void switchFlashConfig(boolean r100);

    void tryShowSaasCouponDialog(Context r100, Bundle r101, Function1<? super JSONObject, Unit> r102);

    void updatePromotionList();
}
