package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface DescriptorRendererOptions {

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class DefaultImpls {
        public static boolean getIncludeAnnotationArguments(DescriptorRendererOptions r0) {
            return r0.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRendererOptions r0) {
            return r0.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<FqName> getExcludedTypeAnnotationClasses();

    void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy r1);

    void setClassifierNamePolicy(ClassifierNamePolicy r1);

    void setDebugMode(boolean r1);

    void setExcludedTypeAnnotationClasses(Set<FqName> r1);

    void setModifiers(Set<? extends DescriptorRendererModifier> r1);

    void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy r1);

    void setReceiverAfterName(boolean r1);

    void setRenderCompanionObjectName(boolean r1);

    void setStartFromName(boolean r1);

    void setTextFormat(RenderingFormat r1);

    void setVerbose(boolean r1);

    void setWithDefinedIn(boolean r1);

    void setWithoutSuperTypes(boolean r1);

    void setWithoutTypeParameters(boolean r1);
}
