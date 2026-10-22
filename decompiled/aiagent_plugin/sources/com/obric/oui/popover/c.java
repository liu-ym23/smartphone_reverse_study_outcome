package com.obric.oui.popover;

import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: OPopoverHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static /* synthetic */ void a(OPopover r9, View r10, int r11, boolean r12, float r13, int r14, int r15, boolean r16, int r17, Object r18) {
        if ((r17 & 8) == 0) goto L5;
        float r5 = 0.0f;
    L7:
        if ((r17 & 16) == 0) goto L9;
        int r6 = 0;
    L11:
        if ((r17 & 32) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r17 & 64) == 0) goto L17;
        boolean r8 = false;
    L18:
        a(r9, r10, r11, r12, r5, r6, r7, r8);
        return;
    L17:
        r8 = r16;
        goto L18
    L13:
        r7 = r15;
        goto L15
    L9:
        r6 = r14;
        goto L11
    L5:
        r5 = r13;
        goto L7
    }

    public static final void a(OPopover r15, View r16, int r17, boolean r18, float r19, int r20, int r21, boolean r22) {
        o.e(r15, "<this>");
        o.e(r16, "anchor");
        b.a(b.f35995a, r15, r16, r17, r18, r19, r20, r21, r22, 0, 0, false, 1792, null);
    }
}
