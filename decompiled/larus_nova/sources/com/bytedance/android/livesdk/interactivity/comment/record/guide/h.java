package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordGuideDialog f136131a;

    public h(LiveHighlightRecordGuideDialog r100) {
        this.f136131a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        if (this.f136131a.B().isPublishLoading() == true) goto L6;
        this.f136131a.B().release();
        return;
    }
}
