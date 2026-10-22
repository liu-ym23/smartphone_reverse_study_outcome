package bt8;

import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpMenuTabContainerWidget;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes26.dex */
public final class b0 implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KmpMenuTabContainerWidget f20573a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public b0(KmpMenuTabContainerWidget r100) {
        this.f20573a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag();
    L7:
        if ((r102 instanceof Long) == false) goto L9;
        Long r103 = (Long) r102;
    L10:
        if (r103 == null) goto L32;
        long r104 = r103.longValue();
        cq8.f0 r105 = this.f20573a.f316652h;
        if (r105 != null) goto L14;
        return;
    L14:
        Iterator<T> r106 = r105.f464834f.iterator();
    L16:
        if (r106.hasNext() == false) goto L20;
        Object r107 = r106.next();
        if (((cq8.g0) r107).f464843c == false) goto L16;
        r101 = r107;
    L20:
        cq8.g0 r108 = (cq8.g0) r101;
        boolean r109 = false;
        if (r108 != null) goto L23;
    L25:
        if (r109 == false) goto L27;
        return;
    L27:
        FLogger.f375446a.i("KmpMenuTabContainerWidget", "[onTabSelected] tabId:" + r104);
        r105.f464832d.a(new cq8.h0(r105.f464831c, r104));
        return;
    L23:
        if (r108.f464841a != r104) goto L25;
        r109 = true;
        goto L25
    L32:
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
