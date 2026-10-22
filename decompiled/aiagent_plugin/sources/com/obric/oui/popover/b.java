package com.obric.oui.popover;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.View;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import d.x;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OPopoverHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "OPopoverHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f35995a = null;

    static {
        f35995a = new b();
    }

    private b() {
    }

    public static /* synthetic */ void a(b r14, OPopover r15, View r16, int r17, boolean r18, float r19, int r20, int r21, boolean r22, int r23, int r24, boolean r25, int r26, Object r27) {
        if ((r26 & 16) == 0) goto L5;
        float r7 = 0.0f;
    L7:
        if ((r26 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r26 & 64) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r26 & 128) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r26 & 256) == 0) goto L21;
        int r11 = 0;
    L23:
        if ((r26 & 512) == 0) goto L25;
        int r12 = 0;
    L27:
        if ((r26 & 1024) == 0) goto L29;
        boolean r13 = true;
    L30:
        r14.a(r15, r16, r17, r18, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r25;
        goto L30
    L25:
        r12 = r24;
        goto L27
    L21:
        r11 = r23;
        goto L23
    L17:
        r10 = r22;
        goto L19
    L13:
        r9 = r21;
        goto L15
    L9:
        r8 = r20;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }

    public final void a(OPopover r19, View r20, int r21, boolean r22, float r23, int r24, int r25, boolean r26, int r27, int r28, boolean r29) {
        o.e(r19, "popover");
        o.e(r20, "anchor");
        int[] r0 = new int[2];
        r20.getLocationOnScreen(r0);
        boolean r13 = false;
        boolean r14 = true;
        a("Popover", "location of parent: " + r0[0] + ':' + r0[1]);
        int r15 = r0[0];
        int r6 = r0[1];
        r19.setGravity$OUI_standardRelease(r21);
        r19.setXOffset(r24);
        r19.setYOffset(r25);
        r19.setAlignArrowPadding(r29);
        int[] r1 = r19.calTargetPosition$OUI_standardRelease(r22, r21, r20.getMeasuredWidth(), r20.getMeasuredHeight(), false, r26);
        r19.setGravity$OUI_standardRelease(3);
        if (r21 != 48) goto L5;
    L50:
        r19.setGravity$OUI_standardRelease(r21);
        Size r2 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        int r3 = r2.getHeight() - g.a(r20, 10);
        int r4 = r2.getWidth();
        int r5 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r19.setMaxContentHeight(n.c(r3 - r5, 0));
        int r7 = r19.getMeasuredHeight();
        int r8 = r19.getMeasuredWidth();
        r19.setGravity$OUI_standardRelease(3);
        if ((r6 + r1[1]) >= r5) goto L58;
        if (r26 == true) goto L55;
        a(this, r19, r20, 80, r22, r23, r24, -r25, true, r27, r28, false, 1024, null);
        return;
    L55:
        int r9 = r25 + (r5 - (r1[1] + r6));
    L56:
        int r12 = r9;
    L65:
        if ((r1[0] + r15) >= 0) goto L84;
        if (r22 == false) goto L73;
        if (r1[0] >= 0) goto L70;
        a(this, r19, r20, r21, false, r23, (-r15) + g.a(r20, 12), r25, false, r27, r28, false, 1024, null);
        return;
    L70:
        a(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L73:
        if (r23 == 0.0f) goto L76;
        r14 = false;
    L76:
        if (r14 == false) goto L81;
        if (r24 != 0) goto L81;
        if (r25 != 0) goto L81;
        r19.show(r20, r21, r22, (((g.a(r20, 25) + r15) + (r20.getMeasuredWidth() / 2)) - r19.getArrowHeight()) - g.a(r20, 3), (((-(r15 + r1[0])) - r19.getArrowHeight()) + g.a(r20, 10)) + g.a(r20, r27), r12, r26);
    L103:
        x r10 = x.f38692a;
        return;
    L81:
        a(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L84:
        if (((r1[0] + r15) + r8) <= r4) goto L99;
        if (r22 == false) goto L89;
        a(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L89:
        if (r23 == 0.0f) goto L92;
        r14 = false;
    L92:
        if (r14 == false) goto L97;
        if (r24 != 0) goto L97;
        if (r25 != 0) goto L97;
        r19.show(r20, r21, r22, ((((r20.getWidth() / 2) + r15) - ((r4 - r19.getMeasuredWidth()) + g.a(r20, 3))) - r19.getArrowHeight()) + g.a(r20, 10), ((r4 - (((r15 + r1[0]) + r8) - r19.getArrowHeight())) - g.a(r20, 10)) + g.a(r20, r28), r12, r26);
    L97:
        a(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L99:
        if (r22 == false) goto L101;
        int r11 = r24;
    L102:
        OPopover.show$default(r19, r20, r21, r22, r23, r11, r12, false, 64, null);
        goto L103
    L101:
        r11 = r1[0];
        goto L102
    L58:
        if (((r1[1] + r6) + r7) <= r3) goto L63;
        if (r26 == true) goto L62;
        a(this, r19, r20, 48, r22, r23, r24, -r25, true, r27, r28, false, 1024, null);
        return;
    L62:
        r9 = (r25 + r3) - ((r1[1] + r6) + r7);
        goto L56
    L63:
        r12 = r25;
        goto L65
    L5:
        if (r21 == 80) goto L50;
        r19.setGravity$OUI_standardRelease(r21);
        Context r16 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r16, "anchor.context");
        int r17 = g.b(r16);
        Context r18 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r18, "anchor.context");
        int r30 = g.a(r18);
        r19.setMaxContentHeight(r17);
        int r31 = r19.getMeasuredHeight();
        int r32 = r19.getMeasuredWidth();
        r19.setGravity$OUI_standardRelease(3);
        if (((r1[0] + r15) + r24) >= 0) goto L13;
        if (r26 == false) goto L10;
        a(this, r19, r20, 48, r22, r23, -r25, -Math.abs(r24), true, r27, r28, false, 1024, null);
        return;
    L10:
        a(this, r19, r20, 5, r22, r23, -r24, r25, true, r27, r28, false, 1024, null);
        return;
    L13:
        if ((((r15 + r1[0]) + r32) + r24) <= r30) goto L19;
        if (r26 == false) goto L16;
        a(this, r19, r20, 48, r22, r23, -r25, -Math.abs(r24), true, r27, r28, false, 1024, null);
        return;
    L16:
        a(this, r19, r20, 3, r22, r23, -r24, r25, true, r27, r28, false, 1024, null);
        return;
    L19:
        if ((r6 + r1[1]) >= 0) goto L34;
        if (r22 == false) goto L24;
        a(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L24:
        if (r23 != 0.0f) goto L26;
        r13 = true;
    L26:
        if (r13 == false) goto L31;
        if (r24 != 0) goto L31;
        if (r25 != 0) goto L31;
        OPopover.show$default(r19, r20, r21, r22, (r6 - g.a(r20, 15)) + r20.getHeight(), r24, (-r6) - r1[1], false, 64, null);
    L49:
        x r33 = x.f38692a;
        return;
    L31:
        a(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L34:
        if (((r6 + r1[1]) + r31) <= r17) goto L48;
        if (r22 == false) goto L39;
        a(this, r19, r20, r21, false, r23, r24, r25, true, r27, r28, false, 1024, null);
        return;
    L39:
        if (r23 != 0.0f) goto L41;
        r13 = true;
    L41:
        if (r13 == false) goto L46;
        if (r24 != 0) goto L46;
        if (r25 != 0) goto L46;
        OPopover.show$default(r19, r20, r21, r22, -(((r17 - (r6 + r20.getHeight())) - g.a(r20, 15)) + (r20.getHeight() / 2)), r24, r17 - ((r6 + r1[1]) + r31), false, 64, null);
    L46:
        a(this, r19, r20, r21, r22, 0.0f, 0, 0, false, 0, 0, false, 2032, null);
        return;
    L48:
        OPopover.show$default(r19, r20, r21, r22, r23, r24, r25, false, 64, null);
        goto L49
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
