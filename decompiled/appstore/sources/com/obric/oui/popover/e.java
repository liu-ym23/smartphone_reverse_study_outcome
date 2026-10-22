package com.obric.oui.popover;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.View;
import bg.h;
import kotlin.Unit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16131a = null;

    static {
        f16131a = new e();
    }

    public e() {
    }

    public static /* synthetic */ void b(e r14, OPopover r15, View r16, int r17, boolean r18, float r19, int r20, int r21, boolean r22, int r23, int r24, boolean r25, int r26, Object r27) {
        if ((r26 & 16) == 0) goto L5;
        float r10 = 0.0f;
    L7:
        if ((r26 & 32) == 0) goto L9;
        int r11 = 0;
    L11:
        if ((r26 & 64) == 0) goto L13;
        int r12 = 0;
    L15:
        if ((r26 & 128) == 0) goto L17;
        boolean r13 = false;
    L19:
        if ((r26 & 256) == 0) goto L21;
        int r110 = 0;
    L23:
        if ((r26 & 512) == 0) goto L25;
        int r111 = 0;
    L27:
        if ((r26 & 1024) == 0) goto L29;
        boolean r112 = true;
    L30:
        r14.a(r15, r16, r17, r18, r10, r11, r12, r13, r110, r111, r112);
        return;
    L29:
        r112 = r25;
        goto L30
    L25:
        r111 = r24;
        goto L27
    L21:
        r110 = r23;
        goto L23
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }

    public final void a(OPopover r19, View r20, int r21, boolean r22, float r23, int r24, int r25, boolean r26, int r27, int r28, boolean r29) {
        q.g(r19, "popover");
        q.g(r20, "anchor");
        int[] r10 = new int[2];
        r20.getLocationOnScreen(r10);
        Log.i("Popover", "location of parent: " + r10[0] + ':' + r10[1]);
        int r15 = r10[0];
        int r11 = r10[1];
        r19.C(r21);
        r19.F(r24);
        r19.G(r25);
        r19.x(r29);
        int[] r12 = r19.l(r22, r21, r20.getMeasuredWidth(), r20.getMeasuredHeight(), false, r26);
        r19.C(3);
        if (r21 != 48) goto L5;
    L46:
        r19.C(r21);
        Size r13 = wd.a.c(r20.getContext());
        int r14 = r13.getHeight() - tc.f.r(r20, 10);
        int r16 = r13.getWidth();
        int r17 = wd.a.g(r20.getContext());
        r19.D(h.d(r14 - r17, 0));
        int r18 = r19.p();
        int r110 = r19.q();
        r19.C(3);
        int r111 = r12[1];
        if ((r11 + r111) >= r17) goto L54;
        if (r26 == true) goto L51;
        b(this, r19, r20, 80, r22, r23, r24, -r25, true, r27, r28, false, 1024, null);
        return;
    L51:
        int r30 = r25 + (r17 - (r11 + r111));
    L52:
        int r31 = r30;
    L60:
        int r32 = r12[0];
        if ((r15 + r32) >= 0) goto L76;
        if (r22 == false) goto L68;
        if (r32 >= 0) goto L65;
        b(this, r19, r20, r21, false, r23, (-r15) + tc.f.r(r20, 12), r25, false, r27, r28, false, 1024, null);
        return;
    L65:
        b(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L68:
        if (r23 != 0.0f) goto L73;
        if (r24 != 0) goto L73;
        if (r25 != 0) goto L73;
        r19.H(r20, r21, r22, (((tc.f.r(r20, 25) + r15) + (r20.getMeasuredWidth() / 2)) - r19.n()) - tc.f.r(r20, 3), (((-(r15 + r12[0])) - r19.n()) + tc.f.r(r20, 10)) + tc.f.r(r20, r27), r31, r26);
    L92:
        Unit r33 = Unit.f21064a;
        return;
    L73:
        b(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L76:
        if (((r15 + r32) + r110) <= r16) goto L88;
        if (r22 == false) goto L81;
        b(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L81:
        if (r23 != 0.0f) goto L86;
        if (r24 != 0) goto L86;
        if (r25 != 0) goto L86;
        r19.H(r20, r21, r22, ((((r20.getWidth() / 2) + r15) - ((r16 - r19.q()) + tc.f.r(r20, 3))) - r19.n()) + tc.f.r(r20, 10), ((r16 - (((r15 + r12[0]) + r110) - r19.n())) - tc.f.r(r20, 10)) + tc.f.r(r20, r28), r31, r26);
    L86:
        b(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L88:
        if (r22 == false) goto L90;
        int r34 = r24;
    L91:
        OPopover.J(r19, r20, r21, r22, r23, r34, r31, false, 64, null);
        goto L92
    L90:
        r34 = r32;
        goto L91
    L54:
        if (((r11 + r111) + r18) <= r14) goto L59;
        if (r26 == true) goto L58;
        b(this, r19, r20, 48, r22, r23, r24, -r25, true, r27, r28, false, 1024, null);
        return;
    L58:
        r30 = (r25 + r14) - ((r11 + r111) + r18);
        goto L52
    L59:
        r31 = r25;
        goto L60
    L5:
        if (r21 == 80) goto L46;
        r19.C(r21);
        Context r35 = r20.getContext();
        q.f(r35, "anchor.context");
        int r36 = tc.f.m(r35);
        Context r37 = r20.getContext();
        q.f(r37, "anchor.context");
        int r38 = tc.f.n(r37);
        r19.D(r36);
        int r39 = r19.p();
        int r40 = r19.q();
        r19.C(3);
        int r41 = r12[0];
        if (((r15 + r41) + r24) >= 0) goto L13;
        if (r26 == false) goto L10;
        b(this, r19, r20, 48, r22, r23, -r25, -Math.abs(r24), true, r27, r28, false, 1024, null);
        return;
    L10:
        b(this, r19, r20, 5, r22, r23, -r24, r25, true, r27, r28, false, 1024, null);
        return;
    L13:
        if ((((r15 + r41) + r40) + r24) <= r38) goto L18;
        if (r26 == false) goto L16;
        b(this, r19, r20, 48, r22, r23, -r25, -Math.abs(r24), true, r27, r28, false, 1024, null);
        return;
    L16:
        b(this, r19, r20, 3, r22, r23, -r24, r25, true, r27, r28, false, 1024, null);
        return;
    L18:
        int r42 = r12[1];
        if ((r11 + r42) >= 0) goto L32;
        if (r22 == false) goto L24;
        b(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L24:
        if (r23 != 0.0f) goto L29;
        if (r24 != 0) goto L29;
        if (r25 != 0) goto L29;
        OPopover.J(r19, r20, r21, r22, (r11 - tc.f.r(r20, 15)) + r20.getHeight(), r24, (-r11) - r12[1], false, 64, null);
    L45:
        Unit r43 = Unit.f21064a;
        return;
    L29:
        b(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L32:
        if (((r11 + r42) + r39) <= r36) goto L44;
        if (r22 == false) goto L37;
        b(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L37:
        if (r23 != 0.0f) goto L42;
        if (r24 != 0) goto L42;
        if (r25 != 0) goto L42;
        OPopover.J(r19, r20, r21, r22, -(((r36 - (r11 + r20.getHeight())) - tc.f.r(r20, 15)) + (r20.getHeight() / 2)), r24, r36 - ((r11 + r12[1]) + r39), false, 64, null);
    L42:
        b(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L44:
        OPopover.J(r19, r20, r21, r22, r23, r24, r25, false, 64, null);
        goto L45
    }
}
