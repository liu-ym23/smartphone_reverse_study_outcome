package com.bytedance.android.live.broadcast.stream.capture.effect;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public final class StickerEffectHandler extends ov0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f59222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f59224d;

    public StickerEffectHandler() {
        this.f59221a = LazyKt.lazy(StickerEffectHandler$composerManager$2.INSTANCE);
        this.f59222b = LazyKt.lazy(new StickerEffectHandler$renderFilterEffectMsgListener$2(this));
        this.f59223c = LazyKt.lazy(new StickerEffectHandler$renderFilterFaceDetectListener$2(this));
        this.f59224d = LazyKt.lazy(StickerEffectHandler$renderFilterExpressionDetectListener$2.INSTANCE);
    }
}
