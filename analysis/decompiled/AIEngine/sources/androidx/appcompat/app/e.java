package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertController.RecycleListView f320a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController f321b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f322c;

    public e(AlertController.b bVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f322c = bVar;
        this.f320a = recycleListView;
        this.f321b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        AlertController.b bVar = this.f322c;
        boolean[] zArr = bVar.f253p;
        AlertController.RecycleListView recycleListView = this.f320a;
        if (zArr != null) {
            zArr[i10] = recycleListView.isItemChecked(i10);
        }
        bVar.f256t.onClick(this.f321b.f214b, i10, recycleListView.isItemChecked(i10));
    }
}
