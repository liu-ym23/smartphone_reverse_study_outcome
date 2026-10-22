package X8;

/* renamed from: X8.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0288t implements S7.k {
    public static final C0288t b = new C0288t(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1534a;

    public /* synthetic */ C0288t(int i) {
        this.f1534a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1534a) {
            case 0:
                w it = (w) obj;
                kotlin.jvm.internal.k.f(it, "it");
                return it.toString();
            default:
                if (((G8.c) obj) != null) {
                    return Boolean.valueOf(!r1.equals(e8.n.y));
                }
                throw new IllegalArgumentException("Argument for @NotNull parameter 'name' of kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1.invoke must not be null");
        }
    }
}
