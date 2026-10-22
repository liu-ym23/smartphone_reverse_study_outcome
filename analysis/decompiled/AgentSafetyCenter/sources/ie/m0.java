package ie;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class m0 {

    /* renamed from: u, reason: collision with root package name */
    public static final Pattern f6019u = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: v, reason: collision with root package name */
    public static final Pattern f6020v = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: a, reason: collision with root package name */
    public Method f6021a;

    /* renamed from: b, reason: collision with root package name */
    public Type[] f6022b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6023c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6024d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6025e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6026f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6027g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6028h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6029j;

    /* renamed from: k, reason: collision with root package name */
    public String f6030k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6031l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6032m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6033n;

    /* renamed from: o, reason: collision with root package name */
    public String f6034o;

    /* renamed from: p, reason: collision with root package name */
    public ad.n f6035p;

    /* renamed from: q, reason: collision with root package name */
    public ad.s f6036q;

    /* renamed from: r, reason: collision with root package name */
    public LinkedHashSet f6037r;

    /* renamed from: s, reason: collision with root package name */
    public w0[] f6038s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6039t;

    public static Class a(Class cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    public final void b(String str, String str2, boolean z10) {
        Method method = this.f6021a;
        String str3 = this.f6030k;
        if (str3 != null) {
            throw w0.m(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.f6030k = str;
        this.f6031l = z10;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        Pattern pattern = f6019u;
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (pattern.matcher(strSubstring).find()) {
                throw w0.m(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.f6034o = str2;
        Matcher matcher = pattern.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.f6037r = linkedHashSet;
    }

    public final void c(int i, Type type) {
        if (w0.j(type)) {
            throw w0.n(this.f6021a, i, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
