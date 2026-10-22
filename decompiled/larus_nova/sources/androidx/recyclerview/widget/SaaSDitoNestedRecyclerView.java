package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.OverScroller;
import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.l;
import com.bytedance.locallife.dito.view.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\b^\u0010_B\u001b\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\b\u0010a\u001a\u0004\u0018\u00010`¢\u0006\u0004\b^\u0010bB#\b\u0016\u0012\u0006\u0010]\u001a\u00020\\\u0012\b\u0010a\u001a\u0004\u0018\u00010`\u0012\u0006\u0010c\u001a\u00020\u0002¢\u0006\u0004\b^\u0010dJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J+\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010\"\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0014J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0002H\u0014J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\"\u001a\u00020\u0005J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0016J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0014J\u0016\u0010)\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0018J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u000eR\"\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010,0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R?\u00109\u001a\u001f\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0005\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010?\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR!\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00160E8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010K\u001a\u00020\u00028\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bK\u0010@\u001a\u0004\bL\u0010B\"\u0004\bM\u0010DR\"\u0010N\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR \u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00180T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0013\u0010Z\u001a\u0004\u0018\u00010W8F¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0011\u0010[\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b[\u0010Q¨\u0006e"}, d2 = {"Landroidx/recyclerview/widget/SaaSDitoNestedRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "consumedX", "consumedY", "", "dispatchOnScrolledSafely", "scrollState", "setScrollStateSafely", "dx", "dy", "", "consumed", "scrollStepSafely", "", "methodName", "", "", "args", "invokeReflectMethod", "(Ljava/lang/String;[Ljava/lang/Object;)V", "doScrollConsumed", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "recycleViewNestedChildScrollListener", "", "addNestChildScrollListener", "removeNestChildScrollListener", "consumePendingUpdateOperations", "state", "setScrollState", "Landroid/view/MotionEvent;", "e", "onTouchEvent", "updateScrollState", "stopScrollWithoutState", "velocityX", "velocityY", "absorbGlows", "onFlingEnd", "nodeTag", "intercept", "setInterceptScroll", "getInterceptScroll", "", "Ljava/lang/reflect/Method;", "cacheMethod", "Ljava/util/Map;", "Lcom/bytedance/locallife/dito/view/d;", "ditoNestedRecycleViewExtension", "Lcom/bytedance/locallife/dito/view/d;", "getDitoNestedRecycleViewExtension", "()Lcom/bytedance/locallife/dito/view/d;", "setDitoNestedRecycleViewExtension", "(Lcom/bytedance/locallife/dito/view/d;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onTouchEventCallback", "Lkotlin/jvm/functions/Function1;", "getOnTouchEventCallback", "()Lkotlin/jvm/functions/Function1;", "setOnTouchEventCallback", "(Lkotlin/jvm/functions/Function1;)V", "nestedTotalScrollY", "I", "getNestedTotalScrollY", "()I", "setNestedTotalScrollY", "(I)V", "", "nestedChildScrollListeners$delegate", "Lkotlin/Lazy;", "getNestedChildScrollListeners", "()Ljava/util/List;", "nestedChildScrollListeners", "smoothScrollToTargetPosition", "getSmoothScrollToTargetPosition", "setSmoothScrollToTargetPosition", "enableScroll", "Z", "getEnableScroll", "()Z", "setEnableScroll", "(Z)V", "Ljava/util/concurrent/ConcurrentHashMap;", "interceptScrollMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/widget/OverScroller;", "getFlingOverScroll", "()Landroid/widget/OverScroller;", "flingOverScroll", "isFling", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class SaaSDitoNestedRecyclerView extends RecyclerView {
    private final Map<String, Method> cacheMethod;
    private d ditoNestedRecycleViewExtension;
    private volatile boolean enableScroll;
    private final ConcurrentHashMap<String, Boolean> interceptScrollMap;
    private final Lazy nestedChildScrollListeners$delegate;
    private int nestedTotalScrollY;
    private Function1<? super MotionEvent, Unit> onTouchEventCallback;
    private int smoothScrollToTargetPosition;

    public void onFlingEnd(int r100, int r101) {
    }

    public final OverScroller getFlingOverScroll() {
        return this.mViewFlinger.mOverScroller;
    }

    public final List<RecyclerView.OnScrollListener> getNestedChildScrollListeners() {
        return (List) this.nestedChildScrollListeners$delegate.getValue();
    }

    public final void stopScrollWithoutState() {
        this.mViewFlinger.stop();
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if (r100 == null) goto L6;
        r100.stopSmoothScroller();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void consumePendingUpdateOperations() {
        super.consumePendingUpdateOperations();
        RecyclerView.LayoutManager r100 = getLayoutManager();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isSmoothScrolling() == false) goto L13;
        RecyclerView.SmoothScroller r101 = r100.mSmoothScroller;
        if (r101 == null) goto L9;
        int r102 = r101.getTargetPosition();
    L10:
        this.smoothScrollToTargetPosition = r102;
        return;
    L9:
        r102 = -1;
        goto L10
    }

    public final boolean isFling() {
        OverScroller r100 = getFlingOverScroll();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isFinished() == true) goto L7;
        return true;
    }

    public final d getDitoNestedRecycleViewExtension() {
        return this.ditoNestedRecycleViewExtension;
    }

    public final boolean getEnableScroll() {
        return this.enableScroll;
    }

    public final int getNestedTotalScrollY() {
        return this.nestedTotalScrollY;
    }

    public final Function1<MotionEvent, Unit> getOnTouchEventCallback() {
        return this.onTouchEventCallback;
    }

    public final int getSmoothScrollToTargetPosition() {
        return this.smoothScrollToTargetPosition;
    }

    public SaaSDitoNestedRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.cacheMethod = new LinkedHashMap();
        this.nestedChildScrollListeners$delegate = LazyKt.lazy(SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2.INSTANCE);
        this.smoothScrollToTargetPosition = -1;
        this.enableScroll = true;
        this.interceptScrollMap = new ConcurrentHashMap();
    }

    private final void setScrollStateSafely(int r100) {
        setScrollState(r100);     // Catch: Throwable -> L4
        return;
    L4:
        Dito r101 = Dito.f257280a;
        if (l.k().getDisableScrollMethodCompatible() == false) goto L7;
        return;
    L7:
        invokeReflectMethod("setScrollState", new Object[]{Integer.valueOf(r100)});
    }

    public final boolean addNestChildScrollListener(RecyclerView.OnScrollListener r100) {
        Intrinsics.checkNotNullParameter(r100, "recycleViewNestedChildScrollListener");
        if (getNestedChildScrollListeners().contains(r100) == false) goto L5;
        return false;
    L5:
        return getNestedChildScrollListeners().add(r100);
    }

    public final boolean getInterceptScroll(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        Boolean r101 = this.interceptScrollMap.get(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.booleanValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L7;
        Function1<? super MotionEvent, Unit> r101 = this.onTouchEventCallback;
        if (r101 == null) goto L7;
        r101.invoke(r100);
    L7:
        return super.onTouchEvent(r100);
    }

    public final boolean removeNestChildScrollListener(RecyclerView.OnScrollListener r100) {
        Intrinsics.checkNotNullParameter(r100, "recycleViewNestedChildScrollListener");
        return getNestedChildScrollListeners().remove(r100);
    }

    public final void setDitoNestedRecycleViewExtension(d r100) {
        this.ditoNestedRecycleViewExtension = r100;
    }

    public final void setEnableScroll(boolean r100) {
        this.enableScroll = r100;
    }

    public final void setNestedTotalScrollY(int r100) {
        this.nestedTotalScrollY = r100;
    }

    public final void setOnTouchEventCallback(Function1<? super MotionEvent, Unit> r100) {
        this.onTouchEventCallback = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollState(int r100) {
        super.setScrollState(r100);
        if (r100 != 0) goto L6;
        this.smoothScrollToTargetPosition = -1;
        return;
    }

    public final void setSmoothScrollToTargetPosition(int r100) {
        this.smoothScrollToTargetPosition = r100;
    }

    public final void updateScrollState(int r100) {
        setScrollStateSafely(r100);
    }

    public SaaSDitoNestedRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.cacheMethod = new LinkedHashMap();
        this.nestedChildScrollListeners$delegate = LazyKt.lazy(SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2.INSTANCE);
        this.smoothScrollToTargetPosition = -1;
        this.enableScroll = true;
        this.interceptScrollMap = new ConcurrentHashMap();
    }

    private final void dispatchOnScrolledSafely(int r100, int r101) {
        dispatchOnScrolled(r100, r101);     // Catch: Throwable -> L4
        return;
    L4:
        Dito r102 = Dito.f257280a;
        if (l.k().getDisableScrollMethodCompatible() == false) goto L7;
        return;
    L7:
        invokeReflectMethod("dispatchOnScrolled", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});
    }

    private final void invokeReflectMethod(String r110, Object... r111) {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        Map<String, Method> r102 = this.cacheMethod;     // Catch: Throwable -> L18
        Method r103 = r102.get(r110);     // Catch: Throwable -> L18
        if (r103 != null) goto L16;
        Method[] r104 = RecyclerView.class.getDeclaredMethods();     // Catch: Throwable -> L18
        int r105 = r104.length;     // Catch: Throwable -> L18
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L11;
        Method r107 = r104[r106];     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(r107.getName(), r110) == true) goto L12;
        r106 = r106 + 1;     // Catch: Throwable -> L18
    L12:
        if (r107 == null) goto L14;
        r107.setAccessible(true);     // Catch: Throwable -> L18
        r103 = r107;
    L15:
        r102.put(r110, r103);     // Catch: Throwable -> L18
        goto L16
    L14:
        r103 = null;
        goto L15
    L11:
        r107 = null;
    L16:
        Object r112 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r112) == false) goto L23;
        r112 = null;
    L23:
        Method r113 = (Method) r112;
        if (r113 != null) goto L32;
    L28:
        Result.m9449constructorimpl(r100);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L32:
        r100 = r113.invoke(this, new Object[]{r111});     // Catch: Throwable -> L26
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void absorbGlows(int r100, int r101) {
        onFlingEnd(r100, r101);
    }

    public final void setInterceptScroll(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeTag");
        Boolean r102 = Boolean.valueOf(r101);
        this.interceptScrollMap.put(r100, r102);
    }

    public SaaSDitoNestedRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.cacheMethod = new LinkedHashMap();
        this.nestedChildScrollListeners$delegate = LazyKt.lazy(SaaSDitoNestedRecyclerView$nestedChildScrollListeners$2.INSTANCE);
        this.smoothScrollToTargetPosition = -1;
        this.enableScroll = true;
        this.interceptScrollMap = new ConcurrentHashMap();
    }

    private final void scrollStepSafely(int r100, int r101, int[] r102) {
        scrollStep(r100, r101, r102);     // Catch: Throwable -> L4
        return;
    L4:
        Dito r103 = Dito.f257280a;
        if (l.k().getDisableScrollMethodCompatible() == false) goto L7;
        return;
    L7:
        invokeReflectMethod("scrollStep", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), r102});
    }

    public final void doScrollConsumed(int r100, int r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r102, "consumed");
        r102[0] = 0;
        r102[1] = 1;
        scrollStepSafely(r100, r101, r102);
        int r103 = r102[0];
        int r104 = r102[1];
        if (r103 != 0) goto L5;
        if (r104 != 0) goto L5;
        return;
    L5:
        dispatchOnScrolledSafely(r103, r104);
    }
}
