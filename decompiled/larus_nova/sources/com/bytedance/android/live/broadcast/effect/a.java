package com.bytedance.android.live.broadcast.effect;

import com.bytedance.android.live.broadcast.stream.capture.effect.StickerEffectHandler;
import com.bytedance.android.live.effect.api.t;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StickerEffectHandler f59145a;

    @Override // com.bytedance.android.live.effect.api.t
    public final int a() {
        this.f59145a.getClass();
        return -1000;
    }

    public a(StickerEffectHandler r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStickerEffect");
        this.f59145a = r100;
    }
}
