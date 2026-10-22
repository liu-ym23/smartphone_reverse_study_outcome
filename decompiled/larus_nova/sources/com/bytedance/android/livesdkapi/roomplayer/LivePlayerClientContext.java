package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.livesdkapi.model.PlayerFirstFrameInfo;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010M\u001a\u00020\nJ\u000e\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010&\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\u001a\u0010(\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\n\u0012\u0004\u0012\u00020+\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001a\u0010?\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R\u001a\u0010B\u001a\u00020CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010-\"\u0004\bJ\u0010/R\u0011\u0010K\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bL\u0010\u0014¨\u0006Q"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerClientContext;", "", "config", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "(Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;)V", "_useScene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "afterCdnDisasterTolerance", "", "getAfterCdnDisasterTolerance", "()Z", "setAfterCdnDisasterTolerance", "(Z)V", "coldFirstPlayer", "getColdFirstPlayer", "setColdFirstPlayer", "createScene", "getCreateScene", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "currentSeiToJsonObject", "Lcom/bytedance/android/livesdkapi/roomplayer/SeiToJsonObject;", "getCurrentSeiToJsonObject", "()Lcom/bytedance/android/livesdkapi/roomplayer/SeiToJsonObject;", "setCurrentSeiToJsonObject", "(Lcom/bytedance/android/livesdkapi/roomplayer/SeiToJsonObject;)V", "firstFrameInfo", "Lcom/bytedance/android/livesdkapi/model/PlayerFirstFrameInfo;", "getFirstFrameInfo", "()Lcom/bytedance/android/livesdkapi/model/PlayerFirstFrameInfo;", "setFirstFrameInfo", "(Lcom/bytedance/android/livesdkapi/model/PlayerFirstFrameInfo;)V", "is0vv", "()Ljava/lang/Boolean;", "set0vv", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isLiveHeadEnterSmooth", "setLiveHeadEnterSmooth", "isPreviewSurfaceView", "setPreviewSurfaceView", "lastLayoutSei", "", "getLastLayoutSei", "()Ljava/lang/String;", "setLastLayoutSei", "(Ljava/lang/String;)V", "resolutionResult", "Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PickResult;", "getResolutionResult", "()Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PickResult;", "setResolutionResult", "(Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PickResult;)V", "resolutionSdkKeyList", "", "getResolutionSdkKeyList", "()Ljava/util/List;", "setResolutionSdkKeyList", "(Ljava/util/List;)V", "saveCurRenderBitmap", "getSaveCurRenderBitmap", "setSaveCurRenderBitmap", "shareRoute", "getShareRoute", "setShareRoute", "streamPlayTime", "", "getStreamPlayTime", "()J", "setStreamPlayTime", "(J)V", "triggerType", "getTriggerType", "setTriggerType", "useScene", "getUseScene", "isSharedClient", "setUseScene", "", "scene", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerClientContext {
    private ILivePlayerScene _useScene;
    private boolean afterCdnDisasterTolerance;
    private final ILivePlayerClient client;
    private boolean coldFirstPlayer;
    private final LivePlayerConfig config;
    private final ILivePlayerScene createScene;
    private SeiToJsonObject currentSeiToJsonObject;
    private PlayerFirstFrameInfo firstFrameInfo;
    private Boolean is0vv;
    private boolean isLiveHeadEnterSmooth;
    private boolean isPreviewSurfaceView;
    private String lastLayoutSei;
    private PlayerResolution.PickResult resolutionResult;
    private List<String> resolutionSdkKeyList;
    private boolean saveCurRenderBitmap;
    private String shareRoute;
    private long streamPlayTime;
    private String triggerType;

    public final boolean isSharedClient() {
        return !Intrinsics.areEqual(this.createScene, getUseScene());
    }

    public final boolean getAfterCdnDisasterTolerance() {
        return this.afterCdnDisasterTolerance;
    }

    public final boolean getColdFirstPlayer() {
        return this.coldFirstPlayer;
    }

    public final ILivePlayerScene getCreateScene() {
        return this.createScene;
    }

    public final SeiToJsonObject getCurrentSeiToJsonObject() {
        return this.currentSeiToJsonObject;
    }

    public final PlayerFirstFrameInfo getFirstFrameInfo() {
        return this.firstFrameInfo;
    }

    public final String getLastLayoutSei() {
        return this.lastLayoutSei;
    }

    public final PlayerResolution.PickResult getResolutionResult() {
        return this.resolutionResult;
    }

    public final List<String> getResolutionSdkKeyList() {
        return this.resolutionSdkKeyList;
    }

    public final boolean getSaveCurRenderBitmap() {
        return this.saveCurRenderBitmap;
    }

    public final String getShareRoute() {
        return this.shareRoute;
    }

    public final long getStreamPlayTime() {
        return this.streamPlayTime;
    }

    public final String getTriggerType() {
        return this.triggerType;
    }

    public final ILivePlayerScene getUseScene() {
        return this._useScene;
    }

    public final Boolean is0vv() {
        return this.is0vv;
    }

    public final boolean isLiveHeadEnterSmooth() {
        return this.isLiveHeadEnterSmooth;
    }

    public final boolean isPreviewSurfaceView() {
        return this.isPreviewSurfaceView;
    }

    public final void set0vv(Boolean r100) {
        this.is0vv = r100;
    }

    public final void setAfterCdnDisasterTolerance(boolean r100) {
        this.afterCdnDisasterTolerance = r100;
    }

    public final void setColdFirstPlayer(boolean r100) {
        this.coldFirstPlayer = r100;
    }

    public final void setCurrentSeiToJsonObject(SeiToJsonObject r100) {
        this.currentSeiToJsonObject = r100;
    }

    public final void setFirstFrameInfo(PlayerFirstFrameInfo r100) {
        this.firstFrameInfo = r100;
    }

    public final void setLastLayoutSei(String r100) {
        this.lastLayoutSei = r100;
    }

    public final void setLiveHeadEnterSmooth(boolean r100) {
        this.isLiveHeadEnterSmooth = r100;
    }

    public final void setPreviewSurfaceView(boolean r100) {
        this.isPreviewSurfaceView = r100;
    }

    public final void setResolutionResult(PlayerResolution.PickResult r100) {
        this.resolutionResult = r100;
    }

    public final void setResolutionSdkKeyList(List<String> r100) {
        this.resolutionSdkKeyList = r100;
    }

    public final void setSaveCurRenderBitmap(boolean r100) {
        this.saveCurRenderBitmap = r100;
    }

    public final void setShareRoute(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.shareRoute = r100;
    }

    public final void setStreamPlayTime(long r100) {
        this.streamPlayTime = r100;
    }

    public final void setTriggerType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.triggerType = r100;
    }

    public final void setUseScene(ILivePlayerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        ILivePlayerScene r101 = this._useScene;
        this._useScene = r100;
        if ((!Intrinsics.areEqual(r101, r100)) == false) goto L9;
        this.client.getEventHub().getSceneChange().setValue(r100);
        IPlayerLogger r102 = this.client.logger();
        if (r102 == null) goto L7;
        ILivePlayerSpmLogger.DefaultImpls.logLifeCycle$default(r102, "scene change : " + r101 + " -> " + r100, null, false, 2, null);
    L7:
        this.shareRoute = this.shareRoute + "->" + r100;
        return;
    }

    public LivePlayerClientContext(LivePlayerConfig r100, ILivePlayerClient r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "client");
        this.config = r100;
        this.client = r101;
        this.createScene = r100.getScene();
        this._useScene = r100.getScene();
        this.shareRoute = getUseScene().getScene();
        this.saveCurRenderBitmap = true;
        this.triggerType = "";
        this.streamPlayTime = -1;
    }
}
