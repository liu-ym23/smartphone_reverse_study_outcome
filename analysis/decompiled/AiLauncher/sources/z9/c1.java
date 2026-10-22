package z9;

import E9.AbstractC0811p;
import E9.C0810o;
import E9.InterfaceC0797b;
import E9.InterfaceC0799d;
import E9.InterfaceC0803h;
import E9.InterfaceC0819y;
import J9.l;
import K9.C0925f;
import K9.C0926g;
import Z8.C1168p;
import Z8.C1172u;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import ea.AbstractC4017a;
import ea.InterfaceC4020d;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import ma.AbstractC4927g;
import ma.C4921a;
import ma.C4922b;
import ma.s;
import o9.C5013a;
import ua.C5601K;
import ua.C5627m;
import ua.C5629o;
import w9.InterfaceC5744c;
import w9.InterfaceC5746e;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a+\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0014*\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\u00020\u0017H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0019*\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010#\u001a\u0004\u0018\u00010\"*\u0006\u0012\u0002\b\u00030!2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$\u001a\u001d\u0010&\u001a\u0004\u0018\u00010\"*\u00020%2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010'\u001a\u0017\u0010)\u001a\u0004\u0018\u00010(*\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010,\u001a\b\u0012\u0002\b\u0003\u0018\u00010+*\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b,\u0010-\u001a\u001b\u0010/\u001a\b\u0012\u0002\b\u0003\u0018\u00010.*\u0004\u0018\u00010\"H\u0000¢\u0006\u0004\b/\u00100\u001a\u0019\u00103\u001a\u0004\u0018\u00010\"2\u0006\u00102\u001a\u000201H\u0000¢\u0006\u0004\b3\u00104\u001a=\u00109\u001a\u0004\u0018\u000108*\u0006\u0012\u0002\b\u00030\u00012\u0006\u00105\u001a\u00020\f2\u001a\u00107\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000106\"\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b9\u0010:\u001a'\u0010>\u001a\u00028\u0000\"\u0004\b\u0000\u0010;2\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<H\u0080\bø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001ai\u0010O\u001a\u00028\u0001\"\b\b\u0000\u0010A*\u00020@\"\b\b\u0001\u0010C*\u00020B2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010E\u001a\u00028\u00002\u0006\u0010G\u001a\u00020F2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0018\u0010N\u001a\u0014\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010LH\u0000¢\u0006\u0004\bO\u0010P\"\u001a\u0010U\u001a\u00020Q8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u0010R\u001a\u0004\bS\u0010T\"\u0018\u0010Z\u001a\u00020W*\u00020V8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bX\u0010Y\"\u0018\u0010\\\u001a\u00020W*\u00020V8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b[\u0010Y\"\u001a\u0010`\u001a\u0004\u0018\u00010]*\u00020B8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006a"}, d2 = {"LE9/b;", "Ljava/lang/Class;", "r", "(LE9/b;)Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "Lga/b;", "kotlinClassId", "", "arrayDimensions", "n", "(Ljava/lang/ClassLoader;Lga/b;I)Ljava/lang/Class;", "classLoader", "", "packageName", "className", "o", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Class;", "f", "(Ljava/lang/Class;)Ljava/lang/Class;", "LE9/p;", "Lkotlin/reflect/KVisibility;", "s", "(LE9/p;)Lkotlin/reflect/KVisibility;", "LF9/a;", "", "", "e", "(LF9/a;)Ljava/util/List;", "u", "(Ljava/util/List;)Ljava/util/List;", "LF9/c;", "q", "(LF9/c;)Ljava/lang/annotation/Annotation;", "Lma/g;", "", "t", "(Lma/g;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lma/b;", Const.INTENT_KEY_APIKEY, "(Lma/b;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/f;", "c", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/jvm/internal/p;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/p;", "Lkotlin/reflect/jvm/internal/d;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/d;", "Ljava/lang/reflect/Type;", "type", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "name", "", "parameterTypes", "Ljava/lang/reflect/Method;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "R", "Lkotlin/Function0;", "block", "reflectionCall", "(Lp9/a;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/protobuf/h;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/a;", "D", "moduleAnchor", "proto", "Lea/d;", "nameResolver", "Lea/h;", "typeTable", "Lea/a;", "metadataVersion", "Lkotlin/Function2;", "Lua/K;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lp9/p;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "Lga/c;", "Lga/c;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "JVM_STATIC", "Lw9/n;", "", "m", "(Lw9/n;)Z", "isInlineClassType", "l", "needsMultiFieldValueClassFlattening", "LE9/S;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ga.c f45340a = new ga.c("kotlin.jvm.JvmStatic");

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45341a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f45341a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(C4922b c4922b, ClassLoader classLoader) throws NegativeArraySizeException {
        ya.S sE;
        Class clsP;
        ma.z zVar = c4922b instanceof ma.z ? (ma.z) c4922b : null;
        if (zVar == null || (sE = zVar.e()) == null) {
            return null;
        }
        List<? extends AbstractC4927g<?>> listB = c4922b.b();
        ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(t((AbstractC4927g) it.next(), classLoader));
        }
        PrimitiveType primitiveTypeO = C9.j.O(sE);
        int i10 = 0;
        switch (primitiveTypeO == null ? -1 : a.f45341a[primitiveTypeO.ordinal()]) {
            case -1:
                if (!C9.j.d0(sE)) {
                    throw new IllegalStateException(("Not an array type: " + sE).toString());
                }
                ya.S type = ((ya.B0) Z8.F.X0(sE.F0())).getType();
                kotlin.jvm.internal.p.h(type, "getType(...)");
                InterfaceC0799d interfaceC0799dD = type.H0().d();
                InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
                if (interfaceC0797b == null) {
                    throw new IllegalStateException(("Not a class type: " + type).toString());
                }
                if (C9.j.w0(type)) {
                    int size = c4922b.b().size();
                    String[] strArr = new String[size];
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlin.String");
                        strArr[i10] = obj;
                        i10++;
                    }
                    return strArr;
                }
                if (C9.j.m0(interfaceC0797b)) {
                    int size2 = c4922b.b().size();
                    Class[] clsArr = new Class[size2];
                    while (i10 < size2) {
                        Object obj2 = arrayList.get(i10);
                        kotlin.jvm.internal.p.g(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        clsArr[i10] = obj2;
                        i10++;
                    }
                    return clsArr;
                }
                ga.b bVarN = DescriptorUtilsKt.n(interfaceC0797b);
                if (bVarN == null || (clsP = p(classLoader, bVarN, 0, 2, null)) == null) {
                    return null;
                }
                Object objNewInstance = Array.newInstance((Class<?>) clsP, c4922b.b().size());
                kotlin.jvm.internal.p.g(objNewInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                Object[] objArr = (Object[]) objNewInstance;
                int size3 = arrayList.size();
                while (i10 < size3) {
                    objArr[i10] = arrayList.get(i10);
                    i10++;
                }
                return objArr;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                int size4 = c4922b.b().size();
                boolean[] zArr = new boolean[size4];
                while (i10 < size4) {
                    Object obj3 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    zArr[i10] = ((Boolean) obj3).booleanValue();
                    i10++;
                }
                return zArr;
            case 2:
                int size5 = c4922b.b().size();
                char[] cArr = new char[size5];
                while (i10 < size5) {
                    Object obj4 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj4, "null cannot be cast to non-null type kotlin.Char");
                    cArr[i10] = ((Character) obj4).charValue();
                    i10++;
                }
                return cArr;
            case 3:
                int size6 = c4922b.b().size();
                byte[] bArr = new byte[size6];
                while (i10 < size6) {
                    Object obj5 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    bArr[i10] = ((Byte) obj5).byteValue();
                    i10++;
                }
                return bArr;
            case 4:
                int size7 = c4922b.b().size();
                short[] sArr = new short[size7];
                while (i10 < size7) {
                    Object obj6 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i10] = ((Short) obj6).shortValue();
                    i10++;
                }
                return sArr;
            case 5:
                int size8 = c4922b.b().size();
                int[] iArr = new int[size8];
                while (i10 < size8) {
                    Object obj7 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj7, "null cannot be cast to non-null type kotlin.Int");
                    iArr[i10] = ((Integer) obj7).intValue();
                    i10++;
                }
                return iArr;
            case 6:
                int size9 = c4922b.b().size();
                float[] fArr = new float[size9];
                while (i10 < size9) {
                    Object obj8 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj8, "null cannot be cast to non-null type kotlin.Float");
                    fArr[i10] = ((Float) obj8).floatValue();
                    i10++;
                }
                return fArr;
            case 7:
                int size10 = c4922b.b().size();
                long[] jArr = new long[size10];
                while (i10 < size10) {
                    Object obj9 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj9, "null cannot be cast to non-null type kotlin.Long");
                    jArr[i10] = ((Long) obj9).longValue();
                    i10++;
                }
                return jArr;
            case 8:
                int size11 = c4922b.b().size();
                double[] dArr = new double[size11];
                while (i10 < size11) {
                    Object obj10 = arrayList.get(i10);
                    kotlin.jvm.internal.p.g(obj10, "null cannot be cast to non-null type kotlin.Double");
                    dArr[i10] = ((Double) obj10).doubleValue();
                    i10++;
                }
                return dArr;
        }
    }

    public static final kotlin.reflect.jvm.internal.d<?> b(Object obj) {
        kotlin.reflect.jvm.internal.d<?> dVar = obj instanceof kotlin.reflect.jvm.internal.d ? (kotlin.reflect.jvm.internal.d) obj : null;
        if (dVar != null) {
            return dVar;
        }
        kotlin.reflect.jvm.internal.f fVarC = c(obj);
        return fVarC != null ? fVarC : d(obj);
    }

    public static final kotlin.reflect.jvm.internal.f c(Object obj) {
        kotlin.reflect.jvm.internal.f fVar = obj instanceof kotlin.reflect.jvm.internal.f ? (kotlin.reflect.jvm.internal.f) obj : null;
        if (fVar != null) {
            return fVar;
        }
        FunctionReference functionReference = obj instanceof FunctionReference ? (FunctionReference) obj : null;
        InterfaceC5744c interfaceC5744cCompute = functionReference != null ? functionReference.compute() : null;
        if (interfaceC5744cCompute instanceof kotlin.reflect.jvm.internal.f) {
            return (kotlin.reflect.jvm.internal.f) interfaceC5744cCompute;
        }
        return null;
    }

    public static final kotlin.reflect.jvm.internal.p<?> d(Object obj) {
        kotlin.reflect.jvm.internal.p<?> pVar = obj instanceof kotlin.reflect.jvm.internal.p ? (kotlin.reflect.jvm.internal.p) obj : null;
        if (pVar != null) {
            return pVar;
        }
        PropertyReference propertyReference = obj instanceof PropertyReference ? (PropertyReference) obj : null;
        InterfaceC5744c interfaceC5744cCompute = propertyReference != null ? propertyReference.compute() : null;
        if (interfaceC5744cCompute instanceof kotlin.reflect.jvm.internal.p) {
            return (kotlin.reflect.jvm.internal.p) interfaceC5744cCompute;
        }
        return null;
    }

    public static final List<Annotation> e(F9.a aVar) {
        Annotation annotationQ;
        kotlin.jvm.internal.p.i(aVar, "<this>");
        F9.g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (F9.c cVar : annotations) {
            E9.W wE = cVar.e();
            if (wE instanceof J9.b) {
                annotationQ = ((J9.b) wE).d();
            } else if (wE instanceof l.a) {
                K9.t tVarC = ((l.a) wE).c();
                C0926g c0926g = tVarC instanceof C0926g ? (C0926g) tVarC : null;
                annotationQ = c0926g != null ? c0926g.M() : null;
            } else {
                annotationQ = q(cVar);
            }
            if (annotationQ != null) {
                arrayList.add(annotationQ);
            }
        }
        return u(arrayList);
    }

    public static final Class<?> f(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final Object g(Type type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!cls.isPrimitive()) {
            return null;
        }
        if (kotlin.jvm.internal.p.d(cls, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (kotlin.jvm.internal.p.d(cls, Character.TYPE)) {
            return (char) 0;
        }
        if (kotlin.jvm.internal.p.d(cls, Byte.TYPE)) {
            return (byte) 0;
        }
        if (kotlin.jvm.internal.p.d(cls, Short.TYPE)) {
            return (short) 0;
        }
        if (kotlin.jvm.internal.p.d(cls, Integer.TYPE)) {
            return 0;
        }
        if (kotlin.jvm.internal.p.d(cls, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (kotlin.jvm.internal.p.d(cls, Long.TYPE)) {
            return 0L;
        }
        if (kotlin.jvm.internal.p.d(cls, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (kotlin.jvm.internal.p.d(cls, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.h, D extends kotlin.reflect.jvm.internal.impl.descriptors.a> D h(Class<?> moduleAnchor, M proto, InterfaceC4020d nameResolver, ea.h typeTable, AbstractC4017a metadataVersion, p9.p<? super C5601K, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf$TypeParameter> listZ0;
        kotlin.jvm.internal.p.i(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.p.i(proto, "proto");
        kotlin.jvm.internal.p.i(nameResolver, "nameResolver");
        kotlin.jvm.internal.p.i(typeTable, "typeTable");
        kotlin.jvm.internal.p.i(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.p.i(createDescriptor, "createDescriptor");
        J9.k kVarA = P0.a(moduleAnchor);
        if (proto instanceof ProtoBuf$Function) {
            listZ0 = ((ProtoBuf$Function) proto).E0();
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            listZ0 = ((ProtoBuf$Property) proto).Z0();
        }
        List<ProtoBuf$TypeParameter> list = listZ0;
        C5627m c5627mA = kVarA.a();
        InterfaceC0819y interfaceC0819yB = kVarA.b();
        ea.j jVarB = ea.j.f32424b.b();
        kotlin.jvm.internal.p.f(list);
        return createDescriptor.invoke(new C5601K(new C5629o(c5627mA, nameResolver, interfaceC0819yB, typeTable, jVarB, metadataVersion, null, null, list)), proto);
    }

    public static final Method i(Class<?> cls, String name, Class<?>... parameterTypes) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(parameterTypes, "parameterTypes");
        try {
            return cls.getDeclaredMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final E9.S j(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.p.i(aVar, "<this>");
        if (aVar.H() == null) {
            return null;
        }
        InterfaceC0803h interfaceC0803hB = aVar.b();
        kotlin.jvm.internal.p.g(interfaceC0803hB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((InterfaceC0797b) interfaceC0803hB).D0();
    }

    public static final ga.c k() {
        return f45340a;
    }

    public static final boolean l(InterfaceC5755n interfaceC5755n) {
        kotlin.jvm.internal.p.i(interfaceC5755n, "<this>");
        InterfaceC5746e interfaceC5746eC = interfaceC5755n.getClassifier();
        kotlin.reflect.jvm.internal.e eVar = interfaceC5746eC instanceof kotlin.reflect.jvm.internal.e ? (kotlin.reflect.jvm.internal.e) interfaceC5746eC : null;
        return (eVar == null || !eVar.q() || eVar.i0()) ? false : true;
    }

    public static final boolean m(InterfaceC5755n interfaceC5755n) {
        kotlin.jvm.internal.p.i(interfaceC5755n, "<this>");
        InterfaceC5746e interfaceC5746eC = interfaceC5755n.getClassifier();
        kotlin.reflect.jvm.internal.e eVar = interfaceC5746eC instanceof kotlin.reflect.jvm.internal.e ? (kotlin.reflect.jvm.internal.e) interfaceC5746eC : null;
        return eVar != null && eVar.i0();
    }

    public static final Class<?> n(ClassLoader classLoader, ga.b kotlinClassId, int i10) {
        kotlin.jvm.internal.p.i(classLoader, "<this>");
        kotlin.jvm.internal.p.i(kotlinClassId, "kotlinClassId");
        ga.b bVarN = D9.a.f2270a.n(kotlinClassId.a().i());
        if (bVarN == null) {
            bVarN = kotlinClassId;
        }
        if (!kotlin.jvm.internal.p.d(bVarN, kotlinClassId)) {
            classLoader = C0925f.j(Y8.t.class);
        }
        return o(classLoader, bVarN.f().a(), bVarN.g().a(), i10);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class<?> o(ClassLoader classLoader, String str, String str2, int i10) {
        if (kotlin.jvm.internal.p.d(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        if (i10 > 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append("[");
            }
            sb2.append("L");
        }
        if (str.length() > 0) {
            sb2.append(str + '.');
        }
        sb2.append(La.D.S(str2, '.', '$', false, 4, null));
        if (i10 > 0) {
            sb2.append(Const.STR_MART_SEMICOLON);
        }
        return J9.e.a(classLoader, sb2.toString());
    }

    public static /* synthetic */ Class p(ClassLoader classLoader, ga.b bVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return n(classLoader, bVar, i10);
    }

    public static final Annotation q(F9.c cVar) {
        InterfaceC0797b interfaceC0797bL = DescriptorUtilsKt.l(cVar);
        Class<?> clsR = interfaceC0797bL != null ? r(interfaceC0797bL) : null;
        if (clsR == null) {
            clsR = null;
        }
        if (clsR == null) {
            return null;
        }
        Set<Map.Entry<ga.e, AbstractC4927g<?>>> setEntrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ga.e eVar = (ga.e) entry.getKey();
            AbstractC4927g abstractC4927g = (AbstractC4927g) entry.getValue();
            ClassLoader classLoader = clsR.getClassLoader();
            kotlin.jvm.internal.p.h(classLoader, "getClassLoader(...)");
            Object objT = t(abstractC4927g, classLoader);
            Pair pairA = objT != null ? Y8.j.a(eVar.b(), objT) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return (Annotation) A9.e.h(clsR, kotlin.collections.a.y(arrayList), null, 4, null);
    }

    public static final Class<?> r(InterfaceC0797b interfaceC0797b) {
        kotlin.jvm.internal.p.i(interfaceC0797b, "<this>");
        E9.W wE = interfaceC0797b.e();
        kotlin.jvm.internal.p.h(wE, "getSource(...)");
        if (wE instanceof ba.s) {
            kotlin.reflect.jvm.internal.impl.load.kotlin.f fVarD = ((ba.s) wE).d();
            kotlin.jvm.internal.p.g(fVarD, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((J9.f) fVarD).d();
        }
        if (wE instanceof l.a) {
            K9.t tVarC = ((l.a) wE).c();
            kotlin.jvm.internal.p.g(tVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) tVarC).s();
        }
        ga.b bVarN = DescriptorUtilsKt.n(interfaceC0797b);
        if (bVarN == null) {
            return null;
        }
        return p(C0925f.j(interfaceC0797b.getClass()), bVarN, 0, 2, null);
    }

    public static final KVisibility s(AbstractC0811p abstractC0811p) {
        kotlin.jvm.internal.p.i(abstractC0811p, "<this>");
        if (kotlin.jvm.internal.p.d(abstractC0811p, C0810o.f2473e)) {
            return KVisibility.PUBLIC;
        }
        if (kotlin.jvm.internal.p.d(abstractC0811p, C0810o.f2471c)) {
            return KVisibility.PROTECTED;
        }
        if (kotlin.jvm.internal.p.d(abstractC0811p, C0810o.f2472d)) {
            return KVisibility.INTERNAL;
        }
        if (kotlin.jvm.internal.p.d(abstractC0811p, C0810o.f2469a) || kotlin.jvm.internal.p.d(abstractC0811p, C0810o.f2470b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    public static final Object t(AbstractC4927g<?> abstractC4927g, ClassLoader classLoader) {
        if (abstractC4927g instanceof C4921a) {
            return q(((C4921a) abstractC4927g).b());
        }
        if (abstractC4927g instanceof C4922b) {
            return a((C4922b) abstractC4927g, classLoader);
        }
        if (abstractC4927g instanceof ma.k) {
            Pair<? extends ga.b, ? extends ga.e> pairB = ((ma.k) abstractC4927g).b();
            ga.b bVarA = pairB.a();
            ga.e eVarB = pairB.b();
            Class clsP = p(classLoader, bVarA, 0, 2, null);
            if (clsP != null) {
                return b1.a(clsP, eVarB.b());
            }
            return null;
        }
        if (!(abstractC4927g instanceof ma.s)) {
            if ((abstractC4927g instanceof ma.l) || (abstractC4927g instanceof ma.u)) {
                return null;
            }
            return abstractC4927g.b();
        }
        s.b bVarB = ((ma.s) abstractC4927g).b();
        if (bVarB instanceof s.b.C0474b) {
            s.b.C0474b c0474b = (s.b.C0474b) bVarB;
            return n(classLoader, c0474b.b(), c0474b.a());
        }
        if (!(bVarB instanceof s.b.a)) {
            throw new NoWhenBranchMatchedException();
        }
        InterfaceC0799d interfaceC0799dD = ((s.b.a) bVarB).a().H0().d();
        InterfaceC0797b interfaceC0797b = interfaceC0799dD instanceof InterfaceC0797b ? (InterfaceC0797b) interfaceC0799dD : null;
        if (interfaceC0797b != null) {
            return r(interfaceC0797b);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, java.util.List<? extends java.lang.annotation.Annotation>, java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List<java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList, java.util.Collection] */
    public static final List<Annotation> u(List<? extends Annotation> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List listE;
        kotlin.jvm.internal.p.i(list, "<this>");
        Iterable<Annotation> iterable = (Iterable) list;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return list;
        }
        Iterator it = iterable.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (kotlin.jvm.internal.p.d(C5013a.b(C5013a.a((Annotation) it.next())).getSimpleName(), "Container")) {
                list = new ArrayList<>();
                for (Annotation annotation : iterable) {
                    Class clsB = C5013a.b(C5013a.a(annotation));
                    if (!kotlin.jvm.internal.p.d(clsB.getSimpleName(), "Container") || clsB.getAnnotation(kotlin.jvm.internal.v.class) == null) {
                        listE = C1172u.e(annotation);
                    } else {
                        Object objInvoke = clsB.getDeclaredMethod(UxipConstants.f30680s, null).invoke(annotation, null);
                        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                        listE = C1168p.d((Annotation[]) objInvoke);
                    }
                    Z8.A.E(list, listE);
                }
            }
        }
        return list;
    }
}
