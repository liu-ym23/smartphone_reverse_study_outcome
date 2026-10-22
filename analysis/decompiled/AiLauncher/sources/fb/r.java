package fb;

import La.C;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001d\u0010\u0012R\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u001a\u0010$\u001a\u00020\u00108\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b#\u0010\u0012R\u0014\u0010%\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u001c\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(¨\u0006,"}, d2 = {"Lfb/r;", "", "<init>", "()V", "Lfb/o;", "f", "()Lfb/o;", Const.INTENT_KEY_BACKGROUND_COMMAND, "segment", "LY8/t;", Const.INTENT_KEY_UMID, "(Lfb/o;)V", "e", "Lfb/p;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lfb/p;", "", Const.INTENT_KEY_PKGNAME, "()I", "c", "", "mask", Const.INTENT_KEY_APIKEY, "(J)I", "I", "getMAX_SIZE", "MAX_SIZE", "Lfb/o;", "LOCK", "getHASH_BUCKET_COUNT$kotlinx_io_core", "HASH_BUCKET_COUNT", "HASH_BUCKET_COUNT_L2", "", "Ljava/lang/String;", "DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE", "getSECOND_LEVEL_POOL_TOTAL_SIZE$kotlinx_io_core", "SECOND_LEVEL_POOL_TOTAL_SIZE", "SECOND_LEVEL_POOL_BUCKET_SIZE", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "hashBuckets", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "hashBucketsL2", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f32624a = new r();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final int MAX_SIZE = 65536;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final o LOCK = o.INSTANCE.b(new byte[0], 0, 0, null, false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final int HASH_BUCKET_COUNT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final int HASH_BUCKET_COUNT_L2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final String DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final int SECOND_LEVEL_POOL_TOTAL_SIZE;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final int SECOND_LEVEL_POOL_BUCKET_SIZE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final AtomicReferenceArray<o> hashBuckets;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final AtomicReferenceArray<o> hashBucketsL2;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        int iF = C5685n.f(iHighestOneBit / 2, 1);
        HASH_BUCKET_COUNT_L2 = iF;
        String str = kotlin.jvm.internal.p.d(System.getProperty("java.vm.name"), "Dalvik") ? "0" : "4194304";
        DEFAULT_SECOND_LEVEL_POOL_TOTAL_SIZE = str;
        String property = System.getProperty("kotlinx.io.pool.size.bytes", str);
        kotlin.jvm.internal.p.h(property, "getProperty(...)");
        Integer numW = C.w(property);
        int iF2 = numW != null ? C5685n.f(numW.intValue(), 0) : 0;
        SECOND_LEVEL_POOL_TOTAL_SIZE = iF2;
        SECOND_LEVEL_POOL_BUCKET_SIZE = C5685n.f(iF2 / iF, com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
        hashBuckets = new AtomicReferenceArray<>(iHighestOneBit);
        hashBucketsL2 = new AtomicReferenceArray<>(iF);
    }

    public static final void d(o segment) {
        kotlin.jvm.internal.p.i(segment, "segment");
        if (segment.getNext() != null || segment.getPrev() != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        p copyTracker = segment.getCopyTracker();
        if (copyTracker != null && copyTracker.c()) {
            return;
        }
        AtomicReferenceArray<o> atomicReferenceArray = hashBuckets;
        int iB = f32624a.b();
        segment.u(0);
        segment.owner = true;
        while (true) {
            o oVar = atomicReferenceArray.get(iB);
            if (oVar != LOCK) {
                int limit = oVar != null ? oVar.getLimit() : 0;
                if (limit >= MAX_SIZE) {
                    if (SECOND_LEVEL_POOL_TOTAL_SIZE > 0) {
                        e(segment);
                        return;
                    }
                    return;
                } else {
                    segment.t(oVar);
                    segment.s(limit + com.stepos.agentframework.chatui.longtext.b.THRESHOLD);
                    if (atomicReferenceArray.compareAndSet(iB, oVar, segment)) {
                        return;
                    }
                }
            }
        }
    }

    public static final void e(o segment) {
        segment.u(0);
        segment.owner = true;
        int iC = f32624a.c();
        AtomicReferenceArray<o> atomicReferenceArray = hashBucketsL2;
        int i10 = 0;
        while (true) {
            o oVar = atomicReferenceArray.get(iC);
            if (oVar != LOCK) {
                int limit = (oVar != null ? oVar.getLimit() : 0) + com.stepos.agentframework.chatui.longtext.b.THRESHOLD;
                if (limit > SECOND_LEVEL_POOL_BUCKET_SIZE) {
                    int i11 = HASH_BUCKET_COUNT_L2;
                    if (i10 >= i11) {
                        return;
                    }
                    i10++;
                    iC = (iC + 1) & (i11 - 1);
                } else {
                    segment.t(oVar);
                    segment.s(limit);
                    if (atomicReferenceArray.compareAndSet(iC, oVar, segment)) {
                        return;
                    }
                }
            }
        }
    }

    public static final o f() {
        o oVar;
        o andSet;
        AtomicReferenceArray<o> atomicReferenceArray = hashBuckets;
        int iB = f32624a.b();
        do {
            oVar = LOCK;
            andSet = atomicReferenceArray.getAndSet(iB, oVar);
        } while (kotlin.jvm.internal.p.d(andSet, oVar));
        if (andSet == null) {
            atomicReferenceArray.set(iB, null);
            return SECOND_LEVEL_POOL_TOTAL_SIZE > 0 ? g() : o.INSTANCE.a();
        }
        atomicReferenceArray.set(iB, andSet.getNext());
        andSet.t(null);
        andSet.s(0);
        return andSet;
    }

    public static final o g() {
        AtomicReferenceArray<o> atomicReferenceArray = hashBucketsL2;
        int iC = f32624a.c();
        int i10 = 0;
        while (true) {
            o oVar = LOCK;
            o andSet = atomicReferenceArray.getAndSet(iC, oVar);
            if (!kotlin.jvm.internal.p.d(andSet, oVar)) {
                if (andSet != null) {
                    atomicReferenceArray.set(iC, andSet.getNext());
                    andSet.t(null);
                    andSet.s(0);
                    return andSet;
                }
                atomicReferenceArray.set(iC, null);
                int i11 = HASH_BUCKET_COUNT_L2;
                if (i10 >= i11) {
                    return o.INSTANCE.a();
                }
                iC = (iC + 1) & (i11 - 1);
                i10++;
            }
        }
    }

    public static final p h() {
        return new n();
    }

    public final int a(long mask) {
        return (int) (Thread.currentThread().getId() & mask);
    }

    public final int b() {
        return a(HASH_BUCKET_COUNT - 1);
    }

    public final int c() {
        return a(HASH_BUCKET_COUNT_L2 - 1);
    }
}
