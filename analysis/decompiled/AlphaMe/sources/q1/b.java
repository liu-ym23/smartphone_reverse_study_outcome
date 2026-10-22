package q1;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.google.android.material.carousel.CarouselLayoutManager;

/* loaded from: classes.dex */
public final class b extends LinearSmoothScroller {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f13988a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CarouselLayoutManager carouselLayoutManager, Context context) {
        super(context);
        this.f13988a = carouselLayoutManager;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDxToMakeVisible(View view, int i4) {
        this.f13988a.getClass();
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDyToMakeVisible(View view, int i4) {
        this.f13988a.getClass();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final PointF computeScrollVectorForPosition(int i4) {
        return this.f13988a.computeScrollVectorForPosition(i4);
    }
}
