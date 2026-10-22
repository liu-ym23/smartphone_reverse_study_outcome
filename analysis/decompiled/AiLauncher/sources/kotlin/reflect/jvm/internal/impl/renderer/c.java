package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;

/* loaded from: classes5.dex */
public interface c {

    public static final class a {
        public static boolean a(c cVar) {
            return cVar.j().getIncludeAnnotationArguments();
        }

        public static boolean b(c cVar) {
            return cVar.j().getIncludeEmptyAnnotationArguments();
        }
    }

    void a(boolean z10);

    void b(ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void c(boolean z10);

    boolean d();

    void e(boolean z10);

    void f(boolean z10);

    void g(RenderingFormat renderingFormat);

    Set<ga.c> h();

    boolean i();

    AnnotationArgumentsRenderingPolicy j();

    void k(Set<ga.c> set);

    void l(Set<? extends DescriptorRendererModifier> set);

    void m(kotlin.reflect.jvm.internal.impl.renderer.a aVar);

    void n(boolean z10);

    void o(boolean z10);

    void p(boolean z10);
}
