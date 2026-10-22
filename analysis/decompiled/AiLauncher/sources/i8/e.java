package i8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    public final List<T> f33073a;

    public e(int i10) {
        this.f33073a = new ArrayList(i10);
    }

    public static <T> e<T> c(int i10) {
        return new e<>(i10);
    }

    public e<T> a(T t10) {
        this.f33073a.add(c.c(t10, "Set contributions cannot be null"));
        return this;
    }

    public Set<T> b() {
        return this.f33073a.isEmpty() ? Collections.EMPTY_SET : this.f33073a.size() == 1 ? Collections.singleton(this.f33073a.get(0)) : Collections.unmodifiableSet(new HashSet(this.f33073a));
    }
}
