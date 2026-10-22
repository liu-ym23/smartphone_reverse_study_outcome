package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.l0;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final boolean d() {
        return true;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new l0(this.f183787l);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        ArrayList r100 = new ArrayList();
        r100.add(new e(this.f183787l));
        r100.add(new m(this.f183787l));
        return r100;
    }

    public d(Fragment r100) {
        super(R.id.ec_store_float_go_top_container, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        View r101 = q.a.a(this, R.layout.ec_shop_layout_go_top_and_hint);
        r101.setVisibility(0);
        return r101;
    }
}
