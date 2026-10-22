package y8;

import x8.k;

/* loaded from: classes.dex */
public final class b extends m0.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11707g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f11708h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(k kVar, int i2) {
        super(1);
        this.f11707g = i2;
        this.f11708h = kVar;
    }

    @Override // m0.a
    public final void e(String[] strArr) {
        switch (this.f11707g) {
            case 0:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1.visitEnd must not be null");
                }
                ((c) this.f11708h).f11710g.f11718i = strArr;
                return;
            case 1:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2.visitEnd must not be null");
                }
                ((c) this.f11708h).f11710g.f11719j = strArr;
                return;
            default:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1.visitEnd must not be null");
                }
                ((c) this.f11708h).f11710g.f11722m = strArr;
                return;
        }
    }
}
