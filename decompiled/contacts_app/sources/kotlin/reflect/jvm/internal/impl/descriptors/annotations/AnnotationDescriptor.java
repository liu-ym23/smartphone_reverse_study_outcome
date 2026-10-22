package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* JADX INFO: compiled from: AnnotationDescriptor.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface AnnotationDescriptor {

    /* JADX INFO: compiled from: AnnotationDescriptor.kt */
    public static final class DefaultImpls {
        public static FqName getFqName(AnnotationDescriptor r2) {
            ClassDescriptor r3 = DescriptorUtilsKt.getAnnotationClass(r2);
            if (r3 != null) goto L5;
            return null;
        L5:
            if (ErrorUtils.isError(r3) == false) goto L8;
            r3 = null;
        L8:
            if (r3 != null) goto L10;
            return null;
        L10:
            return DescriptorUtilsKt.fqNameOrNull(r3);
        }
    }

    Map<Name, ConstantValue<?>> getAllValueArguments();

    FqName getFqName();

    SourceElement getSource();

    KotlinType getType();
}
