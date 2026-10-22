package androidx.compose.foundation.layout;

import C7.r;
import H7.c;
import S7.k;
import U7.a;
import android.graphics.Insets;
import android.os.CancellationSignal;
import android.view.View;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.c0;

@RequiresApi(30)
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010 \u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u000fJ\"\u0010)\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J*\u0010-\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u00100\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0004\b.\u0010/J#\u00103\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001f\u00107\u001a\u00020\r2\u0006\u00104\u001a\u00020\u00102\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\r¢\u0006\u0004\b9\u0010\u000fJ\u0017\u0010:\u001a\u00020\r2\u0006\u00104\u001a\u00020\u0010H\u0016¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b<\u0010;R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010@\u001a\u0004\bA\u0010BR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010F\u001a\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR \u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010U8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010W\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006X"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroid/view/WindowInsetsAnimationControlListener;", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "windowInsets", "Landroid/view/View;", "view", "Landroidx/compose/foundation/layout/SideCalculator;", "sideCalculator", "Landroidx/compose/ui/unit/Density;", "density", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/layout/AndroidWindowInsets;Landroid/view/View;Landroidx/compose/foundation/layout/SideCalculator;Landroidx/compose/ui/unit/Density;)V", "LC7/r;", "requestAnimationController", "()V", "Landroid/view/WindowInsetsAnimationController;", "getAnimationController", "(LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/geometry/Offset;", "available", "", "scrollAmount", "scroll-8S9VItk", "(JF)J", "scroll", "Landroidx/compose/ui/unit/Velocity;", "flingAmount", "", "towardShown", "fling-huYlsQE", "(JFZLH7/c;)Ljava/lang/Object;", "fling", "inset", "adjustInsets", "(F)V", "animationEnded", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "onPreScroll-OzD1aCk", "(JI)J", "onPreScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "onPreFling-QWom1Mo", "(JLH7/c;)Ljava/lang/Object;", "onPreFling", "onPostFling-RZ2iAVY", "(JJLH7/c;)Ljava/lang/Object;", "onPostFling", "controller", "", "types", "onReady", "(Landroid/view/WindowInsetsAnimationController;I)V", "dispose", "onFinished", "(Landroid/view/WindowInsetsAnimationController;)V", "onCancelled", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "getWindowInsets", "()Landroidx/compose/foundation/layout/AndroidWindowInsets;", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Landroidx/compose/foundation/layout/SideCalculator;", "getSideCalculator", "()Landroidx/compose/foundation/layout/SideCalculator;", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "animationController", "Landroid/view/WindowInsetsAnimationController;", "isControllerRequested", "Z", "Landroid/os/CancellationSignal;", "cancellationSignal", "Landroid/os/CancellationSignal;", "partialConsumption", "F", "Lm9/c0;", "animationJob", "Lm9/c0;", "Lm9/j;", "continuation", "Lm9/j;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class WindowInsetsNestedScrollConnection implements NestedScrollConnection, WindowInsetsAnimationControlListener {
    private WindowInsetsAnimationController animationController;
    private c0 animationJob;
    private final CancellationSignal cancellationSignal = new CancellationSignal();
    private InterfaceC1717j continuation;
    private final Density density;
    private boolean isControllerRequested;
    private float partialConsumption;
    private final SideCalculator sideCalculator;
    private final View view;
    private final AndroidWindowInsets windowInsets;

    public WindowInsetsNestedScrollConnection(AndroidWindowInsets androidWindowInsets, View view, SideCalculator sideCalculator, Density density) {
        this.windowInsets = androidWindowInsets;
        this.view = view;
        this.sideCalculator = sideCalculator;
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void adjustInsets(float inset) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(windowInsetsAnimationController.getCurrentInsets(), Math.round(inset)), 1.0f, 0.0f);
        }
    }

    private final void animationEnded() {
        WindowInsetsAnimationController windowInsetsAnimationController;
        WindowInsetsAnimationController windowInsetsAnimationController2 = this.animationController;
        if (windowInsetsAnimationController2 != null && windowInsetsAnimationController2.isReady() && (windowInsetsAnimationController = this.animationController) != null) {
            windowInsetsAnimationController.finish(this.windowInsets.isVisible());
        }
        this.animationController = null;
        InterfaceC1717j interfaceC1717j = this.continuation;
        if (interfaceC1717j != null) {
            interfaceC1717j.e(new k() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.animationEnded.1
                public final void invoke(Throwable th) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return r.f317a;
                }
            }, null);
        }
        this.continuation = null;
        c0 c0Var = this.animationJob;
        if (c0Var != null) {
            c0Var.cancel(new WindowInsetsAnimationCancelledException());
        }
        this.animationJob = null;
        this.partialConsumption = 0.0f;
        this.isControllerRequested = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* renamed from: fling-huYlsQE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m773flinghuYlsQE(long r26, float r28, boolean r29, H7.c<? super androidx.compose.ui.unit.Velocity> r30) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.m773flinghuYlsQE(long, float, boolean, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getAnimationController(c<? super WindowInsetsAnimationController> cVar) {
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            return windowInsetsAnimationController;
        }
        C1718k c1718k = new C1718k(1, a.I(cVar));
        c1718k.y();
        this.continuation = c1718k;
        requestAnimationController();
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestAnimationController() {
        if (this.isControllerRequested) {
            return;
        }
        this.isControllerRequested = true;
        WindowInsetsController windowInsetsController = this.view.getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.controlWindowInsetsAnimation(this.windowInsets.getType(), -1L, null, this.cancellationSignal, this);
        }
    }

    /* renamed from: scroll-8S9VItk, reason: not valid java name */
    private final long m774scroll8S9VItk(long available, float scrollAmount) {
        c0 c0Var = this.animationJob;
        if (c0Var != null) {
            c0Var.cancel(new WindowInsetsAnimationCancelledException());
            this.animationJob = null;
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (scrollAmount != 0.0f) {
            if (this.windowInsets.isVisible() != (scrollAmount > 0.0f) || windowInsetsAnimationController != null) {
                if (windowInsetsAnimationController == null) {
                    this.partialConsumption = 0.0f;
                    requestAnimationController();
                    return this.sideCalculator.mo726consumedOffsetsMKHz9U(available);
                }
                int iValueOf = this.sideCalculator.valueOf(windowInsetsAnimationController.getHiddenStateInsets());
                int iValueOf2 = this.sideCalculator.valueOf(windowInsetsAnimationController.getShownStateInsets());
                Insets currentInsets = windowInsetsAnimationController.getCurrentInsets();
                int iValueOf3 = this.sideCalculator.valueOf(currentInsets);
                if (iValueOf3 == (scrollAmount > 0.0f ? iValueOf2 : iValueOf)) {
                    this.partialConsumption = 0.0f;
                    return Offset.INSTANCE.m3911getZeroF1C5BW0();
                }
                float f = iValueOf3 + scrollAmount + this.partialConsumption;
                int iU = AbstractC1451a.u(Math.round(f), iValueOf, iValueOf2);
                this.partialConsumption = f - Math.round(f);
                if (iU != iValueOf3) {
                    windowInsetsAnimationController.setInsetsAndAlpha(this.sideCalculator.adjustInsets(currentInsets, iU), 1.0f, 0.0f);
                }
                return this.sideCalculator.mo726consumedOffsetsMKHz9U(available);
            }
        }
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    public final void dispose() {
        InterfaceC1717j interfaceC1717j = this.continuation;
        if (interfaceC1717j != null) {
            interfaceC1717j.e(new k() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.dispose.1
                public final void invoke(Throwable th) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return r.f317a;
                }
            }, null);
        }
        c0 c0Var = this.animationJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        WindowInsetsAnimationController windowInsetsAnimationController = this.animationController;
        if (windowInsetsAnimationController != null) {
            windowInsetsAnimationController.finish(!kotlin.jvm.internal.k.b(windowInsetsAnimationController.getCurrentInsets(), windowInsetsAnimationController.getHiddenStateInsets()));
        }
    }

    public final Density getDensity() {
        return this.density;
    }

    public final SideCalculator getSideCalculator() {
        return this.sideCalculator;
    }

    public final View getView() {
        return this.view;
    }

    public final AndroidWindowInsets getWindowInsets() {
        return this.windowInsets;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController controller) {
        animationEnded();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    public Object mo500onPostFlingRZ2iAVY(long j5, long j6, c<? super Velocity> cVar) {
        return m773flinghuYlsQE(j6, this.sideCalculator.showMotion(Velocity.m7082getXimpl(j6), Velocity.m7083getYimpl(j6)), true, cVar);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo501onPostScrollDzOQY0M(long consumed, long available, int source) {
        return m774scroll8S9VItk(available, this.sideCalculator.showMotion(Offset.m3895getXimpl(available), Offset.m3896getYimpl(available)));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo, reason: not valid java name */
    public Object mo775onPreFlingQWom1Mo(long j5, c<? super Velocity> cVar) {
        return m773flinghuYlsQE(j5, this.sideCalculator.hideMotion(Velocity.m7082getXimpl(j5), Velocity.m7083getYimpl(j5)), false, cVar);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long mo776onPreScrollOzD1aCk(long available, int source) {
        return m774scroll8S9VItk(available, this.sideCalculator.hideMotion(Offset.m3895getXimpl(available), Offset.m3896getYimpl(available)));
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController controller, int types) {
        this.animationController = controller;
        this.isControllerRequested = false;
        InterfaceC1717j interfaceC1717j = this.continuation;
        if (interfaceC1717j != null) {
            interfaceC1717j.e(new k() { // from class: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection.onReady.1
                public final void invoke(Throwable th) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return r.f317a;
                }
            }, controller);
        }
        this.continuation = null;
    }
}
