package com.obric.oui.orecyclerview.widget;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class OpReorderer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callback f15428a;

    public interface Callback {
        AdapterHelper.a obtainUpdateOp(int r10, int r11, int r12, Object r13);

        void recycleUpdateOp(AdapterHelper.a r10);
    }

    public OpReorderer(Callback r10) {
        this.f15428a = r10;
    }

    public final int a(List r10) {
        int r11 = r10.size() - 1;
        boolean r12 = false;
    L3:
        if (r11 < 0) goto L10;
        if (((AdapterHelper.a) r10.get(r11)).f15385a != 8) goto L8;
        if (r12 == false) goto L9;
        return r11;
    L9:
        r11 = r11 - 1;
        goto L3
    L8:
        r12 = true;
        goto L9
    L10:
        return -1;
    }

    public void b(List r10) {
    L2:
        int r11 = a(r10);
        if (r11 == (-1)) goto L5;
        d(r10, r11, r11 + 1);
        goto L2
    }

    public final void c(List r10, int r11, AdapterHelper.a r12, int r13, AdapterHelper.a r14) {
        int r15 = r12.f15388d;
        int r16 = r14.f15386b;
        if (r15 >= r16) goto L5;
        int r17 = -1;
    L6:
        int r18 = r12.f15386b;
        if (r18 >= r16) goto L9;
        r17 = r17 + 1;
    L9:
        if (r16 > r18) goto L11;
        r12.f15386b = r18 + r14.f15388d;
    L11:
        int r19 = r14.f15386b;
        if (r19 > r15) goto L14;
        r12.f15388d = r15 + r14.f15388d;
    L14:
        r14.f15386b = r19 + r17;
        r10.set(r11, r14);
        r10.set(r13, r12);
        return;
    L5:
        r17 = 0;
        goto L6
    }

    public final void d(List r10, int r11, int r12) {
        AdapterHelper.a r13 = (AdapterHelper.a) r10.get(r11);
        AdapterHelper.a r14 = (AdapterHelper.a) r10.get(r12);
        int r15 = r14.f15385a;
        if (r15 != 1) goto L5;
        c(r10, r11, r13, r12, r14);
        return;
    L5:
        if (r15 != 2) goto L7;
        e(r10, r11, r13, r12, r14);
        return;
    L7:
        if (r15 != 4) goto L15;
        f(r10, r11, r13, r12, r14);
        return;
    }

    public void e(List r10, int r11, AdapterHelper.a r12, int r13, AdapterHelper.a r14) {
        int r15 = r12.f15386b;
        int r16 = r12.f15388d;
        boolean r17 = false;
        if (r15 >= r16) goto L11;
        if (r14.f15386b == r15) goto L7;
    L9:
        boolean r18 = false;
    L16:
        int r19 = r14.f15386b;
        if (r16 >= r19) goto L19;
        r14.f15386b = r19 - 1;
    L25:
        int r20 = r12.f15386b;
        int r21 = r14.f15386b;
        AdapterHelper.a r22 = null;
        if (r20 > r21) goto L28;
        r14.f15386b = r21 + 1;
    L31:
        if (r17 == false) goto L34;
        r10.set(r11, r14);
        r10.remove(r13);
        this.f15428a.recycleUpdateOp(r12);
        return;
    L34:
        if (r18 == false) goto L48;
        if (r22 == null) goto L42;
        int r23 = r12.f15386b;
        if (r23 <= r22.f15386b) goto L39;
        r12.f15386b = r23 - r22.f15388d;
    L39:
        int r24 = r12.f15388d;
        if (r24 <= r22.f15386b) goto L42;
        r12.f15388d = r24 - r22.f15388d;
    L42:
        int r25 = r12.f15386b;
        if (r25 <= r14.f15386b) goto L45;
        r12.f15386b = r25 - r14.f15388d;
    L45:
        int r26 = r12.f15388d;
        if (r26 <= r14.f15386b) goto L61;
        r12.f15388d = r26 - r14.f15388d;
    L61:
        r10.set(r11, r14);
        if (r12.f15386b == r12.f15388d) goto L64;
        r10.set(r13, r12);
    L65:
        if (r22 == null) goto L69;
        r10.add(r11, r22);
        return;
    L69:
        return;
    L64:
        r10.remove(r13);
        goto L65
    L48:
        if (r22 == null) goto L55;
        int r27 = r12.f15386b;
        if (r27 < r22.f15386b) goto L52;
        r12.f15386b = r27 - r22.f15388d;
    L52:
        int r28 = r12.f15388d;
        if (r28 < r22.f15386b) goto L55;
        r12.f15388d = r28 - r22.f15388d;
    L55:
        int r29 = r12.f15386b;
        if (r29 < r14.f15386b) goto L58;
        r12.f15386b = r29 - r14.f15388d;
    L58:
        int r30 = r12.f15388d;
        if (r30 < r14.f15386b) goto L61;
        r12.f15388d = r30 - r14.f15388d;
        goto L61
    L28:
        int r31 = r14.f15388d;
        if (r20 >= (r21 + r31)) goto L31;
        r22 = this.f15428a.obtainUpdateOp(2, r20 + 1, (r21 + r31) - r20, null);
        r14.f15388d = r12.f15386b - r14.f15386b;
        goto L31
    L19:
        int r32 = r14.f15388d;
        if (r16 >= (r19 + r32)) goto L25;
        r14.f15388d = r32 - 1;
        r12.f15385a = 2;
        r12.f15388d = 1;
        if (r14.f15388d != 0) goto L68;
        r10.remove(r13);
        this.f15428a.recycleUpdateOp(r14);
        return;
    L68:
        return;
    L7:
        if (r14.f15388d != (r16 - r15)) goto L9;
        r18 = false;
        r17 = true;
        goto L16
    L11:
        if (r14.f15386b == (r16 + 1)) goto L13;
    L15:
        r18 = true;
        goto L16
    L13:
        if (r14.f15388d != (r15 - r16)) goto L15;
        r18 = true;
        r17 = true;
        goto L16
    }

    public void f(List r10, int r11, AdapterHelper.a r12, int r13, AdapterHelper.a r14) {
        int r15 = r12.f15388d;
        int r16 = r14.f15386b;
        AdapterHelper.a r17 = null;
        if (r15 >= r16) goto L5;
        r14.f15386b = r16 - 1;
    L8:
        AdapterHelper.a r18 = null;
    L9:
        int r19 = r12.f15386b;
        int r20 = r14.f15386b;
        if (r19 > r20) goto L12;
        r14.f15386b = r20 + 1;
    L15:
        r10.set(r13, r12);
        if (r14.f15388d <= 0) goto L18;
        r10.set(r11, r14);
    L19:
        if (r18 == null) goto L21;
        r10.add(r11, r18);
    L21:
        if (r17 == null) goto L24;
        r10.add(r11, r17);
        return;
    L24:
        return;
    L18:
        r10.remove(r11);
        this.f15428a.recycleUpdateOp(r14);
        goto L19
    L12:
        int r21 = r14.f15388d;
        if (r19 >= (r20 + r21)) goto L15;
        int r22 = (r20 + r21) - r19;
        r17 = this.f15428a.obtainUpdateOp(4, r19 + 1, r22, r14.f15387c);
        r14.f15388d -= r22;
        goto L15
    L5:
        int r23 = r14.f15388d;
        if (r15 >= (r16 + r23)) goto L8;
        r14.f15388d = r23 - 1;
        r18 = this.f15428a.obtainUpdateOp(4, r12.f15386b, 1, r14.f15387c);
        goto L9
    }
}
