package com.bytedance.android.livesdk.announcement.highlight;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes7.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnnouncementHighlightAudienceWidget f103496a;

    public w(AnnouncementHighlightAudienceWidget r100) {
        this.f103496a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnnouncementHighlightAudienceWidget r100 = this.f103496a;     // Catch: Throwable -> L4
        int r101 = AnnouncementHighlightAudienceWidget.C;     // Catch: Throwable -> L4
        r100.Qq();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
