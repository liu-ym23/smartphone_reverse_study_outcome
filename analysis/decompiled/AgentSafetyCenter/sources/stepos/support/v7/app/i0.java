package stepos.support.v7.app;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class i0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12335c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ View f12336f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ View f12337g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ n0 f12338h;

    public /* synthetic */ i0(int i) {
        this.f12335c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12335c) {
            case 0:
                n0.r(this.f12338h.B, this.f12336f, this.f12337g);
                break;
            default:
                n0.r(this.f12338h.i, this.f12336f, this.f12337g);
                break;
        }
    }
}
