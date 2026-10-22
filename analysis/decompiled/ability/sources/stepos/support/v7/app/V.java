package stepos.support.v7.app;

import android.view.View;
import android.widget.AdapterView;

/* loaded from: classes4.dex */
public final class V implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Z f6238a;
    public final /* synthetic */ X b;

    public V(X x10, Z z10) {
        this.b = x10;
        this.f6238a = z10;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        X x10 = this.b;
        Va.o oVar = x10.f6240a.n;
        Z z10 = this.f6238a;
        oVar.onClick(z10.d, i);
        x10.f6240a.getClass();
        z10.d.dismiss();
    }
}
