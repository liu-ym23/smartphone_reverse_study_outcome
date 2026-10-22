package com.bytedance.android.live.search.impl.search.ui;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/ui/UserDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserDiffCallback extends DiffUtil.Callback {
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return 0;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(null, null);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(null, null);
    }
}
