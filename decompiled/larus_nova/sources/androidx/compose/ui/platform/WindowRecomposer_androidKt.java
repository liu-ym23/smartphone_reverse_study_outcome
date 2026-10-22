package androidx.compose.ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.compose.runtime.PausableMonotonicFrameClock;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0003\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002\u001a,\u0010\u0019\u001a\u00020\u0014*\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u001a\u000e\u0010 \u001a\u0004\u0018\u00010\u001f*\u00020\u0003H\u0002\",\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0000\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\" \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0010\u001a\u00020\u0003*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0013\u001a\u00020\u0014*\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"value", "Landroidx/compose/runtime/CompositionContext;", "compositionContext", "Landroid/view/View;", "getCompositionContext", "(Landroid/view/View;)Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroid/view/View;Landroidx/compose/runtime/CompositionContext;)V", "findViewTreeCompositionContext", "animationScale", "", "Landroid/content/Context;", "Lkotlinx/coroutines/flow/StateFlow;", "", "getAnimationScaleFlowFor", "applicationContext", "contentChild", "getContentChild", "(Landroid/view/View;)Landroid/view/View;", "windowRecomposer", "Landroidx/compose/runtime/Recomposer;", "getWindowRecomposer$annotations", "(Landroid/view/View;)V", "getWindowRecomposer", "(Landroid/view/View;)Landroidx/compose/runtime/Recomposer;", "createLifecycleAwareWindowRecomposer", "onAttachStateProvider", "Landroidx/compose/ui/platform/OnAttachStateProvider;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "findLifecycleFromContext", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowRecomposer_androidKt {
    private static final Map<Context, i1<Float>> animationScale = null;

    public static /* synthetic */ void getWindowRecomposer$annotations(View r100) {
    }

    static {
        animationScale = new LinkedHashMap();
    }

    public static final /* synthetic */ i1 access$getAnimationScaleFlowFor(Context r100) {
        return getAnimationScaleFlowFor(r100);
    }

    private static final Lifecycle findLifecycleFromContext(View r100) {
        Object r101 = r100.getContext();
    L4:
        if ((r101 instanceof ContextWrapper) == false) goto L13;
        if ((r101 instanceof LifecycleOwner) == true) goto L8;
        Object r102 = ((ContextWrapper) r101).getBaseContext();
        if (r102 == r101) goto L13;
        r101 = r102;
        goto L4
    L8:
        return ((LifecycleOwner) r101).getLifecycle();
    L13:
        if ((r101 instanceof LifecycleOwner) == true) goto L20;
        return null;
    L20:
        return ((LifecycleOwner) r101).getLifecycle();
    }

    public static final CompositionContext findViewTreeCompositionContext(View r100) {
        CompositionContext r101 = getCompositionContext(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Object r102 = r100.getParent();
    L6:
        if (r101 != null) goto L10;
        if ((r102 instanceof View) == false) goto L10;
        View r103 = (View) r102;
        r101 = getCompositionContext(r103);
        r102 = r103.getParent();
    L10:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1] */
    private static final i1<Float> getAnimationScaleFlowFor(Context r100) {
        Map<Context, i1<Float>> r101 = animationScale;
        monitor-enter(r101);
        i1<Float> r102 = r101.get(r100);     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        ContentResolver r103 = r100.getContentResolver();     // Catch: Throwable -> L10
        Uri r104 = Settings.Global.getUriFor("animator_duration_scale");     // Catch: Throwable -> L10
        final Channel r105 = ChannelKt.Channel$default(-1, null, null, 6, null);     // Catch: Throwable -> L10
        final Handler r106 = HandlerCompat.createAsync(Looper.getMainLooper());     // Catch: Throwable -> L10
        r102 = kotlinx.coroutines.flow.e.F(new c1(new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(r103, r104, new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$contentObserver$1(r105, r106), r105, r100, null)), CoroutineScopeKt.MainScope(), g1.a.a(g1.f504854a, 0, 3), Float.valueOf(Settings.Global.getFloat(r100.getContentResolver(), "animator_duration_scale", 1.0f)));     // Catch: Throwable -> L10
        r101.put(r100, r102);     // Catch: Throwable -> L10
    L7:
        i1<Float> r107 = r102;     // Catch: Throwable -> L10
        monitor-exit(r101);
        return r107;
    L10:
        th = move-exception;
        throw th;
    }

    public static final CompositionContext getCompositionContext(View r100) {
        Object r101 = r100.getTag(R.id.androidx_compose_ui_view_composition_context);
        if ((r101 instanceof CompositionContext) == true) goto L7;
        return null;
    L7:
        return (CompositionContext) r101;
    }

    public static final View getContentChild(View r100) {
        Object r101 = r100.getParent();
    L4:
        if ((r101 instanceof View) == false) goto L9;
        View r102 = (View) r101;
        if (r102.getId() == 16908290) goto L7;
        r101 = r102.getParent();
        r100 = r102;
        goto L4
    L7:
        return r100;
    L9:
        return r100;
    }

    public static final Recomposer getWindowRecomposer(View r100) {
        if (r100.isAttachedToWindow() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("Cannot locate windowRecomposer; View " + r100 + " is not attached to a window");
    L5:
        View r101 = getContentChild(r100);
        CompositionContext r102 = getCompositionContext(r101);
        if (r102 != null) goto L9;
        return WindowRecomposerPolicy.createAndInstallWindowRecomposer$ui_release$default(WindowRecomposerPolicy.INSTANCE, r101, null, 2, null);
    L9:
        if ((r102 instanceof Recomposer) == false) goto L13;
        return (Recomposer) r102;
    L13:
        throw new IllegalStateException("root viewTreeParentCompositionContext is not a Recomposer".toString());
    }

    public static final void setCompositionContext(View r100, CompositionContext r101) {
        r100.setTag(R.id.androidx_compose_ui_view_composition_context, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.coroutines.CoroutineContext] */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, androidx.compose.ui.platform.MotionDurationScaleImpl] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r11v3, types: [kotlin.coroutines.CoroutineContext] */
    public static final Recomposer createLifecycleAwareWindowRecomposer(final View r100, final OnAttachStateProvider r110, CoroutineContext r111, Lifecycle r112) {
        if (r111.get(ContinuationInterceptor.Key) != null) goto L5;
    L6:
        r111 = AndroidUiDispatcher.Companion.getCurrentThread().plus(r111);
    L7:
        MonotonicFrameClock r101 = (MonotonicFrameClock) r111.get(MonotonicFrameClock.Key);
        if (r101 == null) goto L10;
        PausableMonotonicFrameClock r102 = new PausableMonotonicFrameClock(r101);
        r102.pause();
        final PausableMonotonicFrameClock r103 = r102;
    L11:
        final Ref.ObjectRef r104 = new Ref.ObjectRef();
        MotionDurationScale r105 = (MotionDurationScale) r111.get(MotionDurationScale.Key);
        ?? r106 = r105;
        if (r105 != null) goto L14;
        ?? r107 = new MotionDurationScaleImpl();
        r104.element = r107;
        r106 = r107;
    L14:
        if (r103 == null) goto L16;
        CoroutineContext r108 = r103;
    L17:
        CoroutineContext r113 = r111.plus(r108).plus(r106);
        final Recomposer r109 = new Recomposer(r113);
        r109.pauseCompositionFrameClock();
        final CoroutineScope r114 = CoroutineScopeKt.CoroutineScope(r113);
        if (r112 != null) goto L25;
        LifecycleOwner r115 = ViewTreeLifecycleOwner.get(r100);
        if (r115 == null) goto L22;
        r112 = r115.getLifecycle();
    L23:
        if (r112 != null) goto L25;
        r112 = findLifecycleFromContext(r100);
        goto L25
    L22:
        r112 = null;
    L25:
        if (r112 == null) goto L31;
        if (r110 == null) goto L28;
        r110.addOnAttachStateChangeListener(new AnonymousClass1(r110, r109));
    L29:
        r112.addObserver(new AnonymousClass3(r114, r103, r109, r104, r100));
        return r109;
    L28:
        r100.addOnAttachStateChangeListener(new AnonymousClass2(r100, r109));
        goto L29
    L31:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("ViewTreeLifecycleOwner not found from " + r100);
        throw new KotlinNothingValueException();
    L16:
        r108 = EmptyCoroutineContext.INSTANCE;
        goto L17
    L10:
        r103 = null;
        goto L11
    L5:
        if (r111.get(MonotonicFrameClock.Key) != null) goto L7;
        goto L6
    }

    public static /* synthetic */ Recomposer createLifecycleAwareWindowRecomposer$default(View r100, OnAttachStateProvider r101, CoroutineContext r102, Lifecycle r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = EmptyCoroutineContext.INSTANCE;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = null;
    L12:
        return createLifecycleAwareWindowRecomposer(r100, r101, r102, r103);
    }
}
