package stepos.support.v7.app;

import android.view.View;
import android.widget.AbsListView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j0 implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f12144a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f12145b;

    public j0(View view, View view2) {
        this.f12144a = view;
        this.f12145b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        StepOSAlertController.q(absListView, this.f12144a, this.f12145b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i10) {
    }
}
