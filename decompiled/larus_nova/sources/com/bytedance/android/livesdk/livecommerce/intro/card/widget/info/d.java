package com.bytedance.android.livesdk.livecommerce.intro.card.widget.info;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroElasticMultiElementTitle;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends com.bytedance.android.ec.core.utils.rotation.a<IntroElasticMultiElementTitle> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ IntroInfoElasticTitleWidget f148095k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ IntroInfoSalePointView f148096l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ IntroInfoSalePointView f148097m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ List f148098n;

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final View f(int r100) {
        if (r100 != 0) goto L5;
        return this.f148096l;
    L5:
        return this.f148097m;
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void i(int r100, Object r101) {
        IntroElasticMultiElementTitle r102 = (IntroElasticMultiElementTitle) r101;
        Intrinsics.checkNotNullParameter(r102, "data");
        if (r100 != 0) goto L5;
        IntroInfoSalePointView r103 = this.f148096l;
    L6:
        StringBuilder r104 = this.f148095k.f148054d;
        if (r104 == null) goto L9;
        StringsKt.clear(r104);
    L9:
        IntroInfoElasticTitleWidget.a(this.f148095k, r103, r102);
        return;
    L5:
        r103 = this.f148097m;
        goto L6
    }

    public d(IntroInfoElasticTitleWidget r100, IntroInfoSalePointView r110, IntroInfoSalePointView r111, List r112, List r113, long r114, long r115) {
        this.f148095k = r100;
        this.f148096l = r110;
        this.f148097m = r111;
        this.f148098n = r112;
        super(r113, r114, r115, false);
    }
}
