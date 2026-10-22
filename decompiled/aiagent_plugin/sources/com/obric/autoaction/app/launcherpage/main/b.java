package com.obric.autoaction.app.launcherpage.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: compiled from: MainFragmentViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends androidx.viewpager2.adapter.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.b.d<Fragment> f23963e;
    private final MainFragmentViewPagerAdapter$onTabSingleClickListener$1 f;
    private List<? extends IMainTab> g;

    /* JADX INFO: compiled from: MainFragmentViewPagerAdapter.kt */
    public static final class a extends j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<IMainTab> f23964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f23965b;

        a(List<? extends IMainTab> r3, b r4) {
            this.f23964a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
            this.f23965b = r4;
        }

        @Override // androidx.recyclerview.widget.j.a
        public int a() {
            return this.f23964a.size();
        }

        @Override // androidx.recyclerview.widget.j.a
        public int b() {
            return b.a(this.f23965b).size();
        }

        @Override // androidx.recyclerview.widget.j.a
        public boolean a(int r3, int r4) {
            IMainTab r5 = (IMainTab) ZeusTransformUtils.preCheckCast(p.d(this.f23964a, r3), IMainTab.class, "com.obric.aiagent.plugin");
            String r0 = null;
            if (r5 == null) goto L5;
            String r6 = r5.tag();
        L6:
            IMainTab r2 = (IMainTab) ZeusTransformUtils.preCheckCast(p.d(b.a(this.f23965b), r3), IMainTab.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L10;
            r0 = r2.tag();
        L10:
            return o.a(r6, r0);
        L5:
            r6 = null;
            goto L6
        }

        @Override // androidx.recyclerview.widget.j.a
        public boolean b(int r3, int r4) {
            IMainTab r5 = (IMainTab) ZeusTransformUtils.preCheckCast(p.d(this.f23964a, r3), IMainTab.class, "com.obric.aiagent.plugin");
            String r0 = null;
            if (r5 == null) goto L5;
            String r6 = r5.tag();
        L6:
            IMainTab r2 = (IMainTab) ZeusTransformUtils.preCheckCast(p.d(b.a(this.f23965b), r3), IMainTab.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L10;
            r0 = r2.tag();
        L10:
            return o.a(r6, r0);
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final /* synthetic */ List a(b r0) {
        return r0.g;
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.obric.autoaction.app.launcherpage.main.MainFragmentViewPagerAdapter$onTabSingleClickListener$1] */
    public b(FragmentManager r2, i r3) {
        o.e(r2, "fragmentManager");
        o.e(r3, "lifecycle");
        super(r2, r3);
        Field r4 = androidx.viewpager2.adapter.a.class.getDeclaredField("c");
        r4.setAccessible(true);
        Object r5 = r4.get(this);
        o.a(r5, "null cannot be cast to non-null type androidx.collection.LongSparseArray<androidx.fragment.app.Fragment>");
        this.f23963e = (androidx.b.d) ZeusTransformUtils.preCheckCast(r5, androidx.b.d.class, "com.obric.aiagent.plugin");
        this.f = new MainFragmentViewPagerAdapter$onTabSingleClickListener$1();
        this.g = p.b();
    }

    public final void a(List<? extends IMainTab> r3) {
        List<? extends IMainTab> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "value");
        List<? extends IMainTab> r0 = this.g;
        this.g = r4;
        j.a((j.a) ZeusTransformUtils.preCheckCast(new a(r0, this), j.a.class, "com.obric.aiagent.plugin")).a((RecyclerView.a) ZeusTransformUtils.preCheckCast(this, RecyclerView.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.g.size();
    }

    @Override // androidx.viewpager2.adapter.a
    public Fragment c(int r2) {
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(((IMainTab) ZeusTransformUtils.preCheckCast(this.g.get(r2), IMainTab.class, "com.obric.aiagent.plugin")).fragmentClass().newInstance(), Fragment.class, "com.obric.aiagent.plugin");
        o.c(r1, "let(...)");
        return r1;
    }
}
