package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("fragment")
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0017\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001d\u001a\u00020\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010!J\u0011\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010&J!\u0010(\u001a\u00020'2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010.R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00066"}, d2 = {"Landroidx/navigation/fragment/e;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/fragment/e$b;", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "containerId", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;I)V", "Landroidx/navigation/NavBackStackEntry;", "entry", "Landroidx/navigation/k;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "", "n", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/k;Landroidx/navigation/Navigator$Extras;)V", "popUpTo", "", "savedState", "j", "(Landroidx/navigation/NavBackStackEntry;Z)V", "l", "()Landroidx/navigation/fragment/e$b;", "", "entries", "e", "(Ljava/util/List;Landroidx/navigation/k;Landroidx/navigation/Navigator$Extras;)V", "backStackEntry", "g", "(Landroidx/navigation/NavBackStackEntry;)V", "Landroid/os/Bundle;", "i", "()Landroid/os/Bundle;", "h", "(Landroid/os/Bundle;)V", "Landroidx/fragment/app/FragmentTransaction;", "m", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/k;)Landroidx/fragment/app/FragmentTransaction;", "c", "Landroid/content/Context;", "d", "Landroidx/fragment/app/FragmentManager;", "I", "", "", "f", "Ljava/util/Set;", "savedIds", "a", "b", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class e extends Navigator {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3853g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f3854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentManager f3855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f3856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f3857f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static class b extends NavDestination {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f3858l;

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
            if (q.b(this.f3858l, ((b) r10).f3858l) == false) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int r10 = super.hashCode() * 31;
            String r11 = this.f3858l;
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
            TypedArray r12 = r10.getResources().obtainAttributes(r11, R$styleable.FragmentNavigator);
            q.f(r12, "context.resources.obtain…leable.FragmentNavigator)");
            String r13 = r12.getString(R$styleable.FragmentNavigator_android_name);
            if (r13 == null) goto L5;
            u(r13);
        L5:
            Unit r14 = Unit.f21064a;
            r12.recycle();
        }

        public final String t() {
            String r10 = this.f3858l;
            if (r10 == null) goto L9;
            if (r10 == null) goto L7;
            return r10;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L9:
            throw new IllegalStateException("Fragment class was not set");
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append(super.toString());
            r10.append(" class=");
            String r11 = this.f3858l;
            if (r11 != null) goto L5;
            r10.append("null");
        L6:
            String r12 = r10.toString();
            q.f(r12, "sb.toString()");
            return r12;
        L5:
            r10.append(r11);
            goto L6
        }

        public final b u(String r10) {
            q.g(r10, "className");
            this.f3858l = r10;
            return this;
        }
    }

    static {
        f3853g = new a(null);
    }

    public e(Context r10, FragmentManager r11, int r12) {
        q.g(r10, "context");
        q.g(r11, "fragmentManager");
        this.f3854c = r10;
        this.f3855d = r11;
        this.f3856e = r12;
        this.f3857f = new LinkedHashSet();
    }

    private final void n(NavBackStackEntry r10, k r11, Navigator.Extras r12) {
        boolean r13 = ((List) b().b().getValue()).isEmpty();
        if (r11 == null) goto L11;
        if (r13 == true) goto L11;
        if (r11.i() == false) goto L11;
        if (this.f3857f.remove(r10.g()) == false) goto L11;
        this.f3855d.s1(r10.g());
        b().h(r10);
        return;
    L11:
        FragmentTransaction r14 = m(r10, r11);
        if (r13 == true) goto L14;
        r14.h(r10.g());
    L14:
        r14.j();
        b().h(r10);
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination a() {
        return l();
    }

    @Override // androidx.navigation.Navigator
    public void e(List r10, k r11, Navigator.Extras r12) {
        q.g(r10, "entries");
        if (this.f3855d.S0() == false) goto L6;
        Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
        return;
    L6:
        Iterator r13 = r10.iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        n((NavBackStackEntry) r13.next(), r11, r12);
        goto L8
    }

    @Override // androidx.navigation.Navigator
    public void g(NavBackStackEntry r10) {
        q.g(r10, "backStackEntry");
        if (this.f3855d.S0() == false) goto L6;
        Log.i("FragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
        return;
    L6:
        FragmentTransaction r11 = m(r10, null);
        if (((List) b().b().getValue()).size() <= 1) goto L9;
        this.f3855d.h1(r10.g(), 1);
        r11.h(r10.g());
    L9:
        r11.j();
        b().f(r10);
    }

    @Override // androidx.navigation.Navigator
    public void h(Bundle r10) {
        q.g(r10, "savedState");
        ArrayList<String> r11 = r10.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (r11 == null) goto L6;
        this.f3857f.clear();
        y.v(this.f3857f, r11);
        return;
    }

    @Override // androidx.navigation.Navigator
    public Bundle i() {
        if (this.f3857f.isEmpty() == false) goto L7;
        return null;
    L7:
        return androidx.core.os.c.a(new Pair[]{kotlin.d.a("androidx-nav-fragment:navigator:savedIds", new ArrayList(this.f3857f))});
    }

    @Override // androidx.navigation.Navigator
    public void j(NavBackStackEntry r10, boolean r11) {
        q.g(r10, "popUpTo");
        if (this.f3855d.S0() == false) goto L6;
        Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
        return;
    L6:
        if (r11 == false) goto L14;
        List r12 = (List) b().b().getValue();
        NavBackStackEntry r13 = (NavBackStackEntry) b0.Y(r12);
        Iterator r14 = b0.p0(r12.subList(r12.indexOf(r10), r12.size())).iterator();
    L9:
        if (r14.hasNext() == false) goto L15;
        NavBackStackEntry r15 = (NavBackStackEntry) r14.next();
        if (q.b(r15, r13) == true) goto L12;
        this.f3855d.x1(r15.g());
        this.f3857f.add(r15.g());
        goto L9
    L12:
        Log.i("FragmentNavigator", "FragmentManager cannot save the state of the initial destination " + r15);
    L15:
        b().g(r10, r11);
        return;
    L14:
        this.f3855d.h1(r10.g(), 1);
        goto L15
    }

    public b l() {
        return new b(this);
    }

    public final FragmentTransaction m(NavBackStackEntry r10, k r11) {
        b r12 = (b) r10.f();
        Bundle r13 = r10.d();
        String r14 = r12.t();
        int r15 = 0;
        if (r14.charAt(0) != '.') goto L5;
        r14 = this.f3854c.getPackageName() + r14;
    L5:
        Fragment r16 = this.f3855d.v0().a(this.f3854c.getClassLoader(), r14);
        q.f(r16, "fragmentManager.fragment…t.classLoader, className)");
        r16.setArguments(r13);
        FragmentTransaction r17 = this.f3855d.o();
        q.f(r17, "fragmentManager.beginTransaction()");
        if (r11 == null) goto L8;
        int r18 = r11.a();
    L9:
        if (r11 == null) goto L11;
        int r19 = r11.b();
    L12:
        if (r11 == null) goto L14;
        int r20 = r11.c();
    L15:
        if (r11 == null) goto L17;
        int r21 = r11.d();
    L18:
        if (r18 != (-1)) goto L22;
        if (r19 != (-1)) goto L22;
        if (r20 != (-1)) goto L22;
        if (r21 != (-1)) goto L22;
    L34:
        r17.u(this.f3856e, r16);
        r17.y(r16);
        r17.z(true);
        return r17;
    L22:
        if (r18 != (-1)) goto L25;
        r18 = 0;
    L25:
        if (r19 != (-1)) goto L28;
        r19 = 0;
    L28:
        if (r20 != (-1)) goto L31;
        r20 = 0;
    L31:
        if (r21 == (-1)) goto L33;
        r15 = r21;
    L33:
        r17.w(r18, r19, r20, r15);
        goto L34
    L17:
        r21 = -1;
        goto L18
    L14:
        r20 = -1;
        goto L15
    L11:
        r19 = -1;
        goto L12
    L8:
        r18 = -1;
        goto L9
    }
}
