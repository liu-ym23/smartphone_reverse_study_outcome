package com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007R$\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/bg/ECStrokedWaveDraweeView;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "", "<set-?>", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, FaceService.girlLabel, "getWaveWidth", "()F", "waveWidth", "b", "getWaveHeight", "waveHeight", "c", "getWaveLeftMargin", "waveLeftMargin", "d", "getStrokeWidth", "strokeWidth", "", "e", "[I", "getBorderColors", "()[I", "borderColors", "", "f", "[F", "getBorderPositions", "()[F", "borderPositions", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStrokedWaveDraweeView extends ECDraweeView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f148017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f148018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f148019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f148020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f148021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f148022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f148023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f148024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f148025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f148026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f148027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f148028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f148029m;

    public ECStrokedWaveDraweeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECStrokedWaveDraweeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void j() {
        int r100 = getWidth();
        int r101 = getHeight();
        if (r100 == 0) goto L8;
        if (r101 == 0) goto L9;
        float r102 = r100;
        float r103 = r101;
        f(this.f148023g, r102, r103, 0.0f);
        f(this.f148024h, r102, r103, (this.f148020d / 2.0f) - getDp(Double.valueOf(0.01d)));
        this.f148025i.setStrokeWidth(this.f148020d);
        float r104 = r102 / 2.0f;
        this.f148025i.setShader(new LinearGradient(r104, r103 * 0.15f, r104, r103, this.f148021e, this.f148022f, Shader.TileMode.CLAMP));
        this.f148026j = getTopLeftCornerRadius();
        this.f148027k = getTopRightCornerRadius();
        this.f148028l = getBottomRightCornerRadius();
        this.f148029m = getBottomLeftCornerRadius();
        return;
    L9:
        return;
    }

    public final int[] getBorderColors() {
        return this.f148021e;
    }

    public final float[] getBorderPositions() {
        return this.f148022f;
    }

    public final float getStrokeWidth() {
        return this.f148020d;
    }

    public final float getWaveHeight() {
        return this.f148018b;
    }

    public final float getWaveLeftMargin() {
        return this.f148019c;
    }

    public final float getWaveWidth() {
        return this.f148017a;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f148026j == getTopLeftCornerRadius()) goto L5;
    L10:
        j();
    L12:
        if (this.f148023g.isEmpty() == false) goto L15;
        super.draw(r100);
        return;
    L15:
        r100.save();
        r100.clipPath(this.f148023g);
        super.draw(r100);
        r100.restore();
        if (this.f148024h.isEmpty() == true) goto L19;
        r100.drawPath(this.f148024h, this.f148025i);
        return;
    L19:
        return;
    L5:
        if (this.f148027k != getTopRightCornerRadius()) goto L10;
        if (this.f148028l != getBottomRightCornerRadius()) goto L10;
        if (this.f148029m == getBottomLeftCornerRadius()) goto L12;
        goto L10
    }

    public ECStrokedWaveDraweeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148019c = -1.0f;
        this.f148020d = q.a(Float.valueOf(0.75f));
        this.f148021e = new int[]{Color.argb(38, 255, 255, 255), Color.argb(15, 255, 141, 230), Color.argb(61, 255, 141, 173)};
        this.f148022f = new float[]{0.0f, 0.745f, 1.0f};
        this.f148023g = new Path();
        this.f148024h = new Path();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        Unit r104 = Unit.INSTANCE;
        this.f148025i = r103;
        this.f148026j = Float.NaN;
        this.f148027k = Float.NaN;
        this.f148028l = Float.NaN;
        this.f148029m = Float.NaN;
    }

    public /* synthetic */ ECStrokedWaveDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView$appendWaveNotch$1] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.bytedance.android.livesdk.livecommerce.intro.card.widget.bg.ECStrokedWaveDraweeView$appendWaveNotch$2] */
    public final void f(Path r110, float r210, float r211, float r212) {
        r110.reset();
        float r100 = RangesKt.coerceAtLeast(getTopLeftCornerRadius(), 0.0f);
        float r111 = RangesKt.coerceAtLeast(getTopRightCornerRadius(), 0.0f);
        float r112 = RangesKt.coerceAtLeast(getBottomRightCornerRadius(), 0.0f);
        float r113 = RangesKt.coerceAtLeast(getBottomLeftCornerRadius(), 0.0f);
        float r114 = r210 - r212;
        final float r115 = (r211 - this.f148018b) - r212;
        if ((r114 - r212) > Math.max(r100 + r111, r113 + r112)) goto L5;
        return;
    L5:
        if ((r115 - r212) <= Math.max(r100 + r113, r111 + r112)) goto L28;
        float r101 = r212 + r100;
        r110.moveTo(r212, r101);
        float r102 = r212 + (r100 * 0.448f);
        r110.cubicTo(r212, r102, r102, r212, r101, r212);
        r110.lineTo(r114 - r111, r212);
        float r103 = r111 * 0.448f;
        r110.cubicTo(r114 - r103, r212, r114, r212 + r103, r114, r212 + r111);
        r110.lineTo(r114, r115 - r112);
        float r104 = r112 * 0.448f;
        float r116 = r114 - r112;
        r110.cubicTo(r114, r115 - r104, r114 - r104, r115, r116, r115);
        float r105 = this.f148017a;
        if (r105 > 0.0f) goto L10;
    L25:
        r110.lineTo(r212 + r113, r115);
        float r117 = 0.448f * r113;
        r110.cubicTo(r212 + r117, r115, r212, r115 - r117, r212, r115 - r113);
        r110.close();
        return;
    L10:
        if (this.f148018b <= 0.0f) goto L25;
        float r106 = RangesKt.coerceAtLeast((r210 - r112) - r105, r113);
        float r107 = this.f148019c;
        if (r107 >= 0.0f) goto L14;
        float r108 = (r210 - this.f148017a) / 2.0f;
    L15:
        final float r118 = RangesKt.coerceAtLeast(r108 + r212, r212 + r113);
        float r109 = RangesKt.coerceAtMost((r108 + this.f148017a) - r212, r116);
        float r119 = RangesKt.coerceAtLeast(this.f148018b - r212, 0.0f);
        if (r109 <= r118) goto L25;
        if (r119 <= 0.0f) goto L25;
        r110.lineTo(r109, r115);
        float r120 = r109 - r118;
        if (r120 <= 0.0f) goto L25;
        if (r119 <= 0.0f) goto L25;
        final float r121 = r120 / 30.0f;
        ?? r122 = new ECStrokedWaveDraweeView$appendWaveNotch$1(r118, r121);
        ?? r123 = new ECStrokedWaveDraweeView$appendWaveNotch$2(r115, r121);
        r110.cubicTo(r122.invoke(28.0271f), r123.invoke(0.5f), r122.invoke(26.0813f), r123.invoke(0.959339f), r122.invoke(24.3167f), r123.invoke(1.84164f));
        r110.lineTo(r122.invoke(17.6833f), r123.invoke(5.15836f));
        r110.cubicTo(r122.invoke(15.9941f), r123.invoke(6.00294f), r122.invoke(14.0059f), r123.invoke(6.00294f), r122.invoke(12.3167f), r123.invoke(5.15836f));
        r110.lineTo(r122.invoke(5.68328f), r123.invoke(1.84164f));
        r110.cubicTo(r122.invoke(3.91868f), r123.invoke(0.959339f), r122.invoke(1.97289f), r123.invoke(0.5f), r118, r115);
        goto L25
    L14:
        r108 = RangesKt.coerceIn(r107, r113, r106);
        goto L15
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        j();
    }

    public static void k(ECStrokedWaveDraweeView r100, float r101, int[] r102, float[] r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f148020d;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f148021e;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f148022f;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "borderColors");
        Intrinsics.checkNotNullParameter(r103, "borderPositions");
        r100.f148020d = r101;
        if (r102.length == r103.length) goto L14;
    L16:
        r100.j();
        r100.invalidate();
        return;
    L14:
        if (r102.length < 2) goto L16;
        r100.f148021e = r102;
        r100.f148022f = r103;
        goto L16
    }
}
