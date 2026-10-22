package m3;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13635a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13636b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13637c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final StringBuilder f13638d = new StringBuilder(128);

    /* renamed from: e, reason: collision with root package name */
    public Class f13639e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13640f;

    public final boolean a(Class cls, Method method) {
        StringBuilder sb = this.f13638d;
        sb.setLength(0);
        sb.append(method.getName());
        sb.append(Typography.greater);
        sb.append(cls.getName());
        String string = sb.toString();
        Class<?> declaringClass = method.getDeclaringClass();
        HashMap map = this.f13637c;
        Class cls2 = (Class) map.put(string, declaringClass);
        if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
            return true;
        }
        map.put(string, cls2);
        return false;
    }
}
