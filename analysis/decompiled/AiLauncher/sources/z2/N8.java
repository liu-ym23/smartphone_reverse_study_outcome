package z2;

/* loaded from: classes2.dex */
public final class N8 {

    /* renamed from: a, reason: collision with root package name */
    public static L8 f44744a;

    public static synchronized B8 a(AbstractC6274t8 abstractC6274t8) {
        try {
            if (f44744a == null) {
                f44744a = new L8(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (B8) f44744a.b(abstractC6274t8);
    }

    public static synchronized B8 b(String str) {
        return a(AbstractC6274t8.d(str).c());
    }
}
