package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.adjust.view.ToneProcessView;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f70573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f70574d;

    public final TextView getAdjustToneTitle() {
        return (TextView) this.f70571a.getValue();
    }

    public final View getIcDecrease() {
        return (View) this.f70572b.getValue();
    }

    public final View getIcIncrease() {
        return (View) this.f70574d.getValue();
    }

    public final ToneProcessView getToneProcess() {
        return (ToneProcessView) this.f70573c.getValue();
    }

    public c(gc0.a r100, Context r101, boolean r102, int r103) {
        if ((r103 & 16) == 0) goto L5;
        r102 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "tuningToneItemViewCallback");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f70571a = LazyKt.lazy(new TuningToneItemView$adjustToneTitle$2(this));
        this.f70572b = LazyKt.lazy(new TuningToneItemView$icDecrease$2(this));
        this.f70573c = LazyKt.lazy(new TuningToneItemView$toneProcess$2(this));
        this.f70574d = LazyKt.lazy(new TuningToneItemView$icIncrease$2(this));
        LayoutInflater.from(r101).inflate(R.layout.ttlive_ktv_tuning_tone_item_layout, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(17);
        setPadding(s1.f(16.0f), s1.f(18.0f), s1.f(16.0f), s1.f(0.0f));
        TextView r104 = getAdjustToneTitle();
        if (r104 == null) goto L8;
        r104.setText(s1.B(R.string.ttlive_ktv_adjust_tone));
    L8:
        if (r102 == false) goto L12;
        TextView r105 = getAdjustToneTitle();
        if (r105 == null) goto L12;
        r105.setTextSize(13.0f);
    L12:
        ToneProcessView r106 = getToneProcess();
        if (r106 == null) goto L15;
        r106.setHighLightColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70214w));
    L15:
        ToneProcessView r107 = getToneProcess();
        if (r107 == null) goto L22;
        int r108 = r100.a();
        int r109 = r107.f69450f;
        int r110 = ((r109 / 2) + 1) + r108;
        if (1 > r110) goto L22;
        if (r109 < r110) goto L22;
        r107.f69454j = r110;
        r107.invalidate();
    L22:
        View r111 = getIcDecrease();
        if (r111 == null) goto L25;
        r111.setOnClickListener(new a(this, r100));
    L25:
        View r112 = getIcIncrease();
        if (r112 == null) goto L29;
        r112.setOnClickListener(new b(this, r100));
        return;
    }
}
