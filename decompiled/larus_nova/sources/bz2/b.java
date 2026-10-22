package bz2;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static Activity a(Context r100) {
    L13:
    L10:
        c.a();
        return null;
    L3:
        if ((r100 instanceof ContextWrapper) == false) goto L17;
        if ((r100 instanceof Activity) == true) goto L6;
        r100 = ((ContextWrapper) r100).getBaseContext();     // Catch: Exception -> L10
        goto L13
    L6:
        return (Activity) r100;
    L17:
        return null;
    }
}
