package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class TabLayoutMediator {

    @Nullable
    private RecyclerView.Adapter adapter;
    private boolean attached;
    private final boolean autoRefresh;

    @Nullable
    private TabLayoutOnPageChangeCallback onPageChangeCallback;

    @Nullable
    private TabLayout.OnTabSelectedListener onTabSelectedListener;

    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;

    @NonNull
    private final TabLayout tabLayout;

    @NonNull
    private final ViewPager2 viewPager;

    public class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        final /* synthetic */ TabLayoutMediator this$0;

        public PagerAdapterObserver(TabLayoutMediator r10) {
            this.this$0 = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r10, int r11) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r10, int r11) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r10, int r11, int r12) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r10, int r11) {
            this.this$0.populateTabsFromPagerAdapter();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r10, int r11, @Nullable Object r12) {
            this.this$0.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab r10, int r11);
    }

    public static class TabLayoutOnPageChangeCallback extends ViewPager2.h {
        private int previousScrollState;
        private int scrollState;

        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeCallback(TabLayout r10) {
            this.tabLayoutRef = new WeakReference(r10);
            reset();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageScrollStateChanged(int r10) {
            this.previousScrollState = this.scrollState;
            this.scrollState = r10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageScrolled(int r10, float r11, int r12) {
            TabLayout r13 = this.tabLayoutRef.get();
            if (r13 == null) goto L17;
            int r14 = this.scrollState;
            boolean r15 = false;
            if (r14 == 2) goto L7;
        L10:
            boolean r16 = true;
        L11:
            if (r14 == 2) goto L13;
        L14:
            r15 = true;
        L15:
            r13.setScrollPosition(r10, r11, r16, r15);
            return;
        L13:
            if (this.previousScrollState == 0) goto L15;
        L7:
            if (this.previousScrollState == 1) goto L10;
            r16 = false;
            goto L11
        }

        @Override // androidx.viewpager2.widget.ViewPager2.h
        public void onPageSelected(int r10) {
            TabLayout r11 = this.tabLayoutRef.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if (r11.getSelectedTabPosition() != r10) goto L7;
            return;
        L7:
            if (r10 >= r11.getTabCount()) goto L21;
            int r12 = this.scrollState;
            if (r12 != 0) goto L11;
        L16:
            boolean r13 = true;
        L17:
            r11.selectTab(r11.getTabAt(r10), r13);
            return;
        L11:
            if (r12 == 2) goto L13;
        L15:
            r13 = false;
            goto L17
        L13:
            if (this.previousScrollState != 0) goto L15;
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final ViewPager2 viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager2 r10, boolean r11) {
            this.viewPager = r10;
            this.smoothScroll = r11;
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab r10) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@NonNull TabLayout.Tab r10) {
            this.viewPager.j(r10.getPosition(), this.smoothScroll);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab r10) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout r10, @NonNull ViewPager2 r11, @NonNull TabConfigurationStrategy r12) {
        this(r10, r11, true, r12);
    }

    public void attach() {
        if (this.attached == true) goto L14;
        RecyclerView.Adapter r10 = this.viewPager.getAdapter();
        this.adapter = r10;
        if (r10 == null) goto L12;
        this.attached = true;
        TabLayoutOnPageChangeCallback r11 = new TabLayoutOnPageChangeCallback(this.tabLayout);
        this.onPageChangeCallback = r11;
        this.viewPager.g(r11);
        ViewPagerOnTabSelectedListener r12 = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
        this.onTabSelectedListener = r12;
        this.tabLayout.addOnTabSelectedListener(r12);
        if (this.autoRefresh == false) goto L9;
        PagerAdapterObserver r13 = new PagerAdapterObserver(this);
        this.pagerAdapterObserver = r13;
        this.adapter.registerAdapterDataObserver(r13);
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
        RecyclerView.Adapter r10 = this.adapter;
        if (r10 == null) goto L7;
        r10.unregisterAdapterDataObserver(this.pagerAdapterObserver);
        this.pagerAdapterObserver = null;
    L7:
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.n(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void populateTabsFromPagerAdapter() {
        this.tabLayout.removeAllTabs();
        RecyclerView.Adapter r10 = this.adapter;
        if (r10 == null) goto L13;
        int r11 = r10.getItemCount();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L7;
        TabLayout.Tab r13 = this.tabLayout.newTab();
        this.tabConfigurationStrategy.onConfigureTab(r13, r12);
        this.tabLayout.addTab(r13, false);
        r12 = r12 + 1;
        goto L5
    L7:
        if (r11 <= 0) goto L14;
        int r14 = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1);
        if (r14 == this.tabLayout.getSelectedTabPosition()) goto L15;
        TabLayout r15 = this.tabLayout;
        r15.selectTab(r15.getTabAt(r14));
        return;
    L15:
        return;
    L14:
        return;
    }

    public TabLayoutMediator(@NonNull TabLayout r10, @NonNull ViewPager2 r11, boolean r12, @NonNull TabConfigurationStrategy r13) {
        this(r10, r11, r12, true, r13);
    }

    public TabLayoutMediator(@NonNull TabLayout r10, @NonNull ViewPager2 r11, boolean r12, boolean r13, @NonNull TabConfigurationStrategy r14) {
        this.tabLayout = r10;
        this.viewPager = r11;
        this.autoRefresh = r12;
        this.smoothScroll = r13;
        this.tabConfigurationStrategy = r14;
    }
}
