package com.bytedance.android.livesdkapi.distribution;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdkapi/distribution/LiveExternalConfig;", "", "scene", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;", "playerScene", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "commonParams", "", "", "(Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;Ljava/util/Map;)V", "getCommonParams", "()Ljava/util/Map;", "setCommonParams", "(Ljava/util/Map;)V", "feedRoomConfig", "Lcom/bytedance/android/livesdkapi/distribution/ExternalConfigDetail;", "getFeedRoomConfig", "()Lcom/bytedance/android/livesdkapi/distribution/ExternalConfigDetail;", "setFeedRoomConfig", "(Lcom/bytedance/android/livesdkapi/distribution/ExternalConfigDetail;)V", "fisrtRoomConfig", "getFisrtRoomConfig", "setFisrtRoomConfig", "liveExternalType", "Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;", "getLiveExternalType", "()Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;", "setLiveExternalType", "(Lcom/bytedance/android/livesdkapi/distribution/LiveExternalType;)V", "getPlayerScene", "()Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "getScene", "()Lcom/bytedance/android/livesdkapi/distribution/LiveExternalScene;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveExternalConfig {
    private Map<String, String> commonParams;
    private ExternalConfigDetail feedRoomConfig;
    private ExternalConfigDetail fisrtRoomConfig;
    private LiveExternalType liveExternalType;
    private final ILivePlayerScene playerScene;
    private final LiveExternalScene scene;

    public final Map<String, String> getCommonParams() {
        return this.commonParams;
    }

    public final ExternalConfigDetail getFeedRoomConfig() {
        return this.feedRoomConfig;
    }

    public final ExternalConfigDetail getFisrtRoomConfig() {
        return this.fisrtRoomConfig;
    }

    public final LiveExternalType getLiveExternalType() {
        return this.liveExternalType;
    }

    public final ILivePlayerScene getPlayerScene() {
        return this.playerScene;
    }

    public final LiveExternalScene getScene() {
        return this.scene;
    }

    public final void setCommonParams(Map<String, String> r100) {
        this.commonParams = r100;
    }

    public final void setFeedRoomConfig(ExternalConfigDetail r100) {
        this.feedRoomConfig = r100;
    }

    public final void setFisrtRoomConfig(ExternalConfigDetail r100) {
        this.fisrtRoomConfig = r100;
    }

    public final void setLiveExternalType(LiveExternalType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveExternalType = r100;
    }

    public LiveExternalConfig(LiveExternalScene r100, ILivePlayerScene r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.scene = r100;
        this.playerScene = r101;
        this.commonParams = r102;
        this.liveExternalType = LiveExternalType.Single;
    }

    public /* synthetic */ LiveExternalConfig(LiveExternalScene r100, ILivePlayerScene r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
