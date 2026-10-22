package com.stepos.motionkit.fx.backend;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3854a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i(Object obj, int i) {
        this.f3854a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f3854a;
        Object obj = this.b;
        switch (i) {
            case 0:
                SurfaceInstance.release$lambda$5$lambda$4((SurfaceInstance) obj);
                break;
            case 1:
                SurfaceInstance.attachTask$lambda$0((SurfaceInstance) obj);
                break;
            default:
                ((S7.a) obj).invoke();
                break;
        }
    }
}
