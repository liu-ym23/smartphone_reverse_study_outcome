package androidx.camera.core.processing;

import androidx.camera.core.SurfaceRequest;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f5326a;

    public /* synthetic */ k(SurfaceRequest r100) {
        this.f5326a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5326a.willNotProvideSurface();
    }
}
