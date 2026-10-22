package Fa;

/* loaded from: classes5.dex */
public interface f {

    public static final class a {
        public static String a(f fVar, kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
            kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
            if (fVar.b(functionDescriptor)) {
                return null;
            }
            return fVar.getDescription();
        }
    }

    String a(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    boolean b(kotlin.reflect.jvm.internal.impl.descriptors.e eVar);

    String getDescription();
}
