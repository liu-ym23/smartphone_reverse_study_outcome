package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.capabilitykit.common.UiType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.y;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class NavController {
    public static final a G = null;
    public static boolean H;
    public final Map A;
    public int B;
    public final List C;
    public final Lazy D;
    public final MutableSharedFlow E;
    public final Flow F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f3746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f3747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NavGraph f3748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Bundle f3749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Parcelable[] f3750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final kotlin.collections.i f3752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableStateFlow f3753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final StateFlow f3754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f3755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f3756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map f3757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map f3758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LifecycleOwner f3759o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public OnBackPressedDispatcher f3760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f3761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f3762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Lifecycle.State f3763s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final LifecycleObserver f3764t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final androidx.activity.l f3765u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3766v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public o f3767w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map f3768x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function1 f3769y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1 f3770z;

    public final class NavControllerNavigatorState extends p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Navigator f3771g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ NavController f3772h;

        public NavControllerNavigatorState(NavController r10, Navigator r11) {
            kotlin.jvm.internal.q.g(r11, "navigator");
            this.f3772h = r10;
            this.f3771g = r11;
        }

        public static final /* synthetic */ void j(NavControllerNavigatorState r10, NavBackStackEntry r11, boolean r12) {
            super.g(r11, r12);
        }

        @Override // androidx.navigation.p
        public NavBackStackEntry a(NavDestination r12, Bundle r13) {
            kotlin.jvm.internal.q.g(r12, "destination");
            return NavBackStackEntry.a.b(NavBackStackEntry.f3729n, this.f3772h.y(), r12, r13, this.f3772h.D(), NavController.j(this.f3772h), null, null, 96, null);
        }

        @Override // androidx.navigation.p
        public void e(NavBackStackEntry r10) {
            kotlin.jvm.internal.q.g(r10, "entry");
            boolean r11 = kotlin.jvm.internal.q.b(NavController.f(this.f3772h).get(r10), Boolean.TRUE);
            super.e(r10);
            NavController.f(this.f3772h).remove(r10);
            if (this.f3772h.v().contains(r10) == true) goto L24;
            this.f3772h.g0(r10);
            if (r10.getLifecycle().b().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
            r10.k(Lifecycle.State.DESTROYED);
        L7:
            kotlin.collections.i r12 = this.f3772h.v();
            if (r12 != null) goto L10;
        L12:
            Iterator<E> r13 = r12.iterator();
        L14:
            if (r13.hasNext() == false) goto L18;
            if (kotlin.jvm.internal.q.b(((NavBackStackEntry) r13.next()).g(), r10.g()) == false) goto L14;
        L22:
            this.f3772h.h0();
            NavController.l(this.f3772h).tryEmit(this.f3772h.W());
            return;
        L18:
            if (r11 == true) goto L22;
            e r14 = NavController.j(this.f3772h);
            if (r14 == null) goto L22;
            r14.g(r10.g());
            goto L22
        L10:
            if (r12.isEmpty() == false) goto L12;
        L24:
            if (d() == true) goto L31;
            this.f3772h.h0();
            NavController.l(this.f3772h).tryEmit(this.f3772h.W());
            return;
        }

        @Override // androidx.navigation.p
        public void g(final NavBackStackEntry r10, final boolean r11) {
            kotlin.jvm.internal.q.g(r10, "popUpTo");
            Navigator r12 = NavController.k(this.f3772h).d(r10.f().j());
            if (kotlin.jvm.internal.q.b(r12, this.f3771g) == false) goto L8;
            Function1 r13 = NavController.i(this.f3772h);
            if (r13 == null) goto L7;
            r13.invoke(r10);
            super.g(r10, r11);
            return;
        L7:
            this.f3772h.Q(r10, new NavController$NavControllerNavigatorState$pop$1(this, r10, r11));
            return;
        L8:
            Object r14 = NavController.h(this.f3772h).get(r12);
            kotlin.jvm.internal.q.d(r14);
            ((NavControllerNavigatorState) r14).g(r10, r11);
        }

        @Override // androidx.navigation.p
        public void h(NavBackStackEntry r10) {
            kotlin.jvm.internal.q.g(r10, "backStackEntry");
            Navigator r11 = NavController.k(this.f3772h).d(r10.f().j());
            if (kotlin.jvm.internal.q.b(r11, this.f3771g) == false) goto L8;
            Function1 r12 = NavController.c(this.f3772h);
            if (r12 == null) goto L7;
            r12.invoke(r10);
            k(r10);
            return;
        L7:
            Log.i("NavController", "Ignoring add of destination " + r10.f() + " outside of the call to navigate(). ");
            return;
        L8:
            Object r13 = NavController.h(this.f3772h).get(r11);
            if (r13 == null) goto L13;
            ((NavControllerNavigatorState) r13).h(r10);
            return;
        L13:
            throw new IllegalStateException(("NavigatorBackStack for " + r10.f().j() + " should already be created").toString());
        }

        public final void k(NavBackStackEntry r10) {
            kotlin.jvm.internal.q.g(r10, "backStackEntry");
            super.h(r10);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", "destination", "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(@NotNull NavController r10, @NotNull NavDestination r11, @Nullable Bundle r12);
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    public static final class b extends androidx.activity.l {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ NavController f3773d;

        public b(NavController r10) {
            this.f3773d = r10;
            super(false);
        }

        @Override // androidx.activity.l
        public void d() {
            this.f3773d.N();
        }
    }

    static {
        G = new a(null);
        H = true;
    }

    public NavController(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        this.f3745a = r10;
        Iterator r11 = SequencesKt__SequencesKt.f(r10, NavController$activity$1.INSTANCE).iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if ((((Context) r12) instanceof Activity) == false) goto L4;
    L9:
        this.f3746b = (Activity) r12;
        this.f3752h = new kotlin.collections.i();
        MutableStateFlow r13 = f1.a(t.i());
        this.f3753i = r13;
        this.f3754j = kotlinx.coroutines.flow.c.b(r13);
        this.f3755k = new LinkedHashMap();
        this.f3756l = new LinkedHashMap();
        this.f3757m = new LinkedHashMap();
        this.f3758n = new LinkedHashMap();
        this.f3762r = new CopyOnWriteArrayList();
        this.f3763s = Lifecycle.State.INITIALIZED;
        this.f3764t = new d(this);
        this.f3765u = new b(this);
        this.f3766v = true;
        this.f3767w = new o();
        this.f3768x = new LinkedHashMap();
        this.A = new LinkedHashMap();
        o r14 = this.f3767w;
        r14.b(new g(r14));
        this.f3767w.b(new ActivityNavigator(this.f3745a));
        this.C = new ArrayList();
        this.D = kotlin.b.b(new NavController$navInflater$2(this));
        MutableSharedFlow r15 = b1.b(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this.E = r15;
        this.F = kotlinx.coroutines.flow.c.a(r15);
        return;
    L8:
        r12 = null;
        goto L9
    }

    public static final void I(NavController r10, LifecycleOwner r11, Lifecycle.Event r12) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        kotlin.jvm.internal.q.g(r11, "<anonymous parameter 0>");
        kotlin.jvm.internal.q.g(r12, "event");
        Lifecycle.State r13 = r12.getTargetState();
        kotlin.jvm.internal.q.f(r13, "event.targetState");
        r10.f3763s = r13;
        if (r10.f3748d == null) goto L8;
        Iterator r14 = r10.v().iterator();
    L6:
        if (r14.hasNext() == false) goto L10;
        ((NavBackStackEntry) r14.next()).handleLifecycleEvent(r12);
        goto L6
    L10:
        return;
    }

    public static /* synthetic */ boolean T(NavController r10, int r11, boolean r12, boolean r13, int r14, Object r15) {
        if (r15 != null) goto L9;
        if ((r14 & 4) == 0) goto L7;
        r13 = false;
    L7:
        return r10.S(r11, r12, r13);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    public static /* synthetic */ void V(NavController r10, NavBackStackEntry r11, boolean r12, kotlin.collections.i r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = false;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = new kotlin.collections.i();
    L9:
        r10.U(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    public static /* synthetic */ void a(NavController r10, LifecycleOwner r11, Lifecycle.Event r12) {
        I(r10, r11, r12);
    }

    public static final /* synthetic */ void b(NavController r10, NavDestination r11, Bundle r12, NavBackStackEntry r13, List r14) {
        r10.n(r11, r12, r13, r14);
    }

    public static final /* synthetic */ Function1 c(NavController r10) {
        return r10.f3769y;
    }

    public static final /* synthetic */ Map d(NavController r10) {
        return r10.f3757m;
    }

    public static final /* synthetic */ boolean e() {
        return H;
    }

    public static final /* synthetic */ Map f(NavController r10) {
        return r10.A;
    }

    public static final /* synthetic */ j g(NavController r10) {
        return r10.f3747c;
    }

    public static final /* synthetic */ Map h(NavController r10) {
        return r10.f3768x;
    }

    public static final /* synthetic */ Function1 i(NavController r10) {
        return r10.f3770z;
    }

    public static final /* synthetic */ e j(NavController r10) {
        return r10.f3761q;
    }

    public static final /* synthetic */ o k(NavController r10) {
        return r10.f3767w;
    }

    public static final /* synthetic */ MutableStateFlow l(NavController r10) {
        return r10.f3753i;
    }

    public static final /* synthetic */ void m(NavController r10, NavBackStackEntry r11, boolean r12, kotlin.collections.i r13) {
        r10.U(r11, r12, r13);
    }

    public static /* synthetic */ void o(NavController r10, NavDestination r11, Bundle r12, NavBackStackEntry r13, List r14, int r15, Object r16) {
        if (r16 != null) goto L9;
        if ((r15 & 8) == 0) goto L6;
        r14 = t.i();
    L6:
        r10.n(r11, r12, r13, r14);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    public NavDestination A() {
        NavBackStackEntry r10 = z();
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.f();
    }

    public final int B() {
        kotlin.collections.i r10 = v();
        int r11 = 0;
        if (r10 != null) goto L5;
    L7:
        Iterator<E> r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        if ((((NavBackStackEntry) r12.next()).f() instanceof NavGraph) == true) goto L9;
        r11 = r11 + 1;
        if (r11 >= 0) goto L9;
        t.p();
    L15:
        return r11;
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L7
    }

    public NavGraph C() {
        NavGraph r10 = this.f3748d;
        if (r10 == null) goto L9;
        if (r10 == null) goto L7;
        return r10;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
    L9:
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public final Lifecycle.State D() {
        if (this.f3759o != null) goto L6;
        return Lifecycle.State.CREATED;
    L6:
        return this.f3763s;
    }

    public j E() {
        return (j) this.D.getValue();
    }

    public o F() {
        return this.f3767w;
    }

    public boolean G(Intent r20) {
        int r10 = 0;
        if (r20 != null) goto L5;
        return false;
    L5:
        Bundle r11 = r20.getExtras();
        if (r11 == null) goto L8;
        int[] r12 = r11.getIntArray("android-support-nav:controller:deepLinkIds");
    L9:
        if (r11 == null) goto L11;
        ArrayList r13 = r11.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
    L12:
        Bundle r14 = new Bundle();
        if (r11 == null) goto L15;
        Bundle r15 = r11.getBundle("android-support-nav:controller:deepLinkExtras");
    L16:
        if (r15 == null) goto L19;
        r14.putAll(r15);
    L19:
        if (r12 != null) goto L21;
    L22:
        NavGraph r16 = this.f3748d;
        kotlin.jvm.internal.q.d(r16);
        NavDestination.a r17 = r16.m(new f(r20));
        if (r17 == null) goto L28;
        NavDestination r18 = r17.b();
        int[] r19 = NavDestination.f(r18, null, 1, null);
        Bundle r21 = r18.d(r17.c());
        if (r21 == null) goto L27;
        r14.putAll(r21);
    L27:
        int[] r110 = r19;
        r13 = null;
    L29:
        if (r110 != null) goto L31;
    L88:
        return false;
    L31:
        if (r110.length == 0) goto L88;
        String r22 = u(r110);
        if (r22 == null) goto L37;
        Log.i("NavController", "Could not find destination " + r22 + " in the navigation graph, ignoring the deep link from " + r20);
        return false;
    L37:
        r14.putParcelable("android-support-nav:controller:deepLinkIntent", r20);
        int r23 = r110.length;
        Bundle[] r111 = new Bundle[r23];
        int r24 = 0;
    L38:
        if (r24 >= r23) goto L45;
        Bundle r25 = new Bundle();
        r25.putAll(r14);
        if (r13 == null) goto L44;
        Bundle r112 = (Bundle) r13.get(r24);
        if (r112 == null) goto L44;
        r25.putAll(r112);
    L44:
        r111[r24] = r25;
        r24 = r24 + 1;
        goto L38
    L45:
        int r26 = r20.getFlags();
        int r27 = 268435456 & r26;
        if (r27 == 0) goto L54;
        if ((r26 & UiType.FLAG_SETTINGS_CARD) != 0) goto L54;
        r20.addFlags(UiType.FLAG_SETTINGS_CARD);
        TaskStackBuilder r28 = TaskStackBuilder.e(this.f3745a).b(r20);
        kotlin.jvm.internal.q.f(r28, "create(context)\n        …ntWithParentStack(intent)");
        r28.f();
        Activity r29 = this.f3746b;
        if (r29 == null) goto L52;
        r29.finish();
        r29.overridePendingTransition(0, 0);
    L52:
        return true;
    L54:
        if (r27 != 0) goto L56;
        NavGraph r30 = this.f3748d;
        int r31 = r110.length;
        int r32 = 0;
    L67:
        if (r32 >= r31) goto L86;
        int r33 = r110[r32];
        Bundle r34 = r111[r32];
        if (r32 != 0) goto L71;
        NavDestination r35 = this.f3748d;
    L72:
        if (r35 == null) goto L85;
        if (r32 != (r110.length - 1)) goto L76;
        k.a r113 = new k.a();
        NavGraph r36 = this.f3748d;
        kotlin.jvm.internal.q.d(r36);
        K(r35, r34, k.a.i(r113, r36.i(), true, false, 4, null).b(0).c(0).a(), null);
    L83:
        r32 = r32 + 1;
        goto L67
    L76:
        if ((r35 instanceof NavGraph) == false) goto L83;
    L78:
        NavGraph r37 = (NavGraph) r35;
        kotlin.jvm.internal.q.d(r37);
        if ((r37.u(r37.A()) instanceof NavGraph) == false) goto L81;
        r35 = r37.u(r37.A());
        goto L78
    L81:
        r30 = r37;
        goto L83
    L85:
        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f3796j.b(this.f3745a, r33) + " cannot be found in graph " + r30);
    L71:
        kotlin.jvm.internal.q.d(r30);
        r35 = r30.u(r33);
        goto L72
    L86:
        this.f3751g = true;
        return true;
    L56:
        if (v().isEmpty() == true) goto L59;
        NavGraph r38 = this.f3748d;
        kotlin.jvm.internal.q.d(r38);
        T(this, r38.i(), true, false, 4, null);
    L59:
        if (r10 >= r110.length) goto L65;
        int r39 = r110[r10];
        int r40 = r10 + 1;
        Bundle r41 = r111[r10];
        final NavDestination r42 = s(r39);
        if (r42 == null) goto L64;
        K(r42, r41, m.a(new NavController$handleDeepLink$2(r42, this)), null);
        r10 = r40;
        goto L59
    L64:
        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.f3796j.b(this.f3745a, r39) + " cannot be found from the current destination " + A());
    L65:
        return true;
    L28:
        r110 = r12;
        goto L29
    L21:
        if (r12.length != 0) goto L28;
    L15:
        r15 = null;
        goto L16
    L11:
        r13 = null;
        goto L12
    L8:
        r12 = null;
        goto L9
    }

    public final List H(kotlin.collections.i r10) {
        ArrayList r11 = new ArrayList();
        NavBackStackEntry r12 = (NavBackStackEntry) v().g();
        if (r12 == null) goto L6;
        NavDestination r13 = r12.f();
        if (r13 == null) goto L6;
    L7:
        if (r10 == null) goto L16;
        Iterator<E> r14 = r10.iterator();
    L10:
        if (r14.hasNext() == false) goto L16;
        NavBackStackEntryState r15 = (NavBackStackEntryState) r14.next();
        NavDestination r16 = t(r13, r15.getDestinationId());
        if (r16 == null) goto L15;
        r11.add(r15.instantiate(this.f3745a, r16, D(), this.f3761q));
        r13 = r16;
        goto L10
    L15:
        throw new IllegalStateException(("Restore State failed: destination " + NavDestination.f3796j.b(this.f3745a, r15.getDestinationId()) + " cannot be found from the current destination " + r13).toString());
    L16:
        return r11;
    L6:
        r13 = C();
        goto L7
    }

    public final void J(NavBackStackEntry r10, NavBackStackEntry r11) {
        this.f3755k.put(r10, r11);
        if (this.f3756l.get(r11) != null) goto L5;
        this.f3756l.put(r11, new AtomicInteger(0));
    L5:
        Object r12 = this.f3756l.get(r11);
        kotlin.jvm.internal.q.d(r12);
        ((AtomicInteger) r12).incrementAndGet();
    }

    public final void K(final NavDestination r21, Bundle r22, k r23, Navigator.Extras r24) {
        Iterator r10 = this.f3768x.values().iterator();
    L3:
        boolean r11 = true;
        if (r10.hasNext() == false) goto L6;
        ((NavControllerNavigatorState) r10.next()).i(true);
        goto L3
    L6:
        final Ref$BooleanRef r12 = new Ref$BooleanRef();
        if (r23 != null) goto L9;
    L11:
        boolean r13 = false;
    L12:
        final Bundle r14 = r21.d(r22);
        if (r23 != null) goto L15;
    L19:
        NavBackStackEntry r15 = z();
        Navigator r16 = this.f3767w.d(r21.j());
        if (r23 != null) goto L22;
    L32:
        L(r16, s.e(NavBackStackEntry.a.b(NavBackStackEntry.f3729n, this.f3745a, r21, r14, D(), this.f3761q, null, null, 96, null)), r23, r24, new NavController$navigate$4(r12, this, r21, r14));
    L33:
        r11 = false;
    L34:
        i0();
        Iterator r17 = this.f3768x.values().iterator();
    L36:
        if (r17.hasNext() == false) goto L38;
        ((NavControllerNavigatorState) r17.next()).i(false);
        goto L36
    L38:
        if (r13 == false) goto L40;
    L44:
        q();
        return;
    L40:
        if (r12.element == true) goto L44;
        if (r11 == true) goto L44;
        h0();
        return;
    L22:
        if (r23.g() != true) goto L32;
        if (r15 == null) goto L32;
        NavDestination r18 = r15.f();
        if (r18 == null) goto L32;
        if (r21.i() != r18.i()) goto L32;
        g0((NavBackStackEntry) v().removeLast());
        NavBackStackEntry r19 = new NavBackStackEntry(r15, r14);
        v().addLast(r19);
        NavGraph r20 = r19.f().k();
        if (r20 == null) goto L31;
        J(r19, w(r20.i()));
    L31:
        r16.g(r19);
        goto L34
    L15:
        if (r23.i() != true) goto L19;
        if (this.f3757m.containsKey(Integer.valueOf(r21.i())) == false) goto L19;
        r12.element = Y(r21.i(), r14, r23, r24);
        goto L33
    L9:
        if (r23.e() == (-1)) goto L11;
        r13 = S(r23.e(), r23.f(), r23.h());
        goto L12
    }

    public final void L(Navigator r10, List r11, k r12, Navigator.Extras r13, Function1 r14) {
        this.f3769y = r14;
        r10.e(r11, r12, r13);
        this.f3769y = null;
    }

    public final void M(Bundle r10) {
        Bundle r11 = this.f3749e;
        if (r11 == null) goto L12;
        ArrayList<String> r12 = r11.getStringArrayList("android-support-nav:controller:navigatorState:names");
        if (r12 == null) goto L12;
        Iterator<String> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L12;
        String r14 = r13.next();
        o r15 = this.f3767w;
        kotlin.jvm.internal.q.f(r14, "name");
        Navigator r16 = r15.d(r14);
        Bundle r17 = r11.getBundle(r14);
        if (r17 == null) goto L8;
        r16.h(r17);
    L12:
        Parcelable[] r18 = this.f3750f;
        if (r18 == null) goto L28;
        int r19 = r18.length;
        int r20 = 0;
    L15:
        if (r20 >= r19) goto L27;
        NavBackStackEntryState r21 = (NavBackStackEntryState) r18[r20];
        NavDestination r22 = s(r21.getDestinationId());
        if (r22 == null) goto L26;
        NavBackStackEntry r23 = r21.instantiate(this.f3745a, r22, D(), this.f3761q);
        Navigator r24 = this.f3767w.d(r22.j());
        Map r25 = this.f3768x;
        Object r26 = r25.get(r24);
        if (r26 != null) goto L21;
        r26 = new NavControllerNavigatorState(this, r24);
        r25.put(r24, r26);
    L21:
        v().add(r23);
        ((NavControllerNavigatorState) r26).k(r23);
        NavGraph r27 = r23.f().k();
        if (r27 == null) goto L24;
        J(r23, w(r27.i()));
    L24:
        r20 = r20 + 1;
        goto L15
    L26:
        throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.f3796j.b(this.f3745a, r21.getDestinationId()) + " cannot be found from the current destination " + A());
    L27:
        i0();
        this.f3750f = null;
    L28:
        Collection r28 = this.f3767w.e().values();
        ArrayList r29 = new ArrayList();
        Iterator r30 = r28.iterator();
    L30:
        if (r30.hasNext() == false) goto L34;
        Object r31 = r30.next();
        if (((Navigator) r31).c() == true) goto L30;
        r29.add(r31);
        goto L30
    L34:
        Iterator r32 = r29.iterator();
    L36:
        if (r32.hasNext() == false) goto L42;
        Navigator r33 = (Navigator) r32.next();
        Map r34 = this.f3768x;
        Object r35 = r34.get(r33);
        if (r35 != null) goto L40;
        r35 = new NavControllerNavigatorState(this, r33);
        r34.put(r33, r35);
    L40:
        r33.f((NavControllerNavigatorState) r35);
        goto L36
    L42:
        if (this.f3748d != null) goto L44;
    L53:
        q();
        return;
    L44:
        if (v().isEmpty() == false) goto L53;
        if (this.f3751g == true) goto L52;
        Activity r36 = this.f3746b;
        if (r36 == null) goto L52;
        kotlin.jvm.internal.q.d(r36);
        if (G(r36.getIntent()) == false) goto L52;
        return;
    L52:
        NavGraph r37 = this.f3748d;
        kotlin.jvm.internal.q.d(r37);
        K(r37, r10, null, null);
    }

    public boolean N() {
        if (v().isEmpty() == false) goto L5;
        return false;
    L5:
        NavDestination r10 = A();
        kotlin.jvm.internal.q.d(r10);
        return O(r10.i(), true);
    }

    public boolean O(int r10, boolean r11) {
        return P(r10, r11, false);
    }

    public boolean P(int r10, boolean r11, boolean r12) {
        if (S(r10, r11, r12) == true) goto L5;
    L7:
        return false;
    L5:
        if (q() == false) goto L7;
        return true;
    }

    public final void Q(NavBackStackEntry r10, Function0 r11) {
        kotlin.jvm.internal.q.g(r10, "popUpTo");
        kotlin.jvm.internal.q.g(r11, "onComplete");
        int r12 = v().indexOf(r10);
        if (r12 >= 0) goto L6;
        Log.i("NavController", "Ignoring pop of " + r10 + " as it was not found on the current back stack");
        return;
    L6:
        int r13 = r12 + 1;
        if (r13 == v().size()) goto L9;
        S(((NavBackStackEntry) v().get(r13)).f().i(), true, false);
    L9:
        V(this, r10, false, null, 6, null);
        r11.invoke();
        i0();
        q();
    }

    public final void R(Navigator r10, NavBackStackEntry r11, boolean r12, Function1 r13) {
        this.f3770z = r13;
        r10.j(r11, r12);
        this.f3770z = null;
    }

    public final boolean S(int r17, boolean r18, final boolean r19) {
        if (v().isEmpty() == false) goto L5;
        return false;
    L5:
        ArrayList r10 = new ArrayList();
        Iterator r11 = b0.p0(v()).iterator();
    L7:
        if (r11.hasNext() == false) goto L16;
        NavDestination r12 = ((NavBackStackEntry) r11.next()).f();
        Navigator r13 = this.f3767w.d(r12.j());
        if (r18 == false) goto L11;
    L12:
        r10.add(r13);
    L14:
        if (r12.i() != r17) goto L7;
        NavDestination r14 = r12;
    L17:
        if (r14 != null) goto L20;
        Log.i("NavController", "Ignoring popBackStack to destination " + NavDestination.f3796j.b(this.f3745a, r17) + " as it was not found on the current back stack");
        return false;
    L20:
        final Ref$BooleanRef r15 = new Ref$BooleanRef();
        final kotlin.collections.i r16 = new kotlin.collections.i();
        Iterator r110 = r10.iterator();
    L22:
        if (r110.hasNext() == false) goto L25;
        Navigator r111 = (Navigator) r110.next();
        final Ref$BooleanRef r112 = new Ref$BooleanRef();
        R(r111, (NavBackStackEntry) v().last(), r19, new NavController$popBackStackInternal$2(r112, r15, this, r19, r16));
        if (r112.element == true) goto L22;
    L25:
        if (r19 == false) goto L42;
        if (r18 == true) goto L36;
        Iterator r20 = SequencesKt___SequencesKt.u(SequencesKt__SequencesKt.f(r14, NavController$popBackStackInternal$3.INSTANCE), new NavController$popBackStackInternal$4(this)).iterator();
    L29:
        if (r20.hasNext() == false) goto L36;
        NavDestination r21 = (NavDestination) r20.next();
        Map r22 = this.f3757m;
        Integer r23 = Integer.valueOf(r21.i());
        NavBackStackEntryState r24 = (NavBackStackEntryState) r16.e();
        if (r24 == null) goto L33;
        String r25 = r24.getId();
    L34:
        r22.put(r23, r25);
        goto L29
    L33:
        r25 = null;
    L36:
        if (r16.isEmpty() == true) goto L42;
        NavBackStackEntryState r26 = (NavBackStackEntryState) r16.first();
        Iterator r27 = SequencesKt___SequencesKt.u(SequencesKt__SequencesKt.f(s(r26.getDestinationId()), NavController$popBackStackInternal$6.INSTANCE), new NavController$popBackStackInternal$7(this)).iterator();
    L39:
        if (r27.hasNext() == false) goto L41;
        this.f3757m.put(Integer.valueOf(((NavDestination) r27.next()).i()), r26.getId());
        goto L39
    L41:
        this.f3758n.put(r26.getId(), r16);
    L42:
        i0();
        return r15.element;
    L11:
        if (r12.i() == r17) goto L14;
    L16:
        r14 = null;
        goto L17
    }

    public final void U(NavBackStackEntry r10, boolean r11, kotlin.collections.i r12) {
        NavBackStackEntry r13 = (NavBackStackEntry) v().last();
        if (kotlin.jvm.internal.q.b(r13, r10) == false) goto L31;
        v().removeLast();
        NavControllerNavigatorState r14 = (NavControllerNavigatorState) this.f3768x.get(F().d(r13.f().j()));
        boolean r15 = true;
        if (r14 == null) goto L14;
        StateFlow r16 = r14.c();
        if (r16 == null) goto L14;
        Set r17 = (Set) r16.getValue();
        if (r17 == null) goto L14;
        if (r17.contains(r13) != true) goto L14;
    L17:
        Lifecycle.State r18 = r13.getLifecycle().b();
        Lifecycle.State r19 = Lifecycle.State.CREATED;
        if (r18.isAtLeast(r19) == false) goto L24;
        if (r11 == false) goto L21;
        r13.k(r19);
        r12.addFirst(new NavBackStackEntryState(r13));
    L21:
        if (r15 == true) goto L23;
        r13.k(Lifecycle.State.DESTROYED);
        g0(r13);
        goto L24
    L23:
        r13.k(r19);
    L24:
        if (r11 == true) goto L32;
        if (r15 == true) goto L33;
        e r20 = this.f3761q;
        if (r20 == null) goto L34;
        r20.g(r13.g());
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L14:
        if (this.f3756l.containsKey(r13) == true) goto L17;
        r15 = false;
        goto L17
    L31:
        throw new IllegalStateException(("Attempted to pop " + r10.f() + ", which is not the top of the back stack (" + r13.f() + ')').toString());
    }

    public final List W() {
        ArrayList r10 = new ArrayList();
        Iterator r11 = this.f3768x.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        Iterable r12 = (Iterable) ((NavControllerNavigatorState) r11.next()).c().getValue();
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L7:
        if (r14.hasNext() == false) goto L13;
        Object r15 = r14.next();
        NavBackStackEntry r16 = (NavBackStackEntry) r15;
        if (r10.contains(r16) == true) goto L7;
        if (r16.h().isAtLeast(Lifecycle.State.STARTED) == true) goto L7;
        r13.add(r15);
        goto L7
    L13:
        y.v(r10, r13);
        goto L4
    L14:
        kotlin.collections.i r17 = v();
        ArrayList r18 = new ArrayList();
        Iterator<E> r19 = r17.iterator();
    L16:
        if (r19.hasNext() == false) goto L22;
        Object r20 = r19.next();
        NavBackStackEntry r21 = (NavBackStackEntry) r20;
        if (r10.contains(r21) == true) goto L16;
        if (r21.h().isAtLeast(Lifecycle.State.STARTED) == false) goto L16;
        r18.add(r20);
        goto L16
    L22:
        y.v(r10, r18);
        ArrayList r22 = new ArrayList();
        Iterator r23 = r10.iterator();
    L24:
        if (r23.hasNext() == false) goto L28;
        Object r24 = r23.next();
        if ((((NavBackStackEntry) r24).f() instanceof NavGraph) == true) goto L24;
        r22.add(r24);
        goto L24
    L28:
        return r22;
    }

    public void X(Bundle r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        r10.setClassLoader(this.f3745a.getClassLoader());
        this.f3749e = r10.getBundle("android-support-nav:controller:navigatorState");
        this.f3750f = r10.getParcelableArray("android-support-nav:controller:backStack");
        this.f3758n.clear();
        int[] r11 = r10.getIntArray("android-support-nav:controller:backStackDestIds");
        ArrayList<String> r12 = r10.getStringArrayList("android-support-nav:controller:backStackIds");
        if (r11 == null) goto L10;
        if (r12 == null) goto L10;
        int r13 = r11.length;
        int r14 = 0;
        int r15 = 0;
    L8:
        if (r14 >= r13) goto L10;
        this.f3757m.put(Integer.valueOf(r11[r14]), r12.get(r15));
        r14 = r14 + 1;
        r15 = r15 + 1;
    L10:
        ArrayList<String> r16 = r10.getStringArrayList("android-support-nav:controller:backStackStates");
        if (r16 == null) goto L26;
        Iterator<T> r17 = r16.iterator();
    L14:
        if (r17.hasNext() == false) goto L26;
        String r18 = (String) r17.next();
        Parcelable[] r19 = r10.getParcelableArray("android-support-nav:controller:backStackStates:" + r18);
        if (r19 == null) goto L14;
        Map r20 = this.f3758n;
        kotlin.jvm.internal.q.f(r18, "id");
        kotlin.collections.i r21 = new kotlin.collections.i(r19.length);
        Iterator r22 = kotlin.jvm.internal.h.a(r19);
    L19:
        if (r22.hasNext() == false) goto L25;
        Parcelable r23 = (Parcelable) r22.next();
        if (r23 == null) goto L24;
        r21.add((NavBackStackEntryState) r23);
        goto L19
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
    L25:
        r20.put(r18, r21);
    L26:
        this.f3751g = r10.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public final boolean Y(int r14, final Bundle r15, k r16, Navigator.Extras r17) {
        if (this.f3757m.containsKey(Integer.valueOf(r14)) == true) goto L6;
        return false;
    L6:
        final String r10 = (String) this.f3757m.get(Integer.valueOf(r14));
        y.A(this.f3757m.values(), new NavController$restoreStateInternal$1(r10));
        final List r11 = H((kotlin.collections.i) kotlin.jvm.internal.y.d(this.f3758n).remove(r10));
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator r18 = r11.iterator();
    L8:
        if (r18.hasNext() == false) goto L12;
        Object r19 = r18.next();
        if ((((NavBackStackEntry) r19).f() instanceof NavGraph) == true) goto L8;
        r13.add(r19);
        goto L8
    L12:
        Iterator r20 = r13.iterator();
    L14:
        if (r20.hasNext() == false) goto L27;
        NavBackStackEntry r21 = (NavBackStackEntry) r20.next();
        List r22 = (List) b0.j0(r12);
        if (r22 == null) goto L22;
        NavBackStackEntry r23 = (NavBackStackEntry) b0.i0(r22);
        if (r23 == null) goto L22;
        NavDestination r24 = r23.f();
        if (r24 == null) goto L22;
        String r25 = r24.j();
    L24:
        if (kotlin.jvm.internal.q.b(r25, r21.f().j()) == true) goto L25;
        r12.add(t.n(new NavBackStackEntry[]{r21}));
        goto L14
    L25:
        r22.add(r21);
    L22:
        r25 = null;
        goto L24
    L27:
        final Ref$BooleanRef r26 = new Ref$BooleanRef();
        Iterator r27 = r12.iterator();
    L29:
        if (r27.hasNext() == false) goto L32;
        List r110 = (List) r27.next();
        Navigator r111 = this.f3767w.d(((NavBackStackEntry) b0.Y(r110)).f().j());
        final Ref$IntRef r28 = new Ref$IntRef();
        L(r111, r110, r16, r17, new NavController$restoreStateInternal$4(r26, r11, r28, this, r15));
        goto L29
    L32:
        return r26.element;
    }

    public Bundle Z() {
        ArrayList<String> r10 = new ArrayList();
        Bundle r11 = new Bundle();
        Iterator r12 = this.f3767w.e().entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        Bundle r15 = ((Navigator) r13.getValue()).i();
        if (r15 == null) goto L4;
        r10.add(r14);
        r11.putBundle(r14, r15);
        goto L4
    L9:
        if (r10.isEmpty() == true) goto L11;
        Bundle r16 = new Bundle();
        r11.putStringArrayList("android-support-nav:controller:navigatorState:names", r10);
        r16.putBundle("android-support-nav:controller:navigatorState", r11);
    L13:
        if (v().isEmpty() == true) goto L22;
        if (r16 != null) goto L16;
        r16 = new Bundle();
    L16:
        Parcelable[] r17 = new Parcelable[v().size()];
        Iterator r18 = v().iterator();
        int r19 = 0;
    L18:
        if (r18.hasNext() == false) goto L20;
        r17[r19] = new NavBackStackEntryState((NavBackStackEntry) r18.next());
        r19 = r19 + 1;
        goto L18
    L20:
        r16.putParcelableArray("android-support-nav:controller:backStack", r17);
    L22:
        if (this.f3757m.isEmpty() == true) goto L31;
        if (r16 != null) goto L25;
        r16 = new Bundle();
    L25:
        int[] r20 = new int[this.f3757m.size()];
        ArrayList<String> r21 = new ArrayList();
        Iterator r22 = this.f3757m.entrySet().iterator();
        int r23 = 0;
    L27:
        if (r22.hasNext() == false) goto L29;
        Map.Entry r24 = (Map.Entry) r22.next();
        int r25 = ((Number) r24.getKey()).intValue();
        String r26 = (String) r24.getValue();
        r20[r23] = r25;
        r21.add(r26);
        r23 = r23 + 1;
        goto L27
    L29:
        r16.putIntArray("android-support-nav:controller:backStackDestIds", r20);
        r16.putStringArrayList("android-support-nav:controller:backStackIds", r21);
    L31:
        if (this.f3758n.isEmpty() == true) goto L47;
        if (r16 != null) goto L34;
        r16 = new Bundle();
    L34:
        ArrayList<String> r27 = new ArrayList();
        Iterator r28 = this.f3758n.entrySet().iterator();
    L36:
        if (r28.hasNext() == false) goto L45;
        Map.Entry r29 = (Map.Entry) r28.next();
        String r30 = (String) r29.getKey();
        kotlin.collections.i r31 = (kotlin.collections.i) r29.getValue();
        r27.add(r30);
        Parcelable[] r32 = new Parcelable[r31.size()];
        Iterator<E> r33 = r31.iterator();
        int r34 = 0;
    L39:
        if (r33.hasNext() == false) goto L44;
        Object r35 = r33.next();
        int r36 = r34 + 1;
        if (r34 >= 0) goto L43;
        t.q();
    L43:
        r32[r34] = (NavBackStackEntryState) r35;
        r34 = r36;
        goto L39
    L44:
        r16.putParcelableArray("android-support-nav:controller:backStackStates:" + r30, r32);
        goto L36
    L45:
        r16.putStringArrayList("android-support-nav:controller:backStackStates", r27);
    L47:
        if (this.f3751g == false) goto L51;
        if (r16 != null) goto L50;
        r16 = new Bundle();
    L50:
        r16.putBoolean("android-support-nav:controller:deepLinkHandled", this.f3751g);
    L51:
        return r16;
    L11:
        r16 = null;
        goto L13
    }

    public void a0(int r10) {
        c0(E().b(r10), null);
    }

    public void addOnDestinationChangedListener(@NotNull OnDestinationChangedListener r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        this.f3762r.add(r10);
        if (v().isEmpty() == true) goto L6;
        NavBackStackEntry r11 = (NavBackStackEntry) v().last();
        r10.onDestinationChanged(this, r11.f(), r11.d());
        return;
    }

    public void b0(int r10, Bundle r11) {
        c0(E().b(r10), r11);
    }

    public void c0(NavGraph r10, Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "graph");
        if (kotlin.jvm.internal.q.b(this.f3748d, r10) == true) goto L12;
        NavGraph r12 = this.f3748d;
        if (r12 == null) goto L11;
        Iterator r13 = new ArrayList(this.f3757m.keySet()).iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        Integer r14 = (Integer) r13.next();
        kotlin.jvm.internal.q.f(r14, "id");
        p(r14.intValue());
        goto L8
    L10:
        T(this, r12.i(), true, false, 4, null);
    L11:
        this.f3748d = r10;
        M(r11);
        return;
    L12:
        int r15 = r10.y().n();
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L38;
        NavDestination r17 = (NavDestination) r10.y().o(r16);
        NavGraph r18 = this.f3748d;
        kotlin.jvm.internal.q.d(r18);
        r18.y().m(r16, r17);
        kotlin.collections.i r19 = v();
        ArrayList r20 = new ArrayList();
        Iterator<E> r21 = r19.iterator();
    L16:
        if (r21.hasNext() == false) goto L22;
        Object r22 = r21.next();
        NavBackStackEntry r23 = (NavBackStackEntry) r22;
        if (r17 == null) goto L16;
        if (r23.f().i() != r17.i()) goto L16;
        r20.add(r22);
        goto L16
    L22:
        Iterator r24 = r20.iterator();
    L24:
        if (r24.hasNext() == false) goto L26;
        NavBackStackEntry r25 = (NavBackStackEntry) r24.next();
        kotlin.jvm.internal.q.f(r17, "newDestination");
        r25.j(r17);
        goto L24
    L26:
        r16 = r16 + 1;
        goto L13
    }

    public void d0(LifecycleOwner r10) {
        kotlin.jvm.internal.q.g(r10, "owner");
        if (kotlin.jvm.internal.q.b(r10, this.f3759o) == false) goto L5;
        return;
    L5:
        LifecycleOwner r11 = this.f3759o;
        if (r11 == null) goto L10;
        Lifecycle r12 = r11.getLifecycle();
        if (r12 == null) goto L10;
        r12.d(this.f3764t);
    L10:
        this.f3759o = r10;
        r10.getLifecycle().a(this.f3764t);
    }

    public void e0(OnBackPressedDispatcher r10) {
        kotlin.jvm.internal.q.g(r10, "dispatcher");
        if (kotlin.jvm.internal.q.b(r10, this.f3760p) == false) goto L5;
        return;
    L5:
        LifecycleOwner r11 = this.f3759o;
        if (r11 == null) goto L10;
        this.f3765u.f();
        this.f3760p = r10;
        r10.h(r11, this.f3765u);
        Lifecycle r12 = r11.getLifecycle();
        r12.d(this.f3764t);
        r12.a(this.f3764t);
        return;
    L10:
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
    }

    public void f0(ViewModelStore r10) {
        kotlin.jvm.internal.q.g(r10, "viewModelStore");
        e r11 = this.f3761q;
        e.b r12 = e.f3839e;
        if (kotlin.jvm.internal.q.b(r11, r12.a(r10)) == false) goto L6;
        return;
    L6:
        if (v().isEmpty() == false) goto L10;
        this.f3761q = r12.a(r10);
        return;
    L10:
        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
    }

    public final NavBackStackEntry g0(NavBackStackEntry r10) {
        kotlin.jvm.internal.q.g(r10, "child");
        NavBackStackEntry r11 = (NavBackStackEntry) this.f3755k.remove(r10);
        Integer r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        AtomicInteger r13 = (AtomicInteger) this.f3756l.get(r11);
        if (r13 == null) goto L8;
        r12 = Integer.valueOf(r13.decrementAndGet());
    L8:
        if (r12 != null) goto L11;
    L16:
        return r11;
    L11:
        if (r12.intValue() != 0) goto L16;
        Navigator r14 = this.f3767w.d(r11.f().j());
        NavControllerNavigatorState r15 = (NavControllerNavigatorState) this.f3768x.get(r14);
        if (r15 == null) goto L15;
        r15.e(r11);
    L15:
        this.f3756l.remove(r11);
        goto L16
    }

    public final void h0() {
        List r10 = b0.z0(v());
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        NavDestination r11 = ((NavBackStackEntry) b0.i0(r10)).f();
        if ((r11 instanceof FloatingWindow) == false) goto L15;
        Iterator r12 = b0.p0(r10).iterator();
    L9:
        if (r12.hasNext() == false) goto L15;
        NavDestination r13 = ((NavBackStackEntry) r12.next()).f();
        if ((r13 instanceof NavGraph) == true) goto L9;
        if ((r13 instanceof FloatingWindow) == true) goto L9;
    L16:
        HashMap r14 = new HashMap();
        Iterator r15 = b0.p0(r10).iterator();
    L18:
        if (r15.hasNext() == false) goto L54;
        NavBackStackEntry r16 = (NavBackStackEntry) r15.next();
        Lifecycle.State r17 = r16.h();
        NavDestination r18 = r16.f();
        if (r11 == null) goto L43;
        if (r18.i() != r11.i()) goto L43;
        Lifecycle.State r19 = Lifecycle.State.RESUMED;
        if (r17 == r19) goto L42;
        NavControllerNavigatorState r20 = (NavControllerNavigatorState) this.f3768x.get(F().d(r16.f().j()));
        if (r20 == null) goto L32;
        StateFlow r21 = r20.c();
        if (r21 == null) goto L32;
        Set r22 = (Set) r21.getValue();
        if (r22 == null) goto L32;
        Boolean r23 = Boolean.valueOf(r22.contains(r16));
    L34:
        if (kotlin.jvm.internal.q.b(r23, Boolean.TRUE) == true) goto L41;
        AtomicInteger r24 = (AtomicInteger) this.f3756l.get(r16);
        if (r24 != null) goto L38;
    L40:
        r14.put(r16, r19);
        goto L42
    L38:
        if (r24.get() != 0) goto L40;
    L41:
        r14.put(r16, Lifecycle.State.STARTED);
    L32:
        r23 = null;
    L42:
        r11 = r11.k();
    L43:
        if (r13 == null) goto L53;
        if (r18.i() != r13.i()) goto L53;
        if (r17 != Lifecycle.State.RESUMED) goto L49;
        r16.k(Lifecycle.State.STARTED);
    L52:
        r13 = r13.k();
        goto L18
    L49:
        Lifecycle.State r25 = Lifecycle.State.STARTED;
        if (r17 == r25) goto L52;
        r14.put(r16, r25);
    L53:
        r16.k(Lifecycle.State.CREATED);
        goto L18
    L54:
        Iterator r110 = r10.iterator();
    L56:
        if (r110.hasNext() == false) goto L61;
        NavBackStackEntry r26 = (NavBackStackEntry) r110.next();
        Lifecycle.State r27 = (Lifecycle.State) r14.get(r26);
        if (r27 != null) goto L59;
        r26.l();
        goto L56
    L59:
        r26.k(r27);
        goto L56
    L61:
        return;
    L15:
        r13 = null;
        goto L16
    }

    public final void i0() {
        androidx.activity.l r10 = this.f3765u;
        if (this.f3766v == false) goto L7;
        boolean r11 = true;
        if (B() <= 1) goto L7;
    L8:
        r10.h(r11);
        return;
    L7:
        r11 = false;
        goto L8
    }

    public final void n(NavDestination r31, Bundle r32, NavBackStackEntry r33, List r34) {
        Bundle r15 = r32;
        NavBackStackEntry r14 = r33;
        List r13 = r34;
        NavDestination r12 = r33.f();
        if ((r12 instanceof FloatingWindow) == false) goto L5;
    L10:
        kotlin.collections.i r10 = new kotlin.collections.i();
        Object r18 = null;
        if ((r31 instanceof NavGraph) == false) goto L37;
        NavDestination r11 = r12;
    L13:
        kotlin.jvm.internal.q.d(r11);
        NavGraph r16 = r11.k();
        if (r16 == null) goto L32;
        ListIterator r17 = r13.listIterator(r34.size());
    L17:
        if (r17.hasPrevious() == false) goto L21;
        Object r19 = r17.previous();
        if (kotlin.jvm.internal.q.b(((NavBackStackEntry) r19).f(), r16) == false) goto L17;
    L22:
        NavBackStackEntry r20 = (NavBackStackEntry) r19;
        if (r20 != null) goto L25;
        NavBackStackEntry r21 = r14;
        r20 = NavBackStackEntry.a.b(NavBackStackEntry.f3729n, this.f3745a, r16, r32, D(), this.f3761q, null, null, 96, null);
    L26:
        r10.addFirst(r20);
        if (v().isEmpty() == true) goto L33;
        if (((NavBackStackEntry) v().last()).f() != r16) goto L33;
        V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
    L33:
        if (r16 == 0) goto L39;
        if (r16 == r31) goto L39;
        r14 = r21;
        r10 = r10;
        r11 = r16;
        r15 = r15;
        r13 = r13;
        r12 = r12;
    L39:
        if (r10.isEmpty() == false) goto L41;
        NavDestination r22 = r12;
    L42:
        if (r22 == null) goto L59;
        if (s(r22.i()) != null) goto L59;
        r22 = r22.k();
        if (r22 == null) goto L42;
        ListIterator r23 = r13.listIterator(r34.size());
    L49:
        if (r23.hasPrevious() == false) goto L53;
        Object r24 = r23.previous();
        if (kotlin.jvm.internal.q.b(((NavBackStackEntry) r24).f(), r22) == false) goto L49;
    L54:
        NavBackStackEntry r25 = (NavBackStackEntry) r24;
        if (r25 != null) goto L57;
        r25 = NavBackStackEntry.a.b(NavBackStackEntry.f3729n, this.f3745a, r22, r22.d(r15), D(), this.f3761q, null, null, 96, null);
    L57:
        r10.addFirst(r25);
        goto L42
    L53:
        r24 = null;
    L59:
        if (r10.isEmpty() == true) goto L63;
        r12 = ((NavBackStackEntry) r10.first()).f();
    L63:
        if (v().isEmpty() == true) goto L69;
        if ((((NavBackStackEntry) v().last()).f() instanceof NavGraph) == false) goto L69;
        if (((NavGraph) ((NavBackStackEntry) v().last()).f()).v(r12.i(), false) != null) goto L69;
        V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
    L69:
        NavBackStackEntry r26 = (NavBackStackEntry) v().e();
        if (r26 != null) goto L72;
        r26 = (NavBackStackEntry) r10.e();
    L72:
        if (r26 == null) goto L74;
        NavDestination r27 = r26.f();
    L76:
        if (kotlin.jvm.internal.q.b(r27, this.f3748d) == true) goto L87;
        ListIterator r28 = r13.listIterator(r34.size());
    L79:
        if (r28.hasPrevious() == false) goto L83;
        Object r29 = r28.previous();
        NavDestination r30 = ((NavBackStackEntry) r29).f();
        NavGraph r35 = this.f3748d;
        kotlin.jvm.internal.q.d(r35);
        if (kotlin.jvm.internal.q.b(r30, r35) == false) goto L79;
        r18 = r29;
    L83:
        NavBackStackEntry r110 = (NavBackStackEntry) r18;
        if (r110 != null) goto L86;
        NavBackStackEntry.a r111 = NavBackStackEntry.f3729n;
        Context r36 = this.f3745a;
        NavGraph r37 = this.f3748d;
        kotlin.jvm.internal.q.d(r37);
        NavGraph r38 = this.f3748d;
        kotlin.jvm.internal.q.d(r38);
        r110 = NavBackStackEntry.a.b(r111, r36, r37, r38.d(r15), D(), this.f3761q, null, null, 96, null);
    L86:
        r10.addFirst(r110);
    L87:
        Iterator<E> r39 = r10.iterator();
    L89:
        if (r39.hasNext() == false) goto L95;
        NavBackStackEntry r40 = (NavBackStackEntry) r39.next();
        Object r41 = this.f3768x.get(this.f3767w.d(r40.f().j()));
        if (r41 == null) goto L94;
        ((NavControllerNavigatorState) r41).k(r40);
        goto L89
    L94:
        throw new IllegalStateException(("NavigatorBackStack for " + r31.j() + " should already be created").toString());
    L95:
        v().addAll(r10);
        v().add(r21);
        Iterator r42 = b0.o0(r10, r21).iterator();
    L97:
        if (r42.hasNext() == false) goto L101;
        NavBackStackEntry r43 = (NavBackStackEntry) r42.next();
        NavGraph r44 = r43.f().k();
        if (r44 == null) goto L97;
        J(r43, w(r44.i()));
        goto L97
    L101:
        return;
    L74:
        r27 = null;
        goto L76
    L41:
        r22 = ((NavBackStackEntry) r10.first()).f();
        goto L42
    L25:
        r21 = r14;
        goto L26
    L21:
        r19 = null;
        goto L22
    L32:
        r12 = r12;
        r21 = r14;
        goto L33
    L37:
        r10 = r10;
        r12 = r12;
        r13 = r13;
        r21 = r14;
        r15 = r15;
    L5:
        if (v().isEmpty() == true) goto L10;
        if ((((NavBackStackEntry) v().last()).f() instanceof FloatingWindow) == false) goto L10;
        if (T(this, ((NavBackStackEntry) v().last()).f().i(), true, false, 4, null) == true) goto L5;
        goto L10
    }

    public final boolean p(int r10) {
        Iterator r11 = this.f3768x.values().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((NavControllerNavigatorState) r11.next()).i(true);
        goto L4
    L6:
        boolean r12 = Y(r10, null, null, null);
        Iterator r13 = this.f3768x.values().iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        ((NavControllerNavigatorState) r13.next()).i(false);
        goto L8
    L10:
        if (r12 == false) goto L15;
        if (S(r10, true, false) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public final boolean q() {
    L3:
        if (v().isEmpty() == true) goto L7;
        if ((((NavBackStackEntry) v().last()).f() instanceof NavGraph) == false) goto L7;
        V(this, (NavBackStackEntry) v().last(), false, null, 6, null);
    L7:
        NavBackStackEntry r10 = (NavBackStackEntry) v().g();
        if (r10 == null) goto L10;
        this.C.add(r10);
    L10:
        this.B++;
        h0();
        int r11 = this.B - 1;
        this.B = r11;
        if (r11 != 0) goto L21;
        List r12 = b0.z0(this.C);
        this.C.clear();
        Iterator r13 = r12.iterator();
    L14:
        if (r13.hasNext() == false) goto L20;
        NavBackStackEntry r14 = (NavBackStackEntry) r13.next();
        Iterator r15 = this.f3762r.iterator();
    L17:
        if (r15.hasNext() == false) goto L19;
        ((OnDestinationChangedListener) r15.next()).onDestinationChanged(this, r14.f(), r14.d());
        goto L17
    L19:
        this.E.tryEmit(r14);
        goto L14
    L20:
        this.f3753i.tryEmit(W());
    L21:
        if (r10 != null) goto L29;
        return false;
    L29:
        return true;
    }

    public void r(boolean r10) {
        this.f3766v = r10;
        i0();
    }

    public void removeOnDestinationChangedListener(@NotNull OnDestinationChangedListener r10) {
        kotlin.jvm.internal.q.g(r10, "listener");
        this.f3762r.remove(r10);
    }

    public final NavDestination s(int r10) {
        NavGraph r11 = this.f3748d;
        if (r11 != null) goto L6;
        return null;
    L6:
        kotlin.jvm.internal.q.d(r11);
        if (r11.i() == r10) goto L9;
        NavBackStackEntry r12 = (NavBackStackEntry) v().g();
        if (r12 == null) goto L14;
        NavDestination r13 = r12.f();
        if (r13 == null) goto L14;
    L16:
        return t(r13, r10);
    L14:
        r13 = this.f3748d;
        kotlin.jvm.internal.q.d(r13);
        goto L16
    L9:
        return this.f3748d;
    }

    public final NavDestination t(NavDestination r10, int r11) {
        if (r10.i() != r11) goto L6;
        return r10;
    L6:
        if ((r10 instanceof NavGraph) == false) goto L8;
        NavGraph r12 = (NavGraph) r10;
    L10:
        return r12.u(r11);
    L8:
        r12 = r10.k();
        kotlin.jvm.internal.q.d(r12);
        goto L10
    }

    public final String u(int[] r10) {
        NavGraph r11 = this.f3748d;
        int r12 = r10.length;
        int r13 = 0;
    L3:
        NavDestination r14 = null;
        if (r13 >= r12) goto L24;
        int r15 = r10[r13];
        if (r13 != 0) goto L10;
        NavGraph r16 = this.f3748d;
        kotlin.jvm.internal.q.d(r16);
        if (r16.i() != r15) goto L11;
        r14 = this.f3748d;
    L11:
        if (r14 == null) goto L13;
        if (r13 == (r10.length - 1)) goto L23;
        if ((r14 instanceof NavGraph) == false) goto L23;
    L19:
        NavGraph r17 = (NavGraph) r14;
        kotlin.jvm.internal.q.d(r17);
        if ((r17.u(r17.A()) instanceof NavGraph) == false) goto L22;
        r14 = r17.u(r17.A());
        goto L19
    L22:
        r11 = r17;
    L23:
        r13 = r13 + 1;
        goto L3
    L13:
        return NavDestination.f3796j.b(this.f3745a, r15);
    L10:
        kotlin.jvm.internal.q.d(r11);
        r14 = r11.u(r15);
        goto L11
    L24:
        return null;
    }

    public kotlin.collections.i v() {
        return this.f3752h;
    }

    public NavBackStackEntry w(int r10) {
        kotlin.collections.i r11 = v();
        ListIterator<E> r12 = r11.listIterator(r11.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        Object r13 = r12.previous();
        if (((NavBackStackEntry) r13).f().i() != r10) goto L4;
    L9:
        NavBackStackEntry r14 = (NavBackStackEntry) r13;
        if (r14 == null) goto L13;
        return r14;
    L13:
        throw new IllegalArgumentException(("No destination with ID " + r10 + " is on the NavController's back stack. The current destination is " + A()).toString());
    L8:
        r13 = null;
        goto L9
    }

    public final NavBackStackEntry x(String r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.ROUTE);
        kotlin.collections.i r11 = v();
        ListIterator<E> r12 = r11.listIterator(r11.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        Object r13 = r12.previous();
        if (kotlin.jvm.internal.q.b(((NavBackStackEntry) r13).f().l(), r10) == false) goto L4;
    L9:
        NavBackStackEntry r14 = (NavBackStackEntry) r13;
        if (r14 == null) goto L13;
        return r14;
    L13:
        throw new IllegalArgumentException(("No destination with route " + r10 + " is on the NavController's back stack. The current destination is " + A()).toString());
    L8:
        r13 = null;
        goto L9
    }

    public final Context y() {
        return this.f3745a;
    }

    public NavBackStackEntry z() {
        return (NavBackStackEntry) v().g();
    }
}
