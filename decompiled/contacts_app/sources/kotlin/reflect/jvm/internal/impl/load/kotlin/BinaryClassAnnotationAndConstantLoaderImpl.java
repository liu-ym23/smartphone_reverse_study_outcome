package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.android.vcard.VCardConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    private final AnnotationDeserializer annotationDeserializer;
    private final ModuleDescriptor module;
    private final NotFoundClasses notFoundClasses;

    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    private abstract class AbstractAnnotationArgumentVisitor implements KotlinJvmBinaryClass.AnnotationArgumentVisitor {
        final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

        public abstract void visitArrayValue(Name r1, ArrayList<ConstantValue<?>> r2);

        public abstract void visitConstantValue(Name r1, ConstantValue<?> r2);

        public AbstractAnnotationArgumentVisitor(BinaryClassAnnotationAndConstantLoaderImpl r1) {
            this.this$0 = r1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visit(Name r2, Object r3) {
            visitConstantValue(r2, BinaryClassAnnotationAndConstantLoaderImpl.access$createConstant(this.this$0, r2, r3));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitClassLiteral(Name r2, ClassLiteralValue r3) {
            Intrinsics.checkNotNullParameter(r3, "value");
            visitConstantValue(r2, new KClassValue(r3));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public void visitEnum(Name r2, ClassId r3, Name r4) {
            Intrinsics.checkNotNullParameter(r3, "enumClassId");
            Intrinsics.checkNotNullParameter(r4, "enumEntryName");
            visitConstantValue(r2, new EnumValue(r3, r4));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray(Name r3) {
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitArray$1(this.this$0, r3, this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor
        public KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation(final Name r5, ClassId r6) {
            Intrinsics.checkNotNullParameter(r6, "classId");
            final ArrayList r0 = new ArrayList();
            BinaryClassAnnotationAndConstantLoaderImpl r1 = this.this$0;
            SourceElement r2 = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(r2, "NO_SOURCE");
            final KotlinJvmBinaryClass.AnnotationArgumentVisitor r7 = r1.loadAnnotation(r6, r2, r0);
            Intrinsics.checkNotNull(r7);
            return new BinaryClassAnnotationAndConstantLoaderImpl$AbstractAnnotationArgumentVisitor$visitAnnotation$1(r7, this, r5, r0);
        }
    }

    public static final /* synthetic */ ConstantValue access$createConstant(BinaryClassAnnotationAndConstantLoaderImpl r0, Name r1, Object r2) {
        return r0.createConstant(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> loadConstant(String r1, Object r2) {
        return loadConstant2(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    public /* bridge */ /* synthetic */ Object loadTypeAnnotation(ProtoBuf.Annotation r1, NameResolver r2) {
        return loadTypeAnnotation(r1, r2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    public /* bridge */ /* synthetic */ ConstantValue<?> transformToUnsignedConstant(ConstantValue<?> r1) {
        return transformToUnsignedConstant2(r1);
    }

    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor r2, NotFoundClasses r3, StorageManager r4, KotlinClassFinder r5) {
        Intrinsics.checkNotNullParameter(r2, "module");
        Intrinsics.checkNotNullParameter(r3, "notFoundClasses");
        Intrinsics.checkNotNullParameter(r4, "storageManager");
        Intrinsics.checkNotNullParameter(r5, "kotlinClassFinder");
        super(r4, r5);
        this.module = r2;
        this.notFoundClasses = r3;
        this.annotationDeserializer = new AnnotationDeserializer(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected AnnotationDescriptor loadTypeAnnotation(ProtoBuf.Annotation r2, NameResolver r3) {
        Intrinsics.checkNotNullParameter(r2, "proto");
        Intrinsics.checkNotNullParameter(r3, "nameResolver");
        return this.annotationDeserializer.deserializeAnnotation(r2, r3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader
    /* JADX INFO: renamed from: loadConstant, reason: avoid collision after fix types in other method */
    protected ConstantValue<?> loadConstant2(String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "desc");
        Intrinsics.checkNotNullParameter(r6, "initializer");
        boolean r3 = false;
        if (StringsKt.contains$default("ZBCS", r5, false, 2, null) == false) goto L29;
        int r4 = ((Integer) r6).intValue();
        int r7 = r5.hashCode();
        if (r7 == 66) goto L24;
        if (r7 == 67) goto L21;
        if (r7 == 83) goto L18;
        if (r7 != 90) goto L27;
        if (r5.equals("Z") == false) goto L27;
        if (r4 == 0) goto L16;
        r3 = true;
    L16:
        r6 = Boolean.valueOf(r3);
    L27:
        throw new AssertionError(r5);
    L18:
        if (r5.equals(ExifInterface.LATITUDE_SOUTH) == false) goto L27;
        r6 = Short.valueOf((short) r4);
        goto L29
    L21:
        if (r5.equals("C") == false) goto L27;
        r6 = Character.valueOf((char) r4);
        goto L29
    L24:
        if (r5.equals(VCardConstants.PARAM_ENCODING_B) == false) goto L27;
        r6 = Byte.valueOf((byte) r4);
    L29:
        return ConstantValueFactory.INSTANCE.createConstantValue(r6);
    }

    /* JADX INFO: renamed from: transformToUnsignedConstant, reason: avoid collision after fix types in other method */
    protected ConstantValue<?> transformToUnsignedConstant2(ConstantValue<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "constant");
        if ((r3 instanceof ByteValue) == false) goto L6;
        return new UByteValue(((ByteValue) r3).getValue().byteValue());
    L6:
        if ((r3 instanceof ShortValue) == false) goto L9;
        return new UShortValue(((ShortValue) r3).getValue().shortValue());
    L9:
        if ((r3 instanceof IntValue) == false) goto L12;
        return new UIntValue(((IntValue) r3).getValue().intValue());
    L12:
        if ((r3 instanceof LongValue) == true) goto L14;
        return r3;
    L14:
        return new ULongValue(((LongValue) r3).getValue().longValue());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader
    protected KotlinJvmBinaryClass.AnnotationArgumentVisitor loadAnnotation(final ClassId r8, final SourceElement r9, final List<AnnotationDescriptor> r10) {
        Intrinsics.checkNotNullParameter(r8, "annotationClassId");
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter(r10, "result");
        final ClassDescriptor r3 = resolveClass(r8);
        return new AnonymousClass1(this, r3, r8, r10, r9);
    }

    private final ConstantValue<?> createConstant(Name r2, Object r3) {
        ConstantValue<?> r1 = ConstantValueFactory.INSTANCE.createConstantValue(r3);
        if (r1 == null) goto L5;
        return r1;
    L5:
        return ErrorValue.Companion.create("Unsupported annotation argument: " + r2);
    }

    private final ClassDescriptor resolveClass(ClassId r2) {
        return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, r2, this.notFoundClasses);
    }
}
