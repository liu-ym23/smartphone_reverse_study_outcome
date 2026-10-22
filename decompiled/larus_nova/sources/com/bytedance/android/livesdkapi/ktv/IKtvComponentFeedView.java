package com.bytedance.android.livesdkapi.ktv;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.IKtvInteractFeedView;
import com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView;
import com.bytedance.android.livesdkapi.feed.IMultiFeedView;
import com.bytedance.android.livesdkapi.feed.IPkFeedView;
import com.bytedance.android.livesdkapi.feed.ImCacheUnit;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.model.NullableOrderInfo;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tlc.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000e\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\u001e\u0010\u0015\u001a\u00020\f2\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00140\u0017H&J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0005H&J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "Lcom/bytedance/android/livesdkapi/feed/IKtvRoomFeedView;", "getCurrentSingUserIdString", "", "getKtvComponentLyricsViewShowStatus", "", "getKtvSeiModelObject", "", "getOrderInfoObservable", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/model/NullableOrderInfo;", "onSeiUpdatedRaw", "", "sei", BasicTestActionHandler.TEST_ACTION_RESET, "resetKtvSeiModelObject", "setAttachParent", "parent", "Landroid/view/ViewGroup;", "layoutParam", "Landroid/view/ViewGroup$LayoutParams;", "updateKsongLayout", "updateTask", "Lkotlin/Function1;", "updateKtvComponentLyricsViewShowStatus", "show", "updateRoom", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IKtvComponentFeedView extends IKtvRoomFeedView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void bindMultiScenePreviewReportData(IKtvComponentFeedView r100, IMultiScenePreviewStatistics r101, long r102) {
            IKtvRoomFeedView.DefaultImpls.bindMultiScenePreviewReportData(r100, r101, r102);
        }

        public static HashMap<String, Object> getChatRoomEnterRoomExtraParam(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getChatRoomEnterRoomExtraParam(r100);
        }

        public static Object getCurrentSeiParseResultData(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getCurrentSeiParseResultData(r100);
        }

        public static String getCurrentSingUserIdString(IKtvComponentFeedView r100) {
            return "";
        }

        public static FeedViewRoomInfoStore getFeedViewRoomInfoStore(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getFeedViewRoomInfoStore(r100);
        }

        public static IKtvInteractFeedView getIKtvInteractFeedView(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getIKtvInteractFeedView(r100);
        }

        public static IMultiFeedView getIMultiFeedView(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getIMultiFeedView(r100);
        }

        public static IPkFeedView getIPkFeedView(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getIPkFeedView(r100);
        }

        public static List<String> getImCacheTags(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getImCacheTags(r100);
        }

        public static IKtvComponentFeedView getKtvComponentFeedView(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getKtvComponentFeedView(r100);
        }

        public static List<ILinkPlayerInfoBridge> getOnlineList(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getOnlineList(r100);
        }

        public static View getViewCompat(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.getViewCompat(r100);
        }

        public static void monitorLayouts(IKtvComponentFeedView r100, String r101) {
            IKtvRoomFeedView.DefaultImpls.monitorLayouts(r100, r101);
        }

        public static Observable<IPkExposeData> observeFeedViewExposeData(IKtvComponentFeedView r100) {
            return IKtvRoomFeedView.DefaultImpls.observeFeedViewExposeData(r100);
        }

        public static void onOnlineListChanged(IKtvComponentFeedView r100) {
            IKtvRoomFeedView.DefaultImpls.onOnlineListChanged(r100);
        }

        public static void onOnlineListChanged(IKtvComponentFeedView r100, List<? extends ILinkPlayerInfoBridge> r101) {
            IKtvRoomFeedView.DefaultImpls.onOnlineListChanged(r100, r101);
        }

        public static void onScreenSizeChange(IKtvComponentFeedView r100, int r101, int r102) {
            IKtvRoomFeedView.DefaultImpls.onScreenSizeChange(r100, r101, r102);
        }

        public static void onSeiUpdated(IKtvComponentFeedView r100, SeiAppData r101) {
            IKtvRoomFeedView.DefaultImpls.onSeiUpdated(r100, r101);
        }

        public static void onSeiUpdated(IKtvComponentFeedView r100, JSONObject r101) {
            IKtvRoomFeedView.DefaultImpls.onSeiUpdated(r100, r101);
        }

        public static void onSeiUpdatedRaw(IKtvComponentFeedView r100, String r101) {
        }

        public static void onViewHolderPause(IKtvComponentFeedView r100) {
            IKtvRoomFeedView.DefaultImpls.onViewHolderPause(r100);
        }

        public static void onViewHolderResume(IKtvComponentFeedView r100) {
            IKtvRoomFeedView.DefaultImpls.onViewHolderResume(r100);
        }

        public static void onViewHolderSelected(IKtvComponentFeedView r100) {
            IKtvRoomFeedView.DefaultImpls.onViewHolderSelected(r100);
        }

        public static void onViewHolderUnBind(IKtvComponentFeedView r100) {
            IKtvRoomFeedView.DefaultImpls.onViewHolderUnBind(r100);
        }

        public static void onViewHolderUnSelected(IKtvComponentFeedView r100) {
            IKtvRoomFeedView.DefaultImpls.onViewHolderUnSelected(r100);
        }

        public static void onWrdsDataUpdate(IKtvComponentFeedView r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "syncKey");
            IKtvRoomFeedView.DefaultImpls.onWrdsDataUpdate(r100, r101, r102);
        }

        public static void putImCacheContent(IKtvComponentFeedView r100, Map<String, ? extends ImCacheUnit> r101) {
            Intrinsics.checkNotNullParameter(r101, "map");
            IKtvRoomFeedView.DefaultImpls.putImCacheContent(r100, r101);
        }

        public static void refreshSeiCanvasAndSeiVersion(IKtvComponentFeedView r100, JSONObject r101, Integer r102) {
            IKtvRoomFeedView.DefaultImpls.refreshSeiCanvasAndSeiVersion(r100, r101, r102);
        }

        public static void resetKtvSeiModelObject(IKtvComponentFeedView r100) {
        }

        public static void sendMessage(IKtvComponentFeedView r100, List<? extends d> r101) {
            Intrinsics.checkNotNullParameter(r101, "msgList");
            IKtvRoomFeedView.DefaultImpls.sendMessage(r100, r101);
        }

        public static void setDataMergeCenter(IKtvComponentFeedView r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, "dataMergeCenter");
            IKtvRoomFeedView.DefaultImpls.setDataMergeCenter(r100, r101);
        }

        public static void setDataMergeCenterV2(IKtvComponentFeedView r100, Object r101) {
            Intrinsics.checkNotNullParameter(r101, "dataMergeCenter");
            IKtvRoomFeedView.DefaultImpls.setDataMergeCenterV2(r100, r101);
        }

        public static void setInteractPlayView(IKtvComponentFeedView r100, IInteractPlayView r101) {
            Intrinsics.checkNotNullParameter(r101, "interactPlayView");
            IKtvRoomFeedView.DefaultImpls.setInteractPlayView(r100, r101);
        }

        public static void updateActionCaller(IKtvComponentFeedView r100, InteractFeedActionCaller r101) {
            Intrinsics.checkNotNullParameter(r101, "caller");
            IKtvRoomFeedView.DefaultImpls.updateActionCaller(r100, r101);
        }

        public static void updateEnterFrom(IKtvComponentFeedView r100, String r101, String r102) {
            IKtvRoomFeedView.DefaultImpls.updateEnterFrom(r100, r101, r102);
        }

        public static void updateMessageHub(IKtvComponentFeedView r100, MessageHub r101) {
            Intrinsics.checkNotNullParameter(r101, "hub");
            IKtvRoomFeedView.DefaultImpls.updateMessageHub(r100, r101);
        }

        public static void updateMvControllerSei(IKtvComponentFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IKtvRoomFeedView.DefaultImpls.updateMvControllerSei(r100, r101);
        }

        public static void updateRadioSei(IKtvComponentFeedView r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IKtvRoomFeedView.DefaultImpls.updateRadioSei(r100, r101);
        }

        public static void updateRadioTextSei(IKtvComponentFeedView r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IKtvRoomFeedView.DefaultImpls.updateRadioTextSei(r100, r101);
        }

        public static void updateRoomBeforeSelect(IKtvComponentFeedView r100, IRoom r101) {
            IKtvRoomFeedView.DefaultImpls.updateRoomBeforeSelect(r100, r101);
        }

        public static void updateSeiVerAndUiLayout(IKtvComponentFeedView r100, int r101, int r102) {
            IKtvRoomFeedView.DefaultImpls.updateSeiVerAndUiLayout(r100, r101, r102);
        }

        public static void updateSpeechRecognitionSei(IKtvComponentFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IKtvRoomFeedView.DefaultImpls.updateSpeechRecognitionSei(r100, r101);
        }

        public static void updateSpeechRhythmSei(IKtvComponentFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IKtvRoomFeedView.DefaultImpls.updateSpeechRhythmSei(r100, r101);
        }

        public static void updateSubtitleSei(IKtvComponentFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
            IKtvRoomFeedView.DefaultImpls.updateSubtitleSei(r100, r101);
        }

        public static void updateTalkState(IKtvComponentFeedView r100, HashMap<String, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r101, "talkStateMap");
            IKtvRoomFeedView.DefaultImpls.updateTalkState(r100, r101);
        }

        public static void updateTalkState(IKtvComponentFeedView r100, Map<String, Integer> r101) {
            Intrinsics.checkNotNullParameter(r101, "talkStateMap");
            IKtvRoomFeedView.DefaultImpls.updateTalkState(r100, r101);
        }
    }

    @Override // com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView
    String getCurrentSingUserIdString();

    boolean getKtvComponentLyricsViewShowStatus();

    @Override // com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView
    Object getKtvSeiModelObject();

    Observable<NullableOrderInfo> getOrderInfoObservable();

    @Override // com.bytedance.android.livesdkapi.feed.IInteractFeedView
    void onSeiUpdatedRaw(String r100);

    @Override // com.bytedance.android.livesdkapi.feed.IInteractFeedView
    void reset();

    @Override // com.bytedance.android.livesdkapi.feed.IKtvRoomFeedView
    void resetKtvSeiModelObject();

    void setAttachParent(ViewGroup r100, ViewGroup.LayoutParams r101);

    void updateKsongLayout(ViewGroup.LayoutParams r100);

    void updateKsongLayout(Function1<? super ViewGroup.LayoutParams, ? extends ViewGroup.LayoutParams> r100);

    void updateKtvComponentLyricsViewShowStatus(boolean r100);

    @Override // com.bytedance.android.livesdkapi.feed.IInteractFeedView
    void updateRoom(IRoom r100);
}
