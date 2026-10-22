package xb;

import android.app.Activity;
import com.obric.common.oea.style.R$anim;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import kotlin.jvm.internal.q;
import qb.c;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f25862a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f25863b = null;

    static {
        f25863b = new b();
        f25862a = new c();
    }

    public b() {
    }

    public static final void a(Activity r12, TransitionAnimStyle r13) {
        q.g(r12, "activity");
        q.g(r13, "animStyle");
        int r10 = a.f25857a[r13.ordinal()];
        if (r10 == 1) goto L7;
        if (r10 == 2) goto L6;
        TransitionAnimStyle r11 = r13;
    L8:
        String r14 = r12.getClass().getSimpleName();
        if (r13 == r11) goto L11;
        qb.b.c(qb.b.f23627c, "TransitionAnimHelper", "overrideEnterAnim, " + r13 + " is deprecated: , use " + r11 + " instead, activity: " + r14, null, 4, null);
    L12:
        int r15 = a.f25858b[r11.ordinal()];
        if (r15 == 1) goto L20;
        if (r15 != 2) goto L16;
        r12.overridePendingTransition(R$anim.oui_modal_open_enter, R$anim.oui_modal_open_exit);
        return;
    L16:
        if (r15 == 3) goto L18;
        qb.b.f23627c.h("TransitionAnimHelper", "overrideEnterAnim, unsupported anim style: " + r13 + "，activity: " + r14);
        return;
    L18:
        r12.overridePendingTransition(R$anim.oui_search_open_enter, R$anim.oui_search_open_exit);
        return;
    L20:
        r12.overridePendingTransition(R$anim.oui_activity_open_enter, R$anim.oui_activity_open_exit);
        return;
    L11:
        qb.b.f23627c.f("TransitionAnimHelper", "overrideEnterAnim, animStyle: " + r13 + "，activity: " + r14);
        goto L12
    L6:
        r11 = TransitionAnimStyle.Modal;
        goto L8
    L7:
        r11 = TransitionAnimStyle.Standard;
        goto L8
    }

    public static final void b(Activity r12, TransitionAnimStyle r13) {
        q.g(r12, "activity");
        q.g(r13, "animStyle");
        String r10 = r12.getClass().getSimpleName();
        int r11 = a.f25859c[r13.ordinal()];
        if (r11 == 1) goto L7;
        if (r11 == 2) goto L6;
        TransitionAnimStyle r14 = r13;
    L9:
        if (r13 == r14) goto L11;
        qb.b.c(qb.b.f23627c, "TransitionAnimHelper", "overrideExitAnim, " + r13 + " is deprecated, use " + r14 + " instead，activity: " + r10, null, 4, null);
    L12:
        int r15 = a.f25860d[r14.ordinal()];
        if (r15 == 1) goto L20;
        if (r15 != 2) goto L16;
        r12.overridePendingTransition(R$anim.oui_modal_close_enter, R$anim.oui_modal_close_exit);
        return;
    L16:
        if (r15 == 3) goto L18;
        qb.b.f23627c.h("TransitionAnimHelper", "overrideExitAnim, unsupported anim style: " + r13 + "，activity: " + r10);
        return;
    L18:
        r12.overridePendingTransition(R$anim.oui_search_close_enter, R$anim.oui_search_close_exit);
        return;
    L20:
        r12.overridePendingTransition(R$anim.oui_activity_close_enter, R$anim.oui_activity_close_exit);
        return;
    L11:
        qb.b.f23627c.f("TransitionAnimHelper", "overrideExitAnim, animStyle: " + r13 + "，activity: " + r10);
        goto L12
    L6:
        r14 = TransitionAnimStyle.Modal;
        goto L9
    L7:
        r14 = TransitionAnimStyle.Standard;
        goto L9
    }
}
