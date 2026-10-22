package com.obric.oui.common.style;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import kotlin.jvm.internal.q;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f13082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f13083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f13084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DisplayMetrics f13086e;

    public k(Drawable r10) {
        q.g(r10, "bg");
        super(r10);
        Paint r11 = new Paint(1);
        this.f13082a = r11;
        this.f13085d = 16.0f;
        r11.setStyle(Paint.Style.FILL);
        r11.setAntiAlias(true);
    }

    public final void a(float r10) {
        this.f13085d = r10;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        q.g(r10, "canvas");
        int r11 = r10.saveLayer(this.f13084c, this.f13082a);
        super.draw(r10);
        Bitmap r12 = this.f13083b;
        if (r12 == null) goto L6;
        this.f13082a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r10.drawBitmap(r12, 0.0f, 0.0f, this.f13082a);
        this.f13082a.setXfermode(null);
    L6:
        r10.restoreToCount(r11);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        q.g(r10, "r");
        q.g(r11, "parser");
        q.g(r12, "attrs");
        super.inflate(r10, r11, r12, r13);
        int r14 = r11.getDepth();
        this.f13086e = r10.getDisplayMetrics();
        Drawable r15 = null;
    L3:
        int r16 = r11.next();
        if (r16 == 1) goto L15;
        if (r16 != 3) goto L10;
        if (r11.getDepth() <= r14) goto L15;
    L10:
        if (r16 != 2) goto L3;
        if (q.b(r11.getName(), "corners") == true) goto L13;
        r15 = DrawableWrapper.createFromXmlInner(r10, r11, r12, r13);
        goto L3
    L13:
        this.f13085d = i.d(r10, r13, r12, new int[]{R.attr.radius}).getDimensionPixelSize(0, (int) this.f13085d);
    L15:
        if (r15 == null) goto L27;
        setDrawable(r15);
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r10 = getDrawable();
        if ((r10 instanceof AnimationDrawable) == true) goto L5;
        return false;
    L5:
        return ((AnimationDrawable) r10).isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int r10, int r11, int r12, int r13) {
        super.setBounds(r10, r11, r12, r13);
        RectF r14 = new RectF(r10, r11, r12, r13);
        if (q.b(r14, this.f13084c) == true) goto L10;
        Bitmap r15 = this.f13083b;
        if (r15 == null) goto L8;
        r15.recycle();
    L8:
        Bitmap r16 = Bitmap.createBitmap(this.f13086e, r12 - r10, r13 - r11, Bitmap.Config.ARGB_8888);
        Canvas r17 = new Canvas(r16);
        float r18 = this.f13085d;
        r17.drawRoundRect(r14, r18, r18, this.f13082a);
        this.f13084c = r14;
        this.f13083b = r16;
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r10 = getDrawable();
        if ((r10 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r10).start();
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable r10 = getDrawable();
        if ((r10 instanceof AnimationDrawable) == false) goto L6;
        ((AnimationDrawable) r10).stop();
        return;
    }

    public k(Drawable r10, DisplayMetrics r11) {
        q.g(r10, "bg");
        q.g(r11, "displayMetrics");
        this(r10);
        this.f13086e = r11;
    }
}
