package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.effect.soundeffect.LiveSoundAdapter;
import com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import io.reactivex.SingleEmitter;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l1 implements LiveSoundEffectHelper.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSoundEffectHelper f142151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SingleEmitter f142152b;

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void x1(int r100, LiveSoundAdapter.ViewHolder r101) {
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void onError() {
        this.f142152b.onSuccess(TuplesKt.to(1, "download failed"));
    }

    @Override // com.bytedance.android.live.effect.soundeffect.LiveSoundEffectHelper.b
    public final void a(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        this.f142151a.b(r100, true, false);
        this.f142152b.onSuccess(TuplesKt.to(0, "success"));
    }

    public l1(LiveSoundEffectHelper r100, SingleEmitter r101) {
        this.f142151a = r100;
        this.f142152b = r101;
    }
}
