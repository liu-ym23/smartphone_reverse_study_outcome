package A8;

import z8.n;

/* loaded from: classes4.dex */
public final class c extends b {
    public final /* synthetic */ int b;
    public final /* synthetic */ n c;

    public /* synthetic */ c(n nVar, int i) {
        this.b = i;
        this.c = nVar;
    }

    @Override // A8.b
    public final void O0(String[] strArr) {
        switch (this.b) {
            case 0:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1.visitEnd must not be null");
                }
                ((f) ((d) this.c).b).d = strArr;
                return;
            case 1:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2.visitEnd must not be null");
                }
                ((f) ((d) this.c).b).e = strArr;
                return;
            default:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'result' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1.visitEnd must not be null");
                }
                ((f) ((Z0.a) this.c).f1582a).h = strArr;
                return;
        }
    }
}
