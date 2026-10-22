package androidx.navigation;

import android.os.Bundle;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;

/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("navigation")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u0011\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/navigation/g;", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavGraph;", "Landroidx/navigation/o;", "navigatorProvider", "<init>", "(Landroidx/navigation/o;)V", "l", "()Landroidx/navigation/NavGraph;", "", "Landroidx/navigation/NavBackStackEntry;", "entries", "Landroidx/navigation/k;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "", "e", "(Ljava/util/List;Landroidx/navigation/k;Landroidx/navigation/Navigator$Extras;)V", "entry", "m", "(Landroidx/navigation/NavBackStackEntry;Landroidx/navigation/k;Landroidx/navigation/Navigator$Extras;)V", "c", "Landroidx/navigation/o;", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class g extends Navigator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f3865c;

    public g(o r10) {
        kotlin.jvm.internal.q.g(r10, "navigatorProvider");
        this.f3865c = r10;
    }

    @Override // androidx.navigation.Navigator
    public /* bridge */ /* synthetic */ NavDestination a() {
        return l();
    }

    @Override // androidx.navigation.Navigator
    public void e(List r10, k r11, Navigator.Extras r12) {
        kotlin.jvm.internal.q.g(r10, "entries");
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        m((NavBackStackEntry) r13.next(), r11, r12);
        goto L4
    }

    public NavGraph l() {
        return new NavGraph(this);
    }

    public final void m(NavBackStackEntry r10, k r11, Navigator.Extras r12) {
        NavGraph r13 = (NavGraph) r10.f();
        Bundle r14 = r10.d();
        int r15 = r13.A();
        String r16 = r13.B();
        if (r15 != 0) goto L9;
        if (r16 != null) goto L9;
        throw new IllegalStateException(("no start destination defined via app:startDestination for " + r13.h()).toString());
    L9:
        if (r16 == null) goto L11;
        NavDestination r17 = r13.x(r16, false);
    L12:
        if (r17 == null) goto L16;
        this.f3865c.d(r17.j()).e(s.e(b().a(r17, r17.d(r14))), r11, r12);
        return;
    L16:
        throw new IllegalArgumentException("navigation destination " + r13.z() + " is not a direct child of this NavGraph");
    L11:
        r17 = r13.v(r15, false);
        goto L12
    }
}
