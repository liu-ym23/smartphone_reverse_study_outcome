package com.bytedance.android.livesdkapi.roomplayer;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderInfo;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderLayoutConfig;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderLogInfo;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderSeiInfo;
import com.bytedance.android.livesdkapi.model.PlayerMainApplyConfig;
import com.bytedance.android.livesdkapi.model.PlayerMainRenderLayoutConfig;
import com.bytedance.android.livesdkapi.model.RenderDescInfo;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004CDEFJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0011H&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0011H&J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u0001H&J\b\u0010\u001d\u001a\u00020\u0011H&J\u0012\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#H&J\b\u0010$\u001a\u00020#H&J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u00020#H&J\b\u0010'\u001a\u00020#H&J\u001a\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020#H&J\b\u0010+\u001a\u00020\u001bH&J\b\u0010,\u001a\u00020#H&J\u0010\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020/H&J\b\u00100\u001a\u00020\u0011H&J\u0012\u00101\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u00020#H&J\b\u00103\u001a\u00020\u0011H&J\u001c\u00104\u001a\u00020\u00112\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000306H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0012\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u000109H&J\b\u0010:\u001a\u00020\u0011H&J\u0010\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\tH&J\u001c\u0010=\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?H&J\u0010\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020BH&¨\u0006G"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController;", "", "appLogStreamLayout", "", "calculateMainRenderSize", "Lcom/bytedance/android/livesdkapi/model/PlayerMainApplyConfig;", "mainConfig", "Lcom/bytedance/android/livesdkapi/model/PlayerMainRenderLayoutConfig;", "createInteractShadowView", "Landroid/view/View;", "clickListener", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$ClickListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "curExtraDescView", "curExtraRenderView", MapMonitorConst.EVENT_DESTROY, "", "destroyInteractShadowView", "disable", "enable", "renderInfo", "Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderInfo;", "eventHub", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$EventHub;", "forceReCrop", "getGameLayoutType", "", "getPlayerContext", "hideExtraRender", "injectRoomStatusService", "roomStatusService", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$RoomStatusService;", "invisibleExtraRender", "visible", "", "isEnable", "isGameRenderEnable", "isGameRoom", "isUgcRoom", "log", "msg", "suffix", "mainFrameDescViewHeight", "needLogDescViewShow", "onBindNewLivePlayerView", "livePlayerView", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerView;", "onFoldDeviceStateChanged", "onScreenLandscape", "force", "onScreenPortrait", "putSjbUgcExtraRenderParams", "map", "", "setRoomLoggerService", "loggerService", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$IRoomLoggerService;", "showExtraRender", "updateExtraRenderBackground", "view", "updateExtraRenderLayoutConfig", "extraConfig", "Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderLayoutConfig;", "updateRoomDescInfoByMessage", "desInfo", "Lcom/bytedance/android/livesdkapi/model/RenderDescInfo;", "ClickListener", "EventHub", "IRoomLoggerService", "RoomStatusService", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerExtraRenderController {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$ClickListener;", "", "onDescViewClick", "", "info", "Lcom/bytedance/android/livesdkapi/model/RenderDescInfo;", "onExtraRenderViewClick", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ClickListener {
        void onDescViewClick(RenderDescInfo r100);

        void onExtraRenderViewClick(RenderDescInfo r100);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static boolean isGameRenderEnable(ILivePlayerExtraRenderController r100) {
            return false;
        }

        public static /* synthetic */ void onScreenLandscape$default(ILivePlayerExtraRenderController r100, boolean r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            r100.onScreenLandscape(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onScreenLandscape");
        }

        public static /* synthetic */ View createInteractShadowView$default(ILivePlayerExtraRenderController r100, ClickListener r101, Context r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.createInteractShadowView(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createInteractShadowView");
        }

        public static /* synthetic */ void log$default(ILivePlayerExtraRenderController r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.log(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }

        public static /* synthetic */ void updateExtraRenderLayoutConfig$default(ILivePlayerExtraRenderController r100, PlayerMainRenderLayoutConfig r101, PlayerExtraRenderLayoutConfig r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            r100.updateExtraRenderLayoutConfig(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateExtraRenderLayoutConfig");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$EventHub;", "", "extraRenderIsShow", "Landroidx/lifecycle/MutableLiveData;", "", "getExtraRenderIsShow", "()Landroidx/lifecycle/MutableLiveData;", "extraViewBottom", "", "getExtraViewBottom", "extraViewWidth", "getExtraViewWidth", "mainFrameChanged", "getMainFrameChanged", "onRenderSeiInfoUpdate", "Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderSeiInfo;", "getOnRenderSeiInfoUpdate", "rotateToPortrait", "getRotateToPortrait", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface EventHub {
        MutableLiveData<Boolean> getExtraRenderIsShow();

        MutableLiveData<Integer> getExtraViewBottom();

        MutableLiveData<Integer> getExtraViewWidth();

        MutableLiveData<Boolean> getMainFrameChanged();

        MutableLiveData<PlayerExtraRenderSeiInfo> getOnRenderSeiInfoUpdate();

        MutableLiveData<Boolean> getRotateToPortrait();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$IRoomLoggerService;", "", "buildExtraRenderLogInfo", "Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderLogInfo;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IRoomLoggerService {
        PlayerExtraRenderLogInfo buildExtraRenderLogInfo();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerExtraRenderController$RoomStatusService;", "", "curOrientationIsPortrait", "", "isInCast", "statusBarHeight", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface RoomStatusService {
        boolean curOrientationIsPortrait();

        boolean isInCast();

        int statusBarHeight();
    }

    String appLogStreamLayout();

    PlayerMainApplyConfig calculateMainRenderSize(PlayerMainRenderLayoutConfig r100);

    View createInteractShadowView(ClickListener r100, Context r101);

    View curExtraDescView();

    View curExtraRenderView();

    void destroy();

    void destroyInteractShadowView();

    void disable();

    void enable(PlayerExtraRenderInfo r100);

    EventHub eventHub();

    void forceReCrop();

    int getGameLayoutType();

    Object getPlayerContext();

    void hideExtraRender();

    void injectRoomStatusService(RoomStatusService r100);

    void invisibleExtraRender(boolean r100);

    boolean isEnable();

    boolean isGameRenderEnable();

    boolean isGameRoom();

    boolean isUgcRoom();

    void log(String r100, boolean r101);

    int mainFrameDescViewHeight();

    boolean needLogDescViewShow();

    void onBindNewLivePlayerView(LivePlayerView r100);

    void onFoldDeviceStateChanged();

    void onScreenLandscape(boolean r100);

    void onScreenPortrait();

    void putSjbUgcExtraRenderParams(Map<String, String> r100);

    PlayerExtraRenderInfo renderInfo();

    void setRoomLoggerService(IRoomLoggerService r100);

    void showExtraRender();

    void updateExtraRenderBackground(View r100);

    void updateExtraRenderLayoutConfig(PlayerMainRenderLayoutConfig r100, PlayerExtraRenderLayoutConfig r101);

    void updateRoomDescInfoByMessage(RenderDescInfo r100);
}
