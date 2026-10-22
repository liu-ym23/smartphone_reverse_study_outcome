package com.bytedance.android.shopping.commentv3.audio;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/AudioControlAction;", "", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "STOP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AudioControlAction extends Enum<AudioControlAction> {
    public static final AudioControlAction PLAY = null;
    public static final AudioControlAction STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioControlAction[] f172596a = null;

    static {
        AudioControlAction r100 = new AudioControlAction(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0);
        PLAY = r100;
        AudioControlAction r101 = new AudioControlAction("STOP", 1);
        STOP = r101;
        f172596a = new AudioControlAction[]{r100, r101};
    }

    public static AudioControlAction valueOf(String r100) {
        return (AudioControlAction) r27.a.a(AudioControlAction.class, r100);
    }

    public static AudioControlAction[] values() {
        return (AudioControlAction[]) f172596a.clone();
    }

    public AudioControlAction(String r100, int r101) {
        super(r100, r101);
    }
}
