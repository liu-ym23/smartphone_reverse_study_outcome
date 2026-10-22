package i9;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final /* synthetic */ Activity a(Context r10) {
        return c(r10);
    }

    public static final /* synthetic */ int b(View r10, ViewGroup r11) {
        return d(r10, r11);
    }

    public static final Activity c(Context r10) {
        if ((r10 instanceof Activity) == false) goto L6;
        return (Activity) r10;
    L6:
        if ((r10 instanceof ContextWrapper) == false) goto L8;
        Context r11 = ((ContextWrapper) r10).getBaseContext();
        q.f(r11, "getBaseContext(...)");
        return c(r11);
    L8:
        return null;
    }

    public static final int d(View r10, ViewGroup r11) {
        int r12 = r10.getTop();
        ViewParent r13 = r10.getParent();
    L4:
        if ((r13 instanceof ViewGroup) == false) goto L8;
        if (q.b(r13, r11) == true) goto L8;
        ViewGroup r14 = (ViewGroup) r13;
        r12 = r12 + (r14.getTop() - r14.getScrollY());
        r13 = r14.getParent();
    L8:
        return r12;
    }
}
