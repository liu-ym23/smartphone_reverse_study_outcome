package com.bytedance.android.shopping.commentv3.audio;

/* JADX INFO: loaded from: classes13.dex */
public final class o implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f172629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f172630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n.a f172631c;

    @Override // com.bytedance.android.shopping.commentv3.audio.l
    public final void onCompletion() {
        f.a.a(this.f172629a, this.f172630b, StopReason.PLAY_COMPLETE, null, null, 12);
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.l
    public final void onPrepared() {
        dm.a.a("CommentAudioPlayer").i("prepared, sliceId: " + this.f172630b);
        h r100 = this.f172629a.f172626f;
        if (r100 == null) goto L5;
        r100.i();
    L5:
        this.f172631c.b();
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.l
    public final void onError(int r100, String r101) {
        dm.a.a("CommentAudioPlayer").i("error, sliceId: " + this.f172630b + ", code: " + r100 + ", msg: " + r101);
        this.f172631c.a(r100, r101);
        f.a.a(this.f172629a, this.f172630b, StopReason.PLAY_ERROR, null, null, 12);
    }

    public o(n r100, String r101, n.a r102) {
        this.f172629a = r100;
        this.f172630b = r101;
        this.f172631c = r102;
    }
}
