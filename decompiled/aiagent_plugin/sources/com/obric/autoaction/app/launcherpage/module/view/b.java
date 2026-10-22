package com.obric.autoaction.app.launcherpage.module.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d.h.b.o;

/* JADX INFO: compiled from: DividerItemDecoration.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends RecyclerView.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f24287a;

    public b(int r1) {
        this.f24287a = r1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(Rect r2, View r3, RecyclerView r4, RecyclerView.r r5) {
        o.e(r2, "outRect");
        o.e(r3, "view");
        o.e(r4, "parent");
        o.e(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.a r7 = r4.getAdapter();
        if (r7 == null) goto L5;
        int r8 = r7.a();
    L7:
        if (r6 == (r8 - 1)) goto L10;
        r2.bottom = this.f24287a;
        return;
    L10:
        return;
    L5:
        r8 = 0;
        goto L7
    }
}
