package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.b.a;
import androidx.appcompat.widget.u;
import androidx.core.content.b.i;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateListDrawableCompat extends DrawableContainerCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawableCompat";
    private boolean mMutated;
    private StateListState mStateListState;

    static class StateListState extends DrawableContainerCompat.DrawableContainerState {
        int[][] mStateSets;

        StateListState(StateListState r1, StateListDrawableCompat r2, Resources r3) {
            super(r1, r2, r3);
            if (r1 == null) goto L5;
            this.mStateSets = r1.mStateSets;
            return;
        L5:
            this.mStateSets = new int[getCapacity()][];
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        void mutate() {
            int[][] r0 = this.mStateSets;
            int[][] r1 = new int[r0.length][];
            int r2 = r0.length - 1;
        L3:
            if (r2 < 0) goto L9;
            int[][] r3 = this.mStateSets;
            if (r3[r2] == null) goto L7;
            int[] r4 = (int[]) ZeusTransformUtils.preCheckCast(r3[r2].clone(), int[].class, "com.obric.aiagent.plugin");
        L8:
            r1[r2] = r4;
            r2 = r2 - 1;
            goto L3
        L7:
            r4 = null;
            goto L8
        L9:
            this.mStateSets = r1;
        }

        int addStateSet(int[] r1, Drawable r2) {
            int r3 = addChild(r2);
            this.mStateSets[r3] = r1;
            return r3;
        }

        int indexOfStateSet(int[] r4) {
            int[][] r0 = this.mStateSets;
            int r3 = getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r3) goto L8;
            if (StateSet.stateSetMatches(r0[r1], r4) == true) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            return r1;
        L8:
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawableCompat(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r2) {
            return new StateListDrawableCompat(this, r2);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat.DrawableContainerState
        public void growArray(int r3, int r4) {
            super.growArray(r3, r4);
            int[][] r5 = new int[r4][];
            System.arraycopy(this.mStateSets, 0, r5, 0, r3);
            this.mStateSets = r5;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    /* bridge */ /* synthetic */ DrawableContainerCompat.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    public StateListDrawableCompat() {
        this(null, null);
    }

    public void addState(int[] r2, Drawable r3) {
        if (r3 == null) goto L5;
        this.mStateListState.addStateSet(r2, r3);
        onStateChange(getState());
        return;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r3) {
        boolean r0 = super.onStateChange(r3);
        int r4 = this.mStateListState.indexOfStateSet(r3);
        if (r4 >= 0) goto L6;
        r4 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    L6:
        if (selectDrawable(r4) == true) goto L10;
        if (r0 == true) goto L10;
        return false;
    L10:
        return true;
    }

    public void inflate(Context r9, Resources r10, XmlPullParser r11, AttributeSet r12, Resources.Theme r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r5 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r11, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        TypedArray r14 = i.a(r10, r13, r6, R.styleable.StateListDrawable);
        setVisible(r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.StateListDrawable_android_visible, "styleable", "StateListDrawable_android_visible"), true), true);
        updateStateFromTypedArray(r14);
        updateDensity(r10);
        r14.recycle();
        inflateChildElements(r3, r10, r5, r6, r13);
        onStateChange(getState());
    }

    private void updateStateFromTypedArray(TypedArray r4) {
        StateListState r3 = this.mStateListState;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r3.mChangingConfigurations |= a.c.a(r4);
    L5:
        r3.mVariablePadding = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.StateListDrawable_android_variablePadding, "styleable", "StateListDrawable_android_variablePadding"), r3.mVariablePadding);
        r3.mConstantSize = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.StateListDrawable_android_constantSize, "styleable", "StateListDrawable_android_constantSize"), r3.mConstantSize);
        r3.mEnterFadeDuration = r4.getInt(ZeusTransformUtils.mapRes(R.styleable.StateListDrawable_android_enterFadeDuration, "styleable", "StateListDrawable_android_enterFadeDuration"), r3.mEnterFadeDuration);
        r3.mExitFadeDuration = r4.getInt(ZeusTransformUtils.mapRes(R.styleable.StateListDrawable_android_exitFadeDuration, "styleable", "StateListDrawable_android_exitFadeDuration"), r3.mExitFadeDuration);
        r3.mDither = r4.getBoolean(ZeusTransformUtils.mapRes(R.styleable.StateListDrawable_android_dither, "styleable", "StateListDrawable_android_dither"), r3.mDither);
    }

    private void inflateChildElements(Context r10, Resources r11, XmlPullParser r12, AttributeSet r13, Resources.Theme r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        XmlPullParser r16 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r12, XmlPullParser.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r13, AttributeSet.class, "com.obric.aiagent.plugin");
        StateListState r0 = this.mStateListState;
        int r1 = r16.getDepth() + 1;
    L3:
        int r3 = r16.next();
        if (r3 == 1) goto L32;
        int r4 = r16.getDepth();
        if (r4 >= r1) goto L10;
        if (r3 != 3) goto L10;
        return;
    L10:
        if (r3 != 2) goto L3;
        if (r4 > r1) goto L3;
        if (r16.getName().equals("item") == false) goto L3;
        TypedArray r5 = i.a(r11, r14, r17, R.styleable.StateListDrawableItem);
        Drawable r6 = null;
        int r7 = r5.getResourceId(ZeusTransformUtils.mapRes(R.styleable.StateListDrawableItem_android_drawable, "styleable", "StateListDrawableItem_android_drawable"), -1);
        if (r7 <= 0) goto L19;
        r6 = u.a().a(r15, r7);
    L19:
        r5.recycle();
        int[] r8 = extractStateSet(r17);
        if (r6 != null) goto L31;
    L21:
        int r9 = r16.next();
        if (r9 == 4) goto L21;
        if (r9 != 2) goto L30;
        if (Build.VERSION.SDK_INT < 21) goto L28;
        r6 = a.c.a(r11, r16, r17, r14);
        goto L31
    L28:
        r6 = Drawable.createFromXmlInner(r11, r16, r17);
        goto L31
    L30:
        throw new XmlPullParserException(r16.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    L31:
        r0.addStateSet(r8, r6);
        goto L3
    }

    int[] extractStateSet(AttributeSet r8) {
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        int r9 = r7.getAttributeCount();
        int[] r0 = new int[r9];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r9) goto L17;
        int r4 = r7.getAttributeNameResource(r2);
        if (r4 == 0) goto L15;
        if (r4 == 16842960) goto L15;
        if (r4 == 16843161) goto L15;
        int r5 = r3 + 1;
        if (r7.getAttributeBooleanValue(r2, false) == true) goto L14;
        r4 = -r4;
    L14:
        r0[r3] = r4;
        r3 = r5;
    L15:
        r2 = r2 + 1;
        goto L3
    L17:
        return StateSet.trimStateSet(r0, r3);
    }

    StateListState getStateListState() {
        return this.mStateListState;
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    int[] getStateSet(int r1) {
        return this.mStateListState.mStateSets[r1];
    }

    Drawable getStateDrawable(int r1) {
        return this.mStateListState.getChild(r1);
    }

    int getStateDrawableIndex(int[] r1) {
        return this.mStateListState.indexOfStateSet(r1);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        this.mStateListState.mutate();
        this.mMutated = true;
        goto L7
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r1) {
        super.applyTheme(r1);
        onStateChange(getState());
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainerCompat
    void setConstantState(DrawableContainerCompat.DrawableContainerState r3) {
        super.setConstantState(r3);
        if (ZeusTransformUtils.instanceOf(r3, StateListState.class) == false) goto L6;
        this.mStateListState = (StateListState) ZeusTransformUtils.preCheckCast(r3, StateListState.class, "com.obric.aiagent.plugin");
        return;
    }

    StateListDrawableCompat(StateListState r2, Resources r3) {
        setConstantState(new StateListState(r2, this, r3));
        onStateChange(getState());
    }

    StateListDrawableCompat(StateListState r1) {
        if (r1 == null) goto L6;
        setConstantState(r1);
        return;
    }
}
