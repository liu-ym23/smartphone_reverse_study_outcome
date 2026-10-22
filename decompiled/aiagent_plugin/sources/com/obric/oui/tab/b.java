package com.obric.oui.tab;

import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import com.obric.oui.common.style.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OTabLayoutHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f36325a = null;

    static {
        f36325a = new b();
    }

    private b() {
    }

    public static final void a(ViewGroup r13, float r14, int r15, int r16, boolean r17, boolean r18, RectF r19, RectF r20) {
        o.e(r13, "tabContainer");
        o.e(r19, "outLayerBounds");
        o.e(r20, "outOverlayBounds");
        int r3 = r13.getChildCount();
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L3:
        if (r5 >= r3) goto L19;
        int r8 = r5 + 1;
        View r9 = r13.getChildAt(r5);
        if (ZeusTransformUtils.instanceOf(r9, com.obric.oui.common.style.b.class) == false) goto L9;
        List<j> r10 = ((com.obric.oui.common.style.b) ZeusTransformUtils.preCheckCast(r9, com.obric.oui.common.style.b.class, "com.obric.aiagent.plugin")).getCurrentShadows();
        if (r10 == null) goto L9;
        Iterator<j> r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L9;
        j r12 = (j) ZeusTransformUtils.preCheckCast(r11.next(), j.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L12;
        if (r12.h() == false) goto L12;
        r6 = Math.max(r6, (int) Math.ceil((Math.abs(r12.c()) + r12.b()) + r12.e()));
        r7 = Math.max(r7, (int) Math.ceil((Math.abs(r12.d()) + r12.b()) + r12.e()));
    L9:
        r5 = r8;
        goto L3
    L19:
        if (r17 == false) goto L21;
        int r0 = 0;
    L22:
        float r1 = r14 - r0;
        float r21 = r15 + r14;
        if (r18 == true) goto L26;
        r4 = r6;
    L26:
        float r22 = r7;
        r19.set(r1, -r22, r4 + r21, r16 + r22);
        if (r17 == false) goto L29;
        float r2 = r19.left;
    L30:
        if (r18 == false) goto L32;
        r21 = r19.right;
    L32:
        r20.set(r2, r19.top, r21, r19.bottom);
        return;
    L29:
        r2 = r14;
        goto L30
    L21:
        r0 = r6;
        goto L22
    }
}
