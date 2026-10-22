package tc;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f24778a = null;

    static {
        f24778a = new a();
    }

    public a() {
    }

    public final TypedValue a(Context r10, int r11) {
        q.g(r10, "context");
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r12, true) == true) goto L7;
        return null;
    L7:
        return r12;
    }

    public final int b(Context r10, int r11, int r12) {
        q.g(r10, "context");
        TypedValue r13 = a(r10, r11);
        if (r13 != null) goto L5;
    L9:
        float r14 = r10.getResources().getDimension(r12);
    L10:
        return (int) r14;
    L5:
        if (r13.type != 5) goto L9;
        r14 = r13.getDimension(r10.getResources().getDisplayMetrics());
        goto L10
    }
}
