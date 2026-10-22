package androidx.appfunctions;

import android.os.CancellationSignal;
import m9.q0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements CancellationSignal.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1696a;
    public final /* synthetic */ q0 b;

    public /* synthetic */ b(q0 q0Var, int i) {
        this.f1696a = i;
        this.b = q0Var;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        int i = this.f1696a;
        q0 q0Var = this.b;
        switch (i) {
            case 0:
                q0Var.cancel(null);
                break;
            case 1:
                q0Var.cancel(null);
                break;
            default:
                q0Var.cancel(null);
                break;
        }
    }
}
