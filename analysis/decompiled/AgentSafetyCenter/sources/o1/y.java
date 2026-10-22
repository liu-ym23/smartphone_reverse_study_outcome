package o1;

import android.view.MotionEvent;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9102c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ z f9103f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(z zVar, int i) {
        super(1);
        this.f9102c = i;
        this.f9103f = zVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f9102c) {
            case 0:
                MotionEvent motionEvent = (MotionEvent) obj;
                a0 a0Var = this.f9103f.f9104c;
                if (a0Var != null) {
                    a0Var.invoke(motionEvent);
                    return jb.v.f6774a;
                }
                yb.k.f("onTouchEvent");
                throw null;
            default:
                MotionEvent motionEvent2 = (MotionEvent) obj;
                a0 a0Var2 = this.f9103f.f9104c;
                if (a0Var2 != null) {
                    a0Var2.invoke(motionEvent2);
                    return jb.v.f6774a;
                }
                yb.k.f("onTouchEvent");
                throw null;
        }
    }
}
