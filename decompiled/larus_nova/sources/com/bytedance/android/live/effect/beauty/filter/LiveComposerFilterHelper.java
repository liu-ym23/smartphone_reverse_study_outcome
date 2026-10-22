package com.bytedance.android.live.effect.beauty.filter;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.live.effect.sticker.presenter.o;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveComposerFilterHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f67269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Sticker> f67270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.android.live.effect.beauty.makeups.a.b> f67271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67272d;

    public static final class a {
    }

    static {
    }

    public final ILiveEffectComposerManager b() {
        return (ILiveEffectComposerManager) this.f67269a.getValue();
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67272d;
    }

    public LiveComposerFilterHelper(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f67272d = r100;
        this.f67269a = LazyKt.lazy(new LiveComposerFilterHelper$composerManager$2(this));
        this.f67270b = new ArrayList();
        this.f67271c = new ArrayList();
    }

    public final int c(Sticker r100, Sticker.ComposerConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "composerConfig");
        Float r102 = b().G(r100.getEffectId(), r101.getTag());
        if (r102 != null) goto L6;
        return r101.getDefaultValue();
    L6:
        return q.a(r101, r102.floatValue());
    }

    public final void d(LiveComposerFilterFragment.c r100, String r110) {
        Intrinsics.checkNotNullParameter(r110, "page");
        e r101 = new e(this, r100, r110);
        List<String> r102 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67272d).b().h().c() == false) goto L5;
        o.a.a(LiveEffectContext.a.a(this.f67272d).b().d(), d0.f66762l, r101, true, true, true, 16);
        return;
    L5:
        LiveEffectContext.a.a(this.f67272d).b().r().p(d0.f66762l, r101, true);
    }

    public static void a(LiveComposerFilterHelper r100, Sticker r101, String r110, String r111, boolean r112, boolean r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r112 = false;
    L6:
        if ((r114 & 16) == 0) goto L8;
        boolean r102 = true;
    L10:
        if ((r114 & 32) == 0) goto L12;
        r113 = false;
    L12:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "trace");
        Intrinsics.checkNotNullParameter(r111, "eventPage");
        HashMap<String, String> r103 = new HashMap();
        if (r102 == false) goto L15;
        r103.put("is_filter_click", "");
    L15:
        if (r113 == false) goto L18;
        r103.put("is_restore", "");
    L18:
        if (r101 != null) goto L20;
        r100.b().k(d0.f66751a, "ttlive_anchor_effect_LiveComposerFilterHelper".concat(r110), r103, r112);
        return;
    L20:
        Iterator<T> r115 = r100.b().o(d0.f66751a).iterator();
    L22:
        if (r115.hasNext() == false) goto L26;
        Object r116 = r115.next();
        if (Intrinsics.areEqual(((Sticker) r116).getResourceId(), r101.getResourceId()) == false) goto L22;
    L28:
        if (((Sticker) r116) != null) goto L35;
        List<String> r117 = LiveEffectContext.f66734h;
        com.bytedance.android.live.effect.beauty.makeups.a r118 = LiveEffectContext.a.a(r100.f67272d).b().f();
        String r104 = d0.f66751a;
        ((com.bytedance.android.live.effect.beauty.makeups.d) r118).c(r104, r101, r111);
        r100.b().t(r104, "ttlive_anchor_effect_LiveComposerFilterHelper".concat(r110), r103);
        ILiveEffectComposerManager.f.a(r100.b(), r104, r101, "ttlive_anchor_effect_LiveComposerFilterHelper".concat(r110), r103, null, 48);
        Unit r105 = Unit.INSTANCE;
        return;
    L35:
        return;
    L26:
        r116 = null;
        goto L28
    L8:
        r102 = false;
        goto L10
    }
}
