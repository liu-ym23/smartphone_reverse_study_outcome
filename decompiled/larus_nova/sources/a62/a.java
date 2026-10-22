package a62;

import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.interactivity.barrage.setting.vs.BarrageSettingAlphaWidget;
import com.bytedance.android.livesdk.widget.rangeseekbar.RangeSeekBar;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements ov2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BarrageSettingAlphaWidget f1939a;

    @Override // ov2.a
    public final void a() {
    }

    @Override // ov2.a
    public final void c(RangeSeekBar r100, int r101, boolean r102) {
    }

    @Override // ov2.a
    public final void b() {
        BarrageSettingAlphaWidget r100 = this.f1939a;
        r100.f133929b.X50(r100.f133928a);
        this.f1939a.wq();
    }

    public a(BarrageSettingAlphaWidget r100) {
        this.f1939a = r100;
    }

    @Override // ov2.a
    public final void d(RangeSeekBar r100, float r101) {
        if (r100 == null) goto L4;
        int r102 = r100.getStepCount();
    L5:
        if (r102 > 0) goto L11;
        BarrageSettingAlphaWidget r103 = this.f1939a;
        int r104 = BarrageSettingAlphaWidget.f133930e;
        r103.getClass();
        int r105 = MathKt.roundToInt((((int) r101) * 0.8f) + 20.0f);
        TextView r106 = this.f1939a.f133932d;
        if (r106 == null) goto L9;
        r106.setText(String.valueOf(r105) + GXTemplateKey.GAIAX_PE);
    L9:
        this.f1939a.f133928a.setAlpha(r105);
        return;
    L11:
        return;
    L4:
        r102 = 0;
        goto L5
    }
}
