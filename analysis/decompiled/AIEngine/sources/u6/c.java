package u6;

import java.util.ArrayDeque;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final long f13172a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.a<Long> f13173b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f13174c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayDeque<Long> f13175a = new ArrayDeque<>();
    }

    public c(Set initialFailedModels, int i10) {
        initialFailedModels = (i10 & 1) != 0 ? EmptySet.f10003a : initialFailedModels;
        com.stepos.cpuset.c cVar = new com.stepos.cpuset.c(16);
        g.f(initialFailedModels, "initialFailedModels");
        this.f13172a = 86400000L;
        this.f13173b = cVar;
        this.f13174c = new ConcurrentHashMap<>();
        if (initialFailedModels.isEmpty()) {
            return;
        }
        long jLongValue = ((Number) cVar.invoke()).longValue();
        for (String str : initialFailedModels) {
            a aVar = new a();
            aVar.f13175a.addLast(Long.valueOf(jLongValue));
            this.f13174c.put(str, aVar);
        }
    }
}
