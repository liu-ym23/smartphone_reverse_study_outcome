package com.obric.autoaction.app.launcherpage.module.view;

import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: RVSpaceItemDecoration.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends RecyclerView.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f24289b;

    public /* synthetic */ c(int r1, boolean r2, int r3, h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public c(int r1, boolean r2) {
        this.f24288a = r1;
        this.f24289b = r2;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.g
    public void a(Rect r4, View r5, RecyclerView r6, RecyclerView.s r7) {
        o.e(r4, "outRect");
        o.e(r5, "view");
        o.e(r6, "parent");
        o.e(r7, "state");
        RecyclerView.a r8 = r6.getAdapter();
        if (r8 == null) goto L5;
        int r9 = r8.a();
    L6:
        int r10 = r9 - 1;
        int r11 = r6.getChildAdapterPosition(r5);
        if (r11 != (-1)) goto L9;
        return;
    L9:
        if (r11 == r10) goto L15;
        if (this.f24289b == false) goto L13;
        r4.right = this.f24288a;
        goto L15
    L13:
        r4.bottom = this.f24288a;
    L15:
        if (r11 != 0) goto L17;
        r4.top = d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
    L17:
        RecyclerView.v r12 = r6.findViewHolderForAdapterPosition(r11);
        RecyclerView.v r13 = r6.findViewHolderForAdapterPosition(r11 - 1);
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autoaction.app.launcherpage.module.a.b.class) == false) goto L22;
        if (r11 == 0) goto L22;
        r4.top = d.i.a.a(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
    L22:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autoaction.app.launcherpage.module.a.d.class) == false) goto L25;
        r4.top = d.i.a.a(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
        r4.bottom = 0;
    L25:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autoaction.app.launcherpage.module.a.d.class) == false) goto L27;
        r4.top = 0;
    L27:
        if (r12 == null) goto L35;
        if (r13 != null) goto L30;
        return;
    L30:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.autoaction.app.launcherpage.module.a.e.class) == true) goto L32;
        return;
    L32:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.autoaction.app.launcherpage.module.a.c.class) == false) goto L38;
        r4.top = d.i.a.a(TypedValue.applyDimension(1, 16, Resources.getSystem().getDisplayMetrics()));
        return;
    L38:
        return;
    L35:
        return;
    L5:
        r9 = 0;
        goto L6
    }
}
