package a30;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements ca0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1511a;

    public i(e r100) {
        this.f1511a = r100;
    }

    @Override // ca0.h
    public final void onResult(int r100) {
        jy0.b.d("SetEffectComposerMethod", "removeComposer success, result = " + r100);
        this.f1511a.finishWithSuccess();
    }
}
