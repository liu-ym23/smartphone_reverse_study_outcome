package androidx.appcompat.app;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends ArrayAdapter<CharSequence> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertController.RecycleListView f316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlertController.b f317b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(AlertController.b bVar, ContextThemeWrapper contextThemeWrapper, int i10, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(contextThemeWrapper, i10, R.id.text1, charSequenceArr);
        this.f317b = bVar;
        this.f316a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i10, view, viewGroup);
        boolean[] zArr = this.f317b.f253p;
        if (zArr != null && zArr[i10]) {
            this.f316a.setItemChecked(i10, true);
        }
        return view2;
    }
}
