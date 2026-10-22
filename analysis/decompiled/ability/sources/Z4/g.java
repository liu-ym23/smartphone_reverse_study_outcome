package Z4;

import androidx.core.widget.NestedScrollView;
import com.stepos.common.scrollbarview.StepOSScrollBarView;

/* loaded from: classes3.dex */
public final class g implements NestedScrollView.OnScrollChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSScrollBarView f1593a;

    public g(StepOSScrollBarView stepOSScrollBarView) {
        this.f1593a = stepOSScrollBarView;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i6, int i10, int i11) {
        this.f1593a.a(true);
    }
}
