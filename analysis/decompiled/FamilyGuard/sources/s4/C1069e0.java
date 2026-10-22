package s4;

import x4.C1294F;

/* renamed from: s4.e0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1069e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final C1294F f20344a = new C1294F("REMOVED_TASK");

    /* renamed from: b, reason: collision with root package name */
    private static final C1294F f20345b = new C1294F("CLOSED_EMPTY");

    public static final long c(long j5) {
        if (j5 <= 0) {
            return 0L;
        }
        if (j5 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j5 * 1000000;
    }
}
