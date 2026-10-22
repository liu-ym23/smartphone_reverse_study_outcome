package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class z<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final al f39428b = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater g = null;
    private static final /* synthetic */ AtomicLongFieldUpdater h = null;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f39429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f39430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f39431e;
    private final /* synthetic */ AtomicReferenceArray f;

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final int a(long r3) {
            if ((r3 & 2305843009213693952L) == 0) goto L5;
            return 2;
        L5:
            return 1;
        }

        public final long a(long r1, long r3) {
            return r1 & (~r3);
        }

        private a() {
        }

        public final long a(long r3, int r5) {
            return a(r3, 1073741823) | (((long) r5) << 0);
        }

        public final long b(long r3, int r5) {
            return a(r3, 1152921503533105152L) | (((long) r5) << 30);
        }
    }

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39432a;

        public b(int r1) {
            this.f39432a = r1;
        }
    }

    private final /* synthetic */ AtomicReferenceArray f() {
        return this.f;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater h() {
        return g;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater i() {
        return h;
    }

    public z(int r4, boolean r5) {
        this.f39429c = r4;
        this.f39430d = r5;
        int r6 = r4 - 1;
        this.f39431e = r6;
        this.f = new AtomicReferenceArray(r4);
        boolean r3 = false;
        if (r6 > 1073741823) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L16;
        if ((r4 & r6) != 0) goto L11;
        r3 = true;
    L11:
        if (r3 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r1 = false;
        goto L7
    }

    public final boolean a() {
        long r0 = i().get(this);
        if (((int) ((1073741823 & r0) >> 0)) != ((int) ((r0 & 1152921503533105152L) >> 30))) goto L6;
        return true;
    L6:
        return false;
    }

    public final int b() {
        long r0 = i().get(this);
        int r4 = (int) ((1073741823 & r0) >> 0);
        return 1073741823 & (((int) ((r0 & 1152921503533105152L) >> 30)) - r4);
    }

    public final boolean c() {
        AtomicLongFieldUpdater r6 = i();
    L3:
        long r2 = r6.get(this);
        if ((r2 & 2305843009213693952L) != 0) goto L5;
        if ((1152921504606846976L & r2) != 0) goto L8;
        if (r6.compareAndSet(this, r2, r2 | 2305843009213693952L) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    public final int a(E r15) {
        AtomicLongFieldUpdater r0 = i();
    L3:
        long r3 = r0.get(this);
        if ((3458764513820540928L & r3) != 0) goto L6;
        a r1 = f39427a;
        int r2 = (int) ((1073741823 & r3) >> 0);
        int r10 = (int) ((1152921503533105152L & r3) >> 30);
        int r11 = this.f39431e;
        if (((r10 + 2) & r11) == (r2 & r11)) goto L9;
        if (this.f39430d == true) goto L20;
        if (f().get(r10 & r11) == null) goto L20;
        int r4 = this.f39429c;
        if (r4 < 1024) goto L18;
        if (((r10 - r2) & 1073741823) <= (r4 >> 1)) goto L3;
    L18:
        return 1;
    L20:
        if (i().compareAndSet(this, r3, r1.b(r3, (r10 + 1) & 1073741823)) == false) goto L3;
        f().set(r10 & r11, r15);
    L23:
        if ((i().get(this) & 1152921504606846976L) == 0) goto L26;
        z<E> this = this.e().a(r10, r15);
        if (this != null) goto L23;
    L26:
        return 0;
    L9:
        return 1;
    L6:
        return f39427a.a(r3);
    }

    private final z<E> a(int r4, E r5) {
        Object r0 = f().get(this.f39431e & r4);
        if (ZeusTransformUtils.instanceOf(r0, b.class) == true) goto L5;
        return null;
    L5:
        if (((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin")).f39432a != r4) goto L10;
        f().set(r4 & this.f39431e, r5);
        return this;
    L10:
        return null;
    }

    public final Object d() {
        AtomicLongFieldUpdater r0 = i();
    L3:
        long r3 = r0.get(this);
        if ((1152921504606846976L & r3) != 0) goto L6;
        a r1 = f39427a;
        int r7 = (int) ((1073741823 & r3) >> 0);
        int r2 = (int) ((1152921503533105152L & r3) >> 30);
        int r5 = this.f39431e;
        if ((r2 & r5) == (r5 & r7)) goto L9;
        Object r9 = f().get(this.f39431e & r7);
        if (r9 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L17;
        int r10 = (r7 + 1) & 1073741823;
        if (i().compareAndSet(this, r3, r1.a(r3, r10)) == true) goto L20;
        if (this.f39430d == false) goto L3;
    L24:
        z<E> this = this.a(r7, r10);
        if (this != null) goto L24;
        return r9;
    L20:
        f().set(this.f39431e & r7, null);
        return r9;
    L17:
        return null;
    L13:
        if (this.f39430d == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return f39428b;
    }

    private final z<E> a(int r11, int r12) {
        AtomicLongFieldUpdater r0 = i();
    L3:
        long r3 = r0.get(this);
        a r1 = f39427a;
        boolean r2 = false;
        int r7 = (int) ((1073741823 & r3) >> 0);
        if (kotlinx.coroutines.aq.a() == false) goto L12;
        if (r7 != r11) goto L7;
        r2 = true;
    L7:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L12:
        if ((1152921504606846976L & r3) != 0) goto L14;
        if (i().compareAndSet(this, r3, r1.a(r3, r12)) == false) goto L3;
        f().set(this.f39431e & r7, null);
        return null;
    L14:
        return e();
    }

    public final z<E> e() {
        return a(g());
    }

    private final long g() {
        AtomicLongFieldUpdater r6 = i();
    L3:
        long r2 = r6.get(this);
        if ((r2 & 1152921504606846976L) != 0) goto L5;
        long r7 = r2 | 1152921504606846976L;
        if (r6.compareAndSet(this, r2, r7) == false) goto L3;
        return r7;
    L5:
        return r2;
    }

    private final z<E> a(long r5) {
        AtomicReferenceFieldUpdater r0 = h();
    L3:
        z<E> r1 = (z) ZeusTransformUtils.preCheckCast(r0.get(this), z.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        h().compareAndSet(this, null, b(r5));
        goto L3
    L5:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final z<E> b(long r7) {
        z<E> r0 = new z(this.f39429c * 2, this.f39430d);
        int r1 = (int) ((1073741823 & r7) >> 0);
        int r2 = (int) ((1152921503533105152L & r7) >> 30);
    L3:
        int r3 = this.f39431e;
        if ((r1 & r3) == (r3 & r2)) goto L9;
        Object r4 = f().get(this.f39431e & r1);
        if (r4 != null) goto L8;
        r4 = new b(r1);
    L8:
        r0.f().set(r0.f39431e & r1, r4);
        r1 = r1 + 1;
        goto L3
    L9:
        i().set(r0, f39427a.a(r7, 1152921504606846976L));
        return r0;
    }

    static {
        f39427a = new a(null);
        g = AtomicReferenceFieldUpdater.newUpdater(z.class, Object.class, "_next$volatile");
        h = AtomicLongFieldUpdater.newUpdater(z.class, "_state$volatile");
        f39428b = new al("REMOVE_FROZEN");
    }
}
