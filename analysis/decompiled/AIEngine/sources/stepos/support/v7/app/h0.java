package stepos.support.v7.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h0 implements NestedScrollView.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f12123a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f12124b;

    public h0(View view, View view2) {
        this.f12123a = view;
        this.f12124b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.c
    public final void a(NestedScrollView nestedScrollView) {
        StepOSAlertController.q(nestedScrollView, this.f12123a, this.f12124b);
    }
}
