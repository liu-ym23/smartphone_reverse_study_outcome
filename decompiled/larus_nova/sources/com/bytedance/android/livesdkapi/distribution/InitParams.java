package com.bytedance.android.livesdkapi.distribution;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u001d\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u001dHÖ\u0001J\t\u00108\u001a\u00020#HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001a\u0010/\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\f¨\u00069"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/InitParams;", "", "scene", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;", "type", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;", "(Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;)V", "enableEnterSplit", "", "getEnableEnterSplit", "()Z", "setEnableEnterSplit", "(Z)V", "enablePreConnect", "getEnablePreConnect", "setEnablePreConnect", "enablePrePrePare", "getEnablePrePrePare", "setEnablePrePrePare", "enableRemoveRoomOpt", "getEnableRemoveRoomOpt", "setEnableRemoveRoomOpt", "liveExternalConfig", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalConfig;", "getLiveExternalConfig", "()Lcom/bytedance/android/livesdkapi/distribution/LiveExternalConfig;", "setLiveExternalConfig", "(Lcom/bytedance/android/livesdkapi/distribution/LiveExternalConfig;)V", "operatorCode", "", "getOperatorCode", "()I", "setOperatorCode", "(I)V", "preloadStage", "", "getPreloadStage", "()Ljava/lang/String;", "setPreloadStage", "(Ljava/lang/String;)V", "getScene", "()Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;", "getType", "()Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;", "useRoomCache", "getUseRoomCache", "setUseRoomCache", "useSimpleRoom", "getUseSimpleRoom", "setUseSimpleRoom", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InitParams {
    private boolean enableEnterSplit;
    private boolean enablePreConnect;
    private boolean enablePrePrePare;
    private boolean enableRemoveRoomOpt;
    private LiveExternalConfig liveExternalConfig;
    private int operatorCode;
    private String preloadStage;
    private final LiveExternalScene scene;
    private final LiveExternalType type;
    private boolean useRoomCache;
    private boolean useSimpleRoom;

    public static /* synthetic */ InitParams copy$default(InitParams r100, LiveExternalScene r101, LiveExternalType r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.scene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        return r100.copy(r101, r102);
    }

    public final LiveExternalScene component1() {
        return this.scene;
    }

    public final LiveExternalType component2() {
        return this.type;
    }

    public final InitParams copy(LiveExternalScene r100, LiveExternalType r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "type");
        return new InitParams(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof InitParams) == false) goto L10;
        InitParams r101 = (InitParams) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        LiveExternalScene r100 = this.scene;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveExternalType r104 = this.type;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "InitParams(scene=" + this.scene + ", type=" + this.type + ")";
    }

    public final boolean getEnableEnterSplit() {
        return this.enableEnterSplit;
    }

    public final boolean getEnablePreConnect() {
        return this.enablePreConnect;
    }

    public final boolean getEnablePrePrePare() {
        return this.enablePrePrePare;
    }

    public final boolean getEnableRemoveRoomOpt() {
        return this.enableRemoveRoomOpt;
    }

    public final LiveExternalConfig getLiveExternalConfig() {
        return this.liveExternalConfig;
    }

    public final int getOperatorCode() {
        return this.operatorCode;
    }

    public final String getPreloadStage() {
        return this.preloadStage;
    }

    public final LiveExternalScene getScene() {
        return this.scene;
    }

    public final LiveExternalType getType() {
        return this.type;
    }

    public final boolean getUseRoomCache() {
        return this.useRoomCache;
    }

    public final boolean getUseSimpleRoom() {
        return this.useSimpleRoom;
    }

    public final void setEnableEnterSplit(boolean r100) {
        this.enableEnterSplit = r100;
    }

    public final void setEnablePreConnect(boolean r100) {
        this.enablePreConnect = r100;
    }

    public final void setEnablePrePrePare(boolean r100) {
        this.enablePrePrePare = r100;
    }

    public final void setEnableRemoveRoomOpt(boolean r100) {
        this.enableRemoveRoomOpt = r100;
    }

    public final void setLiveExternalConfig(LiveExternalConfig r100) {
        this.liveExternalConfig = r100;
    }

    public final void setOperatorCode(int r100) {
        this.operatorCode = r100;
    }

    public final void setPreloadStage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.preloadStage = r100;
    }

    public final void setUseRoomCache(boolean r100) {
        this.useRoomCache = r100;
    }

    public final void setUseSimpleRoom(boolean r100) {
        this.useSimpleRoom = r100;
    }

    public InitParams(LiveExternalScene r100, LiveExternalType r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.scene = r100;
        this.type = r101;
        this.preloadStage = "all";
        this.operatorCode = -1;
    }
}
