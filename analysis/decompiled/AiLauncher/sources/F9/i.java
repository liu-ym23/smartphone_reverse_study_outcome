package F9;

import kotlin.jvm.internal.p;

/* loaded from: classes5.dex */
public final class i {
    public static final g a(g first, g second) {
        p.i(first, "first");
        p.i(second, "second");
        return first.isEmpty() ? second : second.isEmpty() ? first : new n(first, second);
    }
}
