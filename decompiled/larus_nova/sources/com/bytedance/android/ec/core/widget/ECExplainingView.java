package com.bytedance.android.ec.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes43.dex */
public class ECExplainingView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECLiveExplainWaveView f45915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f45916b;

    public ECExplainingView(Context r100) {
        super(r100);
        a(r100);
    }

    public final void a(Context r100) {
        setGravity(17);
        this.f45915a = new ECLiveExplainWaveView(r100);
        int r101 = ECLiveImageUtils.d(r100, 12.0f);
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(r101, r101);
        r102.rightMargin = ECLiveImageUtils.d(r100, 2.0f);
        this.f45915a.setLayoutParams(r102);
        this.f45915a.setWaveLineColor(r100.getResources().getColor(R.color.ec_color_white));
        addView(this.f45915a);
        TextView r103 = new TextView(r100);
        this.f45916b = r103;
        r103.setText(R.string.ec_explaining_text);
        this.f45916b.setTextColor(r100.getResources().getColor(R.color.ec_color_white));
        this.f45916b.setTextSize(1, 12.0f);
        addView(this.f45916b);
    }

    public ECExplainingView(Context r100, AttributeSet r101) {
        super(r100, r101);
        a(r100);
    }

    public ECExplainingView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        a(r100);
    }
}
