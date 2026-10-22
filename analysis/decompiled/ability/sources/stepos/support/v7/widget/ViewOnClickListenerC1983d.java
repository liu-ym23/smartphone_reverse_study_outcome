package stepos.support.v7.widget;

import android.view.View;

/* renamed from: stepos.support.v7.widget.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewOnClickListenerC1983d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6606a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewOnClickListenerC1983d(Object obj, int i) {
        this.f6606a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6606a) {
            case 0:
                ((Ua.c) this.b).a();
                break;
            case 1:
                ((x0) this.b).getClass();
                break;
            default:
                A0 a02 = ((Toolbar) this.b).f6572Q;
                Va.q qVar = a02 == null ? null : a02.b;
                if (qVar != null) {
                    qVar.collapseActionView();
                    break;
                }
                break;
        }
    }
}
