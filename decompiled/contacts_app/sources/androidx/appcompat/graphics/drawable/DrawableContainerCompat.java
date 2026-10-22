package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;

/* JADX INFO: loaded from: classes.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainerCompat";
    private int mAlpha;
    private Runnable mAnimationRunnable;
    private BlockInvalidateCallback mBlockInvalidateCallback;
    private int mCurIndex;
    private Drawable mCurrDrawable;
    private DrawableContainerState mDrawableContainerState;
    private long mEnterAnimationEnd;
    private long mExitAnimationEnd;
    private boolean mHasAlpha;
    private Rect mHotspotBounds;
    private Drawable mLastDrawable;
    private boolean mMutated;

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState r0) {
            return r0.canApplyTheme();
        }

        public static Resources getResources(Resources.Theme r0) {
            return r0.getResources();
        }

        public static void getOutline(Drawable r0, Outline r1) {
            r0.getOutline(r1);
        }
    }

    static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r1) {
        }

        BlockInvalidateCallback() {
        }

        public BlockInvalidateCallback wrap(Drawable.Callback r1) {
            this.mCallback = r1;
            return this;
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback r0 = this.mCallback;
            this.mCallback = null;
            return r0;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
            Drawable.Callback r0 = this.mCallback;
            if (r0 == null) goto L6;
            r0.scheduleDrawable(r1, r2, r3);
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable r1, Runnable r2) {
            Drawable.Callback r0 = this.mCallback;
            if (r0 == null) goto L6;
            r0.unscheduleDrawable(r1, r2);
            return;
        }
    }

    static abstract class DrawableContainerState extends Drawable.ConstantState {
        boolean mAutoMirrored;
        boolean mCanConstantState;
        int mChangingConfigurations;
        boolean mCheckedConstantSize;
        boolean mCheckedConstantState;
        boolean mCheckedOpacity;
        boolean mCheckedPadding;
        boolean mCheckedStateful;
        int mChildrenChangingConfigurations;
        ColorFilter mColorFilter;
        int mConstantHeight;
        int mConstantMinimumHeight;
        int mConstantMinimumWidth;
        Rect mConstantPadding;
        boolean mConstantSize;
        int mConstantWidth;
        int mDensity;
        boolean mDither;
        SparseArray<Drawable.ConstantState> mDrawableFutures;
        Drawable[] mDrawables;
        int mEnterFadeDuration;
        int mExitFadeDuration;
        boolean mHasColorFilter;
        boolean mHasTintList;
        boolean mHasTintMode;
        int mLayoutDirection;
        boolean mMutated;
        int mNumChildren;
        int mOpacity;
        final DrawableContainerCompat mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        DrawableContainerState(DrawableContainerState r4, DrawableContainerCompat r5, Resources r6) {
            int r0 = 0;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = r5;
            Rect r7 = null;
            if (r6 == null) goto L5;
            Resources r2 = r6;
        L8:
            this.mSourceRes = r2;
            if (r4 == null) goto L11;
            int r3 = r4.mDensity;
        L12:
            int r8 = DrawableContainerCompat.resolveDensity(r6, r3);
            this.mDensity = r8;
            if (r4 == null) goto L44;
            this.mChangingConfigurations = r4.mChangingConfigurations;
            this.mChildrenChangingConfigurations = r4.mChildrenChangingConfigurations;
            this.mCheckedConstantState = true;
            this.mCanConstantState = true;
            this.mVariablePadding = r4.mVariablePadding;
            this.mConstantSize = r4.mConstantSize;
            this.mDither = r4.mDither;
            this.mMutated = r4.mMutated;
            this.mLayoutDirection = r4.mLayoutDirection;
            this.mEnterFadeDuration = r4.mEnterFadeDuration;
            this.mExitFadeDuration = r4.mExitFadeDuration;
            this.mAutoMirrored = r4.mAutoMirrored;
            this.mColorFilter = r4.mColorFilter;
            this.mHasColorFilter = r4.mHasColorFilter;
            this.mTintList = r4.mTintList;
            this.mTintMode = r4.mTintMode;
            this.mHasTintList = r4.mHasTintList;
            this.mHasTintMode = r4.mHasTintMode;
            if (r4.mDensity != r8) goto L26;
            if (r4.mCheckedPadding == false) goto L23;
            if (r4.mConstantPadding == null) goto L21;
            r7 = new Rect(r4.mConstantPadding);
        L21:
            this.mConstantPadding = r7;
            this.mCheckedPadding = true;
        L23:
            if (r4.mCheckedConstantSize == false) goto L26;
            this.mConstantWidth = r4.mConstantWidth;
            this.mConstantHeight = r4.mConstantHeight;
            this.mConstantMinimumWidth = r4.mConstantMinimumWidth;
            this.mConstantMinimumHeight = r4.mConstantMinimumHeight;
            this.mCheckedConstantSize = true;
        L26:
            if (r4.mCheckedOpacity == false) goto L29;
            this.mOpacity = r4.mOpacity;
            this.mCheckedOpacity = true;
        L29:
            if (r4.mCheckedStateful == false) goto L31;
            this.mStateful = r4.mStateful;
            this.mCheckedStateful = true;
        L31:
            Drawable[] r9 = r4.mDrawables;
            this.mDrawables = new Drawable[r9.length];
            this.mNumChildren = r4.mNumChildren;
            SparseArray<Drawable.ConstantState> r10 = r4.mDrawableFutures;
            if (r10 == null) goto L34;
            this.mDrawableFutures = r10.clone();
        L35:
            int r11 = this.mNumChildren;
        L36:
            if (r0 >= r11) goto L50;
            Drawable r12 = r9[r0];
            if (r12 == null) goto L43;
            Drawable.ConstantState r13 = r12.getConstantState();
            if (r13 == null) goto L42;
            this.mDrawableFutures.put(r0, r13);
            goto L43
        L42:
            this.mDrawables[r0] = r9[r0];
        L43:
            r0 = r0 + 1;
            goto L36
        L50:
            return;
        L34:
            this.mDrawableFutures = new SparseArray(this.mNumChildren);
            goto L35
        L44:
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
            return;
        L11:
            r3 = 0;
            goto L12
        L5:
            if (r4 == null) goto L7;
            r2 = r4.mSourceRes;
            goto L8
        L7:
            r2 = null;
            goto L8
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            int r0 = this.mChangingConfigurations;
            return this.mChildrenChangingConfigurations | r0;
        }

        public final int addChild(Drawable r5) {
            int r0 = this.mNumChildren;
            if (r0 < this.mDrawables.length) goto L5;
            growArray(r0, r0 + 10);
        L5:
            r5.mutate();
            r5.setVisible(false, true);
            r5.setCallback(this.mOwner);
            this.mDrawables[r0] = r5;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = r5.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return r0;
        }

        void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        final int getCapacity() {
            return this.mDrawables.length;
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> r0 = this.mDrawableFutures;
            if (r0 == null) goto L10;
            int r1 = r0.size();
            int r2 = 0;
        L5:
            if (r2 >= r1) goto L7;
            int r3 = this.mDrawableFutures.keyAt(r2);
            Drawable.ConstantState r4 = this.mDrawableFutures.valueAt(r2);
            this.mDrawables[r3] = prepareDrawable(r4.newDrawable(this.mSourceRes));
            r2 = r2 + 1;
            goto L5
        L7:
            this.mDrawableFutures = null;
            return;
        }

        private Drawable prepareDrawable(Drawable r2) {
            DrawableCompat.setLayoutDirection(r2, this.mLayoutDirection);
            Drawable r3 = r2.mutate();
            r3.setCallback(this.mOwner);
            return r3;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final Drawable getChild(int r5) {
            Drawable r0 = this.mDrawables[r5];
            if (r0 == null) goto L5;
            return r0;
        L5:
            SparseArray<Drawable.ConstantState> r1 = this.mDrawableFutures;
            if (r1 == null) goto L13;
            int r2 = r1.indexOfKey(r5);
            if (r2 < 0) goto L13;
            Drawable r3 = prepareDrawable(this.mDrawableFutures.valueAt(r2).newDrawable(this.mSourceRes));
            this.mDrawables[r5] = r3;
            this.mDrawableFutures.removeAt(r2);
            if (this.mDrawableFutures.size() != 0) goto L12;
            this.mDrawableFutures = null;
        L12:
            return r3;
        L13:
            return null;
        }

        final boolean setLayoutDirection(int r6, int r7) {
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            int r2 = 0;
            boolean r3 = false;
        L3:
            if (r2 >= r0) goto L10;
            if (r1[r2] == null) goto L9;
            boolean r4 = DrawableCompat.setLayoutDirection(r1[r2], r6);
            if (r2 != r7) goto L9;
            r3 = r4;
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            this.mLayoutDirection = r6;
            return r3;
        }

        final void updateDensity(Resources r2) {
            if (r2 == null) goto L7;
            this.mSourceRes = r2;
            int r3 = DrawableContainerCompat.resolveDensity(r2, this.mDensity);
            int r0 = this.mDensity;
            this.mDensity = r3;
            if (r0 == r3) goto L8;
            this.mCheckedConstantSize = false;
            this.mCheckedPadding = false;
            return;
        L8:
            return;
        }

        final void applyTheme(Resources.Theme r6) {
            if (r6 == null) goto L17;
            createAllFutures();
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L11;
            Drawable r3 = r1[r2];
            if (r3 == null) goto L10;
            if (DrawableCompat.canApplyTheme(r3) == false) goto L10;
            DrawableCompat.applyTheme(r1[r2], r6);
            this.mChildrenChangingConfigurations |= r1[r2].getChangingConfigurations();
        L10:
            r2 = r2 + 1;
            goto L4
        L11:
            updateDensity(Api21Impl.getResources(r6));
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L15;
            Drawable r4 = r1[r3];
            if (r4 != null) goto L7;
            Drawable.ConstantState r5 = this.mDrawableFutures.get(r3);
            if (r5 == null) goto L14;
            if (Api21Impl.canApplyTheme(r5) == false) goto L14;
            return true;
        L14:
            r3 = r3 + 1;
            goto L3
        L7:
            if (DrawableCompat.canApplyTheme(r4) == false) goto L14;
            return true;
        L15:
            return false;
        }

        void mutate() {
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L8;
            Drawable r3 = r1[r2];
            if (r3 == null) goto L7;
            r3.mutate();
        L7:
            r2 = r2 + 1;
            goto L3
        L8:
            this.mMutated = true;
        }

        final void clearMutated() {
            this.mMutated = false;
        }

        public final void setVariablePadding(boolean r1) {
            this.mVariablePadding = r1;
        }

        public final Rect getConstantPadding() {
            Rect r1 = null;
            if (this.mVariablePadding == false) goto L5;
            return null;
        L5:
            Rect r0 = this.mConstantPadding;
            if (r0 == null) goto L8;
        L31:
            return r0;
        L8:
            if (this.mCheckedPadding == true) goto L31;
            createAllFutures();
            Rect r2 = new Rect();
            int r3 = this.mNumChildren;
            Drawable[] r4 = this.mDrawables;
            int r5 = 0;
        L11:
            if (r5 >= r3) goto L29;
            if (r4[r5].getPadding(r2) == false) goto L28;
            if (r1 != null) goto L17;
            r1 = new Rect(0, 0, 0, 0);
        L17:
            if (r2.left <= r1.left) goto L20;
            r1.left = r2.left;
        L20:
            if (r2.top <= r1.top) goto L23;
            r1.top = r2.top;
        L23:
            if (r2.right <= r1.right) goto L26;
            r1.right = r2.right;
        L26:
            if (r2.bottom <= r1.bottom) goto L28;
            r1.bottom = r2.bottom;
        L28:
            r5 = r5 + 1;
            goto L11
        L29:
            this.mCheckedPadding = true;
            this.mConstantPadding = r1;
            return r1;
        }

        public final void setConstantSize(boolean r1) {
            this.mConstantSize = r1;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        public final int getConstantWidth() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantWidth;
        }

        public final int getConstantHeight() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantHeight;
        }

        public final int getConstantMinimumWidth() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantMinimumWidth;
        }

        public final int getConstantMinimumHeight() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantMinimumHeight;
        }

        protected void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            int r2 = 0;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
        L3:
            if (r2 >= r0) goto L17;
            Drawable r3 = r1[r2];
            int r4 = r3.getIntrinsicWidth();
            if (r4 <= this.mConstantWidth) goto L7;
            this.mConstantWidth = r4;
        L7:
            int r5 = r3.getIntrinsicHeight();
            if (r5 <= this.mConstantHeight) goto L10;
            this.mConstantHeight = r5;
        L10:
            int r6 = r3.getMinimumWidth();
            if (r6 <= this.mConstantMinimumWidth) goto L13;
            this.mConstantMinimumWidth = r6;
        L13:
            int r7 = r3.getMinimumHeight();
            if (r7 <= this.mConstantMinimumHeight) goto L16;
            this.mConstantMinimumHeight = r7;
        L16:
            r2 = r2 + 1;
            goto L3
        }

        public final void setEnterFadeDuration(int r1) {
            this.mEnterFadeDuration = r1;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final void setExitFadeDuration(int r1) {
            this.mExitFadeDuration = r1;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity == true) goto L5;
            createAllFutures();
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            if (r0 <= 0) goto L9;
            int r2 = r1[0].getOpacity();
        L10:
            int r4 = 1;
        L11:
            if (r4 >= r0) goto L13;
            r2 = Drawable.resolveOpacity(r2, r1[r4].getOpacity());
            r4 = r4 + 1;
            goto L11
        L13:
            this.mOpacity = r2;
            this.mCheckedOpacity = true;
            return r2;
        L9:
            r2 = -2;
            goto L10
        L5:
            return this.mOpacity;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful == true) goto L5;
            createAllFutures();
            int r0 = this.mNumChildren;
            Drawable[] r1 = this.mDrawables;
            boolean r2 = false;
            int r3 = 0;
        L8:
            if (r3 >= r0) goto L13;
            if (r1[r3].isStateful() == true) goto L11;
            r3 = r3 + 1;
            goto L8
        L11:
            r2 = true;
        L13:
            this.mStateful = r2;
            this.mCheckedStateful = true;
            return r2;
        L5:
            return this.mStateful;
        }

        public void growArray(int r3, int r4) {
            Drawable[] r5 = new Drawable[r4];
            Drawable[] r0 = this.mDrawables;
            if (r0 == null) goto L5;
            System.arraycopy(r0, 0, r5, 0, r3);
        L5:
            this.mDrawables = r5;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState == true) goto L5;
            createAllFutures();
            this.mCheckedConstantState = true;
            int r1 = this.mNumChildren;
            Drawable[] r2 = this.mDrawables;
            int r4 = 0;
        L7:
            if (r4 >= r1) goto L13;
            if (r2[r4].getConstantState() == null) goto L10;
            r4 = r4 + 1;
            goto L7
        L10:
            this.mCanConstantState = false;
            return false;
        L13:
            this.mCanConstantState = true;
            return true;
        L5:
            return this.mCanConstantState;
        }
    }

    public DrawableContainerCompat() {
        this.mAlpha = 255;
        this.mCurIndex = -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r2) {
        Drawable r0 = this.mCurrDrawable;
        if (r0 == null) goto L5;
        r0.draw(r2);
    L5:
        Drawable r1 = this.mLastDrawable;
        if (r1 == null) goto L9;
        r1.draw(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int r0 = super.getChangingConfigurations();
        return this.mDrawableContainerState.getChangingConfigurations() | r0;
    }

    private boolean needsMirroring() {
        if (isAutoMirrored() == true) goto L5;
    L7:
        return false;
    L5:
        if (DrawableCompat.getLayoutDirection(this) != 1) goto L7;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r4) {
        Rect r0 = this.mDrawableContainerState.getConstantPadding();
        if (r0 == null) goto L8;
        r4.set(r0);
        int r1 = (r0.left | r0.top) | r0.bottom;
        if ((r0.right | r1) == 0) goto L7;
        boolean r2 = true;
    L13:
        if (needsMirroring() == false) goto L15;
        int r3 = r4.left;
        r4.left = r4.right;
        r4.right = r3;
    L15:
        return r2;
    L7:
        r2 = false;
        goto L13
    L8:
        Drawable r5 = this.mCurrDrawable;
        if (r5 == null) goto L11;
        r2 = r5.getPadding(r4);
        goto L13
    L11:
        r2 = super.getPadding(r4);
        goto L13
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r1) {
        Drawable r0 = this.mCurrDrawable;
        if (r0 == null) goto L6;
        Api21Impl.getOutline(r0, r1);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r6) {
        if (this.mHasAlpha == true) goto L5;
    L6:
        this.mHasAlpha = true;
        this.mAlpha = r6;
        Drawable r0 = this.mCurrDrawable;
        if (r0 != null) goto L9;
        return;
    L9:
        if (this.mEnterAnimationEnd != 0) goto L11;
        r0.setAlpha(r6);
        return;
    L11:
        animate(false);
        return;
    L5:
        if (this.mAlpha != r6) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r2) {
        if (this.mDrawableContainerState.mDither == r2) goto L8;
        this.mDrawableContainerState.mDither = r2;
        Drawable r3 = this.mCurrDrawable;
        if (r3 == null) goto L9;
        r3.setDither(this.mDrawableContainerState.mDither);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r3) {
        this.mDrawableContainerState.mHasColorFilter = true;
        if (this.mDrawableContainerState.mColorFilter == r3) goto L8;
        this.mDrawableContainerState.mColorFilter = r3;
        Drawable r2 = this.mCurrDrawable;
        if (r2 == null) goto L9;
        r2.setColorFilter(r3);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int r1) {
        setTintList(ColorStateList.valueOf(r1));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList r3) {
        this.mDrawableContainerState.mHasTintList = true;
        if (this.mDrawableContainerState.mTintList == r3) goto L6;
        this.mDrawableContainerState.mTintList = r3;
        DrawableCompat.setTintList(this.mCurrDrawable, r3);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode r3) {
        this.mDrawableContainerState.mHasTintMode = true;
        if (this.mDrawableContainerState.mTintMode == r3) goto L6;
        this.mDrawableContainerState.mTintMode = r3;
        DrawableCompat.setTintMode(this.mCurrDrawable, r3);
        return;
    }

    public void setEnterFadeDuration(int r1) {
        this.mDrawableContainerState.mEnterFadeDuration = r1;
    }

    public void setExitFadeDuration(int r1) {
        this.mDrawableContainerState.mExitFadeDuration = r1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect r2) {
        Drawable r0 = this.mLastDrawable;
        if (r0 == null) goto L5;
        r0.setBounds(r2);
    L5:
        Drawable r1 = this.mCurrDrawable;
        if (r1 == null) goto L9;
        r1.setBounds(r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r2) {
        if (this.mDrawableContainerState.mAutoMirrored == r2) goto L8;
        this.mDrawableContainerState.mAutoMirrored = r2;
        Drawable r3 = this.mCurrDrawable;
        if (r3 == null) goto L9;
        DrawableCompat.setAutoMirrored(r3, this.mDrawableContainerState.mAutoMirrored);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable r0 = this.mLastDrawable;
        boolean r1 = true;
        if (r0 == null) goto L5;
        r0.jumpToCurrentState();
        this.mLastDrawable = null;
        boolean r2 = true;
    L6:
        Drawable r3 = this.mCurrDrawable;
        if (r3 == null) goto L12;
        r3.jumpToCurrentState();
        if (this.mHasAlpha == false) goto L12;
        this.mCurrDrawable.setAlpha(this.mAlpha);
    L12:
        if (this.mExitAnimationEnd == 0) goto L15;
        this.mExitAnimationEnd = 0;
        r2 = true;
    L15:
        if (this.mEnterAnimationEnd == 0) goto L17;
        this.mEnterAnimationEnd = 0;
    L18:
        if (r1 == false) goto L21;
        invalidateSelf();
        return;
    L21:
        return;
    L17:
        r1 = r2;
        goto L18
    L5:
        r2 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r1, float r2) {
        Drawable r0 = this.mCurrDrawable;
        if (r0 == null) goto L6;
        DrawableCompat.setHotspot(r0, r1, r2);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r2, int r3, int r4, int r5) {
        Rect r0 = this.mHotspotBounds;
        if (r0 != null) goto L5;
        this.mHotspotBounds = new Rect(r2, r3, r4, r5);
    L6:
        Drawable r1 = this.mCurrDrawable;
        if (r1 == null) goto L10;
        DrawableCompat.setHotspotBounds(r1, r2, r3, r4, r5);
        return;
    L10:
        return;
    L5:
        r0.set(r2, r3, r4, r5);
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect r2) {
        Rect r0 = this.mHotspotBounds;
        if (r0 == null) goto L5;
        r2.set(r0);
        return;
    L5:
        super.getHotspotBounds(r2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] r2) {
        Drawable r0 = this.mLastDrawable;
        if (r0 != null) goto L5;
        Drawable r1 = this.mCurrDrawable;
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.setState(r2);
    L5:
        return r0.setState(r2);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int r2) {
        Drawable r0 = this.mLastDrawable;
        if (r0 != null) goto L5;
        Drawable r1 = this.mCurrDrawable;
        if (r1 != null) goto L9;
        return false;
    L9:
        return r1.setLevel(r2);
    L5:
        return r0.setLevel(r2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r2) {
        return this.mDrawableContainerState.setLayoutDirection(r2, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r1 = this.mCurrDrawable;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.getIntrinsicWidth();
    L5:
        return this.mDrawableContainerState.getConstantWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r1 = this.mCurrDrawable;
        if (r1 != null) goto L11;
        return -1;
    L11:
        return r1.getIntrinsicHeight();
    L5:
        return this.mDrawableContainerState.getConstantHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r1 = this.mCurrDrawable;
        if (r1 != null) goto L11;
        return 0;
    L11:
        return r1.getMinimumWidth();
    L5:
        return this.mDrawableContainerState.getConstantMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r1 = this.mCurrDrawable;
        if (r1 != null) goto L11;
        return 0;
    L11:
        return r1.getMinimumHeight();
    L5:
        return this.mDrawableContainerState.getConstantMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r2) {
        DrawableContainerState r0 = this.mDrawableContainerState;
        if (r0 == null) goto L6;
        r0.invalidateCache();
    L6:
        if (r2 == this.mCurrDrawable) goto L8;
        return;
    L8:
        if (getCallback() == null) goto L12;
        getCallback().invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable r2, Runnable r3, long r4) {
        if (r2 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().scheduleDrawable(this, r3, r4);
        return;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable r2, Runnable r3) {
        if (r2 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().unscheduleDrawable(this, r3);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r3, boolean r4) {
        boolean r0 = super.setVisible(r3, r4);
        Drawable r1 = this.mLastDrawable;
        if (r1 == null) goto L5;
        r1.setVisible(r3, r4);
    L5:
        Drawable r2 = this.mCurrDrawable;
        if (r2 == null) goto L8;
        r2.setVisible(r3, r4);
    L8:
        return r0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r0 = this.mCurrDrawable;
        if (r0 != null) goto L5;
    L8:
        return -2;
    L5:
        if (r0.isVisible() == false) goto L8;
        return this.mDrawableContainerState.getOpacity();
    }

    void setCurrentIndex(int r1) {
        selectDrawable(r1);
    }

    int getCurrentIndex() {
        return this.mCurIndex;
    }

    boolean selectDrawable(int r10) {
        if (r10 != this.mCurIndex) goto L5;
        return false;
    L5:
        long r2 = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration <= 0) goto L14;
        Drawable r0 = this.mLastDrawable;
        if (r0 == null) goto L10;
        r0.setVisible(false, false);
    L10:
        Drawable r1 = this.mCurrDrawable;
        if (r1 == null) goto L13;
        this.mLastDrawable = r1;
        this.mExitAnimationEnd = ((long) this.mDrawableContainerState.mExitFadeDuration) + r2;
    L17:
        if (r10 >= 0) goto L19;
    L26:
        this.mCurrDrawable = null;
        this.mCurIndex = -1;
    L28:
        if (this.mEnterAnimationEnd == 0) goto L30;
    L31:
        Runnable r11 = this.mAnimationRunnable;
        if (r11 != null) goto L34;
        this.mAnimationRunnable = new AnonymousClass1(this);
    L35:
        animate(true);
    L36:
        invalidateSelf();
        return true;
    L34:
        unscheduleSelf(r11);
        goto L35
    L30:
        if (this.mExitAnimationEnd == 0) goto L36;
    L19:
        if (r10 >= this.mDrawableContainerState.mNumChildren) goto L26;
        Drawable r3 = this.mDrawableContainerState.getChild(r10);
        this.mCurrDrawable = r3;
        this.mCurIndex = r10;
        if (r3 == null) goto L28;
        if (this.mDrawableContainerState.mEnterFadeDuration <= 0) goto L25;
        this.mEnterAnimationEnd = r2 + ((long) this.mDrawableContainerState.mEnterFadeDuration);
    L25:
        initializeDrawableForDisplay(r3);
        goto L28
    L13:
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0;
        goto L17
    L14:
        Drawable r4 = this.mCurrDrawable;
        if (r4 == null) goto L17;
        r4.setVisible(false, false);
        goto L17
    }

    private void initializeDrawableForDisplay(Drawable r5) {
        if (this.mBlockInvalidateCallback != null) goto L5;
        this.mBlockInvalidateCallback = new BlockInvalidateCallback();
    L5:
        r5.setCallback(this.mBlockInvalidateCallback.wrap(r5.getCallback()));
    L25:
        th = move-exception;
        r5.setCallback(this.mBlockInvalidateCallback.unwrap());
        throw th;
    L7:
        if (this.mDrawableContainerState.mEnterFadeDuration > 0) goto L12;
        if (this.mHasAlpha == false) goto L12;
        r5.setAlpha(this.mAlpha);     // Catch: Throwable -> L25
    L12:
        if (this.mDrawableContainerState.mHasColorFilter == false) goto L15;
        r5.setColorFilter(this.mDrawableContainerState.mColorFilter);     // Catch: Throwable -> L25
    L20:
        r5.setVisible(isVisible(), true);     // Catch: Throwable -> L25
        r5.setDither(this.mDrawableContainerState.mDither);     // Catch: Throwable -> L25
        r5.setState(getState());     // Catch: Throwable -> L25
        r5.setLevel(getLevel());     // Catch: Throwable -> L25
        r5.setBounds(getBounds());     // Catch: Throwable -> L25
        DrawableCompat.setLayoutDirection(r5, DrawableCompat.getLayoutDirection(this));     // Catch: Throwable -> L25
        DrawableCompat.setAutoMirrored(r5, this.mDrawableContainerState.mAutoMirrored);     // Catch: Throwable -> L25
        Rect r0 = this.mHotspotBounds;     // Catch: Throwable -> L25
        if (r0 == null) goto L23;
        DrawableCompat.setHotspotBounds(r5, r0.left, r0.top, r0.right, r0.bottom);     // Catch: Throwable -> L25
    L23:
        r5.setCallback(this.mBlockInvalidateCallback.unwrap());
        return;
    L15:
        if (this.mDrawableContainerState.mHasTintList == false) goto L18;
        DrawableCompat.setTintList(r5, this.mDrawableContainerState.mTintList);     // Catch: Throwable -> L25
    L18:
        if (this.mDrawableContainerState.mHasTintMode == false) goto L20;
        DrawableCompat.setTintMode(r5, this.mDrawableContainerState.mTintMode);     // Catch: Throwable -> L25
        goto L20
    }

    void animate(boolean r14) {
        boolean r0 = true;
        this.mHasAlpha = true;
        long r1 = SystemClock.uptimeMillis();
        Drawable r3 = this.mCurrDrawable;
        if (r3 == null) goto L10;
        long r9 = this.mEnterAnimationEnd;
        if (r9 != 0) goto L7;
    L11:
        boolean r4 = false;
    L12:
        Drawable r10 = this.mLastDrawable;
        if (r10 == null) goto L20;
        long r11 = this.mExitAnimationEnd;
        if (r11 != 0) goto L17;
    L21:
        r0 = r4;
    L22:
        if (r14 == false) goto L26;
        if (r0 == false) goto L27;
        scheduleSelf(this.mAnimationRunnable, r1 + 16);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        if (r11 > r1) goto L19;
        r10.setVisible(false, false);
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0;
        goto L21
    L19:
        this.mLastDrawable.setAlpha(((((int) ((r11 - r1) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
        goto L22
    L20:
        this.mExitAnimationEnd = 0;
        goto L21
    L7:
        if (r9 > r1) goto L9;
        r3.setAlpha(this.mAlpha);
        this.mEnterAnimationEnd = 0;
        goto L11
    L9:
        this.mCurrDrawable.setAlpha(((255 - (((int) ((r9 - r1) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
        r4 = true;
        goto L12
    L10:
        this.mEnterAnimationEnd = 0;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    final void updateDensity(Resources r1) {
        this.mDrawableContainerState.updateDensity(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r1) {
        this.mDrawableContainerState.applyTheme(r1);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState() == false) goto L6;
        DrawableContainerState r0 = this.mDrawableContainerState;
        r0.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    L6:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        DrawableContainerState r0 = cloneConstantState();
        r0.mutate();
        setConstantState(r0);
        this.mMutated = true;
        goto L7
    }

    DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    void setConstantState(DrawableContainerState r2) {
        this.mDrawableContainerState = r2;
        int r0 = this.mCurIndex;
        if (r0 < 0) goto L7;
        Drawable r3 = r2.getChild(r0);
        this.mCurrDrawable = r3;
        if (r3 == null) goto L7;
        initializeDrawableForDisplay(r3);
    L7:
        this.mLastDrawable = null;
    }

    static int resolveDensity(Resources r0, int r1) {
        if (r0 == null) goto L5;
        r1 = r0.getDisplayMetrics().densityDpi;
    L5:
        if (r1 != 0) goto L8;
        return 160;
    L8:
        return r1;
    }
}
