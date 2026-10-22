package com.bytedance.android.livesdk.feed.ui;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes8.dex */
public class OpenItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f124530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f124531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f124532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f124533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f124534e;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        super.getItemOffsets(r100, r101, r102, r103);
        int r104 = r102.getChildAdapterPosition(r101);
        int r105 = this.f124534e;
        if (r105 <= 0) goto L8;
        if (r104 != 0) goto L6;
    L7:
        r100.top = r105;
    L10:
        if ((r104 % 2) != 0) goto L12;
        r100.right = this.f124532c;
    L13:
        r100.bottom = this.f124533d;
        return;
    L12:
        r100.left = this.f124530a;
        goto L13
    L6:
        if (r104 == 1) goto L7;
    L8:
        r100.top = this.f124531b;
        goto L10
    }

    public OpenItemDecoration(int r100, int r101, int r102, int r103, int r104) {
        this.f124530a = 0;
        this.f124531b = 0;
        this.f124532c = 0;
        this.f124533d = 0;
        this.f124534e = 0;
        this.f124530a = r100;
        this.f124531b = r101;
        this.f124532c = r102;
        this.f124533d = r103;
        this.f124534e = r104;
    }
}
