package d5;

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
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends g implements Animatable {

    /* renamed from: f, reason: collision with root package name */
    public final d f3205f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f3206g;

    /* renamed from: h, reason: collision with root package name */
    public bb.d f3207h = null;
    public ArrayList i = null;

    /* renamed from: j, reason: collision with root package name */
    public final c f3208j;

    public f(Context context) {
        c cVar = new c(0);
        cVar.f3199f = this;
        VarHandle.storeStoreFence();
        this.f3208j = cVar;
        this.f3206g = context;
        this.f3205f = new d();
    }

    @Override // d5.g, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        d dVar = this.f3205f;
        dVar.f3200a.draw(canvas);
        if (dVar.f3201b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getAlpha() : this.f3205f.f3200a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f3205f.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getColorFilter() : this.f3205f.f3200a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f3209c != null) {
            return new e(this.f3209c.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f3205f.f3200a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f3205f.f3200a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getOpacity() : this.f3205f.f3200a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        if (r3.f3201b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
    
        r3.f3201b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        r3.f3201b.playTogether(r3.f3202c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
    
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
            android.graphics.drawable.Drawable r0 = r8.f3209c
            if (r0 == 0) goto L8
            r0.inflate(r9, r10, r11, r12)
            return
        L8:
            int r0 = r10.getEventType()
            int r1 = r10.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            d5.d r3 = r8.f3205f
            if (r0 == r2) goto Lc6
            int r4 = r10.getDepth()
            if (r4 >= r1) goto L1f
            r4 = 3
            if (r0 == r4) goto Lc6
        L1f:
            r4 = 2
            if (r0 != r4) goto Lc0
            java.lang.String r0 = r10.getName()
            java.lang.String r4 = "animated-vector"
            boolean r4 = r4.equals(r0)
            r5 = 0
            if (r4 == 0) goto L68
            int[] r0 = d5.a.f3195e
            android.content.res.TypedArray r0 = e3.b.g(r9, r12, r11, r0)
            int r4 = r0.getResourceId(r5, r5)
            if (r4 == 0) goto L64
            d5.p r6 = new d5.p
            r6.<init>()
            java.lang.ThreadLocal r7 = e3.k.f3478a
            android.graphics.drawable.Drawable r4 = r9.getDrawable(r4, r12)
            r6.f3209c = r4
            d5.o r4 = new d5.o
            android.graphics.drawable.Drawable r7 = r6.f3209c
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r4.<init>(r7)
            r6.f3264j = r5
            d5.c r4 = r8.f3208j
            r6.setCallback(r4)
            d5.p r4 = r3.f3200a
            if (r4 == 0) goto L62
            r5 = 0
            r4.setCallback(r5)
        L62:
            r3.f3200a = r6
        L64:
            r0.recycle()
            goto Lc0
        L68:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lc0
            int[] r0 = d5.a.f3196f
            android.content.res.TypedArray r0 = r9.obtainAttributes(r11, r0)
            java.lang.String r4 = r0.getString(r5)
            int r6 = r0.getResourceId(r2, r5)
            if (r6 == 0) goto Lbd
            android.content.Context r7 = r8.f3206g
            if (r7 == 0) goto Lb4
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r7, r6)
            d5.p r7 = r3.f3200a
            d5.n r7 = r7.f3261f
            d5.m r7 = r7.f3249b
            p.e r7 = r7.f3247o
            java.lang.Object r7 = r7.get(r4)
            r6.setTarget(r7)
            java.util.ArrayList r7 = r3.f3202c
            if (r7 != 0) goto La9
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r3.f3202c = r7
            p.e r7 = new p.e
            r7.<init>(r5)
            r3.f3203d = r7
        La9:
            java.util.ArrayList r5 = r3.f3202c
            r5.add(r6)
            p.e r3 = r3.f3203d
            r3.put(r6, r4)
            goto Lbd
        Lb4:
            r0.recycle()
            java.lang.String r8 = "Context can't be null when inflating animators"
            od.f.e(r8)
            return
        Lbd:
            r0.recycle()
        Lc0:
            int r0 = r10.next()
            goto L12
        Lc6:
            android.animation.AnimatorSet r8 = r3.f3201b
            if (r8 != 0) goto Ld1
            android.animation.AnimatorSet r8 = new android.animation.AnimatorSet
            r8.<init>()
            r3.f3201b = r8
        Ld1:
            android.animation.AnimatorSet r8 = r3.f3201b
            java.util.ArrayList r9 = r3.f3202c
            r8.playTogether(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.f.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.isAutoMirrored() : this.f3205f.f3200a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f3209c;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f3205f.f3201b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.isStateful() : this.f3205f.f3200a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f3205f.f3200a.setBounds(rect);
        }
    }

    @Override // d5.g, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.setLevel(i) : this.f3205f.f3200a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.setState(iArr) : this.f3205f.f3200a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f3205f.f3200a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setAutoMirrored(z10);
        } else {
            this.f3205f.f3200a.setAutoMirrored(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3205f.f3200a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setTint(i);
        } else {
            this.f3205f.f3200a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        } else {
            this.f3205f.f3200a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setTintMode(mode);
        } else {
            this.f3205f.f3200a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f3205f.f3200a.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        d dVar = this.f3205f;
        if (dVar.f3201b.isStarted()) {
            return;
        }
        dVar.f3201b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f3205f.f3201b.end();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
