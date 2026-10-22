package p0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0195d;
import h.C0584b;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class e extends f implements Animatable {

    /* renamed from: c, reason: collision with root package name */
    public final Context f13853c;

    /* renamed from: d, reason: collision with root package name */
    public C0195d f13854d = null;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f13855e = null;

    /* renamed from: f, reason: collision with root package name */
    public final C0584b f13856f = new C0584b(this);

    /* renamed from: b, reason: collision with root package name */
    public final C0813c f13852b = new C0813c();

    public e(Context context) {
        this.f13853c = context;
    }

    @Override // p0.f, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            E.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return E.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        C0813c c0813c = this.f13852b;
        c0813c.f13847a.draw(canvas);
        if (c0813c.f13848b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getAlpha() : this.f13852b.f13847a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f13852b.getClass();
        return changingConfigurations | 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f13857a;
        return drawable != null ? E.a.c(drawable) : this.f13852b.f13847a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f13857a != null) {
            return new d(this.f13857a.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f13852b.f13847a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f13852b.f13847a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getOpacity() : this.f13852b.f13847a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.isAutoMirrored() : this.f13852b.f13847a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f13857a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f13852b.f13848b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.isStateful() : this.f13852b.f13847a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f13852b.f13847a.setBounds(rect);
        }
    }

    @Override // p0.f, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i4) {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.setLevel(i4) : this.f13852b.f13847a.setLevel(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.setState(iArr) : this.f13852b.f13847a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setAlpha(i4);
        } else {
            this.f13852b.f13847a.setAlpha(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setAutoMirrored(z4);
        } else {
            this.f13852b.f13847a.setAutoMirrored(z4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f13852b.f13847a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            com.airbnb.lottie.h.F(drawable, i4);
        } else {
            this.f13852b.f13847a.setTint(i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            com.airbnb.lottie.h.G(drawable, colorStateList);
        } else {
            this.f13852b.f13847a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            com.airbnb.lottie.h.H(drawable, mode);
        } else {
            this.f13852b.f13847a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return drawable.setVisible(z4, z5);
        }
        this.f13852b.f13847a.setVisible(z4, z5);
        return super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        C0813c c0813c = this.f13852b;
        if (c0813c.f13848b.isStarted()) {
            return;
        }
        c0813c.f13848b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f13852b.f13848b.end();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        if (r3.f13848b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        r3.f13848b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d3, code lost:
    
        r3.f13848b.playTogether(r3.f13849c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00da, code lost:
    
        return;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void inflate(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        /*
            r8 = this;
            android.graphics.drawable.Drawable r0 = r8.f13857a
            if (r0 == 0) goto L8
            E.a.d(r0, r9, r10, r11, r12)
            return
        L8:
            int r0 = r10.getEventType()
            int r1 = r10.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            p0.c r3 = r8.f13852b
            if (r0 == r2) goto Lc8
            int r4 = r10.getDepth()
            if (r4 >= r1) goto L1f
            r4 = 3
            if (r0 == r4) goto Lc8
        L1f:
            r4 = 2
            if (r0 != r4) goto Lc2
            java.lang.String r0 = r10.getName()
            java.lang.String r4 = "animated-vector"
            boolean r4 = r4.equals(r0)
            r5 = 0
            if (r4 == 0) goto L68
            int[] r0 = p0.AbstractC0811a.f13844e
            android.content.res.TypedArray r0 = Z2.I.z(r9, r12, r11, r0)
            int r4 = r0.getResourceId(r5, r5)
            if (r4 == 0) goto L64
            p0.o r6 = new p0.o
            r6.<init>()
            java.lang.ThreadLocal r7 = C.o.f272a
            android.graphics.drawable.Drawable r4 = C.j.a(r9, r4, r12)
            r6.f13857a = r4
            p0.n r4 = new p0.n
            android.graphics.drawable.Drawable r7 = r6.f13857a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r4.<init>(r7)
            r6.f13919f = r5
            h.b r4 = r8.f13856f
            r6.setCallback(r4)
            p0.o r4 = r3.f13847a
            if (r4 == 0) goto L62
            r5 = 0
            r4.setCallback(r5)
        L62:
            r3.f13847a = r6
        L64:
            r0.recycle()
            goto Lc2
        L68:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lc2
            int[] r0 = p0.AbstractC0811a.f13845f
            android.content.res.TypedArray r0 = r9.obtainAttributes(r11, r0)
            java.lang.String r4 = r0.getString(r5)
            int r6 = r0.getResourceId(r2, r5)
            if (r6 == 0) goto Lbf
            android.content.Context r7 = r8.f13853c
            if (r7 == 0) goto Lb4
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r7, r6)
            p0.o r7 = r3.f13847a
            p0.m r7 = r7.f13915b
            p0.l r7 = r7.f13902b
            q.f r7 = r7.f13900o
            java.lang.Object r7 = r7.get(r4)
            r6.setTarget(r7)
            java.util.ArrayList r7 = r3.f13849c
            if (r7 != 0) goto La9
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r3.f13849c = r7
            q.f r7 = new q.f
            r7.<init>(r5)
            r3.f13850d = r7
        La9:
            java.util.ArrayList r5 = r3.f13849c
            r5.add(r6)
            q.f r3 = r3.f13850d
            r3.put(r6, r4)
            goto Lbf
        Lb4:
            r0.recycle()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Context can't be null when inflating animators"
            r8.<init>(r9)
            throw r8
        Lbf:
            r0.recycle()
        Lc2:
            int r0 = r10.next()
            goto L12
        Lc8:
            android.animation.AnimatorSet r8 = r3.f13848b
            if (r8 != 0) goto Ld3
            android.animation.AnimatorSet r8 = new android.animation.AnimatorSet
            r8.<init>()
            r3.f13848b = r8
        Ld3:
            android.animation.AnimatorSet r8 = r3.f13848b
            java.util.ArrayList r9 = r3.f13849c
            r8.playTogether(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.e.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }
}
