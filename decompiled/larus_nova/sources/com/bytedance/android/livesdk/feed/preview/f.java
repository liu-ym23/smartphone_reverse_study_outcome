package com.bytedance.android.livesdk.feed.preview;

/* JADX INFO: loaded from: classes8.dex */
public final class f implements qw1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f124301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveFeedPreview f124302b;

    @Override // qw1.a
    public final void b() {
        this.f124301a = false;
        LiveFeedPreview r100 = this.f124302b;
        int r101 = LiveFeedPreview.f124283h;
        r100.e(null);
    }

    @Override // qw1.a
    public final void onRoomFinished() {
        this.f124301a = false;
        LiveFeedPreview r100 = this.f124302b;
        int r101 = LiveFeedPreview.f124283h;
        r100.e(null);
    }

    @Override // qw1.a
    public final void onUserNotInRoom() {
        this.f124301a = false;
        LiveFeedPreview r100 = this.f124302b;
        int r101 = LiveFeedPreview.f124283h;
        r100.e(null);
    }

    @Override // qw1.a
    public final boolean onPingCheck() {
        if (this.f124301a == false) goto L9;
        LiveFeedPreview r100 = this.f124302b;
        if (r100.f124285b == false) goto L9;
        if (r100.f124288e == false) goto L9;
        return true;
    L9:
        return false;
    }

    public f(LiveFeedPreview r100) {
        this.f124302b = r100;
        this.f124301a = true;
    }

    @Override // qw1.a
    public final void a(long r100) {
        this.f124301a = false;
        LiveFeedPreview r101 = this.f124302b;
        Integer r102 = Integer.valueOf((int) r100);
        int r103 = LiveFeedPreview.f124283h;
        r101.e(r102);
    }
}
