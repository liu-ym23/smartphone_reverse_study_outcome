package com.bytedanceos.appstore.buss.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9286d;

    public e(int r10, int r11, int r12, int r13) {
        this.f9283a = r10;
        this.f9284b = r11;
        this.f9285c = r12;
        this.f9286d = r13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        q.g(r10, "outRect");
        q.g(r11, "view");
        q.g(r12, "parent");
        q.g(r13, WsConstants.KEY_CONNECTION_STATE);
        super.getItemOffsets(r10, r11, r12, r13);
        r10.set(this.f9283a, this.f9284b, this.f9285c, this.f9286d);
    }

    public /* synthetic */ e(int r10, int r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = com.bytedanceos.appstore.buss.utilities.f.f8838a.b();
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = 0;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = 0;
    L14:
        this(r10, r11, r12, r13);
    }
}
