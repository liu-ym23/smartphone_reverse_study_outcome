package androidx.camera.camera2.internal;

import androidx.camera.core.SafeCloseImageReaderProxy;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SafeCloseImageReaderProxy f5061a;

    public /* synthetic */ v3(SafeCloseImageReaderProxy r100) {
        this.f5061a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5061a.safeClose();
    }
}
