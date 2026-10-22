package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardPriceComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPrice;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i extends oh2.a {

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f147900a;

        public a(i r100) {
            this.f147900a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IntroPromotionVO r101 = (IntroPromotionVO) r100;
            if (r101 == null) goto L11;
            IntroPrice r102 = r101.getPrice();
            if (r102 == null) goto L13;
            i r103 = this.f147900a;
            s0 r104 = r101.getControl();
            if (r104 == null) goto L9;
            Integer r105 = Integer.valueOf(r104.d());
        L10:
            ((IntroCardPriceComponent) r103.w().f()).b(r102, r105);
            return;
        L9:
            r105 = null;
            goto L10
        L13:
            return;
        L11:
            ((IntroCardPriceComponent) this.f147900a.w().f()).c();
            Unit r106 = Unit.INSTANCE;
        }
    }

    public i() {
        super(0);
    }

    @Override // oh2.a, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        ((IntroCardPriceComponent) w().f()).c();
    }

    @Override // oh2.a
    public final void D(oh2.h r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        IntroCardViewModel r101 = this.f523246e;
        if (r101 == null) goto L8;
        bk2.e<IntroPromotionVO> r102 = r101.getCardState();
        if (r102 == null) goto L9;
        r102.b(r100.getLifecycleOwner(), new a(this));
        return;
    L9:
        return;
    }
}
