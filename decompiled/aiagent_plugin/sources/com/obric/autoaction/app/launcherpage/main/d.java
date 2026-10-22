package com.obric.autoaction.app.launcherpage.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.oui.segmentedtab.OBottomNavActionBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: TabManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MainFragment f23968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OBottomNavigationBar f23969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewPager2 f23970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f23971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<IMainTab> f23972e;
    private final b f;

    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return d.b.a.a((Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((IMainTab) ZeusTransformUtils.preCheckCast(r2, IMainTab.class, "com.obric.aiagent.plugin")).order()), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Integer.valueOf(((IMainTab) ZeusTransformUtils.preCheckCast(r3, IMainTab.class, "com.obric.aiagent.plugin")).order()), Comparable.class, "com.obric.aiagent.plugin"));
        }
    }

    public d(MainFragment r8, OBottomNavigationBar r9, ViewPager2 r10, e r11) {
        e r12 = (e) ZeusTransformUtils.wrapperContextForParams(r11, e.class, "com.obric.aiagent.plugin");
        o.e(r8, "fragment");
        o.e(r9, "tabLayout");
        o.e(r10, "viewPager");
        o.e(r12, "onTabSelectedListener");
        this.f23968a = r8;
        this.f23969b = r9;
        this.f23970c = r10;
        this.f23971d = r12;
        Set r13 = ServiceManager.get().getServices(IMainTab.class);
        o.b(r13, "ServiceManager.get().getServices(T::class.java)");
        List<IMainTab> r14 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new a(), Comparator.class, "com.obric.aiagent.plugin"));
        this.f23972e = r14;
        FragmentManager r0 = r8.getChildFragmentManager();
        o.c(r0, "getChildFragmentManager(...)");
        i r15 = r8.getLifecycle();
        o.c(r15, "<get-lifecycle>(...)");
        b r16 = new b(r0, r15);
        this.f = r16;
        r16.a(r14);
        OBottomNavActionBar r17 = r9.getNavigationBar();
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.aiagent.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r18, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r20 = r18.iterator();
    L4:
        if (r20.hasNext() == false) goto L6;
        IMainTab r1 = (IMainTab) ZeusTransformUtils.preCheckCast(r20.next(), IMainTab.class, "com.obric.aiagent.plugin");
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23968a.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "requireContext(...)");
        r19.add(r1.tabConfig(r3).a());
        goto L4
    L6:
        String[] r21 = (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin");
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(this.f23972e, Iterable.class, "com.obric.aiagent.plugin");
        Collection r110 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r2, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        IMainTab r5 = (IMainTab) ZeusTransformUtils.preCheckCast(r4.next(), IMainTab.class, "com.obric.aiagent.plugin");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23968a.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r6, "requireContext(...)");
        int r7 = r5.tabConfig(r6).b();
        Context r22 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f23968a.requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r22, "requireContext(...)");
        Drawable r23 = com.obric.autoaction.app.launcherpage.utils.p.a(r7, r22, null, 2, null);
        if (r23 != null) goto L12;
        r23 = (Drawable) ZeusTransformUtils.preCheckCast(new GradientDrawable(), Drawable.class, "com.obric.aiagent.plugin");
    L12:
        r110.add(r23);
        goto L8
    L13:
        r17.setTabTitleAndDrawable(r21, (Drawable[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new Drawable[0]), Drawable[].class, "com.obric.aiagent.plugin"));
        this.f23969b.getNavigationBar().setOnTabSelectListener((OBottomNavActionBar.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), OBottomNavActionBar.d.class, "com.obric.aiagent.plugin"));
        this.f23970c.registerOnPageChangeCallback((ViewPager2.e) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this), ViewPager2.e.class, "com.obric.aiagent.plugin"));
        this.f23970c.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(this.f, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        this.f23970c.setCurrentItem(0);
        this.f23970c.setUserInputEnabled(false);
    }

    public static final /* synthetic */ List a(d r0) {
        return r0.f23972e;
    }

    public final OBottomNavigationBar a() {
        return this.f23969b;
    }

    public final ViewPager2 b() {
        return this.f23970c;
    }

    public final e c() {
        return this.f23971d;
    }

    public final void a(String r7, Bundle r8) {
        o.e(r7, "tabTag");
        o.e(r8, "args");
        Iterator<IMainTab> r0 = this.f23972e.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (o.a(((IMainTab) ZeusTransformUtils.preCheckCast(r0.next(), IMainTab.class, "com.obric.aiagent.plugin")).tag(), r7) == true) goto L10;
        r2 = r2 + 1;
    L10:
        this.f23970c.setCurrentItem(r2, false);
        this.f23969b.getNavigationBar().setCurrentTab(r2);
        this.f23968a.getChildFragmentManager().a(r7 + "_args", r8);
        return;
    L9:
        r2 = -1;
        goto L10
    }
}
