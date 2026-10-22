package cic;

import android.graphics.SurfaceTexture;
import android.os.Build;

/* JADX INFO: loaded from: classes40.dex */
public final class a extends SurfaceTexture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23906a;

    public a() {
        super(false);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void detachFromGLContext() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.detachFromGLContext();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized long getTimestamp() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L8;
        monitor-exit(this);
        return -1;
    L8:
        long r100 = super.getTimestamp();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r100;
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void release() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.release();     // Catch: Throwable -> L10
        this.f23906a = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void releaseTexImage() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.releaseTexImage();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void updateTexImage() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.updateTexImage();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.graphics.SurfaceTexture
    public final boolean isReleased() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return super.isReleased();
    L7:
        return this.f23906a;
    }

    public a(int r100) {
        super(r100);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void attachToGLContext(int r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.attachToGLContext(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void getTransformMatrix(float[] r100) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.getTransformMatrix(r100);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // android.graphics.SurfaceTexture
    public final synchronized void setDefaultBufferSize(int r100, int r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isReleased() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        super.setDefaultBufferSize(r100, r101);     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
