package com.bytedance.android.livesdk.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import rd1.a;

/* JADX INFO: loaded from: classes7.dex */
public class ListDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<?> f103068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<?> f103069b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        List<?> r100 = this.f103069b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        List<?> r100 = this.f103068a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public ListDiffCallback(List<?> r100, List<?> r101) {
        this.f103068a = r100;
        this.f103069b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        if ((ListProtector.get(this.f103068a, r100) instanceof a) == true) goto L5;
        return false;
    L5:
        if ((ListProtector.get(this.f103069b, r101) instanceof a) == true) goto L7;
        return false;
    L7:
        return ((a) ListProtector.get(this.f103068a, r100)).a(ListProtector.get(this.f103069b, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        if ((ListProtector.get(this.f103068a, r100) instanceof a) == false) goto L9;
        if ((ListProtector.get(this.f103069b, r101) instanceof a) == false) goto L9;
        return ((a) ListProtector.get(this.f103068a, r100)).b(ListProtector.get(this.f103069b, r101));
    L9:
        if (ListProtector.get(this.f103068a, r100) != ListProtector.get(this.f103069b, r101)) goto L11;
        return true;
    L11:
        return false;
    }
}
