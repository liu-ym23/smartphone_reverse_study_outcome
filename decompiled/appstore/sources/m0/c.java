package m0;

import androidx.work.h;
import androidx.work.i;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f22017a = null;

    static {
        String r10 = i.i("ConstraintTrkngWrkr");
        q.f(r10, "tagWithPrefix(\"ConstraintTrkngWrkr\")");
        f22017a = r10;
    }

    public static final /* synthetic */ String a() {
        return f22017a;
    }

    public static final /* synthetic */ boolean b(androidx.work.impl.utils.futures.a r10) {
        return d(r10);
    }

    public static final /* synthetic */ boolean c(androidx.work.impl.utils.futures.a r10) {
        return e(r10);
    }

    public static final boolean d(androidx.work.impl.utils.futures.a r10) {
        return r10.p(h.a.a());
    }

    public static final boolean e(androidx.work.impl.utils.futures.a r10) {
        return r10.p(h.a.b());
    }
}
