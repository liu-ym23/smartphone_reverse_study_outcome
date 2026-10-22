package kotlin.reflect;

import Ka.j;
import Ka.t;
import La.D;
import Z8.C1174w;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import kotlin.sequences.SequencesKt___SequencesKt;
import o9.C5013a;
import w9.C5742a;
import w9.C5757p;
import w9.C5758q;
import w9.InterfaceC5745d;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0015\u001a\u00020\u0003*\u00020\t8BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lw9/n;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "c", "(Lw9/n;Z)Ljava/lang/reflect/Type;", "Ljava/lang/Class;", "jClass", "", "Lw9/p;", "arguments", "e", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;", "type", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "f", "(Lw9/n;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lw9/n;)V", "javaType", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw9/p;)Ljava/lang/reflect/Type;", "(Lw9/p;)V", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34855a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34855a = iArr;
        }
    }

    public static final Type c(InterfaceC5755n interfaceC5755n, boolean z10) {
        InterfaceC5746e interfaceC5746eC = interfaceC5755n.c();
        if (interfaceC5746eC instanceof InterfaceC5756o) {
            return new C5758q((InterfaceC5756o) interfaceC5746eC);
        }
        if (!(interfaceC5746eC instanceof InterfaceC5745d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + interfaceC5755n);
        }
        InterfaceC5745d interfaceC5745d = (InterfaceC5745d) interfaceC5746eC;
        Class clsC = z10 ? C5013a.c(interfaceC5745d) : C5013a.b(interfaceC5745d);
        List<C5757p> listG = interfaceC5755n.g();
        if (listG.isEmpty()) {
            return clsC;
        }
        if (!clsC.isArray()) {
            return e(clsC, listG);
        }
        if (clsC.getComponentType().isPrimitive()) {
            return clsC;
        }
        C5757p c5757p = (C5757p) F.Z0(listG);
        if (c5757p == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + interfaceC5755n);
        }
        KVariance variance = c5757p.getVariance();
        InterfaceC5755n type = c5757p.getType();
        int i10 = variance == null ? -1 : a.f34855a[variance.ordinal()];
        if (i10 == -1 || i10 == 1) {
            return clsC;
        }
        if (i10 != 2 && i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        p.f(type);
        Type typeD = d(type, false, 1, null);
        return typeD instanceof Class ? clsC : new C5742a(typeD);
    }

    public static /* synthetic */ Type d(InterfaceC5755n interfaceC5755n, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return c(interfaceC5755n, z10);
    }

    public static final Type e(Class<?> cls, List<C5757p> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<C5757p> list2 = list;
            ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(g((C5757p) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            List<C5757p> list3 = list;
            ArrayList arrayList2 = new ArrayList(C1174w.x(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((C5757p) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List<C5757p> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(C1174w.x(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((C5757p) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, typeE, arrayList3);
    }

    public static final Type f(InterfaceC5755n interfaceC5755n) {
        Type typeI;
        p.i(interfaceC5755n, "<this>");
        return (!(interfaceC5755n instanceof q) || (typeI = ((q) interfaceC5755n).i()) == null) ? d(interfaceC5755n, false, 1, null) : typeI;
    }

    public static final Type g(C5757p c5757p) {
        KVariance kVarianceD = c5757p.d();
        if (kVarianceD == null) {
            return kotlin.reflect.a.f34857c.a();
        }
        InterfaceC5755n interfaceC5755nC = c5757p.c();
        p.f(interfaceC5755nC);
        int i10 = a.f34855a[kVarianceD.ordinal()];
        if (i10 == 1) {
            return new kotlin.reflect.a(null, c(interfaceC5755nC, true));
        }
        if (i10 == 2) {
            return c(interfaceC5755nC, true);
        }
        if (i10 == 3) {
            return new kotlin.reflect.a(c(interfaceC5755nC, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String h(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            p.h(name, "getName(...)");
            return name;
        }
        j jVarQ = t.q(type, TypesJVMKt$typeToString$unwrap$1.f34856a);
        return ((Class) SequencesKt___SequencesKt.P(jVarQ)).getName() + D.P("[]", SequencesKt___SequencesKt.A(jVarQ));
    }
}
