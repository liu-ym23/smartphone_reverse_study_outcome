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
import com.GlobalProxyLancet;
import com.obric.common.oui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppIconDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0006H\u0016J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/oui/image/AppIconDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "icon", "strokeColor", "", "strokeWidthPixels", "", "clipToMask", "", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;IFZ)V", "maskPath", "Landroid/graphics/Path;", "pathMatrix", "Landroid/graphics/Matrix;", "strokePaint", "Landroid/graphics/Paint;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "drawClipMask", "drawNoClipMask", "getOpacity", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "refreshMaskPath", "setAlpha", "alpha", "setClipToMask", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setStrokeColor", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppIconDrawable extends Drawable {
    public static final Companion Companion = null;
    private static final String TAG = "OImageAppIcon";
    private boolean clipToMask;
    private final Context context;
    private final Drawable icon;
    private final Path maskPath;
    private final Matrix pathMatrix;
    private int strokeColor;
    private final Paint strokePaint;
    private final float strokeWidthPixels;

    /* JADX INFO: compiled from: AppIconDrawable.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/oui/image/AppIconDrawable$Companion;", "", "()V", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ AppIconDrawable(Context r7, Drawable r8, int r9, float r10, boolean r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = r7.getColor(R.color.oui_line_1);
    L5:
        int r3 = r9;
        if ((r12 & 8) == 0) goto L8;
        r10 = r7.getResources().getDimension(R.dimen.oui_image_stroke_width);
    L8:
        float r4 = r10;
        if ((r12 & 16) == 0) goto L11;
        r11 = false;
    L11:
        this(r7, r8, r3, r4, r11);
    }

    public AppIconDrawable(Context r2, Drawable r3, int r4, float r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "icon");
        this.context = r2;
        this.icon = r3;
        this.strokeColor = r4;
        this.strokeWidthPixels = r5;
        this.clipToMask = r6;
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.STROKE);
        r7.setColor(this.strokeColor);
        this.strokePaint = r7;
        this.maskPath = new Path();
        this.pathMatrix = new Matrix();
        refreshMaskPath();
    }

    public final void setClipToMask(boolean r2) {
        if (this.clipToMask != r2) goto L5;
        return;
    L5:
        this.clipToMask = r2;
        invalidateSelf();
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
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.clipToMask == true) goto L6;
        drawNoClipMask(r2);
        return;
    L6:
        drawClipMask(r2);
    }

    private final void drawClipMask(Canvas r5) {
        if (this.maskPath.isEmpty() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "draw skipped mask because maskPath is empty");
        this.icon.draw(r5);
        return;
    L6:
        int r0 = r5.save();
        r5.clipPath(this.maskPath);
        this.icon.draw(r5);
        float r2 = this.strokeWidthPixels;
        if (r2 > 0.0f) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r2)));
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
        this.icon.draw(r5);
        if (this.maskPath.isEmpty() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "draw skipped stroke because maskPath is empty");
        return;
    L6:
        float r0 = this.strokeWidthPixels;
        if (r0 > 0.0f) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, Intrinsics.stringPlus("draw skipped stroke because strokeWidthPixels=", Float.valueOf(r0)));
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

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.icon.setBounds(r2);
        refreshMaskPath();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.icon.setAlpha(r2);
        this.strokePaint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.icon.setColorFilter(r2);
        this.strokePaint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.icon.getOpacity();
    }

    private final void refreshMaskPath() {
        this.maskPath.reset();
        if (getBounds().isEmpty() == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "refreshMaskPath skipped because bounds is empty");
        return;
    L6:
        Path r0 = new AdaptiveIconDrawable(null, null, null).getIconMask();
        if (r0.isEmpty() == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "refreshMaskPath found empty icon mask");
        return;
    L10:
        float r1 = getBounds().width();
        float r2 = getBounds().height();
        float r3 = Math.min(r1, r2);
        float r6 = 0.0f;
        if (r1 <= r2) goto L13;
        float r4 = (r1 - r2) / 2.0f;
    L15:
        if (r2 <= r1) goto L17;
        r6 = (r2 - r1) / 2.0f;
    L17:
        this.pathMatrix.reset();
        float r5 = r3 / 100.0f;
        this.pathMatrix.setScale(r5, r5);
        this.maskPath.set(r0);
        this.maskPath.transform(this.pathMatrix);
        this.maskPath.offset(getBounds().left + r4, getBounds().top + r6);
        return;
    L13:
        r4 = 0.0f;
        goto L15
    }
}
