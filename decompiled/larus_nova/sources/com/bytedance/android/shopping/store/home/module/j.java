package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.q0;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class j extends b {
    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new q0(this.f183787l);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final List<QUIModule> i() {
        ArrayList r100 = new ArrayList();
        r100.add(new p(this.f183787l));
        r100.add(new com.bytedance.android.shopping.store.home.slice.a(this.f183787l));
        return r100;
    }

    public j(Fragment r100) {
        super(R.id.ec_store_info_group_area_container, r100);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r100) {
        return q.a.a(this, R.layout.ec_store_layout_info_group);
    }
}
