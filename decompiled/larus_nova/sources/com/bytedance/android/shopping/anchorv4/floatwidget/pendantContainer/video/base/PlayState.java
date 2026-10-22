package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.base;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/pendantContainer/video/base/PlayState;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "STOP", "ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayState extends Enum<PlayState> {
    public static final PlayState ERROR = null;
    public static final PlayState PAUSE = null;
    public static final PlayState PLAY = null;
    public static final PlayState STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayState[] f166806a = null;
    private final String value;

    static {
        PlayState r100 = new PlayState(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0, "play");
        PLAY = r100;
        PlayState r101 = new PlayState("PAUSE", 1, "pause");
        PAUSE = r101;
        PlayState r102 = new PlayState("STOP", 2, "stop");
        STOP = r102;
        PlayState r103 = new PlayState("ERROR", 3, "error");
        ERROR = r103;
        f166806a = new PlayState[]{r100, r101, r102, r103};
    }

    public static PlayState valueOf(String r100) {
        return (PlayState) a.a(PlayState.class, r100);
    }

    public static PlayState[] values() {
        return (PlayState[]) f166806a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public PlayState(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
