package ac5;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.lark.route.SpaceRouteFragment;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;
import com.ss.android.lark.api.bean.ForsetiViewMode;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpaceRouteFragment f2707a;

    public k(SpaceRouteFragment r100) {
        this.f2707a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ForsetiViewMode r101 = (ForsetiViewMode) r100;
        int r102 = SpaceRouteFragment.f227443m;
        tt5.a.h("SpaceRouteFragment", "observeForsetiMode:mode:" + r101 + " mDestination:" + this.f2707a.f227446h);
        if (r101 == null) goto L21;
        SpaceRouteFragment r103 = this.f2707a;
        if (r103.f227444f != null) goto L7;
        return;
    L7:
        if (r103.f227450l.contains(Integer.valueOf(r103.f227446h)) == true) goto L9;
        return;
    L9:
        if (r101.isCompact() == false) goto L15;
        HomeMainTitleBar r104 = this.f2707a.f227444f;
        if (r104 == null) goto L24;
        AppCompatImageView r105 = r104.f228356h;
        if (r105 == null) goto L25;
        r105.setVisibility(0);
        return;
    L25:
        return;
    L24:
        return;
    L15:
        HomeMainTitleBar r106 = this.f2707a.f227444f;
        if (r106 == null) goto L27;
        AppCompatImageView r107 = r106.f228356h;
        if (r107 == null) goto L28;
        r107.setVisibility(8);
        return;
    L28:
        return;
    L27:
        return;
    }
}
