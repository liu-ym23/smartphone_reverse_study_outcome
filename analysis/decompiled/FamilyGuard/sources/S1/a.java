package S1;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class a implements D3.c<Throwable> {

    /* renamed from: c, reason: collision with root package name */
    private static Field f5225c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f5226d;

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f5227a = new Throwable();

    /* renamed from: b, reason: collision with root package name */
    private final D3.c<Throwable> f5228b;

    private a(D3.c<Throwable> cVar) {
        this.f5228b = cVar;
    }

    public static a b() {
        return new a(null);
    }

    public static a c(D3.c<Throwable> cVar) {
        return new a(cVar);
    }

    @Override // D3.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(Throwable th) throws IllegalAccessException, IllegalArgumentException {
        D3.c<Throwable> cVar = this.f5228b;
        if (cVar != null) {
            cVar.accept(th);
        }
        if (f5225c == null) {
            synchronized (this) {
                try {
                    if (f5225c == null) {
                        Field declaredField = Throwable.class.getDeclaredField("detailMessage");
                        f5225c = declaredField;
                        declaredField.setAccessible(true);
                        Field declaredField2 = Throwable.class.getDeclaredField("cause");
                        f5226d = declaredField2;
                        declaredField2.setAccessible(true);
                    }
                } finally {
                }
            }
        }
        f5225c.set(this.f5227a, th.toString());
        f5226d.set(this.f5227a, th);
        R1.a.n("RxThrowable", this.f5227a);
    }
}
