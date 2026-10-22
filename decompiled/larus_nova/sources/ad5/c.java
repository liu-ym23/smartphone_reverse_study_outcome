package ad5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HomeSubMenuView f3017c;

    public c(HomeSubMenuView r100) {
        this.f3017c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        tt5.a.h("HomeSubMenuView", "on click grid");
        HomeSubMenuView r101 = this.f3017c;
        r101.f228334e = !r101.f228334e;
        r101.d();
        HomeSubMenuView r102 = this.f3017c;
        wc5.f.a r103 = r102.f228335f;
        if (r103 == null) goto L6;
        r103.WU(r102.f228334e);
        return;
    }
}
