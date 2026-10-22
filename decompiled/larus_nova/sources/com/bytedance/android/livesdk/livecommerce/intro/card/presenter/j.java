package com.bytedance.android.livesdk.livecommerce.intro.card.presenter;

import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class j extends oh2.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IntroPromotionVO f147901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f147902j;

    public final void F() {
        throw null;
    }

    public static final boolean E(final j r100, com.bytedance.android.livesdk.livecommerce.intro.card.vm.a r101) {
        IntroPromotionVO r102 = r100.f147901i;
        if (r102 == null) goto L11;
        r101.getClass();
        final Long r103 = null;
        if ((!Intrinsics.areEqual(null, r102.getPromotionId())) == true) goto L11;
        if ((!Intrinsics.areEqual(null, r102.getProductId())) == true) goto L11;
        UtilityKotlinExtentionsKt.f(r100.f147902j, r100.f147901i, new KIntroCardPresenter$logShowDurationEvent$1(r100, r103));
        r100.f147902j = null;
        r100.F();
        return true;
    L11:
        return false;
    }
}
