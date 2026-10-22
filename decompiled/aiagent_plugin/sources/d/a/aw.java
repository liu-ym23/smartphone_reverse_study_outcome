package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes4.dex */
final class aw<T> extends c<T> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f38359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f38360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f38361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38362e;

    /* JADX INFO: compiled from: SlidingWindow.kt */
    public static final class a extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ aw<T> f38363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f38364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f38365c;

        a(aw<T> r2) {
            this.f38363a = r2;
            this.f38364b = r2.size();
            this.f38365c = aw.a(r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.a.b
        public void a() {
            if (this.f38364b != 0) goto L5;
            b();
            return;
        L5:
            a(aw.b(this.f38363a)[this.f38365c]);
            this.f38365c = (this.f38365c + 1) % aw.c(this.f38363a);
            this.f38364b--;
        }
    }

    public aw(Object[] r4, int r5) {
        d.h.b.o.e(r4, "buffer");
        this.f38359b = r4;
        boolean r0 = true;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L17;
        if (r5 <= r4.length) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L15;
        this.f38360c = r4.length;
        this.f38362e = r5;
        return;
    L15:
        throw new IllegalArgumentException(("ring buffer filled size: " + r5 + " cannot be larger than the buffer size: " + r4.length).toString());
    L17:
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + r5).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static final /* synthetic */ int a(aw r0) {
        return r0.f38361d;
    }

    public static final /* synthetic */ Object[] b(aw r0) {
        return r0.f38359b;
    }

    public static final /* synthetic */ int c(aw r0) {
        return r0.f38360c;
    }

    public aw(int r2) {
        this(new Object[r2], 0);
    }

    @Override // d.a.a
    public int a() {
        return this.f38362e;
    }

    @Override // d.a.c, java.util.List
    public T get(int r3) {
        c.f38373a.a(r3, size());
        return (T) this.f38359b[(this.f38361d + r3) % c(this)];
    }

    public final boolean b() {
        if (size() != this.f38360c) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.a.c, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<T> iterator() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }

    @Override // d.a.a, java.util.Collection
    public <T> T[] toArray(T[] r6) {
        d.h.b.o.e(r6, "array");
        int r0 = r6.length;
        Object[] r7 = r6;
        if (r0 >= size()) goto L5;
        Object[] r8 = (T[]) Arrays.copyOf(r6, size());
        d.h.b.o.c(r8, "copyOf(...)");
        r7 = r8;
    L5:
        int r1 = size();
        int r2 = this.f38361d;
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L10;
        if (r2 >= this.f38360c) goto L10;
        r7[r4] = this.f38359b[r2];
        r4 = r4 + 1;
        r2 = r2 + 1;
    L10:
        if (r4 >= r1) goto L13;
        r7[r4] = this.f38359b[r3];
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L10
    L13:
        return (T[]) p.a(r1, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.a.a, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final aw<T> a(int r3) {
        int r0 = this.f38360c;
        int r4 = d.l.n.d((r0 + (r0 >> 1)) + 1, r3);
        if (this.f38361d != 0) goto L5;
        Object[] r5 = Arrays.copyOf(this.f38359b, r4);
        d.h.b.o.c(r5, "copyOf(...)");
    L7:
        return new aw(r5, size());
    L5:
        r5 = toArray(new Object[r4]);
        goto L7
    }

    public final void a(T r4) {
        if (b() == true) goto L7;
        this.f38359b[(this.f38361d + size()) % c(this)] = r4;
        this.f38362e = size() + 1;
        return;
    L7:
        throw new IllegalStateException("ring buffer is full");
    }

    public final void b(int r7) {
        boolean r0 = true;
        if (r7 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L22;
        if (r7 <= size()) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L20;
        if (r7 <= 0) goto L23;
        int r1 = this.f38361d;
        int r3 = (r1 + r7) % c(this);
        if (r1 <= r3) goto L16;
        i.a(this.f38359b, null, r1, this.f38360c);
        i.a(this.f38359b, null, 0, r3);
    L17:
        this.f38361d = r3;
        this.f38362e = size() - r7;
        return;
    L16:
        i.a(this.f38359b, null, r1, r3);
        goto L17
    L23:
        return;
    L20:
        throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + r7 + ", size = " + size()).toString());
    L22:
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + r7).toString());
    L5:
        r2 = false;
        goto L6
    }
}
