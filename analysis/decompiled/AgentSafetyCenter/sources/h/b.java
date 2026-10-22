package h;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import m.q2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4748c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4749f;

    public /* synthetic */ b(int i) {
        this.f4748c = i;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, stepos.support.v7.app.k] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.f4748c) {
            case 0:
                g gVar = (g) this.f4749f;
                gVar.f4828s.obtainMessage(1, gVar.f4812b).sendToTarget();
                break;
            case 1:
                ((k.a) this.f4749f).a();
                break;
            case 2:
                q2 q2Var = ((Toolbar) this.f4749f).P;
                l.n nVar = q2Var == null ? null : q2Var.f8052f;
                if (nVar != null) {
                    nVar.collapseActionView();
                    break;
                }
                break;
            case 3:
                stepos.support.v7.app.o oVar = (stepos.support.v7.app.o) this.f4749f;
                ?? r22 = oVar.i;
                if (r22 != 0 && !oVar.f12400s) {
                    r22.onBackTopTouch();
                    break;
                }
                break;
            default:
                stepos.support.v7.app.n0 n0Var = (stepos.support.v7.app.n0) this.f4749f;
                Message messageObtain = (view != n0Var.f12376p || (message3 = n0Var.f12378r) == null) ? (view != n0Var.f12380t || (message2 = n0Var.f12382v) == null) ? (view != n0Var.f12384x || (message = n0Var.f12386z) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                n0Var.R.obtainMessage(1, n0Var.f12361d).sendToTarget();
                break;
        }
    }
}
