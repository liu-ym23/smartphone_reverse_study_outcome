package C3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public final class b extends a {

    /* renamed from: g, reason: collision with root package name */
    public static final Integer f350g = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicLong f351c;

    /* renamed from: d, reason: collision with root package name */
    public long f352d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicLong f353e;

    /* renamed from: f, reason: collision with root package name */
    public final int f354f;

    public b(int i4) {
        super(i4);
        this.f351c = new AtomicLong();
        this.f353e = new AtomicLong();
        this.f354f = Math.min(i4 / 4, f350g.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.f351c.get() == this.f353e.get();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f348a;
        AtomicLong atomicLong = this.f351c;
        long j4 = atomicLong.get();
        int i4 = this.f349b;
        int i5 = ((int) j4) & i4;
        if (j4 >= this.f352d) {
            long j5 = this.f354f + j4;
            if (atomicReferenceArray.get(i4 & ((int) j5)) == null) {
                this.f352d = j5;
            } else if (atomicReferenceArray.get(i5) != null) {
                return false;
            }
        }
        atomicReferenceArray.lazySet(i5, obj);
        atomicLong.lazySet(j4 + 1);
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        return this.f348a.get(((int) this.f353e.get()) & this.f349b);
    }

    @Override // java.util.Queue
    public final Object poll() {
        AtomicLong atomicLong = this.f353e;
        long j4 = atomicLong.get();
        int i4 = ((int) j4) & this.f349b;
        AtomicReferenceArray atomicReferenceArray = this.f348a;
        Object obj = atomicReferenceArray.get(i4);
        if (obj == null) {
            return null;
        }
        atomicReferenceArray.lazySet(i4, null);
        atomicLong.lazySet(j4 + 1);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        AtomicLong atomicLong = this.f353e;
        long j4 = atomicLong.get();
        while (true) {
            long j5 = this.f351c.get();
            long j6 = atomicLong.get();
            if (j4 == j6) {
                return (int) (j5 - j6);
            }
            j4 = j6;
        }
    }
}
