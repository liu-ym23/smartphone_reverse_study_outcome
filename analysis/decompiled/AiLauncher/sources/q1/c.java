package q1;

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
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s0.h;
import s0.k;
import u0.C5566a;

/* loaded from: classes.dex */
public class c extends e implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    public C0503c f38507b;

    /* renamed from: c, reason: collision with root package name */
    public Context f38508c;

    /* renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f38509d;

    /* renamed from: e, reason: collision with root package name */
    public d f38510e;

    /* renamed from: f, reason: collision with root package name */
    public Animator.AnimatorListener f38511f;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<q1.b> f38512g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable.Callback f38513h;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            c.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f38512g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((q1.b) arrayList.get(i10)).b(c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f38512g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((q1.b) arrayList.get(i10)).c(c.this);
            }
        }
    }

    /* renamed from: q1.c$c, reason: collision with other inner class name */
    public static class C0503c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f38516a;

        /* renamed from: b, reason: collision with root package name */
        public f f38517b;

        /* renamed from: c, reason: collision with root package name */
        public AnimatorSet f38518c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<Animator> f38519d;

        /* renamed from: e, reason: collision with root package name */
        public androidx.collection.a<Animator, String> f38520e;

        public C0503c(Context context, C0503c c0503c, Drawable.Callback callback, Resources resources) {
            if (c0503c != null) {
                this.f38516a = c0503c.f38516a;
                f fVar = c0503c.f38517b;
                if (fVar != null) {
                    Drawable.ConstantState constantState = fVar.getConstantState();
                    if (resources != null) {
                        this.f38517b = (f) constantState.newDrawable(resources);
                    } else {
                        this.f38517b = (f) constantState.newDrawable();
                    }
                    f fVar2 = (f) this.f38517b.mutate();
                    this.f38517b = fVar2;
                    fVar2.setCallback(callback);
                    this.f38517b.setBounds(c0503c.f38517b.getBounds());
                    this.f38517b.g(false);
                }
                ArrayList<Animator> arrayList = c0503c.f38519d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f38519d = new ArrayList<>(size);
                    this.f38520e = new androidx.collection.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = c0503c.f38519d.get(i10);
                        Animator animatorClone = animator.clone();
                        String str = c0503c.f38520e.get(animator);
                        animatorClone.setTarget(this.f38517b.c(str));
                        this.f38519d.add(animatorClone);
                        this.f38520e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f38518c == null) {
                this.f38518c = new AnimatorSet();
            }
            this.f38518c.playTogether(this.f38519d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f38516a;
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

    public c() {
        this(null, null, null);
    }

    public static c a(Context context, int i10) throws Resources.NotFoundException {
        c cVar = new c(context);
        Drawable drawableE = h.e(context.getResources(), i10, context.getTheme());
        cVar.f38522a = drawableE;
        drawableE.setCallback(cVar.f38513h);
        cVar.f38510e = new d(cVar.f38522a.getConstantState());
        return cVar;
    }

    public static void c(AnimatedVectorDrawable animatedVectorDrawable, q1.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    public static boolean g(AnimatedVectorDrawable animatedVectorDrawable, q1.b bVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.a(drawable, theme);
        }
    }

    public void b(q1.b bVar) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            c((AnimatedVectorDrawable) drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f38512g == null) {
            this.f38512g = new ArrayList<>();
        }
        if (this.f38512g.contains(bVar)) {
            return;
        }
        this.f38512g.add(bVar);
        if (this.f38511f == null) {
            this.f38511f = new b();
        }
        this.f38507b.f38518c.addListener(this.f38511f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return C5566a.b(drawable);
        }
        return false;
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d() {
        Animator.AnimatorListener animatorListener = this.f38511f;
        if (animatorListener != null) {
            this.f38507b.f38518c.removeListener(animatorListener);
            this.f38511f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f38507b.f38517b.draw(canvas);
        if (this.f38507b.f38518c.isStarted()) {
            invalidateSelf();
        }
    }

    public final void e(String str, Animator animator) {
        animator.setTarget(this.f38507b.f38517b.c(str));
        C0503c c0503c = this.f38507b;
        if (c0503c.f38519d == null) {
            c0503c.f38519d = new ArrayList<>();
            this.f38507b.f38520e = new androidx.collection.a<>();
        }
        this.f38507b.f38519d.add(animator);
        this.f38507b.f38520e.put(animator, str);
    }

    public boolean f(q1.b bVar) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            g((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList<q1.b> arrayList = this.f38512g;
        if (arrayList == null || bVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(bVar);
        if (this.f38512g.size() == 0) {
            d();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f38522a;
        return drawable != null ? C5566a.d(drawable) : this.f38507b.f38517b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f38507b.f38516a | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f38522a;
        return drawable != null ? C5566a.e(drawable) : this.f38507b.f38517b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f38522a != null) {
            return new d(this.f38522a.getConstantState());
        }
        return null;
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f38507b.f38517b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f38507b.f38517b.getIntrinsicWidth();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.getOpacity() : this.f38507b.f38517b.getOpacity();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayQ = k.q(resources, theme, attributeSet, C5143a.f38497e);
                    int resourceId = typedArrayQ.getResourceId(0, 0);
                    if (resourceId != 0) {
                        f fVarB = f.b(resources, resourceId, theme);
                        fVarB.g(false);
                        fVarB.setCallback(this.f38513h);
                        f fVar = this.f38507b.f38517b;
                        if (fVar != null) {
                            fVar.setCallback(null);
                        }
                        this.f38507b.f38517b = fVarB;
                    }
                    typedArrayQ.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, C5143a.f38498f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f38508c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        e(string, q1.d.a(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f38507b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f38522a;
        return drawable != null ? C5566a.h(drawable) : this.f38507b.f38517b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f38522a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f38507b.f38518c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.isStateful() : this.f38507b.f38517b.isStateful();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f38507b.f38517b.setBounds(rect);
        }
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.setLevel(i10) : this.f38507b.f38517b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.setState(iArr) : this.f38507b.f38517b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f38507b.f38517b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.j(drawable, z10);
        } else {
            this.f38507b.f38517b.setAutoMirrored(z10);
        }
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.n(drawable, i10);
        } else {
            this.f38507b.f38517b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.o(drawable, colorStateList);
        } else {
            this.f38507b.f38517b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.p(drawable, mode);
        } else {
            this.f38507b.f38517b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f38507b.f38517b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f38507b.f38518c.isStarted()) {
                return;
            }
            this.f38507b.f38518c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f38507b.f38518c.end();
        }
    }

    public c(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f38507b.f38517b.setColorFilter(colorFilter);
        }
    }

    public static class d extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f38521a;

        public d(Drawable.ConstantState constantState) {
            this.f38521a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f38521a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f38521a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f38521a.newDrawable();
            cVar.f38522a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f38513h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f38521a.newDrawable(resources);
            cVar.f38522a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f38513h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f38521a.newDrawable(resources, theme);
            cVar.f38522a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f38513h);
            return cVar;
        }
    }

    public c(Context context, C0503c c0503c, Resources resources) {
        this.f38509d = null;
        this.f38511f = null;
        this.f38512g = null;
        a aVar = new a();
        this.f38513h = aVar;
        this.f38508c = context;
        if (c0503c != null) {
            this.f38507b = c0503c;
        } else {
            this.f38507b = new C0503c(context, c0503c, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
