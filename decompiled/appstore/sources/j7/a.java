package j7;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.StatefulAdapter;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends RecyclerView.Adapter implements StatefulAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lifecycle f20915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentManager f20916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.c f20917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.collection.c f20918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.collection.c f20919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f20920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f20921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20922h;

    /* JADX INFO: renamed from: j7.a$a, reason: collision with other inner class name */
    public class ViewOnLayoutChangeListenerC0280a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f20923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j7.b f20924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f20925c;

        public ViewOnLayoutChangeListenerC0280a(a r10, FrameLayout r11, j7.b r12) {
            this.f20925c = r10;
            this.f20923a = r11;
            this.f20924b = r12;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
            if (this.f20923a.getParent() == null) goto L6;
            this.f20923a.removeOnLayoutChangeListener(this);
            this.f20925c.p(this.f20924b);
            return;
        }
    }

    public class b implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j7.b f20926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f20927b;

        public b(a r10, j7.b r11) {
            this.f20927b = r10;
            this.f20926a = r11;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (this.f20927b.t() == false) goto L5;
            return;
        L5:
            r10.getLifecycle().d(this);
            if (ViewCompat.S(this.f20926a.b()) == false) goto L9;
            this.f20927b.p(this.f20926a);
            return;
        }
    }

    public class c extends FragmentManager.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f20928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FrameLayout f20929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f20930c;

        public c(a r10, Fragment r11, FrameLayout r12) {
            this.f20930c = r10;
            this.f20928a = r11;
            this.f20929b = r12;
        }

        @Override // androidx.fragment.app.FragmentManager.l
        public void m(FragmentManager r10, Fragment r11, View r12, Bundle r13) {
            if (r11 != this.f20928a) goto L6;
            r10.I1(this);
            this.f20930c.a(r12, this.f20929b);
            return;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20931a;

        public d(a r10) {
            this.f20931a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r10 = this.f20931a;
            r10.f20921g = false;
            r10.f();
        }
    }

    public class e implements LifecycleEventObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f20932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f20933b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f20934c;

        public e(a r10, Handler r11, Runnable r12) {
            this.f20934c = r10;
            this.f20932a = r11;
            this.f20933b = r12;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
            if (r11 != Lifecycle.Event.ON_DESTROY) goto L6;
            this.f20932a.removeCallbacks(this.f20933b);
            r10.getLifecycle().d(this);
            return;
        }
    }

    public static abstract class f extends RecyclerView.AdapterDataObserver {
        public f() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int r10, int r11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int r10, int r11, int r12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int r10, int r11) {
            onChanged();
        }

        public /* synthetic */ f(ViewOnLayoutChangeListenerC0280a r10) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int r10, int r11, Object r12) {
            onChanged();
        }
    }

    public class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ViewPager2.h f20935a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.AdapterDataObserver f20936b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LifecycleEventObserver f20937c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ViewPager2 f20938d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f20939e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ a f20940f;

        /* JADX INFO: renamed from: j7.a$g$a, reason: collision with other inner class name */
        public class C0281a extends ViewPager2.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f20941a;

            public C0281a(g r10) {
                this.f20941a = r10;
            }

            @Override // androidx.viewpager2.widget.ViewPager2.h
            public void onPageScrollStateChanged(int r10) {
                this.f20941a.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.h
            public void onPageSelected(int r10) {
                this.f20941a.d(false);
            }
        }

        public class b extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f20942a;

            public b(g r10) {
                this.f20942a = r10;
                super(null);
            }

            @Override // j7.a.f, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                this.f20942a.d(true);
            }
        }

        public class c implements LifecycleEventObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f20943a;

            public c(g r10) {
                this.f20943a = r10;
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
                this.f20943a.d(false);
            }
        }

        public g(a r10) {
            this.f20940f = r10;
            this.f20939e = -1;
        }

        public final ViewPager2 a(RecyclerView r10) {
            ViewParent r11 = r10.getParent();
            if ((r11 instanceof ViewPager2) == false) goto L7;
            return (ViewPager2) r11;
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r11);
        }

        public void b(RecyclerView r10) {
            this.f20938d = a(r10);
            C0281a r11 = new C0281a(this);
            this.f20935a = r11;
            this.f20938d.g(r11);
            b r12 = new b(this);
            this.f20936b = r12;
            this.f20940f.registerAdapterDataObserver(r12);
            c r13 = new c(this);
            this.f20937c = r13;
            this.f20940f.f20915a.a(r13);
        }

        public void c(RecyclerView r10) {
            a(r10).n(this.f20935a);
            this.f20940f.unregisterAdapterDataObserver(this.f20936b);
            this.f20940f.f20915a.d(this.f20937c);
            this.f20938d = null;
        }

        public void d(boolean r10) {
            if (this.f20940f.t() == false) goto L6;
            return;
        L6:
            if (this.f20938d.getScrollState() == 0) goto L9;
            return;
        L9:
            if (this.f20940f.f20917c.h() == false) goto L11;
            return;
        L11:
            if (this.f20940f.getItemCount() == 0) goto L53;
            int r11 = this.f20938d.getCurrentItem();
            if (r11 < this.f20940f.getItemCount()) goto L16;
            return;
        L16:
            long r12 = this.f20940f.getItemId(r11);
            if (r12 != this.f20939e) goto L20;
            if (r10 == true) goto L20;
            return;
        L20:
            Fragment r13 = (Fragment) this.f20940f.f20917c.e(r12);
            if (r13 != null) goto L23;
            return;
        L23:
            if (r13.isAdded() == false) goto L54;
            this.f20939e = r12;
            FragmentTransaction r14 = this.f20940f.f20916b.o();
            Fragment r15 = null;
            int r16 = 0;
        L27:
            if (r16 >= this.f20940f.f20917c.m()) goto L41;
            long r17 = this.f20940f.f20917c.i(r16);
            Fragment r18 = (Fragment) this.f20940f.f20917c.n(r16);
            if (r18.isAdded() == false) goto L40;
            if (r17 == this.f20939e) goto L34;
            r14.x(r18, Lifecycle.State.STARTED);
        L36:
            if (r17 != this.f20939e) goto L38;
            boolean r19 = true;
        L39:
            r18.setMenuVisibility(r19);
            goto L40
        L38:
            r19 = false;
            goto L39
        L34:
            r15 = r18;
        L40:
            r16 = r16 + 1;
            goto L27
        L41:
            if (r15 == null) goto L44;
            r14.x(r15, Lifecycle.State.RESUMED);
        L44:
            if (r14.s() == true) goto L52;
            r14.l();
            return;
        L52:
            return;
        L54:
            return;
        }
    }

    public a(Fragment r10) {
        this(r10.getChildFragmentManager(), r10.getLifecycle());
    }

    private static String d(String r10, long r11) {
        return r10 + r11;
    }

    private void e(int r10) {
        long r11 = getItemId(r10);
        if (this.f20917c.c(r11) == true) goto L6;
        Fragment r12 = c(r10);
        this.f20917c.j(r11, r12);
        return;
    }

    private boolean g(long r10) {
        if (this.f20919e.c(r10) == false) goto L5;
        return true;
    L5:
        Fragment r11 = (Fragment) this.f20917c.e(r10);
        if (r11 != null) goto L8;
        return false;
    L8:
        View r12 = r11.getView();
        if (r12 != null) goto L12;
        return false;
    L12:
        if (r12.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private static boolean h(String r10, String r11) {
        if (r10.startsWith(r11) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.length() <= r11.length()) goto L7;
        return true;
    }

    private Long i(int r10) {
        Long r11 = null;
        int r12 = 0;
    L4:
        if (r12 >= this.f20919e.m()) goto L12;
        if (((Integer) this.f20919e.n(r12)).intValue() != r10) goto L11;
        if (r11 != null) goto L10;
        r11 = Long.valueOf(this.f20919e.i(r12));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r12 = r12 + 1;
        goto L4
    L12:
        return r11;
    }

    private static long o(String r10, String r11) {
        return Long.parseLong(r10.substring(r11.length()));
    }

    private void q(long r10) {
        Fragment r11 = (Fragment) this.f20917c.e(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        if (r11.getView() == null) goto L11;
        ViewParent r12 = r11.getView().getParent();
        if (r12 == null) goto L11;
        ((FrameLayout) r12).removeAllViews();
    L11:
        if (b(r10) == true) goto L14;
        this.f20918d.k(r10);
    L14:
        if (r11.isAdded() == true) goto L18;
        this.f20917c.k(r10);
        return;
    L18:
        if (t() == false) goto L22;
        this.f20922h = true;
        return;
    L22:
        if (r11.isAdded() == true) goto L24;
    L26:
        this.f20916b.o().t(r11).l();
        this.f20917c.k(r10);
        return;
    L24:
        if (b(r10) == false) goto L26;
        this.f20918d.j(r10, this.f20916b.z1(r11));
        goto L26
    }

    private void r() {
        Handler r10 = new Handler(Looper.getMainLooper());
        d r11 = new d(this);
        this.f20915a.a(new e(this, r10, r11));
        r10.postDelayed(r11, 10000);
    }

    private void s(Fragment r10, FrameLayout r11) {
        this.f20916b.n1(new c(this, r10, r11), false);
    }

    public void a(View r10, FrameLayout r11) {
        if (r11.getChildCount() > 1) goto L16;
        if (r10.getParent() != r11) goto L8;
        return;
    L8:
        if (r11.getChildCount() <= 0) goto L11;
        r11.removeAllViews();
    L11:
        if (r10.getParent() == null) goto L13;
        ((ViewGroup) r10.getParent()).removeView(r10);
    L13:
        r11.addView(r10);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean b(long r10) {
        if (r10 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= getItemCount()) goto L7;
        return true;
    }

    public abstract Fragment c(int r10);

    public void f() {
        if (this.f20922h == true) goto L5;
        return;
    L5:
        if (t() == true) goto L35;
        androidx.collection.a r10 = new androidx.collection.a();
        int r11 = 0;
        int r12 = 0;
    L9:
        if (r12 >= this.f20917c.m()) goto L15;
        long r13 = this.f20917c.i(r12);
        if (b(r13) == true) goto L13;
        r10.add(Long.valueOf(r13));
        this.f20919e.k(r13);
    L13:
        r12 = r12 + 1;
        goto L9
    L15:
        if (this.f20921g == true) goto L23;
        this.f20922h = false;
    L18:
        if (r11 >= this.f20917c.m()) goto L23;
        long r14 = this.f20917c.i(r11);
        if (g(r14) == true) goto L22;
        r10.add(Long.valueOf(r14));
    L22:
        r11 = r11 + 1;
    L23:
        Iterator r15 = r10.iterator();
    L25:
        if (r15.hasNext() == false) goto L36;
        q(((Long) r15.next()).longValue());
        goto L25
    L36:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    public final void j(j7.b r10, int r11) {
        long r12 = r10.getItemId();
        int r13 = r10.b().getId();
        Long r14 = i(r13);
        if (r14 != null) goto L5;
    L7:
        this.f20919e.j(r12, Integer.valueOf(r13));
        e(r11);
        FrameLayout r15 = r10.b();
        if (ViewCompat.S(r15) == true) goto L10;
    L14:
        f();
        return;
    L10:
        if (r15.getParent() != null) goto L13;
        r15.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0280a(this, r15, r10));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r14.longValue() == r12) goto L7;
        q(r14.longValue());
        this.f20919e.k(r14.longValue());
        goto L7
    }

    public final j7.b k(ViewGroup r10, int r11) {
        return j7.b.a(r10);
    }

    public final boolean l(j7.b r10) {
        return true;
    }

    public final void m(j7.b r10) {
        p(r10);
        f();
    }

    public final void n(j7.b r10) {
        Long r11 = i(r10.b().getId());
        if (r11 == null) goto L6;
        q(r11.longValue());
        this.f20919e.k(r11.longValue());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView r10) {
        if (this.f20920f != null) goto L5;
        boolean r11 = true;
    L6:
        androidx.core.util.e.a(r11);
        g r12 = new g(this);
        this.f20920f = r12;
        r12.b(r10);
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        j((j7.b) r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return k(r10, r11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView r10) {
        this.f20920f.c(r10);
        this.f20920f = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder r10) {
        return l((j7.b) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        m((j7.b) r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r10) {
        n((j7.b) r10);
    }

    public void p(j7.b r10) {
        Fragment r11 = (Fragment) this.f20917c.e(r10.getItemId());
        if (r11 == null) goto L36;
        FrameLayout r12 = r10.b();
        View r13 = r11.getView();
        if (r11.isAdded() == true) goto L11;
        if (r13 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r11.isAdded() == false) goto L16;
        if (r13 != null) goto L16;
        s(r11, r12);
        return;
    L16:
        if (r11.isAdded() == false) goto L24;
        if (r13.getParent() == null) goto L24;
        if (r13.getParent() == r12) goto L37;
        a(r13, r12);
        return;
    L37:
        return;
    L24:
        if (r11.isAdded() == false) goto L28;
        a(r13, r12);
        return;
    L28:
        if (t() == true) goto L31;
        s(r11, r12);
        this.f20916b.o().e(r11, "f" + r10.getItemId()).x(r11, Lifecycle.State.STARTED).l();
        this.f20920f.d(false);
        return;
    L31:
        if (this.f20916b.K0() == false) goto L33;
        return;
    L33:
        this.f20915a.a(new b(this, r10));
        return;
    L36:
        throw new IllegalStateException("Design assumption violated.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final void restoreState(Parcelable r10) {
        if (this.f20918d.h() == false) goto L27;
        if (this.f20917c.h() == false) goto L27;
        Bundle r11 = (Bundle) r10;
        if (r11.getClassLoader() != null) goto L9;
        r11.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r12 = r11.keySet().iterator();
    L11:
        if (r12.hasNext() == false) goto L23;
        String r13 = r12.next();
        if (h(r13, "f#") == true) goto L14;
        if (h(r13, "s#") == false) goto L21;
        long r14 = o(r13, "s#");
        Fragment.SavedState r15 = (Fragment.SavedState) r11.getParcelable(r13);
        if (b(r14) == false) goto L11;
        this.f20918d.j(r14, r15);
        goto L11
    L21:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r13);
    L14:
        this.f20917c.j(o(r13, "f#"), this.f20916b.t0(r11, r13));
        goto L11
    L23:
        if (this.f20917c.h() == true) goto L37;
        this.f20922h = true;
        this.f20921g = true;
        f();
        r();
        return;
    L37:
        return;
    L27:
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.viewpager2.adapter.StatefulAdapter
    public final Parcelable saveState() {
        Bundle r10 = new Bundle(this.f20917c.m() + this.f20918d.m());
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= this.f20917c.m()) goto L12;
        long r13 = this.f20917c.i(r12);
        Fragment r14 = (Fragment) this.f20917c.e(r13);
        if (r14 == null) goto L10;
        if (r14.isAdded() == false) goto L10;
        this.f20916b.m1(r10, d("f#", r13), r14);
    L10:
        r12 = r12 + 1;
    L12:
        if (r11 >= this.f20918d.m()) goto L17;
        long r15 = this.f20918d.i(r11);
        if (b(r15) == false) goto L16;
        r10.putParcelable(d("s#", r15), (Parcelable) this.f20918d.e(r15));
    L16:
        r11 = r11 + 1;
        goto L12
    L17:
        return r10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean r10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean t() {
        return this.f20916b.S0();
    }

    public a(FragmentManager r10, Lifecycle r11) {
        this.f20917c = new androidx.collection.c();
        this.f20918d = new androidx.collection.c();
        this.f20919e = new androidx.collection.c();
        this.f20921g = false;
        this.f20922h = false;
        this.f20916b = r10;
        this.f20915a = r11;
        super.setHasStableIds(true);
    }
}
