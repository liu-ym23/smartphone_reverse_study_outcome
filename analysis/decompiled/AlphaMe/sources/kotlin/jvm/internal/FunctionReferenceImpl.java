package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes2.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i4, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i4, CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i4, Class cls, String str, String str2, int i5) {
        super(i4, CallableReference.NO_RECEIVER, cls, str, str2, i5);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i4, Object obj, Class cls, String str, String str2, int i5) {
        super(i4, obj, cls, str, str2, i5);
    }
}
