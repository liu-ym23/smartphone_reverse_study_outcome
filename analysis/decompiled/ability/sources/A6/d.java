package A6;

import android.view.View;
import android.widget.AbsListView;
import stepos.support.v7.app.Z;

/* loaded from: classes3.dex */
public final class d implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f112a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public /* synthetic */ d(View view, View view2, int i) {
        this.f112a = i;
        this.b = view;
        this.c = view2;
    }

    private final void a(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView v10, int i, int i6, int i10) {
        switch (this.f112a) {
            case 0:
                kotlin.jvm.internal.k.f(v10, "v");
                F.i.w(v10, this.b, this.c);
                break;
            default:
                Z.q(v10, this.b, this.c);
                break;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView view, int i) {
        switch (this.f112a) {
            case 0:
                kotlin.jvm.internal.k.f(view, "view");
                break;
        }
    }
}
