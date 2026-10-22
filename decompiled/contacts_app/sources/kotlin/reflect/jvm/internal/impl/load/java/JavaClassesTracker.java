package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;

/* JADX INFO: compiled from: JavaClassesTracker.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface JavaClassesTracker {

    /* JADX INFO: compiled from: JavaClassesTracker.kt */
    public static final class Default implements JavaClassesTracker {
        public static final Default INSTANCE = null;

        static {
            INSTANCE = new Default();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public void reportClass(JavaClassDescriptor r1) {
            Intrinsics.checkNotNullParameter(r1, "classDescriptor");
        }

        private Default() {
        }
    }

    void reportClass(JavaClassDescriptor r1);
}
