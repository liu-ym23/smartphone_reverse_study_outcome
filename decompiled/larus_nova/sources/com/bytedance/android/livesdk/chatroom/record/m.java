package com.bytedance.android.livesdk.chatroom.record;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRecordPreviewDialog f108068a;

    public m(LiveRecordPreviewDialog r100) {
        this.f108068a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveRecordPreviewDialog.U90(this.f108068a);
    }
}
