package cd5;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.facade.common.lazy.LazyBaseFragment;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.list.sort.FilterType;
import com.bytedance.ee.bear.list.sort.SortAndFilterViewModel;
import com.bytedance.ee.bear.list.t3;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import dd5.p1;
import dd5.s1;
import wc5.f;

/* JADX INFO: loaded from: classes18.dex */
public abstract class e implements f.a, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LazyBaseFragment f23384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f23385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f23386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f23387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.ee.bear.list.homepage.banner.a f23388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.ee.bear.list.homepage.banner.c f23389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public yc5.b f23390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f23391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ConnectionService.NetworkState f23392i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FolderSortStrategy f23393j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ce5.a f23394k;

    public abstract String a();

    public String b() {
        return "";
    }

    public String c() {
        return "none";
    }

    public abstract void d(BaseFragment r100, Context r101, View r102);

    public e(ce5.a r100) {
        this.f23394k = r100;
    }

    @Override // dd5.p1
    public final void Mj(boolean r100) {
        this.f23386c.b(r100);
        this.f23387d.b(r100);
    }

    @Override // wc5.f.a
    public void WU(boolean r100) {
        Mj(r100);
        s1.a.f468004a.f((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), r100, c());
    }

    public void e(final AppBarLayout r100) {
        f r101 = (f) r100.findViewById(R.id.home_sub_title_view);
        this.f23386c = r101;
        r101.setViewDelegate(this);
        f r102 = (f) this.f23384a.findViewById(R.id.fixed_at_top_title_view);
        this.f23387d = r102;
        r102.setViewDelegate(this);
        Mj(t3.f229771a);
        r100.addOnOffsetChangedListener(new a(this, r100));
    }

    public void f(FolderSortStrategy r100) {
        this.f23393j = r100;
        f r101 = this.f23386c;
        int r102 = r100.getType();
        FilterType r103 = FilterType.ALL;
        if (r102 != r103.getType()) goto L5;
        SubMenuView.FilterState r104 = SubMenuView.FilterState.DEFAULT;
    L6:
        r101.setFilterState(r104);
        f r105 = this.f23387d;
        if (r100.getType() != r103.getType()) goto L9;
        SubMenuView.FilterState r106 = SubMenuView.FilterState.DEFAULT;
    L10:
        r105.setFilterState(r106);
        return;
    L9:
        r106 = SubMenuView.FilterState.CHECKED;
        goto L10
    L5:
        r104 = SubMenuView.FilterState.CHECKED;
        goto L6
    }

    public e(LazyBaseFragment r100, Context r101, AppBarLayout r102, ce5.a r103) {
        this.f23384a = r100;
        this.f23385b = r101;
        this.f23391h = r102.findViewById(R.id.no_net_container);
        this.f23394k = r103;
        d(r100, r101, r102.findViewById(R.id.header_banner_view));
        e(r102);
        tt5.a.h("BaseHomeHeader", "initNotification()...");
        this.f23390g = new yc5.b(this.f23385b, r102, new d(this));
        if (this.f23384a.getActivity() == null) goto L5;
        ((SortAndFilterViewModel) ViewModelProviders.of(this.f23384a.getActivity()).get(SortAndFilterViewModel.class)).getSortStrategyLiveData().observe(this.f23384a, new b(this));
    L5:
        j.a.f217090a.a().observe(this.f23384a, new c(this));
        s1.a.f468004a.a(this);
        this.f23394k = r103;
    }
}
