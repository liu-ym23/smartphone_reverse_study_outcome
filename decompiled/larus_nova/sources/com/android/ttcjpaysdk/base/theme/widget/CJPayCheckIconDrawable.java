package com.android.ttcjpaysdk.base.theme.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.ttcjpaysdk.base.ktextension.CJPayColorHelper;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.android.ttcjpaysdk.base.theme.CJPayThemeManager;
import com.android.ttcjpaysdk.base.theme.CJPayThemeUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J0\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J0\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCheckIconDrawable;", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isChecked", "", "style", "Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCheckIconDrawable$Style;", "(Landroid/content/Context;ZLcom/android/ttcjpaysdk/base/theme/widget/CJPayCheckIconDrawable$Style;)V", "fillPaint", "Landroid/graphics/Paint;", "strokePaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawCheckPath", "cx", "", "cy", "size", "drawCircleTick", "brandColor", "", "drawTickOnly", "getAlpha", "getOpacity", "resolveBrandColor", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Style", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCheckIconDrawable extends Drawable {
    private final Context context;
    private final Paint fillPaint;
    private final boolean isChecked;
    private final Paint strokePaint;
    private final Style style;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/theme/widget/CJPayCheckIconDrawable$Style;", "", "(Ljava/lang/String;I)V", "CIRCLE_TICK", "TICK_ONLY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style CIRCLE_TICK = null;
        public static final Style TICK_ONLY = null;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{CIRCLE_TICK, TICK_ONLY};
        }

        public static Style valueOf(String r100) {
            return (Style) a.a(Style.class, r100);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        static {
            CIRCLE_TICK = new Style("CIRCLE_TICK", 0);
            TICK_ONLY = new Style("TICK_ONLY", 1);
            $VALUES = $values();
        }

        private Style(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Style.values().length];
            r100[Style.CIRCLE_TICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Style.TICK_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private final int resolveBrandColor() {
        boolean r100 = false;
        String r101 = null;
        int r102 = CJPayColorHelper.safeParseColor$default(CJPayColorConstants.CJ_PAY_RED, 0, 2, null);
        CJPayThemeManager.ThemeInfo r103 = CJPayThemeManager.getInstance().getThemeInfo();     // Catch: Throwable -> L16
        if (r103 == null) goto L6;
        CJPayThemeManager.CheckBoxInfo r104 = r103.checkBoxInfo;     // Catch: Throwable -> L16
    L7:
        if (r104 == null) goto L9;
        r101 = r104.bgColor;     // Catch: Throwable -> L16
    L9:
        if (r101 != null) goto L11;
    L12:
        r100 = true;
    L13:
        if (r100 == true) goto L19;
        return Color.parseColor(r101);
    L19:
        return r102;
    L11:
        if (r101.length() != 0) goto L13;
    L6:
        r104 = null;
    L20:
        return r102;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.strokePaint.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Rect r100 = getBounds();
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        float r101 = r100.width();
        float r102 = r100.height();
        float r103 = Math.min(r101, r102);
        float r104 = r100.left + (r101 / 2.0f);
        float r105 = r100.top + (r102 / 2.0f);
        int r106 = resolveBrandColor();
        int r107 = WhenMappings.$EnumSwitchMapping$0[this.style.ordinal()];
        if (r107 != 1) goto L8;
        drawCircleTick(r110, r104, r105, r103, r106);
        return;
    L8:
        if (r107 != 2) goto L14;
        drawTickOnly(r110, r104, r105, r103, r106);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        this.fillPaint.setAlpha(r100);
        this.strokePaint.setAlpha(r100);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        this.fillPaint.setColorFilter(r100);
        this.strokePaint.setColorFilter(r100);
        invalidateSelf();
    }

    public CJPayCheckIconDrawable(Context r100, boolean r101, Style r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "style");
        this.context = r100;
        this.isChecked = r101;
        this.style = r102;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.fillPaint = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeJoin(Paint.Join.ROUND);
        this.strokePaint = r104;
    }

    private final void drawCheckPath(Canvas r100, float r101, float r110, float r111) {
        float r102 = r111 / 2.0f;
        float r103 = r101 - r102;
        float r104 = r110 - r102;
        float r105 = r101 + r102;
        float r112 = r110 + r102;
        Path r106 = new Path();
        float r107 = 0.25f * r111;
        float r108 = r103 + r107;
        float r109 = r112 - (0.48f * r111);
        float r113 = r103 + (0.45f * r111);
        float r114 = r111 * 0.3f;
        r106.moveTo(r108, r109);
        r106.lineTo(r113, r112 - r114);
        r106.lineTo(r105 - r107, r104 + r114);
        r100.drawPath(r106, this.strokePaint);
    }

    private final void drawCircleTick(Canvas r100, float r101, float r102, float r103, int r110) {
        float r104 = r103 / 2.0f;
        float r105 = 0.08f * r103;
        if (this.isChecked == true) goto L5;
        this.strokePaint.setColor(CJPayThemeUtils.getColor(this.context.getApplicationContext(), R.attr.cj_pay_gray_circle_stroke, R.color.cj_pay_color_gray_bfbfbf_opacity_100));
        this.strokePaint.setStrokeWidth(r105);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        r100.drawCircle(r101, r102, r104 - (r105 / 2.0f), this.strokePaint);
        return;
    L5:
        this.fillPaint.setColor(r110);
        r100.drawCircle(r101, r102, r104, this.fillPaint);
        this.strokePaint.setColor(-1);
        this.strokePaint.setStrokeWidth(r105);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        drawCheckPath(r100, r101, r102, r103);
    }

    private final void drawTickOnly(Canvas r100, float r101, float r102, float r103, int r104) {
        if (this.isChecked == true) goto L5;
        return;
    L5:
        this.strokePaint.setColor(r104);
        this.strokePaint.setStrokeWidth(0.1f * r103);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        drawCheckPath(r100, r101, r102, r103);
    }
}
