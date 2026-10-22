package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TabLayout f86639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewPager2 f86640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f86641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.Adapter<?> f86642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f86643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f86644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f86645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f86646h;

    public class a extends RecyclerView.AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f86647a;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            this.f86647a.a();
        }

        public a(m r100) {
            this.f86647a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101) {
            this.f86647a.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r100, int r101) {
            this.f86647a.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r100, int r101) {
            this.f86647a.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r100, int r101, Object r102) {
            this.f86647a.a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r100, int r101, int r102) {
            this.f86647a.a();
        }
    }

    public interface b {
        void a(TabLayout.Tab r100, int r101);

        void b(int r100);
    }

    public static class c extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f86648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f86649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f86650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f86651d;

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r100) {
            this.f86650c = this.f86651d;
            this.f86651d = r100;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r100) {
            TabLayout r101 = this.f86648a.get();
            if (r101 != null) goto L5;
        L14:
            this.f86649b.b(r100);
            return;
        L5:
            if (r101.getSelectedTabPosition() == r100) goto L14;
            if (r100 >= r101.getTabCount()) goto L14;
            if (this.f86651d != 0) goto L11;
        L11:
            TabLayout.Tab r102 = r101.getTabAt(r100);
            if (r102 == null) goto L14;
            r102.select();
            goto L14
        }

        public c(TabLayout r100, b r101) {
            this.f86648a = new WeakReference(r100);
            this.f86649b = r101;
            this.f86651d = 0;
            this.f86650c = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r100, float r101, int r102) {
            TabLayout r103 = this.f86648a.get();
            if (r103 == null) goto L12;
            boolean r104 = true;
            if (this.f86651d == 2) goto L7;
        L10:
            r103.setScrollPosition(r100, r101, r104);
            return;
        L7:
            if (this.f86650c == 1) goto L10;
            r104 = false;
            goto L10
        }
    }

    public static class d implements TabLayout.OnTabSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager2 f86652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f86653b;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabReselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabUnselected(TabLayout.Tab r100) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public final void onTabSelected(TabLayout.Tab r100) {
            this.f86652a.setCurrentItem(r100.getPosition(), this.f86653b);
        }

        public d(ViewPager2 r100, boolean r101) {
            this.f86652a = r100;
            this.f86653b = r101;
        }
    }

    public final void a() {
        this.f86639a.removeAllTabs();
        RecyclerView.Adapter<?> r100 = this.f86642d;
        if (r100 == null) goto L15;
        int r101 = r100.getItemCount();
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        TabLayout.Tab r103 = this.f86639a.newTab();
        this.f86641c.a(r103, r102);
        this.f86639a.addTab(r103, false);
        r102 = r102 + 1;
        goto L5
    L7:
        if (r101 <= 0) goto L16;
        int r104 = Math.min(this.f86640b.getCurrentItem(), this.f86639a.getTabCount() - 1);
        if (r104 == this.f86639a.getSelectedTabPosition()) goto L17;
        TabLayout.Tab r105 = this.f86639a.getTabAt(r104);
        if (r105 == null) goto L18;
        r105.select();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }

    public m(TabLayout r100, ViewPager2 r101, ProfileTabsComponent.c r102) {
        this.f86639a = r100;
        this.f86640b = r101;
        this.f86641c = r102;
    }
}
