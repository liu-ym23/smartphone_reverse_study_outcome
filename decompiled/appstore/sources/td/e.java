package td;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f24798a = null;

    static {
        f24798a = new e();
    }

    public e() {
    }

    public static final View a(Context r10, int r11, Function3 r12) {
        q.g(r10, "context");
        q.g(r12, "ofStyle");
        ContextThemeWrapper r13 = new ContextThemeWrapper(r10, r11);
        TypedArray r14 = r13.obtainStyledAttributes(null, new int[]{R.attr.layout_width, R.attr.layout_height}, 0, r11);
        q.f(r14, "contextThemeWrapper.obta…ll, attrs, 0, styleResId)");
        int r15 = r14.getLayoutDimension(0, -2);     // Catch: Throwable -> L6
        int r16 = r14.getLayoutDimension(1, -2);     // Catch: Throwable -> L6
        View r17 = (View) r12.invoke(r13, Integer.valueOf(r15), Integer.valueOf(r16));     // Catch: Throwable -> L6
        r14.recycle();
        return r17;
    L6:
        th = move-exception;
        r14.recycle();
        throw th;
    }
}
