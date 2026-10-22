package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo;", "", "gameAreaInfo", "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "cameraAreaInfo", "cameraHorizontalPosition", "cameraHorizontalType", "", "cameraHidden", "", "(Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;IZ)V", "getCameraAreaInfo", "()Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "setCameraAreaInfo", "(Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;)V", "getCameraHidden", "()Z", "setCameraHidden", "(Z)V", "getCameraHorizontalPosition", "setCameraHorizontalPosition", "getCameraHorizontalType", "()I", "setCameraHorizontalType", "(I)V", "getGameAreaInfo", "setGameAreaInfo", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerGameExtraRenderSeiInfo {
    public static final int CAMERA_HORIZONTAL_DEFAULT = 0;
    public static final int CAMERA_HORIZONTAL_MODE_FILL = 2;
    public static final int CAMERA_HORIZONTAL_MODE_WINDOW = 1;
    public static final Companion Companion = null;
    private RenderAreaInfo cameraAreaInfo;
    private boolean cameraHidden;
    private RenderAreaInfo cameraHorizontalPosition;
    private int cameraHorizontalType;
    private RenderAreaInfo gameAreaInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerGameExtraRenderSeiInfo$Companion;", "", "()V", "CAMERA_HORIZONTAL_DEFAULT", "", "CAMERA_HORIZONTAL_MODE_FILL", "CAMERA_HORIZONTAL_MODE_WINDOW", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public PlayerGameExtraRenderSeiInfo() {
        this(null, null, null, 0, false, 31, null);
    }

    public static /* synthetic */ PlayerGameExtraRenderSeiInfo copy$default(PlayerGameExtraRenderSeiInfo r100, RenderAreaInfo r101, RenderAreaInfo r102, RenderAreaInfo r103, int r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.gameAreaInfo;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.cameraAreaInfo;
    L8:
        RenderAreaInfo r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cameraHorizontalPosition;
    L11:
        RenderAreaInfo r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.cameraHorizontalType;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.cameraHidden;
    L17:
        RenderAreaInfo r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final RenderAreaInfo component1() {
        return this.gameAreaInfo;
    }

    public final RenderAreaInfo component2() {
        return this.cameraAreaInfo;
    }

    public final RenderAreaInfo component3() {
        return this.cameraHorizontalPosition;
    }

    public final int component4() {
        return this.cameraHorizontalType;
    }

    public final boolean component5() {
        return this.cameraHidden;
    }

    public final PlayerGameExtraRenderSeiInfo copy(RenderAreaInfo r100, RenderAreaInfo r101, RenderAreaInfo r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "gameAreaInfo");
        Intrinsics.checkNotNullParameter(r101, "cameraAreaInfo");
        return new PlayerGameExtraRenderSeiInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerGameExtraRenderSeiInfo) == false) goto L16;
        PlayerGameExtraRenderSeiInfo r101 = (PlayerGameExtraRenderSeiInfo) r100;
        if (Intrinsics.areEqual(this.gameAreaInfo, r101.gameAreaInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cameraAreaInfo, r101.cameraAreaInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cameraHorizontalPosition, r101.cameraHorizontalPosition) == true) goto L12;
        return false;
    L12:
        if (this.cameraHorizontalType == r101.cameraHorizontalType) goto L14;
        return false;
    L14:
        if (this.cameraHidden == r101.cameraHidden) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
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
        RenderAreaInfo r107 = this.cameraHorizontalPosition;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (((r106 + r101) * 31) + this.cameraHorizontalType) * 31;
        boolean r109 = this.cameraHidden;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlayerGameExtraRenderSeiInfo(gameAreaInfo=" + this.gameAreaInfo + ", cameraAreaInfo=" + this.cameraAreaInfo + ", cameraHorizontalPosition=" + this.cameraHorizontalPosition + ", cameraHorizontalType=" + this.cameraHorizontalType + ", cameraHidden=" + this.cameraHidden + ")";
    }

    public final RenderAreaInfo getCameraAreaInfo() {
        return this.cameraAreaInfo;
    }

    public final boolean getCameraHidden() {
        return this.cameraHidden;
    }

    public final RenderAreaInfo getCameraHorizontalPosition() {
        return this.cameraHorizontalPosition;
    }

    public final int getCameraHorizontalType() {
        return this.cameraHorizontalType;
    }

    public final RenderAreaInfo getGameAreaInfo() {
        return this.gameAreaInfo;
    }

    public final void setCameraAreaInfo(RenderAreaInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cameraAreaInfo = r100;
    }

    public final void setCameraHidden(boolean r100) {
        this.cameraHidden = r100;
    }

    public final void setCameraHorizontalPosition(RenderAreaInfo r100) {
        this.cameraHorizontalPosition = r100;
    }

    public final void setCameraHorizontalType(int r100) {
        this.cameraHorizontalType = r100;
    }

    public final void setGameAreaInfo(RenderAreaInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.gameAreaInfo = r100;
    }

    public PlayerGameExtraRenderSeiInfo(RenderAreaInfo r100, RenderAreaInfo r101, RenderAreaInfo r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "gameAreaInfo");
        Intrinsics.checkNotNullParameter(r101, "cameraAreaInfo");
        this.gameAreaInfo = r100;
        this.cameraAreaInfo = r101;
        this.cameraHorizontalPosition = r102;
        this.cameraHorizontalType = r103;
        this.cameraHidden = r104;
    }

    public /* synthetic */ PlayerGameExtraRenderSeiInfo(RenderAreaInfo r100, RenderAreaInfo r101, RenderAreaInfo r110, int r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r100 = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    L6:
        if ((r113 & 2) == 0) goto L8;
        r101 = new RenderAreaInfo(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    L8:
        RenderAreaInfo r115 = r101;
        if ((r113 & 4) == 0) goto L11;
        r110 = null;
    L11:
        RenderAreaInfo r102 = r110;
        if ((r113 & 8) == 0) goto L14;
        int r103 = 0;
    L16:
        if ((r113 & 16) == 0) goto L18;
        boolean r104 = false;
    L19:
        this(r100, r115, r102, r103, r104);
        return;
    L18:
        r104 = r112;
        goto L19
    L14:
        r103 = r111;
        goto L16
    }
}
