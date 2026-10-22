package aj9;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3948a = null;

    static {
        f3948a = LazyKt.lazy(new a());
    }

    public static final boolean a() {
        return ((Boolean) f3948a.getValue()).booleanValue();
    }
}
