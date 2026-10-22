package K9;

import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.JsonPointer;
import ga.b;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.sequences.SequencesKt___SequencesKt;
import o9.C5013a;
import p9.InterfaceC5063a;
import p9.InterfaceC5064b;
import p9.InterfaceC5065c;
import p9.InterfaceC5066d;
import p9.InterfaceC5067e;
import p9.InterfaceC5068f;
import p9.InterfaceC5069g;
import p9.InterfaceC5070h;
import p9.InterfaceC5071i;
import p9.InterfaceC5072j;
import p9.InterfaceC5073k;
import p9.InterfaceC5074l;
import p9.InterfaceC5075m;
import p9.InterfaceC5076n;
import w9.InterfaceC5745d;

/* renamed from: K9.f, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0925f {

    /* renamed from: a, reason: collision with root package name */
    public static final List<InterfaceC5745d<? extends Object>> f4171a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends Object>, Class<? extends Object>> f4172b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Class<? extends Object>, Class<? extends Object>> f4173c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<Class<? extends Y8.e<?>>, Integer> f4174d;

    static {
        int i10 = 0;
        List<InterfaceC5745d<? extends Object>> listP = C1173v.p(kotlin.jvm.internal.t.b(Boolean.TYPE), kotlin.jvm.internal.t.b(Byte.TYPE), kotlin.jvm.internal.t.b(Character.TYPE), kotlin.jvm.internal.t.b(Double.TYPE), kotlin.jvm.internal.t.b(Float.TYPE), kotlin.jvm.internal.t.b(Integer.TYPE), kotlin.jvm.internal.t.b(Long.TYPE), kotlin.jvm.internal.t.b(Short.TYPE));
        f4171a = listP;
        List<InterfaceC5745d<? extends Object>> list = listP;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            InterfaceC5745d interfaceC5745d = (InterfaceC5745d) it.next();
            arrayList.add(Y8.j.a(C5013a.c(interfaceC5745d), C5013a.d(interfaceC5745d)));
        }
        f4172b = kotlin.collections.a.y(arrayList);
        List<InterfaceC5745d<? extends Object>> list2 = f4171a;
        ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            InterfaceC5745d interfaceC5745d2 = (InterfaceC5745d) it2.next();
            arrayList2.add(Y8.j.a(C5013a.d(interfaceC5745d2), C5013a.c(interfaceC5745d2)));
        }
        f4173c = kotlin.collections.a.y(arrayList2);
        List listP2 = C1173v.p(InterfaceC5063a.class, InterfaceC5074l.class, p9.p.class, p9.q.class, p9.r.class, p9.s.class, p9.t.class, p9.u.class, p9.v.class, p9.w.class, InterfaceC5064b.class, InterfaceC5065c.class, InterfaceC5066d.class, InterfaceC5067e.class, InterfaceC5068f.class, InterfaceC5069g.class, InterfaceC5070h.class, InterfaceC5071i.class, InterfaceC5072j.class, InterfaceC5073k.class, InterfaceC5075m.class, InterfaceC5076n.class, p9.o.class);
        ArrayList arrayList3 = new ArrayList(C1174w.x(listP2, 10));
        for (Object obj : listP2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            arrayList3.add(Y8.j.a((Class) obj, Integer.valueOf(i10)));
            i10 = i11;
        }
        f4174d = kotlin.collections.a.y(arrayList3);
    }

    public static final ParameterizedType a(ParameterizedType it) {
        kotlin.jvm.internal.p.i(it, "it");
        Type ownerType = it.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }

    public static final Ka.j b(ParameterizedType it) {
        kotlin.jvm.internal.p.i(it, "it");
        Type[] actualTypeArguments = it.getActualTypeArguments();
        kotlin.jvm.internal.p.h(actualTypeArguments, "getActualTypeArguments(...)");
        return Z8.r.M(actualTypeArguments);
    }

    public static final ga.b e(Class<?> cls) {
        ga.b bVarE;
        kotlin.jvm.internal.p.i(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
            String simpleName = cls.getSimpleName();
            kotlin.jvm.internal.p.h(simpleName, "getSimpleName(...)");
            if (simpleName.length() != 0) {
                Class<?> declaringClass = cls.getDeclaringClass();
                if (declaringClass != null && (bVarE = e(declaringClass)) != null) {
                    ga.e eVarJ = ga.e.j(cls.getSimpleName());
                    kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
                    ga.b bVarD = bVarE.d(eVarJ);
                    if (bVarD != null) {
                        return bVarD;
                    }
                }
                b.a aVar = ga.b.f32721d;
                String name = cls.getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                return aVar.c(new ga.c(name));
            }
        }
        String name2 = cls.getName();
        kotlin.jvm.internal.p.h(name2, "getName(...)");
        ga.c cVar = new ga.c(name2);
        return new ga.b(cVar.d(), ga.c.f32725c.a(cVar.f()), true);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final String f(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                String name = cls.getName();
                kotlin.jvm.internal.p.h(name, "getName(...)");
                return La.D.S(name, '.', JsonPointer.SEPARATOR, false, 4, null);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('L');
            String name2 = cls.getName();
            kotlin.jvm.internal.p.h(name2, "getName(...)");
            sb2.append(La.D.S(name2, '.', JsonPointer.SEPARATOR, false, 4, null));
            sb2.append(';');
            return sb2.toString();
        }
        String name3 = cls.getName();
        switch (name3.hashCode()) {
            case -1325958191:
                if (name3.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name3.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name3.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name3.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name3.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name3.equals("void")) {
                    return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                }
                break;
            case 64711720:
                if (name3.equals("boolean")) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name3.equals("float")) {
                    return "F";
                }
                break;
            case 109413500:
                if (name3.equals("short")) {
                    return ExifInterface.LATITUDE_SOUTH;
                }
                break;
        }
        throw new IllegalArgumentException("Unsupported primitive type: " + cls);
    }

    public static final Integer g(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        return f4174d.get(cls);
    }

    public static final List<Type> h(Type type) {
        kotlin.jvm.internal.p.i(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return C1173v.m();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.L(Ka.t.q(type, C0923d.f4169a), C0924e.f4170a));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.p.h(actualTypeArguments, "getActualTypeArguments(...)");
        return Z8.r.T0(actualTypeArguments);
    }

    public static final Class<?> i(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        return f4172b.get(cls);
    }

    public static final ClassLoader j(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.p.h(systemClassLoader, "getSystemClassLoader(...)");
        return systemClassLoader;
    }

    public static final Class<?> k(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        return f4173c.get(cls);
    }

    public static final boolean l(Class<?> cls) {
        kotlin.jvm.internal.p.i(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
