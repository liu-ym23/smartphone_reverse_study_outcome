package androidx.compose.ui.platform;

import android.content.Context;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.Owner;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.CastMonitor;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\fJ\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$J\r\u0010.\u001a\u00020\u001cH'¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020\u001cJ\b\u00102\u001a\u00020\u001cH\u0002J\f\u00105\u001a\u00020\f*\u00020\fH\u0002J\b\u00106\u001a\u00020\fH\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\u0006\u0010:\u001a\u00020\u001cJ\b\u0010=\u001a\u00020\u001cH\u0014J\u0018\u0010>\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0004J\u001d\u0010A\u001a\u00020\u001c2\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0010¢\u0006\u0002\bBJ0\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0004J5\u0010I\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u0007H\u0010¢\u0006\u0002\bJJ\u0010\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020\u0007H\u0016J\b\u0010N\u001a\u00020&H\u0016J\u0010\u0010O\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020&H\u0016J\u0012\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u001a\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u0007H\u0016J\"\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0016J\u001c\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J$\u0010P\u001a\u00020\u001c2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J$\u0010X\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010WH\u0014J,\u0010X\u001a\u00020&2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020\u00072\b\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020&H\u0014J\b\u0010Z\u001a\u00020&H\u0016R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001fX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b \u0010!R\u0014\u0010%\u001a\u00020&8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R,\u0010)\u001a\u00020&2\u0006\u0010\r\u001a\u00020&8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010!\u001a\u0004\b+\u0010(\"\u0004\b,\u0010-R\u000e\u00101\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u00103\u001a\u00020&*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020&X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b8\u0010(R\u0011\u0010;\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b<\u0010(R\u000e\u0010M\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/compose/ui/platform/AbstractComposeView;", "Landroid/view/ViewGroup;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cachedViewTreeCompositionContext", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/runtime/CompositionContext;", "value", "Landroid/os/IBinder;", "previousAttachedWindowToken", "setPreviousAttachedWindowToken", "(Landroid/os/IBinder;)V", "composition", "Landroidx/compose/runtime/Composition;", "getComposition", "()Landroidx/compose/runtime/Composition;", "setComposition", "(Landroidx/compose/runtime/Composition;)V", "parentContext", "setParentContext", "(Landroidx/compose/runtime/CompositionContext;)V", "setParentCompositionContext", "", "parent", "disposeViewCompositionStrategy", "Lkotlin/Function0;", "getDisposeViewCompositionStrategy$annotations", "()V", "setViewCompositionStrategy", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Landroidx/compose/ui/platform/ViewCompositionStrategy;", "shouldCreateCompositionOnAttachedToWindow", "", "getShouldCreateCompositionOnAttachedToWindow", "()Z", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "createComposition", "creatingComposition", "checkAddView", "isAlive", "(Landroidx/compose/runtime/CompositionContext;)Z", "cacheIfAlive", "resolveParentCompositionContext", "enablePausableComposition", "getEnablePausableComposition", "ensureCompositionCreated", "disposeComposition", "hasComposition", "getHasComposition", "onAttachedToWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "internalOnMeasure", "internalOnMeasure$ui_release", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "internalOnLayout", "internalOnLayout$ui_release", "onRtlPropertiesChanged", "layoutDirection", "isTransitionGroupSet", "isTransitionGroup", "setTransitionGroup", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "index", "width", "height", "params", "Landroid/view/ViewGroup$LayoutParams;", "addViewInLayout", "preventRequestLayout", "shouldDelayChildPressedState", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractComposeView extends ViewGroup {
    public static final int $stable = 8;
    private WeakReference<CompositionContext> cachedViewTreeCompositionContext;
    private Composition composition;
    private boolean creatingComposition;
    private Function0<Unit> disposeViewCompositionStrategy;
    private final boolean enablePausableComposition;
    private boolean isTransitionGroupSet;
    private CompositionContext parentContext;
    private IBinder previousAttachedWindowToken;
    private boolean showLayoutBounds;

    public AbstractComposeView(Context r100) {
        this(r100, null, 0, 6, null);
    }

    public AbstractComposeView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 4, null);
    }

    private static /* synthetic */ void getDisposeViewCompositionStrategy$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public abstract void Content(Composer r100, int r101);

    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    private final void checkAddView() {
        if (this.creatingComposition == false) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Cannot add views to " + getClass().getSimpleName() + "; only Compose content is supported");
    }

    private final void ensureCompositionCreated() {
        if (this.composition == null) goto L11;
        return;
    L11:
        this.creatingComposition = true;     // Catch: Throwable -> L7
        this.composition = Wrapper_androidKt.setContent(this, resolveParentCompositionContext(), getEnablePausableComposition(), ComposableLambdaKt.composableLambdaInstance(-1330213153, true, new AnonymousClass1(this)));     // Catch: Throwable -> L7
        this.creatingComposition = false;
        return;
    L7:
        th = move-exception;
        this.creatingComposition = false;
        throw th;
    }

    private final CompositionContext resolveParentCompositionContext() {
        CompositionContext r100 = this.parentContext;
        if (r100 != null) goto L20;
        CompositionContext r101 = WindowRecomposer_androidKt.findViewTreeCompositionContext(this);
        CompositionContext r102 = null;
        if (r101 == null) goto L7;
        CompositionContext r103 = cacheIfAlive(r101);
    L8:
        if (r103 != null) goto L21;
        WeakReference<CompositionContext> r104 = this.cachedViewTreeCompositionContext;
        if (r104 == null) goto L16;
        CompositionContext r105 = r104.get();
        if (r105 == null) goto L16;
        if (isAlive(r105) == false) goto L16;
        r102 = r105;
    L16:
        CompositionContext r106 = r102;
        if (r106 == null) goto L19;
        return r106;
    L19:
        return cacheIfAlive(WindowRecomposer_androidKt.getWindowRecomposer(this));
    L21:
        return r103;
    L7:
        r103 = null;
        goto L8
    L20:
        return r100;
    }

    public final void createComposition() {
        if (this.parentContext == null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L13;
        ensureCompositionCreated();
        return;
    L13:
        throw new IllegalStateException("createComposition requires either a parent reference or the View to be attachedto a window. Attach the View or call setParentCompositionReference.".toString());
    L5:
        if (isAttachedToWindow() == true) goto L8;
        r100 = false;
        goto L9
    }

    public final void disposeComposition() {
        Composition r100 = this.composition;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.composition = null;
        requestLayout();
    }

    public final boolean getHasComposition() {
        if (this.composition == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean isTransitionGroup() {
        if (this.isTransitionGroupSet == true) goto L5;
    L8:
        return true;
    L5:
        if (super.isTransitionGroup() == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setPreviousAttachedWindowToken(getWindowToken());
        if (getShouldCreateCompositionOnAttachedToWindow() == false) goto L6;
        ensureCompositionCreated();
        return;
    }

    public final Composition getComposition() {
        return this.composition;
    }

    public boolean getEnablePausableComposition() {
        return this.enablePausableComposition;
    }

    public final boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    private final CompositionContext cacheIfAlive(CompositionContext r100) {
        if (isAlive(r100) == false) goto L5;
        CompositionContext r101 = r100;
    L6:
        if (r101 == null) goto L8;
        this.cachedViewTreeCompositionContext = new WeakReference(r101);
    L8:
        return r100;
    L5:
        r101 = null;
        goto L6
    }

    private final boolean isAlive(CompositionContext r100) {
        if ((r100 instanceof Recomposer) == true) goto L5;
    L8:
        return true;
    L5:
        if (((Recomposer) r100).getCurrentState().getValue().compareTo(Recomposer.State.ShuttingDown) > 0) goto L8;
        return false;
    }

    private final void setParentContext(CompositionContext r100) {
        if (this.parentContext == r100) goto L13;
        this.parentContext = r100;
        if (r100 == null) goto L7;
        this.cachedViewTreeCompositionContext = null;
    L7:
        Composition r101 = this.composition;
        if (r101 == null) goto L14;
        r101.dispose();
        this.composition = null;
        if (isAttachedToWindow() == false) goto L15;
        ensureCompositionCreated();
        return;
    L15:
        return;
    L14:
        return;
    }

    private final void setPreviousAttachedWindowToken(IBinder r100) {
        if (this.previousAttachedWindowToken == r100) goto L6;
        this.previousAttachedWindowToken = r100;
        this.cachedViewTreeCompositionContext = null;
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r100) {
        checkAddView();
        super.addView(r100);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r100) {
        View r101 = getChildAt(0);
        if (r101 == null) goto L6;
        r101.setLayoutDirection(r100);
        return;
    }

    public final void setComposition(Composition r100) {
        this.composition = r100;
    }

    public final void setParentCompositionContext(CompositionContext r100) {
        setParentContext(r100);
    }

    public final void setShowLayoutBounds(boolean r100) {
        this.showLayoutBounds = r100;
        KeyEvent.Callback r101 = getChildAt(0);
        if (r101 == null) goto L6;
        ((Owner) r101).setShowLayoutBounds(r100);
        return;
    }

    @Override // android.view.ViewGroup
    public void setTransitionGroup(boolean r100) {
        super.setTransitionGroup(r100);
        this.isTransitionGroupSet = true;
    }

    public final void setViewCompositionStrategy(ViewCompositionStrategy r100) {
        Function0<Unit> r101 = this.disposeViewCompositionStrategy;
        if (r101 == null) goto L5;
        r101.invoke();
    L5:
        this.disposeViewCompositionStrategy = r100.installFor(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101) {
        checkAddView();
        super.addView(r100, r101);
    }

    public void internalOnMeasure$ui_release(int r100, int r101) {
        View r102 = getChildAt(0);
        if (r102 != null) goto L6;
        super.onMeasure(r100, r101);
        return;
    L6:
        int r103 = Math.max(0, (View.MeasureSpec.getSize(r100) - getPaddingLeft()) - getPaddingRight());
        int r104 = Math.max(0, (View.MeasureSpec.getSize(r101) - getPaddingTop()) - getPaddingBottom());
        r102.measure(View.MeasureSpec.makeMeasureSpec(r103, View.MeasureSpec.getMode(r100)), View.MeasureSpec.makeMeasureSpec(r104, View.MeasureSpec.getMode(r101)));
        setMeasuredDimension((r102.getMeasuredWidth() + getPaddingLeft()) + getPaddingRight(), (r102.getMeasuredHeight() + getPaddingTop()) + getPaddingBottom());
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        ensureCompositionCreated();
        internalOnMeasure$ui_release(r100, r101);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View r100, ViewGroup.LayoutParams r101) {
        checkAddView();
        super.addView(r100, r101);
    }

    public AbstractComposeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        setClipChildren(false);
        setClipToPadding(false);
        setImportantForAccessibility(1);
        this.disposeViewCompositionStrategy = ViewCompositionStrategy.Companion.getDefault().installFor(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, int r102) {
        checkAddView();
        super.addView(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View r100, int r101, ViewGroup.LayoutParams r102) {
        checkAddView();
        return super.addViewInLayout(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        checkAddView();
        super.addView(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View r100, int r101, ViewGroup.LayoutParams r102, boolean r103) {
        checkAddView();
        return super.addViewInLayout(r100, r101, r102, r103);
    }

    public /* synthetic */ AbstractComposeView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }

    public void internalOnLayout$ui_release(boolean r100, int r101, int r102, int r103, int r104) {
        View r105 = getChildAt(0);
        if (r105 == null) goto L6;
        r105.layout(getPaddingLeft(), getPaddingTop(), (r103 - r101) - getPaddingRight(), (r104 - r102) - getPaddingBottom());
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        internalOnLayout$ui_release(r100, r101, r102, r103, r104);
    }
}
