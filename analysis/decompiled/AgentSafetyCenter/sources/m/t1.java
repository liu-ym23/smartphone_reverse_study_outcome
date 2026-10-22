package m;

import android.database.DataSetObserver;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t1 extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f8078a;

    public t1(w1 w1Var) {
        this.f8078a = w1Var;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        w1 w1Var = this.f8078a;
        if (w1Var.D.isShowing()) {
            w1Var.f();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f8078a.dismiss();
    }
}
