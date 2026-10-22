package androidx.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreferenceHeaderFragmentCompat.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u0012\u001a\u00020\u0013H&J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u001a\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\u0012\u0010!\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u001eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006'"}, d2 = {"Landroidx/preference/PreferenceHeaderFragmentCompat;", "Landroidx/fragment/app/Fragment;", "Landroidx/preference/PreferenceFragmentCompat$OnPreferenceStartFragmentCallback;", "()V", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "slidingPaneLayout", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "getSlidingPaneLayout", "()Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "buildContentView", "inflater", "Landroid/view/LayoutInflater;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateInitialDetailFragment", "onCreatePreferenceHeader", "Landroidx/preference/PreferenceFragmentCompat;", "onCreateView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceStartFragment", "", "caller", "pref", "Landroidx/preference/Preference;", "onViewCreated", "view", "onViewStateRestored", "openPreferenceHeader", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "header", "InnerOnBackPressedCallback", "preference_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PreferenceHeaderFragmentCompat extends Fragment implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    private OnBackPressedCallback onBackPressedCallback;

    /* JADX INFO: compiled from: PreferenceHeaderFragmentCompat.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/preference/PreferenceHeaderFragmentCompat$InnerOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$PanelSlideListener;", "caller", "Landroidx/preference/PreferenceHeaderFragmentCompat;", "(Landroidx/preference/PreferenceHeaderFragmentCompat;)V", "handleOnBackPressed", "", "onPanelClosed", "panel", "Landroid/view/View;", "onPanelOpened", "onPanelSlide", "slideOffset", "", "preference_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        private final PreferenceHeaderFragmentCompat caller;

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "panel");
        }

        public InnerOnBackPressedCallback(PreferenceHeaderFragmentCompat r2) {
            Intrinsics.checkNotNullParameter(r2, "caller");
            super(true);
            this.caller = r2;
            r2.getSlidingPaneLayout().addPanelSlideListener(this);
        }

        @Override // androidx.activity.OnBackPressedCallback
        public void handleOnBackPressed() {
            this.caller.getSlidingPaneLayout().closePane();
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelOpened(View r2) {
            Intrinsics.checkNotNullParameter(r2, "panel");
            setEnabled(true);
        }

        @Override // androidx.slidingpanelayout.widget.SlidingPaneLayout.PanelSlideListener
        public void onPanelClosed(View r2) {
            Intrinsics.checkNotNullParameter(r2, "panel");
            setEnabled(false);
        }
    }

    public static /* synthetic */ void $r8$lambda$9O1cI9cyPfNyUipeOQGYqyqFs14(PreferenceHeaderFragmentCompat r0) {
        m64onViewCreated$lambda10(r0);
    }

    public abstract PreferenceFragmentCompat onCreatePreferenceHeader();

    public static final /* synthetic */ OnBackPressedCallback access$getOnBackPressedCallback$p(PreferenceHeaderFragmentCompat r0) {
        return r0.onBackPressedCallback;
    }

    public PreferenceHeaderFragmentCompat() {
    }

    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat r4, Preference r5) {
        Intrinsics.checkNotNullParameter(r4, "caller");
        Intrinsics.checkNotNullParameter(r5, "pref");
        if (r4.getId() != R.id.preferences_header) goto L7;
        openPreferenceHeader(r5);
        return true;
    L7:
        if (r4.getId() != R.id.preferences_detail) goto L10;
        FragmentFactory r6 = getChildFragmentManager().getFragmentFactory();
        ClassLoader r0 = requireContext().getClassLoader();
        String r1 = r5.getFragment();
        Intrinsics.checkNotNull(r1);
        Fragment r7 = r6.instantiate(r0, r1);
        Intrinsics.checkNotNullExpressionValue(r7, "childFragmentManager.fra….fragment!!\n            )");
        r7.setArguments(r5.getExtras());
        FragmentManager r3 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r3, "childFragmentManager");
        FragmentTransaction r8 = r3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r8, "beginTransaction()");
        r8.setReorderingAllowed(true);
        r8.replace(R.id.preferences_detail, r7);
        r8.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        r8.addToBackStack(null);
        r8.commit();
        return true;
    L10:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        FragmentManager r3 = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r3, "parentFragmentManager");
        FragmentTransaction r4 = r3.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r4, "beginTransaction()");
        r4.setPrimaryNavigationFragment(this);
        r4.commit();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        SlidingPaneLayout r4 = buildContentView(r1);
        if (getChildFragmentManager().findFragmentById(R.id.preferences_header) != null) goto L5;
        PreferenceFragmentCompat r5 = onCreatePreferenceHeader();
        FragmentManager r0 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r0, "childFragmentManager");
        FragmentTransaction r6 = r0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r6, "beginTransaction()");
        r6.setReorderingAllowed(true);
        r6.add(R.id.preferences_header, r5);
        r6.commit();
    L5:
        r4.setLockMode(3);
        return r4;
    }

    private final SlidingPaneLayout buildContentView(LayoutInflater r7) {
        SlidingPaneLayout r0 = new SlidingPaneLayout(r7.getContext());
        r0.setId(R.id.preferences_sliding_pane_layout);
        FragmentContainerView r1 = new FragmentContainerView(r7.getContext());
        r1.setId(R.id.preferences_header);
        SlidingPaneLayout.LayoutParams r2 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_header_width), -1);
        r2.weight = getResources().getInteger(R.integer.preferences_header_pane_weight);
        r0.addView(r1, r2);
        FragmentContainerView r3 = new FragmentContainerView(r7.getContext());
        r3.setId(R.id.preferences_detail);
        SlidingPaneLayout.LayoutParams r8 = new SlidingPaneLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.preferences_detail_width), -1);
        r8.weight = getResources().getInteger(R.integer.preferences_detail_pane_weight);
        r0.addView(r3, r8);
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        this.onBackPressedCallback = new InnerOnBackPressedCallback(this);
        SlidingPaneLayout r4 = getSlidingPaneLayout();
        if (ViewCompat.isLaidOut(r4) == true) goto L5;
    L13:
        r4.addOnLayoutChangeListener(new PreferenceHeaderFragmentCompat$onViewCreated$$inlined$doOnLayout$1(this));
    L14:
        getChildFragmentManager().addOnBackStackChangedListener(new PreferenceHeaderFragmentCompat$$ExternalSyntheticLambda0(this));
        OnBackPressedDispatcherOwner r5 = ViewTreeOnBackPressedDispatcherOwner.get(r2);
        if (r5 == null) goto L22;
        OnBackPressedDispatcher r6 = r5.getOnBackPressedDispatcher();
        if (r6 == null) goto L23;
        LifecycleOwner r7 = getViewLifecycleOwner();
        OnBackPressedCallback r1 = this.onBackPressedCallback;
        Intrinsics.checkNotNull(r1);
        r6.addCallback(r7, r1);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r4.isLayoutRequested() == true) goto L13;
        OnBackPressedCallback r8 = access$getOnBackPressedCallback$p(this);
        Intrinsics.checkNotNull(r8);
        if (getSlidingPaneLayout().isSlideable() == true) goto L9;
    L11:
        boolean r0 = false;
    L12:
        r8.setEnabled(r0);
        goto L14
    L9:
        if (getSlidingPaneLayout().isOpen() == false) goto L11;
        r0 = true;
        goto L12
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-10, reason: not valid java name */
    private static final void m64onViewCreated$lambda10(PreferenceHeaderFragmentCompat r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OnBackPressedCallback r0 = r1.onBackPressedCallback;
        Intrinsics.checkNotNull(r0);
        if (r1.getChildFragmentManager().getBackStackEntryCount() != 0) goto L5;
        boolean r2 = true;
    L6:
        r0.setEnabled(r2);
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r2) {
        super.onViewStateRestored(r2);
        if (r2 != null) goto L9;
        Fragment r3 = onCreateInitialDetailFragment();
        if (r3 == null) goto L10;
        FragmentManager r1 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r1, "childFragmentManager");
        FragmentTransaction r4 = r1.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r4, "beginTransaction()");
        r4.setReorderingAllowed(true);
        r4.replace(R.id.preferences_detail, r3);
        r4.commit();
        return;
    L10:
        return;
    }

    public Fragment onCreateInitialDetailFragment() {
        Fragment r0 = getChildFragmentManager().findFragmentById(R.id.preferences_header);
        if (r0 == null) goto L21;
        PreferenceFragmentCompat r1 = (PreferenceFragmentCompat) r0;
        Fragment r2 = null;
        if (r1.getPreferenceScreen().getPreferenceCount() > 0) goto L7;
        return null;
    L7:
        int r3 = r1.getPreferenceScreen().getPreferenceCount();
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L19;
        int r5 = r4 + 1;
        Preference r6 = r1.getPreferenceScreen().getPreference(r4);
        Intrinsics.checkNotNullExpressionValue(r6, "headerFragment.preferenc…reen.getPreference(index)");
        if (r6.getFragment() != null) goto L12;
        r4 = r5;
        goto L8
    L12:
        String r7 = r6.getFragment();
        if (r7 == null) goto L16;
        r2 = getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), r7);
    L16:
        if (r2 == null) goto L19;
        r2.setArguments(r6.getExtras());
    L19:
        return r2;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type androidx.preference.PreferenceFragmentCompat");
    }

    private final void openPreferenceHeader(Preference r4) {
        if (r4.getFragment() != null) goto L6;
        openPreferenceHeader(r4.getIntent());
        return;
    L6:
        String r0 = r4.getFragment();
        if (r0 != null) goto L9;
        Fragment r1 = null;
    L10:
        if (r1 == null) goto L14;
        r1.setArguments(r4.getExtras());
    L14:
        if (getChildFragmentManager().getBackStackEntryCount() <= 0) goto L16;
        FragmentManager.BackStackEntry r5 = getChildFragmentManager().getBackStackEntryAt(0);
        Intrinsics.checkNotNullExpressionValue(r5, "childFragmentManager.getBackStackEntryAt(0)");
        getChildFragmentManager().popBackStack(r5.getId(), 1);
    L16:
        FragmentManager r6 = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(r6, "childFragmentManager");
        FragmentTransaction r7 = r6.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(r7, "beginTransaction()");
        r7.setReorderingAllowed(true);
        int r2 = R.id.preferences_detail;
        Intrinsics.checkNotNull(r1);
        r7.replace(r2, r1);
        if (getSlidingPaneLayout().isOpen() == false) goto L19;
        r7.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    L19:
        getSlidingPaneLayout().openPane();
        r7.commit();
        return;
    L9:
        r1 = getChildFragmentManager().getFragmentFactory().instantiate(requireContext().getClassLoader(), r0);
        goto L10
    }

    private final void openPreferenceHeader(Intent r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        startActivity(r1);
    }
}
