package androidx.compose.ui.window;

import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.byted.cast.common.CastMonitor;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0085\u0001BQ\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010[\u001a\u00020\u0005J&\u0010U\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020]2\u0011\u0010R\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\bQ¢\u0006\u0002\u0010^J\r\u0010_\u001a\u00020\u0005H\u0017¢\u0006\u0002\u0010`J\b\u0010a\u001a\u00020\u0005H\u0014J\b\u0010b\u001a\u00020\u0005H\u0014J\u001d\u0010c\u001a\u00020\u00052\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020eH\u0010¢\u0006\u0002\bgJ5\u0010h\u001a\u00020\u00052\u0006\u0010i\u001a\u00020@2\u0006\u0010j\u001a\u00020e2\u0006\u0010k\u001a\u00020e2\u0006\u0010l\u001a\u00020e2\u0006\u0010m\u001a\u00020eH\u0010¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020@2\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010r\u001a\u00020\u0005H\u0002J\b\u0010s\u001a\u00020\u0005H\u0002J.\u0010t\u001a\u00020\u00052\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010u\u001a\u00020(J\u0010\u0010v\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010w\u001a\u00020\u00052\u0006\u00107\u001a\u000206J\u0006\u0010z\u001a\u00020\u0005J\r\u0010{\u001a\u00020\u0005H\u0001¢\u0006\u0002\b|J\u0006\u0010}\u001a\u00020\u0005J\u0006\u0010~\u001a\u00020\u0005J\u0013\u0010\u007f\u001a\u00020@2\t\u0010p\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020\u00052\u0006\u0010u\u001a\u00020eH\u0016J\u0011\u0010\u0082\u0001\u001a\u00020\u00052\u0006\u0010u\u001a\u00020(H\u0002J\t\u0010\u0083\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0084\u0001\u001a\u00020>H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u00020\u001d8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b0\u00101\"\u0004\b2\u00103R/\u00107\u001a\u0004\u0018\u0001062\b\u0010-\u001a\u0004\u0018\u0001068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b<\u00105\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bA\u0010BR\u0010\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0004\n\u0002\u0010GR\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000RA\u0010R\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\bQ2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\bQ8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bW\u00105\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010Y\u001a\u00020@2\u0006\u0010X\u001a\u00020@@RX\u0094\u000e¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010BR\u000e\u0010x\u001a\u00020yX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, d2 = {"Landroidx/compose/ui/window/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "onDismissRequest", "Lkotlin/Function0;", "", "properties", "Landroidx/compose/ui/window/PopupProperties;", "testTag", "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "popupLayoutHelper", "Landroidx/compose/ui/window/PopupLayoutHelper;", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupProperties;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;Landroidx/compose/ui/window/PopupLayoutHelper;)V", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "windowManager", "Landroid/view/WindowManager;", "params", "Landroid/view/WindowManager$LayoutParams;", "getParams$ui_release$annotations", "()V", "getParams$ui_release", "()Landroid/view/WindowManager$LayoutParams;", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setParentLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "parentLayoutCoordinates$delegate", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", FaceService.girlLabel, "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "backCallback", "", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "show", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "onAttachedToWindow", "onDetachedFromWindow", "internalOnMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "internalOnMeasure$ui_release", "internalOnLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "internalOnLayout$ui_release", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "maybeRegisterBackCallback", "maybeUnregisterBackCallback", "updateParameters", "layoutDirection", "updatePopupProperties", "updateParentLayoutCoordinates", "locationOnScreen", "", "pollForLocationOnScreenChange", "updateParentBounds", "updateParentBounds$ui_release", "updatePosition", "dismiss", "onTouchEvent", "Landroid/view/MotionEvent;", "setLayoutDirection", "superSetLayoutDirection", "createLayoutParams", "getVisibleDisplayBounds", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PopupLayout extends AbstractComposeView implements ViewRootForInspector {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private static final Function1<PopupLayout, Unit> onCommitAffectingPopupPosition = null;
    private Object backCallback;
    private final State canCalculatePosition$delegate;
    private final View composeView;
    private final MutableState content$delegate;
    private final int[] locationOnScreen;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;
    private IntRect parentBounds;
    private final MutableState parentLayoutCoordinates$delegate;
    private LayoutDirection parentLayoutDirection;
    private final MutableState popupContentSize$delegate;
    private final PopupLayoutHelper popupLayoutHelper;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private PopupProperties properties;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private final SnapshotStateObserver snapshotStateObserver;
    private String testTag;
    private final WindowManager windowManager;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/window/PopupLayout$Companion;", "", "<init>", "()V", "onCommitAffectingPopupPosition", "Lkotlin/Function1;", "Landroidx/compose/ui/window/PopupLayout;", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

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

    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, null);
        this.windowManager.removeViewImmediate(this);
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public final /* synthetic */ View getViewRoot() {
        return ViewRootForInspector.CC.$default$getViewRoot(this);
    }

    @Override // android.view.View
    public void setLayoutDirection(int r100) {
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        onCommitAffectingPopupPosition = PopupLayout$Companion$onCommitAffectingPopupPosition$1.INSTANCE;
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams r100 = new WindowManager.LayoutParams();
        r100.gravity = 8388659;
        r100.flags = AndroidPopup_androidKt.access$flagsWithSecureFlagInherited(this.properties, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        r100.type = 1002;
        r100.token = this.composeView.getApplicationWindowToken();
        r100.width = -2;
        r100.height = -2;
        r100.format = -3;
        r100.setTitle(this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return r100;
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.parentLayoutCoordinates$delegate.getValue();
    }

    private final IntRect getVisibleDisplayBounds() {
        Rect r100 = this.previousWindowVisibleFrame;
        this.popupLayoutHelper.getWindowVisibleDisplayFrame(this.composeView, r100);
        return AndroidPopup_androidKt.access$toIntBounds(r100);
    }

    private final void maybeRegisterBackCallback() {
        if (this.properties.getDismissOnBackPress() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 33) goto L8;
        return;
    L8:
        if (this.backCallback != null) goto L10;
        this.backCallback = Api33Impl.createBackCallback(this.onDismissRequest);
    L10:
        Api33Impl.maybeRegisterBackCallback(this, this.backCallback);
    }

    private final void maybeUnregisterBackCallback() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.maybeUnregisterBackCallback(this, this.backCallback);
    L5:
        this.backCallback = null;
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m7803getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    public final void pollForLocationOnScreenChange() {
        int[] r100 = this.locationOnScreen;
        int r101 = r100[0];
        int r102 = r100[1];
        this.composeView.getLocationOnScreen(r100);
        int[] r103 = this.locationOnScreen;
        if (r101 == r103[0]) goto L5;
    L6:
        updateParentBounds$ui_release();
        return;
    L5:
        if (r102 != r103[1]) goto L6;
    }

    public final void show() {
        INVOKEINTERFACE_androidx_compose_ui_window_PopupLayout_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(this.windowManager, this, this.params);
    }

    public final void updatePosition() {
        final IntRect r100 = this.parentBounds;
        if (r100 != null) goto L5;
        return;
    L5:
        IntSize r101 = m7803getPopupContentSizebOM6tXw();
        if (r101 == null) goto L12;
        final long r102 = r101.m7723unboximpl();
        IntRect r103 = getVisibleDisplayBounds();
        int r104 = r103.getWidth();
        final long r110 = IntSize.m7714constructorimpl((((long) r104) << 32) | (((long) r103.getHeight()) & BodyPartID.bodyIdMax));
        final Ref.LongRef r111 = new Ref.LongRef();
        r111.element = IntOffset.Companion.m7687getZeronOccac();
        this.snapshotStateObserver.observeReads(this, onCommitAffectingPopupPosition, new AnonymousClass1(r111, this, r100, r110, r102));
        WindowManager.LayoutParams r105 = this.params;
        r105.x = IntOffset.m7676getXimpl(r111.element);
        WindowManager.LayoutParams r106 = this.params;
        r106.y = IntOffset.m7677getYimpl(r111.element);
        if (this.properties.getExcludeFromSystemGesture() == false) goto L10;
        this.popupLayoutHelper.setGestureExclusionRects(this, (int) (r110 >> 32), (int) (BodyPartID.bodyIdMax & r110));
    L10:
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
        return;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotStateObserver.start();
        maybeRegisterBackCallback();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotStateObserver.stop();
        this.snapshotStateObserver.clear();
        maybeUnregisterBackCallback();
    }

    public final void updateParentBounds$ui_release() {
        LayoutCoordinates r100 = getParentLayoutCoordinates();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L16;
        long r101 = r100.mo6258getSizeYbymL2g();
        long r102 = LayoutCoordinatesKt.positionInWindow(r100);
        int r103 = Math.round(Float.intBitsToFloat((int) (r102 >> 32)));
        int r104 = Math.round(Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax)));
        IntRect r105 = IntRectKt.m7709IntRectVbeCjmY(IntOffset.m7670constructorimpl((((long) r103) << 32) | (BodyPartID.bodyIdMax & ((long) r104))), r101);
        if (Intrinsics.areEqual(r105, this.parentBounds) == true) goto L15;
        this.parentBounds = r105;
        updatePosition();
        return;
    L15:
        return;
    }

    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.params;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public static final /* synthetic */ LayoutCoordinates access$getParentLayoutCoordinates(PopupLayout r100) {
        return r100.getParentLayoutCoordinates();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> r100) {
        this.content$delegate.setValue(r100);
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates r100) {
        this.parentLayoutCoordinates$delegate.setValue(r100);
    }

    private final void superSetLayoutDirection(LayoutDirection r100) {
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        int r102 = 1;
        if (r101 != 1) goto L5;
        r102 = 0;
    L10:
        super.setLayoutDirection(r102);
        return;
    L5:
        if (r101 == 2) goto L10;
        throw new NoWhenBranchMatchedException();
    }

    private final void updatePopupProperties(PopupProperties r100) {
        if (Intrinsics.areEqual(this.properties, r100) == false) goto L6;
        return;
    L6:
        if (r100.getUsePlatformDefaultWidth() == true) goto L8;
    L10:
        this.properties = r100;
        WindowManager.LayoutParams r101 = this.params;
        r101.flags = AndroidPopup_androidKt.access$flagsWithSecureFlagInherited(r100, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
        return;
    L8:
        if (this.properties.getUsePlatformDefaultWidth() == true) goto L10;
        WindowManager.LayoutParams r102 = this.params;
        r102.width = -2;
        r102.height = -2;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r100) {
        if (this.properties.getDismissOnBackPress() == true) goto L7;
        return super.dispatchKeyEvent(r100);
    L7:
        if (r100.getKeyCode() != 4) goto L9;
    L10:
        KeyEvent.DispatcherState r101 = getKeyDispatcherState();
        if (r101 != null) goto L15;
        return super.dispatchKeyEvent(r100);
    L15:
        if (r100.getAction() != 0) goto L21;
        if (r100.getRepeatCount() != 0) goto L21;
        r101.startTracking(r100, this);
        return true;
    L21:
        if (r100.getAction() == 1) goto L23;
    L31:
        return super.dispatchKeyEvent(r100);
    L23:
        if (r101.isTracking(r100) == false) goto L31;
        if (r100.isCanceled() == true) goto L31;
        Function0<Unit> r102 = this.onDismissRequest;
        if (r102 == null) goto L29;
        r102.invoke();
    L29:
        return true;
    L9:
        if (r100.getKeyCode() != 111) goto L31;
        goto L10
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (this.properties.getDismissOnClickOutside() == false) goto L5;
        boolean r101 = false;
        if (r100 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L14;
    L25:
        if (r100 != null) goto L27;
    L29:
        if (r101 == false) goto L35;
        Function0<Unit> r103 = this.onDismissRequest;
        if (r103 == null) goto L33;
        r103.invoke();
    L33:
        return true;
    L35:
        return super.onTouchEvent(r100);
    L27:
        if (r100.getAction() != 4) goto L29;
        r101 = true;
        goto L29
    L14:
        if (r100.getX() >= 0.0f) goto L16;
    L21:
        Function0<Unit> r104 = this.onDismissRequest;
        if (r104 == null) goto L24;
        r104.invoke();
    L24:
        return true;
    L16:
        if (r100.getX() >= getWidth()) goto L21;
        if (r100.getY() < 0.0f) goto L21;
        if (r100.getY() < getHeight()) goto L25;
    L9:
        if (r100.getAction() != 0) goto L11;
        r102 = true;
        goto L12
    L5:
        return super.onTouchEvent(r100);
    }

    public final void setParentLayoutDirection(LayoutDirection r100) {
        this.parentLayoutDirection = r100;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m7804setPopupContentSizefhxjrPA(IntSize r100) {
        this.popupContentSize$delegate.setValue(r100);
    }

    public final void setPositionProvider(PopupPositionProvider r100) {
        this.positionProvider = r100;
    }

    public final void setTestTag(String r100) {
        this.testTag = r100;
    }

    public final void updateParentLayoutCoordinates(LayoutCoordinates r100) {
        setParentLayoutCoordinates(r100);
        updateParentBounds$ui_release();
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer r100, final int r101) {
        Composer r102 = r100.startRestartGroup(-857613600);
        if ((r101 & 6) == 0) goto L5;
        int r103 = r101;
    L11:
        if ((r103 & 3) == 2) goto L13;
        boolean r104 = true;
    L15:
        if (r102.shouldExecute(r104, r103 & 1) == true) goto L17;
        r102.skipToGroupEnd();
    L23:
        ScopeUpdateScope r105 = r102.endRestartGroup();
        if (r105 == null) goto L27;
        r105.updateScope(new AnonymousClass4(this, r101));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-857613600, r103, -1, "androidx.compose.ui.window.PopupLayout.Content (AndroidPopup.android.kt:572)");
    L19:
        getContent().invoke(r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r104 = false;
        goto L15
    L5:
        if (r102.changedInstance(this) == false) goto L7;
        int r106 = 4;
    L8:
        r103 = r106 | r101;
        goto L11
    L7:
        r106 = 2;
        goto L8
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int r100, int r101) {
        if (this.properties.getUsePlatformDefaultWidth() == false) goto L5;
        super.internalOnMeasure$ui_release(r100, r101);
        return;
    L5:
        IntRect r102 = getVisibleDisplayBounds();
        super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(r102.getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(r102.getHeight(), Integer.MIN_VALUE));
    }

    public final void setContent(CompositionContext r100, Function2<? super Composer, ? super Integer, Unit> r101) {
        setParentCompositionContext(r100);
        setContent(r101);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public static void INVOKEINTERFACE_androidx_compose_ui_window_PopupLayout_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r100, View r101, ViewGroup.LayoutParams r102) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);
        r100.addView(r101, r102);
    }

    public final void updateParameters(Function0<Unit> r100, PopupProperties r101, String r102, LayoutDirection r103) {
        this.onDismissRequest = r100;
        this.testTag = r102;
        updatePopupProperties(r101);
        superSetLayoutDirection(r103);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean r100, int r101, int r102, int r103, int r104) {
        super.internalOnLayout$ui_release(r100, r101, r102, r103, r104);
        if (this.properties.getUsePlatformDefaultWidth() == true) goto L9;
        View r105 = getChildAt(0);
        if (r105 != null) goto L7;
        return;
    L7:
        WindowManager.LayoutParams r106 = this.params;
        r106.width = r105.getMeasuredWidth();
        WindowManager.LayoutParams r107 = this.params;
        r107.height = r105.getMeasuredHeight();
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
        return;
    }

    public PopupLayout(Function0<Unit> r100, PopupProperties r101, String r102, View r110, Density r111, PopupPositionProvider r112, UUID r113, PopupLayoutHelper r114) {
        super(r110.getContext(), null, 0, 6, null);
        this.onDismissRequest = r100;
        this.properties = r101;
        this.testTag = r102;
        this.composeView = r110;
        this.popupLayoutHelper = r114;
        Object r103 = r110.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) r103;
        this.params = createLayoutParams();
        this.positionProvider = r112;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.popupContentSize$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.parentLayoutCoordinates$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf(new PopupLayout$canCalculatePosition$2(this));
        float r104 = Dp.m7544constructorimpl(8);
        this.maxSupportedElevation = r104;
        this.previousWindowVisibleFrame = new Rect();
        this.snapshotStateObserver = new SnapshotStateObserver(new PopupLayout$snapshotStateObserver$1(this));
        setId(android.R.id.content);
        ViewTreeLifecycleOwner.set(this, ViewTreeLifecycleOwner.get(r110));
        ViewTreeViewModelStoreOwner.set(this, ViewTreeViewModelStoreOwner.get(r110));
        ViewTreeSavedStateRegistryOwner.set(this, ViewTreeSavedStateRegistryOwner.get(r110));
        setTag(R.id.compose_view_saveable_id_tag, "Popup:" + r113);
        setClipChildren(false);
        setElevation(r111.mo371toPx0680j_4(r104));
        setOutlineProvider(new AnonymousClass2());
        this.content$delegate = SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidPopup_androidKt.INSTANCE.m7802getLambda$1131826196$ui_release(), null, 2, null);
        this.locationOnScreen = new int[2];
    }

    public /* synthetic */ PopupLayout(Function0 r110, PopupProperties r111, String r112, View r113, Density r114, PopupPositionProvider r115, UUID r116, PopupLayoutHelper r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 128) != 0) goto L5;
        PopupLayoutHelper r100 = r117;
    L10:
        this(r110, r111, r112, r113, r114, r115, r116, r100);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        PopupLayoutHelper r101 = new PopupLayoutHelperImpl29();
    L8:
        r100 = r101;
        goto L10
    L7:
        r101 = new PopupLayoutHelperImpl();
        goto L8
    }
}
