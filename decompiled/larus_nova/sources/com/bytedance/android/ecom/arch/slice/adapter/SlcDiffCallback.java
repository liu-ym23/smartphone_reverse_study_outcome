package com.bytedance.android.ecom.arch.slice.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/ecom/arch/slice/adapter/SlcDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SlcDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f50000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f50001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f50002c;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f50001b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f50000a.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        if (this.f50002c == false) goto L7;
        return false;
    L7:
        return ((b) ListProtector.get(this.f50000a, r100)).areContentsTheSame((b) ListProtector.get(this.f50001b, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return ((b) ListProtector.get(this.f50000a, r100)).areItemsTheSame((b) ListProtector.get(this.f50001b, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SlcDiffCallback(List<? extends b> r100, List<? extends b> r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        this.f50000a = r100;
        this.f50001b = r101;
        this.f50002c = r102;
    }
}
