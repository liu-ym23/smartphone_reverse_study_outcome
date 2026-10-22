package androidx.appcompat.graphics.drawable;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.TypedArrayUtils;
import com.baidu.platform.comapi.map.MapController;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class StateListDrawable extends DrawableContainer {
    private static final boolean DEBUG = false;
    private static final String TAG = "StateListDrawable";
    private boolean mMutated;
    private StateListState mStateListState;

    public static class StateListState extends DrawableContainer.DrawableContainerState {
        int[][] mStateSets;

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void mutate() {
            int[][] r100 = this.mStateSets;
            int[][] r101 = new int[r100.length][];
            int r102 = r100.length - 1;
        L3:
            if (r102 < 0) goto L9;
            int[] r103 = this.mStateSets[r102];
            if (r103 == null) goto L7;
            int[] r104 = (int[]) r103.clone();
        L8:
            r101[r102] = r104;
            r102 = r102 - 1;
            goto L3
        L7:
            r104 = null;
            goto L8
        L9:
            this.mStateSets = r101;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new StateListDrawable(this, null);
        }

        public int indexOfStateSet(int[] r100) {
            int[][] r101 = this.mStateSets;
            int r102 = getChildCount();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            if (StateSet.stateSetMatches(r101[r103], r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return r103;
        L8:
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources r100) {
            return new StateListDrawable(this, r100);
        }

        public int addStateSet(int[] r100, Drawable r101) {
            int r102 = addChild(r101);
            this.mStateSets[r102] = r100;
            return r102;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableContainer.DrawableContainerState
        public void growArray(int r100, int r101) {
            super.growArray(r100, r101);
            int[][] r102 = new int[r101][];
            System.arraycopy(this.mStateSets, 0, r102, 0, r100);
            this.mStateSets = r102;
        }

        public StateListState(StateListState r100, StateListDrawable r101, Resources r102) {
            super(r100, r101, r102);
            if (r100 == null) goto L5;
            this.mStateSets = r100.mStateSets;
            return;
        L5:
            this.mStateSets = new int[getCapacity()][];
        }
    }

    public StateListDrawable() {
        this(null, null);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public StateListState cloneConstantState() {
        return new StateListState(this.mStateListState, this, null);
    }

    int getStateCount() {
        return this.mStateListState.getChildCount();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
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

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    public StateListState getStateListState() {
        return this.mStateListState;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public /* bridge */ /* synthetic */ DrawableContainer.DrawableContainerState cloneConstantState() {
        return cloneConstantState();
    }

    public StateListDrawable(StateListState r100) {
        if (r100 == null) goto L6;
        setConstantState(r100);
        return;
    }

    private void updateStateFromTypedArray(TypedArray r100) {
        StateListState r101 = this.mStateListState;
        r101.mChangingConfigurations |= r100.getChangingConfigurations();
        r101.mVariablePadding = r100.getBoolean(2, r101.mVariablePadding);
        r101.mConstantSize = r100.getBoolean(3, r101.mConstantSize);
        r101.mEnterFadeDuration = r100.getInt(4, r101.mEnterFadeDuration);
        r101.mExitFadeDuration = r100.getInt(5, r101.mExitFadeDuration);
        r101.mDither = r100.getBoolean(0, r101.mDither);
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r100) {
        super.applyTheme(r100);
        onStateChange(getState());
    }

    public int[] extractStateSet(AttributeSet r100) {
        int r101 = r100.getAttributeCount();
        int[] r102 = new int[r101];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r101) goto L17;
        int r105 = r100.getAttributeNameResource(r103);
        if (r105 == 0) goto L15;
        if (r105 == 16842960) goto L15;
        if (r105 == 16843161) goto L15;
        int r106 = r104 + 1;
        if (r100.getAttributeBooleanValue(r103, false) == true) goto L14;
        r105 = -r105;
    L14:
        r102[r104] = r105;
        r104 = r106;
    L15:
        r103 = r103 + 1;
        goto L3
    L17:
        return StateSet.trimStateSet(r102, r104);
    }

    Drawable getStateDrawable(int r100) {
        return this.mStateListState.getChild(r100);
    }

    public int getStateDrawableIndex(int[] r100) {
        return this.mStateListState.indexOfStateSet(r100);
    }

    int[] getStateSet(int r100) {
        return this.mStateListState.mStateSets[r100];
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        boolean r101 = super.onStateChange(r100);
        int r102 = this.mStateListState.indexOfStateSet(r100);
        if (r102 >= 0) goto L6;
        r102 = this.mStateListState.indexOfStateSet(StateSet.WILD_CARD);
    L6:
        if (selectDrawable(r102) == true) goto L10;
        if (r101 == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableContainer
    public void setConstantState(DrawableContainer.DrawableContainerState r100) {
        super.setConstantState(r100);
        if ((r100 instanceof StateListState) == false) goto L6;
        this.mStateListState = (StateListState) r100;
        return;
    }

    public StateListDrawable(StateListState r100, Resources r101) {
        setConstantState(new StateListState(r100, this, r101));
        onStateChange(getState());
    }

    public void addState(int[] r100, Drawable r101) {
        if (r101 == null) goto L5;
        this.mStateListState.addStateSet(r100, r101);
        onStateChange(getState());
        return;
    }

    private void inflateChildElements(Context r100, Resources r101, XmlPullParser r110, AttributeSet r111, Resources.Theme r112) throws XmlPullParserException, IOException {
        StateListState r102 = this.mStateListState;
        int r103 = r110.getDepth() + 1;
    L3:
        int r104 = r110.next();
        if (r104 == 1) goto L30;
        int r105 = r110.getDepth();
        if (r105 >= r103) goto L10;
        if (r104 != 3) goto L10;
        return;
    L10:
        if (r104 != 2) goto L3;
        if (r105 > r103) goto L3;
        if (r110.getName().equals(MapController.ITEM_LAYER_TAG) == false) goto L3;
        TypedArray r106 = TypedArrayUtils.obtainAttributes(r101, r112, r111, new int[]{R.attr.drawable});
        int r107 = r106.getResourceId(0, -1);
        if (r107 <= 0) goto L19;
        Drawable r108 = ResourceManagerInternal.get().getDrawable(r100, r107);
    L20:
        r106.recycle();
        int[] r109 = extractStateSet(r111);
        if (r108 != null) goto L29;
    L22:
        int r113 = r110.next();
        if (r113 == 4) goto L22;
        if (r113 != 2) goto L28;
        r108 = Drawable.createFromXmlInner(r101, r110, r111, r112);
        goto L29
    L28:
        throw new XmlPullParserException(r110.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    L29:
        r102.addStateSet(r109, r108);
        goto L3
    L19:
        r108 = null;
        goto L20
    }

    public void inflate(Context r100, Resources r101, XmlPullParser r102, AttributeSet r103, Resources.Theme r104) throws XmlPullParserException, IOException {
        TypedArray r105 = TypedArrayUtils.obtainAttributes(r101, r104, r103, new int[]{R.attr.dither, R.attr.visible, R.attr.variablePadding, R.attr.constantSize, R.attr.enterFadeDuration, R.attr.exitFadeDuration});
        setVisible(r105.getBoolean(1, true), true);
        updateStateFromTypedArray(r105);
        updateDensity(r101);
        r105.recycle();
        inflateChildElements(r100, r101, r102, r103, r104);
        onStateChange(getState());
    }
}
