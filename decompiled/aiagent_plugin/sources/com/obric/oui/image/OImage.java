package com.obric.oui.image;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OImage.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OImage extends AppCompatImageView {
    public static final a Companion = null;
    public static final float OUI_IMAGE_RAIDUS_L2_DP = 12.0f;
    public static final float OUI_IMAGE_RAIDUS_M1_DP = 8.0f;
    public static final float OUI_IMAGE_RAIDUS_M2_DP = 10.0f;
    public static final float OUI_IMAGE_RAIDUS_S_DP = 6.0f;
    public static final float OUI_IMAGE_RAIDUS_XL_DP = 16.0f;
    private static final String TAG = "OImage";
    private final Path clipPath;
    private final RectF clipRect;
    private final RectF contentRect;
    private float effectiveRadiusPx;
    private com.obric.oui.image.a imageShape;
    private final float roundedRadiusPx;
    private final Paint strokePaint;
    private final RectF strokeRect;
    private final float strokeWidthPx;
    private final b styleConfig;
    private float styleRadiusPx;

    /* JADX INFO: compiled from: OImage.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public OImage(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OImage(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public /* synthetic */ OImage(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OImage(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r13, "context");
        super(r13, r14, r12);
        this.clipPath = new Path();
        this.clipRect = new RectF();
        this.contentRect = new RectF();
        this.strokeRect = new RectF();
        this.styleConfig = b.a.a(b.f35293a, r13, r14, r12, 0, 8, null);
        this.roundedRadiusPx = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_image_rounded_radius, "dimen", "oui_image_rounded_radius"));
        n.a r4 = n.f38560a;     // Catch: Throwable -> L9
        OImage r5 = (OImage) ZeusTransformUtils.preCheckCast(this, OImage.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        TypedArray r15 = r13.obtainStyledAttributes(r14, new int[]{android.R.attr.radius}, r12, 0);     // Catch: Throwable -> L9
        float r16 = r15.getDimension(0, 0.0f);     // Catch: Throwable -> L6
        r15.recycle();     // Catch: Throwable -> L9
        Object r17 = n.f(Float.valueOf(r16));     // Catch: Throwable -> L9
    L11:
        Throwable r18 = n.c(r17);
        if (r18 == null) goto L15;
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Failed to parse android:radius; fallback to 0", r18);
        r17 = Float.valueOf(0.0f);
    L15:
        this.styleRadiusPx = ((Number) ZeusTransformUtils.preCheckCast(r17, Number.class, "com.obric.aiagent.plugin")).floatValue();
        com.obric.oui.image.a r19 = this.styleConfig.a();
        this.imageShape = r19;
        this.effectiveRadiusPx = c.a(r19, this.styleRadiusPx, this.roundedRadiusPx);
        float r110 = ZeusTransformUtils.getResources(r13, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_image_stroke_width, "dimen", "oui_image_stroke_width"));
        this.strokeWidthPx = r110;
        Paint r111 = new Paint(1);
        r111.setStyle(Paint.Style.STROKE);
        r111.setColor(androidx.core.content.a.c(r13, ZeusTransformUtils.mapRes(R.color.oui_line_1, "color", "oui_line_1")));
        r111.setStrokeWidth(r110);
        this.strokePaint = r111;
        return;
    L6:
        th = move-exception;
        r15.recycle();     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.a r112 = n.f38560a;
        r17 = n.f(d.o.a(th));
        goto L11
    }

    public final void setImageShape(com.obric.oui.image.a r4) {
        o.e(r4, "shape");
        if (r4 != this.imageShape) goto L6;
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, o.a("Skip setImageShape because shape is unchanged: ", r4));
        return;
    L6:
        this.imageShape = r4;
        this.effectiveRadiusPx = c.a(r4, this.styleRadiusPx, this.roundedRadiusPx);
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(TAG, "Image shape changed to " + r4 + ", effectiveRadiusPx=" + this.effectiveRadiusPx);
        invalidate();
    }

    public final void setRadiusDp(float r4) {
        setRadiusPx(r4 * ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density);
    }

    public final void setRadiusPx(float r3) {
        if (this.styleRadiusPx != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.styleRadiusPx = r3;
        this.effectiveRadiusPx = c.a(this.imageShape, r3, this.roundedRadiusPx);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final com.obric.oui.image.a getImageShape() {
        return this.imageShape;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas r9) {
        o.e(r9, "canvas");
        float r0 = getWidth();
        float r1 = getHeight();
        if (r0 > 0.0f) goto L5;
    L31:
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Skip draw due to invalid size width=" + r0 + " height=" + r1);
        return;
    L5:
        if (r1 <= 0.0f) goto L31;
        this.clipRect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.clipRect.isEmpty() == false) goto L11;
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("Skip draw due to empty clip bounds rect=", this.clipRect));
        return;
    L11:
        boolean r2 = this.styleConfig.b();
        if (r2 == false) goto L14;
        float r3 = d.l.n.a(this.effectiveRadiusPx - this.strokeWidthPx, 0.0f);
    L15:
        if (r2 == false) goto L21;
        this.contentRect.set(this.clipRect);
        RectF r4 = this.contentRect;
        float r5 = this.strokeWidthPx;
        r4.inset(r5, r5);
        if (this.contentRect.isEmpty() == false) goto L20;
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("Stroke ON but skip content draw due to empty content bounds rect=", this.contentRect));
        return;
    L20:
        RectF r6 = this.contentRect;
    L22:
        this.clipPath.reset();
        this.clipPath.addRoundRect(r6, r3, r3, Path.Direction.CW);
        int r7 = r9.save();
        r9.clipPath(this.clipPath);
        super.onDraw(r9);
        r9.restoreToCount(r7);
        if (r2 == true) goto L25;
        return;
    L25:
        this.strokeRect.set(this.clipRect);
        float r8 = this.strokeWidthPx / 2.0f;
        this.strokeRect.inset(r8, r8);
        if (this.strokeRect.isEmpty() == false) goto L29;
        INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, o.a("Stroke ON but skip due to empty stroke bounds rect=", this.strokeRect));
        return;
    L29:
        float r10 = d.l.n.a(this.effectiveRadiusPx - r8, 0.0f);
        r9.drawRoundRect(this.strokeRect, r10, r10, this.strokePaint);
        return;
    L21:
        r6 = this.clipRect;
        goto L22
    L14:
        r3 = this.effectiveRadiusPx;
        goto L15
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_OImage_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
