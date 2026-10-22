package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 implements KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor {
    final /* synthetic */ Name $name;
    private final ArrayList<ConstantValue<?>> elements;
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;
    final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor this$1;

    BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(BinaryClassAnnotationAndConstantLoaderImpl r1, Name r2, BinaryClassAnnotationAndConstantLoaderImpl.AbstractAnnotationArgumentVisitor r3) {
        this.this$0 = r1;
        this.$name = r2;
        this.this$1 = r3;
        this.elements = new ArrayList();
    }

    public static final /* synthetic */ ArrayList access$getElements$p(BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1 r0) {
        return r0.elements;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visit(Object r3) {
        this.elements.add(BinaryClassAnnotationAndConstantLoaderImpl.access$createConstant(this.this$0, this.$name, r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitEnum(ClassId r2, Name r3) {
        Intrinsics.checkNotNullParameter(r2, "enumClassId");
        Intrinsics.checkNotNullParameter(r3, "enumEntryName");
        this.elements.add(new EnumValue(r2, r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitClassLiteral(ClassLiteralValue r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.elements.add(new KClassValue(r2));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(ClassId r5) {
        Intrinsics.checkNotNullParameter(r5, "classId");
        final ArrayList r0 = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl r1 = this.this$0;
        SourceElement r2 = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(r2, "NO_SOURCE");
        final KotlinJvmBinaryClass.AnnotationArgumentVisitor r6 = r1.loadAnnotation(r5, r2, r0);
        Intrinsics.checkNotNull(r6);
        return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1$visitAnnotation$1(r6, this, r0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor
    public void visitEnd() {
        this.this$1.visitArrayValue(this.$name, this.elements);
    }
}
