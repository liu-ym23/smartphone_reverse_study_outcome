package com.bytedance.android.livesdk.chatroom.record;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecordPreviewDialog f108071a;

    public p(LiveRecordPreviewDialog r100) {
        this.f108071a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveRecordPreviewDialog.T90(this.f108071a);
    }
}
