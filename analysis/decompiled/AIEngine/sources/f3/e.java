package f3;

import com.fasterxml.jackson.databind.JavaType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f8709a = Arrays.asList(null, null).getClass();

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?> f8710b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f8711c;

    /* renamed from: d, reason: collision with root package name */
    public static final Class<?> f8712d;

    /* renamed from: e, reason: collision with root package name */
    public static final Class<?> f8713e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class<?> f8714f;

    /* renamed from: g, reason: collision with root package name */
    public static final Class<?> f8715g;
    public static final Class<?> h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements q3.g<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final JavaType f8716a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8717b;

        public a(int i10, JavaType javaType) {
            this.f8716a = javaType;
            this.f8717b = i10;
        }

        public static void c(int i10) {
            if (i10 != 1) {
                throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Can not deserialize Singleton container from ", " entries"));
            }
        }

        @Override // q3.g
        public final Object a(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this.f8717b) {
                case 1:
                    Set set = (Set) obj;
                    c(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    c(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    c(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                case 7:
                    return Collections.synchronizedSet((Set) obj);
                case 8:
                    return Collections.synchronizedCollection((Collection) obj);
                case 9:
                    return Collections.synchronizedList((List) obj);
                case 10:
                    return Collections.synchronizedMap((Map) obj);
                default:
                    return obj;
            }
        }

        @Override // q3.g
        public final JavaType b() {
            return this.f8716a;
        }

        @Override // q3.g
        public final JavaType getInputType() {
            return this.f8716a;
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        Set setSingleton = Collections.singleton(bool);
        f8710b = setSingleton.getClass();
        f8713e = Collections.unmodifiableSet(setSingleton).getClass();
        List listSingletonList = Collections.singletonList(bool);
        f8711c = listSingletonList.getClass();
        f8714f = Collections.unmodifiableList(listSingletonList).getClass();
        f8715g = Collections.unmodifiableList(new LinkedList()).getClass();
        Map mapSingletonMap = Collections.singletonMap("a", "b");
        f8712d = mapSingletonMap.getClass();
        h = Collections.unmodifiableMap(mapSingletonMap).getClass();
    }

    public static String a(Class<?> cls) {
        String name = cls.getName();
        String strSubstring = name.startsWith("java.util.Collections$") ? name.substring(22) : "";
        return (strSubstring == null || !strSubstring.startsWith("Synchronized")) ? "" : strSubstring.substring(12);
    }
}
