package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a;\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\n2\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0002\u0010\u000e\u001a\u0090\u0001\u0010\u000f\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00100\"¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b#\u0010$\u001a\u0090\u0001\u0010%\u001a\u00020\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0013¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u001e2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00100\"¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b&\u0010'\u001a \u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\rH\u0002\u001a-\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\u0006\u0010/\u001a\u00020\u0006H\u0003¢\u0006\u0004\b0\u00101\u001a;\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00062\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\"2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\"2\u0006\u0010-\u001a\u00020\u001eH\u0003¢\u0006\u0004\b6\u00107\u001a\u0014\u0010?\u001a\u00020@2\n\u0010A\u001a\u0006\u0012\u0002\b\u00030BH\u0002\"\u0010\u00108\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010:\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0010\u0010;\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u00109\"\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0=X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010D\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material/DrawerState;", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "rememberBottomDrawerState", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "ModalDrawer", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "Landroidx/compose/ui/unit/Dp;", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawer", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "BottomDrawerScrim", "color", "onDismiss", "visible", "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "EndDrawerPadding", FaceService.girlLabel, "DrawerPositionalThreshold", "DrawerVelocityThreshold", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "BottomDrawerOpenFraction", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "material", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DrawerKt {
    private static final TweenSpec<Float> AnimationSpec = null;
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold = 0.0f;
    private static final float DrawerVelocityThreshold = 0.0f;
    private static final float EndDrawerPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0012H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0007*\u00020\u0019H\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0019*\u00020\u0012H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001b\u001a\u00020\u0019*\u00020\u0007H\u0003¢\u0006\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001f"}, d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toOffset", "", "(F)J", "toFloat", "velocityToFloat", "(J)F", "offsetToFloat", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation;

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public AnonymousClass1(AnchoredDraggableState<?> r100) {
            this.$state = r100;
            this.orientation = Orientation.Vertical;
        }

        private final float offsetToFloat(long r100) {
            if (this.orientation != Orientation.Horizontal) goto L5;
            long r101 = r100 >> 32;
        L7:
            return Float.intBitsToFloat((int) r101);
        L5:
            r101 = r100 & BodyPartID.bodyIdMax;
            goto L7
        }

        private final long toOffset(float r100) {
            Orientation r101 = this.orientation;
            if (r101 != Orientation.Horizontal) goto L5;
            float r102 = r100;
        L7:
            if (r101 == Orientation.Vertical) goto L11;
            r100 = 0.0f;
        L11:
            return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (((long) Float.floatToRawIntBits(r100)) & BodyPartID.bodyIdMax));
        L5:
            r102 = 0.0f;
            goto L7
        }

        private final float velocityToFloat(long r100) {
            if (this.orientation != Orientation.Horizontal) goto L6;
            return Velocity.m7786getXimpl(r100);
        L6:
            return Velocity.m7787getYimpl(r100);
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreFling-QWom1Mo */
        public Object mo498onPreFlingQWom1Mo(long r100, Continuation<? super Velocity> r101) {
            if ((r101 instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) == false) goto L7;
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r102 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            r100 = r102.J$0;
            ResultKt.throwOnFailure(r104);
        L23:
            return Velocity.m7777boximpl(r100);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            float r107 = velocityToFloat(r100);
            float r108 = this.$state.requireOffset();
            if (r107 < 0.0f) goto L17;
        L21:
            r100 = Velocity.Companion.m7797getZero9UxMQ8M();
            goto L23
        L17:
            if (r108 <= this.$state.getAnchors().minAnchor()) goto L21;
            AnchoredDraggableState<?> r109 = this.$state;
            r102.J$0 = r100;
            r102.label = 1;
            if (r109.settle(r107, r102) != r105) goto L23;
            return r105;
        L7:
            r102 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1(this, r101);
            goto L8
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
        public long mo499onPreScrollOzD1aCk(long r100, int r101) {
            float r102 = offsetToFloat(r100);
            if (r102 >= 0.0f) goto L8;
            if (NestedScrollSource.m6006equalsimpl0(r101, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L8;
            return toOffset(this.$state.dispatchRawDelta(r102));
        L8:
            return Offset.Companion.m4598getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
        public Object mo496onPostFlingRZ2iAVY(long r100, long r101, Continuation<? super Velocity> r102) {
            if ((r102 instanceof DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) == false) goto L7;
            DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r103 = (DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L14;
            if (r107 != 1) goto L13;
            r101 = r103.J$0;
            ResultKt.throwOnFailure(r105);
        L18:
            return Velocity.m7777boximpl(r101);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r105);
            AnchoredDraggableState<?> r108 = this.$state;
            float r109 = velocityToFloat(r101);
            r103.J$0 = r101;
            r103.label = 1;
            if (r108.settle(r109, r103) != r106) goto L18;
            return r106;
        L7:
            r103 = new DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1(this, r102);
            goto L8
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
        public long mo497onPostScrollDzOQY0M(long r100, long r101, int r102) {
            if (NestedScrollSource.m6006equalsimpl0(r102, NestedScrollSource.Companion.m6018getUserInputWNlRxjI()) == false) goto L6;
            return toOffset(this.$state.dispatchRawDelta(offsetToFloat(r101)));
        L6:
            return Offset.Companion.m4598getZeroF1C5BW0();
        }
    }

    private static final Unit BottomDrawerScrim_3J_VO9M$lambda$17(long r100, Function0 r101, boolean r102, int r110, Composer r111, int r112) {
        m1632BottomDrawerScrim3JVO9M(r100, r101, r102, r111, RecomposeScopeImplKt.updateChangedFlags(r110 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit BottomDrawer_Gs3lGvM$lambda$9(Function3 r110, Modifier r111, BottomDrawerState r112, boolean r210, Shape r211, float r212, long r213, long r214, long r215, Function2 r216, int r310, int r311, Composer r312, int r313) {
        m1631BottomDrawerGs3lGvM(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r312, RecomposeScopeImplKt.updateChangedFlags(r310 | 1), r311);
        return Unit.INSTANCE;
    }

    private static final Unit ModalDrawer_Gs3lGvM$lambda$8(Function3 r110, Modifier r111, DrawerState r112, boolean r210, Shape r211, float r212, long r213, long r214, long r215, Function2 r216, int r310, int r311, Composer r312, int r313) {
        m1633ModalDrawerGs3lGvM(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r312, RecomposeScopeImplKt.updateChangedFlags(r310 | 1), r311);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$24(boolean r100, Function0 r101, Function0 r102, long r110, int r111, Composer r112, int r113) {
        m1634ScrimBx497Mc(r100, r101, r102, r110, r112, RecomposeScopeImplKt.updateChangedFlags(r111 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(long r100, Function0 r101, DrawScope r102) {
        return Scrim_Bx497Mc$lambda$23$lambda$22(r100, r101, r102);
    }

    public static /* synthetic */ boolean b(BottomDrawerValue r100) {
        return rememberBottomDrawerState$lambda$5$lambda$4(r100);
    }

    public static /* synthetic */ DrawerState c(DrawerValue r100, Function1 r101) {
        return rememberDrawerState$lambda$3$lambda$2(r100, r101);
    }

    private static final float calculateFraction(float r100, float r101, float r102) {
        float r103 = (r102 - r100) / (r101 - r100);
        if (r103 >= 0.0f) goto L6;
        r103 = 0.0f;
    L6:
        if (r103 <= 1.0f) goto L9;
        return 1.0f;
    L9:
        return r103;
    }

    public static /* synthetic */ boolean d(Function0 r100) {
        return Scrim_Bx497Mc$lambda$21$lambda$20$lambda$19(r100);
    }

    public static /* synthetic */ Unit e(String r100, Function0 r101, SemanticsPropertyReceiver r102) {
        return Scrim_Bx497Mc$lambda$21$lambda$20(r100, r101, r102);
    }

    public static /* synthetic */ boolean f(Function0 r100) {
        return BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13$lambda$12(r100);
    }

    public static /* synthetic */ Unit g(Function3 r100, Modifier r101, BottomDrawerState r102, boolean r103, Shape r104, float r105, long r106, long r107, long r110, Function2 r111, int r112, int r113, Composer r114, int r115) {
        return BottomDrawer_Gs3lGvM$lambda$9(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115);
    }

    public static /* synthetic */ BottomDrawerState h(BottomDrawerValue r100, Density r101, Function1 r102, AnimationSpec r103) {
        return rememberBottomDrawerState$lambda$7$lambda$6(r100, r101, r102, r103);
    }

    public static /* synthetic */ Unit i(boolean r100, Function0 r101, Function0 r102, long r103, int r104, Composer r105, int r106) {
        return Scrim_Bx497Mc$lambda$24(r100, r101, r102, r103, r104, r105, r106);
    }

    public static /* synthetic */ Unit j(Function3 r100, Modifier r101, DrawerState r102, boolean r103, Shape r104, float r105, long r106, long r107, long r110, Function2 r111, int r112, int r113, Composer r114, int r115) {
        return ModalDrawer_Gs3lGvM$lambda$8(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115);
    }

    public static /* synthetic */ Unit k(String r100, Function0 r101, SemanticsPropertyReceiver r102) {
        return BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13(r100, r101, r102);
    }

    public static /* synthetic */ Unit l(long r100, Function0 r101, boolean r102, int r103, Composer r104, int r105) {
        return BottomDrawerScrim_3J_VO9M$lambda$17(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ Unit m(long r100, State r101, DrawScope r102) {
        return BottomDrawerScrim_3J_VO9M$lambda$16$lambda$15(r100, r101, r102);
    }

    public static /* synthetic */ boolean n(DrawerValue r100) {
        return rememberDrawerState$lambda$1$lambda$0(r100);
    }

    private static final boolean rememberBottomDrawerState$lambda$5$lambda$4(BottomDrawerValue r100) {
        return true;
    }

    private static final boolean rememberDrawerState$lambda$1$lambda$0(DrawerValue r100) {
        return true;
    }

    static {
        float r100 = 56;
        EndDrawerPadding = Dp.m7544constructorimpl(r100);
        DrawerPositionalThreshold = Dp.m7544constructorimpl(r100);
        DrawerVelocityThreshold = Dp.m7544constructorimpl(400);
        AnimationSpec = new TweenSpec(256, 0, null, 6, null);
    }

    public static final /* synthetic */ TweenSpec access$getAnimationSpec$p() {
        return AnimationSpec;
    }

    public static final /* synthetic */ float access$getDrawerPositionalThreshold$p() {
        return DrawerPositionalThreshold;
    }

    public static final /* synthetic */ float access$getDrawerVelocityThreshold$p() {
        return DrawerVelocityThreshold;
    }

    public static final /* synthetic */ float access$getEndDrawerPadding$p() {
        return EndDrawerPadding;
    }

    private static final float BottomDrawerScrim_3J_VO9M$lambda$10(State<Float> r100) {
        return r100.getValue().floatValue();
    }

    private static final boolean BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13$lambda$12(Function0 r100) {
        r100.invoke();
        return true;
    }

    private static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> r100) {
        return new AnonymousClass1(r100);
    }

    private static final boolean Scrim_Bx497Mc$lambda$21$lambda$20$lambda$19(Function0 r100) {
        r100.invoke();
        return true;
    }

    public static final /* synthetic */ NestedScrollConnection access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState r100) {
        return ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r100);
    }

    private static final DrawerState rememberDrawerState$lambda$3$lambda$2(DrawerValue r100, Function1 r101) {
        return new DrawerState(r100, r101);
    }

    private static final Unit BottomDrawerScrim_3J_VO9M$lambda$14$lambda$13(String r100, final Function0 r101, SemanticsPropertyReceiver r102) {
        SemanticsPropertiesKt.setContentDescription(r102, r100);
        SemanticsPropertiesKt.onClick$default(r102, null, new j3(r101), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit BottomDrawerScrim_3J_VO9M$lambda$16$lambda$15(long r110, State r111, DrawScope r112) {
        DrawScope.CC.m5407drawRectnJ9OG0$default(r112, r110, 0, 0, BottomDrawerScrim_3J_VO9M$lambda$10(r111), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$21$lambda$20(String r100, final Function0 r101, SemanticsPropertyReceiver r102) {
        SemanticsPropertiesKt.setContentDescription(r102, r100);
        SemanticsPropertiesKt.onClick$default(r102, null, new o3(r101), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit Scrim_Bx497Mc$lambda$23$lambda$22(long r110, Function0 r111, DrawScope r112) {
        DrawScope.CC.m5407drawRectnJ9OG0$default(r112, r110, 0, 0, ((Number) r111.invoke()).floatValue(), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ float access$calculateFraction(float r100, float r101, float r102) {
        return calculateFraction(r100, r101, r102);
    }

    private static final BottomDrawerState rememberBottomDrawerState$lambda$7$lambda$6(BottomDrawerValue r100, Density r101, Function1 r102, AnimationSpec r103) {
        return new BottomDrawerState(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    private static final void m1632BottomDrawerScrim3JVO9M(final long r210, final Function0<Unit> r211, final boolean r212, Composer r213, final int r214) {
        Composer r110 = r213.startRestartGroup(-513067266);
        if ((r214 & 6) == 0) goto L5;
        int r100 = r214;
    L11:
        if ((r214 & 48) != 0) goto L18;
        if (r110.changedInstance(r211) == false) goto L15;
        int r101 = 32;
    L16:
        r100 = r100 | r101;
        goto L18
    L15:
        r101 = 16;
    L18:
        if ((r214 & 384) == 0) goto L20;
    L24:
        int r111 = r100;
        if ((r111 & 147) == 146) goto L27;
        boolean r102 = true;
    L29:
        if (r110.shouldExecute(r102, r111 & 1) == true) goto L31;
        r110.skipToGroupEnd();
    L79:
        ScopeUpdateScope r103 = r110.endRestartGroup();
        if (r103 == null) goto L83;
        r103.updateScope(new m3(r210, r211, r212, r214));
        return;
    L83:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L34;
        ComposerKt.traceEventStart(-513067266, r111, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:725)");
    L34:
        if (r210 == 16) goto L36;
        boolean r104 = true;
    L37:
        if (r104 == false) goto L74;
        r110.startReplaceGroup(1001834356);
        if (r212 == false) goto L41;
        float r105 = 1.0f;
    L42:
        final State<Float> r106 = AnimateAsStateKt.animateFloatAsState(r105, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, r110, 48, 28);
        final String r107 = Strings_androidKt.m1746getString4foXLRw(Strings.Companion.m1738getCloseDrawerUdPEhr4(), r110, 6);
        if (r212 == false) goto L63;
        r110.startReplaceGroup(1002054704);
        Modifier.Companion r108 = Modifier.Companion;
        int r109 = r111 & 112;
        if (r109 != 32) goto L47;
        boolean r112 = true;
    L48:
        Object r113 = r110.rememberedValue();
        if (r112 == false) goto L51;
    L52:
        r113 = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(r211);
        r110.updateRememberedValue(r113);
    L53:
        Modifier r114 = SuspendingPointerInputFilterKt.pointerInput(r108, r211, (PointerInputEventHandler) r113);
        boolean r115 = r110.changed(r107);
        if (r109 != 32) goto L56;
        boolean r116 = true;
    L57:
        boolean r117 = r115 | r116;
        Object r118 = r110.rememberedValue();
        if (r117 == false) goto L60;
    L61:
        r118 = new k3(r107, r211);
        r110.updateRememberedValue(r118);
    L62:
        Modifier r119 = SemanticsModifierKt.semantics(r114, true, (Function1) r118);
        r110.endReplaceGroup();
    L64:
        Modifier r120 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(r119);
        if ((r111 & 14) != 4) goto L67;
        boolean r121 = true;
    L68:
        boolean r122 = r110.changed(r106) | r121;
        Object r123 = r110.rememberedValue();
        if (r122 == false) goto L71;
    L72:
        r123 = new l3(r210, r106);
        r110.updateRememberedValue(r123);
    L73:
        CanvasKt.Canvas(r120, (Function1) r123, r110, 0);
        r110.endReplaceGroup();
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L71:
        if (r123 != Composer.Companion.getEmpty()) goto L73;
    L67:
        r121 = false;
        goto L68
    L60:
        if (r118 != Composer.Companion.getEmpty()) goto L62;
    L56:
        r116 = false;
        goto L57
    L51:
        if (r113 != Composer.Companion.getEmpty()) goto L53;
    L47:
        r112 = false;
        goto L48
    L63:
        r110.startReplaceGroup(1002419388);
        r110.endReplaceGroup();
        r119 = Modifier.Companion;
        goto L64
    L41:
        r105 = 0.0f;
        goto L42
    L74:
        r110.startReplaceGroup(1002587780);
        r110.endReplaceGroup();
        goto L76
    L36:
        r104 = false;
        goto L37
    L27:
        r102 = false;
        goto L29
    L20:
        if (r110.changed(r212) == false) goto L22;
        int r124 = 256;
    L23:
        r100 = r100 | r124;
        goto L24
    L22:
        r124 = 128;
        goto L23
    L5:
        if (r110.changed(r210) == false) goto L7;
        int r125 = 4;
    L8:
        r100 = r125 | r214;
        goto L11
    L7:
        r125 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final /* synthetic */ void m1635access$BottomDrawerScrim3JVO9M(long r100, Function0 r101, boolean r102, Composer r103, int r104) {
        m1632BottomDrawerScrim3JVO9M(r100, r101, r102, r103, r104);
    }

    public static final DrawerState rememberDrawerState(final DrawerValue r100, final Function1<? super DrawerValue, Boolean> r101, Composer r102, int r103, int r110) {
        if ((r110 & 2) == 0) goto L9;
        Object r104 = r102.rememberedValue();
        if (r104 != Composer.Companion.getEmpty()) goto L7;
        r104 = new i3();
        r102.updateRememberedValue(r104);
    L7:
        r101 = (Function1) r104;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(-1435874229, r103, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:390)");
    L11:
        Object[] r105 = new Object[0];
        Saver<DrawerState, DrawerValue> r106 = DrawerState.Companion.Saver(r101);
        boolean r107 = true;
        if (((r103 & 14) ^ 6) <= 4) goto L16;
        if (r102.changed(r100.ordinal()) == false) goto L16;
    L17:
        boolean r108 = true;
    L20:
        if (((r103 & 112) ^ 48) <= 32) goto L24;
        if (r102.changed(r101) == false) goto L24;
    L27:
        boolean r109 = r108 | r107;
        Object r111 = r102.rememberedValue();
        if (r109 == false) goto L30;
    L31:
        r111 = new n3(r100, r101);
        r102.updateRememberedValue(r111);
    L32:
        DrawerState r112 = (DrawerState) RememberSaveableKt.m4284rememberSaveable(r105, r106, (Function0) r111, r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L35;
        ComposerKt.traceEventEnd();
    L35:
        return r112;
    L30:
        if (r111 != Composer.Companion.getEmpty()) goto L32;
    L24:
        if ((r103 & 48) == 32) goto L27;
        r107 = false;
    L16:
        if ((r103 & 6) == 4) goto L17;
        r108 = false;
        goto L20
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m1634ScrimBx497Mc(final boolean r110, final Function0<Unit> r111, final Function0<Float> r112, final long r210, Composer r211, final int r212) {
        Composer r100 = r211.startRestartGroup(1983403750);
        if ((r212 & 6) == 0) goto L5;
        int r101 = r212;
    L11:
        if ((r212 & 48) != 0) goto L18;
        if (r100.changedInstance(r111) == false) goto L15;
        int r102 = 32;
    L16:
        r101 = r101 | r102;
        goto L18
    L15:
        r102 = 16;
    L18:
        if ((r212 & 384) != 0) goto L25;
        if (r100.changedInstance(r112) == false) goto L22;
        int r103 = 256;
    L23:
        r101 = r101 | r103;
        goto L25
    L22:
        r103 = 128;
    L25:
        if ((r212 & 3072) == 0) goto L27;
    L31:
        boolean r113 = true;
        if ((r101 & 1171) == 1170) goto L34;
        boolean r104 = true;
    L36:
        if (r100.shouldExecute(r104, r101 & 1) == true) goto L38;
        r100.skipToGroupEnd();
    L79:
        ScopeUpdateScope r105 = r100.endRestartGroup();
        if (r105 == null) goto L83;
        r105.updateScope(new u3(r110, r111, r112, r210, r212));
        return;
    L83:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(1983403750, r101, -1, "androidx.compose.material.Scrim (Drawer.kt:751)");
    L40:
        final String r106 = Strings_androidKt.m1746getString4foXLRw(Strings.Companion.m1738getCloseDrawerUdPEhr4(), r100, 6);
        if (r110 == false) goto L61;
        r100.startReplaceGroup(1716233810);
        Modifier.Companion r107 = Modifier.Companion;
        int r114 = r101 & 112;
        if (r114 != 32) goto L45;
        boolean r115 = true;
    L46:
        Object r116 = r100.rememberedValue();
        if (r115 == false) goto L49;
    L50:
        r116 = new DrawerKt$Scrim$dismissDrawer$1$1(r111);
        r100.updateRememberedValue(r116);
    L51:
        Modifier r108 = SuspendingPointerInputFilterKt.pointerInput(r107, r111, (PointerInputEventHandler) r116);
        boolean r117 = r100.changed(r106);
        if (r114 != 32) goto L54;
        boolean r118 = true;
    L55:
        boolean r119 = r118 | r117;
        Object r120 = r100.rememberedValue();
        if (r119 == false) goto L58;
    L59:
        r120 = new s3(r106, r111);
        r100.updateRememberedValue(r120);
    L60:
        Modifier r109 = SemanticsModifierKt.semantics(r108, true, (Function1) r120);
        r100.endReplaceGroup();
    L62:
        Modifier r121 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, null).then(r109);
        if ((r101 & 7168) != 2048) goto L65;
        boolean r122 = true;
    L67:
        if ((r101 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT) == 256) goto L70;
        r113 = false;
    L70:
        boolean r123 = r122 | r113;
        Object r124 = r100.rememberedValue();
        if (r123 == false) goto L73;
    L74:
        r124 = new t3(r210, r112);
        r100.updateRememberedValue(r124);
    L75:
        CanvasKt.Canvas(r121, (Function1) r124, r100, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L73:
        if (r124 != Composer.Companion.getEmpty()) goto L75;
    L65:
        r122 = false;
        goto L67
    L58:
        if (r120 != Composer.Companion.getEmpty()) goto L60;
    L54:
        r118 = false;
        goto L55
    L49:
        if (r116 != Composer.Companion.getEmpty()) goto L51;
    L45:
        r115 = false;
        goto L46
    L61:
        r100.startReplaceGroup(1716557884);
        r100.endReplaceGroup();
        r109 = Modifier.Companion;
        goto L62
    L34:
        r104 = false;
        goto L36
    L27:
        if (r100.changed(r210) == false) goto L29;
        int r125 = 2048;
    L30:
        r101 = r101 | r125;
        goto L31
    L29:
        r125 = 1024;
        goto L30
    L5:
        if (r100.changed(r110) == false) goto L7;
        int r126 = 4;
    L8:
        r101 = r126 | r212;
        goto L11
    L7:
        r126 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$Scrim-Bx497Mc, reason: not valid java name */
    public static final /* synthetic */ void m1636access$ScrimBx497Mc(boolean r100, Function0 r101, Function0 r102, long r103, Composer r104, int r105) {
        m1634ScrimBx497Mc(r100, r101, r102, r103, r104, r105);
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue r100, final Function1<? super BottomDrawerValue, Boolean> r101, final AnimationSpec<Float> r102, Composer r110, int r111, int r112) {
        if ((r112 & 2) == 0) goto L9;
        Object r103 = r110.rememberedValue();
        if (r103 != Composer.Companion.getEmpty()) goto L7;
        r103 = new p3();
        r110.updateRememberedValue(r103);
    L7:
        r101 = (Function1) r103;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = DrawerDefaults.INSTANCE.getAnimationSpec();
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1477366969, r111, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:409)");
    L14:
        final Density r113 = (Density) r110.consume(CompositionLocalsKt.getLocalDensity());
        boolean r104 = true;
        Object[] r105 = {r113};
        Saver<BottomDrawerState, BottomDrawerValue> r106 = BottomDrawerState.Companion.Saver(r113, r101, r102);
        if (((r111 & 14) ^ 6) <= 4) goto L19;
        if (r110.changed(r100.ordinal()) == false) goto L19;
    L20:
        boolean r107 = true;
    L22:
        boolean r108 = r107 | r110.changed(r113);
        if (((r111 & 112) ^ 48) <= 32) goto L27;
        if (r110.changed(r101) == false) goto L27;
    L30:
        boolean r114 = (r108 | r104) | r110.changedInstance(r102);
        Object r109 = r110.rememberedValue();
        if (r114 == false) goto L33;
    L34:
        r109 = new q3(r100, r113, r101, r102);
        r110.updateRememberedValue(r109);
    L35:
        BottomDrawerState r115 = (BottomDrawerState) RememberSaveableKt.m4284rememberSaveable(r105, r106, (Function0) r109, r110, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
    L38:
        return r115;
    L33:
        if (r109 != Composer.Companion.getEmpty()) goto L35;
    L27:
        if ((r111 & 48) == 32) goto L30;
        r104 = false;
    L19:
        if ((r111 & 6) == 4) goto L20;
        r107 = false;
        goto L22
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX INFO: renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1631BottomDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r310, Modifier r311, BottomDrawerState r312, boolean r313, Shape r410, float r411, long r412, long r413, long r414, final Function2<? super Composer, ? super Integer, Unit> r415, Composer r416, final int r510, final int r511) {
        Composer r100 = r416.startRestartGroup(-1403479060);
        if ((r511 & 1) == 0) goto L6;
        int r101 = r510 | 6;
    L13:
        int r102 = r511 & 2;
        if (r102 == 0) goto L17;
        r101 = r101 | 48;
    L25:
        if ((r510 & 384) == 0) goto L27;
        BottomDrawerState r103 = r312;
    L35:
        int r104 = r511 & 8;
        if (r104 == 0) goto L38;
        r101 = r101 | 3072;
        boolean r110 = r313;
    L46:
        if ((r510 & 24576) != 0) goto L54;
        Shape r111 = r410;
        if ((r511 & 16) == 0) goto L50;
    L52:
        int r105 = 8192;
    L53:
        r101 = r101 | r105;
    L55:
        int r112 = r511 & 32;
        if (r112 == 0) goto L58;
        r101 = r101 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        float r113 = r411;
    L66:
        if ((1572864 & r510) != 0) goto L77;
        if ((r511 & 64) != 0) goto L73;
        if (r100.changed(r412) == false) goto L73;
        int r114 = 1048576;
    L74:
        r101 = r101 | r114;
    L73:
        r114 = 524288;
    L77:
        if ((r510 & 12582912) != 0) goto L87;
        if ((r511 & 128) == 0) goto L81;
    L83:
        int r106 = 4194304;
    L84:
        r101 = r101 | r106;
        goto L87
    L81:
        if (r100.changed(r413) == false) goto L83;
        r106 = 8388608;
    L87:
        if ((100663296 & r510) != 0) goto L97;
        if ((r511 & 256) == 0) goto L91;
    L93:
        int r107 = 33554432;
    L94:
        r101 = r101 | r107;
        goto L97
    L91:
        if (r100.changed(r414) == false) goto L93;
        r107 = 67108864;
    L97:
        if ((r511 & 512) == 0) goto L100;
        r101 = r101 | 805306368;
    L108:
        if ((r101 & 306783379) == 306783378) goto L110;
        boolean r108 = true;
    L112:
        if (r100.shouldExecute(r108, r101 & 1) == false) goto L173;
        r100.startDefaults();
        if ((r510 & 1) != 0) goto L116;
    L134:
        if (r102 == 0) goto L136;
        Modifier r109 = Modifier.Companion;
    L138:
        if ((r511 & 4) == 0) goto L140;
        int r314 = r101;
        boolean r115 = true;
        r103 = rememberBottomDrawerState(BottomDrawerValue.Closed, null, null, r100, 6, 6);
        int r116 = r314 & (-897);
    L141:
        if (r104 == 0) goto L144;
        r110 = true;
    L144:
        if ((r511 & 16) == 0) goto L146;
        Shape r117 = DrawerDefaults.INSTANCE.getShape(r100, 6);
        r116 = r116 & (-57345);
    L147:
        if (r112 == 0) goto L149;
        float r118 = DrawerDefaults.INSTANCE.m1630getElevationD9Ej5fM();
    L151:
        if ((r511 & 64) == 0) goto L153;
        long r119 = DrawerDefaults.INSTANCE.getBackgroundColor(r100, 6);
        r116 = r116 & (-3670017);
    L155:
        if ((r511 & 128) == 0) goto L157;
        long r120 = ColorsKt.m1610contentColorForek8zF_U(r119, r100, (r116 >> 18) & 14);
        r116 = r116 & (-29360129);
    L159:
        if ((r511 & 256) == 0) goto L161;
        r116 = r116 & (-234881025);
        long r315 = DrawerDefaults.INSTANCE.getScrimColor(r100, 6);
    L162:
        Modifier r121 = r109;
        ?? r122 = r115;
    L163:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L166;
        ComposerKt.traceEventStart(-1403479060, r116, -1, "androidx.compose.material.BottomDrawer (Drawer.kt:588)");
    L166:
        Object r123 = r100.rememberedValue();
        if (r123 != Composer.Companion.getEmpty()) goto L169;
        r123 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r100);
        r100.updateRememberedValue(r123);
    L169:
        CoroutineScope r210 = (CoroutineScope) r123;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(r121, 0.0f, r122, null), null, false, ComposableLambdaKt.rememberComposableLambda(468886998, r122, new DrawerKt$BottomDrawer$1(r110, r103, r415, r315, r210, r117, r119, r120, r118, r310), r100, 54), r100, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L172;
        ComposerKt.traceEventEnd();
    L172:
        final Modifier r124 = r121;
        final float r125 = r118;
        final Shape r126 = r117;
        final BottomDrawerState r127 = r103;
        final boolean r128 = r110;
        final long r129 = r120;
    L174:
        ScopeUpdateScope r130 = r100.endRestartGroup();
        if (r130 == null) goto L178;
        final long r131 = r119;
        final long r132 = r315;
        r130.updateScope(new r3(r310, r124, r127, r128, r126, r125, r131, r129, r132, r415, r510, r511));
        return;
    L178:
        return;
    L161:
        r315 = r414;
        goto L162
    L157:
        r120 = r413;
        goto L159
    L153:
        r119 = r412;
        goto L155
    L149:
        r118 = r113;
        goto L151
    L146:
        r117 = r111;
        goto L147
    L140:
        r116 = r101;
        r115 = true;
        r103 = r103;
        goto L141
    L136:
        r109 = r311;
        goto L138
    L116:
        if (r100.getDefaultsInvalid() == true) goto L134;
        r100.skipToGroupEnd();
        if ((r511 & 4) == 0) goto L122;
        r101 = r101 & (-897);
    L122:
        if ((r511 & 16) == 0) goto L125;
        r101 = r101 & (-57345);
    L125:
        if ((r511 & 64) == 0) goto L128;
        r101 = r101 & (-3670017);
    L128:
        if ((r511 & 128) == 0) goto L131;
        r101 = r101 & (-29360129);
    L131:
        if ((r511 & 256) == 0) goto L133;
        r101 = r101 & (-234881025);
    L133:
        r120 = r413;
        r315 = r414;
        r116 = r101;
        r117 = r111;
        r118 = r113;
        r122 = 1;
        r121 = r311;
        r119 = r412;
        goto L163
    L173:
        r100.skipToGroupEnd();
        r124 = r311;
        r315 = r414;
        r127 = r103;
        r128 = r110;
        r126 = r111;
        r125 = r113;
        r119 = r412;
        r129 = r413;
        goto L174
    L110:
        r108 = false;
        goto L112
    L100:
        if ((r510 & 805306368) != 0) goto L108;
        if (r100.changedInstance(r415) == false) goto L104;
        int r133 = 536870912;
    L105:
        r101 = r101 | r133;
        goto L108
    L104:
        r133 = 268435456;
        goto L105
    L58:
        r113 = r411;
        if ((196608 & r510) != 0) goto L66;
        if (r100.changed(r113) == false) goto L63;
        int r134 = 131072;
    L64:
        r101 = r101 | r134;
        goto L66
    L63:
        r134 = 65536;
        goto L64
    L50:
        if (r100.changed(r111) == false) goto L52;
        r105 = 16384;
        goto L53
    L54:
        r111 = r410;
        goto L55
    L38:
        r110 = r313;
        if ((r510 & 3072) != 0) goto L46;
        if (r100.changed(r110) == false) goto L43;
        int r135 = 2048;
    L44:
        r101 = r101 | r135;
        goto L46
    L43:
        r135 = 1024;
        goto L44
    L27:
        if ((r511 & 4) != 0) goto L31;
        r103 = r312;
        if (r100.changedInstance(r103) == false) goto L32;
        int r136 = 256;
    L33:
        r101 = r101 | r136;
    L32:
        r136 = 128;
        goto L33
    L31:
        r103 = r312;
        goto L32
    L17:
        if ((r510 & 48) != 0) goto L25;
        if (r100.changed(r311) == false) goto L21;
        int r137 = 32;
    L22:
        r101 = r101 | r137;
        goto L25
    L21:
        r137 = 16;
        goto L22
    L6:
        if ((r510 & 6) == 0) goto L8;
        r101 = r510;
        goto L13
    L8:
        if (r100.changedInstance(r310) == false) goto L10;
        int r138 = 4;
    L11:
        r101 = r138 | r510;
        goto L13
    L10:
        r138 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    public static final void m1633ModalDrawerGs3lGvM(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> r310, Modifier r311, DrawerState r312, boolean r313, Shape r314, float r315, long r410, long r411, long r412, final Function2<? super Composer, ? super Integer, Unit> r413, Composer r414, final int r415, final int r416) {
        Composer r100 = r414.startRestartGroup(1979404999);
        if ((r416 & 1) == 0) goto L6;
        int r101 = r415 | 6;
    L13:
        int r102 = r416 & 2;
        if (r102 == 0) goto L17;
        r101 = r101 | 48;
    L23:
        Modifier r103 = r311;
    L25:
        if ((r415 & 384) == 0) goto L27;
        DrawerState r104 = r312;
    L35:
        int r105 = r416 & 8;
        if (r105 == 0) goto L39;
        r101 = r101 | 3072;
    L45:
        boolean r106 = r313;
    L47:
        if ((r415 & 24576) == 0) goto L49;
        Shape r110 = r314;
    L57:
        int r111 = r416 & 32;
        if (r111 == 0) goto L61;
        r101 = r101 | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
    L67:
        float r112 = r315;
    L69:
        if ((1572864 & r415) == 0) goto L71;
        int r113 = r101;
    L80:
        if ((r415 & 12582912) != 0) goto L90;
        if ((r416 & 128) == 0) goto L84;
    L86:
        int r107 = 4194304;
    L87:
        r113 = r113 | r107;
        goto L90
    L84:
        if (r100.changed(r411) == false) goto L86;
        r107 = 8388608;
    L90:
        if ((100663296 & r415) != 0) goto L100;
        if ((r416 & 256) == 0) goto L94;
    L96:
        int r108 = 33554432;
    L97:
        r113 = r113 | r108;
        goto L100
    L94:
        if (r100.changed(r412) == false) goto L96;
        r108 = 67108864;
    L100:
        if ((r416 & 512) == 0) goto L103;
        r113 = r113 | 805306368;
    L110:
        if ((306783379 & r113) == 306783378) goto L112;
        boolean r109 = true;
    L114:
        if (r100.shouldExecute(r109, r113 & 1) == false) goto L174;
        r100.startDefaults();
        if ((r415 & 1) != 0) goto L118;
    L136:
        if (r102 == 0) goto L138;
        Modifier r114 = Modifier.Companion;
    L140:
        if ((r416 & 4) == 0) goto L142;
        DrawerState r115 = rememberDrawerState(DrawerValue.Closed, null, r100, 6, 2);
        r113 = r113 & (-897);
    L143:
        if (r105 == 0) goto L146;
        r106 = true;
    L146:
        if ((r416 & 16) == 0) goto L148;
        Shape r116 = DrawerDefaults.INSTANCE.getShape(r100, 6);
        r113 = r113 & (-57345);
    L149:
        if (r111 == 0) goto L151;
        float r117 = DrawerDefaults.INSTANCE.m1630getElevationD9Ej5fM();
    L153:
        if ((r416 & 64) == 0) goto L155;
        long r118 = DrawerDefaults.INSTANCE.getBackgroundColor(r100, 6);
        r113 = r113 & (-3670017);
    L157:
        if ((r416 & 128) == 0) goto L159;
        long r119 = ColorsKt.m1610contentColorForek8zF_U(r118, r100, (r113 >> 18) & 14);
        r113 = r113 & (-29360129);
    L161:
        if ((r416 & 256) == 0) goto L163;
        long r210 = DrawerDefaults.INSTANCE.getScrimColor(r100, 6);
        int r120 = r113 & (-234881025);
        long r121 = r119;
        long r316 = r210;
    L164:
        r100.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L167;
        ComposerKt.traceEventStart(1979404999, r120, -1, "androidx.compose.material.ModalDrawer (Drawer.kt:461)");
    L167:
        Object r122 = r100.rememberedValue();
        if (r122 != Composer.Companion.getEmpty()) goto L170;
        r122 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r100);
        r100.updateRememberedValue(r122);
    L170:
        CoroutineScope r123 = (CoroutineScope) r122;
        Modifier r124 = r114;
        BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxSize$default(r114, 0.0f, 1, null), null, false, ComposableLambdaKt.rememberComposableLambda(-1549911011, true, new DrawerKt$ModalDrawer$1(r115, r106, r123, r316, r116, r118, r121, r117, r413, r310), r100, 54), r100, 3072, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventEnd();
    L173:
        final DrawerState r125 = r115;
        final Shape r126 = r116;
        final float r127 = r117;
        final boolean r128 = r106;
        final long r129 = r118;
        final long r130 = r121;
        final Modifier r131 = r124;
        final long r132 = r316;
    L175:
        ScopeUpdateScope r133 = r100.endRestartGroup();
        if (r133 == null) goto L179;
        r133.updateScope(new v3(r310, r131, r125, r128, r126, r127, r129, r130, r132, r413, r415, r416));
        return;
    L179:
        return;
    L163:
        r316 = r412;
        r120 = r113;
        r121 = r119;
        goto L164
    L159:
        r119 = r411;
        goto L161
    L155:
        r118 = r410;
        goto L157
    L151:
        r117 = r112;
        goto L153
    L148:
        r116 = r110;
        goto L149
    L142:
        r115 = r104;
        goto L143
    L138:
        r114 = r103;
        goto L140
    L118:
        if (r100.getDefaultsInvalid() == true) goto L136;
        r100.skipToGroupEnd();
        if ((r416 & 4) == 0) goto L124;
        r113 = r113 & (-897);
    L124:
        if ((r416 & 16) == 0) goto L127;
        r113 = r113 & (-57345);
    L127:
        if ((r416 & 64) == 0) goto L130;
        r113 = r113 & (-3670017);
    L130:
        if ((r416 & 128) == 0) goto L133;
        r113 = r113 & (-29360129);
    L133:
        if ((r416 & 256) == 0) goto L135;
        r113 = r113 & (-234881025);
    L135:
        r316 = r412;
        r114 = r103;
        r115 = r104;
        r116 = r110;
        r117 = r112;
        r120 = r113;
        r118 = r410;
        r121 = r411;
        goto L164
    L174:
        r100.skipToGroupEnd();
        r131 = r103;
        r125 = r104;
        r128 = r106;
        r126 = r110;
        r127 = r112;
        r129 = r410;
        r130 = r411;
        r132 = r412;
        goto L175
    L112:
        r109 = false;
        goto L114
    L103:
        if ((r415 & 805306368) != 0) goto L110;
        if (r100.changedInstance(r413) == false) goto L107;
        int r134 = 536870912;
    L108:
        r113 = r113 | r134;
        goto L110
    L107:
        r134 = 268435456;
        goto L108
    L71:
        if ((r416 & 64) != 0) goto L75;
        int r135 = r101;
        if (r100.changed(r410) == false) goto L76;
        int r136 = 1048576;
    L77:
        r113 = r135 | r136;
    L76:
        r136 = 524288;
        goto L77
    L75:
        r135 = r101;
        goto L76
    L61:
        if ((196608 & r415) != 0) goto L67;
        r112 = r315;
        if (r100.changed(r112) == false) goto L65;
        int r137 = 131072;
    L66:
        r101 = r101 | r137;
        goto L69
    L65:
        r137 = 65536;
        goto L66
    L49:
        if ((r416 & 16) != 0) goto L53;
        r110 = r314;
        if (r100.changed(r110) == false) goto L54;
        int r138 = 16384;
    L55:
        r101 = r101 | r138;
    L54:
        r138 = 8192;
        goto L55
    L53:
        r110 = r314;
        goto L54
    L39:
        if ((r415 & 3072) != 0) goto L45;
        r106 = r313;
        if (r100.changed(r106) == false) goto L43;
        int r139 = 2048;
    L44:
        r101 = r101 | r139;
        goto L47
    L43:
        r139 = 1024;
        goto L44
    L27:
        if ((r416 & 4) != 0) goto L31;
        r104 = r312;
        if (r100.changed(r104) == false) goto L32;
        int r140 = 256;
    L33:
        r101 = r101 | r140;
    L32:
        r140 = 128;
        goto L33
    L31:
        r104 = r312;
        goto L32
    L17:
        if ((r415 & 48) != 0) goto L23;
        r103 = r311;
        if (r100.changed(r103) == false) goto L21;
        int r141 = 32;
    L22:
        r101 = r101 | r141;
        goto L25
    L21:
        r141 = 16;
        goto L22
    L6:
        if ((r415 & 6) == 0) goto L8;
        r101 = r415;
        goto L13
    L8:
        if (r100.changedInstance(r310) == false) goto L10;
        int r142 = 4;
    L11:
        r101 = r142 | r415;
        goto L13
    L10:
        r142 = 2;
        goto L11
    }
}
