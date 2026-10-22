package androidx.fragment.app;

import T.c;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InterfaceC0468m;
import androidx.fragment.app.G;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.W;
import androidx.lifecycle.X;
import c0.C0574d;
import c0.InterfaceC0576f;
import d.AbstractC0642c;
import d.AbstractC0643d;
import d.C0640a;
import d.C0645f;
import d.InterfaceC0641b;
import d.InterfaceC0644e;
import e.AbstractC0674a;
import e.C0675b;
import e.C0676c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public abstract class x {

    /* renamed from: S, reason: collision with root package name */
    private static boolean f10724S = false;

    /* renamed from: D, reason: collision with root package name */
    private AbstractC0642c<Intent> f10728D;

    /* renamed from: E, reason: collision with root package name */
    private AbstractC0642c<C0645f> f10729E;

    /* renamed from: F, reason: collision with root package name */
    private AbstractC0642c<String[]> f10730F;

    /* renamed from: H, reason: collision with root package name */
    private boolean f10732H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f10733I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f10734J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f10735K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f10736L;

    /* renamed from: M, reason: collision with root package name */
    private ArrayList<C0506a> f10737M;

    /* renamed from: N, reason: collision with root package name */
    private ArrayList<Boolean> f10738N;

    /* renamed from: O, reason: collision with root package name */
    private ArrayList<ComponentCallbacksC0511f> f10739O;

    /* renamed from: P, reason: collision with root package name */
    private A f10740P;

    /* renamed from: Q, reason: collision with root package name */
    private c.C0081c f10741Q;

    /* renamed from: b, reason: collision with root package name */
    private boolean f10744b;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<C0506a> f10746d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<ComponentCallbacksC0511f> f10747e;

    /* renamed from: g, reason: collision with root package name */
    private androidx.activity.p f10749g;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<l> f10755m;

    /* renamed from: v, reason: collision with root package name */
    private p<?> f10764v;

    /* renamed from: w, reason: collision with root package name */
    private AbstractC0518m f10765w;

    /* renamed from: x, reason: collision with root package name */
    private ComponentCallbacksC0511f f10766x;

    /* renamed from: y, reason: collision with root package name */
    ComponentCallbacksC0511f f10767y;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<m> f10743a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private final F f10745c = new F();

    /* renamed from: f, reason: collision with root package name */
    private final q f10748f = new q(this);

    /* renamed from: h, reason: collision with root package name */
    private final androidx.activity.o f10750h = new b(false);

    /* renamed from: i, reason: collision with root package name */
    private final AtomicInteger f10751i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    private final Map<String, C0508c> f10752j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Bundle> f10753k = Collections.synchronizedMap(new HashMap());

    /* renamed from: l, reason: collision with root package name */
    private final Map<String, Object> f10754l = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    private final r f10756n = new r(this);

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList<B> f10757o = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    private final D.a<Configuration> f10758p = new D.a() { // from class: androidx.fragment.app.s
        @Override // D.a
        public final void accept(Object obj) {
            x.e(this.f10719a, (Configuration) obj);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private final D.a<Integer> f10759q = new D.a() { // from class: androidx.fragment.app.t
        @Override // D.a
        public final void accept(Object obj) {
            x.a(this.f10720a, (Integer) obj);
        }
    };

    /* renamed from: r, reason: collision with root package name */
    private final D.a<androidx.core.app.g> f10760r = new D.a() { // from class: androidx.fragment.app.u
        @Override // D.a
        public final void accept(Object obj) {
            x.d(this.f10721a, (androidx.core.app.g) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private final D.a<androidx.core.app.q> f10761s = new D.a() { // from class: androidx.fragment.app.v
        @Override // D.a
        public final void accept(Object obj) {
            x.c(this.f10722a, (androidx.core.app.q) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final androidx.core.view.r f10762t = new c();

    /* renamed from: u, reason: collision with root package name */
    int f10763u = -1;

    /* renamed from: z, reason: collision with root package name */
    private C0520o f10768z = null;

    /* renamed from: A, reason: collision with root package name */
    private C0520o f10725A = new d();

    /* renamed from: B, reason: collision with root package name */
    private N f10726B = null;

    /* renamed from: C, reason: collision with root package name */
    private N f10727C = new e();

    /* renamed from: G, reason: collision with root package name */
    ArrayDeque<k> f10731G = new ArrayDeque<>();

    /* renamed from: R, reason: collision with root package name */
    private Runnable f10742R = new f();

    class a implements InterfaceC0641b<Map<String, Boolean>> {
        a() {
        }

        @Override // d.InterfaceC0641b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                iArr[i5] = ((Boolean) arrayList.get(i5)).booleanValue() ? 0 : -1;
            }
            k kVarPollFirst = x.this.f10731G.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = kVarPollFirst.f10779a;
            int i6 = kVarPollFirst.f10780b;
            ComponentCallbacksC0511f componentCallbacksC0511fI = x.this.f10745c.i(str);
            if (componentCallbacksC0511fI != null) {
                componentCallbacksC0511fI.P0(i6, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    class b extends androidx.activity.o {
        b(boolean z5) {
            super(z5);
        }

        @Override // androidx.activity.o
        public void d() {
            x.this.B0();
        }
    }

    class c implements androidx.core.view.r {
        c() {
        }

        @Override // androidx.core.view.r
        public boolean a(MenuItem menuItem) {
            return x.this.H(menuItem);
        }

        @Override // androidx.core.view.r
        public void b(Menu menu) {
            x.this.I(menu);
        }

        @Override // androidx.core.view.r
        public void c(Menu menu, MenuInflater menuInflater) {
            x.this.A(menu, menuInflater);
        }

        @Override // androidx.core.view.r
        public void d(Menu menu) {
            x.this.M(menu);
        }
    }

    class d extends C0520o {
        d() {
        }

        @Override // androidx.fragment.app.C0520o
        public ComponentCallbacksC0511f a(ClassLoader classLoader, String str) {
            return x.this.s0().b(x.this.s0().f(), str, null);
        }
    }

    class e implements N {
        e() {
        }

        @Override // androidx.fragment.app.N
        public M a(ViewGroup viewGroup) {
            return new C0509d(viewGroup);
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x.this.Y(true);
        }
    }

    class g implements B {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ComponentCallbacksC0511f f10775a;

        g(ComponentCallbacksC0511f componentCallbacksC0511f) {
            this.f10775a = componentCallbacksC0511f;
        }

        @Override // androidx.fragment.app.B
        public void a(x xVar, ComponentCallbacksC0511f componentCallbacksC0511f) {
            this.f10775a.t0(componentCallbacksC0511f);
        }
    }

    class h implements InterfaceC0641b<C0640a> {
        h() {
        }

        @Override // d.InterfaceC0641b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0640a c0640a) {
            k kVarPollFirst = x.this.f10731G.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = kVarPollFirst.f10779a;
            int i5 = kVarPollFirst.f10780b;
            ComponentCallbacksC0511f componentCallbacksC0511fI = x.this.f10745c.i(str);
            if (componentCallbacksC0511fI != null) {
                componentCallbacksC0511fI.q0(i5, c0640a.c(), c0640a.a());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    class i implements InterfaceC0641b<C0640a> {
        i() {
        }

        @Override // d.InterfaceC0641b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C0640a c0640a) {
            k kVarPollFirst = x.this.f10731G.pollFirst();
            if (kVarPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = kVarPollFirst.f10779a;
            int i5 = kVarPollFirst.f10780b;
            ComponentCallbacksC0511f componentCallbacksC0511fI = x.this.f10745c.i(str);
            if (componentCallbacksC0511fI != null) {
                componentCallbacksC0511fI.q0(i5, c0640a.c(), c0640a.a());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    static class j extends AbstractC0674a<C0645f, C0640a> {
        j() {
        }

        @Override // e.AbstractC0674a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, C0645f c0645f) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intentA = c0645f.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intentA.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    c0645f = new C0645f.a(c0645f.A()).b(null).c(c0645f.f(), c0645f.c()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c0645f);
            if (x.F0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // e.AbstractC0674a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public C0640a c(int i5, Intent intent) {
            return new C0640a(i5, intent);
        }
    }

    public interface l {
        void onBackStackChanged();
    }

    interface m {
        boolean a(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2);
    }

    private class n implements m {

        /* renamed from: a, reason: collision with root package name */
        final String f10781a;

        /* renamed from: b, reason: collision with root package name */
        final int f10782b;

        /* renamed from: c, reason: collision with root package name */
        final int f10783c;

        n(String str, int i5, int i6) {
            this.f10781a = str;
            this.f10782b = i5;
            this.f10783c = i6;
        }

        @Override // androidx.fragment.app.x.m
        public boolean a(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2) {
            ComponentCallbacksC0511f componentCallbacksC0511f = x.this.f10767y;
            if (componentCallbacksC0511f == null || this.f10782b >= 0 || this.f10781a != null || !componentCallbacksC0511f.v().W0()) {
                return x.this.Z0(arrayList, arrayList2, this.f10781a, this.f10782b, this.f10783c);
            }
            return false;
        }
    }

    public static boolean F0(int i5) {
        return f10724S || Log.isLoggable("FragmentManager", i5);
    }

    private boolean G0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        return (componentCallbacksC0511f.f10609E && componentCallbacksC0511f.f10610F) || componentCallbacksC0511f.f10653v.n();
    }

    private boolean H0() {
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10766x;
        if (componentCallbacksC0511f == null) {
            return true;
        }
        return componentCallbacksC0511f.g0() && this.f10766x.K().H0();
    }

    private void J(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (componentCallbacksC0511f == null || !componentCallbacksC0511f.equals(d0(componentCallbacksC0511f.f10637f))) {
            return;
        }
        componentCallbacksC0511f.o1();
    }

    private void Q(int i5) {
        try {
            this.f10744b = true;
            this.f10745c.d(i5);
            Q0(i5, false);
            Iterator<M> it = r().iterator();
            while (it.hasNext()) {
                it.next().j();
            }
            this.f10744b = false;
            Y(true);
        } catch (Throwable th) {
            this.f10744b = false;
            throw th;
        }
    }

    private void T() {
        if (this.f10736L) {
            this.f10736L = false;
            m1();
        }
    }

    private void V() {
        Iterator<M> it = r().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    private void X(boolean z5) {
        if (this.f10744b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f10764v == null) {
            if (!this.f10735K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f10764v.g().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z5) {
            o();
        }
        if (this.f10737M == null) {
            this.f10737M = new ArrayList<>();
            this.f10738N = new ArrayList<>();
        }
    }

    private boolean Y0(String str, int i5, int i6) {
        Y(false);
        X(true);
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10767y;
        if (componentCallbacksC0511f != null && i5 < 0 && str == null && componentCallbacksC0511f.v().W0()) {
            return true;
        }
        boolean zZ0 = Z0(this.f10737M, this.f10738N, str, i5, i6);
        if (zZ0) {
            this.f10744b = true;
            try {
                b1(this.f10737M, this.f10738N);
            } finally {
                p();
            }
        }
        o1();
        T();
        this.f10745c.b();
        return zZ0;
    }

    public static /* synthetic */ void a(x xVar, Integer num) {
        if (xVar.H0() && num.intValue() == 80) {
            xVar.D(false);
        }
    }

    private static void a0(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        while (i5 < i6) {
            C0506a c0506a = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue()) {
                c0506a.x(-1);
                c0506a.C();
            } else {
                c0506a.x(1);
                c0506a.B();
            }
            i5++;
        }
    }

    private void b0(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2, int i5, int i6) {
        boolean z5 = arrayList.get(i5).f10445r;
        ArrayList<ComponentCallbacksC0511f> arrayList3 = this.f10739O;
        if (arrayList3 == null) {
            this.f10739O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f10739O.addAll(this.f10745c.o());
        ComponentCallbacksC0511f componentCallbacksC0511fW0 = w0();
        boolean z6 = false;
        for (int i7 = i5; i7 < i6; i7++) {
            C0506a c0506a = arrayList.get(i7);
            componentCallbacksC0511fW0 = !arrayList2.get(i7).booleanValue() ? c0506a.D(this.f10739O, componentCallbacksC0511fW0) : c0506a.G(this.f10739O, componentCallbacksC0511fW0);
            z6 = z6 || c0506a.f10436i;
        }
        this.f10739O.clear();
        if (!z5 && this.f10763u >= 1) {
            for (int i8 = i5; i8 < i6; i8++) {
                ArrayList<G.a> arrayList4 = arrayList.get(i8).f10430c;
                int size = arrayList4.size();
                int i9 = 0;
                while (i9 < size) {
                    G.a aVar = arrayList4.get(i9);
                    i9++;
                    ComponentCallbacksC0511f componentCallbacksC0511f = aVar.f10448b;
                    if (componentCallbacksC0511f != null && componentCallbacksC0511f.f10651t != null) {
                        this.f10745c.r(t(componentCallbacksC0511f));
                    }
                }
            }
        }
        a0(arrayList, arrayList2, i5, i6);
        boolean zBooleanValue = arrayList2.get(i6 - 1).booleanValue();
        for (int i10 = i5; i10 < i6; i10++) {
            C0506a c0506a2 = arrayList.get(i10);
            if (zBooleanValue) {
                for (int size2 = c0506a2.f10430c.size() - 1; size2 >= 0; size2--) {
                    ComponentCallbacksC0511f componentCallbacksC0511f2 = c0506a2.f10430c.get(size2).f10448b;
                    if (componentCallbacksC0511f2 != null) {
                        t(componentCallbacksC0511f2).m();
                    }
                }
            } else {
                ArrayList<G.a> arrayList5 = c0506a2.f10430c;
                int size3 = arrayList5.size();
                int i11 = 0;
                while (i11 < size3) {
                    G.a aVar2 = arrayList5.get(i11);
                    i11++;
                    ComponentCallbacksC0511f componentCallbacksC0511f3 = aVar2.f10448b;
                    if (componentCallbacksC0511f3 != null) {
                        t(componentCallbacksC0511f3).m();
                    }
                }
            }
        }
        Q0(this.f10763u, true);
        for (M m5 : s(arrayList, i5, i6)) {
            m5.r(zBooleanValue);
            m5.p();
            m5.g();
        }
        while (i5 < i6) {
            C0506a c0506a3 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && c0506a3.f10518v >= 0) {
                c0506a3.f10518v = -1;
            }
            c0506a3.F();
            i5++;
        }
        if (z6) {
            c1();
        }
    }

    private void b1(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            if (!arrayList.get(i5).f10445r) {
                if (i6 != i5) {
                    b0(arrayList, arrayList2, i6, i5);
                }
                i6 = i5 + 1;
                if (arrayList2.get(i5).booleanValue()) {
                    while (i6 < size && arrayList2.get(i6).booleanValue() && !arrayList.get(i6).f10445r) {
                        i6++;
                    }
                }
                b0(arrayList, arrayList2, i5, i6);
                i5 = i6 - 1;
            }
            i5++;
        }
        if (i6 != size) {
            b0(arrayList, arrayList2, i6, size);
        }
    }

    public static /* synthetic */ void c(x xVar, androidx.core.app.q qVar) {
        if (xVar.H0()) {
            xVar.L(qVar.a(), false);
        }
    }

    private void c1() {
        if (this.f10755m != null) {
            for (int i5 = 0; i5 < this.f10755m.size(); i5++) {
                this.f10755m.get(i5).onBackStackChanged();
            }
        }
    }

    public static /* synthetic */ void d(x xVar, androidx.core.app.g gVar) {
        if (xVar.H0()) {
            xVar.E(gVar.a(), false);
        }
    }

    public static /* synthetic */ void e(x xVar, Configuration configuration) {
        if (xVar.H0()) {
            xVar.x(configuration, false);
        }
    }

    private int e0(String str, int i5, boolean z5) {
        ArrayList<C0506a> arrayList = this.f10746d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i5 < 0) {
            if (z5) {
                return 0;
            }
            return this.f10746d.size() - 1;
        }
        int size = this.f10746d.size() - 1;
        while (size >= 0) {
            C0506a c0506a = this.f10746d.get(size);
            if ((str != null && str.equals(c0506a.E())) || (i5 >= 0 && i5 == c0506a.f10518v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z5) {
            if (size == this.f10746d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C0506a c0506a2 = this.f10746d.get(size - 1);
            if ((str == null || !str.equals(c0506a2.E())) && (i5 < 0 || i5 != c0506a2.f10518v)) {
                break;
            }
            size--;
        }
        return size;
    }

    static int e1(int i5) {
        if (i5 == 4097) {
            return 8194;
        }
        if (i5 == 8194) {
            return 4097;
        }
        if (i5 == 8197) {
            return 4100;
        }
        if (i5 != 4099) {
            return i5 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    static x i0(View view) {
        ActivityC0516k activityC0516k;
        ComponentCallbacksC0511f componentCallbacksC0511fJ0 = j0(view);
        if (componentCallbacksC0511fJ0 != null) {
            if (componentCallbacksC0511fJ0.g0()) {
                return componentCallbacksC0511fJ0.v();
            }
            throw new IllegalStateException("The Fragment " + componentCallbacksC0511fJ0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                activityC0516k = null;
                break;
            }
            if (context instanceof ActivityC0516k) {
                activityC0516k = (ActivityC0516k) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (activityC0516k != null) {
            return activityC0516k.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    private static ComponentCallbacksC0511f j0(View view) {
        while (view != null) {
            ComponentCallbacksC0511f componentCallbacksC0511fZ0 = z0(view);
            if (componentCallbacksC0511fZ0 != null) {
                return componentCallbacksC0511fZ0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private void k0() {
        Iterator<M> it = r().iterator();
        while (it.hasNext()) {
            it.next().k();
        }
    }

    private void k1(ComponentCallbacksC0511f componentCallbacksC0511f) {
        ViewGroup viewGroupP0 = p0(componentCallbacksC0511f);
        if (viewGroupP0 == null || componentCallbacksC0511f.x() + componentCallbacksC0511f.A() + componentCallbacksC0511f.M() + componentCallbacksC0511f.N() <= 0) {
            return;
        }
        int i5 = S.b.f5200c;
        if (viewGroupP0.getTag(i5) == null) {
            viewGroupP0.setTag(i5, componentCallbacksC0511f);
        }
        ((ComponentCallbacksC0511f) viewGroupP0.getTag(i5)).L1(componentCallbacksC0511f.L());
    }

    private boolean l0(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f10743a) {
            if (this.f10743a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f10743a.size();
                boolean zA = false;
                for (int i5 = 0; i5 < size; i5++) {
                    zA |= this.f10743a.get(i5).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f10743a.clear();
                this.f10764v.g().removeCallbacks(this.f10742R);
            }
        }
    }

    private void m1() {
        Iterator<E> it = this.f10745c.k().iterator();
        while (it.hasNext()) {
            T0(it.next());
        }
    }

    private A n0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        return this.f10740P.P(componentCallbacksC0511f);
    }

    private void n1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new L("FragmentManager"));
        p<?> pVar = this.f10764v;
        if (pVar != null) {
            try {
                pVar.h("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e6) {
                Log.e("FragmentManager", "Failed dumping state", e6);
                throw runtimeException;
            }
        }
        try {
            U("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e7) {
            Log.e("FragmentManager", "Failed dumping state", e7);
            throw runtimeException;
        }
    }

    private void o() {
        if (M0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void o1() {
        synchronized (this.f10743a) {
            try {
                if (this.f10743a.isEmpty()) {
                    this.f10750h.j(m0() > 0 && K0(this.f10766x));
                } else {
                    this.f10750h.j(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void p() {
        this.f10744b = false;
        this.f10738N.clear();
        this.f10737M.clear();
    }

    private ViewGroup p0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        ViewGroup viewGroup = componentCallbacksC0511f.f10612H;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (componentCallbacksC0511f.f10656y > 0 && this.f10765w.d()) {
            View viewC = this.f10765w.c(componentCallbacksC0511f.f10656y);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    private void q() {
        p<?> pVar = this.f10764v;
        if (pVar instanceof X ? this.f10745c.p().T() : pVar.f() instanceof Activity ? !((Activity) this.f10764v.f()).isChangingConfigurations() : true) {
            Iterator<C0508c> it = this.f10752j.values().iterator();
            while (it.hasNext()) {
                Iterator<String> it2 = it.next().f10534a.iterator();
                while (it2.hasNext()) {
                    this.f10745c.p().M(it2.next());
                }
            }
        }
    }

    private Set<M> r() {
        HashSet hashSet = new HashSet();
        Iterator<E> it = this.f10745c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().f10612H;
            if (viewGroup != null) {
                hashSet.add(M.o(viewGroup, x0()));
            }
        }
        return hashSet;
    }

    private Set<M> s(ArrayList<C0506a> arrayList, int i5, int i6) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i5 < i6) {
            ArrayList<G.a> arrayList2 = arrayList.get(i5).f10430c;
            int size = arrayList2.size();
            int i7 = 0;
            while (i7 < size) {
                G.a aVar = arrayList2.get(i7);
                i7++;
                ComponentCallbacksC0511f componentCallbacksC0511f = aVar.f10448b;
                if (componentCallbacksC0511f != null && (viewGroup = componentCallbacksC0511f.f10612H) != null) {
                    hashSet.add(M.n(viewGroup, this));
                }
            }
            i5++;
        }
        return hashSet;
    }

    static ComponentCallbacksC0511f z0(View view) {
        Object tag = view.getTag(S.b.f5198a);
        if (tag instanceof ComponentCallbacksC0511f) {
            return (ComponentCallbacksC0511f) tag;
        }
        return null;
    }

    boolean A(Menu menu, MenuInflater menuInflater) {
        if (this.f10763u < 1) {
            return false;
        }
        ArrayList<ComponentCallbacksC0511f> arrayList = null;
        boolean z5 = false;
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null && J0(componentCallbacksC0511f) && componentCallbacksC0511f.b1(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(componentCallbacksC0511f);
                z5 = true;
            }
        }
        if (this.f10747e != null) {
            for (int i5 = 0; i5 < this.f10747e.size(); i5++) {
                ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10747e.get(i5);
                if (arrayList == null || !arrayList.contains(componentCallbacksC0511f2)) {
                    componentCallbacksC0511f2.B0();
                }
            }
        }
        this.f10747e = arrayList;
        return z5;
    }

    W A0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        return this.f10740P.S(componentCallbacksC0511f);
    }

    void B() {
        this.f10735K = true;
        Y(true);
        V();
        q();
        Q(-1);
        Object obj = this.f10764v;
        if (obj instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj).removeOnTrimMemoryListener(this.f10759q);
        }
        Object obj2 = this.f10764v;
        if (obj2 instanceof androidx.core.content.b) {
            ((androidx.core.content.b) obj2).removeOnConfigurationChangedListener(this.f10758p);
        }
        Object obj3 = this.f10764v;
        if (obj3 instanceof androidx.core.app.n) {
            ((androidx.core.app.n) obj3).removeOnMultiWindowModeChangedListener(this.f10760r);
        }
        Object obj4 = this.f10764v;
        if (obj4 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj4).removeOnPictureInPictureModeChangedListener(this.f10761s);
        }
        Object obj5 = this.f10764v;
        if (obj5 instanceof InterfaceC0468m) {
            ((InterfaceC0468m) obj5).removeMenuProvider(this.f10762t);
        }
        this.f10764v = null;
        this.f10765w = null;
        this.f10766x = null;
        if (this.f10749g != null) {
            this.f10750h.h();
            this.f10749g = null;
        }
        AbstractC0642c<Intent> abstractC0642c = this.f10728D;
        if (abstractC0642c != null) {
            abstractC0642c.c();
            this.f10729E.c();
            this.f10730F.c();
        }
    }

    void B0() {
        Y(true);
        if (this.f10750h.g()) {
            W0();
        } else {
            this.f10749g.k();
        }
    }

    void C() {
        Q(1);
    }

    void C0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (F0(2)) {
            Log.v("FragmentManager", "hide: " + componentCallbacksC0511f);
        }
        if (componentCallbacksC0511f.f10605A) {
            return;
        }
        componentCallbacksC0511f.f10605A = true;
        componentCallbacksC0511f.f10618Q = true ^ componentCallbacksC0511f.f10618Q;
        k1(componentCallbacksC0511f);
    }

    void D(boolean z5) {
        if (z5 && (this.f10764v instanceof androidx.core.content.c)) {
            n1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.h1();
                if (z5) {
                    componentCallbacksC0511f.f10653v.D(true);
                }
            }
        }
    }

    void D0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (componentCallbacksC0511f.f10643l && G0(componentCallbacksC0511f)) {
            this.f10732H = true;
        }
    }

    void E(boolean z5, boolean z6) {
        if (z6 && (this.f10764v instanceof androidx.core.app.n)) {
            n1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.i1(z5);
                if (z6) {
                    componentCallbacksC0511f.f10653v.E(z5, true);
                }
            }
        }
    }

    public boolean E0() {
        return this.f10735K;
    }

    void F(ComponentCallbacksC0511f componentCallbacksC0511f) {
        Iterator<B> it = this.f10757o.iterator();
        while (it.hasNext()) {
            it.next().a(this, componentCallbacksC0511f);
        }
    }

    void G() {
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.l()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.F0(componentCallbacksC0511f.h0());
                componentCallbacksC0511f.f10653v.G();
            }
        }
    }

    boolean H(MenuItem menuItem) {
        if (this.f10763u < 1) {
            return false;
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null && componentCallbacksC0511f.j1(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void I(Menu menu) {
        if (this.f10763u < 1) {
            return;
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.k1(menu);
            }
        }
    }

    boolean I0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (componentCallbacksC0511f == null) {
            return false;
        }
        return componentCallbacksC0511f.h0();
    }

    boolean J0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (componentCallbacksC0511f == null) {
            return true;
        }
        return componentCallbacksC0511f.k0();
    }

    void K() {
        Q(5);
    }

    boolean K0(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (componentCallbacksC0511f == null) {
            return true;
        }
        x xVar = componentCallbacksC0511f.f10651t;
        return componentCallbacksC0511f.equals(xVar.w0()) && K0(xVar.f10766x);
    }

    void L(boolean z5, boolean z6) {
        if (z6 && (this.f10764v instanceof androidx.core.app.o)) {
            n1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.m1(z5);
                if (z6) {
                    componentCallbacksC0511f.f10653v.L(z5, true);
                }
            }
        }
    }

    boolean L0(int i5) {
        return this.f10763u >= i5;
    }

    boolean M(Menu menu) {
        boolean z5 = false;
        if (this.f10763u < 1) {
            return false;
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null && J0(componentCallbacksC0511f) && componentCallbacksC0511f.n1(menu)) {
                z5 = true;
            }
        }
        return z5;
    }

    public boolean M0() {
        return this.f10733I || this.f10734J;
    }

    void N() {
        o1();
        J(this.f10767y);
    }

    void N0(ComponentCallbacksC0511f componentCallbacksC0511f, String[] strArr, int i5) {
        if (this.f10730F == null) {
            this.f10764v.k(componentCallbacksC0511f, strArr, i5);
            return;
        }
        this.f10731G.addLast(new k(componentCallbacksC0511f.f10637f, i5));
        this.f10730F.a(strArr);
    }

    void O() {
        this.f10733I = false;
        this.f10734J = false;
        this.f10740P.V(false);
        Q(7);
    }

    void O0(ComponentCallbacksC0511f componentCallbacksC0511f, Intent intent, int i5, Bundle bundle) {
        if (this.f10728D == null) {
            this.f10764v.l(componentCallbacksC0511f, intent, i5, bundle);
            return;
        }
        this.f10731G.addLast(new k(componentCallbacksC0511f.f10637f, i5));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f10728D.a(intent);
    }

    void P() {
        this.f10733I = false;
        this.f10734J = false;
        this.f10740P.V(false);
        Q(5);
    }

    void P0(ComponentCallbacksC0511f componentCallbacksC0511f, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        if (this.f10729E == null) {
            this.f10764v.m(componentCallbacksC0511f, intentSender, i5, intent, i6, i7, i8, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (F0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + componentCallbacksC0511f);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        C0645f c0645fA = new C0645f.a(intentSender).b(intent).c(i7, i6).a();
        this.f10731G.addLast(new k(componentCallbacksC0511f.f10637f, i5));
        if (F0(2)) {
            Log.v("FragmentManager", "Fragment " + componentCallbacksC0511f + "is launching an IntentSender for result ");
        }
        this.f10729E.a(c0645fA);
    }

    void Q0(int i5, boolean z5) {
        p<?> pVar;
        if (this.f10764v == null && i5 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z5 || i5 != this.f10763u) {
            this.f10763u = i5;
            this.f10745c.t();
            m1();
            if (this.f10732H && (pVar = this.f10764v) != null && this.f10763u == 7) {
                pVar.n();
                this.f10732H = false;
            }
        }
    }

    void R() {
        this.f10734J = true;
        this.f10740P.V(true);
        Q(4);
    }

    void R0() {
        if (this.f10764v == null) {
            return;
        }
        this.f10733I = false;
        this.f10734J = false;
        this.f10740P.V(false);
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.o0();
            }
        }
    }

    void S() {
        Q(2);
    }

    void S0(FragmentContainerView fragmentContainerView) {
        View view;
        for (E e6 : this.f10745c.k()) {
            ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
            if (componentCallbacksC0511fK.f10656y == fragmentContainerView.getId() && (view = componentCallbacksC0511fK.f10613I) != null && view.getParent() == null) {
                componentCallbacksC0511fK.f10612H = fragmentContainerView;
                e6.b();
            }
        }
    }

    void T0(E e6) {
        ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
        if (componentCallbacksC0511fK.f10614J) {
            if (this.f10744b) {
                this.f10736L = true;
            } else {
                componentCallbacksC0511fK.f10614J = false;
                e6.m();
            }
        }
    }

    public void U(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String str2 = str + "    ";
        this.f10745c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<ComponentCallbacksC0511f> arrayList = this.f10747e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i5 = 0; i5 < size2; i5++) {
                ComponentCallbacksC0511f componentCallbacksC0511f = this.f10747e.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0511f.toString());
            }
        }
        ArrayList<C0506a> arrayList2 = this.f10746d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i6 = 0; i6 < size; i6++) {
                C0506a c0506a = this.f10746d.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(c0506a.toString());
                c0506a.z(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f10751i.get());
        synchronized (this.f10743a) {
            try {
                int size3 = this.f10743a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i7 = 0; i7 < size3; i7++) {
                        m mVar = this.f10743a.get(i7);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i7);
                        printWriter.print(": ");
                        printWriter.println(mVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f10764v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f10765w);
        if (this.f10766x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f10766x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f10763u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f10733I);
        printWriter.print(" mStopped=");
        printWriter.print(this.f10734J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f10735K);
        if (this.f10732H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f10732H);
        }
    }

    public void U0() {
        W(new n(null, -1, 0), false);
    }

    void V0(int i5, int i6, boolean z5) {
        if (i5 >= 0) {
            W(new n(null, i5, i6), z5);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    void W(m mVar, boolean z5) {
        if (!z5) {
            if (this.f10764v == null) {
                if (!this.f10735K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            o();
        }
        synchronized (this.f10743a) {
            try {
                if (this.f10764v == null) {
                    if (!z5) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f10743a.add(mVar);
                    g1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean W0() {
        return Y0(null, -1, 0);
    }

    public boolean X0(int i5, int i6) {
        if (i5 >= 0) {
            return Y0(null, i5, i6);
        }
        throw new IllegalArgumentException("Bad id: " + i5);
    }

    boolean Y(boolean z5) {
        X(z5);
        boolean z6 = false;
        while (l0(this.f10737M, this.f10738N)) {
            z6 = true;
            this.f10744b = true;
            try {
                b1(this.f10737M, this.f10738N);
            } finally {
                p();
            }
        }
        o1();
        T();
        this.f10745c.b();
        return z6;
    }

    void Z(m mVar, boolean z5) {
        if (z5 && (this.f10764v == null || this.f10735K)) {
            return;
        }
        X(z5);
        if (mVar.a(this.f10737M, this.f10738N)) {
            this.f10744b = true;
            try {
                b1(this.f10737M, this.f10738N);
            } finally {
                p();
            }
        }
        o1();
        T();
        this.f10745c.b();
    }

    boolean Z0(ArrayList<C0506a> arrayList, ArrayList<Boolean> arrayList2, String str, int i5, int i6) {
        int iE0 = e0(str, i5, (i6 & 1) != 0);
        if (iE0 < 0) {
            return false;
        }
        for (int size = this.f10746d.size() - 1; size >= iE0; size--) {
            arrayList.add(this.f10746d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    void a1(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (F0(2)) {
            Log.v("FragmentManager", "remove: " + componentCallbacksC0511f + " nesting=" + componentCallbacksC0511f.f10650s);
        }
        boolean zI0 = componentCallbacksC0511f.i0();
        if (componentCallbacksC0511f.f10606B && zI0) {
            return;
        }
        this.f10745c.u(componentCallbacksC0511f);
        if (G0(componentCallbacksC0511f)) {
            this.f10732H = true;
        }
        componentCallbacksC0511f.f10644m = true;
        k1(componentCallbacksC0511f);
    }

    public boolean c0() {
        boolean zY = Y(true);
        k0();
        return zY;
    }

    ComponentCallbacksC0511f d0(String str) {
        return this.f10745c.f(str);
    }

    void d1(Parcelable parcelable) {
        E e6;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f10764v.f().getClassLoader());
                this.f10753k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<D> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f10764v.f().getClassLoader());
                arrayList.add((D) bundle.getParcelable("state"));
            }
        }
        this.f10745c.x(arrayList);
        z zVar = (z) bundle3.getParcelable("state");
        if (zVar == null) {
            return;
        }
        this.f10745c.v();
        ArrayList<String> arrayList2 = zVar.f10785a;
        int size = arrayList2.size();
        int i5 = 0;
        while (i5 < size) {
            String str3 = arrayList2.get(i5);
            i5++;
            D dB = this.f10745c.B(str3, null);
            if (dB != null) {
                ComponentCallbacksC0511f componentCallbacksC0511fO = this.f10740P.O(dB.f10399b);
                if (componentCallbacksC0511fO != null) {
                    if (F0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + componentCallbacksC0511fO);
                    }
                    e6 = new E(this.f10756n, this.f10745c, componentCallbacksC0511fO, dB);
                } else {
                    e6 = new E(this.f10756n, this.f10745c, this.f10764v.f().getClassLoader(), q0(), dB);
                }
                ComponentCallbacksC0511f componentCallbacksC0511fK = e6.k();
                componentCallbacksC0511fK.f10651t = this;
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + componentCallbacksC0511fK.f10637f + "): " + componentCallbacksC0511fK);
                }
                e6.o(this.f10764v.f().getClassLoader());
                this.f10745c.r(e6);
                e6.t(this.f10763u);
            }
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10740P.R()) {
            if (!this.f10745c.c(componentCallbacksC0511f.f10637f)) {
                if (F0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + componentCallbacksC0511f + " that was not found in the set of active Fragments " + zVar.f10785a);
                }
                this.f10740P.U(componentCallbacksC0511f);
                componentCallbacksC0511f.f10651t = this;
                E e7 = new E(this.f10756n, this.f10745c, componentCallbacksC0511f);
                e7.t(1);
                e7.m();
                componentCallbacksC0511f.f10644m = true;
                e7.m();
            }
        }
        this.f10745c.w(zVar.f10786b);
        if (zVar.f10787c != null) {
            this.f10746d = new ArrayList<>(zVar.f10787c.length);
            int i6 = 0;
            while (true) {
                C0507b[] c0507bArr = zVar.f10787c;
                if (i6 >= c0507bArr.length) {
                    break;
                }
                C0506a c0506aC = c0507bArr[i6].c(this);
                if (F0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + c0506aC.f10518v + "): " + c0506aC);
                    PrintWriter printWriter = new PrintWriter(new L("FragmentManager"));
                    c0506aC.A("  ", printWriter, false);
                    printWriter.close();
                }
                this.f10746d.add(c0506aC);
                i6++;
            }
        } else {
            this.f10746d = null;
        }
        this.f10751i.set(zVar.f10788d);
        String str4 = zVar.f10789e;
        if (str4 != null) {
            ComponentCallbacksC0511f componentCallbacksC0511fD0 = d0(str4);
            this.f10767y = componentCallbacksC0511fD0;
            J(componentCallbacksC0511fD0);
        }
        ArrayList<String> arrayList3 = zVar.f10790f;
        if (arrayList3 != null) {
            for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                this.f10752j.put(arrayList3.get(i7), zVar.f10791g.get(i7));
            }
        }
        this.f10731G = new ArrayDeque<>(zVar.f10792h);
    }

    public ComponentCallbacksC0511f f0(int i5) {
        return this.f10745c.g(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle f1() {
        C0507b[] c0507bArr;
        int size;
        Bundle bundle = new Bundle();
        k0();
        V();
        Y(true);
        this.f10733I = true;
        this.f10740P.V(true);
        ArrayList<String> arrayListY = this.f10745c.y();
        ArrayList<D> arrayListM = this.f10745c.m();
        if (!arrayListM.isEmpty()) {
            ArrayList<String> arrayListZ = this.f10745c.z();
            ArrayList<C0506a> arrayList = this.f10746d;
            int i5 = 0;
            if (arrayList == null || (size = arrayList.size()) <= 0) {
                c0507bArr = null;
            } else {
                c0507bArr = new C0507b[size];
                for (int i6 = 0; i6 < size; i6++) {
                    c0507bArr[i6] = new C0507b(this.f10746d.get(i6));
                    if (F0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i6 + ": " + this.f10746d.get(i6));
                    }
                }
            }
            z zVar = new z();
            zVar.f10785a = arrayListY;
            zVar.f10786b = arrayListZ;
            zVar.f10787c = c0507bArr;
            zVar.f10788d = this.f10751i.get();
            ComponentCallbacksC0511f componentCallbacksC0511f = this.f10767y;
            if (componentCallbacksC0511f != null) {
                zVar.f10789e = componentCallbacksC0511f.f10637f;
            }
            zVar.f10790f.addAll(this.f10752j.keySet());
            zVar.f10791g.addAll(this.f10752j.values());
            zVar.f10792h = new ArrayList<>(this.f10731G);
            bundle.putParcelable("state", zVar);
            for (String str : this.f10753k.keySet()) {
                bundle.putBundle("result_" + str, this.f10753k.get(str));
            }
            int size2 = arrayListM.size();
            while (i5 < size2) {
                D d6 = arrayListM.get(i5);
                i5++;
                D d7 = d6;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", d7);
                bundle.putBundle("fragment_" + d7.f10399b, bundle2);
            }
        } else if (F0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    void g(C0506a c0506a) {
        if (this.f10746d == null) {
            this.f10746d = new ArrayList<>();
        }
        this.f10746d.add(c0506a);
    }

    public ComponentCallbacksC0511f g0(String str) {
        return this.f10745c.h(str);
    }

    void g1() {
        synchronized (this.f10743a) {
            try {
                if (this.f10743a.size() == 1) {
                    this.f10764v.g().removeCallbacks(this.f10742R);
                    this.f10764v.g().post(this.f10742R);
                    o1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    E h(ComponentCallbacksC0511f componentCallbacksC0511f) {
        String str = componentCallbacksC0511f.f10621T;
        if (str != null) {
            T.c.f(componentCallbacksC0511f, str);
        }
        if (F0(2)) {
            Log.v("FragmentManager", "add: " + componentCallbacksC0511f);
        }
        E eT = t(componentCallbacksC0511f);
        componentCallbacksC0511f.f10651t = this;
        this.f10745c.r(eT);
        if (!componentCallbacksC0511f.f10606B) {
            this.f10745c.a(componentCallbacksC0511f);
            componentCallbacksC0511f.f10644m = false;
            if (componentCallbacksC0511f.f10613I == null) {
                componentCallbacksC0511f.f10618Q = false;
            }
            if (G0(componentCallbacksC0511f)) {
                this.f10732H = true;
            }
        }
        return eT;
    }

    ComponentCallbacksC0511f h0(String str) {
        return this.f10745c.i(str);
    }

    void h1(ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5) {
        ViewGroup viewGroupP0 = p0(componentCallbacksC0511f);
        if (viewGroupP0 == null || !(viewGroupP0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupP0).setDrawDisappearingViewsLast(!z5);
    }

    public void i(B b6) {
        this.f10757o.add(b6);
    }

    void i1(ComponentCallbacksC0511f componentCallbacksC0511f, AbstractC0533m.b bVar) {
        if (componentCallbacksC0511f.equals(d0(componentCallbacksC0511f.f10637f)) && (componentCallbacksC0511f.f10652u == null || componentCallbacksC0511f.f10651t == this)) {
            componentCallbacksC0511f.f10622U = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + componentCallbacksC0511f + " is not an active fragment of FragmentManager " + this);
    }

    int j() {
        return this.f10751i.getAndIncrement();
    }

    void j1(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (componentCallbacksC0511f == null || (componentCallbacksC0511f.equals(d0(componentCallbacksC0511f.f10637f)) && (componentCallbacksC0511f.f10652u == null || componentCallbacksC0511f.f10651t == this))) {
            ComponentCallbacksC0511f componentCallbacksC0511f2 = this.f10767y;
            this.f10767y = componentCallbacksC0511f;
            J(componentCallbacksC0511f2);
            J(this.f10767y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + componentCallbacksC0511f + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    void k(p<?> pVar, AbstractC0518m abstractC0518m, ComponentCallbacksC0511f componentCallbacksC0511f) {
        String str;
        if (this.f10764v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f10764v = pVar;
        this.f10765w = abstractC0518m;
        this.f10766x = componentCallbacksC0511f;
        if (componentCallbacksC0511f != null) {
            i(new g(componentCallbacksC0511f));
        } else if (pVar instanceof B) {
            i((B) pVar);
        }
        if (this.f10766x != null) {
            o1();
        }
        if (pVar instanceof androidx.activity.r) {
            androidx.activity.r rVar = (androidx.activity.r) pVar;
            androidx.activity.p onBackPressedDispatcher = rVar.getOnBackPressedDispatcher();
            this.f10749g = onBackPressedDispatcher;
            InterfaceC0539t interfaceC0539t = rVar;
            if (componentCallbacksC0511f != null) {
                interfaceC0539t = componentCallbacksC0511f;
            }
            onBackPressedDispatcher.h(interfaceC0539t, this.f10750h);
        }
        if (componentCallbacksC0511f != null) {
            this.f10740P = componentCallbacksC0511f.f10651t.n0(componentCallbacksC0511f);
        } else if (pVar instanceof X) {
            this.f10740P = A.Q(((X) pVar).getViewModelStore());
        } else {
            this.f10740P = new A(false);
        }
        this.f10740P.V(M0());
        this.f10745c.A(this.f10740P);
        Object obj = this.f10764v;
        if ((obj instanceof InterfaceC0576f) && componentCallbacksC0511f == null) {
            C0574d savedStateRegistry = ((InterfaceC0576f) obj).getSavedStateRegistry();
            savedStateRegistry.h("android:support:fragments", new C0574d.c() { // from class: androidx.fragment.app.w
                @Override // c0.C0574d.c
                public final Bundle a() {
                    return this.f10723a.f1();
                }
            });
            Bundle bundleB = savedStateRegistry.b("android:support:fragments");
            if (bundleB != null) {
                d1(bundleB);
            }
        }
        Object obj2 = this.f10764v;
        if (obj2 instanceof InterfaceC0644e) {
            AbstractC0643d activityResultRegistry = ((InterfaceC0644e) obj2).getActivityResultRegistry();
            if (componentCallbacksC0511f != null) {
                str = componentCallbacksC0511f.f10637f + ":";
            } else {
                str = BuildConfig.FLAVOR;
            }
            String str2 = "FragmentManager:" + str;
            this.f10728D = activityResultRegistry.j(str2 + "StartActivityForResult", new C0676c(), new h());
            this.f10729E = activityResultRegistry.j(str2 + "StartIntentSenderForResult", new j(), new i());
            this.f10730F = activityResultRegistry.j(str2 + "RequestPermissions", new C0675b(), new a());
        }
        Object obj3 = this.f10764v;
        if (obj3 instanceof androidx.core.content.b) {
            ((androidx.core.content.b) obj3).addOnConfigurationChangedListener(this.f10758p);
        }
        Object obj4 = this.f10764v;
        if (obj4 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj4).addOnTrimMemoryListener(this.f10759q);
        }
        Object obj5 = this.f10764v;
        if (obj5 instanceof androidx.core.app.n) {
            ((androidx.core.app.n) obj5).addOnMultiWindowModeChangedListener(this.f10760r);
        }
        Object obj6 = this.f10764v;
        if (obj6 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj6).addOnPictureInPictureModeChangedListener(this.f10761s);
        }
        Object obj7 = this.f10764v;
        if ((obj7 instanceof InterfaceC0468m) && componentCallbacksC0511f == null) {
            ((InterfaceC0468m) obj7).addMenuProvider(this.f10762t);
        }
    }

    void l(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (F0(2)) {
            Log.v("FragmentManager", "attach: " + componentCallbacksC0511f);
        }
        if (componentCallbacksC0511f.f10606B) {
            componentCallbacksC0511f.f10606B = false;
            if (componentCallbacksC0511f.f10643l) {
                return;
            }
            this.f10745c.a(componentCallbacksC0511f);
            if (F0(2)) {
                Log.v("FragmentManager", "add from attach: " + componentCallbacksC0511f);
            }
            if (G0(componentCallbacksC0511f)) {
                this.f10732H = true;
            }
        }
    }

    void l1(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (F0(2)) {
            Log.v("FragmentManager", "show: " + componentCallbacksC0511f);
        }
        if (componentCallbacksC0511f.f10605A) {
            componentCallbacksC0511f.f10605A = false;
            componentCallbacksC0511f.f10618Q = !componentCallbacksC0511f.f10618Q;
        }
    }

    public G m() {
        return new C0506a(this);
    }

    public int m0() {
        ArrayList<C0506a> arrayList = this.f10746d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    boolean n() {
        boolean zG0 = false;
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.l()) {
            if (componentCallbacksC0511f != null) {
                zG0 = G0(componentCallbacksC0511f);
            }
            if (zG0) {
                return true;
            }
        }
        return false;
    }

    AbstractC0518m o0() {
        return this.f10765w;
    }

    public C0520o q0() {
        C0520o c0520o = this.f10768z;
        if (c0520o != null) {
            return c0520o;
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10766x;
        return componentCallbacksC0511f != null ? componentCallbacksC0511f.f10651t.q0() : this.f10725A;
    }

    public List<ComponentCallbacksC0511f> r0() {
        return this.f10745c.o();
    }

    public p<?> s0() {
        return this.f10764v;
    }

    E t(ComponentCallbacksC0511f componentCallbacksC0511f) {
        E eN = this.f10745c.n(componentCallbacksC0511f.f10637f);
        if (eN != null) {
            return eN;
        }
        E e6 = new E(this.f10756n, this.f10745c, componentCallbacksC0511f);
        e6.o(this.f10764v.f().getClassLoader());
        e6.t(this.f10763u);
        return e6;
    }

    LayoutInflater.Factory2 t0() {
        return this.f10748f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10766x;
        if (componentCallbacksC0511f != null) {
            sb.append(componentCallbacksC0511f.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f10766x)));
            sb.append("}");
        } else {
            p<?> pVar = this.f10764v;
            if (pVar != null) {
                sb.append(pVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f10764v)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    void u(ComponentCallbacksC0511f componentCallbacksC0511f) {
        if (F0(2)) {
            Log.v("FragmentManager", "detach: " + componentCallbacksC0511f);
        }
        if (componentCallbacksC0511f.f10606B) {
            return;
        }
        componentCallbacksC0511f.f10606B = true;
        if (componentCallbacksC0511f.f10643l) {
            if (F0(2)) {
                Log.v("FragmentManager", "remove from detach: " + componentCallbacksC0511f);
            }
            this.f10745c.u(componentCallbacksC0511f);
            if (G0(componentCallbacksC0511f)) {
                this.f10732H = true;
            }
            k1(componentCallbacksC0511f);
        }
    }

    r u0() {
        return this.f10756n;
    }

    void v() {
        this.f10733I = false;
        this.f10734J = false;
        this.f10740P.V(false);
        Q(4);
    }

    ComponentCallbacksC0511f v0() {
        return this.f10766x;
    }

    void w() {
        this.f10733I = false;
        this.f10734J = false;
        this.f10740P.V(false);
        Q(0);
    }

    public ComponentCallbacksC0511f w0() {
        return this.f10767y;
    }

    void x(Configuration configuration, boolean z5) {
        if (z5 && (this.f10764v instanceof androidx.core.content.b)) {
            n1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null) {
                componentCallbacksC0511f.Y0(configuration);
                if (z5) {
                    componentCallbacksC0511f.f10653v.x(configuration, true);
                }
            }
        }
    }

    N x0() {
        N n5 = this.f10726B;
        if (n5 != null) {
            return n5;
        }
        ComponentCallbacksC0511f componentCallbacksC0511f = this.f10766x;
        return componentCallbacksC0511f != null ? componentCallbacksC0511f.f10651t.x0() : this.f10727C;
    }

    boolean y(MenuItem menuItem) {
        if (this.f10763u < 1) {
            return false;
        }
        for (ComponentCallbacksC0511f componentCallbacksC0511f : this.f10745c.o()) {
            if (componentCallbacksC0511f != null && componentCallbacksC0511f.Z0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public c.C0081c y0() {
        return this.f10741Q;
    }

    void z() {
        this.f10733I = false;
        this.f10734J = false;
        this.f10740P.V(false);
        Q(1);
    }

    static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f10779a;

        /* renamed from: b, reason: collision with root package name */
        int f10780b;

        class a implements Parcelable.Creator<k> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i5) {
                return new k[i5];
            }
        }

        k(String str, int i5) {
            this.f10779a = str;
            this.f10780b = i5;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeString(this.f10779a);
            parcel.writeInt(this.f10780b);
        }

        k(Parcel parcel) {
            this.f10779a = parcel.readString();
            this.f10780b = parcel.readInt();
        }
    }
}
