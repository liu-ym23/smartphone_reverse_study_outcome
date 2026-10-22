package v6;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.stepos.agentsafetycenter.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f14813a;

    /* renamed from: b, reason: collision with root package name */
    public final List f14814b;

    public b() {
        Paint paint = new Paint();
        this.f14813a = paint;
        this.f14814b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) throws Resources.NotFoundException {
        Canvas canvas2;
        super.onDrawOver(canvas, recyclerView, state);
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.f14813a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f14814b.iterator();
        while (it.hasNext()) {
            ((g) it.next()).getClass();
            int i = f3.a.f3898a;
            float f5 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f5)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f5)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f5)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f5))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).b()) {
                canvas2 = canvas;
                canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2440b.e(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2440b.a(), paint);
            } else {
                canvas2 = canvas;
                canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f2440b.b(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f2440b.c(), 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
