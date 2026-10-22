package com.obric.oui.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ThumbDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0016\u0010\"\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\fJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/obric/oui/slider/ThumbDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "thumbIntrinsicHeight", "", "(Landroid/content/Context;I)V", "curHeight", "defaultHeight", "defaultMaxHeight", "defaultWidth", "isPressed", "", "mContext", "paint", "Landroid/graphics/Paint;", "getThumbIntrinsicHeight", "()I", "setThumbIntrinsicHeight", "(I)V", "thumbRadius", "", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setDefaultHeight", "setDefaultWidth", "setPressed", "pressed", "setThumbColor", "resourceColor", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThumbDrawable extends Drawable {
    private int curHeight;
    private int defaultHeight;
    private int defaultMaxHeight;
    private int defaultWidth;
    private boolean isPressed;
    private Context mContext;
    private final Paint paint;
    private int thumbIntrinsicHeight;
    private float thumbRadius;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public ThumbDrawable(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.thumbIntrinsicHeight = r3;
        this.mContext = r2;
        Paint r4 = new Paint();
        r4.setColor(ContextCompat.getColor(r2, R.color.oui_accent_bg));
        r4.setStyle(Paint.Style.FILL);
        r4.setAntiAlias(true);
        this.paint = r4;
        this.defaultHeight = OUnitExtensionKt.cdp(r2, 16);
        this.defaultMaxHeight = OUnitExtensionKt.cdp(r2, 24);
        this.curHeight = this.defaultHeight;
        this.defaultWidth = OUnitExtensionKt.cdp(r2, 4);
        this.thumbRadius = OUnitExtensionKt.cdpFloat(r2, 8);
    }

    public /* synthetic */ ThumbDrawable(Context r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = OUnitExtensionKt.cdp(r1, 48);
    L5:
        this(r1, r2);
    }

    public final int getThumbIntrinsicHeight() {
        return this.thumbIntrinsicHeight;
    }

    public final void setThumbIntrinsicHeight(int r1) {
        this.thumbIntrinsicHeight = r1;
    }

    public final void setDefaultHeight(int r4, int r5) {
        this.defaultHeight = r4;
        if (r4 != OUnitExtensionKt.cdp(this.mContext, 14)) goto L5;
        this.paint.setColor(ContextCompat.getColor(this.mContext, R.color.oui_text_1));
    L6:
        this.defaultMaxHeight = r5;
        this.curHeight = r4;
        invalidateSelf();
        return;
    L5:
        this.paint.setColor(ContextCompat.getColor(this.mContext, R.color.oui_accent_bg));
        goto L6
    }

    public final void setThumbColor(int r3) {
        this.paint.setColor(ContextCompat.getColor(this.mContext, r3));
        invalidateSelf();
    }

    public final void setDefaultWidth(int r1) {
        this.defaultWidth = r1;
        invalidateSelf();
    }

    public final void setPressed(boolean r1) {
        this.isPressed = r1;
        if (r1 == false) goto L5;
        this.curHeight = this.defaultMaxHeight;
    L6:
        invalidateSelf();
        return;
    L5:
        this.curHeight = this.defaultHeight;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.thumbIntrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Rect r0 = getBounds();
        Intrinsics.checkNotNullExpressionValue(r0, "bounds");
        int r1 = (r0.height() - this.curHeight) / 2;
        RectF r2 = new RectF(r0.left, r1, r0.right, r1 + this.curHeight);
        float r3 = this.thumbRadius;
        r7.drawRoundRect(r2, r3, r3, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r2) {
        this.paint.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r2) {
        this.paint.setColorFilter(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.defaultWidth;
    }
}
