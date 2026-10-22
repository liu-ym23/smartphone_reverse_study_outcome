package com.bytedance.android.livesdk.livecommerce.intro.auction;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.n;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oh2.h;
import ti.l;

/* JADX INFO: loaded from: classes10.dex */
public final class IntroAuctionPresenter extends QPresenter {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f147843l = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f147844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IntroAuctionViewModel f147845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public l f147846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public IntroAuctionPromotionVO f147847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f147848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final oh2.e f147849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final oh2.c f147850k;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        UtilityKotlinExtentionsKt.f(this.f147848i, this.f147847h, new IntroAuctionPresenter$logShowDurationEvent$1(this));
        this.f147848i = null;
        D();
    }

    public final void D() {
        int r100 = n.f151643o;
        IntroAuctionViewModel r101 = this.f147845f;
        if (r101 == null) goto L7;
        com.bytedance.android.livesdk.livecommerce.room.model.e r102 = r101.getLiveRoomInfo();
        if (r102 == null) goto L7;
        String r103 = r102.roomId();
    L8:
        IntroAuctionViewModel r104 = this.f147845f;
        if (r104 == null) goto L13;
        com.bytedance.android.livesdk.livecommerce.room.model.e r105 = r104.getLiveRoomInfo();
        if (r105 == null) goto L13;
        String r106 = r105.a();
    L14:
        n.a.a(r103, r106).f151654m = true;
        l r107 = this.f147846g;
        if (r107 != null) goto L17;
    L19:
        l r108 = this.f147846g;
        if (r108 == null) goto L22;
        r108.release();
    L22:
        this.f147846g = null;
        return;
    L17:
        if (r107.getHybridView() == null) goto L19;
        ((ViewGroup) w().f()).removeAllViews();
    L13:
        r106 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(final QModel r100) {
        if ((r100 instanceof h) == false) goto L18;
        h r101 = (h) r100;
        if ((r101.a() instanceof IntroAuctionViewModel) == false) goto L19;
        QViewModel r102 = r101.a();
        if (r102 == null) goto L17;
        IntroAuctionViewModel r103 = (IntroAuctionViewModel) r102;
        this.f147845f = r103;
        bk2.e<bk2.a<Unit>> r104 = r103.getShowBeforeAnimAction();
        if (r104 == null) goto L11;
        r104.b(r101.getLifecycleOwner(), new ActionObserver(new IntroAuctionPresenter$onBind$1(this)));
    L11:
        IntroAuctionViewModel r105 = this.f147845f;
        if (r105 == null) goto L20;
        bk2.e<IntroAuctionPromotionVO> r106 = r105.getCardState();
        if (r106 == null) goto L21;
        r106.b(r101.getLifecycleOwner(), new IntroAuctionPresenter$onBind$2(this, r100));
        return;
    L21:
        return;
    L20:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.livecommerce.intro.auction.IntroAuctionViewModel");
    L19:
        return;
    }

    public final void E(int r100) {
        ViewGroup.LayoutParams r101 = w().f().getLayoutParams();
        if (r101 != null) goto L5;
    L6:
        View r102 = w().f();
        ViewGroup.LayoutParams r103 = w().f().getLayoutParams();
        if (r103 == null) goto L9;
        r103.height = r100;
        Unit r104 = Unit.INSTANCE;
    L10:
        r102.setLayoutParams(r103);
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        if (r101.height != r100) goto L6;
    }

    public IntroAuctionPresenter(oh2.e r100, oh2.c r101) {
        Intrinsics.checkNotNullParameter(r100, "argument");
        Intrinsics.checkNotNullParameter(r101, "containerAbility");
        this.f147849j = r100;
        this.f147850k = r101;
        this.f147844e = "auction_uuid";
    }
}
