package tc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {
    public static final Activity a(Context r10) {
        q.g(r10, "context");
    L4:
        if ((r10 instanceof ContextWrapper) == false) goto L10;
        if ((r10 instanceof Activity) == true) goto L8;
        r10 = ((ContextWrapper) r10).getBaseContext();
        q.f(r10, "rContext.baseContext");
        goto L4
    L8:
        return (Activity) r10;
    L10:
        return null;
    }
}
