package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes8.dex */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f118705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f118706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f118707c;

    public SpaceItemDecoration() {
        throw null;
    }

    public SpaceItemDecoration(int r100, int r101, boolean r102) {
        this.f118706b = r100;
        this.f118705a = r101;
        this.f118707c = r102;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        int r104 = r102.getChildPosition(r101);
        int r105 = this.f118706b;
        if (r105 != 0) goto L7;
        if (r104 == 0) goto L14;
        r100.left = this.f118705a;
        return;
    L14:
        return;
    L7:
        if (1 == r105) goto L9;
        return;
    L9:
        if (this.f118707c == false) goto L12;
        if (r104 == 0) goto L17;
        r100.top = this.f118705a;
        return;
    L17:
        return;
    L12:
        r100.top = this.f118705a;
    }
}
