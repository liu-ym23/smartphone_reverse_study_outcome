package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.view.View;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.message.model.od;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OpusPreviewDialog f146181a;

    public b(OpusPreviewDialog r100) {
        this.f146181a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OpusPreviewDialog r101 = this.f146181a;
        if (r101.f146148z == false) goto L5;
        return;
    L5:
        IMvPreviewViewHolder<od> r102 = r101.f146137o;
        if (r102 == null) goto L9;
        r101.Z90(r102, false);
        return;
    }
}
