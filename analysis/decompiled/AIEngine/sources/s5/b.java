package s5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final ud.a f11889c = ud.b.e(b.class);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11890a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11891b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final s5.a f11892a;

        /* renamed from: b, reason: collision with root package name */
        public final Future<Boolean> f11893b;

        public a(s5.a aVar, Future<Boolean> future) {
            this.f11892a = aVar;
            this.f11893b = future;
        }
    }

    public b() {
        throw null;
    }

    public b(List<s5.a> list) {
        this.f11890a = new ArrayList(list);
        this.f11891b = 2000L;
    }
}
