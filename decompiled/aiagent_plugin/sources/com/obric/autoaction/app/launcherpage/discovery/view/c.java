package com.obric.autoaction.app.launcherpage.discovery.view;

import android.graphics.Rect;
import android.view.View;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.obric.oui.common.util.g;
import com.obric.oui.orecyclerview.widget.GridLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DiscoveryListDecoration.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends RecyclerView.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23668b;

    public c(int r1, int r2) {
        this.f23667a = r1;
        this.f23668b = r2;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Rect r10, View r11, RecyclerView r12, RecyclerView.s r13) {
        o.e(r10, "outRect");
        o.e(r11, "view");
        o.e(r12, "parent");
        o.e(r13, "state");
        RecyclerView.a r14 = r12.getAdapter();
        int r0 = 0;
        if (r14 == null) goto L5;
        int r15 = r14.a();
    L6:
        int r16 = r15 - 1;
        int r2 = r12.getChildAdapterPosition(r11);
        if (r2 != (-1)) goto L9;
        return;
    L9:
        RecyclerView.h r3 = r12.getLayoutManager();
        h r6 = null;
        if (ZeusTransformUtils.instanceOf(r3, GridLayoutManager.class) == false) goto L12;
        GridLayoutManager r4 = (GridLayoutManager) ZeusTransformUtils.preCheckCast(r3, GridLayoutManager.class, "com.obric.aiagent.plugin");
    L13:
        if (r4 != null) goto L15;
        return;
    L15:
        GridLayoutManager.b r5 = r4.b();
        int r7 = r5.a(r2, this.f23668b);
        int r8 = r5.a(r2);
        RecyclerView.a r17 = r12.getAdapter();
        if (ZeusTransformUtils.instanceOf(r17, com.obric.autoaction.app.launcherpage.ui.d.class) == false) goto L18;
        com.obric.autoaction.app.launcherpage.ui.d r18 = (com.obric.autoaction.app.launcherpage.ui.d) ZeusTransformUtils.preCheckCast(r17, com.obric.autoaction.app.launcherpage.ui.d.class, "com.obric.aiagent.plugin");
    L20:
        if (r2 == r16) goto L22;
        r10.bottom = this.f23667a;
    L24:
        if ((r16 - r5.a(r16, this.f23668b)) > r2) goto L27;
        if (r2 > r16) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L30;
        r10.bottom = g.a(r11, 24);
    L30:
        int r9 = r2 - r7;
        if (r18 == null) goto L33;
        h r110 = r18.b(r9);
    L34:
        if (r9 <= 0) goto L37;
        if (r18 == null) goto L37;
        r6 = r18.b(r9 - 1);
    L37:
        if (r9 != 0) goto L42;
        if (ZeusTransformUtils.instanceOf(r110, com.obric.autoaction.app.launcherpage.discovery.a.b.d.class) == false) goto L42;
        r0 = g.a(r11, 8);
    L51:
        r10.top = r0;
        r10.left = g.a(r11, 12);
        r10.right = g.a(r11, 12);
        if (r8 == 1) goto L54;
        return;
    L54:
        if (r7 != 0) goto L56;
        r10.right = g.a(r11, 4);
        return;
    L56:
        r10.left = g.a(r11, 4);
        return;
    L42:
        if (r9 != 0) goto L45;
        r0 = g.a(r11, 16);
        goto L51
    L45:
        if (ZeusTransformUtils.instanceOf(r110, com.obric.autoaction.app.launcherpage.discovery.a.b.d.class) == false) goto L51;
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.discovery.a.b.c.class) == false) goto L49;
    L50:
        r0 = g.a(r11, 16) - this.f23667a;
        goto L51
    L49:
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autoaction.app.launcherpage.discovery.a.b.a.class) == false) goto L51;
    L33:
        r110 = null;
    L27:
        r19 = false;
        goto L28
    L22:
        r10.bottom = g.a(r11, 24);
        goto L24
    L18:
        r18 = null;
        goto L20
    L12:
        r4 = null;
        goto L13
    L5:
        r15 = 0;
        goto L6
    }
}
