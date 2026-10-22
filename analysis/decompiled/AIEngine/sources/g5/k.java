package g5;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import d5.u;
import d5.v;
import f5.h;
import i5.a;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k implements v {

    /* renamed from: a, reason: collision with root package name */
    public final f5.a f8999a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.b f9000b;

    /* renamed from: c, reason: collision with root package name */
    public final f5.e f9001c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.d f9002d;

    /* renamed from: e, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f9003e;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a<T> extends u<T> {
        @Override // d5.u
        public final T a(k5.a aVar) throws IOException {
            aVar.Y0();
            return null;
        }

        @Override // d5.u
        public final void b(k5.b bVar, T t8) throws IOException {
            bVar.c0();
        }

        public final String toString() {
            return "AnonymousOrNonStaticLocalClassAdapter";
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class b<T, A> extends u<T> {

        /* renamed from: a, reason: collision with root package name */
        public final e f9004a;

        public b(e eVar) {
            this.f9004a = eVar;
        }

        @Override // d5.u
        public final T a(k5.a aVar) throws IOException {
            if (aVar.R0() == JsonToken.f5478l) {
                aVar.N0();
                return null;
            }
            A aC = c();
            Map<String, c> map = this.f9004a.f9010a;
            try {
                aVar.o();
                while (aVar.x0()) {
                    c cVar = map.get(aVar.L0());
                    if (cVar == null) {
                        aVar.Y0();
                    } else {
                        e(aC, aVar, cVar);
                    }
                }
                aVar.P();
                return d(aC);
            } catch (IllegalAccessException e10) {
                a.AbstractC0090a abstractC0090a = i5.a.f9539a;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
            } catch (IllegalStateException e11) {
                throw new JsonSyntaxException(e11);
            }
        }

        @Override // d5.u
        public final void b(k5.b bVar, T t8) throws IOException {
            if (t8 == null) {
                bVar.c0();
                return;
            }
            bVar.w();
            try {
                Iterator<c> it = this.f9004a.f9011b.iterator();
                while (it.hasNext()) {
                    it.next().c(bVar, t8);
                }
                bVar.P();
            } catch (IllegalAccessException e10) {
                a.AbstractC0090a abstractC0090a = i5.a.f9539a;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
            }
        }

        public abstract A c();

        public abstract T d(A a10);

        public abstract void e(A a10, k5.a aVar, c cVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f9005a;

        /* renamed from: b, reason: collision with root package name */
        public final Field f9006b;

        /* renamed from: c, reason: collision with root package name */
        public final String f9007c;

        public c(String str, Field field) {
            this.f9005a = str;
            this.f9006b = field;
            this.f9007c = field.getName();
        }

        public abstract void a(k5.a aVar, int i10, Object[] objArr);

        public abstract void b(k5.a aVar, Object obj);

        public abstract void c(k5.b bVar, Object obj);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {

        /* renamed from: c, reason: collision with root package name */
        public static final e f9009c = new e(Collections.EMPTY_LIST, Collections.EMPTY_MAP);

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, c> f9010a;

        /* renamed from: b, reason: collision with root package name */
        public final List<c> f9011b;

        public e(List list, Map map) {
            this.f9010a = map;
            this.f9011b = list;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f<T> extends b<T, Object[]> {

        /* renamed from: e, reason: collision with root package name */
        public static final HashMap f9012e;

        /* renamed from: b, reason: collision with root package name */
        public final Constructor<T> f9013b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f9014c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f9015d;

        static {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            f9012e = map;
        }

        public f(Class<T> cls, e eVar, boolean z) throws SecurityException {
            super(eVar);
            this.f9015d = new HashMap();
            a.AbstractC0090a abstractC0090a = i5.a.f9539a;
            Constructor<T> constructorB = abstractC0090a.b(cls);
            this.f9013b = constructorB;
            if (z) {
                k.a(null, constructorB);
            } else {
                i5.a.f(constructorB);
            }
            String[] strArrC = abstractC0090a.c(cls);
            for (int i10 = 0; i10 < strArrC.length; i10++) {
                this.f9015d.put(strArrC[i10], Integer.valueOf(i10));
            }
            Class<?>[] parameterTypes = this.f9013b.getParameterTypes();
            this.f9014c = new Object[parameterTypes.length];
            for (int i11 = 0; i11 < parameterTypes.length; i11++) {
                this.f9014c[i11] = f9012e.get(parameterTypes[i11]);
            }
        }

        @Override // g5.k.b
        public final Object[] c() {
            return (Object[]) this.f9014c.clone();
        }

        @Override // g5.k.b
        public final Object d(Object[] objArr) {
            Object[] objArr2 = objArr;
            Constructor<T> constructor = this.f9013b;
            try {
                return constructor.newInstance(objArr2);
            } catch (IllegalAccessException e10) {
                a.AbstractC0090a abstractC0090a = i5.a.f9539a;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
            } catch (IllegalArgumentException | InstantiationException e11) {
                throw new RuntimeException("Failed to invoke constructor '" + i5.a.b(constructor) + "' with args " + Arrays.toString(objArr2), e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke constructor '" + i5.a.b(constructor) + "' with args " + Arrays.toString(objArr2), e12.getCause());
            }
        }

        @Override // g5.k.b
        public final void e(Object[] objArr, k5.a aVar, c cVar) {
            Object[] objArr2 = objArr;
            String str = cVar.f9007c;
            Integer num = (Integer) this.f9015d.get(str);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr2);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + i5.a.b(this.f9013b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(f5.a aVar, d5.b bVar, f5.e eVar, g5.d dVar, List<ReflectionAccessFilter> list) {
        this.f8999a = aVar;
        this.f9000b = bVar;
        this.f9001c = eVar;
        this.f9002d = dVar;
        this.f9003e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!h.a.f8752a.a(obj, accessibleObject)) {
            throw new JsonIOException(a0.a.j(i5.a.d(accessibleObject, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    public static void c(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + i5.a.c(field) + " and " + i5.a.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // d5.v
    public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        a.AbstractC0090a abstractC0090a = i5.a.f9539a;
        if (!Modifier.isStatic(rawType.getModifiers()) && (rawType.isAnonymousClass() || rawType.isLocalClass())) {
            return new a();
        }
        ReflectionAccessFilter.FilterResult filterResultA = f5.h.a(rawType, this.f9003e);
        if (filterResultA != ReflectionAccessFilter.FilterResult.f5432d) {
            boolean z = filterResultA == ReflectionAccessFilter.FilterResult.f5431c;
            return i5.a.f9539a.d(rawType) ? new f(rawType, d(iVar, typeToken, rawType, z, true), z) : new d(this.f8999a.b(typeToken), d(iVar, typeToken, rawType, z, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + rawType + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0196  */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final g5.k.e d(d5.i r29, com.google.gson.reflect.TypeToken<?> r30, java.lang.Class<?> r31, boolean r32, boolean r33) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 507
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.k.d(d5.i, com.google.gson.reflect.TypeToken, java.lang.Class, boolean, boolean):g5.k$e");
    }

    public final boolean e(Field field, boolean z) {
        boolean z3;
        f5.e eVar = this.f9001c;
        eVar.getClass();
        if ((136 & field.getModifiers()) != 0 || field.isSynthetic() || eVar.c(field.getType(), z)) {
            z3 = true;
            break;
        }
        List<d5.a> list = z ? eVar.f8743a : eVar.f8744b;
        if (!list.isEmpty()) {
            Iterator<d5.a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().b()) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        return !z3;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class d<T> extends b<T, T> {

        /* renamed from: b, reason: collision with root package name */
        public final f5.g<T> f9008b;

        public d(f5.g<T> gVar, e eVar) {
            super(eVar);
            this.f9008b = gVar;
        }

        @Override // g5.k.b
        public final T c() {
            return this.f9008b.c();
        }

        @Override // g5.k.b
        public final void e(T t8, k5.a aVar, c cVar) {
            cVar.b(aVar, t8);
        }

        @Override // g5.k.b
        public final T d(T t8) {
            return t8;
        }
    }
}
