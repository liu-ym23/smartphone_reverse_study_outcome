package com.bytedance.android.ecom.arch.slice.render.util;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/render/util/SlcElementDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "slice-render_release"}, k = 1, mv = {1, 4, 0})
public final class SlcElementDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SlcElement> f50702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SlcElement> f50703b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f50703b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f50702a.size();
    }

    public SlcElementDiffCallback(List<SlcElement> r100, List<SlcElement> r101) {
        this.f50702a = r100;
        this.f50703b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        if (((SlcElement) ListProtector.get(this.f50702a, r100)) != ((SlcElement) ListProtector.get(this.f50703b, r101))) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        SlcElement r102 = (SlcElement) ListProtector.get(this.f50702a, r100);
        SlcElement r103 = (SlcElement) ListProtector.get(this.f50703b, r101);
        if (r102.itemKey != r103.itemKey) goto L5;
        return true;
    L5:
        return false;
    }
}
