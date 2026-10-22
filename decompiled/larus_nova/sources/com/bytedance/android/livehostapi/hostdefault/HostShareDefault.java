package com.bytedance.android.livehostapi.hostdefault;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.model.user.f;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.IHostShareForSaas;
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
import io.reactivex.disposables.Disposables;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class HostShareDefault implements IHostShare {
    public HostShareDefault() {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void addExternalDataSource(List<LiveFansDataSource> r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void addShareContactsListComponent(LiveIMShareTitleWithConListConfig r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void cacheMob(Context r100, Map r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public boolean canBeFoundByShare() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public boolean directJsbShare(Context r100, JSONObject r101, IUgShareCallback r102) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public boolean enableFilterBusinessAccount() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public f getContactUserById(String r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public String getIMContactConversationId(f r100) {
        return "";
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public IInRoomMorePanelShareLinkViewSlotDelegate getLocalLifeShareCouponWidget() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public Bitmap getPublishCover() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void getQrCodeFromUrl(int r100, String r101, String r102, Function1<String, Unit> r103) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void getQrCodeInfo(int r100, String r101, Function1<String, Unit> r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public View getQuickRecordWatermark(Context r100, String r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public View getQuickShotWatermark(Context r100, String r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void getShortUrl(String r100, IHostShare.ValueCallback r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public JSONObject getTcActivitySettings() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public Map<String, String> getToUserConversationId(f r100) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public boolean hasLocalLifeShareCoupon(Object r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public Disposable initVSPoster(Activity r100, ViewGroup r101, Dialog r102, DialogFragment r103, ICommonLiveSharePackage r104, IVSPosterClickListener r105) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public boolean isNightMode() {
        return true;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public boolean isShareAvailable(String r100, Activity r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShareForSaas
    public /* synthetic */ boolean isSupportLiveShare() {
        return IHostShareForSaas.CC.$default$isSupportLiveShare(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void promotion(Activity r100, ShareParams r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public String publishToStory(Activity r100, String r101, String r102, String r103, String r104, Function1<Boolean, Unit> r105) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void removeExternalDataSource(List<Integer> r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void removePublishCallback(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void share(Activity r100, ShareParams r101, IShareCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void shareActivity(Context r100, Map<String, Object> r101, IShareCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void shareDirect(Activity r100, ShareParams r101, IShareCallback r102, IShareDirectTypeCallback r103) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void shareLive(Context r100, f r101, ShareParams r102, IShareCallback r103) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void shareText2FansGroup(String r100, String r101) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void shareVideo2FansGroups(List<String> r100, List<String> r101, Function1<String, Unit> r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShareForSaas
    public /* synthetic */ void showNativeShareDialog(Activity r100, ShareParams r101, IShareCallback r102) {
        IHostShareForSaas.CC.$default$showNativeShareDialog(this, r100, r101, r102);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void showNewShareDialog(Activity r100, ShareParams r101, IShareCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void showReportDialog(Activity r100, ShareParams r101, String r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public void showShareDialog(Activity r100, ShareParams r101, IShareCallback r102) {
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public Pair<Boolean, String> getSharePanelMoreText() {
        return new Pair(Boolean.FALSE, "");
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public ILiveIMSharePostscriptComponent addSharePostscriptComponent(LiveIMSharePostscriptConfig r100) {
        return new AnonymousClass1(this);
    }

    @Override // com.bytedance.android.livehostapi.business.IHostShare
    public Disposable changeCanBeFoundByShare(boolean r100) {
        return Disposables.disposed();
    }
}
