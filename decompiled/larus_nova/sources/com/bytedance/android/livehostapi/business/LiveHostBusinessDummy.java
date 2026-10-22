package com.bytedance.android.livehostapi.business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.base.model.moreliveentrance.LiveTabForceRefreshStyle;
import com.bytedance.android.livehostapi.business.depend.IShowPoiSearchCallback;
import com.bytedance.android.livehostapi.business.depend.IUserAgreePrivacyPolicyListener;
import com.bytedance.android.livehostapi.business.depend.highlight.PublishHighlightVideoData;
import com.bytedance.android.livehostapi.business.depend.largefont.IHostLargeFontService;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livehostapi.wrap.AbsHostBusiness;
import com.bytedance.android.livesdkapi.listener.ICallStatusListener;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import gz.a;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import jz.b;
import jz.d;
import jz.h;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bV\u0010WJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0012H\u0016J(\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016JH\u0010*\u001a\u00020)2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\"2\b\u0010%\u001a\u0004\u0018\u00010\"2 \u0010\u001d\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060'\u0012\u0004\u0012\u00020(\u0018\u00010&H\u0016J&\u0010/\u001a\u00020)2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00101\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010\"H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J&\u00104\u001a\u00020)2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010,\u001a\u0004\u0018\u00010+2\b\u0010.\u001a\u0004\u0018\u000103H\u0016J\u0018\u00109\u001a\u00020)2\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0016J\u0010\u0010;\u001a\u00020)2\u0006\u0010:\u001a\u00020\u0002H\u0016J\u0012\u0010=\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010@\u001a\u00020)2\u0006\u0010?\u001a\u00020>H\u0016J\u0012\u0010A\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010<H\u0016J.\u0010D\u001a\u0004\u0018\u00010C2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010B\u001a\u00020\u0006H\u0016J\u001c\u0010E\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010H\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010\"2\u0006\u0010G\u001a\u00020\u0006H\u0016J\b\u0010I\u001a\u00020\u0002H\u0016J\u0012\u0010K\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010JH\u0016JN\u0010T\u001a\u00020)2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0L2\u0006\u0010N\u001a\u00020\"2\b\u0010O\u001a\u0004\u0018\u0001072\u0006\u0010P\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u00022\u0006\u0010S\u001a\u00020RH\u0016J\b\u0010U\u001a\u00020\u0002H\u0016¨\u0006X"}, d2 = {"Lcom/bytedance/android/livehostapi/business/LiveHostBusinessDummy;", "Lcom/bytedance/android/livehostapi/wrap/AbsHostBusiness;", "", "isEnablePersonalRecommend", "", ShareChannel.DOUYIN, "", "playerContainerHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "audioAddr", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AwemeVideoPlayFragmentV2;", "getLivePureVideoPlayFragmentV2", "playerWidth", "playerHeight", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AwemeCustomPureVideoPlayerView;", "getLivePureVideoPlayerView", "", "aid", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AwemeQueryCallBack;", "callBack", "Lio/reactivex/disposables/Disposable;", "queryBatchAweme", "Lcom/bytedance/android/livehostapi/business/model/emoji/BaseEmoji;", "getRecommendEmojiList", "Lgz/a;", "poiSearchParams", "Lcom/bytedance/android/livehostapi/business/depend/IShowPoiSearchCallback;", "callback", "Landroidx/fragment/app/DialogFragment;", "getPoiSearchModalDialog", "Lcom/bytedance/android/livehostapi/business/depend/largefont/IHostLargeFontService;", "getLiveLargeFontService", "", "targetUid", "targetSecUid", "source", "Lkotlin/Function1;", "Lkotlin/Pair;", "Ljava/lang/Void;", "", "getFollowStatusFromIMDB", "Ljz/h;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Ljz/b;", "listener", "soloKtvVideoSaveDraft", "creationId", "cancelVideoPublish", "isInAvCallFloatWindow", "Ljz/d;", "soloKtvVideoSilentPublish", "Landroid/app/Activity;", "activity", "Landroid/os/Bundle;", "bundle", "openSoloKtvSharePanel", "state", "setLinkMicFloatWindowState", "Lcom/bytedance/android/livesdkapi/listener/ICallStatusListener;", "registerCallStatusListener", "Lcom/bytedance/android/livehostapi/business/depend/highlight/PublishHighlightVideoData;", "params", "openEditAndPublishPage", "unregisterCallStatusListener", "userType", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostBusiness$AwemeVideoPlayFragment;", "getLivePureVideoPlayFragment", "queryAweme", "nitaTag", "layout", "hasCachedView", "isUserAgreePrivacyPolicy", "Lcom/bytedance/android/livehostapi/business/depend/IUserAgreePrivacyPolicyListener;", "addPrivacyAgreeListener", "", "urlParams", "caller", "enterParams", "needPreLoad", "needRoute", "Lcom/bytedance/android/live/base/model/moreliveentrance/LiveTabForceRefreshStyle;", "forceRefreshType", "enterLiveChannel", "hasCellularPermission", "<init>", "()V", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public class LiveHostBusinessDummy extends AbsHostBusiness {
    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public boolean addPrivacyAgreeListener(IUserAgreePrivacyPolicyListener r100) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void cancelVideoPublish(String r100) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void enterLiveChannel(Context r100, Map<String, String> r101, String r102, Bundle r103, boolean r104, boolean r105, LiveTabForceRefreshStyle r106) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "urlParams");
        Intrinsics.checkNotNullParameter(r102, "caller");
        Intrinsics.checkNotNullParameter(r106, "forceRefreshType");
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void getFollowStatusFromIMDB(String r100, String r101, String r102, Function1<? super Pair<Integer, Integer>, Void> r103) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public IHostLargeFontService getLiveLargeFontService() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public IMiddlewareHostBusiness.AwemeVideoPlayFragment getLivePureVideoPlayFragment(Object r100, Context r101, long r102, int r103) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public IMiddlewareHostBusiness.AwemeVideoPlayFragmentV2 getLivePureVideoPlayFragmentV2(Object r100, int r101, Context r102, long r103) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public IMiddlewareHostBusiness.AwemeCustomPureVideoPlayerView getLivePureVideoPlayerView(Context r100, int r101, int r102, long r103) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public DialogFragment getPoiSearchModalDialog(Context r100, a r101, IShowPoiSearchCallback r102) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public List<BaseEmoji> getRecommendEmojiList() {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public boolean hasCachedView(String r100, int r101) {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public boolean hasCellularPermission() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public boolean isEnablePersonalRecommend() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public boolean isInAvCallFloatWindow() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public boolean isUserAgreePrivacyPolicy() {
        return false;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void openEditAndPublishPage(PublishHighlightVideoData r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void openSoloKtvSharePanel(Activity r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bundle");
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public Disposable queryAweme(long r100, IMiddlewareHostBusiness.AwemeQueryCallBack r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IHostBusiness, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public Disposable queryBatchAweme(List<Long> r100, IMiddlewareHostBusiness.AwemeQueryCallBack r101) {
        return null;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void registerCallStatusListener(ICallStatusListener r100) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void setLinkMicFloatWindowState(boolean r100) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void soloKtvVideoSaveDraft(Context r100, h r101, b r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void soloKtvVideoSilentPublish(Context r100, h r101, d r102) {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostBusinessDefault, com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness
    public void unregisterCallStatusListener(ICallStatusListener r100) {
    }

    public LiveHostBusinessDummy() {
    }
}
