package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bH\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\"\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"LMb/F;", "", "<init>", "()V", "LMb/E;", "c", "()LMb/E;", "segment", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LMb/E;)V", "Ljava/util/concurrent/atomic/AtomicReference;", Const.INTENT_KEY_APIKEY, "()Ljava/util/concurrent/atomic/AtomicReference;", "", "I", "getMAX_SIZE", "()I", "MAX_SIZE", "LMb/E;", "LOCK", Const.INTENT_KEY_UMID, "HASH_BUCKET_COUNT", "", "e", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class F {

    /* renamed from: a, reason: collision with root package name */
    public static final F f4688a = new F();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final int MAX_SIZE = 65536;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final E LOCK = new E(new byte[0], 0, 0, false, false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final int HASH_BUCKET_COUNT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final AtomicReference<E>[] hashBuckets;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        AtomicReference<E>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    public static final void b(E segment) {
        AtomicReference<E> atomicReferenceA;
        E e10;
        E andSet;
        kotlin.jvm.internal.p.i(segment, "segment");
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.shared || (andSet = (atomicReferenceA = f4688a.a()).getAndSet((e10 = LOCK))) == e10) {
            return;
        }
        int i10 = andSet != null ? andSet.limit : 0;
        if (i10 >= MAX_SIZE) {
            atomicReferenceA.set(andSet);
            return;
        }
        segment.next = andSet;
        segment.pos = 0;
        segment.limit = i10 + com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
        atomicReferenceA.set(segment);
    }

    public static final E c() {
        AtomicReference<E> atomicReferenceA = f4688a.a();
        E e10 = LOCK;
        E andSet = atomicReferenceA.getAndSet(e10);
        if (andSet == e10) {
            return new E();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new E();
        }
        atomicReferenceA.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final AtomicReference<E> a() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (HASH_BUCKET_COUNT - 1))];
    }
}
