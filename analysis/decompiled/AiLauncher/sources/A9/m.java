package A9;

import A9.h;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.M;
import K9.C0925f;
import La.H;
import Z8.A;
import Z8.C1172u;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.r;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import f9.C4063a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ka.C4829i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import v9.C5680i;
import ya.F0;
import ya.S;
import z9.c1;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002\u0015\u0017B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001e\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010#R\u0014\u0010&\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0016R\u0014\u0010*\u001a\u00020'8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020'0+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010,R\u0014\u0010/\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010.¨\u00060"}, d2 = {"LA9/m;", "Ljava/lang/reflect/Member;", "M", "LA9/g;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "descriptor", "oldCaller", "", "isDefault", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;LA9/g;Z)V", "", "index", "Lv9/i;", "e", "(I)Lv9/i;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Z", Const.INTENT_KEY_PKGNAME, "LA9/g;", "caller", "c", "Ljava/lang/reflect/Member;", "getMember", "()Ljava/lang/reflect/Member;", "member", "LA9/m$a;", Const.INTENT_KEY_UMID, "LA9/m$a;", "data", "[Lv9/i;", "slices", "f", "hasMfvcParameters", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "", "()Ljava/util/List;", "parameterTypes", "()Z", "isBoundInstanceCallWithValueClasses", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class m<M extends Member> implements g<M> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isDefault;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final g<M> caller;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final M member;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final a data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C5680i[] slices;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final boolean hasMfvcParameters;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR%\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u000e\u0010\u0013¨\u0006\u0014"}, d2 = {"LA9/m$a;", "", "Lv9/i;", "argumentRange", "", "", "Ljava/lang/reflect/Method;", "unboxParameters", "box", "<init>", "(Lv9/i;[Ljava/util/List;Ljava/lang/reflect/Method;)V", Const.INTENT_KEY_APIKEY, "Lv9/i;", "()Lv9/i;", Const.INTENT_KEY_PKGNAME, "[Ljava/util/List;", "c", "()[Ljava/util/List;", "Ljava/lang/reflect/Method;", "()Ljava/lang/reflect/Method;", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C5680i argumentRange;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<Method>[] unboxParameters;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final Method box;

        public a(C5680i argumentRange, List<Method>[] unboxParameters, Method method) {
            p.i(argumentRange, "argumentRange");
            p.i(unboxParameters, "unboxParameters");
            this.argumentRange = argumentRange;
            this.unboxParameters = unboxParameters;
            this.box = method;
        }

        /* renamed from: a, reason: from getter */
        public final C5680i getArgumentRange() {
            return this.argumentRange;
        }

        /* renamed from: b, reason: from getter */
        public final Method getBox() {
            return this.box;
        }

        public final List<Method>[] c() {
            return this.unboxParameters;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\"\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\t0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR'\u0010 \u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\t0\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001fR \u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u0014\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010#R\u0014\u0010'\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"LA9/m$b;", "LA9/g;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/e;", "descriptor", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "constructorDesc", "", "LE9/M;", "originalParameters", "<init>", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/util/List;)V", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", Const.INTENT_KEY_APIKEY, "Ljava/lang/reflect/Method;", "constructorImpl", Const.INTENT_KEY_PKGNAME, "boxMethod", "c", "Ljava/util/List;", "parameterUnboxMethods", "Ljava/lang/Class;", Const.INTENT_KEY_UMID, "e", "()Ljava/util/List;", "originalParametersGroups", "Ljava/lang/reflect/Type;", "parameterTypes", "()Ljava/lang/Void;", "member", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Method constructorImpl;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Method boxMethod;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<List<Method>> parameterUnboxMethods;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final List<List<Class<?>>> originalParametersGroups;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final List<Type> parameterTypes;

        public b(kotlin.reflect.jvm.internal.impl.descriptors.e descriptor, KDeclarationContainerImpl container, String constructorDesc, List<? extends M> originalParameters) throws NoSuchMethodException, SecurityException {
            Collection collectionE;
            p.i(descriptor, "descriptor");
            p.i(container, "container");
            p.i(constructorDesc, "constructorDesc");
            p.i(originalParameters, "originalParameters");
            Method methodC = container.C("constructor-impl", constructorDesc);
            p.f(methodC);
            this.constructorImpl = methodC;
            Method methodC2 = container.C("box-impl", H.T0(constructorDesc, ExifInterface.GPS_MEASUREMENT_INTERRUPTED) + C0925f.f(container.m()));
            p.f(methodC2);
            this.boxMethod = methodC2;
            List<? extends M> list = originalParameters;
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                S type = ((M) it.next()).getType();
                p.h(type, "getType(...)");
                arrayList.add(n.p(F0.a(type), descriptor));
            }
            this.parameterUnboxMethods = arrayList;
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            int i10 = 0;
            for (Object obj : list) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                InterfaceC0799d interfaceC0799dD = ((M) obj).getType().H0().d();
                p.g(interfaceC0799dD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                InterfaceC0797b interfaceC0797b = (InterfaceC0797b) interfaceC0799dD;
                List<Method> list2 = this.parameterUnboxMethods.get(i10);
                if (list2 != null) {
                    List<Method> list3 = list2;
                    collectionE = new ArrayList(C1174w.x(list3, 10));
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        collectionE.add(((Method) it2.next()).getReturnType());
                    }
                } else {
                    Class<?> clsR = c1.r(interfaceC0797b);
                    p.f(clsR);
                    collectionE = C1172u.e(clsR);
                }
                arrayList2.add(collectionE);
                i10 = i11;
            }
            this.originalParametersGroups = arrayList2;
            this.parameterTypes = C1174w.z(arrayList2);
        }

        @Override // A9.g
        public List<Type> a() {
            return this.parameterTypes;
        }

        @Override // A9.g
        public /* bridge */ boolean b() {
            return c();
        }

        public boolean c() {
            return false;
        }

        @Override // A9.g
        public Object call(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Collection collectionE;
            p.i(args, "args");
            List<Pair> listL1 = r.l1(args, this.parameterUnboxMethods);
            ArrayList arrayList = new ArrayList();
            for (Pair pair : listL1) {
                Object objA = pair.a();
                List list = (List) pair.b();
                if (list != null) {
                    List list2 = list;
                    collectionE = new ArrayList(C1174w.x(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        collectionE.add(((Method) it.next()).invoke(objA, null));
                    }
                } else {
                    collectionE = C1172u.e(objA);
                }
                A.E(arrayList, collectionE);
            }
            Object[] array = arrayList.toArray(new Object[0]);
            this.constructorImpl.invoke(null, Arrays.copyOf(array, array.length));
            return this.boxMethod.invoke(null, Arrays.copyOf(array, array.length));
        }

        public Void d() {
            return null;
        }

        public final List<List<Class<?>>> e() {
            return this.originalParametersGroups;
        }

        @Override // A9.g
        public /* bridge */ /* synthetic */ Member getMember() {
            return (Member) d();
        }

        @Override // A9.g
        public Type getReturnType() {
            Class<?> returnType = this.boxMethod.getReturnType();
            p.h(returnType, "getReturnType(...)");
            return returnType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[LOOP:1: B:25:0x007c->B:27:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, A9.g<? extends M> r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A9.m.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, A9.g, boolean):void");
    }

    public static final boolean d(InterfaceC0797b makeKotlinParameterTypes) {
        p.i(makeKotlinParameterTypes, "$this$makeKotlinParameterTypes");
        return C4829i.g(makeKotlinParameterTypes);
    }

    @Override // A9.g
    public List<Type> a() {
        return this.caller.a();
    }

    @Override // A9.g
    public boolean b() {
        return this.caller instanceof h.AbstractC0005h.a;
    }

    @Override // A9.g
    public Object call(Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        Object objG;
        Object objG2;
        p.i(args, "args");
        C5680i argumentRange = this.data.getArgumentRange();
        List<Method>[] listArrC = this.data.c();
        Method box = this.data.getBox();
        if (!argumentRange.isEmpty()) {
            if (this.hasMfvcParameters) {
                List listD = C1172u.d(args.length);
                int first = argumentRange.getFirst();
                for (int i10 = 0; i10 < first; i10++) {
                    listD.add(args[i10]);
                }
                int first2 = argumentRange.getFirst();
                int last = argumentRange.getLast();
                if (first2 <= last) {
                    while (true) {
                        List<Method> list = listArrC[first2];
                        Object obj = args[first2];
                        if (list != null) {
                            List list2 = listD;
                            for (Method method : list) {
                                if (obj != null) {
                                    objG2 = method.invoke(obj, null);
                                } else {
                                    Class<?> returnType = method.getReturnType();
                                    p.h(returnType, "getReturnType(...)");
                                    objG2 = c1.g(returnType);
                                }
                                list2.add(objG2);
                            }
                        } else {
                            listD.add(obj);
                        }
                        if (first2 == last) {
                            break;
                        }
                        first2++;
                    }
                }
                int last2 = argumentRange.getLast() + 1;
                int iF0 = r.f0(args);
                if (last2 <= iF0) {
                    while (true) {
                        listD.add(args[last2]);
                        if (last2 == iF0) {
                            break;
                        }
                        last2++;
                    }
                }
                args = C1172u.a(listD).toArray(new Object[0]);
            } else {
                int length = args.length;
                Object[] objArr = new Object[length];
                for (int i11 = 0; i11 < length; i11++) {
                    int first3 = argumentRange.getFirst();
                    if (i11 > argumentRange.getLast() || first3 > i11) {
                        objG = args[i11];
                    } else {
                        List<Method> list3 = listArrC[i11];
                        Method method2 = list3 != null ? (Method) F.X0(list3) : null;
                        objG = args[i11];
                        if (method2 != null) {
                            if (objG != null) {
                                objG = method2.invoke(objG, null);
                            } else {
                                Class<?> returnType2 = method2.getReturnType();
                                p.h(returnType2, "getReturnType(...)");
                                objG = c1.g(returnType2);
                            }
                        }
                    }
                    objArr[i11] = objG;
                }
                args = objArr;
            }
        }
        Object objCall = this.caller.call(args);
        return (objCall == C4063a.g() || box == null || (objInvoke = box.invoke(null, objCall)) == null) ? objCall : objInvoke;
    }

    public final C5680i e(int index) {
        if (index >= 0) {
            C5680i[] c5680iArr = this.slices;
            if (index < c5680iArr.length) {
                return c5680iArr[index];
            }
        }
        C5680i[] c5680iArr2 = this.slices;
        if (c5680iArr2.length == 0) {
            return new C5680i(index, index);
        }
        int length = (index - c5680iArr2.length) + ((C5680i) r.y0(c5680iArr2)).getLast() + 1;
        return new C5680i(length, length);
    }

    @Override // A9.g
    public M getMember() {
        return this.member;
    }

    @Override // A9.g
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
