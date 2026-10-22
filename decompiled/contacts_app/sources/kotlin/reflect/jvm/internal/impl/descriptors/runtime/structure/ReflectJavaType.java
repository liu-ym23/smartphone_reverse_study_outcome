package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = null;

    /* JADX INFO: compiled from: ReflectJavaType.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker r1) {
            this();
        }

        private Factory() {
        }

        public final ReflectJavaType create(Type r3) {
            Intrinsics.checkNotNullParameter(r3, "type");
            boolean r2 = r3 instanceof Class;
            if (r2 == false) goto L8;
            Class r0 = (Class) r3;
            if (r0.isPrimitive() == false) goto L8;
            return new ReflectJavaPrimitiveType(r0);
        L8:
            if ((r3 instanceof GenericArrayType) == true) goto L18;
            if (r2 == false) goto L14;
            if (((Class) r3).isArray() == true) goto L18;
        L14:
            if ((r3 instanceof WildcardType) == false) goto L21;
            return new ReflectJavaWildcardType((WildcardType) r3);
        L21:
            return new ReflectJavaClassifierType(r3);
        L18:
            return new ReflectJavaArrayType(r3);
        }
    }

    static {
        Factory = new Factory(null);
    }

    protected abstract Type getReflectType();

    public ReflectJavaType() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r1) {
        return JavaType.DefaultImpls.findAnnotation(this, r1);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectJavaType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) r2).getReflectType()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
