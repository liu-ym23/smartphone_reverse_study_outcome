package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes4.dex */
public interface PropertyAccessorDescriptor extends VariableAccessorDescriptor {
    PropertyDescriptor getCorrespondingProperty();

    boolean isDefault();
}
