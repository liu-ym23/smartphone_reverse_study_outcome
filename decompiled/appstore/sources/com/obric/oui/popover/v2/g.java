package com.obric.oui.popover.v2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import bg.h;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f16354a = null;

    static {
        f16354a = new g();
    }

    public g() {
    }

    public static /* synthetic */ void f(g r12, OPopover r13, View r14, int r15, boolean r16, int r17, boolean r18, int r19, int r20, int r21, Object r22) {
        if ((r21 & 8) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r21 & 16) == 0) goto L9;
        int r11 = 0;
    L11:
        if ((r21 & 32) == 0) goto L13;
        boolean r23 = true;
    L15:
        if ((r21 & 64) == 0) goto L17;
        int r110 = 0;
    L19:
        if ((r21 & 128) == 0) goto L21;
        int r111 = 0;
    L22:
        r12.e(r13, r14, r15, r10, r11, r23, r110, r111);
        return;
    L21:
        r111 = r20;
        goto L22
    L17:
        r110 = r19;
        goto L19
    L13:
        r23 = r18;
        goto L15
    L9:
        r11 = r17;
        goto L11
    L5:
        r10 = r16;
        goto L7
    }

    public final int a(int r10, int r11) {
        Integer r12 = Integer.valueOf(r10 & 112);
        if (r12.intValue() != 0) goto L6;
        r12 = null;
    L6:
        if (r12 != null) goto L8;
        int r13 = 80;
    L9:
        int r14 = (r10 & 7) | r13;
        if (r11 == 90) goto L16;
        if (r11 == 270) goto L17;
        return r14;
    L17:
        return d(r14);
    L16:
        return c(r14);
    L8:
        r13 = r12.intValue();
        goto L9
    }

    public final Rect b(View r10) {
        View r11 = r10.getRootView();
        wd.a r12 = wd.a.f25402a;
        Context r13 = r10.getContext();
        q.f(r13, "anchor.context");
        Activity r14 = r12.b(r13);
        int[] r15 = new int[2];
        if (r14 == null) goto L5;
        r11 = r14.getWindow().getDecorView();
    L5:
        if (r11 == null) goto L8;
        r11.getLocationOnScreen(r15);
    L8:
        int r16 = r15[0];
        int r17 = r15[1];
        Integer r18 = null;
        if (r14 != null) goto L11;
    L10:
        Integer r19 = null;
    L18:
        if (r19 != null) goto L25;
        if (r11 != null) goto L21;
    L20:
        r19 = null;
    L23:
        if (r19 != null) goto L25;
        int r20 = r10.getResources().getDisplayMetrics().widthPixels;
    L26:
        if (r14 != null) goto L28;
    L27:
        Integer r21 = null;
    L35:
        if (r21 != null) goto L44;
        if (r11 == null) goto L41;
        Integer r22 = Integer.valueOf(r11.getHeight());
        if (r22.intValue() <= 0) goto L41;
        r18 = r22;
    L41:
        if (r18 != null) goto L43;
        int r23 = r10.getResources().getDisplayMetrics().heightPixels;
    L46:
        return new Rect(r16, r17, r20 + r16, r23 + r17);
    L43:
        r23 = r18.intValue();
        goto L46
    L44:
        r23 = r21.intValue();
        goto L46
    L28:
        Window r24 = r14.getWindow();
        if (r24 == null) goto L27;
        View r25 = r24.getDecorView();
        if (r25 == null) goto L27;
        r21 = Integer.valueOf(r25.getHeight());
        goto L35
    L21:
        r19 = Integer.valueOf(r11.getWidth());
        if (r19.intValue() <= 0) goto L20;
    L25:
        r20 = r19.intValue();
        goto L26
    L11:
        Window r26 = r14.getWindow();
        if (r26 == null) goto L10;
        View r27 = r26.getDecorView();
        if (r27 == null) goto L10;
        r19 = Integer.valueOf(r27.getWidth());
        goto L18
    }

    public final int c(int r10) {
        int r11 = r10 & 112;
        if (r11 != 48) goto L5;
        int r12 = 5;
    L9:
        int r13 = r10 & 7;
        if (r13 == 3) goto L15;
        if (r13 == 5) goto L16;
        return r12;
    L16:
        return r12 | 80;
    L15:
        return r12 | 48;
    L5:
        if (r11 == 80) goto L7;
        r12 = 0;
        goto L9
    L7:
        r12 = 3;
        goto L9
    }

    public final int d(int r10) {
        int r11 = r10 & 112;
        if (r11 != 48) goto L5;
        int r12 = 3;
    L9:
        int r13 = r10 & 7;
        if (r13 == 3) goto L15;
        if (r13 == 5) goto L16;
        return r12;
    L16:
        return r12 | 48;
    L15:
        return r12 | 80;
    L5:
        if (r11 == 80) goto L7;
        r12 = 0;
        goto L9
    L7:
        r12 = 5;
        goto L9
    }

    public final void e(OPopover r10, View r11, int r12, boolean r13, int r14, boolean r15, int r16, int r17) {
        q.g(r10, "popover");
        q.g(r11, "anchor");
        g(r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public final void g(OPopover r21, View r22, int r23, boolean r24, int r25, boolean r26, int r27, int r28) {
        if ((r23 & 112) != 0) goto L5;
        int r10 = r23 | 80;
    L72:
        Rect r11 = b(r22);     // Catch: Exception -> L9
        int[] r12 = new int[2];     // Catch: Exception -> L9
        r22.getLocationOnScreen(r12);     // Catch: Exception -> L9
        int r13 = r12[0] - r11.left;     // Catch: Exception -> L9
        int r14 = r12[1] - r11.top;     // Catch: Exception -> L9
        int r15 = r22.getMeasuredWidth() + r13;     // Catch: Exception -> L9
        int r16 = r22.getMeasuredHeight() + r14;     // Catch: Exception -> L9
        int r17 = r11.width();     // Catch: Exception -> L9
        int r18 = r11.height();     // Catch: Exception -> L9
        if (r11.top > 0) goto L11;
        int r19 = wd.a.g(r22.getContext());     // Catch: Exception -> L9
    L12:
        int r110 = tc.f.r(r22, 12);     // Catch: Exception -> L9
        if (r22.getRootWindowInsets() == null) goto L17;
        Insets r20 = r22.getRootWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());     // Catch: Exception -> L9
        q.f(r20, "anchor.rootWindowInsets.…Insets.Type.systemBars())");     // Catch: Exception -> L9
        int r29 = r20.bottom;     // Catch: Exception -> L9
        if (r29 <= 0) goto L17;
        r110 = r29;
    L17:
        int r30 = tc.f.r(r22, 8);     // Catch: Exception -> L9
        int r111 = tc.f.r(r22, 4);     // Catch: Exception -> L9
        r21.r(h.d((r18 - r19) - r110, 0));     // Catch: Exception -> L9
        r21.getContentView().measure(r27, r28);     // Catch: Exception -> L9
        int r31 = r21.getContentView().getMeasuredWidth();     // Catch: Exception -> L9
        int r32 = r21.getContentView().getMeasuredHeight();     // Catch: Exception -> L9
        int r33 = a(r10, ((r21.h() % 360) + 360) % 360);     // Catch: Exception -> L9
        int r34 = r33 & 112;     // Catch: Exception -> L9
        int r35 = r33 & 7;     // Catch: Exception -> L9
        int r112 = r10;
        if (r34 == 48) goto L20;
    L22:
        if (r34 != 80) goto L31;
        if (r24 == false) goto L26;
        int r113 = ((r16 + r32) - r22.getMeasuredHeight()) - r111;     // Catch: Exception -> L9
    L28:
        if (r113 <= (r18 - r110)) goto L31;
        r34 = 48;
        goto L31
    L26:
        r113 = (r16 + r32) + r25;     // Catch: Exception -> L9
    L31:
        if (r35 != 3) goto L33;
        int r36 = r15 - r31;     // Catch: Exception -> L9
    L37:
        int r114 = r17 - r31;     // Catch: Exception -> L9
        int r37 = r114 - r30;     // Catch: Exception -> L9
        if (r37 < r30) goto L40;
        int r38 = h.k(r36, r30, r37);     // Catch: Exception -> L9
    L41:
        if (r24 == false) goto L46;
        int r39 = Math.max(r30, (r15 + r111) - r31);     // Catch: Exception -> L9
        int r40 = Math.min(r37, r13 - r111);     // Catch: Exception -> L9
        if (r40 < r39) goto L46;
        r38 = h.k(r38, r39, r40);     // Catch: Exception -> L9
    L46:
        if (r34 != 48) goto L48;
        int r41 = (r14 - r32) - r25;     // Catch: Exception -> L9
    L49:
        int r115 = (r18 - r32) - r110;     // Catch: Exception -> L9
        if (r115 < r19) goto L52;
        int r42 = h.k(r41, r19, r115);     // Catch: Exception -> L9
    L53:
        if (r24 == false) goto L63;
        int r43 = r22.getMeasuredHeight();     // Catch: Exception -> L9
        if (r34 != 80) goto L57;
        int r116 = (r16 - r43) - r111;     // Catch: Exception -> L9
    L58:
        if (r115 < r19) goto L60;
        r19 = h.k(r116, r19, r115);     // Catch: Exception -> L9
    L60:
        r42 = r19;
        goto L63
    L57:
        r116 = (r16 - r32) + r111;     // Catch: Exception -> L9
    L63:
        r21.q(r112);     // Catch: Exception -> L9
        if (r26 == true) goto L67;
        int r44 = 0;
        r21.setFocusable(false);     // Catch: Exception -> L9
    L68:
        r21.p(true);     // Catch: Exception -> L9
        r21.showAtLocation(r22, r44, r38, r42);     // Catch: Exception -> L9
        return;
    L67:
        r44 = 0;
        goto L68
    L52:
        r42 = r19;
        goto L53
    L48:
        r41 = r16 + r25;     // Catch: Exception -> L9
        goto L49
    L40:
        r38 = h.k(r36, 0, Math.max(0, r114));     // Catch: Exception -> L9
        goto L41
    L33:
        if (r35 == 5) goto L35;
        r36 = ((r22.getMeasuredWidth() - r31) / 2) + r13;     // Catch: Exception -> L9
        goto L37
    L35:
        r36 = r13;
        goto L37
    L20:
        if (((r14 - r32) - r25) >= 0) goto L22;
        r34 = 80;
        goto L31
    L11:
        r19 = 0;
    L9:
        e = move-exception;
        L.c("OPopoverHelperEx1", "showPopoverSmartly failed", e);
        return;
    L5:
        r10 = r23;
        goto L72
    }
}
