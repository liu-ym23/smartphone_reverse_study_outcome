package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import Y7.e;
import Y7.f;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import g1.AbstractC1451a;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\u001a\u007f\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\b\b\u0003\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aµ\u0001\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0003\u0010\f\u001a\u00020\u000b2\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\tH\u0007¢\u0006\u0004\b\u0013\u0010\u0019\u001au\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00152\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0004\b\u0013\u0010\u001b\u001a\u0081\u0001\u0010\u001c\u001a\u00020\u00032\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\b\b\u0003\u0010\f\u001a\u00020\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aæ\u0001\u0010\u001c\u001a\u00020\u00032\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\t2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\b\b\u0003\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001c\u0010#\u001a\u009a\u0001\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020 2\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u001e\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0016H\u0007¢\u0006\u0004\b\u001c\u0010$\u001aa\u0010%\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0004\b%\u0010&\u001a\u0082\u0001\u0010'\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u00162\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0016H\u0003¢\u0006\u0004\b'\u0010(\u001a/\u0010.\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0002¢\u0006\u0004\b.\u0010/\u001a5\u00109\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u0000\u0018\u000105*\u0002002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0082@ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u0017\u0010:\u001a\u00020*2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010;\u001a7\u0010A\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0000H\u0002¢\u0006\u0004\bA\u0010B\u001a:\u0010A\u001a\u00020C2\u0006\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u00002\u0006\u0010D\u001a\u00020C2\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a'\u0010J\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\u00002\u0006\u0010I\u001a\u00020\u0000H\u0002¢\u0006\u0004\bJ\u0010K\u001a#\u0010L\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bL\u0010M\u001a#\u0010N\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bN\u0010O\u001a#\u0010P\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\bP\u0010O\u001a+\u0010Q\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\bQ\u0010R\u001a3\u0010S\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010W\u001a\u00020C2\u0006\u0010U\u001a\u00020\u00002\u0006\u0010V\u001a\u00020\u0000H\u0001¢\u0006\u0004\bW\u0010X\u001a\u001d\u0010W\u001a\u00020C2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00000\tH\u0001¢\u0006\u0004\bW\u0010Z\"\u001a\u0010\\\u001a\u00020[8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u001a\u0010`\u001a\u00020[8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b`\u0010]\u001a\u0004\ba\u0010_\"\u0014\u0010b\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010]\"\u0014\u0010d\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010e\"\u0014\u0010f\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010]\"\u0014\u0010g\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010]\"\u0014\u0010i\u001a\u00020h8\u0002X\u0082T¢\u0006\u0006\n\u0004\bi\u0010j\"\u001e\u0010o\u001a\u00020\u0007*\u00020C8@X\u0081\u0004¢\u0006\f\u0012\u0004\bm\u0010n\u001a\u0004\bk\u0010l\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006p"}, d2 = {"", "value", "Lkotlin/Function1;", "LC7/r;", "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", "", "enabled", "LY7/b;", "valueRange", "", "steps", "Lkotlin/Function0;", "onValueChangeFinished", "Landroidx/compose/material3/SliderColors;", "colors", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Slider", "(FLS7/k;Landroidx/compose/ui/Modifier;ZLY7/b;ILS7/a;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/material3/SliderState;", "Landroidx/compose/runtime/Composable;", "thumb", "track", "(FLS7/k;Landroidx/compose/ui/Modifier;ZLS7/a;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILS7/o;LS7/o;LY7/b;Landroidx/compose/runtime/Composer;III)V", "state", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;LS7/o;Landroidx/compose/runtime/Composer;II)V", "RangeSlider", "(LY7/b;LS7/k;Landroidx/compose/ui/Modifier;ZLY7/b;ILS7/a;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "startInteractionSource", "endInteractionSource", "Landroidx/compose/material3/RangeSliderState;", "startThumb", "endThumb", "(LY7/b;LS7/k;Landroidx/compose/ui/Modifier;ZLY7/b;LS7/a;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;LS7/o;LS7/o;ILandroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;LS7/o;LS7/o;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;LS7/o;Landroidx/compose/runtime/Composer;I)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/o;LS7/o;LS7/o;Landroidx/compose/runtime/Composer;I)V", "current", "", "tickFractions", "minPx", "maxPx", "snapValueToTick", "(F[FFF)F", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/input/pointer/PointerId;", "id", "Landroidx/compose/ui/input/pointer/PointerType;", "type", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILH7/c;)Ljava/lang/Object;", "awaitSlop", "stepsToTickFractions", "(I)[F", "a1", "b1", "x1", "a2", "b2", "scale", "(FFFFF)F", "Landroidx/compose/material3/SliderRange;", "x", "scale-ziovWd0", "(FFJFF)J", "a", "b", "pos", "calcFraction", "(FFF)F", "sliderSemantics", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;Z)Landroidx/compose/ui/Modifier;", "rangeSliderStartThumbSemantics", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;Z)Landroidx/compose/ui/Modifier;", "rangeSliderEndThumbSemantics", "sliderTapModifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Z)Landroidx/compose/ui/Modifier;", "rangeSliderPressDragModifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Z)Landroidx/compose/ui/Modifier;", "start", "endInclusive", "SliderRange", "(FF)J", "range", "(LY7/b;)J", "Landroidx/compose/ui/unit/Dp;", "TrackHeight", "F", "getTrackHeight", "()F", "ThumbWidth", "getThumbWidth", "ThumbHeight", "Landroidx/compose/ui/unit/DpSize;", "ThumbSize", "J", "ThumbTrackGapSize", "TrackInsideCornerSize", "", "SliderRangeTolerance", "D", "isSpecified-If1S1O4", "(J)Z", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderKt {
    private static final double SliderRangeTolerance = 1.0E-4d;
    private static final float ThumbHeight;
    private static final long ThumbSize;
    private static final float ThumbTrackGapSize;
    private static final float ThumbWidth;
    private static final float TrackHeight;
    private static final float TrackInsideCornerSize;

    @J7.c(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", l = {1651}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06401 extends SuspendLambda implements n {
        final /* synthetic */ MutableInteractionSource $endInteractionSource;
        final /* synthetic */ MutableInteractionSource $startInteractionSource;
        final /* synthetic */ RangeSliderState $state;
        private /* synthetic */ Object L$0;
        int label;

        @J7.c(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", l = {1652}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00891 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ RangeSliderState $state;
            private /* synthetic */ Object L$0;
            int label;

            @J7.c(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", l = {1653, 1665, 1687}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00901 extends RestrictedSuspendLambda implements n {
                final /* synthetic */ InterfaceC1733z $$this$coroutineScope;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ RangeSliderState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                @J7.c(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", l = {1705}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                public static final class AnonymousClass2 extends SuspendLambda implements n {
                    final /* synthetic */ Ref$BooleanRef $draggingStart;
                    final /* synthetic */ DragInteraction $finishInteraction;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref$BooleanRef ref$BooleanRef, DragInteraction dragInteraction, H7.c<? super AnonymousClass2> cVar) {
                        super(2, cVar);
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$draggingStart = ref$BooleanRef;
                        this.$finishInteraction = dragInteraction;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.label;
                        if (i == 0) {
                            kotlin.b.b(obj);
                            MutableInteractionSource mutableInteractionSourceActiveInteraction = this.$rangeSliderLogic.activeInteraction(this.$draggingStart.f4916a);
                            DragInteraction dragInteraction = this.$finishInteraction;
                            this.label = 1;
                            if (mutableInteractionSourceActiveInteraction.emit(dragInteraction, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            kotlin.b.b(obj);
                        }
                        return r.f317a;
                    }

                    @Override // S7.n
                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                        return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00901(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, InterfaceC1733z interfaceC1733z, H7.c<? super C00901> cVar) {
                    super(2, cVar);
                    this.$state = rangeSliderState;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$$this$coroutineScope = interfaceC1733z;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    C00901 c00901 = new C00901(this.$state, this.$rangeSliderLogic, this.$$this$coroutineScope, cVar);
                    c00901.L$0 = obj;
                    return c00901;
                }

                @Override // S7.n
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
                    return ((C00901) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
                }

                /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
                /* JADX WARN: Removed duplicated region for block: B:54:0x0160  */
                /* JADX WARN: Removed duplicated region for block: B:57:0x016a A[Catch: CancellationException -> 0x0178, TryCatch #1 {CancellationException -> 0x0178, blocks: (B:55:0x0162, B:57:0x016a, B:58:0x0170), top: B:68:0x0162 }] */
                /* JADX WARN: Removed duplicated region for block: B:58:0x0170 A[Catch: CancellationException -> 0x0178, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x0178, blocks: (B:55:0x0162, B:57:0x016a, B:58:0x0170), top: B:68:0x0162 }] */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r15) {
                    /*
                        Method dump skipped, instructions count: 411
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.C06401.C00891.C00901.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00891(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, H7.c<? super C00891> cVar) {
                super(2, cVar);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = rangeSliderState;
                this.$rangeSliderLogic = rangeSliderLogic;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00891 c00891 = new C00891(this.$$this$pointerInput, this.$state, this.$rangeSliderLogic, cVar);
                c00891.L$0 = obj;
                return c00891;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C00901 c00901 = new C00901(this.$state, this.$rangeSliderLogic, interfaceC1733z, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c00901, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00891) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06401(RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, H7.c<? super C06401> cVar) {
            super(2, cVar);
            this.$state = rangeSliderState;
            this.$startInteractionSource = mutableInteractionSource;
            this.$endInteractionSource = mutableInteractionSource2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06401 c06401 = new C06401(this.$state, this.$startInteractionSource, this.$endInteractionSource, cVar);
            c06401.L$0 = obj;
            return c06401;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((C06401) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                C00891 c00891 = new C00891((PointerInputScope) this.L$0, this.$state, new RangeSliderLogic(this.$state, this.$startInteractionSource, this.$endInteractionSource), null);
                this.label = 1;
                if (AbstractC1683A.f(c00891, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    @J7.c(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1", f = "Slider.kt", l = {1627}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06431 extends SuspendLambda implements n {
        final /* synthetic */ SliderState $state;
        private /* synthetic */ Object L$0;
        int label;

        @J7.c(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", "it", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/PressGestureScope;Landroidx/compose/ui/geometry/Offset;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00931 extends SuspendLambda implements o {
            final /* synthetic */ SliderState $state;
            /* synthetic */ long J$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00931(SliderState sliderState, H7.c<? super C00931> cVar) {
                super(3, cVar);
                this.$state = sliderState;
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2278invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m3905unboximpl(), (H7.c) obj3);
            }

            /* renamed from: invoke-d-4ec7I, reason: not valid java name */
            public final Object m2278invoked4ec7I(PressGestureScope pressGestureScope, long j5, H7.c<? super r> cVar) {
                C00931 c00931 = new C00931(this.$state, cVar);
                c00931.J$0 = j5;
                return c00931.invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                this.$state.m2291onPressk4lQ0M$material3_release(this.J$0);
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06431(SliderState sliderState, H7.c<? super C06431> cVar) {
            super(2, cVar);
            this.$state = sliderState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C06431 c06431 = new C06431(this.$state, cVar);
            c06431.L$0 = obj;
            return c06431;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((C06431) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                C00931 c00931 = new C00931(this.$state, null);
                final SliderState sliderState = this.$state;
                k kVar = new k() { // from class: androidx.compose.material3.SliderKt.sliderTapModifier.1.2
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        m2279invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m2279invokek4lQ0M(long j5) {
                        sliderState.dispatchRawDelta(0.0f);
                        sliderState.getGestureEndAction().invoke();
                    }
                };
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, c00931, kVar, this, 3, null) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }
    }

    static {
        SliderTokens sliderTokens = SliderTokens.INSTANCE;
        TrackHeight = sliderTokens.m3274getInactiveTrackHeightD9Ej5fM();
        float fM3272getHandleWidthD9Ej5fM = sliderTokens.m3272getHandleWidthD9Ej5fM();
        ThumbWidth = fM3272getHandleWidthD9Ej5fM;
        float fM3271getHandleHeightD9Ej5fM = sliderTokens.m3271getHandleHeightD9Ej5fM();
        ThumbHeight = fM3271getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.m6866DpSizeYgX7TsA(fM3272getHandleWidthD9Ej5fM, fM3271getHandleHeightD9Ej5fM);
        ThumbTrackGapSize = sliderTokens.m3264getActiveHandleLeadingSpaceD9Ej5fM();
        TrackInsideCornerSize = Dp.m6844constructorimpl(2);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010a  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(final Y7.b r28, final S7.k r29, androidx.compose.ui.Modifier r30, boolean r31, Y7.b r32, @androidx.annotation.IntRange(from = com.stepos.policy.sdk.config.PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int r33, S7.a r34, androidx.compose.material3.SliderColors r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(Y7.b, S7.k, androidx.compose.ui.Modifier, boolean, Y7.b, int, S7.a, androidx.compose.material3.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z10, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final o oVar, o oVar2, o oVar3, Composer composer, final int i) {
        Modifier modifier2;
        int i6;
        o oVar4;
        final o oVar5;
        o oVar6 = oVar3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1411725677);
        if ((i & 6) == 0) {
            modifier2 = modifier;
            i6 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(rangeSliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar6) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            oVar4 = oVar2;
            oVar5 = oVar6;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411725677, i6, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:735)");
            }
            rangeSliderState.setRtl$material3_release(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierRangeSliderPressDragModifier = rangeSliderPressDragModifier(companion, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z10);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(androidx.compose.ui.R.string.range_start), composerStartRestartGroup, 0);
            final String strM2752getString2EP1pXo2 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(androidx.compose.ui.R.string.range_end), composerStartRestartGroup, 0);
            Modifier modifierThen = SizeKt.m741requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null).then(modifierRangeSliderPressDragModifier);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        long j6 = j5;
                        int size = list.size();
                        int i10 = 0;
                        int i11 = 0;
                        while (i11 < size) {
                            Measurable measurable = list.get(i11);
                            if (LayoutIdKt.getLayoutId(measurable) == RangeSliderComponents.STARTTHUMB) {
                                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j6);
                                int size2 = list.size();
                                int i12 = 0;
                                while (i12 < size2) {
                                    Measurable measurable2 = list.get(i12);
                                    if (LayoutIdKt.getLayoutId(measurable2) == RangeSliderComponents.ENDTHUMB) {
                                        final Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(j6);
                                        int size3 = list.size();
                                        while (i10 < size3) {
                                            Measurable measurable3 = list.get(i10);
                                            if (LayoutIdKt.getLayoutId(measurable3) == RangeSliderComponents.TRACK) {
                                                final Placeable placeableMo5549measureBRTryo03 = measurable3.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(ConstraintsKt.m6817offsetNN6EwU$default(j6, (-(placeableMo5549measureBRTryo02.getWidth() + placeableMo5549measureBRTryo0.getWidth())) / 2, 0, 2, null), 0, 0, 0, 0, 11, null));
                                                int width = ((placeableMo5549measureBRTryo02.getWidth() + placeableMo5549measureBRTryo0.getWidth()) / 2) + placeableMo5549measureBRTryo03.getWidth();
                                                int iMax = Math.max(placeableMo5549measureBRTryo03.getHeight(), Math.max(placeableMo5549measureBRTryo0.getHeight(), placeableMo5549measureBRTryo02.getHeight()));
                                                rangeSliderState.setTrackHeight$material3_release(placeableMo5549measureBRTryo03.getHeight());
                                                rangeSliderState.setTotalWidth$material3_release(width);
                                                rangeSliderState.updateMinMaxPx$material3_release();
                                                final int width2 = placeableMo5549measureBRTryo0.getWidth() / 2;
                                                final int iU = U7.a.U(rangeSliderState.getCoercedActiveRangeStartAsFraction$material3_release() * placeableMo5549measureBRTryo03.getWidth());
                                                final int iU2 = U7.a.U((rangeSliderState.getCoercedActiveRangeEndAsFraction$material3_release() * placeableMo5549measureBRTryo03.getWidth()) + androidx.compose.foundation.b.D(placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo0.getWidth(), 2));
                                                final int iF = androidx.compose.foundation.b.f(placeableMo5549measureBRTryo03, iMax, 2);
                                                final int iF2 = androidx.compose.foundation.b.f(placeableMo5549measureBRTryo0, iMax, 2);
                                                final int iF3 = androidx.compose.foundation.b.f(placeableMo5549measureBRTryo02, iMax, 2);
                                                return MeasureScope.layout$default(measureScope, width, iMax, null, new k() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // S7.k
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((Placeable.PlacementScope) obj);
                                                        return r.f317a;
                                                    }

                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo03, width2, iF, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, iU, iF2, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo02, iU2, iF3, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                            i10++;
                                            j6 = j5;
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                    i12++;
                                    j6 = j5;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i11++;
                            j6 = j5;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            int i10 = i6;
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            Modifier modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(companion, RangeSliderComponents.STARTTHUMB), null, false, 3, null);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new k() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m2275invokeozmzZPI(((IntSize) obj).m7019unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m2275invokeozmzZPI(long j5) {
                        rangeSliderState.setStartThumbWidth$material3_release(IntSize.m7015getWidthimpl(j5));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Modifier modifierRangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default, (k) objRememberedValue2), rangeSliderState, z10);
            boolean zChanged = composerStartRestartGroup.changed(strM2752getString2EP1pXo);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new k() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return r.f317a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM2752getString2EP1pXo);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierFocusable = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierRangeSliderStartThumbSemantics, true, (k) objRememberedValue3), z10, mutableInteractionSource);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusable);
            S7.a constructor2 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG2 = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
            if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i11 = (i10 >> 3) & 14;
            oVar.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i10 >> 12) & 112) | i11));
            composerStartRestartGroup.endNode();
            Modifier modifierWrapContentWidth$default2 = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(companion, RangeSliderComponents.ENDTHUMB), null, false, 3, null);
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(rangeSliderState);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new k() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$4$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m2276invokeozmzZPI(((IntSize) obj).m7019unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m2276invokeozmzZPI(long j5) {
                        rangeSliderState.setEndThumbWidth$material3_release(IntSize.m7015getWidthimpl(j5));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierRangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default2, (k) objRememberedValue4), rangeSliderState, z10);
            boolean zChanged2 = composerStartRestartGroup.changed(strM2752getString2EP1pXo2);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new k() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$5$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return r.f317a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM2752getString2EP1pXo2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Modifier modifierFocusable2 = FocusableKt.focusable(SemanticsModifierKt.semantics(modifierRangeSliderEndThumbSemantics, true, (k) objRememberedValue5), z10, mutableInteractionSource2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusable2);
            S7.a constructor3 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl3 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG3 = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM3474constructorimpl3, currentCompositionLocalMap3);
            if (composerM3474constructorimpl3.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion3.getSetModifier());
            o oVar7 = oVar2;
            oVar7.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i10 >> 15) & 112) | i11));
            composerStartRestartGroup.endNode();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, RangeSliderComponents.TRACK);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            S7.a constructor4 = companion3.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl4 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG4 = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, composerM3474constructorimpl4, currentCompositionLocalMap4);
            if (composerM3474constructorimpl4.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                androidx.appfunctions.metadata.a.z(nVarG4, currentCompositeKeyHash4, composerM3474constructorimpl4, currentCompositeKeyHash4);
            }
            Updater.m3481setimpl(composerM3474constructorimpl4, modifierMaterializeModifier4, companion3.getSetModifier());
            o oVar8 = oVar3;
            oVar8.invoke(rangeSliderState, composerStartRestartGroup, Integer.valueOf(((i10 >> 18) & 112) | i11));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            oVar5 = oVar8;
            oVar4 = oVar7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                oVar5 = oVar8;
                oVar4 = oVar7;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final o oVar9 = oVar4;
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SliderKt.RangeSliderImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    SliderKt.RangeSliderImpl(modifier, rangeSliderState, z10, mutableInteractionSource, mutableInteractionSource2, oVar, oVar9, oVar5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f6  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(final float r27, final S7.k r28, androidx.compose.ui.Modifier r29, boolean r30, Y7.b r31, @androidx.annotation.IntRange(from = com.stepos.policy.sdk.config.PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int r32, S7.a r33, androidx.compose.material3.SliderColors r34, androidx.compose.foundation.interaction.MutableInteractionSource r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, S7.k, androidx.compose.ui.Modifier, boolean, Y7.b, int, S7.a, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void SliderImpl(final Modifier modifier, final SliderState sliderState, final boolean z10, final MutableInteractionSource mutableInteractionSource, final o oVar, final o oVar2, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1390990089);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(sliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar2) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390990089, i6, -1, "androidx.compose.material3.SliderImpl (Slider.kt:664)");
            }
            sliderState.setRtl$material3_release(composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierSliderTapModifier = sliderTapModifier(companion, sliderState, mutableInteractionSource, z10);
            int i10 = i6;
            Orientation orientation = Orientation.Horizontal;
            boolean zIsRtl$material3_release = sliderState.getIsRtl();
            boolean zIsDragging$material3_release = sliderState.isDragging$material3_release();
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierThen = FocusableKt.focusable(sliderSemantics(SizeKt.m741requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), ThumbWidth, TrackHeight, 0.0f, 0.0f, 12, null), sliderState, z10), z10, mutableInteractionSource).then(modifierSliderTapModifier).then(DraggableKt.draggable$default(companion, sliderState, orientation, z10, mutableInteractionSource, zIsDragging$material3_release, null, (o) objRememberedValue, zIsRtl$material3_release, 32, null));
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        int size = list.size();
                        int i11 = 0;
                        for (int i12 = 0; i12 < size; i12++) {
                            Measurable measurable = list.get(i12);
                            if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                                long j6 = j5;
                                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j6);
                                int size2 = list.size();
                                while (i11 < size2) {
                                    Measurable measurable2 = list.get(i11);
                                    if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                                        final Placeable placeableMo5549measureBRTryo02 = measurable2.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(ConstraintsKt.m6817offsetNN6EwU$default(j6, -placeableMo5549measureBRTryo0.getWidth(), 0, 2, null), 0, 0, 0, 0, 11, null));
                                        int width = placeableMo5549measureBRTryo02.getWidth() + placeableMo5549measureBRTryo0.getWidth();
                                        int iMax = Math.max(placeableMo5549measureBRTryo02.getHeight(), placeableMo5549measureBRTryo0.getHeight());
                                        sliderState.updateDimensions$material3_release(placeableMo5549measureBRTryo02.getHeight(), width);
                                        final int width2 = placeableMo5549measureBRTryo0.getWidth() / 2;
                                        final int iU = U7.a.U(sliderState.getCoercedValueAsFraction$material3_release() * placeableMo5549measureBRTryo02.getWidth());
                                        final int iF = androidx.compose.foundation.b.f(placeableMo5549measureBRTryo02, iMax, 2);
                                        final int iF2 = androidx.compose.foundation.b.f(placeableMo5549measureBRTryo0, iMax, 2);
                                        return MeasureScope.layout$default(measureScope, width, iMax, null, new k() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // S7.k
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return r.f317a;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo02, width2, iF, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, iU, iF2, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                    i11++;
                                    j6 = j5;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            Modifier modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId(companion, SliderComponents.THUMB), null, false, 3, null);
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(sliderState);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new k() { // from class: androidx.compose.material3.SliderKt$SliderImpl$1$1$1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m2277invokeozmzZPI(((IntSize) obj).m7019unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m2277invokeozmzZPI(long j5) {
                        sliderState.setThumbWidth$material3_release(IntSize.m7015getWidthimpl(j5));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierWrapContentWidth$default, (k) objRememberedValue3);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
            S7.a constructor2 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG2 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
            if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
            }
            Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i11 = (i10 >> 3) & 14;
            oVar.invoke(sliderState, composerStartRestartGroup, Integer.valueOf(((i10 >> 9) & 112) | i11));
            composerStartRestartGroup.endNode();
            Modifier modifierLayoutId = LayoutIdKt.layoutId(companion, SliderComponents.TRACK);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            S7.a constructor3 = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl3 = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG3 = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM3474constructorimpl3, currentCompositionLocalMap3);
            if (composerM3474constructorimpl3.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                androidx.appfunctions.metadata.a.z(nVarG3, currentCompositeKeyHash3, composerM3474constructorimpl3, currentCompositeKeyHash3);
            }
            Updater.m3481setimpl(composerM3474constructorimpl3, modifierMaterializeModifier3, companion2.getSetModifier());
            oVar2.invoke(sliderState, composerStartRestartGroup, Integer.valueOf(((i10 >> 12) & 112) | i11));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SliderKt.SliderImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i12) {
                    SliderKt.SliderImpl(modifier, sliderState, z10, mutableInteractionSource, oVar, oVar2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @Stable
    public static final long SliderRange(float f, float f7) {
        if ((Float.isNaN(f) && Float.isNaN(f7)) || f <= f7 + SliderRangeTolerance) {
            return SliderRange.m2281constructorimpl((Float.floatToRawIntBits(f7) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
        }
        throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f7 + ')').toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m2270awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, long r9, int r11, H7.c<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r12) {
        /*
            boolean r0 = r12 instanceof androidx.compose.material3.SliderKt$awaitSlop$1
            if (r0 == 0) goto L14
            r0 = r12
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = (androidx.compose.material3.SliderKt$awaitSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.material3.SliderKt$awaitSlop$1 r0 = new androidx.compose.material3.SliderKt$awaitSlop$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r8 = r6.L$0
            kotlin.jvm.internal.Ref$FloatRef r8 = (kotlin.jvm.internal.Ref$FloatRef) r8
            kotlin.b.b(r12)
            goto L53
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.b.b(r12)
            kotlin.jvm.internal.Ref$FloatRef r12 = new kotlin.jvm.internal.Ref$FloatRef
            r12.<init>()
            androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1 r5 = new androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
            r5.<init>()
            r6.L$0 = r12
            r6.label = r2
            r1 = r8
            r2 = r9
            r4 = r11
            java.lang.Object r8 = androidx.compose.material3.internal.DragGestureDetectorCopyKt.m2670awaitHorizontalPointerSlopOrCancellationgDDlDlE(r1, r2, r4, r5, r6)
            if (r8 != r0) goto L50
            return r0
        L50:
            r7 = r12
            r12 = r8
            r8 = r7
        L53:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 == 0) goto L64
            float r8 = r8.f4917a
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r8)
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r12, r9)
            return r8
        L64:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.m2270awaitSlop8vUncbI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calcFraction(float f, float f7, float f9) {
        float f10 = f7 - f;
        return AbstractC1451a.t(f10 == 0.0f ? 0.0f : (f9 - f) / f10, 0.0f, 1.0f);
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    /* renamed from: isSpecified-If1S1O4, reason: not valid java name */
    public static final boolean m2271isSpecifiedIf1S1O4(long j5) {
        return j5 != SliderRange.INSTANCE.m2290getUnspecifiedFYbKRX4();
    }

    @Stable
    /* renamed from: isSpecified-If1S1O4$annotations, reason: not valid java name */
    public static /* synthetic */ void m2272isSpecifiedIf1S1O4$annotations(long j5) {
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z10) {
        final Y7.a aVar = new Y7.a(rangeSliderState.getActiveRangeStart(), Float.valueOf(((Y7.a) rangeSliderState.getValueRange()).b).floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new k() { // from class: androidx.compose.material3.SliderKt.rangeSliderEndThumbSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z10) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final Y7.b bVar = aVar;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.material3.SliderKt.rangeSliderEndThumbSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int endSteps$material3_release;
                        float fT = AbstractC1451a.t(f, Float.valueOf(((Y7.a) bVar).f1568a).floatValue(), Float.valueOf(((Y7.a) bVar).b).floatValue());
                        boolean z11 = false;
                        if (rangeSliderState2.getEndSteps$material3_release() > 0 && (endSteps$material3_release = rangeSliderState2.getEndSteps$material3_release() + 1) >= 0) {
                            float fAbs = fT;
                            float f7 = fAbs;
                            int i = 0;
                            while (true) {
                                float fLerp = MathHelpersKt.lerp(Float.valueOf(((Y7.a) bVar).f1568a).floatValue(), Float.valueOf(((Y7.a) bVar).b).floatValue(), i / (rangeSliderState2.getEndSteps$material3_release() + 1));
                                float f9 = fLerp - fT;
                                if (Math.abs(f9) <= fAbs) {
                                    fAbs = Math.abs(f9);
                                    f7 = fLerp;
                                }
                                if (i == endSteps$material3_release) {
                                    break;
                                }
                                i++;
                            }
                            fT = f7;
                        }
                        if (fT != rangeSliderState2.getActiveRangeEnd()) {
                            long jSliderRange = SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), fT);
                            if (!SliderRange.m2283equalsimpl0(jSliderRange, SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), rangeSliderState2.getActiveRangeEnd()))) {
                                if (rangeSliderState2.getOnValueChange() != null) {
                                    k onValueChange$material3_release = rangeSliderState2.getOnValueChange();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2280boximpl(jSliderRange));
                                    }
                                } else {
                                    rangeSliderState2.setActiveRangeStart(SliderRange.m2285getStartimpl(jSliderRange));
                                    rangeSliderState2.setActiveRangeEnd(SliderRange.m2284getEndInclusiveimpl(jSliderRange));
                                }
                            }
                            S7.a onValueChangeFinished = rangeSliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z11 = true;
                        }
                        return Boolean.valueOf(z11);
                    }
                }, 1, null);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeEnd(), aVar, rangeSliderState.getEndSteps$material3_release());
    }

    @Stable
    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z10) {
        return z10 ? modifier.then(new SuspendPointerInputElement(null, null, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new C06401(rangeSliderState, mutableInteractionSource, mutableInteractionSource2, null)), 3, null)) : modifier;
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z10) {
        final Y7.a aVar = new Y7.a(Float.valueOf(((Y7.a) rangeSliderState.getValueRange()).f1568a).floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new k() { // from class: androidx.compose.material3.SliderKt.rangeSliderStartThumbSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z10) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final Y7.b bVar = aVar;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.material3.SliderKt.rangeSliderStartThumbSemantics.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int startSteps$material3_release;
                        float fT = AbstractC1451a.t(f, Float.valueOf(((Y7.a) bVar).f1568a).floatValue(), Float.valueOf(((Y7.a) bVar).b).floatValue());
                        boolean z11 = false;
                        if (rangeSliderState2.getStartSteps$material3_release() > 0 && (startSteps$material3_release = rangeSliderState2.getStartSteps$material3_release() + 1) >= 0) {
                            float fAbs = fT;
                            float f7 = fAbs;
                            int i = 0;
                            while (true) {
                                float fLerp = MathHelpersKt.lerp(Float.valueOf(((Y7.a) bVar).f1568a).floatValue(), Float.valueOf(((Y7.a) bVar).b).floatValue(), i / (rangeSliderState2.getStartSteps$material3_release() + 1));
                                float f9 = fLerp - fT;
                                if (Math.abs(f9) <= fAbs) {
                                    fAbs = Math.abs(f9);
                                    f7 = fLerp;
                                }
                                if (i == startSteps$material3_release) {
                                    break;
                                }
                                i++;
                            }
                            fT = f7;
                        }
                        if (fT != rangeSliderState2.getActiveRangeStart()) {
                            long jSliderRange = SliderKt.SliderRange(fT, rangeSliderState2.getActiveRangeEnd());
                            if (!SliderRange.m2283equalsimpl0(jSliderRange, SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), rangeSliderState2.getActiveRangeEnd()))) {
                                if (rangeSliderState2.getOnValueChange() != null) {
                                    k onValueChange$material3_release = rangeSliderState2.getOnValueChange();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2280boximpl(jSliderRange));
                                    }
                                } else {
                                    rangeSliderState2.setActiveRangeStart(SliderRange.m2285getStartimpl(jSliderRange));
                                    rangeSliderState2.setActiveRangeEnd(SliderRange.m2284getEndInclusiveimpl(jSliderRange));
                                }
                            }
                            S7.a onValueChangeFinished = rangeSliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z11 = true;
                        }
                        return Boolean.valueOf(z11);
                    }
                }, 1, null);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), rangeSliderState.getActiveRangeStart(), aVar, rangeSliderState.getStartSteps$material3_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float scale(float f, float f7, float f9, float f10, float f11) {
        return MathHelpersKt.lerp(f10, f11, calcFraction(f, f7, f9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: scale-ziovWd0, reason: not valid java name */
    public static final long m2273scaleziovWd0(float f, float f7, long j5, float f9, float f10) {
        return SliderRange(scale(f, f7, SliderRange.m2285getStartimpl(j5), f9, f10), scale(f, f7, SliderRange.m2284getEndInclusiveimpl(j5), f9, f10));
    }

    private static final Modifier sliderSemantics(Modifier modifier, final SliderState sliderState, final boolean z10) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new k() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return r.f317a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z10) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final SliderState sliderState2 = sliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.material3.SliderKt.sliderSemantics.1.1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int steps;
                        float fT = AbstractC1451a.t(f, Float.valueOf(((Y7.a) sliderState2.getValueRange()).f1568a).floatValue(), Float.valueOf(((Y7.a) sliderState2.getValueRange()).b).floatValue());
                        boolean z11 = false;
                        if (sliderState2.getSteps() > 0 && (steps = sliderState2.getSteps() + 1) >= 0) {
                            float fAbs = fT;
                            float f7 = fAbs;
                            int i = 0;
                            while (true) {
                                float fLerp = MathHelpersKt.lerp(Float.valueOf(((Y7.a) sliderState2.getValueRange()).f1568a).floatValue(), Float.valueOf(((Y7.a) sliderState2.getValueRange()).b).floatValue(), i / (sliderState2.getSteps() + 1));
                                float f9 = fLerp - fT;
                                if (Math.abs(f9) <= fAbs) {
                                    fAbs = Math.abs(f9);
                                    f7 = fLerp;
                                }
                                if (i == steps) {
                                    break;
                                }
                                i++;
                            }
                            fT = f7;
                        }
                        if (fT != sliderState2.getValue()) {
                            if (fT != sliderState2.getValue()) {
                                if (sliderState2.getOnValueChange() != null) {
                                    k onValueChange$material3_release = sliderState2.getOnValueChange();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(Float.valueOf(fT));
                                    }
                                } else {
                                    sliderState2.setValue(fT);
                                }
                            }
                            S7.a onValueChangeFinished = sliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z11 = true;
                        }
                        return Boolean.valueOf(z11);
                    }
                }, 1, null);
            }
        }, 1, null).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), sliderState.getValue(), new Y7.a(Float.valueOf(((Y7.a) sliderState.getValueRange()).f1568a).floatValue(), Float.valueOf(((Y7.a) sliderState.getValueRange()).b).floatValue()), sliderState.getSteps());
    }

    @Stable
    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z10) {
        return z10 ? modifier.then(new SuspendPointerInputElement(sliderState, mutableInteractionSource, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new C06431(sliderState, null)), 4, null)) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float snapValueToTick(float f, float[] fArr, float f7, float f9) {
        Float fValueOf;
        if (fArr.length == 0) {
            fValueOf = null;
        } else {
            float f10 = fArr[0];
            int length = fArr.length - 1;
            if (length == 0) {
                fValueOf = Float.valueOf(f10);
            } else {
                float fAbs = Math.abs(MathHelpersKt.lerp(f7, f9, f10) - f);
                e it = new f(1, length, 1).iterator();
                while (it.c) {
                    float f11 = fArr[it.nextInt()];
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f7, f9, f11) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f10 = f11;
                        fAbs = fAbs2;
                    }
                }
                fValueOf = Float.valueOf(f10);
            }
        }
        return fValueOf != null ? MathHelpersKt.lerp(f7, f9, fValueOf.floatValue()) : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i6 = i + 2;
        float[] fArr = new float[i6];
        for (int i10 = 0; i10 < i6; i10++) {
            fArr[i10] = i10 / (i + 1);
        }
        return fArr;
    }

    @Stable
    public static final long SliderRange(Y7.b bVar) {
        float fFloatValue = Float.valueOf(((Y7.a) bVar).f1568a).floatValue();
        float fFloatValue2 = Float.valueOf(((Y7.a) bVar).b).floatValue();
        if ((Float.isNaN(fFloatValue) && Float.isNaN(fFloatValue2)) || fFloatValue <= fFloatValue2 + SliderRangeTolerance) {
            return SliderRange.m2281constructorimpl((Float.floatToRawIntBits(fFloatValue) << 32) | (Float.floatToRawIntBits(fFloatValue2) & 4294967295L));
        }
        throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + fFloatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + fFloatValue2 + ')').toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(final float r27, final S7.k r28, androidx.compose.ui.Modifier r29, boolean r30, S7.a r31, androidx.compose.material3.SliderColors r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, @androidx.annotation.IntRange(from = com.stepos.policy.sdk.config.PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int r34, S7.o r35, S7.o r36, Y7.b r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(float, S7.k, androidx.compose.ui.Modifier, boolean, S7.a, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, int, S7.o, S7.o, Y7.b, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:241:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0111  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(final Y7.b r30, final S7.k r31, androidx.compose.ui.Modifier r32, boolean r33, Y7.b r34, S7.a r35, androidx.compose.material3.SliderColors r36, androidx.compose.foundation.interaction.MutableInteractionSource r37, androidx.compose.foundation.interaction.MutableInteractionSource r38, S7.o r39, S7.o r40, S7.o r41, @androidx.annotation.IntRange(from = com.stepos.policy.sdk.config.PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int r42, androidx.compose.runtime.Composer r43, final int r44, final int r45, final int r46) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(Y7.b, S7.k, androidx.compose.ui.Modifier, boolean, Y7.b, S7.a, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, S7.o, S7.o, S7.o, int, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0108  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Slider(final androidx.compose.material3.SliderState r17, androidx.compose.ui.Modifier r18, boolean r19, androidx.compose.material3.SliderColors r20, androidx.compose.foundation.interaction.MutableInteractionSource r21, S7.o r22, S7.o r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.Slider(androidx.compose.material3.SliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, S7.o, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fc  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void RangeSlider(final androidx.compose.material3.RangeSliderState r22, androidx.compose.ui.Modifier r23, boolean r24, androidx.compose.material3.SliderColors r25, androidx.compose.foundation.interaction.MutableInteractionSource r26, androidx.compose.foundation.interaction.MutableInteractionSource r27, S7.o r28, S7.o r29, S7.o r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SliderKt.RangeSlider(androidx.compose.material3.RangeSliderState, androidx.compose.ui.Modifier, boolean, androidx.compose.material3.SliderColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.interaction.MutableInteractionSource, S7.o, S7.o, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }
}
