package androidx.compose.ui.window;

import android.content.Context;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002J&\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b'¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0002J$\u0010,\u001a\u00020\u00052\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020\u0005J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010 \u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Landroidx/compose/ui/window/DialogWrapper;", "Landroidx/activity/ComponentDialog;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/DialogProperties;", "composeView", "Landroid/view/View;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "dialogId", "Ljava/util/UUID;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/DialogProperties;Landroid/view/View;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;Ljava/util/UUID;)V", "dialogLayout", "Landroidx/compose/ui/window/DialogLayout;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "isPressOutside", "", "subCompositionView", "Landroidx/compose/ui/platform/AbstractComposeView;", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "onKeyUp", "keyCode", "", "event", "Landroid/view/KeyEvent;", "setLayoutDirection", "setContent", "parentComposition", "Landroidx/compose/runtime/CompositionContext;", "children", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "setSecurePolicy", "securePolicy", "Landroidx/compose/ui/window/SecureFlagPolicy;", "updateParameters", "disposeComposition", "onTouchEvent", "Landroid/view/MotionEvent;", "cancel", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DialogWrapper extends ComponentDialog implements ViewRootForInspector {
    private final View composeView;
    private final DialogLayout dialogLayout;
    private boolean isPressOutside;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private DialogProperties properties;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[LayoutDirection.values().length];
            r100[LayoutDirection.Ltr.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[LayoutDirection.Rtl.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public final /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.CC.$default$getViewRoot(this);
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    public static View INVOKEVIRTUAL_androidx_compose_ui_window_DialogWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static final void _init_$disableClipping(ViewGroup r100) {
        int r101 = 0;
        r100.setClipChildren(false);
        if ((r100 instanceof DialogLayout) == false) goto L5;
        return;
    L5:
        int r102 = r100.getChildCount();
    L6:
        if (r101 >= r102) goto L14;
        View r103 = r100.getChildAt(r101);
        if ((r103 instanceof ViewGroup) == false) goto L10;
        ViewGroup r104 = (ViewGroup) r103;
    L11:
        if (r104 == null) goto L13;
        _init_$disableClipping(r104);
    L13:
        r101 = r101 + 1;
        goto L6
    L10:
        r104 = null;
        goto L11
    }

    public static final /* synthetic */ Function0 access$getOnDismissRequest$p(DialogWrapper r100) {
        return r100.onDismissRequest;
    }

    public static final /* synthetic */ DialogProperties access$getProperties$p(DialogWrapper r100) {
        return r100.properties;
    }

    private final void setLayoutDirection(LayoutDirection r100) {
        DialogLayout r101 = this.dialogLayout;
        int r102 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        int r103 = 1;
        if (r102 != 1) goto L5;
        r103 = 0;
    L10:
        r101.setLayoutDirection(r103);
        return;
    L5:
        if (r102 == 2) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    private final void setSecurePolicy(SecureFlagPolicy r100) {
        boolean r101 = SecureFlagPolicy_androidKt.shouldApplySecureFlag(r100, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window r102 = getWindow();
        Intrinsics.checkNotNull(r102);
        if (r101 == false) goto L5;
        int r103 = 8192;
    L6:
        r102.setFlags(r103, 8192);
        return;
    L5:
        r103 = -8193;
        goto L6
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = super.onTouchEvent(r100);
        if (this.properties.getDismissOnClickOutside() == true) goto L5;
    L17:
        int r102 = r100.getActionMasked();
        if (r102 == 0) goto L22;
        if (r102 == 1) goto L22;
        if (r102 == 3) goto L22;
        return r101;
    L22:
        this.isPressOutside = false;
        return r101;
    L5:
        if (this.dialogLayout.isInsideContent(r100) == true) goto L17;
        int r103 = r100.getActionMasked();
        if (r103 == 0) goto L15;
        if (r103 == 1) goto L13;
        if (r103 != 3) goto L27;
        this.isPressOutside = false;
        return r101;
    L27:
        return r101;
    L13:
        if (this.isPressOutside == false) goto L25;
        this.onDismissRequest.invoke();
        this.isPressOutside = false;
    L16:
        return true;
    L25:
        return r101;
    L15:
        this.isPressOutside = true;
        goto L16
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int r100, KeyEvent r101) {
        if (this.properties.getDismissOnBackPress() == false) goto L13;
        if (r101.isTracking() == false) goto L13;
        if (r101.isCanceled() == true) goto L13;
        if (r100 != 111) goto L13;
        this.onDismissRequest.invoke();
        return true;
    L13:
        return super.onKeyUp(r100, r101);
    }

    public final void setContent(CompositionContext r100, Function2<? super Composer, ? super Integer, Unit> r101) {
        this.dialogLayout.setContent(r100, r101);
    }

    public final void updateParameters(Function0<Unit> r100, DialogProperties r101, LayoutDirection r102) {
        this.onDismissRequest = r100;
        this.properties = r101;
        setSecurePolicy(r101.getSecurePolicy());
        setLayoutDirection(r102);
        boolean r103 = r101.getDecorFitsSystemWindows();
        this.dialogLayout.updateProperties(r101.getUsePlatformDefaultWidth(), r103);
        setCanceledOnTouchOutside(r101.getDismissOnClickOutside());
        Window r104 = getWindow();
        if (r104 == null) goto L12;
        if (r103 == false) goto L7;
        int r105 = 0;
    L10:
        r104.setSoftInputMode(r105);
        return;
    L7:
        if (Build.VERSION.SDK_INT >= 31) goto L9;
        r105 = 16;
        goto L10
    L9:
        r105 = 48;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DialogWrapper(Function0<Unit> r100, DialogProperties r101, View r102, LayoutDirection r110, Density r111, UUID r112) {
        Context r103 = r102.getContext();
        if (r101.getDecorFitsSystemWindows() == false) goto L5;
        int r104 = R.style.DialogWindowTheme;
    L6:
        ViewGroup r105 = null;
        super(new ContextThemeWrapper(r103, r104), 0, 2, 0 == true ? 1 : 0);
        this.onDismissRequest = r100;
        this.properties = r101;
        this.composeView = r102;
        float r106 = Dp.m7544constructorimpl(8);
        this.maxSupportedElevation = r106;
        Window r107 = getWindow();
        if (r107 == null) goto L25;
        r107.requestFeature(1);
        r107.setBackgroundDrawableResource(android.R.color.transparent);
        WindowCompat.setDecorFitsSystemWindows(r107, this.properties.getDecorFitsSystemWindows());
        r107.setGravity(17);
        if (this.properties.getDecorFitsSystemWindows() == true) goto L17;
        r107.addFlags(65792);
        WindowManager.LayoutParams r108 = r107.getAttributes();
        int r109 = Build.VERSION.SDK_INT;
        if (r109 < 28) goto L14;
        Api28Impl.INSTANCE.setLayoutInDisplayCutout(r108);
    L14:
        if (r109 < 30) goto L16;
        Api30Impl r113 = Api30Impl.INSTANCE;
        r113.setFitInsetsSides(r108, 0);
        r113.setFitInsetsTypes(r108, 0);
    L16:
        r107.setAttributes(r108);
    L17:
        DialogLayout r114 = new DialogLayout(getContext(), r107);
        setTitle(this.properties.getWindowTitle());
        r114.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + r112);
        r114.setClipChildren(false);
        r114.setElevation(r111.mo371toPx0680j_4(r106));
        r114.setOutlineProvider(new DialogWrapper$1$2());
        this.dialogLayout = r114;
        View r115 = INVOKEVIRTUAL_androidx_compose_ui_window_DialogWrapper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r107);
        if ((r115 instanceof ViewGroup) == false) goto L20;
        r105 = (ViewGroup) r115;
    L20:
        if (r105 == null) goto L22;
        _init_$disableClipping(r105);
    L22:
        setContentView(r114);
        ViewTreeLifecycleOwner.set(r114, ViewTreeLifecycleOwner.get(r102));
        ViewTreeViewModelStoreOwner.set(r114, ViewTreeViewModelStoreOwner.get(r102));
        ViewTreeSavedStateRegistryOwner.set(r114, ViewTreeSavedStateRegistryOwner.get(r102));
        updateParameters(this.onDismissRequest, this.properties, r110);
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new AnonymousClass2(this), 2, null);
        return;
    L25:
        throw new IllegalStateException("Dialog has no window".toString());
    L5:
        r104 = R.style.FloatingDialogWindowTheme;
        goto L6
    }
}
