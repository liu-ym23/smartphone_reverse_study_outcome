package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q0 {
    public static Set a(Set r10) {
        kotlin.jvm.internal.q.g(r10, "builder");
        return ((SetBuilder) r10).build();
    }

    public static Set b() {
        return new SetBuilder();
    }

    public static Set c(int r10) {
        return new SetBuilder(r10);
    }

    public static Set d(Object r10) {
        Set r11 = Collections.singleton(r10);
        kotlin.jvm.internal.q.f(r11, "singleton(...)");
        return r11;
    }
}
