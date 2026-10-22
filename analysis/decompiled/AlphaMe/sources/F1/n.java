package F1;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
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

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f438a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f439b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.g f440c;

    /* renamed from: d, reason: collision with root package name */
    public final H1.d f441d;

    /* renamed from: e, reason: collision with root package name */
    public final List f442e;

    /* renamed from: f, reason: collision with root package name */
    public final Map f443f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f444g;

    /* renamed from: h, reason: collision with root package name */
    public final List f445h;

    /* renamed from: i, reason: collision with root package name */
    public final List f446i;

    /* renamed from: j, reason: collision with root package name */
    public final List f447j;

    public n() {
        G1.g gVar = G1.g.f599c;
        Map mapEmptyMap = Collections.emptyMap();
        List listEmptyList = Collections.emptyList();
        List listEmptyList2 = Collections.emptyList();
        List listEmptyList3 = Collections.emptyList();
        List listEmptyList4 = Collections.emptyList();
        this.f438a = new ThreadLocal();
        this.f439b = new ConcurrentHashMap();
        this.f443f = mapEmptyMap;
        l1.g gVar2 = new l1.g(mapEmptyMap, listEmptyList4);
        this.f440c = gVar2;
        int i4 = 1;
        this.f444g = true;
        this.f445h = listEmptyList;
        this.f446i = listEmptyList2;
        this.f447j = listEmptyList4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(H1.z.f774A);
        arrayList.add(H1.n.f734c);
        arrayList.add(gVar);
        arrayList.addAll(listEmptyList3);
        arrayList.add(H1.z.f791p);
        arrayList.add(H1.z.f782g);
        arrayList.add(H1.z.f779d);
        arrayList.add(H1.z.f780e);
        arrayList.add(H1.z.f781f);
        k kVar = H1.z.f786k;
        arrayList.add(H1.z.b(Long.TYPE, Long.class, kVar));
        int i5 = 0;
        arrayList.add(H1.z.b(Double.TYPE, Double.class, new j(0)));
        arrayList.add(H1.z.b(Float.TYPE, Float.class, new j(1)));
        arrayList.add(H1.l.f731b);
        arrayList.add(H1.z.f783h);
        arrayList.add(H1.z.f784i);
        arrayList.add(H1.z.a(AtomicLong.class, new l(kVar, 0).a()));
        arrayList.add(H1.z.a(AtomicLongArray.class, new l(kVar, 1).a()));
        arrayList.add(H1.z.f785j);
        arrayList.add(H1.z.f787l);
        arrayList.add(H1.z.f792q);
        arrayList.add(H1.z.f793r);
        arrayList.add(H1.z.a(BigDecimal.class, H1.z.f788m));
        arrayList.add(H1.z.a(BigInteger.class, H1.z.f789n));
        arrayList.add(H1.z.a(G1.j.class, H1.z.f790o));
        arrayList.add(H1.z.f794s);
        arrayList.add(H1.z.f795t);
        arrayList.add(H1.z.f797v);
        arrayList.add(H1.z.f798w);
        arrayList.add(H1.z.f800y);
        arrayList.add(H1.z.f796u);
        arrayList.add(H1.z.f777b);
        arrayList.add(H1.e.f715b);
        arrayList.add(H1.z.f799x);
        if (K1.d.f1038a) {
            arrayList.add(K1.d.f1040c);
            arrayList.add(K1.d.f1039b);
            arrayList.add(K1.d.f1041d);
        }
        arrayList.add(H1.b.f707c);
        arrayList.add(H1.z.f776a);
        arrayList.add(new H1.d(gVar2, i5));
        arrayList.add(new H1.i(gVar2));
        H1.d dVar = new H1.d(gVar2, i4);
        this.f441d = dVar;
        arrayList.add(dVar);
        arrayList.add(H1.z.f775B);
        arrayList.add(new H1.s(gVar2, gVar, dVar, listEmptyList4));
        this.f442e = Collections.unmodifiableList(arrayList);
    }

    public static void a(double d4) {
        if (Double.isNaN(d4) || Double.isInfinite(d4)) {
            throw new IllegalArgumentException(d4 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
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

    /* JADX WARN: Removed duplicated region for block: B:52:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.String r7, com.google.gson.reflect.TypeToken r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            java.io.StringReader r1 = new java.io.StringReader
            r1.<init>(r7)
            com.google.gson.stream.JsonReader r7 = new com.google.gson.stream.JsonReader
            r7.<init>(r1)
            r1 = 0
            r7.setLenient(r1)
            java.lang.String r2 = "AssertionError (GSON 2.10.1): "
            boolean r3 = r7.isLenient()
            r4 = 1
            r7.setLenient(r4)
            r5 = 5
            r7.peek()     // Catch: java.lang.Throwable -> L2c java.lang.AssertionError -> L2e java.io.IOException -> L30 java.lang.IllegalStateException -> L32 java.io.EOFException -> L58
            F1.A r6 = r6.e(r8)     // Catch: java.lang.Throwable -> L2c java.lang.AssertionError -> L2e java.io.IOException -> L30 java.lang.IllegalStateException -> L32 java.io.EOFException -> L34
            java.lang.Object r0 = r6.b(r7)     // Catch: java.lang.Throwable -> L2c java.lang.AssertionError -> L2e java.io.IOException -> L30 java.lang.IllegalStateException -> L32 java.io.EOFException -> L34
        L28:
            r7.setLenient(r3)
            goto L5d
        L2c:
            r6 = move-exception
            goto L87
        L2e:
            r6 = move-exception
            goto L36
        L30:
            r6 = move-exception
            goto L4c
        L32:
            r6 = move-exception
            goto L52
        L34:
            r6 = move-exception
            goto L5a
        L36:
            java.lang.AssertionError r8 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L2c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2c
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r1 = r6.getMessage()     // Catch: java.lang.Throwable -> L2c
            r0.append(r1)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L2c
            r8.<init>(r0, r6)     // Catch: java.lang.Throwable -> L2c
            throw r8     // Catch: java.lang.Throwable -> L2c
        L4c:
            F1.q r8 = new F1.q     // Catch: java.lang.Throwable -> L2c
            r8.<init>(r5, r6)     // Catch: java.lang.Throwable -> L2c
            throw r8     // Catch: java.lang.Throwable -> L2c
        L52:
            F1.q r8 = new F1.q     // Catch: java.lang.Throwable -> L2c
            r8.<init>(r5, r6)     // Catch: java.lang.Throwable -> L2c
            throw r8     // Catch: java.lang.Throwable -> L2c
        L58:
            r6 = move-exception
            r1 = r4
        L5a:
            if (r1 == 0) goto L81
            goto L28
        L5d:
            if (r0 == 0) goto L80
            com.google.gson.stream.JsonToken r6 = r7.peek()     // Catch: java.io.IOException -> L70 com.google.gson.stream.MalformedJsonException -> L72
            com.google.gson.stream.JsonToken r7 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L70 com.google.gson.stream.MalformedJsonException -> L72
            if (r6 != r7) goto L68
            goto L80
        L68:
            F1.q r6 = new F1.q     // Catch: java.io.IOException -> L70 com.google.gson.stream.MalformedJsonException -> L72
            java.lang.String r7 = "JSON document was not fully consumed."
            r6.<init>(r7, r5)     // Catch: java.io.IOException -> L70 com.google.gson.stream.MalformedJsonException -> L72
            throw r6     // Catch: java.io.IOException -> L70 com.google.gson.stream.MalformedJsonException -> L72
        L70:
            r6 = move-exception
            goto L74
        L72:
            r6 = move-exception
            goto L7a
        L74:
            F1.q r7 = new F1.q
            r7.<init>(r5, r6)
            throw r7
        L7a:
            F1.q r7 = new F1.q
            r7.<init>(r5, r6)
            throw r7
        L80:
            return r0
        L81:
            F1.q r8 = new F1.q     // Catch: java.lang.Throwable -> L2c
            r8.<init>(r5, r6)     // Catch: java.lang.Throwable -> L2c
            throw r8     // Catch: java.lang.Throwable -> L2c
        L87:
            r7.setLenient(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: F1.n.c(java.lang.String, com.google.gson.reflect.TypeToken):java.lang.Object");
    }

    public final Object d(String str, Type type) {
        return c(str, TypeToken.get(type));
    }

    public final A e(TypeToken typeToken) {
        boolean z4;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f439b;
        A a4 = (A) concurrentHashMap.get(typeToken);
        if (a4 != null) {
            return a4;
        }
        ThreadLocal threadLocal = this.f438a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z4 = true;
        } else {
            A a5 = (A) map.get(typeToken);
            if (a5 != null) {
                return a5;
            }
            z4 = false;
        }
        try {
            m mVar = new m();
            A a6 = null;
            mVar.f437a = null;
            map.put(typeToken, mVar);
            Iterator it = this.f442e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a6 = ((B) it.next()).a(this, typeToken);
                if (a6 != null) {
                    if (mVar.f437a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    mVar.f437a = a6;
                    map.put(typeToken, a6);
                }
            }
            if (z4) {
                threadLocal.remove();
            }
            if (a6 != null) {
                if (z4) {
                    concurrentHashMap.putAll(map);
                }
                return a6;
            }
            throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + typeToken);
        } catch (Throwable th) {
            if (z4) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    public final JsonWriter f(Writer writer) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.setHtmlSafe(this.f444g);
        jsonWriter.setLenient(false);
        jsonWriter.setSerializeNulls(false);
        return jsonWriter;
    }

    public final String g(Object obj) {
        if (obj == null) {
            StringWriter stringWriter = new StringWriter();
            try {
                h(f(stringWriter));
                return stringWriter.toString();
            } catch (IOException e4) {
                throw new q(5, e4);
            }
        }
        Class cls = obj.getClass();
        StringWriter stringWriter2 = new StringWriter();
        try {
            i(obj, cls, f(stringWriter2));
            return stringWriter2.toString();
        } catch (IOException e5) {
            throw new q(5, e5);
        }
    }

    public final void h(JsonWriter jsonWriter) {
        r rVar = r.f449a;
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f444g);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(false);
        try {
            try {
                com.airbnb.lottie.h.L(rVar, jsonWriter);
            } catch (IOException e4) {
                throw new q(5, e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e5.getMessage(), e5);
            }
        } finally {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public final void i(Object obj, Class cls, JsonWriter jsonWriter) {
        A aE = e(TypeToken.get((Type) cls));
        boolean zIsLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean zIsHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.f444g);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(false);
        try {
            try {
                aE.c(jsonWriter, obj);
            } catch (IOException e4) {
                throw new q(5, e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.10.1): " + e5.getMessage(), e5);
            }
        } finally {
            jsonWriter.setLenient(zIsLenient);
            jsonWriter.setHtmlSafe(zIsHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f442e + ",instanceCreators:" + this.f440c + "}";
    }
}
