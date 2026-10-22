package R4;

import C4.D;
import C4.v;
import C4.z;
import R4.p;
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
import javax.annotation.Nullable;

/* loaded from: classes.dex */
final class s {

    /* renamed from: a, reason: collision with root package name */
    private final Method f5127a;

    /* renamed from: b, reason: collision with root package name */
    private final C4.w f5128b;

    /* renamed from: c, reason: collision with root package name */
    final String f5129c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f5130d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private final C4.v f5131e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private final C4.y f5132f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5133g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f5134h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f5135i;

    /* renamed from: j, reason: collision with root package name */
    private final p<?>[] f5136j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f5137k;

    static final class a {

        /* renamed from: x, reason: collision with root package name */
        private static final Pattern f5138x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: y, reason: collision with root package name */
        private static final Pattern f5139y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        final u f5140a;

        /* renamed from: b, reason: collision with root package name */
        final Method f5141b;

        /* renamed from: c, reason: collision with root package name */
        final Annotation[] f5142c;

        /* renamed from: d, reason: collision with root package name */
        final Annotation[][] f5143d;

        /* renamed from: e, reason: collision with root package name */
        final Type[] f5144e;

        /* renamed from: f, reason: collision with root package name */
        boolean f5145f;

        /* renamed from: g, reason: collision with root package name */
        boolean f5146g;

        /* renamed from: h, reason: collision with root package name */
        boolean f5147h;

        /* renamed from: i, reason: collision with root package name */
        boolean f5148i;

        /* renamed from: j, reason: collision with root package name */
        boolean f5149j;

        /* renamed from: k, reason: collision with root package name */
        boolean f5150k;

        /* renamed from: l, reason: collision with root package name */
        boolean f5151l;

        /* renamed from: m, reason: collision with root package name */
        boolean f5152m;

        /* renamed from: n, reason: collision with root package name */
        @Nullable
        String f5153n;

        /* renamed from: o, reason: collision with root package name */
        boolean f5154o;

        /* renamed from: p, reason: collision with root package name */
        boolean f5155p;

        /* renamed from: q, reason: collision with root package name */
        boolean f5156q;

        /* renamed from: r, reason: collision with root package name */
        @Nullable
        String f5157r;

        /* renamed from: s, reason: collision with root package name */
        @Nullable
        C4.v f5158s;

        /* renamed from: t, reason: collision with root package name */
        @Nullable
        C4.y f5159t;

        /* renamed from: u, reason: collision with root package name */
        @Nullable
        Set<String> f5160u;

        /* renamed from: v, reason: collision with root package name */
        @Nullable
        p<?>[] f5161v;

        /* renamed from: w, reason: collision with root package name */
        boolean f5162w;

        a(u uVar, Method method) {
            this.f5140a = uVar;
            this.f5141b = method;
            this.f5142c = method.getAnnotations();
            this.f5144e = method.getGenericParameterTypes();
            this.f5143d = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        private C4.v c(String[] strArr) {
            v.a aVar = new v.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw y.m(this.f5141b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f5159t = C4.y.b(strTrim);
                    } catch (IllegalArgumentException e6) {
                        throw y.n(this.f5141b, e6, "Malformed content type: %s", strTrim);
                    }
                } else {
                    aVar.a(strSubstring, strTrim);
                }
            }
            return aVar.e();
        }

        private void d(String str, String str2, boolean z5) {
            String str3 = this.f5153n;
            if (str3 != null) {
                throw y.m(this.f5141b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f5153n = str;
            this.f5154o = z5;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f5138x.matcher(strSubstring).find()) {
                    throw y.m(this.f5141b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f5157r = str2;
            this.f5160u = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof U4.b) {
                d("DELETE", ((U4.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof U4.f) {
                d("GET", ((U4.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof U4.g) {
                d("HEAD", ((U4.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof U4.n) {
                d("PATCH", ((U4.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof U4.o) {
                d("POST", ((U4.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof U4.p) {
                d("PUT", ((U4.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof U4.m) {
                d("OPTIONS", ((U4.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof U4.h) {
                U4.h hVar = (U4.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof U4.k) {
                String[] strArrValue = ((U4.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw y.m(this.f5141b, "@Headers annotation is empty.", new Object[0]);
                }
                this.f5158s = c(strArrValue);
                return;
            }
            if (annotation instanceof U4.l) {
                if (this.f5155p) {
                    throw y.m(this.f5141b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f5156q = true;
            } else if (annotation instanceof U4.e) {
                if (this.f5156q) {
                    throw y.m(this.f5141b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f5155p = true;
            }
        }

        @Nullable
        private p<?> f(int i5, Type type, @Nullable Annotation[] annotationArr, boolean z5) {
            p<?> pVar;
            if (annotationArr != null) {
                pVar = null;
                for (Annotation annotation : annotationArr) {
                    p<?> pVarG = g(i5, type, annotationArr, annotation);
                    if (pVarG != null) {
                        if (pVar != null) {
                            throw y.o(this.f5141b, i5, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        pVar = pVarG;
                    }
                }
            } else {
                pVar = null;
            }
            if (pVar != null) {
                return pVar;
            }
            if (z5) {
                try {
                    if (y.h(type) == Z3.e.class) {
                        this.f5162w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw y.o(this.f5141b, i5, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private p<?> g(int i5, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof U4.y) {
                j(i5, type);
                if (this.f5152m) {
                    throw y.o(this.f5141b, i5, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f5148i) {
                    throw y.o(this.f5141b, i5, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f5149j) {
                    throw y.o(this.f5141b, i5, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f5150k) {
                    throw y.o(this.f5141b, i5, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f5151l) {
                    throw y.o(this.f5141b, i5, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f5157r != null) {
                    throw y.o(this.f5141b, i5, "@Url cannot be used with @%s URL", this.f5153n);
                }
                this.f5152m = true;
                if (type == C4.w.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new p.C0077p(this.f5141b, i5);
                }
                throw y.o(this.f5141b, i5, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof U4.s) {
                j(i5, type);
                if (this.f5149j) {
                    throw y.o(this.f5141b, i5, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f5150k) {
                    throw y.o(this.f5141b, i5, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f5151l) {
                    throw y.o(this.f5141b, i5, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f5152m) {
                    throw y.o(this.f5141b, i5, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f5157r == null) {
                    throw y.o(this.f5141b, i5, "@Path can only be used with relative url on @%s", this.f5153n);
                }
                this.f5148i = true;
                U4.s sVar = (U4.s) annotation;
                String strValue = sVar.value();
                i(i5, strValue);
                return new p.k(this.f5141b, i5, strValue, this.f5140a.j(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof U4.t) {
                j(i5, type);
                U4.t tVar = (U4.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsH = y.h(type);
                this.f5149j = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    if (!clsH.isArray()) {
                        return new p.l(strValue2, this.f5140a.j(type, annotationArr), zEncoded);
                    }
                    return new p.l(strValue2, this.f5140a.j(a(clsH.getComponentType()), annotationArr), zEncoded).b();
                }
                if (type instanceof ParameterizedType) {
                    return new p.l(strValue2, this.f5140a.j(y.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw y.o(this.f5141b, i5, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof U4.v) {
                j(i5, type);
                boolean zEncoded2 = ((U4.v) annotation).encoded();
                Class<?> clsH2 = y.h(type);
                this.f5150k = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    if (!clsH2.isArray()) {
                        return new p.n(this.f5140a.j(type, annotationArr), zEncoded2);
                    }
                    return new p.n(this.f5140a.j(a(clsH2.getComponentType()), annotationArr), zEncoded2).b();
                }
                if (type instanceof ParameterizedType) {
                    return new p.n(this.f5140a.j(y.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw y.o(this.f5141b, i5, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof U4.u) {
                j(i5, type);
                Class<?> clsH3 = y.h(type);
                this.f5151l = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw y.o(this.f5141b, i5, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = y.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw y.o(this.f5141b, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = y.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new p.m(this.f5141b, i5, this.f5140a.j(y.g(1, parameterizedType), annotationArr), ((U4.u) annotation).encoded());
                }
                throw y.o(this.f5141b, i5, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof U4.i) {
                j(i5, type);
                String strValue3 = ((U4.i) annotation).value();
                Class<?> clsH4 = y.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    if (!clsH4.isArray()) {
                        return new p.f(strValue3, this.f5140a.j(type, annotationArr));
                    }
                    return new p.f(strValue3, this.f5140a.j(a(clsH4.getComponentType()), annotationArr)).b();
                }
                if (type instanceof ParameterizedType) {
                    return new p.f(strValue3, this.f5140a.j(y.g(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw y.o(this.f5141b, i5, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof U4.j) {
                if (type == C4.v.class) {
                    return new p.h(this.f5141b, i5);
                }
                j(i5, type);
                Class<?> clsH5 = y.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw y.o(this.f5141b, i5, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeI2 = y.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw y.o(this.f5141b, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = y.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new p.g(this.f5141b, i5, this.f5140a.j(y.g(1, parameterizedType2), annotationArr));
                }
                throw y.o(this.f5141b, i5, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof U4.c) {
                j(i5, type);
                if (!this.f5155p) {
                    throw y.o(this.f5141b, i5, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                U4.c cVar = (U4.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f5145f = true;
                Class<?> clsH6 = y.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    if (!clsH6.isArray()) {
                        return new p.d(strValue4, this.f5140a.j(type, annotationArr), zEncoded3);
                    }
                    return new p.d(strValue4, this.f5140a.j(a(clsH6.getComponentType()), annotationArr), zEncoded3).b();
                }
                if (type instanceof ParameterizedType) {
                    return new p.d(strValue4, this.f5140a.j(y.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw y.o(this.f5141b, i5, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof U4.d) {
                j(i5, type);
                if (!this.f5155p) {
                    throw y.o(this.f5141b, i5, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsH7 = y.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw y.o(this.f5141b, i5, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = y.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw y.o(this.f5141b, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = y.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    f fVarJ = this.f5140a.j(y.g(1, parameterizedType3), annotationArr);
                    this.f5145f = true;
                    return new p.e(this.f5141b, i5, fVarJ, ((U4.d) annotation).encoded());
                }
                throw y.o(this.f5141b, i5, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (!(annotation instanceof U4.q)) {
                if (annotation instanceof U4.r) {
                    j(i5, type);
                    if (!this.f5156q) {
                        throw y.o(this.f5141b, i5, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                    }
                    this.f5146g = true;
                    Class<?> clsH8 = y.h(type);
                    if (!Map.class.isAssignableFrom(clsH8)) {
                        throw y.o(this.f5141b, i5, "@PartMap parameter type must be Map.", new Object[0]);
                    }
                    Type typeI4 = y.i(type, clsH8, Map.class);
                    if (!(typeI4 instanceof ParameterizedType)) {
                        throw y.o(this.f5141b, i5, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                    }
                    ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                    Type typeG4 = y.g(0, parameterizedType4);
                    if (String.class == typeG4) {
                        Type typeG5 = y.g(1, parameterizedType4);
                        if (z.b.class.isAssignableFrom(y.h(typeG5))) {
                            throw y.o(this.f5141b, i5, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                        }
                        return new p.j(this.f5141b, i5, this.f5140a.h(typeG5, annotationArr, this.f5142c), ((U4.r) annotation).encoding());
                    }
                    throw y.o(this.f5141b, i5, "@PartMap keys must be of type String: " + typeG4, new Object[0]);
                }
                if (annotation instanceof U4.a) {
                    j(i5, type);
                    if (this.f5155p || this.f5156q) {
                        throw y.o(this.f5141b, i5, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                    }
                    if (this.f5147h) {
                        throw y.o(this.f5141b, i5, "Multiple @Body method annotations found.", new Object[0]);
                    }
                    try {
                        f fVarH = this.f5140a.h(type, annotationArr, this.f5142c);
                        this.f5147h = true;
                        return new p.c(this.f5141b, i5, fVarH);
                    } catch (RuntimeException e6) {
                        throw y.p(this.f5141b, e6, i5, "Unable to create @Body converter for %s", type);
                    }
                }
                if (!(annotation instanceof U4.x)) {
                    return null;
                }
                j(i5, type);
                Class<?> clsH9 = y.h(type);
                for (int i6 = i5 - 1; i6 >= 0; i6--) {
                    p<?> pVar = this.f5161v[i6];
                    if ((pVar instanceof p.q) && ((p.q) pVar).f5107a.equals(clsH9)) {
                        throw y.o(this.f5141b, i5, "@Tag type " + clsH9.getName() + " is duplicate of parameter #" + (i6 + 1) + " and would always overwrite its value.", new Object[0]);
                    }
                }
                return new p.q(clsH9);
            }
            j(i5, type);
            if (!this.f5156q) {
                throw y.o(this.f5141b, i5, "@Part parameters can only be used with multipart encoding.", new Object[0]);
            }
            U4.q qVar = (U4.q) annotation;
            this.f5146g = true;
            String strValue5 = qVar.value();
            Class<?> clsH10 = y.h(type);
            if (strValue5.isEmpty()) {
                if (!Iterable.class.isAssignableFrom(clsH10)) {
                    if (clsH10.isArray()) {
                        if (z.b.class.isAssignableFrom(clsH10.getComponentType())) {
                            return p.o.f5104a.b();
                        }
                        throw y.o(this.f5141b, i5, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (z.b.class.isAssignableFrom(clsH10)) {
                        return p.o.f5104a;
                    }
                    throw y.o(this.f5141b, i5, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                if (type instanceof ParameterizedType) {
                    if (z.b.class.isAssignableFrom(y.h(y.g(0, (ParameterizedType) type)))) {
                        return p.o.f5104a.c();
                    }
                    throw y.o(this.f5141b, i5, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                throw y.o(this.f5141b, i5, clsH10.getSimpleName() + " must include generic type (e.g., " + clsH10.getSimpleName() + "<String>)", new Object[0]);
            }
            C4.v vVarG = C4.v.g("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
            if (!Iterable.class.isAssignableFrom(clsH10)) {
                if (!clsH10.isArray()) {
                    if (z.b.class.isAssignableFrom(clsH10)) {
                        throw y.o(this.f5141b, i5, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new p.i(this.f5141b, i5, vVarG, this.f5140a.h(type, annotationArr, this.f5142c));
                }
                Class<?> clsA = a(clsH10.getComponentType());
                if (z.b.class.isAssignableFrom(clsA)) {
                    throw y.o(this.f5141b, i5, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new p.i(this.f5141b, i5, vVarG, this.f5140a.h(clsA, annotationArr, this.f5142c)).b();
            }
            if (type instanceof ParameterizedType) {
                Type typeG6 = y.g(0, (ParameterizedType) type);
                if (z.b.class.isAssignableFrom(y.h(typeG6))) {
                    throw y.o(this.f5141b, i5, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new p.i(this.f5141b, i5, vVarG, this.f5140a.h(typeG6, annotationArr, this.f5142c)).c();
            }
            throw y.o(this.f5141b, i5, clsH10.getSimpleName() + " must include generic type (e.g., " + clsH10.getSimpleName() + "<String>)", new Object[0]);
        }

        static Set<String> h(String str) {
            Matcher matcher = f5138x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i5, String str) {
            if (!f5139y.matcher(str).matches()) {
                throw y.o(this.f5141b, i5, "@Path parameter name must match %s. Found: %s", f5138x.pattern(), str);
            }
            if (!this.f5160u.contains(str)) {
                throw y.o(this.f5141b, i5, "URL \"%s\" does not contain \"{%s}\".", this.f5157r, str);
            }
        }

        private void j(int i5, Type type) {
            if (y.j(type)) {
                throw y.o(this.f5141b, i5, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        s b() {
            for (Annotation annotation : this.f5142c) {
                e(annotation);
            }
            if (this.f5153n == null) {
                throw y.m(this.f5141b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f5154o) {
                if (this.f5156q) {
                    throw y.m(this.f5141b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f5155p) {
                    throw y.m(this.f5141b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f5143d.length;
            this.f5161v = new p[length];
            int i5 = length - 1;
            int i6 = 0;
            while (i6 < length) {
                this.f5161v[i6] = f(i6, this.f5144e[i6], this.f5143d[i6], i6 == i5);
                i6++;
            }
            if (this.f5157r == null && !this.f5152m) {
                throw y.m(this.f5141b, "Missing either @%s URL or @Url parameter.", this.f5153n);
            }
            boolean z5 = this.f5155p;
            if (!z5 && !this.f5156q && !this.f5154o && this.f5147h) {
                throw y.m(this.f5141b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z5 && !this.f5145f) {
                throw y.m(this.f5141b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f5156q || this.f5146g) {
                return new s(this);
            }
            throw y.m(this.f5141b, "Multipart method must contain at least one @Part.", new Object[0]);
        }
    }

    s(a aVar) {
        this.f5127a = aVar.f5141b;
        this.f5128b = aVar.f5140a.f5168c;
        this.f5129c = aVar.f5153n;
        this.f5130d = aVar.f5157r;
        this.f5131e = aVar.f5158s;
        this.f5132f = aVar.f5159t;
        this.f5133g = aVar.f5154o;
        this.f5134h = aVar.f5155p;
        this.f5135i = aVar.f5156q;
        this.f5136j = aVar.f5161v;
        this.f5137k = aVar.f5162w;
    }

    static s b(u uVar, Method method) {
        return new a(uVar, method).b();
    }

    D a(Object[] objArr) {
        p<?>[] pVarArr = this.f5136j;
        int length = objArr.length;
        if (length != pVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + pVarArr.length + ")");
        }
        r rVar = new r(this.f5129c, this.f5128b, this.f5130d, this.f5131e, this.f5132f, this.f5133g, this.f5134h, this.f5135i);
        if (this.f5137k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i5 = 0; i5 < length; i5++) {
            arrayList.add(objArr[i5]);
            pVarArr[i5].a(rVar, objArr[i5]);
        }
        return rVar.k().g(l.class, new l(this.f5127a, arrayList)).b();
    }
}
