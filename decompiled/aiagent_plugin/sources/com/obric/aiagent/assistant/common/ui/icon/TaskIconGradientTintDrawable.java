package com.obric.aiagent.assistant.common.ui.icon;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: TaskIconGradientTintDrawable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TaskIconGradientTintDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TaskIconGradientTintDrawable f16135a = null;

    /* JADX INFO: compiled from: TaskIconGradientTintDrawable.kt */
    private static final class GradientMaskDrawable extends Drawable {
        private final Paint bitmapPaint;
        private Bitmap composedBitmap;
        private int drawableAlpha;
        private final Paint gradientPaint;
        private final boolean isDarkMode;
        private final int mainColor;
        private Bitmap maskBitmap;
        private final Rect maskBounds;
        private final Paint maskPaint;
        private final boolean solidColor;
        private final Drawable source;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        public /* synthetic */ GradientMaskDrawable(Drawable r1, int r2, boolean r3, boolean r4, int r5, h r6) {
            if ((r5 & 8) == 0) goto L5;
            r4 = false;
        L5:
            this(r1, r2, r3, r4);
        }

        public GradientMaskDrawable(Drawable r2, int r3, boolean r4, boolean r5) {
            o.e(r2, DBHelper.BATTERY_COL_SOURCE);
            this.source = r2;
            this.mainColor = r3;
            this.isDarkMode = r4;
            this.solidColor = r5;
            this.gradientPaint = new Paint(1);
            Paint r6 = new Paint(1);
            this.maskPaint = r6;
            this.bitmapPaint = new Paint(3);
            this.maskBounds = new Rect();
            this.drawableAlpha = 255;
            r6.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.DST_IN), Xfermode.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas r4) {
            o.e(r4, "canvas");
            Rect r0 = getBounds();
            o.c(r0, "getBounds(...)");
            if (r0.isEmpty() == false) goto L5;
            return;
        L5:
            this.bitmapPaint.setAlpha(this.drawableAlpha);
            r4.drawBitmap(getComposedBitmap(r0.width(), r0.height()), null, r0, this.bitmapPaint);
        }

        private final Bitmap getComposedBitmap(int r14, int r15) {
            Bitmap r0 = this.composedBitmap;
            if (r0 != null) goto L5;
        L9:
            int r16 = n.c(r14, 1);
            int r17 = n.c(r15, 1);
            Bitmap r1 = Bitmap.createBitmap(r16, r17, Bitmap.Config.ARGB_8888);
            o.c(r1, "createBitmap(...)");
            Canvas r2 = new Canvas(r1);
            if (this.solidColor == false) goto L13;
            int r9 = this.mainColor;
            int r10 = r9;
        L17:
            float r12 = r17;
            this.gradientPaint.setShader((Shader) ZeusTransformUtils.preCheckCast(new LinearGradient(0.0f, 0.0f, 0.0f, r12, r9, r10, Shader.TileMode.CLAMP), Shader.class, "com.obric.aiagent.plugin"));
            this.gradientPaint.setAlpha(255);
            r2.drawRect(0.0f, 0.0f, r16, r12, this.gradientPaint);
            r2.drawBitmap(getMaskBitmap(r16, r17), 0.0f, 0.0f, this.maskPaint);
            this.composedBitmap = r1;
            return r1;
        L13:
            if (this.isDarkMode == false) goto L15;
            int r3 = this.mainColor;
            int r4 = TaskIconGradientTintDrawable.a(TaskIconGradientTintDrawable.f16135a, this.mainColor, -16777216, 0.16f);
        L16:
            r9 = r3;
            r10 = r4;
            goto L17
        L15:
            r3 = TaskIconGradientTintDrawable.b(TaskIconGradientTintDrawable.f16135a, this.mainColor, -1, 0.16f);
            r4 = this.mainColor;
            goto L16
        L5:
            if (r0.getWidth() != r14) goto L9;
            if (r0.getHeight() != r15) goto L9;
            return r0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int r2) {
            if (this.drawableAlpha != r2) goto L5;
            return;
        L5:
            this.drawableAlpha = r2;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter r2) {
            this.bitmapPaint.setColorFilter(r2);
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.source.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.source.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect r3) {
            o.e(r3, "bounds");
            super.onBoundsChange(r3);
            if (this.maskBounds.width() == r3.width()) goto L5;
        L6:
            this.maskBitmap = null;
            this.composedBitmap = null;
        L7:
            this.maskBounds.set(r3);
            return;
        L5:
            if (this.maskBounds.height() == r3.height()) goto L7;
            goto L6
        }

        private final Bitmap getMaskBitmap(int r5, int r6) {
            Bitmap r0 = this.maskBitmap;
            if (r0 != null) goto L5;
        L9:
            Bitmap r7 = Bitmap.createBitmap(n.c(r5, 1), n.c(r6, 1), Bitmap.Config.ARGB_8888);
            o.c(r7, "createBitmap(...)");
            Canvas r8 = new Canvas(r7);
            this.source.setBounds(0, 0, r7.getWidth(), r7.getHeight());
            this.source.setAlpha(255);
            this.source.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN), ColorFilter.class, "com.obric.aiagent.plugin"));
            this.source.draw(r8);
            this.maskBitmap = r7;
            return r7;
        L5:
            if (r0.getWidth() != r5) goto L9;
            if (r0.getHeight() != r6) goto L9;
            return r0;
        }
    }

    static {
        f16135a = new TaskIconGradientTintDrawable();
    }

    private TaskIconGradientTintDrawable() {
    }

    public static final /* synthetic */ int a(TaskIconGradientTintDrawable r0, int r1, int r2, float r3) {
        return r0.b(r1, r2, r3);
    }

    public static final /* synthetic */ int b(TaskIconGradientTintDrawable r0, int r1, int r2, float r3) {
        return r0.a(r1, r2, r3);
    }

    public static final Drawable a(Context r2, int r3, int r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Drawable r7 = r6.getDrawable(r3);
        if (r7 != null) goto L7;
        return null;
    L7:
        return a(r7, r4, r5);
    }

    public static final Drawable a(Drawable r8, int r9, boolean r10) {
        o.e(r8, "drawable");
        Drawable r2 = r8.mutate();
        o.c(r2, "mutate(...)");
        return (Drawable) ZeusTransformUtils.preCheckCast(new GradientMaskDrawable(r2, r9, r10, false, 8, null), Drawable.class, "com.obric.aiagent.plugin");
    }

    public static final Drawable a(Context r3, int r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Drawable r7 = r6.getDrawable(r4);
        if (r7 != null) goto L6;
        return null;
    L6:
        Drawable r8 = r7.mutate();
        o.c(r8, "mutate(...)");
        return (Drawable) ZeusTransformUtils.preCheckCast(new GradientMaskDrawable(r8, r5, false, true), Drawable.class, "com.obric.aiagent.plugin");
    }

    private final int a(int r5, int r6, float r7) {
        int r8 = n.a(Math.round(Color.alpha(r6) * r7), 0, 255);
        return Color.argb(Color.alpha(r5), a(Color.red(r5), Color.red(r6), r8), a(Color.green(r5), Color.green(r6), r8), a(Color.blue(r5), Color.blue(r6), r8));
    }

    private final int a(int r1, int r2, int r3) {
        return n.d(r1 + ((r2 * r3) / 255), 255);
    }

    private final int b(int r5, int r6, float r7) {
        int r8 = n.a(Math.round(Color.alpha(r6) * r7), 0, 255);
        return Color.argb(Color.alpha(r5), b(Color.red(r5), Color.red(r6), r8), b(Color.green(r5), Color.green(r6), r8), b(Color.blue(r5), Color.blue(r6), r8));
    }

    private final int b(int r1, int r2, int r3) {
        return n.c((r1 + ((r2 * r3) / 255)) - r3, 0);
    }
}
