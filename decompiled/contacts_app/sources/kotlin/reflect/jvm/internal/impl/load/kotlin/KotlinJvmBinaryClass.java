package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;

/* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface KotlinJvmBinaryClass {

    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface AnnotationArgumentVisitor {
        void visit(Name r1, Object r2);

        AnnotationArgumentVisitor visitAnnotation(Name r1, ClassId r2);

        AnnotationArrayArgumentVisitor visitArray(Name r1);

        void visitClassLiteral(Name r1, ClassLiteralValue r2);

        void visitEnd();

        void visitEnum(Name r1, ClassId r2, Name r3);
    }

    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface AnnotationArrayArgumentVisitor {
        void visit(Object r1);

        AnnotationArgumentVisitor visitAnnotation(ClassId r1);

        void visitClassLiteral(ClassLiteralValue r1);

        void visitEnd();

        void visitEnum(ClassId r1, Name r2);
    }

    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface AnnotationVisitor {
        AnnotationArgumentVisitor visitAnnotation(ClassId r1, SourceElement r2);

        void visitEnd();
    }

    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface MemberVisitor {
        AnnotationVisitor visitField(Name r1, String r2, Object r3);

        MethodAnnotationVisitor visitMethod(Name r1, String r2);
    }

    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface MethodAnnotationVisitor extends AnnotationVisitor {
        AnnotationArgumentVisitor visitParameterAnnotation(int r1, ClassId r2, SourceElement r3);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(AnnotationVisitor r1, byte[] r2);

    void visitMembers(MemberVisitor r1, byte[] r2);
}
