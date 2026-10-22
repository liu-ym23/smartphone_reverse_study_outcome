package v1;

import android.content.Context;
import android.view.PointerIcon;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f14407a = new e0();

    public final void a(View view, o1.o oVar) {
        Context context = view.getContext();
        PointerIcon systemIcon = oVar instanceof o1.a ? PointerIcon.getSystemIcon(context, ((o1.a) oVar).f8999b) : PointerIcon.getSystemIcon(context, 1000);
        if (yb.k.a(view.getPointerIcon(), systemIcon)) {
            return;
        }
        view.setPointerIcon(systemIcon);
    }
}
