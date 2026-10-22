package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j0 extends i0 {
    public static Map b(Map r10) {
        kotlin.jvm.internal.q.g(r10, "builder");
        return ((MapBuilder) r10).build();
    }

    public static Map c() {
        return new MapBuilder();
    }

    public static Map d(int r10) {
        return new MapBuilder(r10);
    }

    public static int e(int r10) {
        if (r10 >= 0) goto L5;
        return r10;
    L5:
        if (r10 >= 3) goto L8;
        return r10 + 1;
    L8:
        if (r10 < 1073741824) goto L13;
        return Channel.UNLIMITED;
    L13:
        return (int) ((r10 / 0.75f) + 1.0f);
    }

    public static Map f(Pair r10) {
        kotlin.jvm.internal.q.g(r10, "pair");
        Map r11 = Collections.singletonMap(r10.getFirst(), r10.getSecond());
        kotlin.jvm.internal.q.f(r11, "singletonMap(...)");
        return r11;
    }

    public static final Map g(Map r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        Map.Entry r11 = (Map.Entry) r10.entrySet().iterator().next();
        Map r12 = Collections.singletonMap(r11.getKey(), r11.getValue());
        kotlin.jvm.internal.q.f(r12, "with(...)");
        return r12;
    }
}
