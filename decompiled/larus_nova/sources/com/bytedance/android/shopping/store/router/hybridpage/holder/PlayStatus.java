package com.bytedance.android.shopping.store.router.hybridpage.holder;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/holder/PlayStatus;", "", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "STOP", "PAUSE", "READY", "FINISH", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayStatus extends Enum<PlayStatus> {
    public static final PlayStatus FINISH = null;
    public static final PlayStatus PAUSE = null;
    public static final PlayStatus PLAY = null;
    public static final PlayStatus READY = null;
    public static final PlayStatus STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayStatus[] f185887a = null;
    private final String status;

    static {
        PlayStatus r100 = new PlayStatus(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0, "play");
        PLAY = r100;
        PlayStatus r101 = new PlayStatus("STOP", 1, "stop");
        STOP = r101;
        PlayStatus r102 = new PlayStatus("PAUSE", 2, "pause");
        PAUSE = r102;
        PlayStatus r103 = new PlayStatus("READY", 3, "ready");
        READY = r103;
        PlayStatus r104 = new PlayStatus("FINISH", 4, VideoEventOneOutSync.END_TYPE_FINISH);
        FINISH = r104;
        f185887a = new PlayStatus[]{r100, r101, r102, r103, r104};
    }

    public static PlayStatus valueOf(String r100) {
        return (PlayStatus) r27.a.a(PlayStatus.class, r100);
    }

    public static PlayStatus[] values() {
        return (PlayStatus[]) f185887a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public PlayStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
