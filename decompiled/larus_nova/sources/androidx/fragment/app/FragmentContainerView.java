package androidx.fragment.app;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001<B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\"\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0014J \u0010#\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0014J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0017\u0010(\u001a\u0002H)\"\n\b\u0000\u0010)*\u0004\u0018\u00010*¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0017J\b\u0010-\u001a\u00020\u0016H\u0016J\u0010\u0010.\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010/\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0018\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0018\u00104\u001a\u00020\u00162\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\bH\u0016J\u0010\u00105\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0001J\u0012\u00106\u001a\u00020\u00162\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u000eH\u0016J\u0010\u0010;\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u0011H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/fragment/app/FragmentContainerView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroid/content/Context;Landroid/util/AttributeSet;Landroidx/fragment/app/FragmentManager;)V", "applyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", "disappearingFragmentChildren", "", "Landroid/view/View;", "drawDisappearingViewsFirst", "", "transitioningFragmentViews", "addDisappearingFragmentView", "", BaseSwitches.V, "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "dispatchApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "drawChild", "drawingTime", "", "endViewTransition", "view", "getFragment", FaceService.girlLabel, "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "onApplyWindowInsets", "removeAllViewsInLayout", "removeView", "removeViewAt", "removeViewInLayout", "removeViews", "start", "count", "removeViewsInLayout", "setDrawDisappearingViewsLast", "setLayoutTransition", "transition", "Landroid/animation/LayoutTransition;", "setOnApplyWindowInsetsListener", "listener", "startViewTransition", "Api20Impl", "fragment_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FragmentContainerView extends FrameLayout {
    private View.OnApplyWindowInsetsListener applyWindowInsetsListener;
    private final List<View> disappearingFragmentChildren;
    private boolean drawDisappearingViewsFirst;
    private final List<View> transitioningFragmentViews;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Landroidx/fragment/app/FragmentContainerView$Api20Impl;", "", "()V", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "onApplyWindowInsetsListener", "Landroid/view/View$OnApplyWindowInsetsListener;", BaseSwitches.V, "Landroid/view/View;", "insets", "fragment_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Api20Impl {
        public static final Api20Impl INSTANCE = null;

        static {
            INSTANCE = new Api20Impl();
        }

        private Api20Impl() {
        }

        public final WindowInsets onApplyWindowInsets(View.OnApplyWindowInsetsListener r100, View r101, WindowInsets r102) {
            Intrinsics.checkNotNullParameter(r100, "onApplyWindowInsetsListener");
            Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r102, "insets");
            return r100.onApplyWindowInsets(r101, r102);
        }
    }

    public FragmentContainerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets r100) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        return r100;
    }

    public final <F extends Fragment> F getFragment() {
        return (F) FragmentManager.findFragmentManager(this).findFragmentById(getId());
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int r100 = getChildCount() - 1;
        if (r100 < 0) goto L8;
    L4:
        int r101 = r100 - 1;
        addDisappearingFragmentView(getChildAt(r100));
        if (r101 < 0) goto L8;
        r100 = r101;
    L8:
        super.removeAllViewsInLayout();
    }

    public FragmentContainerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
    }

    private final void addDisappearingFragmentView(View r100) {
        if (this.transitioningFragmentViews.contains(r100) == false) goto L6;
        this.disappearingFragmentChildren.add(r100);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets r100) {
        Intrinsics.checkNotNullParameter(r100, "insets");
        WindowInsetsCompat r101 = WindowInsetsCompat.toWindowInsetsCompat(r100);
        View.OnApplyWindowInsetsListener r102 = this.applyWindowInsetsListener;
        if (r102 == null) goto L5;
        Api20Impl r103 = Api20Impl.INSTANCE;
        Intrinsics.checkNotNull(r102);
        WindowInsetsCompat r104 = WindowInsetsCompat.toWindowInsetsCompat(r103.onApplyWindowInsets(r102, this, r100));
    L7:
        if (r104.isConsumed() == true) goto L15;
        int r105 = getChildCount();
        if (r105 <= 0) goto L15;
        int r106 = 0;
    L11:
        int r107 = r106 + 1;
        ViewCompat.dispatchApplyWindowInsets(getChildAt(r106), r104);
        if (r107 >= r105) goto L15;
        r106 = r107;
    L15:
        return r100;
    L5:
        r104 = ViewCompat.onApplyWindowInsets(this, r101);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.drawDisappearingViewsFirst == false) goto L8;
        Iterator<T> r101 = this.disappearingFragmentChildren.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        super.drawChild(r100, (View) r101.next(), getDrawingTime());
    L8:
        super.dispatchDraw(r100);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.transitioningFragmentViews.remove(r100);
        if (this.disappearingFragmentChildren.remove(r100) == false) goto L5;
        this.drawDisappearingViewsFirst = true;
    L5:
        super.endViewTransition(r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        addDisappearingFragmentView(r100);
        super.removeView(r100);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int r100) {
        addDisappearingFragmentView(getChildAt(r100));
        super.removeViewAt(r100);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        addDisappearingFragmentView(r100);
        super.removeViewInLayout(r100);
    }

    public final void setDrawDisappearingViewsLast(boolean r100) {
        this.drawDisappearingViewsFirst = r100;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r100) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.applyWindowInsetsListener = r100;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.getParent() != this) goto L5;
        this.transitioningFragmentViews.add(r100);
    L5:
        super.startViewTransition(r100);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int r100, int r101) {
        int r102 = r100 + r101;
        if (r100 >= r102) goto L9;
        int r103 = r100;
    L5:
        int r104 = r103 + 1;
        addDisappearingFragmentView(getChildAt(r103));
        if (r104 >= r102) goto L9;
        r103 = r104;
    L9:
        super.removeViews(r100, r101);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int r100, int r101) {
        int r102 = r100 + r101;
        if (r100 >= r102) goto L9;
        int r103 = r100;
    L5:
        int r104 = r103 + 1;
        addDisappearingFragmentView(getChildAt(r103));
        if (r104 >= r102) goto L9;
        r103 = r104;
    L9:
        super.removeViewsInLayout(r100, r101);
    }

    public FragmentContainerView(Context r100, AttributeSet r101, FragmentManager r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        Intrinsics.checkNotNullParameter(r102, "fm");
        super(r100, r101);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        String r103 = r101.getClassAttribute();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.name, R.attr.tag}, 0, 0);
        if (r103 != null) goto L5;
        r103 = r104.getString(0);
    L5:
        String r105 = r104.getString(1);
        r104.recycle();
        int r106 = getId();
        Fragment r107 = r102.findFragmentById(r106);
        if (r103 == null) goto L16;
        if (r107 != null) goto L16;
        if (r106 != (-1)) goto L15;
        if (r105 == null) goto L12;
        String r108 = Intrinsics.stringPlus(" with tag ", r105);
    L14:
        throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + r103 + r108);
    L12:
        r108 = "";
        goto L14
    L15:
        Fragment r109 = r102.getFragmentFactory().instantiate(r100.getClassLoader(), r103);
        r109.onInflate(r100, r101, null);
        r102.beginTransaction().setReorderingAllowed(true).add(this, r109, r105).commitNowAllowingStateLoss();
    L16:
        r102.onContainerAvailable(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (FragmentManager.getViewFragment(r100) == null) goto L7;
        super.addView(r100, r101, r102);
        return;
    L7:
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + r100 + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r100, View r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (this.drawDisappearingViewsFirst == false) goto L11;
        if ((!this.disappearingFragmentChildren.isEmpty()) == false) goto L11;
        if (this.disappearingFragmentChildren.contains(r101) == false) goto L11;
        return false;
    L11:
        return super.drawChild(r100, r101, r102);
    }

    public FragmentContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.disappearingFragmentChildren = new ArrayList();
        this.transitioningFragmentViews = new ArrayList();
        this.drawDisappearingViewsFirst = true;
        if (r101 == null) goto L15;
        String r103 = r101.getClassAttribute();
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.name, R.attr.tag}, 0, 0);
        if (r103 != null) goto L7;
        r103 = r104.getString(0);
        String r105 = "android:name";
    L8:
        r104.recycle();
        if (r103 != null) goto L11;
        return;
    L11:
        if (isInEditMode() == false) goto L14;
        return;
    L14:
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + r105 + "=\"" + r103 + Typography.quote);
    L7:
        r105 = "class";
        goto L8
    }

    public /* synthetic */ FragmentContainerView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = 0;
    L5:
        this(r100, r101, r102);
    }
}
