package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.widget.u;
import androidx.b.h;
import androidx.core.content.b.i;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements androidx.core.graphics.drawable.c {
    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private d mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    /* JADX INFO: renamed from: androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class AnimatedStateListState extends StateListDrawableCompat.StateListState {
        private static final long REVERSED_BIT = 4294967296L;
        private static final long REVERSIBLE_FLAG_BIT = 8589934592L;
        h<Integer> mStateIds;
        androidx.b.d<Long> mTransitions;

        private static long generateTransitionKey(int r2, int r3) {
            long r0 = ((long) r2) << 32;
            return ((long) r3) | r0;
        }

        AnimatedStateListState(AnimatedStateListState r1, AnimatedStateListDrawableCompat r2, Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mTransitions = r1.mTransitions;
            this.mStateIds = r1.mStateIds;
            return;
        L5:
            this.mTransitions = new androidx.b.d();
            this.mStateIds = new h();
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            this.mTransitions = this.mTransitions.a();
            this.mStateIds = this.mStateIds.a();
        }

        int addTransition(int r10, int r11, Drawable r12, boolean r13) {
            int r14 = super.addChild(r12);
            long r0 = generateTransitionKey(r10, r11);
            if (r13 == false) goto L5;
            long r2 = REVERSIBLE_FLAG_BIT;
        L6:
            long r5 = r14;
            this.mTransitions.c(r0, Long.valueOf(r5 | r2));
            if (r13 == false) goto L9;
            this.mTransitions.c(generateTransitionKey(r11, r10), Long.valueOf((REVERSED_BIT | r5) | r2));
        L9:
            return r14;
        L5:
            r2 = 0;
            goto L6
        }

        int addStateSet(int[] r1, Drawable r2, int r3) {
            int r4 = super.addStateSet(r1, r2);
            this.mStateIds.b(r4, Integer.valueOf(r3));
            return r4;
        }

        int indexOfKeyframe(int[] r1) {
            int r2 = super.indexOfStateSet(r1);
            if (r2 < 0) goto L6;
            return r2;
        L6:
            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        int getKeyframeIdAt(int r2) {
            if (r2 >= 0) goto L6;
            return 0;
        L6:
            return ((Integer) ZeusTransformUtils.preCheckCast(this.mStateIds.a(r2, 0), Integer.class, "com.obric.aiagent.plugin")).intValue();
        }

        int indexOfTransition(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            return (int) ((Long) ZeusTransformUtils.preCheckCast(this.mTransitions.a(r5, -1L), Long.class, "com.obric.aiagent.plugin")).longValue();
        }

        boolean isTransitionReversed(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            if ((((Long) ZeusTransformUtils.preCheckCast(this.mTransitions.a(r5, -1L), Long.class, "com.obric.aiagent.plugin")).longValue() & REVERSED_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean transitionHasReversibleFlag(int r3, int r4) {
            long r5 = generateTransitionKey(r3, r4);
            if ((((Long) ZeusTransformUtils.preCheckCast(this.mTransitions.a(r5, -1L), Long.class, "com.obric.aiagent.plugin")).longValue() & REVERSIBLE_FLAG_BIT) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat.StateListState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return new AnimatedStateListDrawableCompat(this, r2);
        }
    }

    private static class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        FrameInterpolator(AnimationDrawable r1, boolean r2) {
            updateFrames(r1, r2);
        }

        int updateFrames(AnimationDrawable r6, boolean r7) {
            int r0 = r6.getNumberOfFrames();
            this.mFrames = r0;
            int[] r1 = this.mFrameTimes;
            if (r1 != null) goto L5;
        L6:
            this.mFrameTimes = new int[r0];
        L7:
            int[] r2 = this.mFrameTimes;
            int r3 = 0;
            int r4 = 0;
        L8:
            if (r3 >= r0) goto L13;
            if (r7 == false) goto L11;
            int r5 = (r0 - r3) - 1;
        L12:
            int r8 = r6.getDuration(r5);
            r2[r3] = r8;
            r4 = r4 + r8;
            r3 = r3 + 1;
            goto L8
        L11:
            r5 = r3;
            goto L12
        L13:
            this.mTotalDuration = r4;
            return r4;
        L5:
            if (r1.length >= r0) goto L7;
            goto L6
        }

        int getTotalDuration() {
            return this.mTotalDuration;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r5) {
            int r6 = (int) ((r5 * this.mTotalDuration) + 0.5f);
            int r0 = this.mFrames;
            int[] r1 = this.mFrameTimes;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L7;
            if (r6 < r1[r2]) goto L7;
            r6 = r6 - r1[r2];
            r2 = r2 + 1;
        L7:
            if (r2 >= r0) goto L9;
            float r7 = r6 / this.mTotalDuration;
        L11:
            return (r2 / r0) + r7;
        L9:
            r7 = 0.0f;
            goto L11
        }
    }

    private static class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f286a;

        a(Animatable r3) {
            Animatable r4 = (Animatable) ZeusTransformUtils.wrapperContextForParams(r3, Animatable.class, "com.obric.aiagent.plugin");
            super(null);
            this.f286a = r4;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void a() {
            this.f286a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void b() {
            this.f286a.stop();
        }
    }

    private static class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedVectorDrawableCompat f287a;

        b(AnimatedVectorDrawableCompat r2) {
            super(null);
            this.f287a = r2;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void a() {
            this.f287a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void b() {
            this.f287a.stop();
        }
    }

    private static class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f289b;

        c(AnimationDrawable r6, boolean r7, boolean r8) {
            super(null);
            int r0 = r6.getNumberOfFrames();
            if (r7 == false) goto L5;
            int r2 = r0 - 1;
        L7:
            if (r7 == false) goto L9;
            int r1 = 0;
        L10:
            FrameInterpolator r4 = new FrameInterpolator(r6, r7);
            ObjectAnimator r9 = ObjectAnimator.ofInt(r6, "currentIndex", new int[]{r2, r1});
            if (Build.VERSION.SDK_INT < 18) goto L13;
            androidx.appcompat.b.a.b.a(r9, true);
        L13:
            r9.setDuration(r4.getTotalDuration());
            r9.setInterpolator(r4);
            this.f289b = r8;
            this.f288a = r9;
            return;
        L9:
            r1 = r0 - 1;
            goto L10
        L5:
            r2 = 0;
            goto L7
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public boolean c() {
            return this.f289b;
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void a() {
            this.f288a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void d() {
            this.f288a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat.d
        public void b() {
            this.f288a.cancel();
        }
    }

    private static abstract class d {
        public abstract void a();

        public abstract void b();

        public boolean c() {
            return false;
        }

        public void d() {
        }

        private d() {
        }

        /* synthetic */ d(AnonymousClass1 r1) {
            this();
        }
    }

    static {
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ StateListDrawableCompat.StateListState cloneConstantState() {
        return cloneConstantState();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState r2, Resources r3) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        setConstantState(new AnimatedStateListState(r2, this, r3));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static AnimatedStateListDrawableCompat create(Context r6, int r7, Resources.Theme r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        Resources r1 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin");     // Catch: IOException -> L14 XmlPullParserException -> L16
        XmlResourceParser r10 = r1.getXml(r7);     // Catch: IOException -> L14 XmlPullParserException -> L16
        AttributeSet r2 = Xml.asAttributeSet(r10);     // Catch: IOException -> L14 XmlPullParserException -> L16
    L4:
        int r3 = r10.next();     // Catch: IOException -> L14 XmlPullParserException -> L16
        if (r3 == 2) goto L9;
        if (r3 != 1) goto L4;
    L9:
        if (r3 != 2) goto L13;
        return createFromXmlInner(r9, r1, r10, r2, r8);
    L13:
        throw new XmlPullParserException("No start tag found");     // Catch: IOException -> L14 XmlPullParserException -> L16
    L14:
        e = move-exception;
        INVOKESTATIC_androidx_appcompat_graphics_drawable_AnimatedStateListDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOGTAG, "parser error", e);
        return null;
    L16:
        e = move-exception;
        INVOKESTATIC_androidx_appcompat_graphics_drawable_AnimatedStateListDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(LOGTAG, "parser error", e);
        return null;
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context r8, Resources r9, XmlPullParser r10, AttributeSet r11, Resources.Theme r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r10, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        String r13 = r5.getName();
        if (r13.equals("animated-selector") == false) goto L7;
        AnimatedStateListDrawableCompat r14 = new AnimatedStateListDrawableCompat();
        r14.inflate(r3, r9, r5, r6, r12);
        return r14;
    L7:
        throw new XmlPullParserException(r5.getPositionDescription() + ": invalid animated-selector tag " + r13);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat
    public void inflate(Context r9, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r14 = i.a(r10, r13, r6, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableCompat_android_visible, "styleable", "AnimatedStateListDrawableCompat_android_visible"), true), true);
        updateStateFromTypedArray(r14);
        updateDensity(r10);
        r14.recycle();
        inflateChildElements(r3, r10, r5, r6, r13);
        init();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        boolean r0 = super.setVisible(r3, r4);
        d r1 = this.mTransition;
        if (r1 == null) goto L9;
        if (r0 == true) goto L6;
        if (r4 == false) goto L9;
    L6:
        if (r3 == false) goto L8;
        r1.a();
        goto L9
    L8:
        jumpToCurrentState();
    L9:
        return r0;
    }

    public void addState(int[] r2, Drawable r3, int r4) {
        androidx.core.util.d.a(r3);
        this.mState.addStateSet(r2, r3, r4);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void addTransition(int r1, int r2, T r3, boolean r4) {
        androidx.core.util.d.a(r3);
        this.mState.addTransition(r1, r2, r3, r4);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        d r0 = this.mTransition;
        if (r0 == null) goto L6;
        r0.b();
        this.mTransition = null;
        selectDrawable(this.mTransitionToIndex);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r3) {
        int r0 = this.mState.indexOfKeyframe(r3);
        if (r0 != getCurrentIndex()) goto L5;
    L9:
        boolean r1 = false;
    L10:
        Drawable r2 = getCurrent();
        if (r2 != null) goto L13;
        return r1;
    L13:
        return r1 | r2.setState(r3);
    L5:
        if (selectTransition(r0) == false) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (selectDrawable(r0) == false) goto L9;
        goto L8
    }

    private boolean selectTransition(int r11) {
        d r0 = this.mTransition;
        if (r0 != null) goto L5;
        int r2 = getCurrentIndex();
    L15:
        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState r1 = this.mState;
        int r3 = r1.getKeyframeIdAt(r2);
        int r4 = r1.getKeyframeIdAt(r11);
        if (r4 == 0) goto L33;
        if (r3 == 0) goto L33;
        int r6 = r1.indexOfTransition(r3, r4);
        if (r6 >= 0) goto L22;
        return false;
    L22:
        boolean r7 = r1.transitionHasReversibleFlag(r3, r4);
        selectDrawable(r6);
        Drawable r8 = getCurrent();
        if (ZeusTransformUtils.instanceOf(r8, AnimationDrawable.class) == false) goto L26;
        boolean r5 = r1.isTransitionReversed(r3, r4);
        d r9 = new c((AnimationDrawable) ZeusTransformUtils.preCheckCast(r8, AnimationDrawable.class, "com.obric.aiagent.plugin"), r5, r7);
    L31:
        r9.a();
        this.mTransition = r9;
        this.mTransitionFromIndex = r2;
        this.mTransitionToIndex = r11;
        return true;
    L26:
        if (ZeusTransformUtils.instanceOf(r8, AnimatedVectorDrawableCompat.class) == false) goto L29;
        r9 = new b((AnimatedVectorDrawableCompat) ZeusTransformUtils.preCheckCast(r8, AnimatedVectorDrawableCompat.class, "com.obric.aiagent.plugin"));
        goto L31
    L29:
        if (ZeusTransformUtils.instanceOf(r8, Animatable.class) == false) goto L33;
        r9 = new a((Animatable) ZeusTransformUtils.preCheckCast(r8, Animatable.class, "com.obric.aiagent.plugin"));
    L33:
        return false;
    L5:
        if (r11 != this.mTransitionToIndex) goto L8;
        return true;
    L8:
        if (r11 == this.mTransitionFromIndex) goto L10;
    L13:
        r2 = this.mTransitionToIndex;
        r0.b();
        goto L15
    L10:
        if (r0.c() == false) goto L13;
        r0.d();
        this.mTransitionToIndex = this.mTransitionFromIndex;
        this.mTransitionFromIndex = r11;
        return true;
    }

    private void updateStateFromTypedArray(TypedArray r5) {
        AnimatedStateListState r0 = this.mState;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r0.mChangingConfigurations |= androidx.appcompat.b.a.c.a(r5);
    L5:
        r0.setVariablePadding(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, "styleable", "AnimatedStateListDrawableCompat_android_variablePadding"), r0.mVariablePadding));
        r0.setConstantSize(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, "styleable", "AnimatedStateListDrawableCompat_android_constantSize"), r0.mConstantSize));
        r0.setEnterFadeDuration(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, "styleable", "AnimatedStateListDrawableCompat_android_enterFadeDuration"), r0.mEnterFadeDuration));
        r0.setExitFadeDuration(r5.getInt(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, "styleable", "AnimatedStateListDrawableCompat_android_exitFadeDuration"), r0.mExitFadeDuration));
        setDither(r5.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableCompat_android_dither, "styleable", "AnimatedStateListDrawableCompat_android_dither"), r0.mDither));
    }

    private void init() {
        onStateChange(getState());
    }

    private void inflateChildElements(Context r9, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        int r0 = r15.getDepth() + 1;
    L3:
        int r2 = r15.next();
        if (r2 == 1) goto L20;
        int r3 = r15.getDepth();
        if (r3 >= r0) goto L10;
        if (r2 != 3) goto L10;
        return;
    L10:
        if (r2 != 2) goto L3;
        if (r3 > r0) goto L3;
        if (r15.getName().equals(ELEMENT_ITEM) == true) goto L16;
        if (r15.getName().equals(ELEMENT_TRANSITION) == false) goto L3;
        parseTransition(r14, r10, r15, r16, r13);
        goto L3
    L16:
        parseItem(r14, r10, r15, r16, r13);
        goto L3
    }

    private int parseTransition(Context r9, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r15 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r16 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r0 = i.a(r10, r13, r16, R.styleable.AnimatedStateListDrawableTransition);
        int r1 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableTransition_android_fromId, "styleable", "AnimatedStateListDrawableTransition_android_fromId"), -1);
        int r4 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableTransition_android_toId, "styleable", "AnimatedStateListDrawableTransition_android_toId"), -1);
        int r5 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableTransition_android_drawable, "styleable", "AnimatedStateListDrawableTransition_android_drawable"), -1);
        if (r5 <= 0) goto L5;
        Drawable r6 = u.a().a(r14, r5);
    L6:
        boolean r2 = r0.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableTransition_android_reversible, "styleable", "AnimatedStateListDrawableTransition_android_reversible"), false);
        r0.recycle();
        if (r6 != null) goto L22;
    L8:
        int r7 = r15.next();
        if (r7 == 4) goto L8;
        if (r7 != 2) goto L21;
        if (r15.getName().equals("animated-vector") == false) goto L17;
        r6 = AnimatedVectorDrawableCompat.createFromXmlInner(r14, r10, r15, r16, r13);
        goto L22
    L17:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        r6 = androidx.appcompat.b.a.c.a(r10, r15, r16, r13);
        goto L22
    L19:
        r6 = Drawable.createFromXmlInner(r10, r15, r16);
        goto L22
    L21:
        throw new XmlPullParserException(r15.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L22:
        if (r6 == null) goto L30;
        if (r1 == (-1)) goto L28;
        if (r4 == (-1)) goto L28;
        return this.mState.addTransition(r1, r4, r6, r2);
    L28:
        throw new XmlPullParserException(r15.getPositionDescription() + TRANSITION_MISSING_FROM_TO_ID);
    L30:
        throw new XmlPullParserException(r15.getPositionDescription() + TRANSITION_MISSING_DRAWABLE_ERROR);
    L5:
        r6 = null;
        goto L6
    }

    private int parseItem(Context r6, Resources r7, XmlPullParser r8, AttributeSet r9, Resources.Theme r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r12 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r8, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r13 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r0 = i.a(r7, r10, r13, R.styleable.AnimatedStateListDrawableItem);
        int r1 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableItem_android_id, "styleable", "AnimatedStateListDrawableItem_android_id"), 0);
        int r2 = r0.getResourceId(ZeusTransformUtils.mapRes(R.styleable.AnimatedStateListDrawableItem_android_drawable, "styleable", "AnimatedStateListDrawableItem_android_drawable"), -1);
        if (r2 <= 0) goto L5;
        Drawable r14 = u.a().a(r11, r2);
    L6:
        r0.recycle();
        int[] r3 = extractStateSet(r13);
        if (r14 != null) goto L22;
    L8:
        int r15 = r12.next();
        if (r15 == 4) goto L8;
        if (r15 != 2) goto L21;
        if (r12.getName().equals("vector") == false) goto L17;
        r14 = VectorDrawableCompat.createFromXmlInner(r7, r12, r13, r10);
        goto L22
    L17:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        r14 = androidx.appcompat.b.a.c.a(r7, r12, r13, r10);
        goto L22
    L19:
        r14 = Drawable.createFromXmlInner(r7, r12, r13);
        goto L22
    L21:
        throw new XmlPullParserException(r12.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L22:
        if (r14 == null) goto L26;
        return this.mState.addStateSet(r3, r14, r1);
    L26:
        throw new XmlPullParserException(r12.getPositionDescription() + ITEM_MISSING_DRAWABLE_ERROR);
    L5:
        r14 = null;
        goto L6
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
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

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.StateListDrawableCompat, androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void setConstantState(DrawableContainerCompat.DrawableContainerState r3) {
        super.setConstantState(r3);
        if (ZeusTransformUtils.instanceOf(r3, AnimatedStateListState.class) == false) goto L6;
        this.mState = (AnimatedStateListState) ZeusTransformUtils.preCheckCast(r3, AnimatedStateListState.class, "com.obric.aiagent.plugin");
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_appcompat_graphics_drawable_AnimatedStateListDrawableCompat_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
