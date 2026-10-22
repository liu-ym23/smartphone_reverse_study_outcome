package b8;

import h8.InterfaceC1501I;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.CallableReference;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature;

/* loaded from: classes4.dex */
public abstract class i0 extends AbstractC0857s implements Z7.t {
    public static final Object m = new Object();
    public final AbstractC0830C g;
    public final String h;
    public final String i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f2043j;
    public final Object k;
    public final p0 l;

    public i0(AbstractC0830C abstractC0830C, String str, String str2, InterfaceC1501I interfaceC1501I, Object obj) {
        this.g = abstractC0830C;
        this.h = str;
        this.i = str2;
        this.f2043j = obj;
        this.k = kotlin.a.b(LazyThreadSafetyMode.b, new c0(this, 0));
        this.l = N9.j.E(interfaceC1501I, new c0(this, 1));
    }

    @Override // b8.AbstractC0857s
    public final c8.e d() {
        return r().d();
    }

    @Override // b8.AbstractC0857s
    public final AbstractC0830C e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        i0 i0VarC = v0.c(obj);
        return i0VarC != null && kotlin.jvm.internal.k.b(this.g, i0VarC.g) && kotlin.jvm.internal.k.b(this.h, i0VarC.h) && kotlin.jvm.internal.k.b(this.i, i0VarC.i) && kotlin.jvm.internal.k.b(this.f2043j, i0VarC.f2043j);
    }

    @Override // b8.AbstractC0857s
    public final c8.e f() {
        r().getClass();
        return null;
    }

    @Override // Z7.c
    public final String getName() {
        return this.h;
    }

    public final int hashCode() {
        return this.i.hashCode() + B7.a.c(this.g.hashCode() * 31, 31, this.h);
    }

    @Override // Z7.t
    public final boolean isConst() {
        return g().isConst();
    }

    @Override // Z7.t
    public final boolean isLateinit() {
        return g().q0();
    }

    @Override // Z7.c
    public final boolean isSuspend() {
        return false;
    }

    @Override // b8.AbstractC0857s
    public final boolean n() {
        return this.f2043j != CallableReference.NO_RECEIVER;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [C7.f, java.lang.Object] */
    public final Member o() {
        if (!g().s()) {
            return null;
        }
        G8.b bVar = t0.f2056a;
        M0.i iVarB = t0.b(g());
        if (iVarB instanceof C0853n) {
            C0853n c0853n = (C0853n) iVarB;
            D8.f fVar = c0853n.n;
            JvmProtoBuf$JvmPropertySignature jvmProtoBuf$JvmPropertySignature = c0853n.m;
            if ((jvmProtoBuf$JvmPropertySignature.b & 16) == 16) {
                JvmProtoBuf$JvmMethodSignature jvmProtoBuf$JvmMethodSignature = jvmProtoBuf$JvmPropertySignature.g;
                int i = jvmProtoBuf$JvmMethodSignature.b;
                if ((i & 1) != 1 || (i & 2) != 2) {
                    return null;
                }
                return this.g.f(fVar.getString(jvmProtoBuf$JvmMethodSignature.c), fVar.getString(jvmProtoBuf$JvmMethodSignature.d));
            }
        }
        return (Field) this.k.getF4884a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object p(Member member, Object obj) throws IllegalPropertyDelegateAccessException, SecurityException {
        try {
            Object obj2 = m;
            if (obj == obj2 && g().I() == null) {
                throw new RuntimeException("'" + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            Object objU = n() ? H4.o.u(this.f2043j, g()) : obj;
            if (objU == obj2) {
                objU = null;
            }
            if (!n()) {
                obj = null;
            }
            if (obj == obj2) {
                obj = null;
            }
            AccessibleObject accessibleObject = member instanceof AccessibleObject ? (AccessibleObject) member : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(com.stepos.ability.task.executor.e.G(this));
            }
            if (member == 0) {
                return null;
            }
            if (member instanceof Field) {
                return ((Field) member).get(objU);
            }
            if (!(member instanceof Method)) {
                throw new AssertionError("delegate field/method " + member + " neither field nor method");
            }
            int length = ((Method) member).getParameterTypes().length;
            if (length == 0) {
                return ((Method) member).invoke(null, null);
            }
            if (length == 1) {
                Method method = (Method) member;
                if (objU == null) {
                    Class<?> cls = ((Method) member).getParameterTypes()[0];
                    kotlin.jvm.internal.k.e(cls, "get(...)");
                    objU = v0.e(cls);
                }
                return method.invoke(null, objU);
            }
            if (length != 2) {
                throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
            }
            Method method2 = (Method) member;
            if (obj == null) {
                Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                kotlin.jvm.internal.k.e(cls2, "get(...)");
                obj = v0.e(cls2);
            }
            return method2.invoke(null, objU, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalPropertyDelegateAccessException("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", e);
        }
    }

    @Override // b8.AbstractC0857s
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public final InterfaceC1501I g() {
        Object objInvoke = this.l.invoke();
        kotlin.jvm.internal.k.e(objInvoke, "invoke(...)");
        return (InterfaceC1501I) objInvoke;
    }

    public abstract f0 r();

    public final String toString() {
        I8.g gVar = s0.f2054a;
        return s0.c(g());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i0(AbstractC0830C container, String name, String signature, Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.k.f(container, "container");
        kotlin.jvm.internal.k.f(name, "name");
        kotlin.jvm.internal.k.f(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i0(AbstractC0830C abstractC0830C, InterfaceC1501I descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        String strB = descriptor.getName().b();
        kotlin.jvm.internal.k.e(strB, "asString(...)");
        this(abstractC0830C, strB, t0.b(descriptor).l(), descriptor, CallableReference.NO_RECEIVER);
    }
}
