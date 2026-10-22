package com.stepos.core.common.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.stepos.core.common.R;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import dc.h;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class NotifRingBitmap {
    public static final NotifRingBitmap INSTANCE = new NotifRingBitmap();
    private static final float SIZE_DP = 44.0f;
    private static final float START_ANGLE = -90.0f;
    private static final float STROKE_DP = 3.0f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModelDownloadNotifier.NotifState.values().length];
            try {
                iArr[ModelDownloadNotifier.NotifState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModelDownloadNotifier.NotifState.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private NotifRingBitmap() {
    }

    private final int color(Context context, int i10) {
        return context.getColor(i10);
    }

    private final void drawCenterGlyph(Context context, Canvas canvas, int i10, float f8, ModelDownloadNotifier.NotifState notifState, int i11) {
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i11);
        float f9 = i10 / 2.0f;
        int i12 = WhenMappings.$EnumSwitchMapping$0[notifState.ordinal()];
        if (i12 != 1) {
            if (i12 != 2) {
                drawFullIcon(context, canvas, i10, notifState.getIconRes());
                return;
            }
            float f10 = f8 * 7.0f;
            Path path = new Path();
            float f11 = f9 - (0.4f * f10);
            path.moveTo(f11, f9 - f10);
            float f12 = f10 + f9;
            path.lineTo(f12, f9);
            path.lineTo(f11, f12);
            path.close();
            canvas.drawPath(path, paint);
            return;
        }
        float f13 = STROKE_DP * f8;
        float f14 = 12.0f * f8;
        float f15 = 2;
        float f16 = (f8 * 4.0f) / f15;
        float f17 = f9 - f16;
        float f18 = f14 / f15;
        float f19 = f9 - f18;
        float f20 = f9 + f18;
        float f21 = f13 / f15;
        canvas.drawRoundRect(f17 - f13, f19, f17, f20, f21, f21, paint);
        float f22 = f9 + f16;
        canvas.drawRoundRect(f22, f19, f22 + f13, f20, f21, f21, paint);
    }

    private final void drawFullIcon(Context context, Canvas canvas, int i10, int i11) {
        Drawable drawable = context.getDrawable(i11);
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, i10, i10);
        drawable.draw(canvas);
    }

    private final void drawRing(Canvas canvas, int i10, float f8, float f9, int i11, int i12) {
        float f10 = f8 * STROKE_DP;
        float f11 = (f10 / 2.0f) + 0.5f;
        float f12 = i10 - f11;
        RectF rectF = new RectF(f11, f11, f12, f12);
        Paint paint = new Paint(1);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(f10);
        paint.setColor(i11);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint paint2 = new Paint(1);
        paint2.setStyle(style);
        paint2.setStrokeWidth(f10);
        paint2.setColor(i12);
        paint2.setStrokeCap(cap);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, paint);
        if (f9 > 0.0f) {
            canvas.drawArc(rectF, START_ANGLE, f9 * 360.0f, false, paint2);
        }
    }

    public final Bitmap create(Context context, float f8, ModelDownloadNotifier.NotifState state, boolean z) {
        g.f(context, "context");
        g.f(state, "state");
        float f9 = context.getResources().getDisplayMetrics().density;
        int i10 = (int) (SIZE_DP * f9);
        int i11 = i10 < 1 ? 1 : i10;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i11, i11, Bitmap.Config.ARGB_8888);
        g.e(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (!z) {
            drawFullIcon(context, canvas, i11, state.getIconRes());
            return bitmapCreateBitmap;
        }
        drawRing(canvas, i11, f9, h.Z(f8, 0.0f, 1.0f), color(context, R.color.live_dl_ring_track), color(context, R.color.live_dl_ring_progress));
        drawCenterGlyph(context, canvas, i11, f9, state, color(context, R.color.live_dl_ring_center));
        return bitmapCreateBitmap;
    }
}
