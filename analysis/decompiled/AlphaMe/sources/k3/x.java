package k3;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class x {

    /* renamed from: a, reason: collision with root package name */
    public static final w f13392a = new w(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f13393b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference[] f13394c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f13393b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i4 = 0; i4 < iHighestOneBit; i4++) {
            atomicReferenceArr[i4] = new AtomicReference();
        }
        f13394c = atomicReferenceArr;
    }

    public static final void a(w segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.f13390f != null || segment.f13391g != null) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f13388d) {
            return;
        }
        AtomicReference atomicReference = f13394c[(int) (Thread.currentThread().getId() & (f13393b - 1))];
        w wVar = (w) atomicReference.get();
        if (wVar == f13392a) {
            return;
        }
        int i4 = wVar != null ? wVar.f13387c : 0;
        if (i4 >= 65536) {
            return;
        }
        segment.f13390f = wVar;
        segment.f13386b = 0;
        segment.f13387c = i4 + 8192;
        if (atomicReference.compareAndSet(wVar, segment)) {
            return;
        }
        segment.f13390f = null;
    }

    public static final w b() {
        AtomicReference atomicReference = f13394c[(int) (Thread.currentThread().getId() & (f13393b - 1))];
        w wVar = f13392a;
        w wVar2 = (w) atomicReference.getAndSet(wVar);
        if (wVar2 == wVar) {
            return new w();
        }
        if (wVar2 == null) {
            atomicReference.set(null);
            return new w();
        }
        atomicReference.set(wVar2.f13390f);
        wVar2.f13390f = null;
        wVar2.f13387c = 0;
        return wVar2;
    }
}
