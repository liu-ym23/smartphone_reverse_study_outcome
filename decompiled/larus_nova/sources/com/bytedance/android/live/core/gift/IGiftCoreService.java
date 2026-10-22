package com.bytedance.android.live.core.gift;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.gift.model.Gift;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import g50.b;
import g50.c;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.revenue.service.gift.GiftServiceWrapper")
public interface IGiftCoreService extends c {
    public static final int OPEN_INTERACT_SOURCE_FROM_LIVING = 2;
    public static final int OPEN_INTERACT_SOURCE_FROM_OPEN_LIVE = 1;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.gift.IGiftCoreService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ h1 $default$findGiftById(IGiftCoreService r100, long r101) {
            return r100.findGiftById(r101);
        }
    }

    void addGiftSendResultListener(b r100);

    boolean allowSendToGuest();

    boolean checkGroupContainerType(int r100);

    void closeGiftDialog();

    Gift findGiftById(long r100);

    /* JADX INFO: renamed from: findGiftById, reason: collision with other method in class */
    /* bridge */ /* synthetic */ h1 mo8170findGiftById(long r100);

    @Override // g50.c
    h2 findLiteGiftById(long r100);

    String getAssetsPath(String r100, long r101);

    IBaseUser getDefaultUserToSendGift();

    boolean getGiftTraySwitch();

    boolean getNeedShowGiftEffectSwitch();

    void initGiftEffectDialog();

    boolean isVSGiftIconShow(DataCenter r100);

    boolean needFrequencyRoomNotifyMessage();

    void openGiftDialog(int r100);

    void openGiftDialog(int r100, long r101, Bundle r102, String r103, long r104);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(int r100, long r101, Bundle r102, List<String> r103, boolean r104, String r105);

    void openGiftDialog(int r100, long r101, String r102, Bundle r103, int r104, JSONObject r105);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(int r100, long r101, String r102, Bundle r103, int r104, JSONObject r105, String r106);

    void openGiftDialog(int r100, long r101, String r102, Bundle r103, JSONObject r104);

    void openGiftDialog(int r100, User r101);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(IBaseUser r100);

    @Override // g50.c
    /* synthetic */ void openGiftDialog(IBaseUser r100, Bundle r101);

    void openGiftDialog(String r100);

    void openGiftDialog(String r100, User r101);

    void openInteractGiftDialog(Context r100, int r101, Long r102, String r103, Function0<Unit> r104, DialogInterface.OnDismissListener r105);

    void registerRecommendReceiver(long r100, String r101, Map<String, String> r102, Map<String, String> r103);

    @Override // g50.c
    /* synthetic */ void registerRecommendReceiver(String r100, String r101, Map<String, String> r102, Map<String, String> r103);

    void removeGiftSendResultListener(b r100);

    void setDefaultUserToSendGift(User r100);

    void setGiftTraySwitch(boolean r100);

    void setNeedShowGiftEffectSwitch(boolean r100);

    void unRegisterRecommendReceiver(String r100, Map<String, String> r101);
}
