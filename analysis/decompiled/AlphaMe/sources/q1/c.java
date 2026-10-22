package q1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f13989a;

    /* renamed from: b, reason: collision with root package name */
    public final List f13990b;

    public c() {
        Paint paint = new Paint();
        this.f13989a = paint;
        this.f13990b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        Paint paint = this.f13989a;
        paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
        for (h hVar : this.f13990b) {
            hVar.getClass();
            ThreadLocal threadLocal = D.a.f355a;
            float f4 = 1.0f - Property.DEFAULT_FLOAT_VALUE;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * Property.DEFAULT_FLOAT_VALUE) + (Color.alpha(-65281) * f4)), (int) ((Color.red(-16776961) * Property.DEFAULT_FLOAT_VALUE) + (Color.red(-65281) * f4)), (int) ((Color.green(-16776961) * Property.DEFAULT_FLOAT_VALUE) + (Color.green(-65281) * f4)), (int) ((Color.blue(-16776961) * Property.DEFAULT_FLOAT_VALUE) + (Color.blue(-65281) * f4))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).g()) {
                float fE = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f10542b.e();
                float fA = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f10542b.a();
                hVar.getClass();
                hVar.getClass();
                canvas.drawLine(Property.DEFAULT_FLOAT_VALUE, fE, Property.DEFAULT_FLOAT_VALUE, fA, paint);
            } else {
                float fB = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f10542b.b();
                float fC = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f10542b.c();
                hVar.getClass();
                hVar.getClass();
                canvas.drawLine(fB, Property.DEFAULT_FLOAT_VALUE, fC, Property.DEFAULT_FLOAT_VALUE, paint);
            }
        }
    }
}
