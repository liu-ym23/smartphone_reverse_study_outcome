package com.stepos.familyguard.ui.usage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.AbstractC0597f;
import com.stepos.familyguard.ui.widget.chart.histogram.HistogramView;
import y2.C1320a;

/* renamed from: com.stepos.familyguard.ui.usage.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0613w extends AbstractC0597f {
    public C0613w(Context context, AbstractC0597f.b bVar) {
        super(context, bVar);
    }

    @Override // com.stepos.familyguard.ui.usage.AbstractC0597f
    protected HistogramView j(ViewGroup viewGroup) {
        HistogramView histogramView = (HistogramView) LayoutInflater.from(this.f15022a).inflate(R.layout.us_hoverable_week_histogram, viewGroup, false);
        this.f15026e.a(histogramView);
        histogramView.setChartLayerFactory(new C1320a(3));
        return histogramView;
    }
}
