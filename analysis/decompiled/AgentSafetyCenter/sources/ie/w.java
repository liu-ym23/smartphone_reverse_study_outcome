package ie;

import java.lang.annotation.Annotation;
import java.lang.invoke.VarHandle;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class w extends k {

    /* renamed from: a, reason: collision with root package name */
    public static final w f6095a = new w();

    @Override // ie.k
    public final l b(Type type, Annotation[] annotationArr, q0 q0Var) {
        if (w0.h(type) != Optional.class) {
            return null;
        }
        l lVarC = q0Var.c(w0.g(0, (ParameterizedType) type), annotationArr);
        a2.i iVar = new a2.i(13);
        iVar.f49f = lVarC;
        VarHandle.storeStoreFence();
        return iVar;
    }
}
