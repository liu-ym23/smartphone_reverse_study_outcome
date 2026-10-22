package sd;

import com.stepos.core.ability.speech.PcmDumpBudget;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f11915a = new a0(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f11916b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<a0>[] f11917c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f11916b = iHighestOneBit;
        AtomicReference<a0>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f11917c = atomicReferenceArr;
    }

    public static final void a(a0 segment) {
        kotlin.jvm.internal.g.f(segment, "segment");
        if (segment.f11906f != null || segment.f11907g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.f11904d) {
            return;
        }
        AtomicReference<a0> atomicReference = f11917c[(int) (Thread.currentThread().getId() & (f11916b - 1))];
        a0 a0Var = f11915a;
        a0 andSet = atomicReference.getAndSet(a0Var);
        if (andSet == a0Var) {
            return;
        }
        int i10 = andSet != null ? andSet.f11903c : 0;
        if (i10 >= 65536) {
            atomicReference.set(andSet);
            return;
        }
        segment.f11906f = andSet;
        segment.f11902b = 0;
        segment.f11903c = i10 + PcmDumpBudget.HARD_MAX_DIR_MB;
        atomicReference.set(segment);
    }

    public static final a0 b() {
        AtomicReference<a0> atomicReference = f11917c[(int) (Thread.currentThread().getId() & (f11916b - 1))];
        a0 a0Var = f11915a;
        a0 andSet = atomicReference.getAndSet(a0Var);
        if (andSet == a0Var) {
            return new a0();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new a0();
        }
        atomicReference.set(andSet.f11906f);
        andSet.f11906f = null;
        andSet.f11903c = 0;
        return andSet;
    }
}
