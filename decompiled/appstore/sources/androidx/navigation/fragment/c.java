package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.k;
import androidx.navigation.p;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.y;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("dialog")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002-.B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0018\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010*¨\u0006/"}, d2 = {"Landroidx/navigation/fragment/c;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/c$b;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "Landroidx/navigation/NavBackStackEntry;", "popUpTo", "", "savedState", "", "j", "(Landroidx/navigation/NavBackStackEntry;Z)V", "n", "()Landroidx/navigation/fragment/c$b;", "", "entries", "Landroidx/navigation/k;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "e", "(Ljava/util/List;Landroidx/navigation/k;Landroidx/navigation/Navigator$Extras;)V", "Landroidx/navigation/p;", WsConstants.KEY_CONNECTION_STATE, "f", "(Landroidx/navigation/p;)V", "entry", "o", "(Landroidx/navigation/NavBackStackEntry;)V", "c", "Landroid/content/Context;", "d", "Landroidx/fragment/app/FragmentManager;", "", "", "Ljava/util/Set;", "restoredTagsAwaitingAttach", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "observer", "g", "a", "b", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c extends Navigator {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3847g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentManager f3849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f3850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LifecycleEventObserver f3851f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static class b extends NavDestination implements FloatingWindow {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f3852l;

        public b(Navigator r10) {
            q.g(r10, "fragmentNavigator");
            super(r10);
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object r10) {
            if (r10 != null) goto L5;
            return false;
        L5:
            if ((r10 instanceof b) == true) goto L8;
            return false;
        L8:
            if (super.equals(r10) == true) goto L10;
            return false;
        L10:
            if (q.b(this.f3852l, ((b) r10).f3852l) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r10 = super.hashCode() * 31;
            String r11 = this.f3852l;
            if (r11 == null) goto L5;
            int r12 = r11.hashCode();
        L7:
            return r10 + r12;
        L5:
            r12 = 0;
            goto L7
        }

        @Override // androidx.navigation.NavDestination
        public void n(Context r10, AttributeSet r11) {
            q.g(r10, "context");
            q.g(r11, "attrs");
            super.n(r10, r11);
            TypedArray r12 = r10.getResources().obtainAttributes(r11, R$styleable.DialogFragmentNavigator);
            q.f(r12, "context.resources.obtain…ntNavigator\n            )");
            String r13 = r12.getString(R$styleable.DialogFragmentNavigator_android_name);
            if (r13 == null) goto L5;
            u(r13);
        L5:
            r12.recycle();
        }

        public final String t() {
            String r10 = this.f3852l;
            if (r10 == null) goto L9;
            if (r10 == null) goto L7;
            return r10;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L9:
            throw new IllegalStateException("DialogFragment class was not set");
        }

        public final b u(String r10) {
            q.g(r10, "className");
            this.f3852l = r10;
            return this;
        }
    }

    static {
        f3847g = new a(null);
    }

    public c(Context r10, FragmentManager r11) {
        q.g(r10, "context");
        q.g(r11, "fragmentManager");
        this.f3848c = r10;
        this.f3849d = r11;
        this.f3850e = new LinkedHashSet();
        this.f3851f = new androidx.navigation.fragment.a(this);
    }

    public static /* synthetic */ void l(c r10, LifecycleOwner r11, Lifecycle.Event r12) {
        p(r10, r11, r12);
    }

    public static /* synthetic */ void m(c r10, FragmentManager r11, Fragment r12) {
        q(r10, r11, r12);
    }

    public static final void p(c r10, LifecycleOwner r11, Lifecycle.Event r12) {
        q.g(r10, "this$0");
        q.g(r11, "source");
        q.g(r12, "event");
        if (r12 != Lifecycle.Event.ON_CREATE) goto L17;
        DialogFragment r13 = (DialogFragment) r11;
        Iterable r14 = (Iterable) r10.b().b().getValue();
        if ((r14 instanceof Collection) == true) goto L7;
    L9:
        Iterator r15 = r14.iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        if (q.b(((NavBackStackEntry) r15.next()).g(), r13.getTag()) == false) goto L11;
        return;
    L15:
        r13.dismiss();
        return;
    L7:
        if (((Collection) r14).isEmpty() == false) goto L9;
    L17:
        if (r12 != Lifecycle.Event.ON_STOP) goto L42;
        DialogFragment r16 = (DialogFragment) r11;
        if (r16.requireDialog().isShowing() == true) goto L43;
        List r17 = (List) r10.b().b().getValue();
        ListIterator r18 = r17.listIterator(r17.size());
    L22:
        if (r18.hasPrevious() == false) goto L26;
        Object r19 = r18.previous();
        if (q.b(((NavBackStackEntry) r19).g(), r16.getTag()) == false) goto L22;
    L28:
        if (r19 == null) goto L34;
        NavBackStackEntry r20 = (NavBackStackEntry) r19;
        if (q.b(b0.j0(r17), r20) == true) goto L32;
        Log.i("DialogFragmentNavigator", "Dialog " + r16 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
    L32:
        r10.j(r20, false);
        return;
    L34:
        throw new IllegalStateException(("Dialog " + r16 + " has already been popped off of the Navigation back stack").toString());
    L26:
        r19 = null;
        goto L28
    L43:
        return;
    }

    public static final void q(c r10, FragmentManager r11, Fragment r12) {
        q.g(r10, "this$0");
        q.g(r11, "<anonymous parameter 0>");
        q.g(r12, "childFragment");
        Set r13 = r10.f3850e;
        String r14 = r12.getTag();
        if (y.a(r13).remove(r14) == false) goto L6;
        r12.getLifecycle().a(r10.f3851f);
        return;
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination a() {
        return n();
    }

    @Override // androidx.navigation.Navigator
    public void e(List r10, k r11, Navigator.Extras r12) {
        q.g(r10, "entries");
        if (this.f3849d.S0() == false) goto L6;
        Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
        return;
    L6:
        Iterator r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        o((NavBackStackEntry) r13.next());
        goto L8
    }

    @Override // androidx.navigation.Navigator
    public void f(p r10) {
        q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        super.f(r10);
        Iterator r11 = ((List) r10.b().getValue()).iterator();
    L4:
        if (r11.hasNext() == false) goto L11;
        NavBackStackEntry r12 = (NavBackStackEntry) r11.next();
        DialogFragment r13 = (DialogFragment) this.f3849d.i0(r12.g());
        if (r13 == null) goto L10;
        Lifecycle r14 = r13.getLifecycle();
        if (r14 == null) goto L10;
        r14.a(this.f3851f);
    L10:
        this.f3850e.add(r12.g());
        goto L4
    L11:
        this.f3849d.addFragmentOnAttachListener(new androidx.navigation.fragment.b(this));
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry r10, boolean r11) {
        q.g(r10, "popUpTo");
        if (this.f3849d.S0() == false) goto L6;
        Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
        return;
    L6:
        List r12 = (List) b().b().getValue();
        Iterator r13 = b0.p0(r12.subList(r12.indexOf(r10), r12.size())).iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        NavBackStackEntry r14 = (NavBackStackEntry) r13.next();
        Fragment r15 = this.f3849d.i0(r14.g());
        if (r15 == null) goto L8;
        r15.getLifecycle().d(this.f3851f);
        ((DialogFragment) r15).dismiss();
        goto L8
    L12:
        b().g(r10, r11);
    }

    public b n() {
        return new b(this);
    }

    public final void o(NavBackStackEntry r10) {
        b r11 = (b) r10.f();
        String r12 = r11.t();
        if (r12.charAt(0) != '.') goto L5;
        r12 = this.f3848c.getPackageName() + r12;
    L5:
        Fragment r13 = this.f3849d.v0().a(this.f3848c.getClassLoader(), r12);
        q.f(r13, "fragmentManager.fragment…ader, className\n        )");
        if (DialogFragment.class.isAssignableFrom(r13.getClass()) == false) goto L10;
        DialogFragment r14 = (DialogFragment) r13;
        r14.setArguments(r10.d());
        r14.getLifecycle().a(this.f3851f);
        r14.show(this.f3849d, r10.g());
        b().h(r10);
        return;
    L10:
        throw new IllegalArgumentException(("Dialog destination " + r11.t() + " is not an instance of DialogFragment").toString());
    }
}
