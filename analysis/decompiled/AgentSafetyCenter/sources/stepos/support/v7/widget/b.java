package stepos.support.v7.widget;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12725c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f12726f;

    public /* synthetic */ b(int i) {
        this.f12725c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f12725c) {
            case 0:
                ((se.b) this.f12726f).a();
                break;
            default:
                q1 q1Var = ((Toolbar) this.f12726f).Q;
                te.m mVar = q1Var == null ? null : q1Var.f12823f;
                if (mVar != null) {
                    mVar.collapseActionView();
                    break;
                }
                break;
        }
    }
}
