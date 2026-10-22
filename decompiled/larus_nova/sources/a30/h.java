package a30;

import com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements com.bytedance.android.livesdk.revenue.service.effect.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SetEffectComposerResultModel f1510b;

    @Override // com.bytedance.android.livesdk.revenue.service.effect.g
    public final void onResult(int r100) {
        SetEffectComposerResultModel.b r101 = this.f1510b.getData();
        if (r101 == null) goto L5;
        r101.setResult(Integer.valueOf(r100));
    L5:
        jy0.b.d("SetEffectComposerMethod", "removeComposer success, result = " + r100);
        this.f1509a.finishWithResult(this.f1510b);
    }

    public h(e r100, SetEffectComposerResultModel r101) {
        this.f1509a = r100;
        this.f1510b = r101;
    }
}
