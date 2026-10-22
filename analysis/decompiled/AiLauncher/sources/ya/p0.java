package ya;

import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes5.dex */
public interface p0 {

    public static final class a implements p0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f44120a = new a();

        @Override // ya.p0
        public void a(TypeSubstitutor substitutor, S unsubstitutedArgument, S argument, E9.b0 typeParameter) {
            kotlin.jvm.internal.p.i(substitutor, "substitutor");
            kotlin.jvm.internal.p.i(unsubstitutedArgument, "unsubstitutedArgument");
            kotlin.jvm.internal.p.i(argument, "argument");
            kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
        }

        @Override // ya.p0
        public void b(E9.a0 typeAlias) {
            kotlin.jvm.internal.p.i(typeAlias, "typeAlias");
        }

        @Override // ya.p0
        public void c(F9.c annotation) {
            kotlin.jvm.internal.p.i(annotation, "annotation");
        }

        @Override // ya.p0
        public void d(E9.a0 typeAlias, E9.b0 b0Var, S substitutedArgument) {
            kotlin.jvm.internal.p.i(typeAlias, "typeAlias");
            kotlin.jvm.internal.p.i(substitutedArgument, "substitutedArgument");
        }
    }

    void a(TypeSubstitutor typeSubstitutor, S s10, S s11, E9.b0 b0Var);

    void b(E9.a0 a0Var);

    void c(F9.c cVar);

    void d(E9.a0 a0Var, E9.b0 b0Var, S s10);
}
