package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordGuideDialog f136178a;

    public j(LiveHighlightRecordGuideDialog r100) {
        this.f136178a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f136178a.B().saveDraft();
    }
}
