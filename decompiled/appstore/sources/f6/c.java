package f6;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f19497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f19498b;

    public c(Method r10, List r11) {
        this.f19497a = r10;
        this.f19498b = Collections.unmodifiableList(r11);
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.f19497a.getDeclaringClass().getName(), this.f19497a.getName(), this.f19498b});
    }
}
