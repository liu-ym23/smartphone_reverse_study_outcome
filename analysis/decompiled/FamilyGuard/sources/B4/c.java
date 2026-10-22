package B4;

import x4.C1294F;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final C1294F f225a = new C1294F("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    private static final C1294F f226b = new C1294F("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z5) {
        return new b(z5);
    }

    public static /* synthetic */ a b(boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return a(z5);
    }
}
