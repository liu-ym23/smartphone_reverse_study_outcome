package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u001e\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001d0$H\u0016J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u0015H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020(H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Landroidx/compose/foundation/layout/InsetsListener;", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Ljava/lang/Runnable;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "Landroid/view/View$OnAttachStateChangeListener;", "composeInsets", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "<init>", "(Landroidx/compose/foundation/layout/WindowInsetsHolder;)V", "getComposeInsets", "()Landroidx/compose/foundation/layout/WindowInsetsHolder;", "prepared", "", "getPrepared", "()Z", "setPrepared", "(Z)V", "runningAnimation", "getRunningAnimation", "setRunningAnimation", "savedInsets", "Landroidx/core/view/WindowInsetsCompat;", "getSavedInsets", "()Landroidx/core/view/WindowInsetsCompat;", "setSavedInsets", "(Landroidx/core/view/WindowInsetsCompat;)V", "onPrepare", "", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/core/view/WindowInsetsAnimationCompat;", WidgetCostModule.TYPE_ON_START, "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onProgress", "insets", "runningAnimations", "", "onEnd", "onApplyWindowInsets", "view", "Landroid/view/View;", "run", "onViewAttachedToWindow", "onViewDetachedFromWindow", BaseSwitches.V, "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class InsetsListener extends WindowInsetsAnimationCompat.Callback implements Runnable, OnApplyWindowInsetsListener, View.OnAttachStateChangeListener {
    private final WindowInsetsHolder composeInsets;
    private boolean prepared;
    private boolean runningAnimation;
    private WindowInsetsCompat savedInsets;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_compose_foundation_layout_InsetsListener_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_compose_foundation_layout_InsetsListener__run$___twin___() {
        if (this.prepared == false) goto L8;
        this.prepared = false;
        this.runningAnimation = false;
        WindowInsetsCompat r100 = this.savedInsets;
        if (r100 == null) goto L9;
        this.composeInsets.updateImeAnimationSource(r100);
        WindowInsetsHolder.update$default(this.composeInsets, r100, 0, 2, null);
        this.savedInsets = null;
        return;
    L9:
        return;
    }

    public final WindowInsetsHolder getComposeInsets() {
        return this.composeInsets;
    }

    public final boolean getPrepared() {
        return this.prepared;
    }

    public final boolean getRunningAnimation() {
        return this.runningAnimation;
    }

    public final WindowInsetsCompat getSavedInsets() {
        return this.savedInsets;
    }

    public InsetsListener(WindowInsetsHolder r100) {
        super(!r100.getConsumes() ? 1 : 0);
        this.composeInsets = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_compose_foundation_layout_InsetsListener_com_larus_apm_impl_protector_RunnableLancet_run(InsetsListener r100) {
        r100.androidx_compose_foundation_layout_InsetsListener__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat r100) {
        this.prepared = false;
        this.runningAnimation = false;
        WindowInsetsCompat r101 = this.savedInsets;
        if (r100.getDurationMillis() <= 0) goto L6;
        if (r101 == null) goto L6;
        this.composeInsets.updateImeAnimationSource(r101);
        this.composeInsets.updateImeAnimationTarget(r101);
        WindowInsetsHolder.update$default(this.composeInsets, r101, 0, 2, null);
    L6:
        this.savedInsets = null;
        super.onEnd(r100);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat r100) {
        this.prepared = true;
        this.runningAnimation = true;
        super.onPrepare(r100);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
        r100.requestApplyInsets();
    }

    public final void setPrepared(boolean r100) {
        this.prepared = r100;
    }

    public final void setRunningAnimation(boolean r100) {
        this.runningAnimation = r100;
    }

    public final void setSavedInsets(WindowInsetsCompat r100) {
        this.savedInsets = r100;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        this.savedInsets = r101;
        this.composeInsets.updateImeAnimationTarget(r101);
        if (this.prepared == false) goto L8;
        if (Build.VERSION.SDK_INT != 30) goto L11;
        r100.post(this);
    L11:
        if (this.composeInsets.getConsumes() == true) goto L13;
        return r101;
    L13:
        return WindowInsetsCompat.CONSUMED;
    L8:
        if (this.runningAnimation == true) goto L11;
        this.composeInsets.updateImeAnimationSource(r101);
        WindowInsetsHolder.update$default(this.composeInsets, r101, 0, 2, null);
        goto L11
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat r100, List<WindowInsetsAnimationCompat> r101) {
        WindowInsetsHolder.update$default(this.composeInsets, r100, 0, 2, null);
        if (this.composeInsets.getConsumes() == true) goto L5;
        return r100;
    L5:
        return WindowInsetsCompat.CONSUMED;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat r100, WindowInsetsAnimationCompat.BoundsCompat r101) {
        this.prepared = false;
        return super.onStart(r100, r101);
    }
}
