package a62;

import android.widget.TextView;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingFontSizeWidget;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements ov2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BarrageSettingFontSizeWidget f1944a;

    @Override // ov2.a
    public final void a() {
    }

    @Override // ov2.a
    public final void d(RangeSeekBar r100, float r101) {
    }

    @Override // ov2.a
    public final void b() {
        BarrageSettingFontSizeWidget r100 = this.f1944a;
        r100.f133929b.X50(r100.f133928a);
        this.f1944a.wq();
    }

    public f(BarrageSettingFontSizeWidget r100) {
        this.f1944a = r100;
    }

    @Override // ov2.a
    public final void c(RangeSeekBar r100, int r101, boolean r102) {
        if (r102 == false) goto L4;
        return;
    L4:
        if (r100 == null) goto L6;
        int r103 = r100.getStepCount();
    L7:
        if (r103 <= 0) goto L30;
        this.f1944a.getClass();
        if (r101 == 0) goto L15;
        if (r101 == 1) goto L14;
        if (r101 == 2) goto L13;
        BarrageSettingFont r104 = BarrageSettingFont.MID;
    L16:
        TextView r105 = this.f1944a.f133946d;
        if (r105 == null) goto L28;
        int r106 = e.f1943a[r104.ordinal()];
        if (r106 == 1) goto L26;
        if (r106 != 2) goto L22;
    L25:
        String r107 = "中号";
    L27:
        r105.setText(r107);
        goto L28
    L22:
        if (r106 != 3) goto L25;
        r107 = "大号";
        goto L27
    L26:
        r107 = "小号";
    L28:
        this.f1944a.f133928a.setFontSize(r104);
        return;
    L13:
        r104 = BarrageSettingFont.BIG;
        goto L16
    L14:
        r104 = BarrageSettingFont.MID;
        goto L16
    L15:
        r104 = BarrageSettingFont.SMALL;
        goto L16
    L30:
        return;
    L6:
        r103 = 0;
        goto L7
    }
}
