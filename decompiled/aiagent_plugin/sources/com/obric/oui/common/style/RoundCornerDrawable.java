package com.obric.oui.common.style;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: RoundCornerDrawable.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class RoundCornerDrawable extends DrawableWrapper implements Animatable {
    private final Paint clipPaint;
    private RectF clipRect;
    private DisplayMetrics dm;
    private Bitmap maskBitmap;
    private float radius;

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float r1) {
        this.radius = r1;
    }

    public RoundCornerDrawable() {
        super(null);
        Paint r0 = new Paint(1);
        this.clipPaint = r0;
        this.radius = 16.0f;
        r0.setStyle(Paint.Style.FILL);
        r0.setAntiAlias(true);
    }

    public RoundCornerDrawable(Drawable r3) {
        o.e(r3, "bg");
        super(r3);
        Paint r4 = new Paint(1);
        this.clipPaint = r4;
        this.radius = 16.0f;
        r4.setStyle(Paint.Style.FILL);
        r4.setAntiAlias(true);
    }

    public RoundCornerDrawable(Drawable r2, DisplayMetrics r3) {
        o.e(r2, "bg");
        o.e(r3, "displayMetrics");
        this(r2);
        this.dm = r3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r6, int r7, int r8, int r9) {
        super.setBounds(r6, r7, r8, r9);
        RectF r0 = new RectF(r6, r7, r8, r9);
        if (o.a(r0, this.clipRect) == true) goto L10;
        Bitmap r1 = this.maskBitmap;
        if (r1 == null) goto L8;
        r1.recycle();
    L8:
        Bitmap r10 = Bitmap.createBitmap(this.dm, r8 - r6, r9 - r7, Bitmap.Config.ARGB_8888);
        Canvas r11 = new Canvas(r10);
        float r12 = this.radius;
        r11.drawRoundRect(r0, r12, r12, this.clipPaint);
        this.clipRect = r0;
        this.maskBitmap = r10;
        return;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r7) {
        o.e(r7, "canvas");
        int r0 = r7.saveLayer(this.clipRect, this.clipPaint);
        super.draw(r7);
        Bitmap r1 = this.maskBitmap;
        if (r1 == null) goto L6;
        this.clipPaint.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(new PorterDuffXfermode(PorterDuff.Mode.DST_IN), Xfermode.class, "com.obric.aiagent.plugin"));
        r7.drawBitmap(r1, 0.0f, 0.0f, this.clipPaint);
        this.clipPaint.setXfermode(null);
    L6:
        r7.restoreToCount(r0);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources r6, XmlPullParser r7, AttributeSet r8, Resources.Theme r9) {
        XmlPullParser r10 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r7, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, DownloadFileUtils.MODE_READ);
        o.e(r10, "parser");
        o.e(r11, "attrs");
        super.inflate(r6, r10, r11, r9);
        int r0 = r10.getDepth();
        this.dm = r6.getDisplayMetrics();
        Drawable r1 = null;
    L3:
        int r2 = r10.next();
        if (r2 == 1) goto L15;
        if (r2 != 3) goto L10;
        if (r10.getDepth() <= r0) goto L15;
    L10:
        if (r2 != 2) goto L3;
        if (o.a(r10.getName(), "corners") == true) goto L13;
        r1 = DrawableWrapper.createFromXmlInner(r6, r10, r11, r9);
        goto L3
    L13:
        this.radius = g.a(r6, r9, r11, new int[]{R.attr.radius}).getDimensionPixelSize(0, (int) this.radius);
    L15:
        if (r1 == null) goto L27;
        setDrawable(r1);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r2 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r2, AnimationDrawable.class) == false) goto L6;
        ((AnimationDrawable) ZeusTransformUtils.preCheckCast(r2, AnimationDrawable.class, "com.obric.aiagent.plugin")).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable r2 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r2, AnimationDrawable.class) == false) goto L6;
        ((AnimationDrawable) ZeusTransformUtils.preCheckCast(r2, AnimationDrawable.class, "com.obric.aiagent.plugin")).stop();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r2 = getDrawable();
        if (ZeusTransformUtils.instanceOf(r2, AnimationDrawable.class) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) ZeusTransformUtils.preCheckCast(r2, AnimationDrawable.class, "com.obric.aiagent.plugin")).isRunning();
    }
}
