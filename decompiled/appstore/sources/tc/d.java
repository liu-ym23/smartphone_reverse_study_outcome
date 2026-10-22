package tc;

import android.util.Log;
import com.obric.oui.common.util.OUILog;
import kotlin.Unit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f24779a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static OUILog f24780b;

    static {
        f24779a = new d();
    }

    public d() {
    }

    public static /* synthetic */ void c(d r10, String r11, String r12, Throwable r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        r10.b(r11, r12, r13);
    }

    public final void a(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OUILog r12 = f24780b;
        if (r12 != null) goto L5;
        Unit r13 = null;
    L6:
        if (r13 != null) goto L9;
        Log.d(r10, r11);
        return;
    L9:
        return;
    L5:
        r12.d(r10, r11);
        r13 = Unit.f21064a;
        goto L6
    }

    public final void b(String r10, String r11, Throwable r12) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OUILog r13 = f24780b;
        if (r13 != null) goto L5;
        Unit r14 = null;
    L6:
        if (r14 != null) goto L9;
        Log.e(r10, r11, r12);
        return;
    L9:
        return;
    L5:
        r13.e(r10, r11, r12);
        r14 = Unit.f21064a;
        goto L6
    }

    public final void d(String r10, String r11) {
        q.g(r10, "tag");
        q.g(r11, "msg");
        OUILog r12 = f24780b;
        if (r12 != null) goto L5;
        Unit r13 = null;
    L6:
        if (r13 != null) goto L9;
        Log.i(r10, r11);
        return;
    L9:
        return;
    L5:
        r12.i(r10, r11);
        r13 = Unit.f21064a;
        goto L6
    }
}
