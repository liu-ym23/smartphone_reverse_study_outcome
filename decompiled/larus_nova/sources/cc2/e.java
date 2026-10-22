package cc2;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f23159a;

    public e() {
        this.f23159a = new LinkedHashMap();
    }

    public final <T extends o> f<T> b(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = ((LinkedHashMap) this.f23159a).get(r100);
        if ((r101 instanceof f) == true) goto L6;
        r101 = null;
    L6:
        return (f) r101;
    }

    public final <T extends o> void a(Class<T> r100, T r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "factor");
        this.f23159a.put(r100, new f(r101, r102));
    }
}
