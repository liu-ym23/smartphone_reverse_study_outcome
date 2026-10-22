package com.bytedance.android.livesdk.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper;

/* JADX INFO: loaded from: classes11.dex */
public final class o extends GridPagerSnapHelper {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ EmojiSelectPanel f161900h;

    public o(EmojiSelectPanel r100) {
        this.f161900h = r100;
    }

    @Override // com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper, com.bytedance.android.livesdk.widget.pager.SnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r100) {
        View r101 = super.findSnapView(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        EmojiSelectPanel r102 = this.f161900h;
        r102.f160852f = r100.getPosition(r101);
        EmojiSelectPanel r103 = this.f161900h;
        EmojiSelectPanel.R5(r103, r103.f160852f);
        return r101;
    }

    @Override // com.bytedance.android.livesdk.widget.pager.GridPagerSnapHelper, com.bytedance.android.livesdk.widget.pager.SnapHelper
    public final int findTargetSnapPosition(RecyclerView.LayoutManager r100, int r101, int r102) {
        EmojiSelectPanel r103 = this.f161900h;
        r103.f160852f = super.findTargetSnapPosition(r100, r101, r102);
        EmojiSelectPanel r104 = this.f161900h;
        EmojiSelectPanel.R5(r104, r104.f160852f);
        return this.f161900h.f160852f;
    }
}
