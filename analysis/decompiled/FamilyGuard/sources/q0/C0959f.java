package q0;

import java.lang.reflect.Type;
import org.libpag.BuildConfig;

/* renamed from: q0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0959f implements U {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f19814a;

    /* renamed from: b, reason: collision with root package name */
    private final U f19815b;

    public C0959f(Class<?> cls, U u5) {
        this.f19814a = cls;
        this.f19815b = u5;
    }

    @Override // q0.U
    public final void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws Throwable {
        C0946I c0946i2;
        Throwable th;
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        Z z5 = c0946i.f19683r;
        int i6 = 0;
        c0946i.D(z5, obj, obj2, 0);
        try {
            e0Var.append('[');
            while (i6 < length) {
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
                Object obj3 = objArr[i6];
                if (obj3 == null) {
                    if (e0Var.v(f0.WriteNullStringAsEmpty) && (obj instanceof String[])) {
                        e0Var.h0(BuildConfig.FLAVOR);
                    } else {
                        e0Var.append("null");
                    }
                    c0946i2 = c0946i;
                } else if (obj3.getClass() == this.f19814a) {
                    c0946i2 = c0946i;
                    try {
                        this.f19815b.b(c0946i2, obj3, Integer.valueOf(i6), null, 0);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        c0946i2.f19683r = z5;
                        throw th;
                    }
                } else {
                    c0946i2 = c0946i;
                    c0946i2.x(obj3.getClass()).b(c0946i2, obj3, Integer.valueOf(i6), null, 0);
                }
                i6++;
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
