package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.view.View;
import com.bytedance.android.ec.model.response.ECCarouselData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class g extends com.bytedance.android.ec.core.utils.rotation.a<ECCarouselData> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ECTagAndSalePointWidget f150463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f150464l;

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final View f(int r100) {
        if (r100 != 0) goto L6;
        ECSalePointView r101 = this.f150463k.f150435h;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L9:
        return r101;
    L6:
        r101 = this.f150463k.f150436i;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
        goto L9
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void i(int r100, Object r101) {
        ECCarouselData r102 = (ECCarouselData) r101;
        Intrinsics.checkNotNullParameter(r102, "data");
        if (r100 != 0) goto L7;
        ECSalePointView r103 = this.f150463k.f150435h;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L10:
        StringBuilder r104 = this.f150463k.f150438k;
        if (r104 == null) goto L13;
        StringsKt.clear(r104);
    L13:
        r103.a(r102);
        StringBuilder r105 = this.f150463k.f150438k;
        if (r105 == null) goto L16;
        StringsKt.append(r105, new String[]{r102.getBefore(), r102.getContent()});
    L16:
        this.f150463k.d(r102);
        return;
    L7:
        r103 = this.f150463k.f150436i;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
        goto L10
    }

    public g(ECTagAndSalePointWidget r100, List r101, List r110, long r111, long r112, boolean r113) {
        this.f150463k = r100;
        this.f150464l = r101;
        super(r110, r111, r112, r113);
    }
}
