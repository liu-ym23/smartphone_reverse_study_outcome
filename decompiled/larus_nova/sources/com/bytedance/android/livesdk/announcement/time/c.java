package com.bytedance.android.livesdk.announcement.time;

import com.bytedance.android.livesdk.widget.LiveNumberPicker;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements LiveNumberPicker.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementTimeSelectWidget f103587a;

    public c(AnnouncementTimeSelectWidget r100) {
        this.f103587a = r100;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveNumberPicker.c
    public final void a() {
        AnnouncementTimeSelectWidget.a r100 = this.f103587a.f103550e;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }
}
