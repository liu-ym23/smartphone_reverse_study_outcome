package E9;

import io.ktor.client.utils.CacheControl;
import java.util.Map;

/* loaded from: classes5.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f2454a = new l0();

    /* renamed from: b, reason: collision with root package name */
    public static final Map<m0, Integer> f2455b;

    /* renamed from: c, reason: collision with root package name */
    public static final h f2456c;

    public static final class a extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final a f2457c = new a();

        public a() {
            super("inherited", false);
        }
    }

    public static final class b extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final b f2458c = new b();

        public b() {
            super("internal", false);
        }
    }

    public static final class c extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final c f2459c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    public static final class d extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final d f2460c = new d();

        public d() {
            super("local", false);
        }
    }

    public static final class e extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final e f2461c = new e();

        public e() {
            super(CacheControl.PRIVATE, false);
        }
    }

    public static final class f extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final f f2462c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // E9.m0
        public String b() {
            return "private/*private to this*/";
        }
    }

    public static final class g extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final g f2463c = new g();

        public g() {
            super("protected", true);
        }
    }

    public static final class h extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final h f2464c = new h();

        public h() {
            super(CacheControl.PUBLIC, true);
        }
    }

    public static final class i extends m0 {

        /* renamed from: c, reason: collision with root package name */
        public static final i f2465c = new i();

        public i() {
            super("unknown", false);
        }
    }

    static {
        Map mapC = Z8.Q.c();
        mapC.put(f.f2462c, 0);
        mapC.put(e.f2461c, 0);
        mapC.put(b.f2458c, 1);
        mapC.put(g.f2463c, 1);
        h hVar = h.f2464c;
        mapC.put(hVar, 2);
        f2455b = Z8.Q.b(mapC);
        f2456c = hVar;
    }

    public final Integer a(m0 first, m0 second) {
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(second, "second");
        if (first == second) {
            return 0;
        }
        Map<m0, Integer> map = f2455b;
        Integer num = map.get(first);
        Integer num2 = map.get(second);
        if (num == null || num2 == null || kotlin.jvm.internal.p.d(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(m0 visibility) {
        kotlin.jvm.internal.p.i(visibility, "visibility");
        return visibility == e.f2461c || visibility == f.f2462c;
    }
}
