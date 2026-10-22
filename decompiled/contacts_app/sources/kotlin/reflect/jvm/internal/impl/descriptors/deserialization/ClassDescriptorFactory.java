package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: ClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ClassDescriptorFactory {
    ClassDescriptor createClass(ClassId r1);

    Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName r1);

    boolean shouldCreateClass(FqName r1, Name r2);
}
