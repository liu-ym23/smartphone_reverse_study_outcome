package com.alibaba.android.vlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.layout.LayoutChunkResult;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
class ExposeLinearLayoutManagerEx extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    static final int FLAG_INVALID = 4;
    static final int FLAG_UPDATED = 2;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final String TAG = "ExposeLLManagerEx";
    public static final int VERTICAL = 1;
    private static Field vhField;
    private static Method vhSetFlags;
    private Object[] emptyArgs;
    private LayoutChunkResult layoutChunkResultCache;
    private final AnchorInfo mAnchorInfo;
    private final ChildHelperWrapper mChildHelperWrapper;
    protected Bundle mCurrentPendingSavedState;
    private int mCurrentPendingScrollPosition;
    private final Method mEnsureLayoutStateMethod;
    private boolean mLastStackFromEnd;
    protected LayoutState mLayoutState;
    private OrientationHelperEx mOrientationHelper;
    private int mPendingScrollPositionOffset;
    private RecyclerView mRecyclerView;
    private boolean mShouldReverseLayoutExpose;
    private int recycleOffset;

    public class AnchorInfo {
        public int mCoordinate;
        public boolean mLayoutFromEnd;
        public int mPosition;
        final /* synthetic */ ExposeLinearLayoutManagerEx this$0;

        public AnchorInfo(ExposeLinearLayoutManagerEx r10) {
            this.this$0 = r10;
        }

        public void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r10 = ExposeLinearLayoutManagerEx.access$000(this.this$0).getEndAfterPadding();
        L6:
            this.mCoordinate = r10;
            return;
        L5:
            r10 = ExposeLinearLayoutManagerEx.access$000(this.this$0).getStartAfterPadding();
            goto L6
        }

        public void assignFromView(View r10) {
            if (this.mLayoutFromEnd == false) goto L5;
            this.mCoordinate = (ExposeLinearLayoutManagerEx.access$000(this.this$0).getDecoratedEnd(r10) + this.this$0.computeAlignOffset(r10, this.mLayoutFromEnd, true)) + ExposeLinearLayoutManagerEx.access$000(this.this$0).getTotalSpaceChange();
        L6:
            this.mPosition = this.this$0.getPosition(r10);
            return;
        L5:
            this.mCoordinate = ExposeLinearLayoutManagerEx.access$000(this.this$0).getDecoratedStart(r10) + this.this$0.computeAlignOffset(r10, this.mLayoutFromEnd, true);
            goto L6
        }

        public boolean assignFromViewIfValid(View r10, RecyclerView.State r11) {
            RecyclerView.LayoutParams r12 = (RecyclerView.LayoutParams) r10.getLayoutParams();
            if (r12.isItemRemoved() == false) goto L5;
            return false;
        L5:
            if (r12.getViewPosition() >= 0) goto L7;
            return false;
        L7:
            if (r12.getViewPosition() >= r11.c()) goto L13;
            assignFromView(r10);
            return true;
        L13:
            return false;
        }

        public void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + '}';
        }
    }

    public class ChildHelperWrapper {
        private Object[] args;
        private Field mChildHelperField;
        private Method mClearMethod;
        private Method mFindHiddenNonRemovedViewMethod;
        private Method mFindHiddenNonRemovedViewMethod25;
        private Field mHiddenViewField;
        private Method mHideMethod;
        private Object mInnerBucket;
        private Object mInnerChildHelper;
        private List mInnerHiddenView;
        private Method mIsHideMethod;
        private RecyclerView.LayoutManager mLayoutManager;
        final /* synthetic */ ExposeLinearLayoutManagerEx this$0;

        public ChildHelperWrapper(ExposeLinearLayoutManagerEx r10, RecyclerView.LayoutManager r11) {
            this.this$0 = r10;
            this.args = new Object[1];
            this.mLayoutManager = r11;
            Field r12 = RecyclerView.LayoutManager.class.getDeclaredField("mChildHelper");     // Catch: Exception -> L5
            this.mChildHelperField = r12;     // Catch: Exception -> L5
            r12.setAccessible(true);     // Catch: Exception -> L5
            ensureChildHelper();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        public void ensureChildHelper() {
        L11:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            if (this.mInnerChildHelper != null) goto L22;
            Object r10 = this.mChildHelperField.get(this.mLayoutManager);     // Catch: Exception -> L11
            this.mInnerChildHelper = r10;     // Catch: Exception -> L11
            if (r10 != null) goto L8;
            return;
        L8:
            Class<?> r11 = r10.getClass();     // Catch: Exception -> L11
            Method r12 = r11.getDeclaredMethod("hide", new Class[]{View.class});     // Catch: Exception -> L11
            this.mHideMethod = r12;     // Catch: Exception -> L11
            r12.setAccessible(true);     // Catch: Exception -> L11
            Class r13 = Integer.TYPE;     // Catch: Exception -> L11 NoSuchMethodException -> L13
            Method r14 = r11.getDeclaredMethod("findHiddenNonRemovedView", new Class[]{r13, r13});     // Catch: Exception -> L11 NoSuchMethodException -> L13
            this.mFindHiddenNonRemovedViewMethod = r14;     // Catch: Exception -> L11 NoSuchMethodException -> L13
            r14.setAccessible(true);     // Catch: Exception -> L11 NoSuchMethodException -> L13
        L14:
            Method r15 = r11.getDeclaredMethod("isHidden", new Class[]{View.class});     // Catch: Exception -> L11
            this.mIsHideMethod = r15;     // Catch: Exception -> L11
            r15.setAccessible(true);     // Catch: Exception -> L11
            Field r16 = r11.getDeclaredField("mBucket");     // Catch: Exception -> L11
            r16.setAccessible(true);     // Catch: Exception -> L11
            Object r17 = r16.get(this.mInnerChildHelper);     // Catch: Exception -> L11
            this.mInnerBucket = r17;     // Catch: Exception -> L11
            Method r18 = r17.getClass().getDeclaredMethod("clear", new Class[]{Integer.TYPE});     // Catch: Exception -> L11
            this.mClearMethod = r18;     // Catch: Exception -> L11
            r18.setAccessible(true);     // Catch: Exception -> L11
            Field r19 = r11.getDeclaredField("mHiddenViews");     // Catch: Exception -> L11
            this.mHiddenViewField = r19;     // Catch: Exception -> L11
            r19.setAccessible(true);     // Catch: Exception -> L11
            this.mInnerHiddenView = (List) this.mHiddenViewField.get(this.mInnerChildHelper);     // Catch: Exception -> L11
            return;
        L13:
            Method r20 = r11.getDeclaredMethod("findHiddenNonRemovedView", new Class[]{Integer.TYPE});     // Catch: Exception -> L11
            this.mFindHiddenNonRemovedViewMethod25 = r20;     // Catch: Exception -> L11
            r20.setAccessible(true);     // Catch: Exception -> L11
            goto L14
        }

        public View findHiddenNonRemovedView(int r10, int r11) {
            ensureChildHelper();     // Catch: Exception -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10
            Method r12 = this.mFindHiddenNonRemovedViewMethod;     // Catch: Exception -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10
            if (r12 != null) goto L5;
            Method r13 = this.mFindHiddenNonRemovedViewMethod25;     // Catch: Exception -> L6 InvocationTargetException -> L8 IllegalAccessException -> L10
            if (r13 != null) goto L15;
            return null;
        L15:
            return (View) r13.invoke(this.mInnerChildHelper, new Object[]{Integer.valueOf(r10)});
        L5:
            return (View) r12.invoke(this.mInnerChildHelper, new Object[]{Integer.valueOf(r10), -1});
        L10:
            e = move-exception;
            e.printStackTrace();
            return null;
        L8:
            e = move-exception;
            e.printStackTrace();
            return null;
        L6:
            e = move-exception;
            e.printStackTrace();
            return null;
        }

        public void hide(View r10) {
            ensureChildHelper();     // Catch: Exception -> L6
            if (this.mInnerHiddenView.indexOf(r10) >= 0) goto L11;
            Object[] r11 = this.args;     // Catch: Exception -> L6
            r11[0] = r10;     // Catch: Exception -> L6
            this.mHideMethod.invoke(this.mInnerChildHelper, r11);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        public boolean isHidden(View r10) {
            ensureChildHelper();     // Catch: Exception -> L5 InvocationTargetException -> L7 IllegalAccessException -> L9
            Object[] r11 = this.args;     // Catch: Exception -> L5 InvocationTargetException -> L7 IllegalAccessException -> L9
            r11[0] = r10;     // Catch: Exception -> L5 InvocationTargetException -> L7 IllegalAccessException -> L9
            return ((Boolean) this.mIsHideMethod.invoke(this.mInnerChildHelper, r11)).booleanValue();
        L9:
            e = move-exception;
            e.printStackTrace();
        L14:
            return false;
        L7:
            e = move-exception;
            e.printStackTrace();
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public void show(View r10) {
            ensureChildHelper();     // Catch: Exception -> L6
            int r11 = ExposeLinearLayoutManagerEx.access$100(this.this$0).indexOfChild(r10);     // Catch: Exception -> L6
            this.args[0] = Integer.valueOf(r11);     // Catch: Exception -> L6
            this.mClearMethod.invoke(this.mInnerBucket, this.args);     // Catch: Exception -> L6
            List r12 = this.mInnerHiddenView;     // Catch: Exception -> L6
            if (r12 == null) goto L11;
            r12.remove(r10);     // Catch: Exception -> L6
            return;
        L11:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "_ExposeLLayoutManager#LayoutState";
        public int mAvailable;
        public int mCurrentPosition;
        public int mExtra;
        public int mFixOffset;
        public boolean mIsPreLayout;
        public int mItemDirection;
        public int mLayoutDirection;
        public int mOffset;
        public boolean mOnRefresLayout;
        public boolean mRecycle;
        public List<RecyclerView.ViewHolder> mScrapList;
        public int mScrollingOffset;
        private Method vhIsRemoved;

        public LayoutState() {
            this.vhIsRemoved = null;
            this.mOnRefresLayout = false;
            this.mRecycle = true;
            this.mExtra = 0;
            this.mFixOffset = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
            Method r10 = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", null);     // Catch: NoSuchMethodException -> L5
            this.vhIsRemoved = r10;     // Catch: NoSuchMethodException -> L5
            r10.setAccessible(true);     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        @SuppressLint({"LongLogTag"})
        private View nextFromLimitedList() {
            int r10 = this.mScrapList.size();
            int r11 = Channel.UNLIMITED;
            RecyclerView.ViewHolder r12 = null;
            int r13 = 0;
        L3:
            if (r13 >= r10) goto L28;
            RecyclerView.ViewHolder r14 = this.mScrapList.get(r13);
            if (this.mIsPreLayout == false) goto L32;
        L19:
            int r15 = (r14.getPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (r15 < 0) goto L27;
            if (r15 >= r11) goto L27;
            r12 = r14;
            if (r15 == 0) goto L28;
            r11 = r15;
        L27:
            r13 = r13 + 1;
            goto L3
        L32:
            boolean r16 = ((Boolean) this.vhIsRemoved.invoke(r14, null)).booleanValue();     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10
        L16:
            if (this.mIsPreLayout == true) goto L19;
            if (r16 == false) goto L19;
        L10:
            e = move-exception;
            e.printStackTrace();
        L14:
            r16 = false;
        L8:
            e = move-exception;
            e.printStackTrace();
        L28:
            if (r12 == null) goto L31;
            this.mCurrentPosition = r12.getPosition() + this.mItemDirection;
            return r12.itemView;
        L31:
            return null;
        }

        public boolean hasMore(RecyclerView.State r10) {
            int r11 = this.mCurrentPosition;
            if (r11 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r11 >= r10.c()) goto L7;
            return true;
        }

        @SuppressLint({"LongLogTag"})
        public void log() {
            Log.d(TAG, "avail:" + this.mAvailable + ", ind:" + this.mCurrentPosition + ", dir:" + this.mItemDirection + ", offset:" + this.mOffset + ", layoutDir:" + this.mLayoutDirection);
        }

        public View next(RecyclerView.Recycler r10) {
            if (this.mScrapList != null) goto L5;
            View r11 = r10.o(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return r11;
        L5:
            return nextFromLimitedList();
        }
    }

    public static class ViewHolderWrapper {
        private static Method mIsChanged;
        private static Method mIsInvalid;
        private static Method mIsRemoved;
        private static Method mSetFlags;
        private static Method mShouldIgnore;
        private RecyclerView.ViewHolder mHolder;

        static {
            Method r10 = RecyclerView.ViewHolder.class.getDeclaredMethod("shouldIgnore", null);     // Catch: NoSuchMethodException -> L9
            mShouldIgnore = r10;     // Catch: NoSuchMethodException -> L9
            r10.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            Method r11 = RecyclerView.ViewHolder.class.getDeclaredMethod("isInvalid", null);     // Catch: NoSuchMethodException -> L9
            mIsInvalid = r11;     // Catch: NoSuchMethodException -> L9
            r11.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            Method r12 = RecyclerView.ViewHolder.class.getDeclaredMethod("isRemoved", null);     // Catch: NoSuchMethodException -> L9
            mIsRemoved = r12;     // Catch: NoSuchMethodException -> L9
            r12.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            Class r13 = Integer.TYPE;     // Catch: NoSuchMethodException -> L9
            Method r14 = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", new Class[]{r13, r13});     // Catch: NoSuchMethodException -> L9
            mSetFlags = r14;     // Catch: NoSuchMethodException -> L9
            r14.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            mIsChanged = RecyclerView.ViewHolder.class.getDeclaredMethod("isChanged", null);     // Catch: NoSuchMethodException -> L6
        L7:
            mIsChanged.setAccessible(true);     // Catch: NoSuchMethodException -> L9
            return;
        L6:
            mIsChanged = RecyclerView.ViewHolder.class.getDeclaredMethod("isUpdated", null);     // Catch: NoSuchMethodException -> L9
        L9:
            e = move-exception;
            e.printStackTrace();
        }

        public ViewHolderWrapper(RecyclerView.ViewHolder r10) {
            this.mHolder = r10;
        }

        public static void setFlags(RecyclerView.ViewHolder r10, int r11, int r12) {
            mSetFlags.invoke(r10, new Object[]{Integer.valueOf(r11), Integer.valueOf(r12)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
        L14:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        public boolean isChanged() {
            Method r10 = mIsChanged;
            if (r10 != null) goto L14;
            return true;
        L14:
            return ((Boolean) r10.invoke(this.mHolder, null)).booleanValue();
        L9:
            e = move-exception;
            e.printStackTrace();
        L13:
            return true;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        public boolean isInvalid() {
            Method r10 = mIsInvalid;
            if (r10 != null) goto L14;
            return true;
        L14:
            return ((Boolean) r10.invoke(this.mHolder, null)).booleanValue();
        L9:
            e = move-exception;
            e.printStackTrace();
        L13:
            return true;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        public boolean isRemoved() {
            Method r10 = mIsRemoved;
            if (r10 != null) goto L14;
            return true;
        L14:
            return ((Boolean) r10.invoke(this.mHolder, null)).booleanValue();
        L9:
            e = move-exception;
            e.printStackTrace();
        L13:
            return true;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        public boolean requireUpdated() {
            if (isInvalid() == false) goto L5;
        L10:
            return true;
        L5:
            if (isRemoved() == true) goto L10;
            if (isChanged() == true) goto L10;
            return false;
        }

        public void setFlags(int r10, int r11) {
            mSetFlags.invoke(this.mHolder, new Object[]{Integer.valueOf(r10), Integer.valueOf(r11)});     // Catch: InvocationTargetException -> L4 IllegalAccessException -> L6
        L14:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    static {
    }

    public ExposeLinearLayoutManagerEx(Context r10) {
        this(r10, 1, false);
    }

    public static /* synthetic */ OrientationHelperEx access$000(ExposeLinearLayoutManagerEx r10) {
        return r10.mOrientationHelper;
    }

    public static /* synthetic */ RecyclerView access$100(ExposeLinearLayoutManagerEx r10) {
        return r10.mRecyclerView;
    }

    public static void attachViewHolder(RecyclerView.LayoutParams r10, RecyclerView.ViewHolder r11) {
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (vhField != null) goto L13;
        vhField = RecyclerView.LayoutParams.class.getDeclaredField("mViewHolder");     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
    L13:
        vhField.setAccessible(true);     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
        vhField.set(r10, r11);     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
        if (vhSetFlags != null) goto L16;
        Class r12 = Integer.TYPE;     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
        Method r13 = RecyclerView.ViewHolder.class.getDeclaredMethod("setFlags", new Class[]{r12, r12});     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
        vhSetFlags = r13;     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
        r13.setAccessible(true);     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
    L16:
        vhSetFlags.invoke(r11, new Object[]{4, 4});     // Catch: InvocationTargetException -> L5 NoSuchMethodException -> L7 IllegalAccessException -> L9 NoSuchFieldException -> L11
    }

    private int convertFocusDirectionToLayoutDirectionExpose(int r10) {
        int r11 = getOrientation();
        if (r10 != 1) goto L5;
        return -1;
    L5:
        if (r10 != 2) goto L7;
        return 1;
    L7:
        if (r10 != 17) goto L9;
        if (r11 != 0) goto L30;
        return -1;
    L30:
        return Integer.MIN_VALUE;
    L9:
        if (r10 != 33) goto L11;
        if (r11 != 1) goto L26;
        return -1;
    L26:
        return Integer.MIN_VALUE;
    L11:
        if (r10 != 66) goto L13;
        if (r11 != 0) goto L22;
        return 1;
    L22:
        return Integer.MIN_VALUE;
    L13:
        if (r10 == 130) goto L15;
        return Integer.MIN_VALUE;
    L15:
        if (r11 != 1) goto L18;
        return 1;
    L18:
        return Integer.MIN_VALUE;
    }

    private View findReferenceChildInternal(int r10, int r11, int r12) {
        ensureLayoutStateExpose();
        int r13 = this.mOrientationHelper.getStartAfterPadding();
        int r14 = this.mOrientationHelper.getEndAfterPadding();
        if (r11 <= r10) goto L5;
        int r15 = 1;
    L6:
        View r16 = null;
        View r17 = null;
    L7:
        if (r10 == r11) goto L23;
        View r18 = getChildAt(r10);
        int r19 = getPosition(r18);
        if (r19 < 0) goto L22;
        if (r19 >= r12) goto L22;
        if (((RecyclerView.LayoutParams) r18.getLayoutParams()).isItemRemoved() == false) goto L16;
        if (r17 != null) goto L22;
        r17 = r18;
        goto L22
    L16:
        if (this.mOrientationHelper.getDecoratedStart(r18) < r14) goto L18;
    L20:
        if (r16 != null) goto L22;
        r16 = r18;
        goto L22
    L18:
        if (this.mOrientationHelper.getDecoratedEnd(r18) < r13) goto L20;
        return r18;
    L22:
        r10 = r10 + r15;
        goto L7
    L23:
        if (r16 == null) goto L26;
        return r16;
    L26:
        return r17;
    L5:
        r15 = -1;
        goto L6
    }

    private int fixLayoutEndGapExpose(int r10, RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13) {
        int r14 = this.mOrientationHelper.getEndAfterPadding() - r10;
        if (r14 <= 0) goto L11;
        int r15 = -scrollInternalBy(-r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L10;
        int r17 = this.mOrientationHelper.getEndAfterPadding() - r16;
        if (r17 <= 0) goto L10;
        this.mOrientationHelper.offsetChildren(r17);
        return r17 + r15;
    L10:
        return r15;
    L11:
        return 0;
    }

    private int fixLayoutStartGapExpose(int r10, RecyclerView.Recycler r11, RecyclerView.State r12, boolean r13) {
        int r14 = r10 - this.mOrientationHelper.getStartAfterPadding();
        if (r14 <= 0) goto L10;
        int r15 = -scrollInternalBy(r14, r11, r12);
        int r16 = r10 + r15;
        if (r13 == false) goto L12;
        int r17 = r16 - this.mOrientationHelper.getStartAfterPadding();
        if (r17 <= 0) goto L13;
        this.mOrientationHelper.offsetChildren(-r17);
        return r15 - r17;
    L13:
        return r15;
    L12:
        return r15;
    L10:
        return 0;
    }

    private View getChildClosestToEndExpose() {
        if (this.mShouldReverseLayoutExpose == false) goto L5;
        int r10 = 0;
    L7:
        return getChildAt(r10);
    L5:
        r10 = getChildCount() - 1;
        goto L7
    }

    private View getChildClosestToStartExpose() {
        if (this.mShouldReverseLayoutExpose == false) goto L5;
        int r10 = getChildCount() - 1;
    L7:
        return getChildAt(r10);
    L5:
        r10 = 0;
        goto L7
    }

    public static boolean isViewHolderUpdated(RecyclerView.ViewHolder r10) {
        return new ViewHolderWrapper(r10).requireUpdated();
    }

    private void layoutForPredictiveAnimationsExpose(RecyclerView.Recycler r11, RecyclerView.State r12, int r13, int r14) {
        if (r12.h() == true) goto L5;
        return;
    L5:
        if (getChildCount() != 0) goto L7;
        return;
    L7:
        if (r12.f() == false) goto L9;
        return;
    L9:
        if (supportsPredictiveItemAnimations() == false) goto L44;
        List<RecyclerView.ViewHolder> r10 = r11.k();
        int r15 = r10.size();
        int r16 = getPosition(getChildAt(0));
        int r17 = 0;
        int r18 = 0;
        int r19 = 0;
    L12:
        boolean r20 = true;
        if (r17 >= r15) goto L23;
        RecyclerView.ViewHolder r21 = r10.get(r17);
        if (r21.getPosition() < r16) goto L19;
        r20 = false;
    L19:
        if (r20 == this.mShouldReverseLayoutExpose) goto L21;
        r18 = r18 + this.mOrientationHelper.getDecoratedMeasurement(r21.itemView);
    L22:
        r17 = r17 + 1;
        goto L12
    L21:
        r19 = r19 + this.mOrientationHelper.getDecoratedMeasurement(r21.itemView);
        goto L22
    L23:
        this.mLayoutState.mScrapList = r10;
        int r22 = -1;
        if (r18 <= 0) goto L30;
        updateLayoutStateToFillStartExpose(getPosition(getChildClosestToStartExpose()), r13);
        LayoutState r110 = this.mLayoutState;
        r110.mExtra = r18;
        r110.mAvailable = 0;
        int r23 = r110.mCurrentPosition;
        if (this.mShouldReverseLayoutExpose == false) goto L28;
        int r24 = 1;
    L29:
        r110.mCurrentPosition = r23 + r24;
        r110.mOnRefresLayout = true;
        fill(r11, r110, r12, false);
        goto L30
    L28:
        r24 = -1;
    L30:
        if (r19 <= 0) goto L36;
        updateLayoutStateToFillEndExpose(getPosition(getChildClosestToEndExpose()), r14);
        LayoutState r111 = this.mLayoutState;
        r111.mExtra = r19;
        r111.mAvailable = 0;
        int r112 = r111.mCurrentPosition;
        if (this.mShouldReverseLayoutExpose == true) goto L35;
        r22 = 1;
    L35:
        r111.mCurrentPosition = r112 + r22;
        r111.mOnRefresLayout = true;
        fill(r11, r111, r12, false);
    L36:
        this.mLayoutState.mScrapList = null;
        return;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        int r10 = 0;
    L4:
        if (r10 >= getChildCount()) goto L6;
        View r11 = getChildAt(r10);
        Log.d(TAG, "item " + getPosition(r11) + ", coord:" + this.mOrientationHelper.getDecoratedStart(r11));
        r10 = r10 + 1;
        goto L4
    L6:
        Log.d(TAG, "==============");
    }

    private View myFindFirstReferenceChild(int r10) {
        return findReferenceChildInternal(0, getChildCount(), r10);
    }

    private View myFindLastReferenceChild(int r10) {
        return findReferenceChildInternal(getChildCount() - 1, -1, r10);
    }

    private View myFindReferenceChildClosestToEnd(RecyclerView.State r10) {
        boolean r11 = this.mShouldReverseLayoutExpose;
        int r12 = r10.c();
        if (r11 == false) goto L6;
        return myFindFirstReferenceChild(r12);
    L6:
        return myFindLastReferenceChild(r12);
    }

    private View myFindReferenceChildClosestToStart(RecyclerView.State r10) {
        boolean r11 = this.mShouldReverseLayoutExpose;
        int r12 = r10.c();
        if (r11 == false) goto L6;
        return myFindLastReferenceChild(r12);
    L6:
        return myFindFirstReferenceChild(r12);
    }

    private void myResolveShouldLayoutReverse() {
        if (getOrientation() != 1) goto L5;
    L8:
        this.mShouldReverseLayoutExpose = getReverseLayout();
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.mShouldReverseLayoutExpose = !getReverseLayout();
    }

    private void recycleByLayoutStateExpose(RecyclerView.Recycler r10, LayoutState r11) {
        if (r11.mRecycle == true) goto L6;
        return;
    L6:
        if (r11.mLayoutDirection != (-1)) goto L8;
        recycleViewsFromEndExpose(r10, r11.mScrollingOffset);
        return;
    L8:
        recycleViewsFromStartExpose(r10, r11.mScrollingOffset);
    }

    private void recycleViewsFromEndExpose(RecyclerView.Recycler r10, int r11) {
        int r12 = getChildCount();
        if (r11 >= 0) goto L5;
        return;
    L5:
        int r13 = this.mOrientationHelper.getEnd() - r11;
        if (this.mShouldReverseLayoutExpose == false) goto L14;
        int r14 = 0;
    L8:
        if (r14 >= r12) goto L21;
        if ((this.mOrientationHelper.getDecoratedStart(getChildAt(r14)) - this.recycleOffset) < r13) goto L11;
        r14 = r14 + 1;
        goto L8
    L11:
        recycleChildren(r10, 0, r14);
        return;
    L21:
        return;
    L14:
        int r15 = r12 - 1;
        int r16 = r15;
    L15:
        if (r16 < 0) goto L26;
        if ((this.mOrientationHelper.getDecoratedStart(getChildAt(r16)) - this.recycleOffset) < r13) goto L18;
        r16 = r16 - 1;
        goto L15
    L18:
        recycleChildren(r10, r15, r16);
        return;
    }

    private void recycleViewsFromStartExpose(RecyclerView.Recycler r10, int r11) {
        if (r11 >= 0) goto L4;
        return;
    L4:
        int r12 = getChildCount();
        if (this.mShouldReverseLayoutExpose == false) goto L13;
        int r13 = r12 - 1;
        int r14 = r13;
    L7:
        if (r14 < 0) goto L20;
        if ((this.mOrientationHelper.getDecoratedEnd(getChildAt(r14)) + this.recycleOffset) > r11) goto L10;
        r14 = r14 - 1;
        goto L7
    L10:
        recycleChildren(r10, r13, r14);
        return;
    L20:
        return;
    L13:
        int r15 = 0;
    L14:
        if (r15 >= r12) goto L25;
        if ((this.mOrientationHelper.getDecoratedEnd(getChildAt(r15)) + this.recycleOffset) > r11) goto L17;
        r15 = r15 + 1;
        goto L14
    L17:
        recycleChildren(r10, 0, r15);
        return;
    }

    private boolean updateAnchorFromChildrenExpose(RecyclerView.State r10, AnchorInfo r11) {
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        View r12 = getFocusedChild();
        if (r12 == null) goto L11;
        if (r11.assignFromViewIfValid(r12, r10) == false) goto L11;
        return true;
    L11:
        if (this.mLastStackFromEnd == getStackFromEnd()) goto L14;
        return false;
    L14:
        if (r11.mLayoutFromEnd == false) goto L16;
        View r13 = myFindReferenceChildClosestToEnd(r10);
    L17:
        if (r13 == null) goto L32;
        r11.assignFromView(r13);
        if (r10.f() == false) goto L21;
    L31:
        return true;
    L21:
        if (supportsPredictiveItemAnimations() == false) goto L31;
        if (this.mOrientationHelper.getDecoratedStart(r13) >= this.mOrientationHelper.getEndAfterPadding()) goto L27;
        if (this.mOrientationHelper.getDecoratedEnd(r13) >= this.mOrientationHelper.getStartAfterPadding()) goto L31;
    L27:
        if (r11.mLayoutFromEnd == false) goto L29;
        int r14 = this.mOrientationHelper.getEndAfterPadding();
    L30:
        r11.mCoordinate = r14;
        goto L31
    L29:
        r14 = this.mOrientationHelper.getStartAfterPadding();
        goto L30
    L32:
        return false;
    L16:
        r13 = myFindReferenceChildClosestToStart(r10);
        goto L17
    }

    private boolean updateAnchorFromPendingDataExpose(RecyclerView.State r10, AnchorInfo r11) {
        boolean r12 = false;
        if (r10.f() == true) goto L60;
        int r13 = this.mCurrentPendingScrollPosition;
        if (r13 == (-1)) goto L60;
        if (r13 >= 0) goto L10;
    L59:
        this.mCurrentPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r13 >= r10.c()) goto L59;
        r11.mPosition = this.mCurrentPendingScrollPosition;
        Bundle r14 = this.mCurrentPendingSavedState;
        if (r14 == null) goto L22;
        if (r14.getInt("AnchorPosition") < 0) goto L22;
        boolean r15 = this.mCurrentPendingSavedState.getBoolean("AnchorLayoutFromEnd");
        r11.mLayoutFromEnd = r15;
        if (r15 == false) goto L19;
        r11.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mCurrentPendingSavedState.getInt("AnchorOffset");
    L20:
        return true;
    L19:
        r11.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mCurrentPendingSavedState.getInt("AnchorOffset");
    L22:
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) goto L54;
        View r16 = findViewByPosition(this.mCurrentPendingScrollPosition);
        if (r16 == null) goto L43;
        if (this.mOrientationHelper.getDecoratedMeasurement(r16) <= this.mOrientationHelper.getTotalSpace()) goto L30;
        r11.assignCoordinateFromPadding();
        return true;
    L30:
        if ((this.mOrientationHelper.getDecoratedStart(r16) - this.mOrientationHelper.getStartAfterPadding()) >= 0) goto L34;
        r11.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
        r11.mLayoutFromEnd = false;
        return true;
    L34:
        if ((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r16)) >= 0) goto L38;
        r11.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
        r11.mLayoutFromEnd = true;
        return true;
    L38:
        if (r11.mLayoutFromEnd == false) goto L40;
        int r17 = this.mOrientationHelper.getDecoratedEnd(r16) + this.mOrientationHelper.getTotalSpaceChange();
    L41:
        r11.mCoordinate = r17;
    L53:
        return true;
    L40:
        r17 = this.mOrientationHelper.getDecoratedStart(r16);
        goto L41
    L43:
        if (getChildCount() > 0) goto L45;
    L52:
        r11.assignCoordinateFromPadding();
        goto L53
    L45:
        if (this.mCurrentPendingScrollPosition >= getPosition(getChildAt(0))) goto L47;
        boolean r18 = true;
    L49:
        if (r18 != this.mShouldReverseLayoutExpose) goto L51;
        r12 = true;
    L51:
        r11.mLayoutFromEnd = r12;
        goto L52
    L47:
        r18 = false;
        goto L49
    L54:
        boolean r19 = this.mShouldReverseLayoutExpose;
        r11.mLayoutFromEnd = r19;
        if (r19 == false) goto L57;
        r11.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
    L58:
        return true;
    L57:
        r11.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
    L60:
        return false;
    }

    private void updateAnchorInfoForLayoutExpose(RecyclerView.State r10, AnchorInfo r11) {
        if (updateAnchorFromPendingDataExpose(r10, r11) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildrenExpose(r10, r11) == false) goto L8;
        return;
    L8:
        r11.assignCoordinateFromPadding();
        if (getStackFromEnd() == false) goto L11;
        int r12 = r10.c() - 1;
    L12:
        r11.mPosition = r12;
        return;
    L11:
        r12 = 0;
        goto L12
    }

    private void updateLayoutStateToFillEndExpose(AnchorInfo r10) {
        updateLayoutStateToFillEndExpose(r10.mPosition, r10.mCoordinate);
    }

    private void updateLayoutStateToFillStartExpose(AnchorInfo r10) {
        updateLayoutStateToFillStartExpose(r10.mPosition, r10.mCoordinate);
    }

    private void validateChildOrderExpose() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean r10 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        int r11 = getPosition(getChildAt(0));
        int r12 = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayoutExpose == false) goto L22;
        int r13 = 1;
    L9:
        if (r13 >= getChildCount()) goto L37;
        View r14 = getChildAt(r13);
        int r15 = getPosition(r14);
        int r16 = this.mOrientationHelper.getDecoratedStart(r14);
        if (r15 < r11) goto L12;
        if (r16 > r12) goto L20;
        r13 = r13 + 1;
        goto L9
    L20:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L12:
        logChildren();
        StringBuilder r17 = new StringBuilder();
        r17.append("detected invalid position. loc invalid? ");
        if (r16 < r12) goto L16;
        r10 = false;
    L16:
        r17.append(r10);
        throw new RuntimeException(r17.toString());
    L37:
        return;
    L22:
        int r18 = 1;
    L24:
        if (r18 >= getChildCount()) goto L44;
        View r19 = getChildAt(r18);
        int r20 = getPosition(r19);
        int r21 = this.mOrientationHelper.getDecoratedStart(r19);
        if (r20 < r11) goto L27;
        if (r21 < r12) goto L35;
        r18 = r18 + 1;
        goto L24
    L35:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L27:
        logChildren();
        StringBuilder r22 = new StringBuilder();
        r22.append("detected invalid position. loc invalid? ");
        if (r21 < r12) goto L31;
        r10 = false;
    L31:
        r22.append(r10);
        throw new RuntimeException(r22.toString());
    }

    public void addHiddenView(View r10, boolean r11) {
        if (r11 == false) goto L4;
        int r12 = 0;
    L5:
        addView(r10, r12);
        this.mChildHelperWrapper.hide(r10);
        return;
    L4:
        r12 = -1;
        goto L5
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r10) {
        if (this.mCurrentPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r10);
        return;
    }

    public int computeAlignOffset(int r10, boolean r11, boolean r12) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r10) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r11 = false;
        int r12 = 1;
        if (r10 >= getPosition(getChildAt(0))) goto L10;
        r11 = true;
    L10:
        if (r11 == this.mShouldReverseLayoutExpose) goto L13;
        r12 = -1;
    L13:
        if (getOrientation() != 0) goto L17;
        return new PointF(r12, 0.0f);
    L17:
        return new PointF(0.0f, r12);
    }

    public void ensureLayoutStateExpose() {
        if (this.mLayoutState != null) goto L6;
        this.mLayoutState = new LayoutState();
    L6:
        if (this.mOrientationHelper != null) goto L17;
        this.mOrientationHelper = OrientationHelperEx.createOrientationHelper(this, getOrientation());
    L17:
        this.mEnsureLayoutStateMethod.invoke(this, this.emptyArgs);     // Catch: InvocationTargetException -> L10 IllegalAccessException -> L12
    L20:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public int fill(RecyclerView.Recycler r10, LayoutState r11, RecyclerView.State r12, boolean r13) {
        int r14 = r11.mAvailable;
        int r15 = r11.mScrollingOffset;
        if (r15 == Integer.MIN_VALUE) goto L7;
        if (r14 >= 0) goto L6;
        r11.mScrollingOffset = r15 + r14;
    L6:
        recycleByLayoutStateExpose(r10, r11);
    L7:
        int r16 = r11.mAvailable + r11.mExtra;
        if (r11.mLayoutDirection != (-1)) goto L10;
        int r17 = 0;
    L11:
        int r18 = r16 + r17;
    L12:
        if (r18 <= 0) goto L35;
        if (r11.hasMore(r12) == false) goto L35;
        this.layoutChunkResultCache.resetInternal();
        layoutChunk(r10, r12, r11, this.layoutChunkResultCache);
        LayoutChunkResult r19 = this.layoutChunkResultCache;
        if (r19.mFinished == true) goto L35;
        r11.mOffset += r19.mConsumed * r11.mLayoutDirection;
        if (r19.mIgnoreConsumed == true) goto L21;
    L24:
        int r20 = r11.mAvailable;
        int r21 = this.layoutChunkResultCache.mConsumed;
        r11.mAvailable = r20 - r21;
        r18 = r18 - r21;
    L25:
        int r22 = r11.mScrollingOffset;
        if (r22 == Integer.MIN_VALUE) goto L31;
        int r23 = r22 + this.layoutChunkResultCache.mConsumed;
        r11.mScrollingOffset = r23;
        int r24 = r11.mAvailable;
        if (r24 >= 0) goto L30;
        r11.mScrollingOffset = r23 + r24;
    L30:
        recycleByLayoutStateExpose(r10, r11);
    L31:
        if (r13 == false) goto L12;
        if (this.layoutChunkResultCache.mFocusable == false) goto L12;
    L21:
        if (this.mLayoutState.mScrapList != null) goto L24;
        if (r12.f() == true) goto L25;
    L35:
        return r14 - r11.mAvailable;
    L10:
        r17 = this.recycleOffset;
        goto L11
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findFirstVisibleItemPosition() {
        ensureLayoutStateExpose();
        return super.findFirstVisibleItemPosition();
    }

    public View findHiddenView(int r10) {
        return this.mChildHelperWrapper.findHiddenNonRemovedView(r10, -1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public int findLastVisibleItemPosition() {
        ensureLayoutStateExpose();
        return super.findLastVisibleItemPosition();
    L5:
        e = move-exception;
        Log.d("LastItem", "itemCount: " + getItemCount());
        Log.d("LastItem", "childCount: " + getChildCount());
        Log.d("LastItem", "child: " + getChildAt(getChildCount() + (-1)));
        Log.d("LastItem", "RV childCount: " + this.mRecyclerView.getChildCount());
        Log.d("LastItem", "RV child: " + this.mRecyclerView.getChildAt(this.mRecyclerView.getChildCount() + (-1)));
        throw e;
    }

    public void hideView(View r10) {
        this.mChildHelperWrapper.hide(r10);
    }

    public boolean isEnableMarginOverLap() {
        return false;
    }

    public boolean isHidden(View r10) {
        return this.mChildHelperWrapper.isHidden(r10);
    }

    public void layoutChunk(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutState r12, LayoutChunkResult r13) {
        View r14 = r12.next(r10);
        if (r14 != null) goto L6;
        r13.mFinished = true;
        return;
    L6:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r12.mScrapList != null) goto L15;
        boolean r16 = this.mShouldReverseLayoutExpose;
        if (r12.mLayoutDirection != (-1)) goto L11;
        boolean r17 = true;
    L12:
        if (r16 != r17) goto L14;
        addView(r14);
    L22:
        measureChildWithMargins(r14, 0, 0);
        r13.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(r14);
        if (getOrientation() == 1) goto L25;
        int r18 = getPaddingTop();
        int r19 = this.mOrientationHelper.getDecoratedMeasurementInOther(r14) + r18;
        if (r12.mLayoutDirection != (-1)) goto L35;
        int r110 = r12.mOffset;
        int r20 = r110 - r13.mConsumed;
        int r21 = r110;
        int r111 = r19;
        int r22 = r20;
        int r23 = r18;
    L36:
        layoutDecorated(r14, r22 + ((ViewGroup.MarginLayoutParams) r15).leftMargin, ((ViewGroup.MarginLayoutParams) r15).topMargin + r23, r21 - ((ViewGroup.MarginLayoutParams) r15).rightMargin, r111 - ((ViewGroup.MarginLayoutParams) r15).bottomMargin);
        if (r15.isItemRemoved() == false) goto L39;
    L40:
        r13.mIgnoreConsumed = true;
    L41:
        r13.mFocusable = r14.isFocusable();
        return;
    L39:
        if (r15.isItemChanged() == false) goto L41;
    L35:
        int r112 = r12.mOffset;
        int r24 = r13.mConsumed + r112;
        r22 = r112;
        r111 = r19;
        r23 = r18;
        r21 = r24;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        r21 = getWidth() - getPaddingRight();
        r22 = r21 - this.mOrientationHelper.getDecoratedMeasurementInOther(r14);
    L29:
        if (r12.mLayoutDirection != (-1)) goto L31;
        r111 = r12.mOffset;
        r23 = r111 - r13.mConsumed;
        goto L36
    L31:
        r23 = r12.mOffset;
        r111 = r13.mConsumed + r23;
        goto L36
    L27:
        r22 = getPaddingLeft();
        r21 = this.mOrientationHelper.getDecoratedMeasurementInOther(r14) + r22;
        goto L29
    L14:
        addView(r14, 0);
        goto L22
    L11:
        r17 = false;
        goto L12
    L15:
        boolean r25 = this.mShouldReverseLayoutExpose;
        if (r12.mLayoutDirection != (-1)) goto L18;
        boolean r26 = true;
    L19:
        if (r25 != r26) goto L21;
        addDisappearingView(r14);
        goto L22
    L21:
        addDisappearingView(r14, 0);
        goto L22
    L18:
        r26 = false;
        goto L19
    }

    public void onAnchorReady(RecyclerView.State r10, AnchorInfo r11) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView r10) {
        super.onAttachedToWindow(r10);
        this.mRecyclerView = r10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r10, RecyclerView.Recycler r11) {
        super.onDetachedFromWindow(r10, r11);
        this.mRecyclerView = null;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13) {
        myResolveShouldLayoutReverse();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r14 = convertFocusDirectionToLayoutDirectionExpose(r11);
        if (r14 != Integer.MIN_VALUE) goto L9;
        return null;
    L9:
        if (r14 != (-1)) goto L11;
        View r15 = myFindReferenceChildClosestToStart(r13);
    L12:
        if (r15 != null) goto L14;
        return null;
    L14:
        ensureLayoutStateExpose();
        updateLayoutStateExpose(r14, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, r13);
        LayoutState r16 = this.mLayoutState;
        r16.mScrollingOffset = Integer.MIN_VALUE;
        r16.mRecycle = false;
        r16.mOnRefresLayout = false;
        fill(r12, r16, r13, true);
        if (r14 != (-1)) goto L17;
        View r17 = getChildClosestToStartExpose();
    L18:
        if (r17 != r15) goto L20;
    L23:
        return null;
    L20:
        if (r17.isFocusable() == false) goto L23;
        return r17;
    L17:
        r17 = getChildClosestToEndExpose();
        goto L18
    L11:
        r15 = myFindReferenceChildClosestToEnd(r13);
        goto L12
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r11, RecyclerView.State r12) {
        Bundle r10 = this.mCurrentPendingSavedState;
        if (r10 != null) goto L5;
    L7:
        ensureLayoutStateExpose();
        this.mLayoutState.mRecycle = false;
        myResolveShouldLayoutReverse();
        this.mAnchorInfo.reset();
        this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayoutExpose ^ getStackFromEnd();
        updateAnchorInfoForLayoutExpose(r12, this.mAnchorInfo);
        int r13 = getExtraLayoutSpace(r12);
        if (r12.d() >= this.mAnchorInfo.mPosition) goto L10;
        boolean r14 = true;
    L12:
        if (r14 != this.mShouldReverseLayoutExpose) goto L14;
        int r15 = r13;
        r13 = 0;
    L15:
        int r16 = r13 + this.mOrientationHelper.getStartAfterPadding();
        int r17 = r15 + this.mOrientationHelper.getEndPadding();
        if (r12.f() == false) goto L31;
        int r18 = this.mCurrentPendingScrollPosition;
        if (r18 == (-1)) goto L31;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L31;
        View r19 = findViewByPosition(r18);
        if (r19 == null) goto L31;
        if (this.mShouldReverseLayoutExpose == false) goto L27;
        int r20 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r19);
        int r21 = this.mPendingScrollPositionOffset;
    L26:
        int r22 = r20 - r21;
        if (r22 <= 0) goto L30;
        r16 = r16 + r22;
        goto L31
    L30:
        r17 = r17 - r22;
        goto L31
    L27:
        r21 = this.mOrientationHelper.getDecoratedStart(r19) - this.mOrientationHelper.getStartAfterPadding();
        r20 = this.mPendingScrollPositionOffset;
    L31:
        onAnchorReady(r12, this.mAnchorInfo);
        detachAndScrapAttachedViews(r11);
        this.mLayoutState.mIsPreLayout = r12.f();
        this.mLayoutState.mOnRefresLayout = true;
        AnchorInfo r23 = this.mAnchorInfo;
        if (r23.mLayoutFromEnd == false) goto L37;
        updateLayoutStateToFillStartExpose(r23);
        LayoutState r24 = this.mLayoutState;
        r24.mExtra = r16;
        fill(r11, r24, r12, false);
        LayoutState r25 = this.mLayoutState;
        int r26 = r25.mOffset;
        int r27 = r25.mAvailable;
        if (r27 <= 0) goto L36;
        r17 = r17 + r27;
    L36:
        updateLayoutStateToFillEndExpose(this.mAnchorInfo);
        LayoutState r28 = this.mLayoutState;
        r28.mExtra = r17;
        r28.mCurrentPosition += r28.mItemDirection;
        fill(r11, r28, r12, false);
        int r29 = this.mLayoutState.mOffset;
    L42:
        if (getChildCount() > 0) goto L44;
    L48:
        layoutForPredictiveAnimationsExpose(r11, r12, r26, r29);
        if (r12.f() == true) goto L51;
        this.mCurrentPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mOrientationHelper.onLayoutComplete();
    L51:
        this.mLastStackFromEnd = getStackFromEnd();
        this.mCurrentPendingSavedState = null;
        return;
    L44:
        if ((this.mShouldReverseLayoutExpose ^ getStackFromEnd()) == false) goto L47;
        int r30 = fixLayoutEndGapExpose(r29, r11, r12, true);
        int r31 = r26 + r30;
        int r32 = r29 + r30;
        int r33 = fixLayoutStartGapExpose(r31, r11, r12, false);
    L46:
        r26 = r31 + r33;
        r29 = r32 + r33;
        goto L48
    L47:
        int r34 = fixLayoutStartGapExpose(r26, r11, r12, true);
        r31 = r26 + r34;
        r32 = r29 + r34;
        r33 = fixLayoutEndGapExpose(r32, r11, r12, false);
        goto L46
    L37:
        updateLayoutStateToFillEndExpose(r23);
        LayoutState r35 = this.mLayoutState;
        r35.mExtra = r17;
        fill(r11, r35, r12, false);
        LayoutState r36 = this.mLayoutState;
        int r37 = r36.mOffset;
        int r38 = r36.mAvailable;
        if (r38 <= 0) goto L40;
        r16 = r16 + r38;
    L40:
        updateLayoutStateToFillStartExpose(this.mAnchorInfo);
        LayoutState r39 = this.mLayoutState;
        r39.mExtra = r16;
        r39.mCurrentPosition += r39.mItemDirection;
        fill(r11, r39, r12, false);
        r26 = this.mLayoutState.mOffset;
        r29 = r37;
        goto L42
    L14:
        r15 = 0;
        goto L15
    L10:
        r14 = false;
        goto L12
    L5:
        if (r10.getInt("AnchorPosition") < 0) goto L7;
        this.mCurrentPendingScrollPosition = this.mCurrentPendingSavedState.getInt("AnchorPosition");
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof Bundle) == false) goto L6;
        this.mCurrentPendingSavedState = (Bundle) r10;
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mCurrentPendingSavedState != null) goto L5;
        Bundle r10 = new Bundle();
        if (getChildCount() <= 0) goto L12;
        boolean r11 = this.mLastStackFromEnd ^ this.mShouldReverseLayoutExpose;
        r10.putBoolean("AnchorLayoutFromEnd", r11);
        if (r11 == false) goto L11;
        View r12 = getChildClosestToEndExpose();
        r10.putInt("AnchorOffset", this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r12));
        r10.putInt("AnchorPosition", getPosition(r12));
    L13:
        return r10;
    L11:
        View r13 = getChildClosestToStartExpose();
        r10.putInt("AnchorPosition", getPosition(r13));
        r10.putInt("AnchorOffset", this.mOrientationHelper.getDecoratedStart(r13) - this.mOrientationHelper.getStartAfterPadding());
        goto L13
    L12:
        r10.putInt("AnchorPosition", -1);
        goto L13
    L5:
        return new Bundle(this.mCurrentPendingSavedState);
    }

    public void recycleChildren(RecyclerView.Recycler r10, int r11, int r12) {
        if (r11 != r12) goto L4;
        return;
    L4:
        if (r12 <= r11) goto L8;
        int r13 = r12 - 1;
    L6:
        if (r13 < r11) goto L10;
        removeAndRecycleViewAt(r13, r10);
        r13 = r13 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r11 <= r12) goto L13;
        removeAndRecycleViewAt(r11, r10);
        r11 = r11 - 1;
        goto L8
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getOrientation() != 1) goto L7;
        return 0;
    L7:
        return scrollInternalBy(r10, r11, r12);
    }

    public int scrollInternalBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getChildCount() == 0) goto L17;
        if (r10 == 0) goto L17;
        this.mLayoutState.mRecycle = true;
        ensureLayoutStateExpose();
        if (r10 <= 0) goto L9;
        int r13 = 1;
    L10:
        int r14 = Math.abs(r10);
        updateLayoutStateExpose(r13, r14, true, r12);
        LayoutState r15 = this.mLayoutState;
        int r16 = r15.mScrollingOffset;
        r15.mOnRefresLayout = false;
        int r17 = r16 + fill(r11, r15, r12, false);
        if (r17 >= 0) goto L13;
        return 0;
    L13:
        if (r14 <= r17) goto L15;
        r10 = r13 * r17;
    L15:
        this.mOrientationHelper.offsetChildren(-r10);
        return r10;
    L9:
        r13 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r10) {
        this.mCurrentPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        Bundle r11 = this.mCurrentPendingSavedState;
        if (r11 == null) goto L5;
        r11.putInt("AnchorPosition", -1);
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int r10, int r11) {
        this.mCurrentPendingScrollPosition = r10;
        this.mPendingScrollPositionOffset = r11;
        Bundle r12 = this.mCurrentPendingSavedState;
        if (r12 == null) goto L5;
        r12.putInt("AnchorPosition", -1);
    L5:
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        if (getOrientation() != 0) goto L7;
        return 0;
    L7:
        return scrollInternalBy(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int r10) {
        super.setOrientation(r10);
        this.mOrientationHelper = null;
    }

    public void setRecycleOffset(int r10) {
        this.recycleOffset = r10;
    }

    public void showView(View r10) {
        this.mChildHelperWrapper.show(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mCurrentPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastStackFromEnd != getStackFromEnd()) goto L7;
        return true;
    }

    public void updateLayoutStateExpose(int r10, int r11, boolean r12, RecyclerView.State r13) {
        this.mLayoutState.mExtra = getExtraLayoutSpace(r13);
        LayoutState r14 = this.mLayoutState;
        r14.mLayoutDirection = r10;
        int r15 = -1;
        if (r10 != 1) goto L9;
        r14.mExtra += this.mOrientationHelper.getEndPadding();
        View r16 = getChildClosestToEndExpose();
        LayoutState r17 = this.mLayoutState;
        if (this.mShouldReverseLayoutExpose == true) goto L8;
        r15 = 1;
    L8:
        r17.mItemDirection = r15;
        int r18 = getPosition(r16);
        LayoutState r19 = this.mLayoutState;
        r17.mCurrentPosition = r18 + r19.mItemDirection;
        r19.mOffset = this.mOrientationHelper.getDecoratedEnd(r16) + computeAlignOffset(r16, true, false);
        int r20 = this.mLayoutState.mOffset - this.mOrientationHelper.getEndAfterPadding();
    L13:
        LayoutState r21 = this.mLayoutState;
        r21.mAvailable = r11;
        if (r12 == false) goto L16;
        r21.mAvailable = r11 - r20;
    L16:
        r21.mScrollingOffset = r20;
        return;
    L9:
        View r22 = getChildClosestToStartExpose();
        this.mLayoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
        LayoutState r23 = this.mLayoutState;
        if (this.mShouldReverseLayoutExpose == false) goto L12;
        r15 = 1;
    L12:
        r23.mItemDirection = r15;
        int r24 = getPosition(r22);
        LayoutState r25 = this.mLayoutState;
        r23.mCurrentPosition = r24 + r25.mItemDirection;
        r25.mOffset = this.mOrientationHelper.getDecoratedStart(r22) + computeAlignOffset(r22, false, false);
        r20 = (-this.mLayoutState.mOffset) + this.mOrientationHelper.getStartAfterPadding();
        goto L13
    }

    public ExposeLinearLayoutManagerEx(Context r10, int r11, boolean r12) {
        super(r10, r11, r12);
        this.mShouldReverseLayoutExpose = false;
        this.mCurrentPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mCurrentPendingSavedState = null;
        this.emptyArgs = new Object[0];
        this.layoutChunkResultCache = new LayoutChunkResult();
        this.mAnchorInfo = new AnchorInfo(this);
        setOrientation(r11);
        setReverseLayout(r12);
        this.mChildHelperWrapper = new ChildHelperWrapper(this, this);
        Method r13 = LinearLayoutManager.class.getDeclaredMethod("ensureLayoutState", null);     // Catch: NoSuchMethodException -> L8
        this.mEnsureLayoutStateMethod = r13;     // Catch: NoSuchMethodException -> L8
        r13.setAccessible(true);     // Catch: NoSuchMethodException -> L8
        Method r14 = RecyclerView.LayoutManager.class.getDeclaredMethod("setItemPrefetchEnabled", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L11
        if (r14 == null) goto L16;
        r14.invoke(this, new Object[]{Boolean.FALSE});     // Catch: Throwable -> L11
        return;
    L16:
        return;
    L17:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        throw new RuntimeException(e);
    }

    private void updateLayoutStateToFillEndExpose(int r10, int r11) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - r11;
        LayoutState r12 = this.mLayoutState;
        if (this.mShouldReverseLayoutExpose == false) goto L5;
        int r13 = -1;
    L6:
        r12.mItemDirection = r13;
        r12.mCurrentPosition = r10;
        r12.mLayoutDirection = 1;
        r12.mOffset = r11;
        r12.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r13 = 1;
        goto L6
    }

    private void updateLayoutStateToFillStartExpose(int r10, int r11) {
        this.mLayoutState.mAvailable = r11 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState r12 = this.mLayoutState;
        r12.mCurrentPosition = r10;
        if (this.mShouldReverseLayoutExpose == false) goto L5;
        int r13 = 1;
    L6:
        r12.mItemDirection = r13;
        r12.mLayoutDirection = -1;
        r12.mOffset = r11;
        r12.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r13 = -1;
        goto L6
    }

    public int computeAlignOffset(View r10, boolean r11, boolean r12) {
        return 0;
    }
}
