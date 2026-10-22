package androidx.recyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ThreadLocal<l> f2548a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Comparator<b> f2549e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<RecyclerView> f2550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f2551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f2552d;
    private ArrayList<b> f;

    /* JADX INFO: compiled from: GapWorker.java */
    static class a implements RecyclerView.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f2555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2556d;

        a() {
        }

        void a(int r1, int r2) {
            this.f2553a = r1;
            this.f2554b = r2;
        }

        void a(RecyclerView r5, boolean r6) {
            this.f2556d = 0;
            int[] r0 = this.f2555c;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            RecyclerView.h r1 = r5.mLayout;
            if (r5.mAdapter == null) goto L21;
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.r() == false) goto L23;
            if (r6 == false) goto L15;
            if (r5.mAdapterHelper.d() == true) goto L18;
            r1.a(r5.mAdapter.a(), this);
        L18:
            if (this.f2556d <= r1.x) goto L24;
            r1.x = this.f2556d;
            r1.y = r6;
            r5.mRecycler.b();
            return;
        L24:
            return;
        L15:
            if (r5.hasPendingAdapterUpdates() == true) goto L18;
            r1.a(this.f2553a, this.f2554b, r5.mState, this);
            goto L18
        L23:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h.a
        public void b(int r6, int r7) {
            if (r6 < 0) goto L15;
            if (r7 < 0) goto L13;
            int r0 = this.f2556d * 2;
            int[] r1 = this.f2555c;
            if (r1 != null) goto L8;
            int[] r2 = new int[4];
            this.f2555c = r2;
            Arrays.fill(r2, -1);
        L10:
            int[] r3 = this.f2555c;
            r3[r0] = r6;
            r3[r0 + 1] = r7;
            this.f2556d++;
            return;
        L8:
            if (r0 < r1.length) goto L10;
            int[] r4 = new int[r0 * 2];
            this.f2555c = r4;
            System.arraycopy(r1, 0, r4, 0, r1.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        boolean a(int r5) {
            if (this.f2555c == null) goto L11;
            int r0 = this.f2556d * 2;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L11;
            if (this.f2555c[r2] == r5) goto L8;
            r2 = r2 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        void a() {
            int[] r0 = this.f2555c;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.f2556d = 0;
        }
    }

    /* JADX INFO: compiled from: GapWorker.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f2560d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2561e;

        b() {
        }

        public void a() {
            this.f2557a = false;
            this.f2558b = 0;
            this.f2559c = 0;
            this.f2560d = null;
            this.f2561e = 0;
        }
    }

    l() {
        this.f2550b = new ArrayList();
        this.f = new ArrayList();
    }

    static {
        f2548a = new ThreadLocal();
        f2549e = new AnonymousClass1();
    }

    public void a(RecyclerView r1) {
        this.f2550b.add(r1);
    }

    public void b(RecyclerView r1) {
        this.f2550b.remove(r1);
    }

    void a(RecyclerView r5, int r6, int r7) {
        if (r5.isAttachedToWindow() == true) goto L5;
    L7:
        r5.mPrefetchRegistry.a(r6, r7);
        return;
    L5:
        if (this.f2551c != 0) goto L7;
        this.f2551c = r5.getNanoTime();
        r5.post(this);
        goto L7
    }

    private void a() {
        int r0 = this.f2550b.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f2550b.get(r2), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r4.getWindowVisibility() != 0) goto L8;
        r4.mPrefetchRegistry.a(r4, false);
        r3 = r3 + r4.mPrefetchRegistry.f2556d;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        this.f.ensureCapacity(r3);
        int r5 = 0;
        int r6 = 0;
    L10:
        if (r5 >= r0) goto L27;
        RecyclerView r7 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f2550b.get(r5), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r7.getWindowVisibility() != 0) goto L26;
        a r8 = r7.mPrefetchRegistry;
        int r9 = Math.abs(r8.f2553a) + Math.abs(r8.f2554b);
        int r10 = 0;
    L16:
        if (r10 >= (r8.f2556d * 2)) goto L26;
        if (r6 < this.f.size()) goto L20;
        b r11 = new b();
        this.f.add(r11);
    L21:
        int r12 = r8.f2555c[r10 + 1];
        if (r12 > r9) goto L24;
        boolean r13 = true;
    L25:
        r11.f2557a = r13;
        r11.f2558b = r9;
        r11.f2559c = r12;
        r11.f2560d = r7;
        r11.f2561e = r8.f2555c[r10];
        r6 = r6 + 1;
        r10 = r10 + 2;
        goto L16
    L24:
        r13 = false;
        goto L25
    L20:
        r11 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r6), b.class, "com.obric.aiagent.plugin");
    L26:
        r5 = r5 + 1;
        goto L10
    L27:
        Collections.sort(this.f, f2549e);
    }

    static boolean a(RecyclerView r5, int r6) {
        int r0 = r5.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        RecyclerView.u r3 = RecyclerView.getChildViewHolderInt(r5.mChildHelper.d(r2));
        if (r3.f2392c != r6) goto L10;
        if (r3.q() == true) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    private RecyclerView.u a(RecyclerView r2, int r3, long r4) {
        if (a(r2, r3) == false) goto L6;
        return null;
    L6:
        RecyclerView.n r1 = r2.mRecycler;
        r2.onEnterLayoutOrScroll();     // Catch: Throwable -> L17
        RecyclerView.u r5 = r1.a(r3, false, r4);     // Catch: Throwable -> L17
        if (r5 != null) goto L10;
    L15:
        r2.onExitLayoutOrScroll(false);
        return r5;
    L10:
        if (r5.s() == true) goto L12;
    L14:
        r1.a(r5, false);     // Catch: Throwable -> L17
        goto L15
    L12:
        if (r5.q() == true) goto L14;
        r1.a(r5.f2390a);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r2.onExitLayoutOrScroll(false);
        throw th;
    }

    private void a(RecyclerView r4, long r5) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        a r0 = r4.mPrefetchRegistry;
        r0.a(r4, true);
        if (r0.f2556d != 0) goto L21;
        return;
    L21:
        androidx.core.os.n.a("RV Nested Prefetch");     // Catch: Throwable -> L17
        r4.mState.a(r4.mAdapter);     // Catch: Throwable -> L17
        int r1 = 0;
    L13:
        if (r1 >= (r0.f2556d * 2)) goto L16;
        a(r4, r0.f2555c[r1], r5);     // Catch: Throwable -> L17
        r1 = r1 + 2;
        goto L13
    L16:
        androidx.core.os.n.a();
        return;
    L17:
        th = move-exception;
        androidx.core.os.n.a();
        throw th;
    L7:
        if (r4.mChildHelper.c() == 0) goto L9;
        r4.removeAndRecycleViews();
        goto L9
    }

    private void a(b r4, long r5) {
        if (r4.f2557a == false) goto L5;
        long r0 = Long.MAX_VALUE;
    L6:
        RecyclerView.u r6 = a(r4.f2560d, r4.f2561e, r0);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.f2391b != null) goto L11;
        return;
    L11:
        if (r6.s() == true) goto L13;
        return;
    L13:
        if (r6.q() == true) goto L19;
        a((RecyclerView) ZeusTransformUtils.preCheckCast(r6.f2391b.get(), RecyclerView.class, "com.obric.aiagent.plugin"), r5);
        return;
    L19:
        return;
    L5:
        r0 = r5;
        goto L6
    }

    private void b(long r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.f.size()) goto L9;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f.get(r0), b.class, "com.obric.aiagent.plugin");
        if (r1.f2560d == null) goto L12;
        a(r1, r5);
        r1.a();
        r0 = r0 + 1;
        goto L4
    L12:
        return;
    }

    void a(long r1) {
        a();
        b(r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx.core.os.n.a("RV Prefetch");     // Catch: Throwable -> L19
        if (this.f2550b.isEmpty() == false) goto L7;
    L5:
        this.f2551c = 0;
        androidx.core.os.n.a();
        return;
    L7:
        int r2 = this.f2550b.size();     // Catch: Throwable -> L19
        int r3 = 0;
        long r4 = 0;
    L8:
        if (r3 >= r2) goto L14;
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f2550b.get(r3), RecyclerView.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r6.getWindowVisibility() != 0) goto L12;
        r4 = Math.max(r6.getDrawingTime(), r4);     // Catch: Throwable -> L19
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r4 == 0) goto L5;
        a(TimeUnit.MILLISECONDS.toNanos(r4) + this.f2552d);     // Catch: Throwable -> L19
        this.f2551c = 0;
        androidx.core.os.n.a();
        return;
    L19:
        th = move-exception;
        this.f2551c = 0;
        androidx.core.os.n.a();
        throw th;
    }
}
