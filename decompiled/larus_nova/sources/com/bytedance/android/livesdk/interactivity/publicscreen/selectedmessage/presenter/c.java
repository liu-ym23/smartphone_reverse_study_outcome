package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.presenter;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a.InterfaceC2205a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f139432a;

    public c(a r100) {
        this.f139432a = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.strategy.a.InterfaceC2205a
    public void update(int r100, long r101) {
        a.InterfaceC2204a r102 = (a.InterfaceC2204a) this.f139432a.f531633a;
        if (r102 == null) goto L6;
        r102.DI(r100, r101);
        return;
    }
}
