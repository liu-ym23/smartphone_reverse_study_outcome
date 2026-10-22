package com.bytedance.android.ecom.arch.slice.render.elements.list;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/list/SlcLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f50453a;

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f50453a == false) goto L10;
        if (getOrientation() != 0) goto L8;
        return new RecyclerView.LayoutParams(-2, -1);
    L8:
        return new RecyclerView.LayoutParams(-1, -2);
    L10:
        return super.generateDefaultLayoutParams();
    }

    public SlcLinearLayoutManager(Context r100, int r101) {
        super(r100, r101, false);
        this.f50453a = true;
    }
}
