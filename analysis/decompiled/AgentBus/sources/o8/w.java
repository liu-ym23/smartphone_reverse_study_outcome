package o8;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final e9.c f7856a;

    /* renamed from: b, reason: collision with root package name */
    public static final e9.b f7857b;

    static {
        e9.c cVar = new e9.c("kotlin.jvm.JvmField");
        f7856a = cVar;
        e9.b.j(cVar);
        e9.b.j(new e9.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
        f7857b = e9.b.e("kotlin/jvm/internal/RepeatableContainer", false);
    }

    public static final String a(String str) {
        q7.k.e(str, "propertyName");
        if (c(str)) {
            return str;
        }
        return "get" + w7.e0.g(str);
    }

    public static final String b(String str) {
        String strG;
        StringBuilder sb2 = new StringBuilder("set");
        if (c(str)) {
            strG = str.substring(2);
            q7.k.d(strG, "this as java.lang.String).substring(startIndex)");
        } else {
            strG = w7.e0.g(str);
        }
        sb2.append(strG);
        return sb2.toString();
    }

    public static final boolean c(String str) {
        q7.k.e(str, "name");
        if (ga.r.g0(str, "is", false) && str.length() != 2) {
            char cCharAt = str.charAt(2);
            if (q7.k.f(97, cCharAt) > 0 || q7.k.f(cCharAt, 122) > 0) {
                return true;
            }
        }
        return false;
    }
}
