package com.bytedance.android.live.core.viewholder;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/viewholder/MemorySafeLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MemorySafeLinearLayoutManager extends LinearLayoutManager {
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onDetachedFromWindow(r100, r101);
        RecyclerView.Adapter r102 = r100.getAdapter();
        if (r102 == null) goto L10;
        int r103 = r102.getItemCount() - 1;
    L5:
        if (r103 < 0) goto L14;
        RecyclerView.ViewHolder r104 = r100.findViewHolderForAdapterPosition(r103);
        if ((r104 instanceof BaseViewHolder) == false) goto L9;
        ((BaseViewHolder) r104).unbind();
    L9:
        r103 = r103 - 1;
        goto L5
    L14:
        return;
    }

    public MemorySafeLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102, r103);
    }
}
