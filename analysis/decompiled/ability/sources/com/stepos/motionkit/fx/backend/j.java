package com.stepos.motionkit.fx.backend;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3855a;
    public final /* synthetic */ SurfaceInstance b;
    public final /* synthetic */ long c;

    public /* synthetic */ j(SurfaceInstance surfaceInstance, long j5, int i) {
        this.f3855a = i;
        this.b = surfaceInstance;
        this.c = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3855a) {
            case 0:
                SurfaceInstance.onAvailable$lambda$1(this.b, this.c);
                break;
            default:
                SurfaceInstance.onAvailable$lambda$3$lambda$2(this.b, this.c);
                break;
        }
    }
}
