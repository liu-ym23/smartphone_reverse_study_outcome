package com.bytedance.android.gamecp.common.track;

/* JADX INFO: loaded from: classes44.dex */
public final class e extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f56793a;

    public e() {
        this.f56793a = true;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        if (this.f56793a == false) goto L5;
        return 3;
    L5:
        return 0;
    }
}
