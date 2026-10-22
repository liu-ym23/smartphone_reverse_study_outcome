package com.obric.oui.common.util;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ViewExtensionsKt$clipCorner$1 extends ViewOutlineProvider {
    final /* synthetic */ boolean $bottomLeft;
    final /* synthetic */ boolean $bottomRight;
    final /* synthetic */ float $cornerRadius;
    final /* synthetic */ View $this_clipCorner;
    final /* synthetic */ boolean $topLeft;
    final /* synthetic */ boolean $topRight;

    ViewExtensionsKt$clipCorner$1(View r1, boolean r2, boolean r3, boolean r4, boolean r5, float r6) {
        this.$this_clipCorner = r1;
        this.$topLeft = r2;
        this.$topRight = r3;
        this.$bottomLeft = r4;
        this.$bottomRight = r5;
        this.$cornerRadius = r6;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View r11, Outline r12) {
        int r3 = this.$this_clipCorner.getWidth();
        int r8 = this.$this_clipCorner.getHeight();
        int r13 = (((g.a(this.$topLeft) << 3) + (g.a(this.$topRight) << 2)) + (g.a(this.$bottomLeft) << 1)) + g.a(this.$bottomRight);
        if (r13 == 1) goto L43;
        if (r13 == 2) goto L40;
        if (r13 != 3) goto L7;
        if (r12 == null) goto L62;
        float r5 = this.$cornerRadius;
        r12.setRoundRect(0, (int) (0 - r5), r3, r8, r5);
        return;
    L62:
        return;
    L7:
        if (r13 != 4) goto L9;
        if (r12 == null) goto L61;
        float r6 = this.$cornerRadius;
        r12.setRoundRect((int) (0 - r6), 0, r3, (int) (r8 + r6), r6);
        return;
    L61:
        return;
    L9:
        if (r13 != 5) goto L11;
        if (r12 == null) goto L60;
        float r7 = this.$cornerRadius;
        r12.setRoundRect((int) (0 - r7), 0, r3, r8, r7);
        return;
    L60:
        return;
    L11:
        if (r13 != 8) goto L13;
        if (r12 == null) goto L59;
        float r9 = this.$cornerRadius;
        r12.setRoundRect(0, 0, (int) (r3 + r9), (int) (r8 + r9), r9);
        return;
    L59:
        return;
    L13:
        if (r13 != 10) goto L15;
        if (r12 == null) goto L58;
        float r10 = this.$cornerRadius;
        r12.setRoundRect(0, 0, (int) (r3 + r10), r8, r10);
        return;
    L58:
        return;
    L15:
        if (r13 != 12) goto L17;
        if (r12 == null) goto L57;
        float r14 = this.$cornerRadius;
        r12.setRoundRect(0, 0, r3, (int) (r8 + r14), r14);
        return;
    L57:
        return;
    L17:
        if (r13 != 15) goto L55;
        if (r12 == null) goto L56;
        r12.setRoundRect(0, 0, r3, r8, this.$cornerRadius);
        return;
    L56:
        return;
    L55:
        return;
    L40:
        if (r12 == null) goto L63;
        float r15 = this.$cornerRadius;
        r12.setRoundRect(0, (int) (0 - r15), (int) (r3 + r15), r8, r15);
        return;
    L63:
        return;
    L43:
        if (r12 == null) goto L64;
        float r16 = 0;
        float r17 = this.$cornerRadius;
        r12.setRoundRect((int) (r16 - r17), (int) (r16 - r17), r3, r8, r17);
        return;
    }
}
