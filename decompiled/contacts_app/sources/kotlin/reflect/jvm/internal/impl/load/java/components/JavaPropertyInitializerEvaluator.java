package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* JADX INFO: compiled from: JavaPropertyInitializerEvaluator.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface JavaPropertyInitializerEvaluator {

    /* JADX INFO: compiled from: JavaPropertyInitializerEvaluator.kt */
    public static final class DoNothing implements JavaPropertyInitializerEvaluator {
        public static final DoNothing INSTANCE = null;

        static {
            INSTANCE = new DoNothing();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator
        public ConstantValue<?> getInitializerConstant(JavaField r1, PropertyDescriptor r2) {
            Intrinsics.checkNotNullParameter(r1, "field");
            Intrinsics.checkNotNullParameter(r2, "descriptor");
            return null;
        }

        private DoNothing() {
        }
    }

    ConstantValue<?> getInitializerConstant(JavaField r1, PropertyDescriptor r2);
}
