package com.bytedance.android.live.platformplayer.layout;

/* JADX INFO: loaded from: classes46.dex */
public final class g1 implements com.bytedance.android.live.matchroom.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f85642a;

    @Override // com.bytedance.android.live.matchroom.d
    public final void reset() {
        this.f85642a.setTranslationX(0.0f);
        this.f85642a.setTranslationY(0.0f);
        this.f85642a.setScaleX(1.0f);
        this.f85642a.setScaleY(1.0f);
        this.f85642a.requestLayout("MatchRoomLandScapeAnimUtil reset");
    }

    public g1(c r100) {
        this.f85642a = r100;
    }

    @Override // com.bytedance.android.live.matchroom.d
    public final void a(float r100) {
        this.f85642a.setTranslationX(r100);
        this.f85642a.requestLayout("MatchRoomLandScapeAnimUtil X");
    }

    @Override // com.bytedance.android.live.matchroom.d
    public final void b(float r100) {
        this.f85642a.setTranslationY(r100);
        this.f85642a.requestLayout("MatchRoomLandScapeAnimUtil Y");
    }

    @Override // com.bytedance.android.live.matchroom.d
    public final void c(float r100, float r101) {
        this.f85642a.setScaleX(r100);
        this.f85642a.setScaleY(r101);
        this.f85642a.requestLayout("MatchRoomLandScapeAnimUtil Scale");
    }
}
