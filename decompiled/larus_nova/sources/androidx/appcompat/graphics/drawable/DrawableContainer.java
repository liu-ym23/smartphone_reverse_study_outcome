package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes2.dex */
class DrawableContainer extends Drawable implements Drawable.Callback {
    private static final boolean DEBUG = false;
    private static final boolean DEFAULT_DITHER = true;
    private static final String TAG = "DrawableContainer";
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

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean canApplyTheme(Drawable.ConstantState r100) {
            return r100.canApplyTheme();
        }

        public static Resources getResources(Resources.Theme r100) {
            return r100.getResources();
        }

        public static void getOutline(Drawable r100, Outline r101) {
            r100.getOutline(r101);
        }
    }

    public static class BlockInvalidateCallback implements Drawable.Callback {
        private Drawable.Callback mCallback;

        public BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable r100) {
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback r100 = this.mCallback;
            this.mCallback = null;
            return r100;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback r100) {
            this.mCallback = r100;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable r100, Runnable r101) {
            Drawable.Callback r102 = this.mCallback;
            if (r102 == null) goto L6;
            r102.unscheduleDrawable(r100, r101);
            return;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
            Drawable.Callback r103 = this.mCallback;
            if (r103 == null) goto L6;
            r103.scheduleDrawable(r100, r101, r102);
            return;
        }
    }

    public static abstract class DrawableContainerState extends Drawable.ConstantState {
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
        final DrawableContainer mOwner;
        Resources mSourceRes;
        boolean mStateful;
        ColorStateList mTintList;
        PorterDuff.Mode mTintMode;
        boolean mVariablePadding;

        public final void clearMutated() {
            this.mMutated = false;
        }

        public void computeConstantSize() {
            this.mCheckedConstantSize = true;
            createAllFutures();
            int r100 = this.mNumChildren;
            Drawable[] r101 = this.mDrawables;
            this.mConstantHeight = -1;
            this.mConstantWidth = -1;
            int r102 = 0;
            this.mConstantMinimumHeight = 0;
            this.mConstantMinimumWidth = 0;
        L3:
            if (r102 >= r100) goto L17;
            Drawable r103 = r101[r102];
            int r104 = r103.getIntrinsicWidth();
            if (r104 <= this.mConstantWidth) goto L7;
            this.mConstantWidth = r104;
        L7:
            int r105 = r103.getIntrinsicHeight();
            if (r105 <= this.mConstantHeight) goto L10;
            this.mConstantHeight = r105;
        L10:
            int r106 = r103.getMinimumWidth();
            if (r106 <= this.mConstantMinimumWidth) goto L13;
            this.mConstantMinimumWidth = r106;
        L13:
            int r107 = r103.getMinimumHeight();
            if (r107 <= this.mConstantMinimumHeight) goto L16;
            this.mConstantMinimumHeight = r107;
        L16:
            r102 = r102 + 1;
            goto L3
        }

        public void invalidateCache() {
            this.mCheckedOpacity = false;
            this.mCheckedStateful = false;
        }

        private void createAllFutures() {
            SparseArray<Drawable.ConstantState> r100 = this.mDrawableFutures;
            if (r100 == null) goto L10;
            int r101 = r100.size();
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L7;
            int r103 = this.mDrawableFutures.keyAt(r102);
            Drawable.ConstantState r104 = this.mDrawableFutures.valueAt(r102);
            this.mDrawables[r103] = prepareDrawable(r104.newDrawable(this.mSourceRes));
            r102 = r102 + 1;
            goto L5
        L7:
            this.mDrawableFutures = null;
            return;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int r100 = this.mNumChildren;
            Drawable[] r101 = this.mDrawables;
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L15;
            Drawable r103 = r101[r102];
            if (r103 != null) goto L7;
            Drawable.ConstantState r104 = this.mDrawableFutures.get(r102);
            if (r104 == null) goto L14;
            if (Api21Impl.canApplyTheme(r104) == false) goto L14;
            return true;
        L14:
            r102 = r102 + 1;
            goto L3
        L7:
            if (DrawableCompat.canApplyTheme(r103) == false) goto L14;
            return true;
        L15:
            return false;
        }

        public boolean canConstantState() {
            if (this.mCheckedConstantState == true) goto L5;
            createAllFutures();
            this.mCheckedConstantState = true;
            int r100 = this.mNumChildren;
            Drawable[] r101 = this.mDrawables;
            int r102 = 0;
        L7:
            if (r102 >= r100) goto L13;
            if (r101[r102].getConstantState() == null) goto L10;
            r102 = r102 + 1;
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

        public final int getCapacity() {
            return this.mDrawables.length;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
        }

        public final int getConstantHeight() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantHeight;
        }

        public final int getConstantMinimumHeight() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantMinimumHeight;
        }

        public final int getConstantMinimumWidth() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantMinimumWidth;
        }

        public final Rect getConstantPadding() {
            Rect r100 = null;
            if (this.mVariablePadding == false) goto L5;
            return null;
        L5:
            Rect r101 = this.mConstantPadding;
            if (r101 == null) goto L8;
        L31:
            return r101;
        L8:
            if (this.mCheckedPadding == true) goto L31;
            createAllFutures();
            Rect r102 = new Rect();
            int r103 = this.mNumChildren;
            Drawable[] r104 = this.mDrawables;
            int r105 = 0;
        L11:
            if (r105 >= r103) goto L29;
            if (r104[r105].getPadding(r102) == false) goto L28;
            if (r100 != null) goto L16;
            r100 = new Rect(0, 0, 0, 0);
        L16:
            int r106 = r102.left;
            if (r106 <= r100.left) goto L19;
            r100.left = r106;
        L19:
            int r107 = r102.top;
            if (r107 <= r100.top) goto L22;
            r100.top = r107;
        L22:
            int r108 = r102.right;
            if (r108 <= r100.right) goto L25;
            r100.right = r108;
        L25:
            int r109 = r102.bottom;
            if (r109 <= r100.bottom) goto L28;
            r100.bottom = r109;
        L28:
            r105 = r105 + 1;
            goto L11
        L29:
            this.mCheckedPadding = true;
            this.mConstantPadding = r100;
            return r100;
        }

        public final int getConstantWidth() {
            if (this.mCheckedConstantSize == true) goto L6;
            computeConstantSize();
        L6:
            return this.mConstantWidth;
        }

        public final int getOpacity() {
            if (this.mCheckedOpacity == true) goto L5;
            createAllFutures();
            int r100 = this.mNumChildren;
            Drawable[] r101 = this.mDrawables;
            if (r100 <= 0) goto L9;
            int r102 = r101[0].getOpacity();
        L10:
            int r103 = 1;
        L11:
            if (r103 >= r100) goto L13;
            r102 = Drawable.resolveOpacity(r102, r101[r103].getOpacity());
            r103 = r103 + 1;
            goto L11
        L13:
            this.mOpacity = r102;
            this.mCheckedOpacity = true;
            return r102;
        L9:
            r102 = -2;
            goto L10
        L5:
            return this.mOpacity;
        }

        public final boolean isStateful() {
            if (this.mCheckedStateful == true) goto L5;
            createAllFutures();
            int r100 = this.mNumChildren;
            Drawable[] r101 = this.mDrawables;
            boolean r102 = false;
            int r103 = 0;
        L8:
            if (r103 >= r100) goto L13;
            if (r101[r103].isStateful() == true) goto L11;
            r103 = r103 + 1;
            goto L8
        L11:
            r102 = true;
        L13:
            this.mStateful = r102;
            this.mCheckedStateful = true;
            return r102;
        L5:
            return this.mStateful;
        }

        public void mutate() {
            int r100 = this.mNumChildren;
            Drawable[] r101 = this.mDrawables;
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L8;
            Drawable r103 = r101[r102];
            if (r103 == null) goto L7;
            r103.mutate();
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            this.mMutated = true;
        }

        public final int getChildCount() {
            return this.mNumChildren;
        }

        public final int getEnterFadeDuration() {
            return this.mEnterFadeDuration;
        }

        public final int getExitFadeDuration() {
            return this.mExitFadeDuration;
        }

        public final boolean isConstantSize() {
            return this.mConstantSize;
        }

        private Drawable prepareDrawable(Drawable r100) {
            if (Build.VERSION.SDK_INT < 23) goto L5;
            DrawableCompat.setLayoutDirection(r100, this.mLayoutDirection);
        L5:
            Drawable r101 = r100.mutate();
            r101.setCallback(this.mOwner);
            return r101;
        }

        public final int addChild(Drawable r100) {
            int r101 = this.mNumChildren;
            if (r101 < this.mDrawables.length) goto L5;
            growArray(r101, r101 + 10);
        L5:
            r100.mutate();
            r100.setVisible(false, true);
            r100.setCallback(this.mOwner);
            this.mDrawables[r101] = r100;
            this.mNumChildren++;
            this.mChildrenChangingConfigurations = r100.getChangingConfigurations() | this.mChildrenChangingConfigurations;
            invalidateCache();
            this.mConstantPadding = null;
            this.mCheckedPadding = false;
            this.mCheckedConstantSize = false;
            this.mCheckedConstantState = false;
            return r101;
        }

        public final void applyTheme(Resources.Theme r100) {
            if (r100 == null) goto L17;
            createAllFutures();
            int r101 = this.mNumChildren;
            Drawable[] r102 = this.mDrawables;
            int r103 = 0;
        L4:
            if (r103 >= r101) goto L11;
            Drawable r104 = r102[r103];
            if (r104 == null) goto L10;
            if (DrawableCompat.canApplyTheme(r104) == false) goto L10;
            DrawableCompat.applyTheme(r102[r103], r100);
            this.mChildrenChangingConfigurations |= r102[r103].getChangingConfigurations();
        L10:
            r103 = r103 + 1;
            goto L4
        L11:
            updateDensity(Api21Impl.getResources(r100));
            return;
        }

        public final Drawable getChild(int r100) {
            Drawable r101 = this.mDrawables[r100];
            if (r101 == null) goto L5;
            return r101;
        L5:
            SparseArray<Drawable.ConstantState> r102 = this.mDrawableFutures;
            if (r102 == null) goto L13;
            int r103 = r102.indexOfKey(r100);
            if (r103 < 0) goto L13;
            Drawable r104 = prepareDrawable(this.mDrawableFutures.valueAt(r103).newDrawable(this.mSourceRes));
            this.mDrawables[r100] = r104;
            this.mDrawableFutures.removeAt(r103);
            if (this.mDrawableFutures.size() != 0) goto L12;
            this.mDrawableFutures = null;
        L12:
            return r104;
        L13:
            return null;
        }

        public final void setConstantSize(boolean r100) {
            this.mConstantSize = r100;
        }

        public final void setEnterFadeDuration(int r100) {
            this.mEnterFadeDuration = r100;
        }

        public final void setExitFadeDuration(int r100) {
            this.mExitFadeDuration = r100;
        }

        public final void setVariablePadding(boolean r100) {
            this.mVariablePadding = r100;
        }

        public final void updateDensity(Resources r100) {
            if (r100 == null) goto L7;
            this.mSourceRes = r100;
            int r101 = DrawableContainer.resolveDensity(r100, this.mDensity);
            int r102 = this.mDensity;
            this.mDensity = r101;
            if (r102 == r101) goto L8;
            this.mCheckedConstantSize = false;
            this.mCheckedPadding = false;
            return;
        L8:
            return;
        }

        public void growArray(int r100, int r101) {
            Drawable[] r102 = new Drawable[r101];
            Drawable[] r103 = this.mDrawables;
            if (r103 == null) goto L5;
            System.arraycopy(r103, 0, r102, 0, r100);
        L5:
            this.mDrawables = r102;
        }

        public final boolean setLayoutDirection(int r100, int r110) {
            int r101 = this.mNumChildren;
            Drawable[] r102 = this.mDrawables;
            int r103 = 0;
            boolean r104 = false;
        L3:
            if (r103 >= r101) goto L13;
            Drawable r105 = r102[r103];
            if (r105 == null) goto L12;
            if (Build.VERSION.SDK_INT < 23) goto L9;
            boolean r106 = DrawableCompat.setLayoutDirection(r105, r100);
        L10:
            if (r103 != r110) goto L12;
            r104 = r106;
            goto L12
        L9:
            r106 = false;
        L12:
            r103 = r103 + 1;
            goto L3
        L13:
            this.mLayoutDirection = r100;
            return r104;
        }

        public DrawableContainerState(DrawableContainerState r100, DrawableContainer r101, Resources r102) {
            int r103 = 0;
            this.mVariablePadding = false;
            this.mConstantSize = false;
            this.mDither = true;
            this.mEnterFadeDuration = 0;
            this.mExitFadeDuration = 0;
            this.mOwner = r101;
            Rect r104 = null;
            if (r102 == null) goto L5;
            Resources r105 = r102;
        L8:
            this.mSourceRes = r105;
            if (r100 == null) goto L11;
            int r106 = r100.mDensity;
        L12:
            int r107 = DrawableContainer.resolveDensity(r102, r106);
            this.mDensity = r107;
            if (r100 == null) goto L44;
            this.mChangingConfigurations = r100.mChangingConfigurations;
            this.mChildrenChangingConfigurations = r100.mChildrenChangingConfigurations;
            this.mCheckedConstantState = true;
            this.mCanConstantState = true;
            this.mVariablePadding = r100.mVariablePadding;
            this.mConstantSize = r100.mConstantSize;
            this.mDither = r100.mDither;
            this.mMutated = r100.mMutated;
            this.mLayoutDirection = r100.mLayoutDirection;
            this.mEnterFadeDuration = r100.mEnterFadeDuration;
            this.mExitFadeDuration = r100.mExitFadeDuration;
            this.mAutoMirrored = r100.mAutoMirrored;
            this.mColorFilter = r100.mColorFilter;
            this.mHasColorFilter = r100.mHasColorFilter;
            this.mTintList = r100.mTintList;
            this.mTintMode = r100.mTintMode;
            this.mHasTintList = r100.mHasTintList;
            this.mHasTintMode = r100.mHasTintMode;
            if (r100.mDensity != r107) goto L26;
            if (r100.mCheckedPadding == false) goto L23;
            if (r100.mConstantPadding == null) goto L21;
            r104 = new Rect(r100.mConstantPadding);
        L21:
            this.mConstantPadding = r104;
            this.mCheckedPadding = true;
        L23:
            if (r100.mCheckedConstantSize == false) goto L26;
            this.mConstantWidth = r100.mConstantWidth;
            this.mConstantHeight = r100.mConstantHeight;
            this.mConstantMinimumWidth = r100.mConstantMinimumWidth;
            this.mConstantMinimumHeight = r100.mConstantMinimumHeight;
            this.mCheckedConstantSize = true;
        L26:
            if (r100.mCheckedOpacity == false) goto L29;
            this.mOpacity = r100.mOpacity;
            this.mCheckedOpacity = true;
        L29:
            if (r100.mCheckedStateful == false) goto L31;
            this.mStateful = r100.mStateful;
            this.mCheckedStateful = true;
        L31:
            Drawable[] r108 = r100.mDrawables;
            this.mDrawables = new Drawable[r108.length];
            this.mNumChildren = r100.mNumChildren;
            SparseArray<Drawable.ConstantState> r109 = r100.mDrawableFutures;
            if (r109 == null) goto L34;
            this.mDrawableFutures = r109.clone();
        L35:
            int r110 = this.mNumChildren;
        L36:
            if (r103 >= r110) goto L50;
            Drawable r111 = r108[r103];
            if (r111 == null) goto L43;
            Drawable.ConstantState r112 = r111.getConstantState();
            if (r112 == null) goto L42;
            this.mDrawableFutures.put(r103, r112);
            goto L43
        L42:
            this.mDrawables[r103] = r108[r103];
        L43:
            r103 = r103 + 1;
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
            r106 = 0;
            goto L12
        L5:
            if (r100 == null) goto L7;
            r105 = r100.mSourceRes;
            goto L8
        L7:
            r105 = null;
            goto L8
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.mDrawableContainerState.canApplyTheme();
    }

    public void clearMutated() {
        this.mDrawableContainerState.clearMutated();
        this.mMutated = false;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.mDrawableContainerState.canConstantState() == false) goto L6;
        DrawableContainerState r100 = this.mDrawableContainerState;
        r100.mChangingConfigurations = getChangingConfigurations();
        return this.mDrawableContainerState;
    L6:
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r100 = this.mCurrDrawable;
        if (r100 != null) goto L11;
        return -1;
    L11:
        return r100.getIntrinsicHeight();
    L5:
        return this.mDrawableContainerState.getConstantHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r100 = this.mCurrDrawable;
        if (r100 != null) goto L11;
        return -1;
    L11:
        return r100.getIntrinsicWidth();
    L5:
        return this.mDrawableContainerState.getConstantWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r100 = this.mCurrDrawable;
        if (r100 != null) goto L11;
        return 0;
    L11:
        return r100.getMinimumHeight();
    L5:
        return this.mDrawableContainerState.getConstantMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.mDrawableContainerState.isConstantSize() == true) goto L5;
        Drawable r100 = this.mCurrDrawable;
        if (r100 != null) goto L11;
        return 0;
    L11:
        return r100.getMinimumWidth();
    L5:
        return this.mDrawableContainerState.getConstantMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable r100 = this.mCurrDrawable;
        if (r100 != null) goto L5;
    L8:
        return -2;
    L5:
        if (r100.isVisible() == false) goto L8;
        return this.mDrawableContainerState.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.mDrawableContainerState.mAutoMirrored;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.mDrawableContainerState.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        Drawable r100 = this.mLastDrawable;
        boolean r101 = true;
        if (r100 == null) goto L5;
        r100.jumpToCurrentState();
        this.mLastDrawable = null;
        boolean r102 = true;
    L6:
        Drawable r103 = this.mCurrDrawable;
        if (r103 == null) goto L12;
        r103.jumpToCurrentState();
        if (this.mHasAlpha == false) goto L12;
        this.mCurrDrawable.setAlpha(this.mAlpha);
    L12:
        if (this.mExitAnimationEnd == 0) goto L15;
        this.mExitAnimationEnd = 0;
        r102 = true;
    L15:
        if (this.mEnterAnimationEnd == 0) goto L17;
        this.mEnterAnimationEnd = 0;
    L18:
        if (r101 == false) goto L21;
        invalidateSelf();
        return;
    L21:
        return;
    L17:
        r101 = r102;
        goto L18
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.mMutated == false) goto L5;
    L7:
        return this;
    L5:
        if (super.mutate() != this) goto L7;
        DrawableContainerState r100 = cloneConstantState();
        r100.mutate();
        setConstantState(r100);
        this.mMutated = true;
        goto L7
    }

    public DrawableContainer() {
        this.mAlpha = 255;
        this.mCurIndex = -1;
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
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.mDrawableContainerState.getChangingConfigurations();
    }

    public DrawableContainerState cloneConstantState() {
        return this.mDrawableContainerState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.mCurrDrawable;
    }

    int getCurrentIndex() {
        return this.mCurIndex;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_graphics_drawable_DrawableContainer_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void initializeDrawableForDisplay(Drawable r100) {
        if (this.mBlockInvalidateCallback != null) goto L5;
        this.mBlockInvalidateCallback = new BlockInvalidateCallback();
    L5:
        r100.setCallback(this.mBlockInvalidateCallback.wrap(r100.getCallback()));
    L28:
        th = move-exception;
        r100.setCallback(this.mBlockInvalidateCallback.unwrap());
        throw th;
    L7:
        if (this.mDrawableContainerState.mEnterFadeDuration <= 0) goto L9;
    L11:
        DrawableContainerState r101 = this.mDrawableContainerState;     // Catch: Throwable -> L28
        if (r101.mHasColorFilter == false) goto L15;
        r100.setColorFilter(r101.mColorFilter);     // Catch: Throwable -> L28
    L20:
        r100.setVisible(isVisible(), true);     // Catch: Throwable -> L28
        r100.setDither(this.mDrawableContainerState.mDither);     // Catch: Throwable -> L28
        r100.setState(getState());     // Catch: Throwable -> L28
        r100.setLevel(getLevel());     // Catch: Throwable -> L28
        r100.setBounds(getBounds());     // Catch: Throwable -> L28
        if (Build.VERSION.SDK_INT < 23) goto L23;
        DrawableCompat.setLayoutDirection(r100, DrawableCompat.getLayoutDirection(this));     // Catch: Throwable -> L28
    L23:
        DrawableCompat.setAutoMirrored(r100, this.mDrawableContainerState.mAutoMirrored);     // Catch: Throwable -> L28
        Rect r102 = this.mHotspotBounds;     // Catch: Throwable -> L28
        if (r102 == null) goto L26;
        DrawableCompat.setHotspotBounds(r100, r102.left, r102.top, r102.right, r102.bottom);     // Catch: Throwable -> L28
    L26:
        r100.setCallback(this.mBlockInvalidateCallback.unwrap());
        return;
    L15:
        if (r101.mHasTintList == false) goto L17;
        DrawableCompat.setTintList(r100, r101.mTintList);     // Catch: Throwable -> L28
    L17:
        DrawableContainerState r103 = this.mDrawableContainerState;     // Catch: Throwable -> L28
        if (r103.mHasTintMode == false) goto L20;
        DrawableCompat.setTintMode(r100, r103.mTintMode);     // Catch: Throwable -> L28
        goto L20
    L9:
        if (this.mHasAlpha == false) goto L11;
        r100.setAlpha(this.mAlpha);     // Catch: Throwable -> L28
        goto L11
    }

    public void animate(boolean r110) {
        boolean r100 = true;
        this.mHasAlpha = true;
        long r101 = SystemClock.uptimeMillis();
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L10;
        long r103 = this.mEnterAnimationEnd;
        if (r103 != 0) goto L7;
    L11:
        boolean r104 = false;
    L12:
        Drawable r105 = this.mLastDrawable;
        if (r105 == null) goto L20;
        long r111 = this.mExitAnimationEnd;
        if (r111 != 0) goto L17;
    L21:
        r100 = r104;
    L22:
        if (r110 == false) goto L26;
        if (r100 == false) goto L27;
        scheduleSelf(this.mAnimationRunnable, r101 + 16);
        return;
    L27:
        return;
    L26:
        return;
    L17:
        if (r111 > r101) goto L19;
        r105.setVisible(false, false);
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0;
        goto L21
    L19:
        r105.setAlpha(((((int) ((r111 - r101) * 255)) / this.mDrawableContainerState.mExitFadeDuration) * this.mAlpha) / 255);
        goto L22
    L20:
        this.mExitAnimationEnd = 0;
        goto L21
    L7:
        if (r103 > r101) goto L9;
        r102.setAlpha(this.mAlpha);
        this.mEnterAnimationEnd = 0;
        goto L11
    L9:
        r102.setAlpha(((255 - (((int) ((r103 - r101) * 255)) / this.mDrawableContainerState.mEnterFadeDuration)) * this.mAlpha) / 255);
        r104 = true;
        goto L12
    L10:
        this.mEnterAnimationEnd = 0;
        goto L11
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme r100) {
        this.mDrawableContainerState.applyTheme(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r100) {
        Drawable r101 = this.mCurrDrawable;
        if (r101 == null) goto L5;
        r101.draw(r100);
    L5:
        Drawable r102 = this.mLastDrawable;
        if (r102 == null) goto L9;
        r102.draw(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect r100) {
        Rect r101 = this.mHotspotBounds;
        if (r101 == null) goto L5;
        r100.set(r101);
        return;
    L5:
        super.getHotspotBounds(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline r100) {
        Drawable r101 = this.mCurrDrawable;
        if (r101 == null) goto L6;
        Api21Impl.getOutline(r101, r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect r100) {
        Rect r101 = this.mDrawableContainerState.getConstantPadding();
        if (r101 == null) goto L8;
        r100.set(r101);
        int r102 = (r101.left | r101.top) | r101.bottom;
        if ((r101.right | r102) == 0) goto L7;
        boolean r103 = true;
    L13:
        if (needsMirroring() == false) goto L15;
        int r104 = r100.left;
        r100.left = r100.right;
        r100.right = r104;
    L15:
        return r103;
    L7:
        r103 = false;
        goto L13
    L8:
        Drawable r105 = this.mCurrDrawable;
        if (r105 == null) goto L11;
        r103 = r105.getPadding(r100);
        goto L13
    L11:
        r103 = super.getPadding(r100);
        goto L13
    }

    public void invalidateDrawable(Drawable r100) {
        DrawableContainerState r101 = this.mDrawableContainerState;
        if (r101 == null) goto L6;
        r101.invalidateCache();
    L6:
        if (r100 == this.mCurrDrawable) goto L8;
        return;
    L8:
        if (getCallback() == null) goto L12;
        getCallback().invalidateDrawable(this);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r100) {
        Drawable r101 = this.mLastDrawable;
        if (r101 == null) goto L5;
        r101.setBounds(r100);
    L5:
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L9;
        r102.setBounds(r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int r100) {
        return this.mDrawableContainerState.setLayoutDirection(r100, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r100) {
        Drawable r101 = this.mLastDrawable;
        if (r101 != null) goto L5;
        Drawable r102 = this.mCurrDrawable;
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.setLevel(r100);
    L5:
        return r101.setLevel(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] r100) {
        Drawable r101 = this.mLastDrawable;
        if (r101 != null) goto L5;
        Drawable r102 = this.mCurrDrawable;
        if (r102 != null) goto L9;
        return false;
    L9:
        return r102.setState(r100);
    L5:
        return r101.setState(r100);
    }

    boolean selectDrawable(int r110) {
        if (r110 != this.mCurIndex) goto L5;
        return false;
    L5:
        long r100 = SystemClock.uptimeMillis();
        if (this.mDrawableContainerState.mExitFadeDuration <= 0) goto L14;
        Drawable r101 = this.mLastDrawable;
        if (r101 == null) goto L10;
        r101.setVisible(false, false);
    L10:
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L13;
        this.mLastDrawable = r102;
        this.mExitAnimationEnd = ((long) this.mDrawableContainerState.mExitFadeDuration) + r100;
    L17:
        if (r110 < 0) goto L26;
        DrawableContainerState r103 = this.mDrawableContainerState;
        if (r110 >= r103.mNumChildren) goto L26;
        Drawable r104 = r103.getChild(r110);
        this.mCurrDrawable = r104;
        this.mCurIndex = r110;
        if (r104 == null) goto L28;
        int r111 = this.mDrawableContainerState.mEnterFadeDuration;
        if (r111 <= 0) goto L25;
        this.mEnterAnimationEnd = r100 + ((long) r111);
    L25:
        initializeDrawableForDisplay(r104);
    L28:
        if (this.mEnterAnimationEnd == 0) goto L30;
    L31:
        Runnable r105 = this.mAnimationRunnable;
        if (r105 != null) goto L34;
        this.mAnimationRunnable = new AnonymousClass1(this);
    L35:
        animate(true);
    L36:
        invalidateSelf();
        return true;
    L34:
        unscheduleSelf(r105);
        goto L35
    L30:
        if (this.mExitAnimationEnd == 0) goto L36;
    L26:
        this.mCurrDrawable = null;
        this.mCurIndex = -1;
        goto L28
    L13:
        this.mLastDrawable = null;
        this.mExitAnimationEnd = 0;
        goto L17
    L14:
        Drawable r106 = this.mCurrDrawable;
        if (r106 == null) goto L17;
        r106.setVisible(false, false);
        goto L17
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r100) {
        if (this.mHasAlpha == true) goto L5;
    L6:
        this.mHasAlpha = true;
        this.mAlpha = r100;
        Drawable r101 = this.mCurrDrawable;
        if (r101 != null) goto L9;
        return;
    L9:
        if (this.mEnterAnimationEnd != 0) goto L11;
        r101.setAlpha(r100);
        return;
    L11:
        animate(false);
        return;
    L5:
        if (this.mAlpha != r100) goto L6;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean r100) {
        DrawableContainerState r101 = this.mDrawableContainerState;
        if (r101.mAutoMirrored == r100) goto L8;
        r101.mAutoMirrored = r100;
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L9;
        DrawableCompat.setAutoMirrored(r102, r100);
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r100) {
        DrawableContainerState r101 = this.mDrawableContainerState;
        r101.mHasColorFilter = true;
        if (r101.mColorFilter == r100) goto L8;
        r101.mColorFilter = r100;
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L9;
        r102.setColorFilter(r100);
        return;
    L9:
        return;
    }

    public void setConstantState(DrawableContainerState r100) {
        this.mDrawableContainerState = r100;
        int r101 = this.mCurIndex;
        if (r101 < 0) goto L7;
        Drawable r102 = r100.getChild(r101);
        this.mCurrDrawable = r102;
        if (r102 == null) goto L7;
        initializeDrawableForDisplay(r102);
    L7:
        this.mLastDrawable = null;
    }

    void setCurrentIndex(int r100) {
        selectDrawable(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean r100) {
        DrawableContainerState r101 = this.mDrawableContainerState;
        if (r101.mDither == r100) goto L8;
        r101.mDither = r100;
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L9;
        r102.setDither(r100);
        return;
    L9:
        return;
    }

    public void setEnterFadeDuration(int r100) {
        this.mDrawableContainerState.mEnterFadeDuration = r100;
    }

    public void setExitFadeDuration(int r100) {
        this.mDrawableContainerState.mExitFadeDuration = r100;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList r100) {
        DrawableContainerState r101 = this.mDrawableContainerState;
        r101.mHasTintList = true;
        if (r101.mTintList == r100) goto L6;
        r101.mTintList = r100;
        DrawableCompat.setTintList(this.mCurrDrawable, r100);
        return;
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode r100) {
        DrawableContainerState r101 = this.mDrawableContainerState;
        r101.mHasTintMode = true;
        if (r101.mTintMode == r100) goto L6;
        r101.mTintMode = r100;
        DrawableCompat.setTintMode(this.mCurrDrawable, r100);
        return;
    }

    public final void updateDensity(Resources r100) {
        this.mDrawableContainerState.updateDensity(r100);
    }

    public static int resolveDensity(Resources r100, int r101) {
        if (r100 == null) goto L5;
        r101 = INVOKEVIRTUAL_androidx_appcompat_graphics_drawable_DrawableContainer_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100).densityDpi;
    L5:
        if (r101 != 0) goto L8;
        return 160;
    L8:
        return r101;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float r100, float r101) {
        Drawable r102 = this.mCurrDrawable;
        if (r102 == null) goto L6;
        DrawableCompat.setHotspot(r102, r100, r101);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r100, boolean r101) {
        boolean r102 = super.setVisible(r100, r101);
        Drawable r103 = this.mLastDrawable;
        if (r103 == null) goto L5;
        r103.setVisible(r100, r101);
    L5:
        Drawable r104 = this.mCurrDrawable;
        if (r104 == null) goto L8;
        r104.setVisible(r100, r101);
    L8:
        return r102;
    }

    public void unscheduleDrawable(Drawable r100, Runnable r101) {
        if (r100 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().unscheduleDrawable(this, r101);
        return;
    }

    public void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        if (r100 == this.mCurrDrawable) goto L5;
        return;
    L5:
        if (getCallback() == null) goto L9;
        getCallback().scheduleDrawable(this, r101, r102);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int r100, int r101, int r102, int r103) {
        Rect r104 = this.mHotspotBounds;
        if (r104 != null) goto L5;
        this.mHotspotBounds = new Rect(r100, r101, r102, r103);
    L6:
        Drawable r105 = this.mCurrDrawable;
        if (r105 == null) goto L10;
        DrawableCompat.setHotspotBounds(r105, r100, r101, r102, r103);
        return;
    L10:
        return;
    L5:
        r104.set(r100, r101, r102, r103);
        goto L6
    }
}
