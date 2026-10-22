package ca0;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.gift.BaseCommentGiftGuideView;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.gift.model.h1;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.p2;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.AssetDownloadPriority;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import org.json.JSONObject;
import zg1.f0;

/* JADX INFO: loaded from: classes45.dex */
public interface j extends dy0.c {
    void addGiftSendResultListener(s r100);

    void clearBattlePropCardMessageQueue();

    void convertHonorImageModel(py.k r100);

    List<String> convertRichContentImageUrls(List<String> r100);

    void downloadAssets(String r100, long r101, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r102, int r103);

    void downloadAssets(String r100, long r101, com.bytedance.android.livesdk.gift.platform.business.effect.assets.f r102, int r103, AssetDownloadPriority r104);

    h1 findGiftById(long r100);

    h2 findLiteGiftById(long r100);

    /* JADX INFO: renamed from: getAssetsManager */
    IAssetsManager mo8235getAssetsManager();

    String getAssetsPath(String r100, long r101);

    BaseCommentGiftGuideView getCommentGiftGuideView(Context r100);

    h1 getFastGift();

    i getGiftRenderFilterWrapper();

    BehaviorSubject<Long> getGiftSelectObservable();

    boolean getGiftTraySwitch();

    l getGiftWallPreRequestManager();

    List<IBaseUser> getGroupMemberList();

    int getGroupMemberNum();

    Widget getMatchRoomGiftTrayWidget();

    boolean getNeedShowGiftEffectSwitch();

    q getUICanvasMonitor();

    boolean hasPKPropCard();

    boolean isAssetsDownloaded(String r100, long r101);

    void notifyLowPriorityDownloadTask(Boolean r100);

    void openGiftDialog(IBaseUser r100, Bundle r101);

    void processRevenueApiResponse(String r100, JSONObject r101);

    void registerGiftPreviewDebugWidgetInstance(LiveRecyclableWidget r100);

    void removeGiftSendResultListener(s r100);

    Observable<ExtraResponse<p2, ? extends Extra>> sendGift(b0 r100, int r101);

    void setAllowSendToGuest(boolean r100);

    void setNeedShowGiftEffectSwitch(boolean r100);

    void syncAssetsList(String r100, int r101);

    void syncGiftList(int r100);

    void syncGiftPanel();

    void syncMultiAnchorList();

    void triggerGiftAsyncSort(JSONObject r100);

    void updateGiftTrayPosition(f0 r100);
}
