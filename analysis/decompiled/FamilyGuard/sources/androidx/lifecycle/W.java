package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class W {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, T> f10853a = new LinkedHashMap();

    public final void a() {
        Iterator<T> it = this.f10853a.values().iterator();
        while (it.hasNext()) {
            it.next().H();
        }
        this.f10853a.clear();
    }

    public final T b(String str) {
        j4.k.g(str, "key");
        return this.f10853a.get(str);
    }

    public final Set<String> c() {
        return new HashSet(this.f10853a.keySet());
    }

    public final void d(String str, T t5) {
        j4.k.g(str, "key");
        j4.k.g(t5, "viewModel");
        T tPut = this.f10853a.put(str, t5);
        if (tPut != null) {
            tPut.H();
        }
    }
}
