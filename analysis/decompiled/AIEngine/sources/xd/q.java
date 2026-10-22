package xd;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Method f13874a;

    /* renamed from: b, reason: collision with root package name */
    public final okhttp3.g f13875b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13876c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13877d;

    /* renamed from: e, reason: collision with root package name */
    public final okhttp3.f f13878e;

    /* renamed from: f, reason: collision with root package name */
    public final ad.l f13879f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f13880g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13881i;

    /* renamed from: j, reason: collision with root package name */
    public final n<?>[] f13882j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f13883k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: x, reason: collision with root package name */
        public static final Pattern f13884x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* renamed from: y, reason: collision with root package name */
        public static final Pattern f13885y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        public final t f13886a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f13887b;

        /* renamed from: c, reason: collision with root package name */
        public final Annotation[] f13888c;

        /* renamed from: d, reason: collision with root package name */
        public final Annotation[][] f13889d;

        /* renamed from: e, reason: collision with root package name */
        public final Type[] f13890e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f13891f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f13892g;
        public boolean h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f13893i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f13894j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f13895k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f13896l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f13897m;

        /* renamed from: n, reason: collision with root package name */
        public String f13898n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f13899o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f13900p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f13901q;
        public String r;

        /* renamed from: s, reason: collision with root package name */
        public okhttp3.f f13902s;

        /* renamed from: t, reason: collision with root package name */
        public ad.l f13903t;

        /* renamed from: u, reason: collision with root package name */
        public LinkedHashSet f13904u;

        /* renamed from: v, reason: collision with root package name */
        public n<?>[] f13905v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f13906w;

        public a(t tVar, Method method) {
            this.f13886a = tVar;
            this.f13887b = method;
            this.f13888c = method.getAnnotations();
            this.f13890e = method.getGenericParameterTypes();
            this.f13889d = method.getParameterAnnotations();
        }

        public static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        public final void b(String str, String str2, boolean z) {
            String str3 = this.f13898n;
            Method method = this.f13887b;
            if (str3 != null) {
                throw retrofit2.b.i(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f13898n = str;
            this.f13899o = z;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            Pattern pattern = f13884x;
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (pattern.matcher(strSubstring).find()) {
                    throw retrofit2.b.i(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.r = str2;
            Matcher matcher = pattern.matcher(str2);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            this.f13904u = linkedHashSet;
        }

        public final void c(int i10, Type type) {
            if (retrofit2.b.g(type)) {
                throw retrofit2.b.j(this.f13887b, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public q(a aVar) {
        this.f13874a = aVar.f13887b;
        this.f13875b = aVar.f13886a.f13915c;
        this.f13876c = aVar.f13898n;
        this.f13877d = aVar.r;
        this.f13878e = aVar.f13902s;
        this.f13879f = aVar.f13903t;
        this.f13880g = aVar.f13899o;
        this.h = aVar.f13900p;
        this.f13881i = aVar.f13901q;
        this.f13882j = aVar.f13905v;
        this.f13883k = aVar.f13906w;
    }
}
