package i7;

import android.view.View;
import android.widget.AdapterView;
import m.k0;
import m.n0;
import m.w1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5814c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5815f;

    public /* synthetic */ a(int i) {
        this.f5814c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j10) {
        switch (this.f5814c) {
            case 0:
                c cVar = (c) this.f5815f;
                w1 w1Var = cVar.i;
                cVar.setText(cVar.convertSelectionToString(i < 0 ? !w1Var.D.isShowing() ? null : w1Var.f8116g.getSelectedItem() : cVar.getAdapter().getItem(i)), false);
                AdapterView.OnItemClickListener onItemClickListener = cVar.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !w1Var.D.isShowing() ? null : w1Var.f8116g.getSelectedView();
                        i = !w1Var.D.isShowing() ? -1 : w1Var.f8116g.getSelectedItemPosition();
                        j10 = !w1Var.D.isShowing() ? Long.MIN_VALUE : w1Var.f8116g.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(w1Var.f8116g, view, i, j10);
                }
                w1Var.dismiss();
                break;
            default:
                k0 k0Var = (k0) this.f5815f;
                n0 n0Var = k0Var.I;
                n0Var.setSelection(i);
                if (n0Var.getOnItemClickListener() != null) {
                    n0Var.performItemClick(view, i, k0Var.F.getItemId(i));
                }
                k0Var.dismiss();
                break;
        }
    }
}
