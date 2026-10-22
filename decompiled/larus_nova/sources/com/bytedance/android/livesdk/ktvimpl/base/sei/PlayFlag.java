package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/PlayFlag;", "", EffectConstants.NORMAL, "PREVIEW_SONG", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayFlag extends Enum<PlayFlag> {
    public static final PlayFlag NORMAL = null;
    public static final PlayFlag PREVIEW_SONG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayFlag[] f143302a = null;

    static {
        PlayFlag r100 = new PlayFlag(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        PlayFlag r101 = new PlayFlag("PREVIEW_SONG", 1);
        PREVIEW_SONG = r101;
        f143302a = new PlayFlag[]{r100, r101};
    }

    public static PlayFlag valueOf(String r100) {
        return (PlayFlag) r27.a.a(PlayFlag.class, r100);
    }

    public static PlayFlag[] values() {
        return (PlayFlag[]) f143302a.clone();
    }

    public PlayFlag(String r100, int r101) {
        super(r100, r101);
    }
}
