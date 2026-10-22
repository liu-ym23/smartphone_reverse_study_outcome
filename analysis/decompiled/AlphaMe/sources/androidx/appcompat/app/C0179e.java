package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* renamed from: androidx.appcompat.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0179e extends ArrayAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ListView f2589a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2590b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0179e(C0182h c0182h, Context context, int i4, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(context, i4, R.id.text1, charSequenceArr);
        this.f2590b = c0182h;
        this.f2589a = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i4, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i4, view, viewGroup);
        boolean[] zArr = ((C0182h) this.f2590b).f2612p;
        if (zArr != null && zArr[i4]) {
            ((AlertController$RecycleListView) this.f2589a).setItemChecked(i4, true);
        }
        return view2;
    }
}
