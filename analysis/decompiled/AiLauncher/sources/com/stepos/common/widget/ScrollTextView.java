package com.stepos.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Scroller;
import androidx.dynamicanimation.animation.e;
import com.stepos.common.R$color;
import com.stepos.common.R$dimen;
import com.stepos.common.R$raw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class ScrollTextView extends View {
    private static final float DAMPING_DEFAULT = 0.98f;
    private static final int DEF_VISIBLE_ITEMS = 5;
    private static final int DEF_YSCROLL_END = Integer.MAX_VALUE;
    private static final float FRICTION_SCALAR = 0.98f;
    private static final int SCROLLER_SCROLL = 21000;
    private static final float STIFFNESS_DEFAULT = 30.0f;
    private static final String TAG = "ScrollTextView";
    public static final int VIBRATOR_INTERNAL = 15;
    private static long mLastVibratorTime;
    boolean isCyclic;
    private boolean isScrollingPerformed;
    private boolean isShowMarquee;
    private final List<f> mChangingListeners;
    private final List<g> mClickingListeners;
    private Context mContext;
    private int mCurrentItem;
    private float mDamping;
    private e mDataInterface;
    private float mFadingHeight;
    private Matrix mFadingMatrix;
    private Paint mFadingPaint;
    private Shader mFadingShader;
    private int mFirstItem;
    private float mFontMetricsCenterY;
    private boolean mIsDrawFading;
    private float mNormalFontMetricsCenterY;
    private float mNormalItemHeight;
    private int mNormalTextColor;
    private List<Integer> mNormalTextColors;
    private float mNormalTextSize;
    private List<Float> mNormalTextSizes;
    private int mOffsetX;
    private int mOffsetY;
    private boolean mParentRequestDisallowInterceptTouchEvent;
    private n mRange;
    private final l mScrollingListener;
    private final List<h> mScrollingListeners;
    private int mScrollingOffset;
    private float mSelectFontMetricsCenterY;
    private float mSelectItemHeight;
    private int mSelectTextColor;
    private float mSelectTextSize;
    private float mSelectedTextOffset;
    private m mSoundPoolHelper;
    private androidx.dynamicanimation.animation.i mSpringAnimation;
    private float mStiffness;
    private final Paint mTextPaint;
    private final Runnable mTextRunnable;
    private j mViewAdapter;
    private int mVisibleItems;
    private k mWheelScroller;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollTextView.this.B();
            ScrollTextView.this.postInvalidate();
        }
    }

    public class b implements l {
        public b() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void a(int i10) {
            ScrollTextView.this.A(i10);
            int height = ScrollTextView.this.getHeight();
            if (ScrollTextView.this.mScrollingOffset > height) {
                ScrollTextView.this.mScrollingOffset = height;
                ScrollTextView.this.mWheelScroller.r();
                return;
            }
            int i11 = -height;
            if (ScrollTextView.this.mScrollingOffset < i11) {
                ScrollTextView.this.mScrollingOffset = i11;
                ScrollTextView.this.mWheelScroller.r();
            }
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void b() {
            int i10;
            int itemHeight;
            int i11;
            ScrollTextView scrollTextView = ScrollTextView.this;
            if (!scrollTextView.isCyclic && scrollTextView.getCurrentItem() < ScrollTextView.this.mViewAdapter.d()) {
                ScrollTextView scrollTextView2 = ScrollTextView.this;
                scrollTextView2.X(scrollTextView2.mViewAdapter.d() - ScrollTextView.this.getCurrentItem(), 0);
                return;
            }
            ScrollTextView scrollTextView3 = ScrollTextView.this;
            if (!scrollTextView3.isCyclic && scrollTextView3.getCurrentItem() > ScrollTextView.this.mViewAdapter.c()) {
                ScrollTextView scrollTextView4 = ScrollTextView.this;
                scrollTextView4.X(scrollTextView4.mViewAdapter.c() - ScrollTextView.this.getCurrentItem(), 0);
                return;
            }
            if (Math.abs(ScrollTextView.this.mScrollingOffset) <= ScrollTextView.this.getItemHeight() / 2) {
                if (ScrollTextView.this.mScrollingOffset != 0) {
                    ScrollTextView.this.mWheelScroller.n(ScrollTextView.this.mScrollingOffset, (Math.abs(ScrollTextView.this.mScrollingOffset) * 650) / (ScrollTextView.this.getItemHeight() / 2));
                    return;
                }
                return;
            }
            if (ScrollTextView.this.mScrollingOffset > 0) {
                itemHeight = -ScrollTextView.this.getItemHeight();
                i11 = ScrollTextView.this.mScrollingOffset;
            } else if (ScrollTextView.this.mScrollingOffset >= 0) {
                i10 = 0;
                ScrollTextView.this.mWheelScroller.n(i10, 0);
            } else {
                itemHeight = ScrollTextView.this.getItemHeight();
                i11 = ScrollTextView.this.mScrollingOffset;
            }
            i10 = itemHeight + i11;
            ScrollTextView.this.mWheelScroller.n(i10, 0);
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void c() {
            ScrollTextView.this.isScrollingPerformed = true;
            ScrollTextView scrollTextView = ScrollTextView.this;
            scrollTextView.removeCallbacks(scrollTextView.mTextRunnable);
            ScrollTextView.this.Q();
        }

        @Override // com.stepos.common.widget.ScrollTextView.l
        public void d() {
            if (ScrollTextView.this.isScrollingPerformed) {
                ScrollTextView.this.P();
                ScrollTextView.this.isScrollingPerformed = false;
            }
            ScrollTextView.this.mScrollingOffset = 0;
            ScrollTextView scrollTextView = ScrollTextView.this;
            scrollTextView.removeCallbacks(scrollTextView.mTextRunnable);
            ScrollTextView.this.mSelectedTextOffset = r0.getWidth() / 2.0f;
            ScrollTextView.this.B();
            ScrollTextView.this.invalidate();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ScrollTextView.this.mSelectedTextOffset = r0.getWidth() / 2.0f;
            ScrollTextView.this.B();
        }
    }

    public class d extends Handler {
        private final WeakReference<k> mScrollTextViewScroller;

        public d(k kVar) {
            this.mScrollTextViewScroller = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            k kVar = this.mScrollTextViewScroller.get();
            if (kVar == null || kVar.mFling) {
                return;
            }
            kVar.scroller.computeScrollOffset();
            int currY = kVar.scroller.getCurrY();
            int i10 = kVar.lastScrollY - currY;
            kVar.lastScrollY = currY;
            kVar.listener.a(i10);
            if (Math.abs(currY - kVar.scroller.getFinalY()) < 1) {
                kVar.scroller.forceFinished(true);
            }
            if (kVar.scroller.isFinished()) {
                if (message.what == 0) {
                    kVar.l();
                    return;
                } else {
                    kVar.k();
                    return;
                }
            }
            int i11 = message.what;
            if (i11 == 1 || i11 == 0) {
                kVar.animationHandler.sendEmptyMessage(message.what);
            }
        }
    }

    public interface e {
        String a(int i10);

        void b(View view, int i10, int i11);
    }

    public interface f {
        void a(ScrollTextView scrollTextView, int i10, int i11);
    }

    public interface g {
        void a(ScrollTextView scrollTextView, int i10);
    }

    public interface h {
        void a(ScrollTextView scrollTextView);

        void b(ScrollTextView scrollTextView);
    }

    public class i implements f {
        public i() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.f
        public void a(ScrollTextView scrollTextView, int i10, int i11) {
            ScrollTextView.this.R();
        }

        public /* synthetic */ i(ScrollTextView scrollTextView, a aVar) {
            this();
        }
    }

    public class j {
        public static final int DEFAULT_MAX_VALUE = 9;
        private static final int DEFAULT_MIN_VALUE = 0;
        private int count;
        private int validEnd;
        private int validStart;

        public j(ScrollTextView scrollTextView) {
            this(10, 0, 9);
        }

        public String a(int i10) {
            if (i10 < 0 || i10 >= b() || ScrollTextView.this.mDataInterface == null) {
                return null;
            }
            return ScrollTextView.this.mDataInterface.a(i10);
        }

        public int b() {
            return this.count;
        }

        public int c() {
            return this.validEnd;
        }

        public int d() {
            return this.validStart;
        }

        public j e(int i10, int i11, int i12) {
            this.validStart = i11;
            this.validEnd = i12;
            this.count = i10;
            return this;
        }

        public j(int i10, int i11, int i12) {
            this.validStart = 0;
            this.validEnd = 0;
            this.count = 0;
            e(i10, i11, i12);
        }
    }

    public class k {
        public static final int MIN_DELTA_FOR_SCROLLING = 1;
        private static final int SCROLLING_DURATION = 650;
        private static final int SCROLLING_DURATION_EXTEND = 1000;
        private final int MESSAGE_FLING;
        private final int MESSAGE_JUSTIFY;
        private final int MESSAGE_SCROLL;
        private final Handler animationHandler;
        private final Context context;
        private final GestureDetector gestureDetector;
        private final GestureDetector.SimpleOnGestureListener gestureListener;
        private boolean isScrollingPerformed;
        private int lastScrollY;
        private float lastTouchedY;
        private final l listener;
        private boolean mFling;
        private Scroller scroller;

        public class a extends GestureDetector.SimpleOnGestureListener {

            /* renamed from: com.stepos.common.widget.ScrollTextView$k$a$a, reason: collision with other inner class name */
            public class C0351a implements e.q {
                public C0351a() {
                }

                @Override // androidx.dynamicanimation.animation.e.q
                public void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                    k.this.k();
                }
            }

            public class b implements e.r {
                public b() {
                }

                @Override // androidx.dynamicanimation.animation.e.r
                public void b(androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
                    k.this.p(2);
                }
            }

            public a() {
            }

            public final void a(int i10, int i11) {
                ScrollTextView.this.w();
                if (ScrollTextView.this.mSpringAnimation == null) {
                    ScrollTextView.this.mSpringAnimation = new androidx.dynamicanimation.animation.i(new androidx.dynamicanimation.animation.g());
                    ScrollTextView.this.mSpringAnimation.b(new C0351a());
                    ScrollTextView.this.mSpringAnimation.c(new b());
                }
                androidx.dynamicanimation.animation.j jVar = new androidx.dynamicanimation.animation.j();
                jVar.g(i11);
                jVar.h(ScrollTextView.this.mStiffness);
                jVar.f(ScrollTextView.this.mDamping);
                ScrollTextView.this.mSpringAnimation.B(jVar);
                ScrollTextView.this.mSpringAnimation.r(i10);
                ScrollTextView.this.mSpringAnimation.t();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                k.this.lastScrollY = 0;
                int yScrollEnd = ScrollTextView.this.getYScrollEnd();
                int i10 = (int) (-f11);
                k.this.scroller.fling(0, k.this.lastScrollY, 0, i10, 0, 0, ScrollTextView.this.getYScrollStart(), yScrollEnd);
                int finalY = k.this.scroller.getFinalY();
                int itemHeight = finalY % ScrollTextView.this.getItemHeight();
                if (itemHeight != 0) {
                    int itemHeight2 = itemHeight > 0 ? finalY + (ScrollTextView.this.getItemHeight() - itemHeight) : finalY - (ScrollTextView.this.getItemHeight() + itemHeight);
                    finalY = ScrollTextView.this.mScrollingOffset > 0 ? (itemHeight2 + ScrollTextView.this.mScrollingOffset) - ScrollTextView.this.getItemHeight() : itemHeight2 + ScrollTextView.this.getItemHeight() + ScrollTextView.this.mScrollingOffset;
                    if (finalY > ScrollTextView.this.getItemHeight()) {
                        finalY -= ScrollTextView.this.getItemHeight();
                    } else if (finalY < (-ScrollTextView.this.getItemHeight())) {
                        finalY += ScrollTextView.this.getItemHeight();
                    }
                    k.this.scroller.setFinalY(finalY);
                }
                a(i10, finalY);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
                return true;
            }
        }

        public k(Context context, l lVar) {
            a aVar = new a();
            this.gestureListener = aVar;
            this.MESSAGE_SCROLL = 0;
            this.MESSAGE_JUSTIFY = 1;
            this.MESSAGE_FLING = 2;
            this.animationHandler = ScrollTextView.this.new d(this);
            GestureDetector gestureDetector = new GestureDetector(context, aVar);
            this.gestureDetector = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.scroller = new Scroller(context, new PathInterpolator(0.3f, 1.56f, 0.3f, 1.0f));
            this.listener = lVar;
            this.context = context;
        }

        public final void j() {
            this.animationHandler.removeMessages(0);
            this.animationHandler.removeMessages(1);
            this.animationHandler.removeMessages(2);
        }

        public void k() {
            if (this.isScrollingPerformed) {
                this.listener.d();
                this.isScrollingPerformed = false;
            }
        }

        public final void l() {
            this.listener.b();
            p(1);
        }

        public boolean m(MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.mFling = false;
                this.lastTouchedY = motionEvent.getY();
                this.scroller.forceFinished(true);
                ScrollTextView.this.w();
                j();
                k();
            } else if (action == 2) {
                this.mFling = false;
                int y10 = (int) (motionEvent.getY() - this.lastTouchedY);
                if (y10 != 0) {
                    q();
                    this.listener.a(y10);
                    this.lastTouchedY = motionEvent.getY();
                }
            } else if (action == 3) {
                l();
            }
            if (!this.gestureDetector.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                l();
            }
            return true;
        }

        public void n(int i10, int i11) {
            this.scroller.forceFinished(true);
            this.lastScrollY = 0;
            Scroller scroller = this.scroller;
            if (i11 == 0) {
                i11 = SCROLLING_DURATION;
            }
            scroller.startScroll(0, 0, 0, i10, i11);
            p(0);
            q();
        }

        public void o(Interpolator interpolator) {
            this.scroller.forceFinished(true);
            this.scroller = new Scroller(this.context, interpolator);
        }

        public final void p(int i10) {
            j();
            this.animationHandler.sendEmptyMessage(i10);
        }

        public final void q() {
            if (this.isScrollingPerformed) {
                return;
            }
            this.isScrollingPerformed = true;
            this.listener.c();
        }

        public void r() {
            this.scroller.forceFinished(true);
        }
    }

    public interface l {
        void a(int i10);

        void b();

        void c();

        void d();
    }

    public static class n {
        private int count;
        private int first;

        public n() {
            this(0, 0);
        }

        public int a() {
            return this.count;
        }

        public int b() {
            return this.first;
        }

        public int c() {
            return (b() + a()) - 1;
        }

        public n d(int i10, int i11) {
            this.first = i10;
            this.count = i11;
            return this;
        }

        public n(int i10, int i11) {
            this.first = i10;
            this.count = i11;
        }
    }

    public class o implements f {
        public o() {
        }

        @Override // com.stepos.common.widget.ScrollTextView.f
        public void a(ScrollTextView scrollTextView, int i10, int i11) {
            ScrollTextView.this.L();
        }

        public /* synthetic */ o(ScrollTextView scrollTextView, a aVar) {
            this();
        }
    }

    public ScrollTextView(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        this.mTextPaint = new Paint(1);
        this.mCurrentItem = 0;
        this.mVisibleItems = 5;
        this.mSelectItemHeight = 0.0f;
        this.mNormalItemHeight = 0.0f;
        this.isCyclic = false;
        this.mIsDrawFading = true;
        this.mParentRequestDisallowInterceptTouchEvent = true;
        this.mSelectedTextOffset = 0.0f;
        this.isShowMarquee = true;
        this.mStiffness = 30.0f;
        this.mDamping = 0.98f;
        this.mTextRunnable = new a();
        this.mChangingListeners = new LinkedList();
        this.mScrollingListeners = new LinkedList();
        this.mClickingListeners = new LinkedList();
        this.mScrollingListener = new b();
        G(context);
    }

    private n getItemsRange() {
        if (getItemHeight() == 0) {
            return null;
        }
        int i10 = this.mCurrentItem;
        int iAsin = 1;
        while (true) {
            int i11 = iAsin + 2;
            if (getItemHeight() * i11 >= getHeight()) {
                break;
            }
            i10--;
            iAsin = i11;
        }
        int i12 = this.mScrollingOffset;
        if (i12 != 0) {
            if (i12 > 0) {
                i10--;
            }
            int itemHeight = i12 / getItemHeight();
            i10 -= itemHeight;
            iAsin = (int) (iAsin + 1 + Math.asin(itemHeight));
        }
        return this.mRange.d(i10, iAsin);
    }

    private int getScrollEndItem() {
        int iB = this.mViewAdapter.b();
        if (this.isCyclic) {
            return 0;
        }
        return iB <= this.mVisibleItems ? iB - 1 : iB - 1;
    }

    private int getScrollStartItem() {
        this.mViewAdapter.b();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollEnd() {
        if (this.isCyclic) {
            return Integer.MAX_VALUE;
        }
        return this.mScrollingOffset + ((int) ((getScrollEndItem() - getCurrentItem()) * this.mNormalItemHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getYScrollStart() {
        if (this.isCyclic) {
            return -2147483647;
        }
        return this.mScrollingOffset + ((int) ((getScrollStartItem() - getCurrentItem()) * this.mNormalItemHeight));
    }

    private void setViewAdapter(j jVar) {
        this.mViewAdapter = jVar;
        invalidate();
    }

    public final void A(int i10) {
        if (!I()) {
            if (this.mCurrentItem == getScrollStartItem()) {
                int i11 = this.mScrollingOffset;
                if (i11 + i10 > 0) {
                    i10 = -i11;
                }
                if (i10 == 0) {
                    return;
                }
            } else if (this.mCurrentItem == getScrollEndItem()) {
                int i12 = this.mScrollingOffset;
                if (i12 + i10 < 0) {
                    i10 = -i12;
                }
                if (i10 == 0) {
                    return;
                }
            }
        }
        int iB = this.mViewAdapter.b();
        if (iB == 1) {
            this.mScrollingOffset = 0;
        } else {
            this.mScrollingOffset += i10;
        }
        int itemHeight = getItemHeight();
        int scrollEndItem = this.mScrollingOffset / itemHeight;
        int scrollEndItem2 = this.mCurrentItem - scrollEndItem;
        if (this.isCyclic && iB > 0) {
            while (scrollEndItem2 < 0) {
                scrollEndItem2 += iB;
            }
            scrollEndItem2 %= iB;
        } else if (scrollEndItem2 < getScrollStartItem()) {
            scrollEndItem = this.mCurrentItem - getScrollStartItem();
            scrollEndItem2 = getScrollStartItem();
        } else if (scrollEndItem2 > getScrollEndItem()) {
            scrollEndItem = this.mCurrentItem - getScrollEndItem();
            scrollEndItem2 = getScrollEndItem();
        } else if (scrollEndItem2 != getScrollEndItem()) {
            getScrollStartItem();
        }
        int i13 = this.mScrollingOffset;
        if (scrollEndItem2 != this.mCurrentItem) {
            Y(scrollEndItem2, false);
        } else {
            invalidate();
        }
        int i14 = i13 - (scrollEndItem * itemHeight);
        this.mScrollingOffset = i14;
        if (i14 <= getHeight() || getHeight() == 0) {
            return;
        }
        this.mScrollingOffset = (this.mScrollingOffset % getHeight()) + getHeight();
    }

    public final void B() {
        if (this.isScrollingPerformed) {
            postInvalidate();
        } else {
            postDelayed(this.mTextRunnable, 10L);
        }
    }

    public final void C(Canvas canvas) {
        int width = getWidth() / 2;
        float fMeasureText = this.mTextPaint.measureText("AA");
        float itemHeight = ((-(((this.mCurrentItem - this.mFirstItem) * getItemHeight()) + ((((int) this.mSelectItemHeight) - getHeight()) / 2))) + this.mScrollingOffset) - getItemHeight();
        canvas.translate(this.mOffsetX, itemHeight);
        int itemHeight2 = this.mScrollingOffset;
        if (itemHeight2 <= 0) {
            itemHeight2 = getItemHeight() + this.mScrollingOffset;
        }
        float f10 = 1.0f;
        float itemHeight3 = (itemHeight2 * 1.0f) / getItemHeight();
        int i10 = 0;
        while (i10 < this.mRange.a()) {
            float fZ = z(i10, itemHeight3);
            canvas.translate(0.0f, fZ);
            itemHeight += fZ;
            String strE = E(i10);
            float f11 = (this.mNormalItemHeight / 2.0f) - this.mFontMetricsCenterY;
            if (this.isScrollingPerformed || this.mTextPaint.getTextSize() != this.mSelectTextSize) {
                canvas.drawText(strE, width, f11, this.mTextPaint);
            } else {
                float fMeasureText2 = this.mTextPaint.measureText(strE);
                if (!J() || fMeasureText2 <= getWidth()) {
                    removeCallbacks(this.mTextRunnable);
                    canvas.drawText(strE, width, f11, this.mTextPaint);
                } else {
                    float f12 = this.mSelectedTextOffset - f10;
                    this.mSelectedTextOffset = f12;
                    float f13 = width;
                    float width2 = f13 - ((fMeasureText2 - getWidth()) / 2.0f);
                    if (f12 >= width2 - getWidth()) {
                        canvas.drawText(strE, this.mSelectedTextOffset, f11, this.mTextPaint);
                    }
                    float f14 = this.mSelectedTextOffset;
                    if (f14 <= width2 - fMeasureText && f14 >= ((width2 - fMeasureText2) - getWidth()) - fMeasureText) {
                        canvas.drawText(strE, this.mSelectedTextOffset + fMeasureText2 + fMeasureText, f11, this.mTextPaint);
                    }
                    float f15 = this.mSelectedTextOffset;
                    float f16 = fMeasureText * 2.0f;
                    if (f15 <= (width2 - fMeasureText2) - f16) {
                        canvas.drawText(strE, f15 + ((fMeasureText2 + fMeasureText) * 2.0f), f11, this.mTextPaint);
                    }
                    if (this.mSelectedTextOffset <= (-(((fMeasureText2 * 2.0f) - f13) + f16))) {
                        removeCallbacks(this.mTextRunnable);
                    }
                }
            }
            i10++;
            f10 = 1.0f;
        }
        canvas.translate(0.0f, -itemHeight);
    }

    public final void D(Canvas canvas) {
        this.mFadingMatrix.setScale(1.0f, this.mFadingHeight);
        this.mFadingShader.setLocalMatrix(this.mFadingMatrix);
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.mFadingHeight, this.mFadingPaint);
        this.mFadingMatrix.setScale(1.0f, this.mFadingHeight);
        this.mFadingMatrix.postRotate(180.0f);
        this.mFadingMatrix.postTranslate(0.0f, getHeight());
        this.mFadingShader.setLocalMatrix(this.mFadingMatrix);
        canvas.drawRect(0.0f, getHeight() - this.mFadingHeight, getWidth(), getHeight(), this.mFadingPaint);
    }

    public final String E(int i10) {
        String strA;
        int i11 = i10 + this.mFirstItem;
        String strA2 = this.mViewAdapter.a(i11);
        if (i11 < 0) {
            int iB = this.mViewAdapter.b() + i11;
            if (this.isCyclic) {
                strA = this.mViewAdapter.a(iB);
                strA2 = strA;
            }
            strA2 = "";
        } else if (i11 >= this.mViewAdapter.b()) {
            int iB2 = i11 - this.mViewAdapter.b();
            if (this.isCyclic) {
                strA = this.mViewAdapter.a(iB2);
                strA2 = strA;
            }
            strA2 = "";
        }
        return strA2 == null ? "" : strA2;
    }

    public final void F(Context context) throws Resources.NotFoundException {
        this.mSelectTextColor = context.getResources().getColor(R$color.fd_sys_color_on_surface_default);
        int color = context.getResources().getColor(R$color.fd_sys_color_on_surface_variant_default);
        this.mNormalTextColor = color;
        b0(this.mSelectTextColor, color);
    }

    public final void G(Context context) throws Resources.NotFoundException {
        this.mContext = context;
        this.mNormalTextSizes = new ArrayList();
        H(context);
        F(context);
        this.mViewAdapter = new j(this);
        this.mFadingMatrix = new Matrix();
        this.mFadingShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, context.getResources().getColor(R$color.fd_sys_color_surface_container_lowest_default), 16777215, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.mFadingPaint = paint;
        paint.setShader(this.mFadingShader);
        this.mFadingHeight = context.getResources().getDimension(R$dimen.mc_picker_fading_height);
        this.mRange = new n();
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        x();
        a aVar = null;
        this.mSoundPoolHelper = new m(aVar);
        u(new i(this, aVar));
        u(new o(this, aVar));
        this.mTextPaint.setAntiAlias(true);
    }

    public final void H(Context context) throws Resources.NotFoundException {
        this.mWheelScroller = new k(getContext(), this.mScrollingListener);
        this.mSelectTextSize = context.getResources().getDimension(R$dimen.mc_picker_selected_number_size);
        this.mNormalTextSize = context.getResources().getDimension(R$dimen.mc_picker_normal_number_size);
        this.mSelectItemHeight = context.getResources().getDimension(R$dimen.mc_picker_select_item_height);
        float dimension = context.getResources().getDimension(R$dimen.mc_picker_normal_item_height);
        this.mNormalItemHeight = dimension;
        d0(this.mSelectTextSize, this.mNormalTextSize, this.mSelectItemHeight, dimension);
    }

    public boolean I() {
        return this.isCyclic;
    }

    public boolean J() {
        return this.isShowMarquee;
    }

    public final boolean K(int i10) {
        j jVar = this.mViewAdapter;
        if (jVar == null || jVar.b() <= 0) {
            return false;
        }
        if (this.isCyclic) {
            return true;
        }
        return i10 >= 0 && i10 < this.mViewAdapter.b();
    }

    public final void L() {
        O6.c.i(this, SCROLLER_SCROLL, 6);
    }

    public int M(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        this.mTextPaint.setTextSize(this.mSelectTextSize);
        this.mTextPaint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i10 = 0; i10 < length; i10++) {
            iCeil += (int) Math.ceil(r2[i10]);
        }
        return iCeil;
    }

    public void N(int i10, int i11) {
        Iterator<f> it = this.mChangingListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10, i11);
        }
    }

    public void O(int i10) {
        Y(i10, true);
        Iterator<g> it = this.mClickingListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10);
        }
    }

    public void P() {
        e eVar = this.mDataInterface;
        if (eVar != null) {
            eVar.b(this, 0, getCurrentItem());
        }
        Iterator<h> it = this.mScrollingListeners.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    public void Q() {
        Iterator<h> it = this.mScrollingListeners.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public final void R() {
        m mVar = this.mSoundPoolHelper;
        if (mVar != null) {
            mVar.f();
        }
    }

    public final boolean S() {
        n itemsRange = getItemsRange();
        this.mRange = itemsRange;
        if (this.mFirstItem <= itemsRange.b() || this.mFirstItem > this.mRange.c()) {
            this.mFirstItem = this.mRange.b();
            return false;
        }
        int i10 = this.mFirstItem;
        while (true) {
            i10--;
            if (i10 < this.mRange.b()) {
                return false;
            }
            this.mFirstItem = i10;
        }
    }

    public void T(int i10) {
        W(i10, this.mCurrentItem, 0, i10 - 1);
    }

    public void U(int i10, int i11) {
        int i12 = this.mCurrentItem + i11;
        this.mCurrentItem = i12;
        W(i10, i12, 0, i10 - 1);
    }

    public void V(int i10) {
        W(this.mViewAdapter.b(), i10, this.mViewAdapter.d(), this.mViewAdapter.c());
    }

    public void W(int i10, int i11, int i12, int i13) {
        e eVar;
        h0();
        if (i10 < 0) {
            return;
        }
        setViewAdapter(this.mViewAdapter.e(i10, i12, i13));
        int i14 = this.mCurrentItem;
        if (i11 != i14) {
            int iMax = Math.max(i11, i12);
            this.mCurrentItem = iMax;
            if (iMax > i13 || iMax >= i10) {
                this.mCurrentItem = Math.min(i13, i10);
            }
        }
        int i15 = this.mCurrentItem;
        if (i14 != i15 && (eVar = this.mDataInterface) != null) {
            eVar.b(this, i14, i15);
        }
        invalidate();
    }

    public void X(int i10, int i11) {
        this.mWheelScroller.n((i10 * getItemHeight()) + this.mScrollingOffset, i11);
    }

    public void Y(int i10, boolean z10) {
        int iMin;
        j jVar = this.mViewAdapter;
        if (jVar == null || jVar.b() == 0) {
            return;
        }
        int iB = this.mViewAdapter.b();
        if (i10 < 0 || i10 >= iB) {
            if (!this.isCyclic) {
                return;
            }
            while (i10 < 0) {
                i10 += iB;
            }
            i10 %= iB;
        }
        int i11 = this.mCurrentItem;
        if (i10 != i11) {
            if (!z10) {
                this.mScrollingOffset = 0;
                this.mCurrentItem = i10;
                N(i11, i10);
                invalidate();
                return;
            }
            int i12 = i10 - i11;
            if (this.isCyclic && (iMin = (iB + Math.min(i10, i11)) - Math.max(i10, this.mCurrentItem)) < Math.abs(i12)) {
                i12 = i12 < 0 ? iMin : -iMin;
            }
            X(i12, 0);
        }
    }

    public void Z(e eVar, float f10, int i10, int i11, int i12, int i13, int i14, boolean z10) {
        setIDataAdapter(eVar);
        this.mVisibleItems = i12;
        this.isCyclic = z10;
        if (f10 == -1.0f) {
            this.mOffsetY = getResources().getDimensionPixelSize(R$dimen.mc_picker_offset_y);
        } else {
            this.mOffsetY = (int) (f10 * getContext().getResources().getDisplayMetrics().density);
        }
        if (i11 < this.mVisibleItems || i14 + 1 < i11 || i13 > 0) {
            this.isCyclic = false;
        }
        W(i11, i10, i13, i14);
    }

    public void a0(float f10, float f11) {
        d0(this.mSelectTextSize, this.mNormalTextSize, f10, f11);
    }

    public void b0(int i10, int i11) {
        this.mSelectTextColor = i10;
        this.mNormalTextColor = i11;
        this.mNormalTextColors = new ArrayList();
        int i12 = this.mVisibleItems - 1;
        for (int i13 = 0; i13 < i12 / 2; i13++) {
            this.mNormalTextColors.add(Integer.valueOf(this.mNormalTextColor));
        }
        invalidate();
    }

    public void c0(int i10, List<Integer> list) {
        this.mSelectTextColor = i10;
        if (list != null && this.mNormalTextColors != list) {
            this.mNormalTextColor = list.get(0).intValue();
            this.mNormalTextColors = new ArrayList();
            int i11 = this.mVisibleItems - 1;
            for (int i12 = 0; i12 < i11 / 2; i12++) {
                int size = list.size();
                if (i12 < size) {
                    this.mNormalTextColors.add(list.get(i12));
                } else {
                    this.mNormalTextColors.add(list.get(size - 1));
                }
            }
        }
        invalidate();
    }

    public void d0(float f10, float f11, float f12, float f13) {
        this.mSelectItemHeight = f12;
        this.mNormalItemHeight = f13;
        this.mSelectTextSize = f10;
        this.mNormalTextSize = f11;
        this.mNormalTextSizes = new ArrayList();
        int i10 = this.mVisibleItems - 1;
        for (int i11 = 0; i11 < i10 / 2; i11++) {
            this.mNormalTextSizes.add(Float.valueOf(this.mNormalTextSize));
        }
        x();
        invalidate();
    }

    public void e0(float f10, List<Float> list, float f11, float f12) {
        if (this.mSelectItemHeight == f11 && this.mNormalItemHeight == f12 && this.mSelectTextSize == f10 && list == null) {
            return;
        }
        this.mSelectItemHeight = f11;
        this.mSelectTextSize = f10;
        this.mNormalItemHeight = f12;
        if (list != null && this.mNormalTextSizes != list) {
            this.mNormalTextSize = list.get(0).floatValue();
            this.mNormalTextSizes = new ArrayList();
            int i10 = this.mVisibleItems - 1;
            for (int i11 = 0; i11 < i10 / 2; i11++) {
                int size = list.size();
                if (i11 < size) {
                    this.mNormalTextSizes.add(list.get(i11));
                } else {
                    this.mNormalTextSizes.add(list.get(size - 1));
                }
            }
        }
        x();
        invalidate();
    }

    public void f0(float f10, float f11) {
        d0(f10, f11, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public void g0(float f10, List<Float> list) {
        if (f10 == this.mSelectTextSize && list == null) {
            return;
        }
        e0(f10, list, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public e getIDataAdapter() {
        return this.mDataInterface;
    }

    public int getItemHeight() {
        return (int) this.mNormalItemHeight;
    }

    public int getItemsCount() {
        return this.mViewAdapter.b();
    }

    public int getSelectedItemHeight() {
        return (int) this.mSelectItemHeight;
    }

    public j getViewAdapter() {
        return this.mViewAdapter;
    }

    public int getVisibleItems() {
        return this.mVisibleItems;
    }

    public void h0() {
        k kVar = this.mWheelScroller;
        if (kVar != null) {
            kVar.r();
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m mVar = this.mSoundPoolHelper;
        if (mVar != null) {
            mVar.e(this.mContext);
        }
        post(new c());
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m mVar = this.mSoundPoolHelper;
        if (mVar != null) {
            mVar.g();
        }
        k kVar = this.mWheelScroller;
        if (kVar != null) {
            kVar.j();
        }
        removeCallbacks(this.mTextRunnable);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j jVar = this.mViewAdapter;
        if (jVar != null && jVar.b() > 0) {
            S();
            C(canvas);
        }
        if (this.mIsDrawFading) {
            D(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ScrollTextView.class.getName());
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            return;
        }
        setMeasuredDimension(getMeasuredWidthAndState(), (int) (((this.mVisibleItems - 1) * this.mNormalItemHeight) + this.mSelectItemHeight));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || getViewAdapter() == null) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2 && getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(this.mParentRequestDisallowInterceptTouchEvent);
            }
        } else if (!this.isScrollingPerformed) {
            int y10 = ((int) motionEvent.getY()) - (getHeight() / 2);
            int itemHeight = ((int) (y10 < 0 ? y10 + ((this.mSelectItemHeight / 2.0f) - getItemHeight()) : y10 - ((this.mSelectItemHeight / 2.0f) - getItemHeight()))) / getItemHeight();
            if (itemHeight != 0 && K(this.mCurrentItem + itemHeight)) {
                O(this.mCurrentItem + itemHeight);
            }
        }
        return this.mWheelScroller.m(motionEvent);
    }

    public void setCurrentItem(int i10) {
        Y(i10, false);
    }

    public void setCyclic(boolean z10) {
        this.isCyclic = z10;
        invalidate();
    }

    public void setFadingHeight(float f10) {
        if (this.mFadingHeight != f10) {
            this.mFadingHeight = f10;
            invalidate();
        }
    }

    public void setFadingShader(Shader shader) {
        this.mFadingShader = shader;
        this.mFadingPaint.setShader(shader);
        invalidate();
    }

    public void setFadingShaderColor(int i10) {
        this.mFadingShader = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, i10, 16777215, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        this.mFadingPaint = paint;
        paint.setShader(this.mFadingShader);
    }

    public void setHorizontalOffset(int i10) {
        this.mOffsetX = i10;
    }

    public void setIDataAdapter(e eVar) {
        this.mDataInterface = eVar;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mWheelScroller.o(interpolator);
    }

    public void setIsDrawFading(boolean z10) {
        this.mIsDrawFading = z10;
    }

    public void setNormalItemHeight(float f10) {
        d0(this.mSelectTextSize, this.mNormalTextSize, this.mSelectItemHeight, f10);
    }

    public void setNormalTextColor(int i10) {
        if (this.mNormalTextColor == i10) {
            return;
        }
        b0(this.mSelectTextColor, i10);
    }

    public void setNormalTextSize(float f10) {
        d0(this.mSelectTextSize, f10, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public void setParentRequestDisallowInterceptTouchEvent(boolean z10) {
        this.mParentRequestDisallowInterceptTouchEvent = z10;
    }

    @Override // android.view.View
    public void setScrollY(int i10) {
        int i11 = this.mWheelScroller.lastScrollY - i10;
        this.mWheelScroller.lastScrollY = i10;
        this.mWheelScroller.listener.a(i11);
    }

    public void setSelectItemHeight(float f10) {
        d0(this.mSelectTextSize, this.mNormalTextSize, f10, this.mNormalItemHeight);
    }

    public void setSelectTextColor(int i10) {
        if (this.mSelectTextColor == i10) {
            return;
        }
        c0(i10, this.mNormalTextColors);
    }

    public void setSelectTextSize(float f10) {
        d0(f10, this.mNormalTextSize, this.mSelectItemHeight, this.mNormalItemHeight);
    }

    public void setShowMarquee(boolean z10) {
        this.isShowMarquee = z10;
    }

    public void setTypeface(Typeface typeface) {
        this.mTextPaint.setTypeface(typeface);
        x();
        invalidate();
    }

    public void setVisibleItems(int i10) {
        this.mVisibleItems = i10;
    }

    public void u(f fVar) {
        this.mChangingListeners.add(fVar);
    }

    public void v(h hVar) {
        this.mScrollingListeners.add(hVar);
    }

    public final void w() {
        androidx.dynamicanimation.animation.i iVar = this.mSpringAnimation;
        if (iVar == null || !iVar.i()) {
            return;
        }
        this.mSpringAnimation.d();
    }

    public final void x() {
        this.mTextPaint.setTextSize(this.mSelectTextSize);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        this.mSelectFontMetricsCenterY = (fontMetricsInt.bottom + fontMetricsInt.top) / 2.0f;
        this.mTextPaint.setTextSize(this.mNormalTextSize);
        Paint.FontMetricsInt fontMetricsInt2 = this.mTextPaint.getFontMetricsInt();
        this.mNormalFontMetricsCenterY = (fontMetricsInt2.bottom + fontMetricsInt2.top) / 2.0f;
    }

    public final void y(int i10, float f10) {
        float f11;
        float fFloatValue;
        float f12;
        float f13;
        int iIntValue;
        int i11 = this.mVisibleItems;
        int i12 = i11 / 2;
        int iIntValue2 = this.mSelectTextColor;
        if (i10 < i12 || i10 > i12 + 1) {
            this.mFontMetricsCenterY = this.mNormalFontMetricsCenterY;
        } else {
            float f14 = this.mNormalFontMetricsCenterY;
            this.mFontMetricsCenterY = f14 + ((this.mSelectFontMetricsCenterY - f14) * f10);
        }
        if (i10 > i12) {
            i10 = i11 - i10;
        }
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 == 0) {
            iIntValue2 = this.mNormalTextColors.get(i10).intValue();
            iIntValue = this.mNormalTextColors.get(i10).intValue();
            float fFloatValue2 = this.mNormalTextSizes.get(i10).floatValue();
            fFloatValue = this.mNormalTextSizes.get(i10).floatValue();
            f12 = 0.0f;
            f11 = fFloatValue2;
            f13 = 0.0f;
        } else if (i10 < i12) {
            iIntValue2 = this.mNormalTextColors.get(i10).intValue();
            int i13 = i10 - 1;
            int iIntValue3 = this.mNormalTextColors.get(i13).intValue();
            float fFloatValue3 = this.mNormalTextSizes.get(i10).floatValue();
            float fFloatValue4 = this.mNormalTextSizes.get(i13).floatValue();
            f11 = fFloatValue3;
            fFloatValue = fFloatValue4;
            f13 = f10;
            iIntValue = iIntValue3;
            f12 = 0.0f;
        } else {
            int i14 = i10 - 1;
            int iIntValue4 = this.mNormalTextColors.get(i14).intValue();
            f11 = this.mSelectTextSize;
            fFloatValue = this.mNormalTextSizes.get(i14).floatValue();
            f12 = 2.0f;
            f13 = f10;
            iIntValue = iIntValue4;
        }
        int iAlpha = Color.alpha(iIntValue2);
        int iRed = Color.red(iIntValue2);
        int iGreen = Color.green(iIntValue2);
        int iBlue = Color.blue(iIntValue2);
        this.mTextPaint.setColor(Color.argb(Color.alpha(iIntValue) + ((int) ((iAlpha - r8) * f13)), Color.red(iIntValue) + ((int) ((iRed - r9) * f13)), Color.green(iIntValue) + ((int) ((iGreen - r10) * f13)), Color.blue(iIntValue) + ((int) ((iBlue - r14) * f13))));
        this.mTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mTextPaint.setStrokeWidth(0.0f + ((f12 - 0.0f) * f13));
        this.mTextPaint.setTextSize(fFloatValue + ((f11 - fFloatValue) * f13));
    }

    public final float z(int i10, float f10) {
        float f11;
        float itemHeight = getItemHeight();
        int i11 = (int) (this.mSelectItemHeight - this.mNormalItemHeight);
        int i12 = this.mVisibleItems / 2;
        if (i10 >= i12) {
            if (i10 == i12) {
                f11 = i11;
            } else {
                if (i10 == i12 + 1) {
                    itemHeight += i11 / 2.0f;
                } else if (i10 == i12 + 2) {
                    f11 = i11;
                    f10 = 1.0f - f10;
                }
                f10 = 1.0f - f10;
            }
            itemHeight += (f11 * f10) / 2.0f;
        }
        y(i10, f10);
        return itemHeight;
    }

    public void setNormalTextSize(List<Float> list) {
        if (list != null) {
            e0(this.mSelectTextSize, list, this.mSelectItemHeight, this.mNormalItemHeight);
        }
    }

    public void setNormalTextColor(List<Integer> list) {
        c0(this.mSelectTextColor, list);
    }

    public static class m {
        public Context mContext;
        public boolean mIsFinishedLoad;
        public boolean mIsRelease;
        private Handler mSoundHander;
        private Looper mSoundLooper;
        public SoundPool mSoundPool;
        private Thread mSoundPoolThread;
        public int mVoiceID;

        public class a implements Runnable {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            /* renamed from: com.stepos.common.widget.ScrollTextView$m$a$a, reason: collision with other inner class name */
            public class C0352a implements SoundPool.OnLoadCompleteListener {
                public C0352a() {
                }

                @Override // android.media.SoundPool.OnLoadCompleteListener
                public void onLoadComplete(SoundPool soundPool, int i10, int i11) {
                    m.this.mIsFinishedLoad = true;
                }
            }

            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v12 */
            /* JADX WARN: Type inference failed for: r5v13 */
            @Override // java.lang.Runnable
            public void run() throws IllegalArgumentException {
                SoundPool.Builder builder = new SoundPool.Builder();
                builder.setMaxStreams(1);
                AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
                builder2.setLegacyStreamType(1);
                builder.setAudioAttributes(builder2.build());
                m.this.mSoundPool = builder.build();
                m.this.mSoundPool.setOnLoadCompleteListener(new C0352a());
                try {
                    try {
                        m mVar = m.this;
                        mVar.mVoiceID = mVar.mSoundPool.load(mVar.mContext, R$raw.mc_picker_scrolled, 1);
                        Looper.prepare();
                        synchronized (m.this) {
                            m mVar2 = m.this;
                            if (mVar2.mIsRelease) {
                                this = mVar2.mSoundPool;
                            } else {
                                mVar2.mSoundLooper = Looper.myLooper();
                                m.this.mSoundHander = new Handler(m.this.mSoundLooper);
                                Looper.loop();
                                this = m.this.mSoundPool;
                            }
                        }
                    } catch (Exception unused) {
                        m mVar3 = m.this;
                        mVar3.mIsFinishedLoad = false;
                        this = mVar3.mSoundPool;
                    }
                    this.release();
                } catch (Throwable th) {
                    m.this.mSoundPool.release();
                    throw th;
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m mVar = m.this;
                if (mVar.mIsFinishedLoad) {
                    mVar.mSoundPool.play(mVar.mVoiceID, 0.5f, 0.5f, 0, 0, 1.0f);
                }
            }
        }

        public m() {
            this.mSoundPoolThread = null;
            this.mSoundHander = null;
            this.mSoundLooper = null;
        }

        public void d(Context context) {
            this.mContext = context.getApplicationContext();
            this.mIsFinishedLoad = false;
            this.mIsRelease = false;
            Thread thread = new Thread(new a());
            this.mSoundPoolThread = thread;
            thread.start();
        }

        public void e(Context context) {
            if (this.mIsFinishedLoad) {
                return;
            }
            d(context);
        }

        public void f() {
            Handler handler = this.mSoundHander;
            if (handler != null) {
                handler.post(new b());
            }
        }

        public void g() {
            synchronized (this) {
                try {
                    this.mIsRelease = true;
                    Handler handler = this.mSoundHander;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        if (this.mIsFinishedLoad) {
                            this.mSoundPool.unload(this.mVoiceID);
                        }
                        this.mSoundPool.release();
                        this.mSoundLooper.quit();
                        this.mSoundPoolThread = null;
                        this.mIsFinishedLoad = false;
                        this.mContext = null;
                        this.mSoundHander = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ m(a aVar) {
            this();
        }
    }

    public ScrollTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
