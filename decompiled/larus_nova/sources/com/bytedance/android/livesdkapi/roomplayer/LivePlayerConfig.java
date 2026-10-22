package com.bytedance.android.livesdkapi.roomplayer;

import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b*\u0018\u0000 E2\u00020\u0001:\u0001EBu\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0002\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010'R\u001a\u0010*\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010'R\u0011\u0010\u0013\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0016R\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010'R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0016\"\u0004\b>\u0010'R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0016\"\u0004\b@\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;", "", "scene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", LocationMonitorConst.IDENTIFIER, "", "type", "Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;", "shareToOther", "", "client", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "shareFromOther", "reusePreSceneTextureRenderView", "renderViewType", "Lcom/bytedance/android/livesdkapi/view/IRenderView$RenderViewType;", "autoSaveLastRenderFrame", "renderViewGravity", "", "observerLiveStatus", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;ZLcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;ZZLcom/bytedance/android/livesdkapi/view/IRenderView$RenderViewType;ZIZ)V", "getAutoSaveLastRenderFrame", "()Z", "getClient", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;", "setClient", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerClient;)V", "delayStopOrReleaseTime", "", "getDelayStopOrReleaseTime", "()J", "setDelayStopOrReleaseTime", "(J)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "isEncrypt", "setEncrypt", "(Z)V", "isVrRoom", "setVrRoom", "jumpSameStream", "getJumpSameStream", "setJumpSameStream", "getObserverLiveStatus", "projectKey", "getProjectKey", "setProjectKey", "getRenderViewGravity", "()I", "getRenderViewType", "()Lcom/bytedance/android/livesdkapi/view/IRenderView$RenderViewType;", "setRenderViewType", "(Lcom/bytedance/android/livesdkapi/view/IRenderView$RenderViewType;)V", "getReusePreSceneTextureRenderView", "setReusePreSceneTextureRenderView", "getScene", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "setScene", "(Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;)V", "getShareFromOther", "setShareFromOther", "getShareToOther", "setShareToOther", "getType", "()Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;", "setType", "(Lcom/bytedance/android/livesdkapi/roomplayer/PlayerClientType;)V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayerConfig {
    public static final Companion Companion = null;
    private final boolean autoSaveLastRenderFrame;
    private ILivePlayerClient client;
    private long delayStopOrReleaseTime;
    private String identifier;
    private boolean isEncrypt;
    private boolean isVrRoom;
    private boolean jumpSameStream;
    private final boolean observerLiveStatus;
    private String projectKey;
    private final int renderViewGravity;
    private IRenderView.RenderViewType renderViewType;
    private boolean reusePreSceneTextureRenderView;
    private ILivePlayerScene scene;
    private boolean shareFromOther;
    private boolean shareToOther;
    private PlayerClientType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig$Companion;", "", "()V", "buildWith", "Lcom/bytedance/android/livesdkapi/roomplayer/LivePlayerConfig;", "_scene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "roomId", "", "", "_shareFromOther", "", "_sharToOther", "buildWithSurface", "_useSurface", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final LivePlayerConfig buildWith(ILivePlayerScene r110) {
            Intrinsics.checkNotNullParameter(r110, "_scene");
            return new LivePlayerConfig(r110, null, null, false, null, false, false, null, false, 0, false, 2046, null);
        }

        @JvmStatic
        public final LivePlayerConfig buildWith(ILivePlayerScene r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, "_scene");
            Intrinsics.checkNotNullParameter(r111, "roomId");
            return new LivePlayerConfig(r110, r111, null, false, null, false, false, null, false, 0, false, 2044, null);
        }

        @JvmStatic
        public final LivePlayerConfig buildWith(ILivePlayerScene r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "_scene");
            return buildWith(r100, String.valueOf(r101));
        }

        @JvmStatic
        public final LivePlayerConfig buildWith(ILivePlayerScene r110, String r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r110, "_scene");
            Intrinsics.checkNotNullParameter(r111, "roomId");
            return new LivePlayerConfig(r110, r111, null, false, null, r112, false, null, false, 0, false, 2012, null);
        }

        @JvmStatic
        public final LivePlayerConfig buildWithSurface(ILivePlayerScene r110, String r111, boolean r112) {
            Intrinsics.checkNotNullParameter(r110, "_scene");
            Intrinsics.checkNotNullParameter(r111, "roomId");
            PlayerClientType r100 = null;
            boolean r101 = false;
            ILivePlayerClient r102 = null;
            boolean r103 = false;
            boolean r104 = false;
            if (r112 == false) goto L5;
            IRenderView.RenderViewType r105 = IRenderView.RenderViewType.SURFACE_VIEW;
        L7:
            return new LivePlayerConfig(r110, r111, r100, r101, r102, r103, r104, r105, false, 0, false, 1916, null);
        L5:
            r105 = IRenderView.RenderViewType.TEXTURE_VIEW;
            goto L7
        }

        @JvmStatic
        public final LivePlayerConfig buildWith(ILivePlayerScene r110, String r111, boolean r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r110, "_scene");
            Intrinsics.checkNotNullParameter(r111, "roomId");
            return new LivePlayerConfig(r110, r111, null, r113, null, r112, false, null, false, 0, false, 2004, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LivePlayerConfig(ILivePlayerScene r110) {
        this(r110, null, null, false, null, false, false, null, false, 0, false, 2046, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111) {
        this(r110, r111, null, false, null, false, false, null, false, 0, false, 2044, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112) {
        this(r110, r111, r112, false, null, false, false, null, false, 0, false, 2040, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113) {
        this(r110, r111, r112, r113, null, false, false, null, false, 0, false, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114) {
        this(r110, r111, r112, r113, r114, false, false, null, false, 0, false, 2016, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114, boolean r210) {
        this(r110, r111, r112, r113, r114, r210, false, null, false, 0, false, 1984, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114, boolean r210, boolean r211) {
        this(r110, r111, r112, r113, r114, r210, r211, null, false, 0, false, TECameraUtils.CAPTURE_NORMAL, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114, boolean r210, boolean r211, IRenderView.RenderViewType r212) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, false, 0, false, ISmModel.VERSION_0700, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114, boolean r210, boolean r211, IRenderView.RenderViewType r212, boolean r213) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, 0, false, ISmModel.VERSION_0600, null);
    }

    public LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114, boolean r210, boolean r211, IRenderView.RenderViewType r212, boolean r213, int r214) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, false, 1024, null);
    }

    @JvmStatic
    public static final LivePlayerConfig buildWith(ILivePlayerScene r100) {
        return Companion.buildWith(r100);
    }

    @JvmStatic
    public static final LivePlayerConfig buildWith(ILivePlayerScene r100, long r101) {
        return Companion.buildWith(r100, r101);
    }

    @JvmStatic
    public static final LivePlayerConfig buildWith(ILivePlayerScene r100, String r101) {
        return Companion.buildWith(r100, r101);
    }

    @JvmStatic
    public static final LivePlayerConfig buildWith(ILivePlayerScene r100, String r101, boolean r102) {
        return Companion.buildWith(r100, r101, r102);
    }

    @JvmStatic
    public static final LivePlayerConfig buildWith(ILivePlayerScene r100, String r101, boolean r102, boolean r103) {
        return Companion.buildWith(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final LivePlayerConfig buildWithSurface(ILivePlayerScene r100, String r101, boolean r102) {
        return Companion.buildWithSurface(r100, r101, r102);
    }

    public final boolean getAutoSaveLastRenderFrame() {
        return this.autoSaveLastRenderFrame;
    }

    public final ILivePlayerClient getClient() {
        return this.client;
    }

    public final long getDelayStopOrReleaseTime() {
        return this.delayStopOrReleaseTime;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final boolean getJumpSameStream() {
        return this.jumpSameStream;
    }

    public final boolean getObserverLiveStatus() {
        return this.observerLiveStatus;
    }

    public final String getProjectKey() {
        return this.projectKey;
    }

    public final int getRenderViewGravity() {
        return this.renderViewGravity;
    }

    public final IRenderView.RenderViewType getRenderViewType() {
        return this.renderViewType;
    }

    public final boolean getReusePreSceneTextureRenderView() {
        return this.reusePreSceneTextureRenderView;
    }

    public final ILivePlayerScene getScene() {
        return this.scene;
    }

    public final boolean getShareFromOther() {
        return this.shareFromOther;
    }

    public final boolean getShareToOther() {
        return this.shareToOther;
    }

    public final PlayerClientType getType() {
        return this.type;
    }

    public final boolean isEncrypt() {
        return this.isEncrypt;
    }

    public final boolean isVrRoom() {
        return this.isVrRoom;
    }

    public final void setClient(ILivePlayerClient r100) {
        this.client = r100;
    }

    public final void setDelayStopOrReleaseTime(long r100) {
        this.delayStopOrReleaseTime = r100;
    }

    public final void setEncrypt(boolean r100) {
        this.isEncrypt = r100;
    }

    public final void setIdentifier(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.identifier = r100;
    }

    public final void setJumpSameStream(boolean r100) {
        this.jumpSameStream = r100;
    }

    public final void setProjectKey(String r100) {
        this.projectKey = r100;
    }

    public final void setRenderViewType(IRenderView.RenderViewType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderViewType = r100;
    }

    public final void setReusePreSceneTextureRenderView(boolean r100) {
        this.reusePreSceneTextureRenderView = r100;
    }

    public final void setScene(ILivePlayerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public final void setShareFromOther(boolean r100) {
        this.shareFromOther = r100;
    }

    public final void setShareToOther(boolean r100) {
        this.shareToOther = r100;
    }

    public final void setType(PlayerClientType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setVrRoom(boolean r100) {
        this.isVrRoom = r100;
    }

    public LivePlayerConfig(ILivePlayerScene r100, String r101, PlayerClientType r102, boolean r103, ILivePlayerClient r104, boolean r105, boolean r106, IRenderView.RenderViewType r107, boolean r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, LocationMonitorConst.IDENTIFIER);
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r107, "renderViewType");
        this.scene = r100;
        this.identifier = r101;
        this.type = r102;
        this.shareToOther = r103;
        this.client = r104;
        this.shareFromOther = r105;
        this.reusePreSceneTextureRenderView = r106;
        this.renderViewType = r107;
        this.autoSaveLastRenderFrame = r110;
        this.renderViewGravity = r111;
        this.observerLiveStatus = r112;
        this.delayStopOrReleaseTime = -1;
        if (r101.length() != 0) goto L5;
        boolean r108 = true;
    L6:
        if (r108 == false) goto L8;
    L9:
        this.identifier = String.valueOf(hashCode());
        return;
    L8:
        if (Intrinsics.areEqual(this.identifier, "0") == true) goto L9;
        return;
    L5:
        r108 = false;
        goto L6
    }

    public /* synthetic */ LivePlayerConfig(ILivePlayerScene r110, String r111, PlayerClientType r112, boolean r113, ILivePlayerClient r114, boolean r115, boolean r116, IRenderView.RenderViewType r117, boolean r210, int r211, boolean r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 2) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r213 & 4) == 0) goto L9;
        PlayerClientType r101 = PlayerClientType.NORMAL;
    L10:
        boolean r102 = false;
        if ((r213 & 8) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r213 & 16) == 0) goto L17;
        ILivePlayerClient r104 = null;
    L19:
        if ((r213 & 32) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r213 & 64) != 0) goto L27;
        r102 = r116;
    L27:
        if ((r213 & 128) == 0) goto L29;
        IRenderView.RenderViewType r106 = IRenderView.RenderViewType.TEXTURE_VIEW;
    L30:
        boolean r107 = true;
        if ((r213 & 256) == 0) goto L33;
        boolean r108 = true;
    L35:
        if ((r213 & 512) == 0) goto L37;
        int r118 = 17;
    L39:
        if ((r213 & 1024) != 0) goto L42;
        r107 = r212;
    L42:
        this(r110, r100, r101, r103, r104, r105, r102, r106, r108, r118, r107);
        return;
    L37:
        r118 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L30
    L21:
        r105 = r115;
        goto L23
    L17:
        r104 = r114;
        goto L19
    L13:
        r103 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L10
    L5:
        r100 = r111;
        goto L7
    }
}
