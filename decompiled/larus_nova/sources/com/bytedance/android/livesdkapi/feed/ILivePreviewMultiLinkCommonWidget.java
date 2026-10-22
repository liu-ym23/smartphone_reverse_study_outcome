package com.bytedance.android.livesdkapi.feed;

import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.ParseSeiData;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import ld0.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0003,-.J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\rH&J\b\u0010\u0014\u001a\u00020\rH&J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H&J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000bH&J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001dH&J\u0012\u0010!\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u0006H&J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\bH&J\b\u0010%\u001a\u00020$H&J\u001a\u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020)H&¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget;", "", "Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "configProvider", "Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider$IMobLoggerProvider;", "mobLoggerProvider", "", "receivePlayerFirstFrame", "", "bindTs", "isPreload", "", "from", "", "init", "onViewHolderSelect", "onViewHolderUnSelect", "onViewHolderResume", "onViewHolderPause", "onLivePlayerVideoSizeChanged", "release", "", "targetUILayout", "fromUILayout", "Lcom/bytedance/android/livesdkapi/model/ParseSeiData;", "parseSeiData", "updateUILayoutBySei", "seiRaw", "onSeiRawUpdated", "Lye1/a;", "info", "onSeiRawUpdatedV2", "isClickEnterRoom", "clickEnterRoomEventUpdate", "time", "recordPlayerFirstFrameLoad", "Landroid/widget/FrameLayout$LayoutParams;", "getKtvComponentLayoutParams", "syncKey", "value", "onKtvWRDSDataUpdate", "Lcom/bytedance/android/livesdkapi/depend/message/RoomLinkMicSyncData;", "wrds", "updatePreloadRoomLinkMicSyncData", "IEnterBundleExtraParamsProvider", "IKtvComponentExtraParamsProvider", "IPreviewMultiLinkEffectProvider", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewMultiLinkCommonWidget {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void clickEnterRoomEventUpdate$default(ILivePreviewMultiLinkCommonWidget r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.clickEnterRoomEventUpdate(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clickEnterRoomEventUpdate");
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0001H&J(\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0015H&J(\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0015H&J\b\u0010\u0018\u001a\u00020\u0002H&J\b\u0010\u0019\u001a\u00020\nH&J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IEnterBundleExtraParamsProvider;", "", "", "getSeiRaw", "", "getUILayout", "getSeiVersion", "getSubScene", "Landroid/view/View;", "getFeedPreview", "", "updateFeedDataToPreLoad", "setRenderViewBitmapToMockView", "Lld0/a;", "getCurrentVideoStateSeiData", "getCurrentSeiParseResultData", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getOnlineList", "getKtvSeiModelObject", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKtvEnterRoomExtraParam", "getChatRoomEnterRoomExtraParam", "getCurrentSingUserIdString", "resetKtvSeiModelObject", "getShowPlayer", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IEnterBundleExtraParamsProvider {
        HashMap<String, Object> getChatRoomEnterRoomExtraParam();

        Object getCurrentSeiParseResultData();

        String getCurrentSingUserIdString();

        a getCurrentVideoStateSeiData();

        View getFeedPreview();

        HashMap<String, Object> getKtvEnterRoomExtraParam();

        Object getKtvSeiModelObject();

        List<ILinkPlayerInfoBridge> getOnlineList();

        String getSeiRaw();

        int getSeiVersion();

        String getShowPlayer();

        int getSubScene();

        int getUILayout();

        void resetKtvSeiModelObject();

        void setRenderViewBitmapToMockView();

        void updateFeedDataToPreLoad();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IKtvComponentExtraParamsProvider;", "", "getKtvComponentFeedPreview", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IKtvComponentExtraParamsProvider {
        IKtvComponentFeedView getKtvComponentFeedPreview();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IPreviewMultiLinkEffectProvider;", "", "insertEffectView", "", "view", "Landroid/view/View;", GXTemplateKey.GAIAX_LAYER, "", "removeEffectView", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IPreviewMultiLinkEffectProvider {
        void insertEffectView(View r100, int r101);

        void removeEffectView();
    }

    void clickEnterRoomEventUpdate(boolean r100);

    FrameLayout.LayoutParams getKtvComponentLayoutParams();

    void init(IPreviewMultiLinkOuterConfigProvider r100, IPreviewMultiLinkOuterConfigProvider.IMobLoggerProvider r101, boolean r102, long r103, boolean r104, String r105);

    void onKtvWRDSDataUpdate(String r100, Object r101);

    void onLivePlayerVideoSizeChanged();

    void onSeiRawUpdated(String r100);

    void onSeiRawUpdatedV2(String r100, ye1.a r101);

    void onViewHolderPause();

    void onViewHolderResume();

    void onViewHolderSelect();

    void onViewHolderUnSelect();

    void recordPlayerFirstFrameLoad(long r100);

    void release();

    void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r100);

    void updateUILayoutBySei(int r100, int r101, ParseSeiData r102);
}
