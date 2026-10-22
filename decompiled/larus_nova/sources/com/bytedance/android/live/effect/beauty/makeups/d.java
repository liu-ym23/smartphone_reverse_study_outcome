package com.bytedance.android.live.effect.beauty.makeups;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.q;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements com.bytedance.android.live.effect.beauty.makeups.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Sticker> f67344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.live.effect.beauty.makeups.a.b> f67345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67346c;

    public static final class a {
    }

    public static final class b implements k.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f67347a;

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void Z(String r100, Sticker r101) {
        }

        public b(d r100) {
            this.f67347a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void O1(String r100, Sticker r101) {
            String r102 = d0.f66761k;
            if (StringUtils.equal(r102, r100) == false) goto L16;
            if (r101 != null) goto L9;
            Iterator<com.bytedance.android.live.effect.beauty.makeups.a.b> r103 = this.f67347a.f67345b.iterator();
        L7:
            if (r103.hasNext() == false) goto L19;
            r103.next().onError();
            goto L7
        L19:
            return;
        L9:
            d r104 = this.f67347a;
            r104.getClass();
            List<String> r105 = LiveEffectContext.f66734h;
            Sticker r106 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(r104.f67346c).a().o(r102));
            if (r106 == null) goto L12;
            com.bytedance.android.live.effect.beauty.makeups.a.C1110a.a(r104, r106, "updateLocalTagValue_");
        L12:
            Iterator<com.bytedance.android.live.effect.beauty.makeups.a.b> r107 = this.f67347a.f67345b.iterator();
        L14:
            if (r107.hasNext() == false) goto L20;
            r107.next().a(r101);
            goto L14
        L20:
            return;
        }

        @Override // com.bytedance.android.live.effect.api.k.f
        public final void z0(String r100, Sticker r101, ExceptionResult r102) {
            if (StringUtils.equal(d0.f66761k, r100) == false) goto L8;
            Iterator<T> r103 = this.f67347a.f67345b.iterator();
        L6:
            if (r103.hasNext() == false) goto L10;
            ((com.bytedance.android.live.effect.beauty.makeups.a.b) r103.next()).onError();
            goto L6
        L10:
            return;
        }
    }

    static {
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.f67346c;
    }

    public d(LiveEffectContextFactoryDelegate$Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f67346c = r100;
        this.f67344a = new ArrayList();
        this.f67345b = new ArrayList();
    }

    public final void b(LiveMakeupsBeautyFragment.c r100) {
        System.currentTimeMillis();
        e r101 = new e(this, r100);
        List<String> r102 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67346c).b().h().c() == false) goto L5;
        LiveEffectContext.a.a(this.f67346c).b().d().a(d0.f66761k, r101, true, true, false, true);
        return;
    L5:
        LiveEffectContext.a.a(this.f67346c).b().r().p(d0.f66761k, r101, true);
    }

    public final void d(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        List<String> r101 = LiveEffectContext.f66734h;
        if (LiveEffectContext.a.a(this.f67346c).b().r().q(r100) == false) goto L12;
        Sticker r102 = (Sticker) CollectionsKt.firstOrNull(LiveEffectContext.a.a(this.f67346c).a().o(d0.f66761k));
        if (r102 == null) goto L7;
        com.bytedance.android.live.effect.beauty.makeups.a.C1110a.a(this, r102, "updateLocalTagValue_");
    L7:
        Iterator<com.bytedance.android.live.effect.beauty.makeups.a.b> r103 = this.f67345b.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r103.next().a(r100);
        goto L9
    L11:
        return;
    L12:
        LiveEffectContext.a.a(this.f67346c).b().r().g(d0.f66761k, r100, new b(this));
    }

    public final void a(Sticker r100, String r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r101, "trace");
        if (r100 != null) goto L6;
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(this.f67346c).a().b(d0.f66761k, "ttlive_anchor_effect_LiveMakeupsBeautyHelper_changeSelectMakeups_stickerIsNull");
        return;
    L6:
        List<String> r103 = LiveEffectContext.f66734h;
        Iterator<T> r104 = LiveEffectContext.a.a(this.f67346c).a().o(d0.f66761k).iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (((Sticker) r105).getResourceId().equals(r100.getResourceId()) == false) goto L8;
    L14:
        if (((Sticker) r105) != null) goto L23;
        List<String> r106 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r107 = LiveEffectContext.a.a(this.f67346c).a();
        String r108 = d0.f66761k;
        r107.b(r108, "ttlive_anchor_effect_LiveMakeupsBeautyHelper_changeSelectMakeups");
        HashMap r109 = new HashMap();
        if (r110 == false) goto L18;
        r109.put("is_restore", "");
    L18:
        ILiveEffectComposerManager.f.a(LiveEffectContext.a.a(this.f67346c).a(), r108, r100, "ttlive_anchor_effect_LiveMakeupsBeautyHelper_changeSelectMakeups", r109, null, 48);
        Unit r111 = Unit.INSTANCE;
        return;
    L23:
        return;
    L12:
        r105 = null;
        goto L14
    }

    public final void c(String r110, Sticker r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "stickerPanel");
        Intrinsics.checkNotNullParameter(r112, "page");
        Object r100 = null;
        if (Intrinsics.areEqual(r110, d0.f66751a) == false) goto L10;
        List<String> r113 = LiveEffectContext.f66734h;
        Iterator<T> r114 = LiveEffectContext.a.a(this.f67346c).a().o(d0.f66761k).iterator();
    L6:
        if (r114.hasNext() == false) goto L57;
        if ((((Sticker) r114.next()).getStickerFeature() & 1) <= 0) goto L6;
        PthreadHandlerThreadV2 r115 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.j("effect_mutex_type_makeup_by_filter");
        com.bytedance.android.live.effect.beauty.makeups.a.C1110a.a(this, null, "makeupsRepelIfNeed_FILTER_");
        goto L6
    L57:
        return;
    L10:
        String r101 = d0.f66753c;
        if (Intrinsics.areEqual(r110, r101) == false) goto L20;
        List<String> r116 = LiveEffectContext.f66734h;
        Iterator<T> r117 = LiveEffectContext.a.a(this.f67346c).a().o(d0.f66761k).iterator();
    L14:
        if (r117.hasNext() == false) goto L58;
        Sticker r118 = (Sticker) r117.next();
        if (r111 == null) goto L18;
        r111.getStickerFeature();
    L18:
        r118.getStickerFeature();
        goto L14
    L58:
        return;
    L20:
        if (Intrinsics.areEqual(r110, d0.f66761k) == true) goto L22;
        return;
    L22:
        if (r111 == null) goto L24;
        int r102 = r111.getStickerFeature();
    L26:
        if ((r102 & 1) <= 0) goto L28;
        PthreadHandlerThreadV2 r103 = LiveEffectMonitor.f68860a;
        LiveEffectMonitor.j("effect_mutex_type_filter_by_makeup");
        List<String> r104 = LiveEffectContext.f66734h;
        LiveComposerFilterHelper.a(LiveEffectContext.a.a(this.f67346c).b().m(), null, "makeupsRepelIfNeed_MAKEUPS_", r112, false, false, 56);
    L28:
        List<String> r119 = LiveEffectContext.f66734h;
        Iterator<T> r120 = LiveEffectContext.a.a(this.f67346c).a().o(r101).iterator();
    L30:
        if (r120.hasNext() == false) goto L41;
        Object r105 = r120.next();
        Sticker r106 = (Sticker) r105;
        if (r111 == null) goto L34;
        int r107 = r111.getStickerFeature();
    L36:
        if ((r106.getStickerFeature() & r107) <= 0) goto L38;
        boolean r108 = true;
    L39:
        if (r108 == false) goto L30;
        r100 = r105;
        goto L41
    L38:
        r108 = false;
        goto L39
    L34:
        r107 = 0;
    L41:
        Sticker r109 = (Sticker) r100;
        return;
    L24:
        r102 = 0;
        goto L26
    }

    public final void e(Sticker r100, Sticker.ComposerConfig r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r110, "composerConfig");
        List<String> r101 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager.f.d(LiveEffectContext.a.a(this.f67346c).a(), d0.f66761k, r100, r110.getTag(), q.c(r110, r111), null, 48);
    }
}
