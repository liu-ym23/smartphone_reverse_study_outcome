package qa;

/* loaded from: classes4.dex */
public abstract class G {

    /* renamed from: a, reason: collision with root package name */
    public static final U5.d f5629a;
    public static final C1849a b;
    public static final C1849a c;

    static {
        String property = System.getProperty("java.vm.name");
        property.getClass();
        int i = 6;
        if (property.equals("RoboVM")) {
            f5629a = null;
            b = new C1849a(7);
            c = new C1849a(i);
            return;
        }
        int i6 = 1;
        if (property.equals("Dalvik")) {
            f5629a = new U5.d(1);
            b = new H(0);
            c = new C1851c(i);
        } else {
            f5629a = null;
            b = new H(i6);
            c = new C1851c(i);
        }
    }
}
