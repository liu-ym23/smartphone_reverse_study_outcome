package com.stepos.common.picker;

import O6.s;
import O6.y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.common.R$attr;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$styleable;
import com.stepos.common.picker.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WheelPicker extends RecyclerView {
    private static final int FLAG_MARGIN_START_DP = 4;
    private static final int ITEM_COUNT_DEFAULT = 5;
    private static final int REDUNDANCY = 20;
    private static final float SCALE_REDUCE_ATOM = 0.15f;
    private static final int SCROLLER_SCROLL = 21000;
    private static final String TAG = "WheelPicker";
    private static final int VIBRATOR_INTERNAL = 15;
    private RecyclerView.Adapter<RecyclerView.ViewHolder> mAdapter;
    private final Context mContext;
    private List<String> mData;
    private boolean mDrawFlagEnable;
    private final Paint mFlagPaint;
    private String mFlagText;
    private boolean mInfinityLoop;
    private int mItemCount;
    private int mItemHeight;
    int[] mItemReactWindow;
    private int mLastSelectedPosition;
    private View mLastSelectedView;
    private long mLastVibratorTime;
    private LinearLayoutManager mLayoutManager;
    private final LinearSnapHelper mLinearSnapHelper;
    private int mLocYCenter;
    private int mNormalTextColor;
    private int mOffset;
    private final RecyclerView.OnScrollListener mOnScrollListener;
    private boolean mScrollFromUser;
    private int mSelectTextColor;
    private float mSelectedBaseline;
    private List<e> mSelectedChangeListeners;
    private float mSelectedEndPoint;
    private final com.stepos.common.picker.c mSoundPoolHelper;
    private int mStableTextLength;
    private int mTotalHeight;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            WheelPicker.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WheelPicker wheelPicker = WheelPicker.this;
            wheelPicker.addOnScrollListener(wheelPicker.mOnScrollListener);
            WheelPicker.this.v();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelPicker.this.requestLayout();
            WheelPicker.this.v();
            WheelPicker.this.x();
        }
    }

    public class c implements a.b {
        public c() {
        }

        @Override // com.stepos.common.picker.a.b
        public void a(View view, int i10, int i11) {
            int[] iArrCalculateDistanceToFinalSnap;
            WheelPicker.this.mScrollFromUser = true;
            if (WheelPicker.this.mLayoutManager == null || (iArrCalculateDistanceToFinalSnap = WheelPicker.this.mLinearSnapHelper.calculateDistanceToFinalSnap(WheelPicker.this.mLayoutManager, view)) == null) {
                return;
            }
            WheelPicker.this.smoothScrollBy(iArrCalculateDistanceToFinalSnap[0], iArrCalculateDistanceToFinalSnap[1]);
        }
    }

    public class d extends RecyclerView.OnScrollListener {
        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (i10 == 0) {
                WheelPicker wheelPicker = WheelPicker.this;
                TextView textViewY = wheelPicker.y(wheelPicker.mLastSelectedView);
                String str = (textViewY == null || TextUtils.isEmpty(textViewY.getText())) ? null : (String) textViewY.getText();
                WheelPicker wheelPicker2 = WheelPicker.this;
                wheelPicker2.q(wheelPicker2.mLastSelectedPosition, WheelPicker.this.mLastSelectedView, str);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i10, int i11) {
            super.onScrolled(recyclerView, i10, i11);
            WheelPicker.this.v();
        }
    }

    public interface e {
        void a(int i10, View view, String str);
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.StepOSWheelPickerStyle);
    }

    private int getInitialPosition() {
        RecyclerView.Adapter<RecyclerView.ViewHolder> adapter = this.mAdapter;
        if (adapter instanceof com.stepos.common.picker.a) {
            return ((com.stepos.common.picker.a) adapter).d();
        }
        return 0;
    }

    public void A(int i10, boolean z10) {
        this.mScrollFromUser = false;
        this.mLayoutManager.scrollToPositionWithOffset((getInitialPosition() + i10) - this.mOffset, 0);
        v();
    }

    public void B(List<String> list, int i10, boolean z10) {
        if (list == null) {
            return;
        }
        if (list.equals(this.mData)) {
            Log.i(TAG, "data is the same.");
            return;
        }
        stopScroll();
        this.mInfinityLoop = z10;
        if (list.size() > 0) {
            this.mStableTextLength = list.get(0).length();
        }
        setAdapter(new com.stepos.common.picker.a(new com.stepos.common.picker.b(list), z10));
        A(i10, false);
        this.mData = list;
    }

    public final void C() {
        if (this.mScrollFromUser) {
            if (O6.c.d()) {
                performHapticFeedback(SCROLLER_SCROLL);
            } else {
                y.d(getContext(), 2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i10, int i11) {
        this.mScrollFromUser = true;
        return super.fling(i10, i11);
    }

    public int getCurrentItem() {
        return this.mLastSelectedPosition;
    }

    public void n(e eVar) {
        if (this.mSelectedChangeListeners == null) {
            this.mSelectedChangeListeners = new ArrayList();
        }
        this.mSelectedChangeListeners.add(eVar);
    }

    public final float o(int i10) {
        int iAbs = Math.abs(this.mLocYCenter - i10);
        int i11 = this.mItemHeight;
        if (iAbs >= i11) {
            return 1.0f;
        }
        return iAbs / i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.stepos.common.picker.c cVar = this.mSoundPoolHelper;
        if (cVar != null) {
            cVar.i(this.mContext);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.stepos.common.picker.c cVar = this.mSoundPoolHelper;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawFlagEnable || TextUtils.isEmpty(this.mFlagText)) {
            return;
        }
        canvas.drawText(this.mFlagText, this.mSelectedEndPoint, this.mSelectedBaseline, this.mFlagPaint);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        w(i11, i13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12 = this.mTotalHeight;
        if (i12 != 0) {
            super.onMeasure(i10, i12);
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.mScrollFromUser = true;
        return super.onTouchEvent(motionEvent);
    }

    public final float p(int i10) {
        int i11 = this.mLocYCenter;
        if (i11 != 0 && this.mItemHeight != 0) {
            int iAbs = Math.abs(i10 - i11);
            return (1.0f - ((iAbs / r3) * 0.15f)) - (((iAbs % r3) / this.mItemHeight) * 0.15f);
        }
        Log.w(TAG, "mLocYCenter nor itemHeight init, mLocYCenter:" + this.mLocYCenter + ",itemHeight:" + this.mItemHeight);
        return 1.0f;
    }

    public final void q(int i10, View view, String str) {
        if (this.mSelectedChangeListeners != null) {
            for (int i11 = 0; i11 < this.mSelectedChangeListeners.size(); i11++) {
                this.mSelectedChangeListeners.get(i11).a(i10, view, str);
            }
        }
    }

    public final boolean r(int i10, int i11) {
        int i12 = this.mItemHeight;
        int i13 = i10 - (i12 / 2);
        int[] iArr = this.mItemReactWindow;
        return i13 > iArr[0] && i10 + (i12 / 2) < iArr[1] && this.mLastSelectedPosition != i11;
    }

    public final int s(float f10) {
        return E2.c.b().evaluate(f10, Integer.valueOf(this.mSelectTextColor), Integer.valueOf(this.mNormalTextColor)).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(adapter);
        this.mAdapter = adapter;
        if (adapter instanceof com.stepos.common.picker.a) {
            ((com.stepos.common.picker.a) adapter).f(new c());
        }
    }

    public void setCurrentItem(int i10) {
        A(i10, false);
    }

    public void setDrawFlagEnable(boolean z10) {
        this.mDrawFlagEnable = z10;
    }

    public void setFlagText(String str) {
        this.mFlagText = str;
    }

    public void setFlagTextColor(int i10) {
        this.mFlagPaint.setColor(i10);
    }

    public void setFlagTextSize(float f10) {
        this.mFlagPaint.setTextSize(f10);
    }

    public void setInfinityLoop(boolean z10) {
        this.mInfinityLoop = z10;
    }

    public void setItemCount(int i10) {
        if (this.mItemCount != i10) {
            this.mItemCount = i10;
            this.mOffset = i10 / 2;
            this.mTotalHeight = i10 * this.mItemHeight;
            requestLayout();
        }
    }

    public void setItemHeight(int i10) {
        this.mItemHeight = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        this.mLayoutManager = (LinearLayoutManager) layoutManager;
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        if (i10 == 0) {
            post(new b());
        }
    }

    public final void t(int i10, View view) {
        if (this.mScrollFromUser) {
            this.mSoundPoolHelper.j();
        }
        this.mLastSelectedPosition = i10;
        this.mLastSelectedView = view;
    }

    public final void u(View view, int i10) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                float fMax = Math.max(0.0f, p(i10));
                childAt.setScaleX(fMax);
                childAt.setScaleY(fMax);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (viewGroup2.getChildCount() > 0) {
                        View childAt2 = viewGroup2.getChildAt(0);
                        if (childAt2 instanceof TextView) {
                            ((TextView) childAt2).setTextColor(s(o(i10)));
                        }
                    }
                }
            }
        }
    }

    public final void v() {
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        if (linearLayoutManager != null) {
            int childCount = linearLayoutManager.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.mLayoutManager.getChildAt(i10);
                if (childAt == null) {
                    Log.w(TAG, "wtf! child was null.");
                } else {
                    int childAdapterPosition = getChildAdapterPosition(childAt);
                    int top = childAt.getTop() + (childAt.getHeight() / 2);
                    if (r(top, childAdapterPosition)) {
                        t(childAdapterPosition, childAt);
                        C();
                    }
                    u(childAt, top);
                }
            }
        }
    }

    public final void w(int i10, int i11) {
        int i12 = (i11 - i10) / 2;
        this.mLocYCenter = i12;
        int[] iArr = this.mItemReactWindow;
        int i13 = this.mItemHeight;
        iArr[0] = (i12 - (i13 / 2)) - 20;
        iArr[1] = i12 + (i13 / 2) + 20;
    }

    public final void x() {
        TextView textViewY = y(this.mLastSelectedView);
        if (textViewY != null) {
            int baseline = textViewY.getBaseline();
            this.mSelectedEndPoint = ((getWidth() + z()) / 2.0f) + s.a(4.0f, getContext());
            this.mSelectedBaseline = ((this.mTotalHeight - this.mItemHeight) / 2.0f) + baseline;
            invalidate();
        }
    }

    public final TextView y(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof TextView) {
                return (TextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                return y(childAt);
            }
        }
        return null;
    }

    public final float z() {
        TextView textViewY = y(this.mLastSelectedView);
        if (textViewY != null) {
            return textViewY.getPaint().measureText(this.mStableTextLength == 2 ? "00" : "0000");
        }
        return 0.0f;
    }

    public WheelPicker(Context context, AttributeSet attributeSet, int i10) throws IllegalStateException {
        super(context, attributeSet, i10);
        this.mItemReactWindow = new int[2];
        this.mDrawFlagEnable = false;
        this.mStableTextLength = 2;
        this.mOnScrollListener = new d();
        setOverScrollMode(2);
        this.mContext = context;
        int[] iArr = R$styleable.WheelPicker;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        this.mItemHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.WheelPicker_wheelPickerItemHeight, context.getResources().getDimensionPixelSize(R$dimen.mc_picker_select_item_height));
        this.mSelectTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheelPickerSelectedTextColor, context.getResources().getColor(R$color.fd_sys_color_on_surface_default));
        this.mNormalTextColor = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheelPickerNormalTextColor, context.getResources().getColor(R$color.fd_sys_color_on_surface_variant_default));
        int i11 = typedArrayObtainStyledAttributes.getInt(R$styleable.WheelPicker_wheelPickerItemCount, 5);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.WheelPicker_wheelPickerFlagTextColor, -16777216);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.WheelPicker_wheelPickerFlagTextSize, context.getResources().getDimensionPixelSize(R$dimen.mc_picker_text_size));
        setItemCount(i11);
        Paint paint = new Paint(1);
        this.mFlagPaint = paint;
        paint.setColor(color);
        paint.setTextSize(dimensionPixelSize);
        paint.setFakeBoldText(true);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
        this.mSoundPoolHelper = new com.stepos.common.picker.c();
        setLayoutManager(new LinearLayoutManager(context));
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.mLinearSnapHelper = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.mItemHeight);
        post(new Runnable() { // from class: com.stepos.common.picker.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f29512a.x();
            }
        });
    }
}
