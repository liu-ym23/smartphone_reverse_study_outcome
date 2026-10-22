package androidx.compose.material3;

import S7.k;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001aC\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00042\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/material3/SheetState;", "sheetState", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Lkotlin/Function1;", "", "LC7/r;", "onFling", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "(Landroidx/compose/material3/SheetState;Landroidx/compose/foundation/gestures/Orientation;LS7/k;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "", "skipPartiallyExpanded", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "initialValue", "skipHiddenState", "rememberSheetState", "(ZLS7/k;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "Landroidx/compose/ui/unit/Dp;", "DragHandleVerticalPadding", "F", "Landroidx/compose/animation/core/AnimationSpec;", "BottomSheetAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = Dp.m6844constructorimpl(22);
    private static final AnimationSpec<Float> BottomSheetAnimationSpec = AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState sheetState, final Orientation orientation, final k kVar) {
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection.1
            private final float offsetToFloat(long j5) {
                return orientation == Orientation.Horizontal ? Offset.m3895getXimpl(j5) : Offset.m3896getYimpl(j5);
            }

            private final long toOffset(float f) {
                Orientation orientation2 = orientation;
                float f7 = orientation2 == Orientation.Horizontal ? f : 0.0f;
                if (orientation2 != Orientation.Vertical) {
                    f = 0.0f;
                }
                return OffsetKt.Offset(f7, f);
            }

            private final float velocityToFloat(long j5) {
                return orientation == Orientation.Horizontal ? Velocity.m7082getXimpl(j5) : Velocity.m7083getYimpl(j5);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPostFling-RZ2iAVY */
            public Object mo500onPostFlingRZ2iAVY(long j5, long j6, H7.c<? super Velocity> cVar) {
                kVar.invoke(new Float(velocityToFloat(j6)));
                return Velocity.m7073boximpl(j6);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPostScroll-DzOQY0M */
            public long mo501onPostScrollDzOQY0M(long consumed, long available, int source) {
                return NestedScrollSource.m5300equalsimpl0(source, NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI()) ? toOffset(sheetState.getAnchoredDraggableState$material3_release().dispatchRawDelta(offsetToFloat(available))) : Offset.INSTANCE.m3911getZeroF1C5BW0();
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPreFling-QWom1Mo */
            public Object mo775onPreFlingQWom1Mo(long j5, H7.c<? super Velocity> cVar) {
                float fVelocityToFloat = velocityToFloat(j5);
                float fRequireOffset = sheetState.requireOffset();
                float fMinAnchor = sheetState.getAnchoredDraggableState$material3_release().getAnchors().minAnchor();
                if (fVelocityToFloat >= 0.0f || fRequireOffset <= fMinAnchor) {
                    j5 = Velocity.INSTANCE.m7093getZero9UxMQ8M();
                } else {
                    kVar.invoke(new Float(fVelocityToFloat));
                }
                return Velocity.m7073boximpl(j5);
            }

            @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPreScroll-OzD1aCk */
            public long mo776onPreScrollOzD1aCk(long available, int source) {
                float fOffsetToFloat = offsetToFloat(available);
                return (fOffsetToFloat >= 0.0f || !NestedScrollSource.m5300equalsimpl0(source, NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI())) ? Offset.INSTANCE.m3911getZeroF1C5BW0() : toOffset(sheetState.getAnchoredDraggableState$material3_release().dispatchRawDelta(fOffsetToFloat));
            }
        };
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final SheetState rememberSheetState(boolean z10, k kVar, SheetValue sheetValue, boolean z11, Composer composer, int i, int i6) {
        final boolean z12 = (i6 & 1) != 0 ? false : z10;
        if ((i6 & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.material3.SheetDefaultsKt.rememberSheetState.1
                @Override // S7.k
                public final Boolean invoke(SheetValue sheetValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        final k kVar2 = kVar;
        final SheetValue sheetValue2 = (i6 & 4) != 0 ? SheetValue.Hidden : sheetValue;
        final boolean z13 = (i6 & 8) != 0 ? false : z11;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1032784200, i, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:407)");
        }
        final Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {Boolean.valueOf(z12), kVar2, Boolean.valueOf(z13)};
        Saver<SheetState, SheetValue> Saver = SheetState.INSTANCE.Saver(z12, kVar2, density, z13);
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(z12)) || (i & 6) == 4) | composer.changed(density) | ((((i & 896) ^ 384) > 256 && composer.changed(sheetValue2)) || (i & 384) == 256) | ((((i & 112) ^ 48) > 32 && composer.changed(kVar2)) || (i & 48) == 32) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z13)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object obj = new S7.a() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final SheetState invoke() {
                    return new SheetState(z12, density, sheetValue2, kVar2, z13);
                }
            };
            composer.updateRememberedValue(obj);
            objRememberedValue = obj;
        }
        SheetState sheetState = (SheetState) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) Saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return sheetState;
    }
}
