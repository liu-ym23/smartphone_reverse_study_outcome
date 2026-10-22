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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.R$id;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import com.bytedance.common.wschannel.WsConstants;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager implements FragmentResultOwner {
    public static boolean S = false;
    public androidx.fragment.app.p A;
    public SpecialEffectsControllerFactory B;
    public SpecialEffectsControllerFactory C;
    public ActivityResultLauncher D;
    public ActivityResultLauncher E;
    public ActivityResultLauncher F;
    public ArrayDeque G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f3186J;
    public boolean K;
    public boolean L;
    public ArrayList M;
    public ArrayList N;
    public ArrayList O;
    public y P;
    public FragmentStrictMode.a Q;
    public Runnable R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f3189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f3190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f3191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f3192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f3193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.activity.l f3194h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f3195i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f3196j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f3197k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f3198l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f3199m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final r f3200n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f3201o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Consumer f3202p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Consumer f3203q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Consumer f3204r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Consumer f3205s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MenuProvider f3206t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FragmentHostCallback f3208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public FragmentContainer f3209w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Fragment f3210x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Fragment f3211y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.fragment.app.p f3212z;

    public interface BackStackEntry {
        @Nullable
        @Deprecated
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbShortTitleRes();

        @Nullable
        @Deprecated
        CharSequence getBreadCrumbTitle();

        @StringRes
        @Deprecated
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public LaunchedFragmentInfo a(Parcel r10) {
                return new LaunchedFragmentInfo(r10);
            }

            public LaunchedFragmentInfo[] b(int r10) {
                return new LaunchedFragmentInfo[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return b(r10);
            }
        }

        static {
            CREATOR = new a();
        }

        public LaunchedFragmentInfo(@NonNull String r10, int r11) {
            this.mWho = r10;
            this.mRequestCode = r11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.mWho);
            r10.writeInt(this.mRequestCode);
        }

        public LaunchedFragmentInfo(@NonNull Parcel r10) {
            this.mWho = r10.readString();
            this.mRequestCode = r10.readInt();
        }
    }

    public interface OnBackStackChangedListener {
        @MainThread
        default void onBackStackChangeCommitted(@NonNull Fragment r10, boolean r11) {
        }

        @MainThread
        default void onBackStackChangeStarted(@NonNull Fragment r10, boolean r11) {
        }

        @MainThread
        void onBackStackChanged();
    }

    public interface OpGenerator {
        boolean generateOps(@NonNull ArrayList<androidx.fragment.app.a> r10, @NonNull ArrayList<Boolean> r11);
    }

    public class a implements ActivityResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3213a;

        public a(FragmentManager r10) {
            this.f3213a = r10;
        }

        public void a(Map r10) {
            String[] r11 = (String[]) r10.keySet().toArray(new String[0]);
            ArrayList r12 = new ArrayList(r10.values());
            int[] r13 = new int[r12.size()];
            int r14 = 0;
        L4:
            if (r14 >= r12.size()) goto L10;
            if (((Boolean) r12.get(r14)).booleanValue() == false) goto L8;
            int r15 = 0;
        L9:
            r13[r14] = r15;
            r14 = r14 + 1;
            goto L4
        L8:
            r15 = -1;
            goto L9
        L10:
            LaunchedFragmentInfo r16 = (LaunchedFragmentInfo) this.f3213a.G.pollFirst();
            if (r16 != null) goto L14;
            Log.w("FragmentManager", "No permissions were requested for " + this);
            return;
        L14:
            String r17 = r16.mWho;
            int r18 = r16.mRequestCode;
            Fragment r19 = FragmentManager.h(this.f3213a).i(r17);
            if (r19 != null) goto L18;
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + r17);
            return;
        L18:
            r19.onRequestPermissionsResult(r18, r11, r13);
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public /* bridge */ /* synthetic */ void onActivityResult(Object r10) {
            a((Map) r10);
        }
    }

    public class b extends androidx.activity.l {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3214d;

        public b(FragmentManager r10, boolean r11) {
            this.f3214d = r10;
            super(r11);
        }

        @Override // androidx.activity.l
        public void d() {
            this.f3214d.H0();
        }
    }

    public class c implements MenuProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3215a;

        public c(FragmentManager r10) {
            this.f3215a = r10;
        }

        @Override // androidx.core.view.MenuProvider
        public void onCreateMenu(Menu r10, MenuInflater r11) {
            this.f3215a.C(r10, r11);
        }

        @Override // androidx.core.view.MenuProvider
        public void onMenuClosed(Menu r10) {
            this.f3215a.K(r10);
        }

        @Override // androidx.core.view.MenuProvider
        public boolean onMenuItemSelected(MenuItem r10) {
            return this.f3215a.J(r10);
        }

        @Override // androidx.core.view.MenuProvider
        public void onPrepareMenu(Menu r10) {
            this.f3215a.O(r10);
        }
    }

    public class d extends androidx.fragment.app.p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3216b;

        public d(FragmentManager r10) {
            this.f3216b = r10;
        }

        @Override // androidx.fragment.app.p
        public Fragment a(ClassLoader r10, String r11) {
            return this.f3216b.y0().a(this.f3216b.y0().e(), r11, null);
        }
    }

    public class e implements SpecialEffectsControllerFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3217a;

        public e(FragmentManager r10) {
            this.f3217a = r10;
        }

        @Override // androidx.fragment.app.SpecialEffectsControllerFactory
        public SpecialEffectsController createController(ViewGroup r10) {
            return new DefaultSpecialEffectsController(r10);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3218a;

        public f(FragmentManager r10) {
            this.f3218a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3218a.a0(true);
        }
    }

    public class g implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentResultListener f3220b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f3221c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3222d;

        public g(FragmentManager r10, String r11, FragmentResultListener r12, Lifecycle r13) {
            this.f3222d = r10;
            this.f3219a = r11;
            this.f3220b = r12;
            this.f3221c = r13;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (r11 != Lifecycle.Event.ON_START) goto L8;
            Bundle r12 = (Bundle) FragmentManager.f(this.f3222d).get(this.f3219a);
            if (r12 == null) goto L8;
            this.f3220b.onFragmentResult(this.f3219a, r12);
            this.f3222d.clearFragmentResult(this.f3219a);
        L8:
            if (r11 != Lifecycle.Event.ON_DESTROY) goto L11;
            this.f3221c.d(this);
            FragmentManager.g(this.f3222d).remove(this.f3219a);
            return;
        }
    }

    public class h implements FragmentOnAttachListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f3223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3224b;

        public h(FragmentManager r10, Fragment r11) {
            this.f3224b = r10;
            this.f3223a = r11;
        }

        @Override // androidx.fragment.app.FragmentOnAttachListener
        public void onAttachFragment(FragmentManager r10, Fragment r11) {
            this.f3223a.onAttachFragment(r11);
        }
    }

    public class i implements ActivityResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3225a;

        public i(FragmentManager r10) {
            this.f3225a = r10;
        }

        public void a(ActivityResult r10) {
            LaunchedFragmentInfo r11 = (LaunchedFragmentInfo) this.f3225a.G.pollLast();
            if (r11 != null) goto L6;
            Log.w("FragmentManager", "No Activities were started for result for " + this);
            return;
        L6:
            String r12 = r11.mWho;
            int r13 = r11.mRequestCode;
            Fragment r14 = FragmentManager.h(this.f3225a).i(r12);
            if (r14 != null) goto L10;
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + r12);
            return;
        L10:
            r14.onActivityResult(r13, r10.getResultCode(), r10.getData());
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public /* bridge */ /* synthetic */ void onActivityResult(Object r10) {
            a((ActivityResult) r10);
        }
    }

    public class j implements ActivityResultCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3226a;

        public j(FragmentManager r10) {
            this.f3226a = r10;
        }

        public void a(ActivityResult r10) {
            LaunchedFragmentInfo r11 = (LaunchedFragmentInfo) this.f3226a.G.pollFirst();
            if (r11 != null) goto L6;
            Log.w("FragmentManager", "No IntentSenders were started for " + this);
            return;
        L6:
            String r12 = r11.mWho;
            int r13 = r11.mRequestCode;
            Fragment r14 = FragmentManager.h(this.f3226a).i(r12);
            if (r14 != null) goto L10;
            Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + r12);
            return;
        L10:
            r14.onActivityResult(r13, r10.getResultCode(), r10.getData());
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public /* bridge */ /* synthetic */ void onActivityResult(Object r10) {
            a((ActivityResult) r10);
        }
    }

    public static class k extends ActivityResultContract {
        public k() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent a(Context r10, Object r11) {
            return d(r10, (IntentSenderRequest) r11);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Object c(int r10, Intent r11) {
            return e(r10, r11);
        }

        public Intent d(Context r10, IntentSenderRequest r11) {
            Intent r12 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent r13 = r11.getFillInIntent();
            if (r13 == null) goto L9;
            Bundle r14 = r13.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (r14 == null) goto L9;
            r12.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r14);
            r13.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (r13.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false) == false) goto L9;
            r11 = new IntentSenderRequest.Builder(r11.getIntentSender()).b(null).c(r11.getFlagsValues(), r11.getFlagsMask()).a();
        L9:
            r12.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", r11);
            if (FragmentManager.L0(2) == false) goto L12;
            Log.v("FragmentManager", "CreateIntent created the following intent: " + r12);
        L12:
            return r12;
        }

        public ActivityResult e(int r10, Intent r11) {
            return new ActivityResult(r10, r11);
        }
    }

    public static abstract class l {
        public l() {
        }

        public void a(FragmentManager r10, Fragment r11, Bundle r12) {
        }

        public void b(FragmentManager r10, Fragment r11, Context r12) {
        }

        public void c(FragmentManager r10, Fragment r11, Bundle r12) {
        }

        public void d(FragmentManager r10, Fragment r11) {
        }

        public void e(FragmentManager r10, Fragment r11) {
        }

        public void f(FragmentManager r10, Fragment r11) {
        }

        public void g(FragmentManager r10, Fragment r11, Context r12) {
        }

        public void h(FragmentManager r10, Fragment r11, Bundle r12) {
        }

        public void i(FragmentManager r10, Fragment r11) {
        }

        public void j(FragmentManager r10, Fragment r11, Bundle r12) {
        }

        public void k(FragmentManager r10, Fragment r11) {
        }

        public void l(FragmentManager r10, Fragment r11) {
        }

        public abstract void m(FragmentManager r10, Fragment r11, View r12, Bundle r13);

        public void n(FragmentManager r10, Fragment r11) {
        }
    }

    public static class m implements FragmentResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f3227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FragmentResultListener f3228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LifecycleEventObserver f3229c;

        public m(Lifecycle r10, FragmentResultListener r11, LifecycleEventObserver r12) {
            this.f3227a = r10;
            this.f3228b = r11;
            this.f3229c = r12;
        }

        public boolean a(Lifecycle.State r10) {
            return this.f3227a.b().isAtLeast(r10);
        }

        public void b() {
            this.f3227a.d(this.f3229c);
        }

        @Override // androidx.fragment.app.FragmentResultListener
        public void onFragmentResult(String r10, Bundle r11) {
            this.f3228b.onFragmentResult(r10, r11);
        }
    }

    public class n implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f3232c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3233d;

        public n(FragmentManager r10, String r11, int r12, int r13) {
            this.f3233d = r10;
            this.f3230a = r11;
            this.f3231b = r12;
            this.f3232c = r13;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList r10, ArrayList r11) {
            Fragment r12 = this.f3233d.f3211y;
            if (r12 == null) goto L13;
            if (this.f3231b >= 0) goto L13;
            if (this.f3230a != null) goto L13;
            if (r12.getChildFragmentManager().i1() == false) goto L13;
            return false;
        L13:
            return this.f3233d.l1(r10, r11, this.f3230a, this.f3231b, this.f3232c);
        }
    }

    public class o implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3235b;

        public o(FragmentManager r10, String r11) {
            this.f3235b = r10;
            this.f3234a = r11;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList r10, ArrayList r11) {
            return this.f3235b.t1(r10, r11, this.f3234a);
        }
    }

    public class p implements OpGenerator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f3236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f3237b;

        public p(FragmentManager r10, String r11) {
            this.f3237b = r10;
            this.f3236a = r11;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public boolean generateOps(ArrayList r10, ArrayList r11) {
            return this.f3237b.y1(r10, r11, this.f3236a);
        }
    }

    static {
    }

    public FragmentManager() {
        this.f3187a = new ArrayList();
        this.f3189c = new c0();
        this.f3192f = new q(this);
        this.f3194h = new b(this, false);
        this.f3195i = new AtomicInteger();
        this.f3196j = Collections.synchronizedMap(new HashMap());
        this.f3197k = Collections.synchronizedMap(new HashMap());
        this.f3198l = Collections.synchronizedMap(new HashMap());
        this.f3200n = new r(this);
        this.f3201o = new CopyOnWriteArrayList();
        this.f3202p = new s(this);
        this.f3203q = new t(this);
        this.f3204r = new u(this);
        this.f3205s = new v(this);
        this.f3206t = new c(this);
        this.f3207u = -1;
        this.f3212z = null;
        this.A = new d(this);
        this.B = null;
        this.C = new e(this);
        this.G = new ArrayDeque();
        this.R = new f(this);
    }

    public static Fragment F0(View r10) {
        Object r11 = r10.getTag(R$id.fragment_container_view_tag);
        if ((r11 instanceof Fragment) == true) goto L5;
        return null;
    L5:
        return (Fragment) r11;
    }

    public static boolean L0(int r10) {
        if (S == false) goto L5;
    L8:
        return true;
    L5:
        if (Log.isLoggable("FragmentManager", r10) == true) goto L8;
        return false;
    }

    public static /* synthetic */ void a(FragmentManager r10, Integer r11) {
        r10.V0(r11);
    }

    public static /* synthetic */ Bundle b(FragmentManager r10) {
        return r10.T0();
    }

    public static /* synthetic */ void c(FragmentManager r10, androidx.core.app.k r11) {
        r10.X0(r11);
    }

    public static void c0(ArrayList r10, ArrayList r11, int r12, int r13) {
    L2:
        if (r12 >= r13) goto L8;
        androidx.fragment.app.a r14 = (androidx.fragment.app.a) r10.get(r12);
        if (((Boolean) r11.get(r12)).booleanValue() == false) goto L6;
        r14.B(-1);
        r14.H();
    L7:
        r12 = r12 + 1;
        goto L2
    L6:
        r14.B(1);
        r14.G();
        goto L7
    }

    public static /* synthetic */ void d(FragmentManager r10, androidx.core.app.e r11) {
        r10.W0(r11);
    }

    public static /* synthetic */ void e(FragmentManager r10, Configuration r11) {
        r10.U0(r11);
    }

    public static /* synthetic */ Map f(FragmentManager r10) {
        return r10.f3197k;
    }

    public static /* synthetic */ Map g(FragmentManager r10) {
        return r10.f3198l;
    }

    public static /* synthetic */ c0 h(FragmentManager r10) {
        return r10.f3189c;
    }

    public static FragmentManager k0(View r10) {
        Fragment r11 = l0(r10);
        if (r11 != null) goto L5;
        Context r12 = r10.getContext();
    L11:
        if ((r12 instanceof ContextWrapper) == false) goto L16;
        if ((r12 instanceof FragmentActivity) == true) goto L14;
        r12 = ((ContextWrapper) r12).getBaseContext();
        goto L11
    L14:
        FragmentActivity r13 = (FragmentActivity) r12;
    L17:
        if (r13 == null) goto L21;
        return r13.getSupportFragmentManager();
    L21:
        throw new IllegalStateException("View " + r10 + " is not within a subclass of FragmentActivity.");
    L16:
        r13 = null;
        goto L17
    L5:
        if (r11.isAdded() == false) goto L8;
        return r11.getChildFragmentManager();
    L8:
        throw new IllegalStateException("The Fragment " + r11 + " that owns View " + r10 + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
    }

    public static Fragment l0(View r10) {
    L3:
        if (r10 == null) goto L11;
        Fragment r11 = F0(r10);
        if (r11 != null) goto L6;
        Object r12 = r10.getParent();
        if ((r12 instanceof View) == true) goto L9;
        r10 = null;
        goto L3
    L9:
        r10 = (View) r12;
        goto L3
    L6:
        return r11;
    L11:
        return null;
    }

    public static int v1(int r10) {
        int r11 = 4097;
        if (r10 == 4097) goto L14;
        if (r10 == 8194) goto L17;
        r11 = 8197;
        if (r10 != 8197) goto L8;
        return 4100;
    L8:
        if (r10 == 4099) goto L13;
        if (r10 == 4100) goto L17;
        return 0;
    L13:
        return 4099;
    L17:
        return r11;
    L14:
        return 8194;
    }

    public boolean A(MenuItem r10) {
        if (this.f3207u >= 1) goto L5;
        return false;
    L5:
        Iterator r11 = this.f3189c.o().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Fragment r12 = (Fragment) r11.next();
        if (r12 == null) goto L7;
        if (r12.performContextItemSelected(r10) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public r A0() {
        return this.f3200n;
    }

    public void A1() {
        ArrayList r10 = this.f3187a;
        monitor-enter(r10);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f3187a.size() != 1) goto L9;
        this.f3208v.f().removeCallbacks(this.R);     // Catch: Throwable -> L7
        this.f3208v.f().post(this.R);     // Catch: Throwable -> L7
        J1();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L7
    }

    public void B() {
        this.I = false;
        this.f3186J = false;
        this.P.q(false);
        S(1);
    }

    public Fragment B0() {
        return this.f3210x;
    }

    public void B1(Fragment r10, boolean r11) {
        ViewGroup r12 = u0(r10);
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12 instanceof FragmentContainerView) == false) goto L9;
        ((FragmentContainerView) r12).setDrawDisappearingViewsLast(!r11);
        return;
    }

    public boolean C(Menu r10, MenuInflater r11) {
        int r12 = 0;
        if (this.f3207u >= 1) goto L5;
        return false;
    L5:
        Iterator r13 = this.f3189c.o().iterator();
        ArrayList r14 = null;
        boolean r15 = false;
    L7:
        if (r13.hasNext() == false) goto L18;
        Fragment r16 = (Fragment) r13.next();
        if (r16 == null) goto L7;
        if (P0(r16) == false) goto L7;
        if (r16.performCreateOptionsMenu(r10, r11) == false) goto L7;
        if (r14 != null) goto L16;
        r14 = new ArrayList();
    L16:
        r14.add(r16);
        r15 = true;
        goto L7
    L18:
        if (this.f3191e != null) goto L20;
    L27:
        this.f3191e = r14;
        return r15;
    L20:
        if (r12 >= this.f3191e.size()) goto L27;
        Fragment r17 = (Fragment) this.f3191e.get(r12);
        if (r14 != null) goto L24;
    L25:
        r17.onDestroyOptionsMenu();
    L26:
        r12 = r12 + 1;
        goto L20
    L24:
        if (r14.contains(r17) == true) goto L26;
        goto L25
    }

    public Fragment C0() {
        return this.f3211y;
    }

    public void C1(Fragment r10, Lifecycle.State r11) {
        if (r10.equals(f0(r10.mWho)) == false) goto L11;
        if (r10.mHost != null) goto L7;
    L8:
        r10.mMaxState = r11;
        return;
    L7:
        if (r10.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r10 + " is not an active fragment of FragmentManager " + this);
    }

    public void D() {
        this.K = true;
        a0(true);
        X();
        s();
        S(-1);
        Object r10 = this.f3208v;
        if ((r10 instanceof OnTrimMemoryProvider) == false) goto L5;
        ((OnTrimMemoryProvider) r10).removeOnTrimMemoryListener(this.f3203q);
    L5:
        Object r11 = this.f3208v;
        if ((r11 instanceof OnConfigurationChangedProvider) == false) goto L8;
        ((OnConfigurationChangedProvider) r11).removeOnConfigurationChangedListener(this.f3202p);
    L8:
        Object r12 = this.f3208v;
        if ((r12 instanceof OnMultiWindowModeChangedProvider) == false) goto L11;
        ((OnMultiWindowModeChangedProvider) r12).removeOnMultiWindowModeChangedListener(this.f3204r);
    L11:
        Object r13 = this.f3208v;
        if ((r13 instanceof OnPictureInPictureModeChangedProvider) == false) goto L14;
        ((OnPictureInPictureModeChangedProvider) r13).removeOnPictureInPictureModeChangedListener(this.f3205s);
    L14:
        Object r14 = this.f3208v;
        if ((r14 instanceof MenuHost) == true) goto L17;
    L19:
        this.f3208v = null;
        this.f3209w = null;
        this.f3210x = null;
        if (this.f3193g == null) goto L22;
        this.f3194h.f();
        this.f3193g = null;
    L22:
        ActivityResultLauncher r15 = this.D;
        if (r15 == null) goto L26;
        r15.c();
        this.E.c();
        this.F.c();
        return;
    L26:
        return;
    L17:
        if (this.f3210x != null) goto L19;
        ((MenuHost) r14).removeMenuProvider(this.f3206t);
        goto L19
    }

    public SpecialEffectsControllerFactory D0() {
        SpecialEffectsControllerFactory r10 = this.B;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Fragment r11 = this.f3210x;
        if (r11 == null) goto L10;
        return r11.mFragmentManager.D0();
    L10:
        return this.C;
    }

    public void D1(Fragment r10) {
        if (r10 != null) goto L4;
    L12:
        Fragment r11 = this.f3211y;
        this.f3211y = r10;
        L(r11);
        L(this.f3211y);
        return;
    L4:
        if (r10.equals(f0(r10.mWho)) == false) goto L11;
        if (r10.mHost == null) goto L12;
        if (r10.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r10 + " is not an active fragment of FragmentManager " + this);
    }

    public void E() {
        S(1);
    }

    public FragmentStrictMode.a E0() {
        return this.Q;
    }

    public final void E1(Fragment r10) {
        ViewGroup r11 = u0(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if ((((r10.getEnterAnim() + r10.getExitAnim()) + r10.getPopEnterAnim()) + r10.getPopExitAnim()) <= 0) goto L12;
        int r12 = R$id.visible_removing_fragment_view_tag;
        if (r11.getTag(r12) != null) goto L9;
        r11.setTag(r12, r10);
    L9:
        ((Fragment) r11.getTag(r12)).setPopDirection(r10.getPopDirection());
        return;
    }

    public void F(boolean r10) {
        if (r10 == true) goto L4;
    L6:
        Iterator r11 = this.f3189c.o().iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        Fragment r12 = (Fragment) r11.next();
        if (r12 == null) goto L8;
        r12.performLowMemory();
        if (r10 == false) goto L8;
        r12.mChildFragmentManager.F(true);
        goto L8
    L14:
        return;
    L4:
        if ((this.f3208v instanceof OnTrimMemoryProvider) == false) goto L6;
        H1(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        goto L6
    }

    public void F1(Fragment r10) {
        if (L0(2) == false) goto L6;
        Log.v("FragmentManager", "show: " + r10);
    L6:
        if (r10.mHidden == false) goto L9;
        r10.mHidden = false;
        r10.mHiddenChanged = !r10.mHiddenChanged;
        return;
    }

    public void G(boolean r10, boolean r11) {
        if (r11 == true) goto L4;
    L6:
        Iterator r12 = this.f3189c.o().iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        Fragment r13 = (Fragment) r12.next();
        if (r13 == null) goto L8;
        r13.performMultiWindowModeChanged(r10);
        if (r11 == false) goto L8;
        r13.mChildFragmentManager.G(r10, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.f3208v instanceof OnMultiWindowModeChangedProvider) == false) goto L6;
        H1(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        goto L6
    }

    public ViewModelStore G0(Fragment r10) {
        return this.P.n(r10);
    }

    public final void G1() {
        Iterator r10 = this.f3189c.k().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        e1((a0) r10.next());
        goto L4
    }

    public void H(Fragment r10) {
        Iterator r11 = this.f3201o.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((FragmentOnAttachListener) r11.next()).onAttachFragment(this, r10);
        goto L4
    }

    public void H0() {
        a0(true);
        if (this.f3194h.e() == false) goto L5;
        i1();
        return;
    L5:
        this.f3193g.k();
    }

    public final void H1(RuntimeException r10) {
        Log.e("FragmentManager", r10.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter r11 = new PrintWriter(new g0("FragmentManager"));
        FragmentHostCallback r12 = this.f3208v;
        if (r12 == null) goto L15;
        r12.g("  ", null, r11, new String[0]);     // Catch: Exception -> L6
        throw r10;
    L6:
        e = move-exception;
        Log.e("FragmentManager", "Failed dumping state", e);
        throw r10;
    L15:
        W("  ", null, r11, new String[0]);     // Catch: Exception -> L10
        throw r10;
    L10:
        e = move-exception;
        Log.e("FragmentManager", "Failed dumping state", e);
        throw r10;
    }

    public void I() {
        Iterator r10 = this.f3189c.l().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        Fragment r11 = (Fragment) r10.next();
        if (r11 == null) goto L4;
        r11.onHiddenChanged(r11.isHidden());
        r11.mChildFragmentManager.I();
        goto L4
    }

    public void I0(Fragment r10) {
        if (L0(2) == false) goto L6;
        Log.v("FragmentManager", "hide: " + r10);
    L6:
        if (r10.mHidden == true) goto L9;
        r10.mHidden = true;
        r10.mHiddenChanged = true ^ r10.mHiddenChanged;
        E1(r10);
        return;
    }

    public void I1(l r10) {
        this.f3200n.p(r10);
    }

    public boolean J(MenuItem r10) {
        if (this.f3207u >= 1) goto L5;
        return false;
    L5:
        Iterator r11 = this.f3189c.o().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Fragment r12 = (Fragment) r11.next();
        if (r12 == null) goto L7;
        if (r12.performOptionsItemSelected(r10) == false) goto L7;
        return true;
    L13:
        return false;
    }

    public void J0(Fragment r10) {
        if (r10.mAdded == true) goto L5;
        return;
    L5:
        if (M0(r10) == false) goto L9;
        this.H = true;
        return;
    }

    public final void J1() {
        ArrayList r10 = this.f3187a;
        monitor-enter(r10);
        boolean r11 = true;
        if (this.f3187a.isEmpty() == true) goto L11;
        this.f3194h.h(true);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
        androidx.activity.l r12 = this.f3194h;
        if (q0() > 0) goto L15;
    L17:
        r11 = false;
    L18:
        r12.h(r11);
        return;
    L15:
        if (Q0(this.f3210x) == false) goto L17;
    L9:
        th = move-exception;
        throw th;
    }

    public void K(Menu r10) {
        if (this.f3207u >= 1) goto L5;
        return;
    L5:
        Iterator r11 = this.f3189c.o().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        Fragment r12 = (Fragment) r11.next();
        if (r12 == null) goto L7;
        r12.performOptionsMenuClosed(r10);
        goto L7
    }

    public boolean K0() {
        return this.K;
    }

    public final void L(Fragment r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.equals(f0(r10.mWho)) == false) goto L8;
        r10.performPrimaryNavigationFragmentChanged();
        return;
    }

    public void M() {
        S(5);
    }

    public final boolean M0(Fragment r10) {
        if (r10.mHasMenu == false) goto L7;
        if (r10.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r10.mChildFragmentManager.p() == true) goto L8;
        return false;
    }

    public void N(boolean r10, boolean r11) {
        if (r11 == true) goto L4;
    L6:
        Iterator r12 = this.f3189c.o().iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        Fragment r13 = (Fragment) r12.next();
        if (r13 == null) goto L8;
        r13.performPictureInPictureModeChanged(r10);
        if (r11 == false) goto L8;
        r13.mChildFragmentManager.N(r10, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.f3208v instanceof OnPictureInPictureModeChangedProvider) == false) goto L6;
        H1(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        goto L6
    }

    public final boolean N0() {
        Fragment r10 = this.f3210x;
        if (r10 != null) goto L6;
        return true;
    L6:
        if (r10.isAdded() == true) goto L8;
    L10:
        return false;
    L8:
        if (this.f3210x.getParentFragmentManager().N0() == false) goto L10;
        return true;
    }

    public boolean O(Menu r10) {
        boolean r11 = false;
        if (this.f3207u >= 1) goto L5;
        return false;
    L5:
        Iterator r12 = this.f3189c.o().iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        Fragment r13 = (Fragment) r12.next();
        if (r13 == null) goto L7;
        if (P0(r13) == false) goto L7;
        if (r13.performPrepareOptionsMenu(r10) == false) goto L7;
        r11 = true;
        goto L7
    L15:
        return r11;
    }

    public boolean O0(Fragment r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.isHidden();
    }

    public void P() {
        J1();
        L(this.f3211y);
    }

    public boolean P0(Fragment r10) {
        if (r10 != null) goto L6;
        return true;
    L6:
        return r10.isMenuVisible();
    }

    public void Q() {
        this.I = false;
        this.f3186J = false;
        this.P.q(false);
        S(7);
    }

    public boolean Q0(Fragment r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        FragmentManager r11 = r10.mFragmentManager;
        if (r10.equals(r11.C0()) == true) goto L8;
    L10:
        return false;
    L8:
        if (Q0(r11.f3210x) == false) goto L10;
        return true;
    }

    public void R() {
        this.I = false;
        this.f3186J = false;
        this.P.q(false);
        S(5);
    }

    public boolean R0(int r10) {
        if (this.f3207u < r10) goto L5;
        return true;
    L5:
        return false;
    }

    public final void S(int r10) {
        this.f3188b = true;     // Catch: Throwable -> L8
        this.f3189c.d(r10);     // Catch: Throwable -> L8
        b1(r10, false);     // Catch: Throwable -> L8
        Iterator r11 = t().iterator();     // Catch: Throwable -> L8
    L5:
        if (r11.hasNext() == false) goto L10;
        ((SpecialEffectsController) r11.next()).n();     // Catch: Throwable -> L8
        goto L5
    L10:
        this.f3188b = false;
        a0(true);
        return;
    L8:
        th = move-exception;
        this.f3188b = false;
        throw th;
    }

    public boolean S0() {
        if (this.I == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f3186J == true) goto L8;
        return false;
    }

    public void T() {
        this.f3186J = true;
        this.P.q(true);
        S(4);
    }

    public final /* synthetic */ Bundle T0() {
        return w1();
    }

    public void U() {
        S(2);
    }

    public final /* synthetic */ void U0(Configuration r10) {
        if (N0() == false) goto L6;
        z(r10, false);
        return;
    }

    public final void V() {
        if (this.L == false) goto L6;
        this.L = false;
        G1();
        return;
    }

    public final /* synthetic */ void V0(Integer r10) {
        if (N0() == true) goto L5;
        return;
    L5:
        if (r10.intValue() != 80) goto L9;
        F(false);
        return;
    }

    public void W(String r10, FileDescriptor r11, PrintWriter r12, String[] r13) {
        String r14 = r10 + "    ";
        this.f3189c.e(r10, r11, r12, r13);
        ArrayList r15 = this.f3191e;
        int r16 = 0;
        if (r15 == null) goto L9;
        int r17 = r15.size();
        if (r17 <= 0) goto L9;
        r12.print(r10);
        r12.println("Fragments Created Menus:");
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L9;
        Fragment r19 = (Fragment) this.f3191e.get(r18);
        r12.print(r10);
        r12.print("  #");
        r12.print(r18);
        r12.print(": ");
        r12.println(r19.toString());
        r18 = r18 + 1;
    L9:
        ArrayList r20 = this.f3190d;
        if (r20 == null) goto L16;
        int r21 = r20.size();
        if (r21 <= 0) goto L16;
        r12.print(r10);
        r12.println("Back Stack:");
        int r22 = 0;
    L14:
        if (r22 >= r21) goto L16;
        androidx.fragment.app.a r23 = (androidx.fragment.app.a) this.f3190d.get(r22);
        r12.print(r10);
        r12.print("  #");
        r12.print(r22);
        r12.print(": ");
        r12.println(r23.toString());
        r23.E(r14, r12);
        r22 = r22 + 1;
    L16:
        r12.print(r10);
        r12.println("Back Stack Index: " + this.f3195i.get());
        ArrayList r24 = this.f3187a;
        monitor-enter(r24);
        int r25 = this.f3187a.size();     // Catch: Throwable -> L23
        if (r25 <= 0) goto L25;
        r12.print(r10);     // Catch: Throwable -> L23
        r12.println("Pending Actions:");     // Catch: Throwable -> L23
    L21:
        if (r16 >= r25) goto L25;
        OpGenerator r26 = (OpGenerator) this.f3187a.get(r16);     // Catch: Throwable -> L23
        r12.print(r10);     // Catch: Throwable -> L23
        r12.print("  #");     // Catch: Throwable -> L23
        r12.print(r16);     // Catch: Throwable -> L23
        r12.print(": ");     // Catch: Throwable -> L23
        r12.println(r26);     // Catch: Throwable -> L23
        r16 = r16 + 1;     // Catch: Throwable -> L23
    L25:
        monitor-exit(r24);     // Catch: Throwable -> L23
        r12.print(r10);
        r12.println("FragmentManager misc state:");
        r12.print(r10);
        r12.print("  mHost=");
        r12.println(this.f3208v);
        r12.print(r10);
        r12.print("  mContainer=");
        r12.println(this.f3209w);
        if (this.f3210x == null) goto L29;
        r12.print(r10);
        r12.print("  mParent=");
        r12.println(this.f3210x);
    L29:
        r12.print(r10);
        r12.print("  mCurState=");
        r12.print(this.f3207u);
        r12.print(" mStateSaved=");
        r12.print(this.I);
        r12.print(" mStopped=");
        r12.print(this.f3186J);
        r12.print(" mDestroyed=");
        r12.println(this.K);
        if (this.H == false) goto L40;
        r12.print(r10);
        r12.print("  mNeedMenuInvalidate=");
        r12.println(this.H);
        return;
    L40:
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final /* synthetic */ void W0(androidx.core.app.e r10) {
        if (N0() == false) goto L6;
        G(r10.a(), false);
        return;
    }

    public final void X() {
        Iterator r10 = t().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((SpecialEffectsController) r10.next()).n();
        goto L4
    }

    public final /* synthetic */ void X0(androidx.core.app.k r10) {
        if (N0() == false) goto L6;
        N(r10.a(), false);
        return;
    }

    public void Y(OpGenerator r10, boolean r11) {
        if (r11 == false) goto L4;
    L12:
        ArrayList r12 = this.f3187a;
        monitor-enter(r12);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.f3208v != null) goto L23;
        if (r11 == false) goto L22;
        monitor-exit(r12);     // Catch: Throwable -> L19
        return;
    L22:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L19
    L23:
        this.f3187a.add(r10);     // Catch: Throwable -> L19
        A1();     // Catch: Throwable -> L19
        monitor-exit(r12);     // Catch: Throwable -> L19
        return;
    L4:
        if (this.f3208v == null) goto L6;
        q();
        goto L12
    L6:
        if (this.K == false) goto L10;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L10:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    public void Y0(Fragment r10, String[] r11, int r12) {
        if (this.F == null) goto L5;
        LaunchedFragmentInfo r13 = new LaunchedFragmentInfo(r10.mWho, r12);
        this.G.addLast(r13);
        this.F.a(r11);
        return;
    L5:
        this.f3208v.j(r10, r11, r12);
    }

    public final void Z(boolean r10) {
        if (this.f3188b == true) goto L23;
        if (this.f3208v != null) goto L13;
        if (this.K == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.f3208v.f().getLooper()) goto L21;
        if (r10 == true) goto L17;
        q();
    L17:
        if (this.M != null) goto L24;
        this.M = new ArrayList();
        this.N = new ArrayList();
        return;
    L24:
        return;
    L21:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L23:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public void Z0(Fragment r10, Intent r11, int r12, Bundle r13) {
        if (this.D == null) goto L8;
        LaunchedFragmentInfo r14 = new LaunchedFragmentInfo(r10.mWho, r12);
        this.G.addLast(r14);
        if (r13 == null) goto L7;
        r11.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r13);
    L7:
        this.D.a(r11);
        return;
    L8:
        this.f3208v.l(r10, r11, r12, r13);
    }

    public boolean a0(boolean r10) {
        Z(r10);
        boolean r11 = false;
    L4:
        if (o0(this.M, this.N) == false) goto L11;
        r11 = true;
        this.f3188b = true;
        p1(this.M, this.N);     // Catch: Throwable -> L8
        r();
    L8:
        th = move-exception;
        r();
        throw th;
    L11:
        J1();
        V();
        this.f3189c.b();
        return r11;
    }

    public void a1(Fragment r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) {
        if (this.E != null) goto L5;
        this.f3208v.m(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        if (r18 == null) goto L13;
        if (r14 != null) goto L8;
        Intent r10 = new Intent();
        r10.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
    L10:
        if (L0(2) == false) goto L12;
        Log.v("FragmentManager", "ActivityOptions " + r18 + " were added to fillInIntent " + r10 + " for fragment " + r11);
    L12:
        r10.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r18);
    L14:
        IntentSenderRequest r19 = new IntentSenderRequest.Builder(r12).b(r10).c(r16, r15).a();
        this.G.addLast(new LaunchedFragmentInfo(r11.mWho, r13));
        if (L0(2) == false) goto L17;
        Log.v("FragmentManager", "Fragment " + r11 + "is launching an IntentSender for result ");
    L17:
        this.E.a(r19);
        return;
    L8:
        r10 = r14;
        goto L10
    L13:
        r10 = r14;
        goto L14
    }

    public void addFragmentOnAttachListener(@NonNull FragmentOnAttachListener r10) {
        this.f3201o.add(r10);
    }

    public void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener r10) {
        if (this.f3199m != null) goto L5;
        this.f3199m = new ArrayList();
    L5:
        this.f3199m.add(r10);
    }

    public void b0(OpGenerator r10, boolean r11) {
        if (r11 == true) goto L4;
    L8:
        Z(r11);
        if (r10.generateOps(this.M, this.N) == false) goto L16;
        this.f3188b = true;
        p1(this.M, this.N);     // Catch: Throwable -> L13
        r();
    L13:
        th = move-exception;
        r();
        throw th;
    L16:
        J1();
        V();
        this.f3189c.b();
        return;
    L4:
        if (this.f3208v != null) goto L6;
        return;
    L6:
        if (this.K == false) goto L8;
    }

    public void b1(int r10, boolean r11) {
        if (this.f3208v == null) goto L5;
    L9:
        if (r11 == false) goto L11;
    L13:
        this.f3207u = r10;
        this.f3189c.t();
        G1();
        if (this.H == false) goto L21;
        FragmentHostCallback r12 = this.f3208v;
        if (r12 != null) goto L18;
        return;
    L18:
        if (this.f3207u != 7) goto L23;
        r12.n();
        this.H = false;
        return;
    L23:
        return;
    L21:
        return;
    L11:
        if (r10 != this.f3207u) goto L13;
        return;
    L5:
        if (r10 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    public void c1() {
        if (this.f3208v != null) goto L5;
        return;
    L5:
        this.I = false;
        this.f3186J = false;
        this.P.q(false);
        Iterator r10 = this.f3189c.o().iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        Fragment r11 = (Fragment) r10.next();
        if (r11 == null) goto L7;
        r11.noteStateNotSaved();
        goto L7
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResult(String r10) {
        this.f3197k.remove(r10);
        if (L0(2) == false) goto L6;
        Log.v("FragmentManager", "Clearing fragment result with key " + r10);
        return;
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void clearFragmentResultListener(String r10) {
        m r11 = (m) this.f3198l.remove(r10);
        if (r11 == null) goto L6;
        r11.b();
    L6:
        if (L0(2) == false) goto L9;
        Log.v("FragmentManager", "Clearing FragmentResultListener for key " + r10);
        return;
    }

    public final void d0(ArrayList r10, ArrayList r11, int r12, int r13) {
        boolean r14 = ((androidx.fragment.app.a) r10.get(r12)).f3260r;
        ArrayList r15 = this.O;
        if (r15 != null) goto L5;
        this.O = new ArrayList();
    L6:
        this.O.addAll(this.f3189c.o());
        Fragment r16 = C0();
        int r17 = r12;
        boolean r18 = false;
    L8:
        if (r17 >= r13) goto L20;
        androidx.fragment.app.a r19 = (androidx.fragment.app.a) r10.get(r17);
        if (((Boolean) r11.get(r17)).booleanValue() == true) goto L12;
        r16 = r19.I(this.O, r16);
    L13:
        if (r18 == false) goto L15;
    L18:
        r18 = true;
    L19:
        r17 = r17 + 1;
        goto L8
    L15:
        if (r19.f3251i == true) goto L18;
        r18 = false;
        goto L19
    L12:
        r16 = r19.K(this.O, r16);
        goto L13
    L20:
        this.O.clear();
        if (r14 == false) goto L23;
    L35:
        c0(r10, r11, r12, r13);
        boolean r20 = ((Boolean) r11.get(r13 - 1)).booleanValue();
        if (r18 == false) goto L59;
        ArrayList r21 = this.f3199m;
        if (r21 == null) goto L59;
        if (r21.isEmpty() == true) goto L59;
        LinkedHashSet r22 = new LinkedHashSet();
        Iterator r23 = r10.iterator();
    L43:
        if (r23.hasNext() == false) goto L45;
        r22.addAll(n0((androidx.fragment.app.a) r23.next()));
        goto L43
    L45:
        Iterator r24 = this.f3199m.iterator();
    L47:
        if (r24.hasNext() == false) goto L52;
        OnBackStackChangedListener r25 = (OnBackStackChangedListener) r24.next();
        Iterator r26 = r22.iterator();
    L50:
        if (r26.hasNext() == false) goto L47;
        r25.onBackStackChangeStarted((Fragment) r26.next(), r20);
        goto L50
    L52:
        Iterator r27 = this.f3199m.iterator();
    L54:
        if (r27.hasNext() == false) goto L59;
        OnBackStackChangedListener r28 = (OnBackStackChangedListener) r27.next();
        Iterator r29 = r22.iterator();
    L57:
        if (r29.hasNext() == false) goto L54;
        r28.onBackStackChangeCommitted((Fragment) r29.next(), r20);
    L59:
        int r30 = r12;
    L60:
        if (r30 >= r13) goto L76;
        androidx.fragment.app.a r31 = (androidx.fragment.app.a) r10.get(r30);
        if (r20 == false) goto L69;
        int r32 = r31.f3245c.size() - 1;
    L64:
        if (r32 < 0) goto L75;
        Fragment r33 = ((FragmentTransaction.a) r31.f3245c.get(r32)).f3263b;
        if (r33 == null) goto L68;
        v(r33).m();
    L68:
        r32 = r32 - 1;
    L75:
        r30 = r30 + 1;
        goto L60
    L69:
        Iterator r34 = r31.f3245c.iterator();
    L71:
        if (r34.hasNext() == false) goto L75;
        Fragment r35 = ((FragmentTransaction.a) r34.next()).f3263b;
        if (r35 == null) goto L71;
        v(r35).m();
        goto L71
    L76:
        b1(this.f3207u, true);
        Iterator r36 = u(r10, r12, r13).iterator();
    L78:
        if (r36.hasNext() == false) goto L80;
        SpecialEffectsController r37 = (SpecialEffectsController) r36.next();
        r37.v(r20);
        r37.t();
        r37.k();
    L80:
        if (r12 >= r13) goto L87;
        androidx.fragment.app.a r38 = (androidx.fragment.app.a) r10.get(r12);
        if (((Boolean) r11.get(r12)).booleanValue() == false) goto L86;
        if (r38.f3296v < 0) goto L86;
        r38.f3296v = -1;
    L86:
        r38.J();
        r12 = r12 + 1;
        goto L80
    L87:
        if (r18 == false) goto L120;
        r1();
        return;
    L120:
        return;
    L23:
        if (this.f3207u < 1) goto L35;
        int r39 = r12;
    L25:
        if (r39 >= r13) goto L35;
        Iterator r40 = ((androidx.fragment.app.a) r10.get(r39)).f3245c.iterator();
    L28:
        if (r40.hasNext() == false) goto L34;
        Fragment r41 = ((FragmentTransaction.a) r40.next()).f3263b;
        if (r41 == null) goto L28;
        if (r41.mFragmentManager == null) goto L28;
        this.f3189c.r(v(r41));
        goto L28
    L34:
        r39 = r39 + 1;
        goto L25
    L5:
        r15.clear();
        goto L6
    }

    public void d1(FragmentContainerView r10) {
        Iterator r11 = this.f3189c.k().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        a0 r12 = (a0) r11.next();
        Fragment r13 = r12.k();
        if (r13.mContainerId != r10.getId()) goto L4;
        View r14 = r13.mView;
        if (r14 == null) goto L4;
        if (r14.getParent() != null) goto L4;
        r13.mContainer = r10;
        r12.b();
        goto L4
    }

    public boolean e0() {
        boolean r10 = a0(true);
        m0();
        return r10;
    }

    public void e1(a0 r10) {
        Fragment r11 = r10.k();
        if (r11.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.f3188b == false) goto L8;
        this.L = true;
        return;
    L8:
        r11.mDeferStart = false;
        r10.m();
    }

    public Fragment f0(String r10) {
        return this.f3189c.f(r10);
    }

    public void f1() {
        Y(new n(this, null, -1, 0), false);
    }

    public final int g0(String r10, int r11, boolean r12) {
        ArrayList r13 = this.f3190d;
        if (r13 != null) goto L5;
    L43:
        return -1;
    L5:
        if (r13.isEmpty() == true) goto L43;
        if (r10 != null) goto L14;
        if (r11 >= 0) goto L14;
        if (r12 == false) goto L13;
        return 0;
    L13:
        return this.f3190d.size() - 1;
    L14:
        int r14 = this.f3190d.size() - 1;
    L15:
        if (r14 < 0) goto L26;
        androidx.fragment.app.a r15 = (androidx.fragment.app.a) this.f3190d.get(r14);
        if (r10 != null) goto L19;
    L21:
        if (r11 < 0) goto L25;
        if (r11 == r15.f3296v) goto L26;
    L25:
        r14 = r14 - 1;
        goto L15
    L19:
        if (r10.equals(r15.getName()) == false) goto L21;
    L26:
        if (r14 >= 0) goto L28;
        return r14;
    L28:
        if (r12 == false) goto L39;
    L29:
        if (r14 <= 0) goto L56;
        androidx.fragment.app.a r16 = (androidx.fragment.app.a) this.f3190d.get(r14 - 1);
        if (r10 != null) goto L33;
    L34:
        if (r11 < 0) goto L54;
        if (r11 == r16.f3296v) goto L37;
        return r14;
    L37:
        r14 = r14 - 1;
        goto L29
    L54:
        return r14;
    L33:
        if (r10.equals(r16.getName()) == true) goto L37;
    L56:
        return r14;
    L39:
        if (r14 != (this.f3190d.size() - 1)) goto L42;
        return -1;
    L42:
        return r14 + 1;
    }

    public void g1(int r10, int r11, boolean r12) {
        if (r10 < 0) goto L6;
        Y(new n(this, null, r10, r11), r12);
        return;
    L6:
        throw new IllegalArgumentException("Bad id: " + r10);
    }

    public Fragment h0(int r10) {
        return this.f3189c.g(r10);
    }

    public void h1(String r10, int r11) {
        Y(new n(this, r10, -1, r11), false);
    }

    public void i(androidx.fragment.app.a r10) {
        if (this.f3190d != null) goto L5;
        this.f3190d = new ArrayList();
    L5:
        this.f3190d.add(r10);
    }

    public Fragment i0(String r10) {
        return this.f3189c.h(r10);
    }

    public boolean i1() {
        return k1(null, -1, 0);
    }

    public a0 j(Fragment r10) {
        String r11 = r10.mPreviousWho;
        if (r11 == null) goto L6;
        FragmentStrictMode.h(r10, r11);
    L6:
        if (L0(2) == false) goto L8;
        Log.v("FragmentManager", "add: " + r10);
    L8:
        a0 r12 = v(r10);
        r10.mFragmentManager = this;
        this.f3189c.r(r12);
        if (r10.mDetached == true) goto L16;
        this.f3189c.a(r10);
        r10.mRemoving = false;
        if (r10.mView != null) goto L14;
        r10.mHiddenChanged = false;
    L14:
        if (M0(r10) == false) goto L16;
        this.H = true;
    L16:
        return r12;
    }

    public Fragment j0(String r10) {
        return this.f3189c.i(r10);
    }

    public boolean j1(int r10, int r11) {
        if (r10 < 0) goto L6;
        return k1(null, r10, r11);
    L6:
        throw new IllegalArgumentException("Bad id: " + r10);
    }

    public void k(Fragment r10) {
        this.P.f(r10);
    }

    public final boolean k1(String r10, int r11, int r12) {
        a0(false);
        Z(true);
        Fragment r13 = this.f3211y;
        if (r13 == null) goto L9;
        if (r11 >= 0) goto L9;
        if (r10 != null) goto L9;
        if (r13.getChildFragmentManager().i1() == false) goto L9;
        return true;
    L9:
        boolean r14 = l1(this.M, this.N, r10, r11, r12);
        if (r14 == false) goto L17;
        this.f3188b = true;
        p1(this.M, this.N);     // Catch: Throwable -> L14
        r();
    L14:
        th = move-exception;
        r();
        throw th;
    L17:
        J1();
        V();
        this.f3189c.b();
        return r14;
    }

    public int l() {
        return this.f3195i.getAndIncrement();
    }

    public boolean l1(ArrayList r10, ArrayList r11, String r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        boolean r15 = true;
    L6:
        int r16 = g0(r12, r13, r15);
        if (r16 >= 0) goto L9;
        return false;
    L9:
        int r17 = this.f3190d.size() - 1;
    L10:
        if (r17 < r16) goto L12;
        r10.add((androidx.fragment.app.a) this.f3190d.remove(r17));
        r11.add(Boolean.TRUE);
        r17 = r17 - 1;
        goto L10
    L12:
        return true;
    L5:
        r15 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void m(FragmentHostCallback r10, FragmentContainer r11, Fragment r12) {
        if (this.f3208v != null) goto L56;
        this.f3208v = r10;
        this.f3209w = r11;
        this.f3210x = r12;
        if (r12 == null) goto L8;
        addFragmentOnAttachListener(new h(this, r12));
    L11:
        if (this.f3210x == null) goto L14;
        J1();
    L14:
        if ((r10 instanceof OnBackPressedDispatcherOwner) == false) goto L19;
        OnBackPressedDispatcherOwner r13 = (OnBackPressedDispatcherOwner) r10;
        OnBackPressedDispatcher r14 = r13.getOnBackPressedDispatcher();
        this.f3193g = r14;
        LifecycleOwner r15 = r13;
        if (r12 == null) goto L18;
        r15 = r12;
    L18:
        r14.h(r15, this.f3194h);
    L19:
        if (r12 == null) goto L22;
        this.P = r12.mFragmentManager.r0(r12);
    L25:
        this.P.q(S0());
        this.f3189c.A(this.P);
        Object r16 = this.f3208v;
        if ((r16 instanceof SavedStateRegistryOwner) == false) goto L31;
        if (r12 != null) goto L31;
        SavedStateRegistry r17 = ((SavedStateRegistryOwner) r16).getSavedStateRegistry();
        r17.h("android:support:fragments", new w(this));
        Bundle r18 = r17.b("android:support:fragments");
        if (r18 == null) goto L31;
        u1(r18);
    L31:
        Object r19 = this.f3208v;
        if ((r19 instanceof ActivityResultRegistryOwner) == false) goto L38;
        ActivityResultRegistry r20 = ((ActivityResultRegistryOwner) r19).getActivityResultRegistry();
        if (r12 == null) goto L36;
        String r21 = r12.mWho + ":";
    L37:
        String r22 = "FragmentManager:" + r21;
        this.D = r20.i(r22 + "StartActivityForResult", new b.a(), new i(this));
        this.E = r20.i(r22 + "StartIntentSenderForResult", new k(), new j(this));
        this.F = r20.i(r22 + "RequestPermissions", new androidx.activity.result.contract.a(), new a(this));
        goto L38
    L36:
        r21 = "";
    L38:
        Object r23 = this.f3208v;
        if ((r23 instanceof OnConfigurationChangedProvider) == false) goto L41;
        ((OnConfigurationChangedProvider) r23).addOnConfigurationChangedListener(this.f3202p);
    L41:
        Object r24 = this.f3208v;
        if ((r24 instanceof OnTrimMemoryProvider) == false) goto L44;
        ((OnTrimMemoryProvider) r24).addOnTrimMemoryListener(this.f3203q);
    L44:
        Object r25 = this.f3208v;
        if ((r25 instanceof OnMultiWindowModeChangedProvider) == false) goto L47;
        ((OnMultiWindowModeChangedProvider) r25).addOnMultiWindowModeChangedListener(this.f3204r);
    L47:
        Object r26 = this.f3208v;
        if ((r26 instanceof OnPictureInPictureModeChangedProvider) == false) goto L50;
        ((OnPictureInPictureModeChangedProvider) r26).addOnPictureInPictureModeChangedListener(this.f3205s);
    L50:
        Object r27 = this.f3208v;
        if ((r27 instanceof MenuHost) == false) goto L57;
        if (r12 != null) goto L58;
        ((MenuHost) r27).addMenuProvider(this.f3206t);
        return;
    L58:
        return;
    L57:
        return;
    L22:
        if ((r10 instanceof ViewModelStoreOwner) == false) goto L24;
        this.P = y.l(((ViewModelStoreOwner) r10).getViewModelStore());
        goto L25
    L24:
        this.P = new y(false);
        goto L25
    L8:
        if ((r10 instanceof FragmentOnAttachListener) == false) goto L11;
        addFragmentOnAttachListener((FragmentOnAttachListener) r10);
        goto L11
    L56:
        throw new IllegalStateException("Already attached");
    }

    public final void m0() {
        Iterator r10 = t().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((SpecialEffectsController) r10.next()).o();
        goto L4
    }

    public void m1(Bundle r10, String r11, Fragment r12) {
        if (r12.mFragmentManager == this) goto L5;
        H1(new IllegalStateException("Fragment " + r12 + " is not currently in the FragmentManager"));
    L5:
        r10.putString(r11, r12.mWho);
    }

    public void n(Fragment r10) {
        if (L0(2) == false) goto L6;
        Log.v("FragmentManager", "attach: " + r10);
    L6:
        if (r10.mDetached == false) goto L16;
        r10.mDetached = false;
        if (r10.mAdded == true) goto L17;
        this.f3189c.a(r10);
        if (L0(2) == false) goto L13;
        Log.v("FragmentManager", "add from attach: " + r10);
    L13:
        if (M0(r10) == false) goto L18;
        this.H = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    public final Set n0(androidx.fragment.app.a r10) {
        HashSet r11 = new HashSet();
        int r12 = 0;
    L4:
        if (r12 >= r10.f3245c.size()) goto L11;
        Fragment r13 = ((FragmentTransaction.a) r10.f3245c.get(r12)).f3263b;
        if (r13 == null) goto L10;
        if (r10.f3251i == false) goto L10;
        r11.add(r13);
    L10:
        r12 = r12 + 1;
        goto L4
    L11:
        return r11;
    }

    public void n1(l r10, boolean r11) {
        this.f3200n.o(r10, r11);
    }

    public FragmentTransaction o() {
        return new androidx.fragment.app.a(this);
    }

    public final boolean o0(ArrayList r10, ArrayList r11) {
        ArrayList r12 = this.f3187a;
        monitor-enter(r12);
        int r13 = 0;
        if (this.f3187a.isEmpty() == false) goto L23;
        monitor-exit(r12);     // Catch: Throwable -> L8
        return false;
    L23:
        int r14 = this.f3187a.size();     // Catch: Throwable -> L14
        boolean r15 = false;
    L11:
        if (r13 >= r14) goto L16;
        r15 = r15 | ((OpGenerator) this.f3187a.get(r13)).generateOps(r10, r11);
        r13 = r13 + 1;
        goto L11
    L16:
        this.f3187a.clear();     // Catch: Throwable -> L8
        this.f3208v.f().removeCallbacks(this.R);     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
        return r15;
    L14:
        th = move-exception;
        this.f3187a.clear();     // Catch: Throwable -> L8
        this.f3208v.f().removeCallbacks(this.R);     // Catch: Throwable -> L8
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void o1(Fragment r10) {
        if (L0(2) == false) goto L5;
        Log.v("FragmentManager", "remove: " + r10 + " nesting=" + r10.mBackStackNesting);
    L5:
        boolean r11 = r10.isInBackStack();
        if (r10.mDetached == false) goto L8;
        if (r11 == false) goto L8;
        return;
    L8:
        this.f3189c.u(r10);
        if (M0(r10) == false) goto L11;
        this.H = true;
    L11:
        r10.mRemoving = true;
        E1(r10);
    }

    public boolean p() {
        Iterator r10 = this.f3189c.l().iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L11;
        Fragment r12 = (Fragment) r10.next();
        if (r12 == null) goto L8;
        r11 = M0(r12);
    L8:
        if (r11 == false) goto L4;
        return true;
    L11:
        return false;
    }

    public List p0() {
        return this.f3189c.l();
    }

    public final void p1(ArrayList r10, ArrayList r11) {
        if (r10.isEmpty() == false) goto L6;
        return;
    L6:
        if (r10.size() != r11.size()) goto L27;
        int r12 = r10.size();
        int r13 = 0;
        int r14 = 0;
    L8:
        if (r13 >= r12) goto L23;
        if (((androidx.fragment.app.a) r10.get(r13)).f3260r == true) goto L22;
        if (r14 == r13) goto L13;
        d0(r10, r11, r14, r13);
    L13:
        r14 = r13 + 1;
        if (((Boolean) r11.get(r13)).booleanValue() == false) goto L21;
    L15:
        if (r14 >= r12) goto L21;
        if (((Boolean) r11.get(r14)).booleanValue() == false) goto L21;
        if (((androidx.fragment.app.a) r10.get(r14)).f3260r == true) goto L21;
        r14 = r14 + 1;
    L21:
        d0(r10, r11, r13, r14);
        r13 = r14 - 1;
    L22:
        r13 = r13 + 1;
        goto L8
    L23:
        if (r14 == r12) goto L34;
        d0(r10, r11, r14, r12);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    public final void q() {
        if (S0() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public int q0() {
        ArrayList r10 = this.f3190d;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.size();
    }

    public void q1(Fragment r10) {
        this.P.p(r10);
    }

    public final void r() {
        this.f3188b = false;
        this.N.clear();
        this.M.clear();
    }

    public final y r0(Fragment r10) {
        return this.P.k(r10);
    }

    public final void r1() {
        if (this.f3199m == null) goto L8;
        int r10 = 0;
    L6:
        if (r10 >= this.f3199m.size()) goto L10;
        ((OnBackStackChangedListener) this.f3199m.get(r10)).onBackStackChanged();
        r10 = r10 + 1;
        goto L6
    L10:
        return;
    }

    public void removeFragmentOnAttachListener(@NonNull FragmentOnAttachListener r10) {
        this.f3201o.remove(r10);
    }

    public void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener r10) {
        ArrayList r11 = this.f3199m;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    public final void s() {
        FragmentHostCallback r10 = this.f3208v;
        if ((r10 instanceof ViewModelStoreOwner) == false) goto L6;
        boolean r11 = this.f3189c.p().o();
    L9:
        if (r11 == false) goto L17;
        Iterator r12 = this.f3196j.values().iterator();
    L12:
        if (r12.hasNext() == false) goto L20;
        Iterator<String> r13 = ((BackStackState) r12.next()).mFragments.iterator();
    L15:
        if (r13.hasNext() == false) goto L12;
        this.f3189c.p().h(r13.next(), false);
        goto L15
    L20:
        return;
    L17:
        return;
    L6:
        if ((r10.e() instanceof Activity) == false) goto L8;
        r11 = !((Activity) this.f3208v.e()).isChangingConfigurations();
        goto L9
    L8:
        r11 = true;
        goto L9
    }

    public FragmentContainer s0() {
        return this.f3209w;
    }

    public void s1(String r10) {
        Y(new o(this, r10), false);
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResult(String r10, Bundle r11) {
        m r12 = (m) this.f3198l.get(r10);
        if (r12 != null) goto L5;
    L7:
        this.f3197k.put(r10, r11);
    L9:
        if (L0(2) == false) goto L12;
        Log.v("FragmentManager", "Setting fragment result with key " + r10 + " and result " + r11);
        return;
    L12:
        return;
    L5:
        if (r12.a(Lifecycle.State.STARTED) == false) goto L7;
        r12.onFragmentResult(r10, r11);
        goto L9
    }

    @Override // androidx.fragment.app.FragmentResultOwner
    public final void setFragmentResultListener(String r10, LifecycleOwner r11, FragmentResultListener r12) {
        Lifecycle r13 = r11.getLifecycle();
        if (r13.b() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        g r14 = new g(this, r10, r12, r13);
        m r15 = (m) this.f3198l.put(r10, new m(r13, r12, r14));
        if (r15 == null) goto L9;
        r15.b();
    L9:
        if (L0(2) == false) goto L11;
        Log.v("FragmentManager", "Setting FragmentResultListener with key " + r10 + " lifecycleOwner " + r13 + " and listener " + r12);
    L11:
        r13.a(r14);
    }

    public final Set t() {
        HashSet r10 = new HashSet();
        Iterator r11 = this.f3189c.k().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ViewGroup r12 = ((a0) r11.next()).k().mContainer;
        if (r12 == null) goto L4;
        r10.add(SpecialEffectsController.s(r12, D0()));
        goto L4
    L8:
        return r10;
    }

    public Fragment t0(Bundle r10, String r11) {
        String r12 = r10.getString(r11);
        if (r12 != null) goto L6;
        return null;
    L6:
        Fragment r13 = f0(r12);
        if (r13 != null) goto L9;
        H1(new IllegalStateException("Fragment no longer exists for key " + r11 + ": unique id " + r12));
    L9:
        return r13;
    }

    public boolean t1(ArrayList r10, ArrayList r11, String r12) {
        BackStackState r13 = (BackStackState) this.f3196j.remove(r12);
        if (r13 != null) goto L5;
        return false;
    L5:
        HashMap r14 = new HashMap();
        Iterator r15 = r10.iterator();
    L7:
        if (r15.hasNext() == false) goto L16;
        androidx.fragment.app.a r16 = (androidx.fragment.app.a) r15.next();
        if (r16.f3297w == false) goto L7;
        Iterator r17 = r16.f3245c.iterator();
    L12:
        if (r17.hasNext() == false) goto L7;
        Fragment r18 = ((FragmentTransaction.a) r17.next()).f3263b;
        if (r18 == null) goto L12;
        r14.put(r18.mWho, r18);
        goto L12
    L16:
        Iterator<androidx.fragment.app.a> r19 = r13.instantiate(this, r14).iterator();
    L17:
        boolean r20 = false;
    L19:
        if (r19.hasNext() == false) goto L24;
        if (r19.next().generateOps(r10, r11) == true) goto L23;
        if (r20 == false) goto L17;
    L23:
        r20 = true;
        goto L19
    L24:
        return r20;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(128);
        r10.append("FragmentManager{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append(" in ");
        Fragment r11 = this.f3210x;
        if (r11 == null) goto L5;
        r10.append(r11.getClass().getSimpleName());
        r10.append("{");
        r10.append(Integer.toHexString(System.identityHashCode(this.f3210x)));
        r10.append("}");
    L9:
        r10.append("}}");
        return r10.toString();
    L5:
        FragmentHostCallback r12 = this.f3208v;
        if (r12 == null) goto L8;
        r10.append(r12.getClass().getSimpleName());
        r10.append("{");
        r10.append(Integer.toHexString(System.identityHashCode(this.f3208v)));
        r10.append("}");
        goto L9
    L8:
        r10.append("null");
        goto L9
    }

    public final Set u(ArrayList r10, int r11, int r12) {
        HashSet r13 = new HashSet();
    L3:
        if (r11 >= r12) goto L13;
        Iterator r14 = ((androidx.fragment.app.a) r10.get(r11)).f3245c.iterator();
    L6:
        if (r14.hasNext() == false) goto L12;
        Fragment r15 = ((FragmentTransaction.a) r14.next()).f3263b;
        if (r15 == null) goto L6;
        ViewGroup r16 = r15.mContainer;
        if (r16 == null) goto L6;
        r13.add(SpecialEffectsController.r(r16, this));
        goto L6
    L12:
        r11 = r11 + 1;
        goto L3
    L13:
        return r13;
    }

    public final ViewGroup u0(Fragment r10) {
        ViewGroup r11 = r10.mContainer;
        if (r11 == null) goto L6;
        return r11;
    L6:
        if (r10.mContainerId > 0) goto L9;
        return null;
    L9:
        if (this.f3209w.c() == false) goto L14;
        View r12 = this.f3209w.b(r10.mContainerId);
        if ((r12 instanceof ViewGroup) == false) goto L14;
        return (ViewGroup) r12;
    L14:
        return null;
    }

    public void u1(Parcelable r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        Bundle r16 = (Bundle) r15;
        Iterator<String> r10 = r16.keySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L12;
        String r11 = r10.next();
        if (r11.startsWith("result_") == false) goto L6;
        Bundle r12 = r16.getBundle(r11);
        if (r12 == null) goto L6;
        r12.setClassLoader(this.f3208v.e().getClassLoader());
        this.f3197k.put(r11.substring(7), r12);
        goto L6
    L12:
        HashMap r13 = new HashMap();
        Iterator<String> r14 = r16.keySet().iterator();
    L14:
        if (r14.hasNext() == false) goto L20;
        String r17 = r14.next();
        if (r17.startsWith("fragment_") == false) goto L14;
        Bundle r18 = r16.getBundle(r17);
        if (r18 == null) goto L14;
        r18.setClassLoader(this.f3208v.e().getClassLoader());
        r13.put(r17.substring(9), r18);
        goto L14
    L20:
        this.f3189c.x(r13);
        FragmentManagerState r19 = (FragmentManagerState) r16.getParcelable(WsConstants.KEY_CONNECTION_STATE);
        if (r19 != null) goto L23;
        return;
    L23:
        this.f3189c.v();
        Iterator<String> r20 = r19.mActive.iterator();
    L25:
        if (r20.hasNext() == false) goto L39;
        Bundle r21 = this.f3189c.B(r20.next(), null);
        if (r21 == null) goto L25;
        Fragment r22 = this.P.j(((FragmentState) r21.getParcelable(WsConstants.KEY_CONNECTION_STATE)).mWho);
        if (r22 != null) goto L31;
        a0 r23 = new a0(this.f3200n, this.f3189c, this.f3208v.e().getClassLoader(), v0(), r21);
    L35:
        Fragment r24 = r23.k();
        r24.mSavedFragmentState = r21;
        r24.mFragmentManager = this;
        if (L0(2) == false) goto L38;
        Log.v("FragmentManager", "restoreSaveState: active (" + r24.mWho + "): " + r24);
    L38:
        r23.o(this.f3208v.e().getClassLoader());
        this.f3189c.r(r23);
        r23.t(this.f3207u);
        goto L25
    L31:
        if (L0(2) == false) goto L33;
        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + r22);
    L33:
        r23 = new a0(this.f3200n, this.f3189c, r22, r21);
        goto L35
    L39:
        Iterator r25 = this.P.m().iterator();
    L41:
        if (r25.hasNext() == false) goto L48;
        Fragment r26 = (Fragment) r25.next();
        if (this.f3189c.c(r26.mWho) == true) goto L41;
        if (L0(2) == false) goto L47;
        Log.v("FragmentManager", "Discarding retained Fragment " + r26 + " that was not found in the set of active Fragments " + r19.mActive);
    L47:
        this.P.p(r26);
        r26.mFragmentManager = this;
        a0 r27 = new a0(this.f3200n, this.f3189c, r26);
        r27.t(1);
        r27.m();
        r26.mRemoving = true;
        r27.m();
        goto L41
    L48:
        this.f3189c.w(r19.mAdded);
        int r28 = 0;
        if (r19.mBackStack == null) goto L57;
        this.f3190d = new ArrayList(r19.mBackStack.length);
        int r29 = 0;
    L51:
        BackStackRecordState[] r30 = r19.mBackStack;
        if (r29 >= r30.length) goto L58;
        androidx.fragment.app.a r31 = r30[r29].instantiate(this);
        if (L0(2) == false) goto L56;
        Log.v("FragmentManager", "restoreAllState: back stack #" + r29 + " (index " + r31.f3296v + "): " + r31);
        PrintWriter r32 = new PrintWriter(new g0("FragmentManager"));
        r31.F("  ", r32, false);
        r32.close();
    L56:
        this.f3190d.add(r31);
        r29 = r29 + 1;
    L58:
        this.f3195i.set(r19.mBackStackIndex);
        String r33 = r19.mPrimaryNavActiveWho;
        if (r33 == null) goto L61;
        Fragment r34 = f0(r33);
        this.f3211y = r34;
        L(r34);
    L61:
        ArrayList<String> r35 = r19.mBackStackStateKeys;
        if (r35 != null) goto L64;
    L66:
        this.G = new ArrayDeque(r19.mLaunchedFragments);
        return;
    L64:
        if (r28 >= r35.size()) goto L66;
        this.f3196j.put(r35.get(r28), r19.mBackStackStates.get(r28));
        r28 = r28 + 1;
        goto L64
    L57:
        this.f3190d = null;
        goto L58
    }

    public a0 v(Fragment r10) {
        a0 r11 = this.f3189c.n(r10.mWho);
        if (r11 == null) goto L5;
        return r11;
    L5:
        a0 r12 = new a0(this.f3200n, this.f3189c, r10);
        r12.o(this.f3208v.e().getClassLoader());
        r12.t(this.f3207u);
        return r12;
    }

    public androidx.fragment.app.p v0() {
        androidx.fragment.app.p r10 = this.f3212z;
        if (r10 == null) goto L5;
        return r10;
    L5:
        Fragment r11 = this.f3210x;
        if (r11 == null) goto L10;
        return r11.mFragmentManager.v0();
    L10:
        return this.A;
    }

    public void w(Fragment r10) {
        if (L0(2) == false) goto L6;
        Log.v("FragmentManager", "detach: " + r10);
    L6:
        if (r10.mDetached == true) goto L17;
        r10.mDetached = true;
        if (r10.mAdded == true) goto L10;
        return;
    L10:
        if (L0(2) == false) goto L12;
        Log.v("FragmentManager", "remove from detach: " + r10);
    L12:
        this.f3189c.u(r10);
        if (M0(r10) == false) goto L15;
        this.H = true;
    L15:
        E1(r10);
        return;
    }

    public c0 w0() {
        return this.f3189c;
    }

    public Bundle w1() {
        Bundle r10 = new Bundle();
        m0();
        X();
        a0(true);
        this.I = true;
        this.P.q(true);
        ArrayList<String> r11 = this.f3189c.y();
        HashMap r12 = this.f3189c.m();
        if (r12.isEmpty() == true) goto L5;
        ArrayList<String> r13 = this.f3189c.z();
        ArrayList r14 = this.f3190d;
        if (r14 == null) goto L17;
        int r15 = r14.size();
        if (r15 <= 0) goto L17;
        BackStackRecordState[] r16 = new BackStackRecordState[r15];
        int r17 = 0;
    L12:
        if (r17 >= r15) goto L18;
        r16[r17] = new BackStackRecordState((androidx.fragment.app.a) this.f3190d.get(r17));
        if (L0(2) == false) goto L16;
        Log.v("FragmentManager", "saveAllState: adding back stack #" + r17 + ": " + this.f3190d.get(r17));
    L16:
        r17 = r17 + 1;
    L18:
        FragmentManagerState r18 = new FragmentManagerState();
        r18.mActive = r11;
        r18.mAdded = r13;
        r18.mBackStack = r16;
        r18.mBackStackIndex = this.f3195i.get();
        Fragment r19 = this.f3211y;
        if (r19 == null) goto L21;
        r18.mPrimaryNavActiveWho = r19.mWho;
    L21:
        r18.mBackStackStateKeys.addAll(this.f3196j.keySet());
        r18.mBackStackStates.addAll(this.f3196j.values());
        r18.mLaunchedFragments = new ArrayList(this.G);
        r10.putParcelable(WsConstants.KEY_CONNECTION_STATE, r18);
        Iterator r20 = this.f3197k.keySet().iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        String r21 = (String) r20.next();
        r10.putBundle("result_" + r21, (Bundle) this.f3197k.get(r21));
        goto L23
    L25:
        Iterator r110 = r12.keySet().iterator();
    L27:
        if (r110.hasNext() == false) goto L29;
        String r22 = (String) r110.next();
        r10.putBundle("fragment_" + r22, (Bundle) r12.get(r22));
    L29:
        return r10;
    L17:
        r16 = null;
        goto L18
    L5:
        if (L0(2) == false) goto L29;
        Log.v("FragmentManager", "saveAllState: no fragments!");
        goto L29
    }

    public void x() {
        this.I = false;
        this.f3186J = false;
        this.P.q(false);
        S(4);
    }

    public List x0() {
        return this.f3189c.o();
    }

    public void x1(String r10) {
        Y(new p(this, r10), false);
    }

    public void y() {
        this.I = false;
        this.f3186J = false;
        this.P.q(false);
        S(0);
    }

    public FragmentHostCallback y0() {
        return this.f3208v;
    }

    public boolean y1(ArrayList r17, ArrayList r18, String r19) {
        int r10 = g0(r19, -1, true);
        if (r10 >= 0) goto L6;
        return false;
    L6:
        int r11 = r10;
    L8:
        if (r11 >= this.f3190d.size()) goto L13;
        androidx.fragment.app.a r12 = (androidx.fragment.app.a) this.f3190d.get(r11);
        if (r12.f3260r == true) goto L12;
        H1(new IllegalArgumentException("saveBackStack(\"" + r19 + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + r12 + " that did not use setReorderingAllowed(true)."));
    L12:
        r11 = r11 + 1;
        goto L8
    L13:
        HashSet r13 = new HashSet();
        int r14 = r10;
    L15:
        if (r14 >= this.f3190d.size()) goto L42;
        androidx.fragment.app.a r15 = (androidx.fragment.app.a) this.f3190d.get(r14);
        HashSet r16 = new HashSet();
        HashSet r20 = new HashSet();
        Iterator r110 = r15.f3245c.iterator();
    L18:
        if (r110.hasNext() == false) goto L34;
        FragmentTransaction.a r111 = (FragmentTransaction.a) r110.next();
        Fragment r112 = r111.f3263b;
        if (r112 == null) goto L18;
        if (r111.f3264c == false) goto L29;
        int r113 = r111.f3262a;
        if (r113 == 1) goto L29;
        if (r113 == 2) goto L29;
        if (r113 == 8) goto L29;
    L30:
        int r114 = r111.f3262a;
        if (r114 == 1) goto L33;
        if (r114 != 2) goto L18;
    L33:
        r20.add(r112);
    L29:
        r13.add(r112);
        r16.add(r112);
        goto L30
    L34:
        r16.removeAll(r20);
        if (r16.isEmpty() == true) goto L41;
        StringBuilder r115 = new StringBuilder();
        r115.append("saveBackStack(\"");
        r115.append(r19);
        r115.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
        if (r16.size() != 1) goto L39;
        String r21 = " " + r16.iterator().next();
    L40:
        r115.append(r21);
        r115.append(" in ");
        r115.append(r15);
        r115.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
        H1(new IllegalArgumentException(r115.toString()));
        goto L41
    L39:
        r21 = "s " + r16;
    L41:
        r14 = r14 + 1;
        goto L15
    L42:
        ArrayDeque r22 = new ArrayDeque(r13);
    L44:
        if (r22.isEmpty() == true) goto L58;
        Fragment r23 = (Fragment) r22.removeFirst();
        if (r23.mRetainInstance == false) goto L52;
        StringBuilder r24 = new StringBuilder();
        r24.append("saveBackStack(\"");
        r24.append(r19);
        r24.append("\") must not contain retained fragments. Found ");
        if (r13.contains(r23) == false) goto L50;
        String r116 = "direct reference to retained ";
    L51:
        r24.append(r116);
        r24.append("fragment ");
        r24.append(r23);
        H1(new IllegalArgumentException(r24.toString()));
        goto L52
    L50:
        r116 = "retained child ";
    L52:
        Iterator r25 = r23.mChildFragmentManager.p0().iterator();
    L54:
        if (r25.hasNext() == false) goto L44;
        Fragment r26 = (Fragment) r25.next();
        if (r26 == null) goto L54;
        r22.addLast(r26);
        goto L54
    L58:
        ArrayList r27 = new ArrayList();
        Iterator r28 = r13.iterator();
    L60:
        if (r28.hasNext() == false) goto L62;
        r27.add(((Fragment) r28.next()).mWho);
        goto L60
    L62:
        ArrayList r29 = new ArrayList(this.f3190d.size() - r10);
        int r30 = r10;
    L64:
        if (r30 >= this.f3190d.size()) goto L66;
        r29.add(null);
        r30 = r30 + 1;
        goto L64
    L66:
        BackStackState r31 = new BackStackState(r27, r29);
        int r32 = this.f3190d.size() - 1;
    L67:
        if (r32 < r10) goto L69;
        androidx.fragment.app.a r33 = (androidx.fragment.app.a) this.f3190d.remove(r32);
        androidx.fragment.app.a r34 = new androidx.fragment.app.a(r33);
        r34.C();
        r29.set(r32 - r10, new BackStackRecordState(r34));
        r33.f3297w = true;
        r17.add(r33);
        r18.add(Boolean.TRUE);
        r32 = r32 - 1;
        goto L67
    L69:
        this.f3196j.put(r19, r31);
        return true;
    }

    public void z(Configuration r10, boolean r11) {
        if (r11 == true) goto L4;
    L6:
        Iterator r12 = this.f3189c.o().iterator();
    L8:
        if (r12.hasNext() == false) goto L14;
        Fragment r13 = (Fragment) r12.next();
        if (r13 == null) goto L8;
        r13.performConfigurationChanged(r10);
        if (r11 == false) goto L8;
        r13.mChildFragmentManager.z(r10, true);
        goto L8
    L14:
        return;
    L4:
        if ((this.f3208v instanceof OnConfigurationChangedProvider) == false) goto L6;
        H1(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        goto L6
    }

    public LayoutInflater.Factory2 z0() {
        return this.f3192f;
    }

    public Fragment.SavedState z1(Fragment r10) {
        a0 r11 = this.f3189c.n(r10.mWho);
        if (r11 != null) goto L5;
    L6:
        H1(new IllegalStateException("Fragment " + r10 + " is not currently in the FragmentManager"));
    L8:
        return r11.q();
    L5:
        if (r11.k().equals(r10) == true) goto L8;
        goto L6
    }
}
