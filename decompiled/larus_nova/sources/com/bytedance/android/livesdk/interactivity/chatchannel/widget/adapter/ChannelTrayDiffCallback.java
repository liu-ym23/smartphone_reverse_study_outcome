package com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p62.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/adapter/ChannelTrayDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelTrayDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f134554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f134555b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f134555b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f134554a.size();
    }

    public ChannelTrayDiffCallback(List<a> r100, List<a> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldDatas");
        Intrinsics.checkNotNullParameter(r101, "newDatas");
        this.f134554a = r100;
        this.f134555b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        a r102 = (a) ListProtector.get(this.f134554a, r100);
        a r103 = (a) ListProtector.get(this.f134555b, r101);
        if (r102.f527877l != r103.f527877l) goto L5;
        boolean r104 = true;
    L7:
        if (r102.f527876k != r103.f527876k) goto L9;
        boolean r105 = true;
    L10:
        if (r104 == false) goto L13;
        if (r105 == false) goto L13;
        return true;
    L13:
        return false;
    L9:
        r105 = false;
        goto L10
    L5:
        r104 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        a r102 = (a) ListProtector.get(this.f134554a, r100);
        a r103 = (a) ListProtector.get(this.f134555b, r101);
        if (r102.f527868c != r103.f527868c) goto L5;
        return true;
    L5:
        return false;
    }
}
