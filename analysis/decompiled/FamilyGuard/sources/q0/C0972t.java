package q0;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import l0.C0823b;
import o0.C0888a;

/* renamed from: q0.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0972t implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final C0972t f19875a = new C0972t();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws Throwable {
        C0946I c0946i2;
        Throwable th;
        int i6;
        e0 e0Var = c0946i.f19676k;
        if (obj == null) {
            e0Var.d0(f0.WriteNullListAsEmpty);
            return;
        }
        f0 f0Var = f0.WriteClassName;
        Type typeU = (e0Var.v(f0Var) || f0.e(i5, f0Var)) ? u0.o.U(type) : null;
        Collection collection = (Collection) obj;
        Z z5 = c0946i.f19683r;
        int i7 = 0;
        c0946i.D(z5, obj, obj2, 0);
        if (e0Var.v(f0Var)) {
            if (HashSet.class.isAssignableFrom(collection.getClass())) {
                e0Var.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                e0Var.append("TreeSet");
            }
        }
        try {
            e0Var.append('[');
            for (Object obj3 : collection) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    try {
                        e0Var.append(',');
                    } catch (Throwable th2) {
                        th = th2;
                        c0946i2 = c0946i;
                        c0946i2.f19683r = z5;
                        throw th;
                    }
                }
                if (obj3 == null) {
                    e0Var.Y();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        e0Var.V(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        e0Var.X(((Long) obj3).longValue());
                        if (e0Var.v(f0.WriteClassName)) {
                            e0Var.write(76);
                        }
                    } else {
                        U uX = c0946i.x(cls);
                        if (f0.e(i5, f0.WriteClassName) && (uX instanceof C0947J)) {
                            c0946i2 = c0946i;
                            i6 = i5;
                            try {
                                ((C0947J) uX).E(c0946i2, obj3, Integer.valueOf(i7), typeU, i6);
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                c0946i2.f19683r = z5;
                                throw th;
                            }
                        } else {
                            c0946i2 = c0946i;
                            i6 = i5;
                            uX.b(c0946i2, obj3, Integer.valueOf(i7), typeU, i6);
                        }
                        i7 = i8;
                        c0946i = c0946i2;
                        i5 = i6;
                    }
                }
                c0946i2 = c0946i;
                i6 = i5;
                i7 = i8;
                c0946i = c0946i2;
                i5 = i6;
            }
            c0946i2 = c0946i;
            e0Var.append(']');
            c0946i2.f19683r = z5;
        } catch (Throwable th4) {
            th = th4;
            c0946i2 = c0946i;
        }
    }

    @Override // p0.t
    public int d() {
        return 14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [T, java.util.Collection, l0.b] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Collection collection;
        if (c0888a.f18948f.U() == 8) {
            c0888a.f18948f.A(16);
            return null;
        }
        if (type == C0823b.class) {
            ?? r12 = (T) new C0823b();
            c0888a.Y(r12);
            return r12;
        }
        if (c0888a.f18948f.U() == 21) {
            c0888a.f18948f.nextToken();
            collection = (T) u0.o.G(type);
        } else {
            collection = (T) u0.o.F(type);
        }
        c0888a.X(u0.o.U(type), collection, obj);
        return (T) collection;
    }
}
