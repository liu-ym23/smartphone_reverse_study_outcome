package com.bytedance.android.live.effect.common;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f67845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f67846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Sticker> f67847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67848d;

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67848d;
    }

    public a(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter("live_camera_move", "panel");
        this.f67848d = r100;
        this.f67845a = LazyKt.lazy(new AbsLiveStickerCommonPresenter$composerManager$2(this));
        this.f67846b = LazyKt.lazy(new AbsLiveStickerCommonPresenter$stickerDownloadHelper$2(this));
        this.f67847c = new ArrayList();
    }
}
