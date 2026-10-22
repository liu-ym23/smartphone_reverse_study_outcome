package androidx.navigation.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;
import androidx.navigation.i;
import androidx.navigation.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0015¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0015¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001b0\u001aH\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b#\u0010$J!\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\"2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b&\u0010'J)\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0017¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\nH\u0017¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0011\u0010\u0013\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010B\u001a\u0002078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006D"}, d2 = {"Landroidx/navigation/fragment/f;", "Landroidx/fragment/app/Fragment;", "Landroidx/navigation/NavHost;", "<init>", "()V", "Landroid/content/Context;", "context", "", "onAttach", "(Landroid/content/Context;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroidx/navigation/i;", "navHostController", "m", "(Landroidx/navigation/i;)V", "Landroidx/navigation/NavController;", "navController", "l", "(Landroidx/navigation/NavController;)V", "", "isPrimaryNavigationFragment", "onPrimaryNavigationFragmentChanged", "(Z)V", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/e$b;", "j", "()Landroidx/navigation/Navigator;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/util/AttributeSet;", "attrs", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onDestroyView", "a", "Landroidx/navigation/i;", "b", "Ljava/lang/Boolean;", "isPrimaryBeforeOnCreate", "c", "Landroid/view/View;", "viewParent", "", "d", "I", "graphId", "e", "Z", "defaultNavHost", "getNavController", "()Landroidx/navigation/NavController;", "k", "()I", "containerId", "f", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class f extends Fragment implements NavHost {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3859f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f3860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f3861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f3862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3864e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final NavController a(Fragment r10) {
            q.g(r10, "fragment");
            Fragment r11 = r10;
        L3:
            if (r11 == null) goto L19;
            if ((r11 instanceof f) == true) goto L6;
            Fragment r12 = r11.getParentFragmentManager().C0();
            if ((r12 instanceof f) == true) goto L13;
            r11 = r11.getParentFragment();
            goto L3
        L13:
            i r13 = f.i((f) r12);
            if (r13 == null) goto L17;
            return r13;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
        L6:
            i r14 = f.i((f) r11);
            if (r14 == null) goto L10;
            return r14;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavController");
        L19:
            View r15 = r10.getView();
            if (r15 != null) goto L22;
            View r16 = null;
            if ((r10 instanceof DialogFragment) == false) goto L26;
            DialogFragment r17 = (DialogFragment) r10;
        L27:
            if (r17 == null) goto L33;
            Dialog r18 = r17.getDialog();
            if (r18 == null) goto L33;
            Window r19 = r18.getWindow();
            if (r19 == null) goto L33;
            r16 = r19.getDecorView();
        L33:
            if (r16 == null) goto L37;
            return Navigation.b(r16);
        L37:
            throw new IllegalStateException("Fragment " + r10 + " does not have a NavController set");
        L26:
            r17 = null;
            goto L27
        L22:
            return Navigation.b(r15);
        }

        public a() {
        }
    }

    static {
        f3859f = new a(null);
    }

    public f() {
    }

    public static final /* synthetic */ i i(f r10) {
        return r10.f3860a;
    }

    @Override // androidx.navigation.NavHost
    public final NavController getNavController() {
        i r10 = this.f3860a;
        if (r10 == null) goto L9;
        if (r10 == null) goto L7;
        return r10;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavHostController");
    L9:
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    public Navigator j() {
        Context r10 = requireContext();
        q.f(r10, "requireContext()");
        FragmentManager r11 = getChildFragmentManager();
        q.f(r11, "childFragmentManager");
        return new e(r10, r11, k());
    }

    public final int k() {
        int r10 = getId();
        if (r10 == 0) goto L8;
        if (r10 == (-1)) goto L8;
        return r10;
    L8:
        return R$id.nav_host_fragment_container;
    }

    public void l(NavController r10) {
        q.g(r10, "navController");
        o r11 = r10.F();
        Context r12 = requireContext();
        q.f(r12, "requireContext()");
        FragmentManager r13 = getChildFragmentManager();
        q.f(r13, "childFragmentManager");
        r11.b(new c(r12, r13));
        r10.F().b(j());
    }

    public void m(i r10) {
        q.g(r10, "navHostController");
        l(r10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r10) {
        q.g(r10, "context");
        super.onAttach(r10);
        if (this.f3864e == false) goto L6;
        getParentFragmentManager().o().y(this).j();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r10) {
        Context r11 = requireContext();
        q.f(r11, "requireContext()");
        i r12 = new i(r11);
        this.f3860a = r12;
        q.d(r12);
        r12.d0(this);
        Object r13 = r11;
    L4:
        if ((r13 instanceof ContextWrapper) == false) goto L9;
        if ((r13 instanceof OnBackPressedDispatcherOwner) == true) goto L7;
        Context r14 = ((ContextWrapper) r13).getBaseContext();
        q.f(r14, "context.baseContext");
        r13 = r14;
        goto L4
    L7:
        i r15 = this.f3860a;
        q.d(r15);
        OnBackPressedDispatcher r16 = ((OnBackPressedDispatcherOwner) r13).getOnBackPressedDispatcher();
        q.f(r16, "context as OnBackPressed…).onBackPressedDispatcher");
        r15.e0(r16);
    L9:
        i r17 = this.f3860a;
        q.d(r17);
        Boolean r18 = this.f3861b;
        int r19 = 0;
        if (r18 == null) goto L17;
        if (r18 == null) goto L16;
        if (r18.booleanValue() == false) goto L17;
        boolean r20 = true;
    L18:
        r17.r(r20);
        Bundle r21 = null;
        this.f3861b = null;
        i r22 = this.f3860a;
        q.d(r22);
        ViewModelStore r23 = getViewModelStore();
        q.f(r23, "viewModelStore");
        r22.f0(r23);
        i r24 = this.f3860a;
        q.d(r24);
        m(r24);
        if (r10 == null) goto L24;
        Bundle r25 = r10.getBundle("android-support-nav:fragment:navControllerState");
        if (r10.getBoolean("android-support-nav:fragment:defaultHost", false) == false) goto L23;
        this.f3864e = true;
        getParentFragmentManager().o().y(this).j();
    L23:
        this.f3863d = r10.getInt("android-support-nav:fragment:graphId");
    L25:
        if (r25 == null) goto L28;
        i r26 = this.f3860a;
        q.d(r26);
        r26.X(r25);
    L28:
        if (this.f3863d == 0) goto L30;
        i r27 = this.f3860a;
        q.d(r27);
        r27.a0(this.f3863d);
    L37:
        super.onCreate(r10);
        return;
    L30:
        Bundle r28 = getArguments();
        if (r28 == null) goto L33;
        r19 = r28.getInt("android-support-nav:fragment:graphId");
    L33:
        if (r28 == null) goto L35;
        r21 = r28.getBundle("android-support-nav:fragment:startDestinationArgs");
    L35:
        if (r19 == 0) goto L37;
        i r29 = this.f3860a;
        q.d(r29);
        r29.b0(r19, r21);
        goto L37
    L24:
        r25 = null;
        goto L25
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L17:
        r20 = false;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        q.g(r10, "inflater");
        Context r13 = r10.getContext();
        q.f(r13, "inflater.context");
        FragmentContainerView r14 = new FragmentContainerView(r13);
        r14.setId(k());
        return r14;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View r10 = this.f3862c;
        if (r10 != null) goto L5;
    L7:
        this.f3862c = null;
        return;
    L5:
        if (Navigation.b(r10) != this.f3860a) goto L7;
        Navigation.e(r10, null);
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context r10, AttributeSet r11, Bundle r12) {
        q.g(r10, "context");
        q.g(r11, "attrs");
        super.onInflate(r10, r11, r12);
        TypedArray r13 = r10.obtainStyledAttributes(r11, androidx.navigation.R$styleable.NavHost);
        q.f(r13, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int r14 = r13.getResourceId(androidx.navigation.R$styleable.NavHost_navGraph, 0);
        if (r14 == 0) goto L5;
        this.f3863d = r14;
    L5:
        Unit r15 = Unit.f21064a;
        r13.recycle();
        TypedArray r16 = r10.obtainStyledAttributes(r11, R$styleable.NavHostFragment);
        q.f(r16, "context.obtainStyledAttr…tyleable.NavHostFragment)");
        if (r16.getBoolean(R$styleable.NavHostFragment_defaultNavHost, false) == false) goto L8;
        this.f3864e = true;
    L8:
        r16.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrimaryNavigationFragmentChanged(boolean r10) {
        i r11 = this.f3860a;
        if (r11 == null) goto L6;
        if (r11 == null) goto L8;
        r11.r(r10);
        return;
    L8:
        return;
    L6:
        this.f3861b = Boolean.valueOf(r10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r10) {
        q.g(r10, "outState");
        super.onSaveInstanceState(r10);
        i r11 = this.f3860a;
        q.d(r11);
        Bundle r12 = r11.Z();
        if (r12 == null) goto L6;
        r10.putBundle("android-support-nav:fragment:navControllerState", r12);
    L6:
        if (this.f3864e == false) goto L8;
        r10.putBoolean("android-support-nav:fragment:defaultHost", true);
    L8:
        int r13 = this.f3863d;
        if (r13 == 0) goto L12;
        r10.putInt("android-support-nav:fragment:graphId", r13);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r10, Bundle r11) {
        q.g(r10, "view");
        super.onViewCreated(r10, r11);
        if ((r10 instanceof ViewGroup) == false) goto L15;
        Navigation.e(r10, this.f3860a);
        if (r10.getParent() == null) goto L13;
        Object r12 = r10.getParent();
        if (r12 == null) goto L12;
        View r13 = (View) r12;
        this.f3862c = r13;
        q.d(r13);
        if (r13.getId() != getId()) goto L16;
        View r14 = this.f3862c;
        q.d(r14);
        Navigation.e(r14, this.f3860a);
        return;
    L16:
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L13:
        return;
    L15:
        throw new IllegalStateException(("created host view " + r10 + " is not a ViewGroup").toString());
    }
}
