package androidx.camera.core.processing;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge.SettableSurface f5341a;

    public /* synthetic */ t(SurfaceEdge.SettableSurface r100) {
        this.f5341a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5341a.close();
    }
}
