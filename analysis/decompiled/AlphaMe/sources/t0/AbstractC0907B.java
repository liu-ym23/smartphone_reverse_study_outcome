package t0;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0907B {

    /* renamed from: a, reason: collision with root package name */
    public static final String f15314a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f15315b;

    static {
        String strF = s0.t.f("WrkDbPathHelper");
        Intrinsics.checkNotNullExpressionValue(strF, "tagWithPrefix(\"WrkDbPathHelper\")");
        f15314a = strF;
        f15315b = new String[]{"-journal", "-shm", "-wal"};
    }
}
