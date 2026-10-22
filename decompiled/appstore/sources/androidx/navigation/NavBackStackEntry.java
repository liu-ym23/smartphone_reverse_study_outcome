package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.g0;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f3729n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NavDestination f3731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f3732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle.State f3733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NavViewModelStoreProvider f3734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f3736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LifecycleRegistry f3737h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SavedStateRegistryController f3738i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3739j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f3740k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f3741l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Lifecycle.State f3742m;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static /* synthetic */ NavBackStackEntry b(a r10, Context r11, NavDestination r12, Bundle r13, Lifecycle.State r14, NavViewModelStoreProvider r15, String r16, Bundle r17, int r18, Object r19) {
            if ((r18 & 4) == 0) goto L5;
            Bundle r20 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            Lifecycle.State r21 = Lifecycle.State.CREATED;
        L11:
            if ((r18 & 16) == 0) goto L13;
            NavViewModelStoreProvider r22 = null;
        L15:
            if ((r18 & 32) == 0) goto L17;
            String r23 = UUID.randomUUID().toString();
            kotlin.jvm.internal.q.f(r23, "randomUUID().toString()");
            String r24 = r23;
        L19:
            if ((r18 & 64) == 0) goto L21;
            Bundle r25 = null;
        L23:
            return r10.a(r11, r12, r20, r21, r22, r24, r25);
        L21:
            r25 = r17;
            goto L23
        L17:
            r24 = r16;
            goto L19
        L13:
            r22 = r15;
            goto L15
        L9:
            r21 = r14;
            goto L11
        L5:
            r20 = r13;
            goto L7
        }

        public final NavBackStackEntry a(Context r11, NavDestination r12, Bundle r13, Lifecycle.State r14, NavViewModelStoreProvider r15, String r16, Bundle r17) {
            kotlin.jvm.internal.q.g(r12, "destination");
            kotlin.jvm.internal.q.g(r14, "hostLifecycleState");
            kotlin.jvm.internal.q.g(r16, "id");
            return new NavBackStackEntry(r11, r12, r13, r14, r15, r16, r17, null);
        }

        public a() {
        }
    }

    public static final class b extends androidx.lifecycle.a {
        public b(SavedStateRegistryOwner r10) {
            kotlin.jvm.internal.q.g(r10, "owner");
            super(r10, null);
        }

        @Override // androidx.lifecycle.a
        public k0 c(String r10, Class r11, b0 r12) {
            kotlin.jvm.internal.q.g(r10, "key");
            kotlin.jvm.internal.q.g(r11, "modelClass");
            kotlin.jvm.internal.q.g(r12, "handle");
            return new c(r12);
        }
    }

    public static final class c extends k0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b0 f3743d;

        public c(@NotNull b0 r10) {
            kotlin.jvm.internal.q.g(r10, "handle");
            this.f3743d = r10;
        }

        public final b0 f() {
            return this.f3743d;
        }
    }

    static {
        f3729n = new a(null);
    }

    public /* synthetic */ NavBackStackEntry(Context r10, NavDestination r11, Bundle r12, Lifecycle.State r13, NavViewModelStoreProvider r14, String r15, Bundle r16, DefaultConstructorMarker r17) {
        this(r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ Context a(NavBackStackEntry r10) {
        return r10.f3730a;
    }

    public static final /* synthetic */ LifecycleRegistry b(NavBackStackEntry r10) {
        return r10.f3737h;
    }

    public static final /* synthetic */ boolean c(NavBackStackEntry r10) {
        return r10.f3739j;
    }

    public final Bundle d() {
        return this.f3732c;
    }

    public final g0 e() {
        return (g0) this.f3740k.getValue();
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        if ((r10 instanceof NavBackStackEntry) == false) goto L48;
        NavBackStackEntry r11 = (NavBackStackEntry) r10;
        if (kotlin.jvm.internal.q.b(this.f3735f, r11.f3735f) == true) goto L10;
        return false;
    L10:
        if (kotlin.jvm.internal.q.b(this.f3731b, r11.f3731b) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f3737h, r11.f3737h) == true) goto L14;
        return false;
    L14:
        if (kotlin.jvm.internal.q.b(getSavedStateRegistry(), r11.getSavedStateRegistry()) == true) goto L16;
        return false;
    L16:
        if (kotlin.jvm.internal.q.b(this.f3732c, r11.f3732c) == true) goto L36;
        Bundle r12 = this.f3732c;
        if (r12 == null) goto L46;
        Set<String> r13 = r12.keySet();
        if (r13 == null) goto L47;
        Set<String> r14 = r13;
        if ((r14 instanceof Collection) == true) goto L24;
    L26:
        Iterator<T> r15 = r14.iterator();
    L28:
        if (r15.hasNext() == false) goto L36;
        String r16 = (String) r15.next();
        Object r17 = this.f3732c.get(r16);
        Bundle r18 = r11.f3732c;
        if (r18 == null) goto L32;
        Object r19 = r18.get(r16);
    L34:
        if (kotlin.jvm.internal.q.b(r17, r19) == true) goto L28;
        return false;
    L32:
        r19 = null;
        goto L34
    L24:
        if (r14.isEmpty() == false) goto L26;
    L47:
        return false;
    L46:
        return false;
    L36:
        return true;
    L48:
        return false;
    }

    public final NavDestination f() {
        return this.f3731b;
    }

    public final String g() {
        return this.f3735f;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application r10 = null;
        androidx.lifecycle.viewmodel.a r11 = new androidx.lifecycle.viewmodel.a(null, 1, null);
        Context r12 = this.f3730a;
        if (r12 == null) goto L5;
        Context r13 = r12.getApplicationContext();
    L7:
        if ((r13 instanceof Application) == false) goto L9;
        r10 = (Application) r13;
    L9:
        if (r10 == null) goto L11;
        r11.c(ViewModelProvider.a.f3486g, r10);
    L11:
        r11.c(e0.f3520a, this);
        r11.c(e0.f3521b, this);
        Bundle r14 = this.f3732c;
        if (r14 == null) goto L14;
        r11.c(e0.f3522c, r14);
    L14:
        return r11;
    L5:
        r13 = null;
        goto L7
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return e();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f3737h;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.f3738i.b();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.f3739j == false) goto L15;
        if (this.f3737h.b() == Lifecycle.State.DESTROYED) goto L13;
        NavViewModelStoreProvider r10 = this.f3734e;
        if (r10 == null) goto L11;
        return r10.getViewModelStore(this.f3735f);
    L11:
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    L13:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
    L15:
        throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
    }

    public final Lifecycle.State h() {
        return this.f3742m;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void handleLifecycleEvent(@NotNull Lifecycle.Event r10) {
        kotlin.jvm.internal.q.g(r10, "event");
        Lifecycle.State r11 = r10.getTargetState();
        kotlin.jvm.internal.q.f(r11, "event.targetState");
        this.f3733d = r11;
        l();
    }

    public int hashCode() {
        int r10 = (this.f3735f.hashCode() * 31) + this.f3731b.hashCode();
        Bundle r11 = this.f3732c;
        if (r11 == null) goto L15;
        Set<String> r12 = r11.keySet();
        if (r12 == null) goto L15;
        Iterator<T> r13 = r12.iterator();
    L8:
        if (r13.hasNext() == false) goto L15;
        String r14 = (String) r13.next();
        int r15 = r10 * 31;
        Object r16 = this.f3732c.get(r14);
        if (r16 == null) goto L12;
        int r17 = r16.hashCode();
    L13:
        r10 = r15 + r17;
        goto L8
    L12:
        r17 = 0;
    L15:
        return (((r10 * 31) + this.f3737h.hashCode()) * 31) + getSavedStateRegistry().hashCode();
    }

    public final void i(Bundle r10) {
        kotlin.jvm.internal.q.g(r10, "outBundle");
        this.f3738i.e(r10);
    }

    public final void j(NavDestination r10) {
        kotlin.jvm.internal.q.g(r10, "<set-?>");
        this.f3731b = r10;
    }

    public final void k(Lifecycle.State r10) {
        kotlin.jvm.internal.q.g(r10, "maxState");
        this.f3742m = r10;
        l();
    }

    public final void l() {
        if (this.f3739j == true) goto L9;
        this.f3738i.c();
        this.f3739j = true;
        if (this.f3734e == null) goto L7;
        e0.c(this);
    L7:
        this.f3738i.d(this.f3736g);
    L9:
        if (this.f3733d.ordinal() >= this.f3742m.ordinal()) goto L11;
        this.f3737h.n(this.f3733d);
        return;
    L11:
        this.f3737h.n(this.f3742m);
    }

    public NavBackStackEntry(Context r10, NavDestination r11, Bundle r12, Lifecycle.State r13, NavViewModelStoreProvider r14, String r15, Bundle r16) {
        this.f3730a = r10;
        this.f3731b = r11;
        this.f3732c = r12;
        this.f3733d = r13;
        this.f3734e = r14;
        this.f3735f = r15;
        this.f3736g = r16;
        this.f3737h = new LifecycleRegistry(this);
        this.f3738i = SavedStateRegistryController.f4729d.a(this);
        this.f3740k = kotlin.b.b(new NavBackStackEntry$defaultFactory$2(this));
        this.f3741l = kotlin.b.b(new NavBackStackEntry$savedStateHandle$2(this));
        this.f3742m = Lifecycle.State.INITIALIZED;
    }

    public NavBackStackEntry(NavBackStackEntry r10, Bundle r11) {
        kotlin.jvm.internal.q.g(r10, "entry");
        this(r10.f3730a, r10.f3731b, r11, r10.f3733d, r10.f3734e, r10.f3735f, r10.f3736g);
        this.f3733d = r10.f3733d;
        k(r10.f3742m);
    }
}
