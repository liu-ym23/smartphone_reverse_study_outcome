package com.obric.oui.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AppIconDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppIconDrawable extends Drawable {
    public static final a Companion = null;
    private static final String TAG = "OImageAppIcon";
    private boolean backgroundAvoidsStroke;
    private Integer backgroundColor;
    private final Path backgroundMaskPath;
    private final Paint backgroundPaint;
    private boolean clipToMask;
    private final Context context;
    private final Drawable icon;
    private final Path maskPath;
    private final Matrix pathMatrix;
    private int strokeColor;
    private final Paint strokePaint;
    private final float strokeWidthPixels;

    /* JADX INFO: compiled from: AppIconDrawable.kt */
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

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.d(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public /* synthetic */ AppIconDrawable(Context r10, Drawable r11, Integer r12, int r13, float r14, boolean r15, int r16, h r17) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        if ((r16 & 4) == 0) goto L5;
        Integer r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        int r6 = r3.getColor(ZeusTransformUtils.mapRes(R.color.oui_line_1, "color", "oui_line_1"));
    L11:
        if ((r16 & 16) == 0) goto L13;
        float r7 = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDimension(ZeusTransformUtils.mapRes(R.dimen.oui_image_stroke_width, "dimen", "oui_image_stroke_width"));
    L15:
        if ((r16 & 32) == 0) goto L17;
        boolean r8 = false;
    L18:
        this(r3, r11, r5, r6, r7, r8);
        return;
    L17:
        r8 = r15;
        goto L18
    L13:
        r7 = r14;
        goto L15
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public AppIconDrawable(Context r3, Drawable r4, Integer r5, int r6, float r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r4, "icon");
        this.context = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
        this.icon = r4;
        this.backgroundColor = r5;
        this.strokeColor = r6;
        this.strokeWidthPixels = r7;
        this.clipToMask = r8;
        Paint r10 = new Paint(1);
        r10.setStyle(Paint.Style.STROKE);
        r10.setColor(this.strokeColor);
        this.strokePaint = r10;
        Paint r11 = new Paint(1);
        r11.setStyle(Paint.Style.FILL);
        this.backgroundPaint = r11;
        this.maskPath = new Path();
        this.backgroundMaskPath = new Path();
        this.pathMatrix = new Matrix();
        Integer r12 = this.backgroundColor;
        if (r12 == null) goto L6;
        r11.setColor(((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).intValue());
    L6:
        refreshMaskPath();
    }

    public final void setClipToMask(boolean r2) {
        if (this.clipToMask != r2) goto L5;
        return;
    L5:
        this.clipToMask = r2;
        invalidateSelf();
    }

    public final void setIconBackgroundColor(Integer r3) {
        if (o.a(this.backgroundColor, r3) == false) goto L5;
        return;
    L5:
        this.backgroundColor = r3;
        if (r3 == null) goto L8;
        boolean r0 = true;
    L9:
        this.backgroundAvoidsStroke = r0;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, o.a("backgroundAvoidsStroke =  ", Boolean.valueOf(r0)));
        if (r3 == null) goto L13;
        int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
        this.backgroundPaint.setColor(r4);
    L13:
        invalidateSelf();
        return;
    L8:
        r0 = false;
        goto L9
    }

    public final void setStrokeColor(int r2) {
        if (this.strokeColor != r2) goto L5;
        return;
    L5:
        this.strokeColor = r2;
        this.strokePaint.setColor(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        o.e(r2, "canvas");
        if (this.clipToMask == true) goto L6;
        drawNoClipMask(r2);
        return;
    L6:
        drawClipMask(r2);
    }

    private final void drawClipMask(Canvas r5) {
        if (this.maskPath.isEmpty() == false) goto L6;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "draw skipped mask because maskPath is empty");
        this.icon.draw(r5);
        return;
    L6:
        int r0 = r5.save();
        r5.clipPath(this.maskPath);
        drawMaskBackground(r5);
        this.icon.draw(r5);
        float r2 = this.strokeWidthPixels;
        if (r2 > 0.0f) goto L10;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, o.a("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r2)));
        r5.restoreToCount(r0);
        return;
    L10:
        this.strokePaint.setStrokeWidth(r2 * 2);
        this.strokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
        r5.drawPath(this.maskPath, this.strokePaint);
        r5.restoreToCount(r0);
    }

    private final void drawNoClipMask(Canvas r5) {
        drawMaskBackground(r5);
        this.icon.draw(r5);
        if (this.maskPath.isEmpty() == false) goto L6;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "draw skipped stroke because maskPath is empty");
        return;
    L6:
        float r0 = this.strokeWidthPixels;
        if (r0 > 0.0f) goto L10;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(TAG, o.a("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r0)));
        return;
    L10:
        int r1 = r5.save();
        r5.clipPath(this.maskPath);
        this.strokePaint.setStrokeWidth(this.strokeWidthPixels * 2);
        this.strokePaint.setStrokeJoin(Paint.Join.ROUND);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
        r5.drawPath(this.maskPath, this.strokePaint);
        r5.restoreToCount(r1);
    }

    private final void drawMaskBackground(Canvas r2) {
        if (this.backgroundColor != null) goto L6;
        return;
    L6:
        if (this.maskPath.isEmpty() == false) goto L10;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "draw skipped background because maskPath is empty");
        return;
    L10:
        if (this.backgroundAvoidsStroke == false) goto L12;
        Path r0 = this.backgroundMaskPath;
    L13:
        r2.drawPath(r0, this.backgroundPaint);
        return;
    L12:
        r0 = this.maskPath;
        goto L13
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r2) {
        o.e(r2, "bounds");
        super.onBoundsChange(r2);
        this.icon.setBounds(r2);
        refreshMaskPath();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.icon.setAlpha(r2);
        this.backgroundPaint.setAlpha(r2);
        this.strokePaint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.icon.setColorFilter(r2);
        this.backgroundPaint.setColorFilter(r2);
        this.strokePaint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.icon.getOpacity();
    }

    private final void refreshMaskPath() {
        this.maskPath.reset();
        this.backgroundMaskPath.reset();
        if (getBounds().isEmpty() == false) goto L6;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "refreshMaskPath skipped because bounds is empty, check if in whitelist");
        return;
    L6:
        Path r0 = new AdaptiveIconDrawable(null, null, null).getIconMask();
        if (r0.isEmpty() == false) goto L10;
        INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "refreshMaskPath found empty icon mask");
        return;
    L10:
        float r1 = getBounds().width();
        float r2 = getBounds().height();
        float r3 = Math.min(r1, r2);
        float r5 = 0.0f;
        if (r1 <= r2) goto L13;
        float r4 = (r1 - r2) / 2.0f;
    L15:
        if (r2 <= r1) goto L17;
        r5 = (r2 - r1) / 2.0f;
    L17:
        this.pathMatrix.reset();
        float r6 = r3 / 100.0f;
        this.pathMatrix.setScale(r6, r6);
        this.maskPath.set(r0);
        this.maskPath.transform(this.pathMatrix);
        this.maskPath.offset(getBounds().left + r4, getBounds().top + r5);
        float r7 = this.strokeWidthPixels + 1;
        this.pathMatrix.reset();
        float r8 = (r3 - (2.0f * r7)) / 100.0f;
        this.pathMatrix.setScale(r8, r8);
        this.backgroundMaskPath.set(r0);
        this.backgroundMaskPath.transform(this.pathMatrix);
        this.backgroundMaskPath.offset((getBounds().left + r4) + r7, (getBounds().top + r5) + r7);
        return;
    L13:
        r4 = 0.0f;
        goto L15
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_image_AppIconDrawable_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
