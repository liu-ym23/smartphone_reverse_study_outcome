package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f68212a;

    public n(k r100) {
        this.f68212a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        ALogger.i("ttlive_anchor_effect_MultiAnchorEffectHelper", "getData failed,roomId=" + this.f68212a.f68207g);
    }
}
