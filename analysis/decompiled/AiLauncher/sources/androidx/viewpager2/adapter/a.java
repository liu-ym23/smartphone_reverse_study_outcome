package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.j;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.K;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class a extends RecyclerView.Adapter<androidx.viewpager2.adapter.b> implements androidx.viewpager2.adapter.c {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    final FragmentManager mFragmentManager;
    private g mFragmentMaxLifecycleEnforcer;
    final Lifecycle mLifecycle;
    final j<Fragment> mFragments = new j<>();
    private final j<Fragment.SavedState> mSavedStates = new j<>();
    private final j<Integer> mItemIdToViewHolder = new j<>();
    f mFragmentEventDispatcher = new f();
    boolean mIsInGracePeriod = false;
    private boolean mHasStaleFragments = false;

    /* renamed from: androidx.viewpager2.adapter.a$a, reason: collision with other inner class name */
    public class C0185a implements InterfaceC1395m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.viewpager2.adapter.b f15075a;

        public C0185a(androidx.viewpager2.adapter.b bVar) {
            this.f15075a = bVar;
        }

        @Override // android.view.InterfaceC1395m
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (a.this.v()) {
                return;
            }
            lifecycleOwner.getLifecycle().d(this);
            if (this.f15075a.b().isAttachedToWindow()) {
                a.this.r(this.f15075a);
            }
        }
    }

    public class b extends FragmentManager.k {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f15077a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f15078b;

        public b(Fragment fragment, FrameLayout frameLayout) {
            this.f15077a = fragment;
            this.f15078b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.k
        public void m(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment == this.f15077a) {
                fragmentManager.C1(this);
                a.this.c(view, this.f15078b);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.mIsInGracePeriod = false;
            aVar.h();
        }
    }

    public class d implements InterfaceC1395m {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f15081a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f15082b;

        public d(Handler handler, Runnable runnable) {
            this.f15081a = handler;
            this.f15082b = runnable;
        }

        @Override // android.view.InterfaceC1395m
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f15081a.removeCallbacks(this.f15082b);
                lifecycleOwner.getLifecycle().d(this);
            }
        }
    }

    public static abstract class e extends RecyclerView.AdapterDataObserver {
        public e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        public /* synthetic */ e(C0185a c0185a) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public List<h> f15084a = new CopyOnWriteArrayList();

        public List<h.b> a(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.f15084a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a(fragment, state));
            }
            return arrayList;
        }

        public void b(List<h.b> list) {
            Iterator<h.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        public List<h.b> c(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.f15084a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().b(fragment));
            }
            return arrayList;
        }

        public List<h.b> d(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.f15084a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().c(fragment));
            }
            return arrayList;
        }

        public List<h.b> e(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator<h> it = this.f15084a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().d(fragment));
            }
            return arrayList;
        }
    }

    public class g {

        /* renamed from: a, reason: collision with root package name */
        public ViewPager2.i f15085a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.AdapterDataObserver f15086b;

        /* renamed from: c, reason: collision with root package name */
        public InterfaceC1395m f15087c;

        /* renamed from: d, reason: collision with root package name */
        public ViewPager2 f15088d;

        /* renamed from: e, reason: collision with root package name */
        public long f15089e = -1;

        /* renamed from: androidx.viewpager2.adapter.a$g$a, reason: collision with other inner class name */
        public class C0186a extends ViewPager2.i {
            public C0186a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageScrollStateChanged(int i10) {
                g.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.i
            public void onPageSelected(int i10) {
                g.this.d(false);
            }
        }

        public class b extends e {
            public b() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.a.e, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                g.this.d(true);
            }
        }

        public class c implements InterfaceC1395m {
            public c() {
            }

            @Override // android.view.InterfaceC1395m
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                g.this.d(false);
            }
        }

        public g() {
        }

        public final ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(RecyclerView recyclerView) {
            this.f15088d = a(recyclerView);
            C0186a c0186a = new C0186a();
            this.f15085a = c0186a;
            this.f15088d.j(c0186a);
            b bVar = new b();
            this.f15086b = bVar;
            a.this.registerAdapterDataObserver(bVar);
            c cVar = new c();
            this.f15087c = cVar;
            a.this.mLifecycle.a(cVar);
        }

        public void c(RecyclerView recyclerView) {
            a(recyclerView).r(this.f15085a);
            a.this.unregisterAdapterDataObserver(this.f15086b);
            a.this.mLifecycle.d(this.f15087c);
            this.f15088d = null;
        }

        public void d(boolean z10) {
            int currentItem;
            Fragment fragmentH;
            if (a.this.v() || this.f15088d.getScrollState() != 0 || a.this.mFragments.j() || a.this.getItemCount() == 0 || (currentItem = this.f15088d.getCurrentItem()) >= a.this.getItemCount()) {
                return;
            }
            long itemId = a.this.getItemId(currentItem);
            if ((itemId != this.f15089e || z10) && (fragmentH = a.this.mFragments.h(itemId)) != null && fragmentH.isAdded()) {
                this.f15089e = itemId;
                K kQ = a.this.mFragmentManager.q();
                ArrayList arrayList = new ArrayList();
                Fragment fragment = null;
                for (int i10 = 0; i10 < a.this.mFragments.r(); i10++) {
                    long jK = a.this.mFragments.k(i10);
                    Fragment fragmentS = a.this.mFragments.s(i10);
                    if (fragmentS.isAdded()) {
                        if (jK != this.f15089e) {
                            Lifecycle.State state = Lifecycle.State.STARTED;
                            kQ.u(fragmentS, state);
                            arrayList.add(a.this.mFragmentEventDispatcher.a(fragmentS, state));
                        } else {
                            fragment = fragmentS;
                        }
                        fragmentS.setMenuVisibility(jK == this.f15089e);
                    }
                }
                if (fragment != null) {
                    Lifecycle.State state2 = Lifecycle.State.RESUMED;
                    kQ.u(fragment, state2);
                    arrayList.add(a.this.mFragmentEventDispatcher.a(fragment, state2));
                }
                if (kQ.n()) {
                    return;
                }
                kQ.i();
                Collections.reverse(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    a.this.mFragmentEventDispatcher.b((List) it.next());
                }
            }
        }
    }

    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15094a = new C0187a();

        /* renamed from: androidx.viewpager2.adapter.a$h$a, reason: collision with other inner class name */
        public class C0187a implements b {
            @Override // androidx.viewpager2.adapter.a.h.b
            public void a() {
            }
        }

        public interface b {
            void a();
        }

        public b a(Fragment fragment, Lifecycle.State state) {
            return f15094a;
        }

        public b b(Fragment fragment) {
            return f15094a;
        }

        public b c(Fragment fragment) {
            return f15094a;
        }

        public b d(Fragment fragment) {
            return f15094a;
        }
    }

    public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }

    public static String f(String str, long j10) {
        return str + j10;
    }

    public static boolean j(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    public static long q(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    @Override // androidx.viewpager2.adapter.c
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.mFragments.r() + this.mSavedStates.r());
        for (int i10 = 0; i10 < this.mFragments.r(); i10++) {
            long jK = this.mFragments.k(i10);
            Fragment fragmentH = this.mFragments.h(jK);
            if (fragmentH != null && fragmentH.isAdded()) {
                this.mFragmentManager.k1(bundle, f(KEY_PREFIX_FRAGMENT, jK), fragmentH);
            }
        }
        for (int i11 = 0; i11 < this.mSavedStates.r(); i11++) {
            long jK2 = this.mSavedStates.k(i11);
            if (d(jK2)) {
                bundle.putParcelable(f(KEY_PREFIX_STATE, jK2), this.mSavedStates.h(jK2));
            }
        }
        return bundle;
    }

    @Override // androidx.viewpager2.adapter.c
    public final void b(Parcelable parcelable) {
        if (!this.mSavedStates.j() || !this.mFragments.j()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (j(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.n(q(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.v0(bundle, str));
            } else {
                if (!j(str, KEY_PREFIX_STATE)) {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
                long jQ = q(str, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (d(jQ)) {
                    this.mSavedStates.n(jQ, savedState);
                }
            }
        }
        if (this.mFragments.j()) {
            return;
        }
        this.mHasStaleFragments = true;
        this.mIsInGracePeriod = true;
        h();
        t();
    }

    public void c(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    public boolean d(long j10) {
        return j10 >= 0 && j10 < ((long) getItemCount());
    }

    public abstract Fragment e(int i10);

    public final void g(int i10) {
        long itemId = getItemId(i10);
        if (this.mFragments.f(itemId)) {
            return;
        }
        Fragment fragmentE = e(i10);
        fragmentE.setInitialSavedState(this.mSavedStates.h(itemId));
        this.mFragments.n(itemId, fragmentE);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    public void h() {
        if (!this.mHasStaleFragments || v()) {
            return;
        }
        androidx.collection.b bVar = new androidx.collection.b();
        for (int i10 = 0; i10 < this.mFragments.r(); i10++) {
            long jK = this.mFragments.k(i10);
            if (!d(jK)) {
                bVar.add(Long.valueOf(jK));
                this.mItemIdToViewHolder.o(jK);
            }
        }
        if (!this.mIsInGracePeriod) {
            this.mHasStaleFragments = false;
            for (int i11 = 0; i11 < this.mFragments.r(); i11++) {
                long jK2 = this.mFragments.k(i11);
                if (!i(jK2)) {
                    bVar.add(Long.valueOf(jK2));
                }
            }
        }
        Iterator<E> it = bVar.iterator();
        while (it.hasNext()) {
            s(((Long) it.next()).longValue());
        }
    }

    public final boolean i(long j10) {
        View view;
        if (this.mItemIdToViewHolder.f(j10)) {
            return true;
        }
        Fragment fragmentH = this.mFragments.h(j10);
        return (fragmentH == null || (view = fragmentH.getView()) == null || view.getParent() == null) ? false : true;
    }

    public final Long k(int i10) {
        Long lValueOf = null;
        for (int i11 = 0; i11 < this.mItemIdToViewHolder.r(); i11++) {
            if (this.mItemIdToViewHolder.s(i11).intValue() == i10) {
                if (lValueOf != null) {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
                lValueOf = Long.valueOf(this.mItemIdToViewHolder.k(i11));
            }
        }
        return lValueOf;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(androidx.viewpager2.adapter.b bVar, int i10) {
        long itemId = bVar.getItemId();
        int id = bVar.b().getId();
        Long lK = k(id);
        if (lK != null && lK.longValue() != itemId) {
            s(lK.longValue());
            this.mItemIdToViewHolder.o(lK.longValue());
        }
        this.mItemIdToViewHolder.n(itemId, Integer.valueOf(id));
        g(i10);
        if (bVar.b().isAttachedToWindow()) {
            r(bVar);
        }
        h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final androidx.viewpager2.adapter.b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return androidx.viewpager2.adapter.b.a(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final boolean onFailedToRecycleView(androidx.viewpager2.adapter.b bVar) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final void onViewAttachedToWindow(androidx.viewpager2.adapter.b bVar) {
        r(bVar);
        h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        B0.h.a(this.mFragmentMaxLifecycleEnforcer == null);
        g gVar = new g();
        this.mFragmentMaxLifecycleEnforcer = gVar;
        gVar.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.c(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final void onViewRecycled(androidx.viewpager2.adapter.b bVar) {
        Long lK = k(bVar.b().getId());
        if (lK != null) {
            s(lK.longValue());
            this.mItemIdToViewHolder.o(lK.longValue());
        }
    }

    public void r(androidx.viewpager2.adapter.b bVar) {
        Fragment fragmentH = this.mFragments.h(bVar.getItemId());
        if (fragmentH == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutB = bVar.b();
        View view = fragmentH.getView();
        if (!fragmentH.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragmentH.isAdded() && view == null) {
            u(fragmentH, frameLayoutB);
            return;
        }
        if (fragmentH.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayoutB) {
                c(view, frameLayoutB);
                return;
            }
            return;
        }
        if (fragmentH.isAdded()) {
            c(view, frameLayoutB);
            return;
        }
        if (v()) {
            if (this.mFragmentManager.M0()) {
                return;
            }
            this.mLifecycle.a(new C0185a(bVar));
            return;
        }
        u(fragmentH, frameLayoutB);
        List<h.b> listC = this.mFragmentEventDispatcher.c(fragmentH);
        try {
            fragmentH.setMenuVisibility(false);
            this.mFragmentManager.q().d(fragmentH, "f" + bVar.getItemId()).u(fragmentH, Lifecycle.State.STARTED).i();
            this.mFragmentMaxLifecycleEnforcer.d(false);
        } finally {
            this.mFragmentEventDispatcher.b(listC);
        }
    }

    public final void s(long j10) {
        ViewParent parent;
        Fragment fragmentH = this.mFragments.h(j10);
        if (fragmentH == null) {
            return;
        }
        if (fragmentH.getView() != null && (parent = fragmentH.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!d(j10)) {
            this.mSavedStates.o(j10);
        }
        if (!fragmentH.isAdded()) {
            this.mFragments.o(j10);
            return;
        }
        if (v()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragmentH.isAdded() && d(j10)) {
            List<h.b> listE = this.mFragmentEventDispatcher.e(fragmentH);
            Fragment.SavedState savedStateT1 = this.mFragmentManager.t1(fragmentH);
            this.mFragmentEventDispatcher.b(listE);
            this.mSavedStates.n(j10, savedStateT1);
        }
        List<h.b> listD = this.mFragmentEventDispatcher.d(fragmentH);
        try {
            this.mFragmentManager.q().o(fragmentH).i();
            this.mFragments.o(j10);
        } finally {
            this.mFragmentEventDispatcher.b(listD);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public final void t() {
        Handler handler = new Handler(Looper.getMainLooper());
        c cVar = new c();
        this.mLifecycle.a(new d(handler, cVar));
        handler.postDelayed(cVar, 10000L);
    }

    public final void u(Fragment fragment, FrameLayout frameLayout) {
        this.mFragmentManager.l1(new b(fragment, frameLayout), false);
    }

    public boolean v() {
        return this.mFragmentManager.U0();
    }
}
