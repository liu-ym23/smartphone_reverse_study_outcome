package com.bytedance.android.ec.window.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0001`B\t\b\u0016¢\u0006\u0004\bU\u0010KB\u0011\b\u0016\u0012\u0006\u0010W\u001a\u00020V¢\u0006\u0004\bU\u0010XB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\bU\u0010YB\u001d\b\u0016\u0012\b\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\u0010]\u001a\u0004\u0018\u00010\\¢\u0006\u0004\bU\u0010^J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u001b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u001aH\u0002J\u0010\u0010\u001c\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u001aH\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ \u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\nJ\u001f\u0010'\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b)\u0010*J\u0006\u0010+\u001a\u00020\u0013J\u0006\u0010,\u001a\u00020\u0006J \u00101\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u000f2\u0006\u00100\u001a\u00020/H\u0016J\u001a\u00102\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\nH\u0016J8\u00105\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00104\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016JH\u0010:\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J(\u0010;\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010@\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010AR\u0016\u0010\u0005\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010AR\u0018\u0010C\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR\u001c\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bH\u0010I\u0012\u0004\bJ\u0010KR\u0018\u0010M\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0018\u0010P\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010IR\u0016\u0010Q\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010IR\u0018\u0010T\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010F¨\u0006a"}, d2 = {"Lcom/bytedance/android/ec/window/base/widget/WindowControllableAppBarSnapBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$Behavior;", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "", "snapTopDownThreshold", "snapBottomUpThreshold", "", "init", "setSnapTopDownThreshold", "setSnapBottomUpThreshold", "", "type", "updateLastStartedType", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "coordinatorLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "abl", "Landroid/view/View;", PickerReporterConstants.KEY.TARGET, "", "delegateOnStopNestedScroll", "updateOffsetAndGetSnapToBoundaryOffset", "offset", "getChildIndexOnOffset", "setLiftedState", "updateLastNestedScrollingChildRef", "Ljava/lang/Class;", "baseBehaviorClass", "headerBehaviorClass", "snapToBoundaryIfNeed", "smoothSnapTo", "snapTo", "appBarLayout", "dispatchOffsetChangedOf", "currentOffset", "snapBottomOffset", "setSnapIntermediately", "enable", "offsetLimit", "setOffsetDownEnable", "(ZLjava/lang/Integer;)V", "updateOffsetDownLimit", "(Ljava/lang/Integer;)V", "couldOffsetDown", "clearLastNestedScrollingChildRef", "parent", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/MotionEvent;", "ev", "onTouchEvent", "onOffsetChanged", "directTargetChild", "nestedScrollAxes", "onStartNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "onStopNestedScroll", "touchSlop$delegate", "Lkotlin/Lazy;", "getTouchSlop", "()I", "touchSlop", FaceService.girlLabel, "Lcom/bytedance/android/ec/window/base/widget/WindowScrollOrientation;", "scrollOrientation", "Lcom/bytedance/android/ec/window/base/widget/WindowScrollOrientation;", "topOffset", "Ljava/lang/Integer;", "bottomOffset", "lastStartedType", "I", "getLastStartedType$annotations", "()V", "Ljava/lang/reflect/Method;", "methodAnimateOffsetTo", "Ljava/lang/reflect/Method;", "methodSetHeaderTopBottomOffset", "methodGetTopBottomOffsetForScrollingSibling", "isOffsetDownEnable", "Z", "offsetWhenDisableOffsetDown", "lastOffset", "<init>", "Lcom/bytedance/android/ec/window/base/widget/WindowSnapStrategy;", "snapStrategy", "(Lcom/bytedance/android/ec/window/base/widget/WindowSnapStrategy;)V", "(FF)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class WindowControllableAppBarSnapBehavior extends AppBarLayout.Behavior implements AppBarLayout.OnOffsetChangedListener {
    public static final a Companion = null;
    public static final float DEFAULT_SNAP_THRESHOLD = 0.5f;
    private static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private Integer bottomOffset;
    private boolean isOffsetDownEnable;
    private Integer lastOffset;
    private int lastStartedType;
    private Method methodAnimateOffsetTo;
    private Method methodGetTopBottomOffsetForScrollingSibling;
    private Method methodSetHeaderTopBottomOffset;
    private int offsetWhenDisableOffsetDown;
    private WindowScrollOrientation scrollOrientation;
    private int snapBottomOffset;
    private float snapBottomUpThreshold;
    private float snapTopDownThreshold;
    private Integer topOffset;
    private final Lazy touchSlop$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private static /* synthetic */ void getLastStartedType$annotations() {
    }

    public final void clearLastNestedScrollingChildRef() {
        updateLastNestedScrollingChildRef(null);
    }

    public final int currentOffset() {
    L15:
        return 0;
    L4:
        if (this.methodGetTopBottomOffsetForScrollingSibling != null) goto L6;
        Method r100 = baseBehaviorClass().getDeclaredMethod("getTopBottomOffsetForScrollingSibling", new Class[0]);     // Catch: Exception -> L15
        r100.setAccessible(true);     // Catch: Exception -> L15
        Unit r101 = Unit.INSTANCE;     // Catch: Exception -> L15
        this.methodGetTopBottomOffsetForScrollingSibling = r100;     // Catch: Exception -> L15
    L6:
        Method r102 = this.methodGetTopBottomOffsetForScrollingSibling;     // Catch: Exception -> L15
        if (r102 == null) goto L9;
        Object r103 = r102.invoke(this, new Object[0]);     // Catch: Exception -> L15
    L10:
        if (r103 == null) goto L14;
        return ((Integer) r103).intValue();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L15
    L9:
        r103 = null;
        goto L10
    }

    public final int getTouchSlop() {
        return ((Number) this.touchSlop$delegate.getValue()).intValue();
    }

    public WindowControllableAppBarSnapBehavior() {
        this(WindowSnapStrategy.EASY);
    }

    private final Class<? super WindowControllableAppBarSnapBehavior> baseBehaviorClass() throws WindowReflectFailedException {
        if (WindowControllableAppBarSnapBehavior.class.getSuperclass() == null) goto L12;
        Class r100 = WindowControllableAppBarSnapBehavior.class.getSuperclass();
        if (r100 == null) goto L10;
        Class<? super WindowControllableAppBarSnapBehavior> r101 = r100.getSuperclass();
        if (r101 == null) goto L10;
        return r101;
    L10:
        throw new WindowReflectFailedException("failed to get AppBarLayout.BaseBehavior.class");
    L12:
        throw new WindowReflectFailedException("failed to get AppBarLayout.Behavior.class");
    }

    public final boolean couldOffsetDown() {
        if (this.isOffsetDownEnable == false) goto L5;
    L8:
        return true;
    L5:
        if (currentOffset() < this.offsetWhenDisableOffsetDown) goto L8;
        return false;
    }

    private final Class<? super WindowControllableAppBarSnapBehavior> headerBehaviorClass() throws WindowReflectFailedException {
        Class r100 = baseBehaviorClass().getSuperclass();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new WindowReflectFailedException("failed to get HeaderBehavior.class");
    }

    public WindowControllableAppBarSnapBehavior(WindowSnapStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "snapStrategy");
        this(r100.getTopDown(), r100.getBottomUp());
    }

    private final WindowControllableAppBarSnapBehavior setSnapBottomUpThreshold(float r100) {
        this.snapBottomUpThreshold = r100;
        return this;
    }

    private final WindowControllableAppBarSnapBehavior setSnapTopDownThreshold(float r100) {
        this.snapTopDownThreshold = r100;
        return this;
    }

    private final boolean updateLastNestedScrollingChildRef(View r100) {
        Field r101 = baseBehaviorClass().getDeclaredField("lastNestedScrollingChildRef");     // Catch: Exception -> L8
        r101.setAccessible(true);     // Catch: Exception -> L8
        if (r100 != null) goto L5;
        WeakReference r102 = null;
    L6:
        r101.set(this, r102);     // Catch: Exception -> L8
        return true;
    L5:
        r102 = new WeakReference(r100);     // Catch: Exception -> L8
    L8:
        return false;
    }

    private final void updateLastStartedType(int r100) {
        this.lastStartedType = r100;
    }

    private final int updateOffsetAndGetSnapToBoundaryOffset(AppBarLayout r110) {
        int r100 = currentOffset();
        int r101 = getChildIndexOnOffset(r110, r100);
        if (r101 >= 0) goto L5;
        return Integer.MIN_VALUE;
    L5:
        View r102 = r110.getChildAt(r101);
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L65;
        AppBarLayout.LayoutParams r104 = (AppBarLayout.LayoutParams) r103;
        int r105 = r104.getScrollFlags();
        Companion.getClass();
        if ((r105 & 17) != 17) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L13;
        return Integer.MIN_VALUE;
    L13:
        int r107 = -r102.getTop();
        int r108 = -r102.getBottom();
        if (r101 == (r110.getChildCount() - 1)) goto L67;
    L20:
        Companion.getClass();
        if ((r105 & 2) != 2) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == false) goto L27;
        r108 = r108 + ViewCompat.getMinimumHeight(r102);
    L36:
        if ((r105 & 32) != 32) goto L38;
        boolean r111 = true;
    L39:
        if (r111 == false) goto L41;
        r107 = r107 + ((LinearLayout.LayoutParams) r104).topMargin;
        r108 = r108 - ((LinearLayout.LayoutParams) r104).bottomMargin;
    L41:
        this.topOffset = Integer.valueOf(r107);
        this.bottomOffset = Integer.valueOf(r108);
        int r112 = this.snapBottomOffset + r108;
        int r113 = Math.abs(r107);
        int r114 = Math.abs(r112);
        int r115 = Math.abs(r100);
        if (r113 > r115) goto L46;
        if (r114 < r115) goto L46;
        boolean r116 = true;
    L47:
        if (r116 == true) goto L50;
        r107 = r112;
    L50:
        if (r116 == false) goto L52;
        r108 = r112;
    L52:
        WindowScrollOrientation r117 = this.scrollOrientation;
        if (r117 != null) goto L55;
        float r118 = 0.5f;
    L59:
        this.scrollOrientation = null;
        if (r100 >= (r107 + ((r108 - r107) * r118))) goto L63;
        r107 = r108;
    L63:
        return MathUtils.clamp(r107, -r110.getTotalScrollRange(), 0);
    L55:
        if (r117 != WindowScrollOrientation.BOTTOM_UP) goto L57;
        r118 = this.snapBottomUpThreshold;
        goto L59
    L57:
        r118 = 1 - this.snapTopDownThreshold;
    L46:
        r116 = false;
        goto L47
    L38:
        r111 = false;
        goto L39
    L27:
        if ((r105 & 5) != 5) goto L29;
        boolean r119 = true;
    L30:
        if (r119 == false) goto L36;
        int r120 = ViewCompat.getMinimumHeight(r102) + r108;
        if (r100 >= r120) goto L34;
        r107 = r120;
        goto L36
    L34:
        r108 = r120;
        goto L36
    L29:
        r119 = false;
        goto L30
    L23:
        r109 = false;
        goto L24
    L67:
        Method r121 = r110.getClass().getDeclaredMethod("getTopInset", new Class[0]);     // Catch: Exception -> L66
        r121.setAccessible(true);     // Catch: Exception -> L66
        Object r122 = r121.invoke(r110, new Object[0]);     // Catch: Exception -> L66
        if (r122 == null) goto L19;
        r108 = r108 + ((Integer) r122).intValue();     // Catch: Exception -> L66
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Exception -> L66
    L10:
        r106 = false;
        goto L11
    L65:
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    }

    public final void setSnapIntermediately(int r100) {
        this.snapBottomOffset = r100;
    }

    public final void updateOffsetDownLimit(Integer r100) {
        if (this.isOffsetDownEnable == false) goto L5;
        int r101 = 0;
    L8:
        this.offsetWhenDisableOffsetDown = r101;
        return;
    L5:
        if (r100 == null) goto L7;
        r101 = r100.intValue();
        goto L8
    L7:
        r101 = currentOffset();
        goto L8
    }

    public WindowControllableAppBarSnapBehavior(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.touchSlop$delegate = LazyKt.lazy(WindowControllableAppBarSnapBehavior$touchSlop$2.INSTANCE);
        this.snapTopDownThreshold = 0.5f;
        this.snapBottomUpThreshold = 0.5f;
        this.isOffsetDownEnable = true;
        WindowSnapStrategy r102 = WindowSnapStrategy.EASY;
        init(r102.getTopDown(), r102.getBottomUp());
    }

    private final int getChildIndexOnOffset(AppBarLayout r100, int r101) {
        int r102 = r100.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        View r104 = r100.getChildAt(r103);
        int r105 = r104.getTop();
        int r106 = r104.getBottom();
        ViewGroup.LayoutParams r107 = r104.getLayoutParams();
        if (r107 == null) goto L16;
        AppBarLayout.LayoutParams r108 = (AppBarLayout.LayoutParams) r107;
        if ((r108.getScrollFlags() & 32) != 32) goto L9;
        r105 = r105 - ((LinearLayout.LayoutParams) r108).topMargin;
        r106 = r106 + ((LinearLayout.LayoutParams) r108).bottomMargin;
    L9:
        int r109 = -r101;
        if (r105 > r109) goto L14;
        if (r106 < r109) goto L14;
        return r103;
    L14:
        r103 = r103 + 1;
        goto L3
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
    L17:
        return -1;
    }

    private final void init(float r100, float r101) {
        setSnapTopDownThreshold(r100);
        setSnapBottomUpThreshold(r101);
    }

    private final boolean setLiftedState(AppBarLayout r100, View r101) {
        Method r102 = r100.getClass().getDeclaredMethod("shouldLift", new Class[]{View.class});     // Catch: Exception -> L9
        r102.setAccessible(true);     // Catch: Exception -> L9
        Object r103 = r102.invoke(r100, new Object[]{r101});     // Catch: Exception -> L9
        if (r103 == null) goto L7;
        boolean r104 = ((Boolean) r103).booleanValue();     // Catch: Exception -> L9
        Method r105 = r100.getClass().getDeclaredMethod("setLiftedState", new Class[]{Boolean.TYPE});     // Catch: Exception -> L9
        r105.setAccessible(true);     // Catch: Exception -> L9
        r105.invoke(r100, new Object[]{Boolean.valueOf(r104)});     // Catch: Exception -> L9
        return true;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L9
    L11:
        return false;
    }

    public final void dispatchOffsetChangedOf(AppBarLayout r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "appBarLayout");
        Method r102 = r100.getClass().getDeclaredMethod("dispatchOffsetUpdates", new Class[]{Integer.TYPE});     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r102.invoke(r100, new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L5
        return;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public void onOffsetChanged(AppBarLayout r100, int r101) {
        Integer r102 = this.lastOffset;
        if (r102 != null) goto L5;
    L9:
        this.lastOffset = Integer.valueOf(r101);
        return;
    L5:
        if ((r102.intValue() - r101) >= 0) goto L7;
        WindowScrollOrientation r103 = WindowScrollOrientation.TOP_DOWN;
    L8:
        this.scrollOrientation = r103;
        goto L9
    L7:
        r103 = WindowScrollOrientation.BOTTOM_UP;
        goto L8
    }

    public final void setOffsetDownEnable(boolean r100, Integer r101) {
        this.isOffsetDownEnable = r100;
        if (r100 == false) goto L5;
        int r102 = 0;
    L8:
        this.offsetWhenDisableOffsetDown = r102;
        return;
    L5:
        if (r101 == null) goto L7;
        r102 = r101.intValue();
        goto L8
    L7:
        r102 = currentOffset();
        goto L8
    }

    public boolean snapToBoundaryIfNeed(CoordinatorLayout r100, AppBarLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, "abl");
        return smoothSnapTo(updateOffsetAndGetSnapToBoundaryOffset(r101), r100, r101);
    }

    public WindowControllableAppBarSnapBehavior(float r100, float r101) {
        this.touchSlop$delegate = LazyKt.lazy(WindowControllableAppBarSnapBehavior$touchSlop$2.INSTANCE);
        this.snapTopDownThreshold = 0.5f;
        this.snapBottomUpThreshold = 0.5f;
        this.isOffsetDownEnable = true;
        init(r100, r101);
    }

    public boolean onTouchEvent(CoordinatorLayout r100, AppBarLayout r101, MotionEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "ev");
        if (couldOffsetDown() == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100, r101, r102);
    }

    public final boolean smoothSnapTo(int r110, CoordinatorLayout r111, AppBarLayout r112) {
        Intrinsics.checkNotNullParameter(r111, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r112, "abl");
        if (r110 != Integer.MIN_VALUE) goto L14;
        return false;
    L14:
        if (this.methodAnimateOffsetTo != null) goto L8;
        Method r100 = baseBehaviorClass().getDeclaredMethod("animateOffsetTo", new Class[]{CoordinatorLayout.class, AppBarLayout.class, Integer.TYPE, Float.TYPE});     // Catch: Exception -> L13
        r100.setAccessible(true);     // Catch: Exception -> L13
        Unit r101 = Unit.INSTANCE;     // Catch: Exception -> L13
        this.methodAnimateOffsetTo = r100;     // Catch: Exception -> L13
    L8:
        Method r102 = this.methodAnimateOffsetTo;     // Catch: Exception -> L13
        if (r102 == null) goto L11;
        r102.invoke(this, new Object[]{r111, r112, Integer.valueOf(r110), Float.valueOf(0.0f)});     // Catch: Exception -> L13
    L11:
        return true;
    L16:
        return false;
    }

    public final void snapTo(int r100, CoordinatorLayout r110, AppBarLayout r111) {
        Intrinsics.checkNotNullParameter(r110, "coordinatorLayout");
        if (r111 != null) goto L6;
        return;
    L6:
        if (r100 != Integer.MIN_VALUE) goto L16;
        return;
    L16:
        if (this.methodSetHeaderTopBottomOffset != null) goto L11;
        Method r101 = headerBehaviorClass().getDeclaredMethod("setHeaderTopBottomOffset", new Class[]{CoordinatorLayout.class, View.class, Integer.TYPE});     // Catch: Exception -> L15
        r101.setAccessible(true);     // Catch: Exception -> L15
        Unit r102 = Unit.INSTANCE;     // Catch: Exception -> L15
        this.methodSetHeaderTopBottomOffset = r101;     // Catch: Exception -> L15
    L11:
        Method r103 = this.methodSetHeaderTopBottomOffset;     // Catch: Exception -> L15
        if (r103 == null) goto L18;
        r103.invoke(this, new Object[]{r110, r111, Integer.valueOf(r100)});     // Catch: Exception -> L15
        return;
    L18:
        return;
    }

    @Override // com.google.android.material.appbar.HeaderBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onTouchEvent(CoordinatorLayout r100, View r101, MotionEvent r102) {
        return onTouchEvent(r100, (AppBarLayout) r101, r102);
    }

    private final boolean delegateOnStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
        if (this.lastStartedType == 0) goto L6;
        if (r103 == 1) goto L6;
        return false;
    L6:
        if (snapToBoundaryIfNeed(r100, r101) == true) goto L8;
        return false;
    L8:
        if (updateLastNestedScrollingChildRef(r102) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public static /* synthetic */ void updateOffsetDownLimit$default(WindowControllableAppBarSnapBehavior r100, Integer r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        r100.updateOffsetDownLimit(r101);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateOffsetDownLimit");
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onStopNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, "abl");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
    L11:
        super.onStopNestedScroll(r100, r101, r102, r103);
        return;
    L4:
        if (delegateOnStopNestedScroll(r100, r101, r102, r103) == true) goto L8;
        super.onStopNestedScroll(r100, r101, r102, r103);     // Catch: Exception -> L11
        return;
    L8:
        if (r101.isLiftOnScroll() == false) goto L14;
        setLiftedState(r101, r102);     // Catch: Exception -> L11
        return;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103) {
        onStopNestedScroll(r100, (AppBarLayout) r101, r102, r103);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public boolean onStartNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, View r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "directTargetChild");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        r101.addOnOffsetChangedListener(this);
        updateLastStartedType(r105);
        boolean r106 = super.onStartNestedScroll(r100, r101, r102, r103, r104, r105);
        if (this.topOffset != null) goto L6;
    L7:
        updateOffsetAndGetSnapToBoundaryOffset(r101);     // Catch: Exception -> L9
        goto L8
    L6:
        if (this.bottomOffset == null) goto L7;
    L8:
        return r106;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout r100, View r101, View r102, View r103, int r104, int r105) {
        return onStartNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.Behavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior
    public void onNestedScroll(CoordinatorLayout r100, AppBarLayout r101, View r102, int r103, int r104, int r105, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "coordinatorLayout");
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (r110 < 0) goto L5;
    L10:
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r110, r111);
        return;
    L5:
        if (this.isOffsetDownEnable == true) goto L10;
        int r106 = currentOffset();
        int r107 = getTopAndBottomOffset() - r110;
        int r108 = this.offsetWhenDisableOffsetDown;
        if (r107 < r108) goto L10;
        snapTo(r106 - RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r110, r106 - r108), 0), r100, r101);
        ViewCompat.stopNestedScroll(r102, r111);
    }

    @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout r100, View r101, View r102, int r103, int r104, int r105, int r106, int r107) {
        onNestedScroll(r100, (AppBarLayout) r101, r102, r103, r104, r105, r106, r107);
    }
}
