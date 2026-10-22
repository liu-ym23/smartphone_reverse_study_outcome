package qb;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final int a(Context r10) {
        q.g(r10, "$this$getScreenWidth");
        Resources r11 = r10.getResources();
        q.f(r11, "resources");
        DisplayMetrics r12 = r11.getDisplayMetrics();
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.widthPixels;
    }
}
