package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.text.Spannable;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.RechargeViewParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class n0 implements yr2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVIRechargeView f127957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RechargeViewParams f127958b;

    @Override // yr2.a
    public final void a(py.k r100) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r100, "image");
    }

    public n0(GiftMVIRechargeView r100, RechargeViewParams r101) {
        this.f127957a = r100;
        this.f127958b = r101;
    }

    @Override // yr2.a
    public final void b(Spannable r100, yr2.a.C8374a r101) {
        Intrinsics.checkNotNullParameter(r100, "spannable");
        Intrinsics.checkNotNullParameter(r101, "info");
        TextView r102 = this.f127957a.f127571n;
        if (r102 == null) goto L5;
        r102.setText(r100);
    L5:
        TextView r103 = this.f127957a.f127571n;
        if (r103 == null) goto L8;
        r103.setTextSize(1, this.f127958b.getTextSize());
    L8:
        HSImageView r104 = this.f127957a.f127572o;
        if (r104 == null) goto L12;
        r104.setVisibility(8);
        return;
    }
}
