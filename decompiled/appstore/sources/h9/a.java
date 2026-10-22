package h9;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20383a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f20384b = null;

    static {
        f20383a = new a();
        f20384b = new ConcurrentHashMap();
    }

    public a() {
    }

    public final Object a(Class r10) {
        q.g(r10, "serviceClass");
        return r10.cast(f20384b.get(r10));
    }

    public final void b(Class r10, Object r11) {
        q.g(r10, "serviceClass");
        q.g(r11, "service");
        f20384b.put(r10, r11);
    }
}
