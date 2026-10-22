package cf;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.live.LiveClearScreenMode;
import com.bytedance.android.ec.model.live.LiveScreenMoveMode;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;

/* JADX INFO: loaded from: classes43.dex */
public interface l {
    void Aa(int r100, String r101);

    boolean Ba(ECPromotionCampaign r100, long r101);

    void Ca(String r100, com.bytedance.android.ec.model.live.r r101);

    com.bytedance.android.livesdk.livecommerce.promotion.card.b Da(ViewGroup r100, com.bytedance.android.livesdk.livecommerce.promotion.card.g r101, boolean r102);

    boolean Ea();

    void Fa(boolean r100, Fragment r101, LiveClearScreenMode r102, LiveScreenMoveMode r103);

    d Ga(Context r100, com.bytedance.android.shopping.store.home.presenter.preview.c r101, LiveRoomParams r102, com.bytedance.android.shopping.store.home.presenter.preview.d r103, im.m r104);

    ECUIPromotion Ha(ECPromotion r100, Context r101, long r102, Boolean r103);

    View Ia();

    hf.a Ja();

    void Ka(String r100, com.bytedance.android.ec.model.live.r r101);

    void La();

    void Ma();

    boolean Na();

    void Oa(boolean r100);

    float[] Pa();

    void Qa(String r100);

    void a(FragmentActivity r100, String r101, Window r102);

    void b(FragmentActivity r100, String r101, Window r102);

    void c();

    void d();

    void f(FragmentActivity r100, String r101, Window r102);

    w getRoomInfo();

    void showInteractionAndEnterRoom(String r100);

    void showInteractionMask(String r100);

    void startShowFloatInNextLifecycle(Activity r100, String r101);

    void ya();

    boolean za();
}
