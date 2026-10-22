package com.bytedance.android.livesdk.feed.preview;

import com.bytedance.android.livesdkapi.view.TextureRenderView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveFeedPreview f124298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f124299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f124300c;

    public e(LiveFeedPreview r100, int r101, int r102) {
        this.f124298a = r100;
        this.f124299b = r101;
        this.f124300c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (((TextureRenderView) this.f124298a.b()) != null) goto L5;
        return;
    L5:
        if (((TextureRenderView) this.f124298a.b()).getVisibility() != 0) goto L15;
        ((TextureRenderView) this.f124298a.b()).setVideoSize(this.f124299b, this.f124300c);     // Catch: Throwable -> L8
        return;
    }
}
