package com.bytedance.android.livesdk.ceremony.view;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CeremonyBorderWidget f104958a;

    @Override // com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a
    public final void a(float r100, float r101, float r102, float r103) {
    }

    @Override // com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a
    public final boolean needContinueLoop() {
        return true;
    }

    @Override // com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a
    public final void onFileLoaded(int r100, int r101) {
    }

    @Override // com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a
    public final void onStart() {
    }

    @Override // com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a
    public final void onEnd() {
        com.bytedance.android.livesdk.ceremony.viewmodel.a r100 = this.f104958a.f104906f;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.ceremony.viewmodel.a.InterfaceC1580a
    public final void onStop() {
        com.bytedance.android.livesdk.ceremony.viewmodel.a r100 = this.f104958a.f104906f;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public a(CeremonyBorderWidget r100) {
        this.f104958a = r100;
    }
}
