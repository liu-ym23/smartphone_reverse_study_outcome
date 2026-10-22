package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractC0597f;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;

/* loaded from: classes.dex */
public class I extends AbstractC0597f {
    public I(Context context, AbstractC0597f.c cVar) {
        super(context, cVar);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0597f
    protected HistogramView j(ViewGroup viewGroup) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(this.f15022a).inflate(R.layout.us_selectable_week_histogram, viewGroup, false);
        this.f15026e.a(histogramView);
        return histogramView;
    }
}
