package com.bytedance.android.livesdk.player.layout;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.TranslationAndScaleProperty;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class DefaultLivePlayerLayoutManager implements com.bytedance.android.live.platformplayer.layout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.platformplayer.layout.c f155416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f155417b;

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final boolean c(String r100, com.bytedance.android.live.platformplayer.layout.f r101) {
        Intrinsics.checkNotNullParameter(r101, "layoutContext");
        return true;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final String d() {
        return "default";
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void e() {
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void reset() {
        this.f155416a = null;
    }

    public DefaultLivePlayerLayoutManager() {
        this.f155417b = LazyKt.lazy(DefaultLivePlayerLayoutManager$translationAndScaleOpt$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void b(com.bytedance.android.live.platformplayer.layout.c r100) {
        Intrinsics.checkNotNullParameter(r100, "playPosition");
        this.f155416a = r100;
    }

    @Override // com.bytedance.android.live.platformplayer.layout.b
    public final void a(String r100, com.bytedance.android.live.platformplayer.layout.f r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "layoutContext");
        Intrinsics.checkNotNullParameter(r111, "from");
        Function1<? super com.bytedance.android.live.platformplayer.layout.e, Unit> r101 = r110.f85627r;
        if (r101 == null) goto L5;
        Unit r102 = r101.invoke(new com.bytedance.android.live.platformplayer.layout.e());
    L5:
        com.bytedance.android.live.platformplayer.layout.c r103 = this.f155416a;
        if (r103 == null) goto L38;
        r103.setWidth(-1);
        r103.setHeight(-1);
        int r104 = r110.f85616g;
        int r105 = 1;
        int r106 = 0;
        if (r104 != (-1)) goto L10;
    L12:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L25;
        if (r110.f85613d == true) goto L18;
        int r108 = 0;
    L28:
        r105 = 17;
    L30:
        if (r110.f85613d == false) goto L32;
    L36:
        r103.setScaleType(r108);
        r103.setGravity(r105);
        r103.f(r106);
        r103.requestLayout(r111);
        return;
    L32:
        if (((Boolean) this.f155417b.getValue()).booleanValue() == false) goto L36;
        TranslationAndScaleProperty r112 = r110.f85633x;
        if (r112 == null) goto L36;
        r103.setTranslationX(r112.getTranslationX());
        r103.setTranslationY(r112.getTranslationY());
        r103.setScaleX(r112.getScaleX());
        r103.setScaleY(r112.getScaleY());
        goto L36
    L18:
        if (r104 <= r110.f85617h) goto L20;
        boolean r109 = true;
    L21:
        if (r109 == false) goto L27;
        r106 = r110.f85626q;
    L26:
        r108 = 0;
    L27:
        r108 = 2;
        goto L28
    L20:
        r109 = false;
        goto L21
    L25:
        if (r110.f85613d == true) goto L27;
    L10:
        if (r110.f85617h == (-1)) goto L12;
        r107 = true;
        goto L14
    }
}
