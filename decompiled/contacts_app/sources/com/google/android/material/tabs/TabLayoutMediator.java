package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class TabLayoutMediator {
    private RecyclerView.Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;
    private TabLayoutOnPageChangeCallback onPageChangeCallback;
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;
    private final TabLayout tabLayout;
    private final ViewPager2 viewPager;

    private class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ TabLayoutMediator this$0;

        PagerAdapterObserver(TabLayoutMediator r1) {
            this.this$0 = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r1, int r2) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r1, int r2, Object r3) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r1, int r2) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r1, int r2) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r1, int r2, int r3) {
            this.this$0.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(TabLayout.Tab r1, int r2);
    }

    private static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int previousScrollState;
        private int scrollState;
        private final WeakReference<TabLayout> tabLayoutRef;

        TabLayoutOnPageChangeCallback(TabLayout r2) {
            this.tabLayoutRef = new WeakReference(r2);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r2) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r2;
            TabLayout r3 = this.tabLayoutRef.get();
            if (r3 == null) goto L6;
            r3.updateViewPagerScrollState(this.scrollState);
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r7, float r8, int r9) {
            TabLayout r0 = this.tabLayoutRef.get();
            if (r0 == null) goto L19;
            int r10 = this.scrollState;
            if (r10 == 2) goto L7;
        L10:
            boolean r4 = true;
        L11:
            if (r10 == 2) goto L13;
        L16:
            boolean r6 = true;
        L17:
            r0.setScrollPosition(r7, r8, r4, r6, false);
            return;
        L13:
            if (this.previousScrollState != 0) goto L16;
            r6 = false;
            goto L17
        L7:
            if (this.previousScrollState == 1) goto L10;
            r4 = false;
            goto L11
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r4) {
            TabLayout r0 = this.tabLayoutRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.getSelectedTabPosition() != r4) goto L7;
            return;
        L7:
            if (r4 >= r0.getTabCount()) goto L21;
            int r1 = this.scrollState;
            if (r1 != 0) goto L11;
        L16:
            boolean r3 = true;
        L17:
            r0.selectTab(r0.getTabAt(r4), r3);
            return;
        L11:
            if (r1 == 2) goto L13;
        L15:
            r3 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    private static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final ViewPager2 viewPager;

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab r1) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab r1) {
        }

        ViewPagerOnTabSelectedListener(ViewPager2 r1, boolean r2) {
            this.viewPager = r1;
            this.smoothScroll = r2;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab r2) {
            this.viewPager.setCurrentItem(r2.getPosition(), this.smoothScroll);
        }
    }

    public TabLayoutMediator(TabLayout r2, ViewPager2 r3, TabConfigurationStrategy r4) {
        this(r2, r3, true, r4);
    }

    public TabLayoutMediator(TabLayout r7, ViewPager2 r8, boolean r9, TabConfigurationStrategy r10) {
        this(r7, r8, r9, true, r10);
    }

    public TabLayoutMediator(TabLayout r1, ViewPager2 r2, boolean r3, boolean r4, TabConfigurationStrategy r5) {
        this.tabLayout = r1;
        this.viewPager = r2;
        this.autoRefresh = r3;
        this.smoothScroll = r4;
        this.tabConfigurationStrategy = r5;
    }

    public void attach() {
        if (this.attached == true) goto L14;
        RecyclerView.Adapter<?> r0 = this.viewPager.getAdapter();
        this.adapter = r0;
        if (r0 == null) goto L12;
        this.attached = true;
        TabLayoutOnPageChangeCallback r1 = new TabLayoutOnPageChangeCallback(this.tabLayout);
        this.onPageChangeCallback = r1;
        this.viewPager.registerOnPageChangeCallback(r1);
        ViewPagerOnTabSelectedListener r2 = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
        this.onTabSelectedListener = r2;
        this.tabLayout.addOnTabSelectedListener(r2);
        if (this.autoRefresh == false) goto L9;
        PagerAdapterObserver r3 = new PagerAdapterObserver(this);
        this.pagerAdapterObserver = r3;
        this.adapter.registerAdapterDataObserver(r3);
    L9:
        populateTabsFromPagerAdapter();
        this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
        return;
    L12:
        throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
    L14:
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        if (this.autoRefresh == false) goto L7;
        RecyclerView.Adapter<?> r0 = this.adapter;
        if (r0 == null) goto L7;
        r0.unregisterAdapterDataObserver(this.pagerAdapterObserver);
        this.pagerAdapterObserver = null;
    L7:
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        RecyclerView.Adapter<?> r0 = this.adapter;
        if (r0 == null) goto L13;
        int r1 = r0.getItemCount();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        TabLayout.Tab r3 = this.tabLayout.newTab();
        this.tabConfigurationStrategy.onConfigureTab(r3, r2);
        this.tabLayout.addTab(r3, false);
        r2 = r2 + 1;
        goto L5
    L7:
        if (r1 <= 0) goto L14;
        int r4 = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
        if (r4 == this.tabLayout.getSelectedTabPosition()) goto L15;
        TabLayout r5 = this.tabLayout;
        r5.selectTab(r5.getTabAt(r4));
        return;
    L15:
        return;
    L14:
        return;
    }
}
