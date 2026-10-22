package com.bytedance.android.livesdk.announcement;

import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementEntryWidget f103355a;

    public c(AnnouncementEntryWidget r100) {
        this.f103355a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AnnouncementEntryWidget.wq(this.f103355a);
    }
}
