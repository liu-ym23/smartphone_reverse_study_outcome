package j1;

import android.view.Choreographer;

/* loaded from: classes.dex */
public final class t0 implements Choreographer.FrameCallback {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ia.m f5332f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ p7.k f5333g;

    public t0(ia.m mVar, b0.q1 q1Var, p7.k kVar) {
        this.f5332f = mVar;
        this.f5333g = kVar;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        Object objN;
        try {
            objN = this.f5333g.invoke(Long.valueOf(j2));
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        this.f5332f.resumeWith(objN);
    }
}
