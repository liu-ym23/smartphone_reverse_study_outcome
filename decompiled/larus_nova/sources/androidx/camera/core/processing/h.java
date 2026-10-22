package androidx.camera.core.processing;

import androidx.camera.core.SurfaceOutput;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SurfaceOutput f5316a;

    public /* synthetic */ h(SurfaceOutput r100) {
        this.f5316a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5316a.close();
    }
}
