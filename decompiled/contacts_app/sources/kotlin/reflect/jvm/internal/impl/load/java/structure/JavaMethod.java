package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;

/* JADX INFO: compiled from: javaElements.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface JavaMethod extends JavaMember, JavaTypeParameterListOwner {

    /* JADX INFO: compiled from: javaElements.kt */
    public static final class DefaultImpls {
        public static boolean getHasAnnotationParameterDefaultValue(JavaMethod r0) {
            if (r0.getAnnotationParameterDefaultValue() == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    JavaAnnotationArgument getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    JavaType getReturnType();

    List<JavaValueParameter> getValueParameters();
}
