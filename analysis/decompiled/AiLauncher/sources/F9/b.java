package F9;

/* loaded from: classes5.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final g f2599a;

    public b(g gVar) {
        if (gVar == null) {
            T(0);
        }
        this.f2599a = gVar;
    }

    private static /* synthetic */ void T(int i10) {
        String str = i10 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i10 != 1 ? 3 : 2];
        if (i10 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i10 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i10 != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i10 == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // F9.a
    public g getAnnotations() {
        g gVar = this.f2599a;
        if (gVar == null) {
            T(1);
        }
        return gVar;
    }
}
