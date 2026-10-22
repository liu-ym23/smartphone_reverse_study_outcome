package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.b.d;
import androidx.core.util.g;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.apm.util.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: FragmentStateAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends RecyclerView.a<androidx.viewpager2.adapter.b> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final i f2920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final FragmentManager f2921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final d<Fragment> f2922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f2923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d<Fragment.SavedState> f2924e;
    private final d<Integer> f;
    private b g;
    private boolean h;

    /* JADX INFO: renamed from: androidx.viewpager2.adapter.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FragmentStateAdapter.java */
    private static abstract class AbstractC0078a extends RecyclerView.b {
        @Override // androidx.recyclerview.widget.RecyclerView.b
        public abstract void a();

        private AbstractC0078a() {
        }

        /* synthetic */ AbstractC0078a(FragmentStateAdapter$1 r1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, Object r3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void b(int r1, int r2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void c(int r1, int r2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public final void a(int r1, int r2, int r3) {
            a();
        }
    }

    /* JADX INFO: compiled from: FragmentStateAdapter.java */
    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f2929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ViewPager2.e f2930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private RecyclerView.b f2931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private m f2932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ViewPager2 f2933e;
        private long f;

        b(a r3) {
            this.f2929a = r3;
            this.f = -1;
        }

        void a(RecyclerView r2) {
            this.f2933e = c(r2);
            ViewPager2.e r3 = new AnonymousClass1(this);
            this.f2930b = r3;
            this.f2933e.registerOnPageChangeCallback(r3);
            AbstractC0078a r4 = new AnonymousClass2(this);
            this.f2931c = r4;
            this.f2929a.a(r4);
            this.f2932d = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(this);
            this.f2929a.f2920a.a(this.f2932d);
        }

        void b(RecyclerView r2) {
            c(r2).unregisterOnPageChangeCallback(this.f2930b);
            this.f2929a.b(this.f2931c);
            this.f2929a.f2920a.b(this.f2932d);
            this.f2933e = null;
        }

        void a(boolean r10) {
            if (this.f2929a.h() == false) goto L6;
            return;
        L6:
            if (this.f2933e.getScrollState() == 0) goto L9;
            return;
        L9:
            if (this.f2929a.f2922c.c() == false) goto L11;
            return;
        L11:
            if (this.f2929a.a() == 0) goto L53;
            int r0 = this.f2933e.getCurrentItem();
            if (r0 < this.f2929a.a()) goto L16;
            return;
        L16:
            long r1 = this.f2929a.b(r0);
            if (r1 != this.f) goto L20;
            if (r10 == true) goto L20;
            return;
        L20:
            Fragment r11 = (Fragment) ZeusTransformUtils.preCheckCast(this.f2929a.f2922c.a(r1), Fragment.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L23;
            return;
        L23:
            if (r11.isAdded() == false) goto L54;
            this.f = r1;
            androidx.fragment.app.m r12 = this.f2929a.f2921b.a();
            Fragment r2 = null;
            int r3 = 0;
        L27:
            if (r3 >= this.f2929a.f2922c.b()) goto L41;
            long r4 = this.f2929a.f2922c.b(r3);
            Fragment r6 = (Fragment) ZeusTransformUtils.preCheckCast(this.f2929a.f2922c.c(r3), Fragment.class, "com.obric.aiagent.plugin");
            if (r6.isAdded() == false) goto L40;
            if (r4 == this.f) goto L34;
            r12.a(r6, i.b.f2057d);
        L36:
            if (r4 != this.f) goto L38;
            boolean r5 = true;
        L39:
            r6.setMenuVisibility(r5);
            goto L40
        L38:
            r5 = false;
            goto L39
        L34:
            r2 = r6;
        L40:
            r3 = r3 + 1;
            goto L27
        L41:
            if (r2 == null) goto L44;
            r12.a(r2, i.b.f2058e);
        L44:
            if (r12.i() == true) goto L52;
            r12.d();
            return;
        L52:
            return;
        L54:
            return;
        }

        private ViewPager2 c(RecyclerView r3) {
            ViewParent r2 = r3.getParent();
            if (ZeusTransformUtils.instanceOf(r2, ViewPager2.class) == false) goto L7;
            return (ViewPager2) ZeusTransformUtils.preCheckCast(r2, ViewPager2.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + r2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long b(int r1) {
        return r1;
    }

    public abstract Fragment c(int r1);

    public final boolean d(androidx.viewpager2.adapter.b r1) {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ RecyclerView.u a(ViewGroup r1, int r2) {
        return c(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void a(RecyclerView.u r3, int r4) {
        a((androidx.viewpager2.adapter.b) ZeusTransformUtils.preCheckCast(r3, androidx.viewpager2.adapter.b.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ boolean a(RecyclerView.u r3) {
        return d((androidx.viewpager2.adapter.b) ZeusTransformUtils.preCheckCast(r3, androidx.viewpager2.adapter.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void b(RecyclerView.u r3) {
        a((androidx.viewpager2.adapter.b) ZeusTransformUtils.preCheckCast(r3, androidx.viewpager2.adapter.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public /* synthetic */ void d(RecyclerView.u r3) {
        c((androidx.viewpager2.adapter.b) ZeusTransformUtils.preCheckCast(r3, androidx.viewpager2.adapter.b.class, "com.obric.aiagent.plugin"));
    }

    public a(FragmentActivity r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        this(r4.getSupportFragmentManager(), r4.getLifecycle());
    }

    public a(FragmentManager r2, i r3) {
        this.f2922c = new d();
        this.f2924e = new d();
        this.f = new d();
        this.f2923d = false;
        this.h = false;
        this.f2921b = r2;
        this.f2920a = r3;
        super.a(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void a(RecyclerView r2) {
        if (this.g != null) goto L5;
        boolean r0 = true;
    L6:
        g.a(r0);
        b r1 = new b(this);
        this.g = r1;
        r1.a(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public void b(RecyclerView r2) {
        this.g.b(r2);
        this.g = null;
    }

    public final androidx.viewpager2.adapter.b c(ViewGroup r1, int r2) {
        return androidx.viewpager2.adapter.b.a(r1);
    }

    public final void a(final androidx.viewpager2.adapter.b r8, int r9) {
        long r0 = r8.j();
        int r2 = r8.E().getId();
        Long r3 = f(r2);
        if (r3 != null) goto L5;
    L7:
        this.f.b(r0, Integer.valueOf(r2));
        g(r9);
        final FrameLayout r10 = r8.E();
        if (ViewCompat.I(r10) == true) goto L10;
    L14:
        g();
        return;
    L10:
        if (r10.getParent() != null) goto L13;
        r10.addOnLayoutChangeListener(new FragmentStateAdapter$1(this, r10, r8));
        goto L14
    L13:
        throw new IllegalStateException("Design assumption violated.");
    L5:
        if (r3.longValue() == r0) goto L7;
        c(r3.longValue());
        this.f.b(r3.longValue());
        goto L7
    }

    void g() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (h() == true) goto L35;
        androidx.b.b r0 = new androidx.b.b();
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= this.f2922c.b()) goto L15;
        long r3 = this.f2922c.b(r2);
        if (a(r3) == true) goto L13;
        r0.add(Long.valueOf(r3));
        this.f.b(r3);
    L13:
        r2 = r2 + 1;
        goto L9
    L15:
        if (this.f2923d == true) goto L23;
        this.h = false;
    L18:
        if (r1 >= this.f2922c.b()) goto L23;
        long r4 = this.f2922c.b(r1);
        if (b(r4) == true) goto L22;
        r0.add(Long.valueOf(r4));
    L22:
        r1 = r1 + 1;
    L23:
        Iterator<E> r5 = r0.iterator();
    L25:
        if (r5.hasNext() == false) goto L36;
        c(((Long) ZeusTransformUtils.preCheckCast(r5.next(), Long.class, "com.obric.aiagent.plugin")).longValue());
        goto L25
    L36:
        return;
    }

    private boolean b(long r3) {
        if (this.f.d(r3) == false) goto L5;
        return true;
    L5:
        Fragment r2 = (Fragment) ZeusTransformUtils.preCheckCast(this.f2922c.a(r3), Fragment.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
        return false;
    L8:
        View r4 = r2.getView();
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.getParent() == null) goto L15;
        return true;
    L15:
        return false;
    }

    private Long f(int r6) {
        Long r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= this.f.b()) goto L12;
        if (((Integer) ZeusTransformUtils.preCheckCast(this.f.c(r1), Integer.class, "com.obric.aiagent.plugin")).intValue() != r6) goto L11;
        if (r0 != null) goto L10;
        r0 = Long.valueOf(this.f.b(r1));
        goto L11
    L10:
        throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return r0;
    }

    private void g(int r6) {
        long r0 = b(r6);
        if (this.f2922c.d(r0) == true) goto L6;
        Fragment r7 = c(r6);
        r7.setInitialSavedState((Fragment.SavedState) ZeusTransformUtils.preCheckCast(this.f2924e.a(r0), Fragment.SavedState.class, "com.obric.aiagent.plugin"));
        this.f2922c.b(r0, r7);
        return;
    }

    public final void a(androidx.viewpager2.adapter.b r1) {
        b(r1);
        g();
    }

    void b(final androidx.viewpager2.adapter.b r6) {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.f2922c.a(r6.j()), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L36;
        FrameLayout r2 = r6.E();
        View r3 = r0.getView();
        if (r0.isAdded() == true) goto L11;
        if (r3 == null) goto L11;
        throw new IllegalStateException("Design assumption violated.");
    L11:
        if (r0.isAdded() == false) goto L16;
        if (r3 != null) goto L16;
        a(r0, r2);
        return;
    L16:
        if (r0.isAdded() == false) goto L24;
        if (r3.getParent() == null) goto L24;
        if (r3.getParent() == r2) goto L37;
        a(r3, r2);
        return;
    L37:
        return;
    L24:
        if (r0.isAdded() == false) goto L28;
        a(r3, r2);
        return;
    L28:
        if (h() == true) goto L31;
        a(r0, r2);
        this.f2921b.a().a(r0, f.f4978a + r6.j()).a(r0, i.b.f2057d).d();
        this.g.a(false);
        return;
    L31:
        if (this.f2921b.g() == false) goto L33;
        return;
    L33:
        this.f2920a.a(new FragmentStateAdapter$2(this, r6));
        return;
    L36:
        throw new IllegalStateException("Design assumption violated.");
    }

    private void a(final Fragment r3, final FrameLayout r4) {
        this.f2921b.a(new AnonymousClass1(this, r3, r4), false);
    }

    void a(View r3, FrameLayout r4) {
        if (r4.getChildCount() > 1) goto L16;
        if (r3.getParent() != r4) goto L8;
        return;
    L8:
        if (r4.getChildCount() <= 0) goto L11;
        r4.removeAllViews();
    L11:
        if (r3.getParent() == null) goto L13;
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r3.getParent(), ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r3);
    L13:
        r4.addView(r3);
        return;
    L16:
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void c(androidx.viewpager2.adapter.b r3) {
        Long r4 = f(r3.E().getId());
        if (r4 == null) goto L6;
        c(r4.longValue());
        this.f.b(r4.longValue());
        return;
    }

    private void c(long r5) {
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(this.f2922c.a(r5), Fragment.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.getView() == null) goto L11;
        ViewParent r1 = r0.getView().getParent();
        if (r1 == null) goto L11;
        ((FrameLayout) ZeusTransformUtils.preCheckCast(r1, FrameLayout.class, "com.obric.aiagent.plugin")).removeAllViews();
    L11:
        if (a(r5) == true) goto L14;
        this.f2924e.b(r5);
    L14:
        if (r0.isAdded() == true) goto L18;
        this.f2922c.b(r5);
        return;
    L18:
        if (h() == false) goto L22;
        this.h = true;
        return;
    L22:
        if (r0.isAdded() == true) goto L24;
    L26:
        this.f2921b.a().a(r0).d();
        this.f2922c.b(r5);
        return;
    L24:
        if (a(r5) == false) goto L26;
        this.f2924e.b(r5, this.f2921b.f(r0));
        goto L26
    }

    boolean h() {
        return this.f2921b.h();
    }

    public boolean a(long r3) {
        if (r3 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r3 >= a()) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void a(boolean r1) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    @Override // androidx.viewpager2.adapter.c
    public final Parcelable i() {
        Bundle r0 = new Bundle(this.f2922c.b() + this.f2924e.b());
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= this.f2922c.b()) goto L12;
        long r5 = this.f2922c.b(r2);
        Fragment r3 = (Fragment) ZeusTransformUtils.preCheckCast(this.f2922c.a(r5), Fragment.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L10;
        if (r3.isAdded() == false) goto L10;
        this.f2921b.a(r0, a("f#", r5), r3);
    L10:
        r2 = r2 + 1;
    L12:
        if (r1 >= this.f2924e.b()) goto L17;
        long r4 = this.f2924e.b(r1);
        if (a(r4) == false) goto L16;
        r0.putParcelable(a("s#", r4), (Parcelable) ZeusTransformUtils.preCheckCast(this.f2924e.a(r4), Parcelable.class, "com.obric.aiagent.plugin"));
    L16:
        r1 = r1 + 1;
        goto L12
    L17:
        return r0;
    }

    @Override // androidx.viewpager2.adapter.c
    public final void a(Parcelable r7) {
        Parcelable r8 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r7, Parcelable.class, "com.obric.aiagent.plugin");
        if (this.f2924e.c() == false) goto L27;
        if (this.f2922c.c() == false) goto L27;
        Bundle r9 = (Bundle) ZeusTransformUtils.preCheckCast(r8, Bundle.class, "com.obric.aiagent.plugin");
        if (r9.getClassLoader() != null) goto L9;
        r9.setClassLoader(getClass().getClassLoader());
    L9:
        Iterator<String> r0 = r9.keySet().iterator();
    L11:
        if (r0.hasNext() == false) goto L23;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        if (a(r2, "f#") == true) goto L14;
        if (a(r2, "s#") == false) goto L21;
        long r3 = b(r2, "s#");
        Fragment.SavedState r4 = (Fragment.SavedState) ZeusTransformUtils.preCheckCast(r9.getParcelable(r2), Fragment.SavedState.class, "com.obric.aiagent.plugin");
        if (a(r3) == false) goto L11;
        this.f2924e.b(r3, r4);
        goto L11
    L21:
        throw new IllegalArgumentException("Unexpected key in savedState: " + r2);
    L14:
        this.f2922c.b(b(r2, "f#"), this.f2921b.a(r9, r2));
        goto L11
    L23:
        if (this.f2922c.c() == true) goto L37;
        this.h = true;
        this.f2923d = true;
        g();
        j();
        return;
    L37:
        return;
    L27:
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    private void j() {
        final Handler r0 = new Handler(Looper.getMainLooper());
        final Runnable r1 = new AnonymousClass2(this);
        this.f2920a.a(new FragmentStateAdapter$5(this, r0, r1));
        r0.postDelayed(r1, 10000);
    }

    private static String a(String r1, long r2) {
        return r1 + r2;
    }

    private static boolean a(String r1, String r2) {
        if (r1.startsWith(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.length() <= r2.length()) goto L7;
        return true;
    }

    private static long b(String r0, String r1) {
        return Long.parseLong(r0.substring(r1.length()));
    }
}
