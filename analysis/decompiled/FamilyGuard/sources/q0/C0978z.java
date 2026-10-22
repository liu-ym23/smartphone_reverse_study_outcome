package q0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* renamed from: q0.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0978z implements U {

    /* renamed from: a, reason: collision with root package name */
    public static C0978z f19881a = new C0978z();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws Throwable {
        C0946I c0946i2;
        Throwable th;
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullListAsEmpty);
            return;
        }
        int i6 = 0;
        Type type2 = (e0Var.v(f0.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        Z z5 = c0946i.f19683r;
        c0946i.D(z5, obj, obj2, 0);
        try {
            e0Var.append('[');
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i7 = i6 + 1;
                if (i6 != 0) {
                    try {
                        e0Var.append(',');
                    } catch (Throwable th2) {
                        th = th2;
                        c0946i2 = c0946i;
                        c0946i2.f19683r = z5;
                        throw th;
                    }
                }
                if (objNextElement == null) {
                    e0Var.Y();
                    c0946i2 = c0946i;
                } else {
                    c0946i2 = c0946i;
                    try {
                        c0946i.x(objNextElement.getClass()).b(c0946i2, objNextElement, Integer.valueOf(i6), type2, 0);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        c0946i2.f19683r = z5;
                        throw th;
                    }
                }
                i6 = i7;
                c0946i = c0946i2;
            }
            c0946i2 = c0946i;
            e0Var.append(']');
            c0946i2.f19683r = z5;
        } catch (Throwable th4) {
            th = th4;
            c0946i2 = c0946i;
        }
    }
}
