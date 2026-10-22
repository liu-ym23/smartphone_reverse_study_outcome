package com.bytedance.android.livesdk.chatroom.record;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecordPreviewDialog f108073a;

    public r(LiveRecordPreviewDialog r100) {
        this.f108073a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveRecordPreviewDialog.U90(this.f108073a);
    }
}
