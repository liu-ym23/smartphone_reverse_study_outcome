package com.bytedance.android.livesdk.castscreen.padandpc.adapter;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/castscreen/padandpc/adapter/PadAndPcDeviceDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lpf1/a;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PadAndPcDeviceDiffCallback extends DiffUtil.ItemCallback<pf1.a> {
    public PadAndPcDeviceDiffCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(pf1.a r100, pf1.a r101) {
        pf1.a r102 = r100;
        pf1.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r103, "p1");
        return Intrinsics.areEqual(r102, r103);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(pf1.a r100, pf1.a r101) {
        pf1.a r102 = r100;
        pf1.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "p0");
        Intrinsics.checkNotNullParameter(r103, "p1");
        return Intrinsics.areEqual(r102, r103);
    }
}
