package com.stepos.widget.topbar;

import Y8.t;
import Z8.C1173v;
import Z8.M;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.tabbar.StepOSTabBar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;
import v9.C5680i;
import v9.C5685n;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u0000 z2\u00020\u0001:\u0001zB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\rJ\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010\rJ\u0017\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010&J\u0017\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0015¢\u0006\u0004\b/\u00100J\u001f\u00102\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0006H\u0014¢\u0006\u0004\b2\u00103J7\u00109\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0014¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0014H\u0014¢\u0006\u0004\b;\u0010<J\u0019\u0010>\u001a\u00020\u000b2\b\b\u0001\u0010=\u001a\u00020\u0006H\u0014¢\u0006\u0004\b>\u0010&J\u000f\u0010?\u001a\u00020\u000bH\u0014¢\u0006\u0004\b?\u0010\rJ\u0017\u0010B\u001a\u00020\u00142\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\u00142\u0006\u0010D\u001a\u00020@H\u0016¢\u0006\u0004\bE\u0010CJ\u000f\u0010F\u001a\u00020\u000bH\u0016¢\u0006\u0004\bF\u0010\rJ\u000f\u0010G\u001a\u00020\u000bH\u0014¢\u0006\u0004\bG\u0010\rJ\u000f\u0010H\u001a\u00020\u0006H\u0014¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0006H\u0014¢\u0006\u0004\bJ\u0010IJ\u000f\u0010K\u001a\u00020\u0006H\u0014¢\u0006\u0004\bK\u0010IJ\u0017\u0010N\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OJ!\u0010S\u001a\u00020\u00142\u0006\u0010P\u001a\u00020\u00062\b\u0010R\u001a\u0004\u0018\u00010QH\u0016¢\u0006\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010W\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010XR\u0016\u0010Z\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010VR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010XR\u0014\u0010a\u001a\u00020`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010\\R\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010\\R*\u0010f\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u00148\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010V\u001a\u0004\bf\u0010<\"\u0004\bg\u0010hR,\u0010i\u001a\u00020\u00062\b\b\u0001\u0010e\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010\\\u001a\u0004\bj\u0010I\"\u0004\bk\u0010&R\u0016\u0010l\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010\\R\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010\\R\u0014\u0010o\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010IR\u0014\u0010q\u001a\u00020\u00068UX\u0094\u0004¢\u0006\u0006\u001a\u0004\bp\u0010IR\u0014\u0010s\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\br\u0010IR&\u0010v\u001a\u00020\u00062\b\b\u0001\u0010e\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\f\u001a\u0004\bt\u0010I\"\u0004\bu\u0010&R&\u0010y\u001a\u00020\u00062\b\b\u0001\u0010e\u001a\u00020\u00068W@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010I\"\u0004\bx\u0010&¨\u0006{"}, d2 = {"Lcom/stepos/widget/topbar/StepOSTopBar;", "Lcom/stepos/widget/tabbar/StepOSTabBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "LY8/t;", "onOverflowChanged", "()V", "applyCountBasedLabelAppearance", "Landroid/widget/LinearLayout;", "item", "dropLabelTopMarginWhenNoIcon", "(Landroid/widget/LinearLayout;)V", "Landroid/view/View;", "", "hasVisibleIcon", "(Landroid/view/View;)Z", "", "name", "incoming", "kept", "warnIgnored", "(Ljava/lang/String;II)Ljava/lang/String;", "mode", "modeName", "(I)Ljava/lang/String;", "", "deltaX", "dragBy", "(F)V", "velocityX", "fling", "(I)V", "Landroid/view/VelocityTracker;", "obtainVelocityTracker", "()Landroid/view/VelocityTracker;", "recycleVelocityTracker", "scrollSelectedIntoView", "targetX", "smoothScrollTo", "widthMeasureSpec", "measureItemWidth", "(I)I", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", Const.INTENT_KEY_PKGNAME, "onLayout", "(ZIIII)V", "shouldSelectOnPressDown", "()Z", "itemId", "onSelectionCommitted", "refreshItemLayout", "Landroid/view/MotionEvent;", "ev", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "event", "onTouchEvent", "computeScroll", "onDetachedFromWindow", "computeHorizontalScrollRange", "()I", "computeHorizontalScrollOffset", "computeHorizontalScrollExtent", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "(Landroid/view/accessibility/AccessibilityNodeInfo;)V", "action", "Landroid/os/Bundle;", "arguments", "performAccessibilityAction", "(ILandroid/os/Bundle;)Z", "overflowing", "Z", "lastTouchX", "F", "lastTouchY", "isBeingDragged", "touchSlop", "I", "velocityTracker", "Landroid/view/VelocityTracker;", "scrollRemainderX", "Landroid/widget/OverScroller;", "scroller", "Landroid/widget/OverScroller;", "minFlingVelocity", "maxFlingVelocity", UxipConstants.f30680s, "isScrollEnabled", "setScrollEnabled", "(Z)V", "itemMinWidth", "getItemMinWidth", "setItemMinWidth", "cachedContentWidth", "cachedMaxScrollX", "getMaxScrollX", "maxScrollX", "getItemHeightPx", "itemHeightPx", "getEqualDivideMaxCount", "equalDivideMaxCount", "getItemSpacing", "setItemSpacing", "itemSpacing", "getItemMaxWidth", "setItemMaxWidth", "itemMaxWidth", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class StepOSTopBar extends StepOSTabBar {
    private static final Companion Companion = new Companion(null);
    private static final int MAX_SCROLL_DURATION_MS = 360;
    private static final String TAG = "StepOSTopBar";
    private int cachedContentWidth;
    private int cachedMaxScrollX;
    private boolean isBeingDragged;
    private boolean isScrollEnabled;
    private int itemMinWidth;
    private float lastTouchX;
    private float lastTouchY;
    private int maxFlingVelocity;
    private int minFlingVelocity;
    private boolean overflowing;
    private float scrollRemainderX;
    private final OverScroller scroller;
    private int touchSlop;
    private VelocityTracker velocityTracker;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/widget/topbar/StepOSTopBar$Companion;", "", "<init>", "()V", "TAG", "", "MAX_SCROLL_DURATION_MS", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTopBar(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    private final void applyCountBasedLabelAppearance() {
        int i10 = 0;
        Iterable iterableS = C5685n.s(0, getTabCount());
        if (!(iterableS instanceof Collection) || !((Collection) iterableS).isEmpty()) {
            Iterator it = iterableS.iterator();
            while (it.hasNext()) {
                if (getChildAt(((M) it).nextInt()).getVisibility() != 8 && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        if (i10 == 0) {
            return;
        }
        setItemLabelTextAppearance(i10 >= 5 ? R.style.StepOSTextAppearance_TopBar_Label_Dense : i10 == 4 ? R.style.StepOSTextAppearance_TopBar_Label_Count4 : R.style.StepOSTextAppearance_TopBar_Label);
    }

    private final void dragBy(float deltaX) {
        float f10 = deltaX + this.scrollRemainderX;
        int i10 = (int) f10;
        this.scrollRemainderX = f10 - i10;
        if (i10 == 0) {
            return;
        }
        int iN = C5685n.n(getScrollX() + i10, 0, getCachedMaxScrollX());
        if (iN != getScrollX()) {
            scrollTo(iN, 0);
        }
        if (iN == 0 || iN == getCachedMaxScrollX()) {
            this.scrollRemainderX = 0.0f;
        }
    }

    private final void dropLabelTopMarginWhenNoIcon(LinearLayout item) {
        if (hasVisibleIcon(item)) {
            return;
        }
        int childCount = item.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = item.getChildAt(i10);
            p.f(childAt);
            if (!hasVisibleIcon(childAt)) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                if (marginLayoutParams != null) {
                    marginLayoutParams.topMargin = 0;
                }
            }
        }
    }

    private final void fling(int velocityX) {
        this.scrollRemainderX = 0.0f;
        this.scroller.abortAnimation();
        this.scroller.fling(getScrollX(), 0, velocityX, 0, 0, getCachedMaxScrollX(), 0, 0);
        postInvalidateOnAnimation();
    }

    /* renamed from: getMaxScrollX, reason: from getter */
    private final int getCachedMaxScrollX() {
        return this.cachedMaxScrollX;
    }

    private final boolean hasVisibleIcon(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (imageView.getVisibility() == 0 && imageView.getDrawable() != null) {
                return true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                p.h(childAt, "getChildAt(...)");
                if (hasVisibleIcon(childAt)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final String modeName(int mode) {
        return mode != Integer.MIN_VALUE ? mode != 0 ? mode != 1073741824 ? String.valueOf(mode) : "EXACTLY" : "UNSPECIFIED" : "AT_MOST";
    }

    private final VelocityTracker obtainVelocityTracker() {
        VelocityTracker velocityTrackerObtain = this.velocityTracker;
        if (velocityTrackerObtain == null) {
            velocityTrackerObtain = VelocityTracker.obtain();
            this.velocityTracker = velocityTrackerObtain;
        }
        p.f(velocityTrackerObtain);
        return velocityTrackerObtain;
    }

    private final void onOverflowChanged() {
        if (!this.overflowing) {
            setClipChildren(false);
            setClipToPadding(false);
            setHorizontalFadingEdgeEnabled(false);
        } else {
            setClipChildren(true);
            setClipToPadding(true);
            setHorizontalFadingEdgeEnabled(true);
            setFadingEdgeLength(getResources().getDimensionPixelSize(R.dimen.stepos_topbar_fading_edge_length));
        }
    }

    private final void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
    }

    private final void scrollSelectedIntoView() throws Resources.NotFoundException {
        int selectedPosition = getSelectedPosition();
        if (selectedPosition < 0 || selectedPosition >= getTabCount()) {
            return;
        }
        View childAt = getChildAt(selectedPosition);
        if (childAt.getVisibility() != 0) {
            return;
        }
        smoothScrollTo(C5685n.n(childAt.getLeft() - ((getWidth() - childAt.getWidth()) / 2), 0, getCachedMaxScrollX()));
    }

    private final void smoothScrollTo(int targetX) throws Resources.NotFoundException {
        this.scroller.abortAnimation();
        int iN = C5685n.n(targetX, 0, getCachedMaxScrollX()) - getScrollX();
        if (iN == 0) {
            return;
        }
        int iMax = Math.max(1, this.itemMinWidth);
        int iAbs = ((Math.abs(iN) + iMax) - 1) / iMax;
        int integer = getResources().getInteger(R.integer.stepos_topbar_scroll_segment_duration);
        this.scroller.startScroll(getScrollX(), 0, iN, 0, C5685n.n(iAbs * integer, integer, 360));
        postInvalidateOnAnimation();
    }

    private final String warnIgnored(String name, int incoming, int kept) {
        return "TopBar 恒通栏等分，" + name + " 对它无意义：收到 " + incoming + "px，保持 " + kept + "px。要改外观请用 app:steposTabBar* 的其他属性，或继承出 StepOSWidget.TopBar.<变体>";
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return getWidth();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return getScrollX();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return this.cachedContentWidth;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), 0);
            postInvalidateOnAnimation();
        }
    }

    public int getEqualDivideMaxCount() {
        return getResources().getInteger(R.integer.stepos_topbar_equal_divide_max_count);
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public int getItemHeightPx() {
        return getResources().getDimensionPixelSize(R.dimen.stepos_topbar_item_height);
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public int getItemMaxWidth() {
        return super.getItemMaxWidth();
    }

    public final int getItemMinWidth() {
        return this.itemMinWidth;
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public int getItemSpacing() {
        return super.getItemSpacing();
    }

    /* renamed from: isScrollEnabled, reason: from getter */
    public final boolean getIsScrollEnabled() {
        return this.isScrollEnabled;
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public int measureItemWidth(int widthMeasureSpec) {
        C5680i c5680iS = C5685n.s(0, getTabCount());
        ArrayList arrayList = new ArrayList();
        for (Integer num : c5680iS) {
            if (getChildAt(num.intValue()).getVisibility() != 8) {
                arrayList.add(num);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return 0;
        }
        if (this.isScrollEnabled && size > getEqualDivideMaxCount()) {
            int i10 = this.itemMinWidth;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ViewGroup.LayoutParams layoutParams = getChildAt(((Number) it.next()).intValue()).getLayoutParams();
                p.g(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                ((LinearLayout.LayoutParams) layoutParams).width = i10;
            }
            return i10;
        }
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size2 = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingStart()) - getPaddingEnd();
        if (mode == 0 || size2 <= 0) {
            throw new IllegalStateException(("TopBar 是通栏等分控件，量不到可用宽度：MeasureSpec mode=" + modeName(mode) + "、specSize=" + View.MeasureSpec.getSize(widthMeasureSpec) + "px、内边距=" + (getPaddingStart() + getPaddingEnd()) + "px、可见 " + size + " 段。请把容器宽度写死（match_parent / 固定 dp）；wrap_content 放在不限宽的父容器里（如 HorizontalScrollView）没有通栏可言").toString());
        }
        int i11 = size2 / size;
        if (i11 <= 0) {
            throw new IllegalStateException(("等分后段宽是 " + i11 + "px（≤ 0），画不出来：可见 " + size + " 段、可用宽度=" + size2 + "px。请减少段数，或给容器更大的宽度").toString());
        }
        int i12 = size2 - (size * i11);
        int i13 = 0;
        for (Object obj : arrayList) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                C1173v.w();
            }
            ViewGroup.LayoutParams layoutParams2 = getChildAt(((Number) obj).intValue()).getLayoutParams();
            p.g(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams2).width = (i13 < i12 ? 1 : 0) + i11;
            i13 = i14;
        }
        return i11;
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.scroller.abortAnimation();
        recycleVelocityTracker();
        super.onDetachedFromWindow();
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        p.i(info, "info");
        super.onInitializeAccessibilityNodeInfo(info);
        if (this.overflowing) {
            if (getScrollX() > 0) {
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(b.THRESHOLD, null));
            }
            if (getScrollX() < getCachedMaxScrollX()) {
                info.addAction(new AccessibilityNodeInfo.AccessibilityAction(4096, null));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r6, r0)
            boolean r0 = r5.overflowing
            if (r0 != 0) goto Le
            boolean r5 = super.onInterceptTouchEvent(r6)
            return r5
        Le:
            int r0 = r6.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L6a
            if (r0 == r1) goto L63
            r2 = 2
            if (r0 == r2) goto L1f
            r1 = 3
            if (r0 == r1) goto L63
            goto La4
        L1f:
            android.view.VelocityTracker r0 = r5.obtainVelocityTracker()
            r0.addMovement(r6)
            float r0 = r6.getX()
            float r2 = r5.lastTouchX
            float r0 = r0 - r2
            float r2 = r6.getY()
            float r3 = r5.lastTouchY
            float r2 = r2 - r3
            float r3 = java.lang.Math.abs(r0)
            int r4 = r5.touchSlop
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto La4
            float r0 = java.lang.Math.abs(r0)
            float r2 = java.lang.Math.abs(r2)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto La4
            r5.isBeingDragged = r1
            float r0 = r6.getX()
            r5.lastTouchX = r0
            float r6 = r6.getY()
            r5.lastTouchY = r6
            android.view.ViewParent r5 = r5.getParent()
            if (r5 == 0) goto L62
            r5.requestDisallowInterceptTouchEvent(r1)
        L62:
            return r1
        L63:
            r0 = 0
            r5.isBeingDragged = r0
            r5.recycleVelocityTracker()
            goto La4
        L6a:
            float r0 = r6.getX()
            r5.lastTouchX = r0
            float r0 = r6.getY()
            r5.lastTouchY = r0
            r0 = 0
            r5.scrollRemainderX = r0
            android.widget.OverScroller r0 = r5.scroller
            boolean r0 = r0.isFinished()
            r0 = r0 ^ r1
            r5.isBeingDragged = r0
            android.widget.OverScroller r0 = r5.scroller
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L8f
            android.widget.OverScroller r0 = r5.scroller
            r0.abortAnimation()
        L8f:
            android.view.VelocityTracker r0 = r5.obtainVelocityTracker()
            r0.addMovement(r6)
            boolean r0 = r5.isBeingDragged
            if (r0 == 0) goto La4
            android.view.ViewParent r5 = r5.getParent()
            if (r5 == 0) goto La3
            r5.requestDisallowInterceptTouchEvent(r1)
        La3:
            return r1
        La4:
            boolean r5 = super.onInterceptTouchEvent(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.topbar.StepOSTopBar.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar, android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l10, int t10, int r10, int b10) {
        super.onLayout(changed, l10, t10, r10, b10);
        if (!this.overflowing) {
            this.cachedContentWidth = getWidth();
            this.cachedMaxScrollX = 0;
            if (getScrollX() != 0) {
                this.scroller.abortAnimation();
                this.scrollRemainderX = 0.0f;
                scrollTo(0, 0);
                return;
            }
            return;
        }
        int paddingStart = getPaddingStart() + getPaddingEnd();
        C5680i c5680iS = C5685n.s(0, getTabCount());
        ArrayList arrayList = new ArrayList();
        for (Integer num : c5680iS) {
            if (getChildAt(num.intValue()).getVisibility() != 8) {
                arrayList.add(num);
            }
        }
        Iterator it = arrayList.iterator();
        int width = 0;
        while (it.hasNext()) {
            width += getChildAt(((Number) it.next()).intValue()).getWidth();
        }
        int i10 = paddingStart + width;
        this.cachedContentWidth = i10;
        this.cachedMaxScrollX = Math.max(0, i10 - getWidth());
        int iN = C5685n.n(getScrollX(), 0, this.cachedMaxScrollX);
        if (iN != getScrollX()) {
            this.scroller.abortAnimation();
            this.scrollRemainderX = 0.0f;
            scrollTo(iN, 0);
        }
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar, android.widget.LinearLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws Resources.NotFoundException {
        int measuredWidth = 0;
        C5680i c5680iS = C5685n.s(0, getTabCount());
        ArrayList arrayList = new ArrayList();
        for (Integer num : c5680iS) {
            if (getChildAt(num.intValue()).getVisibility() != 8) {
                arrayList.add(num);
            }
        }
        boolean z10 = this.overflowing;
        boolean z11 = this.isScrollEnabled && arrayList.size() > getEqualDivideMaxCount();
        this.overflowing = z11;
        if (z11 != z10) {
            onOverflowChanged();
        }
        if (!this.overflowing) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        measureItemWidth(iMakeMeasureSpec);
        super.onMeasure(iMakeMeasureSpec, heightMeasureSpec);
        int paddingStart = getPaddingStart() + getPaddingEnd();
        C5680i c5680iS2 = C5685n.s(0, getTabCount());
        ArrayList arrayList2 = new ArrayList();
        for (Integer num2 : c5680iS2) {
            if (getChildAt(num2.intValue()).getVisibility() != 8) {
                arrayList2.add(num2);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            measuredWidth += getChildAt(((Number) it.next()).intValue()).getMeasuredWidth();
        }
        setMeasuredDimension(Math.min(paddingStart + measuredWidth, View.MeasureSpec.getSize(widthMeasureSpec)), getMeasuredHeight());
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public void onSelectionCommitted(int itemId) throws Resources.NotFoundException {
        if (this.overflowing) {
            scrollSelectedIntoView();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        ViewParent parent;
        VelocityTracker velocityTracker;
        p.i(event, "event");
        if (!this.overflowing) {
            return super.onTouchEvent(event);
        }
        obtainVelocityTracker().addMovement(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.lastTouchX = event.getX();
            this.lastTouchY = event.getY();
            this.scrollRemainderX = 0.0f;
            this.scroller.abortAnimation();
            if (this.isBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (actionMasked == 1) {
            if (this.isBeingDragged && (velocityTracker = this.velocityTracker) != null) {
                velocityTracker.computeCurrentVelocity(1000, this.maxFlingVelocity);
                float xVelocity = velocityTracker.getXVelocity();
                if (Math.abs(xVelocity) >= this.minFlingVelocity) {
                    fling(-((int) xVelocity));
                }
            }
            this.isBeingDragged = false;
            recycleVelocityTracker();
        } else if (actionMasked == 2) {
            float x10 = event.getX() - this.lastTouchX;
            float y10 = event.getY() - this.lastTouchY;
            if (!this.isBeingDragged && Math.abs(x10) > this.touchSlop && Math.abs(x10) > Math.abs(y10)) {
                this.isBeingDragged = true;
                ViewParent parent2 = getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(true);
                }
                this.lastTouchX = event.getX();
                this.lastTouchY = event.getY();
            } else if (this.isBeingDragged) {
                dragBy(-(event.getX() - this.lastTouchX));
                this.lastTouchX = event.getX();
                this.lastTouchY = event.getY();
            }
        } else if (actionMasked == 3) {
            this.isBeingDragged = false;
            this.scrollRemainderX = 0.0f;
            recycleVelocityTracker();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int action, Bundle arguments) throws Resources.NotFoundException {
        if (this.overflowing) {
            if (action == 4096) {
                if (getScrollX() >= getCachedMaxScrollX()) {
                    return false;
                }
                smoothScrollTo(getScrollX() + getWidth());
                return true;
            }
            if (action == 8192) {
                if (getScrollX() <= 0) {
                    return false;
                }
                smoothScrollTo(getScrollX() - getWidth());
                return true;
            }
        }
        return super.performAccessibilityAction(action, arguments);
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public void refreshItemLayout() {
        super.refreshItemLayout();
        applyCountBasedLabelAppearance();
        int tabCount = getTabCount();
        for (int i10 = 0; i10 < tabCount; i10++) {
            View childAt = getChildAt(i10);
            LinearLayout linearLayout = childAt instanceof LinearLayout ? (LinearLayout) childAt : null;
            if (linearLayout != null) {
                linearLayout.setGravity(17);
                linearLayout.setPaddingRelative(linearLayout.getPaddingStart(), 0, linearLayout.getPaddingEnd(), 0);
                dropLabelTopMarginWhenNoIcon(linearLayout);
            }
        }
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public void setItemMaxWidth(int i10) {
        if (super.getItemMaxWidth() == i10) {
            return;
        }
        if (getConstructed()) {
            Log.w(TAG, warnIgnored("itemMaxWidth", i10, super.getItemMaxWidth()));
        } else {
            super.setItemMaxWidth(i10);
        }
    }

    public final void setItemMinWidth(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(("itemMinWidth must be >= 0 but was " + i10).toString());
        }
        if (this.itemMinWidth == i10) {
            return;
        }
        this.itemMinWidth = i10;
        if (this.overflowing) {
            requestLayout();
        }
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public void setItemSpacing(int i10) {
        if (super.getItemSpacing() == i10) {
            return;
        }
        if (getConstructed()) {
            Log.w(TAG, warnIgnored("itemSpacing", i10, super.getItemSpacing()));
        } else {
            super.setItemSpacing(i10);
        }
    }

    public final void setScrollEnabled(boolean z10) {
        if (this.isScrollEnabled == z10) {
            return;
        }
        this.isScrollEnabled = z10;
        requestLayout();
    }

    @Override // com.stepos.widget.tabbar.StepOSTabBar
    public boolean shouldSelectOnPressDown() {
        return !this.overflowing;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTopBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSTopBar(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSTopBar(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposTopBarStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_TopBar : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSTopBar(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.scroller = new OverScroller(context, new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f));
        this.itemMinWidth = getResources().getDimensionPixelSize(R.dimen.stepos_topbar_item_min_width);
        setElevation(0.0f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.minFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSTopBar, i10, i11);
        try {
            setScrollEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSTopBar_steposTopBarScrollEnabled, this.isScrollEnabled));
            setItemMinWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSTopBar_steposTopBarItemMinWidth, this.itemMinWidth));
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            refreshItemLayout();
        } finally {
        }
    }
}
