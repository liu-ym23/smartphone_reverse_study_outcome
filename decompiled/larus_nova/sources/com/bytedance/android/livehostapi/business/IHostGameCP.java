package com.bytedance.android.livehostapi.business;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.bytedance.android.livehostapi.business.depend.ISimpleCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IAirCompressListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IDownloadedGameCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IFlowTipsDialogListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameAutoDownloadResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPDownloadView;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPSelectImageCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPTrackService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPUploadImageCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPWhiteBoxTestService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCancelOrderResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameDownloadListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameJSBCallerListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameOrderResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePlayCard;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGamePromoteRankSettingCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameResDownloadListener;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameStatusResultCallback;
import com.bytedance.android.livehostapi.business.depend.gamecp.MediaModel;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.kmp.core.a;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¶\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0002H&J(\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J(\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0015\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&J(\u0010\u0019\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&J0\u0010\u001b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017H'J-\u0010\u001f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u001f\u0010 J-\u0010!\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b!\u0010 J(\u0010$\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010#0\"H&J\u001a\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H&J\"\u0010+\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\r2\u0006\u0010*\u001a\u00020)2\b\u0010'\u001a\u0004\u0018\u00010&H&J$\u0010,\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H&J,\u0010.\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010-\u001a\u00020)2\u0006\u0010%\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010&H&J\u0012\u0010/\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J0\u00102\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010#0\"2\u0006\u00101\u001a\u000200H&J>\u00108\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u00104\u001a\u0004\u0018\u0001032\b\u00106\u001a\u0004\u0018\u0001052\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0017H&J\b\u00109\u001a\u00020)H&J$\u0010<\u001a\u00020)2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:2\b\u00101\u001a\u0004\u0018\u00010;H&J\"\u0010>\u001a\u00020)2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:2\u0006\u00101\u001a\u00020=H&J\u001a\u0010?\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:H&J\"\u0010A\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:2\u0006\u0010'\u001a\u00020@H&J(\u0010?\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010B\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\rH&J4\u0010E\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010B\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010\r2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040DH&J\u001a\u0010F\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:H&J\u001a\u0010G\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:H&J\u001a\u0010H\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020:H&J6\u0010N\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020J0I\u0018\u00010M2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0I2\u0006\u0010L\u001a\u00020)H&J\u0010\u0010O\u001a\u00020#2\u0006\u0010\f\u001a\u00020\u000bH&J(\u0010T\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010S\u001a\u00020RH&J<\u0010W\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\r2\u0006\u0010U\u001a\u00020\r2\u0006\u0010C\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010R2\b\u0010'\u001a\u0004\u0018\u00010VH&J4\u0010Z\u001a\u00020\u00022\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010R2\b\u00101\u001a\u0004\u0018\u00010YH&J\"\u0010\\\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020R2\b\u0010'\u001a\u0004\u0018\u00010[H&J(\u0010_\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020R0I2\b\u0010'\u001a\u0004\u0018\u00010^H&J$\u0010a\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010R2\b\u0010'\u001a\u0004\u0018\u00010`H&J,\u0010d\u001a\u00020\u00022\u0006\u0010b\u001a\u00020)2\u0006\u0010c\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017H&J4\u0010d\u001a\u00020\u00022\u0006\u0010b\u001a\u00020)2\u0006\u0010c\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00172\u0006\u0010e\u001a\u00020\u0004H&J$\u0010f\u001a\u00020\u00022\u0006\u0010c\u001a\u00020\r2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0017H&J\b\u0010g\u001a\u00020\u0002H&J\u0010\u0010i\u001a\u00020\u00022\u0006\u0010h\u001a\u00020\u0004H&J\u0010\u0010k\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010jH&J\u0012\u0010m\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010lH&J\n\u0010n\u001a\u0004\u0018\u00010\rH&J\b\u0010p\u001a\u00020oH&J\b\u0010r\u001a\u00020qH&J\n\u0010t\u001a\u0004\u0018\u00010sH&J\b\u0010u\u001a\u00020\u0004H&J \u0010w\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\r2\u0006\u0010'\u001a\u00020vH&J\b\u0010x\u001a\u00020\u0004H&J\n\u0010z\u001a\u0004\u0018\u00010yH&J\n\u0010|\u001a\u0004\u0018\u00010{H&J\u0012\u0010}\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u007f\u001a\u0004\u0018\u00010~H&J\t\u0010\u0080\u0001\u001a\u00020\u0002H&J'\u0010\u0083\u0001\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\r2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\r2\u0007\u00101\u001a\u00030\u0082\u0001H&J\u0013\u0010\u0084\u0001\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\rH&J\u0013\u0010\u0085\u0001\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u00010\rH&J\u0013\u0010\u0086\u0001\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u0088\u0001\u001a\u000b\u0012\u0004\u0012\u00020#\u0018\u00010\u0087\u0001H&J\u000b\u0010\u0089\u0001\u001a\u0004\u0018\u00010\rH&J,\u0010\u008b\u0001\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u008a\u0001\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\rH&J\f\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u0001H&J\u0015\u0010\u0090\u0001\u001a\u0004\u0018\u00010#2\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001H&J\u0012\u0010\u0092\u0001\u001a\u00020\u00022\u0007\u0010\u0091\u0001\u001a\u00020\u0004H&¨\u0006\u0093\u0001À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostGameCP;", "Lcom/bytedance/android/livehostapi/business/IMiddlewareHostGameCP;", "", "init", "", "hasInit", "isAppBackground", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "onAnchorCreatedRoom", "onAnchorExitRoom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "uniqueKey", "source", "onRoomEnter", "", "roomId", "onRoomExit", "onLoadAiPredictor", "stopAiPredictorTimer", "onUnloadAiPredictor", "", "trackParams", "showIntroDialog", "params", "showPromoteListDialog", "Landroid/os/Bundle;", "arguments", "isAnchor", "showGamePromoteDetailDialog", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/lang/Boolean;)V", "showGameOrderDetailDialog", "", "", "showPropsDetailDialog", "from", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePromoteRankSettingCallback;", "callback", "getGamePromoteRankSetting", "", "status", "setGamePromoteRankSetting", "showGamePromoteRankSetting", "curItemValue", "showGamePromoteRankSettingDy", "openGameCPPlayerRankInstruction", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameJSBCallerListener;", "listener", "bindTencentRoleInTest", "Landroid/net/Uri;", "uri", "Landroid/view/View;", "view", "queryItems", "handleHttpSchema", "getDownloadToken", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameDownloadListener;", "subscribeDownloadGame", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameResDownloadListener;", "subscribeDownloadGameRes", "downloadGameAction", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IFlowTipsDialogListener;", "downloadGameResAction", "gameId", "enterFrom", "Lcom/bytedance/android/livehostapi/business/depend/ISimpleCallback;", "hasDownloadRecord", "unsubscribeDownloadGame", "unsubscribeDownloadGameRes", "cancelDownloadGame", "", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/MediaModel;", "selected", "selectNumber", "Lio/reactivex/Observable;", "selectImages", "getLynxNestRecyclerView", "label", "refer", "Lorg/json/JSONObject;", "adExtraData", "sendAdLog", "gameName", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameOrderResultCallback;", "orderGame", "ctx", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCancelOrderResultCallback;", "cancelOrderGame", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPSelectImageCallback;", "openAlbum", "list", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPUploadImageCallback;", "uploadImage", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameAutoDownloadResultCallback;", "autoDownloadWhenOnline", "scene", "eventName", "logMonitorLinkEvent", "useParamPassing", "dataChannelLinkEvent", "clearLivePromoteIconShowStatus", "show", "livePromoteIconShowChange", "", "getDownloadingGames", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IDownloadedGameCallback;", "getHasDownloadedGame", "getDownloadedGameIconUri", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPTrackService;", "getTrackService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPWhiteBoxTestService;", "getWhiteBoxTestService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPDownloadView;", "createGameCPDownload", "interceptLiveFloatWindow", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameStatusResultCallback;", "getGameDownloadStatus", "hasGamePromoteDialogShow", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/cloudgame/IGameCPCloudGameService;", "getCloudGameService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpGameService;", "getGameService", "onAnchorRoomContextCreated", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCPFmpMonitorService;", "getGameCPFmpMonitorService", "checkInstallFailPushTips", "filePath", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IAirCompressListener;", "registerAirCompressListener", "isSupportAirCompress", "isRestoreFailed", "unregisterAirCompressListener", "", "getBehaviorList", "getGameCpSdkVersion", "uniqueCode", "onWidgetLoaded", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGamePlayCard;", "createGamePlayCard", "Lcom/bytedance/live/kmp/core/a;", "liveRoomInstance", "createGameCpInstance", "degrade", "inDegradeScene", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostGameCP extends IMiddlewareHostGameCP {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.IHostGameCP$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void downloadGameAction$default(IHostGameCP r100, Context r101, String r102, String r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L6;
            r103 = "";
        L6:
            r100.downloadGameAction(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadGameAction");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void downloadGameAction$default(IHostGameCP r100, Context r101, String r102, String r103, int r104, Object r105) {
            CC.downloadGameAction$default(r100, r101, r102, r103, r104, r105);
        }
    }

    void autoDownloadWhenOnline(Context r100, JSONObject r101, IGameAutoDownloadResultCallback r102);

    void bindTencentRoleInTest(Context r100, Map<String, Object> r101, IGameJSBCallerListener r102);

    void cancelDownloadGame(Context r100, JsonObject r101);

    void cancelOrderGame(Context r100, String r101, String r102, JSONObject r103, IGameCancelOrderResultCallback r104);

    void checkInstallFailPushTips();

    void clearLivePromoteIconShowStatus();

    IGameCPDownloadView createGameCPDownload();

    Object createGameCpInstance(a r100);

    IGamePlayCard createGamePlayCard();

    void dataChannelLinkEvent(String r100, Map<String, String> r101);

    void downloadGameAction(Context r100, JsonObject r101);

    void downloadGameAction(Context r100, String r101, String r102);

    void downloadGameResAction(Context r100, JsonObject r101, IFlowTipsDialogListener r102);

    List<Object> getBehaviorList();

    IGameCPCloudGameService getCloudGameService();

    int getDownloadToken();

    String getDownloadedGameIconUri();

    Set<String> getDownloadingGames();

    IGameCPFmpMonitorService getGameCPFmpMonitorService();

    String getGameCpSdkVersion();

    void getGameDownloadStatus(Context r100, String r101, IGameStatusResultCallback r102);

    void getGamePromoteRankSetting(String r100, IGamePromoteRankSettingCallback r101);

    IGameCpGameService getGameService();

    boolean getHasDownloadedGame(IDownloadedGameCallback r100);

    Object getLynxNestRecyclerView(Context r100);

    IGameCPTrackService getTrackService();

    IGameCPWhiteBoxTestService getWhiteBoxTestService();

    boolean handleHttpSchema(Context r100, Uri r101, View r102, Map<String, String> r103);

    void hasDownloadRecord(Context r100, String r101, String r102, ISimpleCallback<Boolean> r103);

    boolean hasGamePromoteDialogShow();

    boolean hasInit();

    void inDegradeScene(boolean r100);

    void init();

    boolean interceptLiveFloatWindow();

    boolean isAppBackground();

    boolean isRestoreFailed(String r100);

    boolean isSupportAirCompress(String r100);

    void livePromoteIconShowChange(boolean r100);

    void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102);

    void logMonitorLinkEvent(int r100, String r101, Map<String, String> r102, boolean r103);

    void onAnchorCreatedRoom(Room r100);

    void onAnchorExitRoom();

    void onAnchorRoomContextCreated(Room r100);

    void onLoadAiPredictor(Context r100, long r101, String r102, String r103);

    void onRoomEnter(Context r100, Room r101, String r102, String r103);

    void onRoomExit(long r100, String r101, String r102);

    void onUnloadAiPredictor(long r100);

    void onWidgetLoaded(Context r100, Room r101, int r102, String r103);

    void openAlbum(Context r100, JSONObject r101, IGameCPSelectImageCallback r102);

    void openGameCPPlayerRankInstruction(Context r100);

    void orderGame(Context r100, String r101, String r102, String r103, JSONObject r104, IGameOrderResultCallback r105);

    void registerAirCompressListener(String r100, String r101, IAirCompressListener r102);

    Observable<List<MediaModel>> selectImages(Context r100, List<? extends MediaModel> r101, int r102);

    void sendAdLog(String r100, String r101, long r102, JSONObject r103);

    void setGamePromoteRankSetting(String r100, int r101, IGamePromoteRankSettingCallback r102);

    void showGameOrderDetailDialog(Context r100, Bundle r101, Boolean r102);

    void showGamePromoteDetailDialog(Context r100, Bundle r101, Boolean r102);

    void showGamePromoteRankSetting(Context r100, String r101, IGamePromoteRankSettingCallback r102);

    void showGamePromoteRankSettingDy(Context r100, int r101, String r102, IGamePromoteRankSettingCallback r103);

    void showIntroDialog(Context r100, Map<String, String> r101);

    @Deprecated(message = "主播推荐列表已经禁用")
    void showPromoteListDialog(Context r100, Room r101, Map<String, String> r102);

    void showPropsDetailDialog(Context r100, Map<String, Object> r101);

    void stopAiPredictorTimer();

    int subscribeDownloadGame(Context r100, JsonObject r101, IGameDownloadListener r102);

    int subscribeDownloadGameRes(Context r100, JsonObject r101, IGameResDownloadListener r102);

    void unregisterAirCompressListener(String r100);

    void unsubscribeDownloadGame(Context r100, JsonObject r101);

    void unsubscribeDownloadGameRes(Context r100, JsonObject r101);

    void uploadImage(Context r100, List<? extends JSONObject> r101, IGameCPUploadImageCallback r102);
}
