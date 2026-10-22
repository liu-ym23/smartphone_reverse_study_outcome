package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 0;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;

    @Nullable
    private Drawable overlayDrawable;

    @Nullable
    private CircularRevealWidget.RevealInfo revealInfo;

    @NonNull
    private final Paint revealPaint;

    @NonNull
    private final Path revealPath;

    @NonNull
    private final Paint scrimPaint;

    @NonNull
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas r10);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    static {
        STRATEGY = 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(Delegate r10) {
        this.delegate = r10;
        View r11 = (View) r10;
        this.view = r11;
        r11.setWillNotDraw(false);
        this.revealPath = new Path();
        this.revealPaint = new Paint(7);
        Paint r12 = new Paint(1);
        this.scrimPaint = r12;
        r12.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas r10, int r11, float r12) {
        this.debugPaint.setColor(r11);
        this.debugPaint.setStrokeWidth(r12);
        CircularRevealWidget.RevealInfo r13 = this.revealInfo;
        r10.drawCircle(r13.centerX, r13.centerY, r13.radius - (r12 / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas r10) {
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L6;
        CircularRevealWidget.RevealInfo r11 = this.revealInfo;
        r10.drawCircle(r11.centerX, r11.centerY, r11.radius, this.scrimPaint);
    L6:
        if (shouldDrawCircularReveal() == false) goto L8;
        drawDebugCircle(r10, -16777216, 10.0f);
        drawDebugCircle(r10, -65536, 5.0f);
    L8:
        drawOverlayDrawable(r10);
    }

    private void drawOverlayDrawable(@NonNull Canvas r10) {
        if (shouldDrawOverlayDrawable() == false) goto L6;
        Rect r11 = this.overlayDrawable.getBounds();
        float r12 = this.revealInfo.centerX - (r11.width() / 2.0f);
        float r13 = this.revealInfo.centerY - (r11.height() / 2.0f);
        r10.translate(r12, r13);
        this.overlayDrawable.draw(r10);
        r10.translate(-r12, -r13);
        return;
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo r10) {
        return MathUtils.distanceToFurthestCorner(r10.centerX, r10.centerY, 0.0f, 0.0f, this.view.getWidth(), this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY != 1) goto L7;
        this.revealPath.rewind();
        CircularRevealWidget.RevealInfo r10 = this.revealInfo;
        if (r10 == null) goto L7;
        this.revealPath.addCircle(r10.centerX, r10.centerY, r10.radius, Path.Direction.CW);
    L7:
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        CircularRevealWidget.RevealInfo r10 = this.revealInfo;
        if (r10 != null) goto L5;
    L8:
        boolean r11 = true;
    L10:
        if (STRATEGY != 0) goto L17;
        if (r11 == false) goto L13;
        return false;
    L13:
        if (this.hasCircularRevealCache == true) goto L15;
        return false;
    L15:
        return true;
    L17:
        return !r11;
    L5:
        if (r10.isInvalid() == true) goto L8;
        r11 = false;
        goto L10
    }

    private boolean shouldDrawOverlayDrawable() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L9:
        return false;
    L5:
        if (this.overlayDrawable == null) goto L9;
        if (this.revealInfo == null) goto L9;
        return true;
    }

    private boolean shouldDrawScrim() {
        if (this.buildingCircularRevealCache == false) goto L5;
    L7:
        return false;
    L5:
        if (Color.alpha(this.scrimPaint.getColor()) == 0) goto L7;
        return true;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY != 0) goto L15;
        this.buildingCircularRevealCache = true;
        this.hasCircularRevealCache = false;
        this.view.buildDrawingCache();
        Bitmap r10 = this.view.getDrawingCache();
        if (r10 == null) goto L7;
    L11:
        if (r10 == null) goto L13;
        Paint r11 = this.revealPaint;
        Shader.TileMode r12 = Shader.TileMode.CLAMP;
        r11.setShader(new BitmapShader(r10, r12, r12));
    L13:
        this.buildingCircularRevealCache = false;
        this.hasCircularRevealCache = true;
        return;
    L7:
        if (this.view.getWidth() == 0) goto L11;
        if (this.view.getHeight() == 0) goto L11;
        r10 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas r13 = new Canvas(r10);
        this.view.draw(r13);
        goto L11
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY != 0) goto L6;
        this.hasCircularRevealCache = false;
        this.view.destroyDrawingCache();
        this.revealPaint.setShader(null);
        this.view.invalidate();
        return;
    }

    public void draw(@NonNull Canvas r10) {
        if (shouldDrawCircularReveal() == false) goto L22;
        int r11 = STRATEGY;
        if (r11 != 0) goto L7;
        CircularRevealWidget.RevealInfo r12 = this.revealInfo;
        r10.drawCircle(r12.centerX, r12.centerY, r12.radius, this.revealPaint);
        if (shouldDrawScrim() == false) goto L25;
        CircularRevealWidget.RevealInfo r13 = this.revealInfo;
        r10.drawCircle(r13.centerX, r13.centerY, r13.radius, this.scrimPaint);
    L25:
        drawOverlayDrawable(r10);
        return;
    L7:
        if (r11 != 1) goto L9;
        int r14 = r10.save();
        r10.clipPath(this.revealPath);
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L18;
        r10.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
    L18:
        r10.restoreToCount(r14);
        goto L25
    L9:
        if (r11 != 2) goto L14;
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L25;
        r10.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    L14:
        throw new IllegalStateException("Unsupported strategy " + r11);
    L22:
        this.delegate.actualDraw(r10);
        if (shouldDrawScrim() == false) goto L25;
        r10.drawRect(0.0f, 0.0f, this.view.getWidth(), this.view.getHeight(), this.scrimPaint);
        goto L25
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo r10 = this.revealInfo;
        if (r10 != null) goto L6;
        return null;
    L6:
        CircularRevealWidget.RevealInfo r11 = new CircularRevealWidget.RevealInfo(r10);
        if (r11.isInvalid() == false) goto L9;
        r11.radius = getDistanceToFurthestCorner(r11);
    L9:
        return r11;
    }

    public boolean isOpaque() {
        if (this.delegate.actualIsOpaque() == true) goto L5;
    L7:
        return false;
    L5:
        if (shouldDrawCircularReveal() == true) goto L7;
        return true;
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable r10) {
        this.overlayDrawable = r10;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int r10) {
        this.scrimPaint.setColor(r10);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo r10) {
        if (r10 != null) goto L4;
        this.revealInfo = null;
    L11:
        invalidateRevealInfo();
        return;
    L4:
        CircularRevealWidget.RevealInfo r11 = this.revealInfo;
        if (r11 != null) goto L7;
        this.revealInfo = new CircularRevealWidget.RevealInfo(r10);
    L9:
        if (MathUtils.geq(r10.radius, getDistanceToFurthestCorner(r10), 1.0E-4f) == false) goto L11;
        this.revealInfo.radius = Float.MAX_VALUE;
        goto L11
    L7:
        r11.set(r10);
        goto L9
    }
}
