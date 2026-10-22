package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final TabLayout f21463a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f21464b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21465c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21466d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC0238b f21467e;

    /* renamed from: f, reason: collision with root package name */
    public RecyclerView.Adapter<?> f21468f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21469g;

    /* renamed from: h, reason: collision with root package name */
    public c f21470h;

    /* renamed from: i, reason: collision with root package name */
    public TabLayout.d f21471i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView.AdapterDataObserver f21472j;

    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            b.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11) {
            b.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            b.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i10, int i11, int i12) {
            b.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            b.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            b.this.b();
        }
    }

    /* renamed from: com.google.android.material.tabs.b$b, reason: collision with other inner class name */
    public interface InterfaceC0238b {
        void a(TabLayout.g gVar, int i10);
    }

    public static class c extends ViewPager2.i {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<TabLayout> f21474a;

        /* renamed from: b, reason: collision with root package name */
        public int f21475b;

        /* renamed from: c, reason: collision with root package name */
        public int f21476c;

        public c(TabLayout tabLayout) {
            this.f21474a = new WeakReference<>(tabLayout);
            a();
        }

        public void a() {
            this.f21476c = 0;
            this.f21475b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrollStateChanged(int i10) {
            this.f21475b = this.f21476c;
            this.f21476c = i10;
            TabLayout tabLayout = this.f21474a.get();
            if (tabLayout != null) {
                tabLayout.V(this.f21476c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            TabLayout tabLayout = this.f21474a.get();
            if (tabLayout != null) {
                int i12 = this.f21476c;
                boolean z11 = true;
                if (i12 != 2 || this.f21475b == 1) {
                    z10 = true;
                } else {
                    z10 = true;
                    z11 = false;
                }
                if (i12 == 2 && this.f21475b == 0) {
                    z10 = false;
                }
                tabLayout.P(i10, f10, z11, z10, false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int i10) {
            TabLayout tabLayout = this.f21474a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i10 || i10 >= tabLayout.getTabCount()) {
                return;
            }
            int i11 = this.f21476c;
            tabLayout.L(tabLayout.B(i10), i11 == 0 || (i11 == 2 && this.f21475b == 0));
        }
    }

    public static class d implements TabLayout.d {

        /* renamed from: a, reason: collision with root package name */
        public final ViewPager2 f21477a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f21478b;

        public d(ViewPager2 viewPager2, boolean z10) {
            this.f21477a = viewPager2;
            this.f21478b = z10;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
            this.f21477a.m(gVar.g(), this.f21478b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public b(TabLayout tabLayout, ViewPager2 viewPager2, InterfaceC0238b interfaceC0238b) {
        this(tabLayout, viewPager2, true, interfaceC0238b);
    }

    public void a() {
        if (this.f21469g) {
            throw new IllegalStateException("TabLayoutMediator is already attached");
        }
        RecyclerView.Adapter<?> adapter = this.f21464b.getAdapter();
        this.f21468f = adapter;
        if (adapter == null) {
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        this.f21469g = true;
        c cVar = new c(this.f21463a);
        this.f21470h = cVar;
        this.f21464b.j(cVar);
        d dVar = new d(this.f21464b, this.f21466d);
        this.f21471i = dVar;
        this.f21463a.h(dVar);
        if (this.f21465c) {
            a aVar = new a();
            this.f21472j = aVar;
            this.f21468f.registerAdapterDataObserver(aVar);
        }
        b();
        this.f21463a.N(this.f21464b.getCurrentItem(), 0.0f, true);
    }

    public void b() {
        this.f21463a.H();
        RecyclerView.Adapter<?> adapter = this.f21468f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                TabLayout.g gVarE = this.f21463a.E();
                this.f21467e.a(gVarE, i10);
                this.f21463a.k(gVarE, false);
            }
            if (itemCount > 0) {
                int iMin = Math.min(this.f21464b.getCurrentItem(), this.f21463a.getTabCount() - 1);
                if (iMin != this.f21463a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f21463a;
                    tabLayout.K(tabLayout.B(iMin));
                }
            }
        }
    }

    public b(TabLayout tabLayout, ViewPager2 viewPager2, boolean z10, InterfaceC0238b interfaceC0238b) {
        this(tabLayout, viewPager2, z10, true, interfaceC0238b);
    }

    public b(TabLayout tabLayout, ViewPager2 viewPager2, boolean z10, boolean z11, InterfaceC0238b interfaceC0238b) {
        this.f21463a = tabLayout;
        this.f21464b = viewPager2;
        this.f21465c = z10;
        this.f21466d = z11;
        this.f21467e = interfaceC0238b;
    }
}
