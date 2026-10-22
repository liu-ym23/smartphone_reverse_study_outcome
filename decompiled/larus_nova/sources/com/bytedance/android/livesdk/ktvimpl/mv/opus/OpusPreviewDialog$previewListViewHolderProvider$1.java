package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.view.viewholder.OpusPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.bytedance.android.livesdk.message.model.od;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class OpusPreviewDialog$previewListViewHolderProvider$1 implements j<od> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpusPreviewDialog f146153a;

    public OpusPreviewDialog$previewListViewHolderProvider$1(OpusPreviewDialog r100) {
        this.f146153a = r100;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.j
    public final IMvPreviewViewHolder<od> a(final FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        OpusPreviewViewHolder r101 = new OpusPreviewViewHolder(r100, new OpusPreviewDialog$previewListViewHolderProvider$1$provideMvPreviewViewHolder$1(this, r100));
        this.f146153a.f146141s.add(r101);
        return r101;
    }
}
