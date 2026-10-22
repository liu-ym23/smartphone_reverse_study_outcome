package A8;

/* loaded from: classes4.dex */
public final class e extends b {
    public final /* synthetic */ int b;
    public final /* synthetic */ a5.d c;

    public /* synthetic */ e(a5.d dVar, int i) {
        this.b = i;
        this.c = dVar;
    }

    @Override // A8.b
    public final void O0(String[] strArr) {
        switch (this.b) {
            case 0:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1.visitEnd must not be null");
                }
                ((f) this.c.b).d = strArr;
                return;
            default:
                if (strArr == null) {
                    throw new IllegalArgumentException("Argument for @NotNull parameter 'data' of kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2.visitEnd must not be null");
                }
                ((f) this.c.b).e = strArr;
                return;
        }
    }
}
