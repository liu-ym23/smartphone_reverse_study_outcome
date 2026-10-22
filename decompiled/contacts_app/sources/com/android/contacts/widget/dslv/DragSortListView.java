package com.android.contacts.widget.dslv;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import com.android.contacts.ListViewCollapseRunner;
import com.android.contacts.MultiDeleteAnimation;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.CubicInterpolator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DragSortListView extends QuickContactListView implements MultiDeleteAnimation.MultiDeleteAnimationOperator {
    private static final int DRAGGING = 4;
    public static final int DRAG_NEG_X = 2;
    public static final int DRAG_NEG_Y = 8;
    public static final int DRAG_POS_X = 1;
    public static final int DRAG_POS_Y = 4;
    private static final int DROPPING = 2;
    private static final int IDLE = 0;
    private static final int MOVING = 5;
    private static final int NO_CANCEL = 0;
    private static final int ON_INTERCEPT_TOUCH_EVENT = 2;
    private static final int ON_TOUCH_EVENT = 1;
    private static final int REMOVING = 1;
    public static final int SELECT_STATE_CANCEL = 0;
    public static final int SELECT_STATE_OK = 1;
    private static final int STOPPED = 3;
    private static final String TAG = "DragSortListView";
    private static final int sCacheSize = 3;
    private final float SPEED_CARDINAL;
    private boolean downItemChecked;
    private AdapterWrapper mAdapterWrapper;
    private boolean mAnimate;
    private boolean mBlockLayoutRequests;
    private MotionEvent mCancelEvent;
    private int mCancelMethod;
    private int mCheckBoxId;
    private HeightCache mChildHeightCache;
    private ListViewCollapseRunner mCollapseRunner;
    private DragSortController mController;
    private float mCurrFloatAlpha;
    private Point mCurrPoint;
    private Point mDownPoint;
    private int mDownScrollStartY;
    private float mDownScrollStartYF;
    private int mDragDeltaX;
    private int mDragDeltaY;
    private float mDragDownScrollHeight;
    private float mDragDownScrollStartFrac;
    private boolean mDragEnabled;
    private int mDragFlags;
    private DragListener mDragListener;
    private DragScroller mDragScroller;
    private DragSortTracker mDragSortTracker;
    private DragStartListener mDragStartListener;
    private int mDragStartY;
    private int mDragState;
    private float mDragUpScrollHeight;
    private float mDragUpScrollStartFrac;
    private DropAnimator mDropAnimator;
    private DropListener mDropListener;
    private int mFirstExpPos;
    private float mFloatAlpha;
    private Point mFloatLoc;
    private int mFloatPos;
    private View mFloatView;
    private int mFloatViewHeight;
    private int mFloatViewHeightHalf;
    private boolean mFloatViewInvalidated;
    private FloatViewManager mFloatViewManager;
    private int mFloatViewMid;
    private boolean mFloatViewOnMeasured;
    private boolean mIgnoreTouchEvent;
    private boolean mInTouchEvent;
    public boolean mIsDoningAnimation;
    private int mItemHeightCollapsed;
    private boolean mLastCallWasIntercept;
    private int mLastX;
    private int mLastY;
    private boolean mListViewIntercepted;
    private float mMaxScrollSpeed;
    private MoveListener mMoveListener;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private int mPrePosition;
    private RemoveAnimator mRemoveAnimator;
    private RemoveListener mRemoveListener;
    private float mRemoveVelocityX;
    private View[] mSampleViewTypes;
    private DragScrollProfile mScrollProfile;
    private int mSecondExpPos;
    private float mSelectDownScrollStartFrac;
    private float mSelectDownScrollStartY;
    private SelectScroller mSelectScroller;
    private int mSelectState;
    private float mSelectUpScrollStartFrac;
    private float mSelectUpScrollStartY;
    private float mSlideFrac;
    private float mSlideRegionFrac;
    private int mSrcPos;
    private Point mTouchLoc;
    private boolean mTrackDragSort;
    private int mUpScrollStartY;
    private float mUpScrollStartYF;
    private boolean mUseRemoveVelocity;
    private int mWidthMeasureSpec;
    private int mX;
    private int mY;

    private class AdapterWrapper extends BaseAdapter {
        private ListAdapter mAdapter;
        final /* synthetic */ DragSortListView this$0;

        public AdapterWrapper(final DragSortListView r2, ListAdapter r3) {
            this.this$0 = r2;
            this.mAdapter = r3;
            r3.registerDataSetObserver(new AnonymousClass1(this, r2));
        }

        public ListAdapter getAdapter() {
            return this.mAdapter;
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return this.mAdapter.getItemId(r1);
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return this.mAdapter.getItem(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mAdapter.getCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return this.mAdapter.areAllItemsEnabled();
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int r1) {
            return this.mAdapter.isEnabled(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int r1) {
            return this.mAdapter.getItemViewType(r1);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return this.mAdapter.getViewTypeCount();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return this.mAdapter.hasStableIds();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean isEmpty() {
            return this.mAdapter.isEmpty();
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            if (r5 == null) goto L8;
            DragSortItemView r7 = (DragSortItemView) r5;
            View r0 = r7.getChildAt(0);
            View r1 = this.mAdapter.getView(r4, r0, this.this$0);
            if (r1 == r0) goto L13;
            if (r0 == null) goto L7;
            r7.removeViewAt(0);
        L7:
            r7.addView(r1);
        L13:
            DragSortListView r3 = this.this$0;
            DragSortListView.access$300(r3, r4 + r3.getHeaderViewsCount(), r7, true);
            return r7;
        L8:
            View r8 = this.mAdapter.getView(r4, null, this.this$0);
            if ((r8 instanceof Checkable) == false) goto L11;
            DragSortItemView r9 = new ObricDragSortItemCheckableView(this.this$0.getContext());
        L12:
            r9.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            r9.addView(r8);
            r7 = r9;
            goto L13
        L11:
            r9 = new DragSortItemView(this.this$0.getContext());
            goto L12
        }
    }

    public interface DragListener {
        void drag(int r1, int r2);
    }

    public interface DragScrollProfile {
        float getSpeed(float r1, long r2);
    }

    private class DragScroller implements Runnable {
        public static final int DOWN = 1;
        public static final int STOP = -1;
        public static final int UP = 0;
        private float dt;
        private int dy;
        private boolean mAbort;
        private long mCurrTime;
        private int mFirstFooter;
        private int mLastHeader;
        private long mPrevTime;
        private float mScrollSpeed;
        private boolean mScrolling;
        private int scrollDir;
        private long tStart;
        final /* synthetic */ DragSortListView this$0;

        public boolean isScrolling() {
            return this.mScrolling;
        }

        public int getScrollDir() {
            if (this.mScrolling == true) goto L7;
            return -1;
        L7:
            return this.scrollDir;
        }

        public DragScroller(DragSortListView r1) {
            this.this$0 = r1;
            this.mScrolling = false;
        }

        public void startScrolling(int r3) {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DragSortListView.TAG, "startScrolling....................");
        L6:
            if (this.mScrolling == true) goto L9;
            this.mAbort = false;
            this.mScrolling = true;
            long r0 = SystemClock.uptimeMillis();
            this.tStart = r0;
            this.mPrevTime = r0;
            this.scrollDir = r3;
            this.this$0.post(this);
            return;
        }

        public void stopScrolling(boolean r3) {
            if (ContactsUtils.DEBUG == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DragSortListView.TAG, "stopScrolling....................");
        L5:
            if (r3 == false) goto L7;
            this.this$0.removeCallbacks(this);
            this.mScrolling = false;
            return;
        L7:
            this.mAbort = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAbort == false) goto L6;
            this.mScrolling = false;
            return;
        L6:
            int r0 = this.this$0.getFirstVisiblePosition();
            int r2 = this.this$0.getLastVisiblePosition();
            int r3 = this.this$0.getCount();
            int r4 = this.this$0.getPaddingTop();
            int r5 = (this.this$0.getHeight() - r4) - this.this$0.getPaddingBottom();
            int r6 = Math.min(DragSortListView.access$700(this.this$0), DragSortListView.access$2100(this.this$0) + DragSortListView.access$500(this.this$0));
            int r7 = Math.max(DragSortListView.access$700(this.this$0), DragSortListView.access$2100(this.this$0) - DragSortListView.access$500(this.this$0));
            if (this.scrollDir != 0) goto L18;
            View r8 = this.this$0.getChildAt(0);
            if (r8 != null) goto L12;
            this.mScrolling = false;
            return;
        L12:
            if (r0 == 0) goto L14;
        L17:
            this.mScrollSpeed = DragSortListView.access$2400(this.this$0).getSpeed((DragSortListView.access$2200(this.this$0) - r7) / DragSortListView.access$2300(this.this$0), this.mPrevTime);
        L29:
            long r9 = SystemClock.uptimeMillis();
            this.mCurrTime = r9;
            float r10 = r9 - this.mPrevTime;
            this.dt = r10;
            int r11 = Math.round(this.mScrollSpeed * r10);
            this.dy = r11;
            if (r11 < 0) goto L32;
            this.dy = Math.min(r5, r11);
            r2 = r0;
        L33:
            View r1 = this.this$0.getChildAt(r2 - r0);
            int r12 = r1.getTop() + this.dy;
            if (r2 != 0) goto L37;
            if (r12 <= r4) goto L37;
            r12 = r4;
        L37:
            DragSortListView.access$2702(this.this$0, true);
            this.this$0.setSelectionFromTop(r2, r12 - r4);
            this.this$0.layoutChildren();
            this.this$0.invalidate();
            DragSortListView.access$2702(this.this$0, false);
            DragSortListView.access$2800(this.this$0, r2, r1, false);
            this.mPrevTime = this.mCurrTime;
            this.this$0.post(this);
            return;
        L32:
            this.dy = Math.max(-r5, r11);
            goto L33
        L14:
            if (r8.getTop() != r4) goto L17;
            this.mScrolling = false;
            return;
        L18:
            View r13 = this.this$0.getChildAt(r2 - r0);
            if (r13 != null) goto L23;
            this.mScrolling = false;
            return;
        L23:
            if (r2 == (r3 - 1)) goto L25;
        L28:
            this.mScrollSpeed = -DragSortListView.access$2400(this.this$0).getSpeed((r6 - DragSortListView.access$2500(this.this$0)) / DragSortListView.access$2600(this.this$0), this.mPrevTime);
            goto L29
        L25:
            if (r13.getBottom() > (r5 + r4)) goto L28;
            this.mScrolling = false;
        }
    }

    public interface DragSortListener extends DropListener, DragListener, RemoveListener {
    }

    private class DragSortTracker {
        StringBuilder mBuilder;
        File mFile;
        private int mNumFlushes;
        private int mNumInBuffer;
        private boolean mTracking;
        final /* synthetic */ DragSortListView this$0;

        public DragSortTracker(DragSortListView r4) {
            this.this$0 = r4;
            this.mBuilder = new StringBuilder();
            this.mNumInBuffer = 0;
            this.mNumFlushes = 0;
            this.mTracking = false;
            File r1 = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
            this.mFile = r1;
            if (r1.exists() == true) goto L13;
            this.mFile.createNewFile();     // Catch: IOException -> L8
            if (ContactsUtils.DEBUG == false) goto L14;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("mobeta", "file created");     // Catch: IOException -> L8
            return;
        L14:
            return;
        L8:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("mobeta", "Could not create dslv_state.txt");
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("mobeta", e.getMessage());
            return;
        }

        public void startTracking() {
            this.mBuilder.append("<DSLVStates>\n");
            this.mNumFlushes = 0;
            this.mTracking = true;
        }

        public void appendState() {
            if (this.mTracking == true) goto L5;
            return;
        L5:
            this.mBuilder.append("<DSLVState>\n");
            int r0 = this.this$0.getChildCount();
            int r1 = this.this$0.getFirstVisiblePosition();
            this.mBuilder.append("    <Positions>");
            int r3 = 0;
        L7:
            if (r3 >= r0) goto L9;
            this.mBuilder.append(r1 + r3).append(SimContactsConstants.EMAIL_SEP);
            r3 = r3 + 1;
            goto L7
        L9:
            this.mBuilder.append("</Positions>\n");
            this.mBuilder.append("    <Tops>");
            int r4 = 0;
        L10:
            if (r4 >= r0) goto L12;
            this.mBuilder.append(this.this$0.getChildAt(r4).getTop()).append(SimContactsConstants.EMAIL_SEP);
            r4 = r4 + 1;
            goto L10
        L12:
            this.mBuilder.append("</Tops>\n");
            this.mBuilder.append("    <Bottoms>");
            int r5 = 0;
        L13:
            if (r5 >= r0) goto L15;
            this.mBuilder.append(this.this$0.getChildAt(r5).getBottom()).append(SimContactsConstants.EMAIL_SEP);
            r5 = r5 + 1;
            goto L13
        L15:
            this.mBuilder.append("</Bottoms>\n");
            this.mBuilder.append("    <FirstExpPos>").append(DragSortListView.access$1400(this.this$0)).append("</FirstExpPos>\n");
            StringBuilder r6 = this.mBuilder.append("    <FirstExpBlankHeight>");
            DragSortListView r7 = this.this$0;
            int r8 = DragSortListView.access$2900(r7, DragSortListView.access$1400(r7));
            DragSortListView r9 = this.this$0;
            r6.append(r8 - DragSortListView.access$3000(r9, DragSortListView.access$1400(r9))).append("</FirstExpBlankHeight>\n");
            this.mBuilder.append("    <SecondExpPos>").append(DragSortListView.access$1500(this.this$0)).append("</SecondExpPos>\n");
            StringBuilder r10 = this.mBuilder.append("    <SecondExpBlankHeight>");
            DragSortListView r11 = this.this$0;
            int r12 = DragSortListView.access$2900(r11, DragSortListView.access$1500(r11));
            DragSortListView r13 = this.this$0;
            r10.append(r12 - DragSortListView.access$3000(r13, DragSortListView.access$1500(r13))).append("</SecondExpBlankHeight>\n");
            this.mBuilder.append("    <SrcPos>").append(DragSortListView.access$1000(this.this$0)).append("</SrcPos>\n");
            this.mBuilder.append("    <SrcHeight>").append(DragSortListView.access$1200(this.this$0) + this.this$0.getDividerHeight()).append("</SrcHeight>\n");
            this.mBuilder.append("    <ViewHeight>").append(this.this$0.getHeight()).append("</ViewHeight>\n");
            this.mBuilder.append("    <LastY>").append(DragSortListView.access$3100(this.this$0)).append("</LastY>\n");
            this.mBuilder.append("    <FloatY>").append(DragSortListView.access$2100(this.this$0)).append("</FloatY>\n");
            this.mBuilder.append("    <ShuffleEdges>");
            int r14 = 0;
        L16:
            if (r14 >= r0) goto L18;
            StringBuilder r15 = this.mBuilder;
            DragSortListView r16 = this.this$0;
            r15.append(DragSortListView.access$3200(r16, r1 + r14, r16.getChildAt(r14).getTop())).append(SimContactsConstants.EMAIL_SEP);
            r14 = r14 + 1;
            goto L16
        L18:
            this.mBuilder.append("</ShuffleEdges>\n");
            this.mBuilder.append("</DSLVState>\n");
            int r2 = this.mNumInBuffer + 1;
            this.mNumInBuffer = r2;
            if (r2 <= 1000) goto L26;
            flush();
            this.mNumInBuffer = 0;
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.io.FileWriter] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.io.FileWriter] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public void flush() {
            if (this.mTracking == true) goto L5;
            return;
        L5:
            ?? r0 = 0;
            r0 = 0;
            r0 = 0;
        L25:
            e = move-exception;
            e.printStackTrace();
        L39:
            return;
        L20:
            e = e;
        L21:
            e.printStackTrace();     // Catch: Throwable -> L18
            if (r0 == 0) goto L39;
            r0.close();     // Catch: IOException -> L25
            r0 = r0;
        L34:
            goto L39
        L7:
            if (this.mNumFlushes != 0) goto L9;
            boolean r1 = false;
        L10:
            FileWriter r4 = new FileWriter(this.mFile, r1);     // Catch: Throwable -> L18 IOException -> L20
            r4.write(this.mBuilder.toString());     // Catch: Throwable -> L14 IOException -> L16
            StringBuilder r2 = this.mBuilder;     // Catch: Throwable -> L14 IOException -> L16
            r2.delete(0, r2.length());     // Catch: Throwable -> L14 IOException -> L16
            r4.flush();     // Catch: Throwable -> L14 IOException -> L16
            int r3 = this.mNumFlushes + 1;     // Catch: Throwable -> L14 IOException -> L16
            this.mNumFlushes = r3;     // Catch: Throwable -> L14 IOException -> L16
            r4.close();     // Catch: IOException -> L25
            r0 = r3;
            goto L34
        L16:
            e = e;
            r0 = r4;
        L14:
            th = th;
            r0 = r4;
        L28:
            if (r0 != 0) goto L37;
        L33:
            throw th;
        L37:
            r0.close();     // Catch: IOException -> L31
        L31:
            e = move-exception;
            e.printStackTrace();
            goto L33
        L9:
            r1 = true;
        L18:
            th = th;
            goto L28
        }

        public void stopTracking() {
            if (this.mTracking == false) goto L6;
            this.mBuilder.append("</DSLVStates>\n");
            flush();
            this.mTracking = false;
            return;
        }
    }

    public interface DragStartListener {
        void dragStart(int r1);
    }

    private class DropAnimator extends SmoothAnimator {
        private int mDropPos;
        private float mInitDeltaX;
        private float mInitDeltaY;
        private int srcPos;
        final /* synthetic */ DragSortListView this$0;

        public DropAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onStart() {
            this.this$0.mIsDoningAnimation = true;
            this.mDropPos = DragSortListView.access$900(this.this$0);
            this.srcPos = DragSortListView.access$1000(this.this$0);
            DragSortListView.access$202(this.this$0, 2);
            this.mInitDeltaY = DragSortListView.access$600(this.this$0).y - getTargetY();
            this.mInitDeltaX = DragSortListView.access$600(this.this$0).x - this.this$0.getPaddingLeft();
        }

        private int getTargetY() {
            int r0 = this.this$0.getFirstVisiblePosition();
            int r1 = (DragSortListView.access$1100(this.this$0) + this.this$0.getDividerHeight()) / 2;
            View r2 = this.this$0.getChildAt(this.mDropPos - r0);
            if (r2 == null) goto L10;
            int r3 = this.mDropPos;
            int r4 = this.srcPos;
            if (r3 == r4) goto L12;
            if (r3 >= r4) goto L14;
            return r2.getTop() - r1;
        L14:
            return (r2.getBottom() + r1) - DragSortListView.access$1200(this.this$0);
        L12:
            return r2.getTop();
        L10:
            cancel();
            return -1;
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r4, float r5) {
            int r6 = getTargetY();
            int r0 = this.this$0.getPaddingLeft();
            float r1 = DragSortListView.access$600(this.this$0).y - r6;
            float r2 = DragSortListView.access$600(this.this$0).x - r0;
            float r3 = 1.0f - r5;
            if (r3 >= Math.abs(r1 / this.mInitDeltaY)) goto L5;
        L6:
            DragSortListView.access$600(this.this$0).y = r6 + ((int) (this.mInitDeltaY * r3));
            DragSortListView.access$600(this.this$0).x = this.this$0.getPaddingLeft() + ((int) (this.mInitDeltaX * r3));
            DragSortListView.access$800(this.this$0, true);
            return;
        L5:
            if (r3 < Math.abs(r2 / this.mInitDeltaX)) goto L6;
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onStop() {
            this.this$0.mIsDoningAnimation = false;
            DragSortListView.access$1300(this.this$0);
        }
    }

    public interface DropListener {
        void drop(int r1, int r2);
    }

    public interface FloatViewManager {
        int getPaddingBottom();

        int getPaddingTop();

        View onCreateFloatView(int r1);

        void onDestroyFloatView(View r1);

        void onDragFloatView(View r1, Point r2, Point r3);
    }

    private class HeightCache {
        private SparseIntArray mMap;
        private int mMaxSize;
        private ArrayList<Integer> mOrder;
        final /* synthetic */ DragSortListView this$0;

        public HeightCache(DragSortListView r1, int r2) {
            this.this$0 = r1;
            this.mMap = new SparseIntArray(r2);
            this.mOrder = new ArrayList(r2);
            this.mMaxSize = r2;
        }

        public void add(int r4, int r5) {
            int r0 = this.mMap.get(r4, -1);
            if (r0 == r5) goto L11;
            if (r0 == (-1)) goto L6;
            this.mOrder.remove(Integer.valueOf(r4));
        L9:
            this.mMap.put(r4, r5);
            this.mOrder.add(Integer.valueOf(r4));
            return;
        L6:
            if (this.mMap.size() != this.mMaxSize) goto L9;
            this.mMap.delete(this.mOrder.remove(0).intValue());
            goto L9
        }

        public int get(int r2) {
            return this.mMap.get(r2, -1);
        }

        public void clear() {
            this.mMap.clear();
            this.mOrder.clear();
        }
    }

    private class LiftAnimator extends SmoothAnimator {
        private float mFinalDragDeltaY;
        private float mInitDragDeltaY;
        final /* synthetic */ DragSortListView this$0;

        public LiftAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onStart() {
            this.mInitDragDeltaY = DragSortListView.access$400(this.this$0);
            this.mFinalDragDeltaY = DragSortListView.access$500(this.this$0);
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r3, float r4) {
            if (DragSortListView.access$200(this.this$0) == 4) goto L5;
            cancel();
            return;
        L5:
            DragSortListView.access$402(this.this$0, (int) ((this.mFinalDragDeltaY * r4) + ((1.0f - r4) * this.mInitDragDeltaY)));
            Point r5 = DragSortListView.access$600(this.this$0);
            r5.y = DragSortListView.access$700(this.this$0) - DragSortListView.access$400(this.this$0);
            DragSortListView.access$800(this.this$0, true);
        }
    }

    public interface MoveListener {
        void checkTo(int r1, boolean r2);

        boolean isChecked(int r1);
    }

    private class RemoveAnimator extends SmoothAnimator {
        private int mFirstChildHeight;
        private int mFirstPos;
        private float mFirstStartBlank;
        private float mFloatLocX;
        private int mSecondChildHeight;
        private int mSecondPos;
        private float mSecondStartBlank;
        private int srcPos;
        final /* synthetic */ DragSortListView this$0;

        public RemoveAnimator(DragSortListView r1, float r2, int r3) {
            this.this$0 = r1;
            super(r1, r2, r3);
            this.mFirstChildHeight = -1;
            this.mSecondChildHeight = -1;
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onStart() {
            int r0 = -1;
            this.mFirstChildHeight = -1;
            this.mSecondChildHeight = -1;
            this.mFirstPos = DragSortListView.access$1400(this.this$0);
            this.mSecondPos = DragSortListView.access$1500(this.this$0);
            this.srcPos = DragSortListView.access$1000(this.this$0);
            DragSortListView.access$202(this.this$0, 1);
            this.mFloatLocX = DragSortListView.access$600(this.this$0).x;
            if (DragSortListView.access$1600(this.this$0) == false) goto L21;
            float r1 = this.this$0.getWidth() * 2.0f;
            if (DragSortListView.access$1700(this.this$0) != 0.0f) goto L11;
            DragSortListView r3 = this.this$0;
            if (this.mFloatLocX < 0.0f) goto L10;
            r0 = 1;
        L10:
            DragSortListView.access$1702(r3, r0 * r1);
            return;
        L11:
            float r2 = r1 * 2.0f;
            if (DragSortListView.access$1700(this.this$0) >= 0.0f) goto L17;
            float r4 = -r2;
            if (DragSortListView.access$1700(this.this$0) <= r4) goto L17;
            DragSortListView.access$1702(this.this$0, r4);
            return;
        L17:
            if (DragSortListView.access$1700(this.this$0) > 0.0f) goto L19;
            return;
        L19:
            if (DragSortListView.access$1700(this.this$0) >= r2) goto L26;
            DragSortListView.access$1702(this.this$0, r2);
            return;
        L26:
            return;
        L21:
            DragSortListView.access$1800(this.this$0);
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onUpdate(float r10, float r11) {
            float r12 = 1.0f - r11;
            int r13 = this.this$0.getFirstVisiblePosition();
            View r0 = this.this$0.getChildAt(this.mFirstPos - r13);
            if (DragSortListView.access$1600(this.this$0) == false) goto L18;
            float r1 = (SystemClock.uptimeMillis() - this.mStartTime) / 1000.0f;
            if (r1 != 0.0f) goto L7;
            return;
        L7:
            float r5 = DragSortListView.access$1700(this.this$0) * r1;
            int r6 = this.this$0.getWidth();
            DragSortListView r7 = this.this$0;
            if (DragSortListView.access$1700(r7) <= 0.0f) goto L10;
            int r4 = 1;
        L11:
            float r8 = r4 * r1;
            float r2 = r6;
            DragSortListView.access$1716(r7, r8 * r2);
            this.mFloatLocX += r5;
            DragSortListView.access$600(this.this$0).x = (int) this.mFloatLocX;
            float r9 = this.mFloatLocX;
            if (r9 >= r2) goto L18;
            if (r9 <= (-r6)) goto L18;
            this.mStartTime = SystemClock.uptimeMillis();
            DragSortListView.access$800(this.this$0, true);
            return;
        L10:
            r4 = -1;
        L18:
            if (r0 != null) goto L20;
        L23:
            int r3 = this.mSecondPos;
            if (r3 == this.mFirstPos) goto L32;
            View r14 = this.this$0.getChildAt(r3 - r13);
            if (r14 != null) goto L28;
            return;
        L28:
            if (this.mSecondChildHeight != (-1)) goto L30;
            this.mSecondChildHeight = DragSortListView.access$1900(this.this$0, this.mSecondPos, r14, false);
            this.mSecondStartBlank = r14.getHeight() - this.mSecondChildHeight;
        L30:
            int r15 = Math.max((int) (r12 * this.mSecondStartBlank), 1);
            ViewGroup.LayoutParams r16 = r14.getLayoutParams();
            r16.height = this.mSecondChildHeight + r15;
            r14.setLayoutParams(r16);
            return;
        L32:
            return;
        L20:
            if (this.mFirstChildHeight != (-1)) goto L22;
            this.mFirstChildHeight = DragSortListView.access$1900(this.this$0, this.mFirstPos, r0, false);
            this.mFirstStartBlank = r0.getHeight() - this.mFirstChildHeight;
        L22:
            int r17 = Math.max((int) (this.mFirstStartBlank * r12), 1);
            ViewGroup.LayoutParams r18 = r0.getLayoutParams();
            r18.height = this.mFirstChildHeight + r17;
            r0.setLayoutParams(r18);
            goto L23
        }

        @Override // com.android.contacts.widget.dslv.DragSortListView.SmoothAnimator
        public void onStop() {
            DragSortListView.access$2000(this.this$0);
        }
    }

    public interface RemoveListener {
        void remove(int r1);
    }

    private final class SelectScroller implements Runnable {
        public static final int DOWN = 2;
        public static final int UP = 1;
        private boolean mAbort;
        private long mCurrTime;
        private long mPrevTime;
        private int mScrollDir;
        private float mScrollSpeed;
        private boolean mScrolling;
        final /* synthetic */ DragSortListView this$0;

        private SelectScroller(DragSortListView r1) {
            this.this$0 = r1;
            this.mScrolling = false;
        }

        /* synthetic */ SelectScroller(DragSortListView r1, AnonymousClass1 r2) {
            this(r1);
        }

        static /* synthetic */ void access$3300(SelectScroller r0) {
            r0.performSelectAction();
        }

        public void startScroll(int r3) {
            if (this.mScrolling == true) goto L6;
            this.mScrolling = true;
            this.mAbort = false;
            this.mScrollDir = r3;
            this.mPrevTime = SystemClock.uptimeMillis();
            this.this$0.post(this);
            return;
        }

        public void stopScroll() {
            this.this$0.removeCallbacks(this);
            this.mScrolling = false;
        }

        public boolean isScrolling() {
            return this.mScrolling;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mAbort == false) goto L5;
            return;
        L5:
            int r0 = this.this$0.getFirstVisiblePosition();
            int r1 = this.this$0.getLastVisiblePosition();
            int r2 = this.this$0.getCount();
            int r3 = this.this$0.getPaddingTop();
            int r4 = (this.this$0.getHeight() - r3) - this.this$0.getPaddingBottom();
            this.this$0.post(new AnonymousClass1(this));
            if (this.mScrollDir != 1) goto L20;
            View r5 = this.this$0.getChildAt(0);
            if (r5 == null) goto L18;
            if (r0 != 0) goto L14;
            if (r5.getTop() == r3) goto L18;
        L14:
            if (DragSortListView.access$3400(this.this$0).y < r3) goto L17;
            r3 = DragSortListView.access$3400(this.this$0).y;
        L17:
            this.mScrollSpeed = (r3 - DragSortListView.access$3500(this.this$0)) * 0.01f;
        L32:
            long r6 = SystemClock.uptimeMillis();
            this.mCurrTime = r6;
            float r7 = r6 - this.mPrevTime;
            this.this$0.smoothScrollBy(Math.round(this.mScrollSpeed * r7), (int) r7);
            this.this$0.invalidate();
            this.mPrevTime = this.mCurrTime;
            this.this$0.post(this);
            return;
        L18:
            this.mScrolling = false;
            return;
        L20:
            View r8 = this.this$0.getChildAt(r1 - r0);
            if (r8 != null) goto L23;
        L34:
            this.mScrolling = false;
            return;
        L23:
            if (r1 == (r2 - 1)) goto L25;
        L27:
            int r9 = this.this$0.getHeight() - this.this$0.getPaddingBottom();
            if (DragSortListView.access$3400(this.this$0).y > r9) goto L31;
            r9 = DragSortListView.access$3400(this.this$0).y;
        L31:
            this.mScrollSpeed = (r9 - DragSortListView.access$3600(this.this$0)) * 0.01f;
            goto L32
        L25:
            if (r8.getBottom() > (r4 + r3)) goto L27;
            goto L27
        }

        private void performSelectAction() {
            if (ContactsUtils.DEBUG == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DragSortListView.TAG, "performSelectAction().....................  ");
        L6:
            if (DragSortListView.access$3400(this.this$0).y >= this.this$0.getPaddingTop()) goto L13;
            if (ContactsUtils.DEBUG == false) goto L10;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DragSortListView.TAG, "mCurrPoint is above list view");
        L10:
            DragSortListView r4 = this.this$0;
            DragSortListView.access$3700(r4, r4.getFirstVisiblePosition());
            return;
        L13:
            if (DragSortListView.access$3400(this.this$0).y > (this.this$0.getHeight() - this.this$0.getPaddingBottom())) goto L15;
            DragSortListView r0 = this.this$0;
            int r1 = r0.pointToPosition(DragSortListView.access$3400(r0).x, DragSortListView.access$3400(this.this$0).y);
            DragSortListView r2 = this.this$0;
            View r3 = r2.getChildAt(r1 - r2.getFirstVisiblePosition());
            if (r3 != null) goto L22;
            return;
        L22:
            if (r3.findViewById(DragSortListView.access$3800(this.this$0)) == null) goto L26;
            DragSortListView.access$3700(this.this$0, r1);
            return;
        L26:
            return;
        L15:
            if (ContactsUtils.DEBUG == false) goto L17;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(DragSortListView.TAG, "mCurrPoint is below list view");
        L17:
            DragSortListView r5 = this.this$0;
            DragSortListView.access$3700(r5, r5.getLastVisiblePosition());
        }
    }

    private class SmoothAnimator implements Runnable {
        private float mA;
        private float mAlpha;
        private float mB;
        private float mC;
        private boolean mCanceled;
        private float mD;
        private float mDurationF;
        protected long mStartTime;
        final /* synthetic */ DragSortListView this$0;

        public void onStart() {
        }

        public void onStop() {
        }

        public void onUpdate(float r1, float r2) {
        }

        public SmoothAnimator(DragSortListView r3, float r4, int r5) {
            this.this$0 = r3;
            this.mAlpha = r4;
            this.mDurationF = r5;
            float r6 = 1.0f / ((r4 * 2.0f) * (1.0f - r4));
            this.mD = r6;
            this.mA = r6;
            this.mB = r4 / ((r4 - 1.0f) * 2.0f);
            this.mC = 1.0f / (1.0f - r4);
        }

        public float transform(float r3) {
            float r0 = this.mAlpha;
            if (r3 >= r0) goto L7;
            return (this.mA * r3) * r3;
        L7:
            if (r3 < (1.0f - r0)) goto L9;
            float r4 = r3 - 1.0f;
            return 1.0f - ((this.mD * r4) * r4);
        L9:
            return this.mB + (this.mC * r3);
        }

        public void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.mCanceled = false;
            onStart();
            this.this$0.post(this);
        }

        public void cancel() {
            this.mCanceled = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mCanceled == false) goto L5;
            return;
        L5:
            float r0 = (SystemClock.uptimeMillis() - this.mStartTime) / this.mDurationF;
            if (r0 < 1.0f) goto L8;
            onUpdate(1.0f, 1.0f);
            onStop();
            return;
        L8:
            onUpdate(r0, transform(r0));
            this.this$0.post(this);
        }
    }

    private static int rotate(int r1, int r2, int r3, int r4) {
        int r0 = r4 - r3;
        int r5 = r1 + r2;
        if (r5 < r3) goto L8;
        if (r5 >= r4) goto L7;
        return r5;
    L7:
        return r5 - r0;
    L8:
        return r5 + r0;
    }

    static /* synthetic */ float access$000(DragSortListView r0) {
        return r0.mMaxScrollSpeed;
    }

    static /* synthetic */ int access$1000(DragSortListView r0) {
        return r0.mSrcPos;
    }

    static /* synthetic */ int access$1100(DragSortListView r0) {
        return r0.mItemHeightCollapsed;
    }

    static /* synthetic */ int access$1200(DragSortListView r0) {
        return r0.mFloatViewHeight;
    }

    static /* synthetic */ void access$1300(DragSortListView r0) {
        r0.dropFloatView();
    }

    static /* synthetic */ int access$1400(DragSortListView r0) {
        return r0.mFirstExpPos;
    }

    static /* synthetic */ int access$1500(DragSortListView r0) {
        return r0.mSecondExpPos;
    }

    static /* synthetic */ boolean access$1600(DragSortListView r0) {
        return r0.mUseRemoveVelocity;
    }

    static /* synthetic */ float access$1700(DragSortListView r0) {
        return r0.mRemoveVelocityX;
    }

    static /* synthetic */ float access$1702(DragSortListView r0, float r1) {
        r0.mRemoveVelocityX = r1;
        return r1;
    }

    static /* synthetic */ float access$1716(DragSortListView r1, float r2) {
        float r0 = r1.mRemoveVelocityX + r2;
        r1.mRemoveVelocityX = r0;
        return r0;
    }

    static /* synthetic */ void access$1800(DragSortListView r0) {
        r0.destroyFloatView();
    }

    static /* synthetic */ int access$1900(DragSortListView r0, int r1, View r2, boolean r3) {
        return r0.getChildHeight(r1, r2, r3);
    }

    static /* synthetic */ int access$200(DragSortListView r0) {
        return r0.mDragState;
    }

    static /* synthetic */ void access$2000(DragSortListView r0) {
        r0.doRemoveItem();
    }

    static /* synthetic */ int access$202(DragSortListView r0, int r1) {
        r0.mDragState = r1;
        return r1;
    }

    static /* synthetic */ int access$2100(DragSortListView r0) {
        return r0.mFloatViewMid;
    }

    static /* synthetic */ float access$2200(DragSortListView r0) {
        return r0.mUpScrollStartYF;
    }

    static /* synthetic */ float access$2300(DragSortListView r0) {
        return r0.mDragUpScrollHeight;
    }

    static /* synthetic */ DragScrollProfile access$2400(DragSortListView r0) {
        return r0.mScrollProfile;
    }

    static /* synthetic */ float access$2500(DragSortListView r0) {
        return r0.mDownScrollStartYF;
    }

    static /* synthetic */ float access$2600(DragSortListView r0) {
        return r0.mDragDownScrollHeight;
    }

    static /* synthetic */ boolean access$2702(DragSortListView r0, boolean r1) {
        r0.mBlockLayoutRequests = r1;
        return r1;
    }

    static /* synthetic */ void access$2800(DragSortListView r0, int r1, View r2, boolean r3) {
        r0.doDragFloatView(r1, r2, r3);
    }

    static /* synthetic */ int access$2900(DragSortListView r0, int r1) {
        return r0.getItemHeight(r1);
    }

    static /* synthetic */ void access$300(DragSortListView r0, int r1, View r2, boolean r3) {
        r0.adjustItem(r1, r2, r3);
    }

    static /* synthetic */ int access$3000(DragSortListView r0, int r1) {
        return r0.getChildHeight(r1);
    }

    static /* synthetic */ int access$3100(DragSortListView r0) {
        return r0.mLastY;
    }

    static /* synthetic */ int access$3200(DragSortListView r0, int r1, int r2) {
        return r0.getShuffleEdge(r1, r2);
    }

    static /* synthetic */ Point access$3400(DragSortListView r0) {
        return r0.mCurrPoint;
    }

    static /* synthetic */ float access$3500(DragSortListView r0) {
        return r0.mSelectUpScrollStartY;
    }

    static /* synthetic */ float access$3600(DragSortListView r0) {
        return r0.mSelectDownScrollStartY;
    }

    static /* synthetic */ boolean access$3700(DragSortListView r0, int r1) {
        return r0.continueSelectMove(r1);
    }

    static /* synthetic */ int access$3800(DragSortListView r0) {
        return r0.mCheckBoxId;
    }

    static /* synthetic */ int access$400(DragSortListView r0) {
        return r0.mDragDeltaY;
    }

    static /* synthetic */ int access$402(DragSortListView r0, int r1) {
        r0.mDragDeltaY = r1;
        return r1;
    }

    static /* synthetic */ int access$500(DragSortListView r0) {
        return r0.mFloatViewHeightHalf;
    }

    static /* synthetic */ Point access$600(DragSortListView r0) {
        return r0.mFloatLoc;
    }

    static /* synthetic */ int access$700(DragSortListView r0) {
        return r0.mY;
    }

    static /* synthetic */ void access$800(DragSortListView r0, boolean r1) {
        r0.doDragFloatView(r1);
    }

    static /* synthetic */ int access$900(DragSortListView r0) {
        return r0.mFloatPos;
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    public DragSortListView(Context r29, AttributeSet r30) {
        super(r29, r30);
        this.mFloatLoc = new Point();
        this.mTouchLoc = new Point();
        this.mFloatViewOnMeasured = false;
        this.mFloatAlpha = 1.0f;
        this.mCurrFloatAlpha = 1.0f;
        this.mAnimate = false;
        this.mDragEnabled = true;
        this.mDragState = 0;
        this.mItemHeightCollapsed = 1;
        this.mWidthMeasureSpec = 0;
        this.mSampleViewTypes = new View[1];
        this.mDragUpScrollStartFrac = 0.33333334f;
        this.mDragDownScrollStartFrac = 0.33333334f;
        this.mMaxScrollSpeed = 0.5f;
        this.mScrollProfile = new AnonymousClass1(this);
        this.mDragFlags = 0;
        this.mLastCallWasIntercept = false;
        this.mInTouchEvent = false;
        AnonymousClass1 r10 = null;
        this.mFloatViewManager = null;
        this.mCancelMethod = 0;
        this.mSlideRegionFrac = 0.25f;
        this.mSlideFrac = 0.0f;
        this.mTrackDragSort = false;
        this.mBlockLayoutRequests = false;
        this.mIgnoreTouchEvent = false;
        this.mChildHeightCache = new HeightCache(this, 3);
        this.mRemoveVelocityX = 0.0f;
        this.mIsDoningAnimation = false;
        this.mListViewIntercepted = false;
        this.mPrePosition = -1;
        this.mSelectState = 0;
        this.mFloatViewInvalidated = false;
        this.mSelectUpScrollStartFrac = 0.2f;
        this.mSelectDownScrollStartFrac = 0.2f;
        this.SPEED_CARDINAL = 0.01f;
        this.mDownPoint = new Point();
        this.mCurrPoint = new Point();
        int r5 = 150;
        if (r30 == null) goto L15;
        TypedArray r11 = getContext().obtainStyledAttributes(r30, R.styleable.DragSortListView, 0, 0);
        this.mItemHeightCollapsed = Math.max(1, r11.getDimensionPixelSize(3, 1));
        boolean r0 = r11.getBoolean(18, false);
        this.mTrackDragSort = r0;
        if (r0 == false) goto L7;
        this.mDragSortTracker = new DragSortTracker(this);
    L7:
        float r1 = r11.getFloat(10, this.mFloatAlpha);
        this.mFloatAlpha = r1;
        this.mCurrFloatAlpha = r1;
        this.mDragEnabled = r11.getBoolean(4, this.mDragEnabled);
        float r2 = Math.max(0.0f, Math.min(1.0f, 1.0f - r11.getFloat(16, 0.75f)));
        this.mSlideRegionFrac = r2;
        if (r2 <= 0.0f) goto L10;
        boolean r3 = true;
    L11:
        this.mAnimate = r3;
        setDragScrollStart(r11.getFloat(6, this.mDragUpScrollStartFrac));
        this.mMaxScrollSpeed = r11.getFloat(12, this.mMaxScrollSpeed);
        int r12 = r11.getInt(13, 150);
        int r13 = r11.getInt(8, 150);
        if (r11.getBoolean(19, true) == false) goto L14;
        boolean r14 = r11.getBoolean(14, false);
        int r4 = r11.getInt(15, 1);
        boolean r15 = r11.getBoolean(17, true);
        int r6 = r11.getInt(7, 0);
        int r7 = r11.getResourceId(5, 0);
        int r8 = r11.getResourceId(9, 0);
        int r9 = r11.getResourceId(2, 0);
        int r16 = r11.getResourceId(1, 0);
        this.mCheckBoxId = r16;
        int r17 = r11.getColor(11, -16777216);
        DragSortController r18 = new DragSortController(this, r7, r6, r4, r9, r8, r16);
        this.mController = r18;
        r18.setRemoveEnabled(r14);
        this.mController.setSortEnabled(r15);
        this.mController.setBackgroundColor(r17);
        DragSortController r19 = this.mController;
        this.mFloatViewManager = r19;
        setOnTouchListener(r19);
    L14:
        r11.recycle();
        r5 = r12;
    L16:
        this.mDragScroller = new DragScroller(this);
        this.mSelectScroller = new SelectScroller(this, r10);
        if (r5 <= 0) goto L19;
        float r20 = 0.5f;
        this.mRemoveAnimator = new RemoveAnimator(this, 0.5f, r5);
    L20:
        if (r13 <= 0) goto L22;
        this.mDropAnimator = new DropAnimator(this, r20, r13);
    L22:
        this.mCancelEvent = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new AnonymousClass2(this);
        return;
    L19:
        r20 = 0.5f;
        goto L20
    L10:
        r3 = false;
        goto L11
    L15:
        r13 = 150;
        goto L16
    }

    public void stopScrolling() {
        this.mDragScroller.stopScrolling(true);
    }

    public void setFloatAlpha(float r1) {
        this.mCurrFloatAlpha = r1;
    }

    public float getFloatAlpha() {
        return this.mCurrFloatAlpha;
    }

    public void setMaxScrollSpeed(float r1) {
        this.mMaxScrollSpeed = r1;
    }

    public void setIsDoingAnimation(boolean r1) {
        this.mIsDoningAnimation = r1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r2) {
        if (r2 == null) goto L12;
        this.mAdapterWrapper = new AdapterWrapper(this, r2);
        r2.registerDataSetObserver(this.mObserver);
        if ((r2 instanceof DropListener) == false) goto L7;
        setDropListener((DropListener) r2);
    L7:
        if ((r2 instanceof DragListener) == false) goto L10;
        setDragListener((DragListener) r2);
    L10:
        if ((r2 instanceof RemoveListener) == false) goto L13;
        setRemoveListener((RemoveListener) r2);
    L13:
        super.setAdapter(this.mAdapterWrapper);
        return;
    L12:
        this.mAdapterWrapper = null;
        goto L13
    }

    public ListAdapter getInputAdapter() {
        AdapterWrapper r0 = this.mAdapterWrapper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAdapter();
    }

    private void drawDivider(int r7, Canvas r8) {
        Drawable r0 = getDivider();
        int r1 = getDividerHeight();
        if (r0 == null) goto L13;
        if (r1 == 0) goto L14;
        ViewGroup r2 = (ViewGroup) getChildAt(r7 - getFirstVisiblePosition());
        if (r2 == null) goto L15;
        int r3 = getPaddingLeft();
        int r4 = getWidth() - getPaddingRight();
        int r5 = r2.getChildAt(0).getHeight();
        if (r7 <= this.mSrcPos) goto L10;
        int r6 = r2.getTop() + r5;
        int r9 = r1 + r6;
    L11:
        r8.save();
        r8.clipRect(r3, r6, r4, r9);
        r0.setBounds(r3, r6, r4, r9);
        r0.draw(r8);
        r8.restore();
        return;
    L10:
        int r10 = r2.getBottom() - r5;
        int r11 = r10 - r1;
        r9 = r10;
        r6 = r11;
        goto L11
    L15:
        return;
    L14:
        return;
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r13) {
        super.dispatchDraw(r13);
        if (this.mDragState == 0) goto L12;
        int r0 = this.mFirstExpPos;
        if (r0 == this.mSrcPos) goto L7;
        drawDivider(r0, r13);
    L7:
        int r1 = this.mSecondExpPos;
        if (r1 == this.mFirstExpPos) goto L12;
        if (r1 == this.mSrcPos) goto L12;
        drawDivider(r1, r13);
    L12:
        View r2 = this.mFloatView;
        if (r2 == null) goto L22;
        int r3 = r2.getWidth();
        int r4 = this.mFloatView.getHeight();
        int r5 = this.mFloatLoc.x;
        int r6 = getWidth();
        if (r5 >= 0) goto L17;
        r5 = -r5;
    L17:
        if (r5 >= r6) goto L19;
        float r7 = (r6 - r5) / r6;
        float r8 = r7 * r7;
    L20:
        int r10 = (int) ((this.mCurrFloatAlpha * 255.0f) * r8);
        r13.save();
        r13.translate(this.mFloatLoc.x, this.mFloatLoc.y - this.mFloatViewManager.getPaddingTop());
        r13.clipRect(0, 0, r3, r4);
        r13.saveLayerAlpha(0.0f, 0.0f, r3, r4, r10, 31);
        this.mFloatView.draw(r13);
        r13.restore();
        r13.restore();
        return;
    L19:
        r8 = 0.0f;
        goto L20
    }

    private int getItemHeight(int r2) {
        View r0 = getChildAt(r2 - getFirstVisiblePosition());
        if (r0 == null) goto L7;
        return r0.getHeight();
    L7:
        return calcItemHeight(r2, getChildHeight(r2));
    }

    private void printPosData() {
        if (ContactsUtils.DEBUG == false) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("mobeta", "mSrcPos=" + this.mSrcPos + " mFirstExpPos=" + this.mFirstExpPos + " mSecondExpPos=" + this.mSecondExpPos);
        return;
    }

    private int getShuffleEdge(int r8, int r9) {
        int r0 = getHeaderViewsCount();
        int r1 = getFooterViewsCount();
        if (r8 > r0) goto L5;
        return r9;
    L5:
        if (r8 >= (getCount() - r1)) goto L32;
        int r2 = getDividerHeight();
        int r3 = this.mFloatViewHeight - this.mItemHeightCollapsed;
        int r4 = getChildHeight(r8);
        int r5 = getItemHeight(r8);
        int r6 = this.mSecondExpPos;
        int r7 = this.mSrcPos;
        if (r6 > r7) goto L18;
        if (r8 == r6) goto L11;
    L15:
        if (r8 <= r6) goto L26;
        if (r8 > r7) goto L26;
    L17:
        r9 = r9 - r3;
    L26:
        if (r8 > r7) goto L29;
        return r9 + (((this.mFloatViewHeight - r2) - getChildHeight(r8 - 1)) / 2);
    L29:
        return r9 + (((r4 - r2) - this.mFloatViewHeight) / 2);
    L11:
        if (this.mFirstExpPos == r6) goto L15;
        if (r8 != r7) goto L14;
        r9 = r9 + r5;
        r3 = this.mFloatViewHeight;
        goto L17
    L14:
        r9 = r9 + (r5 - r4);
        goto L17
    L18:
        if (r8 > r7) goto L20;
    L22:
        if (r8 != r6) goto L26;
        if (this.mFirstExpPos == r6) goto L26;
        r9 = r9 + (r5 - r4);
        goto L26
    L20:
        if (r8 > this.mFirstExpPos) goto L22;
        r9 = r9 + r3;
        goto L26
    L32:
        return r9;
    }

    private boolean updatePositions() {
        int r0 = getFirstVisiblePosition();
        int r1 = this.mFirstExpPos;
        View r2 = getChildAt(r1 - r0);
        if (r2 != null) goto L5;
        r1 = (getChildCount() / 2) + r0;
        r2 = getChildAt(r1 - r0);
    L5:
        int r3 = r2.getTop();
        int r4 = r2.getHeight();
        int r5 = getShuffleEdge(r1, r3);
        int r6 = getDividerHeight();
        if (this.mFloatViewMid >= r5) goto L17;
    L7:
        if (r1 < 0) goto L16;
        r1 = r1 - 1;
        int r7 = getItemHeight(r1);
        if (r1 == 0) goto L10;
        r3 = r3 - (r7 + r6);
        int r8 = getShuffleEdge(r1, r3);
        if (this.mFloatViewMid >= r8) goto L14;
        r5 = r8;
        goto L7
    L14:
        int r9 = r5;
        r5 = r8;
    L26:
        int r10 = getHeaderViewsCount();
        int r11 = getFooterViewsCount();
        int r12 = this.mFirstExpPos;
        int r13 = this.mSecondExpPos;
        float r14 = this.mSlideFrac;
        if (this.mAnimate == false) goto L37;
        int r15 = Math.abs(r5 - r9);
        int r16 = this.mFloatViewMid;
        if (r16 >= r5) goto L31;
        int r17 = r5;
        r5 = r9;
        r9 = r17;
    L31:
        int r18 = (int) ((this.mSlideRegionFrac * 0.5f) * r15);
        float r19 = r18;
        int r20 = r5 + r18;
        int r21 = r9 - r18;
        if (r16 >= r20) goto L34;
        this.mFirstExpPos = r1 - 1;
        this.mSecondExpPos = r1;
        this.mSlideFrac = ((r20 - r16) * 0.5f) / r19;
    L39:
        if (this.mFirstExpPos >= r10) goto L42;
        this.mFirstExpPos = r10;
        this.mSecondExpPos = r10;
        r1 = r10;
    L45:
        if (this.mFirstExpPos == r12) goto L47;
    L52:
        boolean r22 = true;
    L53:
        int r23 = this.mFloatPos;
        if (r1 == r23) goto L60;
        DragListener r24 = this.mDragListener;
        if (r24 == null) goto L58;
        r24.drag(r23 - r10, r1 - r10);
    L58:
        this.mFloatPos = r1;
        return true;
    L60:
        return r22;
    L47:
        if (this.mSecondExpPos != r13) goto L52;
        if (this.mSlideFrac != r14) goto L52;
        r22 = false;
        goto L53
    L42:
        if (this.mSecondExpPos < (getCount() - r11)) goto L45;
        r1 = (getCount() - r11) - 1;
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        goto L45
    L34:
        if (r16 >= r21) goto L36;
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        goto L39
    L36:
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1 + 1;
        this.mSlideFrac = (((r9 - r16) / r19) + 1.0f) * 0.5f;
        goto L39
    L37:
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        goto L39
    L10:
        int r25 = (r3 - r6) - r7;
    L11:
        int r110 = r5;
        r5 = r25;
        r9 = r110;
    L16:
        r9 = r5;
        goto L26
    L17:
        int r26 = getCount();
    L18:
        if (r1 >= r26) goto L16;
        if (r1 == (r26 - 1)) goto L21;
        r3 = r3 + (r4 + r6);
        int r27 = r1 + 1;
        int r28 = getItemHeight(r27);
        int r29 = getShuffleEdge(r27, r3);
        if (this.mFloatViewMid < r29) goto L24;
        r1 = r27;
        r4 = r28;
        r5 = r29;
        goto L18
    L24:
        r9 = r5;
        r5 = r29;
        goto L26
    L21:
        r25 = (r3 + r6) + r4;
        goto L11
    }

    @Override // android.view.View
    protected void onDraw(Canvas r1) {
        super.onDraw(r1);
        if (this.mTrackDragSort == false) goto L6;
        this.mDragSortTracker.appendState();
        return;
    }

    public void removeItem(int r2) {
        this.mUseRemoveVelocity = false;
        removeItem(r2, 0.0f);
    }

    public void removeItem(int r4, float r5) {
        int r0 = this.mDragState;
        if (r0 == 0) goto L5;
        if (r0 == 4) goto L5;
        return;
    L5:
        if (r0 != 0) goto L9;
        int r1 = getHeaderViewsCount() + r4;
        this.mSrcPos = r1;
        this.mFirstExpPos = r1;
        this.mSecondExpPos = r1;
        this.mFloatPos = r1;
        View r2 = getChildAt(r1 - getFirstVisiblePosition());
        if (r2 == null) goto L9;
        r2.setVisibility(4);
    L9:
        this.mDragState = 1;
        this.mRemoveVelocityX = r5;
        if (this.mInTouchEvent == false) goto L18;
        int r6 = this.mCancelMethod;
        if (r6 != 1) goto L14;
        super.onTouchEvent(this.mCancelEvent);
        goto L18
    L14:
        if (r6 != 2) goto L18;
        super.onInterceptTouchEvent(this.mCancelEvent);
    L18:
        RemoveAnimator r7 = this.mRemoveAnimator;
        if (r7 == null) goto L21;
        r7.start();
        return;
    L21:
        doRemoveItem(r4);
    }

    public void moveItem(int r2, int r3) {
        if (this.mDropListener != null) goto L5;
        return;
    L5:
        if (getInputAdapter() == null) goto L14;
        int r0 = getInputAdapter().getCount();
        if (r2 < 0) goto L15;
        if (r2 >= r0) goto L16;
        if (r3 < 0) goto L17;
        if (r3 >= r0) goto L18;
        this.mDropListener.drop(r2, r3);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public void cancelDrag() {
        if (this.mDragState != 4) goto L9;
        this.mDragScroller.stopScrolling(true);
        destroyFloatView();
        clearPositions();
        adjustAllItems();
        if (this.mInTouchEvent == false) goto L7;
        this.mDragState = 3;
        return;
    L7:
        this.mDragState = 0;
        return;
    }

    private void clearPositions() {
        this.mSrcPos = -1;
        this.mFirstExpPos = -1;
        this.mSecondExpPos = -1;
        this.mFloatPos = -1;
    }

    private void dropFloatView() {
        this.mDragState = 2;
        if (this.mDropListener == null) goto L9;
        int r0 = this.mFloatPos;
        if (r0 < 0) goto L9;
        if (r0 >= getCount()) goto L9;
        int r1 = getHeaderViewsCount();
        this.mDropListener.drop(this.mSrcPos - r1, this.mFloatPos - r1);
    L9:
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        adjustAllItems();
        if (this.mInTouchEvent == false) goto L12;
        this.mDragState = 3;
        return;
    L12:
        this.mDragState = 0;
    }

    private void doRemoveItem() {
        doRemoveItem(this.mSrcPos - getHeaderViewsCount());
    }

    private void doRemoveItem(int r2) {
        this.mDragState = 1;
        RemoveListener r0 = this.mRemoveListener;
        if (r0 == null) goto L5;
        r0.remove(r2);
    L5:
        destroyFloatView();
        adjustOnReorder();
        clearPositions();
        if (this.mInTouchEvent == false) goto L8;
        this.mDragState = 3;
        return;
    L8:
        this.mDragState = 0;
    }

    private void adjustOnReorder() {
        int r0 = getFirstVisiblePosition();
        if (this.mSrcPos >= r0) goto L9;
        int r1 = 0;
        View r2 = getChildAt(0);
        if (r2 == null) goto L7;
        r1 = r2.getTop();
    L7:
        setSelectionFromTop(r0 - 1, r1 - getPaddingTop());
        return;
    }

    public boolean stopDrag(boolean r2) {
        this.mUseRemoveVelocity = false;
        return stopDrag(r2, 0.0f);
    }

    public boolean stopDragWithVelocity(boolean r2, float r3) {
        this.mUseRemoveVelocity = true;
        return stopDrag(r2, r3);
    }

    public boolean stopDrag(boolean r3, float r4) {
        if (this.mFloatView == null) goto L15;
        this.mDragScroller.stopScrolling(true);
        if (r3 == false) goto L7;
        removeItem(this.mSrcPos - getHeaderViewsCount(), r4);
    L12:
        if (this.mTrackDragSort == false) goto L14;
        this.mDragSortTracker.stopTracking();
    L14:
        return true;
    L7:
        DropAnimator r5 = this.mDropAnimator;
        if (r5 == null) goto L10;
        r5.start();
        goto L12
    L10:
        dropFloatView();
        goto L12
    L15:
        return false;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView, com.android.contacts.list.HorizontalScrollListView, com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r6) {
        if (this.mIsDoningAnimation == false) goto L5;
        return true;
    L5:
        boolean r2 = false;
        if (this.mIgnoreTouchEvent == false) goto L10;
        this.mIgnoreTouchEvent = false;
        return false;
    L10:
        if (this.mDragEnabled == false) goto L12;
        boolean r0 = this.mLastCallWasIntercept;
        this.mLastCallWasIntercept = false;
        if (r0 == true) goto L17;
        saveTouchCoords(r6);
    L17:
        if (this.mController.startCheckPosition(r6) >= 0) goto L19;
    L21:
        int r1 = this.mDragState;
        if (r1 != 4) goto L24;
        onDragTouchEvent(r6);
        return true;
    L24:
        if (r1 != 5) goto L27;
        onCheckTouchEvent(r6);
        return true;
    L27:
        if (r1 == 0) goto L30;
        if (r1 == 3) goto L30;
    L32:
        int r3 = r6.getAction() & 255;
        if (r3 == 1) goto L37;
        if (r3 == 3) goto L37;
        if (r2 == false) goto L39;
        this.mCancelMethod = 1;
    L39:
        return r2;
    L37:
        doActionUpOrCancel();
        super.onTouchEvent(r6);
    L30:
        if (super.onTouchEvent(r6) == false) goto L32;
        r2 = true;
        goto L32
    L19:
        if (r6.getActionMasked() != 0) goto L21;
        this.mDragState = 5;
        goto L21
    L12:
        return super.onTouchEvent(r6);
    }

    private void doActionUpOrCancel() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "doActionUpOrCancel....................");
    L5:
        this.mCancelMethod = 0;
        this.mInTouchEvent = false;
        this.mDragState = 0;
        this.mCurrFloatAlpha = this.mFloatAlpha;
        this.mListViewIntercepted = false;
        this.mChildHeightCache.clear();
    }

    private void saveTouchCoords(MotionEvent r3) {
        int r0 = r3.getAction() & 255;
        if (r0 == 0) goto L5;
        this.mLastX = this.mX;
        this.mLastY = this.mY;
    L5:
        this.mX = (int) r3.getX();
        int r1 = (int) r3.getY();
        this.mY = r1;
        if (r0 != 0) goto L8;
        this.mLastX = this.mX;
        this.mLastY = r1;
    L8:
        this.mOffsetX = ((int) r3.getRawX()) - this.mX;
        this.mOffsetY = ((int) r3.getRawY()) - this.mY;
    }

    public boolean listViewIntercepted() {
        return this.mListViewIntercepted;
    }

    @Override // com.android.contacts.bytedanceosquickcontact.QuickContactListView, com.android.contacts.list.HorizontalScrollListView, com.obric.oui.bouncelayout.OListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        if (this.mIsDoningAnimation == false) goto L6;
        return true;
    L6:
        if (this.mDragEnabled == false) goto L8;
        saveTouchCoords(r6);
        this.mLastCallWasIntercept = true;
        int r0 = r6.getAction() & 255;
        if (r0 != 0) goto L18;
        int r3 = this.mDragState;
        if (r3 == 0) goto L16;
        if (r3 == 3) goto L16;
        this.mIgnoreTouchEvent = true;
        return true;
    L16:
        this.mInTouchEvent = true;
    L18:
        if (this.mFloatView == null) goto L21;
        boolean r7 = true;
    L30:
        if (r0 == 1) goto L32;
        if (r0 == 3) goto L32;
    L33:
        return r7;
    L32:
        this.mInTouchEvent = false;
        goto L33
    L21:
        if (super.onInterceptTouchEvent(r6) == false) goto L23;
        this.mListViewIntercepted = true;
        r7 = true;
    L24:
        if (r0 == 1) goto L29;
        if (r0 == 3) goto L29;
        if (r7 == false) goto L28;
        this.mCancelMethod = 1;
        goto L30
    L28:
        this.mCancelMethod = 2;
    L29:
        doActionUpOrCancel();
        goto L30
    L23:
        r7 = false;
        goto L24
    L8:
        return super.onInterceptTouchEvent(r6);
    }

    public void setDragScrollStart(float r1) {
        setDragScrollStarts(r1, r1);
    }

    public void setDragScrollStarts(float r3, float r4) {
        if (r4 <= 0.5f) goto L5;
        this.mDragDownScrollStartFrac = 0.5f;
    L7:
        if (r3 <= 0.5f) goto L9;
        this.mDragUpScrollStartFrac = 0.5f;
    L11:
        if (getHeight() == 0) goto L14;
        updateScrollStarts();
        return;
    L14:
        return;
    L9:
        this.mDragUpScrollStartFrac = r3;
        goto L11
    L5:
        this.mDragDownScrollStartFrac = r4;
        goto L7
    }

    private void continueDrag(int r6, int r7) {
        Point r0 = this.mFloatLoc;
        r0.x = r6 - this.mDragDeltaX;
        Point r8 = this.mFloatLoc;
        r8.y = r7 - this.mDragDeltaY;
        doDragFloatView(true);
        int r1 = Math.min(r7, this.mFloatViewMid + this.mFloatViewHeightHalf);
        int r9 = Math.max(r7, this.mFloatViewMid - this.mFloatViewHeightHalf);
        int r2 = this.mDragScroller.getScrollDir();
        int r3 = this.mLastY;
        if (r1 > r3) goto L5;
    L10:
        if (r9 >= r3) goto L18;
        if (r9 >= this.mUpScrollStartY) goto L18;
        if (r2 == 0) goto L18;
        if (r2 == (-1)) goto L16;
        this.mDragScroller.stopScrolling(true);
    L16:
        this.mDragScroller.startScrolling(0);
        return;
    L18:
        if (r9 >= this.mUpScrollStartY) goto L20;
        return;
    L20:
        if (r1 <= this.mDownScrollStartY) goto L22;
        return;
    L22:
        if (this.mDragScroller.isScrolling() == false) goto L29;
        this.mDragScroller.stopScrolling(true);
        return;
    L29:
        return;
    L5:
        if (r1 <= this.mDownScrollStartY) goto L10;
        if (r2 == 1) goto L10;
        if (r2 == (-1)) goto L9;
        this.mDragScroller.stopScrolling(true);
    L9:
        this.mDragScroller.startScrolling(1);
    }

    private void updateScrollStarts() {
        int r0 = getPaddingTop();
        int r1 = (getHeight() - r0) - getPaddingBottom();
        float r2 = r1;
        float r3 = r0;
        float r4 = (this.mDragUpScrollStartFrac * r2) + r3;
        this.mUpScrollStartYF = r4;
        float r5 = ((1.0f - this.mDragDownScrollStartFrac) * r2) + r3;
        this.mDownScrollStartYF = r5;
        this.mUpScrollStartY = (int) r4;
        this.mDownScrollStartY = (int) r5;
        this.mDragUpScrollHeight = r4 - r3;
        this.mDragDownScrollHeight = (r0 + r1) - r5;
    }

    @Override // com.obric.oui.bouncelayout.OListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateScrollStarts();
        initScrollData();
    }

    private void adjustAllItems() {
        int r0 = getFirstVisiblePosition();
        int r1 = getLastVisiblePosition();
        int r2 = Math.max(0, getHeaderViewsCount() - r0);
        int r3 = Math.min(r1 - r0, ((getCount() - 1) - getFooterViewsCount()) - r0);
    L3:
        if (r2 > r3) goto L8;
        View r4 = getChildAt(r2);
        if (r4 == null) goto L7;
        adjustItem(r0 + r2, r4, false);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private void adjustItem(int r3) {
        View r0 = getChildAt(r3 - getFirstVisiblePosition());
        if (r0 == null) goto L6;
        adjustItem(r3, r0, false);
        return;
    }

    private void adjustItem(int r3, View r4, boolean r5) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r3 != this.mSrcPos) goto L5;
    L9:
        int r6 = calcItemHeight(r3, r4, r5);
    L11:
        if (r6 == r0.height) goto L14;
        r0.height = r6;
        r4.setLayoutParams(r0);
    L14:
        if (r3 != this.mFirstExpPos) goto L16;
    L17:
        int r7 = this.mSrcPos;
        if (r3 >= r7) goto L20;
        ((DragSortItemView) r4).setGravity(80);
    L22:
        int r8 = r4.getVisibility();
        if (r3 == this.mSrcPos) goto L25;
    L27:
        int r2 = 0;
    L28:
        if (r2 == r8) goto L31;
        r4.setVisibility(r2);
        return;
    L31:
        return;
    L25:
        if (this.mFloatView == null) goto L27;
        r2 = 4;
        goto L28
    L20:
        if (r3 <= r7) goto L22;
        ((DragSortItemView) r4).setGravity(48);
        goto L22
    L16:
        if (r3 != this.mSecondExpPos) goto L22;
    L5:
        if (r3 == this.mFirstExpPos) goto L9;
        if (r3 == this.mSecondExpPos) goto L9;
        r6 = -2;
        goto L11
    }

    private int getChildHeight(int r5) {
        if (r5 != this.mSrcPos) goto L5;
        return 0;
    L5:
        View r0 = getChildAt(r5 - getFirstVisiblePosition());
        if (r0 != null) goto L8;
        int r1 = this.mChildHeightCache.get(r5);
        if (r1 == (-1)) goto L12;
        return r1;
    L12:
        ListAdapter r2 = getAdapter();
        int r3 = r2.getItemViewType(r5);
        int r4 = r2.getViewTypeCount();
        if (r4 == this.mSampleViewTypes.length) goto L16;
        this.mSampleViewTypes = new View[r4];
    L16:
        if (r3 < 0) goto L21;
        View r6 = this.mSampleViewTypes[r3];
        if (r6 != null) goto L20;
        View r7 = r2.getView(r5, null, this);
        this.mSampleViewTypes[r3] = r7;
    L22:
        int r8 = getChildHeight(r5, r7, true);
        this.mChildHeightCache.add(r5, r8);
        return r8;
    L20:
        r7 = r2.getView(r5, r6, this);
        goto L22
    L21:
        r7 = r2.getView(r5, null, this);
        goto L22
    L8:
        return getChildHeight(r5, r0, false);
    }

    private int getChildHeight(int r4, View r5, boolean r6) {
        int r1 = 0;
        if (r4 != this.mSrcPos) goto L6;
        return 0;
    L6:
        if (r4 >= getHeaderViewsCount()) goto L8;
    L11:
        if (r5 == null) goto L13;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
    L14:
        if (r7 != null) goto L16;
    L19:
        if (r5 == null) goto L21;
        r1 = r5.getHeight();
    L21:
        if (r1 == 0) goto L23;
        if (r6 == true) goto L23;
        return r1;
    L23:
        measureItem(r5);
        return r5.getMeasuredHeight();
    L16:
        if (r7.height <= 0) goto L19;
        return r7.height;
    L13:
        r7 = null;
        goto L14
    L8:
        if (r4 >= (getCount() - getFooterViewsCount())) goto L11;
        r5 = ((ViewGroup) r5).getChildAt(0);
        goto L11
    }

    private int calcItemHeight(int r1, View r2, boolean r3) {
        return calcItemHeight(r1, getChildHeight(r1, r2, r3));
    }

    private int calcItemHeight(int r7, int r8) {
        getDividerHeight();
        if (this.mAnimate == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        int r1 = this.mFloatViewHeight;
        int r2 = this.mItemHeightCollapsed;
        int r3 = r1 - r2;
        int r4 = (int) (this.mSlideFrac * r3);
        int r5 = this.mSrcPos;
        if (r7 != r5) goto L20;
        if (r5 != this.mFirstExpPos) goto L16;
        if (r0 == false) goto L29;
        return r4 + r2;
    L29:
        return r1;
    L16:
        if (r5 != this.mSecondExpPos) goto L31;
        return r1 - r4;
    L31:
        return r2;
    L20:
        if (r7 != this.mFirstExpPos) goto L25;
        if (r0 == false) goto L33;
        return r8 + r4;
    L33:
        return r8 + r3;
    L25:
        if (r7 == this.mSecondExpPos) goto L27;
        return r8;
    L27:
        return (r8 + r3) - r4;
    L5:
        if (this.mFirstExpPos == this.mSecondExpPos) goto L7;
        r0 = true;
        goto L8
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests == true) goto L6;
        super.requestLayout();
        return;
    }

    private int adjustScroll(int r8, View r9, int r10, int r11) {
        int r0 = getChildHeight(r8);
        int r12 = r9.getHeight();
        int r1 = calcItemHeight(r8, r0);
        int r2 = this.mSrcPos;
        if (r8 == r2) goto L5;
        int r3 = r12 - r0;
        int r4 = r1 - r0;
    L6:
        int r5 = this.mFloatViewHeight;
        int r6 = this.mFirstExpPos;
        if (r2 == r6) goto L12;
        if (r2 == this.mSecondExpPos) goto L12;
        r5 = r5 - this.mItemHeightCollapsed;
    L12:
        if (r8 > r10) goto L15;
        if (r8 > r6) goto L29;
        return 0;
    L29:
        return 0 + (r5 - r4);
    L15:
        if (r8 != r11) goto L22;
        if (r8 > r6) goto L20;
        r3 = r3 - r5;
    L30:
        return 0 + r3;
    L20:
        if (r8 != this.mSecondExpPos) goto L30;
        return 0 + (r12 - r1);
    L22:
        if (r8 > r6) goto L25;
        return 0 - r5;
    L25:
        if (r8 == this.mSecondExpPos) goto L27;
        return 0;
    L27:
        return 0 - r4;
    L5:
        r3 = r12;
        r4 = r1;
        goto L6
    }

    private void measureItem(View r4) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new AbsListView.LayoutParams(-1, -2);
        r4.setLayoutParams(r0);
    L5:
        int r3 = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), r0.width);
        if (r0.height <= 0) goto L8;
        int r1 = View.MeasureSpec.makeMeasureSpec(r0.height, 1073741824);
    L9:
        r4.measure(r3, r1);
        return;
    L8:
        r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L9
    }

    private void measureFloatView() {
        View r0 = this.mFloatView;
        if (r0 == null) goto L6;
        measureItem(r0);
        int r1 = (this.mFloatView.getMeasuredHeight() - this.mFloatViewManager.getPaddingTop()) - this.mFloatViewManager.getPaddingBottom();
        this.mFloatViewHeight = r1;
        this.mFloatViewHeightHalf = r1 / 2;
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        View r3 = this.mFloatView;
        if (r3 != null) goto L5;
    L8:
        this.mWidthMeasureSpec = r1;
        return;
    L5:
        if (r3.isLayoutRequested() == false) goto L7;
        measureFloatView();
    L7:
        this.mFloatViewOnMeasured = true;
        goto L8
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        super.layoutChildren();
        View r0 = this.mFloatView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isLayoutRequested() == true) goto L7;
    L9:
        View r1 = this.mFloatView;
        r1.layout(0, 0, r1.getMeasuredWidth(), this.mFloatView.getMeasuredHeight());
        this.mFloatViewOnMeasured = false;
        return;
    L7:
        if (this.mFloatViewOnMeasured == true) goto L9;
        measureFloatView();
        goto L9
    }

    protected boolean onDragTouchEvent(MotionEvent r6) {
        r6.getAction();
        int r0 = r6.getAction();
        if (r0 == 1) goto L22;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L15;
        if (r0 != 5) goto L11;
        r6.getPointerId(r6.getActionIndex());
    L27:
        return true;
    L11:
        if (r0 == 6) goto L22;
    L15:
        if (this.mDragState != 4) goto L17;
        cancelDrag();
    L17:
        doActionUpOrCancel();
        goto L27
    L19:
        if (r6.getPointerId(0) != 0) goto L27;
        continueDrag((int) r6.getX(), (int) r6.getY());
    L22:
        if (this.mDragState != 4) goto L24;
        stopDrag(false);
    L24:
        doActionUpOrCancel();
        if (isPressed() == false) goto L27;
        super.onTouchEvent(r6);
        goto L27
    }

    public void setMoveListener(MoveListener r1) {
        this.mMoveListener = r1;
    }

    protected boolean onCheckTouchEvent(MotionEvent r6) {
        int r0 = r6.getAction() & 255;
        int r1 = (int) r6.getX();
        int r2 = (int) r6.getY();
        this.mCurrPoint.set(r1, r2);
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L6;
    L11:
        recoveryFromSelection();
    L17:
        return true;
    L6:
        if (r0 != 2) goto L8;
        continueSelect(r1, r2, this.mController.startCheckPosition(r6));
        goto L17
    L8:
        if (r0 == 3) goto L11;
    L12:
        int r3 = this.mController.startCheckPosition(r6);
        if (r3 < 0) goto L17;
        MoveListener r4 = this.mMoveListener;
        if (r4 == null) goto L17;
        this.mSelectState = 1;
        this.downItemChecked = r4.isChecked(r3);
        continueMove(r6);
        this.mDownPoint.set(r1, r2);
        goto L17
    }

    @Override // com.android.contacts.list.HorizontalScrollListView, android.view.View
    protected void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 == 0) goto L6;
        recoveryFromSelection();
        return;
    }

    private void recoveryFromSelection() {
        doActionUpOrCancel();
        this.mSelectState = 0;
        this.mPrePosition = -1;
        SelectScroller r1 = this.mSelectScroller;
        if (r1 == null) goto L6;
        r1.stopScroll();
        return;
    }

    public int getSelectState() {
        return this.mSelectState;
    }

    private boolean continueMove(MotionEvent r2) {
        return continueSelectMove(this.mController.startCheckPosition(r2));
    }

    private boolean continueSelectMove(int r3) {
        if (r3 >= 0) goto L4;
        return false;
    L4:
        if (r3 == this.mPrePosition) goto L12;
        this.mPrePosition = r3;
        MoveListener r0 = this.mMoveListener;
        if (r0 == null) goto L9;
        r0.checkTo(r3, !this.downItemChecked);
    L9:
        return true;
    L12:
        return false;
    }

    private void invalidateFloatView() {
        this.mFloatViewInvalidated = true;
    }

    public boolean startDrag(int r9, int r10, int r11, int r12) {
        if (this.mInTouchEvent == false) goto L15;
        FloatViewManager r0 = this.mFloatViewManager;
        if (r0 == null) goto L15;
        View r4 = r0.onCreateFloatView(r9);
        if (r4 != null) goto L10;
        return false;
    L10:
        DragStartListener r1 = this.mDragStartListener;
        if (r1 == null) goto L14;
        r1.dragStart(r9);
    L14:
        return startDrag(r9, r4, r10, r11, r12);
    L15:
        return false;
    }

    public boolean startDrag(int r4, View r5, int r6, int r7, int r8) {
        if (this.mDragState == 0) goto L5;
    L30:
        return false;
    L5:
        if (this.mInTouchEvent == false) goto L30;
        if (this.mFloatView != null) goto L30;
        if (r5 == null) goto L30;
        if (this.mDragEnabled == false) goto L30;
        if (getParent() == null) goto L15;
        getParent().requestDisallowInterceptTouchEvent(true);
    L15:
        int r9 = r4 + getHeaderViewsCount();
        this.mFirstExpPos = r9;
        this.mSecondExpPos = r9;
        this.mSrcPos = r9;
        this.mFloatPos = r9;
        this.mDragState = 4;
        this.mDragFlags = r6 | 0;
        this.mFloatView = r5;
        measureFloatView();
        this.mDragDeltaX = r7;
        this.mDragDeltaY = r8;
        this.mDragStartY = this.mY;
        Point r10 = this.mFloatLoc;
        r10.x = this.mX - r7;
        Point r11 = this.mFloatLoc;
        r11.y = this.mY - this.mDragDeltaY;
        View r12 = getChildAt(this.mSrcPos - getFirstVisiblePosition());
        if (r12 == null) goto L19;
        r12.setVisibility(4);
    L19:
        if (this.mTrackDragSort == false) goto L21;
        this.mDragSortTracker.startTracking();
    L21:
        int r13 = this.mCancelMethod;
        if (r13 != 1) goto L24;
        super.onTouchEvent(this.mCancelEvent);
    L28:
        requestLayout();
        return true;
    L24:
        if (r13 != 2) goto L28;
        super.onInterceptTouchEvent(this.mCancelEvent);
        goto L28
    }

    public boolean startMove(int r1, int r2, int r3, int r4) {
        if (this.mDragState == 0) goto L5;
        return false;
    L5:
        if (this.mInTouchEvent == true) goto L7;
        return false;
    L7:
        if (this.mDragEnabled == true) goto L10;
        return false;
    L10:
        if (getParent() == null) goto L12;
        getParent().requestDisallowInterceptTouchEvent(true);
    L12:
        this.mDragState = 5;
        int r5 = this.mCancelMethod;
        if (r5 != 1) goto L15;
        super.onTouchEvent(this.mCancelEvent);
    L19:
        requestLayout();
        return true;
    L15:
        if (r5 != 2) goto L19;
        super.onInterceptTouchEvent(this.mCancelEvent);
        goto L19
    }

    private void doDragFloatView(boolean r3) {
        int r0 = getFirstVisiblePosition() + (getChildCount() / 2);
        View r1 = getChildAt(getChildCount() / 2);
        if (r1 != null) goto L5;
        return;
    L5:
        doDragFloatView(r0, r1, r3);
    }

    private void doDragFloatView(int r4, View r5, boolean r6) {
        this.mBlockLayoutRequests = true;
        updateFloatView();
        int r0 = this.mFirstExpPos;
        int r1 = this.mSecondExpPos;
        boolean r2 = updatePositions();
        if (r2 == false) goto L5;
        adjustAllItems();
        int r3 = adjustScroll(r4, r5, r0, r1);
        setSelectionFromTop(r4, (r5.getTop() + r3) - getPaddingTop());
        layoutChildren();
    L5:
        if (r2 == true) goto L7;
        if (r6 == true) goto L7;
    L8:
        this.mBlockLayoutRequests = false;
        return;
    L7:
        invalidate();
        goto L8
    }

    private void updateFloatView() {
        if (this.mFloatViewManager == null) goto L5;
        this.mTouchLoc.set(this.mX, this.mY);
        this.mFloatViewManager.onDragFloatView(this.mFloatView, this.mFloatLoc, this.mTouchLoc);
    L5:
        int r0 = this.mFloatLoc.x;
        int r1 = this.mFloatLoc.y;
        int r2 = getPaddingLeft();
        int r3 = this.mDragFlags;
        if ((r3 & 1) != 0) goto L10;
        if (r0 <= r2) goto L10;
        this.mFloatLoc.x = r2;
    L13:
        int r4 = getHeaderViewsCount();
        int r5 = getFooterViewsCount();
        int r6 = getFirstVisiblePosition();
        int r7 = getLastVisiblePosition();
        int r8 = getPaddingTop();
        if (r6 >= r4) goto L17;
        r8 = getChildAt((r4 - r6) - 1).getBottom();
    L17:
        if ((this.mDragFlags & 8) != 0) goto L21;
        int r9 = this.mSrcPos;
        if (r6 > r9) goto L21;
        r8 = Math.max(getChildAt(r9 - r6).getTop(), r8);
    L21:
        int r10 = getHeight() - getPaddingBottom();
        if (r7 < ((getCount() - r5) - 1)) goto L27;
        View r11 = getChildAt(((getCount() - r5) - 1) - r6);
        if (r11 == null) goto L27;
        r10 = Math.min(r11.getBottom(), r10);
    L27:
        if ((this.mDragFlags & 4) != 0) goto L31;
        int r12 = this.mSrcPos;
        if (r7 < r12) goto L31;
        r10 = Math.min(getChildAt(r12 - r6).getBottom(), r10);
    L31:
        if (r1 >= r8) goto L33;
        this.mFloatLoc.y = r8;
    L36:
        this.mFloatViewMid = this.mFloatLoc.y + this.mFloatViewHeightHalf;
        return;
    L33:
        int r13 = this.mFloatViewHeight;
        if ((r1 + r13) <= r10) goto L36;
        this.mFloatLoc.y = r10 - r13;
    L10:
        if ((r3 & 2) != 0) goto L13;
        if (r0 >= r2) goto L13;
        this.mFloatLoc.x = r2;
        goto L13
    }

    private void destroyFloatView() {
        View r0 = this.mFloatView;
        if (r0 == null) goto L9;
        r0.setVisibility(8);
        FloatViewManager r1 = this.mFloatViewManager;
        if (r1 == null) goto L7;
        r1.onDestroyFloatView(this.mFloatView);
    L7:
        this.mFloatView = null;
        invalidate();
        return;
    }

    public void setFloatViewManager(FloatViewManager r1) {
        this.mFloatViewManager = r1;
    }

    public void setDragListener(DragListener r1) {
        this.mDragListener = r1;
    }

    public void setDragStartListener(DragStartListener r1) {
        this.mDragStartListener = r1;
    }

    public void setDragEnabled(boolean r1) {
        this.mDragEnabled = r1;
    }

    public boolean isDragEnabled() {
        return this.mDragEnabled;
    }

    public void setDropListener(DropListener r1) {
        this.mDropListener = r1;
    }

    public void setRemoveListener(RemoveListener r1) {
        this.mRemoveListener = r1;
    }

    public void setDragSortListener(DragSortListener r1) {
        setDropListener(r1);
        setDragListener(r1);
        setRemoveListener(r1);
    }

    public void setDragScrollProfile(DragScrollProfile r1) {
        if (r1 == null) goto L5;
        this.mScrollProfile = r1;
        return;
    }

    public void moveCheckState(int r10, int r11) {
        SparseBooleanArray r0 = getCheckedItemPositions();
        if (r11 >= r10) goto L5;
        int r1 = r10;
        int r2 = r11;
    L6:
        int r3 = r1 + 1;
        int[] r4 = new int[r0.size()];
        int[] r5 = new int[r0.size()];
        int r6 = buildRunList(r0, r2, r3, r4, r5);
        if (r6 == 1) goto L9;
    L11:
        if (r10 >= r11) goto L15;
        int r12 = 0;
    L13:
        if (r12 == r6) goto L18;
        setItemChecked(rotate(r4[r12], -1, r2, r3), true);
        setItemChecked(rotate(r5[r12], -1, r2, r3), false);
        r12 = r12 + 1;
        goto L13
    L18:
        return;
    L15:
        int r13 = 0;
    L16:
        if (r13 == r6) goto L21;
        setItemChecked(r4[r13], false);
        setItemChecked(r5[r13], true);
        r13 = r13 + 1;
        goto L16
    L21:
        return;
    L9:
        if (r4[0] != r5[0]) goto L11;
        return;
    L5:
        r2 = r10;
        r1 = r11;
        goto L6
    }

    public void removeCheckState(int r11) {
        SparseBooleanArray r0 = getCheckedItemPositions();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() == 0) goto L21;
        int[] r1 = new int[r0.size()];
        int[] r2 = new int[r0.size()];
        int r3 = r0.keyAt(r0.size() - 1) + 1;
        int r4 = buildRunList(r0, r11, r3, r1, r2);
        int r6 = 0;
    L8:
        if (r6 == r4) goto L22;
        int r7 = r1[r6];
        if (r7 == r11) goto L15;
        int r9 = r2[r6];
        if (r9 >= r7) goto L14;
        if (r9 > r11) goto L15;
    L14:
        setItemChecked(rotate(r7, -1, r11, r3), true);
    L15:
        setItemChecked(rotate(r2[r6], -1, r11, r3), false);
        r6 = r6 + 1;
        goto L8
    L22:
        return;
    }

    private static int buildRunList(SparseBooleanArray r8, int r9, int r10, int[] r11, int[] r12) {
        int r0 = findFirstSetIndex(r8, r9, r10);
        if (r0 != (-1)) goto L5;
        return 0;
    L5:
        int r1 = r8.keyAt(r0);
        int r3 = r1 + 1;
        int r2 = r0 + 1;
        int r5 = 0;
    L7:
        if (r2 >= r8.size()) goto L17;
        int r6 = r8.keyAt(r2);
        if (r6 >= r10) goto L17;
        if (r8.valueAt(r2) == false) goto L16;
        if (r6 != r3) goto L15;
        r3 = r3 + 1;
        goto L16
    L15:
        r11[r5] = r1;
        r12[r5] = r3;
        r5 = r5 + 1;
        r3 = r6 + 1;
        r1 = r6;
    L16:
        r2 = r2 + 1;
    L17:
        if (r3 != r10) goto L19;
        r3 = r9;
    L19:
        r11[r5] = r1;
        r12[r5] = r3;
        int r7 = r5 + 1;
        if (r7 > 1) goto L22;
        return r7;
    L22:
        if (r11[0] != r9) goto L33;
        int r13 = r7 - 1;
        if (r12[r13] != r9) goto L34;
        r11[0] = r11[r13];
        return r7 - 1;
    L34:
        return r7;
    L33:
        return r7;
    }

    private static int findFirstSetIndex(SparseBooleanArray r2, int r3, int r4) {
        int r0 = r2.size();
        int r5 = insertionIndexForKey(r2, r3);
    L3:
        if (r5 >= r0) goto L9;
        if (r2.keyAt(r5) >= r4) goto L9;
        if (r2.valueAt(r5) == true) goto L9;
        r5 = r5 + 1;
    L9:
        if (r5 != r0) goto L11;
        return -1;
    L11:
        if (r2.keyAt(r5) >= r4) goto L19;
        return r5;
    L19:
        return -1;
    }

    private static int insertionIndexForKey(SparseBooleanArray r4, int r5) {
        int r0 = r4.size();
        int r1 = 0;
    L4:
        if ((r0 - r1) <= 0) goto L9;
        int r2 = (r1 + r0) >> 1;
        if (r4.keyAt(r2) < r5) goto L7;
        r0 = r2;
        goto L4
    L7:
        r1 = r2 + 1;
        goto L4
    L9:
        return r1;
    }

    private void initScrollData() {
        int r0 = getPaddingTop();
        float r1 = (getHeight() - r0) - getPaddingBottom();
        float r2 = r0;
        this.mSelectUpScrollStartY = (this.mSelectUpScrollStartFrac * r1) + r2;
        this.mSelectDownScrollStartY = r2 + ((1.0f - this.mSelectDownScrollStartFrac) * r1);
    }

    private void continueSelect(int r4, int r5, int r6) {
        int r7 = r5 - this.mDownPoint.y;
        float r8 = r5;
        float r0 = this.mSelectDownScrollStartY;
        if (r8 <= r0) goto L7;
        if (r7 <= 0) goto L7;
        this.mSelectScroller.startScroll(2);
        return;
    L7:
        float r1 = this.mSelectUpScrollStartY;
        if (r8 >= r1) goto L13;
        if (r7 >= 0) goto L13;
        this.mSelectScroller.startScroll(1);
        return;
    L13:
        if (r8 > r1) goto L15;
    L17:
        continueSelectMove(r6);
        return;
    L15:
        if (r8 >= r0) goto L17;
        this.mSelectScroller.stopScroll();
        goto L17
    }

    public boolean isSelecting() {
        if (this.mDragState != 5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas r3) {
        ListViewCollapseRunner r0 = this.mCollapseRunner;
        if (r0 == null) goto L7;
        boolean r1 = r0.compute();
        this.mCollapseRunner.draw(r3);
        invalidate();
        if (r1 == false) goto L9;
        this.mCollapseRunner = null;
        return;
    L9:
        return;
    L7:
        super.draw(r3);
    }

    @Override // com.android.contacts.MultiDeleteAnimation.MultiDeleteAnimationOperator
    public void startDeleteAnimations(List<Integer> r2, Animation.AnimationListener r3) {
        ListViewCollapseRunner r0 = new ListViewCollapseRunner(this, r2, r3);
        this.mCollapseRunner = r0;
        r0.setInterpolator(CubicInterpolator.OUT);
        this.mCollapseRunner.start();
        invalidate();
    }

    public DragSortController getController() {
        return this.mController;
    }
}
