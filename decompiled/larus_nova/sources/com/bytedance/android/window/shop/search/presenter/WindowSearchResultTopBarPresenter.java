package com.bytedance.android.window.shop.search.presenter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.window.shop.search.activity.ECWindowSearchActivity;
import com.bytedance.android.window.shop.search.router.ECWindowSearchParam;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchResultViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowSearchResultTopBarPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f189721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f189722f;

    public final WindowSearchResultViewModel F() {
        return (WindowSearchResultViewModel) this.f189721e.getValue();
    }

    public WindowSearchResultTopBarPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f189722f = r100;
        this.f189721e = LazyKt.lazy(new WindowSearchResultTopBarPresenter$viewModel$2(this));
    }

    public static final void D(WindowSearchResultTopBarPresenter r100) {
        r100.F().getSearchParam().setSearchKeyword("");
        Intent r101 = new Intent(r100.u().c(), ECWindowSearchActivity.class);
        ECWindowSearchParam r102 = r100.F().getSearchParam();
        if (r102 == null) goto L17;
        r101.putExtra("search_param", r102);
        Uri r103 = r100.F().getUri();
        if (r103 == null) goto L7;
        String r104 = UriProtector.getQueryParameter(r103, com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
    L8:
        Uri r105 = r100.F().getUri();
        if (r105 == null) goto L11;
        String r106 = UriProtector.getQueryParameter(r105, "ec_shop_inner_info");
    L12:
        xn.c.f(r101, r104, z1.g(r106));
        ContextCompat.startActivity(r100.u().c(), r101, null);
        Activity r107 = l0.b(r100.u().c());
        if (r107 == null) goto L18;
        r107.finish();
        return;
    L18:
        return;
    L11:
        r106 = null;
        goto L12
    L7:
        r104 = null;
        goto L8
    L17:
        throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        ((ImageView) y().findViewById(R.id.commerce_store_search_result_back)).setOnClickListener(new m(this));
        View r101 = y().findViewById(R.id.commerce_store_search_close);
        r101.setVisibility(0);
        r101.setOnClickListener(new n(this));
        View r102 = y().findViewById(R.id.commerce_store_search_camera);
        r102.setVisibility(8);
        r102.setOnClickListener(new o(r102, this));
        TextView r103 = (TextView) y().findViewById(R.id.commerce_store_search_input);
        r103.setText(F().getSearchParam().getSearchKeyword());
        F().getData().putExtra("sug_enter_type", 1);
        r103.setOnClickListener(new p(this));
        View r104 = y().findViewById(R.id.status_bar);
        if (r104 == null) goto L6;
        int r105 = com.bytedance.android.ec.core.utils.j.f45614a;
        com.bytedance.android.ec.core.utils.j.a.a(r104);
        return;
    }

    public static final void E(WindowSearchResultTopBarPresenter r100, int r101) {
        r100.F().setMToNewPage(false);
        r100.F().getData().putExtra("sug_gap_time", SystemClock.elapsedRealtime() - r100.F().getMRecordTime());
        Activity r102 = l0.b(r100.u().c());
        if (r102 == null) goto L5;
        r102.setResult(r101, r100.F().getData());
    L5:
        Activity r103 = l0.b(r100.u().c());
        if (r103 == null) goto L9;
        r103.finish();
        return;
    }
}
