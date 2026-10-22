package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
public interface SurfaceProcessor {
    void onInputSurface(SurfaceRequest r100) throws ProcessingException;

    void onOutputSurface(SurfaceOutput r100) throws ProcessingException;
}
