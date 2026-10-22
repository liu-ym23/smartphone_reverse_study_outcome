package m;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p1 implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ w1 f8046c;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j10) {
        j1 j1Var;
        if (i == -1 || (j1Var = this.f8046c.f8116g) == null) {
            return;
        }
        j1Var.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
