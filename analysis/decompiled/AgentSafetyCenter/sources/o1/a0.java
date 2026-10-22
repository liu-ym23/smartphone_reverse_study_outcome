package o1;

import android.view.MotionEvent;
import u1.n1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9000c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ r2.q f9001f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(r2.q qVar, int i) {
        super(1);
        this.f9000c = i;
        this.f9001f = qVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        boolean zDispatchTouchEvent;
        switch (this.f9000c) {
            case 0:
                MotionEvent motionEvent = (MotionEvent) obj;
                int actionMasked = motionEvent.getActionMasked();
                r2.q qVar = this.f9001f;
                switch (actionMasked) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        zDispatchTouchEvent = qVar.dispatchTouchEvent(motionEvent);
                        break;
                    default:
                        zDispatchTouchEvent = qVar.dispatchGenericMotionEvent(motionEvent);
                        break;
                }
                return Boolean.valueOf(zDispatchTouchEvent);
            default:
                n1 n1Var = (n1) obj;
                v1.t tVar = n1Var instanceof v1.t ? (v1.t) n1Var : null;
                r2.q qVar2 = this.f9001f;
                if (tVar != null) {
                    tVar.getAndroidViewsHandler$ui_release().removeViewInLayout(qVar2);
                    yb.x.b(tVar.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder()).remove(tVar.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(qVar2));
                    qVar2.setImportantForAccessibility(0);
                }
                qVar2.removeAllViewsInLayout();
                return jb.v.f6774a;
        }
    }
}
