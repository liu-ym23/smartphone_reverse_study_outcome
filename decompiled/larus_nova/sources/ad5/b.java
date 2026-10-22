package ad5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.tab.HomeSubMenuView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HomeSubMenuView f3016c;

    public b(HomeSubMenuView r100) {
        this.f3016c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        tt5.a.h("HomeSubMenuView", "on click iv filter");
        wc5.f.a r101 = this.f3016c.f228335f;
        if (r101 == null) goto L6;
        r101.eF();
        return;
    }
}
