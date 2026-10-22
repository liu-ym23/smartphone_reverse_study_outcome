package n8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import b8.InterfaceC0844e;
import com.fasterxml.jackson.core.JsonPointer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.EmptyList;

/* renamed from: n8.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1744c {

    /* renamed from: a, reason: collision with root package name */
    public static final List f5355a;
    public static final Map b;
    public static final Map c;
    public static final Map d;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        int i = 0;
        List listN = H4.o.N(nVar.b(Boolean.TYPE), nVar.b(Byte.TYPE), nVar.b(Character.TYPE), nVar.b(Double.TYPE), nVar.b(Float.TYPE), nVar.b(Integer.TYPE), nVar.b(Long.TYPE), nVar.b(Short.TYPE));
        f5355a = listN;
        List<Z7.d> list = listN;
        ArrayList arrayList = new ArrayList(D7.w.c0(list, 10));
        for (Z7.d dVar : list) {
            arrayList.add(new Pair(M.a.a0(dVar), M.a.b0(dVar)));
        }
        b = kotlin.collections.a.X(arrayList);
        List<Z7.d> list2 = f5355a;
        ArrayList arrayList2 = new ArrayList(D7.w.c0(list2, 10));
        for (Z7.d dVar2 : list2) {
            arrayList2.add(new Pair(M.a.b0(dVar2), M.a.a0(dVar2)));
        }
        c = kotlin.collections.a.X(arrayList2);
        List listN2 = H4.o.N(S7.a.class, S7.k.class, S7.n.class, S7.o.class, S7.p.class, S7.q.class, S7.r.class, S7.s.class, S7.t.class, S7.u.class, S7.b.class, S7.c.class, InterfaceC0844e.class, S7.d.class, S7.e.class, S7.f.class, S7.g.class, S7.h.class, S7.i.class, S7.j.class, S7.l.class, S7.m.class, InterfaceC0844e.class);
        ArrayList arrayList3 = new ArrayList(D7.w.c0(listN2, 10));
        for (Object obj : listN2) {
            int i6 = i + 1;
            if (i < 0) {
                H4.o.X();
                throw null;
            }
            arrayList3.add(new Pair((Class) obj, Integer.valueOf(i)));
            i = i6;
        }
        d = kotlin.collections.a.X(arrayList3);
    }

    public static final G8.b a(Class cls) {
        kotlin.jvm.internal.k.f(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException(B7.a.i(cls, "Can't compute ClassId for primitive type: "));
        }
        if (cls.isArray()) {
            throw new IllegalArgumentException(B7.a.i(cls, "Can't compute ClassId for array type: "));
        }
        if (cls.getEnclosingMethod() != null || cls.getEnclosingConstructor() != null || cls.getSimpleName().length() == 0) {
            G8.c cVar = new G8.c(cls.getName());
            return new G8.b(cVar.e(), G8.c.j(cVar.f()), true);
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            return a(declaringClass).d(G8.f.e(cls.getSimpleName()));
        }
        G8.c cVar2 = new G8.c(cls.getName());
        G8.c cVarE = cVar2.e();
        G8.f fVarF = cVar2.f();
        kotlin.jvm.internal.k.e(fVarF, "shortName(...)");
        return new G8.b(cVarE, fVarF);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final String b(Class cls) {
        kotlin.jvm.internal.k.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (cls.isArray()) {
                return j9.t.b0(cls.getName(), '.', JsonPointer.SEPARATOR);
            }
            return "L" + j9.t.b0(cls.getName(), '.', JsonPointer.SEPARATOR) + ';';
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    return "D";
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    return "I";
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    return "B";
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    return "C";
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    return "J";
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return "Z";
                }
                break;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    return "F";
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    return ExifInterface.LATITUDE_SOUTH;
                }
                break;
        }
        throw new IllegalArgumentException(B7.a.i(cls, "Unsupported primitive type: "));
    }

    public static final List c(Type type) {
        kotlin.jvm.internal.k.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return EmptyList.f4893a;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return kotlin.sequences.a.o0(kotlin.sequences.a.h0(kotlin.sequences.a.k0(C1743b.b, type), C1743b.c));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        kotlin.jvm.internal.k.e(actualTypeArguments, "getActualTypeArguments(...)");
        return D7.q.I0(actualTypeArguments);
    }

    public static final ClassLoader d(Class cls) {
        kotlin.jvm.internal.k.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.k.e(systemClassLoader, "getSystemClassLoader(...)");
        return systemClassLoader;
    }
}
