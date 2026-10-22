package com.bytedance.android.ec.store.utils;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/store/utils/SoundState;", "", "", "isMute", "Z", "()Z", "MUTE", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SoundState extends Enum<SoundState> {
    public static final SoundState MUTE = null;
    public static final SoundState PLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SoundState[] f48661a = null;
    private final boolean isMute;

    static {
        SoundState r100 = new SoundState("MUTE", 0, true);
        MUTE = r100;
        SoundState r101 = new SoundState(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 1, false);
        PLAY = r101;
        f48661a = new SoundState[]{r100, r101};
    }

    public static SoundState valueOf(String r100) {
        return (SoundState) r27.a.a(SoundState.class, r100);
    }

    public static SoundState[] values() {
        return (SoundState[]) f48661a.clone();
    }

    public final boolean isMute() {
        return this.isMute;
    }

    public SoundState(String r100, int r101, boolean r102) {
        super(r100, r101);
        this.isMute = r102;
    }
}
