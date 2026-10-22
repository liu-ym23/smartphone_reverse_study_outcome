package tc;

import android.content.Context;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f24781a = null;

    static {
        f24781a = new g();
    }

    public g() {
    }

    public final boolean a(Context r10) {
        q.g(r10, "context");
        if (r10.getResources().getConfiguration().orientation != 2) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        L.c("ResourceUtils", "isLandscape error", e);
        return false;
    }
}
