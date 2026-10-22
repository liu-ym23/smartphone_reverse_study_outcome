package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TimePickerSelectionMode;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import ca.AbstractC0897f;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\r\u001a-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a6\u0010\u001f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a?\u0010$\u001a\u00020\b*\u00020 2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a3\u0010%\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020 2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011H\u0001¢\u0006\u0004\b%\u0010&\u001a3\u0010'\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020 2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011H\u0001¢\u0006\u0004\b'\u0010&\u001a'\u0010(\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010*\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010,\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b,\u0010+\u001a\u001f\u0010-\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b-\u0010+\u001a'\u0010.\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b.\u0010/\u001a'\u00100\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b0\u0010/\u001a?\u00106\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0003¢\u0006\u0004\b6\u00107\u001aN\u0010@\u001a\u00020\b2\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u0002032\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\b0:2\u0006\u0010\u0005\u001a\u00020\u00042\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020\b0<¢\u0006\u0002\b>H\u0003¢\u0006\u0004\b@\u0010A\u001a\u0017\u0010B\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\bB\u0010C\u001a:\u0010I\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010F\u001a\u00020E2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\bG\u0010H\u001a'\u0010J\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0011H\u0001¢\u0006\u0004\bJ\u0010K\u001a#\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bL\u0010M\u001a/\u0010N\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020 2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0011H\u0003¢\u0006\u0004\bN\u0010O\u001aN\u0010V\u001a\u00020\b2\u0006\u0010F\u001a\u00020E2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010D\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u000e2\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\b0<H\u0002ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001ab\u0010^\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010D\u001a\u00020P2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\b0<2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010F\u001a\u00020E2\b\b\u0002\u0010Y\u001a\u00020X2\b\b\u0002\u0010[\u001a\u00020Z2\u0006\u0010\u0005\u001a\u00020\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a7\u0010c\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010`\u001a\u00020_2\u0011\u0010?\u001a\r\u0012\u0004\u0012\u00020\b0:¢\u0006\u0002\b>H\u0003ø\u0001\u0000¢\u0006\u0004\ba\u0010b\u001a*\u0010h\u001a\u00020e2\u0006\u0010F\u001a\u00020E2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010d\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010g\u001a/\u0010m\u001a\u00020\u00172\u0006\u0010i\u001a\u00020\u00172\u0006\u0010j\u001a\u00020\u00172\u0006\u0010k\u001a\u00020\u000e2\u0006\u0010l\u001a\u00020\u000eH\u0002¢\u0006\u0004\bm\u0010n\u001a\u001f\u0010o\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bo\u0010p\u001a\u001b\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010q\u001a\u00020\u0011H\u0003¢\u0006\u0004\bq\u0010r\"\u0014\u0010s\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\bs\u0010t\"\u0014\u0010u\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\bu\u0010t\"\u0014\u0010w\u001a\u00020v8\u0002X\u0082T¢\u0006\u0006\n\u0004\bw\u0010x\"\u0014\u0010y\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\by\u0010t\"\u0014\u0010z\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\bz\u0010t\"\u0014\u0010{\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b{\u0010t\"\u0014\u0010|\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010t\"\u0014\u0010}\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010t\"\u0014\u0010~\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010t\"\u0014\u0010\u007f\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010t\"\u0016\u0010\u0080\u0001\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010t\"\u0016\u0010\u0081\u0001\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010t\"\u0016\u0010\u0082\u0001\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010t\"\u0016\u0010\u0083\u0001\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0083\u0001\u0010t\"\u0016\u0010\u0084\u0001\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010t\"\u0018\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0087\u0001\"\u0018\u0010\u0089\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0087\u0001\"\u0016\u0010\u008a\u0001\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010t\"\u001b\u0010\u008d\u0001\u001a\u00020\u000e*\u00020\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u001c\u0010\u0091\u0001\u001a\u00030\u008e\u0001*\u00020 8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0097\u0001²\u0006\r\u0010\u0092\u0001\u001a\u00020\u00118\nX\u008a\u0084\u0002²\u0006\u000f\u0010\u0093\u0001\u001a\u00020P8\n@\nX\u008a\u008e\u0002²\u0006\u000f\u0010\u0094\u0001\u001a\u00020P8\n@\nX\u008a\u008e\u0002²\u0006\u000f\u0010\u001c\u001a\u00030\u0095\u00018\n@\nX\u008a\u008e\u0002²\u0006\u000f\u0010\u0096\u0001\u001a\u00020\u001b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/material3/TimePickerState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/TimePickerColors;", "colors", "Landroidx/compose/material3/TimePickerLayoutType;", "layoutType", "LC7/r;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePicker", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "", "initialHour", "initialMinute", "", "is24Hour", "rememberTimePickerState", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "TimePickerState", "(IIZ)Landroidx/compose/material3/TimePickerState;", "", "x", "y", "maxDist", "Landroidx/compose/ui/unit/IntOffset;", "center", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "moveSelector", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "onTap-rOwcSBo", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLH7/c;)Ljava/lang/Object;", "onTap", "VerticalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "HorizontalTimePicker", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "ClockDisplayNumbers", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalPeriodToggle", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/graphics/Shape;", "startShape", "endShape", "PeriodToggleImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "checked", "shape", "Lkotlin/Function0;", "onClick", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "content", "ToggleItem", "(ZLandroidx/compose/ui/graphics/Shape;LS7/a;Landroidx/compose/material3/TimePickerColors;LS7/o;Landroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "value", "Landroidx/compose/material3/TimePickerSelectionMode;", "selection", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "TimeSelector", "ClockFace", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "drawSelector", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;)Landroidx/compose/ui/Modifier;", "ClockText", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "prevValue", "max", "onNewValue", "timeInputOnChange-z7XvuPQ", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILS7/k;)V", "timeInputOnChange", "onValueChange", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;LS7/k;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimePickerTextField", "Landroidx/compose/ui/unit/Dp;", "radius", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLS7/n;Landroidx/compose/runtime/Composer;II)V", "CircularLayout", "number", "", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "numberContentDescription", "x1", "y1", "x2", "y2", "dist", "(FFII)F", "atan", "(FF)F", "visible", "(Landroidx/compose/ui/Modifier;Z)Landroidx/compose/ui/Modifier;", "FullCircle", "F", "HalfCircle", "", "QuarterCircle", "D", "RadiansPerMinute", "RadiansPerHour", "SeparatorZIndex", "OuterCircleSizeRadius", "InnerCircleRadius", "ClockDisplayBottomMargin", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "SupportLabelTop", "TimeInputBottomPadding", "MaxDistance", "MinimumInteractiveSize", "Landroidx/collection/IntList;", "Minutes", "Landroidx/collection/IntList;", "Hours", "ExtraHours", "PeriodToggleMargin", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "hourForDisplay", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "selectorPos", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt {
    private static final float ClockFaceBottomMargin;
    private static final float DisplaySeparatorWidth;
    private static final IntList ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    private static final IntList Hours;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float TimeInputBottomPadding;
    private static final float OuterCircleSizeRadius = Dp.m6844constructorimpl(101);
    private static final float InnerCircleRadius = Dp.m6844constructorimpl(69);
    private static final float ClockDisplayBottomMargin = Dp.m6844constructorimpl(36);
    private static final float SupportLabelTop = Dp.m6844constructorimpl(7);
    private static final float MaxDistance = Dp.m6844constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m6844constructorimpl(48);
    private static final IntList Minutes = IntListKt.intListOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);

    static {
        float f = 24;
        ClockFaceBottomMargin = Dp.m6844constructorimpl(f);
        DisplaySeparatorWidth = Dp.m6844constructorimpl(f);
        TimeInputBottomPadding = Dp.m6844constructorimpl(f);
        IntList intListIntListOf = IntListKt.intListOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Hours = intListIntListOf;
        MutableIntList mutableIntList = new MutableIntList(intListIntListOf.getSize());
        int[] iArr = intListIntListOf.content;
        int i = intListIntListOf._size;
        for (int i6 = 0; i6 < i; i6++) {
            mutableIntList.add((iArr[i6] % 12) + 12);
        }
        ExtraHours = mutableIntList;
        PeriodToggleMargin = Dp.m6844constructorimpl(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: CircularLayout-uFdPcIQ, reason: not valid java name */
    public static final void m2490CircularLayoutuFdPcIQ(Modifier modifier, final float f, final n nVar, Composer composer, final int i, final int i6) {
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(1548175696);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i10 = i | 6;
        } else if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i6 & 2) != 0) {
            i10 |= 48;
        } else if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i10 |= 384;
        } else if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 256 : 128;
        }
        if ((i10 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i11 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, i10, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1870)");
            }
            boolean z10 = (i10 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, final long j5) {
                        Measurable measurable;
                        Measurable measurable2;
                        final float fMo381toPx0680j_4 = measureScope.mo381toPx0680j_4(f);
                        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
                        ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        int i12 = 0;
                        for (int i13 = 0; i13 < size; i13++) {
                            Measurable measurable3 = list.get(i13);
                            Measurable measurable4 = measurable3;
                            if (LayoutIdKt.getLayoutId(measurable4) != LayoutId.Selector && LayoutIdKt.getLayoutId(measurable4) != LayoutId.InnerCircle) {
                                arrayList.add(measurable3);
                            }
                        }
                        final ArrayList arrayList2 = new ArrayList(arrayList.size());
                        int size2 = arrayList.size();
                        for (int i14 = 0; i14 < size2; i14++) {
                            arrayList2.add(((Measurable) arrayList.get(i14)).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        int size3 = list.size();
                        int i15 = 0;
                        while (true) {
                            if (i15 >= size3) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i15);
                            if (LayoutIdKt.getLayoutId(measurable) == LayoutId.Selector) {
                                break;
                            }
                            i15++;
                        }
                        Measurable measurable5 = measurable;
                        int size4 = list.size();
                        while (true) {
                            if (i12 >= size4) {
                                measurable2 = null;
                                break;
                            }
                            measurable2 = list.get(i12);
                            if (LayoutIdKt.getLayoutId(measurable2) == LayoutId.InnerCircle) {
                                break;
                            }
                            i12++;
                        }
                        Measurable measurable6 = measurable2;
                        final float size5 = 6.2831855f / arrayList2.size();
                        Placeable placeableMo5549measureBRTryo0 = measurable5 != null ? measurable5.mo5549measureBRTryo0(jM6787copyZbe2FdA$default) : null;
                        final Placeable placeableMo5549measureBRTryo02 = measurable6 != null ? measurable6.mo5549measureBRTryo0(jM6787copyZbe2FdA$default) : null;
                        final Placeable placeable = placeableMo5549measureBRTryo0;
                        return MeasureScope.layout$default(measureScope, Constraints.m6799getMinWidthimpl(j5), Constraints.m6798getMinHeightimpl(j5), null, new k() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable placeable2 = placeable;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.place$default(placementScope, placeable2, 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list2 = arrayList2;
                                long j6 = j5;
                                float f7 = fMo381toPx0680j_4;
                                float f9 = size5;
                                int size6 = list2.size();
                                int i16 = 0;
                                while (i16 < size6) {
                                    Placeable placeable3 = list2.get(i16);
                                    double d = f7;
                                    double d6 = (i16 * f9) - 1.5707963267948966d;
                                    Placeable.PlacementScope.place$default(placementScope, placeable3, U7.a.T((Math.cos(d6) * d) + ((Constraints.m6797getMaxWidthimpl(j6) / 2) - (placeable3.getWidth() / 2))), U7.a.T((Math.sin(d6) * d) + ((Constraints.m6796getMaxHeightimpl(j6) / 2) - (placeable3.getHeight() / 2))), 0.0f, 4, null);
                                    i16++;
                                    list2 = list2;
                                    j6 = j6;
                                }
                                Placeable placeable4 = placeableMo5549measureBRTryo02;
                                if (placeable4 != null) {
                                    Placeable.PlacementScope.place$default(placementScope, placeable4, androidx.compose.foundation.b.D(placeableMo5549measureBRTryo02, Constraints.m6799getMinWidthimpl(j5), 2), androidx.compose.foundation.b.f(placeableMo5549measureBRTryo02, Constraints.m6798getMinHeightimpl(j5), 2), 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            int i12 = ((i10 >> 6) & 14) | ((i10 << 3) & 112);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
            int i13 = ((i12 << 6) & 896) | 6;
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            if (androidx.appfunctions.metadata.a.C(nVar, composerStartRestartGroup, (i13 >> 6) & 14)) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i14) {
                    TimePickerKt.m2490CircularLayoutuFdPcIQ(modifier2, f, nVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClockDisplayNumbers(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-934561141);
        if ((i & 6) == 0) {
            i6 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, i6, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1126)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), composerStartRestartGroup, 6)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(-477913269, true, new n() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-477913269, i10, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:1132)");
                    }
                    TimePickerState timePickerState2 = timePickerState;
                    TimePickerColors timePickerColors2 = timePickerColors;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion2.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer2);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
                    Modifier modifierM747sizeVpY3zN4 = SizeKt.m747sizeVpY3zN4(companion, timePickerTokens.m3328getTimeSelectorContainerWidthD9Ej5fM(), timePickerTokens.m3327getTimeSelectorContainerHeightD9Ej5fM());
                    int hourForDisplay = TimePickerKt.getHourForDisplay(timePickerState2);
                    TimePickerSelectionMode.Companion companion3 = TimePickerSelectionMode.INSTANCE;
                    TimePickerKt.m2493TimeSelectorSAnMeKU(modifierM747sizeVpY3zN4, hourForDisplay, timePickerState2, companion3.m2525getHouryecRtBI(), timePickerColors2, composer2, 3078);
                    TimePickerKt.DisplaySeparator(SizeKt.m747sizeVpY3zN4(companion, TimePickerKt.DisplaySeparatorWidth, timePickerTokens.m3324getPeriodSelectorVerticalContainerHeightD9Ej5fM()), composer2, 6);
                    TimePickerKt.m2493TimeSelectorSAnMeKU(SizeKt.m747sizeVpY3zN4(companion, timePickerTokens.m3328getTimeSelectorContainerWidthD9Ej5fM(), timePickerTokens.m3327getTimeSelectorContainerHeightD9Ej5fM()), timePickerState2.getMinute(), timePickerState2, companion3.m2526getMinuteyecRtBI(), timePickerColors2, composer2, 3078);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TimePickerKt.ClockDisplayNumbers(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClockFace(final AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors, final boolean z10, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1170157036);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changedInstance(analogTimePickerState) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(z10) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1170157036, i6, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1512)");
            }
            CrossfadeKt.Crossfade(analogTimePickerState.getClockFaceValues(), drawSelector(SizeKt.m745size3ABfNKs(BackgroundKt.m238backgroundbw27NRU(Modifier.INSTANCE, timePickerColors.getClockDialColor(), RoundedCornerShapeKt.getCircleShape()).then(new ClockDialModifier(analogTimePickerState, z10, analogTimePickerState.mo1501getSelectionyecRtBI(), null)), TimePickerTokens.INSTANCE.m3316getClockDialContainerSizeD9Ej5fM()), analogTimePickerState, timePickerColors), AnimationSpecKt.tween$default(200, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1022006568, true, new o() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((IntList) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(final IntList intList, Composer composer2, int i10) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1022006568, i10, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1522)");
                    }
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SizeKt.m745size3ABfNKs(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3316getClockDialContainerSizeD9Ej5fM()), false, new k() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.1
                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return r.f317a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.selectableGroup(semanticsPropertyReceiver);
                        }
                    }, 1, null);
                    float f = TimePickerKt.OuterCircleSizeRadius;
                    final TimePickerColors timePickerColors2 = timePickerColors;
                    final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                    final boolean z11 = z10;
                    TimePickerKt.m2490CircularLayoutuFdPcIQ(modifierSemantics$default, f, ComposableLambdaKt.rememberComposableLambda(-320307952, true, new n() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // S7.n
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return r.f317a;
                        }

                        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                        @Composable
                        public final void invoke(Composer composer3, int i11) {
                            if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-320307952, i11, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1526)");
                            }
                            ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m4129boximpl(timePickerColors2.m2468clockDialContentColorvNxB06k$material3_release(false)));
                            final IntList intList2 = intList;
                            final AnalogTimePickerState analogTimePickerState3 = analogTimePickerState2;
                            final boolean z12 = z11;
                            CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1992872400, true, new n() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // S7.n
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return r.f317a;
                                }

                                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                @Composable
                                public final void invoke(Composer composer4, int i12) {
                                    if ((i12 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1992872400, i12, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1529)");
                                    }
                                    composer4.startReplaceGroup(1547046870);
                                    int size = intList2.getSize();
                                    AnalogTimePickerState analogTimePickerState4 = analogTimePickerState3;
                                    IntList intList3 = intList2;
                                    boolean z13 = z12;
                                    for (final int i13 = 0; i13 < size; i13++) {
                                        int i14 = (!analogTimePickerState4.getIs24hour() || TimePickerSelectionMode.m2521equalsimpl0(analogTimePickerState4.mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI())) ? intList3.get(i13) : intList3.get(i13) % 12;
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        boolean zChanged = composer4.changed(i13);
                                        Object objRememberedValue = composer4.rememberedValue();
                                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue = new k() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$1$1$1
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
                                                    SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, i13);
                                                }
                                            };
                                            composer4.updateRememberedValue(objRememberedValue);
                                        }
                                        TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (k) objRememberedValue, 1, null), analogTimePickerState4, i14, z13, composer4, 0);
                                    }
                                    composer4.endReplaceGroup();
                                    if (TimePickerSelectionMode.m2521equalsimpl0(analogTimePickerState3.mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI()) && analogTimePickerState3.getIs24hour()) {
                                        Modifier modifierM238backgroundbw27NRU = BackgroundKt.m238backgroundbw27NRU(SizeKt.m745size3ABfNKs(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m3316getClockDialContainerSizeD9Ej5fM()), Color.INSTANCE.m4174getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                        float f7 = TimePickerKt.InnerCircleRadius;
                                        final AnalogTimePickerState analogTimePickerState5 = analogTimePickerState3;
                                        final boolean z14 = z12;
                                        TimePickerKt.m2490CircularLayoutuFdPcIQ(modifierM238backgroundbw27NRU, f7, ComposableLambdaKt.rememberComposableLambda(-205464413, true, new n() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // S7.n
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return r.f317a;
                                            }

                                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                                            @Composable
                                            public final void invoke(Composer composer5, int i15) {
                                                if ((i15 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-205464413, i15, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1552)");
                                                }
                                                int size2 = TimePickerKt.ExtraHours.getSize();
                                                AnalogTimePickerState analogTimePickerState6 = analogTimePickerState5;
                                                boolean z15 = z14;
                                                for (final int i16 = 0; i16 < size2; i16++) {
                                                    int i17 = TimePickerKt.ExtraHours.get(i16);
                                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                                    boolean zChanged2 = composer5.changed(i16);
                                                    Object objRememberedValue2 = composer5.rememberedValue();
                                                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        objRememberedValue2 = new k() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2$1$1$1
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
                                                                SemanticsPropertiesKt.setTraversalIndex(semanticsPropertyReceiver, 12 + i16);
                                                            }
                                                        };
                                                        composer5.updateRememberedValue(objRememberedValue2);
                                                    }
                                                    TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion2, false, (k) objRememberedValue2, 1, null), analogTimePickerState6, i17, z15, composer5, 0);
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer4, 54), composer4, 432, 0);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 432, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TimePickerKt.ClockFace(analogTimePickerState, timePickerColors, z10, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v4 */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void ClockText(final Modifier modifier, final AnalogTimePickerState analogTimePickerState, final int i, final boolean z10, Composer composer, final int i6) {
        int i10;
        Modifier modifier2;
        boolean z11;
        ?? r15;
        Alignment alignment;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-206784607);
        if ((i6 & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i6;
        } else {
            i10 = i6;
        }
        if ((i6 & 48) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(analogTimePickerState) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i10 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i10 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-206784607, i10, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1638)");
            }
            TextStyle value = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), composerStartRestartGroup, 6);
            final float fMo381toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo381toPx0680j_4(MaxDistance);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3884boximpl(Offset.INSTANCE.m3911getZeroF1C5BW0()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6963boximpl(IntOffset.INSTANCE.m6983getZeronOccac()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composerStartRestartGroup), composerStartRestartGroup);
            }
            final InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue3).getCoroutineScope();
            final String strM2501numberContentDescriptiondSwYdS4 = m2501numberContentDescriptiondSwYdS4(analogTimePickerState.mo1501getSelectionyecRtBI(), analogTimePickerState.getIs24hour(), i, composerStartRestartGroup, i10 & 896);
            String localString$default = CalendarLocale_jvmKt.toLocalString$default(i, 0, 0, false, 7, null);
            boolean zB = TimePickerSelectionMode.m2521equalsimpl0(analogTimePickerState.mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI()) ? kotlin.jvm.internal.k.b(CalendarLocale_jvmKt.toLocalString$default(analogTimePickerState.getMinute(), 0, 0, false, 7, null), localString$default) : kotlin.jvm.internal.k.b(CalendarLocale_jvmKt.toLocalString$default(analogTimePickerState.getHour(), 0, 0, false, 7, null), localString$default);
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierM745size3ABfNKs = SizeKt.m745size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), MinimumInteractiveSize);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new k() { // from class: androidx.compose.material3.TimePickerKt$ClockText$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((LayoutCoordinates) obj);
                        return r.f317a;
                    }

                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                        MutableState<IntOffset> mutableState3 = mutableState2;
                        LayoutCoordinates parentCoordinates = layoutCoordinates.getParentCoordinates();
                        TimePickerKt.ClockText$lambda$33(mutableState3, parentCoordinates != null ? IntSizeKt.m7021getCenterozmzZPI(parentCoordinates.mo5557getSizeYbymL2g()) : IntOffset.INSTANCE.m6983getZeronOccac());
                        TimePickerKt.ClockText$lambda$30(mutableState, LayoutCoordinatesKt.boundsInParent(layoutCoordinates).m3925getCenterF1C5BW0());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Modifier modifierFocusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM745size3ABfNKs, (k) objRememberedValue4), false, null, 3, null);
            boolean zChangedInstance = ((i10 & 7168) == 2048) | composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(analogTimePickerState) | composerStartRestartGroup.changed(fMo381toPx0680j_4) | composerStartRestartGroup.changed(zB);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == companion.getEmpty()) {
                modifier2 = modifierFocusable$default;
                final boolean z12 = zB;
                z11 = true;
                r15 = 0;
                alignment = center;
                k kVar = new k() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1
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
                        final InterfaceC1733z interfaceC1733z = coroutineScope;
                        final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                        final float f = fMo381toPx0680j_4;
                        final boolean z13 = z10;
                        final MutableState<Offset> mutableState3 = mutableState;
                        final MutableState<IntOffset> mutableState4 = mutableState2;
                        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new S7.a() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1.1

                            @J7.c(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1", f = "TimePicker.kt", l = {1674}, m = "invokeSuspend")
                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                            /* renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            public static final class C00991 extends SuspendLambda implements n {
                                final /* synthetic */ boolean $autoSwitchToMinute;
                                final /* synthetic */ MutableState<Offset> $center$delegate;
                                final /* synthetic */ float $maxDist;
                                final /* synthetic */ MutableState<IntOffset> $parentCenter$delegate;
                                final /* synthetic */ AnalogTimePickerState $state;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C00991(AnalogTimePickerState analogTimePickerState, float f, boolean z10, MutableState<Offset> mutableState, MutableState<IntOffset> mutableState2, H7.c<? super C00991> cVar) {
                                    super(2, cVar);
                                    this.$state = analogTimePickerState;
                                    this.$maxDist = f;
                                    this.$autoSwitchToMinute = z10;
                                    this.$center$delegate = mutableState;
                                    this.$parentCenter$delegate = mutableState2;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                                    return new C00991(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, this.$parentCenter$delegate, cVar);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                                    int i = this.label;
                                    if (i == 0) {
                                        kotlin.b.b(obj);
                                        AnalogTimePickerState analogTimePickerState = this.$state;
                                        float fM3895getXimpl = Offset.m3895getXimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate));
                                        float fM3896getYimpl = Offset.m3896getYimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate));
                                        float f = this.$maxDist;
                                        boolean z10 = this.$autoSwitchToMinute;
                                        long jClockText$lambda$32 = TimePickerKt.ClockText$lambda$32(this.$parentCenter$delegate);
                                        this.label = 1;
                                        if (TimePickerKt.m2502onTaprOwcSBo(analogTimePickerState, fM3895getXimpl, fM3896getYimpl, f, z10, jClockText$lambda$32, this) == coroutineSingletons) {
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
                                    return ((C00991) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // S7.a
                            public final Boolean invoke() {
                                AbstractC1683A.n(interfaceC1733z, null, new C00991(analogTimePickerState2, f, z13, mutableState3, mutableState4, null), 3);
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z12);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(kVar);
                objRememberedValue5 = kVar;
            } else {
                modifier2 = modifierFocusable$default;
                r15 = 0;
                alignment = center;
                z11 = true;
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier2, z11, (k) objRememberedValue5);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(alignment, r15);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, r15);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics);
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            boolean zChanged = composerStartRestartGroup.changed(strM2501numberContentDescriptiondSwYdS4);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new k() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1$1
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
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM2501numberContentDescriptiondSwYdS4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            composer2 = composerStartRestartGroup;
            TextKt.m2464Text4IGK_g(localString$default, SemanticsModifierKt.clearAndSetSemantics(companion3, (k) objRememberedValue6), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, value, composer2, 0, 0, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.ClockText.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i11) {
                    TimePickerKt.ClockText(modifier, analogTimePickerState, i, z10, composer3, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$29(MutableState<Offset> mutableState) {
        return mutableState.getValue().m3905unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$30(MutableState<Offset> mutableState, long j5) {
        mutableState.setValue(Offset.m3884boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$32(MutableState<IntOffset> mutableState) {
        return mutableState.getValue().m6981unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$33(MutableState<IntOffset> mutableState, long j5) {
        mutableState.setValue(IntOffset.m6963boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void DisplaySeparator(final Modifier modifier, Composer composer, final int i) {
        int i6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2100674302);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, i6, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1324)");
            }
            TextStyle textStyleM6324copyp1EtxEg$default = TextStyle.m6324copyp1EtxEg$default((TextStyle) composerStartRestartGroup.consume(TextKt.getLocalTextStyle()), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6728getCentere0LSkKk(), 0, 0L, null, null, new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m6696getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m6717getBothEVpEnUU(), (e) null), 0, 0, null, 15695871, null);
            Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(modifier, new k() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.1
                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return r.f317a;
                }
            });
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClearAndSetSemantics);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            S7.a constructor = companion.getConstructor();
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composer2 = composerStartRestartGroup;
            TextKt.m2464Text4IGK_g(":", (Modifier) null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), composerStartRestartGroup, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, textStyleM6324copyp1EtxEg$default, composer2, 6, 0, 65530);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i10) {
                    TimePickerKt.DisplaySeparator(modifier, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(755539561);
        if ((i & 6) == 0) {
            i6 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(755539561, i6, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1086)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, companion2.getStart(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicyColumnMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i6 & 126);
            composerStartRestartGroup.startReplaceGroup(919638492);
            if (!timePickerState.getIs24hour()) {
                Modifier modifierM704paddingqDBjuR0$default = PaddingKt.m704paddingqDBjuR0$default(companion, 0.0f, PeriodToggleMargin, 0.0f, 0.0f, 13, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default);
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
                TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
                int i10 = i6 << 3;
                HorizontalPeriodToggle(SizeKt.m747sizeVpY3zN4(companion, timePickerTokens.m3322getPeriodSelectorHorizontalContainerWidthD9Ej5fM(), timePickerTokens.m3321getPeriodSelectorHorizontalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i10 & 896) | (i10 & 112) | 6);
                composerStartRestartGroup.endNode();
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.HorizontalClockDisplay.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i11) {
                    TimePickerKt.HorizontalClockDisplay(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i) {
        int i6;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1261215927);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, i6, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1159)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Measurable measurable = list.get(i10);
                            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j5, 0, measureScope.mo375roundToPx0680j_4(TimePickerTokens.INSTANCE.m3323getPeriodSelectorOutlineWidthD9Ej5fM()), 0, 0, 12, null));
                                ArrayList arrayList = new ArrayList(list.size());
                                int size2 = list.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    Measurable measurable2 = list.get(i11);
                                    if (!kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable2), "Spacer")) {
                                        arrayList.add(measurable2);
                                    }
                                }
                                final ArrayList arrayList2 = new ArrayList(arrayList.size());
                                int size3 = arrayList.size();
                                for (int i12 = 0; i12 < size3; i12++) {
                                    arrayList2.add(((Measurable) arrayList.get(i12)).mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j5, 0, Constraints.m6797getMaxWidthimpl(j5) / 2, 0, 0, 12, null)));
                                }
                                return MeasureScope.layout$default(measureScope, Constraints.m6797getMaxWidthimpl(j5), Constraints.m6796getMaxHeightimpl(j5), null, new k() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope.place$default(placementScope, arrayList2.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(placementScope, arrayList2.get(1), arrayList2.get(0).getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, arrayList2.get(0).getWidth() - (placeableMo5549measureBRTryo0.getWidth() / 2), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            kotlin.jvm.internal.k.d(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.start(cornerBasedShape), ShapesKt.end(cornerBasedShape), composerStartRestartGroup, (i6 & 14) | 3072 | (i6 & 112) | (i6 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.HorizontalPeriodToggle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TimePickerKt.HorizontalPeriodToggle(modifier2, timePickerState2, timePickerColors2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void HorizontalTimePicker(final androidx.compose.material3.AnalogTimePickerState r18, androidx.compose.ui.Modifier r19, androidx.compose.material3.TimePickerColors r20, final boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void PeriodToggleImpl(final Modifier modifier, final TimePickerState timePickerState, final TimePickerColors timePickerColors, final MeasurePolicy measurePolicy, final Shape shape, final Shape shape2, Composer composer, final int i) {
        int i6;
        Shape shape3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1374241901);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(measurePolicy) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            shape3 = shape2;
            i6 |= composerStartRestartGroup.changed(shape3) ? 131072 : 65536;
        } else {
            shape3 = shape2;
        }
        if ((74899 & i6) == 74898 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1374241901, i6, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1254)");
            }
            TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
            BorderStroke borderStrokeM268BorderStrokecXLIe8U = BorderStrokeKt.m268BorderStrokecXLIe8U(timePickerTokens.m3323getPeriodSelectorOutlineWidthD9Ej5fM(), timePickerColors.getPeriodSelectorBorderColor());
            Shape value = ShapesKt.getValue(timePickerTokens.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            kotlin.jvm.internal.k.d(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            Strings.Companion companion = Strings.INSTANCE;
            final String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_time_picker_period_toggle_description), composerStartRestartGroup, 0);
            boolean zChanged = composerStartRestartGroup.changed(strM2752getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$1$1
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
                        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM2752getString2EP1pXo);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierBorder = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(modifier, false, (k) objRememberedValue, 1, null)), borderStrokeM268BorderStrokecXLIe8U, cornerBasedShape);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBorder);
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
            boolean z10 = !timePickerState.isAfternoon();
            int i10 = i6 & 112;
            boolean z11 = i10 == 32 || ((i6 & 64) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$1$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2504invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2504invoke() {
                        timePickerState.setAfternoon(false);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposableSingletons$TimePickerKt composableSingletons$TimePickerKt = ComposableSingletons$TimePickerKt.INSTANCE;
            int i11 = (i6 << 3) & 7168;
            int i12 = i6;
            ToggleItem(z10, shape, (S7.a) objRememberedValue2, timePickerColors, composableSingletons$TimePickerKt.m1735getLambda1$material3_release(), composerStartRestartGroup, ((i6 >> 9) & 112) | 24576 | i11);
            SpacerKt.Spacer(BackgroundKt.m239backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.INSTANCE, "Spacer"), SeparatorZIndex), 0.0f, 1, null), timePickerColors.getPeriodSelectorBorderColor(), null, 2, null), composerStartRestartGroup, 0);
            boolean z12 = false;
            boolean zIsAfternoon = timePickerState.isAfternoon();
            if (i10 == 32 || ((i12 & 64) != 0 && composerStartRestartGroup.changedInstance(timePickerState))) {
                z12 = true;
            }
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z12 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new S7.a() { // from class: androidx.compose.material3.TimePickerKt$PeriodToggleImpl$2$2$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2505invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2505invoke() {
                        timePickerState.setAfternoon(true);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ToggleItem(zIsAfternoon, shape3, (S7.a) objRememberedValue3, timePickerColors, composableSingletons$TimePickerKt.m1736getLambda2$material3_release(), composerStartRestartGroup, ((i12 >> 12) & 112) | 24576 | i11);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.PeriodToggleImpl.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i13) {
                    TimePickerKt.PeriodToggleImpl(modifier, timePickerState, timePickerColors, measurePolicy, shape, shape2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TimeInput(final androidx.compose.material3.TimePickerState r7, androidx.compose.ui.Modifier r8, androidx.compose.material3.TimePickerColors r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            r0 = -760850373(0xffffffffd2a6583b, float:-3.5722242E11)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            r1 = r12 & 1
            if (r1 == 0) goto Le
            r1 = r11 | 6
            goto L27
        Le:
            r1 = r11 & 6
            if (r1 != 0) goto L26
            r1 = r11 & 8
            if (r1 != 0) goto L1b
            boolean r1 = r10.changed(r7)
            goto L1f
        L1b:
            boolean r1 = r10.changedInstance(r7)
        L1f:
            if (r1 == 0) goto L23
            r1 = 4
            goto L24
        L23:
            r1 = 2
        L24:
            r1 = r1 | r11
            goto L27
        L26:
            r1 = r11
        L27:
            r2 = r12 & 2
            if (r2 == 0) goto L2e
            r1 = r1 | 48
            goto L3e
        L2e:
            r3 = r11 & 48
            if (r3 != 0) goto L3e
            boolean r3 = r10.changed(r8)
            if (r3 == 0) goto L3b
            r3 = 32
            goto L3d
        L3b:
            r3 = 16
        L3d:
            r1 = r1 | r3
        L3e:
            r3 = r11 & 384(0x180, float:5.38E-43)
            if (r3 != 0) goto L52
            r3 = r12 & 4
            if (r3 != 0) goto L4f
            boolean r3 = r10.changed(r9)
            if (r3 == 0) goto L4f
            r3 = 256(0x100, float:3.59E-43)
            goto L51
        L4f:
            r3 = 128(0x80, float:1.8E-43)
        L51:
            r1 = r1 | r3
        L52:
            r3 = r1 & 147(0x93, float:2.06E-43)
            r4 = 146(0x92, float:2.05E-43)
            if (r3 != r4) goto L65
            boolean r3 = r10.getSkipping()
            if (r3 != 0) goto L5f
            goto L65
        L5f:
            r10.skipToGroupEnd()
        L62:
            r3 = r8
            r4 = r9
            goto Lb1
        L65:
            r10.startDefaults()
            r3 = r11 & 1
            r4 = 6
            if (r3 == 0) goto L7e
            boolean r3 = r10.getDefaultsInvalid()
            if (r3 == 0) goto L74
            goto L7e
        L74:
            r10.skipToGroupEnd()
            r2 = r12 & 4
            if (r2 == 0) goto L8d
        L7b:
            r1 = r1 & (-897(0xfffffffffffffc7f, float:NaN))
            goto L8d
        L7e:
            if (r2 == 0) goto L82
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.INSTANCE
        L82:
            r2 = r12 & 4
            if (r2 == 0) goto L8d
            androidx.compose.material3.TimePickerDefaults r9 = androidx.compose.material3.TimePickerDefaults.INSTANCE
            androidx.compose.material3.TimePickerColors r9 = r9.colors(r10, r4)
            goto L7b
        L8d:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L9c
            r2 = -1
            java.lang.String r3 = "androidx.compose.material3.TimeInput (TimePicker.kt:260)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L9c:
            int r0 = r1 >> 3
            r0 = r0 & 126(0x7e, float:1.77E-43)
            int r1 = r1 << r4
            r1 = r1 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            TimeInputImpl(r8, r9, r7, r10, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L62
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L62
        Lb1:
            androidx.compose.runtime.ScopeUpdateScope r8 = r10.endRestartGroup()
            if (r8 == 0) goto Lc2
            androidx.compose.material3.TimePickerKt$TimeInput$1 r1 = new androidx.compose.material3.TimePickerKt$TimeInput$1
            r2 = r7
            r5 = r11
            r6 = r12
            r1.<init>()
            r8.updateScope(r1)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TimeInputImpl(final Modifier modifier, final TimePickerColors timePickerColors, final TimePickerState timePickerState, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-475657989);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= (i & 512) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, i6, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:963)");
            }
            Object[] objArr = new Object[0];
            TextFieldValue.Companion companion = TextFieldValue.INSTANCE;
            Saver<TextFieldValue, Object> saver = companion.getSaver();
            int i10 = i6 & 896;
            boolean z10 = i10 == 256 || ((i6 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new S7.a() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(TimePickerKt.getHourForDisplay(timePickerState), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (e) null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableStateRememberSaveable = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (S7.a) objRememberedValue, composerStartRestartGroup, 0, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = companion.getSaver();
            boolean z11 = i10 == 256 || ((i6 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState));
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(timePickerState.getMinute(), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (e) null), null, 2, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableStateRememberSaveable2 = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (String) null, (S7.a) objRememberedValue2, composerStartRestartGroup, 0, 4);
            int i11 = i6;
            Modifier modifierM704paddingqDBjuR0$default = PaddingKt.m704paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), companion2.getTop(), composerStartRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default);
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TimeInputTokens timeInputTokens = TimeInputTokens.INSTANCE;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TextStyle.m6324copyp1EtxEg$default(TypographyKt.getValue(timeInputTokens.getTimeFieldLabelTextFont(), composerStartRestartGroup, 6), timePickerColors.m2487timeSelectorContentColorvNxB06k$material3_release(true), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6728getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new n() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i12) {
                    if ((i12 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1306700887, i12, -1, "androidx.compose.material3.TimeInputImpl.<anonymous>.<anonymous> (TimePicker.kt:987)");
                    }
                    final MutableState<TextFieldValue> mutableState = mutableStateRememberSaveable;
                    final TimePickerState timePickerState2 = timePickerState;
                    TimePickerColors timePickerColors2 = timePickerColors;
                    final MutableState<TextFieldValue> mutableState2 = mutableStateRememberSaveable2;
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion4);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    S7.a constructor2 = companion5.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composer2);
                    n nVarG2 = androidx.appfunctions.metadata.a.g(companion5, composerM3474constructorimpl2, measurePolicyRowMeasurePolicy2, composerM3474constructorimpl2, currentCompositionLocalMap2);
                    if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                    boolean zChanged = composer2.changed(mutableState) | composer2.changedInstance(timePickerState2);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return m2506invokeZmokQxo(((KeyEvent) obj).m5264unboximpl());
                            }

                            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m2506invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                int iM5277getUtf16CodePointZmokQxo = KeyEvent_androidKt.m5277getUtf16CodePointZmokQxo(keyEvent);
                                if (48 <= iM5277getUtf16CodePointZmokQxo && iM5277getUtf16CodePointZmokQxo < 58 && TextRange.m6311getStartimpl(TimePickerKt.TimeInputImpl$lambda$6(mutableState).getSelection()) == 2 && TimePickerKt.TimeInputImpl$lambda$6(mutableState).getText().length() == 2) {
                                    timePickerState2.mo1502setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI());
                                }
                                return Boolean.FALSE;
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(companion4, (k) objRememberedValue3);
                    TextFieldValue textFieldValueTimeInputImpl$lambda$6 = TimePickerKt.TimeInputImpl$lambda$6(mutableState);
                    boolean zChangedInstance = composer2.changedInstance(timePickerState2) | composer2.changed(mutableState);
                    Object objRememberedValue4 = composer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((TextFieldValue) obj);
                                return r.f317a;
                            }

                            public final void invoke(TextFieldValue textFieldValue) {
                                int iM2525getHouryecRtBI = TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI();
                                TimePickerState timePickerState3 = timePickerState2;
                                TextFieldValue textFieldValueTimeInputImpl$lambda$62 = TimePickerKt.TimeInputImpl$lambda$6(mutableState);
                                int i13 = timePickerState2.getIs24hour() ? 23 : 12;
                                final MutableState<TextFieldValue> mutableState3 = mutableState;
                                TimePickerKt.m2503timeInputOnChangez7XvuPQ(iM2525getHouryecRtBI, timePickerState3, textFieldValue, textFieldValueTimeInputImpl$lambda$62, i13, new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((TextFieldValue) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(TextFieldValue textFieldValue2) {
                                        mutableState3.setValue(textFieldValue2);
                                    }
                                });
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue4);
                    }
                    k kVar = (k) objRememberedValue4;
                    TimePickerSelectionMode.Companion companion6 = TimePickerSelectionMode.INSTANCE;
                    int iM2525getHouryecRtBI = companion6.m2525getHouryecRtBI();
                    ImeAction.Companion companion7 = ImeAction.INSTANCE;
                    int iM6493getNexteUduSuo = companion7.m6493getNexteUduSuo();
                    KeyboardType.Companion companion8 = KeyboardType.INSTANCE;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, companion8.m6547getNumberPjHm6EE(), iM6493getNexteUduSuo, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (e) null);
                    boolean zChangedInstance2 = composer2.changedInstance(timePickerState2);
                    Object objRememberedValue5 = composer2.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$3$1
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyboardActionScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(KeyboardActionScope keyboardActionScope) {
                                timePickerState2.mo1502setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue5);
                    }
                    TimePickerKt.m2492TimePickerTextField1vLObsk(modifierOnKeyEvent, textFieldValueTimeInputImpl$lambda$6, kVar, timePickerState2, iM2525getHouryecRtBI, keyboardOptions, new KeyboardActions(null, null, (k) objRememberedValue5, null, null, null, 59, null), timePickerColors2, composer2, 24576, 0);
                    TimePickerKt.DisplaySeparator(SizeKt.m747sizeVpY3zN4(companion4, TimePickerKt.DisplaySeparatorWidth, TimeInputTokens.INSTANCE.m3310getPeriodSelectorContainerHeightD9Ej5fM()), composer2, 6);
                    boolean zChanged2 = composer2.changed(mutableState2) | composer2.changedInstance(timePickerState2);
                    Object objRememberedValue6 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue6 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return m2507invokeZmokQxo(((KeyEvent) obj).m5264unboximpl());
                            }

                            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m2507invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                boolean z12 = KeyEvent_androidKt.m5277getUtf16CodePointZmokQxo(keyEvent) == 0 && TextRange.m6311getStartimpl(TimePickerKt.TimeInputImpl$lambda$9(mutableState2).getSelection()) == 0;
                                if (z12) {
                                    timePickerState2.mo1502setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI());
                                }
                                return Boolean.valueOf(z12);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    Modifier modifierOnPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(companion4, (k) objRememberedValue6);
                    TextFieldValue textFieldValueTimeInputImpl$lambda$9 = TimePickerKt.TimeInputImpl$lambda$9(mutableState2);
                    boolean zChangedInstance3 = composer2.changedInstance(timePickerState2) | composer2.changed(mutableState2);
                    Object objRememberedValue7 = composer2.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((TextFieldValue) obj);
                                return r.f317a;
                            }

                            public final void invoke(TextFieldValue textFieldValue) {
                                int iM2526getMinuteyecRtBI = TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI();
                                TimePickerState timePickerState3 = timePickerState2;
                                TextFieldValue textFieldValueTimeInputImpl$lambda$92 = TimePickerKt.TimeInputImpl$lambda$9(mutableState2);
                                final MutableState<TextFieldValue> mutableState3 = mutableState2;
                                TimePickerKt.m2503timeInputOnChangez7XvuPQ(iM2526getMinuteyecRtBI, timePickerState3, textFieldValue, textFieldValueTimeInputImpl$lambda$92, 59, new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$5$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((TextFieldValue) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(TextFieldValue textFieldValue2) {
                                        mutableState3.setValue(textFieldValue2);
                                    }
                                });
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue7);
                    }
                    k kVar2 = (k) objRememberedValue7;
                    int iM2526getMinuteyecRtBI = companion6.m2526getMinuteyecRtBI();
                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, companion8.m6547getNumberPjHm6EE(), companion7.m6491getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (e) null);
                    boolean zChangedInstance4 = composer2.changedInstance(timePickerState2);
                    Object objRememberedValue8 = composer2.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue8 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1$1$6$1
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyboardActionScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(KeyboardActionScope keyboardActionScope) {
                                timePickerState2.mo1502setSelection6_8s6DQ(TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue8);
                    }
                    TimePickerKt.m2492TimePickerTextField1vLObsk(modifierOnPreviewKeyEvent, textFieldValueTimeInputImpl$lambda$9, kVar2, timePickerState2, iM2526getMinuteyecRtBI, keyboardOptions2, new KeyboardActions(null, null, (k) objRememberedValue8, null, null, null, 59, null), timePickerColors2, composer2, 24576, 0);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            composerStartRestartGroup.startReplaceGroup(511443242);
            if (!timePickerState.getIs24hour()) {
                Modifier.Companion companion4 = Modifier.INSTANCE;
                Modifier modifierM704paddingqDBjuR0$default2 = PaddingKt.m704paddingqDBjuR0$default(companion4, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default2);
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
                VerticalPeriodToggle(SizeKt.m747sizeVpY3zN4(companion4, timeInputTokens.m3311getPeriodSelectorContainerWidthD9Ej5fM(), timeInputTokens.m3310getPeriodSelectorContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, ((i11 >> 3) & 112) | 6 | ((i11 << 3) & 896));
                composerStartRestartGroup.endNode();
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.TimeInputImpl.2
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
                    TimePickerKt.TimeInputImpl(modifier, timePickerColors, timePickerState, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$6(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$9(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0141  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    /* renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2491TimePickermT9BvqQ(final androidx.compose.material3.TimePickerState r13, androidx.compose.ui.Modifier r14, androidx.compose.material3.TimePickerColors r15, int r16, androidx.compose.runtime.Composer r17, final int r18, final int r19) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2491TimePickermT9BvqQ(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, int, androidx.compose.runtime.Composer, int, int):void");
    }

    @ExperimentalMaterial3Api
    public static final TimePickerState TimePickerState(int i, int i6, boolean z10) {
        return new TimePickerStateImpl(i, i6, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0119  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: TimePickerTextField-1vLObsk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2492TimePickerTextField1vLObsk(final androidx.compose.ui.Modifier r112, final androidx.compose.ui.text.input.TextFieldValue r113, final S7.k r114, androidx.compose.material3.TimePickerState r115, final int r116, androidx.compose.foundation.text.KeyboardOptions r117, androidx.compose.foundation.text.KeyboardActions r118, final androidx.compose.material3.TimePickerColors r119, androidx.compose.runtime.Composer r120, final int r121, final int r122) {
        /*
            Method dump skipped, instructions count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2492TimePickerTextField1vLObsk(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, S7.k, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* renamed from: TimeSelector-SAnMeKU, reason: not valid java name */
    public static final void m2493TimeSelectorSAnMeKU(final Modifier modifier, final int i, final TimePickerState timePickerState, final int i6, final TimePickerColors timePickerColors, Composer composer, final int i10) {
        int i11;
        int iM2682constructorimpl;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1148055889);
        if ((i10 & 6) == 0) {
            i11 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 48) == 0) {
            i11 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i10 & 384) == 0) {
            i11 |= (i10 & 512) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 256 : 128;
        }
        if ((i10 & 3072) == 0) {
            i11 |= composerStartRestartGroup.changed(i6) ? 2048 : 1024;
        }
        if ((i10 & 24576) == 0) {
            i11 |= composerStartRestartGroup.changed(timePickerColors) ? 16384 : 8192;
        }
        if ((i11 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1148055889, i11, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1348)");
            }
            boolean zM2521equalsimpl0 = TimePickerSelectionMode.m2521equalsimpl0(timePickerState.mo1501getSelectionyecRtBI(), i6);
            if (TimePickerSelectionMode.m2521equalsimpl0(i6, TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI())) {
                Strings.Companion companion = Strings.INSTANCE;
                iM2682constructorimpl = Strings.m2682constructorimpl(R.string.m3c_time_picker_hour_selection);
            } else {
                Strings.Companion companion2 = Strings.INSTANCE;
                iM2682constructorimpl = Strings.m2682constructorimpl(R.string.m3c_time_picker_minute_selection);
            }
            final String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(iM2682constructorimpl, composerStartRestartGroup, 0);
            long jM2486timeSelectorContainerColorvNxB06k$material3_release = timePickerColors.m2486timeSelectorContainerColorvNxB06k$material3_release(zM2521equalsimpl0);
            final long jM2487timeSelectorContentColorvNxB06k$material3_release = timePickerColors.m2487timeSelectorContentColorvNxB06k$material3_release(zM2521equalsimpl0);
            boolean zChanged = composerStartRestartGroup.changed(strM2752getString2EP1pXo);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$1$1
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
                        SemanticsPropertiesKt.m6100setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m6086getRadioButtono7Vup1c());
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM2752getString2EP1pXo);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (k) objRememberedValue);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), composerStartRestartGroup, 6);
            boolean z10 = ((i11 & 896) == 256 || ((i11 & 512) != 0 && composerStartRestartGroup.changedInstance(timePickerState))) | ((i11 & 7168) == 2048);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new S7.a() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2508invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2508invoke() {
                        if (TimePickerSelectionMode.m2521equalsimpl0(i6, timePickerState.mo1501getSelectionyecRtBI())) {
                            return;
                        }
                        timePickerState.mo1502setSelection6_8s6DQ(i6);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2315Surfaced85dljk(zM2521equalsimpl0, (S7.a) objRememberedValue2, modifierSemantics, false, value, jM2486timeSelectorContainerColorvNxB06k$material3_release, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (n) ComposableLambdaKt.rememberComposableLambda(-1477282471, true, new n() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer3, int i12) {
                    if ((i12 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1477282471, i12, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1376)");
                    }
                    final String strM2501numberContentDescriptiondSwYdS4 = TimePickerKt.m2501numberContentDescriptiondSwYdS4(i6, timePickerState.getIs24hour(), i, composer3, 0);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    int i13 = i;
                    long j5 = jM2487timeSelectorContentColorvNxB06k$material3_release;
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, companion3);
                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion4.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer3);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion4, composerM3474constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion4.getSetModifier());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    boolean zChanged2 = composer3.changed(strM2501numberContentDescriptiondSwYdS4);
                    Object objRememberedValue3 = composer3.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new k() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM2501numberContentDescriptiondSwYdS4);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    TextKt.m2464Text4IGK_g(CalendarLocale_jvmKt.toLocalString$default(i13, 2, 0, false, 6, null), SemanticsModifierKt.semantics$default(companion3, false, (k) objRememberedValue3, 1, null), j5, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (k) null, (TextStyle) null, composer3, 0, 0, 131064);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, 0, 48, 1992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i12) {
                    TimePickerKt.m2493TimeSelectorSAnMeKU(modifier, i, timePickerState, i6, timePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i10 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void ToggleItem(final boolean z10, final Shape shape, final S7.a aVar, final TimePickerColors timePickerColors, final o oVar, Composer composer, final int i) {
        int i6;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1937408098);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(z10) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(shape) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, i6, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1304)");
            }
            long jM2485periodSelectorContentColorvNxB06k$material3_release = timePickerColors.m2485periodSelectorContentColorvNxB06k$material3_release(z10);
            long jM2484periodSelectorContainerColorvNxB06k$material3_release = timePickerColors.m2484periodSelectorContainerColorvNxB06k$material3_release(z10);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, z10 ? 0.0f : 1.0f), 0.0f, 1, null);
            boolean z11 = (i6 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new k() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$1$1
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
                        SemanticsPropertiesKt.setSelected(semanticsPropertyReceiver, z10);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ButtonKt.TextButton(aVar, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (k) objRememberedValue, 1, null), false, shape, ButtonDefaults.INSTANCE.m1563textButtonColorsro_MJ88(jM2484periodSelectorContainerColorvNxB06k$material3_release, jM2485periodSelectorContentColorvNxB06k$material3_release, 0L, 0L, composerStartRestartGroup, 24576, 12), null, null, PaddingKt.m693PaddingValues0680j_4(Dp.m6844constructorimpl(0)), null, oVar, composerStartRestartGroup, ((i6 >> 6) & 14) | 12582912 | ((i6 << 6) & 7168) | ((i6 << 15) & 1879048192), 356);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.ToggleItem.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i10) {
                    TimePickerKt.ToggleItem(z10, shape, aVar, timePickerColors, oVar, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerticalClockDisplay(final TimePickerState timePickerState, final TimePickerColors timePickerColors, Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(2054675515);
        if ((i & 6) == 0) {
            i6 = ((i & 8) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054675515, i6, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1106)");
            }
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, companion2.getTop(), composerStartRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            n nVarG = androidx.appfunctions.metadata.a.g(companion3, composerM3474constructorimpl, measurePolicyRowMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ClockDisplayNumbers(timePickerState, timePickerColors, composerStartRestartGroup, i6 & 126);
            composerStartRestartGroup.startReplaceGroup(-709485014);
            if (!timePickerState.getIs24hour()) {
                Modifier modifierM704paddingqDBjuR0$default = PaddingKt.m704paddingqDBjuR0$default(companion, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM704paddingqDBjuR0$default);
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
                TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
                int i10 = i6 << 3;
                VerticalPeriodToggle(SizeKt.m747sizeVpY3zN4(companion, timePickerTokens.m3325getPeriodSelectorVerticalContainerWidthD9Ej5fM(), timePickerTokens.m3324getPeriodSelectorVerticalContainerHeightD9Ej5fM()), timePickerState, timePickerColors, composerStartRestartGroup, (i10 & 896) | (i10 & 112) | 6);
                composerStartRestartGroup.endNode();
            }
            if (androidx.appfunctions.metadata.a.D(composerStartRestartGroup)) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.VerticalClockDisplay.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i11) {
                    TimePickerKt.VerticalClockDisplay(timePickerState, timePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, Composer composer, final int i) {
        int i6;
        final Modifier modifier2;
        final TimePickerState timePickerState2;
        final TimePickerColors timePickerColors2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1898918107);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= (i & 64) == 0 ? composerStartRestartGroup.changed(timePickerState) : composerStartRestartGroup.changedInstance(timePickerState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i6 |= composerStartRestartGroup.changed(timePickerColors) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, i6, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1205)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Measurable measurable = list.get(i10);
                            if (kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable), "Spacer")) {
                                final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, measureScope.mo375roundToPx0680j_4(TimePickerTokens.INSTANCE.m3323getPeriodSelectorOutlineWidthD9Ej5fM()), 3, null));
                                ArrayList arrayList = new ArrayList(list.size());
                                int size2 = list.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    Measurable measurable2 = list.get(i11);
                                    if (!kotlin.jvm.internal.k.b(LayoutIdKt.getLayoutId(measurable2), "Spacer")) {
                                        arrayList.add(measurable2);
                                    }
                                }
                                final ArrayList arrayList2 = new ArrayList(arrayList.size());
                                int size3 = arrayList.size();
                                for (int i12 = 0; i12 < size3; i12++) {
                                    arrayList2.add(((Measurable) arrayList.get(i12)).mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, Constraints.m6796getMaxHeightimpl(j5) / 2, 3, null)));
                                }
                                return MeasureScope.layout$default(measureScope, Constraints.m6797getMaxWidthimpl(j5), Constraints.m6796getMaxHeightimpl(j5), null, new k() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // S7.k
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return r.f317a;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope.place$default(placementScope, arrayList2.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(placementScope, arrayList2.get(1), 0, arrayList2.get(0).getHeight(), 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, 0, arrayList2.get(0).getHeight() - (placeableMo5549measureBRTryo0.getHeight() / 2), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), composerStartRestartGroup, 6);
            kotlin.jvm.internal.k.d(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
            modifier2 = modifier;
            timePickerState2 = timePickerState;
            timePickerColors2 = timePickerColors;
            PeriodToggleImpl(modifier2, timePickerState2, timePickerColors2, measurePolicy, ShapesKt.top(cornerBasedShape), ShapesKt.bottom(cornerBasedShape), composerStartRestartGroup, (i6 & 14) | 3072 | (i6 & 112) | (i6 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.TimePickerKt.VerticalPeriodToggle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    TimePickerKt.VerticalPeriodToggle(modifier2, timePickerState2, timePickerColors2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0146  */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void VerticalTimePicker(final androidx.compose.material3.AnalogTimePickerState r9, androidx.compose.ui.Modifier r10, androidx.compose.material3.TimePickerColors r11, final boolean r12, androidx.compose.runtime.Composer r13, final int r14, final int r15) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float f, float f7) {
        float fAtan2 = ((float) Math.atan2(f, f7)) - 1.5707964f;
        return fAtan2 < 0.0f ? fAtan2 + FullCircle : fAtan2;
    }

    private static final float dist(float f, float f7, int i, int i6) {
        return (float) Math.hypot(i - f, i6 - f7);
    }

    private static final Modifier drawSelector(Modifier modifier, final AnalogTimePickerState analogTimePickerState, final TimePickerColors timePickerColors) {
        return DrawModifierKt.drawWithContent(modifier, new k() { // from class: androidx.compose.material3.TimePickerKt.drawSelector.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return r.f317a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                long jOffset = OffsetKt.Offset(contentDrawScope.mo381toPx0680j_4(DpOffset.m6905getXD9Ej5fM(TimePickerKt.getSelectorPos(analogTimePickerState))), contentDrawScope.mo381toPx0680j_4(DpOffset.m6907getYD9Ej5fM(TimePickerKt.getSelectorPos(analogTimePickerState))));
                TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
                float f = 2;
                float fMo381toPx0680j_4 = contentDrawScope.mo381toPx0680j_4(timePickerTokens.m3318getClockDialSelectorHandleContainerSizeD9Ej5fM()) / f;
                long selectorColor = timePickerColors.getSelectorColor();
                long jM4165getBlack0d7_KjU = Color.INSTANCE.m4165getBlack0d7_KjU();
                BlendMode.Companion companion = BlendMode.INSTANCE;
                DrawScope.m4688drawCircleVaOC9Bg$default(contentDrawScope, jM4165getBlack0d7_KjU, fMo381toPx0680j_4, jOffset, 0.0f, null, null, companion.m4053getClear0nO6VwU(), 56, null);
                contentDrawScope.drawContent();
                DrawScope.m4688drawCircleVaOC9Bg$default(contentDrawScope, selectorColor, fMo381toPx0680j_4, jOffset, 0.0f, null, null, companion.m4081getXor0nO6VwU(), 56, null);
                DrawScope.m4693drawLineNGM6Ib0$default(contentDrawScope, selectorColor, androidx.compose.ui.geometry.SizeKt.m3974getCenteruvyYCjk(contentDrawScope.mo4707getSizeNHjbRc()), Offset.m3899minusMKHz9U(jOffset, OffsetKt.Offset(((float) Math.cos(analogTimePickerState.getCurrentAngle())) * fMo381toPx0680j_4, ((float) Math.sin(analogTimePickerState.getCurrentAngle())) * fMo381toPx0680j_4)), contentDrawScope.mo381toPx0680j_4(timePickerTokens.m3319getClockDialSelectorTrackContainerWidthD9Ej5fM()), 0, null, 0.0f, null, companion.m4080getSrcOver0nO6VwU(), 240, null);
                DrawScope.m4688drawCircleVaOC9Bg$default(contentDrawScope, selectorColor, contentDrawScope.mo381toPx0680j_4(timePickerTokens.m3317getClockDialSelectorCenterContainerSizeD9Ej5fM()) / f, androidx.compose.ui.geometry.SizeKt.m3974getCenteruvyYCjk(contentDrawScope.mo4707getSizeNHjbRc()), 0.0f, null, null, 0, MenuKt.InTransitionDuration, null);
                DrawScope.m4688drawCircleVaOC9Bg$default(contentDrawScope, timePickerColors.m2468clockDialContentColorvNxB06k$material3_release(true), fMo381toPx0680j_4, jOffset, 0.0f, null, null, companion.m4063getDstOver0nO6VwU(), 56, null);
            }
        });
    }

    public static final int getHourForDisplay(TimePickerState timePickerState) {
        if (timePickerState.getIs24hour()) {
            return timePickerState.getHour() % 24;
        }
        if (timePickerState.getHour() % 12 == 0) {
            return 12;
        }
        return timePickerState.isAfternoon() ? timePickerState.getHour() - 12 : timePickerState.getHour();
    }

    public static final long getSelectorPos(AnalogTimePickerState analogTimePickerState) {
        TimePickerTokens timePickerTokens = TimePickerTokens.INSTANCE;
        float f = 2;
        float fM6844constructorimpl = Dp.m6844constructorimpl(timePickerTokens.m3318getClockDialSelectorHandleContainerSizeD9Ej5fM() / f);
        float fM6844constructorimpl2 = Dp.m6844constructorimpl(Dp.m6844constructorimpl(((analogTimePickerState.getIs24hour() && analogTimePickerState.isAfternoon() && TimePickerSelectionMode.m2521equalsimpl0(analogTimePickerState.mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI())) ? InnerCircleRadius : OuterCircleSizeRadius) - fM6844constructorimpl) + fM6844constructorimpl);
        return DpKt.m6865DpOffsetYgX7TsA(Dp.m6844constructorimpl(Dp.m6844constructorimpl(timePickerTokens.m3316getClockDialContainerSizeD9Ej5fM() / f) + Dp.m6844constructorimpl(((float) Math.cos(analogTimePickerState.getCurrentAngle())) * fM6844constructorimpl2)), Dp.m6844constructorimpl(Dp.m6844constructorimpl(timePickerTokens.m3316getClockDialContainerSizeD9Ej5fM() / f) + Dp.m6844constructorimpl(fM6844constructorimpl2 * ((float) Math.sin(analogTimePickerState.getCurrentAngle())))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: moveSelector-d3b8Pxo, reason: not valid java name */
    public static final void m2500moveSelectord3b8Pxo(TimePickerState timePickerState, float f, float f7, float f9, long j5) {
        if (TimePickerSelectionMode.m2521equalsimpl0(timePickerState.mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI()) && timePickerState.getIs24hour()) {
            timePickerState.setAfternoon(dist(f, f7, IntOffset.m6972getXimpl(j5), IntOffset.m6973getYimpl(j5)) < f9);
        }
    }

    @Composable
    @ReadOnlyComposable
    /* renamed from: numberContentDescription-dSwYdS4, reason: not valid java name */
    public static final String m2501numberContentDescriptiondSwYdS4(int i, boolean z10, int i6, Composer composer, int i10) {
        int iM2682constructorimpl;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(194237364, i10, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1914)");
        }
        if (TimePickerSelectionMode.m2521equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI())) {
            Strings.Companion companion = Strings.INSTANCE;
            iM2682constructorimpl = Strings.m2682constructorimpl(R.string.m3c_time_picker_minute_suffix);
        } else if (z10) {
            Strings.Companion companion2 = Strings.INSTANCE;
            iM2682constructorimpl = Strings.m2682constructorimpl(R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.INSTANCE;
            iM2682constructorimpl = Strings.m2682constructorimpl(R.string.m3c_time_picker_hour_suffix);
        }
        String strM2753getStringqBjtwXw = Strings_androidKt.m2753getStringqBjtwXw(iM2682constructorimpl, new Object[]{Integer.valueOf(i6)}, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return strM2753getStringqBjtwXw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* renamed from: onTap-rOwcSBo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m2502onTaprOwcSBo(androidx.compose.material3.AnalogTimePickerState r11, float r12, float r13, float r14, boolean r15, long r16, H7.c<? super C7.r> r18) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2502onTaprOwcSBo(androidx.compose.material3.AnalogTimePickerState, float, float, float, boolean, long, H7.c):java.lang.Object");
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final TimePickerState rememberTimePickerState(int i, int i6, boolean z10, Composer composer, int i10, int i11) {
        final int i12 = (i11 & 1) != 0 ? 0 : i;
        final int i13 = (i11 & 2) != 0 ? 0 : i6;
        final boolean zIs24HourFormat = (i11 & 4) != 0 ? TimeFormat_androidKt.is24HourFormat(composer, 0) : z10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, i10, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:573)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerStateImpl, ?> Saver = TimePickerStateImpl.INSTANCE.Saver();
        boolean z11 = ((((i10 & 14) ^ 6) > 4 && composer.changed(i12)) || (i10 & 6) == 4) | ((((i10 & 112) ^ 48) > 32 && composer.changed(i13)) || (i10 & 48) == 32) | ((((i10 & 896) ^ 384) > 256 && composer.changed(zIs24HourFormat)) || (i10 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new S7.a() { // from class: androidx.compose.material3.TimePickerKt$rememberTimePickerState$state$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final TimePickerStateImpl invoke() {
                    return new TimePickerStateImpl(i12, i13, zIs24HourFormat);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        TimePickerStateImpl timePickerStateImpl = (TimePickerStateImpl) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) Saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return timePickerStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: timeInputOnChange-z7XvuPQ, reason: not valid java name */
    public static final void m2503timeInputOnChangez7XvuPQ(int i, TimePickerState timePickerState, TextFieldValue textFieldValue, TextFieldValue textFieldValue2, int i6, k kVar) {
        if (kotlin.jvm.internal.k.b(textFieldValue.getText(), textFieldValue2.getText())) {
            kVar.invoke(textFieldValue);
            return;
        }
        if (textFieldValue.getText().length() == 0) {
            if (TimePickerSelectionMode.m2521equalsimpl0(i, TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI())) {
                timePickerState.setHour(0);
            } else {
                timePickerState.setMinute(0);
            }
            kVar.invoke(TextFieldValue.m6555copy3r_uNRQ$default(textFieldValue, "", 0L, (TextRange) null, 6, (Object) null));
            return;
        }
        try {
            int iV = (textFieldValue.getText().length() == 3 && TextRange.m6311getStartimpl(textFieldValue.getSelection()) == 1) ? AbstractC0897f.v(textFieldValue.getText().charAt(0)) : Integer.parseInt(textFieldValue.getText());
            if (iV <= i6) {
                TimePickerSelectionMode.Companion companion = TimePickerSelectionMode.INSTANCE;
                if (TimePickerSelectionMode.m2521equalsimpl0(i, companion.m2525getHouryecRtBI())) {
                    timePickerState.setHour(iV);
                    if (iV > 1 && !timePickerState.getIs24hour()) {
                        timePickerState.mo1502setSelection6_8s6DQ(companion.m2526getMinuteyecRtBI());
                    }
                } else {
                    timePickerState.setMinute(iV);
                }
                kVar.invoke(textFieldValue.getText().length() <= 2 ? textFieldValue : TextFieldValue.m6555copy3r_uNRQ$default(textFieldValue, String.valueOf(textFieldValue.getText().charAt(0)), 0L, (TextRange) null, 6, (Object) null));
            }
        } catch (NumberFormatException | IllegalArgumentException unused) {
        }
    }

    @Stable
    private static final Modifier visible(Modifier modifier, final boolean z10) {
        return modifier.then(new VisibleModifier(z10, InspectableValueKt.isDebugInspectorInfoEnabled() ? new k() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((InspectorInfo) obj);
                return r.f317a;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("visible");
                inspectorInfo.getProperties().set("visible", Boolean.valueOf(z10));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
