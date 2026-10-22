package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f186303e;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.shopfeed.presenter.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC2737a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f186304a;

        public ViewOnClickListenerC2737a(a r100) {
            this.f186304a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Activity r101 = l0.b(this.f186304a.u().c());
            if (r101 == null) goto L6;
            r101.finish();
            return;
        }
    }

    public Integer D() {
        return null;
    }

    public abstract int E();

    public abstract int F();

    public a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f186303e = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public void A(QModel r100) {
        ImageView r101 = (ImageView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.shop_feed_back_button));
        if (r101 == null) goto L9;
        Integer r102 = D();
        if (r102 == null) goto L7;
        r101.setColorFilter(r102.intValue());
    L7:
        d2.d(r101, E(), F(), 0, 0);
        r101.setOnClickListener(new ViewOnClickListenerC2737a(this));
        return;
    }
}
