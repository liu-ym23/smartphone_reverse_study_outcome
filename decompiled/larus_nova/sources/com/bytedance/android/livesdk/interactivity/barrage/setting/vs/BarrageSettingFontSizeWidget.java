package com.bytedance.android.livesdk.interactivity.barrage.setting.vs;

import a62.e;
import a62.f;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.setting.InterceptConstraintLayout;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import com.bytedance.android.livesdk.widget.rangeseekbar.SeekBar;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ov2.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/BarrageSettingFontSizeWidget;", "Lcom/bytedance/android/livesdk/interactivity/barrage/setting/vs/AbsBarrageSettingWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BarrageSettingFontSizeWidget extends AbsBarrageSettingWidget {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RangeSeekBar f133945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f133946d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BarrageSettingFontSizeWidget f133947a;

        public a(BarrageSettingFontSizeWidget r100) {
            this.f133947a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BarrageSettingFontSizeWidget r100 = this.f133947a;     // Catch: Throwable -> L10
            RangeSeekBar r101 = r100.f133945c;     // Catch: Throwable -> L10
            if (r101 == null) goto L5;
            r101.setStepCount(2);     // Catch: Throwable -> L10
        L5:
            RangeSeekBar r102 = r100.f133945c;     // Catch: Throwable -> L10
            if (r102 == null) goto L8;
            r102.setOnRangeChangedListener(new f(r100));     // Catch: Throwable -> L10
        L8:
            this.f133947a.zq();     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L14;
            return;
        L14:
            throw th;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_layout_vs_live_barrage_setting_font_size;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
    }

    public final void zq() {
        BarrageSettingFont r100 = this.f133928a.getFontSize();
        TextView r101 = this.f133946d;
        if (r101 == null) goto L15;
        int r102 = e.f1943a[r100.ordinal()];
        if (r102 != 1) goto L7;
        String r103 = "小号";
    L14:
        r101.setText(r103);
        goto L15
    L7:
        if (r102 != 2) goto L9;
    L12:
        r103 = "中号";
        goto L14
    L9:
        if (r102 != 3) goto L12;
        r103 = "大号";
    L15:
        RangeSeekBar r104 = this.f133945c;
        if (r104 == null) goto L19;
        r104.setStep(r100.getLevel());
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        RangeSeekBar r101 = (RangeSeekBar) findViewById(R.id.size_seek_bar);
        if (r101 == null) goto L33;
        r101.setGravity(2);
        r101.setSeekBarMode(1);
        Context r102 = r101.getContext();
        if (r102 == null) goto L9;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L9;
        r101.setProgressColor(r103.getColor(R.color.ttlive_barrage_setting_alpha_seek_bar));
    L9:
        Context r104 = r101.getContext();
        if (r104 == null) goto L14;
        Resources r105 = r104.getResources();
        if (r105 == null) goto L14;
        r101.setProgressDefaultColor(r105.getColor(R.color.ttlive_barrage_setting_alpha_seek_bar_default));
    L14:
        r101.setProgressHeight(c.b(r101.getContext(), 3.0f));
        r101.setProgressRadius(c.b(r101.getContext(), 2.0f));
        r101.setStepCircleStyle(true);
        r101.setStepsColor(-1);
        r101.setStepsHeight(c.b(r101.getContext(), 3.0f));
        r101.setStepsWidth(c.b(r101.getContext(), 3.0f));
        SeekBar r106 = r101.getLeftSeekBar();
        if (r106 == null) goto L17;
        r106.f162004t = c.b(r101.getContext(), 14.0f);
    L17:
        SeekBar r107 = r101.getLeftSeekBar();
        if (r107 == null) goto L20;
        r107.f162003s = c.b(r101.getContext(), 14.0f);
    L20:
        SeekBar r108 = r101.getRightSeekBar();
        if (r108 == null) goto L23;
        r108.f162004t = c.b(r101.getContext(), 14.0f);
    L23:
        SeekBar r109 = r101.getRightSeekBar();
        if (r109 == null) goto L26;
        r109.f162003s = c.b(r101.getContext(), 14.0f);
    L26:
        SeekBar r110 = r101.getLeftSeekBar();
        if (r110 == null) goto L29;
        r110.f161985a = 1;
    L29:
        SeekBar r111 = r101.getRightSeekBar();
        if (r111 == null) goto L32;
        r111.f161985a = 1;
    L32:
        Unit r112 = Unit.INSTANCE;
    L34:
        this.f133945c = r101;
        this.f133946d = (TextView) findViewById(R.id.font_size);
        return;
    L33:
        r101 = null;
        goto L34
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L6;
        r101.post(new a(this));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void xq(BarrageSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        this.f133928a = r100;
        zq();
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.setting.vs.AbsBarrageSettingWidget
    public final void yq(boolean r100) {
        View r101 = this.contentView;
        if ((r101 instanceof InterceptConstraintLayout) == true) goto L5;
        r101 = null;
    L5:
        InterceptConstraintLayout r102 = (InterceptConstraintLayout) r101;
        if (r102 == null) goto L13;
        r102.setmIsIntercept(r100);
        if (r100 == false) goto L10;
        float r103 = 0.5f;
    L11:
        r102.setAlpha(r103);
        return;
    L10:
        r103 = 1.0f;
        goto L11
    }

    public BarrageSettingFontSizeWidget(BarrageSetting r100, AbsBarrageSettingWidget.a r101) {
        Intrinsics.checkNotNullParameter(r100, "barrageSetting");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100, r101);
    }
}
