package com.bytedance.android.ecom.arch.slice.render.elements.list;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f50471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f50472b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f50472b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f50471a.size();
    }

    public b(List<a> r100, List<a> r101) {
        this.f50471a = r100;
        this.f50472b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        a r102 = (a) ListProtector.get(this.f50471a, r100);
        a r103 = (a) ListProtector.get(this.f50472b, r101);
        if (r102.f50470b.itemKey != r103.f50470b.itemKey) goto L5;
        return true;
    L5:
        return false;
    }
}
