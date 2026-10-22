package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class k implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordGuideDialog f136179a;

    public k(LiveHighlightRecordGuideDialog r100) {
        this.f136179a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f136179a.B().openPreviewDialog();
    }
}
