package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* loaded from: classes.dex */
public final class D0 extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2810a;

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        G0 g02 = (G0) this.f2810a;
        if (g02.f2846z.isShowing()) {
            g02.g();
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        ((G0) this.f2810a).dismiss();
    }
}
