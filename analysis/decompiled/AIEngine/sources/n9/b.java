package n9;

import android.util.Pair;
import com.stepos.deepbinder.core.log.IPCLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f10675a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<Pair<String, Long>, a> f10676b = new ConcurrentHashMap<>();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f10677a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f10678b;

        public a(boolean z, boolean z3, Object callback) {
            g.f(callback, "callback");
            this.f10677a = z3;
            this.f10678b = z ? new WeakReference(callback) : callback;
        }

        public final Object a() {
            Object obj = this.f10678b;
            return obj instanceof WeakReference ? ((WeakReference) obj).get() : obj;
        }
    }

    public static void a(long j10) {
        ConcurrentHashMap<Pair<String, Long>, a> concurrentHashMap = f10676b;
        concurrentHashMap.entrySet().removeIf(new b9.b(new n9.a(j10), 8));
        IPCLog.INSTANCE.d("CallbackCache", "[Remain]", "size", Integer.valueOf(concurrentHashMap.size()));
    }

    public static void b(Object callback) {
        g.f(callback, "callback");
        f10676b.entrySet().removeIf(new b9.b(new androidx.compose.runtime.g(callback, 19), 7));
    }
}
