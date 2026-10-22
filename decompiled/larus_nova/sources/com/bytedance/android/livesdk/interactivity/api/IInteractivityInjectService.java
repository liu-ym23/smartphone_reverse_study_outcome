package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.message.m1;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.InteractivityInjectService")
@Metadata(d1 = {"\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J,\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H&J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H&J\u001c\u0010\u001f\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001cH&J\u0012\u0010 \u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u0002H&J\n\u0010&\u001a\u0004\u0018\u00010$H&J\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010'H&J\b\u0010,\u001a\u00020+H&J\u0012\u0010-\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010.\u001a\u00020\u0002H&J&\u00102\u001a\u0004\u0018\u0001012\u0006\u0010\"\u001a\u00020!2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\r0/H&J\u0010\u00105\u001a\u00020\r2\u0006\u00104\u001a\u000203H&J\u0010\u00106\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0012H&J\f\u00109\u001a\u0006\u0012\u0002\b\u000308H&J\b\u0010:\u001a\u00020\rH&J\b\u0010;\u001a\u00020\rH&J(\u0010=\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH&J\u0012\u0010?\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010@\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010A\u001a\u00020\r2\u0006\u0010>\u001a\u00020\u001dH&J(\u0010F\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001dH&J(\u0010G\u001a\u00020\r2\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001dH&J$\u0010I\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020H2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001cH&J \u0010J\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010>\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010K\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010L\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010\u001dH&J\"\u0010Q\u001a\u0004\u0018\u00010P2\u0006\u0010M\u001a\u00020'2\u0006\u0010O\u001a\u00020N2\u0006\u0010\u0013\u001a\u00020\u0012H&J(\u0010S\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010'2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0004\u0012\u00020\r0/H&JV\u0010^\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\\\u0018\u00010[2\u0006\u0010\"\u001a\u00020!2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010V\u001a\u00020\u00142\u0006\u0010W\u001a\u00020!2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020\u001d2\u0006\u0010Z\u001a\u00020\u001dH&J\u001a\u0010a\u001a\u0004\u0018\u00010`2\u0006\u0010T\u001a\u00020!2\u0006\u0010_\u001a\u00020]H&J\"\u0010b\u001a\u0004\u0018\u00010`2\u0006\u0010T\u001a\u00020!2\u0006\u0010W\u001a\u00020!2\u0006\u0010_\u001a\u00020]H&J\u0012\u0010c\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J2\u0010g\u001a\u00020\r2\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020!2\u0006\u0010d\u001a\u00020\u001d2\b\u0010f\u001a\u0004\u0018\u00010eH&J\u0012\u0010h\u001a\u00020\u00022\b\u0010M\u001a\u0004\u0018\u00010'H&J\"\u0010m\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010j\u001a\u00020i2\u0006\u0010l\u001a\u00020kH&J\u0014\u0010n\u001a\u0004\u0018\u00010'2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010o\u001a\u00020\u0002H&J\u0012\u0010p\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0010\u0010s\u001a\u00020\r2\u0006\u0010r\u001a\u00020qH&J\u0014\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020q0tH&J@\u0010y\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001d2&\u0010x\u001a\"\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010vj\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u0001`wH&J0\u0010}\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010z\u001a\u00020\u001d2\u0006\u0010{\u001a\u00020\u001d2\u0006\u0010|\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!H&J\u0012\u0010\u007f\u001a\u00020\r2\b\u0010l\u001a\u0004\u0018\u00010~H\u0016J\u001b\u0010\u0082\u0001\u001a\u00020!2\u0007\u0010\u0080\u0001\u001a\u00020\u001d2\u0007\u0010\u0081\u0001\u001a\u00020\u001dH&J\t\u0010\u0083\u0001\u001a\u00020!H&J\n\u0010\u0085\u0001\u001a\u00030\u0084\u0001H&J\u001f\u0010\u0086\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0t2\u0006\u0010T\u001a\u00020!H&J\u0011\u0010\u0087\u0001\u001a\u00020\u00022\u0006\u0010T\u001a\u00020!H&J\u001c\u0010\u008b\u0001\u001a\u00020\r2\b\u0010\u0089\u0001\u001a\u00030\u0088\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0002H&J\u001c\u0010\u008d\u0001\u001a\u00020\r2\u0007\u0010\u008c\u0001\u001a\u00020\u00142\b\u0010f\u001a\u0004\u0018\u00010eH&J\u001b\u0010\u0090\u0001\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H&¨\u0006\u0091\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IInteractivityInjectService;", "Lcom/bytedance/android/live/base/IService;", "", "isUserEnterMessage", "currentInSubMatchCamera", "Lcom/bytedance/android/live/base/model/message/t;", "message", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/s;", "messageModel", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/r;", "callBack", "", "openPSOperatePanel", "isAnchor", "", "getScore", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "getVideoTalkRoomSubScene", "(Lcom/bytedance/ies/sdk/widgets/DataCenter;)Ljava/lang/Integer;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lcom/bytedance/android/livesdk/interactivity/api/s;", "callback", "subscribeVideoTalkRoomSubScene", "", "", "extra", "appendCastSDKLogCommonParams", "canShowCastDanmakuBtn", "", "roomId", "isShadow", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "currentPlayer", "currentClient", "Lcom/bytedance/live/datacontext/DataContext;", "dataContext", "Lcom/bytedance/live/datacontext/m;", "getLandscapeDialogState", "Lcom/bytedance/android/livesdk/reddot/a;", "audienceRoomBarrageSetting", "isInVrLandscape", "isShowWebAnim", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdk/chatroom/z0;", "Lio/reactivex/disposables/Disposable;", "subscribeSEITimePair", "Lcom/bytedance/android/live/liveinteract/plantform/model/IMessageBoardInfo;", "messageBoardInfo", "sendMessageBoardPin", "getMatchAgainstLeftName", "getMatchAgainstRightName", "Ljava/lang/Class;", "getBackendModelClass", "muteLivePlayerClient", "unmuteLivePlayerClient", "map", "buildVsRoomLog", "schema", "openMiniAppToShare", "preloadMiniAPPForInteractivityShare", "openMiniAppFromPublicScreen", "requestPage", "toUserId", "toUserType", "liveType", "logHighScoreSongLabelClick", "logHighScoreSongLabelShow", "Lcom/bytedance/android/live/base/model/message/m1;", "checkThenDoInjectMiniAppParams", "getLiveAnchorChooseButtonReportParam", "preloadMiniApp", "onShowMiniAppItem", "roomContext", "Ly22/d;", "sender", "Ly22/e;", "getChatChannelCommentFlowPlugin", "Ls22/c;", "getChannelGreetingManager", RemoteMessageConst.Notification.CHANNEL_ID, "content", "type", "emojiId", "imEmojiDisplayName", "rtfContent", "pasteMethod", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/Response;", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/b;", "channelChat", "response", "Ltlc/d;", "mockChatTextMessageWithResponse", "mockChatEmojiMessageWithResponse", "dataChannelMonitorLink", "emojiName", "", "error", "traceChatFailed", "isInMultiTabMode", "Landroid/view/View;", "containerView", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "changeDrawCleanScreen", "getLiveVisibilityControlContext", "enableToolbarFastGiftOptimize", "getVrMachineLogStr", "Lorg/json/JSONObject;", "adExtra", "handleLiveAdExtraData", "Lkotlin/Pair;", "createSamiTokenParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraParams", "showLiveFloatWindow", "event", "lable", "anchorId", "reportAdEvent", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "onMessageSendSuccess", "currentUserId", "guestUserId", "hasSecretChatChannel", "getCurrentChatChannelId", "Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/utils/a$a;", "getCurrentChannelTrackInfo", "getChannelValidStatus", "trySwitchToChannel", "Lcom/bytedance/android/livesdkapi/depend/model/live/roomchannel/RoomChannelInfo;", "roomChannelInfo", "addFirst", "createChatChannel", "statusCode", "reportSecretChatSend", "Lvlc/d;", "messageManager", "initKmpRoomMessageCenter", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IInteractivityInjectService extends IService {
    void appendCastSDKLogCommonParams(Map<String, String> r100);

    com.bytedance.android.livesdk.reddot.a audienceRoomBarrageSetting();

    void buildVsRoomLog(DataCenter r100, Map<String, String> r101);

    boolean canShowCastDanmakuBtn(DataCenter r100);

    void changeDrawCleanScreen(DataCenter r100, View r101, IRoom r102);

    Observable<Response<com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b>> channelChat(long r100, long r101, String r102, int r103, long r104, String r105, String r110, String r111);

    void checkThenDoInjectMiniAppParams(m1 r100, Map<String, String> r101);

    void createChatChannel(RoomChannelInfo r100, boolean r101);

    Pair<String, JSONObject> createSamiTokenParams();

    ILivePlayerClient currentClient();

    boolean currentInSubMatchCamera();

    ILivePlayerClient currentPlayer(long r100, boolean r101);

    void dataChannelMonitorLink(DataCenter r100);

    boolean enableToolbarFastGiftOptimize();

    Class<?> getBackendModelClass();

    void getChannelGreetingManager(DataContext r100, Function1<? super s22.c, Unit> r101);

    Pair<Boolean, String> getChannelValidStatus(long r100);

    y22.e getChatChannelCommentFlowPlugin(DataContext r100, y22.d r101, DataCenter r102);

    com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.a.C2103a getCurrentChannelTrackInfo();

    long getCurrentChatChannelId();

    com.bytedance.live.datacontext.m<Boolean> getLandscapeDialogState(DataContext r100);

    Map<String, String> getLiveAnchorChooseButtonReportParam(String r100);

    DataContext getLiveVisibilityControlContext(DataCenter r100);

    String getMatchAgainstLeftName(DataCenter r100);

    String getMatchAgainstRightName(DataCenter r100);

    float getScore(boolean r100);

    Integer getVideoTalkRoomSubScene(DataCenter r100);

    String getVrMachineLogStr(DataCenter r100);

    void handleLiveAdExtraData(JSONObject r100);

    long hasSecretChatChannel(String r100, String r101);

    void initKmpRoomMessageCenter(long r100, vlc.d r101);

    boolean isInMultiTabMode(DataContext r100);

    boolean isInVrLandscape(DataCenter r100);

    boolean isShowWebAnim();

    boolean isUserEnterMessage();

    void logHighScoreSongLabelClick(String r100, String r101, String r102, String r103);

    void logHighScoreSongLabelShow(String r100, String r101, String r102, String r103);

    tlc.d mockChatEmojiMessageWithResponse(long r100, long r101, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b r102);

    tlc.d mockChatTextMessageWithResponse(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.b r101);

    void muteLivePlayerClient();

    void onMessageSendSuccess(Room r100);

    void onShowMiniAppItem(String r100);

    void openMiniAppFromPublicScreen(String r100);

    void openMiniAppToShare(String r100);

    void openPSOperatePanel(t r100, Context r101, com.bytedance.android.livesdk.interactivity.api.publicscreen.s r102, com.bytedance.android.livesdk.interactivity.api.publicscreen.r r103);

    void preloadMiniAPPForInteractivityShare(String r100);

    void preloadMiniApp(String r100);

    void reportAdEvent(DataCenter r100, String r101, String r102, String r103, long r104);

    void reportSecretChatSend(int r100, Throwable r101);

    void sendMessageBoardPin(IMessageBoardInfo r100);

    void showLiveFloatWindow(Context r100, String r101, HashMap<String, String> r102);

    Disposable subscribeSEITimePair(long r100, Function1<? super z0, Unit> r101);

    void subscribeVideoTalkRoomSubScene(DataCenter r100, CompositeDisposable r101, s r102);

    void traceChatFailed(long r100, String r101, long r102, String r103, Throwable r104);

    boolean trySwitchToChannel(long r100);

    void unmuteLivePlayerClient();
}
