package androidx.fragment.app;

import android.content.Context;
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
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.ao;
import androidx.lifecycle.ap;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f1731a = true;
    private static boolean f = false;
    private u A;
    private u B;
    private androidx.activity.result.b<Intent> C;
    private androidx.activity.result.b<IntentSenderRequest> D;
    private androidx.activity.result.b<String[]> E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f1732J;
    private ArrayList<androidx.fragment.app.a> K;
    private ArrayList<Boolean> L;
    private ArrayList<Fragment> M;
    private ArrayList<g> N;
    private h O;
    private Runnable P;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f1733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Fragment f1735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ArrayDeque<LaunchedFragmentInfo> f1736e;
    private final ArrayList<e> g;
    private boolean h;
    private final l i;
    private ArrayList<Fragment> j;
    private final FragmentLayoutInflaterFactory k;
    private OnBackPressedDispatcher l;
    private final androidx.activity.c m;
    private final AtomicInteger n;
    private final Map<String, Bundle> o;
    private final Map<String, c> p;
    private ArrayList<d> q;
    private Map<Fragment, HashSet<androidx.core.os.f>> r;
    private final n.a s;
    private final androidx.fragment.app.f t;
    private final CopyOnWriteArrayList<i> u;
    private androidx.fragment.app.e<?> v;
    private androidx.fragment.app.c w;
    private Fragment x;
    private FragmentFactory y;
    private FragmentFactory z;

    static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = null;
        int mRequestCode;
        String mWho;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        LaunchedFragmentInfo(String r1, int r2) {
            this.mWho = r1;
            this.mRequestCode = r2;
        }

        LaunchedFragmentInfo(Parcel r2) {
            this.mWho = r2.readString();
            this.mRequestCode = r2.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.mWho);
            r1.writeInt(this.mRequestCode);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static class a extends androidx.activity.result.a.a<IntentSenderRequest, ActivityResult> {
        a() {
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ Intent a(Context r3, IntentSenderRequest r4) {
            return a2((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (IntentSenderRequest) ZeusTransformUtils.preCheckCast(r4, IntentSenderRequest.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.activity.result.a.a
        public /* synthetic */ ActivityResult a(int r1, Intent r2) {
            return b(r1, r2);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public Intent a2(Context r3, IntentSenderRequest r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            Intent r5 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent r6 = r4.getFillInIntent();
            if (r6 == null) goto L9;
            Bundle r1 = r6.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (r1 == null) goto L9;
            r5.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r1);
            r6.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (r6.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false) == false) goto L9;
            r4 = new IntentSenderRequest.a(r4.getIntentSender()).a(null).a(r4.getFlagsValues(), r4.getFlagsMask()).a();
        L9:
            r5.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", r4);
            if (FragmentManager.a(2) == false) goto L12;
            a("FragmentManager", "CreateIntent created the following intent: " + r5);
        L12:
            return r5;
        }

        public ActivityResult b(int r1, Intent r2) {
            return new ActivityResult(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    public static abstract class b {
        public void a(FragmentManager r1, Fragment r2) {
        }

        public void a(FragmentManager r1, Fragment r2, Context r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        }

        public void a(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void a(FragmentManager r1, Fragment r2, View r3, Bundle r4) {
        }

        public void b(FragmentManager r1, Fragment r2) {
        }

        public void b(FragmentManager r1, Fragment r2, Context r3) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        }

        public void b(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void c(FragmentManager r1, Fragment r2) {
        }

        @Deprecated
        public void c(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void d(FragmentManager r1, Fragment r2) {
        }

        public void d(FragmentManager r1, Fragment r2, Bundle r3) {
        }

        public void e(FragmentManager r1, Fragment r2) {
        }

        public void f(FragmentManager r1, Fragment r2) {
        }

        public void g(FragmentManager r1, Fragment r2) {
        }

        public b() {
        }
    }

    private static class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.lifecycle.i f1751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final j f1752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.lifecycle.m f1753c;

        c(androidx.lifecycle.i r3, j r4, androidx.lifecycle.m r5) {
            j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
            androidx.lifecycle.m r7 = (androidx.lifecycle.m) ZeusTransformUtils.wrapperContextForParams(r5, androidx.lifecycle.m.class, "com.obric.aiagent.plugin");
            this.f1751a = r3;
            this.f1752b = r6;
            this.f1753c = r7;
        }

        public boolean a(androidx.lifecycle.i.b r1) {
            return this.f1751a.b().a(r1);
        }

        @Override // androidx.fragment.app.j
        public void onFragmentResult(String r1, Bundle r2) {
            this.f1752b.onFragmentResult(r1, r2);
        }

        public void a() {
            this.f1751a.b(this.f1753c);
        }
    }

    public interface d {
        void a();
    }

    interface e {
        boolean a(ArrayList<androidx.fragment.app.a> r1, ArrayList<Boolean> r2);
    }

    private class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f1754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f1755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f1756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ FragmentManager f1757d;

        f(FragmentManager r1, String r2, int r3, int r4) {
            this.f1757d = r1;
            this.f1754a = r2;
            this.f1755b = r3;
            this.f1756c = r4;
        }

        @Override // androidx.fragment.app.FragmentManager.e
        public boolean a(ArrayList<androidx.fragment.app.a> r7, ArrayList<Boolean> r8) {
            if (this.f1757d.f1735d == null) goto L13;
            if (this.f1755b >= 0) goto L13;
            if (this.f1754a != null) goto L13;
            if (this.f1757d.f1735d.getChildFragmentManager().d() == false) goto L13;
            return false;
        L13:
            return this.f1757d.a(r7, r8, this.f1754a, this.f1755b, this.f1756c);
        }
    }

    static class g implements Fragment.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f1758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f1759b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f1760c;

        g(androidx.fragment.app.a r1, boolean r2) {
            this.f1758a = r2;
            this.f1759b = r1;
        }

        @Override // androidx.fragment.app.Fragment.d
        public void a() {
            int r0 = this.f1760c - 1;
            this.f1760c = r0;
            if (r0 == 0) goto L5;
            return;
        L5:
            this.f1759b.f1766a.i();
        }

        @Override // androidx.fragment.app.Fragment.d
        public void b() {
            this.f1760c++;
        }

        public boolean c() {
            if (this.f1760c != 0) goto L5;
            return true;
        L5:
            return false;
        }

        void d() {
            if (this.f1760c <= 0) goto L5;
            boolean r0 = true;
        L6:
            Iterator<Fragment> r2 = this.f1759b.f1766a.f().iterator();
        L8:
            if (r2.hasNext() == false) goto L14;
            Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r2.next(), Fragment.class, "com.obric.aiagent.plugin");
            r3.setOnStartEnterTransitionListener(null);
            if (r0 == false) goto L8;
            if (r3.isPostponed() == false) goto L8;
            r3.startPostponedEnterTransition();
            goto L8
        L14:
            this.f1759b.f1766a.a(this.f1759b, this.f1758a, !r0, true);
            return;
        L5:
            r0 = false;
            goto L6
        }

        void e() {
            this.f1759b.f1766a.a(this.f1759b, this.f1758a, false, false);
        }
    }

    static {
    }

    static int d(int r3) {
        if (r3 == 4097) goto L10;
        if (r3 == 4099) goto L9;
        if (r3 == 8194) goto L12;
        return 0;
    L12:
        return 4097;
    L9:
        return 4099;
    L10:
        return 8194;
    }

    public FragmentManager() {
        this.g = new ArrayList();
        this.i = new l();
        this.k = new FragmentLayoutInflaterFactory(this);
        final boolean r1 = false;
        this.m = new AnonymousClass1(this, r1);
        this.n = new AtomicInteger();
        this.o = Collections.synchronizedMap(new HashMap());
        this.p = Collections.synchronizedMap(new HashMap());
        this.r = Collections.synchronizedMap(new HashMap());
        this.s = new AnonymousClass4(this);
        this.t = new androidx.fragment.app.f(this);
        this.u = new CopyOnWriteArrayList();
        this.f1734c = -1;
        this.y = null;
        this.z = new AnonymousClass5(this);
        this.A = null;
        this.B = new AnonymousClass8(this);
        this.f1736e = new ArrayDeque();
        this.P = new AnonymousClass9(this);
    }

    static /* synthetic */ Map a(FragmentManager r0) {
        return r0.o;
    }

    static /* synthetic */ Map b(FragmentManager r0) {
        return r0.p;
    }

    static /* synthetic */ l c(FragmentManager r0) {
        return r0.i;
    }

    static boolean a(int r1) {
        if (f == false) goto L5;
    L8:
        return true;
    L5:
        if (a("FragmentManager", r1) == true) goto L8;
        return false;
    }

    private void a(RuntimeException r8) {
        a("FragmentManager", r8.getMessage());
        a("FragmentManager", "Activity state:");
        PrintWriter r2 = new PrintWriter(new s("FragmentManager"));
        androidx.fragment.app.e<?> r0 = this.v;
        if (r0 == null) goto L15;
        r0.a("  ", null, r2, new String[0]);     // Catch: Exception -> L6
        throw r8;
    L6:
        e = move-exception;
        a("FragmentManager", "Failed dumping state", e);
        throw r8;
    L15:
        a("  ", null, r2, new String[0]);     // Catch: Exception -> L10
        throw r8;
    L10:
        e = move-exception;
        a("FragmentManager", "Failed dumping state", e);
        throw r8;
    }

    public m a() {
        return new androidx.fragment.app.a(this);
    }

    public boolean b() {
        boolean r0 = a(true);
        M();
        return r0;
    }

    private void I() {
        ArrayList<e> r0 = this.g;
        monitor-enter(r0);
        boolean r2 = true;
        if (this.g.isEmpty() == true) goto L9;
        this.m.a(true);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L18
        androidx.activity.c r1 = this.m;
        if (e() > 0) goto L13;
    L15:
        r2 = false;
    L16:
        r1.a(r2);
        return;
    L13:
        if (a(this.x) == false) goto L15;
    L18:
        th = move-exception;
        throw th;
    }

    boolean a(Fragment r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        FragmentManager r1 = r4.mFragmentManager;
        if (r4.equals(r1.C()) == true) goto L8;
    L10:
        return false;
    L8:
        if (a(r1.x) == false) goto L10;
        return true;
    }

    boolean b(Fragment r1) {
        if (r1 != null) goto L6;
        return true;
    L6:
        return r1.isMenuVisible();
    }

    void c() {
        a(true);
        if (this.m.a() == false) goto L5;
        d();
        return;
    L5:
        this.l.c();
    }

    public boolean d() {
        return a(null, -1, 0);
    }

    public void a(int r3, int r4) {
        if (r3 < 0) goto L6;
        a(new f(this, null, r3, r4), false);
        return;
    L6:
        throw new IllegalArgumentException("Bad id: " + r3);
    }

    private boolean a(String r9, int r10, int r11) {
        a(false);
        d(true);
        Fragment r1 = this.f1735d;
        if (r1 == null) goto L9;
        if (r10 >= 0) goto L9;
        if (r9 != null) goto L9;
        if (r1.getChildFragmentManager().d() == false) goto L9;
        return true;
    L9:
        boolean r12 = a(this.K, this.L, r9, r10, r11);
        if (r12 == false) goto L17;
        this.h = true;
        b(this.K, this.L);     // Catch: Throwable -> L14
        L();
    L14:
        th = move-exception;
        L();
        throw th;
    L17:
        I();
        P();
        this.i.d();
        return r12;
    }

    public int e() {
        ArrayList<androidx.fragment.app.a> r0 = this.f1733b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    void a(Fragment r3, androidx.core.os.f r4) {
        if (this.r.get(r3) != null) goto L5;
        this.r.put(r3, new HashSet());
    L5:
        ((HashSet) ZeusTransformUtils.preCheckCast(this.r.get(r3), HashSet.class, "com.obric.aiagent.plugin")).add(r4);
    }

    void b(Fragment r4, androidx.core.os.f r5) {
        HashSet r0 = (HashSet) ZeusTransformUtils.preCheckCast(this.r.get(r4), HashSet.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.remove(r5) == true) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L14;
        this.r.remove(r4);
        if (r4.mState >= 5) goto L15;
        u(r4);
        g(r4);
        return;
    L15:
        return;
    }

    public final void a(String r4, Bundle r5) {
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.p.get(r4), c.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L7:
        this.o.put(r4, r5);
        return;
    L5:
        if (r0.a(androidx.lifecycle.i.b.f2057d) == false) goto L7;
        r0.onFragmentResult(r4, r5);
    }

    public final void a(String r1) {
        this.o.remove(r1);
    }

    public final void a(final String r4, androidx.lifecycle.p r5, j r6) {
        androidx.lifecycle.p r7 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r5, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        final j r8 = (j) ZeusTransformUtils.wrapperContextForParams(r6, j.class, "com.obric.aiagent.plugin");
        final androidx.lifecycle.i r9 = r7.getLifecycle();
        if (r9.b() != androidx.lifecycle.i.b.f2054a) goto L5;
        return;
    L5:
        androidx.lifecycle.m r0 = new AnonymousClass6(this, r4, r8, r9);
        r9.a(r0);
        c r3 = (c) ZeusTransformUtils.preCheckCast(this.p.put(r4, new c(r9, r8, r0)), c.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        r3.a();
        return;
    }

    public void a(Bundle r4, String r5, Fragment r6) {
        if (r6.mFragmentManager == this) goto L5;
        a(new IllegalStateException("Fragment " + r6 + " is not currently in the FragmentManager"));
    L5:
        r4.putString(r5, r6.mWho);
    }

    public Fragment a(Bundle r5, String r6) {
        String r7 = r5.getString(r6);
        if (r7 != null) goto L6;
        return null;
    L6:
        Fragment r0 = d(r7);
        if (r0 != null) goto L9;
        a(new IllegalStateException("Fragment no longer exists for key " + r6 + ": unique id " + r7));
    L9:
        return r0;
    }

    static Fragment a(View r3) {
        Object r4 = r3.getTag(ZeusTransformUtils.mapRes(R.id.fragment_container_view_tag, DbHelper.COL_ID, "fragment_container_view_tag"));
        if (ZeusTransformUtils.instanceOf(r4, Fragment.class) == true) goto L5;
        return null;
    L5:
        return (Fragment) ZeusTransformUtils.preCheckCast(r4, Fragment.class, "com.obric.aiagent.plugin");
    }

    void a(FragmentContainerView r5) {
        Iterator<k> r4 = this.i.g().iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r4.next(), k.class, "com.obric.aiagent.plugin");
        Fragment r1 = r0.a();
        if (r1.mContainerId != r5.getId()) goto L4;
        if (r1.mView == null) goto L4;
        if (r1.mView.getParent() != null) goto L4;
        r1.mContainer = r5;
        r0.s();
        goto L4
    }

    public List<Fragment> f() {
        return this.i.h();
    }

    ao c(Fragment r1) {
        return this.O.e(r1);
    }

    private h s(Fragment r1) {
        return this.O.d(r1);
    }

    void d(Fragment r1) {
        this.O.a(r1);
    }

    void e(Fragment r1) {
        this.O.c(r1);
    }

    public Fragment.SavedState f(Fragment r5) {
        k r0 = this.i.c(r5.mWho);
        if (r0 != null) goto L5;
    L6:
        a(new IllegalStateException("Fragment " + r5 + " is not currently in the FragmentManager"));
    L8:
        return r0.n();
    L5:
        if (r0.a().equals(r5) == true) goto L8;
        goto L6
    }

    public boolean g() {
        return this.I;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("FragmentManager{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        r0.append(" in ");
        Fragment r1 = this.x;
        if (r1 == null) goto L5;
        r0.append(r1.getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this.x)));
        r0.append("}");
    L9:
        r0.append("}}");
        return r0.toString();
    L5:
        androidx.fragment.app.e<?> r2 = this.v;
        if (r2 == null) goto L8;
        r0.append(r2.getClass().getSimpleName());
        r0.append("{");
        r0.append(Integer.toHexString(System.identityHashCode(this.v)));
        r0.append("}");
        goto L9
    L8:
        r0.append("null");
        goto L9
    }

    public void a(String r6, FileDescriptor r7, PrintWriter r8, String[] r9) {
        String r0 = r6 + "    ";
        this.i.a(r6, r7, r8, r9);
        ArrayList<Fragment> r10 = this.j;
        int r11 = 0;
        if (r10 == null) goto L9;
        int r12 = r10.size();
        if (r12 <= 0) goto L9;
        r8.print(r6);
        r8.println("Fragments Created Menus:");
        int r1 = 0;
    L7:
        if (r1 >= r12) goto L9;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.j.get(r1), Fragment.class, "com.obric.aiagent.plugin");
        r8.print(r6);
        r8.print("  #");
        r8.print(r1);
        r8.print(": ");
        r8.println(r2.toString());
        r1 = r1 + 1;
    L9:
        ArrayList<androidx.fragment.app.a> r13 = this.f1733b;
        if (r13 == null) goto L16;
        int r14 = r13.size();
        if (r14 <= 0) goto L16;
        r8.print(r6);
        r8.println("Back Stack:");
        int r3 = 0;
    L14:
        if (r3 >= r14) goto L16;
        androidx.fragment.app.a r4 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(this.f1733b.get(r3), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        r8.print(r6);
        r8.print("  #");
        r8.print(r3);
        r8.print(": ");
        r8.println(r4.toString());
        r4.a(r0, r8);
        r3 = r3 + 1;
    L16:
        r8.print(r6);
        r8.println("Back Stack Index: " + this.n.get());
        ArrayList<e> r15 = this.g;
        monitor-enter(r15);
        int r5 = this.g.size();     // Catch: Throwable -> L31
        if (r5 <= 0) goto L23;
        r8.print(r6);     // Catch: Throwable -> L31
        r8.println("Pending Actions:");     // Catch: Throwable -> L31
    L21:
        if (r11 >= r5) goto L23;
        e r16 = (e) ZeusTransformUtils.preCheckCast(this.g.get(r11), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L31
        r8.print(r6);     // Catch: Throwable -> L31
        r8.print("  #");     // Catch: Throwable -> L31
        r8.print(r11);     // Catch: Throwable -> L31
        r8.print(": ");     // Catch: Throwable -> L31
        r8.println(r16);     // Catch: Throwable -> L31
        r11 = r11 + 1;     // Catch: Throwable -> L31
    L23:
        monitor-exit(r15);     // Catch: Throwable -> L31
        r8.print(r6);
        r8.println("FragmentManager misc state:");
        r8.print(r6);
        r8.print("  mHost=");
        r8.println(this.v);
        r8.print(r6);
        r8.print("  mContainer=");
        r8.println(this.w);
        if (this.x == null) goto L27;
        r8.print(r6);
        r8.print("  mParent=");
        r8.println(this.x);
    L27:
        r8.print(r6);
        r8.print("  mCurState=");
        r8.print(this.f1734c);
        r8.print(" mStateSaved=");
        r8.print(this.G);
        r8.print(" mStopped=");
        r8.print(this.H);
        r8.print(" mDestroyed=");
        r8.println(this.I);
        if (this.F == false) goto L39;
        r8.print(r6);
        r8.print("  mNeedMenuInvalidate=");
        r8.println(this.F);
        return;
    L39:
        return;
    L31:
        th = move-exception;
        throw th;
    }

    void a(k r3) {
        Fragment r0 = r3.a();
        if (r0.mDeferStart == true) goto L5;
        return;
    L5:
        if (this.h == false) goto L8;
        this.f1732J = true;
        return;
    L8:
        r0.mDeferStart = false;
        if (f1731a == false) goto L11;
        r3.c();
        return;
    L11:
        g(r0);
    }

    boolean b(int r1) {
        if (this.f1734c < r1) goto L5;
        return true;
    L5:
        return false;
    }

    void a(Fragment r11, int r12) {
        k r0 = this.i.c(r11.mWho);
        int r1 = 1;
        if (r0 != null) goto L6;
        r0 = new k(this.t, this.i, r11);
        r0.a(1);
    L6:
        if (r11.mFromLayout == true) goto L8;
    L12:
        int r13 = Math.min(r12, r0.b());
        if (r11.mState > r13) goto L42;
        if (r11.mState < r13) goto L17;
    L19:
        int r10 = r11.mState;
        if (r10 == (-1)) goto L27;
        if (r10 == 0) goto L29;
        if (r10 == 1) goto L31;
        if (r10 == 2) goto L35;
        if (r10 == 4) goto L37;
        if (r10 != 5) goto L105;
    L39:
        if (r13 <= 5) goto L105;
        r0.j();
    L105:
        if (r11.mState != r13) goto L107;
        return;
    L107:
        if (a(3) == false) goto L109;
        b("FragmentManager", "moveToState: Fragment state for " + r11 + " not updated inline; expected state " + r13 + " found " + r11.mState);
    L109:
        r11.mState = r13;
        return;
    L37:
        if (r13 <= 4) goto L39;
        r0.i();
    L35:
        if (r13 <= 2) goto L37;
        r0.h();
    L31:
        if (r13 <= (-1)) goto L33;
        r0.d();
    L33:
        if (r13 <= 1) goto L35;
        r0.g();
    L29:
        if (r13 <= 0) goto L31;
        r0.f();
        goto L31
    L27:
        if (r13 <= (-1)) goto L29;
        r0.e();
        goto L29
    L17:
        if (this.r.isEmpty() == true) goto L19;
        t(r11);
        goto L19
    L42:
        if (r11.mState <= r13) goto L105;
        int r2 = r11.mState;
        if (r2 == 0) goto L100;
        if (r2 == 1) goto L95;
        if (r2 == 2) goto L67;
        if (r2 == 4) goto L56;
        if (r2 != 5) goto L50;
    L54:
        if (r13 >= 5) goto L56;
        r0.l();
        goto L56
    L50:
        if (r2 != 7) goto L105;
        if (r13 >= 7) goto L54;
        r0.k();
    L56:
        if (r13 >= 4) goto L67;
        if (a(3) == false) goto L61;
        b("FragmentManager", "movefrom ACTIVITY_CREATED: " + r11);
    L61:
        if (r11.mView == null) goto L67;
        if (this.v.a(r11) == false) goto L67;
        if (r11.mSavedViewState != null) goto L67;
        r0.o();
    L67:
        if (r13 >= 2) goto L95;
        FragmentAnim.a r3 = null;
        if (r11.mView == null) goto L93;
        if (r11.mContainer == null) goto L93;
        r11.mContainer.endViewTransition(r11.mView);
        r11.mView.clearAnimation();
        if (r11.isRemovingParent() == true) goto L93;
        if (this.f1734c > (-1)) goto L77;
    L83:
        r11.mPostponedAlpha = 0.0f;
        ViewGroup r6 = r11.mContainer;
        View r7 = r11.mView;
        if (r3 == null) goto L86;
        FragmentAnim.a(r11, r3, this.s);
    L86:
        r6.removeView(r7);
        if (a(2) == false) goto L90;
        c("FragmentManager", "Removing view " + r7 + " for fragment " + r11 + " from container " + r6);
    L90:
        if (r6 == r11.mContainer) goto L93;
        return;
    L77:
        if (this.I == true) goto L83;
        if (r11.mView.getVisibility() != 0) goto L83;
        if (r11.mPostponedAlpha < 0.0f) goto L83;
        r3 = FragmentAnim.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11, false, r11.getPopDirection());
    L93:
        if (this.r.get(r11) != null) goto L95;
        r0.p();
    L95:
        if (r13 >= 1) goto L100;
        if (this.r.get(r11) != null) goto L101;
        r0.q();
    L101:
        if (r1 >= 0) goto L103;
        r0.r();
    L103:
        r13 = r1;
    L100:
        r1 = r13;
        goto L101
    L8:
        if (r11.mInLayout == false) goto L12;
        if (r11.mState != 2) goto L12;
        r12 = Math.max(r12, 2);
        goto L12
    }

    private void t(Fragment r6) {
        HashSet r0 = (HashSet) ZeusTransformUtils.preCheckCast(this.r.get(r6), HashSet.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        ((androidx.core.os.f) ZeusTransformUtils.preCheckCast(r1.next(), androidx.core.os.f.class, "com.obric.aiagent.plugin")).b();
        goto L6
    L8:
        r0.clear();
        u(r6);
        this.r.remove(r6);
        return;
    }

    void a(Fragment r2, boolean r3) {
        ViewGroup r1 = x(r2);
        if (r1 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, FragmentContainerView.class) == false) goto L9;
        ((FragmentContainerView) ZeusTransformUtils.preCheckCast(r1, FragmentContainerView.class, "com.obric.aiagent.plugin")).setDrawDisappearingViewsLast(!r3);
        return;
    }

    private void u(Fragment r3) {
        r3.performDestroyView();
        this.t.g(r3, false);
        r3.mContainer = null;
        r3.mView = null;
        r3.mViewLifecycleOwner = null;
        r3.mViewLifecycleOwnerLiveData.b(null);
        r3.mInLayout = false;
    }

    void g(Fragment r2) {
        a(r2, this.f1734c);
    }

    private void v(final Fragment r7) {
        if (r7.mView == null) goto L27;
        FragmentAnim.a r0 = FragmentAnim.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, !r7.mHidden, r7.getPopDirection());
        if (r0 != null) goto L7;
    L16:
        if (r0 == null) goto L19;
        r7.mView.startAnimation(r0.f1728a);
        r0.f1728a.start();
    L19:
        if (r7.mHidden == true) goto L21;
    L23:
        int r1 = 0;
    L24:
        r7.mView.setVisibility(r1);
        if (r7.isHideReplaced() == false) goto L27;
        r7.setHideReplaced(false);
        goto L27
    L21:
        if (r7.isHideReplaced() == true) goto L23;
        r1 = 8;
        goto L24
    L7:
        if (r0.f1729b == null) goto L16;
        r0.f1729b.setTarget(r7.mView);
        if (r7.mHidden == true) goto L11;
        r7.mView.setVisibility(0);
    L15:
        r0.f1729b.start();
        goto L27
    L11:
        if (r7.isHideReplaced() == false) goto L13;
        r7.setHideReplaced(false);
        goto L15
    L13:
        final ViewGroup r2 = r7.mContainer;
        final View r3 = r7.mView;
        r2.startViewTransition(r3);
        r0.f1729b.addListener(new AnonymousClass7(this, r2, r3, r7));
    L27:
        r(r7);
        r7.mHiddenChanged = false;
        r7.onHiddenChanged(r7.mHidden);
    }

    void h(Fragment r4) {
        if (this.i.b(r4.mWho) == false) goto L5;
        g(r4);
        if (r4.mView == null) goto L24;
        if (r4.mIsNewlyAdded == false) goto L24;
        if (r4.mContainer == null) goto L24;
        if (r4.mPostponedAlpha <= 0.0f) goto L17;
        r4.mView.setAlpha(r4.mPostponedAlpha);
    L17:
        r4.mPostponedAlpha = 0.0f;
        r4.mIsNewlyAdded = false;
        FragmentAnim.a r0 = FragmentAnim.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, true, r4.getPopDirection());
        if (r0 == null) goto L24;
        if (r0.f1728a == null) goto L22;
        r4.mView.startAnimation(r0.f1728a);
        goto L24
    L22:
        r0.f1729b.setTarget(r4.mView);
        r0.f1729b.start();
    L24:
        if (r4.mHiddenChanged == false) goto L28;
        v(r4);
        return;
    L28:
        return;
    L5:
        if (a(3) == false) goto L27;
        b("FragmentManager", "Ignoring moving " + r4 + " to state " + this.f1734c + "since it is not added to " + this);
        return;
    }

    void a(int r5, boolean r6) {
        if (this.v == null) goto L5;
    L9:
        if (r6 == false) goto L11;
    L13:
        this.f1734c = r5;
        if (f1731a == false) goto L16;
        this.i.c();
    L34:
        J();
        if (this.F == false) goto L48;
        androidx.fragment.app.e<?> r7 = this.v;
        if (r7 != null) goto L39;
        return;
    L39:
        if (this.f1734c != 7) goto L50;
        r7.d();
        this.F = false;
        return;
    L50:
        return;
    L48:
        return;
    L16:
        Iterator<Fragment> r8 = this.i.h().iterator();
    L18:
        if (r8.hasNext() == false) goto L20;
        h((Fragment) ZeusTransformUtils.preCheckCast(r8.next(), Fragment.class, "com.obric.aiagent.plugin"));
        goto L18
    L20:
        Iterator<k> r9 = this.i.g().iterator();
    L22:
        if (r9.hasNext() == false) goto L34;
        k r0 = (k) ZeusTransformUtils.preCheckCast(r9.next(), k.class, "com.obric.aiagent.plugin");
        Fragment r2 = r0.a();
        if (r2.mIsNewlyAdded == true) goto L27;
        h(r2);
    L27:
        if (r2.mRemoving == true) goto L29;
    L31:
        boolean r3 = false;
    L32:
        if (r3 == false) goto L22;
        this.i.b(r0);
        goto L22
    L29:
        if (r2.isInBackStack() == true) goto L31;
        r3 = true;
        goto L32
    L11:
        if (r5 != this.f1734c) goto L13;
        return;
    L5:
        if (r5 == (-1)) goto L9;
        throw new IllegalStateException("No activity");
    }

    private void J() {
        Iterator<k> r0 = this.i.g().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    k i(Fragment r4) {
        k r0 = this.i.c(r4.mWho);
        if (r0 == null) goto L5;
        return r0;
    L5:
        k r1 = new k(this.t, this.i, r4);
        r1.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader());
        r1.a(this.f1734c);
        return r1;
    }

    k j(Fragment r4) {
        if (a(2) == false) goto L5;
        c("FragmentManager", "add: " + r4);
    L5:
        k r0 = i(r4);
        r4.mFragmentManager = this;
        this.i.a(r0);
        if (r4.mDetached == true) goto L13;
        this.i.a(r4);
        r4.mRemoving = false;
        if (r4.mView != null) goto L11;
        r4.mHiddenChanged = false;
    L11:
        if (z(r4) == false) goto L13;
        this.F = true;
    L13:
        return r0;
    }

    void k(Fragment r4) {
        if (a(2) == false) goto L5;
        c("FragmentManager", "remove: " + r4 + " nesting=" + r4.mBackStackNesting);
    L5:
        boolean r0 = !r4.isInBackStack();
        if (r4.mDetached == false) goto L8;
        if (r0 == true) goto L8;
        return;
    L8:
        this.i.b(r4);
        if (z(r4) == false) goto L11;
        this.F = true;
    L11:
        r4.mRemoving = true;
        w(r4);
    }

    void l(Fragment r3) {
        if (a(2) == false) goto L6;
        c("FragmentManager", "hide: " + r3);
    L6:
        if (r3.mHidden == true) goto L9;
        r3.mHidden = true;
        r3.mHiddenChanged = true ^ r3.mHiddenChanged;
        w(r3);
        return;
    }

    void m(Fragment r2) {
        if (a(2) == false) goto L6;
        c("FragmentManager", "show: " + r2);
    L6:
        if (r2.mHidden == false) goto L9;
        r2.mHidden = false;
        r2.mHiddenChanged = !r2.mHiddenChanged;
        return;
    }

    void n(Fragment r5) {
        if (a(2) == false) goto L6;
        c("FragmentManager", "detach: " + r5);
    L6:
        if (r5.mDetached == true) goto L17;
        r5.mDetached = true;
        if (r5.mAdded == true) goto L10;
        return;
    L10:
        if (a(2) == false) goto L12;
        c("FragmentManager", "remove from detach: " + r5);
    L12:
        this.i.b(r5);
        if (z(r5) == false) goto L15;
        this.F = true;
    L15:
        w(r5);
        return;
    }

    void o(Fragment r5) {
        if (a(2) == false) goto L6;
        c("FragmentManager", "attach: " + r5);
    L6:
        if (r5.mDetached == false) goto L16;
        r5.mDetached = false;
        if (r5.mAdded == true) goto L17;
        this.i.a(r5);
        if (a(2) == false) goto L13;
        c("FragmentManager", "add from attach: " + r5);
    L13:
        if (z(r5) == false) goto L18;
        this.F = true;
        return;
    L18:
        return;
    L17:
        return;
    }

    public Fragment c(int r1) {
        return this.i.b(r1);
    }

    public Fragment b(String r1) {
        return this.i.a(r1);
    }

    Fragment c(String r1) {
        return this.i.d(r1);
    }

    Fragment d(String r1) {
        return this.i.e(r1);
    }

    private void K() {
        if (h() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public boolean h() {
        if (this.G == false) goto L5;
    L8:
        return true;
    L5:
        if (this.H == true) goto L8;
        return false;
    }

    void a(e r3, boolean r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r4 == false) goto L5;
    L13:
        ArrayList<e> r0 = this.g;
        monitor-enter(r0);
    L25:
        th = move-exception;
        throw th;
    L16:
        if (this.v != null) goto L22;
        if (r4 == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L21:
        throw new IllegalStateException("Activity has been destroyed");     // Catch: Throwable -> L25
    L22:
        this.g.add(r5);     // Catch: Throwable -> L25
        i();     // Catch: Throwable -> L25
        monitor-exit(r0);     // Catch: Throwable -> L25
        return;
    L5:
        if (this.v == null) goto L7;
        K();
        goto L13
    L7:
        if (this.I == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    }

    void i() {
        ArrayList<e> r0 = this.g;
        monitor-enter(r0);
        ArrayList<g> r1 = this.N;     // Catch: Throwable -> L18
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        boolean r3 = false;
    L11:
        if (this.g.size() != 1) goto L13;
        r2 = true;
    L13:
        if (r3 == true) goto L15;
        if (r2 == true) goto L15;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L15:
        this.v.f().removeCallbacks(this.P);     // Catch: Throwable -> L18
        this.v.f().post(this.P);     // Catch: Throwable -> L18
        I();     // Catch: Throwable -> L18
        goto L16
    L7:
        if (r1.isEmpty() == true) goto L9;
        r3 = true;
    L18:
        th = move-exception;
        throw th;
    }

    int j() {
        return this.n.getAndIncrement();
    }

    private void d(boolean r3) {
        if (this.h == true) goto L29;
        if (this.v != null) goto L13;
        if (this.I == false) goto L11;
        throw new IllegalStateException("FragmentManager has been destroyed");
    L11:
        throw new IllegalStateException("FragmentManager has not been attached to a host.");
    L13:
        if (Looper.myLooper() != this.v.f().getLooper()) goto L27;
        if (r3 == true) goto L17;
        K();
    L17:
        if (this.K != null) goto L19;
        this.K = new ArrayList();
        this.L = new ArrayList();
    L19:
        this.h = true;
        a(null, null);     // Catch: Throwable -> L23
        this.h = false;
        return;
    L23:
        th = move-exception;
        this.h = false;
        throw th;
    L27:
        throw new IllegalStateException("Must be called from main thread of fragment host");
    L29:
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    void b(e r3, boolean r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        if (r4 == true) goto L5;
    L9:
        d(r4);
        if (r5.a(this.K, this.L) == false) goto L17;
        this.h = true;
        b(this.K, this.L);     // Catch: Throwable -> L14
        L();
    L14:
        th = move-exception;
        L();
        throw th;
    L17:
        I();
        P();
        this.i.d();
        return;
    L5:
        if (this.v != null) goto L7;
        return;
    L7:
        if (this.I == false) goto L9;
    }

    private void L() {
        this.h = false;
        this.L.clear();
        this.K.clear();
    }

    boolean a(boolean r4) {
        d(r4);
        boolean r0 = false;
    L4:
        if (c(this.K, this.L) == false) goto L11;
        this.h = true;
        b(this.K, this.L);     // Catch: Throwable -> L8
        L();
        r0 = true;
    L8:
        th = move-exception;
        L();
        throw th;
    L11:
        I();
        P();
        this.i.d();
        return r0;
    }

    private void a(ArrayList<androidx.fragment.app.a> r9, ArrayList<Boolean> r10) {
        ArrayList<g> r0 = this.N;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L35;
        g r3 = (g) ZeusTransformUtils.preCheckCast(this.N.get(r2), g.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L19;
        if (r3.f1758a == true) goto L19;
        int r6 = r9.indexOf(r3.f1759b);
        if (r6 == (-1)) goto L19;
        if (r10 == null) goto L19;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.get(r6), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L19;
        this.N.remove(r2);
        r2 = r2 - 1;
        r1 = r1 - 1;
        r3.e();
    L34:
        r2 = r2 + 1;
    L19:
        if (r3.c() == true) goto L23;
        if (r9 == null) goto L34;
        if (r3.f1759b.a(r9, 0, r9.size()) == false) goto L34;
    L23:
        this.N.remove(r2);
        r2 = r2 - 1;
        r1 = r1 - 1;
        if (r9 != null) goto L26;
    L33:
        r3.d();
        goto L34
    L26:
        if (r3.f1758a == true) goto L33;
        int r7 = r9.indexOf(r3.f1759b);
        if (r7 == (-1)) goto L33;
        if (r10 == null) goto L33;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10.get(r7), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L33;
        r3.e();
        goto L34
    L35:
        return;
    L5:
        r1 = r0.size();
        goto L6
    }

    private void b(ArrayList<androidx.fragment.app.a> r7, ArrayList<Boolean> r8) {
        if (r7.isEmpty() == false) goto L6;
        return;
    L6:
        if (r7.size() != r8.size()) goto L27;
        a(r7, r8);
        int r0 = r7.size();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r1 >= r0) goto L23;
        if (((androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r7.get(r1), androidx.fragment.app.a.class, "com.obric.aiagent.plugin")).s == true) goto L22;
        if (r2 == r1) goto L13;
        a(r7, r8, r2, r1);
    L13:
        r2 = r1 + 1;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r1), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L21;
    L15:
        if (r2 >= r0) goto L21;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r8.get(r2), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L21;
        if (((androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r7.get(r2), androidx.fragment.app.a.class, "com.obric.aiagent.plugin")).s == true) goto L21;
        r2 = r2 + 1;
    L21:
        a(r7, r8, r1, r2);
        r1 = r2 - 1;
    L22:
        r1 = r1 + 1;
        goto L8
    L23:
        if (r2 == r0) goto L34;
        a(r7, r8, r2, r0);
        return;
    L34:
        return;
    L27:
        throw new IllegalStateException("Internal error with the back stack records");
    }

    /* JADX WARN: Failed to calculate best type for var: r18v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v10 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v11 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v11 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v12 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r9v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to set immutable type for var: r18v0 'this'  ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v0 'this'  ??, new type: androidx.fragment.app.FragmentManager
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$0(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r9v9 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    private void a(java.util.ArrayList<androidx.fragment.app.a> r19, java.util.ArrayList<java.lang.Boolean> r20, int r21, int r22) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x011b: INVOKE (r9v9 ?? I:int) = (r9v8 java.util.ArrayList<androidx.fragment.app.m$a>) VIRTUAL call: java.util.ArrayList.size():int A[DECLARE_VAR, MD:():int (c)] in method: androidx.fragment.app.FragmentManager.a(java.util.ArrayList<androidx.fragment.app.a>, java.util.ArrayList<java.lang.Boolean>, int, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.a(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    private Set<t> a(ArrayList<androidx.fragment.app.a> r6, int r7, int r8) {
        HashSet r0 = new HashSet();
    L3:
        if (r7 >= r8) goto L13;
        Iterator<m.a> r1 = ((androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r6.get(r7), androidx.fragment.app.a.class, "com.obric.aiagent.plugin")).f1826d.iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        Fragment r2 = ((m.a) ZeusTransformUtils.preCheckCast(r1.next(), m.a.class, "com.obric.aiagent.plugin")).f1829b;
        if (r2 == null) goto L6;
        ViewGroup r3 = r2.mContainer;
        if (r3 == null) goto L6;
        r0.add(t.a(r3, this));
        goto L6
    L12:
        r7 = r7 + 1;
        goto L3
    L13:
        return r0;
    }

    private void a(androidx.b.b<Fragment> r5) {
        int r4 = r5.size();
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L8;
        Fragment r1 = (Fragment) ZeusTransformUtils.preCheckCast(r5.b(r0), Fragment.class, "com.obric.aiagent.plugin");
        if (r1.mAdded == true) goto L7;
        View r2 = r1.requireView();
        r1.mPostponedAlpha = r2.getAlpha();
        r2.setAlpha(0.0f);
    L7:
        r0 = r0 + 1;
        goto L3
    }

    private int a(ArrayList<androidx.fragment.app.a> r8, ArrayList<Boolean> r9, int r10, int r11, androidx.b.b<Fragment> r12) {
        int r0 = r11 - 1;
        int r1 = r11;
    L3:
        if (r0 < r10) goto L23;
        androidx.fragment.app.a r2 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r8.get(r0), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        boolean r3 = ((Boolean) ZeusTransformUtils.preCheckCast(r9.get(r0), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r2.g() == true) goto L7;
    L9:
        boolean r4 = false;
    L10:
        if (r4 == false) goto L22;
        if (this.N != null) goto L14;
        this.N = new ArrayList();
    L14:
        g r5 = new g(r2, r3);
        this.N.add(r5);
        r2.a(r5);
        if (r3 == false) goto L17;
        r2.f();
    L18:
        r1 = r1 - 1;
        if (r0 == r1) goto L21;
        r8.remove(r0);
        r8.add(r1, r2);
    L21:
        b(r12);
        goto L22
    L17:
        r2.b(false);
    L22:
        r0 = r0 - 1;
        goto L3
    L7:
        if (r2.a(r8, r0 + 1, r11) == true) goto L9;
        r4 = true;
        goto L10
    L23:
        return r1;
    }

    void a(androidx.fragment.app.a r10, boolean r11, boolean r12, boolean r13) {
        if (r11 == false) goto L4;
        r10.b(r13);
    L5:
        ArrayList r2 = new ArrayList(1);
        ArrayList r3 = new ArrayList(1);
        r2.add(r10);
        r3.add(Boolean.valueOf(r11));
        if (r12 == true) goto L8;
    L10:
        if (r13 == false) goto L12;
        a(this.f1734c, true);
    L12:
        Iterator<Fragment> r9 = this.i.i().iterator();
    L14:
        if (r9.hasNext() == false) goto L29;
        Fragment r14 = (Fragment) ZeusTransformUtils.preCheckCast(r9.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L14;
        if (r14.mView == null) goto L14;
        if (r14.mIsNewlyAdded == false) goto L14;
        if (r10.b(r14.mContainerId) == false) goto L14;
        if (r14.mPostponedAlpha <= 0.0f) goto L26;
        r14.mView.setAlpha(r14.mPostponedAlpha);
    L26:
        if (r13 == true) goto L27;
        r14.mPostponedAlpha = -1.0f;
        r14.mIsNewlyAdded = false;
        goto L14
    L27:
        r14.mPostponedAlpha = 0.0f;
        goto L14
    L29:
        return;
    L8:
        if (this.f1734c < 1) goto L10;
        n.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.w, r2, r3, 0, 1, true, this.s);
        goto L10
    L4:
        r10.f();
        goto L5
    }

    private static void b(ArrayList<androidx.fragment.app.a> r4, ArrayList<Boolean> r5, int r6, int r7) {
    L2:
        if (r6 >= r7) goto L12;
        androidx.fragment.app.a r0 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(r4.get(r6), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5.get(r6), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L10;
        r0.a(-1);
        if (r6 == (r7 - 1)) goto L9;
        r2 = false;
    L9:
        r0.b(r2);
    L11:
        r6 = r6 + 1;
        goto L2
    L10:
        r0.a(1);
        r0.f();
        goto L11
    }

    private void w(Fragment r4) {
        ViewGroup r3 = x(r4);
        if (r3 != null) goto L5;
        return;
    L5:
        if ((((r4.getEnterAnim() + r4.getExitAnim()) + r4.getPopEnterAnim()) + r4.getPopExitAnim()) > 0) goto L7;
        return;
    L7:
        if (r3.getTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, DbHelper.COL_ID, "visible_removing_fragment_view_tag")) != null) goto L9;
        r3.setTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, DbHelper.COL_ID, "visible_removing_fragment_view_tag"), r4);
    L9:
        ((Fragment) ZeusTransformUtils.preCheckCast(r3.getTag(ZeusTransformUtils.mapRes(R.id.visible_removing_fragment_view_tag, DbHelper.COL_ID, "visible_removing_fragment_view_tag")), Fragment.class, "com.obric.aiagent.plugin")).setPopDirection(r4.getPopDirection());
    }

    private ViewGroup x(Fragment r3) {
        if (r3.mContainer == null) goto L7;
        return r3.mContainer;
    L7:
        if (r3.mContainerId > 0) goto L10;
        return null;
    L10:
        if (this.w.a() == false) goto L15;
        View r2 = this.w.a(r3.mContainerId);
        if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L15;
        return (ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin");
    L15:
        return null;
    }

    private void b(androidx.b.b<Fragment> r6) {
        int r0 = this.f1734c;
        if (r0 >= 1) goto L5;
        return;
    L5:
        int r1 = Math.min(r0, 5);
        Iterator<Fragment> r2 = this.i.h().iterator();
    L7:
        if (r2.hasNext() == false) goto L17;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r2.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r3.mState >= r1) goto L7;
        a(r3, r1);
        if (r3.mView == null) goto L7;
        if (r3.mHidden == true) goto L7;
        if (r3.mIsNewlyAdded == false) goto L7;
        r6.add(r3);
        goto L7
    }

    private void M() {
        if (f1731a == false) goto L9;
        Iterator<t> r3 = O().iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        ((t) ZeusTransformUtils.preCheckCast(r3.next(), t.class, "com.obric.aiagent.plugin")).c();
        goto L6
    L16:
        return;
    L9:
        if (this.N != null) goto L11;
        return;
    L11:
        if (this.N.isEmpty() == true) goto L17;
        ((g) ZeusTransformUtils.preCheckCast(this.N.remove(0), g.class, "com.obric.aiagent.plugin")).d();
        goto L11
    }

    private void N() {
        if (f1731a == false) goto L9;
        Iterator<t> r4 = O().iterator();
    L6:
        if (r4.hasNext() == false) goto L17;
        ((t) ZeusTransformUtils.preCheckCast(r4.next(), t.class, "com.obric.aiagent.plugin")).e();
        goto L6
    L17:
        return;
    L9:
        if (this.r.isEmpty() == true) goto L14;
        Iterator<Fragment> r0 = this.r.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L18;
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.aiagent.plugin");
        t(r2);
        g(r2);
        goto L12
    L18:
        return;
    }

    private Set<t> O() {
        HashSet r0 = new HashSet();
        Iterator<k> r1 = this.i.g().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        ViewGroup r2 = ((k) ZeusTransformUtils.preCheckCast(r1.next(), k.class, "com.obric.aiagent.plugin")).a().mContainer;
        if (r2 == null) goto L4;
        r0.add(t.a(r2, E()));
        goto L4
    L8:
        return r0;
    }

    private boolean c(ArrayList<androidx.fragment.app.a> r8, ArrayList<Boolean> r9) {
        ArrayList<e> r0 = this.g;
        monitor-enter(r0);
        int r2 = 0;
        if (this.g.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L8:
        int r1 = this.g.size();     // Catch: Throwable -> L14
        boolean r3 = false;
    L9:
        if (r2 >= r1) goto L11;
        r3 = r3 | ((e) ZeusTransformUtils.preCheckCast(this.g.get(r2), e.class, "com.obric.aiagent.plugin")).a(r8, r9);     // Catch: Throwable -> L14
        r2 = r2 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        this.g.clear();     // Catch: Throwable -> L14
        this.v.f().removeCallbacks(this.P);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return r3;
    L14:
        th = move-exception;
        throw th;
    }

    private void P() {
        if (this.f1732J == false) goto L6;
        this.f1732J = false;
        J();
        return;
    }

    private void Q() {
        if (this.q == null) goto L8;
        int r0 = 0;
    L6:
        if (r0 >= this.q.size()) goto L10;
        ((d) ZeusTransformUtils.preCheckCast(this.q.get(r0), d.class, "com.obric.aiagent.plugin")).a();
        r0 = r0 + 1;
        goto L6
    L10:
        return;
    }

    void a(androidx.fragment.app.a r2) {
        if (this.f1733b != null) goto L5;
        this.f1733b = new ArrayList();
    L5:
        this.f1733b.add(r2);
    }

    boolean a(ArrayList<androidx.fragment.app.a> r7, ArrayList<Boolean> r8, String r9, int r10, int r11) {
        ArrayList<androidx.fragment.app.a> r0 = this.f1733b;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r9 != null) goto L14;
        if (r10 >= 0) goto L14;
        if ((r11 & 1) != 0) goto L14;
        int r12 = r0.size() - 1;
        if (r12 >= 0) goto L13;
        return false;
    L13:
        r7.add(this.f1733b.remove(r12));
        r8.add(true);
    L52:
        return true;
    L14:
        if (r9 != null) goto L18;
        if (r10 >= 0) goto L18;
        int r13 = -1;
    L47:
        if (r13 != (this.f1733b.size() - 1)) goto L49;
        return false;
    L49:
        int r14 = this.f1733b.size() - 1;
    L50:
        if (r14 <= r13) goto L52;
        r7.add(this.f1733b.remove(r14));
        r8.add(true);
        r14 = r14 - 1;
    L18:
        int r1 = r0.size() - 1;
    L20:
        if (r1 < 0) goto L31;
        androidx.fragment.app.a r4 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(this.f1733b.get(r1), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        if (r9 != null) goto L24;
    L26:
        if (r10 < 0) goto L30;
        if (r10 == r4.f1768c) goto L31;
    L30:
        r1 = r1 - 1;
        goto L20
    L24:
        if (r9.equals(r4.h()) == false) goto L26;
    L31:
        if (r1 >= 0) goto L34;
        return false;
    L34:
        if ((r11 & 1) == 0) goto L45;
    L35:
        r1 = r1 - 1;
        if (r1 < 0) goto L45;
        androidx.fragment.app.a r15 = (androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(this.f1733b.get(r1), androidx.fragment.app.a.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L41;
        if (r9.equals(r15.h()) == true) goto L35;
    L41:
        if (r10 < 0) goto L45;
        if (r10 == r15.f1768c) goto L35;
    L45:
        r13 = r1;
        goto L47
    }

    Parcelable k() {
        M();
        N();
        a(true);
        this.G = true;
        this.O.a(true);
        ArrayList<FragmentState> r0 = this.i.e();
        BackStackState[] r4 = null;
        if (r0.isEmpty() == true) goto L5;
        ArrayList<String> r1 = this.i.f();
        ArrayList<androidx.fragment.app.a> r5 = this.f1733b;
        if (r5 == null) goto L18;
        int r6 = r5.size();
        if (r6 <= 0) goto L18;
        r4 = new BackStackState[r6];
        int r7 = 0;
    L13:
        if (r7 >= r6) goto L18;
        r4[r7] = new BackStackState((androidx.fragment.app.a) ZeusTransformUtils.preCheckCast(this.f1733b.get(r7), androidx.fragment.app.a.class, "com.obric.aiagent.plugin"));
        if (a(2) == false) goto L17;
        c("FragmentManager", "saveAllState: adding back stack #" + r7 + ": " + this.f1733b.get(r7));
    L17:
        r7 = r7 + 1;
    L18:
        FragmentManagerState r2 = new FragmentManagerState();
        r2.mActive = r0;
        r2.mAdded = r1;
        r2.mBackStack = r4;
        r2.mBackStackIndex = this.n.get();
        Fragment r3 = this.f1735d;
        if (r3 == null) goto L21;
        r2.mPrimaryNavActiveWho = r3.mWho;
    L21:
        r2.mResultKeys.addAll(this.o.keySet());
        r2.mResults.addAll(this.o.values());
        r2.mLaunchedFragments = new ArrayList(this.f1736e);
        return r2;
    L5:
        if (a(2) == false) goto L7;
        c("FragmentManager", "saveAllState: no fragments!");
    L7:
        return null;
    }

    void a(Parcelable r13) {
        Parcelable r14 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r13, Parcelable.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L5;
        return;
    L5:
        FragmentManagerState r15 = (FragmentManagerState) ZeusTransformUtils.preCheckCast(r14, FragmentManagerState.class, "com.obric.aiagent.plugin");
        if (r15.mActive != null) goto L8;
        return;
    L8:
        this.i.b();
        Iterator<FragmentState> r0 = r15.mActive.iterator();
    L10:
        if (r0.hasNext() == false) goto L24;
        FragmentState r11 = (FragmentState) ZeusTransformUtils.preCheckCast(r0.next(), FragmentState.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L10;
        Fragment r2 = this.O.a(r11.mWho);
        if (r2 != null) goto L16;
        k r6 = new k(this.t, this.i, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader(), D(), r11);
    L20:
        Fragment r3 = r6.a();
        r3.mFragmentManager = this;
        if (a(2) == false) goto L23;
        c("FragmentManager", "restoreSaveState: active (" + r3.mWho + "): " + r3);
    L23:
        r6.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader());
        this.i.a(r6);
        r6.a(this.f1734c);
        goto L10
    L16:
        if (a(2) == false) goto L18;
        c("FragmentManager", "restoreSaveState: re-attaching retained " + r2);
    L18:
        r6 = new k(this.t, this.i, r2, r11);
        goto L20
    L24:
        Iterator<Fragment> r1 = this.O.c().iterator();
    L26:
        if (r1.hasNext() == false) goto L33;
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(r1.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (this.i.b(r4.mWho) == true) goto L26;
        if (a(2) == false) goto L32;
        c("FragmentManager", "Discarding retained Fragment " + r4 + " that was not found in the set of active Fragments " + r15.mActive);
    L32:
        this.O.c(r4);
        r4.mFragmentManager = this;
        k r7 = new k(this.t, this.i, r4);
        r7.a(1);
        r7.c();
        r4.mRemoving = true;
        r7.c();
        goto L26
    L33:
        this.i.a(r15.mAdded);
        int r5 = 0;
        if (r15.mBackStack == null) goto L42;
        this.f1733b = new ArrayList(r15.mBackStack.length);
        int r8 = 0;
    L37:
        if (r8 >= r15.mBackStack.length) goto L43;
        androidx.fragment.app.a r9 = r15.mBackStack[r8].instantiate(this);
        if (a(2) == false) goto L41;
        c("FragmentManager", "restoreAllState: back stack #" + r8 + " (index " + r9.f1768c + "): " + r9);
        PrintWriter r10 = new PrintWriter(new s("FragmentManager"));
        r9.a("  ", r10, false);
        r10.close();
    L41:
        this.f1733b.add(r9);
        r8 = r8 + 1;
    L43:
        this.n.set(r15.mBackStackIndex);
        if (r15.mPrimaryNavActiveWho == null) goto L46;
        Fragment r12 = d(r15.mPrimaryNavActiveWho);
        this.f1735d = r12;
        y(r12);
    L46:
        ArrayList<String> r16 = r15.mResultKeys;
        if (r16 != null) goto L49;
    L51:
        this.f1736e = new ArrayDeque(r15.mLaunchedFragments);
        return;
    L49:
        if (r5 >= r16.size()) goto L51;
        Bundle r17 = (Bundle) ZeusTransformUtils.preCheckCast(r15.mResults.get(r5), Bundle.class, "com.obric.aiagent.plugin");
        r17.setClassLoader(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.v.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getClassLoader());
        this.o.put(r16.get(r5), r17);
        r5 = r5 + 1;
        goto L49
    L42:
        this.f1733b = null;
        goto L43
    }

    androidx.fragment.app.e<?> l() {
        return this.v;
    }

    Fragment m() {
        return this.x;
    }

    androidx.fragment.app.c n() {
        return this.w;
    }

    l o() {
        return this.i;
    }

    void a(androidx.fragment.app.e<?> r4, androidx.fragment.app.c r5, final Fragment r6) {
        if (this.v != null) goto L34;
        this.v = r4;
        this.w = r5;
        this.x = r6;
        if (r6 == null) goto L8;
        a(new AnonymousClass10(this, r6));
    L11:
        if (this.x == null) goto L14;
        I();
    L14:
        if (ZeusTransformUtils.instanceOf(r4, androidx.activity.d.class) == false) goto L19;
        androidx.activity.d r0 = (androidx.activity.d) ZeusTransformUtils.preCheckCast(r4, androidx.activity.d.class, "com.obric.aiagent.plugin");
        OnBackPressedDispatcher r1 = r0.getOnBackPressedDispatcher();
        this.l = r1;
        androidx.lifecycle.p r2 = r0;
        if (r6 == null) goto L18;
        r2 = r6;
    L18:
        r1.a(r2, this.m);
    L19:
        if (r6 == null) goto L22;
        this.O = r6.mFragmentManager.s(r6);
    L25:
        this.O.a(h());
        this.i.a(this.O);
        if (ZeusTransformUtils.instanceOf(this.v, androidx.activity.result.d.class) == false) goto L35;
        androidx.activity.result.c r7 = ((androidx.activity.result.d) ZeusTransformUtils.preCheckCast(this.v, androidx.activity.result.d.class, "com.obric.aiagent.plugin")).getActivityResultRegistry();
        if (r6 == null) goto L30;
        String r8 = r6.mWho + ":";
    L31:
        String r9 = "FragmentManager:" + r8;
        this.C = r7.a(r9 + "StartActivityForResult", new androidx.activity.result.a.b.C0006b(), new AnonymousClass11(this));
        this.D = r7.a(r9 + "StartIntentSenderForResult", new a(), new AnonymousClass2(this));
        this.E = r7.a(r9 + "RequestPermissions", new androidx.activity.result.a.b.a(), new AnonymousClass3(this));
        return;
    L30:
        r8 = "";
        goto L31
    L35:
        return;
    L22:
        if (ZeusTransformUtils.instanceOf(r4, ap.class) == false) goto L24;
        this.O = h.a(((ap) ZeusTransformUtils.preCheckCast(r4, ap.class, "com.obric.aiagent.plugin")).getViewModelStore());
        goto L25
    L24:
        this.O = new h(false);
        goto L25
    L8:
        if (ZeusTransformUtils.instanceOf(r4, i.class) == false) goto L11;
        a((i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.aiagent.plugin"));
        goto L11
    L34:
        throw new IllegalStateException("Already attached");
    }

    void p() {
        if (this.v != null) goto L5;
        return;
    L5:
        this.G = false;
        this.H = false;
        this.O.a(false);
        Iterator<Fragment> r3 = this.i.h().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        r0.noteStateNotSaved();
        goto L7
    }

    void a(Fragment r2, Intent r3, int r4, Bundle r5) {
        if (this.C == null) goto L9;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.f1736e.addLast(r0);
        if (r3 == null) goto L8;
        if (r5 == null) goto L8;
        r3.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r5);
    L8:
        this.C.a(r3);
        return;
    L9:
        this.v.a(r2, r3, r4, r5);
    }

    void a(Fragment r11, IntentSender r12, int r13, Intent r14, int r15, int r16, int r17, Bundle r18) {
        if (this.D != null) goto L5;
        this.v.a(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    L5:
        if (r18 == null) goto L13;
        if (r14 != null) goto L8;
        Intent r4 = new Intent();
        r4.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
    L10:
        if (a(2) == false) goto L12;
        c("FragmentManager", "ActivityOptions " + r18 + " were added to fillInIntent " + r4 + " for fragment " + r11);
    L12:
        r4.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", r18);
    L14:
        IntentSenderRequest r5 = new IntentSenderRequest.a(r12).a(r4).a(r16, r15).a();
        this.f1736e.addLast(new LaunchedFragmentInfo(r11.mWho, r13));
        if (a(2) == false) goto L17;
        c("FragmentManager", "Fragment " + r11 + "is launching an IntentSender for result ");
    L17:
        this.D.a(r5);
        return;
    L8:
        r4 = r14;
        goto L10
    L13:
        r4 = r14;
        goto L14
    }

    void a(Fragment r2, String[] r3, int r4) {
        if (this.E == null) goto L5;
        LaunchedFragmentInfo r0 = new LaunchedFragmentInfo(r2.mWho, r4);
        this.f1736e.addLast(r0);
        this.E.a(r3);
        return;
    L5:
        this.v.a(r2, r3, r4);
    }

    void q() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        e(0);
    }

    void r() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        e(1);
    }

    void s() {
        e(2);
    }

    void t() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        e(4);
    }

    void u() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        e(5);
    }

    void v() {
        this.G = false;
        this.H = false;
        this.O.a(false);
        e(7);
    }

    void w() {
        e(5);
    }

    void x() {
        this.H = true;
        this.O.a(true);
        e(4);
    }

    void y() {
        e(1);
    }

    void z() {
        this.I = true;
        a(true);
        N();
        e(-1);
        this.v = null;
        this.w = null;
        this.x = null;
        if (this.l == null) goto L5;
        this.m.b();
        this.l = null;
    L5:
        androidx.activity.result.b<Intent> r0 = this.C;
        if (r0 == null) goto L9;
        r0.a();
        this.D.a();
        this.E.a();
        return;
    }

    private void e(int r6) {
        this.h = true;     // Catch: Throwable -> L12
        this.i.a(r6);     // Catch: Throwable -> L12
        a(r6, false);     // Catch: Throwable -> L12
        if (f1731a == false) goto L10;
        Iterator<t> r7 = O().iterator();     // Catch: Throwable -> L12
    L7:
        if (r7.hasNext() == false) goto L10;
        ((t) ZeusTransformUtils.preCheckCast(r7.next(), t.class, "com.obric.aiagent.plugin")).e();     // Catch: Throwable -> L12
    L10:
        this.h = false;
        a(true);
        return;
    L12:
        th = move-exception;
        this.h = false;
        throw th;
    }

    void b(boolean r4) {
        Iterator<Fragment> r3 = this.i.h().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.performMultiWindowModeChanged(r4);
        goto L4
    }

    void c(boolean r4) {
        Iterator<Fragment> r3 = this.i.h().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.performPictureInPictureModeChanged(r4);
        goto L4
    }

    void a(Configuration r4) {
        Iterator<Fragment> r3 = this.i.h().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.performConfigurationChanged(r4);
        goto L4
    }

    void A() {
        Iterator<Fragment> r3 = this.i.h().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L4;
        r0.performLowMemory();
        goto L4
    }

    boolean a(Menu r9, MenuInflater r10) {
        Menu r11 = (Menu) ZeusTransformUtils.wrapperContextForParams(r9, Menu.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (this.f1734c >= 1) goto L5;
        return false;
    L5:
        ArrayList<Fragment> r0 = null;
        Iterator<Fragment> r4 = this.i.h().iterator();
        boolean r5 = false;
    L7:
        if (r4.hasNext() == false) goto L18;
        Fragment r6 = (Fragment) ZeusTransformUtils.preCheckCast(r4.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L7;
        if (b(r6) == false) goto L7;
        if (r6.performCreateOptionsMenu(r11, r10) == false) goto L7;
        if (r0 != null) goto L16;
        r0 = new ArrayList();
    L16:
        r0.add(r6);
        r5 = true;
        goto L7
    L18:
        if (this.j != null) goto L20;
    L27:
        this.j = r0;
        return r5;
    L20:
        if (r2 >= this.j.size()) goto L27;
        Fragment r12 = (Fragment) ZeusTransformUtils.preCheckCast(this.j.get(r2), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L24;
    L25:
        r12.onDestroyOptionsMenu();
    L26:
        r2 = r2 + 1;
        goto L20
    L24:
        if (r0.contains(r12) == true) goto L26;
        goto L25
    }

    boolean a(Menu r7) {
        Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r7, Menu.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (this.f1734c >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r0 = this.i.h().iterator();
    L7:
        if (r0.hasNext() == false) goto L15;
        Fragment r4 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L7;
        if (b(r4) == false) goto L7;
        if (r4.performPrepareOptionsMenu(r8) == false) goto L7;
        r2 = true;
        goto L7
    L15:
        return r2;
    }

    boolean a(MenuItem r6) {
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.aiagent.plugin");
        if (this.f1734c >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r5 = this.i.h().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r5.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        if (r0.performOptionsItemSelected(r7) == false) goto L7;
        return true;
    L13:
        return false;
    }

    boolean b(MenuItem r6) {
        MenuItem r7 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r6, MenuItem.class, "com.obric.aiagent.plugin");
        if (this.f1734c >= 1) goto L5;
        return false;
    L5:
        Iterator<Fragment> r5 = this.i.h().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r5.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        if (r0.performContextItemSelected(r7) == false) goto L7;
        return true;
    L13:
        return false;
    }

    void b(Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        if (this.f1734c >= 1) goto L5;
        return;
    L5:
        Iterator<Fragment> r3 = this.i.h().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(r3.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        r0.performOptionsMenuClosed(r5);
        goto L7
    }

    void p(Fragment r4) {
        if (r4 != null) goto L4;
    L12:
        Fragment r0 = this.f1735d;
        this.f1735d = r4;
        y(r0);
        y(this.f1735d);
        return;
    L4:
        if (r4.equals(d(r4.mWho)) == false) goto L11;
        if (r4.mHost == null) goto L12;
        if (r4.mFragmentManager == this) goto L12;
    L11:
        throw new IllegalArgumentException("Fragment " + r4 + " is not an active fragment of FragmentManager " + this);
    }

    private void y(Fragment r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.equals(d(r2.mWho)) == false) goto L8;
        r2.performPrimaryNavigationFragmentChanged();
        return;
    }

    void B() {
        I();
        y(this.f1735d);
    }

    public Fragment C() {
        return this.f1735d;
    }

    void a(Fragment r3, androidx.lifecycle.i.b r4) {
        if (r3.equals(d(r3.mWho)) == false) goto L11;
        if (r3.mHost != null) goto L7;
    L8:
        r3.mMaxState = r4;
        return;
    L7:
        if (r3.mFragmentManager == this) goto L8;
    L11:
        throw new IllegalArgumentException("Fragment " + r3 + " is not an active fragment of FragmentManager " + this);
    }

    public FragmentFactory D() {
        FragmentFactory r0 = this.y;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.x;
        if (r1 == null) goto L10;
        return r1.mFragmentManager.D();
    L10:
        return this.z;
    }

    u E() {
        u r0 = this.A;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Fragment r1 = this.x;
        if (r1 == null) goto L10;
        return r1.mFragmentManager.E();
    L10:
        return this.B;
    }

    androidx.fragment.app.f F() {
        return this.t;
    }

    public void a(b r1, boolean r2) {
        this.t.a(r1, r2);
    }

    public void a(b r1) {
        this.t.a(r1);
    }

    public void a(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        this.u.add(r4);
    }

    void q(Fragment r5) {
        Iterator<i> r0 = this.u.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.aiagent.plugin")).a(this, r5);
        goto L4
    }

    boolean G() {
        Iterator<Fragment> r0 = this.i.i().iterator();
        boolean r2 = false;
    L4:
        if (r0.hasNext() == false) goto L11;
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(r0.next(), Fragment.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        r2 = z(r3);
    L8:
        if (r2 == false) goto L4;
        return true;
    L11:
        return false;
    }

    private boolean z(Fragment r1) {
        if (r1.mHasMenu == false) goto L7;
        if (r1.mMenuVisible == false) goto L7;
    L8:
        return true;
    L7:
        if (r1.mChildFragmentManager.G() == true) goto L8;
        return false;
    }

    void r(Fragment r2) {
        if (r2.mAdded == true) goto L5;
        return;
    L5:
        if (z(r2) == false) goto L9;
        this.F = true;
        return;
    }

    LayoutInflater.Factory2 H() {
        return this.k;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
