package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c extends com.bytedance.android.ec.core.utils.rotation.a<p0> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ IntroCardInfoComponent f148030k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f148031l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f148032m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f148033n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ List f148034o;

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final View f(int r100) {
        if (r100 != 0) goto L5;
        return this.f148031l;
    L5:
        return this.f148032m;
    }

    @Override // com.bytedance.android.ec.core.utils.rotation.e
    public final void i(int r100, Object r101) {
        p0 r102 = (p0) r101;
        Intrinsics.checkNotNullParameter(r102, "data");
        if (r100 != 0) goto L5;
        FrameLayout r103 = this.f148031l;
    L6:
        r103.removeAllViews();
        IntroCardInfoComponent r104 = this.f148030k;
        int r105 = this.f148033n;
        int r106 = IntroCardInfoComponent.f147973g;
        r103.addView(r104.d(r102, r105).component1(), new LinearLayout.LayoutParams(-1, -2));
        return;
    L5:
        r103 = this.f148032m;
        goto L6
    }

    public c(IntroCardInfoComponent r100, FrameLayout r110, FrameLayout r111, int r112, List r113, List r114, long r115, long r116) {
        this.f148030k = r100;
        this.f148031l = r110;
        this.f148032m = r111;
        this.f148033n = r112;
        this.f148034o = r113;
        super(r114, r115, r116, false);
    }
}
