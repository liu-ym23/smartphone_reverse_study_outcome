package q0;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import l0.C0823b;
import o0.C0888a;
import o0.InterfaceC0890c;

/* loaded from: classes.dex */
public class T implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final T f19720a = new T();

    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <T> T f(o0.C0888a r12, java.lang.Class<?> r13, l0.C0823b r14) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException {
        /*
            r11 = this;
            r0 = 0
            if (r14 != 0) goto L4
            return r0
        L4:
            int r1 = r14.size()
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r13, r1)
            r3 = 0
            r4 = r3
        Le:
            if (r4 >= r1) goto L65
            java.lang.Object r5 = r14.get(r4)
            if (r5 != r14) goto L1a
            java.lang.reflect.Array.set(r2, r4, r2)
            goto L62
        L1a:
            boolean r6 = r13.isArray()
            if (r6 == 0) goto L31
            boolean r6 = r13.isInstance(r5)
            if (r6 == 0) goto L27
            goto L2d
        L27:
            l0.b r5 = (l0.C0823b) r5
            java.lang.Object r5 = r11.f(r12, r13, r5)
        L2d:
            java.lang.reflect.Array.set(r2, r4, r5)
            goto L62
        L31:
            boolean r6 = r5 instanceof l0.C0823b
            if (r6 == 0) goto L54
            r6 = r5
            l0.b r6 = (l0.C0823b) r6
            int r7 = r6.size()
            r8 = r3
            r9 = r8
        L3e:
            if (r8 >= r7) goto L4d
            java.lang.Object r10 = r6.get(r8)
            if (r10 != r14) goto L4a
            r6.set(r4, r2)
            r9 = 1
        L4a:
            int r8 = r8 + 1
            goto L3e
        L4d:
            if (r9 == 0) goto L54
            java.lang.Object[] r6 = r6.toArray()
            goto L55
        L54:
            r6 = r0
        L55:
            if (r6 != 0) goto L5f
            o0.i r6 = r12.u()
            java.lang.Object r6 = u0.o.f(r5, r13, r6)
        L5f:
            java.lang.reflect.Array.set(r2, r4, r6)
        L62:
            int r4 = r4 + 1
            goto Le
        L65:
            r14.Q(r2)
            r14.P(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.T.f(o0.a, java.lang.Class, l0.b):java.lang.Object");
    }

    @Override // q0.U
    public final void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        e0 e0Var = c0946i.f19676k;
        Object[] objArr = (Object[]) obj;
        if (obj == null) {
            e0Var.d0(f0.WriteNullListAsEmpty);
            return;
        }
        int length = objArr.length;
        int i6 = length - 1;
        if (i6 == -1) {
            e0Var.append("[]");
            return;
        }
        Z z5 = c0946i.f19683r;
        c0946i.D(z5, obj, obj2, 0);
        try {
            e0Var.append('[');
            if (e0Var.v(f0.PrettyFormat)) {
                c0946i.z();
                c0946i.C();
                for (int i7 = 0; i7 < length; i7++) {
                    if (i7 != 0) {
                        e0Var.write(44);
                        c0946i.C();
                    }
                    c0946i.K(objArr[i7], Integer.valueOf(i7));
                }
                c0946i.s();
                c0946i.C();
                e0Var.write(93);
                c0946i.f19683r = z5;
                return;
            }
            Class<?> cls = null;
            U uX = null;
            for (int i8 = 0; i8 < i6; i8++) {
                Object obj3 = objArr[i8];
                if (obj3 == null) {
                    e0Var.append("null,");
                } else {
                    if (c0946i.r(obj3)) {
                        c0946i.J(obj3);
                    } else {
                        Class<?> cls2 = obj3.getClass();
                        if (cls2 == cls) {
                            uX.b(c0946i, obj3, Integer.valueOf(i8), null, 0);
                        } else {
                            uX = c0946i.x(cls2);
                            uX.b(c0946i, obj3, Integer.valueOf(i8), null, 0);
                            cls = cls2;
                        }
                    }
                    e0Var.append(',');
                }
            }
            Object obj4 = objArr[i6];
            if (obj4 == null) {
                e0Var.append("null]");
            } else {
                if (c0946i.r(obj4)) {
                    c0946i.J(obj4);
                } else {
                    c0946i.K(obj4, Integer.valueOf(i6));
                }
                e0Var.append(']');
            }
            c0946i.f19683r = z5;
        } catch (Throwable th) {
            c0946i.f19683r = z5;
            throw th;
        }
    }

    @Override // p0.t
    public int d() {
        return 14;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, byte[]] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Class<?> clsP;
        Type type2;
        InterfaceC0890c interfaceC0890c = c0888a.f18948f;
        int iU = interfaceC0890c.U();
        Type type3 = null;
        if (iU == 8) {
            interfaceC0890c.A(16);
            return null;
        }
        if (iU == 4 || iU == 26) {
            ?? r7 = (T) interfaceC0890c.G();
            interfaceC0890c.A(16);
            if (r7.length != 0 || type == byte[].class) {
                return r7;
            }
            return null;
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) genericComponentType;
                Type type4 = c0888a.v().f19021e;
                if (type4 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type4;
                    Type rawType = parameterizedType.getRawType();
                    if (rawType instanceof Class) {
                        TypeVariable<Class<T>>[] typeParameters = ((Class) rawType).getTypeParameters();
                        for (int i5 = 0; i5 < typeParameters.length; i5++) {
                            if (typeParameters[i5].getName().equals(typeVariable.getName())) {
                                type3 = parameterizedType.getActualTypeArguments()[i5];
                            }
                        }
                    }
                    if (type3 instanceof Class) {
                        clsP = (Class) type3;
                        type2 = genericComponentType;
                    } else {
                        clsP = Object.class;
                        type2 = genericComponentType;
                    }
                } else {
                    clsP = u0.o.P(typeVariable.getBounds()[0]);
                    type2 = genericComponentType;
                }
            } else {
                clsP = u0.o.P(genericComponentType);
                type2 = genericComponentType;
            }
        } else {
            Class<?> componentType = ((Class) type).getComponentType();
            clsP = componentType;
            type2 = componentType;
        }
        C0823b c0823b = new C0823b();
        c0888a.X(type2, c0823b, obj);
        return (T) f(c0888a, clsP, c0823b);
    }
}
