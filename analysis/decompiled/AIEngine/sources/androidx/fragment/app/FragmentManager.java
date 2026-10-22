package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import com.stepos.aiengine.R;
import com.stepos.core.common.util.TraceIdKeys;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import q1.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class FragmentManager {
    public d.f A;
    public d.f B;
    public d.f C;
    public ArrayDeque<LaunchedFragmentInfo> D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public ArrayList<androidx.fragment.app.a> J;
    public ArrayList<Boolean> K;
    public ArrayList<Fragment> L;
    public z M;
    public final f N;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2014b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<androidx.fragment.app.a> f2016d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f2017e;

    /* renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f2019g;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList<l> f2023l;

    /* renamed from: m, reason: collision with root package name */
    public final v f2024m;

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList<a0> f2025n;

    /* renamed from: o, reason: collision with root package name */
    public final w f2026o;

    /* renamed from: p, reason: collision with root package name */
    public final x f2027p;

    /* renamed from: q, reason: collision with root package name */
    public final w f2028q;
    public final x r;

    /* renamed from: s, reason: collision with root package name */
    public final c f2029s;

    /* renamed from: t, reason: collision with root package name */
    public int f2030t;

    /* renamed from: u, reason: collision with root package name */
    public t<?> f2031u;

    /* renamed from: v, reason: collision with root package name */
    public q f2032v;

    /* renamed from: w, reason: collision with root package name */
    public Fragment f2033w;

    /* renamed from: x, reason: collision with root package name */
    public Fragment f2034x;

    /* renamed from: y, reason: collision with root package name */
    public final d f2035y;
    public final e z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<m> f2013a = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final c0 f2015c = new c0();

    /* renamed from: f, reason: collision with root package name */
    public final u f2018f = new u(this);
    public final b h = new b();

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f2020i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map<String, BackStackState> f2021j = Collections.synchronizedMap(new HashMap());

    /* renamed from: k, reason: collision with root package name */
    public final Map<String, Bundle> f2022k = Collections.synchronizedMap(new HashMap());

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements d.a<Map<String, Boolean>> {
        public a() {
        }

        @Override // d.a
        @SuppressLint({"SyntheticAccessor"})
        public final void a(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = fragmentManager.D.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.mWho;
            int i11 = launchedFragmentInfoPollFirst.mRequestCode;
            Fragment fragmentC = fragmentManager.f2015c.c(str);
            if (fragmentC == null) {
                a0.a.A("Permission request result delivered for unknown Fragment ", str, "FragmentManager");
            } else {
                fragmentC.onRequestPermissionsResult(i11, strArr, iArr);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends b.p {
        public b() {
            super(false);
        }

        @Override // b.p
        public final void d() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.x(true);
            if (fragmentManager.h.f3026a) {
                fragmentManager.O();
            } else {
                fragmentManager.f2019g.c();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements v0.l {
        public c() {
        }

        @Override // v0.l
        public final void a(Menu menu) {
            FragmentManager.this.p(menu);
        }

        @Override // v0.l
        public final void b(Menu menu) {
            FragmentManager.this.s(menu);
        }

        @Override // v0.l
        public final boolean c(MenuItem menuItem) {
            return FragmentManager.this.o(menuItem);
        }

        @Override // v0.l
        public final void d(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.j(menu, menuInflater);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends s {
        public d() {
        }

        @Override // androidx.fragment.app.s
        public final Fragment a(String str) {
            return Fragment.instantiate(FragmentManager.this.f2031u.f2194b, str, null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e implements m0 {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            FragmentManager.this.x(true);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g implements a0 {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f2041a;

        public g(Fragment fragment) {
            this.f2041a = fragment;
        }

        @Override // androidx.fragment.app.a0
        public final void a(Fragment fragment) {
            this.f2041a.onAttachFragment(fragment);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class h implements d.a<ActivityResult> {
        public h() {
        }

        @Override // d.a
        public final void a(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = fragmentManager.D.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.mWho;
            int i10 = launchedFragmentInfoPollFirst.mRequestCode;
            Fragment fragmentC = fragmentManager.f2015c.c(str);
            if (fragmentC == null) {
                a0.a.A("Activity result delivered for unknown Fragment ", str, "FragmentManager");
            } else {
                fragmentC.onActivityResult(i10, activityResult2.getResultCode(), activityResult2.getData());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class i implements d.a<ActivityResult> {
        public i() {
        }

        @Override // d.a
        public final void a(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            FragmentManager fragmentManager = FragmentManager.this;
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = fragmentManager.D.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.mWho;
            int i10 = launchedFragmentInfoPollFirst.mRequestCode;
            Fragment fragmentC = fragmentManager.f2015c.c(str);
            if (fragmentC == null) {
                a0.a.A("Intent Sender result delivered for unknown Fragment ", str, "FragmentManager");
            } else {
                fragmentC.onActivityResult(i10, activityResult2.getResultCode(), activityResult2.getData());
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface j {
        int getId();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class k extends e.a<IntentSenderRequest, ActivityResult> {
        @Override // e.a
        public final Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequest2 = intentSenderRequest;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent fillInIntent = intentSenderRequest2.getFillInIntent();
            if (fillInIntent != null && (bundleExtra = fillInIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                fillInIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (fillInIntent.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    IntentSender intentSender = intentSenderRequest2.getIntentSender();
                    kotlin.jvm.internal.g.f(intentSender, "intentSender");
                    intentSenderRequest2 = new IntentSenderRequest(intentSender, null, intentSenderRequest2.getFlagsMask(), intentSenderRequest2.getFlagsValues());
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest2);
            if (FragmentManager.G(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // e.a
        public final ActivityResult c(int i10, Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface l {
        void onBackStackChanged();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface m {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class n implements m {

        /* renamed from: a, reason: collision with root package name */
        public final int f2044a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2045b;

        public n(int i10, int i11) {
            this.f2044a = i10;
            this.f2045b = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public final boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
            FragmentManager fragmentManager = FragmentManager.this;
            Fragment fragment = fragmentManager.f2034x;
            int i10 = this.f2044a;
            if (fragment == null || i10 >= 0 || !fragment.getChildFragmentManager().P(-1, 0)) {
                return fragmentManager.Q(arrayList, arrayList2, i10, this.f2045b);
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.fragment.app.w] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.fragment.app.w] */
    public FragmentManager() {
        Collections.synchronizedMap(new HashMap());
        this.f2024m = new v(this);
        this.f2025n = new CopyOnWriteArrayList<>();
        final int i10 = 0;
        this.f2026o = new u0.a(this) { // from class: androidx.fragment.app.w

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f2203b;

            {
                this.f2203b = this;
            }

            @Override // u0.a
            public final void accept(Object obj) {
                switch (i10) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f2203b;
                        if (fragmentManager.I()) {
                            fragmentManager.h(false, configuration);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.d dVar = (androidx.core.app.d) obj;
                        FragmentManager fragmentManager2 = this.f2203b;
                        if (fragmentManager2.I()) {
                            fragmentManager2.m(dVar.f1486a, false);
                            break;
                        }
                        break;
                }
            }
        };
        this.f2027p = new x(this, 0);
        final int i11 = 1;
        this.f2028q = new u0.a(this) { // from class: androidx.fragment.app.w

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ FragmentManager f2203b;

            {
                this.f2203b = this;
            }

            @Override // u0.a
            public final void accept(Object obj) {
                switch (i11) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        FragmentManager fragmentManager = this.f2203b;
                        if (fragmentManager.I()) {
                            fragmentManager.h(false, configuration);
                            break;
                        }
                        break;
                    default:
                        androidx.core.app.d dVar = (androidx.core.app.d) obj;
                        FragmentManager fragmentManager2 = this.f2203b;
                        if (fragmentManager2.I()) {
                            fragmentManager2.m(dVar.f1486a, false);
                            break;
                        }
                        break;
                }
            }
        };
        this.r = new x(this, 1);
        this.f2029s = new c();
        this.f2030t = -1;
        this.f2035y = new d();
        this.z = new e();
        this.D = new ArrayDeque<>();
        this.N = new f();
    }

    public static boolean G(int i10) {
        return Log.isLoggable("FragmentManager", i10);
    }

    public static boolean H(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        ArrayList arrayListE = fragment.mChildFragmentManager.f2015c.e();
        int size = arrayListE.size();
        boolean zH = false;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListE.get(i10);
            i10++;
            Fragment fragment2 = (Fragment) obj;
            if (fragment2 != null) {
                zH = H(fragment2);
            }
            if (zH) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        return fragment.equals(fragmentManager.f2034x) && J(fragmentManager.f2033w);
    }

    public static void a0(Fragment fragment) {
        if (G(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final Fragment A(int i10) {
        c0 c0Var = this.f2015c;
        ArrayList<Fragment> arrayList = c0Var.f2090a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i10) {
                return fragment;
            }
        }
        for (b0 b0Var : c0Var.f2091b.values()) {
            if (b0Var != null) {
                Fragment fragment2 = b0Var.f2081c;
                if (fragment2.mFragmentId == i10) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment B(String str) {
        c0 c0Var = this.f2015c;
        ArrayList<Fragment> arrayList = c0Var.f2090a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = arrayList.get(size);
            if (fragment != null && str.equals(fragment.mTag)) {
                return fragment;
            }
        }
        for (b0 b0Var : c0Var.f2091b.values()) {
            if (b0Var != null) {
                Fragment fragment2 = b0Var.f2081c;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final ViewGroup C(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.f2032v.c()) {
            return null;
        }
        View viewB = this.f2032v.b(fragment.mContainerId);
        if (viewB instanceof ViewGroup) {
            return (ViewGroup) viewB;
        }
        return null;
    }

    public final s D() {
        Fragment fragment = this.f2033w;
        return fragment != null ? fragment.mFragmentManager.D() : this.f2035y;
    }

    public final m0 E() {
        Fragment fragment = this.f2033w;
        return fragment != null ? fragment.mFragmentManager.E() : this.z;
    }

    public final void F(Fragment fragment) {
        if (G(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        Z(fragment);
    }

    public final boolean I() {
        Fragment fragment = this.f2033w;
        if (fragment == null) {
            return true;
        }
        return fragment.isAdded() && this.f2033w.getParentFragmentManager().I();
    }

    public final boolean K() {
        return this.F || this.G;
    }

    public final void L(int i10, boolean z) {
        t<?> tVar;
        if (this.f2031u == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i10 != this.f2030t) {
            this.f2030t = i10;
            c0 c0Var = this.f2015c;
            HashMap<String, b0> map = c0Var.f2091b;
            ArrayList<Fragment> arrayList = c0Var.f2090a;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Fragment fragment = arrayList.get(i11);
                i11++;
                b0 b0Var = map.get(fragment.mWho);
                if (b0Var != null) {
                    b0Var.j();
                }
            }
            for (b0 b0Var2 : map.values()) {
                if (b0Var2 != null) {
                    b0Var2.j();
                    Fragment fragment2 = b0Var2.f2081c;
                    if (fragment2.mRemoving && !fragment2.isInBackStack()) {
                        if (fragment2.mBeingSaved && !c0Var.f2092c.containsKey(fragment2.mWho)) {
                            b0Var2.m();
                        }
                        c0Var.h(b0Var2);
                    }
                }
            }
            ArrayList arrayListD = c0Var.d();
            int size2 = arrayListD.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj = arrayListD.get(i12);
                i12++;
                b0 b0Var3 = (b0) obj;
                Fragment fragment3 = b0Var3.f2081c;
                if (fragment3.mDeferStart) {
                    if (this.f2014b) {
                        this.I = true;
                    } else {
                        fragment3.mDeferStart = false;
                        b0Var3.j();
                    }
                }
            }
            if (this.E && (tVar = this.f2031u) != null && this.f2030t == 7) {
                tVar.h();
                this.E = false;
            }
        }
    }

    public final void M() {
        if (this.f2031u == null) {
            return;
        }
        this.F = false;
        this.G = false;
        this.M.f2211g = false;
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final void N(int i10, boolean z) {
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.providers.a.a(i10, "Bad id: "));
        }
        v(new n(i10, 1), z);
    }

    public final boolean O() {
        return P(-1, 0);
    }

    public final boolean P(int i10, int i11) {
        x(false);
        w(true);
        Fragment fragment = this.f2034x;
        if (fragment != null && i10 < 0 && fragment.getChildFragmentManager().O()) {
            return true;
        }
        boolean zQ = Q(this.J, this.K, i10, i11);
        if (zQ) {
            this.f2014b = true;
            try {
                S(this.J, this.K);
            } finally {
                d();
            }
        }
        c0();
        boolean z = this.I;
        c0 c0Var = this.f2015c;
        if (z) {
            this.I = false;
            ArrayList arrayListD = c0Var.d();
            int size = arrayListD.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayListD.get(i12);
                i12++;
                b0 b0Var = (b0) obj;
                Fragment fragment2 = b0Var.f2081c;
                if (fragment2.mDeferStart) {
                    if (this.f2014b) {
                        this.I = true;
                    } else {
                        fragment2.mDeferStart = false;
                        b0Var.j();
                    }
                }
            }
        }
        c0Var.f2091b.values().removeAll(Collections.singleton(null));
        return zQ;
    }

    public final boolean Q(ArrayList arrayList, ArrayList arrayList2, int i10, int i11) {
        boolean z = (i11 & 1) != 0;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f2016d;
        int size = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i10 < 0) {
                size = z ? 0 : this.f2016d.size() - 1;
            } else {
                int size2 = this.f2016d.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f2016d.get(size2);
                    if (i10 >= 0 && i10 == aVar.f2076s) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    size = size2;
                } else if (z) {
                    size = size2;
                    while (size > 0) {
                        androidx.fragment.app.a aVar2 = this.f2016d.get(size - 1);
                        if (i10 < 0 || i10 != aVar2.f2076s) {
                            break;
                        }
                        size--;
                    }
                } else if (size2 != this.f2016d.size() - 1) {
                    size = size2 + 1;
                }
            }
        }
        if (size < 0) {
            return false;
        }
        for (int size3 = this.f2016d.size() - 1; size3 >= size; size3--) {
            arrayList.add(this.f2016d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void R(Fragment fragment) {
        if (G(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean zIsInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && zIsInBackStack) {
            return;
        }
        c0 c0Var = this.f2015c;
        synchronized (c0Var.f2090a) {
            c0Var.f2090a.remove(fragment);
        }
        fragment.mAdded = false;
        if (H(fragment)) {
            this.E = true;
        }
        fragment.mRemoving = true;
        Z(fragment);
    }

    public final void S(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
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
            if (!arrayList.get(i10).f2109p) {
                if (i11 != i10) {
                    z(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f2109p) {
                        i11++;
                    }
                }
                z(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            z(arrayList, arrayList2, i11, size);
        }
    }

    public final void T(Parcelable parcelable) {
        v vVar;
        b0 b0Var;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f2031u.f2194b.getClassLoader());
                this.f2022k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f2031u.f2194b.getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        c0 c0Var = this.f2015c;
        HashMap<String, FragmentState> map = c0Var.f2092c;
        HashMap<String, b0> map2 = c0Var.f2091b;
        map.clear();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            FragmentState fragmentState = (FragmentState) obj;
            map.put(fragmentState.mWho, fragmentState);
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        map2.clear();
        ArrayList<String> arrayList2 = fragmentManagerState.mActive;
        int size2 = arrayList2.size();
        int i11 = 0;
        while (true) {
            vVar = this.f2024m;
            if (i11 >= size2) {
                break;
            }
            String str3 = arrayList2.get(i11);
            i11++;
            FragmentState fragmentStateI = c0Var.i(str3, null);
            if (fragmentStateI != null) {
                Fragment fragment = this.M.f2206b.get(fragmentStateI.mWho);
                if (fragment != null) {
                    if (G(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    b0Var = new b0(vVar, c0Var, fragment, fragmentStateI);
                } else {
                    b0Var = new b0(this.f2024m, this.f2015c, this.f2031u.f2194b.getClassLoader(), D(), fragmentStateI);
                }
                Fragment fragment2 = b0Var.f2081c;
                fragment2.mFragmentManager = this;
                if (G(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                b0Var.k(this.f2031u.f2194b.getClassLoader());
                c0Var.g(b0Var);
                b0Var.f2083e = this.f2030t;
            }
        }
        z zVar = this.M;
        zVar.getClass();
        ArrayList arrayList3 = new ArrayList(zVar.f2206b.values());
        int size3 = arrayList3.size();
        int i12 = 0;
        while (i12 < size3) {
            Object obj2 = arrayList3.get(i12);
            i12++;
            Fragment fragment3 = (Fragment) obj2;
            if (map2.get(fragment3.mWho) == null) {
                if (G(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                }
                this.M.f(fragment3);
                fragment3.mFragmentManager = this;
                b0 b0Var2 = new b0(vVar, c0Var, fragment3);
                b0Var2.f2083e = 1;
                b0Var2.j();
                fragment3.mRemoving = true;
                b0Var2.j();
            }
        }
        ArrayList<String> arrayList4 = fragmentManagerState.mAdded;
        c0Var.f2090a.clear();
        if (arrayList4 != null) {
            int size4 = arrayList4.size();
            int i13 = 0;
            while (i13 < size4) {
                String str4 = arrayList4.get(i13);
                i13++;
                String str5 = str4;
                Fragment fragmentB = c0Var.b(str5);
                if (fragmentB == null) {
                    throw new IllegalStateException(a0.a.k("No instantiated fragment for (", str5, ")"));
                }
                if (G(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str5 + "): " + fragmentB);
                }
                c0Var.a(fragmentB);
            }
        }
        if (fragmentManagerState.mBackStack != null) {
            this.f2016d = new ArrayList<>(fragmentManagerState.mBackStack.length);
            int i14 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                if (i14 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarInstantiate = backStackRecordStateArr[i14].instantiate(this);
                if (G(2)) {
                    StringBuilder sbK = com.stepos.core.ota.d.k(i14, "restoreAllState: back stack #", " (index ");
                    sbK.append(aVarInstantiate.f2076s);
                    sbK.append("): ");
                    sbK.append(aVarInstantiate);
                    Log.v("FragmentManager", sbK.toString());
                    PrintWriter printWriter = new PrintWriter(new l0());
                    aVarInstantiate.h("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2016d.add(aVarInstantiate);
                i14++;
            }
        } else {
            this.f2016d = null;
        }
        this.f2020i.set(fragmentManagerState.mBackStackIndex);
        String str6 = fragmentManagerState.mPrimaryNavActiveWho;
        if (str6 != null) {
            Fragment fragmentB2 = c0Var.b(str6);
            this.f2034x = fragmentB2;
            q(fragmentB2);
        }
        ArrayList<String> arrayList5 = fragmentManagerState.mBackStackStateKeys;
        if (arrayList5 != null) {
            for (int i15 = 0; i15 < arrayList5.size(); i15++) {
                this.f2021j.put(arrayList5.get(i15), fragmentManagerState.mBackStackStates.get(i15));
            }
        }
        this.D = new ArrayDeque<>(fragmentManagerState.mLaunchedFragments);
    }

    public final Bundle U() {
        int i10;
        BackStackRecordState[] backStackRecordStateArr;
        ArrayList<String> arrayList;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            i10 = 0;
            if (!it.hasNext()) {
                break;
            }
            SpecialEffectsController specialEffectsController = (SpecialEffectsController) it.next();
            if (specialEffectsController.f2053e) {
                if (G(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                specialEffectsController.f2053e = false;
                specialEffectsController.c();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((SpecialEffectsController) it2.next()).e();
        }
        x(true);
        this.F = true;
        this.M.f2211g = true;
        c0 c0Var = this.f2015c;
        c0Var.getClass();
        HashMap<String, b0> map = c0Var.f2091b;
        ArrayList<String> arrayList2 = new ArrayList<>(map.size());
        for (b0 b0Var : map.values()) {
            if (b0Var != null) {
                Fragment fragment = b0Var.f2081c;
                b0Var.m();
                arrayList2.add(fragment.mWho);
                if (G(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragment.mSavedFragmentState);
                }
            }
        }
        c0 c0Var2 = this.f2015c;
        c0Var2.getClass();
        ArrayList arrayList3 = new ArrayList(c0Var2.f2092c.values());
        if (!arrayList3.isEmpty()) {
            c0 c0Var3 = this.f2015c;
            synchronized (c0Var3.f2090a) {
                try {
                    backStackRecordStateArr = null;
                    if (c0Var3.f2090a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList<>(c0Var3.f2090a.size());
                        ArrayList<Fragment> arrayList4 = c0Var3.f2090a;
                        int size2 = arrayList4.size();
                        int i11 = 0;
                        while (i11 < size2) {
                            Fragment fragment2 = arrayList4.get(i11);
                            i11++;
                            Fragment fragment3 = fragment2;
                            arrayList.add(fragment3.mWho);
                            if (G(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment3.mWho + "): " + fragment3);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList<androidx.fragment.app.a> arrayList5 = this.f2016d;
            if (arrayList5 != null && (size = arrayList5.size()) > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i12 = 0; i12 < size; i12++) {
                    backStackRecordStateArr[i12] = new BackStackRecordState(this.f2016d.get(i12));
                    if (G(2)) {
                        StringBuilder sbK = com.stepos.core.ota.d.k(i12, "saveAllState: adding back stack #", ": ");
                        sbK.append(this.f2016d.get(i12));
                        Log.v("FragmentManager", sbK.toString());
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.mActive = arrayList2;
            fragmentManagerState.mAdded = arrayList;
            fragmentManagerState.mBackStack = backStackRecordStateArr;
            fragmentManagerState.mBackStackIndex = this.f2020i.get();
            Fragment fragment4 = this.f2034x;
            if (fragment4 != null) {
                fragmentManagerState.mPrimaryNavActiveWho = fragment4.mWho;
            }
            fragmentManagerState.mBackStackStateKeys.addAll(this.f2021j.keySet());
            fragmentManagerState.mBackStackStates.addAll(this.f2021j.values());
            fragmentManagerState.mLaunchedFragments = new ArrayList<>(this.D);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f2022k.keySet()) {
                bundle.putBundle(ai.onnxruntime.a.k("result_", str), this.f2022k.get(str));
            }
            int size3 = arrayList3.size();
            while (i10 < size3) {
                Object obj = arrayList3.get(i10);
                i10++;
                FragmentState fragmentState = (FragmentState) obj;
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle("fragment_" + fragmentState.mWho, bundle2);
            }
        } else if (G(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void V() {
        synchronized (this.f2013a) {
            try {
                if (this.f2013a.size() == 1) {
                    this.f2031u.f2195c.removeCallbacks(this.N);
                    this.f2031u.f2195c.post(this.N);
                    c0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void W(Fragment fragment, boolean z) {
        ViewGroup viewGroupC = C(fragment);
        if (viewGroupC == null || !(viewGroupC instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupC).setDrawDisappearingViewsLast(!z);
    }

    public final void X(Fragment fragment, Lifecycle.State state) {
        if (fragment.equals(this.f2015c.b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void Y(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f2015c.b(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.f2034x;
        this.f2034x = fragment;
        q(fragment2);
        q(this.f2034x);
    }

    public final void Z(Fragment fragment) {
        ViewGroup viewGroupC = C(fragment);
        if (viewGroupC != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (viewGroupC.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupC.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) viewGroupC.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final b0 a(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.d(fragment, str);
        }
        if (G(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        b0 b0VarF = f(fragment);
        fragment.mFragmentManager = this;
        c0 c0Var = this.f2015c;
        c0Var.g(b0VarF);
        if (!fragment.mDetached) {
            c0Var.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (H(fragment)) {
                this.E = true;
            }
        }
        return b0VarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public final void b(t<?> tVar, q qVar, Fragment fragment) {
        if (this.f2031u != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2031u = tVar;
        this.f2032v = qVar;
        this.f2033w = fragment;
        CopyOnWriteArrayList<a0> copyOnWriteArrayList = this.f2025n;
        if (fragment != null) {
            copyOnWriteArrayList.add(new g(fragment));
        } else if (tVar instanceof a0) {
            copyOnWriteArrayList.add((a0) tVar);
        }
        if (this.f2033w != null) {
            c0();
        }
        if (tVar instanceof b.s) {
            b.s sVar = (b.s) tVar;
            OnBackPressedDispatcher onBackPressedDispatcher = sVar.getOnBackPressedDispatcher();
            this.f2019g = onBackPressedDispatcher;
            androidx.lifecycle.q qVar2 = sVar;
            if (fragment != null) {
                qVar2 = fragment;
            }
            onBackPressedDispatcher.a(qVar2, this.h);
        }
        if (fragment != null) {
            z zVar = fragment.mFragmentManager.M;
            HashMap<String, z> map = zVar.f2207c;
            z zVar2 = map.get(fragment.mWho);
            if (zVar2 == null) {
                zVar2 = new z(zVar.f2209e);
                map.put(fragment.mWho, zVar2);
            }
            this.M = zVar2;
        } else if (tVar instanceof t0) {
            s0 store = ((t0) tVar).getViewModelStore();
            kotlin.jvm.internal.g.f(store, "store");
            a.C0127a defaultCreationExtras = a.C0127a.f11487b;
            kotlin.jvm.internal.g.f(defaultCreationExtras, "defaultCreationExtras");
            r1.b bVar = new r1.b(store, z.h, defaultCreationExtras);
            kotlin.jvm.internal.c cVarA = kotlin.jvm.internal.i.a(z.class);
            String strD = cVarA.d();
            if (strD == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            this.M = (z) bVar.a(cVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strD));
        } else {
            this.M = new z(false);
        }
        this.M.f2211g = K();
        this.f2015c.f2093d = this.M;
        Object obj = this.f2031u;
        if ((obj instanceof w1.d) && fragment == null) {
            w1.b savedStateRegistry = ((w1.d) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new androidx.fragment.app.l(this, 1));
            Bundle bundleA = savedStateRegistry.a("android:support:fragments");
            if (bundleA != null) {
                T(bundleA);
            }
        }
        Object obj2 = this.f2031u;
        if (obj2 instanceof d.g) {
            d.d activityResultRegistry = ((d.g) obj2).getActivityResultRegistry();
            String strK = ai.onnxruntime.a.k("FragmentManager:", fragment != null ? ai.onnxruntime.a.o(new StringBuilder(), fragment.mWho, ":") : "");
            this.A = activityResultRegistry.d(a0.a.j(strK, "StartActivityForResult"), new e.c(), new h());
            this.B = activityResultRegistry.d(a0.a.j(strK, "StartIntentSenderForResult"), new k(), new i());
            this.C = activityResultRegistry.d(a0.a.j(strK, "RequestPermissions"), new e.b(), new a());
        }
        Object obj3 = this.f2031u;
        if (obj3 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj3).addOnConfigurationChangedListener(this.f2026o);
        }
        Object obj4 = this.f2031u;
        if (obj4 instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj4).addOnTrimMemoryListener(this.f2027p);
        }
        Object obj5 = this.f2031u;
        if (obj5 instanceof androidx.core.app.j) {
            ((androidx.core.app.j) obj5).addOnMultiWindowModeChangedListener(this.f2028q);
        }
        Object obj6 = this.f2031u;
        if (obj6 instanceof androidx.core.app.k) {
            ((androidx.core.app.k) obj6).addOnPictureInPictureModeChangedListener(this.r);
        }
        Object obj7 = this.f2031u;
        if ((obj7 instanceof v0.h) && fragment == null) {
            ((v0.h) obj7).addMenuProvider(this.f2029s);
        }
    }

    public final void b0(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new l0());
        t<?> tVar = this.f2031u;
        if (tVar != null) {
            try {
                tVar.d(printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e10) {
                Log.e("FragmentManager", "Failed dumping state", e10);
                throw illegalStateException;
            }
        }
        try {
            u("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e11) {
            Log.e("FragmentManager", "Failed dumping state", e11);
            throw illegalStateException;
        }
    }

    public final void c(Fragment fragment) {
        if (G(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f2015c.a(fragment);
            if (G(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (H(fragment)) {
                this.E = true;
            }
        }
    }

    public final void c0() {
        synchronized (this.f2013a) {
            try {
                if (!this.f2013a.isEmpty()) {
                    this.h.e(true);
                    return;
                }
                b bVar = this.h;
                ArrayList<androidx.fragment.app.a> arrayList = this.f2016d;
                bVar.e((arrayList != null ? arrayList.size() : 0) > 0 && J(this.f2033w));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        this.f2014b = false;
        this.K.clear();
        this.J.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        ArrayList arrayListD = this.f2015c.d();
        int size = arrayListD.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListD.get(i10);
            i10++;
            ViewGroup viewGroup = ((b0) obj).f2081c.mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.g(viewGroup, E()));
            }
        }
        return hashSet;
    }

    public final b0 f(Fragment fragment) {
        String str = fragment.mWho;
        c0 c0Var = this.f2015c;
        b0 b0Var = c0Var.f2091b.get(str);
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0(this.f2024m, c0Var, fragment);
        b0Var2.k(this.f2031u.f2194b.getClassLoader());
        b0Var2.f2083e = this.f2030t;
        return b0Var2;
    }

    public final void g(Fragment fragment) {
        if (G(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (G(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            c0 c0Var = this.f2015c;
            synchronized (c0Var.f2090a) {
                c0Var.f2090a.remove(fragment);
            }
            fragment.mAdded = false;
            if (H(fragment)) {
                this.E = true;
            }
            Z(fragment);
        }
    }

    public final void h(boolean z, Configuration configuration) {
        if (z && (this.f2031u instanceof androidx.core.content.c)) {
            b0(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
                if (z) {
                    fragment.mChildFragmentManager.h(true, configuration);
                }
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.f2030t < 1) {
            return false;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.f2030t < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f2017e != null) {
            for (int i10 = 0; i10 < this.f2017e.size(); i10++) {
                Fragment fragment2 = this.f2017e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2017e = arrayList;
        return z;
    }

    public final void k() {
        boolean zIsChangingConfigurations = true;
        this.H = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).e();
        }
        t<?> tVar = this.f2031u;
        boolean z = tVar instanceof t0;
        c0 c0Var = this.f2015c;
        if (z) {
            zIsChangingConfigurations = c0Var.f2093d.f2210f;
        } else {
            o oVar = tVar.f2194b;
            if (oVar != null) {
                zIsChangingConfigurations = true ^ oVar.isChangingConfigurations();
            }
        }
        if (zIsChangingConfigurations) {
            Iterator<BackStackState> it2 = this.f2021j.values().iterator();
            while (it2.hasNext()) {
                for (String str : it2.next().mFragments) {
                    z zVar = c0Var.f2093d;
                    zVar.getClass();
                    if (G(3)) {
                        a0.a.v("Clearing non-config state for saved state of Fragment ", str, "FragmentManager");
                    }
                    zVar.e(str);
                }
            }
        }
        t(-1);
        Object obj = this.f2031u;
        if (obj instanceof androidx.core.content.d) {
            ((androidx.core.content.d) obj).removeOnTrimMemoryListener(this.f2027p);
        }
        Object obj2 = this.f2031u;
        if (obj2 instanceof androidx.core.content.c) {
            ((androidx.core.content.c) obj2).removeOnConfigurationChangedListener(this.f2026o);
        }
        Object obj3 = this.f2031u;
        if (obj3 instanceof androidx.core.app.j) {
            ((androidx.core.app.j) obj3).removeOnMultiWindowModeChangedListener(this.f2028q);
        }
        Object obj4 = this.f2031u;
        if (obj4 instanceof androidx.core.app.k) {
            ((androidx.core.app.k) obj4).removeOnPictureInPictureModeChangedListener(this.r);
        }
        Object obj5 = this.f2031u;
        if (obj5 instanceof v0.h) {
            ((v0.h) obj5).removeMenuProvider(this.f2029s);
        }
        this.f2031u = null;
        this.f2032v = null;
        this.f2033w = null;
        if (this.f2019g != null) {
            Iterator<b.b> it3 = this.h.f3027b.iterator();
            while (it3.hasNext()) {
                it3.next().cancel();
            }
            this.f2019g = null;
        }
        d.f fVar = this.A;
        if (fVar != null) {
            fVar.b();
            this.B.b();
            this.C.b();
        }
    }

    public final void l(boolean z) {
        if (z && (this.f2031u instanceof androidx.core.content.d)) {
            b0(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
                if (z) {
                    fragment.mChildFragmentManager.l(true);
                }
            }
        }
    }

    public final void m(boolean z, boolean z3) {
        if (z3 && (this.f2031u instanceof androidx.core.app.j)) {
            b0(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
                if (z3) {
                    fragment.mChildFragmentManager.m(z, true);
                }
            }
        }
    }

    public final void n() {
        ArrayList arrayListE = this.f2015c.e();
        int size = arrayListE.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayListE.get(i10);
            i10++;
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.n();
            }
        }
    }

    public final boolean o(MenuItem menuItem) {
        if (this.f2030t < 1) {
            return false;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void p(Menu menu) {
        if (this.f2030t < 1) {
            return;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void q(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f2015c.b(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void r(boolean z, boolean z3) {
        if (z3 && (this.f2031u instanceof androidx.core.app.k)) {
            b0(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
                if (z3) {
                    fragment.mChildFragmentManager.r(z, true);
                }
            }
        }
    }

    public final boolean s(Menu menu) {
        boolean z = false;
        if (this.f2030t < 1) {
            return false;
        }
        for (Fragment fragment : this.f2015c.f()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void t(int i10) {
        try {
            this.f2014b = true;
            for (b0 b0Var : this.f2015c.f2091b.values()) {
                if (b0Var != null) {
                    b0Var.f2083e = i10;
                }
            }
            L(i10, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).e();
            }
            this.f2014b = false;
            x(true);
        } catch (Throwable th) {
            this.f2014b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(TraceIdKeys.MAX_LENGTH);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f2033w;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append("{");
            sb2.append(Integer.toHexString(System.identityHashCode(this.f2033w)));
            sb2.append("}");
        } else {
            t<?> tVar = this.f2031u;
            if (tVar != null) {
                sb2.append(tVar.getClass().getSimpleName());
                sb2.append("{");
                sb2.append(Integer.toHexString(System.identityHashCode(this.f2031u)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strJ = a0.a.j(str, "    ");
        c0 c0Var = this.f2015c;
        ArrayList<Fragment> arrayList = c0Var.f2090a;
        String strJ2 = a0.a.j(str, "    ");
        HashMap<String, b0> map = c0Var.f2091b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (b0 b0Var : map.values()) {
                printWriter.print(str);
                if (b0Var != null) {
                    Fragment fragment = b0Var.f2081c;
                    printWriter.println(fragment);
                    fragment.dump(strJ2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i10 = 0; i10 < size3; i10++) {
                Fragment fragment2 = arrayList.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList2 = this.f2017e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i11 = 0; i11 < size2; i11++) {
                Fragment fragment3 = this.f2017e.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f2016d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i12 = 0; i12 < size; i12++) {
                androidx.fragment.app.a aVar = this.f2016d.get(i12);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i12);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.h(strJ, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2020i.get());
        synchronized (this.f2013a) {
            try {
                int size4 = this.f2013a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i13 = 0; i13 < size4; i13++) {
                        Object obj = (m) this.f2013a.get(i13);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i13);
                        printWriter.print(": ");
                        printWriter.println(obj);
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
        printWriter.println(this.f2031u);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2032v);
        if (this.f2033w != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2033w);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2030t);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.F);
        printWriter.print(" mStopped=");
        printWriter.print(this.G);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.H);
        if (this.E) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.E);
        }
    }

    public final void v(m mVar, boolean z) {
        if (!z) {
            if (this.f2031u == null) {
                if (!this.H) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (K()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f2013a) {
            try {
                if (this.f2031u == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f2013a.add(mVar);
                    V();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z) {
        if (this.f2014b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2031u == null) {
            if (!this.H) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2031u.f2195c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && K()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.J == null) {
            this.J = new ArrayList<>();
            this.K = new ArrayList<>();
        }
    }

    public final boolean x(boolean z) {
        boolean zA;
        w(z);
        boolean z3 = false;
        while (true) {
            ArrayList<androidx.fragment.app.a> arrayList = this.J;
            ArrayList<Boolean> arrayList2 = this.K;
            synchronized (this.f2013a) {
                if (this.f2013a.isEmpty()) {
                    zA = false;
                } else {
                    try {
                        int size = this.f2013a.size();
                        zA = false;
                        for (int i10 = 0; i10 < size; i10++) {
                            zA |= this.f2013a.get(i10).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!zA) {
                break;
            }
            this.f2014b = true;
            try {
                S(this.J, this.K);
                d();
                z3 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        c0();
        if (this.I) {
            this.I = false;
            ArrayList arrayListD = this.f2015c.d();
            int size2 = arrayListD.size();
            int i11 = 0;
            while (i11 < size2) {
                Object obj = arrayListD.get(i11);
                i11++;
                b0 b0Var = (b0) obj;
                Fragment fragment = b0Var.f2081c;
                if (fragment.mDeferStart) {
                    if (this.f2014b) {
                        this.I = true;
                    } else {
                        fragment.mDeferStart = false;
                        b0Var.j();
                    }
                }
            }
        }
        this.f2015c.f2091b.values().removeAll(Collections.singleton(null));
        return z3;
    }

    public final void y(androidx.fragment.app.a aVar, boolean z) {
        if (z && (this.f2031u == null || this.H)) {
            return;
        }
        w(z);
        aVar.a(this.J, this.K);
        this.f2014b = true;
        try {
            S(this.J, this.K);
            d();
            c0();
            boolean z3 = this.I;
            c0 c0Var = this.f2015c;
            if (z3) {
                this.I = false;
                ArrayList arrayListD = c0Var.d();
                int size = arrayListD.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayListD.get(i10);
                    i10++;
                    b0 b0Var = (b0) obj;
                    Fragment fragment = b0Var.f2081c;
                    if (fragment.mDeferStart) {
                        if (this.f2014b) {
                            this.I = true;
                        } else {
                            fragment.mDeferStart = false;
                            b0Var.j();
                        }
                    }
                }
            }
            c0Var.f2091b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0228 A[PHI: r14
      0x0228: PHI (r14v14 int) = (r14v13 int), (r14v15 int) binds: [B:99:0x0218, B:104:0x0224] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(java.util.ArrayList<androidx.fragment.app.a> r24, java.util.ArrayList<java.lang.Boolean> r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 1218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.z(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        int mRequestCode;
        String mWho;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final LaunchedFragmentInfo[] newArray(int i10) {
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
