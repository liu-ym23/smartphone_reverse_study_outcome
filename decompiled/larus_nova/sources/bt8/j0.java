package bt8;

import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpTabSelectorWidget;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes26.dex */
public final class j0 implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KmpTabSelectorWidget f20628a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public j0(KmpTabSelectorWidget r100) {
        this.f20628a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        Long r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getTag();
    L7:
        if ((r102 instanceof Long) == false) goto L9;
        r101 = (Long) r102;
    L9:
        if (r101 == null) goto L15;
        long r103 = r101.longValue();
        FLogger.f375446a.i("KmpTabSelectorWidget", "[onTabSelected] tabOptionId:" + r103);
        cq8.r0 r104 = this.f20628a.f316663g;
        if (r104 != null) goto L13;
        return;
    L13:
        r104.f464947d.a(new cq8.s0(r104.f464946c, r103));
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
