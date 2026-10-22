package g;

import android.database.DataSetObserver;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c1 extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f2674a;

    public c1(j1 j1Var) {
        this.f2674a = j1Var;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        j1 j1Var = this.f2674a;
        if (j1Var.f2757w.isShowing()) {
            j1Var.a();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        this.f2674a.dismiss();
    }
}
