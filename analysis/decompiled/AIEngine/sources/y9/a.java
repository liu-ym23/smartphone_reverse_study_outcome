package y9;

import android.util.Pair;
import com.stepos.deepbinder.annotation.ext.BlackList;
import com.stepos.deepbinder.annotation.ext.WhiteList;
import com.stepos.deepbinder.core.entity.ext.CallerData;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0178a f14176c = new C0178a();

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f14177d;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, Pair<ArrayList<String>, ArrayList<String>>> f14178a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final ThreadLocal<CallerData> f14179b = new ThreadLocal<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: y9.a$a, reason: collision with other inner class name */
    public static final class C0178a {
        public final a a() {
            a aVar;
            a aVar2 = a.f14177d;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (this) {
                aVar = a.f14177d;
                if (aVar == null) {
                    aVar = new a();
                    a.f14177d = aVar;
                }
            }
            return aVar;
        }
    }

    public static ArrayList a(Annotation annotation) {
        if (annotation == null) {
            return new ArrayList();
        }
        return new ArrayList(l.q0(annotation instanceof WhiteList ? ((WhiteList) annotation).value() : annotation instanceof BlackList ? ((BlackList) annotation).value() : new String[0]));
    }

    public final Pair<ArrayList<String>, ArrayList<String>> b(Class<?> cls, String str, Method method) {
        Annotation annotation;
        Annotation annotation2;
        Pair<ArrayList<String>, ArrayList<String>> pairPutIfAbsent;
        boolean z = cls != null;
        if (z) {
            g.c(cls);
            annotation = cls.getAnnotation(WhiteList.class);
        } else {
            g.c(method);
            annotation = method.getAnnotation(WhiteList.class);
        }
        WhiteList whiteList = (WhiteList) annotation;
        if (z) {
            g.c(cls);
            annotation2 = cls.getAnnotation(BlackList.class);
        } else {
            g.c(method);
            annotation2 = method.getAnnotation(BlackList.class);
        }
        BlackList blackList = (BlackList) annotation2;
        if (whiteList == null && blackList == null) {
            return null;
        }
        if (z) {
            g.c(cls);
            str = cls.getName();
        } else if (str == null) {
            str = "";
        }
        ConcurrentHashMap<String, Pair<ArrayList<String>, ArrayList<String>>> concurrentHashMap = this.f14178a;
        Pair<ArrayList<String>, ArrayList<String>> pair = concurrentHashMap.get(str);
        if (pair == null && (pairPutIfAbsent = concurrentHashMap.putIfAbsent(str, (pair = new Pair<>(a(whiteList), a(blackList))))) != null) {
            pair = pairPutIfAbsent;
        }
        return pair;
    }
}
