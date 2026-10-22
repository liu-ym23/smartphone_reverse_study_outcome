package com.bytedance.android.live.effect.beauty;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.composer.n;
import com.bytedance.android.live.effect.utils.LiveAnchorBeautifyLogHelper;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements ILiveEffectComposerManager.e, ILiveEffectComposerManager.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LiveAnchorBeautifyLogHelper> f67211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67212b;

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67212b;
    }

    public d(String r100, LiveEffectContextFactoryDelegate$Type r101) {
        Intrinsics.checkNotNullParameter(r100, "eventPage");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f67212b = r101;
        this.f67211a = CollectionsKt.listOf(new LiveAnchorBeautifyLogHelper[]{new LiveAnchorBeautifyLogHelper(d0.f66759i, r100, r101), new LiveAnchorBeautifyLogHelper(d0.f66751a, r100, r101), new LiveAnchorBeautifyLogHelper(d0.f66761k, r100, r101), new LiveAnchorBeautifyLogHelper("livebody", r100, r101), new LiveAnchorBeautifyLogHelper("live_adjustment", r100, r101), new LiveAnchorBeautifyLogHelper("live_camera_move", r100, r101)});
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void a(String r100, Sticker r101) {
        e(r100, r101);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.k
    public final void c(List<n> r100, Map<String, ? extends List<Sticker>> r101) {
        Intrinsics.checkNotNullParameter(r100, "sortList");
        Intrinsics.checkNotNullParameter(r101, "allStickerList");
        Intrinsics.checkNotNullParameter(r100, "sortList");
        Intrinsics.checkNotNullParameter(r101, "allStickerList");
        Intrinsics.checkNotNullParameter(r100, "sortList");
        Intrinsics.checkNotNullParameter(r101, "allStickerList");
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void e(String r100, Sticker r101) {
        Iterator<T> r102 = this.f67211a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((LiveAnchorBeautifyLogHelper) r102.next()).getClass();
        goto L4
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void b(boolean r100, String r101, Sticker r102) {
        d(r100, r101, r102, null);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r100, Sticker r101, String r102, float r103) {
        ILiveEffectComposerManager.c.a.a(this, r100, r101, r102, r103);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.e
    public final void d(boolean r100, String r101, Sticker r102, HashMap<String, String> r103) {
        Iterator<T> r104 = this.f67211a.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((LiveAnchorBeautifyLogHelper) r104.next()).d(r100, r101, r102, r103);
        goto L4
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r100, Sticker r110, String r111, float r112, HashMap<String, String> r113) {
        Iterator<T> r101 = this.f67211a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((LiveAnchorBeautifyLogHelper) r101.next()).u2(r100, r110, r111, r112, r113);
        goto L4
    }
}
