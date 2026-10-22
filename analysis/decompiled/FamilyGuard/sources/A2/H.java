package A2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.DashPathEffect;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;

/* loaded from: classes.dex */
public class H implements o {

    /* renamed from: a, reason: collision with root package name */
    private final int f91a;

    public H(int i5) {
        this.f91a = i5;
    }

    @Override // A2.o
    public void a(HistogramView histogramView) {
        String[] strArr;
        int[] iArr;
        Context context = histogramView.getContext();
        Resources resources = context.getResources();
        int i5 = this.f91a;
        if (i5 == 0) {
            strArr = new String[]{24 + resources.getString(R.string.us_hour), "0" + resources.getString(R.string.us_minute)};
            iArr = new int[]{0, 1};
        } else if (i5 == 1) {
            strArr = new String[]{"0" + resources.getString(R.string.us_times), "0" + resources.getString(R.string.us_times), "0" + resources.getString(R.string.us_times)};
            iArr = new int[]{0, 1, 2};
        } else {
            strArr = new String[]{"0" + resources.getString(R.string.us_times_t), "0" + resources.getString(R.string.us_times_t), "0" + resources.getString(R.string.us_times_t)};
            iArr = new int[]{0, 1, 2};
        }
        histogramView.setXDimensionStrings(d(context, histogramView));
        histogramView.setXDimensionIndexArray(new int[]{0, 1, 2, 3, 4, 5, 6});
        histogramView.setYDimensionIndexArray(iArr);
        histogramView.setYDimensionStrings(strArr);
        histogramView.setXSegmentDividerPathEffect(new DashPathEffect(HistogramView.f15231g0, 0.0f));
    }

    public void b(HistogramView histogramView, z2.f fVar) {
        Object[] objArrF = fVar.f();
        com.stepos.digitalwellbeing.server.data.i[] iVarArr = objArrF instanceof com.stepos.digitalwellbeing.server.data.i[] ? (com.stepos.digitalwellbeing.server.data.i[]) objArrF : null;
        if (iVarArr != null) {
            int i5 = 0;
            long time = iVarArr[0].getTime();
            long j5 = 604800000 + time;
            long jY = C0711p.y();
            if (jY < time || jY > j5) {
                histogramView.setXDimensionStrings(histogramView.getContext().getResources().getStringArray(R.array.us_week));
            } else {
                int length = iVarArr.length;
                while (true) {
                    if (i5 >= length) {
                        i5 = -1;
                        break;
                    } else if (iVarArr[i5].getTime() == jY) {
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i5 >= 0) {
                    histogramView.getXDimensionStrings()[i5] = histogramView.getContext().getString(R.string.us_today);
                }
            }
        }
        histogramView.setData(fVar);
    }

    public int c(z2.f fVar) {
        Object[] objArrF = fVar.f();
        if (objArrF instanceof com.stepos.digitalwellbeing.server.data.i[]) {
            com.stepos.digitalwellbeing.server.data.i[] iVarArr = (com.stepos.digitalwellbeing.server.data.i[]) objArrF;
            int length = iVarArr.length;
            for (int i5 = 0; i5 < length; i5++) {
                if (iVarArr[i5].getTime() == C0711p.y()) {
                    return i5;
                }
            }
        }
        return -1;
    }

    protected String[] d(Context context, HistogramView histogramView) {
        return context.getResources().getStringArray(R.array.us_week);
    }
}
