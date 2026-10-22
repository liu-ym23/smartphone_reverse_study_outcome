package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardCarouselComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class h extends oh2.a implements c {

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f147899a;

        public a(h r100) {
            this.f147899a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IntroPromotionVO r101 = (IntroPromotionVO) r100;
            if (r101 == null) goto L5;
            ((IntroCardCarouselComponent) this.f147899a.w().b(R.id.area_carousel).f()).R5(r101);
            return;
        L5:
            ((IntroCardCarouselComponent) this.f147899a.w().b(R.id.area_carousel).f()).release();
            Unit r102 = Unit.INSTANCE;
        }
    }

    public h() {
        super(0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c
    public final void i() {
        IntroCardViewModel r100 = this.f523246e;
        if (r100 == null) goto L8;
        bk2.e<bk2.a<Unit>> r101 = r100.getShowCardAction();
        if (r101 == null) goto L9;
        r101.g(new bk2.a(Unit.INSTANCE));
        return;
    L9:
        return;
    }

    @Override // oh2.a, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        ((IntroCardCarouselComponent) w().b(R.id.area_carousel).f()).release();
    }

    @Override // oh2.a
    public final void D(oh2.h r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ((IntroCardCarouselComponent) w().b(R.id.area_carousel).f()).setPresenter(this);
        IntroCardCarouselComponent r101 = (IntroCardCarouselComponent) w().b(R.id.area_carousel).f();
        r101.setArgument(this.f523247f);
        r101.setContainerAbility(this.f523248g);
        IntroCardViewModel r102 = this.f523246e;
        if (r102 == null) goto L8;
        bk2.e<IntroPromotionVO> r103 = r102.getCardState();
        if (r103 == null) goto L9;
        r103.b(r100.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c
    public final void t(boolean r100) {
        IntroCardViewModel r101 = this.f523246e;
        if (r101 == null) goto L8;
        bk2.e<bk2.a<Boolean>> r102 = r101.getSecondFrameHasTitleAction();
        if (r102 == null) goto L9;
        r102.g(new bk2.a(Boolean.valueOf(r100)));
        return;
    L9:
        return;
    }
}
