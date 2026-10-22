package kotlin.reflect.jvm.internal;

import E9.AbstractC0811p;
import E9.M;
import E9.S;
import E9.b0;
import E9.i0;
import Z8.C1173v;
import Z8.C1174w;
import Z8.C1177z;
import Z8.F;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.reflect.KParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.u;
import o9.C5013a;
import w9.InterfaceC5744c;
import w9.InterfaceC5755n;
import w9.InterfaceC5756o;
import ya.F0;
import z9.C6429n;
import z9.C6431o;
import z9.C6433p;
import z9.C6435q;
import z9.C6437r;
import z9.C6439s;
import z9.C6441t;
import z9.C6443u;
import z9.C6445v;
import z9.C6447w;
import z9.C6449x;
import z9.C6451y;
import z9.N0;
import z9.c1;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00028\u00002\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00028\u00002\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000b\"\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001f\u0010 J%\u0010!\u001a\u00028\u00002\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0014H\u0016¢\u0006\u0004\b!\u0010\u0017J3\u0010\u0001\u001a\u00028\u00002\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00142\f\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"H\u0000¢\u0006\u0004\b\u0001\u0010$R.\u0010*\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020& '*\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00070\u00070%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)RD\u0010.\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u000f '*\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010+j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`,0+j\b\u0012\u0004\u0012\u00020\u000f`,0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010)RD\u00100\u001a2\u0012.\u0012,\u0012\u0004\u0012\u00020\u000f '*\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010+j\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`,0+j\b\u0012\u0004\u0012\u00020\u000f`,0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010)R\"\u00103\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u000101010%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010)R.\u00106\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000204 '*\n\u0012\u0004\u0012\u000204\u0018\u00010\u00070\u00070%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010)R2\u00108\u001a \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f '*\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b0\u000b0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010)R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0006\u0012\u0002\b\u00030>8&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010>8&X¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@R\u0014\u0010G\u001a\u00020D8&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020:8&X¦\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020&0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0017\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00078F¢\u0006\u0006\u001a\u0004\bN\u0010LR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010LR\u0014\u0010T\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020U0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010LR\u0016\u0010[\u001a\u0004\u0018\u00010X8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0014\u0010\\\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010IR\u0014\u0010]\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010IR\u0014\u0010^\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010IR\u0014\u0010`\u001a\u00020:8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b_\u0010IR\u0014\u0010c\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b¨\u0006d"}, d2 = {"Lkotlin/reflect/jvm/internal/d;", "R", "Lw9/c;", "Lz9/N0;", "<init>", "()V", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "", "LE9/i0;", ExifInterface.LATITUDE_SOUTH, "(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;)Ljava/util/List;", "", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()[Ljava/lang/Object;", "Lkotlin/reflect/KParameter;", "parameter", "", "a0", "(Lkotlin/reflect/KParameter;)I", "", "args", "Q", "(Ljava/util/Map;)Ljava/lang/Object;", "Lw9/n;", "type", ExifInterface.GPS_DIRECTION_TRUE, "(Lw9/n;)Ljava/lang/Object;", "Ljava/lang/reflect/Type;", "U", "()Ljava/lang/reflect/Type;", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "Le9/c;", "continuationArgument", "(Ljava/util/Map;Le9/c;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/u$a;", "", "kotlin.jvm.PlatformType", Const.INTENT_KEY_APIKEY, "Lkotlin/reflect/jvm/internal/u$a;", "_annotations", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", Const.INTENT_KEY_PKGNAME, "_receiverParameters", "c", "_parameters", "Lkotlin/reflect/jvm/internal/s;", Const.INTENT_KEY_UMID, "_returnType", "Lkotlin/reflect/jvm/internal/t;", "e", "_typeParameters", "f", "_absentArguments", "LY8/h;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "LY8/h;", "parametersNeedMFVCFlattening", "LA9/g;", ExifInterface.LONGITUDE_WEST, "()LA9/g;", "caller", "Y", "defaultCaller", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "X", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "d0", "()Z", "isBound", "getAnnotations", "()Ljava/util/List;", "annotations", "b0", "receiverParameters", "getParameters", "parameters", "getReturnType", "()Lw9/n;", "returnType", "Lw9/o;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility", "isFinal", "isOpen", "isAbstract", "c0", "isAnnotationConstructor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "kotlin-reflection"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class d<R> implements InterfaceC5744c<R>, N0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final u.a<List<Annotation>> _annotations;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final u.a<ArrayList<KParameter>> _receiverParameters;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final u.a<ArrayList<KParameter>> _parameters;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final u.a<s> _returnType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final u.a<List<t>> _typeParameters;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final u.a<Object[]> _absentArguments;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<Boolean> parametersNeedMFVCFlattening;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d(((KParameter) t10).getName(), ((KParameter) t11).getName());
        }
    }

    public d() {
        u.a<List<Annotation>> aVarC = u.c(new C6429n(this));
        kotlin.jvm.internal.p.h(aVarC, "lazySoft(...)");
        this._annotations = aVarC;
        u.a<ArrayList<KParameter>> aVarC2 = u.c(new C6435q(this));
        kotlin.jvm.internal.p.h(aVarC2, "lazySoft(...)");
        this._receiverParameters = aVarC2;
        u.a<ArrayList<KParameter>> aVarC3 = u.c(new C6437r(this));
        kotlin.jvm.internal.p.h(aVarC3, "lazySoft(...)");
        this._parameters = aVarC3;
        u.a<s> aVarC4 = u.c(new C6439s(this));
        kotlin.jvm.internal.p.h(aVarC4, "lazySoft(...)");
        this._returnType = aVarC4;
        u.a<List<t>> aVarC5 = u.c(new C6441t(this));
        kotlin.jvm.internal.p.h(aVarC5, "lazySoft(...)");
        this._typeParameters = aVarC5;
        u.a<Object[]> aVarC6 = u.c(new C6443u(this));
        kotlin.jvm.internal.p.h(aVarC6, "lazySoft(...)");
        this._absentArguments = aVarC6;
        this.parametersNeedMFVCFlattening = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6445v(this));
    }

    public static final M A(S s10) {
        return s10;
    }

    public static final s B(d dVar) {
        ya.S returnType = dVar.f0().getReturnType();
        kotlin.jvm.internal.p.f(returnType);
        return new s(returnType, new C6433p(dVar));
    }

    public static final Type C(d dVar) {
        Type typeU = dVar.U();
        return typeU == null ? dVar.W().getReturnType() : typeU;
    }

    public static final List D(d dVar) {
        List<b0> typeParameters = dVar.f0().getTypeParameters();
        kotlin.jvm.internal.p.h(typeParameters, "getTypeParameters(...)");
        List<b0> list = typeParameters;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (b0 b0Var : list) {
            kotlin.jvm.internal.p.f(b0Var);
            arrayList.add(new t(dVar, b0Var));
        }
        return arrayList;
    }

    public static final boolean e0(d dVar) {
        List<KParameter> parameters = dVar.getParameters();
        if ((parameters instanceof Collection) && parameters.isEmpty()) {
            return false;
        }
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            if (c1.l(((KParameter) it.next()).getType())) {
                return true;
            }
        }
        return false;
    }

    public static final Object[] o(d dVar) {
        int iA0;
        List<KParameter> parameters = dVar.getParameters();
        int size = parameters.size() + (dVar.isSuspend() ? 1 : 0);
        if (dVar.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            iA0 = 0;
            for (KParameter kParameter : parameters) {
                iA0 += kParameter.getKind() == KParameter.Kind.VALUE ? dVar.a0(kParameter) : 0;
            }
        } else {
            List<KParameter> list = parameters;
            if ((list instanceof Collection) && list.isEmpty()) {
                iA0 = 0;
            } else {
                Iterator<T> it = list.iterator();
                iA0 = 0;
                while (it.hasNext()) {
                    if (((KParameter) it.next()).getKind() == KParameter.Kind.VALUE && (iA0 = iA0 + 1) < 0) {
                        C1173v.v();
                    }
                }
            }
        }
        int i10 = (iA0 + 31) / 32;
        Object[] objArr = new Object[size + i10 + 1];
        for (KParameter kParameter2 : parameters) {
            if (kParameter2.v() && !c1.m(kParameter2.getType())) {
                objArr[kParameter2.getIndex()] = c1.g(y9.d.g(kParameter2.getType()));
            } else if (kParameter2.a()) {
                objArr[kParameter2.getIndex()] = dVar.T(kParameter2.getType());
            }
        }
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[size + i11] = 0;
        }
        return objArr;
    }

    public static final List p(d dVar) {
        return c1.e(dVar.f0());
    }

    public static final ArrayList r(d dVar) {
        CallableMemberDescriptor callableMemberDescriptorF0 = dVar.f0();
        ArrayList arrayList = new ArrayList();
        if (!dVar.d0()) {
            arrayList.addAll(dVar.b0());
        }
        int size = callableMemberDescriptorF0.i().size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new l(dVar, arrayList.size(), KParameter.Kind.VALUE, new C6431o(callableMemberDescriptorF0, i10)));
        }
        if (dVar.c0() && (callableMemberDescriptorF0 instanceof U9.a) && arrayList.size() > 1) {
            C1177z.C(arrayList, new a());
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final M w(CallableMemberDescriptor callableMemberDescriptor, int i10) {
        i0 i0Var = callableMemberDescriptor.i().get(i10);
        kotlin.jvm.internal.p.h(i0Var, "get(...)");
        return i0Var;
    }

    public static final ArrayList x(d dVar) {
        ArrayList arrayList = new ArrayList();
        S sJ = c1.j(dVar.f0());
        if (sJ != null) {
            arrayList.add(new l(dVar, arrayList.size(), KParameter.Kind.INSTANCE, new C6447w(sJ)));
        }
        List<i0> listS = dVar.S(dVar.f0());
        int size = listS.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new l(dVar, arrayList.size(), KParameter.Kind.CONTEXT, new C6449x(listS, i10)));
        }
        S sK = dVar.f0().K();
        if (sK != null) {
            arrayList.add(new l(dVar, arrayList.size(), KParameter.Kind.EXTENSION_RECEIVER, new C6451y(sK)));
        }
        return arrayList;
    }

    public static final M y(S s10) {
        return s10;
    }

    public static final M z(List list, int i10) {
        return (M) list.get(i10);
    }

    public final R Q(Map<KParameter, ? extends Object> args) throws IllegalCallableAccessException, NegativeArraySizeException {
        Object objT;
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(C1174w.x(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (args.containsKey(kParameter)) {
                objT = args.get(kParameter);
                if (objT == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.v()) {
                objT = null;
            } else {
                if (!kParameter.a()) {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
                }
                objT = T(kParameter.getType());
            }
            arrayList.add(objT);
        }
        A9.g<?> gVarY = Y();
        if (gVarY != null) {
            try {
                return (R) gVarY.call(arrayList.toArray(new Object[0]));
            } catch (IllegalAccessException e10) {
                throw new IllegalCallableAccessException(e10);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + f0());
    }

    public final R R(Map<KParameter, ? extends Object> args, InterfaceC4014c<?> continuationArgument) throws IllegalCallableAccessException {
        kotlin.jvm.internal.p.i(args, "args");
        List<KParameter> parameters = getParameters();
        boolean z10 = false;
        if (parameters.isEmpty()) {
            try {
                return (R) W().call(isSuspend() ? new InterfaceC4014c[]{continuationArgument} : new InterfaceC4014c[0]);
            } catch (IllegalAccessException e10) {
                throw new IllegalCallableAccessException(e10);
            }
        }
        int size = parameters.size() + (isSuspend() ? 1 : 0);
        Object[] objArrV = V();
        if (isSuspend()) {
            objArrV[parameters.size()] = continuationArgument;
        }
        boolean zBooleanValue = this.parametersNeedMFVCFlattening.getValue().booleanValue();
        int i10 = 0;
        for (KParameter kParameter : parameters) {
            int iA0 = zBooleanValue ? a0(kParameter) : 1;
            if (args.containsKey(kParameter)) {
                objArrV[kParameter.getIndex()] = args.get(kParameter);
            } else if (kParameter.v()) {
                if (zBooleanValue) {
                    int i11 = i10 + iA0;
                    for (int i12 = i10; i12 < i11; i12++) {
                        int i13 = (i12 / 32) + size;
                        Object obj = objArrV[i13];
                        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlin.Int");
                        objArrV[i13] = Integer.valueOf(((Integer) obj).intValue() | (1 << (i12 % 32)));
                    }
                } else {
                    int i14 = (i10 / 32) + size;
                    Object obj2 = objArrV[i14];
                    kotlin.jvm.internal.p.g(obj2, "null cannot be cast to non-null type kotlin.Int");
                    objArrV[i14] = Integer.valueOf(((Integer) obj2).intValue() | (1 << (i10 % 32)));
                }
                z10 = true;
            } else if (!kParameter.a()) {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            if (kParameter.getKind() == KParameter.Kind.VALUE) {
                i10 += iA0;
            }
        }
        if (!z10) {
            try {
                A9.g<?> gVarW = W();
                Object[] objArrCopyOf = Arrays.copyOf(objArrV, size);
                kotlin.jvm.internal.p.h(objArrCopyOf, "copyOf(...)");
                return (R) gVarW.call(objArrCopyOf);
            } catch (IllegalAccessException e11) {
                throw new IllegalCallableAccessException(e11);
            }
        }
        A9.g<?> gVarY = Y();
        if (gVarY != null) {
            try {
                return (R) gVarY.call(objArrV);
            } catch (IllegalAccessException e12) {
                throw new IllegalCallableAccessException(e12);
            }
        }
        throw new KotlinReflectionInternalError("This callable does not support a default call: " + f0());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<E9.i0> S(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r18) {
        /*
            r17 = this;
            r1 = r18
            boolean r0 = r1 instanceof wa.C5771M
            if (r0 == 0) goto L1a
            r0 = r1
            wa.M r0 = (wa.C5771M) r0
            ea.d r2 = r0.F()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r0 = r0.a0()
            java.util.List r0 = r0.k0()
            kotlin.Pair r0 = Y8.j.a(r2, r0)
            goto L5a
        L1a:
            boolean r0 = r1 instanceof wa.C5770L
            if (r0 == 0) goto L32
            r0 = r1
            wa.L r0 = (wa.C5770L) r0
            ea.d r2 = r0.F()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = r0.a0()
            java.util.List r0 = r0.u0()
            kotlin.Pair r0 = Y8.j.a(r2, r0)
            goto L5a
        L32:
            boolean r0 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.f
            r2 = 0
            if (r0 == 0) goto L59
            r0 = r1
            kotlin.reflect.jvm.internal.impl.descriptors.f r0 = (kotlin.reflect.jvm.internal.impl.descriptors.f) r0
            E9.O r0 = r0.Q()
            boolean r3 = r0 instanceof wa.C5770L
            if (r3 == 0) goto L45
            wa.L r0 = (wa.C5770L) r0
            goto L46
        L45:
            r0 = r2
        L46:
            if (r0 == 0) goto L59
            ea.d r2 = r0.F()
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = r0.a0()
            java.util.List r0 = r0.u0()
            kotlin.Pair r0 = Y8.j.a(r2, r0)
            goto L5a
        L59:
            r0 = r2
        L5a:
            if (r0 != 0) goto L61
            java.util.List r0 = Z8.C1173v.m()
            return r0
        L61:
            java.lang.Object r2 = r0.a()
            r12 = r2
            ea.d r12 = (ea.InterfaceC4020d) r12
            java.lang.Object r0 = r0.b()
            r13 = r0
            java.util.List r13 = (java.util.List) r13
            java.util.List r0 = r1.s0()
            java.lang.String r2 = "getContextReceiverParameters(...)"
            kotlin.jvm.internal.p.h(r0, r2)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r14 = new java.util.ArrayList
            r2 = 10
            int r2 = Z8.C1174w.x(r0, r2)
            r14.<init>(r2)
            java.util.Iterator r15 = r0.iterator()
            r0 = 0
            r3 = r0
        L8b:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto Lde
            java.lang.Object r0 = r15.next()
            int r16 = r3 + 1
            if (r3 >= 0) goto L9c
            Z8.C1173v.w()
        L9c:
            E9.S r0 = (E9.S) r0
            r2 = r0
            H9.V r0 = new H9.V
            F9.g r4 = r2.getAnnotations()
            java.lang.Object r5 = r13.get(r3)
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r5 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter) r5
            int r5 = r5.S()
            java.lang.String r5 = r12.getString(r5)
            ga.e r5 = ga.e.i(r5)
            java.lang.String r6 = "guessByFirstCharacter(...)"
            kotlin.jvm.internal.p.h(r5, r6)
            ya.S r6 = r2.getType()
            java.lang.String r7 = "getType(...)"
            kotlin.jvm.internal.p.h(r6, r7)
            E9.W r11 = r2.e()
            java.lang.String r2 = "getSource(...)"
            kotlin.jvm.internal.p.h(r11, r2)
            r2 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r14.add(r0)
            r1 = r18
            r3 = r16
            goto L8b
        Lde:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.d.S(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor):java.util.List");
    }

    public final Object T(InterfaceC5755n type) throws NegativeArraySizeException {
        Class clsB = C5013a.b(y9.c.b(type));
        if (clsB.isArray()) {
            Object objNewInstance = Array.newInstance(clsB.getComponentType(), 0);
            kotlin.jvm.internal.p.h(objNewInstance, "run(...)");
            return objNewInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + clsB.getSimpleName() + ", because it is not an array type");
    }

    public final Type U() {
        Type[] lowerBounds;
        if (isSuspend()) {
            Object objE0 = F.E0(W().a());
            ParameterizedType parameterizedType = objE0 instanceof ParameterizedType ? (ParameterizedType) objE0 : null;
            if (kotlin.jvm.internal.p.d(parameterizedType != null ? parameterizedType.getRawType() : null, InterfaceC4014c.class)) {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                kotlin.jvm.internal.p.h(actualTypeArguments, "getActualTypeArguments(...)");
                Object objE02 = Z8.r.E0(actualTypeArguments);
                WildcardType wildcardType = objE02 instanceof WildcardType ? (WildcardType) objE02 : null;
                if (wildcardType != null && (lowerBounds = wildcardType.getLowerBounds()) != null) {
                    return (Type) Z8.r.X(lowerBounds);
                }
            }
        }
        return null;
    }

    public final Object[] V() {
        return (Object[]) this._absentArguments.invoke().clone();
    }

    public abstract A9.g<?> W();

    /* renamed from: X */
    public abstract KDeclarationContainerImpl getContainer();

    public abstract A9.g<?> Y();

    /* renamed from: Z */
    public abstract CallableMemberDescriptor f0();

    public final int a0(KParameter parameter) {
        if (!this.parametersNeedMFVCFlattening.getValue().booleanValue()) {
            throw new IllegalArgumentException("Check if parametersNeedMFVCFlattening is true before");
        }
        if (!c1.l(parameter.getType())) {
            return 1;
        }
        InterfaceC5755n type = parameter.getType();
        kotlin.jvm.internal.p.g(type, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        List<Method> listN = A9.n.n(F0.a(((s) type).getType()));
        kotlin.jvm.internal.p.f(listN);
        return listN.size();
    }

    public final List<KParameter> b0() {
        ArrayList<KParameter> arrayListInvoke = this._receiverParameters.invoke();
        kotlin.jvm.internal.p.h(arrayListInvoke, "invoke(...)");
        return arrayListInvoke;
    }

    public final boolean c0() {
        return kotlin.jvm.internal.p.d(getName(), "<init>") && getContainer().m().isAnnotation();
    }

    @Override // w9.InterfaceC5744c
    public R call(Object... args) throws IllegalCallableAccessException {
        kotlin.jvm.internal.p.i(args, "args");
        try {
            return (R) W().call(args);
        } catch (IllegalAccessException e10) {
            throw new IllegalCallableAccessException(e10);
        }
    }

    @Override // w9.InterfaceC5744c
    public R callBy(Map<KParameter, ? extends Object> args) {
        kotlin.jvm.internal.p.i(args, "args");
        return c0() ? Q(args) : R(args, null);
    }

    public abstract boolean d0();

    @Override // w9.InterfaceC5743b
    public List<Annotation> getAnnotations() {
        List<Annotation> listInvoke = this._annotations.invoke();
        kotlin.jvm.internal.p.h(listInvoke, "invoke(...)");
        return listInvoke;
    }

    @Override // w9.InterfaceC5744c
    public List<KParameter> getParameters() {
        ArrayList<KParameter> arrayListInvoke = this._parameters.invoke();
        kotlin.jvm.internal.p.h(arrayListInvoke, "invoke(...)");
        return arrayListInvoke;
    }

    @Override // w9.InterfaceC5744c
    public InterfaceC5755n getReturnType() {
        s sVarInvoke = this._returnType.invoke();
        kotlin.jvm.internal.p.h(sVarInvoke, "invoke(...)");
        return sVarInvoke;
    }

    @Override // w9.InterfaceC5744c
    public List<InterfaceC5756o> getTypeParameters() {
        List<t> listInvoke = this._typeParameters.invoke();
        kotlin.jvm.internal.p.h(listInvoke, "invoke(...)");
        return listInvoke;
    }

    @Override // w9.InterfaceC5744c
    public KVisibility getVisibility() {
        AbstractC0811p visibility = f0().getVisibility();
        kotlin.jvm.internal.p.h(visibility, "getVisibility(...)");
        return c1.s(visibility);
    }

    @Override // w9.InterfaceC5744c
    public boolean isAbstract() {
        return f0().p() == Modality.ABSTRACT;
    }

    @Override // w9.InterfaceC5744c
    public boolean isFinal() {
        return f0().p() == Modality.FINAL;
    }

    @Override // w9.InterfaceC5744c
    public boolean isOpen() {
        return f0().p() == Modality.OPEN;
    }
}
