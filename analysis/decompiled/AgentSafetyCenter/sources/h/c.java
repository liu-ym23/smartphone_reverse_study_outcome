package h;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4752c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f4753f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f4754g;

    public /* synthetic */ c(int i) {
        this.f4752c = i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j10) {
        switch (this.f4752c) {
            case 0:
                d dVar = (d) this.f4754g;
                DialogInterface.OnClickListener onClickListener = dVar.f4764h;
                h hVar = ((g) this.f4753f).f4812b;
                onClickListener.onClick(hVar, i);
                if (!dVar.i) {
                    hVar.dismiss();
                    break;
                }
                break;
            default:
                stepos.support.v7.app.d dVar2 = ((stepos.support.v7.app.l0) this.f4754g).f12341a;
                l.m mVar = dVar2.f12305n;
                stepos.support.v7.app.n0 n0Var = (stepos.support.v7.app.n0) this.f4753f;
                mVar.onClick(n0Var.f12361d, i);
                dVar2.getClass();
                n0Var.f12361d.dismiss();
                break;
        }
    }
}
