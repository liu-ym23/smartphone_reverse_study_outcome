package androidx.compose.runtime;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements n {

    /* renamed from: b, reason: collision with root package name */
    public static final e f977b = new e(0);

    /* renamed from: c, reason: collision with root package name */
    public static final e f978c = new e(1);

    /* renamed from: d, reason: collision with root package name */
    public static final e f979d = new e(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f980a;

    public /* synthetic */ e(int i10) {
        this.f980a = i10;
    }

    @Override // androidx.compose.runtime.n
    public final boolean a(Object obj, Object obj2) {
        switch (this.f980a) {
            case 0:
                return false;
            case 1:
                return obj == obj2;
            default:
                return kotlin.jvm.internal.g.b(obj, obj2);
        }
    }

    public final String toString() {
        switch (this.f980a) {
            case 0:
                return "NeverEqualPolicy";
            case 1:
                return "ReferentialEqualityPolicy";
            default:
                return "StructuralEqualityPolicy";
        }
    }
}
