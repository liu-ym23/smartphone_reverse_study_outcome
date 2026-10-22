package d5;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.Strictness;
import com.google.gson.ToNumberPolicy;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import g5.p;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: k, reason: collision with root package name */
    public static final c f8354k = c.f8347d;

    /* renamed from: l, reason: collision with root package name */
    public static final b f8355l = FieldNamingPolicy.f5425a;

    /* renamed from: m, reason: collision with root package name */
    public static final t f8356m = ToNumberPolicy.f5438a;

    /* renamed from: n, reason: collision with root package name */
    public static final t f8357n = ToNumberPolicy.f5439b;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal<Map<TypeToken<?>, u<?>>> f8358a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f8359b;

    /* renamed from: c, reason: collision with root package name */
    public final f5.a f8360c;

    /* renamed from: d, reason: collision with root package name */
    public final g5.d f8361d;

    /* renamed from: e, reason: collision with root package name */
    public final List<v> f8362e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8363f;

    /* renamed from: g, reason: collision with root package name */
    public final c f8364g;
    public final List<v> h;

    /* renamed from: i, reason: collision with root package name */
    public final List<v> f8365i;

    /* renamed from: j, reason: collision with root package name */
    public final List<ReflectionAccessFilter> f8366j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<T> extends g5.m<T> {

        /* renamed from: a, reason: collision with root package name */
        public u<T> f8367a = null;

        @Override // d5.u
        public final T a(k5.a aVar) {
            u<T> uVar = this.f8367a;
            if (uVar != null) {
                return uVar.a(aVar);
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // d5.u
        public final void b(k5.b bVar, T t8) {
            u<T> uVar = this.f8367a;
            if (uVar == null) {
                throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
            }
            uVar.b(bVar, t8);
        }

        @Override // g5.m
        public final u<T> c() {
            u<T> uVar = this.f8367a;
            if (uVar != null) {
                return uVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i() {
        f5.e eVar = f5.e.f8742c;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this(eVar, f8355l, map, true, f8354k, true, LongSerializationPolicy.f5427a, list, list, list, f8356m, f8357n, list);
    }

    public static void a(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            throw new IllegalArgumentException(d8 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(Class cls, String str) {
        Object objC = c(str, TypeToken.get(cls));
        if (cls == Integer.TYPE) {
            cls = Integer.class;
        } else if (cls == Float.TYPE) {
            cls = Float.class;
        } else if (cls == Byte.TYPE) {
            cls = Byte.class;
        } else if (cls == Double.TYPE) {
            cls = Double.class;
        } else if (cls == Long.TYPE) {
            cls = Long.class;
        } else if (cls == Character.TYPE) {
            cls = Character.class;
        } else if (cls == Boolean.TYPE) {
            cls = Boolean.class;
        } else if (cls == Short.TYPE) {
            cls = Short.class;
        } else if (cls == Void.TYPE) {
            cls = Void.class;
        }
        return cls.cast(objC);
    }

    public final <T> T c(String str, TypeToken<T> typeToken) {
        if (str == null) {
            return null;
        }
        k5.a aVar = new k5.a(new StringReader(str));
        aVar.U0(Strictness.f5435b);
        T t8 = (T) d(aVar, typeToken);
        if (t8 != null) {
            try {
                if (aVar.R0() != JsonToken.f5479m) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            }
        }
        return t8;
    }

    public final <T> T d(k5.a aVar, TypeToken<T> typeToken) {
        boolean z;
        Strictness strictness = aVar.f9921b;
        if (strictness == Strictness.f5435b) {
            aVar.f9921b = Strictness.f5434a;
        }
        try {
            try {
                try {
                    aVar.R0();
                    z = false;
                    try {
                        return e(typeToken).a(aVar);
                    } catch (EOFException e10) {
                        e = e10;
                        if (!z) {
                            throw new JsonSyntaxException(e);
                        }
                        aVar.U0(strictness);
                        return null;
                    }
                } finally {
                    aVar.U0(strictness);
                }
            } catch (EOFException e11) {
                e = e11;
                z = true;
            }
        } catch (IOException e12) {
            throw new JsonSyntaxException(e12);
        } catch (AssertionError e13) {
            throw new AssertionError("AssertionError (GSON 2.11.0): " + e13.getMessage(), e13);
        } catch (IllegalStateException e14) {
            throw new JsonSyntaxException(e14);
        }
    }

    public final <T> u<T> e(TypeToken<T> typeToken) {
        boolean z;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f8359b;
        u<T> uVar = (u) concurrentHashMap.get(typeToken);
        if (uVar != null) {
            return uVar;
        }
        ThreadLocal<Map<TypeToken<?>, u<?>>> threadLocal = this.f8358a;
        Map<TypeToken<?>, u<?>> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
            z = true;
        } else {
            u<T> uVar2 = (u) map.get(typeToken);
            if (uVar2 != null) {
                return uVar2;
            }
            z = false;
        }
        try {
            a aVar = new a();
            map.put(typeToken, aVar);
            Iterator<v> it = this.f8362e.iterator();
            u<T> uVarB = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                uVarB = it.next().b(this, typeToken);
                if (uVarB != null) {
                    if (aVar.f8367a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    aVar.f8367a = uVarB;
                    map.put(typeToken, uVarB);
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (uVarB != null) {
                if (z) {
                    concurrentHashMap.putAll(map);
                }
                return uVarB;
            }
            throw new IllegalArgumentException("GSON (2.11.0) cannot handle " + typeToken);
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> d5.u<T> f(d5.v r6, com.google.gson.reflect.TypeToken<T> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "skipPast must not be null"
            java.util.Objects.requireNonNull(r6, r0)
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            g5.d r0 = r5.f8361d
            r0.getClass()
            java.util.concurrent.ConcurrentHashMap r1 = r0.f8980b
            g5.d$a r2 = g5.d.f8977c
            if (r6 != r2) goto L16
            goto L58
        L16:
            java.lang.Class r2 = r7.getRawType()
            java.lang.Object r3 = r1.get(r2)
            d5.v r3 = (d5.v) r3
            if (r3 == 0) goto L25
            if (r3 != r6) goto L59
            goto L58
        L25:
            java.lang.Class<e5.a> r3 = e5.a.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            e5.a r3 = (e5.a) r3
            if (r3 != 0) goto L30
            goto L59
        L30:
            java.lang.Class r3 = r3.value()
            java.lang.Class<d5.v> r4 = d5.v.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 != 0) goto L3d
            goto L59
        L3d:
            f5.a r4 = r0.f8979a
            com.google.gson.reflect.TypeToken r3 = com.google.gson.reflect.TypeToken.get(r3)
            f5.g r3 = r4.b(r3)
            java.lang.Object r3 = r3.c()
            d5.v r3 = (d5.v) r3
            java.lang.Object r1 = r1.putIfAbsent(r2, r3)
            d5.v r1 = (d5.v) r1
            if (r1 == 0) goto L56
            r3 = r1
        L56:
            if (r3 != r6) goto L59
        L58:
            r6 = r0
        L59:
            java.util.List<d5.v> r0 = r5.f8362e
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L60:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L79
            java.lang.Object r2 = r0.next()
            d5.v r2 = (d5.v) r2
            if (r1 != 0) goto L72
            if (r2 != r6) goto L60
            r1 = 1
            goto L60
        L72:
            d5.u r2 = r2.b(r5, r7)
            if (r2 == 0) goto L60
            return r2
        L79:
            if (r1 != 0) goto L80
            d5.u r5 = r5.e(r7)
            return r5
        L80:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "GSON cannot serialize or deserialize "
            r6.<init>(r0)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.i.f(d5.v, com.google.gson.reflect.TypeToken):d5.u");
    }

    public final k5.b g(Writer writer) {
        k5.b bVar = new k5.b(writer);
        bVar.x0(this.f8364g);
        bVar.f9943l = this.f8363f;
        bVar.C0(Strictness.f5435b);
        bVar.f9945n = false;
        return bVar;
    }

    public final String h(Object obj) {
        if (obj == null) {
            o oVar = p.f8382a;
            StringWriter stringWriter = new StringWriter();
            try {
                i(oVar, g(stringWriter));
                return stringWriter.toString();
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            j(obj, cls, g(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e11) {
            throw new JsonIOException(e11);
        }
    }

    public final void i(o oVar, k5.b bVar) {
        Strictness strictness = bVar.f9942k;
        boolean z = bVar.f9943l;
        boolean z3 = bVar.f9945n;
        bVar.f9943l = this.f8363f;
        bVar.f9945n = false;
        if (strictness == Strictness.f5435b) {
            bVar.f9942k = Strictness.f5434a;
        }
        try {
            try {
                g5.p.z.getClass();
                p.t.d(oVar, bVar);
                bVar.C0(strictness);
                bVar.f9943l = z;
                bVar.f9945n = z3;
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.11.0): " + e11.getMessage(), e11);
            }
        } catch (Throwable th) {
            bVar.C0(strictness);
            bVar.f9943l = z;
            bVar.f9945n = z3;
            throw th;
        }
    }

    public final void j(Object obj, Class cls, k5.b bVar) {
        u uVarE = e(TypeToken.get((Type) cls));
        Strictness strictness = bVar.f9942k;
        if (strictness == Strictness.f5435b) {
            bVar.f9942k = Strictness.f5434a;
        }
        boolean z = bVar.f9943l;
        boolean z3 = bVar.f9945n;
        bVar.f9943l = this.f8363f;
        bVar.f9945n = false;
        try {
            try {
                uVarE.b(bVar, obj);
            } catch (IOException e10) {
                throw new JsonIOException(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.11.0): " + e11.getMessage(), e11);
            }
        } finally {
            bVar.C0(strictness);
            bVar.f9943l = z;
            bVar.f9945n = z3;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f8362e + ",instanceCreators:" + this.f8360c + "}";
    }

    public i(f5.e eVar, b bVar, Map map, boolean z, c cVar, boolean z3, LongSerializationPolicy longSerializationPolicy, List list, List list2, List list3, t tVar, t tVar2, List list4) {
        g5.i iVar;
        u fVar;
        g5.g gVar;
        this.f8358a = new ThreadLocal<>();
        this.f8359b = new ConcurrentHashMap();
        f5.a aVar = new f5.a(map, z3, list4);
        this.f8360c = aVar;
        this.f8363f = z;
        this.f8364g = cVar;
        this.h = list;
        this.f8365i = list2;
        this.f8366j = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(g5.p.A);
        if (tVar == ToNumberPolicy.f5438a) {
            iVar = g5.j.f8996c;
        } else {
            iVar = new g5.i(tVar, 0);
        }
        arrayList.add(iVar);
        arrayList.add(eVar);
        arrayList.addAll(list3);
        arrayList.add(g5.p.f9049p);
        arrayList.add(g5.p.f9041g);
        arrayList.add(g5.p.f9038d);
        arrayList.add(g5.p.f9039e);
        arrayList.add(g5.p.f9040f);
        if (longSerializationPolicy == LongSerializationPolicy.f5427a) {
            fVar = g5.p.f9044k;
        } else {
            fVar = new f();
        }
        arrayList.add(new g5.s(Long.TYPE, Long.class, fVar));
        arrayList.add(new g5.s(Double.TYPE, Double.class, new d()));
        arrayList.add(new g5.s(Float.TYPE, Float.class, new e()));
        if (tVar2 == ToNumberPolicy.f5439b) {
            gVar = g5.h.f8992b;
        } else {
            gVar = new g5.g(new g5.h(tVar2));
        }
        arrayList.add(gVar);
        arrayList.add(g5.p.h);
        arrayList.add(g5.p.f9042i);
        arrayList.add(new g5.r(AtomicLong.class, new h(new g(fVar), 1)));
        arrayList.add(new g5.r(AtomicLongArray.class, new h(new h(fVar, 0), 1)));
        arrayList.add(g5.p.f9043j);
        arrayList.add(g5.p.f9045l);
        arrayList.add(g5.p.f9050q);
        arrayList.add(g5.p.r);
        arrayList.add(new g5.r(BigDecimal.class, g5.p.f9046m));
        arrayList.add(new g5.r(BigInteger.class, g5.p.f9047n));
        arrayList.add(new g5.r(LazilyParsedNumber.class, g5.p.f9048o));
        arrayList.add(g5.p.f9051s);
        arrayList.add(g5.p.f9052t);
        arrayList.add(g5.p.f9054v);
        arrayList.add(g5.p.f9055w);
        arrayList.add(g5.p.f9057y);
        arrayList.add(g5.p.f9053u);
        arrayList.add(g5.p.f9036b);
        arrayList.add(g5.c.f8972c);
        arrayList.add(g5.p.f9056x);
        if (j5.d.f9702a) {
            arrayList.add(j5.d.f9706e);
            arrayList.add(j5.d.f9705d);
            arrayList.add(j5.d.f9707f);
        }
        arrayList.add(g5.a.f8966c);
        arrayList.add(g5.p.f9035a);
        arrayList.add(new g5.b(aVar));
        arrayList.add(new g5.f(aVar));
        g5.d dVar = new g5.d(aVar);
        this.f8361d = dVar;
        arrayList.add(dVar);
        arrayList.add(g5.p.B);
        arrayList.add(new g5.k(aVar, bVar, eVar, dVar, list4));
        this.f8362e = Collections.unmodifiableList(arrayList);
    }
}
