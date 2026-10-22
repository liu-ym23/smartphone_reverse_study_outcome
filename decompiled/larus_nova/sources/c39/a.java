package c39;

import com.google.android.material.tabs.TabLayout;
import com.larus.discover.impl.databinding.LarusDiscoverMainLayoutBinding;

/* JADX INFO: loaded from: classes27.dex */
public final class a implements TabLayout.OnTabSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusDiscoverMainLayoutBinding f22344a;

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab r100) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab r100) {
    }

    public a(LarusDiscoverMainLayoutBinding r100) {
        this.f22344a = r100;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f22344a.f330499c.getCurrentItem() == r100.getPosition()) goto L8;
        this.f22344a.f330499c.setCurrentItem(r100.getPosition());
        return;
    }
}
