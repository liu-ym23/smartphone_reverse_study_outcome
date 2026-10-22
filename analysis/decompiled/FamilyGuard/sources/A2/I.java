package A2;

import android.content.Context;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import f2.C0711p;

/* loaded from: classes.dex */
public class I extends H {
    public I(int i5) {
        super(i5);
    }

    @Override // A2.H
    protected String[] d(Context context, HistogramView histogramView) {
        return new String[]{context.getString(R.string.us_week_total, C0711p.C(context, C0711p.y() - 518400000)), context.getString(R.string.us_week_total, C0711p.C(context, C0711p.y() - 432000000)), context.getString(R.string.us_week_total, C0711p.C(context, C0711p.y() - 345600000)), context.getString(R.string.us_week_total, C0711p.C(context, C0711p.y() - 259200000)), context.getString(R.string.us_week_total, C0711p.C(context, C0711p.y() - 172800000)), context.getString(R.string.us_week_total, C0711p.C(context, C0711p.y() - 86400000)), context.getString(R.string.us_today)};
    }
}
