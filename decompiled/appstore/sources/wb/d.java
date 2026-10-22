package wb;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Pair;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f25401a = null;

    static {
        f25401a = new d();
    }

    public d() {
    }

    public final Pair a(View r10, ViewGroup r11) {
        q.g(r10, "view");
        q.g(r11, "viewGroup");
        int r12 = 0;
        View r13 = r10;
        int r14 = 0;
    L3:
        if (r13 == null) goto L13;
        if (q.b(r13, r11) == true) goto L13;
        r12 = r12 + r13.getLeft();
        r14 = r14 + r13.getTop();
        b r15 = b.f25397a;
        Object r16 = r13.getParent();
        if (r16 != null) goto L10;
    L8:
        r16 = null;
    L11:
        r13 = (View) r16;
        goto L3
    L10:
        if ((r16 instanceof View) == false) goto L8;
    L13:
        return new Pair(Integer.valueOf(r12), Integer.valueOf(r14));
    }
}
