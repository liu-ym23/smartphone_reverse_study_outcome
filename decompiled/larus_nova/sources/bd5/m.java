package bd5;

import android.view.View;
import com.bytedance.ee.bear.list.homepage.title.SubMenuView;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes18.dex */
public final class m extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SubMenuView f18671c;

    public m(SubMenuView r100) {
        this.f18671c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        SubMenuView r101 = this.f18671c;
        boolean r102 = !r101.f228388g;
        r101.f228388g = r102;
        r101.b(r102);
        SubMenuView r103 = this.f18671c;
        wc5.f.a r104 = r103.f228386e;
        if (r104 == null) goto L6;
        r104.WU(r103.f228388g);
        return;
    }
}
