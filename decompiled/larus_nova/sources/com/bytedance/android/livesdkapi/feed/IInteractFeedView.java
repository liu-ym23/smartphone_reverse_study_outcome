package com.bytedance.android.livesdkapi.feed;

import android.view.View;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.feed.data.FeedViewRoomInfoStore;
import com.bytedance.android.livesdkapi.feed.data.IPkExposeData;
import com.bytedance.android.livesdkapi.ktv.IKtvComponentFeedView;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.service.InteractFeedActionCaller;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.android.livesdkapi.util.IInteractPlayView;
import com.bytedance.android.livesdkapi.util.IMultiScenePreviewStatistics;
import com.bytedance.android.livesdkapi.view.IRenderView;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tlc.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J,\u0010\u001f\u001a\u00020\u00062\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u001bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c`\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010#\u001a\u00020\u0006H&J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u001c\u0010)\u001a\u00020\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\u0016\u0010.\u001a\u00020\u00062\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0$H\u0016J#\u00102\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00152\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\b\u00104\u001a\u00020\u0006H\u0016J\b\u00105\u001a\u00020\u0006H\u0016J\u0010\u00108\u001a\u00020\u00062\u0006\u00107\u001a\u000206H\u0016J\u001a\u0010=\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010<\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?H\u0016J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0016J\n\u0010F\u001a\u0004\u0018\u00010EH\u0016J\n\u0010H\u001a\u0004\u0018\u00010GH\u0016J\n\u0010J\u001a\u0004\u0018\u00010IH\u0016J\u0010\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010$H\u0016J\u001c\u0010O\u001a\u00020\u00062\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020M0LH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010PH\u0016J\n\u0010S\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010V\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010TH\u0016J\u0010\u0010W\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010X\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010Y\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010Z\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010[\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0010\u0010\\\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010_\u001a\u00020\u00062\u0006\u0010]\u001a\u0002002\u0006\u0010^\u001a\u000200H\u0016J\u0018\u0010b\u001a\u00020\u00062\u0006\u0010`\u001a\u0002002\u0006\u0010a\u001a\u000200H\u0016J(\u0010c\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u001dH\u0016J\n\u0010e\u001a\u0004\u0018\u00010dH\u0016¨\u0006f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/IInteractFeedView;", "", "", "getFeedViewName", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "", "updateRoom", "updateRoomBeforeSelect", "Lcom/bytedance/android/livesdkapi/view/IRenderView;", "renderView", "setLivePlayerView", "Lcom/bytedance/android/livesdkapi/feed/IPreviewPlayerContainerAbility;", "playerContainerAbility", "setLivePlayerContainerAbility", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "livePlayerClient", "setLivePlayerClient", "Lcom/bytedance/android/livesdkapi/model/SeiAppData;", "seiAppData", "onSeiUpdated", "Lorg/json/JSONObject;", "appData", "sei", "onSeiUpdatedRaw", "monitorLayouts", "onOnlineListChanged", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "talkStateMap", "updateTalkState", "syncKey", "value", "onWrdsDataUpdate", BasicTestActionHandler.TEST_ACTION_RESET, "", "Lcom/bytedance/android/live/liveinteract/plantform/model/ILinkPlayerInfoBridge;", "getOnlineList", "enterFromMerge", "enterMethod", "updateEnterFrom", "onViewHolderSelected", "onViewHolderUnSelected", "Ltlc/d;", "msgList", "sendMessage", "canvas", "", "version", "refreshSeiCanvasAndSeiVersion", "(Lorg/json/JSONObject;Ljava/lang/Integer;)V", "onViewHolderPause", "onViewHolderResume", "Lcom/bytedance/android/livesdkapi/util/IInteractPlayView;", "interactPlayView", "setInteractPlayView", "Lcom/bytedance/android/livesdkapi/util/IMultiScenePreviewStatistics;", "multiScenePreviewStatistics", "", "bindTime", "bindMultiScenePreviewReportData", "onViewHolderUnBind", "Lcom/bytedance/android/livesdkapi/service/MessageHub;", "hub", "updateMessageHub", "Lcom/bytedance/android/livesdkapi/service/InteractFeedActionCaller;", "caller", "updateActionCaller", "Lcom/bytedance/android/livesdkapi/feed/IPkFeedView;", "getIPkFeedView", "Lcom/bytedance/android/livesdkapi/feed/IMultiFeedView;", "getIMultiFeedView", "Lcom/bytedance/android/livesdkapi/feed/IKtvInteractFeedView;", "getIKtvInteractFeedView", "getImCacheTags", "", "Lcom/bytedance/android/livesdkapi/feed/ImCacheUnit;", "map", "putImCacheContent", "Lcom/bytedance/android/livesdkapi/ktv/IKtvComponentFeedView;", "getKtvComponentFeedView", "Landroid/view/View;", "getViewCompat", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/feed/data/IPkExposeData;", "observeFeedViewExposeData", "updateSubtitleSei", "updateRadioTextSei", "updateSpeechRecognitionSei", "updateSpeechRhythmSei", "updateRadioSei", "updateMvControllerSei", "seiVer", "uiLayout", "updateSeiVerAndUiLayout", "screenWidth", "screenHeight", "onScreenSizeChange", "getChatRoomEnterRoomExtraParam", "Lcom/bytedance/android/livesdkapi/feed/data/FeedViewRoomInfoStore;", "getFeedViewRoomInfoStore", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractFeedView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void bindMultiScenePreviewReportData(IInteractFeedView r100, IMultiScenePreviewStatistics r101, long r102) {
        }

        public static HashMap<String, Object> getChatRoomEnterRoomExtraParam(IInteractFeedView r100) {
            return null;
        }

        public static FeedViewRoomInfoStore getFeedViewRoomInfoStore(IInteractFeedView r100) {
            return null;
        }

        public static IKtvInteractFeedView getIKtvInteractFeedView(IInteractFeedView r100) {
            return null;
        }

        public static IMultiFeedView getIMultiFeedView(IInteractFeedView r100) {
            return null;
        }

        public static IPkFeedView getIPkFeedView(IInteractFeedView r100) {
            return null;
        }

        public static List<String> getImCacheTags(IInteractFeedView r100) {
            return null;
        }

        public static IKtvComponentFeedView getKtvComponentFeedView(IInteractFeedView r100) {
            return null;
        }

        public static void monitorLayouts(IInteractFeedView r100, String r101) {
        }

        public static Observable<IPkExposeData> observeFeedViewExposeData(IInteractFeedView r100) {
            return null;
        }

        public static void onOnlineListChanged(IInteractFeedView r100) {
        }

        public static void onScreenSizeChange(IInteractFeedView r100, int r101, int r102) {
        }

        public static void onSeiUpdated(IInteractFeedView r100, SeiAppData r101) {
        }

        public static void onSeiUpdated(IInteractFeedView r100, JSONObject r101) {
        }

        public static void onSeiUpdatedRaw(IInteractFeedView r100, String r101) {
        }

        public static void onViewHolderPause(IInteractFeedView r100) {
        }

        public static void onViewHolderResume(IInteractFeedView r100) {
        }

        public static void onViewHolderSelected(IInteractFeedView r100) {
        }

        public static void onViewHolderUnBind(IInteractFeedView r100) {
        }

        public static void onViewHolderUnSelected(IInteractFeedView r100) {
        }

        public static void onWrdsDataUpdate(IInteractFeedView r100, String r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "syncKey");
        }

        public static void putImCacheContent(IInteractFeedView r100, Map<String, ? extends ImCacheUnit> r101) {
            Intrinsics.checkNotNullParameter(r101, "map");
        }

        public static void refreshSeiCanvasAndSeiVersion(IInteractFeedView r100, JSONObject r101, Integer r102) {
        }

        public static void sendMessage(IInteractFeedView r100, List<? extends d> r101) {
            Intrinsics.checkNotNullParameter(r101, "msgList");
        }

        public static void setInteractPlayView(IInteractFeedView r100, IInteractPlayView r101) {
            Intrinsics.checkNotNullParameter(r101, "interactPlayView");
        }

        public static void updateActionCaller(IInteractFeedView r100, InteractFeedActionCaller r101) {
            Intrinsics.checkNotNullParameter(r101, "caller");
        }

        public static void updateEnterFrom(IInteractFeedView r100, String r101, String r102) {
        }

        public static void updateMessageHub(IInteractFeedView r100, MessageHub r101) {
            Intrinsics.checkNotNullParameter(r101, "hub");
        }

        public static void updateMvControllerSei(IInteractFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
        }

        public static void updateRadioSei(IInteractFeedView r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
        }

        public static void updateRadioTextSei(IInteractFeedView r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
        }

        public static void updateRoomBeforeSelect(IInteractFeedView r100, IRoom r101) {
        }

        public static void updateSeiVerAndUiLayout(IInteractFeedView r100, int r101, int r102) {
        }

        public static void updateSpeechRecognitionSei(IInteractFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
        }

        public static void updateSpeechRhythmSei(IInteractFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
        }

        public static void updateSubtitleSei(IInteractFeedView r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "sei");
        }

        public static void updateTalkState(IInteractFeedView r100, HashMap<String, Boolean> r101) {
            Intrinsics.checkNotNullParameter(r101, "talkStateMap");
        }

        public static List<ILinkPlayerInfoBridge> getOnlineList(IInteractFeedView r100) {
            return new ArrayList();
        }

        public static View getViewCompat(IInteractFeedView r100) {
            boolean r101 = r100 instanceof View;
            Object r102 = r100;
            if (r101 == true) goto L6;
            r102 = null;
        L6:
            return (View) r102;
        }
    }

    void bindMultiScenePreviewReportData(IMultiScenePreviewStatistics r100, long r101);

    HashMap<String, Object> getChatRoomEnterRoomExtraParam();

    String getFeedViewName();

    FeedViewRoomInfoStore getFeedViewRoomInfoStore();

    IKtvInteractFeedView getIKtvInteractFeedView();

    IMultiFeedView getIMultiFeedView();

    IPkFeedView getIPkFeedView();

    List<String> getImCacheTags();

    IKtvComponentFeedView getKtvComponentFeedView();

    List<ILinkPlayerInfoBridge> getOnlineList();

    View getViewCompat();

    void monitorLayouts(String r100);

    Observable<IPkExposeData> observeFeedViewExposeData();

    void onOnlineListChanged();

    void onScreenSizeChange(int r100, int r101);

    void onSeiUpdated(SeiAppData r100);

    void onSeiUpdated(JSONObject r100);

    void onSeiUpdatedRaw(String r100);

    void onViewHolderPause();

    void onViewHolderResume();

    void onViewHolderSelected();

    void onViewHolderUnBind();

    void onViewHolderUnSelected();

    void onWrdsDataUpdate(String r100, Object r101);

    void putImCacheContent(Map<String, ? extends ImCacheUnit> r100);

    void refreshSeiCanvasAndSeiVersion(JSONObject r100, Integer r101);

    void reset();

    void sendMessage(List<? extends d> r100);

    void setInteractPlayView(IInteractPlayView r100);

    void setLivePlayerClient(ILivePlayerClient r100);

    void setLivePlayerContainerAbility(IPreviewPlayerContainerAbility r100);

    void setLivePlayerView(IRenderView r100);

    void updateActionCaller(InteractFeedActionCaller r100);

    void updateEnterFrom(String r100, String r101);

    void updateMessageHub(MessageHub r100);

    void updateMvControllerSei(String r100);

    void updateRadioSei(JSONObject r100);

    void updateRadioTextSei(JSONObject r100);

    void updateRoom(IRoom r100);

    void updateRoomBeforeSelect(IRoom r100);

    void updateSeiVerAndUiLayout(int r100, int r101);

    void updateSpeechRecognitionSei(String r100);

    void updateSpeechRhythmSei(String r100);

    void updateSubtitleSei(String r100);

    void updateTalkState(HashMap<String, Boolean> r100);
}
