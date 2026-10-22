package A9;

import E9.C0820z;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.O;
import E9.i0;
import E9.j0;
import Z8.A;
import Z8.C1172u;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import fa.C4065b;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ka.C4829i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import o9.C5013a;
import p9.InterfaceC5074l;
import ya.AbstractC5990d0;
import ya.F0;
import ya.H0;
import ya.S;
import z9.c1;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\u0014\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010\u001e\u001a\u00020\u0011*\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a=\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\n\b\u0000\u0010 *\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0013\u0010#\u001a\u00020\u0011*\u00020\u0006H\u0002¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010&\u001a\u00020\t*\u0006\u0012\u0002\b\u00030%2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b&\u0010'\u001a\u001f\u0010(\u001a\u00020\t*\u0006\u0012\u0002\b\u00030%2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010'\u001a\u0019\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010%*\u00020\u001bH\u0002¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010%*\u0004\u0018\u00010+H\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010/\u001a\u0004\u0018\u00010.*\u0004\u0018\u00010.2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b/\u00100\"\u001a\u00103\u001a\u0004\u0018\u00010\u001b*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"LE9/d;", "", "u", "(LE9/d;)Ljava/lang/String;", "Lya/d0;", "type", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "descriptor", "", "Ljava/lang/reflect/Method;", "p", "(Lya/d0;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/util/List;", "n", "(Lya/d0;)Ljava/util/List;", "LA9/g;", "", "expectedArgsSize", "", "isDefault", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LA9/g;ILkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;Z)V", "Ljava/lang/reflect/Member;", "member", "Lkotlin/Function1;", "LE9/b;", "isSpecificClass", "Lya/S;", "r", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;Ljava/lang/reflect/Member;Lp9/l;)Ljava/util/List;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/reflect/Member;)Z", "M", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LA9/g;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;Z)LA9/g;", "q", "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Z", "Ljava/lang/Class;", "m", "(Ljava/lang/Class;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/lang/reflect/Method;", "k", "t", "(Lya/S;)Ljava/lang/Class;", "LE9/h;", "s", "(LE9/h;)Ljava/lang/Class;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/lang/Object;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "expectedReceiverType", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n {
    public static final boolean a(Member member) {
        if (member.getDeclaringClass() == null) {
            return false;
        }
        return !C5013a.e(r0).q();
    }

    public static final void g(g<?> gVar, int i10, CallableMemberDescriptor callableMemberDescriptor, boolean z10) {
        if (i.a(gVar) == i10) {
            return;
        }
        throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + i.a(gVar) + " != " + i10 + "\nCalling: " + callableMemberDescriptor + "\nParameter types: " + gVar.a() + ")\nDefault: " + z10);
    }

    public static final Object h(Object obj, CallableMemberDescriptor descriptor) {
        S sL;
        Class<?> clsT;
        Method methodM;
        p.i(descriptor, "descriptor");
        return (((descriptor instanceof O) && C4829i.e((j0) descriptor)) || (sL = l(descriptor)) == null || (clsT = t(sL)) == null || (methodM = m(clsT, descriptor)) == null) ? obj : methodM.invoke(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <M extends java.lang.reflect.Member> A9.g<M> i(A9.g<? extends M> r3, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4, boolean r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r3, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.p.i(r4, r0)
            boolean r0 = ka.C4829i.a(r4)
            if (r0 != 0) goto L96
            java.util.List r0 = r4.s0()
            java.lang.String r1 = "getContextReceiverParameters(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            java.lang.String r2 = "getType(...)"
            if (r1 == 0) goto L2b
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L2b
            goto L49
        L2b:
            java.util.Iterator r0 = r0.iterator()
        L2f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L49
            java.lang.Object r1 = r0.next()
            E9.S r1 = (E9.S) r1
            ya.S r1 = r1.getType()
            kotlin.jvm.internal.p.h(r1, r2)
            boolean r1 = ka.C4829i.h(r1)
            if (r1 == 0) goto L2f
            goto L96
        L49:
            java.util.List r0 = r4.i()
            java.lang.String r1 = "getValueParameters(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L62
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L62
            goto L80
        L62:
            java.util.Iterator r0 = r0.iterator()
        L66:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L80
            java.lang.Object r1 = r0.next()
            E9.i0 r1 = (E9.i0) r1
            ya.S r1 = r1.getType()
            kotlin.jvm.internal.p.h(r1, r2)
            boolean r1 = ka.C4829i.h(r1)
            if (r1 == 0) goto L66
            goto L96
        L80:
            ya.S r0 = r4.getReturnType()
            if (r0 == 0) goto L8e
            boolean r0 = ka.C4829i.c(r0)
            r1 = 1
            if (r0 != r1) goto L8e
            goto L96
        L8e:
            boolean r0 = q(r4)
            if (r0 == 0) goto L95
            goto L96
        L95:
            return r3
        L96:
            A9.m r0 = new A9.m
            r0.<init>(r4, r3, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: A9.n.i(A9.g, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, boolean):A9.g");
    }

    public static /* synthetic */ g j(g gVar, CallableMemberDescriptor callableMemberDescriptor, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return i(gVar, callableMemberDescriptor, z10);
    }

    public static final Method k(Class<?> cls, CallableMemberDescriptor callableMemberDescriptor) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod("box-impl", m(cls, callableMemberDescriptor).getReturnType());
            p.f(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    public static final S l(CallableMemberDescriptor callableMemberDescriptor) {
        E9.S sK = callableMemberDescriptor.K();
        E9.S sH = callableMemberDescriptor.H();
        if (sK != null) {
            return sK.getType();
        }
        if (sH == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
            return sH.getType();
        }
        InterfaceC0803h interfaceC0803hB = callableMemberDescriptor.b();
        InterfaceC0797b interfaceC0797b = interfaceC0803hB instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0803hB : null;
        if (interfaceC0797b != null) {
            return interfaceC0797b.n();
        }
        return null;
    }

    public static final Method m(Class<?> cls, CallableMemberDescriptor descriptor) throws NoSuchMethodException, SecurityException {
        p.i(cls, "<this>");
        p.i(descriptor, "descriptor");
        try {
            Method declaredMethod = cls.getDeclaredMethod("unbox-impl", null);
            p.f(declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + descriptor + ')');
        }
    }

    public static final List<Method> n(AbstractC5990d0 type) {
        p.i(type, "type");
        List<String> listO = o(F0.a(type));
        if (listO == null) {
            return null;
        }
        List<String> list = listO;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add("unbox-impl-" + ((String) it.next()));
        }
        InterfaceC0799d interfaceC0799dD = type.H0().d();
        p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Class<?> clsR = c1.r((InterfaceC0797b) interfaceC0799dD);
        p.f(clsR);
        ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(clsR.getDeclaredMethod((String) it2.next(), null));
        }
        return arrayList2;
    }

    public static final List<String> o(AbstractC5990d0 abstractC5990d0) {
        Collection collectionE;
        if (!C4829i.i(abstractC5990d0)) {
            return null;
        }
        InterfaceC0799d interfaceC0799dD = abstractC5990d0.H0().d();
        p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        C0820z<AbstractC5990d0> c0820zT = DescriptorUtilsKt.t((InterfaceC0797b) interfaceC0799dD);
        p.f(c0820zT);
        Iterable<Pair> iterableC = c0820zT.c();
        ArrayList arrayList = new ArrayList();
        for (Pair pair : iterableC) {
            ga.e eVar = (ga.e) pair.a();
            List<String> listO = o((AbstractC5990d0) pair.b());
            if (listO != null) {
                List<String> list = listO;
                collectionE = new ArrayList(C1174w.x(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    collectionE.add(eVar.e() + '-' + ((String) it.next()));
                }
            } else {
                collectionE = C1172u.e(eVar.e());
            }
            A.E(arrayList, collectionE);
        }
        return arrayList;
    }

    public static final List<Method> p(AbstractC5990d0 abstractC5990d0, CallableMemberDescriptor callableMemberDescriptor) {
        Method methodM;
        List<Method> listN = n(abstractC5990d0);
        if (listN != null) {
            return listN;
        }
        Class<?> clsT = t(abstractC5990d0);
        if (clsT == null || (methodM = m(clsT, callableMemberDescriptor)) == null) {
            return null;
        }
        return C1172u.e(methodM);
    }

    public static final boolean q(CallableMemberDescriptor callableMemberDescriptor) {
        S sL = l(callableMemberDescriptor);
        return sL != null && C4829i.h(sL);
    }

    public static final List<S> r(CallableMemberDescriptor callableMemberDescriptor, Member member, InterfaceC5074l<? super InterfaceC0797b, Boolean> interfaceC5074l) {
        ArrayList arrayList = new ArrayList();
        E9.S sK = callableMemberDescriptor.K();
        S type = sK != null ? sK.getType() : null;
        if (type != null) {
            arrayList.add(type);
        } else if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
            InterfaceC0797b interfaceC0797bY = ((kotlin.reflect.jvm.internal.impl.descriptors.c) callableMemberDescriptor).Y();
            p.h(interfaceC0797bY, "getConstructedClass(...)");
            if (interfaceC0797bY.x()) {
                InterfaceC0803h interfaceC0803hB = interfaceC0797bY.b();
                p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                arrayList.add(((InterfaceC0797b) interfaceC0803hB).n());
            }
        } else {
            InterfaceC0803h interfaceC0803hB2 = callableMemberDescriptor.b();
            p.h(interfaceC0803hB2, "getContainingDeclaration(...)");
            if ((interfaceC0803hB2 instanceof InterfaceC0797b) && interfaceC5074l.invoke(interfaceC0803hB2).booleanValue()) {
                if (member == null || !a(member)) {
                    arrayList.add(((InterfaceC0797b) interfaceC0803hB2).n());
                } else {
                    AbstractC5990d0 abstractC5990d0N = ((InterfaceC0797b) interfaceC0803hB2).n();
                    p.h(abstractC5990d0N, "getDefaultType(...)");
                    arrayList.add(Da.d.B(abstractC5990d0N));
                }
            }
        }
        List<i0> listI = callableMemberDescriptor.i();
        p.h(listI, "getValueParameters(...)");
        Iterator<T> it = listI.iterator();
        while (it.hasNext()) {
            arrayList.add(((i0) it.next()).getType());
        }
        return arrayList;
    }

    public static final Class<?> s(InterfaceC0803h interfaceC0803h) {
        if (!(interfaceC0803h instanceof InterfaceC0797b) || !C4829i.b(interfaceC0803h)) {
            return null;
        }
        InterfaceC0797b interfaceC0797b = (InterfaceC0797b) interfaceC0803h;
        Class<?> clsR = c1.r(interfaceC0797b);
        if (clsR != null) {
            return clsR;
        }
        throw new KotlinReflectionInternalError("Class object for the class " + interfaceC0797b.getName() + " cannot be found (classId=" + DescriptorUtilsKt.n((InterfaceC0799d) interfaceC0803h) + ')');
    }

    public static final Class<?> t(S s10) {
        S sJ;
        Class<?> clsS = s(s10.H0().d());
        if (clsS == null) {
            return null;
        }
        if (H0.l(s10) && ((sJ = C4829i.j(s10)) == null || H0.l(sJ) || C9.j.t0(sJ))) {
            return null;
        }
        return clsS;
    }

    public static final String u(InterfaceC0799d interfaceC0799d) {
        p.i(interfaceC0799d, "<this>");
        ga.b bVarN = DescriptorUtilsKt.n(interfaceC0799d);
        p.f(bVarN);
        return C4065b.b(bVarN.b());
    }
}
