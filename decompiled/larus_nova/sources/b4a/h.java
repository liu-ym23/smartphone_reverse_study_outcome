package b4a;

import hq9.c5;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f17692a = null;

    static {
        f17692a = LazyKt.lazy(new g());
    }

    public static c5 a() {
        return (c5) f17692a.getValue();
    }
}
