package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00102\u001a\u00020\u0019H\u0016J\b\u00103\u001a\u00020+H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderSeiInfo;", "", "()V", "cameraAreaInfo", "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "getCameraAreaInfo", "()Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "setCameraAreaInfo", "(Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;)V", "cameraCustomAreaInfo", "getCameraCustomAreaInfo", "setCameraCustomAreaInfo", "cameraHidden", "", "getCameraHidden", "()Z", "setCameraHidden", "(Z)V", "cameraHorizontalHidden", "getCameraHorizontalHidden", "setCameraHorizontalHidden", "cameraHorizontalPosition", "getCameraHorizontalPosition", "setCameraHorizontalPosition", "cameraHorizontalType", "", "getCameraHorizontalType", "()I", "setCameraHorizontalType", "(I)V", "cameraVerticalType", "getCameraVerticalType", "setCameraVerticalType", "displayMode", "getDisplayMode", "setDisplayMode", "gameAreaInfo", "getGameAreaInfo", "setGameAreaInfo", "gameHidden", "getGameHidden", "setGameHidden", "gameRoomId", "", "getGameRoomId", "()Ljava/lang/String;", "setGameRoomId", "(Ljava/lang/String;)V", "equals", "other", "hashCode", "toString", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerExtraRenderSeiInfo {
    public static final int CAMERA_HORIZONTAL_DEFAULT = 0;
    public static final int CAMERA_HORIZONTAL_MODE_FILL = 2;
    public static final int CAMERA_HORIZONTAL_MODE_WINDOW = 1;
    public static final int CAMERA_VERTICAL_MODE_FILL = 1;
    public static final int CAMERA_VERTICAL_MODE_WINDOW = 0;
    public static final Companion Companion = null;
    public static final int DISPLAY_MODE_CAMERA = 1;
    public static final int DISPLAY_MODE_GAME = 0;
    private RenderAreaInfo cameraAreaInfo;
    private RenderAreaInfo cameraCustomAreaInfo;
    private boolean cameraHidden;
    private boolean cameraHorizontalHidden;
    private RenderAreaInfo cameraHorizontalPosition;
    private int cameraHorizontalType;
    private int cameraVerticalType;
    private int displayMode;
    private RenderAreaInfo gameAreaInfo;
    private boolean gameHidden;
    private String gameRoomId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerExtraRenderSeiInfo$Companion;", "", "()V", "CAMERA_HORIZONTAL_DEFAULT", "", "CAMERA_HORIZONTAL_MODE_FILL", "CAMERA_HORIZONTAL_MODE_WINDOW", "CAMERA_VERTICAL_MODE_FILL", "CAMERA_VERTICAL_MODE_WINDOW", "DISPLAY_MODE_CAMERA", "DISPLAY_MODE_GAME", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public int hashCode() {
        RenderAreaInfo r100 = this.gameAreaInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RenderAreaInfo r104 = this.cameraAreaInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.cameraHidden == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.gameHidden == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (((((r109 + r110) * 31) + this.displayMode) * 31) + this.gameRoomId.hashCode()) * 31;
        RenderAreaInfo r112 = this.cameraCustomAreaInfo;
        if (r112 == null) goto L21;
        int r113 = r112.hashCode();
    L22:
        int r114 = (((r111 + r113) * 31) + this.cameraVerticalType) * 31;
        if (this.cameraHorizontalHidden == true) goto L26;
        r107 = 1237;
    L26:
        int r115 = (((r114 + r107) * 31) + this.cameraHorizontalType) * 31;
        RenderAreaInfo r116 = this.cameraHorizontalPosition;
        if (r116 == null) goto L30;
        r101 = r116.hashCode();
    L30:
        return r115 + r101;
    L21:
        r113 = 0;
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlayerExtraRenderSeiInfo(gameAreaInfo=" + this.gameAreaInfo + ", cameraAreaInfo=" + this.cameraAreaInfo + ", cameraHidden=" + this.cameraHidden + ", gameHidden=" + this.gameHidden + ", displayMode=" + this.displayMode + ", gameRoomId='" + this.gameRoomId + "', cameraCustomAreaInfo=" + this.cameraCustomAreaInfo + ", cameraVerticalType=" + this.cameraVerticalType + ", cameraHorizontalHidden=" + this.cameraHorizontalHidden + ", cameraHorizontalType=" + this.cameraHorizontalType + ", cameraHorizontalPosition=" + this.cameraHorizontalPosition + ')';
    }

    public PlayerExtraRenderSeiInfo() {
        this.gameAreaInfo = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        this.cameraAreaInfo = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        this.gameRoomId = "";
        this.cameraCustomAreaInfo = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        this.cameraHorizontalPosition = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public final RenderAreaInfo getCameraAreaInfo() {
        return this.cameraAreaInfo;
    }

    public final RenderAreaInfo getCameraCustomAreaInfo() {
        return this.cameraCustomAreaInfo;
    }

    public final boolean getCameraHidden() {
        return this.cameraHidden;
    }

    public final boolean getCameraHorizontalHidden() {
        return this.cameraHorizontalHidden;
    }

    public final RenderAreaInfo getCameraHorizontalPosition() {
        return this.cameraHorizontalPosition;
    }

    public final int getCameraHorizontalType() {
        return this.cameraHorizontalType;
    }

    public final int getCameraVerticalType() {
        return this.cameraVerticalType;
    }

    public final int getDisplayMode() {
        return this.displayMode;
    }

    public final RenderAreaInfo getGameAreaInfo() {
        return this.gameAreaInfo;
    }

    public final boolean getGameHidden() {
        return this.gameHidden;
    }

    public final String getGameRoomId() {
        return this.gameRoomId;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(PlayerExtraRenderSeiInfo.class, r101)) == false) goto L13;
        return false;
    L13:
        if ((r100 instanceof PlayerExtraRenderSeiInfo) == true) goto L15;
        return false;
    L15:
        PlayerExtraRenderSeiInfo r102 = (PlayerExtraRenderSeiInfo) r100;
        if ((!Intrinsics.areEqual(this.gameAreaInfo, r102.gameAreaInfo)) == false) goto L19;
        return false;
    L19:
        if ((!Intrinsics.areEqual(this.cameraAreaInfo, r102.cameraAreaInfo)) == false) goto L22;
        return false;
    L22:
        if (this.cameraHidden == r102.cameraHidden) goto L25;
        return false;
    L25:
        if (this.gameHidden == r102.gameHidden) goto L28;
        return false;
    L28:
        if (this.displayMode == r102.displayMode) goto L31;
        return false;
    L31:
        if ((!Intrinsics.areEqual(this.gameRoomId, r102.gameRoomId)) == false) goto L34;
        return false;
    L34:
        if ((!Intrinsics.areEqual(this.cameraCustomAreaInfo, r102.cameraCustomAreaInfo)) == false) goto L37;
        return false;
    L37:
        if (this.cameraVerticalType == r102.cameraVerticalType) goto L40;
        return false;
    L40:
        if (this.cameraHorizontalHidden == r102.cameraHorizontalHidden) goto L43;
        return false;
    L43:
        if (this.cameraHorizontalType == r102.cameraHorizontalType) goto L46;
        return false;
    L46:
        if ((!Intrinsics.areEqual(this.cameraHorizontalPosition, r102.cameraHorizontalPosition)) == false) goto L48;
        return false;
    L48:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCameraAreaInfo(RenderAreaInfo r100) {
        this.cameraAreaInfo = r100;
    }

    public final void setCameraCustomAreaInfo(RenderAreaInfo r100) {
        this.cameraCustomAreaInfo = r100;
    }

    public final void setCameraHidden(boolean r100) {
        this.cameraHidden = r100;
    }

    public final void setCameraHorizontalHidden(boolean r100) {
        this.cameraHorizontalHidden = r100;
    }

    public final void setCameraHorizontalPosition(RenderAreaInfo r100) {
        this.cameraHorizontalPosition = r100;
    }

    public final void setCameraHorizontalType(int r100) {
        this.cameraHorizontalType = r100;
    }

    public final void setCameraVerticalType(int r100) {
        this.cameraVerticalType = r100;
    }

    public final void setDisplayMode(int r100) {
        this.displayMode = r100;
    }

    public final void setGameAreaInfo(RenderAreaInfo r100) {
        this.gameAreaInfo = r100;
    }

    public final void setGameHidden(boolean r100) {
        this.gameHidden = r100;
    }

    public final void setGameRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameRoomId = r100;
    }
}
