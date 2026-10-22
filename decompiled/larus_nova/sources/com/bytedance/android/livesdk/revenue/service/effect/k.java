package com.bytedance.android.livesdk.revenue.service.effect;

import com.bytedance.android.live.core.resources.AssetsModel;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.gift.GiftEffectResourceServiceHolder;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.k3;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.w3;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k implements com.bytedance.android.scope.o, c {

    public static final class a implements com.bytedance.android.live.effect.api.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yp2.a f157305a;

        @Override // com.bytedance.android.live.effect.api.a
        public final void onSuccess() {
            yp2.a r100 = this.f157305a;
            if (r100 == null) goto L6;
            r100.onSuccess();
            return;
        }

        public a(yp2.a r100) {
            this.f157305a = r100;
        }

        @Override // com.bytedance.android.live.effect.api.a
        public final void onFailure(Exception r100) {
            yp2.a r101 = this.f157305a;
            if (r101 == null) goto L6;
            r101.onFailure(r100);
            return;
        }
    }

    public static final class b implements com.bytedance.android.live.effect.utils.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f157306a;

        public b(f r100) {
            this.f157306a = r100;
        }

        @Override // com.bytedance.android.live.effect.utils.f.a
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            f r101 = this.f157306a;
            if (r101 == null) goto L6;
            r101.a(new yp2.c(r100));
            return;
        }

        @Override // com.bytedance.android.live.effect.utils.f.a
        public final void b(ExceptionResult r100) {
            f r101 = this.f157306a;
            if (r101 == null) goto L8;
            if (r100 == null) goto L6;
            r100.getMsg();
        L6:
            r101.onError();
            return;
        }
    }

    public k() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final boolean N2() {
        Lazy r100 = GiftEffectResourceServiceHolder.f68022a;
        if (GiftEffectResourceServiceHolder.a.a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void providerResourceFinder() {
        int r100 = com.bytedance.android.live.effect.a.f66704a;
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r101 = ILiveWrappedEffectSDKService.a.a();
        if (r101 == null) goto L6;
        r101.providerResourceFinder();
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void D8() {
        Intrinsics.checkNotNullParameter("_Interact_preview", "trace");
        List<String> r100 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().b("effect_gift", "_Interact_preview");
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final yp2.c Hk(com.bytedance.android.livesdk.gift.platform.core.preview.e r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Sticker r101 = new Sticker();
        r101.setId(r100.f130996b);
        r101.setUnzipPath(r100.b());
        r101.setStickerPanel("effect_gift");
        r101.setHighCost(r100.c());
        Unit r102 = Unit.INSTANCE;
        return new yp2.c(r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final Single Y7(i r100) {
        Intrinsics.checkNotNullParameter(r100, "effect");
        Object r101 = r100.f157303a;
        if ((r101 instanceof Effect) == true) goto L5;
        r101 = null;
    L5:
        Effect r102 = (Effect) r101;
        if (r102 != null) goto L8;
        return null;
    L8:
        return com.bytedance.android.live.effect.sticker.d.c(r102).map(j.f157304a);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final List<yp2.b> f4(RevStickerPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        String r101 = o.a(r100);
        if (r101 == null) goto L5;
        ArrayList r102 = new ArrayList();
        List<String> r103 = LiveEffectContext.f66734h;
        Iterator<Sticker> r104 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(r101).iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r102.add(new yp2.c(r104.next()));
        goto L8
    L10:
        return r102;
    L5:
        return new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final boolean he(com.bytedance.android.live.core.resources.e r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if ((r100 instanceof AssetsModel) == true) goto L8;
        AssetsModel r101 = new AssetsModel();
        r101.setId(r100.getId());
        r101.setResourceType(r100.getResourceType());
        r101.setResourceType(r100.getResourceType());
        r101.setResourceModel(r100.getResourceModel());
        r101.setLokiExtra(r100.getLokiExtra());
        r101.setMD5(r100.getMD5());
        Lazy r102 = GiftEffectResourceServiceHolder.f68022a;
        com.bytedance.android.live.effect.gift.e r103 = GiftEffectResourceServiceHolder.a.a();
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.c(r101);
    L8:
        Lazy r104 = GiftEffectResourceServiceHolder.f68022a;
        com.bytedance.android.live.effect.gift.e r105 = GiftEffectResourceServiceHolder.a.a();
        if (r105 != null) goto L11;
        return false;
    L11:
        return r105.c((AssetsModel) r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final List<yp2.b> lk(List<? extends com.bytedance.android.livesdk.revenue.service.effect.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "effectList");
        ArrayList r101 = new ArrayList();
        Iterator<? extends com.bytedance.android.livesdk.revenue.service.effect.b> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next().getImpl();
        if ((r103 instanceof Effect) == true) goto L8;
        r103 = null;
    L8:
        Effect r104 = (Effect) r103;
        if (r104 == null) goto L4;
        r101.add(new yp2.c(com.bytedance.android.live.effect.sticker.d.b(r104)));
        goto L4
    L11:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void Bn(yp2.b r100, RevStickerPanel r101) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter("_astmosphere_effect", "trace");
        if (r101 == null) goto L5;
        String r102 = o.a(r101);
    L6:
        if (r102 == null) goto L9;
        String r103 = o.a(r101);
    L12:
        if (r103 == null) goto L15;
        List<String> r104 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().O(r103, ((yp2.c) r100).f568698a, "_astmosphere_effect");
        return;
    L15:
        return;
    L9:
        if (r100.a() == null) goto L11;
        r103 = r100.a();
        goto L12
    L11:
        r103 = d0.f66753c;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void U9(List r100, k3 r101) {
        Intrinsics.checkNotNullParameter(r100, "effectIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if ((!r100.isEmpty()) == false) goto L6;
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().j(r100, new m(r101));
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void h2(String r100, w3 r101) {
        Intrinsics.checkNotNullParameter(r100, "effectId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        List<String> r102 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).b().r().d(r100, new l(r101));
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void Bj(List<String> r100, Map<String, ? extends List<String>> r101, yp2.a r102) {
        Lazy r103 = GiftEffectResourceServiceHolder.f68022a;
        com.bytedance.android.live.effect.gift.e r104 = GiftEffectResourceServiceHolder.a.a();
        if (r104 == null) goto L6;
        r104.a(r100, r101, new a(r102));
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void nm(yp2.b r100, String r101, RevStickerPanel r102) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        Intrinsics.checkNotNullParameter(r101, "trace");
        if (r102 == null) goto L5;
        String r103 = o.a(r102);
    L6:
        if (r103 == null) goto L9;
        String r104 = o.a(r102);
    L12:
        if (r104 == null) goto L18;
        List<String> r105 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r106 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a();
        if (r100 == null) goto L17;
        r106.a(r104, ((yp2.c) r100).f568698a, r101);
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.effect.RevStickerImpl");
    L18:
        return;
    L9:
        if (r100.a() == null) goto L11;
        r104 = r100.a();
        goto L12
    L11:
        r104 = d0.f66753c;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.revenue.service.effect.c
    public final void wd(RevStickerPanel r100, yp2.b r101, f r102, Function1<? super Integer, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Intrinsics.checkNotNullParameter(r101, "sticker");
        Intrinsics.checkNotNullParameter(r103, "processAction");
        String r104 = o.a(r100);
        if (r104 != null) goto L5;
        return;
    L5:
        int r105 = com.bytedance.android.live.effect.utils.f.f68869a;
        if (r101 == null) goto L10;
        com.bytedance.android.live.effect.utils.f.a(r104, ((yp2.c) r101).f568698a, new b(r102));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.revenue.effect.RevStickerImpl");
    }
}
