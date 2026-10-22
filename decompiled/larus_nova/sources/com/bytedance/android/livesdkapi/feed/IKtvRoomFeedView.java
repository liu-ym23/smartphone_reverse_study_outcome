package com.bytedance.android.livesdkapi.feed;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.ktv.KTVRoomFeedModel;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld0.a;
import org.json.JSONObject;
import tlc.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f\u0018\u0001`\u0012H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u001c\u001a\u00020\u00022\u0016\u0010\u001b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\fH\u0016¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IKtvRoomFeedView;", "Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "", "setRenderViewBitmapToMockView", "Landroid/view/ViewGroup;", "getKtvVideoContainer", "Lld0/a;", "videoSei", "onKtvVideoStateChange", "Lcom/bytedance/android/livesdkapi/ktv/KTVRoomFeedModel;", "feedModelKTV", "bind", "", "getKtvSeiModelObject", "resetKtvSeiModelObject", "", "getCurrentSingUserIdString", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getKtvEnterRoomExtraParam", "getCurrentSeiParseResultData", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "linkPlayerInfos", "onOnlineListChanged", "", "", "talkStateMap", "updateTalkState", "dataMergeCenter", "setDataMergeCenter", "setDataMergeCenterV2", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IKtvRoomFeedView extends IInteractFeedView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void bindMultiScenePreviewReportData(IKtvRoomFeedView r100, IMultiScenePreviewStatistics r101, long r102) {
            IInteractFeedView.DefaultImpls.bindMultiScenePreviewReportData(r100, r101, r102);
        }

        public static HashMap<String, Object> getChatRoomEnterRoomExtraParam(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(r100);
        }

        public static Object getCurrentSeiParseResultData(IKtvRoomFeedView r100) {
            return null;
        }

        public static String getCurrentSingUserIdString(IKtvRoomFeedView r100) {
            return "";
        }

        public static FeedViewRoomInfoStore getFeedViewRoomInfoStore(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getFeedViewRoomInfoStore(r100);
        }

        public static IKtvInteractFeedView getIKtvInteractFeedView(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getIKtvInteractFeedView(r100);
        }

        public static IMultiFeedView getIMultiFeedView(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getIMultiFeedView(r100);
        }

        public static IPkFeedView getIPkFeedView(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getIPkFeedView(r100);
        }

        public static List<String> getImCacheTags(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getImCacheTags(r100);
        }

        public static IKtvComponentFeedView getKtvComponentFeedView(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getKtvComponentFeedView(r100);
        }

        public static List<ILinkPlayerInfoBridge> getOnlineList(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getOnlineList(r100);
        }

        public static View getViewCompat(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.getViewCompat(r100);
        }

        public static void monitorLayouts(IKtvRoomFeedView r100, String r101) {
            IInteractFeedView.DefaultImpls.monitorLayouts(r100, r101);
        }

        public static Observable<IPkExposeData> observeFeedViewExposeData(IKtvRoomFeedView r100) {
            return IInteractFeedView.DefaultImpls.observeFeedViewExposeData(r100);
        }

        public static void onOnlineListChanged(IKtvRoomFeedView r100) {
            IInteractFeedView.DefaultImpls.onOnlineListChanged(r100);
        }

        public static void onOnlineListChanged(IKtvRoomFeedView r100, List<? extends ILinkPlayerInfoBridge> r101) {
        }

        public static void onScreenSizeChange(IKtvRoomFeedView r100, int r101, int r102) {
            IInteractFeedView.DefaultImpls.onScreenSizeChange(r100, r101, r102);
        }

        public static void onSeiUpdated(IKtvRoomFeedView r100, SeiAppData r101) {
            IInteractFeedView.DefaultImpls.onSeiUpdated(r100, r101);
        }

        public static void onSeiUpdated(IKtvRoomFeedView r100, JSONObject r101) {
            IInteractFeedView.DefaultImpls.onSeiUpdated(r100, r101);
        }

        public static void onSeiUpdatedRaw(IKtvRoomFeedView r100, String r101) {
            IInteractFeedView.DefaultImpls.onSeiUpdatedRaw(r100, r101);
        }

        public static void onViewHolderPause(IKtvRoomFeedView r100) {
            IInteractFeedView.DefaultImpls.onViewHolderPause(r100);
        }

        public static void onViewHolderResume(IKtvRoomFeedView r100) {
            IInteractFeedView.DefaultImpls.onViewHolderResume(r100);
        }

        public static void onViewHolderSelected(IKtvRoomFeedView r100) {
            IInteractFeedView.DefaultImpls.onViewHolderSelected(r100);
        }

        public static void onViewHolderUnBind(IKtvRoomFeedView r100) {
            IInteractFeedView.DefaultImpls.onViewHolderUnBind(r100);
        }

        public static void onViewHolderUnSelected(IKtvRoomFeedView r100) {
            IInteractFeedView.DefaultImpls.onViewHolderUnSelected(r100);
        }

        public static void onWrdsDataUpdate(IKtvRoomFeedView r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "syncKey");
            IInteractFeedView.DefaultImpls.onWrdsDataUpdate(r100, r101, r102);
        }

        public static void putImCacheContent(IKtvRoomFeedView r100, Map<String, ? extends ImCacheUnit> r101) {
            Intrinsics.checkNotNullParameter(r101, "map");
            IInteractFeedView.DefaultImpls.putImCacheContent(r100, r101);
        }

        public static void refreshSeiCanvasAndSeiVersion(IKtvRoomFeedView r100, JSONObject r101, Integer r102) {
            IInteractFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(r100, r101, r102);
        }

        public static void resetKtvSeiModelObject(IKtvRoomFeedView r100) {
        }

        public static void sendMessage(IKtvRoomFeedView r100, List<? extends d> r101) {
            Intrinsics.checkNotNullParameter(r101, "msgList");
            IInteractFeedView.DefaultImpls.sendMessage(r100, r101);
        }

        public static void setDataMergeCenter(IKtvRoomFeedView r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, "dataMergeCenter");
        }

        public static void setDataMergeCenterV2(IKtvRoomFeedView r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, "dataMergeCenter");
        }

        public static void setInteractPlayView(IKtvRoomFeedView r100, IInteractPlayView r101) {
            Intrinsics.checkNotNullParameter(r101, "interactPlayView");
            IInteractFeedView.DefaultImpls.setInteractPlayView(r100, r101);
        }

        public static void updateActionCaller(IKtvRoomFeedView r100, InteractFeedActionCaller r101) {
            Intrinsics.checkNotNullParameter(r101, "caller");
            IInteractFeedView.DefaultImpls.updateActionCaller(r100, r101);
        }

        public static void updateEnterFrom(IKtvRoomFeedView r100, String r101, String r102) {
            IInteractFeedView.DefaultImpls.updateEnterFrom(r100, r101, r102);
        }

        public static void updateMessageHub(IKtvRoomFeedView r100, MessageHub r101) {
            Intrinsics.checkNotNullParameter(r101, "hub");
            IInteractFeedView.DefaultImpls.updateMessageHub(r100, r101);
        }

        public static void updateMvControllerSei(IKtvRoomFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IInteractFeedView.DefaultImpls.updateMvControllerSei(r100, r101);
        }

        public static void updateRadioSei(IKtvRoomFeedView r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IInteractFeedView.DefaultImpls.updateRadioSei(r100, r101);
        }

        public static void updateRadioTextSei(IKtvRoomFeedView r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IInteractFeedView.DefaultImpls.updateRadioTextSei(r100, r101);
        }

        public static void updateRoomBeforeSelect(IKtvRoomFeedView r100, IRoom r101) {
            IInteractFeedView.DefaultImpls.updateRoomBeforeSelect(r100, r101);
        }

        public static void updateSeiVerAndUiLayout(IKtvRoomFeedView r100, int r101, int r102) {
            IInteractFeedView.DefaultImpls.updateSeiVerAndUiLayout(r100, r101, r102);
        }

        public static void updateSpeechRecognitionSei(IKtvRoomFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IInteractFeedView.DefaultImpls.updateSpeechRecognitionSei(r100, r101);
        }

        public static void updateSpeechRhythmSei(IKtvRoomFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IInteractFeedView.DefaultImpls.updateSpeechRhythmSei(r100, r101);
        }

        public static void updateSubtitleSei(IKtvRoomFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IInteractFeedView.DefaultImpls.updateSubtitleSei(r100, r101);
        }

        public static void updateTalkState(IKtvRoomFeedView r100, HashMap<String, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r101, "talkStateMap");
            IInteractFeedView.DefaultImpls.updateTalkState(r100, r101);
        }

        public static void updateTalkState(IKtvRoomFeedView r100, Map<String, Integer> r101) {
            Intrinsics.checkNotNullParameter(r101, "talkStateMap");
        }
    }

    void bind(KTVRoomFeedModel r100);

    Object getCurrentSeiParseResultData();

    String getCurrentSingUserIdString();

    HashMap<String, Object> getKtvEnterRoomExtraParam();

    Object getKtvSeiModelObject();

    ViewGroup getKtvVideoContainer();

    void onKtvVideoStateChange(a r100);

    void onOnlineListChanged(List<? extends ILinkPlayerInfoBridge> r100);

    void resetKtvSeiModelObject();

    void setDataMergeCenter(Object r100);

    void setDataMergeCenterV2(Object r100);

    void setRenderViewBitmapToMockView();

    void updateTalkState(Map<String, Integer> r100);
}
