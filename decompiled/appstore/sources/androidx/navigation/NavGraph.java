package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable, KMappedMarker {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f3812p = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.collection.e f3813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3815n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3816o;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        public final NavDestination a(NavGraph r10) {
            kotlin.jvm.internal.q.g(r10, "<this>");
            return (NavDestination) SequencesKt___SequencesKt.r(SequencesKt__SequencesKt.f(r10.u(r10.A()), NavGraph$Companion$findStartDestination$1.INSTANCE));
        }

        public Companion() {
        }
    }

    public static final class a implements Iterator, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NavGraph f3819c;

        public a(NavGraph r10) {
            this.f3819c = r10;
            this.f3817a = -1;
        }

        public NavDestination a() {
            if (hasNext() == false) goto L7;
            this.f3818b = true;
            androidx.collection.e r10 = this.f3819c.y();
            int r11 = this.f3817a + 1;
            this.f3817a = r11;
            Object r12 = r10.o(r11);
            kotlin.jvm.internal.q.f(r12, "nodes.valueAt(++index)");
            return (NavDestination) r12;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if ((this.f3817a + 1) < this.f3819c.y().n()) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f3818b == false) goto L7;
            androidx.collection.e r10 = this.f3819c.y();
            ((NavDestination) r10.o(this.f3817a)).q(null);
            r10.l(this.f3817a);
            this.f3817a--;
            this.f3818b = false;
            return;
        L7:
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    static {
        f3812p = new Companion(null);
    }

    public NavGraph(Navigator r10) {
        kotlin.jvm.internal.q.g(r10, "navGraphNavigator");
        super(r10);
        this.f3813l = new androidx.collection.e();
    }

    public final int A() {
        return this.f3814m;
    }

    public final String B() {
        return this.f3816o;
    }

    public final void C(int r10) {
        if (r10 == i()) goto L10;
        if (this.f3816o == null) goto L7;
        D(null);
    L7:
        this.f3814m = r10;
        this.f3815n = null;
        return;
    L10:
        throw new IllegalArgumentException(("Start destination " + r10 + " cannot use the same id as the graph " + this).toString());
    }

    public final void D(String r10) {
        if (r10 != null) goto L5;
        int r11 = 0;
    L9:
        this.f3814m = r11;
        this.f3816o = r10;
        return;
    L5:
        if (kotlin.jvm.internal.q.b(r10, l()) == true) goto L14;
        if (kotlin.text.o.r(r10) == true) goto L12;
        r11 = NavDestination.f3796j.a(r10).hashCode();
        goto L9
    L12:
        throw new IllegalArgumentException("Cannot have an empty start destination route");
    L14:
        throw new IllegalArgumentException(("Start destination " + r10 + " cannot use the same route as the graph " + this).toString());
    }

    @Override // androidx.navigation.NavDestination
    public boolean equals(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if ((r10 instanceof NavGraph) == false) goto L27;
        List r11 = SequencesKt___SequencesKt.x(SequencesKt__SequencesKt.c(androidx.collection.f.a(this.f3813l)));
        NavGraph r12 = (NavGraph) r10;
        Iterator r13 = androidx.collection.f.a(r12.f3813l);
    L9:
        if (r13.hasNext() == false) goto L12;
        r11.remove((NavDestination) r13.next());
        goto L9
    L12:
        if (super.equals(r10) == true) goto L14;
        return false;
    L14:
        if (this.f3813l.n() == r12.f3813l.n()) goto L16;
        return false;
    L16:
        if (A() == r12.A()) goto L18;
        return false;
    L18:
        if (r11.isEmpty() == false) goto L26;
        return true;
    L26:
        return false;
    L27:
        return false;
    }

    @Override // androidx.navigation.NavDestination
    public String h() {
        if (i() != 0) goto L7;
        return "the root navigation";
    L7:
        return super.h();
    }

    @Override // androidx.navigation.NavDestination
    public int hashCode() {
        int r10 = A();
        androidx.collection.e r11 = this.f3813l;
        int r12 = r11.n();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        int r14 = r11.j(r13);
        r10 = (((r10 * 31) + r14) * 31) + ((NavDestination) r11.o(r13)).hashCode();
        r13 = r13 + 1;
        goto L3
    L5:
        return r10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a(this);
    }

    @Override // androidx.navigation.NavDestination
    public NavDestination.a m(f r10) {
        kotlin.jvm.internal.q.g(r10, "navDeepLinkRequest");
        NavDestination.a r11 = super.m(r10);
        ArrayList r12 = new ArrayList();
        Iterator r13 = iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        NavDestination.a r14 = ((NavDestination) r13.next()).m(r10);
        if (r14 == null) goto L4;
        r12.add(r14);
        goto L4
    L9:
        return (NavDestination.a) b0.k0(t.m(new NavDestination.a[]{r11, (NavDestination.a) b0.k0(r12)}));
    }

    @Override // androidx.navigation.NavDestination
    public void n(Context r10, AttributeSet r11) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r11, "attrs");
        super.n(r10, r11);
        TypedArray r12 = r10.getResources().obtainAttributes(r11, androidx.navigation.common.R$styleable.NavGraphNavigator);
        kotlin.jvm.internal.q.f(r12, "context.resources.obtain…vGraphNavigator\n        )");
        C(r12.getResourceId(androidx.navigation.common.R$styleable.NavGraphNavigator_startDestination, 0));
        this.f3815n = NavDestination.f3796j.b(r10, this.f3814m);
        Unit r13 = Unit.f21064a;
        r12.recycle();
    }

    public final void t(NavDestination r10) {
        kotlin.jvm.internal.q.g(r10, "node");
        int r11 = r10.i();
        String r12 = r10.l();
        if (r11 != 0) goto L9;
        if (r12 != null) goto L9;
        throw new IllegalArgumentException("Destinations must have an id or route. Call setId(), setRoute(), or include an android:id or app:route in your navigation XML.");
    L9:
        if (l() == null) goto L16;
        if (kotlin.jvm.internal.q.b(r12, l()) == false) goto L16;
        throw new IllegalArgumentException(("Destination " + r10 + " cannot have the same route as graph " + this).toString());
    L16:
        if (r11 == i()) goto L29;
        NavDestination r13 = (NavDestination) this.f3813l.f(r11);
        if (r13 != r10) goto L21;
        return;
    L21:
        if (r10.k() != null) goto L27;
        if (r13 == null) goto L24;
        r13.q(null);
    L24:
        r10.q(this);
        this.f3813l.k(r10.i(), r10);
        return;
    L27:
        throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
    L29:
        throw new IllegalArgumentException(("Destination " + r10 + " cannot have the same id as graph " + this).toString());
    }

    @Override // androidx.navigation.NavDestination
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(super.toString());
        NavDestination r11 = w(this.f3816o);
        if (r11 != null) goto L5;
        r11 = u(A());
    L5:
        r10.append(" startDestination=");
        if (r11 != null) goto L14;
        String r12 = this.f3816o;
        if (r12 == null) goto L10;
        r10.append(r12);
    L15:
        String r13 = r10.toString();
        kotlin.jvm.internal.q.f(r13, "sb.toString()");
        return r13;
    L10:
        String r14 = this.f3815n;
        if (r14 == null) goto L13;
        r10.append(r14);
        goto L15
    L13:
        r10.append("0x" + Integer.toHexString(this.f3814m));
        goto L15
    L14:
        r10.append("{");
        r10.append(r11.toString());
        r10.append("}");
        goto L15
    }

    public final NavDestination u(int r10) {
        return v(r10, true);
    }

    public final NavDestination v(int r10, boolean r11) {
        NavDestination r12 = (NavDestination) this.f3813l.f(r10);
        if (r12 != null) goto L10;
        if (r11 == true) goto L6;
    L8:
        return null;
    L6:
        if (k() == null) goto L8;
        NavGraph r13 = k();
        kotlin.jvm.internal.q.d(r13);
        return r13.u(r10);
    L10:
        return r12;
    }

    public final NavDestination w(String r10) {
        if (r10 != null) goto L4;
    L7:
        return null;
    L4:
        if (kotlin.text.o.r(r10) == true) goto L7;
        return x(r10, true);
    }

    public final NavDestination x(String r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.ROUTE);
        int r12 = NavDestination.f3796j.a(r10).hashCode();
        NavDestination r13 = (NavDestination) this.f3813l.f(r12);
        if (r13 != null) goto L10;
        if (r11 == true) goto L6;
    L8:
        return null;
    L6:
        if (k() == null) goto L8;
        NavGraph r14 = k();
        kotlin.jvm.internal.q.d(r14);
        return r14.w(r10);
    L10:
        return r13;
    }

    public final androidx.collection.e y() {
        return this.f3813l;
    }

    public final String z() {
        if (this.f3815n != null) goto L8;
        String r10 = this.f3816o;
        if (r10 != null) goto L7;
        r10 = String.valueOf(this.f3814m);
    L7:
        this.f3815n = r10;
    L8:
        String r11 = this.f3815n;
        kotlin.jvm.internal.q.d(r11);
        return r11;
    }
}
