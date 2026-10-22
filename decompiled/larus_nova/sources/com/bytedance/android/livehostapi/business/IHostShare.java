package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.base.IBaseHostShare;
import com.bytedance.android.livehostapi.business.depend.share.ICommonLiveSharePackage;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IShareDirectTypeCallback;
import com.bytedance.android.livehostapi.business.depend.share.IUgShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.IVSPosterClickListener;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansDataSource;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.business.shareinter.ILiveIMSharePostscriptComponent;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMSharePostscriptConfig;
import com.bytedance.android.livehostapi.business.shareinter.LiveIMShareTitleWithConListConfig;
import com.bytedance.android.livehostapi.business.shareinter.sharelinkpanel.IInRoomMorePanelShareLinkViewSlotDelegate;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostShare extends IService, IBaseHostShare, IHostShareForSaas {

    public interface ShareType {
        public static final String COMMAND = "command";
        public static final String LAUNCH_ONLY = "launch_only";
        public static final String LINK = "link";
        public static final String QR_CODE = "qr_code";
        public static final String SCREENSHOT = "screenshot";
    }

    public interface ValueCallback {
        void onFailed(Throwable r100);

        void onSucceed(String r100);
    }

    void addExternalDataSource(List<LiveFansDataSource> r100);

    void addShareContactsListComponent(LiveIMShareTitleWithConListConfig r100);

    ILiveIMSharePostscriptComponent addSharePostscriptComponent(LiveIMSharePostscriptConfig r100);

    void cacheMob(Context r100, Map r101);

    boolean canBeFoundByShare();

    Disposable changeCanBeFoundByShare(boolean r100);

    boolean directJsbShare(Context r100, JSONObject r101, IUgShareCallback r102);

    boolean enableFilterBusinessAccount();

    f getContactUserById(String r100);

    String getIMContactConversationId(f r100);

    IInRoomMorePanelShareLinkViewSlotDelegate getLocalLifeShareCouponWidget();

    Bitmap getPublishCover();

    void getQrCodeFromUrl(int r100, String r101, String r102, Function1<String, Unit> r103);

    void getQrCodeInfo(int r100, String r101, Function1<String, Unit> r102);

    View getQuickRecordWatermark(Context r100, String r101);

    View getQuickShotWatermark(Context r100, String r101);

    Pair<Boolean, String> getSharePanelMoreText();

    void getShortUrl(String r100, ValueCallback r101);

    JSONObject getTcActivitySettings();

    Map<String, String> getToUserConversationId(f r100);

    boolean hasLocalLifeShareCoupon(Object r100);

    Disposable initVSPoster(Activity r100, ViewGroup r101, Dialog r102, DialogFragment r103, ICommonLiveSharePackage r104, IVSPosterClickListener r105);

    boolean isNightMode();

    boolean isShareAvailable(String r100, Activity r101);

    void promotion(Activity r100, ShareParams r101);

    String publishToStory(Activity r100, String r101, String r102, String r103, String r104, Function1<Boolean, Unit> r105);

    void removeExternalDataSource(List<Integer> r100);

    void removePublishCallback(String r100);

    void share(Activity r100, ShareParams r101, IShareCallback r102);

    void shareActivity(Context r100, Map<String, Object> r101, IShareCallback r102);

    void shareDirect(Activity r100, ShareParams r101, IShareCallback r102, IShareDirectTypeCallback r103);

    void shareLive(Context r100, f r101, ShareParams r102, IShareCallback r103);

    void shareText2FansGroup(String r100, String r101);

    void shareVideo2FansGroups(List<String> r100, List<String> r101, Function1<String, Unit> r102);

    void showNewShareDialog(Activity r100, ShareParams r101, IShareCallback r102);

    void showReportDialog(Activity r100, ShareParams r101, String r102);

    void showShareDialog(Activity r100, ShareParams r101, IShareCallback r102);
}
