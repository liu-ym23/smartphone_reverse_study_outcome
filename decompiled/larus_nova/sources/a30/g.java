package a30;

/* JADX INFO: loaded from: classes45.dex */
public final class g implements ca0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1508a;

    public g(e r100) {
        this.f1508a = r100;
    }

    @Override // ca0.h
    public final void onResult(int r100) {
        jy0.b.d("SetEffectComposerMethod", "appendComposer success, result = " + r100);
        this.f1508a.finishWithSuccess();
    }
}
