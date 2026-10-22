package com.bytedance.android.ec.core.widget;

import android.view.View;
import com.bytedance.android.ec.window.base.product.presenter.element.source.ECWindowProductCardSourceInfoElementPresenter;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f46104g;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f46104g.onClick(r100);
    }

    public g(ECWindowProductCardSourceInfoElementPresenter r100, Long r101, String r102) {
        this.f46104g = r100;
        super(r101, r102);
    }
}
