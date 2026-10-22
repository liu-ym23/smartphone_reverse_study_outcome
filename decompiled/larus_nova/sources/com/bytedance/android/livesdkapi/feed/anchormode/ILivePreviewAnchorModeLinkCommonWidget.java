package com.bytedance.android.livesdkapi.feed.anchormode;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.AnchorModeParseSeiData;
import java.util.HashMap;
import kotlin.Metadata;
import ld0.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001&J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH&J(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001cH&J\u0012\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\bH&J\u0010\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020#H&¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/anchormode/ILivePreviewAnchorModeLinkCommonWidget;", "", "Lcom/bytedance/android/livesdkapi/feed/data/IPreviewMultiLinkOuterConfigProvider;", "configProvider", "Lcom/bytedance/android/livesdkapi/feed/anchormode/IPreviewAnchorModeContainerProvider;", "containerProvider", "", "receivePlayerFirstFrame", "", "bindTs", "isPreload", "", "init", "onViewHolderSelect", "onViewHolderUnSelect", "onViewHolderResume", "onViewHolderPause", "onLivePlayerVideoSizeChanged", "release", "", "targetUILayout", "fromUILayout", "Lcom/bytedance/android/livesdkapi/model/AnchorModeParseSeiData;", "parseSeiData", "updateUILayoutBySei", "", "seiRaw", "onSeiRawUpdated", "Lye1/a;", "info", "onSeiRawUpdatedV2", "isClickEnterRoom", "clickEnterRoomEventUpdate", "time", "recordPlayerFirstFrameLoad", "Lcom/bytedance/android/livesdkapi/depend/message/RoomLinkMicSyncData;", "wrds", "updatePreloadRoomLinkMicSyncData", "IEnterBundleExtraParamsProvider", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePreviewAnchorModeLinkCommonWidget {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void clickEnterRoomEventUpdate$default(ILivePreviewAnchorModeLinkCommonWidget r100, boolean r101, int r102, Object r103) {
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

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0001H&J(\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0011H&J\b\u0010\u0013\u001a\u00020\u0002H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/anchormode/ILivePreviewAnchorModeLinkCommonWidget$IEnterBundleExtraParamsProvider;", "", "", "getSeiRaw", "", "getUILayout", "getSeiVersion", "getSubScene", "Landroid/view/View;", "getFeedPreview", "", "updateFeedDataToPreLoad", "setRenderViewBitmapToMockView", "Lld0/a;", "getCurrentVideoStateSeiData", "getCurrentSeiParseResultData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getChatRoomEnterRoomExtraParam", "getCurrentSingUserIdString", "getShowPlayer", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IEnterBundleExtraParamsProvider {
        HashMap<String, Object> getChatRoomEnterRoomExtraParam();

        Object getCurrentSeiParseResultData();

        String getCurrentSingUserIdString();

        a getCurrentVideoStateSeiData();

        View getFeedPreview();

        String getSeiRaw();

        int getSeiVersion();

        String getShowPlayer();

        int getSubScene();

        int getUILayout();

        void setRenderViewBitmapToMockView();

        void updateFeedDataToPreLoad();
    }

    void clickEnterRoomEventUpdate(boolean r100);

    void init(IPreviewMultiLinkOuterConfigProvider r100, IPreviewAnchorModeContainerProvider r101, boolean r102, long r103, boolean r104);

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

    void updateUILayoutBySei(int r100, int r101, AnchorModeParseSeiData r102, boolean r103);
}
