package c7;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final q f1193a = new q(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f1194b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f1195c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f1194b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i8 = 0; i8 < iHighestOneBit; i8++) {
            atomicReferenceArr[i8] = new AtomicReference();
        }
        f1195c = atomicReferenceArr;
    }

    public static final void a(q segment) {
        kotlin.jvm.internal.p.e(segment, "segment");
        if (segment.f1191f != null || segment.f1192g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.d) {
            return;
        }
        AtomicReference atomicReference = f1195c[(int) (Thread.currentThread().getId() & (f1194b - 1))];
        q qVar = f1193a;
        q qVar2 = (q) atomicReference.getAndSet(qVar);
        if (qVar2 == qVar) {
            return;
        }
        int i8 = qVar2 != null ? qVar2.f1189c : 0;
        if (i8 >= 65536) {
            atomicReference.set(qVar2);
            return;
        }
        segment.f1191f = qVar2;
        segment.f1188b = 0;
        segment.f1189c = i8 + 8192;
        atomicReference.set(segment);
    }

    public static final q b() {
        AtomicReference atomicReference = f1195c[(int) (Thread.currentThread().getId() & (f1194b - 1))];
        q qVar = f1193a;
        q qVar2 = (q) atomicReference.getAndSet(qVar);
        if (qVar2 == qVar) {
            return new q();
        }
        if (qVar2 == null) {
            atomicReference.set(null);
            return new q();
        }
        atomicReference.set(qVar2.f1191f);
        qVar2.f1191f = null;
        qVar2.f1189c = 0;
        return qVar2;
    }
}
