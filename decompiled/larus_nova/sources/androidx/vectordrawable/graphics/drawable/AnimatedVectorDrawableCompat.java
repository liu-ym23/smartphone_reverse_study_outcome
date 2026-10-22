package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes17.dex */
public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private final AnimatedVectorDrawableCompatState mAnimatedVectorState;
    ArrayList<Animatable2Compat.AnimationCallback> mAnimationCallbacks;
    private Animator.AnimatorListener mAnimatorListener;
    private android.animation.ArgbEvaluator mArgbEvaluator;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable.Callback mCallback;
    private final Context mContext;

    public static class AnimatedVectorDrawableCompatState extends Drawable.ConstantState {
        AnimatorSet mAnimatorSet;
        ArrayList<Animator> mAnimators;
        int mChangingConfigurations;
        ArrayMap<Animator, String> mTargetNameMap;
        VectorDrawableCompat mVectorDrawable;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            if (this.mAnimatorSet != null) goto L5;
            this.mAnimatorSet = new AnimatorSet();
        L5:
            this.mAnimatorSet.playTogether(this.mAnimators);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public AnimatedVectorDrawableCompatState(Context r100, AnimatedVectorDrawableCompatState r101, Drawable.Callback r102, Resources r103) {
            if (r101 == null) goto L19;
            this.mChangingConfigurations = r101.mChangingConfigurations;
            VectorDrawableCompat r104 = r101.mVectorDrawable;
            int r105 = 0;
            if (r104 == null) goto L11;
            Drawable.ConstantState r106 = r104.getConstantState();
            if (r103 == null) goto L9;
            this.mVectorDrawable = (VectorDrawableCompat) r106.newDrawable(r103);
        L10:
            VectorDrawableCompat r107 = (VectorDrawableCompat) this.mVectorDrawable.mutate();
            this.mVectorDrawable = r107;
            r107.setCallback(r102);
            this.mVectorDrawable.setBounds(r101.mVectorDrawable.getBounds());
            this.mVectorDrawable.setAllowCaching(false);
            goto L11
        L9:
            this.mVectorDrawable = (VectorDrawableCompat) r106.newDrawable();
        L11:
            ArrayList<Animator> r108 = r101.mAnimators;
            if (r108 == null) goto L20;
            int r109 = r108.size();
            this.mAnimators = new ArrayList(r109);
            this.mTargetNameMap = new ArrayMap(r109);
        L14:
            if (r105 >= r109) goto L16;
            Animator r110 = (Animator) ListProtector.get(r101.mAnimators, r105);
            Animator r111 = r110.clone();
            String r112 = r101.mTargetNameMap.get(r110);
            r111.setTarget(this.mVectorDrawable.getTargetByName(r112));
            this.mAnimators.add(r111);
            this.mTargetNameMap.put(r111, r112);
            r105 = r105 + 1;
            goto L14
        L16:
            setupAnimatorSet();
            return;
        L20:
            return;
        }
    }

    public static class AnimatedVectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat r100 = new AnimatedVectorDrawableCompat();
            Drawable r101 = this.mDelegateState.newDrawable();
            r100.mDelegateDrawable = r101;
            r101.setCallback(r100.mCallback);
            return r100;
        }

        public AnimatedVectorDrawableDelegateState(Drawable.ConstantState r100) {
            this.mDelegateState = r100;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            AnimatedVectorDrawableCompat r101 = new AnimatedVectorDrawableCompat();
            Drawable r102 = this.mDelegateState.newDrawable(r100);
            r101.mDelegateDrawable = r102;
            r102.setCallback(r101.mCallback);
            return r101;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100, Resources.Theme r101) {
            AnimatedVectorDrawableCompat r102 = new AnimatedVectorDrawableCompat();
            Drawable r103 = this.mDelegateState.newDrawable(r100, r101);
            r102.mDelegateDrawable = r103;
            r103.setCallback(r102.mCallback);
            return r102;
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static void clearAnimationCallbacks(Object r100) {
            ((AnimatedVectorDrawable) r100).clearAnimationCallbacks();
        }

        public static void registerAnimationCallback(Object r100, Object r101) {
            ((AnimatedVectorDrawable) r100).registerAnimationCallback((Animatable2.AnimationCallback) r101);
        }

        public static boolean unregisterAnimationCallback(Object r100, Object r101) {
            return ((AnimatedVectorDrawable) r100).unregisterAnimationCallback((Animatable2.AnimationCallback) r101);
        }
    }

    public AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private void removeAnimatorSetListener() {
        Animator.AnimatorListener r100 = this.mAnimatorListener;
        if (r100 == null) goto L6;
        this.mAnimatedVectorState.mAnimatorSet.removeListener(r100);
        this.mAnimatorListener = null;
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 != null) goto L5;
        return false;
    L5:
        return DrawableCompat.canApplyTheme(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L6;
        Api23Impl.clearAnimationCallbacks(r100);
        return;
    L6:
        removeAnimatorSetListener();
        ArrayList<Animatable2Compat.AnimationCallback> r101 = this.mAnimationCallbacks;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.clear();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return DrawableCompat.getAlpha(r100);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getChangingConfigurations();
    L7:
        return super.getChangingConfigurations() | this.mAnimatedVectorState.mChangingConfigurations;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return DrawableCompat.getColorFilter(r100);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mDelegateDrawable != null) goto L5;
        return null;
    L5:
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return null;
    L7:
        return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getIntrinsicHeight();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getIntrinsicWidth();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.getOpacity();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return DrawableCompat.isAutoMirrored(r100);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return ((AnimatedVectorDrawable) r100).isRunning();
    L7:
        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        return r100.isStateful();
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L5;
        r100.mutate();
    L5:
        return this;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L7;
        ((AnimatedVectorDrawable) r100).start();
        return;
    L7:
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L9;
        return;
    L9:
        this.mAnimatedVectorState.mAnimatorSet.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable r100 = this.mDelegateDrawable;
        if (r100 == null) goto L6;
        ((AnimatedVectorDrawable) r100).stop();
        return;
    L6:
        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    private AnimatedVectorDrawableCompat(Context r100) {
        this(r100, null, null);
    }

    public static void clearAnimationCallbacks(Drawable r100) {
        if ((r100 instanceof Animatable) == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 24) goto L8;
        Api23Impl.clearAnimationCallbacks(r100);
        return;
    L8:
        ((AnimatedVectorDrawableCompat) r100).clearAnimationCallbacks();
    }

    private void setupColorAnimator(Animator r100) {
        if ((r100 instanceof AnimatorSet) == false) goto L11;
        ArrayList<Animator> r101 = ((AnimatorSet) r100).getChildAnimations();
        if (r101 == null) goto L11;
        int r102 = 0;
    L8:
        if (r102 >= r101.size()) goto L11;
        setupColorAnimator((Animator) ListProtector.get(r101, r102));
        r102 = r102 + 1;
    L11:
        if ((r100 instanceof ObjectAnimator) == false) goto L22;
        ObjectAnimator r103 = (ObjectAnimator) r100;
        String r104 = r103.getPropertyName();
        if ("fillColor".equals(r104) == true) goto L17;
        if ("strokeColor".equals(r104) == true) goto L17;
        return;
    L17:
        if (this.mArgbEvaluator != null) goto L19;
        this.mArgbEvaluator = new android.animation.ArgbEvaluator();
    L19:
        r103.setEvaluator(this.mArgbEvaluator);
        return;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.applyTheme(r101, r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.draw(r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.draw(r100);
        if (this.mAnimatedVectorState.mAnimatorSet.isStarted() == false) goto L10;
        invalidateSelf();
        return;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r100) {
        return super.getPadding(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setBounds(r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setBounds(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L7;
        return r101.setLevel(r100);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setLevel(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L7;
        return r101.setState(r100);
    L7:
        return this.mAnimatedVectorState.mVectorDrawable.setState(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L9;
        registerPlatformCallback((AnimatedVectorDrawable) r101, r100);
        return;
    L9:
        if (this.mAnimationCallbacks != null) goto L12;
        this.mAnimationCallbacks = new ArrayList();
    L12:
        if (this.mAnimationCallbacks.contains(r100) == false) goto L14;
        return;
    L14:
        this.mAnimationCallbacks.add(r100);
        if (this.mAnimatorListener != null) goto L17;
        this.mAnimatorListener = new AnonymousClass2(this);
    L17:
        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setAlpha(r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setAutoMirrored(r101, r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int r100) {
        super.setChangingConfigurations(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        r101.setColorFilter(r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean r100) {
        super.setFilterBitmap(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] r100) {
        return super.setState(r100);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTint(r101, r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTint(r100);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTintList(r101, r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintList(r100);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L6;
        DrawableCompat.setTintMode(r101, r100);
        return;
    L6:
        this.mAnimatedVectorState.mVectorDrawable.setTintMode(r100);
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Drawable r101 = this.mDelegateDrawable;
        if (r101 == null) goto L8;
        unregisterPlatformCallback((AnimatedVectorDrawable) r101, r100);
    L8:
        ArrayList<Animatable2Compat.AnimationCallback> r102 = this.mAnimationCallbacks;
        if (r102 != null) goto L11;
        return false;
    L11:
        boolean r103 = r102.remove(r100);
        if (this.mAnimationCallbacks.size() != 0) goto L14;
        removeAnimatorSetListener();
    L14:
        return r103;
    }

    public static AnimatedVectorDrawableCompat create(Context r100, int r101) {
        if (Build.VERSION.SDK_INT < 24) goto L20;
        AnimatedVectorDrawableCompat r102 = new AnimatedVectorDrawableCompat(r100);
        Drawable r103 = ResourcesCompat.getDrawable(r100.getResources(), r101, r100.getTheme());
        ObjectsCompat.requireNonNull(r102, "Failed to load drawable");
        r103.setCallback(r102.mCallback);
        r102.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(r103.getConstantState());
        r102.mDelegateDrawable = r103;
        return r102;
    L20:
        XmlResourceParser r104 = r100.getResources().getXml(r101);     // Catch: Throwable -> L18
        AttributeSet r105 = Xml.asAttributeSet(r104);     // Catch: Throwable -> L18
    L8:
        int r106 = r104.next();     // Catch: Throwable -> L18
        if (r106 == 2) goto L13;
        if (r106 != 1) goto L8;
    L13:
        if (r106 != 2) goto L17;
        return createFromXmlInner(r100, r100.getResources(), r104, r105, r100.getTheme());
    L17:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L18
    L18:
        return null;
    }

    public static void registerAnimationCallback(Drawable r100, Animatable2Compat.AnimationCallback r101) {
        if (r100 == null) goto L13;
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r100 instanceof Animatable) == true) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 24) goto L11;
        registerPlatformCallback((AnimatedVectorDrawable) r100, r101);
        return;
    L11:
        ((AnimatedVectorDrawableCompat) r100).registerAnimationCallback(r101);
        return;
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable r100, Animatable2Compat.AnimationCallback r101) {
        Api23Impl.registerAnimationCallback(r100, r101.getPlatformCallback());
    }

    private void setupAnimatorsForTarget(String r100, Animator r101) {
        r101.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(r100));
        AnimatedVectorDrawableCompatState r102 = this.mAnimatedVectorState;
        if (r102.mAnimators != null) goto L5;
        r102.mAnimators = new ArrayList();
        AnimatedVectorDrawableCompatState r103 = this.mAnimatedVectorState;
        r103.mTargetNameMap = new ArrayMap();
    L5:
        this.mAnimatedVectorState.mAnimators.add(r101);
        this.mAnimatedVectorState.mTargetNameMap.put(r101, r100);
    }

    public static boolean unregisterAnimationCallback(Drawable r100, Animatable2Compat.AnimationCallback r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        if ((r100 instanceof Animatable) == true) goto L10;
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        return unregisterPlatformCallback((AnimatedVectorDrawable) r100, r101);
    L14:
        return ((AnimatedVectorDrawableCompat) r100).unregisterAnimationCallback(r101);
    L15:
        return false;
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable r100, Animatable2Compat.AnimationCallback r101) {
        return Api23Impl.unregisterAnimationCallback(r100, r101.getPlatformCallback());
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int r100, PorterDuff.Mode r101) {
        super.setColorFilter(r100, r101);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r100, float r101) {
        super.setHotspot(r100, r101);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        Drawable r102 = this.mDelegateDrawable;
        if (r102 != null) goto L5;
        this.mAnimatedVectorState.mVectorDrawable.setVisible(r100, r101);
        return super.setVisible(r100, r101);
    L5:
        return r102.setVisible(r100, r101);
    }

    private AnimatedVectorDrawableCompat(Context r100, AnimatedVectorDrawableCompatState r101, Resources r102) {
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        Drawable.Callback r103 = new AnonymousClass1(this);
        this.mCallback = r103;
        this.mContext = r100;
        if (r101 == null) goto L5;
        this.mAnimatedVectorState = r101;
        return;
    L5:
        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(r100, null, r103, r102);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r100, XmlPullParser r101, AttributeSet r102) throws XmlPullParserException, IOException {
        inflate(r100, r101, r102, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources r100, XmlPullParser r101, AttributeSet r102, Resources.Theme r110) throws XmlPullParserException, IOException {
        Drawable r103 = this.mDelegateDrawable;
        if (r103 == null) goto L6;
        DrawableCompat.inflate(r103, r100, r101, r102, r110);
        return;
    L6:
        int r104 = r101.getEventType();
        int r105 = r101.getDepth() + 1;
    L7:
        if (r104 == 1) goto L34;
        if (r101.getDepth() >= r105) goto L13;
        if (r104 == 3) goto L34;
    L13:
        if (r104 != 2) goto L33;
        String r106 = r101.getName();
        if (ANIMATED_VECTOR.equals(r106) == false) goto L24;
        TypedArray r107 = TypedArrayUtils.obtainAttributes(r100, r110, r102, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
        int r108 = r107.getResourceId(0, 0);
        if (r108 == 0) goto L22;
        VectorDrawableCompat r109 = VectorDrawableCompat.create(r100, r108, r110);
        ObjectsCompat.requireNonNull(r109, "Failed to load drawable");
        r109.setAllowCaching(false);
        r109.setCallback(this.mCallback);
        VectorDrawableCompat r111 = this.mAnimatedVectorState.mVectorDrawable;
        if (r111 == null) goto L21;
        r111.setCallback(null);
    L21:
        this.mAnimatedVectorState.mVectorDrawable = r109;
    L22:
        r107.recycle();
        goto L33
    L24:
        if ("target".equals(r106) == false) goto L33;
        TypedArray r112 = r100.obtainAttributes(r102, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
        String r113 = r112.getString(0);
        int r114 = r112.getResourceId(1, 0);
        if (r114 == 0) goto L32;
        Context r115 = this.mContext;
        if (r115 == null) goto L30;
        setupAnimatorsForTarget(r113, AnimatorInflaterCompat.loadAnimator(r115, r114));
        goto L32
    L30:
        r112.recycle();
        throw new IllegalStateException("Context can't be null when inflating animators");
    L32:
        r112.recycle();
    L33:
        r104 = r101.next();
    L34:
        this.mAnimatedVectorState.setupAnimatorSet();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r100, int r101, int r102, int r103) {
        super.setHotspotBounds(r100, r101, r102, r103);
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r104) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat r105 = new AnimatedVectorDrawableCompat(r100);
        r105.inflate(r101, r102, r103, r104);
        return r105;
    }
}
