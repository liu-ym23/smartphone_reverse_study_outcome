package com.tmall.wireless.tangram.ext;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.view.RecyclerviewCompat;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.card.SwipeCard;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SwipeItemTouchListener implements RecyclerView.OnItemTouchListener {
    private static final int SWIPING_HOR = 1;
    private static final int SWIPING_NONE = -1;
    private static final int SWIPING_VER = 2;
    private static final String TAG = "TangramEngine";
    private Card currCard;
    private int currCardIdx;
    private MotionEvent lastMotionEvent;
    private VirtualLayoutManager layoutManager;
    private int mActionEdge;
    private List<View> mChildList;
    private float mDistanceX;
    private float mDistanceY;
    private GroupBasicAdapter mGroupBasicAdapter;
    private WeakReference<SwipeCard> mSwipeCardRef;
    private GestureDetectorCompat mSwipeGestureDector;
    private PullFromEndListener pullFromEndListener;
    private RecyclerviewCompat recyclerView;
    private RecyclerView.OnScrollListener scrollListener;
    private int swipeType;

    public class SwipeGestureListener extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ SwipeItemTouchListener this$0;

        private SwipeGestureListener(SwipeItemTouchListener r10) {
            this.this$0 = r10;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r10, MotionEvent r11, float r12, float r13) {
            int r14 = 0;
            if (r10 == null) goto L64;
            if (r11 == null) goto L64;
            SwipeItemTouchListener.access$302(this.this$0, r11);
            SwipeItemTouchListener.access$802(this.this$0, r11.getX() - r10.getX());
            SwipeItemTouchListener.access$902(this.this$0, r11.getY() - r10.getY());
            if (SwipeItemTouchListener.access$1000(this.this$0) == null) goto L64;
            if ((SwipeItemTouchListener.access$700(this.this$0) instanceof SwipeCard) == false) goto L64;
            SwipeItemTouchListener.access$102(this.this$0, new WeakReference((SwipeCard) SwipeItemTouchListener.access$700(this.this$0)));
            if (SwipeItemTouchListener.access$1100(this.this$0) == true) goto L27;
            if (Math.abs(r12) <= Math.abs(r13)) goto L16;
            SwipeItemTouchListener.access$1202(this.this$0, 1);
            i.b(SwipeItemTouchListener.TAG, "onScroll: hor");
            goto L27
        L16:
            if (SwipeItemTouchListener.access$1300(this.this$0) != null) goto L18;
        L24:
            i.b(SwipeItemTouchListener.TAG, "onScroll: none");
            return false;
        L18:
            if (Math.abs(r12) >= Math.abs(r13)) goto L24;
            if (SwipeItemTouchListener.access$900(this.this$0) >= 0.0f) goto L24;
            if (SwipeItemTouchListener.access$1400(this.this$0) == false) goto L24;
            SwipeItemTouchListener.access$1202(this.this$0, 2);
            i.b(SwipeItemTouchListener.TAG, "onScroll: ver");
        L27:
            if (SwipeItemTouchListener.access$1200(this.this$0) != 1) goto L42;
        L29:
            if (r14 >= SwipeItemTouchListener.access$1000(this.this$0).getChildCount()) goto L62;
            View r15 = SwipeItemTouchListener.access$1000(this.this$0).getChildAt(r14);
            if (SwipeItemTouchListener.access$600(this.this$0).findCardIdxFor(SwipeItemTouchListener.access$400(this.this$0).getPosition(r15)) != SwipeItemTouchListener.access$500(this.this$0)) goto L40;
            if (SwipeItemTouchListener.access$200(this.this$0).contains(r15) == true) goto L36;
            SwipeItemTouchListener.access$200(this.this$0).add(r15);
        L36:
            if (SwipeItemTouchListener.access$800(this.this$0) <= 0.0f) goto L38;
            int r16 = 1;
        L39:
            r15.setTranslationX((float) (((double) (r16 * 10.0f)) * Math.sqrt(Math.abs(SwipeItemTouchListener.access$800(this.this$0)))));
            i.b(SwipeItemTouchListener.TAG, "onScroll: translationX");
            goto L40
        L38:
            r16 = -1;
        L40:
            r14 = r14 + 1;
        L62:
            return true;
        L42:
            if (SwipeItemTouchListener.access$1200(this.this$0) == 2) goto L44;
        L63:
            i.b(SwipeItemTouchListener.TAG, "onScroll: no hanlding");
            goto L64
        L44:
            if (SwipeItemTouchListener.access$900(this.this$0) >= 0.0f) goto L63;
        L46:
            if (r14 >= SwipeItemTouchListener.access$1000(this.this$0).getChildCount()) goto L62;
            View r17 = SwipeItemTouchListener.access$1000(this.this$0).getChildAt(r14);
            if (SwipeItemTouchListener.access$600(this.this$0).findCardIdxFor(SwipeItemTouchListener.access$400(this.this$0).getPosition(r17)) != SwipeItemTouchListener.access$500(this.this$0)) goto L61;
            if (SwipeItemTouchListener.access$200(this.this$0).contains(r17) == true) goto L53;
            SwipeItemTouchListener.access$200(this.this$0).add(r17);
        L53:
            if (SwipeItemTouchListener.access$900(this.this$0) <= 0.0f) goto L55;
            int r18 = 1;
        L57:
            if (SwipeItemTouchListener.access$900(this.this$0) >= (-SwipeItemTouchListener.access$1300(this.this$0).getPullEdge())) goto L59;
            SwipeItemTouchListener.access$1300(this.this$0).onReleaseToAction(SwipeItemTouchListener.access$800(this.this$0), SwipeItemTouchListener.access$900(this.this$0));
        L60:
            r17.setTranslationY((float) (((double) (r18 * 10.0f)) * Math.sqrt(Math.abs(SwipeItemTouchListener.access$900(this.this$0)))));
            i.b(SwipeItemTouchListener.TAG, "onScroll: translationY");
            goto L61
        L59:
            SwipeItemTouchListener.access$1300(this.this$0).onPull(SwipeItemTouchListener.access$800(this.this$0), SwipeItemTouchListener.access$900(this.this$0));
            goto L60
        L55:
            r18 = -1;
        L61:
            r14 = r14 + 1;
        L64:
            return false;
        }

        public /* synthetic */ SwipeGestureListener(SwipeItemTouchListener r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public SwipeItemTouchListener(Context r10, GroupBasicAdapter r11, RecyclerView r12) {
        this.swipeType = -1;
        this.mActionEdge = 0;
        RecyclerView.OnScrollListener r13 = new AnonymousClass2(this);
        this.scrollListener = r13;
        this.mGroupBasicAdapter = r11;
        RecyclerviewCompat r14 = (RecyclerviewCompat) r12;
        this.recyclerView = r14;
        r14.addOnScrollListener(r13);
        this.layoutManager = (VirtualLayoutManager) r12.getLayoutManager();
        this.mSwipeGestureDector = new GestureDetectorCompat(r10, new SwipeGestureListener(this, null));
        this.mChildList = new ArrayList();
    }

    public static /* synthetic */ WeakReference access$100(SwipeItemTouchListener r10) {
        return r10.mSwipeCardRef;
    }

    public static /* synthetic */ RecyclerviewCompat access$1000(SwipeItemTouchListener r10) {
        return r10.recyclerView;
    }

    public static /* synthetic */ WeakReference access$102(SwipeItemTouchListener r10, WeakReference r11) {
        r10.mSwipeCardRef = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$1100(SwipeItemTouchListener r10) {
        return r10.isSwiping();
    }

    public static /* synthetic */ int access$1200(SwipeItemTouchListener r10) {
        return r10.swipeType;
    }

    public static /* synthetic */ int access$1202(SwipeItemTouchListener r10, int r11) {
        r10.swipeType = r11;
        return r11;
    }

    public static /* synthetic */ PullFromEndListener access$1300(SwipeItemTouchListener r10) {
        return r10.pullFromEndListener;
    }

    public static /* synthetic */ boolean access$1400(SwipeItemTouchListener r10) {
        return r10.isReadyToPullFromEnd();
    }

    public static /* synthetic */ List access$200(SwipeItemTouchListener r10) {
        return r10.mChildList;
    }

    public static /* synthetic */ MotionEvent access$300(SwipeItemTouchListener r10) {
        return r10.lastMotionEvent;
    }

    public static /* synthetic */ MotionEvent access$302(SwipeItemTouchListener r10, MotionEvent r11) {
        r10.lastMotionEvent = r11;
        return r11;
    }

    public static /* synthetic */ VirtualLayoutManager access$400(SwipeItemTouchListener r10) {
        return r10.layoutManager;
    }

    public static /* synthetic */ int access$500(SwipeItemTouchListener r10) {
        return r10.currCardIdx;
    }

    public static /* synthetic */ int access$502(SwipeItemTouchListener r10, int r11) {
        r10.currCardIdx = r11;
        return r11;
    }

    public static /* synthetic */ GroupBasicAdapter access$600(SwipeItemTouchListener r10) {
        return r10.mGroupBasicAdapter;
    }

    public static /* synthetic */ Card access$700(SwipeItemTouchListener r10) {
        return r10.currCard;
    }

    public static /* synthetic */ Card access$702(SwipeItemTouchListener r10, Card r11) {
        r10.currCard = r11;
        return r11;
    }

    public static /* synthetic */ float access$800(SwipeItemTouchListener r10) {
        return r10.mDistanceX;
    }

    public static /* synthetic */ float access$802(SwipeItemTouchListener r10, float r11) {
        r10.mDistanceX = r11;
        return r11;
    }

    public static /* synthetic */ float access$900(SwipeItemTouchListener r10) {
        return r10.mDistanceY;
    }

    public static /* synthetic */ float access$902(SwipeItemTouchListener r10, float r11) {
        r10.mDistanceY = r11;
        return r11;
    }

    private View findCanScrollView(View r10) {
        if ((r10 instanceof ViewGroup) == false) goto L18;
        ViewGroup r11 = (ViewGroup) r10;
        if ((r11 instanceof UltraViewPager) == true) goto L9;
        if ((r11 instanceof RecyclerView) == true) goto L9;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= r11.getChildCount()) goto L18;
        View r13 = findCanScrollView(r11.getChildAt(r12));
        if (r13 != null) goto L16;
        r12 = r12 + 1;
        goto L13
    L16:
        return r13;
    L9:
        if (r11.getVisibility() != 0) goto L11;
        return r11;
    L18:
        return null;
    }

    private View findFixedChildViewUnder(MotionEvent r10) {
        int r11 = (int) r10.getX();
        int r12 = (int) r10.getY();
        List<View> r13 = getLayoutManager().getFixedViews();
        int r14 = r13.size() - 1;
    L3:
        if (r14 < 0) goto L14;
        View r15 = r13.get(r14);
        float r16 = r15.getTranslationX();
        float r17 = r15.getTranslationY();
        float r18 = r11;
        if (r18 < (r15.getLeft() + r16)) goto L13;
        if (r18 > (r15.getRight() + r16)) goto L13;
        float r19 = r12;
        if (r19 < (r15.getTop() + r17)) goto L13;
        if (r19 > (r15.getBottom() + r17)) goto L13;
        return r15;
    L13:
        r14 = r14 - 1;
        goto L3
    L14:
        return null;
    }

    private View findScrollableChildViewUnder(MotionEvent r10) {
        int r11 = (int) r10.getX();
        int r12 = (int) r10.getY();
        int r13 = getLayoutManager().findFirstVisibleItemPosition();
        int r14 = getLayoutManager().findLastVisibleItemPosition();
        int r15 = 0;
    L4:
        if (r15 > (r14 - r13)) goto L19;
        View r16 = getLayoutManager().getChildAt(r15);
        if ((r16 instanceof ViewGroup) == false) goto L18;
        float r17 = r16.getTranslationX();
        float r18 = r16.getTranslationY();
        float r19 = r11;
        if (r19 < (r16.getLeft() + r17)) goto L18;
        if (r19 > (r16.getRight() + r17)) goto L18;
        float r20 = r12;
        if (r20 < (r16.getTop() + r18)) goto L18;
        if (r20 > (r16.getBottom() + r18)) goto L18;
        if (findCanScrollView(r16) == null) goto L18;
        return r16;
    L18:
        r15 = r15 + 1;
        goto L4
    L19:
        return null;
    }

    private VirtualLayoutManager getLayoutManager() {
        return this.layoutManager;
    }

    private static boolean hasAdapter(RecyclerView r10) {
        if (r10.getAdapter() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isAttachedToWindow(RecyclerView r10) {
        return r10.isAttachedToWindow();
    }

    private boolean isReadyToPullFromEnd() {
        PullFromEndListener r10 = this.pullFromEndListener;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isReadyToPull() == false) goto L7;
        return true;
    }

    private boolean isSwiping() {
        if (this.swipeType == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private void resetViews(RecyclerView r17, final int r18, final boolean r19, final int r20) {
        int r10 = r17.getWidth();
        AnimatorSet r11 = new AnimatorSet();
        ArrayList r12 = new ArrayList();
        if (r18 != 2) goto L5;
        String r13 = "translationY";
    L6:
        Iterator<View> r14 = this.mChildList.iterator();
    L8:
        if (r14.hasNext() == false) goto L14;
        View r15 = r14.next();
        if (r19 == false) goto L12;
        ObjectAnimator r16 = ObjectAnimator.ofFloat(r15, r13, new float[]{r10 * r20}).setDuration(150);
        r16.setInterpolator(new AccelerateInterpolator());
    L13:
        r12.add(r16);
        goto L8
    L12:
        r16 = ObjectAnimator.ofFloat(r15, r13, new float[]{0.0f}).setDuration(150);
        r16.setInterpolator(new DecelerateInterpolator());
        goto L13
    L14:
        r11.playTogether(r12);
        r11.addListener(new AnonymousClass1(this, r18, r19, r20));
        r11.start();
        if (r18 != 2) goto L24;
        PullFromEndListener r21 = this.pullFromEndListener;
        if (r21 == null) goto L24;
        float r22 = this.mDistanceY;
        if (r22 < 0.0f) goto L21;
    L23:
        this.pullFromEndListener.onReset();
        goto L24
    L21:
        if (r22 >= (-r21.getPullEdge())) goto L23;
        this.pullFromEndListener.onAction();
    L24:
        this.swipeType = -1;
        return;
    L5:
        r13 = "translationX";
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView r10, MotionEvent r11) {
        if (r10.getScrollState() == 0) goto L5;
    L17:
        return false;
    L5:
        if (isAttachedToWindow(r10) == false) goto L17;
        if (hasAdapter(r10) == false) goto L17;
        if (findFixedChildViewUnder(r11) == null) goto L13;
        return false;
    L13:
        if (findScrollableChildViewUnder(r11) == null) goto L15;
        return false;
    L15:
        this.mSwipeGestureDector.a(r11);
        return isSwiping();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean r10) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView r10, MotionEvent r11) {
        this.mSwipeGestureDector.a(r11);
        boolean r12 = true;
        if (r11.getAction() == 1) goto L7;
        if (r11.getAction() == 3) goto L7;
        return;
    L7:
        if (this.swipeType != 1) goto L15;
        float r13 = Math.abs(this.mDistanceX);
        int r14 = this.mActionEdge;
        if (r14 > 0) goto L13;
        r14 = r10.getWidth() / 3;
    L13:
        if (r13 <= r14) goto L15;
        boolean r15 = true;
    L16:
        WeakReference<SwipeCard> r16 = this.mSwipeCardRef;
        if (r16 != null) goto L19;
    L31:
        boolean r17 = false;
    L32:
        int r18 = this.swipeType;
        int r19 = -1;
        if (r18 != 1) goto L38;
        if (this.mDistanceX > 0.0f) goto L41;
    L42:
        if (r15 == false) goto L45;
        if (r17 == true) goto L45;
    L46:
        resetViews(r10, r18, r12, r19);
        return;
    L45:
        r12 = false;
    L41:
        r19 = 1;
        goto L42
    L38:
        if (r18 != 2) goto L41;
        if (this.mDistanceY <= 0.0f) goto L42;
    L19:
        if (r16.get() == null) goto L31;
        if (this.swipeType != 1) goto L31;
        SwipeCard r20 = this.mSwipeCardRef.get();
        if (r20.getCurrentIndex() != 0) goto L27;
        if (this.mDistanceX <= 0.0f) goto L27;
    L30:
        r17 = true;
    L27:
        if (r20.getCurrentIndex() != (r20.getTotalPage() - 1)) goto L31;
        if (this.mDistanceX >= 0.0f) goto L31;
    L15:
        r15 = false;
        goto L16
    }

    public void setActionEdge(int r10) {
        this.mActionEdge = r10;
    }

    public void setPullFromEndListener(PullFromEndListener r10) {
        this.pullFromEndListener = r10;
    }
}
