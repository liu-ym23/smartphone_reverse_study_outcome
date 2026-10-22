package A2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.DashPathEffect;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;

/* renamed from: A2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0270i implements o {
    @Override // A2.o
    public void a(HistogramView histogramView) {
        Context context = histogramView.getContext();
        Resources resources = context.getResources();
        String[] strArr = {C0711p.e(context, 6, true), C0711p.e(context, 12, true), C0711p.e(context, 18, true), C0711p.e(context, 24, true)};
        String[] strArr2 = {60 + resources.getString(R.string.us_minute), 30 + resources.getString(R.string.us_minute), "0" + resources.getString(R.string.us_minute)};
        histogramView.setXDimensionStrings(strArr);
        histogramView.setYDimensionStrings(strArr2);
        histogramView.setXDimensionIndexArray(new int[]{1, 2, 3, 4});
        histogramView.setYDimensionIndexArray(new int[]{0, 1, 2});
        histogramView.setXSegmentDividerPathEffect(new DashPathEffect(HistogramView.f15231g0, 0.0f));
    }
}
