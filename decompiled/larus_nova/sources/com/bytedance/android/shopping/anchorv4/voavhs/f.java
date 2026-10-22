package com.bytedance.android.shopping.anchorv4.voavhs;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f implements com.bytedance.android.ecom.arch.slice.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f168335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ecom.arch.slice.slices.b<List<com.bytedance.android.ecom.arch.slice.g>> f168336b;

    @Override // com.bytedance.android.ecom.arch.slice.f
    public final RecyclerView.LayoutParams a(boolean r100) {
        if (this.f168335a.getLayoutManager() == null) goto L5;
        boolean r101 = true;
    L6:
        nq.a.e(r101, RecyclerViewDelegate$createSliceLayoutParam$1.INSTANCE, 2);
        RecyclerView.LayoutManager r102 = this.f168335a.getLayoutManager();
        if (r102 == null) goto L11;
        RecyclerView.LayoutParams r103 = r102.generateDefaultLayoutParams();
        if (r103 == null) goto L11;
        ((ViewGroup.MarginLayoutParams) r103).width = -1;
        ((ViewGroup.MarginLayoutParams) r103).height = -2;
    L12:
        if (r100 == true) goto L14;
    L16:
        return r103;
    L14:
        if ((r103 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L16;
        ((StaggeredGridLayoutManager.LayoutParams) r103).setFullSpan(true);
    L11:
        r103 = null;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public f(RecyclerView r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f168335a = r100;
        this.f168336b = r101;
    }
}
