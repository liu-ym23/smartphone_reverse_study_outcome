package v1;

import android.view.Choreographer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n0 implements Choreographer.FrameCallback {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ kc.g f14509c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ xb.l f14510f;

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j10) {
        Object objL;
        kc.g gVar = this.f14509c;
        try {
            objL = this.f14510f.invoke(Long.valueOf(j10));
        } catch (Throwable th) {
            objL = id.c.l(th);
        }
        gVar.resumeWith(objL);
    }
}
