package androidx.fragment.app;

import android.annotation.SuppressLint;
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
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.V;
import android.view.View;
import android.view.ViewGroup;
import android.view.W;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.view.InterfaceC1325m;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.K;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import b.AbstractC1417G;
import b.C1423c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import d.AbstractC3936b;
import d.AbstractC3939e;
import d.InterfaceC3935a;
import d.InterfaceC3940f;
import e.AbstractC3969a;
import g1.e;
import io.ktor.sse.ServerSentEventKt;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class FragmentManager {

    /* renamed from: U, reason: collision with root package name */
    public static boolean f13909U = false;

    /* renamed from: V, reason: collision with root package name */
    public static boolean f13910V = true;

    /* renamed from: A, reason: collision with root package name */
    public Fragment f13911A;

    /* renamed from: F, reason: collision with root package name */
    public AbstractC3936b<Intent> f13916F;

    /* renamed from: G, reason: collision with root package name */
    public AbstractC3936b<IntentSenderRequest> f13917G;

    /* renamed from: H, reason: collision with root package name */
    public AbstractC3936b<String[]> f13918H;

    /* renamed from: J, reason: collision with root package name */
    public boolean f13920J;

    /* renamed from: K, reason: collision with root package name */
    public boolean f13921K;

    /* renamed from: L, reason: collision with root package name */
    public boolean f13922L;

    /* renamed from: M, reason: collision with root package name */
    public boolean f13923M;

    /* renamed from: N, reason: collision with root package name */
    public boolean f13924N;

    /* renamed from: O, reason: collision with root package name */
    public ArrayList<C1363a> f13925O;

    /* renamed from: P, reason: collision with root package name */
    public ArrayList<Boolean> f13926P;

    /* renamed from: Q, reason: collision with root package name */
    public ArrayList<Fragment> f13927Q;

    /* renamed from: R, reason: collision with root package name */
    public G f13928R;

    /* renamed from: S, reason: collision with root package name */
    public FragmentStrictMode.b f13929S;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13932b;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f13935e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f13937g;

    /* renamed from: x, reason: collision with root package name */
    public w<?> f13954x;

    /* renamed from: y, reason: collision with root package name */
    public AbstractC1381t f13955y;

    /* renamed from: z, reason: collision with root package name */
    public Fragment f13956z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<m> f13931a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final J f13933c = new J();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<C1363a> f13934d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public final x f13936f = new x(this);

    /* renamed from: h, reason: collision with root package name */
    public C1363a f13938h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13939i = false;

    /* renamed from: j, reason: collision with root package name */
    public final AbstractC1417G f13940j = new b(false);

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f13941k = new AtomicInteger();

    /* renamed from: l, reason: collision with root package name */
    public final Map<String, BackStackState> f13942l = Collections.synchronizedMap(new HashMap());

    /* renamed from: m, reason: collision with root package name */
    public final Map<String, Bundle> f13943m = Collections.synchronizedMap(new HashMap());

    /* renamed from: n, reason: collision with root package name */
    public final Map<String, Object> f13944n = Collections.synchronizedMap(new HashMap());

    /* renamed from: o, reason: collision with root package name */
    public ArrayList<l> f13945o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public final y f13946p = new y(this);

    /* renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList<H> f13947q = new CopyOnWriteArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    public final B0.a<Configuration> f13948r = new B0.a() { // from class: androidx.fragment.app.z
        @Override // B0.a
        public final void accept(Object obj) {
            FragmentManager.f(this.f14155a, (Configuration) obj);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    public final B0.a<Integer> f13949s = new B0.a() { // from class: androidx.fragment.app.A
        @Override // B0.a
        public final void accept(Object obj) {
            FragmentManager.a(this.f13811a, (Integer) obj);
        }
    };

    /* renamed from: t, reason: collision with root package name */
    public final B0.a<androidx.core.app.g> f13950t = new B0.a() { // from class: androidx.fragment.app.B
        @Override // B0.a
        public final void accept(Object obj) {
            FragmentManager.e(this.f13812a, (androidx.core.app.g) obj);
        }
    };

    /* renamed from: u, reason: collision with root package name */
    public final B0.a<androidx.core.app.q> f13951u = new B0.a() { // from class: androidx.fragment.app.C
        @Override // B0.a
        public final void accept(Object obj) {
            FragmentManager.d(this.f13813a, (androidx.core.app.q) obj);
        }
    };

    /* renamed from: v, reason: collision with root package name */
    public final androidx.core.view.r f13952v = new c();

    /* renamed from: w, reason: collision with root package name */
    public int f13953w = -1;

    /* renamed from: B, reason: collision with root package name */
    public v f13912B = null;

    /* renamed from: C, reason: collision with root package name */
    public v f13913C = new d();

    /* renamed from: D, reason: collision with root package name */
    public T f13914D = null;

    /* renamed from: E, reason: collision with root package name */
    public T f13915E = new e();

    /* renamed from: I, reason: collision with root package name */
    public ArrayDeque<LaunchedFragmentInfo> f13919I = new ArrayDeque<>();

    /* renamed from: T, reason: collision with root package name */
    public Runnable f13930T = new f();

    public class a implements InterfaceC3935a<Map<String, Boolean>> {
        public a() {
        }

        @Override // d.InterfaceC3935a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.f13919I.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.mWho;
            int i11 = launchedFragmentInfoPollFirst.mRequestCode;
            Fragment fragmentI = FragmentManager.this.f13933c.i(str);
            if (fragmentI != null) {
                fragmentI.onRequestPermissionsResult(i11, strArr, iArr);
                return;
            }
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    public class b extends AbstractC1417G {
        public b(boolean z10) {
            super(z10);
        }

        @Override // b.AbstractC1417G
        public void handleOnBackCancelled() {
            if (FragmentManager.N0(3)) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = " + FragmentManager.f13910V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.f13910V) {
                FragmentManager.this.r();
            }
        }

        @Override // b.AbstractC1417G
        public void handleOnBackPressed() {
            if (FragmentManager.N0(3)) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = " + FragmentManager.f13910V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager.this.J0();
        }

        @Override // b.AbstractC1417G
        public void handleOnBackProgressed(C1423c c1423c) {
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = " + FragmentManager.f13910V + " fragment manager " + FragmentManager.this);
            }
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.f13938h != null) {
                Iterator<SpecialEffectsController> it = fragmentManager.x(new ArrayList<>(Collections.singletonList(FragmentManager.this.f13938h)), 0, 1).iterator();
                while (it.hasNext()) {
                    it.next().A(c1423c);
                }
                Iterator<l> it2 = FragmentManager.this.f13945o.iterator();
                while (it2.hasNext()) {
                    it2.next().a(c1423c);
                }
            }
        }

        @Override // b.AbstractC1417G
        public void handleOnBackStarted(C1423c c1423c) {
            if (FragmentManager.N0(3)) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = " + FragmentManager.f13910V + " fragment manager " + FragmentManager.this);
            }
            if (FragmentManager.f13910V) {
                FragmentManager.this.a0();
                FragmentManager.this.j1();
            }
        }
    }

    public class c implements androidx.core.view.r {
        public c() {
        }

        @Override // androidx.core.view.r
        public void a(Menu menu) {
            FragmentManager.this.N(menu);
        }

        @Override // androidx.core.view.r
        public void b(Menu menu) {
            FragmentManager.this.R(menu);
        }

        @Override // androidx.core.view.r
        public boolean c(MenuItem menuItem) {
            return FragmentManager.this.M(menuItem);
        }

        @Override // androidx.core.view.r
        public void d(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.F(menu, menuInflater);
        }
    }

    public class d extends v {
        public d() {
        }

        @Override // androidx.fragment.app.v
        public Fragment a(ClassLoader classLoader, String str) {
            return FragmentManager.this.A0().b(FragmentManager.this.A0().getContext(), str, null);
        }
    }

    public class e implements T {
        public e() {
        }

        @Override // androidx.fragment.app.T
        public SpecialEffectsController a(ViewGroup viewGroup) {
            return new DefaultSpecialEffectsController(viewGroup);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.d0(true);
        }
    }

    public class g implements H {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f13963a;

        public g(Fragment fragment) {
            this.f13963a = fragment;
        }

        @Override // androidx.fragment.app.H
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f13963a.onAttachFragment(fragment);
        }
    }

    public class h implements InterfaceC3935a<ActivityResult> {
        public h() {
        }

        @Override // d.InterfaceC3935a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollLast = FragmentManager.this.f13919I.pollLast();
            if (launchedFragmentInfoPollLast == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollLast.mWho;
            int i10 = launchedFragmentInfoPollLast.mRequestCode;
            Fragment fragmentI = FragmentManager.this.f13933c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i10, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public class i implements InterfaceC3935a<ActivityResult> {
        public i() {
        }

        @Override // d.InterfaceC3935a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.f13919I.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.mWho;
            int i10 = launchedFragmentInfoPollFirst.mRequestCode;
            Fragment fragmentI = FragmentManager.this.f13933c.i(str);
            if (fragmentI != null) {
                fragmentI.onActivityResult(i10, activityResult.getResultCode(), activityResult.getData());
                return;
            }
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
        }
    }

    public static class j extends AbstractC3969a<IntentSenderRequest, ActivityResult> {
        @Override // e.AbstractC3969a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.getIntentSender()).b(null).c(intentSenderRequest.getFlagsValues(), intentSenderRequest.getFlagsMask()).a();
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
            if (FragmentManager.N0(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // e.AbstractC3969a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static abstract class k {
        @Deprecated
        public void a(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void b(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void c(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void d(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void e(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void f(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void g(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void h(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void i(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void j(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void k(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void l(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void n(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    public interface l {
        default void a(C1423c c1423c) {
        }

        default void b(Fragment fragment, boolean z10) {
        }

        default void c(Fragment fragment, boolean z10) {
        }

        default void d() {
        }

        void onBackStackChanged();
    }

    public interface m {
        boolean a(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class n implements m {

        /* renamed from: a, reason: collision with root package name */
        public final String f13967a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13968b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13969c;

        public n(String str, int i10, int i11) {
            this.f13967a = str;
            this.f13968b = i10;
            this.f13969c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f13911A;
            if (fragment == null || this.f13968b >= 0 || this.f13967a != null || !fragment.getChildFragmentManager().d1()) {
                return FragmentManager.this.h1(arrayList, arrayList2, this.f13967a, this.f13968b, this.f13969c);
            }
            return false;
        }
    }

    public class o implements m {
        public o() {
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2) {
            boolean zI1 = FragmentManager.this.i1(arrayList, arrayList2);
            if (!FragmentManager.this.f13945o.isEmpty() && arrayList.size() > 0) {
                boolean zBooleanValue = arrayList2.get(arrayList.size() - 1).booleanValue();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Iterator<C1363a> it = arrayList.iterator();
                while (it.hasNext()) {
                    linkedHashSet.addAll(FragmentManager.this.q0(it.next()));
                }
                Iterator<l> it2 = FragmentManager.this.f13945o.iterator();
                while (it2.hasNext()) {
                    l next = it2.next();
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        next.c((Fragment) it3.next(), zBooleanValue);
                    }
                }
            }
            return zI1;
        }
    }

    public static Fragment H0(View view) {
        Object tag = view.getTag(R$id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    public static boolean N0(int i10) {
        return f13909U || Log.isLoggable("FragmentManager", i10);
    }

    public static /* synthetic */ void a(FragmentManager fragmentManager, Integer num) {
        if (fragmentManager.P0() && num.intValue() == 80) {
            fragmentManager.I(false);
        }
    }

    public static /* synthetic */ void c(FragmentManager fragmentManager) {
        Iterator<l> it = fragmentManager.f13945o.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public static /* synthetic */ void d(FragmentManager fragmentManager, androidx.core.app.q qVar) {
        if (fragmentManager.P0()) {
            fragmentManager.Q(qVar.getIsInPictureInPictureMode(), false);
        }
    }

    public static /* synthetic */ void e(FragmentManager fragmentManager, androidx.core.app.g gVar) {
        if (fragmentManager.P0()) {
            fragmentManager.J(gVar.getIsInMultiWindowMode(), false);
        }
    }

    public static /* synthetic */ void f(FragmentManager fragmentManager, Configuration configuration) {
        if (fragmentManager.P0()) {
            fragmentManager.C(configuration, false);
        }
    }

    public static void f0(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            C1363a c1363a = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                c1363a.w(-1);
                c1363a.C();
            } else {
                c1363a.w(1);
                c1363a.B();
            }
            i10++;
        }
    }

    public static FragmentManager n0(View view) {
        r rVar;
        Fragment fragmentO0 = o0(view);
        if (fragmentO0 != null) {
            if (fragmentO0.isAdded()) {
                return fragmentO0.getChildFragmentManager();
            }
            throw new IllegalStateException("The Fragment " + fragmentO0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                rVar = null;
                break;
            }
            if (context instanceof r) {
                rVar = (r) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (rVar != null) {
            return rVar.getSupportFragmentManager();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    public static Fragment o0(View view) {
        while (view != null) {
            Fragment fragmentH0 = H0(view);
            if (fragmentH0 != null) {
                return fragmentH0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static int r1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    public void A() {
        this.f13921K = false;
        this.f13922L = false;
        this.f13928R.p(false);
        V(4);
    }

    public w<?> A0() {
        return this.f13954x;
    }

    public final void A1() {
        Iterator<I> it = this.f13933c.k().iterator();
        while (it.hasNext()) {
            b1(it.next());
        }
    }

    public void B() {
        this.f13921K = false;
        this.f13922L = false;
        this.f13928R.p(false);
        V(0);
    }

    public LayoutInflater.Factory2 B0() {
        return this.f13936f;
    }

    public final void B1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new P("FragmentManager"));
        w<?> wVar = this.f13954x;
        if (wVar != null) {
            try {
                wVar.i("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw runtimeException;
            }
        }
        try {
            Z("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw runtimeException;
        }
    }

    public void C(Configuration configuration, boolean z10) {
        if (z10 && (this.f13954x instanceof androidx.core.content.c)) {
            B1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z10) {
                    fragment.mChildFragmentManager.C(configuration, true);
                }
            }
        }
    }

    public y C0() {
        return this.f13946p;
    }

    public void C1(k kVar) {
        this.f13946p.p(kVar);
    }

    public boolean D(MenuItem menuItem) {
        if (this.f13953w < 1) {
            return false;
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public Fragment D0() {
        return this.f13956z;
    }

    public final void D1() {
        synchronized (this.f13931a) {
            try {
                if (!this.f13931a.isEmpty()) {
                    this.f13940j.setEnabled(true);
                    if (N0(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                boolean z10 = s0() > 0 && S0(this.f13956z);
                if (N0(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z10);
                }
                this.f13940j.setEnabled(z10);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void E() {
        this.f13921K = false;
        this.f13922L = false;
        this.f13928R.p(false);
        V(1);
    }

    public Fragment E0() {
        return this.f13911A;
    }

    public boolean F(Menu menu, MenuInflater menuInflater) {
        if (this.f13953w < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null && R0(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f13935e != null) {
            for (int i10 = 0; i10 < this.f13935e.size(); i10++) {
                Fragment fragment2 = this.f13935e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f13935e = arrayList;
        return z10;
    }

    public T F0() {
        T t10 = this.f13914D;
        if (t10 != null) {
            return t10;
        }
        Fragment fragment = this.f13956z;
        return fragment != null ? fragment.mFragmentManager.F0() : this.f13915E;
    }

    public void G() {
        this.f13923M = true;
        d0(true);
        a0();
        v();
        V(-1);
        Object obj = this.f13954x;
        if (obj instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj).removeOnTrimMemoryListener(this.f13949s);
        }
        Object obj2 = this.f13954x;
        if (obj2 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj2).removeOnConfigurationChangedListener(this.f13948r);
        }
        Object obj3 = this.f13954x;
        if (obj3 instanceof androidx.core.app.n) {
            ((androidx.core.app.n) obj3).removeOnMultiWindowModeChangedListener(this.f13950t);
        }
        Object obj4 = this.f13954x;
        if (obj4 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj4).removeOnPictureInPictureModeChangedListener(this.f13951u);
        }
        Object obj5 = this.f13954x;
        if ((obj5 instanceof InterfaceC1325m) && this.f13956z == null) {
            ((InterfaceC1325m) obj5).removeMenuProvider(this.f13952v);
        }
        this.f13954x = null;
        this.f13955y = null;
        this.f13956z = null;
        if (this.f13937g != null) {
            this.f13940j.remove();
            this.f13937g = null;
        }
        AbstractC3936b<Intent> abstractC3936b = this.f13916F;
        if (abstractC3936b != null) {
            abstractC3936b.c();
            this.f13917G.c();
            this.f13918H.c();
        }
    }

    public FragmentStrictMode.b G0() {
        return this.f13929S;
    }

    public void H() {
        V(1);
    }

    public void I(boolean z10) {
        if (z10 && (this.f13954x instanceof androidx.core.content.d)) {
            B1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z10) {
                    fragment.mChildFragmentManager.I(true);
                }
            }
        }
    }

    public V I0(Fragment fragment) {
        return this.f13928R.m(fragment);
    }

    public void J(boolean z10, boolean z11) {
        if (z11 && (this.f13954x instanceof androidx.core.app.n)) {
            B1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z10);
                if (z11) {
                    fragment.mChildFragmentManager.J(z10, true);
                }
            }
        }
    }

    public void J0() {
        this.f13939i = true;
        d0(true);
        this.f13939i = false;
        if (!f13910V || this.f13938h == null) {
            if (this.f13940j.getIsEnabled()) {
                if (N0(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                d1();
                return;
            } else {
                if (N0(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                this.f13937g.q();
                return;
            }
        }
        if (!this.f13945o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(q0(this.f13938h));
            Iterator<l> it = this.f13945o.iterator();
            while (it.hasNext()) {
                l next = it.next();
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    next.b((Fragment) it2.next(), true);
                }
            }
        }
        Iterator<K.a> it3 = this.f13938h.f13995c.iterator();
        while (it3.hasNext()) {
            Fragment fragment = it3.next().f14013b;
            if (fragment != null) {
                fragment.mTransitioning = false;
            }
        }
        Iterator<SpecialEffectsController> it4 = x(new ArrayList<>(Collections.singletonList(this.f13938h)), 0, 1).iterator();
        while (it4.hasNext()) {
            it4.next().f();
        }
        Iterator<K.a> it5 = this.f13938h.f13995c.iterator();
        while (it5.hasNext()) {
            Fragment fragment2 = it5.next().f14013b;
            if (fragment2 != null && fragment2.mContainer == null) {
                y(fragment2).m();
            }
        }
        this.f13938h = null;
        D1();
        if (N0(3)) {
            Log.d("FragmentManager", "Op is being set to null");
            Log.d("FragmentManager", "OnBackPressedCallback enabled=" + this.f13940j.getIsEnabled() + " for  FragmentManager " + this);
        }
    }

    public void K(Fragment fragment) {
        Iterator<H> it = this.f13947q.iterator();
        while (it.hasNext()) {
            it.next().a(this, fragment);
        }
    }

    public void K0(Fragment fragment) {
        if (N0(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        y1(fragment);
    }

    public void L() {
        for (Fragment fragment : this.f13933c.l()) {
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.L();
            }
        }
    }

    public void L0(Fragment fragment) {
        if (fragment.mAdded && O0(fragment)) {
            this.f13920J = true;
        }
    }

    public boolean M(MenuItem menuItem) {
        if (this.f13953w < 1) {
            return false;
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean M0() {
        return this.f13923M;
    }

    public void N(Menu menu) {
        if (this.f13953w < 1) {
            return;
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void O(Fragment fragment) {
        if (fragment == null || !fragment.equals(i0(fragment.mWho))) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    public final boolean O0(Fragment fragment) {
        return (fragment.mHasMenu && fragment.mMenuVisible) || fragment.mChildFragmentManager.s();
    }

    public void P() {
        V(5);
    }

    public final boolean P0() {
        Fragment fragment = this.f13956z;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f13956z.getParentFragmentManager().P0();
    }

    public void Q(boolean z10, boolean z11) {
        if (z11 && (this.f13954x instanceof androidx.core.app.o)) {
            B1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z10);
                if (z11) {
                    fragment.mChildFragmentManager.Q(z10, true);
                }
            }
        }
    }

    public boolean Q0(Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.isHidden();
    }

    public boolean R(Menu menu) {
        boolean z10 = false;
        if (this.f13953w < 1) {
            return false;
        }
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null && R0(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public boolean R0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public void S() {
        D1();
        O(this.f13911A);
    }

    public boolean S0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.E0()) && S0(fragmentManager.f13956z);
    }

    public void T() {
        this.f13921K = false;
        this.f13922L = false;
        this.f13928R.p(false);
        V(7);
    }

    public boolean T0(int i10) {
        return this.f13953w >= i10;
    }

    public void U() {
        this.f13921K = false;
        this.f13922L = false;
        this.f13928R.p(false);
        V(5);
    }

    public boolean U0() {
        return this.f13921K || this.f13922L;
    }

    public final void V(int i10) {
        try {
            this.f13932b = true;
            this.f13933c.d(i10);
            Y0(i10, false);
            Iterator<SpecialEffectsController> it = w().iterator();
            while (it.hasNext()) {
                it.next().q();
            }
            this.f13932b = false;
            d0(true);
        } catch (Throwable th) {
            this.f13932b = false;
            throw th;
        }
    }

    public void V0(Fragment fragment, String[] strArr, int i10) {
        if (this.f13918H == null) {
            this.f13954x.l(fragment, strArr, i10);
            return;
        }
        this.f13919I.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
        this.f13918H.a(strArr);
    }

    public void W() {
        this.f13922L = true;
        this.f13928R.p(true);
        V(4);
    }

    public void W0(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        if (this.f13916F == null) {
            this.f13954x.n(fragment, intent, i10, bundle);
            return;
        }
        this.f13919I.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
        if (bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        this.f13916F.a(intent);
    }

    public void X() {
        V(2);
    }

    public void X0(Fragment fragment, IntentSender intentSender, int i10, Intent intent, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.f13917G == null) {
            this.f13954x.o(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (N0(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + fragment);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.a(intentSender).b(intent).c(i12, i11).a();
        this.f13919I.addLast(new LaunchedFragmentInfo(fragment.mWho, i10));
        if (N0(2)) {
            Log.v("FragmentManager", "Fragment " + fragment + "is launching an IntentSender for result ");
        }
        this.f13917G.a(intentSenderRequestA);
    }

    public final void Y() {
        if (this.f13924N) {
            this.f13924N = false;
            A1();
        }
    }

    public void Y0(int i10, boolean z10) {
        w<?> wVar;
        if (this.f13954x == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f13953w) {
            this.f13953w = i10;
            this.f13933c.t();
            A1();
            if (this.f13920J && (wVar = this.f13954x) != null && this.f13953w == 7) {
                wVar.p();
                this.f13920J = false;
            }
        }
    }

    public void Z(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String str2 = str + "    ";
        this.f13933c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f13935e;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size; i10++) {
                Fragment fragment = this.f13935e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        int size2 = this.f13934d.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size2; i11++) {
                C1363a c1363a = this.f13934d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(c1363a.toString());
                c1363a.z(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f13941k.get());
        synchronized (this.f13931a) {
            try {
                int size3 = this.f13931a.size();
                if (size3 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size3; i12++) {
                        m mVar = this.f13931a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
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
        printWriter.println(this.f13954x);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f13955y);
        if (this.f13956z != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f13956z);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f13953w);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f13921K);
        printWriter.print(" mStopped=");
        printWriter.print(this.f13922L);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f13923M);
        if (this.f13920J) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f13920J);
        }
    }

    public void Z0() {
        if (this.f13954x == null) {
            return;
        }
        this.f13921K = false;
        this.f13922L = false;
        this.f13928R.p(false);
        for (Fragment fragment : this.f13933c.o()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void a0() {
        Iterator<SpecialEffectsController> it = w().iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    public final void a1(FragmentContainerView fragmentContainerView) {
        View view;
        for (I i10 : this.f13933c.k()) {
            Fragment fragmentK = i10.k();
            if (fragmentK.mContainerId == fragmentContainerView.getId() && (view = fragmentK.mView) != null && view.getParent() == null) {
                fragmentK.mContainer = fragmentContainerView;
                i10.b();
                i10.m();
            }
        }
    }

    public void b0(m mVar, boolean z10) {
        if (!z10) {
            if (this.f13954x == null) {
                if (!this.f13923M) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            t();
        }
        synchronized (this.f13931a) {
            try {
                if (this.f13954x == null) {
                    if (!z10) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f13931a.add(mVar);
                    u1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b1(I i10) {
        Fragment fragmentK = i10.k();
        if (fragmentK.mDeferStart) {
            if (this.f13932b) {
                this.f13924N = true;
            } else {
                fragmentK.mDeferStart = false;
                i10.m();
            }
        }
    }

    public final void c0(boolean z10) {
        if (this.f13932b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f13954x == null) {
            if (!this.f13923M) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f13954x.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            t();
        }
        if (this.f13925O == null) {
            this.f13925O = new ArrayList<>();
            this.f13926P = new ArrayList<>();
        }
    }

    public void c1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            b0(new n(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public boolean d0(boolean z10) {
        C1363a c1363a;
        c0(z10);
        boolean z11 = false;
        if (!this.f13939i && (c1363a = this.f13938h) != null) {
            c1363a.f14084u = false;
            c1363a.x();
            if (N0(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.f13938h + " as part of execPendingActions for actions " + this.f13931a);
            }
            this.f13938h.y(false, false);
            this.f13931a.add(0, this.f13938h);
            Iterator<K.a> it = this.f13938h.f13995c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f14013b;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            this.f13938h = null;
        }
        while (r0(this.f13925O, this.f13926P)) {
            z11 = true;
            this.f13932b = true;
            try {
                n1(this.f13925O, this.f13926P);
            } finally {
                u();
            }
        }
        D1();
        Y();
        this.f13933c.b();
        return z11;
    }

    public boolean d1() {
        return g1(null, -1, 0);
    }

    public void e0(m mVar, boolean z10) {
        if (z10 && (this.f13954x == null || this.f13923M)) {
            return;
        }
        c0(z10);
        C1363a c1363a = this.f13938h;
        boolean z11 = false;
        if (c1363a != null) {
            c1363a.f14084u = false;
            c1363a.x();
            if (N0(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.f13938h + " as part of execSingleAction for action " + mVar);
            }
            this.f13938h.y(false, false);
            boolean zA = this.f13938h.a(this.f13925O, this.f13926P);
            Iterator<K.a> it = this.f13938h.f13995c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f14013b;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            this.f13938h = null;
            z11 = zA;
        }
        boolean zA2 = mVar.a(this.f13925O, this.f13926P);
        if (z11 || zA2) {
            this.f13932b = true;
            try {
                n1(this.f13925O, this.f13926P);
            } finally {
                u();
            }
        }
        D1();
        Y();
        this.f13933c.b();
    }

    public boolean e1(int i10, int i11) {
        if (i10 >= 0) {
            return g1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public boolean f1(String str, int i10) {
        return g1(str, -1, i10);
    }

    public final void g0(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f14010r;
        ArrayList<Fragment> arrayList3 = this.f13927Q;
        if (arrayList3 == null) {
            this.f13927Q = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f13927Q.addAll(this.f13933c.o());
        Fragment fragmentE0 = E0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            C1363a c1363a = arrayList.get(i12);
            fragmentE0 = !arrayList2.get(i12).booleanValue() ? c1363a.D(this.f13927Q, fragmentE0) : c1363a.G(this.f13927Q, fragmentE0);
            z11 = z11 || c1363a.f14001i;
        }
        this.f13927Q.clear();
        if (!z10 && this.f13953w >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<K.a> it = arrayList.get(i13).f13995c.iterator();
                while (it.hasNext()) {
                    Fragment fragment = it.next().f14013b;
                    if (fragment != null && fragment.mFragmentManager != null) {
                        this.f13933c.r(y(fragment));
                    }
                }
            }
        }
        f0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = arrayList2.get(i11 - 1).booleanValue();
        if (z11 && !this.f13945o.isEmpty()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<C1363a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashSet.addAll(q0(it2.next()));
            }
            if (this.f13938h == null) {
                Iterator<l> it3 = this.f13945o.iterator();
                while (it3.hasNext()) {
                    l next = it3.next();
                    Iterator it4 = linkedHashSet.iterator();
                    while (it4.hasNext()) {
                        next.c((Fragment) it4.next(), zBooleanValue);
                    }
                }
                Iterator<l> it5 = this.f13945o.iterator();
                while (it5.hasNext()) {
                    l next2 = it5.next();
                    Iterator it6 = linkedHashSet.iterator();
                    while (it6.hasNext()) {
                        next2.b((Fragment) it6.next(), zBooleanValue);
                    }
                }
            }
        }
        for (int i14 = i10; i14 < i11; i14++) {
            C1363a c1363a2 = arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = c1363a2.f13995c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = c1363a2.f13995c.get(size).f14013b;
                    if (fragment2 != null) {
                        y(fragment2).m();
                    }
                }
            } else {
                Iterator<K.a> it7 = c1363a2.f13995c.iterator();
                while (it7.hasNext()) {
                    Fragment fragment3 = it7.next().f14013b;
                    if (fragment3 != null) {
                        y(fragment3).m();
                    }
                }
            }
        }
        Y0(this.f13953w, true);
        for (SpecialEffectsController specialEffectsController : x(arrayList, i10, i11)) {
            specialEffectsController.D(zBooleanValue);
            specialEffectsController.z();
            specialEffectsController.n();
        }
        while (i10 < i11) {
            C1363a c1363a3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && c1363a3.f14085v >= 0) {
                c1363a3.f14085v = -1;
            }
            c1363a3.F();
            i10++;
        }
        if (z11) {
            p1();
        }
    }

    public final boolean g1(String str, int i10, int i11) {
        d0(false);
        c0(true);
        Fragment fragment = this.f13911A;
        if (fragment != null && i10 < 0 && str == null && fragment.getChildFragmentManager().d1()) {
            return true;
        }
        boolean zH1 = h1(this.f13925O, this.f13926P, str, i10, i11);
        if (zH1) {
            this.f13932b = true;
            try {
                n1(this.f13925O, this.f13926P);
            } finally {
                u();
            }
        }
        D1();
        Y();
        this.f13933c.b();
        return zH1;
    }

    public boolean h0() {
        boolean zD0 = d0(true);
        p0();
        return zD0;
    }

    public boolean h1(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2, String str, int i10, int i11) {
        int iJ0 = j0(str, i10, (i11 & 1) != 0);
        if (iJ0 < 0) {
            return false;
        }
        for (int size = this.f13934d.size() - 1; size >= iJ0; size--) {
            arrayList.add(this.f13934d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public void i(C1363a c1363a) {
        this.f13934d.add(c1363a);
    }

    public Fragment i0(String str) {
        return this.f13933c.f(str);
    }

    public boolean i1(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2) {
        if (N0(2)) {
            Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + this.f13931a);
        }
        if (this.f13934d.isEmpty()) {
            Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
            return false;
        }
        ArrayList<C1363a> arrayList3 = this.f13934d;
        C1363a c1363a = arrayList3.get(arrayList3.size() - 1);
        this.f13938h = c1363a;
        Iterator<K.a> it = c1363a.f13995c.iterator();
        while (it.hasNext()) {
            Fragment fragment = it.next().f14013b;
            if (fragment != null) {
                fragment.mTransitioning = true;
            }
        }
        return h1(arrayList, arrayList2, null, -1, 0);
    }

    public I j(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.f(fragment, str);
        }
        if (N0(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        I iY = y(fragment);
        fragment.mFragmentManager = this;
        this.f13933c.r(iY);
        if (!fragment.mDetached) {
            this.f13933c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (O0(fragment)) {
                this.f13920J = true;
            }
        }
        return iY;
    }

    public final int j0(String str, int i10, boolean z10) {
        if (this.f13934d.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f13934d.size() - 1;
        }
        int size = this.f13934d.size() - 1;
        while (size >= 0) {
            C1363a c1363a = this.f13934d.get(size);
            if ((str != null && str.equals(c1363a.E())) || (i10 >= 0 && i10 == c1363a.f14085v)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f13934d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            C1363a c1363a2 = this.f13934d.get(size - 1);
            if ((str == null || !str.equals(c1363a2.E())) && (i10 < 0 || i10 != c1363a2.f14085v)) {
                break;
            }
            size--;
        }
        return size;
    }

    public void j1() {
        b0(new o(), false);
    }

    public void k(H h10) {
        this.f13947q.add(h10);
    }

    public Fragment k0(int i10) {
        return this.f13933c.g(i10);
    }

    public void k1(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager != this) {
            B1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.mWho);
    }

    public void l(l lVar) {
        this.f13945o.add(lVar);
    }

    public Fragment l0(String str) {
        return this.f13933c.h(str);
    }

    public void l1(k kVar, boolean z10) {
        this.f13946p.o(kVar, z10);
    }

    public void m(Fragment fragment) {
        this.f13928R.e(fragment);
    }

    public Fragment m0(String str) {
        return this.f13933c.i(str);
    }

    public void m1(Fragment fragment) {
        if (N0(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        this.f13933c.u(fragment);
        if (O0(fragment)) {
            this.f13920J = true;
        }
        fragment.mRemoving = true;
        y1(fragment);
    }

    public int n() {
        return this.f13941k.getAndIncrement();
    }

    public final void n1(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!arrayList.get(i10).f14010r) {
                if (i11 != i10) {
                    g0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f14010r) {
                        i11++;
                    }
                }
                g0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            g0(arrayList, arrayList2, i11, size);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o(w<?> wVar, AbstractC1381t abstractC1381t, Fragment fragment) {
        String str;
        if (this.f13954x != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f13954x = wVar;
        this.f13955y = abstractC1381t;
        this.f13956z = fragment;
        if (fragment != null) {
            k(new g(fragment));
        } else if (wVar instanceof H) {
            k((H) wVar);
        }
        if (this.f13956z != null) {
            D1();
        }
        if (wVar instanceof b.L) {
            b.L l10 = (b.L) wVar;
            OnBackPressedDispatcher onBackPressedDispatcher = l10.getOnBackPressedDispatcher();
            this.f13937g = onBackPressedDispatcher;
            LifecycleOwner lifecycleOwner = l10;
            if (fragment != null) {
                lifecycleOwner = fragment;
            }
            onBackPressedDispatcher.m(lifecycleOwner, this.f13940j);
        }
        if (fragment != null) {
            this.f13928R = fragment.mFragmentManager.t0(fragment);
        } else if (wVar instanceof W) {
            this.f13928R = G.k(((W) wVar).getViewModelStore());
        } else {
            this.f13928R = new G(false);
        }
        this.f13928R.p(U0());
        this.f13933c.A(this.f13928R);
        Object obj = this.f13954x;
        if ((obj instanceof g1.h) && fragment == null) {
            g1.e savedStateRegistry = ((g1.h) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new e.b() { // from class: androidx.fragment.app.D
                @Override // g1.e.b
                public final Bundle a() {
                    return this.f13814a.s1();
                }
            });
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                q1(bundleA);
            }
        }
        Object obj2 = this.f13954x;
        if (obj2 instanceof InterfaceC3940f) {
            AbstractC3939e activityResultRegistry = ((InterfaceC3940f) obj2).getActivityResultRegistry();
            if (fragment != null) {
                str = fragment.mWho + ServerSentEventKt.COLON;
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.f13916F = activityResultRegistry.o(str2 + "StartActivityForResult", new e.e(), new h());
            this.f13917G = activityResultRegistry.o(str2 + "StartIntentSenderForResult", new j(), new i());
            this.f13918H = activityResultRegistry.o(str2 + "RequestPermissions", new e.c(), new a());
        }
        Object obj3 = this.f13954x;
        if (obj3 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj3).addOnConfigurationChangedListener(this.f13948r);
        }
        Object obj4 = this.f13954x;
        if (obj4 instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj4).addOnTrimMemoryListener(this.f13949s);
        }
        Object obj5 = this.f13954x;
        if (obj5 instanceof androidx.core.app.n) {
            ((androidx.core.app.n) obj5).addOnMultiWindowModeChangedListener(this.f13950t);
        }
        Object obj6 = this.f13954x;
        if (obj6 instanceof androidx.core.app.o) {
            ((androidx.core.app.o) obj6).addOnPictureInPictureModeChangedListener(this.f13951u);
        }
        Object obj7 = this.f13954x;
        if ((obj7 instanceof InterfaceC1325m) && fragment == null) {
            ((InterfaceC1325m) obj7).addMenuProvider(this.f13952v);
        }
    }

    public void o1(Fragment fragment) {
        this.f13928R.o(fragment);
    }

    public void p(Fragment fragment) {
        if (N0(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f13933c.a(fragment);
            if (N0(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (O0(fragment)) {
                this.f13920J = true;
            }
        }
    }

    public final void p0() {
        Iterator<SpecialEffectsController> it = w().iterator();
        while (it.hasNext()) {
            it.next().r();
        }
    }

    public final void p1() {
        for (int i10 = 0; i10 < this.f13945o.size(); i10++) {
            this.f13945o.get(i10).onBackStackChanged();
        }
    }

    public K q() {
        return new C1363a(this);
    }

    public Set<Fragment> q0(C1363a c1363a) {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < c1363a.f13995c.size(); i10++) {
            Fragment fragment = c1363a.f13995c.get(i10).f14013b;
            if (fragment != null && c1363a.f14001i) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public void q1(Parcelable parcelable) {
        I i10;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f13954x.getContext().getClassLoader());
                this.f13943m.put(str.substring(7), bundle2);
            }
        }
        HashMap<String, Bundle> map = new HashMap<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f13954x.getContext().getClassLoader());
                map.put(str2.substring(9), bundle);
            }
        }
        this.f13933c.x(map);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable(VoiceWakeupReceiver.EXTRA_STATE);
        if (fragmentManagerState == null) {
            return;
        }
        this.f13933c.v();
        Iterator<String> it = fragmentManagerState.mActive.iterator();
        while (it.hasNext()) {
            Bundle bundleB = this.f13933c.B(it.next(), null);
            if (bundleB != null) {
                Fragment fragmentI = this.f13928R.i(((FragmentState) bundleB.getParcelable(VoiceWakeupReceiver.EXTRA_STATE)).mWho);
                if (fragmentI != null) {
                    if (N0(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentI);
                    }
                    i10 = new I(this.f13946p, this.f13933c, fragmentI, bundleB);
                } else {
                    i10 = new I(this.f13946p, this.f13933c, this.f13954x.getContext().getClassLoader(), x0(), bundleB);
                }
                Fragment fragmentK = i10.k();
                fragmentK.mSavedFragmentState = bundleB;
                fragmentK.mFragmentManager = this;
                if (N0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragmentK.mWho + "): " + fragmentK);
                }
                i10.o(this.f13954x.getContext().getClassLoader());
                this.f13933c.r(i10);
                i10.t(this.f13953w);
            }
        }
        for (Fragment fragment : this.f13928R.l()) {
            if (!this.f13933c.c(fragment.mWho)) {
                if (N0(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                this.f13928R.o(fragment);
                fragment.mFragmentManager = this;
                I i11 = new I(this.f13946p, this.f13933c, fragment);
                i11.t(1);
                i11.m();
                fragment.mRemoving = true;
                i11.m();
            }
        }
        this.f13933c.w(fragmentManagerState.mAdded);
        if (fragmentManagerState.mBackStack != null) {
            this.f13934d = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int i12 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                if (i12 >= backStackRecordStateArr.length) {
                    break;
                }
                C1363a c1363aInstantiate = backStackRecordStateArr[i12].instantiate(this);
                if (N0(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i12 + " (index " + c1363aInstantiate.f14085v + "): " + c1363aInstantiate);
                    PrintWriter printWriter = new PrintWriter(new P("FragmentManager"));
                    c1363aInstantiate.A("  ", printWriter, false);
                    printWriter.close();
                }
                this.f13934d.add(c1363aInstantiate);
                i12++;
            }
        } else {
            this.f13934d = new ArrayList<>();
        }
        this.f13941k.set(fragmentManagerState.mBackStackIndex);
        String str3 = fragmentManagerState.mPrimaryNavActiveWho;
        if (str3 != null) {
            Fragment fragmentI0 = i0(str3);
            this.f13911A = fragmentI0;
            O(fragmentI0);
        }
        ArrayList<String> arrayList = fragmentManagerState.mBackStackStateKeys;
        if (arrayList != null) {
            for (int i13 = 0; i13 < arrayList.size(); i13++) {
                this.f13942l.put(arrayList.get(i13), fragmentManagerState.mBackStackStates.get(i13));
            }
        }
        this.f13919I = new ArrayDeque<>(fragmentManagerState.mLaunchedFragments);
    }

    public void r() {
        if (N0(3)) {
            Log.d("FragmentManager", "cancelBackStackTransition for transition " + this.f13938h);
        }
        C1363a c1363a = this.f13938h;
        if (c1363a != null) {
            c1363a.f14084u = false;
            c1363a.x();
            this.f13938h.r(true, new Runnable() { // from class: androidx.fragment.app.E
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentManager.c(this.f13863a);
                }
            });
            this.f13938h.g();
            this.f13939i = true;
            h0();
            this.f13939i = false;
            this.f13938h = null;
        }
    }

    public final boolean r0(ArrayList<C1363a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this.f13931a) {
            if (this.f13931a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f13931a.size();
                boolean zA = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zA |= this.f13931a.get(i10).a(arrayList, arrayList2);
                }
                return zA;
            } finally {
                this.f13931a.clear();
                this.f13954x.getHandler().removeCallbacks(this.f13930T);
            }
        }
    }

    public boolean s() {
        boolean zO0 = false;
        for (Fragment fragment : this.f13933c.l()) {
            if (fragment != null) {
                zO0 = O0(fragment);
            }
            if (zO0) {
                return true;
            }
        }
        return false;
    }

    public int s0() {
        return this.f13934d.size() + (this.f13938h != null ? 1 : 0);
    }

    public Bundle s1() {
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        p0();
        a0();
        d0(true);
        this.f13921K = true;
        this.f13928R.p(true);
        ArrayList<String> arrayListY = this.f13933c.y();
        HashMap<String, Bundle> mapM = this.f13933c.m();
        if (!mapM.isEmpty()) {
            ArrayList<String> arrayListZ = this.f13933c.z();
            int size = this.f13934d.size();
            if (size > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState(this.f13934d.get(i10));
                    if (N0(2)) {
                        Log.v("FragmentManager", "saveAllState: adding back stack #" + i10 + ": " + this.f13934d.get(i10));
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = arrayListY;
            fragmentManagerState.mAdded = arrayListZ;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.f13941k.get();
            Fragment fragment = this.f13911A;
            if (fragment != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment.mWho;
            }
            fragmentManagerState.mBackStackStateKeys.addAll(this.f13942l.keySet());
            fragmentManagerState.mBackStackStates.addAll(this.f13942l.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList<>(this.f13919I);
            bundle.putParcelable(VoiceWakeupReceiver.EXTRA_STATE, fragmentManagerState);
            for (String str : this.f13943m.keySet()) {
                bundle.putBundle("result_" + str, this.f13943m.get(str));
            }
            for (String str2 : mapM.keySet()) {
                bundle.putBundle("fragment_" + str2, mapM.get(str2));
            }
        } else if (N0(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void t() {
        if (U0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final G t0(Fragment fragment) {
        return this.f13928R.j(fragment);
    }

    public Fragment.SavedState t1(Fragment fragment) {
        I iN = this.f13933c.n(fragment.mWho);
        if (iN == null || !iN.k().equals(fragment)) {
            B1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return iN.q();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f13956z;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append(Const.STR_MART_JSON_BEGIN);
            sb2.append(Integer.toHexString(System.identityHashCode(this.f13956z)));
            sb2.append("}");
        } else {
            w<?> wVar = this.f13954x;
            if (wVar != null) {
                sb2.append(wVar.getClass().getSimpleName());
                sb2.append(Const.STR_MART_JSON_BEGIN);
                sb2.append(Integer.toHexString(System.identityHashCode(this.f13954x)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u() {
        this.f13932b = false;
        this.f13926P.clear();
        this.f13925O.clear();
    }

    public AbstractC1381t u0() {
        return this.f13955y;
    }

    public void u1() {
        synchronized (this.f13931a) {
            try {
                if (this.f13931a.size() == 1) {
                    this.f13954x.getHandler().removeCallbacks(this.f13930T);
                    this.f13954x.getHandler().post(this.f13930T);
                    D1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v() {
        w<?> wVar = this.f13954x;
        if (wVar instanceof W ? this.f13933c.p().n() : wVar.getContext() instanceof Activity ? !((Activity) this.f13954x.getContext()).isChangingConfigurations() : true) {
            Iterator<BackStackState> it = this.f13942l.values().iterator();
            while (it.hasNext()) {
                Iterator<String> it2 = it.next().mFragments.iterator();
                while (it2.hasNext()) {
                    this.f13933c.p().g(it2.next(), false);
                }
            }
        }
    }

    public Fragment v0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentI0 = i0(string);
        if (fragmentI0 == null) {
            B1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentI0;
    }

    public void v1(Fragment fragment, boolean z10) {
        ViewGroup viewGroupW0 = w0(fragment);
        if (viewGroupW0 == null || !(viewGroupW0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupW0).setDrawDisappearingViewsLast(!z10);
    }

    public final Set<SpecialEffectsController> w() {
        HashSet hashSet = new HashSet();
        Iterator<I> it = this.f13933c.k().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = it.next().k().mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.v(viewGroup, F0()));
            }
        }
        return hashSet;
    }

    public final ViewGroup w0(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.f13955y.d()) {
            View viewC = this.f13955y.c(fragment.mContainerId);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    public void w1(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(i0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public Set<SpecialEffectsController> x(ArrayList<C1363a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<K.a> it = arrayList.get(i10).f13995c.iterator();
            while (it.hasNext()) {
                Fragment fragment = it.next().f14013b;
                if (fragment != null && (viewGroup = fragment.mContainer) != null) {
                    hashSet.add(SpecialEffectsController.u(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    public v x0() {
        v vVar = this.f13912B;
        if (vVar != null) {
            return vVar;
        }
        Fragment fragment = this.f13956z;
        return fragment != null ? fragment.mFragmentManager.x0() : this.f13913C;
    }

    public void x1(Fragment fragment) {
        if (fragment == null || (fragment.equals(i0(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.f13911A;
            this.f13911A = fragment;
            O(fragment2);
            O(this.f13911A);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public I y(Fragment fragment) {
        I iN = this.f13933c.n(fragment.mWho);
        if (iN != null) {
            return iN;
        }
        I i10 = new I(this.f13946p, this.f13933c, fragment);
        i10.o(this.f13954x.getContext().getClassLoader());
        i10.t(this.f13953w);
        return i10;
    }

    public J y0() {
        return this.f13933c;
    }

    public final void y1(Fragment fragment) {
        ViewGroup viewGroupW0 = w0(fragment);
        if (viewGroupW0 == null || fragment.getEnterAnim() + fragment.getExitAnim() + fragment.getPopEnterAnim() + fragment.getPopExitAnim() <= 0) {
            return;
        }
        int i10 = R$id.visible_removing_fragment_view_tag;
        if (viewGroupW0.getTag(i10) == null) {
            viewGroupW0.setTag(i10, fragment);
        }
        ((Fragment) viewGroupW0.getTag(i10)).setPopDirection(fragment.getPopDirection());
    }

    public void z(Fragment fragment) {
        if (N0(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (N0(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f13933c.u(fragment);
            if (O0(fragment)) {
                this.f13920J = true;
            }
            y1(fragment);
        }
    }

    public List<Fragment> z0() {
        return this.f13933c.o();
    }

    public void z1(Fragment fragment) {
        if (N0(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        int mRequestCode;
        String mWho;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        public LaunchedFragmentInfo(String str, int i10) {
            this.mWho = str;
            this.mRequestCode = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.mWho = parcel.readString();
            this.mRequestCode = parcel.readInt();
        }
    }
}
