package D1;

import A1.r;
import A1.t;
import A1.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class i implements u {

    /* renamed from: a, reason: collision with root package name */
    private final C1.c f1072a;

    /* renamed from: b, reason: collision with root package name */
    private final A1.d f1073b;

    /* renamed from: c, reason: collision with root package name */
    private final C1.d f1074c;

    /* renamed from: d, reason: collision with root package name */
    private final d f1075d;

    /* renamed from: e, reason: collision with root package name */
    private final F1.b f1076e = F1.b.a();

    class a extends c {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Field f1077d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f1078e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f1079f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ A1.e f1080g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.gson.reflect.a f1081h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f1082i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z5, boolean z6, Field field, boolean z7, t tVar, A1.e eVar, com.google.gson.reflect.a aVar, boolean z8) {
            super(str, z5, z6);
            this.f1077d = field;
            this.f1078e = z7;
            this.f1079f = tVar;
            this.f1080g = eVar;
            this.f1081h = aVar;
            this.f1082i = z8;
        }

        @Override // D1.i.c
        void a(G1.a aVar, Object obj) throws IllegalAccessException, IllegalArgumentException {
            Object objB = this.f1079f.b(aVar);
            if (objB == null && this.f1082i) {
                return;
            }
            this.f1077d.set(obj, objB);
        }

        @Override // D1.i.c
        void b(G1.c cVar, Object obj) throws IllegalAccessException, IllegalArgumentException {
            (this.f1078e ? this.f1079f : new m(this.f1080g, this.f1079f, this.f1081h.getType())).d(cVar, this.f1077d.get(obj));
        }

        @Override // D1.i.c
        public boolean c(Object obj) {
            return this.f1087b && this.f1077d.get(obj) != obj;
        }
    }

    public static final class b<T> extends t<T> {

        /* renamed from: a, reason: collision with root package name */
        private final C1.i<T> f1084a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, c> f1085b;

        b(C1.i<T> iVar, Map<String, c> map) {
            this.f1084a = iVar;
            this.f1085b = map;
        }

        @Override // A1.t
        public T b(G1.a aVar) throws IOException {
            if (aVar.V() == G1.b.NULL) {
                aVar.O();
                return null;
            }
            T tA = this.f1084a.a();
            try {
                aVar.c();
                while (aVar.w()) {
                    c cVar = this.f1085b.get(aVar.L());
                    if (cVar == null || !cVar.f1088c) {
                        aVar.m0();
                    } else {
                        cVar.a(aVar, tA);
                    }
                }
                aVar.u();
                return tA;
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (IllegalStateException e7) {
                throw new r(e7);
            }
        }

        @Override // A1.t
        public void d(G1.c cVar, T t5) throws IOException {
            if (t5 == null) {
                cVar.D();
                return;
            }
            cVar.m();
            try {
                for (c cVar2 : this.f1085b.values()) {
                    if (cVar2.c(t5)) {
                        cVar.A(cVar2.f1086a);
                        cVar2.b(cVar, t5);
                    }
                }
                cVar.u();
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            }
        }
    }

    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String f1086a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f1087b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f1088c;

        protected c(String str, boolean z5, boolean z6) {
            this.f1086a = str;
            this.f1087b = z5;
            this.f1088c = z6;
        }

        abstract void a(G1.a aVar, Object obj);

        abstract void b(G1.c cVar, Object obj);

        abstract boolean c(Object obj);
    }

    public i(C1.c cVar, A1.d dVar, C1.d dVar2, d dVar3) {
        this.f1072a = cVar;
        this.f1073b = dVar;
        this.f1074c = dVar2;
        this.f1075d = dVar3;
    }

    private c a(A1.e eVar, Field field, String str, com.google.gson.reflect.a<?> aVar, boolean z5, boolean z6) {
        boolean zB = C1.k.b(aVar.getRawType());
        B1.b bVar = (B1.b) field.getAnnotation(B1.b.class);
        t<?> tVarA = bVar != null ? this.f1075d.a(this.f1072a, eVar, aVar, bVar) : null;
        boolean z7 = tVarA != null;
        if (tVarA == null) {
            tVarA = eVar.k(aVar);
        }
        return new a(str, z5, z6, field, z7, tVarA, eVar, aVar, zB);
    }

    static boolean d(Field field, boolean z5, C1.d dVar) {
        return (dVar.e(field.getType(), z5) || dVar.i(field, z5)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    private Map<String, c> e(A1.e eVar, com.google.gson.reflect.a<?> aVar, Class<?> cls) {
        com.google.gson.reflect.a<?> aVar2;
        i iVar = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cls.isInterface()) {
            Type type = aVar.getType();
            com.google.gson.reflect.a<?> aVar3 = aVar;
            Class<?> rawType = cls;
            while (rawType != Object.class) {
                Field[] declaredFields = rawType.getDeclaredFields();
                int length = declaredFields.length;
                boolean z5 = false;
                int i5 = 0;
                i iVar2 = iVar;
                while (i5 < length) {
                    Field field = declaredFields[i5];
                    boolean zC = iVar2.c(field, true);
                    boolean zC2 = iVar2.c(field, z5);
                    if (zC || zC2) {
                        iVar2.f1076e.b(field);
                        Type typeP = C1.b.p(aVar3.getType(), rawType, field.getGenericType());
                        List<String> listF = iVar2.f(field);
                        int size = listF.size();
                        c cVar = null;
                        i iVar3 = iVar2;
                        for (?? r13 = z5; r13 < size; r13++) {
                            String str = listF.get(r13);
                            if (r13 != 0) {
                                zC = false;
                            }
                            int i6 = size;
                            List<String> list = listF;
                            com.google.gson.reflect.a<?> aVar4 = aVar3;
                            c cVar2 = cVar;
                            boolean z6 = zC;
                            c cVar3 = (c) linkedHashMap.put(str, iVar3.a(eVar, field, str, com.google.gson.reflect.a.get(typeP), z6, zC2));
                            if (cVar2 != null) {
                                cVar3 = cVar2;
                            }
                            aVar3 = aVar4;
                            zC = z6;
                            listF = list;
                            size = i6;
                            cVar = cVar3;
                            iVar3 = this;
                        }
                        aVar2 = aVar3;
                        c cVar4 = cVar;
                        if (cVar4 != null) {
                            throw new IllegalArgumentException(type + " declares multiple JSON fields named " + cVar4.f1086a);
                        }
                    } else {
                        aVar2 = aVar3;
                    }
                    i5++;
                    z5 = false;
                    iVar2 = this;
                    aVar3 = aVar2;
                }
                aVar3 = com.google.gson.reflect.a.get(C1.b.p(aVar3.getType(), rawType, rawType.getGenericSuperclass()));
                rawType = aVar3.getRawType();
                iVar = this;
            }
        }
        return linkedHashMap;
    }

    private List<String> f(Field field) {
        B1.c cVar = (B1.c) field.getAnnotation(B1.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f1073b.b(field));
        }
        String strValue = cVar.value();
        String[] strArrAlternate = cVar.alternate();
        if (strArrAlternate.length == 0) {
            return Collections.singletonList(strValue);
        }
        ArrayList arrayList = new ArrayList(strArrAlternate.length + 1);
        arrayList.add(strValue);
        for (String str : strArrAlternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // A1.u
    public <T> t<T> b(A1.e eVar, com.google.gson.reflect.a<T> aVar) {
        Class<? super T> rawType = aVar.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new b(this.f1072a.a(aVar), e(eVar, aVar, rawType));
        }
        return null;
    }

    public boolean c(Field field, boolean z5) {
        return d(field, z5, this.f1074c);
    }
}
