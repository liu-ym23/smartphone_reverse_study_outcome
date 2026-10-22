package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class r0 implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public static r0 f3981a;

    @Override // androidx.lifecycle.q0
    public n0 a(Class modelClass) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        try {
            Object objNewInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n                modelC…wInstance()\n            }");
            return (n0) objNewInstance;
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e6);
        }
    }
}
