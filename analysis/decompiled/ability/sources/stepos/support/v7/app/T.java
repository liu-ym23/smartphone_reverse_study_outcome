package stepos.support.v7.app;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes4.dex */
public final class T implements NestedScrollView.OnScrollChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6236a;
    public final /* synthetic */ View b;

    public T(View view, View view2) {
        this.f6236a = view;
        this.b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i6, int i10, int i11) {
        Z.q(nestedScrollView, this.f6236a, this.b);
    }
}
