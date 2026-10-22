package e4;

import d4.C0673a;
import n4.AbstractC0886c;
import o4.C0903a;

/* renamed from: e4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0691a extends C0673a {

    /* renamed from: e4.a$a, reason: collision with other inner class name */
    private static final class C0212a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0212a f16711a = new C0212a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f16712b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f16712b = num;
        }

        private C0212a() {
        }
    }

    private final boolean c(int i5) {
        Integer num = C0212a.f16712b;
        return num == null || num.intValue() >= i5;
    }

    @Override // c4.C0584a
    public AbstractC0886c b() {
        return c(34) ? new C0903a() : super.b();
    }
}
