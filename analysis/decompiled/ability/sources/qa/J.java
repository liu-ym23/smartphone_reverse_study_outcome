package qa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class J {
    public static final Pattern y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: z, reason: collision with root package name */
    public static final Pattern f5632z = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: a, reason: collision with root package name */
    public final N f5633a;
    public final Class b;
    public final Method c;
    public final Annotation[] d;
    public final Annotation[][] e;
    public final Type[] f;
    public boolean g;
    public boolean h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5634j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public String o;
    public boolean p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5635q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5636r;

    /* renamed from: s, reason: collision with root package name */
    public String f5637s;

    /* renamed from: t, reason: collision with root package name */
    public F9.w f5638t;
    public F9.B u;

    /* renamed from: v, reason: collision with root package name */
    public LinkedHashSet f5639v;

    /* renamed from: w, reason: collision with root package name */
    public U[] f5640w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5641x;

    public J(N n, Class cls, Method method) {
        this.f5633a = n;
        this.b = cls;
        this.c = method;
        this.d = method.getAnnotations();
        this.f = method.getGenericParameterTypes();
        this.e = method.getParameterAnnotations();
    }

    public static Class a(Class cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    public final void b(String str, String str2, boolean z10) {
        String str3 = this.o;
        Method method = this.c;
        if (str3 != null) {
            throw U.k(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.o = str;
        this.p = z10;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        Pattern pattern = y;
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (pattern.matcher(strSubstring).find()) {
                throw U.k(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.f5637s = str2;
        Matcher matcher = pattern.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.f5639v = linkedHashSet;
    }

    public final void c(int i, Type type) {
        if (U.h(type)) {
            throw U.l(this.c, i, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
