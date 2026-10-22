package androidx.appcompat.graphics.drawable;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawable implements TintAwareDrawable {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = null;
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AnimatableTransition extends Transition {
        private final Animatable mA;

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mA.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mA.stop();
        }

        public AnimatableTransition(Animatable r100) {
            super(null);
            this.mA = r100;
        }
    }

    public static class AnimatedStateListState extends StateListDrawable.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        SparseArrayCompat<Integer> mStateIds;
        LongSparseArray<Long> mTransitions;

        private static long generateTransitionKey(int r100, int r101) {
            long r102 = ((long) r100) << 32;
            return ((long) r101) | r102;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public int getKeyframeIdAt(int r100) {
            if (r100 >= 0) goto L6;
            return 0;
        L6:
            return this.mStateIds.get(r100, 0).intValue();
        }

        public int indexOfKeyframe(int[] r100) {
            int r101 = super.indexOfStateSet(r100);
            if (r101 < 0) goto L6;
            return r101;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawable.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            return new AnimatedStateListDrawableCompat(this, r100);
        }

        public int indexOfTransition(int r100, int r101) {
            long r102 = generateTransitionKey(r100, r101);
            return (int) this.mTransitions.get(r102, -1L).longValue();
        }

        public boolean isTransitionReversed(int r100, int r101) {
            long r102 = generateTransitionKey(r100, r101);
            if ((this.mTransitions.get(r102, -1L).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean transitionHasReversibleFlag(int r100, int r101) {
            long r102 = generateTransitionKey(r100, r101);
            if ((this.mTransitions.get(r102, -1L).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public AnimatedStateListState(AnimatedStateListState r100, AnimatedStateListDrawableCompat r101, Resources r102) {
            super(r100, r101, r102);
            if (r100 == null) goto L5;
            this.mTransitions = r100.mTransitions;
            this.mStateIds = r100.mStateIds;
            return;
        L5:
            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }

        public int addStateSet(int[] r100, Drawable r101, int r102) {
            int r103 = super.addStateSet(r100, r101);
            this.mStateIds.put(r103, Integer.valueOf(r102));
            return r103;
        }

        public int addTransition(int r110, int r111, Drawable r112, boolean r113) {
            int r114 = super.addChild(r112);
            long r100 = generateTransitionKey(r110, r111);
            if (r113 == false) goto L5;
            long r101 = REVERSIBLE_FLAG_BIT;
        L6:
            long r102 = r114;
            this.mTransitions.append(r100, Long.valueOf(r102 | r101));
            if (r113 == false) goto L9;
            this.mTransitions.append(generateTransitionKey(r111, r110), Long.valueOf((REVERSED_BIT | r102) | r101));
        L9:
            return r114;
        L5:
            r101 = 0;
            goto L6
        }
    }

    public static class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAvd.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAvd.stop();
        }

        public AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat r100) {
            super(null);
            this.mAvd = r100;
        }
    }

    public static class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void reverse() {
            this.mAnim.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void start() {
            this.mAnim.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public void stop() {
            this.mAnim.cancel();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.Transition
        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public AnimationDrawableTransition(AnimationDrawable r100, boolean r101, boolean r102) {
            super(null);
            int r103 = r100.getNumberOfFrames();
            if (r101 == false) goto L5;
            int r104 = r103 - 1;
        L7:
            if (r101 == false) goto L9;
            int r105 = 0;
        L10:
            FrameInterpolator r106 = new FrameInterpolator(r100, r101);
            ObjectAnimator r107 = ObjectAnimator.ofInt(r100, "currentIndex", new int[]{r104, r105});
            r107.setAutoCancel(true);
            r107.setDuration(r106.getTotalDuration());
            r107.setInterpolator(r106);
            this.mHasReversibleFlag = r102;
            this.mAnim = r107;
            return;
        L9:
            r105 = r103 - 1;
            goto L10
        L5:
            r104 = 0;
            goto L7
        }
    }

    public static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        public int getTotalDuration() {
            return this.mTotalDuration;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r100) {
            int r101 = (int) ((r100 * this.mTotalDuration) + 0.5f);
            int r102 = this.mFrames;
            int[] r103 = this.mFrameTimes;
            int r104 = 0;
        L3:
            if (r104 >= r102) goto L7;
            int r105 = r103[r104];
            if (r101 < r105) goto L7;
            r101 = r101 - r105;
            r104 = r104 + 1;
        L7:
            if (r104 >= r102) goto L9;
            float r106 = r101 / this.mTotalDuration;
        L11:
            return (r104 / r102) + r106;
        L9:
            r106 = 0.0f;
            goto L11
        }

        public FrameInterpolator(AnimationDrawable r100, boolean r101) {
            updateFrames(r100, r101);
        }

        public int updateFrames(AnimationDrawable r100, boolean r101) {
            int r102 = r100.getNumberOfFrames();
            this.mFrames = r102;
            int[] r103 = this.mFrameTimes;
            if (r103 != null) goto L5;
        L6:
            this.mFrameTimes = new int[r102];
        L7:
            int[] r104 = this.mFrameTimes;
            int r105 = 0;
            int r106 = 0;
        L8:
            if (r105 >= r102) goto L13;
            if (r101 == false) goto L11;
            int r107 = (r102 - r105) - 1;
        L12:
            int r108 = r100.getDuration(r107);
            r104[r105] = r108;
            r106 = r106 + r108;
            r105 = r105 + 1;
            goto L8
        L11:
            r107 = r105;
            goto L12
        L13:
            this.mTotalDuration = r106;
            return r106;
        L5:
            if (r103.length >= r102) goto L7;
            goto L6
        }
    }

    public static abstract class Transition {
        private Transition() {
        }

        public boolean canReverse() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        public /* synthetic */ Transition(AnonymousClass1 r100) {
            this();
        }
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    static {
        LOGTAG = "AnimatedStateListDrawableCompat";
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mState.mutate();
        this.mMutated = true;
        goto L7
    }

    private void init() {
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition r100 = this.mTransition;
        if (r100 == null) goto L6;
        r100.stop();
        this.mTransition = null;
        selectDrawable(this.mTransitionToIndex);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ DrawableContainer.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ StateListDrawable.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    private boolean selectTransition(int r110) {
        Transition r100 = this.mTransition;
        if (r100 != null) goto L5;
        int r101 = getCurrentIndex();
    L15:
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState r102 = this.mState;
        int r103 = r102.getKeyframeIdAt(r101);
        int r104 = r102.getKeyframeIdAt(r110);
        if (r104 == 0) goto L33;
        if (r103 == 0) goto L33;
        int r105 = r102.indexOfTransition(r103, r104);
        if (r105 >= 0) goto L22;
        return false;
    L22:
        boolean r106 = r102.transitionHasReversibleFlag(r103, r104);
        selectDrawable(r105);
        Object r107 = getCurrent();
        if ((r107 instanceof AnimationDrawable) == false) goto L26;
        AnimationDrawable r108 = (AnimationDrawable) r107;
        Transition r109 = new AnimationDrawableTransition(r108, r102.isTransitionReversed(r103, r104), r106);
    L31:
        r109.start();
        this.mTransition = r109;
        this.mTransitionFromIndex = r101;
        this.mTransitionToIndex = r110;
        return true;
    L26:
        if ((r107 instanceof AnimatedVectorDrawableCompat) == false) goto L29;
        r109 = new AnimatedVectorDrawableTransition((AnimatedVectorDrawableCompat) r107);
        goto L31
    L29:
        if ((r107 instanceof Animatable) == false) goto L33;
        r109 = new AnimatableTransition((Animatable) r107);
    L33:
        return false;
    L5:
        if (r110 != this.mTransitionToIndex) goto L8;
        return true;
    L8:
        if (r110 == this.mTransitionFromIndex) goto L10;
    L13:
        r101 = this.mTransitionToIndex;
        r100.stop();
        goto L15
    L10:
        if (r100.canReverse() == false) goto L13;
        r100.reverse();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = r110;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray r100) {
        AnimatedStateListState r101 = this.mState;
        r101.mChangingConfigurations |= r100.getChangingConfigurations();
        r101.setVariablePadding(r100.getBoolean(2, r101.mVariablePadding));
        r101.setConstantSize(r100.getBoolean(3, r101.mConstantSize));
        r101.setEnterFadeDuration(r100.getInt(4, r101.mEnterFadeDuration));
        r101.setExitFadeDuration(r100.getInt(5, r101.mExitFadeDuration));
        setDither(r100.getBoolean(0, r101.mDither));
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme r100) {
        super.applyTheme(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas r100) {
        super.draw(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect r100) {
        super.getHotspotBounds(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline r100) {
        super.getOutline(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect r100) {
        return super.getPadding(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable r100) {
        super.invalidateDrawable(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int r100) {
        return super.onLayoutDirectionChanged(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        int r101 = this.mState.indexOfKeyframe(r100);
        if (r101 != getCurrentIndex()) goto L5;
    L9:
        boolean r102 = false;
    L10:
        Drawable r103 = getCurrent();
        if (r103 != null) goto L13;
        return r102;
    L13:
        return r102 | r103.setState(r100);
    L5:
        if (selectTransition(r101) == false) goto L7;
    L8:
        r102 = true;
        goto L10
    L7:
        if (selectDrawable(r101) == false) goto L9;
        goto L8
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r100) {
        super.setAlpha(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean r100) {
        super.setAutoMirrored(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter r100) {
        super.setColorFilter(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable, androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(DrawableContainer.DrawableContainerState r100) {
        super.setConstantState(r100);
        if ((r100 instanceof AnimatedStateListState) == false) goto L6;
        this.mState = (AnimatedStateListState) r100;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean r100) {
        super.setDither(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setEnterFadeDuration(int r100) {
        super.setEnterFadeDuration(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ void setExitFadeDuration(int r100) {
        super.setExitFadeDuration(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList r100) {
        super.setTintList(r100);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode r100) {
        super.setTintMode(r100);
    }

    public AnimatedStateListDrawableCompat(AnimatedStateListState r100, Resources r101) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r100, this, r101));
        onStateChange(getState());
        jumpToCurrentState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public /* bridge */ /* synthetic */ void addState(int[] r100, Drawable r101) {
        super.addState(r100, r101);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float r100, float r101) {
        super.setHotspot(r100, r101);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        Transition r103 = this.mTransition;
        if (r103 == null) goto L9;
        if (r102 == true) goto L6;
        if (r101 == false) goto L9;
    L6:
        if (r100 == false) goto L8;
        r103.start();
        goto L9
    L8:
        jumpToCurrentState();
    L9:
        return r102;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable r100, Runnable r101) {
        super.unscheduleDrawable(r100, r101);
    }

    public static AnimatedStateListDrawableCompat create(Context r100, int r101, Resources.Theme r102) {
        Resources r103 = r100.getResources();     // Catch: Throwable -> L13
        XmlResourceParser r104 = r103.getXml(r101);     // Catch: Throwable -> L13
        AttributeSet r105 = Xml.asAttributeSet(r104);     // Catch: Throwable -> L13
    L3:
        int r106 = r104.next();     // Catch: Throwable -> L13
        if (r106 == 2) goto L8;
        if (r106 != 1) goto L3;
    L8:
        if (r106 != 2) goto L12;
        return createFromXmlInner(r100, r103, r104, r105, r102);
    L12:
        throw new XmlPullParserException("No start tag found");     // Catch: Throwable -> L13
    L13:
        return null;
    }

    public void addState(int[] r100, Drawable r101, int r102) {
        if (r101 == null) goto L6;
        this.mState.addStateSet(r100, r101, r102);
        onStateChange(getState());
        return;
    L6:
        throw new IllegalArgumentException("Drawable must not be null");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        super.scheduleDrawable(r100, r101, r102);
    }

    public <T extends Drawable & Animatable> void addTransition(int r100, int r101, T r102, boolean r103) {
        if (r102 == null) goto L6;
        this.mState.addTransition(r100, r101, r102, r103);
        return;
    L6:
        throw new IllegalArgumentException("Transition drawable must not be null");
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int r100, int r101, int r102, int r103) {
        super.setHotspotBounds(r100, r101, r102, r103);
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context r100, Resources r101, XmlPullParser r110, AttributeSet r111, Resources.Theme r112) throws IOException, XmlPullParserException {
        String r102 = r110.getName();
        if (r102.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r103 = new AnimatedStateListDrawableCompat();
        r103.inflate(r100, r101, r110, r111, r112);
        return r103;
    L7:
        throw new XmlPullParserException(r110.getPositionDescription() + ": invalid animated-selector tag " + r102);
    }

    private void inflateChildElements(Context r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r110) throws XmlPullParserException, IOException {
        int r104 = r102.getDepth() + 1;
    L3:
        int r105 = r102.next();
        if (r105 == 1) goto L20;
        int r106 = r102.getDepth();
        if (r106 >= r104) goto L10;
        if (r105 != 3) goto L10;
        return;
    L10:
        if (r105 != 2) goto L3;
        if (r106 > r104) goto L3;
        if (r102.getName().equals("item") == true) goto L16;
        if (r102.getName().equals("transition") == false) goto L3;
        parseTransition(r100, r101, r102, r103, r110);
        goto L3
    L16:
        parseItem(r100, r101, r102, r103, r110);
        goto L3
    }

    private int parseItem(Context r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r110) throws XmlPullParserException, IOException {
        TypedArray r104 = TypedArrayUtils.obtainAttributes(r101, r110, r103, new int[]{R.attr.id, R.attr.drawable});
        int r105 = r104.getResourceId(0, 0);
        int r106 = r104.getResourceId(1, -1);
        if (r106 <= 0) goto L5;
        Drawable r107 = ResourceManagerInternal.get().getDrawable(r100, r106);
    L6:
        r104.recycle();
        int[] r108 = extractStateSet(r103);
        if (r107 != null) goto L18;
    L8:
        int r109 = r102.next();
        if (r109 == 4) goto L8;
        if (r109 != 2) goto L17;
        if (r102.getName().equals("vector") == false) goto L15;
        r107 = VectorDrawableCompat.createFromXmlInner(r101, r102, r103, r110);
        goto L18
    L15:
        r107 = Drawable.createFromXmlInner(r101, r102, r103, r110);
        goto L18
    L17:
        throw new XmlPullParserException(r102.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L18:
        if (r107 == null) goto L22;
        return this.mState.addStateSet(r108, r107, r105);
    L22:
        throw new XmlPullParserException(r102.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L5:
        r107 = null;
        goto L6
    }

    private int parseTransition(Context r110, Resources r111, XmlPullParser r112, AttributeSet r113, Resources.Theme r114) throws XmlPullParserException, IOException {
        TypedArray r100 = TypedArrayUtils.obtainAttributes(r111, r114, r113, new int[]{R.attr.drawable, R.attr.toId, R.attr.fromId, R.attr.reversible});
        int r101 = r100.getResourceId(2, -1);
        int r102 = r100.getResourceId(1, -1);
        int r103 = r100.getResourceId(0, -1);
        if (r103 <= 0) goto L5;
        Drawable r104 = ResourceManagerInternal.get().getDrawable(r110, r103);
    L6:
        boolean r105 = r100.getBoolean(3, false);
        r100.recycle();
        if (r104 != null) goto L18;
    L8:
        int r106 = r112.next();
        if (r106 == 4) goto L8;
        if (r106 != 2) goto L17;
        if (r112.getName().equals("animated-vector") == false) goto L15;
        r104 = AnimatedVectorDrawableCompat.createFromXmlInner(r110, r111, r112, r113, r114);
        goto L18
    L15:
        r104 = Drawable.createFromXmlInner(r111, r112, r113, r114);
        goto L18
    L17:
        throw new XmlPullParserException(r112.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L18:
        if (r104 == null) goto L26;
        if (r101 == (-1)) goto L24;
        if (r102 == (-1)) goto L24;
        return this.mState.addTransition(r101, r102, r104, r105);
    L24:
        throw new XmlPullParserException(r112.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
    L26:
        throw new XmlPullParserException(r112.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawable
    public void inflate(Context r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r104) throws XmlPullParserException, IOException {
        TypedArray r105 = TypedArrayUtils.obtainAttributes(r101, r104, r103, new int[]{R.attr.dither, R.attr.visible, R.attr.variablePadding, R.attr.constantSize, R.attr.enterFadeDuration, R.attr.exitFadeDuration});
        setVisible(r105.getBoolean(1, true), true);
        updateStateFromTypedArray(r105);
        updateDensity(r101);
        r105.recycle();
        inflateChildElements(r100, r101, r102, r103, r104);
        init();
    }
}
