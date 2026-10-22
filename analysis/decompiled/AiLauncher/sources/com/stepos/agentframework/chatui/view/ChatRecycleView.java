package com.stepos.agentframework.chatui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.AgentMarkdownCodeScrollView;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001$B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010\u0018J\u0017\u0010'\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00102\u0006\u0010&\u001a\u00020%2\u0006\u0010,\u001a\u00020\u001aH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b/\u0010(J\u000f\u00100\u001a\u00020\u0010H\u0002¢\u0006\u0004\b0\u0010\u0018J\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u0010\u0018J)\u00108\u001a\u0004\u0018\u0001012\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0002¢\u0006\u0004\b8\u00109J)\u0010:\u001a\u0004\u0018\u0001012\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0002¢\u0006\u0004\b:\u00109J\u0017\u0010;\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b;\u0010(J'\u0010<\u001a\u00020\u001a2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0002¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\u001a2\u0006\u00105\u001a\u000201H\u0002¢\u0006\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010CR\u0016\u0010E\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010H\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010I\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010FR\u0018\u0010J\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010KR\u0016\u0010M\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010FR\u0016\u0010N\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010FR\u0016\u0010O\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010FR\u0014\u0010P\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010AR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006U"}, d2 = {"Lcom/stepos/agentframework/chatui/view/ChatRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/stepos/agentframework/uikit/g0;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "getTopFadingEdgeStrength", "()F", "topPx", "bottomPx", "topHoldPx", "bottomHoldPx", "LY8/t;", "o", "(FFFF)V", "Landroid/graphics/Canvas;", "canvas", "dispatchDraw", "(Landroid/graphics/Canvas;)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "", "m", "()Z", "", "direction", "canScrollVertically", "(I)Z", "disallowIntercept", "requestDisallowInterceptTouchEvent", "(Z)V", Const.INTENT_KEY_APIKEY, "Landroid/view/MotionEvent;", "e", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "r", "(Landroid/view/MotionEvent;)V", "fromIntercept", "c", "(Landroid/view/MotionEvent;Z)V", "q", "f", "Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Landroid/view/View;", "n", "view", "x", "y", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;FF)Landroid/view/View;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "(Landroid/view/View;FF)Z", "l", "(Landroid/view/View;)Z", "touchSlop", "I", "downX", "F", "downY", "gestureDecided", "Z", "interceptingVertical", "appliedInitialDelta", "allowChildDisallow", "hScrollChildUnderDown", "Landroid/view/View;", "vScrollCodeChildUnderDown", "lockingHorizontal", "innerCodeScrolledThisGesture", "insideDraggableSheet", "visualBottomSlopPx", "Lcom/stepos/agentframework/chatui/view/I0;", "viewportFade", "Lcom/stepos/agentframework/chatui/view/I0;", "Companion", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChatRecycleView extends RecyclerView implements com.stepos.agentframework.uikit.g0 {
    private static final String DRAGGABLE_SHEET_LAYOUT = "com.stepos.ailauncher.sheet.widget.DraggableSheetLayout";
    private static final float HORIZONTAL_CHILD_VERTICAL_RATIO = 1.5f;
    private boolean allowChildDisallow;
    private boolean appliedInitialDelta;
    private float downX;
    private float downY;
    private boolean gestureDecided;
    private View hScrollChildUnderDown;
    private boolean innerCodeScrolledThisGesture;
    private boolean insideDraggableSheet;
    private boolean interceptingVertical;
    private boolean lockingHorizontal;
    private final int touchSlop;
    private View vScrollCodeChildUnderDown;
    private final I0 viewportFade;
    private final int visualBottomSlopPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.visualBottomSlopPx = C5685n.f((int) (getResources().getDisplayMetrics().density * 8.0f), 2);
        this.viewportFade = new I0();
    }

    public static final Y8.t e(ChatRecycleView chatRecycleView, Canvas it) {
        kotlin.jvm.internal.p.i(it, "it");
        super.dispatchDraw(it);
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void p(ChatRecycleView chatRecycleView, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        chatRecycleView.o(f10, f11, f12, f13);
    }

    @Override // com.stepos.agentframework.uikit.g0
    public void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.requestDisallowInterceptTouchEvent(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        startNestedScroll(2);
        if (this.innerCodeScrolledThisGesture) {
            n();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.MotionEvent r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.view.ChatRecycleView.c(android.view.MotionEvent, boolean):void");
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        if (direction > 0 && this.insideDraggableSheet && m()) {
            return false;
        }
        return super.canScrollVertically(direction);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.p.i(canvas, "canvas");
        this.viewportFade.a(this, canvas, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.view.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ChatRecycleView.e(this.f23126a, (Canvas) obj);
            }
        });
    }

    public final void f() {
        this.gestureDecided = false;
        this.interceptingVertical = false;
        this.appliedInitialDelta = false;
        this.allowChildDisallow = false;
        this.hScrollChildUnderDown = null;
        this.vScrollCodeChildUnderDown = null;
        this.lockingHorizontal = false;
        this.innerCodeScrolledThisGesture = false;
        stopNestedScroll();
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.stepos.agentframework.chatui.view.ChatRecycleView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public final View g() {
        while (this != 0) {
            if (kotlin.jvm.internal.p.d(this.getClass().getName(), DRAGGABLE_SHEET_LAYOUT)) {
                return this;
            }
            Object parent = this.getParent();
            this = parent instanceof View ? (View) parent : 0;
        }
        return null;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public final View h(View view, float x10, float y10) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            float scrollX = x10 + viewGroup.getScrollX();
            float scrollY = y10 + viewGroup.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                float left = (scrollX - childAt.getLeft()) - childAt.getTranslationX();
                float top = (scrollY - childAt.getTop()) - childAt.getTranslationY();
                if (left >= 0.0f && left < childAt.getWidth() && top >= 0.0f && top < childAt.getHeight()) {
                    kotlin.jvm.internal.p.f(childAt);
                    View viewH = h(childAt, left, top);
                    if (viewH != null) {
                        return viewH;
                    }
                }
            }
        }
        if (view.canScrollHorizontally(-1) || view.canScrollHorizontally(1)) {
            return view;
        }
        return null;
    }

    public final View i(View view, float x10, float y10) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            float scrollX = x10 + viewGroup.getScrollX();
            float scrollY = y10 + viewGroup.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                float left = (scrollX - childAt.getLeft()) - childAt.getTranslationX();
                float top = (scrollY - childAt.getTop()) - childAt.getTranslationY();
                if (left >= 0.0f && left < childAt.getWidth() && top >= 0.0f && top < childAt.getHeight()) {
                    kotlin.jvm.internal.p.f(childAt);
                    View viewI = i(childAt, left, top);
                    if (viewI != null) {
                        return viewI;
                    }
                }
            }
        }
        if ((view instanceof AgentMarkdownCodeScrollView) && (view.canScrollVertically(1) || view.canScrollVertically(-1))) {
            return view;
        }
        return null;
    }

    public final boolean j(MotionEvent e10) {
        return k(this, e10.getX(), e10.getY());
    }

    public final boolean k(View view, float x10, float y10) {
        if (x10 < 0.0f || y10 < 0.0f || x10 > view.getWidth() || y10 > view.getHeight() || view.getVisibility() != 0) {
            return false;
        }
        boolean z10 = view instanceof NestedScrollableHost;
        if (z10) {
            NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) view;
            return nestedScrollableHost.canScrollHorizontally(1) || nestedScrollableHost.canScrollHorizontally(-1);
        }
        if (z10 || l(view) || (view instanceof ViewPager2)) {
            return true;
        }
        if ((view instanceof HorizontalScrollView) && (view.canScrollHorizontally(1) || view.canScrollHorizontally(-1))) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = viewGroup.getScrollX();
            int scrollY = viewGroup.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                kotlin.jvm.internal.p.f(childAt);
                if (k(childAt, (scrollX + x10) - childAt.getLeft(), (scrollY + y10) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l(View view) {
        return kotlin.jvm.internal.p.d(view.getClass().getName(), "com.stepos.ailauncher.foundation.appui.card.provider.amap.NestedScrollableHost");
    }

    public final boolean m() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || !linearLayoutManager.getReverseLayout()) {
            return false;
        }
        RecyclerView.Adapter adapter = getAdapter();
        if ((adapter != null ? adapter.getItemCount() : 0) == 0) {
            return true;
        }
        View viewFindViewByPosition = linearLayoutManager.findViewByPosition(0);
        return viewFindViewByPosition != null && linearLayoutManager.getDecoratedBottom(viewFindViewByPosition) <= (getHeight() - getPaddingBottom()) + this.visualBottomSlopPx;
    }

    public final void n() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        View viewG = g();
        if (viewG == null) {
            return;
        }
        try {
            viewG.getClass().getMethod("notifyInnerContentScrolled", null).invoke(viewG, null);
        } catch (ReflectiveOperationException unused) {
        }
    }

    public final void o(float topPx, float bottomPx, float topHoldPx, float bottomHoldPx) {
        if (this.viewportFade.c(topPx, bottomPx, topHoldPx, bottomHoldPx)) {
            invalidate();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.insideDraggableSheet = g() != null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.insideDraggableSheet = false;
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        if (e10.getActionMasked() == 0) {
            r(e10);
            if (j(e10) || this.vScrollCodeChildUnderDown != null) {
                this.allowChildDisallow = true;
            }
            super.onInterceptTouchEvent(e10);
            return false;
        }
        if (e10.getActionMasked() == 2) {
            if (q(e10)) {
                this.interceptingVertical = false;
                this.innerCodeScrolledThisGesture = true;
                return false;
            }
            c(e10, true);
        }
        if ((this.allowChildDisallow || this.lockingHorizontal) && !this.interceptingVertical && (!this.gestureDecided || this.lockingHorizontal)) {
            return false;
        }
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(e10);
        if (e10.getActionMasked() == 1 || e10.getActionMasked() == 3) {
            f();
        }
        if (this.hScrollChildUnderDown == null || this.interceptingVertical || this.gestureDecided) {
            return this.interceptingVertical || zOnInterceptTouchEvent;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        if (e10.getActionMasked() == 2) {
            c(e10, false);
        }
        boolean z10 = this.interceptingVertical;
        if (e10.getActionMasked() == 2 && z10 && !this.appliedInitialDelta) {
            this.appliedInitialDelta = true;
            int y10 = (int) (this.downY - e10.getY());
            if (y10 != 0 && (!this.insideDraggableSheet || y10 <= 0 || !m())) {
                scrollBy(0, y10);
            }
        }
        boolean zOnTouchEvent = super.onTouchEvent(e10);
        if (e10.getActionMasked() == 1 || e10.getActionMasked() == 3) {
            f();
        }
        return zOnTouchEvent || z10;
    }

    public final boolean q(MotionEvent e10) {
        View view = this.vScrollCodeChildUnderDown;
        if (view == null) {
            return false;
        }
        float x10 = e10.getX() - this.downX;
        float y10 = e10.getY() - this.downY;
        float fAbs = Math.abs(x10);
        float fAbs2 = Math.abs(y10);
        float f10 = fAbs * 0.5f;
        if (f10 <= this.touchSlop || f10 < fAbs2) {
            return view.canScrollVertically(y10 < 0.0f ? 1 : -1);
        }
        return false;
    }

    public final void r(MotionEvent e10) {
        this.downX = e10.getX();
        this.downY = e10.getY();
        this.gestureDecided = false;
        this.interceptingVertical = false;
        this.appliedInitialDelta = false;
        this.hScrollChildUnderDown = h(this, e10.getX(), e10.getY());
        View viewI = i(this, e10.getX(), e10.getY());
        this.vScrollCodeChildUnderDown = viewI;
        this.lockingHorizontal = false;
        this.innerCodeScrolledThisGesture = false;
        this.allowChildDisallow = (this.hScrollChildUnderDown == null && viewI == null) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (!disallowIntercept || this.allowChildDisallow) {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }
}
