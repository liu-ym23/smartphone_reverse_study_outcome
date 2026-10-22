package g;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j1 f2873a;

    public y0(j1 j1Var) {
        this.f2873a = j1Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i8, long j4) {
        i1 i1Var;
        if (i8 == -1 || (i1Var = this.f2873a.f2739c) == null) {
            return;
        }
        i1Var.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
