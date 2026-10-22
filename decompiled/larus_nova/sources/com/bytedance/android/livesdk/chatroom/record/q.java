package com.bytedance.android.livesdk.chatroom.record;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecordPreviewDialog f108072a;

    public q(LiveRecordPreviewDialog r100) {
        this.f108072a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveRecordPreviewDialog.U90(this.f108072a);
    }
}
