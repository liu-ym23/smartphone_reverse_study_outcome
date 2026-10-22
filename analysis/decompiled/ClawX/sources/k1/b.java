package k1;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.stepos.stepclaw.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v0.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends z {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3541a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3542b;

    public b() {
        Paint paint = new Paint();
        this.f3541a = paint;
        this.f3542b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // v0.z
    public final void b(Canvas canvas, RecyclerView recyclerView) throws Resources.NotFoundException {
        int iY;
        Canvas canvas2;
        int iW;
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.f3541a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f3542b.iterator();
        while (it.hasNext()) {
            ((d) it.next()).getClass();
            int i8 = x.a.f6230a;
            float f3 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f3)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f3)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f3)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f3))));
            int iX = 0;
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).c0()) {
                c cVar = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1288l;
                switch (cVar.f3544b) {
                    case 0:
                        break;
                    default:
                        iX = cVar.f3545c.z();
                        break;
                }
                float f7 = iX;
                c cVar2 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1288l;
                switch (cVar2.f3544b) {
                    case 0:
                        iW = cVar2.f3545c.f5800j;
                        break;
                    default:
                        CarouselLayoutManager carouselLayoutManager = cVar2.f3545c;
                        iW = carouselLayoutManager.f5800j - carouselLayoutManager.w();
                        break;
                }
                float f9 = iW;
                canvas2 = canvas;
                canvas2.drawLine(0.0f, f7, 0.0f, f9, paint);
            } else {
                c cVar3 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1288l;
                switch (cVar3.f3544b) {
                    case 0:
                        iX = cVar3.f3545c.x();
                        break;
                }
                float f10 = iX;
                c cVar4 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).f1288l;
                switch (cVar4.f3544b) {
                    case 0:
                        CarouselLayoutManager carouselLayoutManager2 = cVar4.f3545c;
                        iY = carouselLayoutManager2.f5799i - carouselLayoutManager2.y();
                        break;
                    default:
                        iY = cVar4.f3545c.f5799i;
                        break;
                }
                canvas2 = canvas;
                canvas2.drawLine(f10, 0.0f, iY, 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
