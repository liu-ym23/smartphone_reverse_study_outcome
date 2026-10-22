package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardTitleComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.o0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroSkinHelper;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mh2.q;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroCardTitlePresenter extends oh2.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f147885i;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntroCardTitlePresenter f147886a;

        public a(IntroCardTitlePresenter r100) {
            this.f147886a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            IntroPromotionVO r111 = (IntroPromotionVO) r110;
            boolean r100 = false;
            if (r111 == null) goto L55;
            o0 r101 = r111.getTitle();
            if (r101 == null) goto L70;
            IntroCardTitlePresenter r102 = this.f147886a;
            if (r102.f147885i == true) goto L71;
            s0 r112 = r111.getControl();
            if (r112 == null) goto L11;
            int r113 = r112.d();
        L12:
            IntroCardTitleComponent r103 = (IntroCardTitleComponent) r102.w().f();
            Intrinsics.checkNotNullParameter(r101, "titleModel");
            r103.setVisibility(0);
            th2.b r114 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r113));
            if (r114 == null) goto L18;
            ECLiveSkinViewUIConfig r115 = r114.u();
            if (r115 == null) goto L18;
            ECLiveSkinTextElement r116 = r115.getText();
            if (r116 == null) goto L18;
        L19:
            IntroSkinHelper.a(r103, r116);
            String r104 = r101.b();
            List<ECRitTag> r117 = r101.c();
            Integer r105 = Integer.valueOf((int) r101.a());
            if (r105.intValue() <= 0) goto L23;
            r100 = true;
        L23:
            if (r100 == true) goto L26;
            r105 = null;
        L26:
            if (r105 == null) goto L28;
            int r106 = r105.intValue();
        L29:
            if (r117 == null) goto L46;
            ArrayList r107 = new ArrayList();
            Iterator<T> r118 = r117.iterator();
        L32:
            if (r118.hasNext() == false) goto L37;
            ECUrlModel r108 = ((ECRitTag) r118.next()).getTextIcon();
            if (r108 == null) goto L32;
            r107.add(r108);
            goto L32
        L37:
            if ((!r107.isEmpty()) == true) goto L40;
            r107 = null;
        L40:
            if (r107 == null) goto L46;
            ECUrlModel r119 = (ECUrlModel) CollectionsKt.firstOrNull(r107);
            if (r119 == null) goto L44;
            float r109 = r119.getHeight();
        L45:
            r103.f147991c = q.a(r107, r104, 2.0f, r109, r103, true, true);
        L47:
            r103.setMaxLines(r106);
            r103.setFocusable(true);
            List<ECRitTag> r120 = r101.c();
            if (r120 == null) goto L72;
            Iterator<T> r121 = r120.iterator();
        L51:
            if (r121.hasNext() == false) goto L73;
            RitTagTrack r122 = ((ECRitTag) r121.next()).getTagTrack();
            if (r122 == null) goto L51;
            r122.setVisibile(true);
            goto L51
        L73:
            return;
        L72:
            return;
        L44:
            r109 = 0.0f;
        L46:
            r103.setText(r104);
            Unit r123 = Unit.INSTANCE;
            goto L47
        L28:
            r106 = 1;
        L18:
            r116 = new ECLiveSkinTextElement(14, CollectionsKt.listOf(CustomHeaderConfig.COLOR_LIGHT), 500);
            goto L19
        L11:
            r113 = 0;
            goto L12
        L71:
            return;
        L70:
            return;
        L55:
            IntroCardTitlePresenter r124 = this.f147886a;
            Disposable r125 = ((IntroCardTitleComponent) r124.w().f()).f147991c;
            if (r125 == null) goto L58;
            r125.dispose();
        L58:
            r124.f147885i = false;
            Unit r126 = Unit.INSTANCE;
        }
    }

    public IntroCardTitlePresenter() {
        super(0);
    }

    @Override // oh2.a, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        Disposable r100 = ((IntroCardTitleComponent) w().f()).f147991c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f147885i = false;
    }

    @Override // oh2.a
    public final void D(oh2.h r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        IntroCardViewModel r101 = this.f523246e;
        if (r101 == null) goto L7;
        bk2.e<IntroPromotionVO> r102 = r101.getCardState();
        if (r102 == null) goto L7;
        r102.b(r100.getLifecycleOwner(), new a(this));
    L7:
        IntroCardViewModel r103 = this.f523246e;
        if (r103 == null) goto L13;
        bk2.e<bk2.a<Boolean>> r104 = r103.getSecondFrameHasTitleAction();
        if (r104 == null) goto L14;
        r104.b(r100.getLifecycleOwner(), new ActionObserver(new IntroCardTitlePresenter$bind$2(this)));
        return;
    L14:
        return;
    }
}
