package v1;

import android.os.SystemClock;
import android.view.MotionEvent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14531c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ t f14532f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(t tVar, int i) {
        super(0);
        this.f14531c = i;
        this.f14532f = tVar;
    }

    @Override // xb.a
    public final Object invoke() {
        int actionMasked;
        switch (this.f14531c) {
            case 0:
                t tVar = this.f14532f;
                MotionEvent motionEvent = tVar.f14568u0;
                if (motionEvent != null && ((actionMasked = motionEvent.getActionMasked()) == 7 || actionMasked == 9)) {
                    tVar.f14570v0 = SystemClock.uptimeMillis();
                    tVar.post(tVar.A0);
                }
                return jb.v.f6774a;
            default:
                return this.f14532f.get_viewTreeOwners();
        }
    }
}
