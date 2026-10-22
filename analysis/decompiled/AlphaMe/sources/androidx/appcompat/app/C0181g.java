package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* renamed from: androidx.appcompat.app.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0181g implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListView f2594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2595b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2596c;

    public /* synthetic */ C0181g(C0182h c0182h, AlertController$RecycleListView alertController$RecycleListView, C0185k c0185k) {
        this.f2596c = c0182h;
        this.f2594a = alertController$RecycleListView;
        this.f2595b = c0185k;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        C0182h c0182h = (C0182h) this.f2596c;
        boolean[] zArr = c0182h.f2612p;
        ListView listView = this.f2594a;
        if (zArr != null) {
            zArr[i4] = ((AlertController$RecycleListView) listView).isItemChecked(i4);
        }
        c0182h.f2616t.onClick(((C0185k) this.f2595b).f2634b, i4, ((AlertController$RecycleListView) listView).isItemChecked(i4));
    }
}
