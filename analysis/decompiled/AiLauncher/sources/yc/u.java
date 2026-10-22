package yc;

import e9.InterfaceC4014c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.C5528A;
import tb.u;
import tb.y;
import yc.q;

/* loaded from: classes5.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Class<?> f44432a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f44433b;

    /* renamed from: c, reason: collision with root package name */
    public final tb.v f44434c;

    /* renamed from: d, reason: collision with root package name */
    public final String f44435d;

    /* renamed from: e, reason: collision with root package name */
    public final String f44436e;

    /* renamed from: f, reason: collision with root package name */
    public final tb.u f44437f;

    /* renamed from: g, reason: collision with root package name */
    public final tb.x f44438g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f44439h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f44440i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f44441j;

    /* renamed from: k, reason: collision with root package name */
    public final q<?>[] f44442k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f44443l;

    public static final class a {

        /* renamed from: y, reason: collision with root package name */
        public static final Pattern f44444y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: z, reason: collision with root package name */
        public static final Pattern f44445z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        public final w f44446a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f44447b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f44448c;

        /* renamed from: d, reason: collision with root package name */
        public final Annotation[] f44449d;

        /* renamed from: e, reason: collision with root package name */
        public final Annotation[][] f44450e;

        /* renamed from: f, reason: collision with root package name */
        public final Type[] f44451f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f44452g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f44453h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f44454i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f44455j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f44456k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f44457l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f44458m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f44459n;

        /* renamed from: o, reason: collision with root package name */
        public String f44460o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f44461p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f44462q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f44463r;

        /* renamed from: s, reason: collision with root package name */
        public String f44464s;

        /* renamed from: t, reason: collision with root package name */
        public tb.u f44465t;

        /* renamed from: u, reason: collision with root package name */
        public tb.x f44466u;

        /* renamed from: v, reason: collision with root package name */
        public Set<String> f44467v;

        /* renamed from: w, reason: collision with root package name */
        public q<?>[] f44468w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f44469x;

        public a(w wVar, Class<?> cls, Method method) {
            this.f44446a = wVar;
            this.f44447b = cls;
            this.f44448c = method;
            this.f44449d = method.getAnnotations();
            this.f44451f = method.getGenericParameterTypes();
            this.f44450e = method.getParameterAnnotations();
        }

        public static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        public static Set<String> h(String str) {
            Matcher matcher = f44444y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        public u b() {
            for (Annotation annotation : this.f44449d) {
                e(annotation);
            }
            if (this.f44460o == null) {
                throw A.n(this.f44448c, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f44461p) {
                if (this.f44463r) {
                    throw A.n(this.f44448c, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f44462q) {
                    throw A.n(this.f44448c, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f44450e.length;
            this.f44468w = new q[length];
            int i10 = length - 1;
            int i11 = 0;
            while (i11 < length) {
                this.f44468w[i11] = f(i11, this.f44451f[i11], this.f44450e[i11], i11 == i10);
                i11++;
            }
            if (this.f44464s == null && !this.f44459n) {
                throw A.n(this.f44448c, "Missing either @%s URL or @Url parameter.", this.f44460o);
            }
            boolean z10 = this.f44462q;
            if (!z10 && !this.f44463r && !this.f44461p && this.f44454i) {
                throw A.n(this.f44448c, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z10 && !this.f44452g) {
                throw A.n(this.f44448c, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f44463r || this.f44453h) {
                return new u(this);
            }
            throw A.n(this.f44448c, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        public final tb.u c(String[] strArr, boolean z10) {
            u.a aVar = new u.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw A.n(this.f44448c, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f44466u = tb.x.e(strTrim);
                    } catch (IllegalArgumentException e10) {
                        throw A.o(this.f44448c, e10, "Malformed content type: %s", strTrim);
                    }
                } else if (z10) {
                    aVar.e(strSubstring, strTrim);
                } else {
                    aVar.a(strSubstring, strTrim);
                }
            }
            return aVar.f();
        }

        public final void d(String str, String str2, boolean z10) {
            String str3 = this.f44460o;
            if (str3 != null) {
                throw A.n(this.f44448c, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f44460o = str;
            this.f44461p = z10;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f44444y.matcher(strSubstring).find()) {
                    throw A.n(this.f44448c, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f44464s = str2;
            this.f44467v = h(str2);
        }

        public final void e(Annotation annotation) {
            if (annotation instanceof Ac.b) {
                d("DELETE", ((Ac.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof Ac.f) {
                d("GET", ((Ac.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof Ac.g) {
                d("HEAD", ((Ac.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof Ac.n) {
                d("PATCH", ((Ac.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof Ac.o) {
                d("POST", ((Ac.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof Ac.p) {
                d("PUT", ((Ac.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof Ac.m) {
                d("OPTIONS", ((Ac.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof Ac.h) {
                Ac.h hVar = (Ac.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof Ac.k) {
                Ac.k kVar = (Ac.k) annotation;
                String[] strArrValue = kVar.value();
                if (strArrValue.length == 0) {
                    throw A.n(this.f44448c, "@Headers annotation is empty.", new Object[0]);
                }
                this.f44465t = c(strArrValue, kVar.allowUnsafeNonAsciiValues());
                return;
            }
            if (annotation instanceof Ac.l) {
                if (this.f44462q) {
                    throw A.n(this.f44448c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f44463r = true;
            } else if (annotation instanceof Ac.e) {
                if (this.f44463r) {
                    throw A.n(this.f44448c, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f44462q = true;
            }
        }

        public final q<?> f(int i10, Type type, Annotation[] annotationArr, boolean z10) {
            q<?> qVar;
            if (annotationArr != null) {
                qVar = null;
                for (Annotation annotation : annotationArr) {
                    q<?> qVarG = g(i10, type, annotationArr, annotation);
                    if (qVarG != null) {
                        if (qVar != null) {
                            throw A.p(this.f44448c, i10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        qVar = qVarG;
                    }
                }
            } else {
                qVar = null;
            }
            if (qVar != null) {
                return qVar;
            }
            if (z10) {
                try {
                    if (A.h(type) == InterfaceC4014c.class) {
                        this.f44469x = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw A.p(this.f44448c, i10, "No Retrofit annotation found.", new Object[0]);
        }

        public final q<?> g(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof Ac.y) {
                j(i10, type);
                if (this.f44459n) {
                    throw A.p(this.f44448c, i10, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f44455j) {
                    throw A.p(this.f44448c, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f44456k) {
                    throw A.p(this.f44448c, i10, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f44457l) {
                    throw A.p(this.f44448c, i10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f44458m) {
                    throw A.p(this.f44448c, i10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f44464s != null) {
                    throw A.p(this.f44448c, i10, "@Url cannot be used with @%s URL", this.f44460o);
                }
                this.f44459n = true;
                if (type == tb.v.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new q.p(this.f44448c, i10);
                }
                throw A.p(this.f44448c, i10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof Ac.s) {
                j(i10, type);
                if (this.f44456k) {
                    throw A.p(this.f44448c, i10, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f44457l) {
                    throw A.p(this.f44448c, i10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f44458m) {
                    throw A.p(this.f44448c, i10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f44459n) {
                    throw A.p(this.f44448c, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f44464s == null) {
                    throw A.p(this.f44448c, i10, "@Path can only be used with relative url on @%s", this.f44460o);
                }
                this.f44455j = true;
                Ac.s sVar = (Ac.s) annotation;
                String strValue = sVar.value();
                i(i10, strValue);
                return new q.k(this.f44448c, i10, strValue, this.f44446a.k(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof Ac.t) {
                j(i10, type);
                Ac.t tVar = (Ac.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsH = A.h(type);
                this.f44456k = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    if (!clsH.isArray()) {
                        return new q.l(strValue2, this.f44446a.k(type, annotationArr), zEncoded);
                    }
                    return new q.l(strValue2, this.f44446a.k(a(clsH.getComponentType()), annotationArr), zEncoded).b();
                }
                if (type instanceof ParameterizedType) {
                    return new q.l(strValue2, this.f44446a.k(A.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw A.p(this.f44448c, i10, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof Ac.v) {
                j(i10, type);
                boolean zEncoded2 = ((Ac.v) annotation).encoded();
                Class<?> clsH2 = A.h(type);
                this.f44457l = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    if (!clsH2.isArray()) {
                        return new q.n(this.f44446a.k(type, annotationArr), zEncoded2);
                    }
                    return new q.n(this.f44446a.k(a(clsH2.getComponentType()), annotationArr), zEncoded2).b();
                }
                if (type instanceof ParameterizedType) {
                    return new q.n(this.f44446a.k(A.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw A.p(this.f44448c, i10, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof Ac.u) {
                j(i10, type);
                Class<?> clsH3 = A.h(type);
                this.f44458m = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw A.p(this.f44448c, i10, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = A.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw A.p(this.f44448c, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = A.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new q.m(this.f44448c, i10, this.f44446a.k(A.g(1, parameterizedType), annotationArr), ((Ac.u) annotation).encoded());
                }
                throw A.p(this.f44448c, i10, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof Ac.i) {
                j(i10, type);
                Ac.i iVar = (Ac.i) annotation;
                String strValue3 = iVar.value();
                Class<?> clsH4 = A.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    if (!clsH4.isArray()) {
                        return new q.f(strValue3, this.f44446a.k(type, annotationArr), iVar.allowUnsafeNonAsciiValues());
                    }
                    return new q.f(strValue3, this.f44446a.k(a(clsH4.getComponentType()), annotationArr), iVar.allowUnsafeNonAsciiValues()).b();
                }
                if (type instanceof ParameterizedType) {
                    return new q.f(strValue3, this.f44446a.k(A.g(0, (ParameterizedType) type), annotationArr), iVar.allowUnsafeNonAsciiValues()).c();
                }
                throw A.p(this.f44448c, i10, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof Ac.j) {
                if (type == tb.u.class) {
                    return new q.h(this.f44448c, i10);
                }
                j(i10, type);
                Class<?> clsH5 = A.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw A.p(this.f44448c, i10, "@HeaderMap parameter type must be Map or Headers.", new Object[0]);
                }
                Type typeI2 = A.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw A.p(this.f44448c, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = A.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new q.g(this.f44448c, i10, this.f44446a.k(A.g(1, parameterizedType2), annotationArr), ((Ac.j) annotation).allowUnsafeNonAsciiValues());
                }
                throw A.p(this.f44448c, i10, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof Ac.c) {
                j(i10, type);
                if (!this.f44462q) {
                    throw A.p(this.f44448c, i10, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                Ac.c cVar = (Ac.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f44452g = true;
                Class<?> clsH6 = A.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    if (!clsH6.isArray()) {
                        return new q.d(strValue4, this.f44446a.k(type, annotationArr), zEncoded3);
                    }
                    return new q.d(strValue4, this.f44446a.k(a(clsH6.getComponentType()), annotationArr), zEncoded3).b();
                }
                if (type instanceof ParameterizedType) {
                    return new q.d(strValue4, this.f44446a.k(A.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw A.p(this.f44448c, i10, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof Ac.d) {
                j(i10, type);
                if (!this.f44462q) {
                    throw A.p(this.f44448c, i10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsH7 = A.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw A.p(this.f44448c, i10, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = A.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw A.p(this.f44448c, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = A.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    h hVarK = this.f44446a.k(A.g(1, parameterizedType3), annotationArr);
                    this.f44452g = true;
                    return new q.e(this.f44448c, i10, hVarK, ((Ac.d) annotation).encoded());
                }
                throw A.p(this.f44448c, i10, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (!(annotation instanceof Ac.q)) {
                if (annotation instanceof Ac.r) {
                    j(i10, type);
                    if (!this.f44463r) {
                        throw A.p(this.f44448c, i10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                    }
                    this.f44453h = true;
                    Class<?> clsH8 = A.h(type);
                    if (!Map.class.isAssignableFrom(clsH8)) {
                        throw A.p(this.f44448c, i10, "@PartMap parameter type must be Map.", new Object[0]);
                    }
                    Type typeI4 = A.i(type, clsH8, Map.class);
                    if (!(typeI4 instanceof ParameterizedType)) {
                        throw A.p(this.f44448c, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                    Type typeG4 = A.g(0, parameterizedType4);
                    if (String.class == typeG4) {
                        Type typeG5 = A.g(1, parameterizedType4);
                        if (y.c.class.isAssignableFrom(A.h(typeG5))) {
                            throw A.p(this.f44448c, i10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                        }
                        return new q.j(this.f44448c, i10, this.f44446a.i(typeG5, annotationArr, this.f44449d), ((Ac.r) annotation).encoding());
                    }
                    throw A.p(this.f44448c, i10, "@PartMap keys must be of type String: " + typeG4, new Object[0]);
                }
                if (annotation instanceof Ac.a) {
                    j(i10, type);
                    if (this.f44462q || this.f44463r) {
                        throw A.p(this.f44448c, i10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.f44454i) {
                        throw A.p(this.f44448c, i10, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        h hVarI = this.f44446a.i(type, annotationArr, this.f44449d);
                        this.f44454i = true;
                        return new q.c(this.f44448c, i10, hVarI);
                    } catch (RuntimeException e10) {
                        throw A.q(this.f44448c, e10, i10, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!(annotation instanceof Ac.x)) {
                    return null;
                }
                j(i10, type);
                Class<?> clsA = a(A.h(type));
                for (int i11 = i10 - 1; i11 >= 0; i11--) {
                    q<?> qVar = this.f44468w[i11];
                    if ((qVar instanceof q.C0561q) && ((q.C0561q) qVar).f44413a.equals(clsA)) {
                        throw A.p(this.f44448c, i10, "@Tag type " + clsA.getName() + " is duplicate of " + r.f44415b.a(this.f44448c, i11) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new q.C0561q(clsA);
            }
            j(i10, type);
            if (!this.f44463r) {
                throw A.p(this.f44448c, i10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            Ac.q qVar2 = (Ac.q) annotation;
            this.f44453h = true;
            String strValue5 = qVar2.value();
            Class<?> clsH9 = A.h(type);
            if (strValue5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(clsH9)) {
                    if (clsH9.isArray()) {
                        if (y.c.class.isAssignableFrom(clsH9.getComponentType())) {
                            return q.o.f44410a.b();
                        }
                        throw A.p(this.f44448c, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (y.c.class.isAssignableFrom(clsH9)) {
                        return q.o.f44410a;
                    }
                    throw A.p(this.f44448c, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (y.c.class.isAssignableFrom(A.h(A.g(0, (ParameterizedType) type)))) {
                        return q.o.f44410a.c();
                    }
                    throw A.p(this.f44448c, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw A.p(this.f44448c, i10, clsH9.getSimpleName() + " must include generic type (e.g., " + clsH9.getSimpleName() + "<String>)", new Object[0]);
            }
            tb.u uVarJ = tb.u.j("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar2.encoding());
            if (!Iterable.class.isAssignableFrom(clsH9)) {
                if (!clsH9.isArray()) {
                    if (y.c.class.isAssignableFrom(clsH9)) {
                        throw A.p(this.f44448c, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new q.i(this.f44448c, i10, uVarJ, this.f44446a.i(type, annotationArr, this.f44449d));
                }
                Class<?> clsA2 = a(clsH9.getComponentType());
                if (y.c.class.isAssignableFrom(clsA2)) {
                    throw A.p(this.f44448c, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new q.i(this.f44448c, i10, uVarJ, this.f44446a.i(clsA2, annotationArr, this.f44449d)).b();
            }
            if (type instanceof ParameterizedType) {
                Type typeG6 = A.g(0, (ParameterizedType) type);
                if (y.c.class.isAssignableFrom(A.h(typeG6))) {
                    throw A.p(this.f44448c, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new q.i(this.f44448c, i10, uVarJ, this.f44446a.i(typeG6, annotationArr, this.f44449d)).c();
            }
            throw A.p(this.f44448c, i10, clsH9.getSimpleName() + " must include generic type (e.g., " + clsH9.getSimpleName() + "<String>)", new Object[0]);
        }

        public final void i(int i10, String str) {
            if (!f44445z.matcher(str).matches()) {
                throw A.p(this.f44448c, i10, "@Path parameter name must match %s. Found: %s", f44444y.pattern(), str);
            }
            if (!this.f44467v.contains(str)) {
                throw A.p(this.f44448c, i10, "URL \"%s\" does not contain \"{%s}\".", this.f44464s, str);
            }
        }

        public final void j(int i10, Type type) {
            if (A.j(type)) {
                throw A.p(this.f44448c, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public u(a aVar) {
        this.f44432a = aVar.f44447b;
        this.f44433b = aVar.f44448c;
        this.f44434c = aVar.f44446a.f44475c;
        this.f44435d = aVar.f44460o;
        this.f44436e = aVar.f44464s;
        this.f44437f = aVar.f44465t;
        this.f44438g = aVar.f44466u;
        this.f44439h = aVar.f44461p;
        this.f44440i = aVar.f44462q;
        this.f44441j = aVar.f44463r;
        this.f44442k = aVar.f44468w;
        this.f44443l = aVar.f44469x;
    }

    public static u b(w wVar, Class<?> cls, Method method) {
        return new a(wVar, cls, method).b();
    }

    public C5528A a(Object obj, Object[] objArr) throws IOException {
        q<?>[] qVarArr = this.f44442k;
        int length = objArr.length;
        if (length != qVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + qVarArr.length + ")");
        }
        t tVar = new t(this.f44435d, this.f44434c, this.f44436e, this.f44437f, this.f44438g, this.f44439h, this.f44440i, this.f44441j);
        if (this.f44443l) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(objArr[i10]);
            qVarArr[i10].a(tVar, objArr[i10]);
        }
        return tVar.k().r(n.class, new n(this.f44432a, obj, this.f44433b, arrayList)).b();
    }
}
