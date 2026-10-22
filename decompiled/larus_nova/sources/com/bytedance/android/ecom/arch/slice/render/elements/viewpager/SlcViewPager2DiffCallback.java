package com.bytedance.android.ecom.arch.slice.render.elements.viewpager;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/elements/viewpager/SlcViewPager2DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/bytedance/android/ecom/arch/slice/render/elements/viewpager/SlcViewPager2ItemData;", "<init>", "()V", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcViewPager2DiffCallback extends DiffUtil.ItemCallback<SlcViewPager2ItemData> {
    static {
        new SlcViewPager2DiffCallback();
    }

    private SlcViewPager2DiffCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* bridge */ /* synthetic */ boolean areContentsTheSame(SlcViewPager2ItemData r100, SlcViewPager2ItemData r101) {
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(SlcViewPager2ItemData r100, SlcViewPager2ItemData r101) {
        if (r100.f50559d.itemKey != r101.f50559d.itemKey) goto L5;
        return true;
    L5:
        return false;
    }
}
