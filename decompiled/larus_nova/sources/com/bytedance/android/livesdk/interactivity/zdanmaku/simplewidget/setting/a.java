package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdk.widget.rangeseekbar.SeekBar;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f141761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RangeSeekBar f141762d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f141763e;

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void e() {
    }

    public abstract ov2.a g();

    public abstract f h();

    public abstract String i();

    public abstract void j();

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void d() {
        TextView r100 = this.f141761c;
        if (r100 == null) goto L5;
        r100.setText(i());
    L5:
        j();
        RangeSeekBar r101 = this.f141762d;
        if (r101 == null) goto L9;
        r101.setOnRangeChangedListener(g());
        return;
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        TextView r101 = this.f141763e;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public a(o r100, SimpleZDanmakuSettingDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "danmakuSetting");
        Intrinsics.checkNotNullParameter(r101, "panelCallback");
        super(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.setting.b
    public final void c(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.ttlive_layout_simple_range_seek_bar_layout, r101, true);
        if (r102 == null) goto L55;
        this.f141761c = (TextView) r102.findViewById(R.id.title);
        RangeSeekBar r103 = (RangeSeekBar) r102.findViewById(R.id.seek_bar);
        if (r103 == null) goto L52;
        f r104 = h();
        r103.setGravity(r104.f141772a);
        r103.setSeekBarMode(r104.f141773b);
        Context r105 = r103.getContext();
        if (r105 == null) goto L11;
        Resources r106 = r105.getResources();
        if (r106 == null) goto L11;
        r103.setProgressColor(r106.getColor(r104.f141774c));
    L11:
        Context r107 = r103.getContext();
        if (r107 == null) goto L16;
        Resources r108 = r107.getResources();
        if (r108 == null) goto L16;
        r103.setProgressDefaultColor(r108.getColor(r104.f141775d));
    L16:
        r103.setProgressHeight(UtilityKotlinExtentionsKt.i(r104.f141776e));
        r103.setProgressRadius(UtilityKotlinExtentionsKt.h(r104.f141777f));
        r103.setStepCircleStyle(r104.f141778g);
        Context r109 = r103.getContext();
        if (r109 == null) goto L21;
        Resources r110 = r109.getResources();
        if (r110 == null) goto L21;
        r103.setStepsColor(r110.getColor(r104.f141779h));
    L21:
        Context r111 = r103.getContext();
        if (r111 == null) goto L26;
        Resources r112 = r111.getResources();
        if (r112 == null) goto L26;
        r103.setStepsCircleBorderColor(r112.getColor(r104.f141780i));
    L26:
        r103.setStepsHeight(UtilityKotlinExtentionsKt.h(r104.f141781j));
        r103.setStepsWidth(UtilityKotlinExtentionsKt.h(r104.f141782k));
        Context r113 = r103.getContext();
        if (r113 == null) goto L33;
        Resources r114 = r113.getResources();
        if (r114 == null) goto L33;
        int r115 = r114.getColor(r104.f141783l);
        SeekBar r116 = r103.getLeftSeekBar();
        if (r116 == null) goto L33;
        r116.f162005u = r115;
    L33:
        SeekBar r117 = r103.getLeftSeekBar();
        if (r117 == null) goto L36;
        r117.f162004t = UtilityKotlinExtentionsKt.i(r104.f141784m);
    L36:
        SeekBar r118 = r103.getLeftSeekBar();
        if (r118 == null) goto L39;
        r118.f162003s = UtilityKotlinExtentionsKt.i(r104.f141785n);
    L39:
        SeekBar r119 = r103.getRightSeekBar();
        if (r119 == null) goto L42;
        r119.f162004t = UtilityKotlinExtentionsKt.i(r104.f141786o);
    L42:
        SeekBar r120 = r103.getRightSeekBar();
        if (r120 == null) goto L45;
        r120.f162003s = UtilityKotlinExtentionsKt.i(r104.f141787p);
    L45:
        SeekBar r121 = r103.getLeftSeekBar();
        if (r121 == null) goto L48;
        r121.f161985a = r104.f141788q;
    L48:
        SeekBar r122 = r103.getRightSeekBar();
        if (r122 == null) goto L51;
        r122.f161985a = r104.f141789r;
    L51:
        r103.setStepCount(r104.f141790s);
        Unit r123 = Unit.INSTANCE;
    L53:
        this.f141762d = r103;
        this.f141763e = (TextView) r102.findViewById(R.id.desc);
        return;
    L52:
        r103 = null;
        goto L53
    }
}
