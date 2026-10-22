package pa;

import com.obric.appstore.StoreBaseApplication;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23414a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static StoreBaseApplication f23415b;

    static {
        f23414a = new a();
    }

    public a() {
    }

    public final StoreBaseApplication a() {
        StoreBaseApplication r10 = f23415b;
        if (r10 != null) goto L6;
        q.y("application");
        return null;
    L6:
        return r10;
    }

    public final void b(StoreBaseApplication r10) {
        q.g(r10, "application");
        f23415b = r10;
    }
}
