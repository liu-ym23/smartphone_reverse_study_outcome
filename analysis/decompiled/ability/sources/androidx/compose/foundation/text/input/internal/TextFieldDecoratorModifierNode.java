package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.k;
import S7.n;
import S7.o;
import android.view.KeyEvent;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.handwriting.StylusHandwritingNode;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.PlatformTextInputSessionScope;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.h;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.i;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\u0094\u0001\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\fB[\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 Ja\u0010\"\u001a\u00020!2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\"\u0010 J\u0013\u0010$\u001a\u00020!*\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020!2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020!H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020!H\u0016¢\u0006\u0004\b,\u0010+J\u0017\u0010/\u001a\u00020!2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b/\u00100J*\u00109\u001a\u00020!2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u00020!H\u0016¢\u0006\u0004\b:\u0010+J\u001a\u0010?\u001a\u00020\u00152\u0006\u0010<\u001a\u00020;H\u0016ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001a\u0010A\u001a\u00020\u00152\u0006\u0010<\u001a\u00020;H\u0016ø\u0001\u0000¢\u0006\u0004\b@\u0010>J\u000f\u0010B\u001a\u00020!H\u0016¢\u0006\u0004\bB\u0010+J\u000f\u0010C\u001a\u00020!H\u0002¢\u0006\u0004\bC\u0010+J\u0017\u0010E\u001a\u00020!2\u0006\u0010D\u001a\u00020\u0015H\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020!H\u0002¢\u0006\u0004\bG\u0010+J\u000f\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020!H\u0002¢\u0006\u0004\bK\u0010+J\u001a\u0010P\u001a\u00020!2\u0006\u0010M\u001a\u00020LH\u0002ø\u0001\u0000¢\u0006\u0004\bN\u0010OR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010FR\"\u0010\u0017\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010e\u001a\u0004\bi\u0010g\"\u0004\bj\u0010FR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010e\u001a\u0004\bp\u0010g\"\u0004\bq\u0010FR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001e\u0010x\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010~\u001a\u00020}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R(\u0010\u0019\u001a\u00020\u00182\u0007\u0010\u0086\u0001\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u0019\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010eR\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0090\u0001R!\u0010\u009a\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0099\u00010\u0098\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009d\u0001\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010gR\u0016\u0010\u009f\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010gR\u001f\u0010¢\u0001\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010w8BX\u0082\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001R\u0016\u0010£\u0001\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b£\u0001\u0010g\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/InputTransformation;", "filter", "", "enabled", "readOnly", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardOptions", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "keyboardActionHandler", "singleLine", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)V", "LC7/r;", "updateNode", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Landroidx/compose/ui/focus/FocusState;", "focusState", "onFocusEvent", "(Landroidx/compose/ui/focus/FocusState;)V", "onAttach", "()V", "onDetach", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "onGloballyPositioned", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "Landroidx/compose/ui/input/key/KeyEvent;", NotificationCompat.CATEGORY_EVENT, "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onPreKeyEvent", "onKeyEvent-ZmokQxo", "onKeyEvent", "onObservedReadsChanged", "onFocusChange", "fromTap", "startInputSession", "(Z)V", "disposeInputSession", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "requireKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "emitDragExitEvent", "Landroidx/compose/ui/text/input/ImeAction;", "imeAction", "onImeActionPerformed-KlQnJC8", "(I)V", "onImeActionPerformed", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "Landroidx/compose/foundation/text/input/InputTransformation;", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "Z", "getEnabled", "()Z", "setEnabled", "getReadOnly", "setReadOnly", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "getSingleLine", "setSingleLine", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "Lp9/i;", "backingStylusHandwritingTrigger", "Lp9/i;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "stylusHandwritingNode", "Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "dragEnterEvent", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "<set-?>", "Landroidx/compose/foundation/text/KeyboardOptions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "isElementFocused", "Landroidx/compose/ui/platform/WindowInfo;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "Lm9/c0;", "observeChangesJob", "Lm9/c0;", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "keyboardActionScope", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "inputSessionJob", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentConfigurationProvider", "LS7/a;", "getShouldMergeDescendantSemantics", "shouldMergeDescendantSemantics", "getEditable", "editable", "getStylusHandwritingTrigger", "()Lp9/i;", "stylusHandwritingTrigger", "isFocused", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements PlatformTextInputModifierNode, SemanticsModifierNode, FocusRequesterModifierNode, FocusEventModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;
    private i backingStylusHandwritingTrigger;
    private HoverInteraction.Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    private c0 inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isElementFocused;
    private KeyboardActionHandler keyboardActionHandler;
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private c0 observeChangesJob;
    private boolean readOnly;
    private final S7.a receiveContentConfigurationProvider;
    private boolean singleLine;
    private final StylusHandwritingNode stylusHandwritingNode;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private WindowInfo windowInfo;
    private final SuspendingPointerInputModifierNode pointerInputNode = (SuspendingPointerInputModifierNode) delegate(SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new TextFieldDecoratorModifierNode$pointerInputNode$1(this, null)));
    private final DragAndDropModifierNode dragAndDropNode = (DragAndDropModifierNode) delegate(TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode$default(new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$1
        {
            super(0);
        }

        @Override // S7.a
        public final Set<MediaType> invoke() {
            return ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0) != null ? TextFieldDecoratorModifierKt.MediaTypesAll : TextFieldDecoratorModifierKt.MediaTypesText;
        }
    }, new n() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$2
        {
            super(2);
        }

        @Override // S7.n
        public final Boolean invoke(ClipEntry clipEntry, ClipMetadata clipMetadata) {
            ClipEntry clipEntry2;
            this.this$0.emitDragExitEvent();
            this.this$0.getTextFieldSelectionState().clearHandleDragging();
            String plainText = TransferableContent_androidKt.readPlainText(clipEntry);
            ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0);
            if (receiveContentConfiguration != null) {
                TransferableContent transferableContentOnReceive = receiveContentConfiguration.getReceiveContentListener().onReceive(new TransferableContent(clipEntry, clipMetadata, TransferableContent.Source.INSTANCE.m344getDragAndDropkB6V9T0(), null, 8, null));
                plainText = (transferableContentOnReceive == null || (clipEntry2 = transferableContentOnReceive.getClipEntry()) == null) ? null : TransferableContent_androidKt.readPlainText(clipEntry2);
            }
            String str = plainText;
            if (str != null) {
                TransformedTextFieldState.replaceSelectedText$default(this.this$0.getTextFieldState(), str, false, null, 6, null);
            }
            return Boolean.TRUE;
        }
    }, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$3
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DragAndDropEvent) obj);
            return r.f317a;
        }

        public final void invoke(DragAndDropEvent dragAndDropEvent) {
            if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0) != null) {
                DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(this.this$0, dragAndDropEvent);
            }
        }
    }, null, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$4
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DragAndDropEvent) obj);
            return r.f317a;
        }

        public final void invoke(DragAndDropEvent dragAndDropEvent) {
            ReceiveContentListener receiveContentListener;
            TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
            HoverInteraction.Enter enter = new HoverInteraction.Enter();
            this.this$0.getInteractionSource().tryEmit(enter);
            textFieldDecoratorModifierNode.dragEnterEvent = enter;
            ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0);
            if (receiveContentConfiguration == null || (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) == null) {
                return;
            }
            receiveContentListener.onDragEnter();
        }
    }, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$5
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m1232invokek4lQ0M(((Offset) obj).m3905unboximpl());
            return r.f317a;
        }

        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final void m1232invokek4lQ0M(long j5) {
            long jM1258fromWindowToDecorationUv8p0NA = TextLayoutStateKt.m1258fromWindowToDecorationUv8p0NA(this.this$0.getTextLayoutState(), j5);
            this.this$0.getTextFieldState().m1268selectCharsIn5zctL8(TextRangeKt.TextRange(TextLayoutState.m1248getOffsetForPosition3MmeM6k$default(this.this$0.getTextLayoutState(), jM1258fromWindowToDecorationUv8p0NA, false, 2, null)));
            this.this$0.getTextFieldSelectionState().m1305updateHandleDraggingUv8p0NA(Handle.Cursor, jM1258fromWindowToDecorationUv8p0NA);
        }
    }, null, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$6
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DragAndDropEvent) obj);
            return r.f317a;
        }

        public final void invoke(DragAndDropEvent dragAndDropEvent) {
            ReceiveContentListener receiveContentListener;
            this.this$0.emitDragExitEvent();
            this.this$0.getTextFieldSelectionState().clearHandleDragging();
            ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0);
            if (receiveContentConfiguration == null || (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) == null) {
                return;
            }
            receiveContentListener.onDragExit();
        }
    }, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$dragAndDropNode$7
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DragAndDropEvent) obj);
            return r.f317a;
        }

        public final void invoke(DragAndDropEvent dragAndDropEvent) {
            this.this$0.emitDragExitEvent();
        }
    }, 72, null));

    @J7.c(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onFocusChange$1", f = "TextFieldDecoratorModifier.kt", l = {634}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onFocusChange$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05021 extends SuspendLambda implements n {
        int label;

        public C05021(H7.c<? super C05021> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return TextFieldDecoratorModifierNode.this.new C05021(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                TextFieldSelectionState textFieldSelectionState = TextFieldDecoratorModifierNode.this.getTextFieldSelectionState();
                this.label = 1;
                if (textFieldSelectionState.observeChanges(this) == coroutineSingletons) {
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
            return ((C05021) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1", f = "TextFieldDecoratorModifier.kt", l = {TypedValues.TransitionType.TYPE_TRANSITION_FLAGS}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05041 extends SuspendLambda implements n {
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        int label;

        @J7.c(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1", f = "TextFieldDecoratorModifier.kt", l = {708}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00521 extends SuspendLambda implements n {
            final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TextFieldDecoratorModifierNode this$0;

            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1, reason: invalid class name and collision with other inner class name */
            public /* synthetic */ class C00531 extends FunctionReferenceImpl implements k {
                public C00531(Object obj) {
                    super(1, obj, TextFieldDecoratorModifierNode.class, "onImeActionPerformed", "onImeActionPerformed-KlQnJC8(I)V", 0);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1238invokeKlQnJC8(((ImeAction) obj).getValue());
                    return r.f317a;
                }

                /* renamed from: invoke-KlQnJC8, reason: not valid java name */
                public final void m1238invokeKlQnJC8(int i) {
                    ((TextFieldDecoratorModifierNode) this.receiver).m1231onImeActionPerformedKlQnJC8(i);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00521(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ReceiveContentConfiguration receiveContentConfiguration, H7.c<? super C00521> cVar) {
                super(2, cVar);
                this.this$0 = textFieldDecoratorModifierNode;
                this.$receiveContentConfiguration = receiveContentConfiguration;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00521 c00521 = new C00521(this.this$0, this.$receiveContentConfiguration, cVar);
                c00521.L$0 = obj;
                return c00521;
            }

            @Override // S7.n
            public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, H7.c<?> cVar) {
                return ((C00521) create(platformTextInputSessionScope, cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    PlatformTextInputSessionScope platformTextInputSessionScope = (PlatformTextInputSessionScope) this.L$0;
                    TransformedTextFieldState textFieldState = this.this$0.getTextFieldState();
                    TextLayoutState textLayoutState = this.this$0.getTextLayoutState();
                    ImeOptions imeOptions$foundation_release = this.this$0.getKeyboardOptions().toImeOptions$foundation_release(this.this$0.getSingleLine());
                    ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
                    C00531 c00531 = new C00531(this.this$0);
                    i stylusHandwritingTrigger = this.this$0.getStylusHandwritingTrigger();
                    ViewConfiguration viewConfiguration = (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalViewConfiguration());
                    this.label = 1;
                    if (AndroidTextInputSession_androidKt.platformSpecificTextInputSession(platformTextInputSessionScope, textFieldState, textLayoutState, imeOptions$foundation_release, receiveContentConfiguration, c00531, stylusHandwritingTrigger, viewConfiguration, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05041(ReceiveContentConfiguration receiveContentConfiguration, H7.c<? super C05041> cVar) {
            super(2, cVar);
            this.$receiveContentConfiguration = receiveContentConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return TextFieldDecoratorModifierNode.this.new C05041(this.$receiveContentConfiguration, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = TextFieldDecoratorModifierNode.this;
                C00521 c00521 = new C00521(textFieldDecoratorModifierNode, this.$receiveContentConfiguration, null);
                this.label = 1;
                if (PlatformTextInputModifierNodeKt.establishTextInputSession(textFieldDecoratorModifierNode, c00521, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C05041) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation inputTransformation, boolean z10, boolean z11, final KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean z12, MutableInteractionSource mutableInteractionSource) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = inputTransformation;
        this.enabled = z10;
        this.readOnly = z11;
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = z12;
        this.interactionSource = mutableInteractionSource;
        this.stylusHandwritingNode = (StylusHandwritingNode) delegate(new StylusHandwritingNode(new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$stylusHandwritingNode$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                i stylusHandwritingTrigger;
                if (!this.this$0.isFocused()) {
                    FocusRequesterModifierNodeKt.requestFocus(this.this$0);
                }
                int keyboardType = keyboardOptions.getKeyboardType();
                KeyboardType.Companion companion = KeyboardType.INSTANCE;
                if (!KeyboardType.m6530equalsimpl0(keyboardType, companion.m6549getPasswordPjHm6EE()) && !KeyboardType.m6530equalsimpl0(keyboardOptions.getKeyboardType(), companion.m6548getNumberPasswordPjHm6EE()) && (stylusHandwritingTrigger = this.this$0.getStylusHandwritingTrigger()) != null) {
                    stylusHandwritingTrigger.a(r.f317a);
                }
                return Boolean.TRUE;
            }
        }));
        InputTransformation inputTransformation2 = this.filter;
        this.keyboardOptions = keyboardOptions.fillUnspecifiedValuesWith$foundation_release(inputTransformation2 != null ? inputTransformation2.getKeyboardOptions() : null);
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.receiveContentConfigurationProvider = new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$receiveContentConfigurationProvider$1
            {
                super(0);
            }

            @Override // S7.a
            public final ReceiveContentConfiguration invoke() {
                return ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.this$0);
            }
        };
    }

    private final void disposeInputSession() {
        c0 c0Var = this.inputSessionJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.inputSessionJob = null;
        i stylusHandwritingTrigger = getStylusHandwritingTrigger();
        if (stylusHandwritingTrigger != null) {
            stylusHandwritingTrigger.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitDragExitEvent() {
        HoverInteraction.Enter enter = this.dragEnterEvent;
        if (enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction.Exit(enter));
            this.dragEnterEvent = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i getStylusHandwritingTrigger() {
        i iVar = this.backingStylusHandwritingTrigger;
        if (iVar != null) {
            return iVar;
        }
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported()) {
            return null;
        }
        h hVarB = p9.e.b(1, 0, BufferOverflow.c, 2);
        this.backingStylusHandwritingTrigger = hVarB;
        return hVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFocused() {
        WindowInfo windowInfo = this.windowInfo;
        return this.isElementFocused && (windowInfo != null && windowInfo.isWindowFocused());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFocusChange() {
        this.textFieldSelectionState.setFocused(isFocused());
        if (isFocused() && this.observeChangesJob == null) {
            this.observeChangesJob = AbstractC1683A.n(getCoroutineScope(), null, new C05021(null), 3);
        } else {
            if (isFocused()) {
                return;
            }
            c0 c0Var = this.observeChangesJob;
            if (c0Var != null) {
                c0Var.cancel(null);
            }
            this.observeChangesJob = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onImeActionPerformed-KlQnJC8, reason: not valid java name */
    public final void m1231onImeActionPerformedKlQnJC8(final int imeAction) {
        KeyboardActionHandler keyboardActionHandler;
        ImeAction.Companion companion = ImeAction.INSTANCE;
        if (ImeAction.m6477equalsimpl0(imeAction, companion.m6494getNoneeUduSuo()) || ImeAction.m6477equalsimpl0(imeAction, companion.m6490getDefaulteUduSuo()) || (keyboardActionHandler = this.keyboardActionHandler) == null) {
            this.keyboardActionScope.mo1026defaultKeyboardActionKlQnJC8(imeAction);
        } else if (keyboardActionHandler != null) {
            keyboardActionHandler.onKeyboardAction(new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onImeActionPerformed$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1233invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1233invoke() {
                    this.this$0.keyboardActionScope.mo1026defaultKeyboardActionKlQnJC8(imeAction);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startInputSession(boolean fromTap) {
        if (fromTap || this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release()) {
            this.inputSessionJob = AbstractC1683A.n(getCoroutineScope(), null, new C05041(ReceiveContentConfigurationKt.getReceiveContentConfiguration(this), null), 3);
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextFieldCharSequence outputText = this.textFieldState.getOutputText();
        long selection = outputText.getSelection();
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, new AnnotatedString(outputText.toString(), null, null, 6, null));
        SemanticsPropertiesKt.m6101setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, selection);
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, getEditable());
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.1
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(List<TextLayoutResult> list) {
                TextLayoutResult layoutResult = TextFieldDecoratorModifierNode.this.getTextLayoutState().getLayoutResult();
                return Boolean.valueOf(layoutResult != null ? list.add(layoutResult) : false);
            }
        }, 1, null);
        if (getEditable()) {
            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.2
                {
                    super(1);
                }

                @Override // S7.k
                public final Boolean invoke(AnnotatedString annotatedString) {
                    if (!TextFieldDecoratorModifierNode.this.getEditable()) {
                        return Boolean.FALSE;
                    }
                    TextFieldDecoratorModifierNode.this.getTextFieldState().replaceAll(annotatedString);
                    return Boolean.TRUE;
                }
            }, 1, null);
            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new k() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.3
                {
                    super(1);
                }

                @Override // S7.k
                public final Boolean invoke(AnnotatedString annotatedString) {
                    if (!TextFieldDecoratorModifierNode.this.getEditable()) {
                        return Boolean.FALSE;
                    }
                    TransformedTextFieldState.replaceSelectedText$default(TextFieldDecoratorModifierNode.this.getTextFieldState(), annotatedString, true, null, 4, null);
                    return Boolean.TRUE;
                }
            }, 1, null);
        }
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new o() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.4
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
            }

            public final Boolean invoke(int i, int i6, boolean z10) {
                TextFieldCharSequence untransformedText = z10 ? TextFieldDecoratorModifierNode.this.getTextFieldState().getUntransformedText() : TextFieldDecoratorModifierNode.this.getTextFieldState().getVisualText();
                long selection2 = untransformedText.getSelection();
                if (!TextFieldDecoratorModifierNode.this.getEnabled() || Math.min(i, i6) < 0 || Math.max(i, i6) > untransformedText.length()) {
                    return Boolean.FALSE;
                }
                if (i == TextRange.m6311getStartimpl(selection2) && i6 == TextRange.m6306getEndimpl(selection2)) {
                    return Boolean.TRUE;
                }
                long jTextRange = TextRangeKt.TextRange(i, i6);
                if (z10 || i == i6) {
                    TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.None);
                } else {
                    TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
                }
                if (z10) {
                    TextFieldDecoratorModifierNode.this.getTextFieldState().m1269selectUntransformedCharsIn5zctL8(jTextRange);
                } else {
                    TextFieldDecoratorModifierNode.this.getTextFieldState().m1268selectCharsIn5zctL8(jTextRange);
                }
                return Boolean.TRUE;
            }
        }, 1, null);
        final int iM1040getImeActionOrDefaulteUduSuo$foundation_release = this.keyboardOptions.m1040getImeActionOrDefaulteUduSuo$foundation_release();
        SemanticsPropertiesKt.m6097onImeAction9UiTYpY$default(semanticsPropertyReceiver, iM1040getImeActionOrDefaulteUduSuo$foundation_release, null, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                TextFieldDecoratorModifierNode.this.m1231onImeActionPerformedKlQnJC8(iM1040getImeActionOrDefaulteUduSuo$foundation_release);
                return Boolean.TRUE;
            }
        }, 2, null);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.6
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                if (!TextFieldDecoratorModifierNode.this.isFocused()) {
                    FocusRequesterModifierNodeKt.requestFocus(TextFieldDecoratorModifierNode.this);
                } else if (!TextFieldDecoratorModifierNode.this.getReadOnly()) {
                    TextFieldDecoratorModifierNode.this.requireKeyboardController().show();
                }
                return Boolean.TRUE;
            }
        }, 1, null);
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.7
            {
                super(0);
            }

            @Override // S7.a
            public final Boolean invoke() {
                if (!TextFieldDecoratorModifierNode.this.isFocused()) {
                    FocusRequesterModifierNodeKt.requestFocus(TextFieldDecoratorModifierNode.this);
                }
                TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
                return Boolean.TRUE;
            }
        }, 1, null);
        if (!TextRange.m6305getCollapsedimpl(selection)) {
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.8
                {
                    super(0);
                }

                @Override // S7.a
                public final Boolean invoke() {
                    TextFieldSelectionState.copy$default(TextFieldDecoratorModifierNode.this.getTextFieldSelectionState(), false, 1, null);
                    return Boolean.TRUE;
                }
            }, 1, null);
            if (this.enabled && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.9
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Boolean invoke() {
                        TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().cut();
                        return Boolean.TRUE;
                    }
                }, 1, null);
            }
        }
        if (getEditable()) {
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.applySemantics.10
                {
                    super(0);
                }

                @Override // S7.a
                public final Boolean invoke() {
                    TextFieldDecoratorModifierNode.this.getTextFieldSelectionState().paste();
                    return Boolean.TRUE;
                }
            }, 1, null);
        }
        InputTransformation inputTransformation = this.filter;
        if (inputTransformation != null) {
            inputTransformation.applySemantics(semanticsPropertyReceiver);
        }
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        this.stylusHandwritingNode.onCancelPointerInput();
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration(null);
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(FocusState focusState) {
        if (this.isElementFocused == focusState.isFocused()) {
            return;
        }
        this.isElementFocused = focusState.isFocused();
        onFocusChange();
        if (!focusState.isFocused()) {
            disposeInputSession();
            TransformedTextFieldState transformedTextFieldState = this.textFieldState;
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer().getChangeTracker().clearChanges();
            EditCommandKt.finishComposingText(textFieldState.getMainBuffer());
            textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
            this.textFieldState.collapseSelectionToMax();
        } else if (getEditable()) {
            startInputSession(false);
        }
        this.stylusHandwritingNode.onFocusEvent(focusState);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(coordinates);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public boolean mo211onKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.mo1167onKeyEvent6ptp14s(event, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.enabled && !this.readOnly, this.singleLine, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$onKeyEvent$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m1234invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1234invoke() {
                TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
                textFieldDecoratorModifierNode.m1231onImeActionPerformedKlQnJC8(textFieldDecoratorModifierNode.getKeyboardOptions().m1040getImeActionOrDefaulteUduSuo$foundation_release());
            }
        });
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode.onObservedReadsChanged.1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m1235invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1235invoke() {
                TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = TextFieldDecoratorModifierNode.this;
                textFieldDecoratorModifierNode.windowInfo = (WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldDecoratorModifierNode, CompositionLocalsKt.getLocalWindowInfo());
                TextFieldDecoratorModifierNode.this.onFocusChange();
            }
        });
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo212onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.stylusHandwritingNode.mo212onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        this.pointerInputNode.mo212onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo213onPreKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.mo1168onPreKeyEventMyFupTE(event, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    public final void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public final void setFilter(InputTransformation inputTransformation) {
        this.filter = inputTransformation;
    }

    public final void setInteractionSource(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    public final void setKeyboardActionHandler(KeyboardActionHandler keyboardActionHandler) {
        this.keyboardActionHandler = keyboardActionHandler;
    }

    public final void setReadOnly(boolean z10) {
        this.readOnly = z10;
    }

    public final void setSingleLine(boolean z10) {
        this.singleLine = z10;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState textFieldSelectionState) {
        this.textFieldSelectionState = textFieldSelectionState;
    }

    public final void setTextFieldState(TransformedTextFieldState transformedTextFieldState) {
        this.textFieldState = transformedTextFieldState;
    }

    public final void setTextLayoutState(TextLayoutState textLayoutState) {
        this.textLayoutState = textLayoutState;
    }

    public final void updateNode(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean singleLine, MutableInteractionSource interactionSource) {
        boolean z10 = this.enabled;
        boolean z11 = z10 && !this.readOnly;
        boolean z12 = enabled && !readOnly;
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        KeyboardOptions keyboardOptions2 = this.keyboardOptions;
        TextFieldSelectionState textFieldSelectionState2 = this.textFieldSelectionState;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = filter;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.keyboardOptions = keyboardOptions.fillUnspecifiedValuesWith$foundation_release(filter != null ? filter.getKeyboardOptions() : null);
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = singleLine;
        this.interactionSource = interactionSource;
        if (z12 != z11 || !kotlin.jvm.internal.k.b(textFieldState, transformedTextFieldState) || !kotlin.jvm.internal.k.b(this.keyboardOptions, keyboardOptions2)) {
            if (z12 && isFocused()) {
                startInputSession(false);
            } else if (!z12) {
                disposeInputSession();
            }
        }
        if (z10 != enabled) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!kotlin.jvm.internal.k.b(textFieldSelectionState, textFieldSelectionState2)) {
            this.pointerInputNode.resetPointerInputHandler();
            this.stylusHandwritingNode.resetPointerInputHandler();
            if (getIsAttached()) {
                textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
            }
        }
        if (kotlin.jvm.internal.k.b(interactionSource, mutableInteractionSource)) {
            return;
        }
        this.pointerInputNode.resetPointerInputHandler();
        this.stylusHandwritingNode.resetPointerInputHandler();
    }
}
