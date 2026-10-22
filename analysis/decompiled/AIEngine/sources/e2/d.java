package e2;

import android.animation.Animator;
import android.animation.AnimatorSet;
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
import java.util.ArrayList;
import o0.a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends e implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    public final b f8528b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f8529c;

    /* renamed from: d, reason: collision with root package name */
    public com.google.android.material.bottomappbar.a f8530d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<e2.c> f8531e;
    public final a h;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            d.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            d.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            d.this.unscheduleSelf(runnable);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public f f8533a;

        /* renamed from: b, reason: collision with root package name */
        public AnimatorSet f8534b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<Animator> f8535c;

        /* renamed from: d, reason: collision with root package name */
        public p.a<Animator, String> f8536d;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public d(Context context, int i10) {
        this.f8530d = null;
        this.f8531e = null;
        this.h = new a();
        this.f8529c = context;
        this.f8528b = new b();
    }

    @Override // e2.e, android.graphics.drawable.Drawable
    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return o0.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        b bVar = this.f8528b;
        bVar.f8533a.draw(canvas);
        if (bVar.f8534b.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f8538a;
        return drawable != null ? o0.a.c(drawable) : this.f8528b.f8533a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f8528b.getClass();
        return changingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f8538a;
        return drawable != null ? a.C0115a.a(drawable) : this.f8528b.f8533a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f8538a != null) {
            return new c(this.f8538a.getConstantState());
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f8528b.f8533a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f8528b.f8533a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.getOpacity() : this.f8528b.f8533a.getOpacity();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        if (r3.f8534b != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ca, code lost:
    
        r3.f8534b = new android.animation.AnimatorSet();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        r3.f8534b.playTogether(r3.f8535c);
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
            android.graphics.drawable.Drawable r0 = r8.f8538a
            if (r0 == 0) goto L8
            r0.inflate(r9, r10, r11, r12)
            return
        L8:
            int r0 = r10.getEventType()
            int r1 = r10.getDepth()
            r2 = 1
            int r1 = r1 + r2
        L12:
            e2.d$b r3 = r8.f8528b
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
            if (r4 == 0) goto L66
            int[] r0 = e2.a.f8524e
            android.content.res.TypedArray r0 = m0.g.d(r9, r12, r11, r0)
            int r4 = r0.getResourceId(r5, r5)
            if (r4 == 0) goto L62
            e2.f r6 = new e2.f
            r6.<init>()
            android.graphics.drawable.Drawable r4 = m0.f.a(r9, r4, r12)
            r6.f8538a = r4
            e2.f$h r4 = new e2.f$h
            android.graphics.drawable.Drawable r7 = r6.f8538a
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r4.<init>(r7)
            r6.h = r5
            e2.d$a r4 = r8.h
            r6.setCallback(r4)
            e2.f r4 = r3.f8533a
            if (r4 == 0) goto L60
            r5 = 0
            r4.setCallback(r5)
        L60:
            r3.f8533a = r6
        L62:
            r0.recycle()
            goto Lc0
        L66:
            java.lang.String r4 = "target"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lc0
            int[] r0 = e2.a.f8525f
            android.content.res.TypedArray r0 = r9.obtainAttributes(r11, r0)
            java.lang.String r4 = r0.getString(r5)
            int r5 = r0.getResourceId(r2, r5)
            if (r5 == 0) goto Lbd
            android.content.Context r6 = r8.f8529c
            if (r6 == 0) goto Lb2
            android.animation.Animator r5 = android.animation.AnimatorInflater.loadAnimator(r6, r5)
            e2.f r6 = r3.f8533a
            e2.f$g r6 = r6.f8540b
            e2.f$f r6 = r6.f8586b
            p.a<java.lang.String, java.lang.Object> r6 = r6.f8584o
            java.lang.Object r6 = r6.get(r4)
            r5.setTarget(r6)
            java.util.ArrayList<android.animation.Animator> r6 = r3.f8535c
            if (r6 != 0) goto La7
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r3.f8535c = r6
            p.a r6 = new p.a
            r6.<init>()
            r3.f8536d = r6
        La7:
            java.util.ArrayList<android.animation.Animator> r6 = r3.f8535c
            r6.add(r5)
            p.a<android.animation.Animator, java.lang.String> r3 = r3.f8536d
            r3.put(r5, r4)
            goto Lbd
        Lb2:
            r0.recycle()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Context can't be null when inflating animators"
            r8.<init>(r9)
            throw r8
        Lbd:
            r0.recycle()
        Lc0:
            int r0 = r10.next()
            goto L12
        Lc6:
            android.animation.AnimatorSet r8 = r3.f8534b
            if (r8 != 0) goto Ld1
            android.animation.AnimatorSet r8 = new android.animation.AnimatorSet
            r8.<init>()
            r3.f8534b = r8
        Ld1:
            android.animation.AnimatorSet r8 = r3.f8534b
            java.util.ArrayList<android.animation.Animator> r9 = r3.f8535c
            r8.playTogether(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.d.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f8538a;
        return drawable != null ? o0.a.d(drawable) : this.f8528b.f8533a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        Drawable drawable = this.f8538a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f8528b.f8534b.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.isStateful() : this.f8528b.f8533a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f8528b.f8533a.setBounds(rect);
        }
    }

    @Override // e2.e, android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i10) {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.setLevel(i10) : this.f8528b.f8533a.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.setState(iArr) : this.f8528b.f8533a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f8528b.f8533a.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.e(drawable, z);
        } else {
            this.f8528b.f8533a.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8528b.f8533a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.h(drawable, i10);
        } else {
            this.f8528b.f8533a.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.i(drawable, colorStateList);
        } else {
            this.f8528b.f8533a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.j(drawable, mode);
        } else {
            this.f8528b.f8533a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z3) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return drawable.setVisible(z, z3);
        }
        this.f8528b.f8533a.setVisible(z, z3);
        return super.setVisible(z, z3);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        b bVar = this.f8528b;
        if (bVar.f8534b.isStarted()) {
            return;
        }
        bVar.f8534b.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f8528b.f8534b.end();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f8537a;

        public c(Drawable.ConstantState constantState) {
            this.f8537a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f8537a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f8537a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f8537a.newDrawable();
            dVar.f8538a = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.h);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f8537a.newDrawable(resources);
            dVar.f8538a = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.h);
            return dVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            d dVar = new d();
            Drawable drawableNewDrawable = this.f8537a.newDrawable(resources, theme);
            dVar.f8538a = drawableNewDrawable;
            drawableNewDrawable.setCallback(dVar.h);
            return dVar;
        }
    }

    public d() {
        this(null, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, Resources.NotFoundException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
