package L3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import com.stepos.alphame.R;

/* loaded from: classes2.dex */
public final class b extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f1263a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1264b;

    /* renamed from: c, reason: collision with root package name */
    public int f1265c;

    /* renamed from: d, reason: collision with root package name */
    public final com.stepos.common.widget.r f1266d;

    public b(Context context, Drawable drawable) throws Resources.NotFoundException {
        Drawable drawable2 = this.f1263a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1263a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        com.stepos.common.widget.r rVar = new com.stepos.common.widget.r(context);
        this.f1266d = rVar;
        rVar.f11947d = true;
    }

    public final void a(Canvas canvas) {
        this.f1263a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void jumpToCurrentState() {
        this.f1263a.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void onBoundsChange(Rect rect) {
        this.f1263a.setBounds(rect);
    }

    public final void d(int i4) {
        this.f1263a.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        a(canvas);
        if (this.f1264b) {
            Rect bounds = getBounds();
            canvas.save();
            com.stepos.common.widget.r rVar = this.f1266d;
            int i4 = rVar.f11953j;
            int i5 = rVar.f11954k;
            if (this.f1265c > 0) {
                canvas.translate(bounds.right - (i4 >> 1), bounds.top - (i5 >> 1));
            } else {
                canvas.translate(bounds.right - i4, bounds.top);
            }
            rVar.a(canvas);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final void setAutoMirrored(boolean z4) {
        this.f1263a.setAutoMirrored(z4);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void setChangingConfigurations(int i4) {
        this.f1263a.setChangingConfigurations(i4);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f1263a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.f1263a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f1263a.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f1263a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f1263a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.f1263a.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.f1263a.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f1263a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.f1263a.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.f1263a.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.f1263a.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setDither(boolean z4) {
        this.f1263a.setDither(z4);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void setFilterBitmap(boolean z4) {
        this.f1263a.setFilterBitmap(z4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f1263a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f1263a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void setHotspot(float f4, float f5) {
        E.a.e(this.f1263a, f4, f5);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void setHotspotBounds(int i4, int i5, int i6, int i7) {
        E.a.f(this.f1263a, i4, i5, i6, i7);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void setTint(int i4) {
        E.a.g(this.f1263a, i4);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final void setTintList(ColorStateList colorStateList) {
        E.a.h(this.f1263a, colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final void setTintMode(PorterDuff.Mode mode) {
        E.a.i(this.f1263a, mode);
    }

    @Override // android.graphics.drawable.Drawable
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final boolean setVisible(boolean z4, boolean z5) {
        return super.setVisible(z4, z5) || this.f1263a.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i4) {
        return this.f1263a.setLevel(i4);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        scheduleSelf(runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        d(i4);
        com.stepos.common.widget.r rVar = this.f1266d;
        rVar.f11951h.setAlpha(i4);
        rVar.f11952i.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        return this.f1263a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
