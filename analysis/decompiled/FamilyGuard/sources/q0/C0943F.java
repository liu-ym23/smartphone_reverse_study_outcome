package q0;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/* renamed from: q0.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0943F implements U {

    /* renamed from: a, reason: collision with root package name */
    public static final C0943F f19673a = new C0943F();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws Throwable {
        e0 e0Var = c0946i.f19676k;
        C0953P c0953p = C0953P.f19714j;
        try {
            Field declaredField = obj.getClass().getDeclaredField("map");
            if (Modifier.isPrivate(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            c0953p.b(c0946i, declaredField.get(obj), obj2, type, i5);
        } catch (Exception unused) {
            e0Var.Y();
        }
    }
}
