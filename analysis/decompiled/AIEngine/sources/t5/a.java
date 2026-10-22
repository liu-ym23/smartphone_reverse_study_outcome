package t5;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @FunctionalInterface
    /* renamed from: t5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0147a {
        boolean a(int i10, String str);
    }

    public static void a(String str, int i10, int i11, InterfaceC0147a interfaceC0147a) {
        if (i10 <= 0 || i11 < 0 || i11 >= i10) {
            throw new IllegalArgumentException(a0.a.f("chunk size must be positive and overlap in [0, size): size=", i10, i11, ", overlap="));
        }
        int i12 = 0;
        while (i12 < str.length()) {
            int iMin = Math.min(i12 + i10, str.length());
            if (interfaceC0147a.a(i12, str.substring(i12, iMin)) || iMin == str.length()) {
                return;
            } else {
                i12 += i10 - i11;
            }
        }
    }
}
