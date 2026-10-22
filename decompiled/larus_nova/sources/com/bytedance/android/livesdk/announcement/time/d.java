package com.bytedance.android.livesdk.announcement.time;

import com.bytedance.android.livesdk.widget.LiveNumberPicker;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements LiveNumberPicker.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementTimeSelectWidget f103588a;

    public d(AnnouncementTimeSelectWidget r100) {
        this.f103588a = r100;
    }

    @Override // com.bytedance.android.livesdk.widget.LiveNumberPicker.c
    public final void a() {
        AnnouncementTimeSelectWidget.a r100 = this.f103588a.f103550e;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }
}
