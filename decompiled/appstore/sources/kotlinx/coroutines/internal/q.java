package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f21616e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21617f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f21618g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b0 f21619h = null;

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f21623d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final int a(long r10) {
            if ((r10 & 2305843009213693952L) == 0) goto L5;
            return 2;
        L5:
            return 1;
        }

        public final long b(long r10, int r11) {
            return d(r10, 1073741823) | ((long) r11);
        }

        public final long c(long r10, int r11) {
            return d(r10, 1152921503533105152L) | (((long) r11) << 30);
        }

        public final long d(long r10, long r11) {
            return r10 & (~r11);
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21624a;

        public b(int r10) {
            this.f21624a = r10;
        }
    }

    static {
        f21616e = new a(null);
        f21617f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");
        f21618g = AtomicLongFieldUpdater.newUpdater(q.class, "_state");
        f21619h = new b0("REMOVE_FROZEN");
    }

    public q(int r10, boolean r11) {
        this.f21620a = r10;
        this.f21621b = r11;
        int r12 = r10 - 1;
        this.f21622c = r12;
        this.f21623d = new AtomicReferenceArray(r10);
        if (r12 > 1073741823) goto L10;
        if ((r10 & r12) != 0) goto L8;
        return;
    L8:
        throw new IllegalStateException("Check failed.");
    L10:
        throw new IllegalStateException("Check failed.");
    }

    public final int a(Object r13) {
        AtomicLongFieldUpdater r10 = f21618g;
    L3:
        long r11 = r10.get(this);
        if ((3458764513820540928L & r11) != 0) goto L6;
        int r12 = (int) (1073741823 & r11);
        int r14 = (int) ((1152921503533105152L & r11) >> 30);
        int r15 = this.f21622c;
        if (((r14 + 2) & r15) == (r12 & r15)) goto L9;
        if (this.f21621b == true) goto L19;
        if (this.f21623d.get(r14 & r15) == null) goto L19;
        int r16 = this.f21620a;
        if (r16 < 1024) goto L18;
        if (((r14 - r12) & 1073741823) <= (r16 >> 1)) goto L3;
    L18:
        return 1;
    L19:
        AtomicLongFieldUpdater r17 = f21618g;
        a r18 = f21616e;
        if (r17.compareAndSet(this, r11, r18.c(r11, (r14 + 1) & 1073741823)) == false) goto L3;
        this.f21623d.set(r14 & r15, r13);
    L23:
        if ((f21618g.get(this) & 1152921504606846976L) == 0) goto L26;
        q this = this.i().e(r14, r13);
        if (this != null) goto L23;
        return 0;
    L26:
        return 0;
    L9:
        return 1;
    L6:
        return f21616e.a(r11);
    }

    public final q b(long r10) {
        q r11 = new q(this.f21620a * 2, this.f21621b);
        int r12 = (int) (1073741823 & r10);
        int r13 = (int) ((1152921503533105152L & r10) >> 30);
    L3:
        int r14 = this.f21622c;
        if ((r12 & r14) == (r13 & r14)) goto L9;
        Object r15 = this.f21623d.get(r14 & r12);
        if (r15 != null) goto L8;
        r15 = new b(r12);
    L8:
        r11.f21623d.set(r11.f21622c & r12, r15);
        r12 = r12 + 1;
        goto L3
    L9:
        f21618g.set(r11, f21616e.d(r10, 1152921504606846976L));
        return r11;
    }

    public final q c(long r10) {
        AtomicReferenceFieldUpdater r11 = f21617f;
    L3:
        q r12 = (q) r11.get(this);
        if (r12 != null) goto L5;
        androidx.concurrent.futures.a.a(f21617f, this, null, b(r10));
        goto L3
    L5:
        return r12;
    }

    public final boolean d() {
        AtomicLongFieldUpdater r10 = f21618g;
    L3:
        long r11 = r10.get(this);
        if ((r11 & 2305843009213693952L) != 0) goto L5;
        if ((1152921504606846976L & r11) != 0) goto L8;
        if (r10.compareAndSet(this, r11, r11 | 2305843009213693952L) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    public final q e(int r10, Object r11) {
        Object r12 = this.f21623d.get(this.f21622c & r10);
        if ((r12 instanceof b) == true) goto L5;
        return null;
    L5:
        if (((b) r12).f21624a != r10) goto L10;
        this.f21623d.set(r10 & this.f21622c, r11);
        return this;
    L10:
        return null;
    }

    public final int f() {
        long r10 = f21618g.get(this);
        int r11 = (int) (1073741823 & r10);
        return 1073741823 & (((int) ((r10 & 1152921503533105152L) >> 30)) - r11);
    }

    public final boolean g() {
        long r10 = f21618g.get(this);
        if (((int) (1073741823 & r10)) != ((int) ((r10 & 1152921503533105152L) >> 30))) goto L5;
        return true;
    L5:
        return false;
    }

    public final long h() {
        AtomicLongFieldUpdater r10 = f21618g;
    L3:
        long r11 = r10.get(this);
        if ((r11 & 1152921504606846976L) != 0) goto L5;
        long r12 = r11 | 1152921504606846976L;
        if (r10.compareAndSet(this, r11, r12) == false) goto L3;
        return r12;
    L5:
        return r11;
    }

    public final q i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater r10 = f21618g;
    L3:
        long r11 = r10.get(this);
        if ((1152921504606846976L & r11) != 0) goto L6;
        int r12 = (int) (1073741823 & r11);
        int r13 = this.f21622c;
        if ((((int) ((1152921503533105152L & r11) >> 30)) & r13) == (r12 & r13)) goto L9;
        Object r14 = this.f21623d.get(r13 & r12);
        if (r14 == null) goto L13;
        if ((r14 instanceof b) == true) goto L17;
        int r15 = (r12 + 1) & 1073741823;
        if (f21618g.compareAndSet(this, r11, f21616e.b(r11, r15)) == true) goto L20;
        if (this.f21621b == false) goto L3;
    L24:
        q this = this.k(r12, r15);
        if (this != null) goto L24;
        return r14;
    L20:
        this.f21623d.set(this.f21622c & r12, null);
        return r14;
    L17:
        return null;
    L13:
        if (this.f21621b == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return f21619h;
    }

    public final q k(int r10, int r11) {
        AtomicLongFieldUpdater r12 = f21618g;
    L3:
        long r13 = r12.get(this);
        int r14 = (int) (1073741823 & r13);
        if ((1152921504606846976L & r13) != 0) goto L6;
        if (f21618g.compareAndSet(this, r13, f21616e.b(r13, r11)) == false) goto L3;
        this.f21623d.set(this.f21622c & r14, null);
        return null;
    L6:
        return i();
    }
}
