package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.s;
import androidx.lifecycle.q;
import androidx.preference.PreferenceFragmentCompat;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import b.p;
import com.stepos.aiengine.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.f {
    private p onBackPressedCallback;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends p implements SlidingPaneLayout.f {

        /* renamed from: d, reason: collision with root package name */
        public final PreferenceHeaderFragmentCompat f2383d;

        public a(PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat) {
            super(true);
            this.f2383d = preferenceHeaderFragmentCompat;
            preferenceHeaderFragmentCompat.getSlidingPaneLayout().f2608q.add(this);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.f
        public final void a(View panel) {
            kotlin.jvm.internal.g.f(panel, "panel");
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.f
        public final void b(View panel) {
            kotlin.jvm.internal.g.f(panel, "panel");
            e(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.f
        public final void c(View panel) {
            kotlin.jvm.internal.g.f(panel, "panel");
            e(false);
        }

        @Override // b.p
        public final void d() {
            this.f2383d.getSlidingPaneLayout().a();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements View.OnLayoutChangeListener {
        public b() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            if (view == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(kotlin.jvm.internal.g.i("view"));
                kotlin.jvm.internal.g.j(illegalArgumentException, kotlin.jvm.internal.g.class.getName());
                throw illegalArgumentException;
            }
            view.removeOnLayoutChangeListener(this);
            PreferenceHeaderFragmentCompat preferenceHeaderFragmentCompat = PreferenceHeaderFragmentCompat.this;
            p pVar = preferenceHeaderFragmentCompat.onBackPressedCallback;
            kotlin.jvm.internal.g.c(pVar);
            pVar.e(preferenceHeaderFragmentCompat.getSlidingPaneLayout().f2600e && preferenceHeaderFragmentCompat.getSlidingPaneLayout().d());
        }
    }

    private final SlidingPaneLayout buildContentView(LayoutInflater layoutInflater) {
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(R.id.preferences_header);
        SlidingPaneLayout.e eVar = new SlidingPaneLayout.e(getResources().getDimensionPixelSize(R.dimen.preferences_header_width));
        eVar.f2621a = getResources().getInteger(R.integer.preferences_header_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView, eVar);
        FragmentContainerView fragmentContainerView2 = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView2.setId(R.id.preferences_detail);
        SlidingPaneLayout.e eVar2 = new SlidingPaneLayout.e(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width));
        eVar2.f2621a = getResources().getInteger(R.integer.preferences_detail_pane_weight);
        slidingPaneLayout.addView(fragmentContainerView2, eVar2);
        return slidingPaneLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-10, reason: not valid java name */
    public static final void m8onViewCreated$lambda10(PreferenceHeaderFragmentCompat this$0) {
        kotlin.jvm.internal.g.f(this$0, "this$0");
        p pVar = this$0.onBackPressedCallback;
        kotlin.jvm.internal.g.c(pVar);
        ArrayList<androidx.fragment.app.a> arrayList = this$0.getChildFragmentManager().f2016d;
        pVar.e((arrayList != null ? arrayList.size() : 0) == 0);
    }

    private final void openPreferenceHeader(Intent intent) {
        if (intent == null) {
            return;
        }
        startActivity(intent);
    }

    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        super.onAttach(context);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        kotlin.jvm.internal.g.e(parentFragmentManager, "parentFragmentManager");
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(parentFragmentManager);
        aVar.i(this);
        aVar.g(false);
    }

    public Fragment onCreateInitialDetailFragment() {
        Fragment fragmentA = getChildFragmentManager().A(R.id.preferences_header);
        if (fragmentA == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
        }
        PreferenceFragmentCompat preferenceFragmentCompat = (PreferenceFragmentCompat) fragmentA;
        if (preferenceFragmentCompat.getPreferenceScreen().T.size() <= 0) {
            return null;
        }
        int size = preferenceFragmentCompat.getPreferenceScreen().T.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            Preference preferenceD = preferenceFragmentCompat.getPreferenceScreen().D(i10);
            kotlin.jvm.internal.g.e(preferenceD, "headerFragment.preferenc…reen.getPreference(index)");
            String str = preferenceD.f2359q;
            if (str != null) {
                s sVarD = getChildFragmentManager().D();
                requireContext().getClassLoader();
                Fragment fragmentA2 = sVarD.a(str);
                if (fragmentA2 == null) {
                    return fragmentA2;
                }
                fragmentA2.setArguments(preferenceD.d());
                return fragmentA2;
            }
            i10 = i11;
        }
        return null;
    }

    public abstract PreferenceFragmentCompat onCreatePreferenceHeader();

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.g.f(inflater, "inflater");
        SlidingPaneLayout slidingPaneLayoutBuildContentView = buildContentView(inflater);
        if (getChildFragmentManager().A(R.id.preferences_header) == null) {
            PreferenceFragmentCompat preferenceFragmentCompatOnCreatePreferenceHeader = onCreatePreferenceHeader();
            FragmentManager childFragmentManager = getChildFragmentManager();
            kotlin.jvm.internal.g.e(childFragmentManager, "childFragmentManager");
            androidx.fragment.app.a aVar = new androidx.fragment.app.a(childFragmentManager);
            aVar.f2109p = true;
            aVar.d(R.id.preferences_header, preferenceFragmentCompatOnCreatePreferenceHeader, null, 1);
            aVar.g(false);
        }
        slidingPaneLayoutBuildContentView.setLockMode(3);
        return slidingPaneLayoutBuildContentView;
    }

    @Override // androidx.preference.PreferenceFragmentCompat.f
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat caller, Preference pref) {
        kotlin.jvm.internal.g.f(caller, "caller");
        kotlin.jvm.internal.g.f(pref, "pref");
        if (caller.getId() == R.id.preferences_header) {
            openPreferenceHeader(pref);
            return true;
        }
        if (caller.getId() != R.id.preferences_detail) {
            return false;
        }
        s sVarD = getChildFragmentManager().D();
        requireContext().getClassLoader();
        String str = pref.f2359q;
        kotlin.jvm.internal.g.c(str);
        Fragment fragmentA = sVarD.a(str);
        kotlin.jvm.internal.g.e(fragmentA, "childFragmentManager.fra….fragment!!\n            )");
        fragmentA.setArguments(pref.d());
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.g.e(childFragmentManager, "childFragmentManager");
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(childFragmentManager);
        aVar.f2109p = true;
        aVar.e(fragmentA, R.id.preferences_detail);
        aVar.f2100f = 4099;
        aVar.c();
        aVar.g(false);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        b.s sVar;
        OnBackPressedDispatcher onBackPressedDispatcher;
        kotlin.jvm.internal.g.f(view, "view");
        super.onViewCreated(view, bundle);
        this.onBackPressedCallback = new a(this);
        SlidingPaneLayout slidingPaneLayout = getSlidingPaneLayout();
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        if (!slidingPaneLayout.isLaidOut() || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new b());
        } else {
            p pVar = this.onBackPressedCallback;
            kotlin.jvm.internal.g.c(pVar);
            pVar.e(getSlidingPaneLayout().f2600e && getSlidingPaneLayout().d());
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        FragmentManager.l lVar = new FragmentManager.l() { // from class: androidx.preference.d
            @Override // androidx.fragment.app.FragmentManager.l
            public final void onBackStackChanged() {
                PreferenceHeaderFragmentCompat.m8onViewCreated$lambda10(this.f2402a);
            }
        };
        if (childFragmentManager.f2023l == null) {
            childFragmentManager.f2023l = new ArrayList<>();
        }
        childFragmentManager.f2023l.add(lVar);
        while (true) {
            sVar = null;
            if (view == null) {
                break;
            }
            Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
            b.s sVar2 = tag instanceof b.s ? (b.s) tag : null;
            if (sVar2 != null) {
                sVar = sVar2;
                break;
            }
            Object parent = view.getParent();
            if (parent == null) {
                Object tag2 = view.getTag(R.id.view_tree_disjoint_parent);
                parent = tag2 instanceof ViewParent ? (ViewParent) tag2 : null;
            }
            view = parent instanceof View ? (View) parent : null;
        }
        if (sVar == null || (onBackPressedDispatcher = sVar.getOnBackPressedDispatcher()) == null) {
            return;
        }
        q viewLifecycleOwner = getViewLifecycleOwner();
        p pVar2 = this.onBackPressedCallback;
        kotlin.jvm.internal.g.c(pVar2);
        onBackPressedDispatcher.a(viewLifecycleOwner, pVar2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        Fragment fragmentOnCreateInitialDetailFragment;
        super.onViewStateRestored(bundle);
        if (bundle != null || (fragmentOnCreateInitialDetailFragment = onCreateInitialDetailFragment()) == null) {
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.g.e(childFragmentManager, "childFragmentManager");
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(childFragmentManager);
        aVar.f2109p = true;
        aVar.e(fragmentOnCreateInitialDetailFragment, R.id.preferences_detail);
        aVar.g(false);
    }

    private final void openPreferenceHeader(Preference preference) {
        String str = preference.f2359q;
        if (str == null) {
            openPreferenceHeader(preference.f2358p);
            return;
        }
        s sVarD = getChildFragmentManager().D();
        requireContext().getClassLoader();
        Fragment fragmentA = sVarD.a(str);
        if (fragmentA != null) {
            fragmentA.setArguments(preference.d());
        }
        ArrayList<androidx.fragment.app.a> arrayList = getChildFragmentManager().f2016d;
        if ((arrayList != null ? arrayList.size() : 0) > 0) {
            androidx.fragment.app.a aVar = getChildFragmentManager().f2016d.get(0);
            kotlin.jvm.internal.g.e(aVar, "childFragmentManager.getBackStackEntryAt(0)");
            getChildFragmentManager().N(aVar.getId(), false);
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.g.e(childFragmentManager, "childFragmentManager");
        androidx.fragment.app.a aVar2 = new androidx.fragment.app.a(childFragmentManager);
        aVar2.f2109p = true;
        kotlin.jvm.internal.g.c(fragmentA);
        aVar2.e(fragmentA, R.id.preferences_detail);
        if (getSlidingPaneLayout().d()) {
            aVar2.f2100f = 4099;
        }
        SlidingPaneLayout slidingPaneLayout = getSlidingPaneLayout();
        if (!slidingPaneLayout.f2600e) {
            slidingPaneLayout.f2610t = true;
        }
        if (slidingPaneLayout.f2611u || slidingPaneLayout.f(0.0f)) {
            slidingPaneLayout.f2610t = true;
        }
        aVar2.g(false);
    }
}
