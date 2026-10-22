package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = null;
    private final KotlinClassHeader classHeader;
    private final Class<?> klass;

    /* JADX INFO: compiled from: ReflectKotlinClass.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r1) {
            this();
        }

        private Factory() {
        }

        public final ReflectKotlinClass create(Class<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "klass");
            ReadKotlinClassHeaderAnnotationVisitor r2 = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(r3, r2);
            KotlinClassHeader r4 = r2.createHeader();
            DefaultConstructorMarker r1 = null;
            if (r4 != null) goto L6;
            return null;
        L6:
            return new ReflectKotlinClass(r3, r4, r1);
        }
    }

    static {
        Factory = new Factory(null);
    }

    public /* synthetic */ ReflectKotlinClass(Class r1, KotlinClassHeader r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    private ReflectKotlinClass(Class<?> r1, KotlinClassHeader r2) {
        this.klass = r1;
        this.classHeader = r2;
    }

    public final Class<?> getKlass() {
        return this.klass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public String getLocation() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.klass.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "klass.name");
        return r0.append(StringsKt.replace$default(r1, '.', '/', false, 4, null)).append(".class").toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, r1);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectKotlinClass) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.klass, ((ReflectKotlinClass) r2).klass) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.klass;
    }
}
