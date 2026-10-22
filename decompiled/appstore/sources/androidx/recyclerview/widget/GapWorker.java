package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class GapWorker implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal f4084e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator f4085f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f4086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList f4089d;

    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f4092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4093d;

        public LayoutPrefetchRegistryImpl() {
        }

        public void a() {
            int[] r10 = this.f4092c;
            if (r10 == null) goto L5;
            Arrays.fill(r10, -1);
        L5:
            this.f4093d = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int r10, int r11) {
            if (r10 < 0) goto L15;
            if (r11 < 0) goto L13;
            int r12 = this.f4093d;
            int r13 = r12 * 2;
            int[] r14 = this.f4092c;
            if (r14 != null) goto L8;
            int[] r15 = new int[4];
            this.f4092c = r15;
            Arrays.fill(r15, -1);
        L10:
            int[] r16 = this.f4092c;
            r16[r13] = r10;
            r16[r13 + 1] = r11;
            this.f4093d++;
            return;
        L8:
            if (r13 < r14.length) goto L10;
            int[] r17 = new int[r12 * 4];
            this.f4092c = r17;
            System.arraycopy(r14, 0, r17, 0, r14.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void b(RecyclerView r10, boolean r11) {
            this.f4093d = 0;
            int[] r12 = this.f4092c;
            if (r12 == null) goto L5;
            Arrays.fill(r12, -1);
        L5:
            RecyclerView.LayoutManager r13 = r10.mLayout;
            if (r10.mAdapter == null) goto L21;
            if (r13 != null) goto L9;
            return;
        L9:
            if (r13.isItemPrefetchEnabled() == false) goto L23;
            if (r11 == false) goto L15;
            if (r10.mAdapterHelper.n() == true) goto L17;
            r13.collectInitialPrefetchPositions(r10.mAdapter.getItemCount(), this);
        L17:
            int r14 = this.f4093d;
            if (r14 <= r13.mPrefetchMaxCountObserved) goto L24;
            r13.mPrefetchMaxCountObserved = r14;
            r13.mPrefetchMaxObservedInInitialPrefetch = r11;
            r10.mRecycler.P();
            return;
        L24:
            return;
        L15:
            if (r10.hasPendingAdapterUpdates() == true) goto L17;
            r13.collectAdjacentPrefetchPositions(this.f4090a, this.f4091b, r10.mState, this);
            goto L17
        L23:
            return;
        }

        public boolean c(int r10) {
            if (this.f4092c == null) goto L11;
            int r11 = this.f4093d * 2;
            int r12 = 0;
        L5:
            if (r12 >= r11) goto L11;
            if (this.f4092c[r12] == r10) goto L8;
            r12 = r12 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        public void d(int r10, int r11) {
            this.f4090a = r10;
            this.f4091b = r11;
        }
    }

    public class a implements Comparator {
        public a() {
        }

        public int a(b r10, b r11) {
            RecyclerView r12 = r10.f4097d;
            if (r12 != null) goto L5;
            boolean r13 = true;
        L7:
            if (r11.f4097d != null) goto L9;
            boolean r14 = true;
        L11:
            if (r13 == r14) goto L16;
            if (r12 != null) goto L15;
            return 1;
        L15:
            return -1;
        L16:
            boolean r15 = r10.f4094a;
            if (r15 == r11.f4094a) goto L21;
            if (r15 == true) goto L20;
            return 1;
        L20:
            return -1;
        L21:
            int r16 = r11.f4095b - r10.f4095b;
            if (r16 == 0) goto L24;
            return r16;
        L24:
            int r17 = r10.f4096c - r11.f4096c;
            if (r17 == 0) goto L27;
            return r17;
        L27:
            return 0;
        L9:
            r14 = false;
            goto L11
        L5:
            r13 = false;
            goto L7
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((b) r10, (b) r11);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f4097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4098e;

        public b() {
        }

        public void a() {
            this.f4094a = false;
            this.f4095b = 0;
            this.f4096c = 0;
            this.f4097d = null;
            this.f4098e = 0;
        }
    }

    static {
        f4084e = new ThreadLocal();
        f4085f = new a();
    }

    public GapWorker() {
        this.f4086a = new ArrayList();
        this.f4089d = new ArrayList();
    }

    public static boolean e(RecyclerView r10, int r11) {
        int r12 = r10.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        RecyclerView.ViewHolder r14 = RecyclerView.getChildViewHolderInt(r10.mChildHelper.getUnfilteredChildAt(r13));
        if (r14.mPosition != r11) goto L10;
        if (r14.isInvalid() == true) goto L10;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    public void a(RecyclerView r10) {
        if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
    L9:
        this.f4086a.add(r10);
        return;
    L5:
        if (this.f4086a.contains(r10) == false) goto L9;
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    public final void b() {
        int r10 = this.f4086a.size();
        int r11 = 0;
        int r12 = 0;
    L3:
        if (r11 >= r10) goto L8;
        RecyclerView r13 = (RecyclerView) this.f4086a.get(r11);
        if (r13.getWindowVisibility() != 0) goto L7;
        r13.mPrefetchRegistry.b(r13, false);
        r12 = r12 + r13.mPrefetchRegistry.f4093d;
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.f4089d.ensureCapacity(r12);
        int r14 = 0;
        int r15 = 0;
    L9:
        if (r14 >= r10) goto L26;
        RecyclerView r16 = (RecyclerView) this.f4086a.get(r14);
        if (r16.getWindowVisibility() != 0) goto L25;
        LayoutPrefetchRegistryImpl r17 = r16.mPrefetchRegistry;
        int r18 = Math.abs(r17.f4090a) + Math.abs(r17.f4091b);
        int r19 = 0;
    L15:
        if (r19 >= (r17.f4093d * 2)) goto L25;
        if (r15 < this.f4089d.size()) goto L19;
        b r20 = new b();
        this.f4089d.add(r20);
    L20:
        int[] r21 = r17.f4092c;
        int r110 = r21[r19 + 1];
        if (r110 > r18) goto L23;
        boolean r111 = true;
    L24:
        r20.f4094a = r111;
        r20.f4095b = r18;
        r20.f4096c = r110;
        r20.f4097d = r16;
        r20.f4098e = r21[r19];
        r15 = r15 + 1;
        r19 = r19 + 2;
        goto L15
    L23:
        r111 = false;
        goto L24
    L19:
        r20 = (b) this.f4089d.get(r15);
    L25:
        r14 = r14 + 1;
        goto L9
    L26:
        Collections.sort(this.f4089d, f4085f);
    }

    public final void c(b r10, long r11) {
        if (r10.f4094a == false) goto L5;
        long r12 = Long.MAX_VALUE;
    L6:
        RecyclerView.ViewHolder r13 = i(r10.f4097d, r10.f4098e, r12);
        if (r13 != null) goto L9;
        return;
    L9:
        if (r13.mNestedRecyclerView != null) goto L11;
        return;
    L11:
        if (r13.isBound() == true) goto L13;
        return;
    L13:
        if (r13.isInvalid() == true) goto L19;
        h(r13.mNestedRecyclerView.get(), r11);
        return;
    L19:
        return;
    L5:
        r12 = r11;
        goto L6
    }

    public final void d(long r10) {
        int r11 = 0;
    L4:
        if (r11 >= this.f4089d.size()) goto L9;
        b r12 = (b) this.f4089d.get(r11);
        if (r12.f4097d == null) goto L12;
        c(r12, r10);
        r12.a();
        r11 = r11 + 1;
        goto L4
    L12:
        return;
    }

    public void f(RecyclerView r10, int r11, int r12) {
        if (r10.isAttachedToWindow() == true) goto L5;
    L14:
        r10.mPrefetchRegistry.d(r11, r12);
        return;
    L5:
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
        if (this.f4086a.contains(r10) == true) goto L12;
        throw new IllegalStateException("attempting to post unregistered view!");
    L12:
        if (this.f4087b != 0) goto L14;
        this.f4087b = r10.getNanoTime();
        r10.post(this);
        goto L14
    }

    public void g(long r10) {
        b();
        d(r10);
    }

    public final void h(RecyclerView r10, long r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        LayoutPrefetchRegistryImpl r12 = r10.mPrefetchRegistry;
        r12.b(r10, true);
        if (r12.f4093d != 0) goto L22;
        return;
    L22:
        androidx.core.os.g.a("RV Nested Prefetch");     // Catch: Throwable -> L16
        r10.mState.g(r10.mAdapter);     // Catch: Throwable -> L16
        int r13 = 0;
    L13:
        if (r13 >= (r12.f4093d * 2)) goto L18;
        i(r10, r12.f4092c[r13], r11);     // Catch: Throwable -> L16
        r13 = r13 + 2;
        goto L13
    L18:
        androidx.core.os.g.b();
        return;
    L16:
        th = move-exception;
        androidx.core.os.g.b();
        throw th;
    L7:
        if (r10.mChildHelper.getUnfilteredChildCount() == 0) goto L9;
        r10.removeAndRecycleViews();
        goto L9
    }

    public final RecyclerView.ViewHolder i(RecyclerView r10, int r11, long r12) {
        if (e(r10, r11) == false) goto L6;
        return null;
    L6:
        RecyclerView.Recycler r13 = r10.mRecycler;
        r10.onEnterLayoutOrScroll();     // Catch: Throwable -> L14
        RecyclerView.ViewHolder r14 = r13.N(r11, false, r12);     // Catch: Throwable -> L14
        if (r14 != null) goto L10;
    L17:
        r10.onExitLayoutOrScroll(false);
        return r14;
    L10:
        if (r14.isBound() == true) goto L12;
    L16:
        r13.a(r14, false);     // Catch: Throwable -> L14
        goto L17
    L12:
        if (r14.isInvalid() == true) goto L16;
        r13.G(r14.itemView);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r10.onExitLayoutOrScroll(false);
        throw th;
    }

    public void j(RecyclerView r10) {
        boolean r11 = this.f4086a.remove(r10);
        if (RecyclerView.sDebugAssertionsEnabled == false) goto L8;
        if (r11 == false) goto L7;
        return;
    L7:
        throw new IllegalStateException("RecyclerView removal failed!");
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx.core.os.g.a("RV Prefetch");     // Catch: Throwable -> L12
        if (this.f4086a.isEmpty() == false) goto L7;
    L5:
        this.f4087b = 0;
        androidx.core.os.g.b();
        return;
    L7:
        int r10 = this.f4086a.size();     // Catch: Throwable -> L12
        int r11 = 0;
        long r12 = 0;
    L8:
        if (r11 >= r10) goto L16;
        RecyclerView r13 = (RecyclerView) this.f4086a.get(r11);     // Catch: Throwable -> L12
        if (r13.getWindowVisibility() != 0) goto L14;
        r12 = Math.max(r13.getDrawingTime(), r12);     // Catch: Throwable -> L12
    L14:
        r11 = r11 + 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        if (r12 == 0) goto L5;
        g(TimeUnit.MILLISECONDS.toNanos(r12) + this.f4088c);     // Catch: Throwable -> L12
        this.f4087b = 0;
        androidx.core.os.g.b();
        return;
    L12:
        th = move-exception;
        this.f4087b = 0;
        androidx.core.os.g.b();
        throw th;
    }
}
