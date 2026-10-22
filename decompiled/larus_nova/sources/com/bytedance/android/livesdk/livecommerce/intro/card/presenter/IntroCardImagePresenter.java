package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardImageComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.r;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroCardImagePresenter extends oh2.a implements d {

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroCardImagePresenter f147877a;

        public a(IntroCardImagePresenter r100) {
            this.f147877a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IntroPromotionVO r101 = (IntroPromotionVO) r100;
            if (r101 == null) goto L11;
            u r102 = r101.getImage();
            if (r102 == null) goto L13;
            IntroCardImagePresenter r103 = this.f147877a;
            s0 r104 = r101.getControl();
            if (r104 == null) goto L9;
            int r105 = r104.d();
        L10:
            ((IntroCardImageComponent) r103.w().f()).R5(r102, r105);
            return;
        L9:
            r105 = 0;
            goto L10
        L13:
            return;
        L11:
            ((IntroCardImageComponent) this.f147877a.w().f()).S5();
            Unit r106 = Unit.INSTANCE;
        }
    }

    public IntroCardImagePresenter() {
        super(0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.card.presenter.d
    public final void d() {
        IntroCardViewModel r100 = this.f523246e;
        if (r100 == null) goto L8;
        r r101 = r100.getCardCallback();
        if (r101 == null) goto L9;
        r101.d();
        return;
    L9:
        return;
    }

    @Override // oh2.a, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        ((IntroCardImageComponent) w().f()).S5();
    }

    @Override // oh2.a
    public final void D(oh2.h r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ((IntroCardImageComponent) w().f()).setPresenter(this);
        IntroCardViewModel r101 = this.f523246e;
        if (r101 == null) goto L7;
        bk2.e<IntroPromotionVO> r102 = r101.getCardState();
        if (r102 == null) goto L7;
        r102.b(r100.getLifecycleOwner(), new a(this));
    L7:
        IntroCardViewModel r103 = this.f523246e;
        if (r103 == null) goto L13;
        bk2.e<bk2.a<Boolean>> r104 = r103.getShowImageTagAction();
        if (r104 == null) goto L14;
        r104.b(r100.getLifecycleOwner(), new ActionObserver(new IntroCardImagePresenter$bind$2(this)));
        return;
    L14:
        return;
    }
}
