package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.res.h;
import androidx.core.content.res.k;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q.C0933a;

/* loaded from: classes.dex */
public class c extends e implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    private C0150c f11516b;

    /* renamed from: c, reason: collision with root package name */
    private Context f11517c;

    /* renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f11518d;

    /* renamed from: e, reason: collision with root package name */
    d f11519e;

    /* renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f11520f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<androidx.vectordrawable.graphics.drawable.b> f11521g;

    /* renamed from: h, reason: collision with root package name */
    final Drawable.Callback f11522h;

    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
            c.this.scheduleSelf(runnable, j5);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f11521g);
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i5)).b(c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f11521g);
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i5)).c(c.this);
            }
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.c$c, reason: collision with other inner class name */
    private static class C0150c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f11525a;

        /* renamed from: b, reason: collision with root package name */
        f f11526b;

        /* renamed from: c, reason: collision with root package name */
        AnimatorSet f11527c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f11528d;

        /* renamed from: e, reason: collision with root package name */
        C0933a<Animator, String> f11529e;

        public C0150c(Context context, C0150c c0150c, Drawable.Callback callback, Resources resources) {
            if (c0150c != null) {
                this.f11525a = c0150c.f11525a;
                f fVar = c0150c.f11526b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    if (resources != null) {
                        this.f11526b = (f) constantState.newDrawable(resources);
                    } else {
                        this.f11526b = (f) constantState.newDrawable();
                    }
                    f fVar2 = (f) this.f11526b.mutate();
                    this.f11526b = fVar2;
                    fVar2.setCallback(callback);
                    this.f11526b.setBounds(c0150c.f11526b.getBounds());
                    this.f11526b.g(false);
                }
                ArrayList<Animator> arrayList = c0150c.f11528d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f11528d = new ArrayList<>(size);
                    this.f11529e = new C0933a<>(size);
                    for (int i5 = 0; i5 < size; i5++) {
                        Animator animator = c0150c.f11528d.get(i5);
                        Animator animatorClone = animator.clone();
                        String str = c0150c.f11529e.get(animator);
                        animatorClone.setTarget(this.f11526b.c(str));
                        this.f11528d.add(animatorClone);
                        this.f11529e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f11527c == null) {
                this.f11527c = new AnimatorSet();
            }
            this.f11527c.playTogether(this.f11528d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f11525a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    c() {
        this(null, null, null);
    }

    public static c a(Context context, int i5) {
        c cVar = new c(context);
        Drawable drawableF = h.f(context.getResources(), i5, context.getTheme());
        cVar.f11531a = drawableF;
        drawableF.setCallback(cVar.f11522h);
        cVar.f11519e = new d(cVar.f11531a.getConstantState());
        return cVar;
    }

    private static void c(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    private void d() {
        Animator.AnimatorListener animatorListener = this.f11520f;
        if (animatorListener != null) {
            this.f11516b.f11527c.removeListener(animatorListener);
            this.f11520f = null;
        }
    }

    private void e(String str, Animator animator) {
        animator.setTarget(this.f11516b.f11526b.c(str));
        C0150c c0150c = this.f11516b;
        if (c0150c.f11528d == null) {
            c0150c.f11528d = new ArrayList<>();
            this.f11516b.f11529e = new C0933a<>();
        }
        this.f11516b.f11528d.add(animator);
        this.f11516b.f11529e.put(animator, str);
    }

    private static boolean g(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    public void b(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            c((AnimatedVectorDrawable) drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f11521g == null) {
            this.f11521g = new ArrayList<>();
        }
        if (this.f11521g.contains(bVar)) {
            return;
        }
        this.f11521g.add(bVar);
        if (this.f11520f == null) {
            this.f11520f = new b();
        }
        this.f11516b.f11527c.addListener(this.f11520f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f11516b.f11526b.draw(canvas);
        if (this.f11516b.f11527c.isStarted()) {
            invalidateSelf();
        }
    }

    public boolean f(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            g((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList<androidx.vectordrawable.graphics.drawable.b> arrayList = this.f11521g;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(bVar);
        if (this.f11521g.size() == 0) {
            d();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f11531a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f11516b.f11526b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f11516b.f11525a | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f11531a;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f11516b.f11526b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f11531a != null) {
            return new d(this.f11531a.getConstantState());
        }
        return null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f11516b.f11526b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f11516b.f11526b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.getOpacity() : this.f11516b.f11526b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayQ = k.q(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f11506e);
                    int resourceId = typedArrayQ.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f fVarB = f.b(resources, resourceId, theme);
                        fVarB.g(false);
                        fVarB.setCallback(this.f11522h);
                        f fVar = this.f11516b.f11526b;
                        if (fVar != null) {
                            fVar.setCallback(null);
                        }
                        this.f11516b.f11526b = fVarB;
                    }
                    typedArrayQ.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f11507f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f11517c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        e(string, androidx.vectordrawable.graphics.drawable.d.a(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f11516b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f11531a;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f11516b.f11526b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f11531a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f11516b.f11527c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.isStateful() : this.f11516b.f11526b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f11516b.f11526b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i5) {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.setLevel(i5) : this.f11516b.f11526b.setLevel(i5);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.setState(iArr) : this.f11516b.f11526b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else {
            this.f11516b.f11526b.setAlpha(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z5);
        } else {
            this.f11516b.f11526b.setAutoMirrored(z5);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i5) {
        super.setChangingConfigurations(i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i5, PorterDuff.Mode mode) {
        super.setColorFilter(i5, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z5) {
        super.setFilterBitmap(z5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f5, float f6) {
        super.setHotspot(f5, f6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i5, int i6, int i7, int i8) {
        super.setHotspotBounds(i5, i6, i7, i8);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i5);
        } else {
            this.f11516b.f11526b.setTint(i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f11516b.f11526b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f11516b.f11526b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return drawable.setVisible(z5, z6);
        }
        this.f11516b.f11526b.setVisible(z5, z6);
        return super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f11516b.f11527c.isStarted()) {
                return;
            }
            this.f11516b.f11527c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f11516b.f11527c.end();
        }
    }

    private c(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f11516b.f11526b.setColorFilter(colorFilter);
        }
    }

    private static class d extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f11530a;

        public d(Drawable.ConstantState constantState) {
            this.f11530a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f11530a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f11530a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f11530a.newDrawable();
            cVar.f11531a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f11522h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f11530a.newDrawable(resources);
            cVar.f11531a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f11522h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f11530a.newDrawable(resources, theme);
            cVar.f11531a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f11522h);
            return cVar;
        }
    }

    private c(Context context, C0150c c0150c, Resources resources) {
        this.f11518d = null;
        this.f11520f = null;
        this.f11521g = null;
        a aVar = new a();
        this.f11522h = aVar;
        this.f11517c = context;
        if (c0150c != null) {
            this.f11516b = c0150c;
        } else {
            this.f11516b = new C0150c(context, c0150c, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
