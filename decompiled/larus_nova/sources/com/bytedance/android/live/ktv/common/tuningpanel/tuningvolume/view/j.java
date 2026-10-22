package com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f70582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f70583b;

    public final SeekBarWithProgress getVolumeSeekBar() {
        return (SeekBarWithProgress) this.f70583b.getValue();
    }

    public final TextView getVolumeTitle() {
        return (TextView) this.f70582a.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SeekBarWithProgress r100 = getVolumeSeekBar();
        if (r100 == null) goto L6;
        r100.f161297c = null;
        return;
    }

    public j(gc0.c r100, Context r101, boolean r102, int r103) {
        if ((r103 & 16) == 0) goto L5;
        r102 = false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "tuningVolumeItemViewCallback");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        this.f70582a = LazyKt.lazy(new TuningVolumeItemView$volumeTitle$2(this));
        this.f70583b = LazyKt.lazy(new TuningVolumeItemView$volumeSeekBar$2(this));
        LayoutInflater.from(r101).inflate(R.layout.ttlive_ktv_tuning_volume_item_layout, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(17);
        setPadding(s1.f(16.0f), s1.f(18.0f), s1.f(16.0f), s1.f(0.0f));
        TextView r104 = getVolumeTitle();
        if (r104 == null) goto L8;
        r104.setText(r100.a());
    L8:
        if (r102 == false) goto L12;
        TextView r105 = getVolumeTitle();
        if (r105 == null) goto L12;
        r105.setTextSize(13.0f);
    L12:
        SeekBarWithProgress r106 = getVolumeSeekBar();
        if (r106 == null) goto L15;
        r106.setSeekBarProgressTvColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK));
    L15:
        SeekBarWithProgress r107 = getVolumeSeekBar();
        if (r107 == null) goto L18;
        r107.setThumbColor(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70210s));
    L18:
        SeekBarWithProgress r108 = getVolumeSeekBar();
        if (r108 == null) goto L21;
        r108.setProgressBarDrawable(s1.m(KtvOrderSongThemeManager.a(KtvOrderSongThemeManager.f70213v)));
    L21:
        SeekBarWithProgress r109 = getVolumeSeekBar();
        if (r109 == null) goto L24;
        int r110 = r100.c();
        r109.f161299e = r110;
        r109.f161300f = true;
        ((SeekBar) r109.a(R.id.seek_bar_with_progress)).setMax(r110);
    L24:
        SeekBarWithProgress r111 = getVolumeSeekBar();
        if (r111 == null) goto L27;
        r111.setInterceptCallBack(r100.b());
    L27:
        SeekBarWithProgress r112 = getVolumeSeekBar();
        if (r112 == null) goto L30;
        r112.c(r100.d());
    L30:
        SeekBarWithProgress r113 = getVolumeSeekBar();
        if (r113 == null) goto L34;
        r113.setOnSeekBarChangeListener(new i(r100));
        return;
    }
}
