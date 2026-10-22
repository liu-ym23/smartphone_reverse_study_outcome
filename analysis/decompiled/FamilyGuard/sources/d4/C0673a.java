package d4;

import c4.C0584a;
import j4.k;
import java.lang.reflect.InvocationTargetException;

/* renamed from: d4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0673a extends C0584a {

    /* renamed from: d4.a$a, reason: collision with other inner class name */
    private static final class C0206a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0206a f16628a = new C0206a();

        /* renamed from: b, reason: collision with root package name */
        public static final Integer f16629b;

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
            f16629b = num;
        }

        private C0206a() {
        }
    }

    private final boolean c(int i5) {
        Integer num = C0206a.f16629b;
        return num == null || num.intValue() >= i5;
    }

    @Override // c4.C0584a
    public void a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        k.g(th, "cause");
        k.g(th2, "exception");
        if (c(19)) {
            th.addSuppressed(th2);
        } else {
            super.a(th, th2);
        }
    }
}
