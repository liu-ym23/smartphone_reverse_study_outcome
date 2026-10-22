package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes4.dex */
final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ThreadLocal<k> f35798a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static Comparator<b> f35799e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<RecyclerView> f35800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f35801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f35802d;
    private ArrayList<b> f;

    /* JADX INFO: compiled from: GapWorker.java */
    static class a implements RecyclerView.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f35803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f35805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f35806d;

        a() {
        }

        void a(int r1, int r2) {
            this.f35803a = r1;
            this.f35804b = r2;
        }

        void a(RecyclerView r5, boolean r6) {
            this.f35806d = 0;
            int[] r0 = this.f35805c;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            RecyclerView.h r1 = r5.mLayout;
            if (r5.mAdapter == null) goto L21;
            if (r1 != null) goto L9;
            return;
        L9:
            if (r1.s() == false) goto L23;
            if (r6 == false) goto L15;
            if (r5.mAdapterHelper.d() == true) goto L18;
            r1.a(r5.mAdapter.a(), this);
        L18:
            if (this.f35806d <= r1.x) goto L24;
            r1.x = this.f35806d;
            r1.y = r6;
            r5.mRecycler.b();
            return;
        L24:
            return;
        L15:
            if (r5.hasPendingAdapterUpdates() == true) goto L18;
            r1.a(this.f35803a, this.f35804b, r5.mState, this);
            goto L18
        L23:
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.h.a
        public void b(int r6, int r7) {
            if (r6 < 0) goto L15;
            if (r7 < 0) goto L13;
            int r0 = this.f35806d * 2;
            int[] r1 = this.f35805c;
            if (r1 != null) goto L8;
            int[] r2 = new int[4];
            this.f35805c = r2;
            Arrays.fill(r2, -1);
        L10:
            int[] r3 = this.f35805c;
            r3[r0] = r6;
            r3[r0 + 1] = r7;
            this.f35806d++;
            return;
        L8:
            if (r0 < r1.length) goto L10;
            int[] r4 = new int[r0 * 2];
            this.f35805c = r4;
            System.arraycopy(r1, 0, r4, 0, r1.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        boolean a(int r5) {
            if (this.f35805c == null) goto L11;
            int r0 = this.f35806d * 2;
            int r2 = 0;
        L5:
            if (r2 >= r0) goto L11;
            if (this.f35805c[r2] == r5) goto L8;
            r2 = r2 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        void a() {
            int[] r0 = this.f35805c;
            if (r0 == null) goto L5;
            Arrays.fill(r0, -1);
        L5:
            this.f35806d = 0;
        }
    }

    /* JADX INFO: compiled from: GapWorker.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f35807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f35808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35809c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f35810d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f35811e;

        b() {
        }

        public void a() {
            this.f35807a = false;
            this.f35808b = 0;
            this.f35809c = 0;
            this.f35810d = null;
            this.f35811e = 0;
        }
    }

    k() {
        this.f35800b = new ArrayList();
        this.f = new ArrayList();
    }

    static {
        f35798a = new ThreadLocal();
        f35799e = new AnonymousClass1();
    }

    public void a(RecyclerView r2) {
        if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
    L9:
        this.f35800b.add(r2);
        return;
    L5:
        if (this.f35800b.contains(r2) == false) goto L9;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    public void b(RecyclerView r1) {
        boolean r0 = this.f35800b.remove(r1);
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L8;
        if (r0 == false) goto L7;
        return;
    L7:
        throw new IllegalStateException("RecyclerView removal failed!");
    }

    void a(RecyclerView r5, int r6, int r7) {
        if (r5.isAttachedToWindow() == true) goto L5;
    L14:
        r5.mPrefetchRegistry.a(r6, r7);
        return;
    L5:
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
        if (this.f35800b.contains(r5) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.f35801c != 0) goto L14;
        this.f35801c = r5.getNanoTime();
        r5.post(this);
        goto L14
    }

    private void a() {
        int r0 = this.f35800b.size();
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        RecyclerView r4 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f35800b.get(r2), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r4.getWindowVisibility() != 0) goto L8;
        r4.mPrefetchRegistry.a(r4, false);
        r3 = r3 + r4.mPrefetchRegistry.f35806d;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        this.f.ensureCapacity(r3);
        int r5 = 0;
        int r6 = 0;
    L10:
        if (r5 >= r0) goto L27;
        RecyclerView r7 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f35800b.get(r5), RecyclerView.class, "com.obric.aiagent.plugin");
        if (r7.getWindowVisibility() != 0) goto L26;
        a r8 = r7.mPrefetchRegistry;
        int r9 = Math.abs(r8.f35803a) + Math.abs(r8.f35804b);
        int r10 = 0;
    L16:
        if (r10 >= (r8.f35806d * 2)) goto L26;
        if (r6 < this.f.size()) goto L20;
        b r11 = new b();
        this.f.add(r11);
    L21:
        int r12 = r8.f35805c[r10 + 1];
        if (r12 > r9) goto L24;
        boolean r13 = true;
    L25:
        r11.f35807a = r13;
        r11.f35808b = r9;
        r11.f35809c = r12;
        r11.f35810d = r7;
        r11.f35811e = r8.f35805c[r10];
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
        Collections.sort(this.f, f35799e);
    }

    static boolean a(RecyclerView r5, int r6) {
        int r0 = r5.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        RecyclerView.v r3 = RecyclerView.getChildViewHolderInt(r5.mChildHelper.d(r2));
        if (r3.f35662d != r6) goto L10;
        if (r3.u() == true) goto L10;
        return true;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return false;
    }

    private RecyclerView.v a(RecyclerView r2, int r3, long r4) {
        if (a(r2, r3) == false) goto L6;
        return null;
    L6:
        RecyclerView.o r1 = r2.mRecycler;
        r2.onEnterLayoutOrScroll();     // Catch: Throwable -> L17
        RecyclerView.v r5 = r1.a(r3, false, r4);     // Catch: Throwable -> L17
        if (r5 != null) goto L10;
    L15:
        r2.onExitLayoutOrScroll(false);
        return r5;
    L10:
        if (r5.w() == true) goto L12;
    L14:
        r1.a(r5, false);     // Catch: Throwable -> L17
        goto L15
    L12:
        if (r5.u() == true) goto L14;
        r1.a(r5.f35660b);     // Catch: Throwable -> L17
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
        if (r0.f35806d != 0) goto L21;
        return;
    L21:
        androidx.core.os.n.a("RV Nested Prefetch");     // Catch: Throwable -> L17
        r4.mState.a(r4.mAdapter);     // Catch: Throwable -> L17
        int r1 = 0;
    L13:
        if (r1 >= (r0.f35806d * 2)) goto L16;
        a(r4, r0.f35805c[r1], r5);     // Catch: Throwable -> L17
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
        if (r4.f35807a == false) goto L5;
        long r0 = Long.MAX_VALUE;
    L6:
        RecyclerView.v r6 = a(r4.f35810d, r4.f35811e, r0);
        if (r6 != null) goto L9;
        return;
    L9:
        if (r6.f35661c != null) goto L11;
        return;
    L11:
        if (r6.w() == true) goto L13;
        return;
    L13:
        if (r6.u() == true) goto L19;
        a((RecyclerView) ZeusTransformUtils.preCheckCast(r6.f35661c.get(), RecyclerView.class, "com.obric.aiagent.plugin"), r5);
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
        if (r1.f35810d == null) goto L12;
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
        if (this.f35800b.isEmpty() == false) goto L7;
    L5:
        this.f35801c = 0;
        androidx.core.os.n.a();
        return;
    L7:
        int r2 = this.f35800b.size();     // Catch: Throwable -> L19
        int r3 = 0;
        long r4 = 0;
    L8:
        if (r3 >= r2) goto L14;
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(this.f35800b.get(r3), RecyclerView.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r6.getWindowVisibility() != 0) goto L12;
        r4 = Math.max(r6.getDrawingTime(), r4);     // Catch: Throwable -> L19
    L12:
        r3 = r3 + 1;     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r4 == 0) goto L5;
        a(TimeUnit.MILLISECONDS.toNanos(r4) + this.f35802d);     // Catch: Throwable -> L19
        this.f35801c = 0;
        androidx.core.os.n.a();
        return;
    L19:
        th = move-exception;
        this.f35801c = 0;
        androidx.core.os.n.a();
        throw th;
    }
}
