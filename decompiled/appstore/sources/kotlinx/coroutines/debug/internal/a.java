package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f21393a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f21394b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f21395c = null;

    static {
        f21393a = new b0("REHASH");
        f21394b = new e(null);
        f21395c = new e(Boolean.TRUE);
    }

    public static final /* synthetic */ b0 a() {
        return f21393a;
    }

    public static final /* synthetic */ e b(Object r10) {
        return d(r10);
    }

    public static final /* synthetic */ Void c() {
        return e();
    }

    public static final e d(Object r10) {
        if (r10 != null) goto L5;
        return f21394b;
    L5:
        if (q.b(r10, Boolean.TRUE) == false) goto L8;
        return f21395c;
    L8:
        return new e(r10);
    }

    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
