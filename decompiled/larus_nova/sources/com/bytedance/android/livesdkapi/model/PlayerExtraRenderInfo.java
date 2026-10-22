package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0016J\u0006\u00106\u001a\u00020\u0016J\u0006\u00107\u001a\u00020\u0016J\u0006\u00108\u001a\u00020\u0016J\b\u00109\u001a\u00020\"H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\b\"\u0004\b)\u0010\nR\u001a\u0010*\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010,\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0004R\u001a\u00100\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 ¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderInfo;", "", "layoutType", "", "(I)V", "curStreamSei", "Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderSeiInfo;", "getCurStreamSei", "()Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderSeiInfo;", "setCurStreamSei", "(Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderSeiInfo;)V", "descInfo", "Lcom/bytedance/android/livesdkapi/model/RenderDescInfo;", "getDescInfo", "()Lcom/bytedance/android/livesdkapi/model/RenderDescInfo;", "setDescInfo", "(Lcom/bytedance/android/livesdkapi/model/RenderDescInfo;)V", "descViewHeight", "getDescViewHeight", "()I", "setDescViewHeight", "extraAreaIsGame", "", "getExtraAreaIsGame", "()Z", "setExtraAreaIsGame", "(Z)V", "extraViewInfo", "Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "getExtraViewInfo", "()Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;", "setExtraViewInfo", "(Lcom/bytedance/android/livesdkapi/model/RenderViewInfo;)V", "initLinkMicSeiInfo", "", "getInitLinkMicSeiInfo", "()Ljava/lang/String;", "setInitLinkMicSeiInfo", "(Ljava/lang/String;)V", "initSeiInfo", "getInitSeiInfo", "setInitSeiInfo", "isLandStyle", "setLandStyle", "isPortrait", "setPortrait", "getLayoutType", "setLayoutType", "mainViewInfo", "getMainViewInfo", "setMainViewInfo", "getHorizontalPosition", "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "isWindow", "isFillLayout", "isGameLayout", "isUgcLayout", "toString", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerExtraRenderInfo {
    public static final Companion Companion = null;
    public static final int GAME_HORIZONTAL_FILL = 4;
    public static final int GAME_HORIZONTAL_WINDOW = 3;
    public static final int GAME_NOT_SUPPORT = 0;
    public static final int GAME_VERTICAL_FILL = 2;
    public static final int GAME_VERTICAL_WINDOW = 1;
    public static final int LAYOUT_GAME = 0;
    public static final int LAYOUT_UGC = 1;
    private PlayerExtraRenderSeiInfo curStreamSei;
    private RenderDescInfo descInfo;
    private int descViewHeight;
    private boolean extraAreaIsGame;
    private RenderViewInfo extraViewInfo;
    private String initLinkMicSeiInfo;
    private PlayerExtraRenderSeiInfo initSeiInfo;
    private boolean isLandStyle;
    private boolean isPortrait;
    private int layoutType;
    private RenderViewInfo mainViewInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderInfo$Companion;", "", "()V", "GAME_HORIZONTAL_FILL", "", "GAME_HORIZONTAL_WINDOW", "GAME_NOT_SUPPORT", "GAME_VERTICAL_FILL", "GAME_VERTICAL_WINDOW", "LAYOUT_GAME", "LAYOUT_UGC", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PlayerExtraRenderInfo() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public final boolean isGameLayout() {
        if (this.layoutType != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUgcLayout() {
        if (this.layoutType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "PlayerExtraRenderInfo(layoutType=" + this.layoutType + ", mainViewInfo=" + this.mainViewInfo + ", extraViewInfo=" + this.extraViewInfo + ", descInfo=" + this.descInfo + ", extraAreaIsGame=" + this.extraAreaIsGame + ", initSeiInfo=" + this.initSeiInfo + ')';
    }

    public final boolean isFillLayout() {
        if (isGameLayout() == false) goto L9;
        PlayerExtraRenderSeiInfo r100 = this.initSeiInfo;
        if (r100 == null) goto L9;
        if (r100.getCameraVerticalType() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final PlayerExtraRenderSeiInfo getCurStreamSei() {
        return this.curStreamSei;
    }

    public final RenderDescInfo getDescInfo() {
        return this.descInfo;
    }

    public final int getDescViewHeight() {
        return this.descViewHeight;
    }

    public final boolean getExtraAreaIsGame() {
        return this.extraAreaIsGame;
    }

    public final RenderViewInfo getExtraViewInfo() {
        return this.extraViewInfo;
    }

    public final String getInitLinkMicSeiInfo() {
        return this.initLinkMicSeiInfo;
    }

    public final PlayerExtraRenderSeiInfo getInitSeiInfo() {
        return this.initSeiInfo;
    }

    public final int getLayoutType() {
        return this.layoutType;
    }

    public final RenderViewInfo getMainViewInfo() {
        return this.mainViewInfo;
    }

    public final boolean isLandStyle() {
        return this.isLandStyle;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    public PlayerExtraRenderInfo(int r210) {
        this.layoutType = r210;
        this.mainViewInfo = new RenderViewInfo(null, 0, 0, 0, 0, null, false, 127, null);
        this.extraViewInfo = new RenderViewInfo(null, 0, 0, 0, 0, null, false, 127, null);
        this.descInfo = new RenderDescInfo();
        this.isPortrait = true;
    }

    public final RenderAreaInfo getHorizontalPosition(boolean r100) {
        PlayerExtraRenderSeiInfo r101 = this.initSeiInfo;
        if (r101 == null) goto L14;
        RenderAreaInfo r102 = r101.getCameraHorizontalPosition();
        if (r102 == null) goto L14;
        if (r102.isValidHorizontalArea() == true) goto L16;
        if (r100 == false) goto L11;
        RenderAreaInfo r103 = new RenderAreaInfo(0.0f, 0.0f, 0.25f, 0.25f);
    L15:
        return r103;
    L11:
        r103 = new RenderAreaInfo(1.0f, 0.0f, 0.25f, 1.0f);
        goto L15
    L16:
        return r102;
    L14:
        return new RenderAreaInfo(0.0f, 0.0f, 0.25f, 0.25f);
    }

    public final void setCurStreamSei(PlayerExtraRenderSeiInfo r100) {
        this.curStreamSei = r100;
    }

    public final void setDescInfo(RenderDescInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.descInfo = r100;
    }

    public final void setDescViewHeight(int r100) {
        this.descViewHeight = r100;
    }

    public final void setExtraAreaIsGame(boolean r100) {
        this.extraAreaIsGame = r100;
    }

    public final void setExtraViewInfo(RenderViewInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraViewInfo = r100;
    }

    public final void setInitLinkMicSeiInfo(String r100) {
        this.initLinkMicSeiInfo = r100;
    }

    public final void setInitSeiInfo(PlayerExtraRenderSeiInfo r100) {
        this.initSeiInfo = r100;
    }

    public final void setLandStyle(boolean r100) {
        this.isLandStyle = r100;
    }

    public final void setLayoutType(int r100) {
        this.layoutType = r100;
    }

    public final void setMainViewInfo(RenderViewInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mainViewInfo = r100;
    }

    public final void setPortrait(boolean r100) {
        this.isPortrait = r100;
    }

    public /* synthetic */ PlayerExtraRenderInfo(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
