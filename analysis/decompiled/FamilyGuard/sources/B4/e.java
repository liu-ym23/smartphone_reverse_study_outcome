package B4;

import x4.C1294F;
import x4.C1297I;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int f237a = C1297I.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* renamed from: b, reason: collision with root package name */
    private static final C1294F f238b = new C1294F("PERMIT");

    /* renamed from: c, reason: collision with root package name */
    private static final C1294F f239c = new C1294F("TAKEN");

    /* renamed from: d, reason: collision with root package name */
    private static final C1294F f240d = new C1294F("BROKEN");

    /* renamed from: e, reason: collision with root package name */
    private static final C1294F f241e = new C1294F("CANCELLED");

    /* renamed from: f, reason: collision with root package name */
    private static final int f242f = C1297I.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final f h(long j5, f fVar) {
        return new f(j5, fVar, 0);
    }
}
