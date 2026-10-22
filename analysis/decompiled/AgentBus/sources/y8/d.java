package y8;

/* loaded from: classes.dex */
public final class d extends m0.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11711g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f11712h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(c cVar, int i2) {
        super(1);
        this.f11711g = i2;
        this.f11712h = cVar;
    }

    @Override // m0.a
    public final void e(String[] strArr) {
        switch (this.f11711g) {
            case 0:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1.visitEnd must not be null");
                }
                this.f11712h.f11710g.f11718i = strArr;
                return;
            default:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2.visitEnd must not be null");
                }
                this.f11712h.f11710g.f11719j = strArr;
                return;
        }
    }
}
