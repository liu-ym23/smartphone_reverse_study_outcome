package androidx.compose.foundation.text.selection;

import C7.r;
import J7.c;
import N9.j;
import S7.k;
import S7.n;
import S7.p;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongIntMapKt;
import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongIntMap;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\"\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001c\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010 \u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0019H\u0000¢\u0006\u0004\b!\u0010\u001bJ\u000f\u0010$\u001a\u00020\u0019H\u0000¢\u0006\u0004\b#\u0010\u001bJ\u0011\u0010(\u001a\u0004\u0018\u00010%H\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010*\u001a\u00020\u001dH\u0000¢\u0006\u0004\b)\u0010\u001fJ\r\u0010+\u001a\u00020\u001d¢\u0006\u0004\b+\u0010\u001fJ\u0015\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020\u0019¢\u0006\u0004\b.\u0010/J4\u00107\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u0006\u00104\u001a\u000203H\u0000ø\u0001\u0000¢\u0006\u0004\b5\u00106J2\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002002\u0006\u00109\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u0006\u00104\u001a\u000203H\u0000ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020\u0019H\u0001¢\u0006\u0004\b<\u0010\u001bJ\u0018\u0010@\u001a\u00020\u001d2\u0006\u00108\u001a\u000200ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020\u001dH\u0002¢\u0006\u0004\bA\u0010\u001fJ\u000f\u0010B\u001a\u00020\u001dH\u0002¢\u0006\u0004\bB\u0010\u001fJ\u000f\u0010C\u001a\u00020\u001dH\u0002¢\u0006\u0004\bC\u0010\u001fJ\u0011\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bE\u0010FJ(\u0010J\u001a\u00020\u001d*\u00020G2\u0012\u0010I\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001d0HH\u0082@¢\u0006\u0004\bJ\u0010KJ!\u0010O\u001a\u00020L*\u00020L2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001d0MH\u0002¢\u0006\u0004\bO\u0010PJ\"\u0010U\u001a\u0002002\u0006\u0010Q\u001a\u00020\f2\u0006\u0010R\u001a\u000200H\u0002ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ*\u0010X\u001a\u00020\u001d2\u0006\u00108\u001a\u0002002\u0006\u0010,\u001a\u00020\u00192\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ*\u0010\\\u001a\u00020Y2\u0006\u00108\u001a\u0002002\u0006\u00109\u001a\u0002002\u0006\u0010,\u001a\u00020\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\bZ\u0010[J\u001f\u0010_\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020Y2\u0006\u0010^\u001a\u00020\u0012H\u0002¢\u0006\u0004\b_\u0010`R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010aR\u001c\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00190b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010dRF\u0010g\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u001d0H2\u0014\u0010f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u001d0H8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u0004\u0018\u00010m8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010u\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR&\u0010|\u001a\u0004\u0018\u00010{8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R*\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R1\u0010\u008e\u0001\u001a\u00020\u00192\u0007\u0010\u0089\u0001\u001a\u00020\u00198F@FX\u0086\u008e\u0002¢\u0006\u0016\n\u0005\b\u008a\u0001\u0010d\u001a\u0005\b\u008b\u0001\u0010\u001b\"\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001f\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\n\u0005\b2\u0010\u008f\u0001R5\u0010\u0091\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\f8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0005\b\u0093\u0001\u0010\u000e\"\u0006\b\u0094\u0001\u0010\u0095\u0001R7\u0010\u009a\u0001\u001a\u0002002\u0007\u0010\u0089\u0001\u001a\u0002008@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0016\n\u0005\b\u0096\u0001\u0010d\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0005\b\u0099\u0001\u0010?R7\u0010\u009e\u0001\u001a\u0002002\u0007\u0010\u0089\u0001\u001a\u0002008@@BX\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0016\n\u0005\b\u009b\u0001\u0010d\u001a\u0006\b\u009c\u0001\u0010\u0098\u0001\"\u0005\b\u009d\u0001\u0010?R<\u0010¤\u0001\u001a\u0004\u0018\u0001002\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001008F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b\u009f\u0001\u0010d\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R<\u0010¨\u0001\u001a\u0004\u0018\u0001002\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001008F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b¥\u0001\u0010d\u001a\u0006\b¦\u0001\u0010¡\u0001\"\u0006\b§\u0001\u0010£\u0001R8\u0010¯\u0001\u001a\u0005\u0018\u00010©\u00012\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010©\u00018F@BX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\bª\u0001\u0010d\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R<\u0010³\u0001\u001a\u0004\u0018\u0001002\t\u0010\u0089\u0001\u001a\u0004\u0018\u0001008F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0017\n\u0005\b°\u0001\u0010d\u001a\u0006\b±\u0001\u0010¡\u0001\"\u0006\b²\u0001\u0010£\u0001R2\u0010´\u0001\u001a\u0004\u0018\u00010Y8\u0000@\u0000X\u0081\u000e¢\u0006\u001f\n\u0006\b´\u0001\u0010µ\u0001\u0012\u0005\bº\u0001\u0010\u001f\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R1\u0010»\u0001\u001a\u00020\u00192\u0007\u0010\u0090\u0001\u001a\u00020\u00198\u0000@@X\u0080\u000e¢\u0006\u0017\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0005\b½\u0001\u0010\u001b\"\u0006\b¾\u0001\u0010\u008d\u0001R.\u0010Ã\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00128F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R)\u0010Ä\u0001\u001a\u00020\u00192\u0007\u0010\u0090\u0001\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\bÄ\u0001\u0010\u001b\"\u0006\bÅ\u0001\u0010\u008d\u0001R\u0014\u0010È\u0001\u001a\u00020L8F¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0016\u0010Ê\u0001\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÉ\u0001\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ë\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionManager;", "", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "selectionRegistrar", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;)V", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "anchor", "Landroidx/compose/foundation/text/selection/Selectable;", "getAnchorSelectable$foundation_release", "(Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;)Landroidx/compose/foundation/text/selection/Selectable;", "getAnchorSelectable", "Landroidx/compose/ui/layout/LayoutCoordinates;", "requireContainerCoordinates$foundation_release", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "requireContainerCoordinates", "", "selectableId", "Landroidx/compose/foundation/text/selection/Selection;", "previousSelection", "Lkotlin/Pair;", "Landroidx/collection/LongObjectMap;", "selectAllInSelectable$foundation_release", "(JLandroidx/compose/foundation/text/selection/Selection;)Lkotlin/Pair;", "selectAllInSelectable", "", "isEntireContainerSelected$foundation_release", "()Z", "isEntireContainerSelected", "LC7/r;", "selectAll$foundation_release", "()V", "selectAll", "isTriviallyCollapsedSelection$foundation_release", "isTriviallyCollapsedSelection", "isNonEmptySelection$foundation_release", "isNonEmptySelection", "Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "getSelectedText", "copy$foundation_release", "copy", "onRelease", "isStartHandle", "Landroidx/compose/foundation/text/TextDragObserver;", "handleDragObserver", "(Z)Landroidx/compose/foundation/text/TextDragObserver;", "Landroidx/compose/ui/geometry/Offset;", "newPosition", "previousPosition", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjustment", "updateSelection-qNKwrvQ$foundation_release", "(Landroidx/compose/ui/geometry/Offset;JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "updateSelection", "position", "previousHandlePosition", "updateSelection-jyLRC_s$foundation_release", "(JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "shouldPerformHaptics$foundation_release", "shouldPerformHaptics", "contextMenuOpenAdjustment-k-4lQ0M", "(J)V", "contextMenuOpenAdjustment", "updateHandleOffsets", "toolbarCopy", "updateSelectionToolbar", "Landroidx/compose/ui/geometry/Rect;", "getContentRect", "()Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/Function1;", "onTap", "detectNonConsumingTap", "(Landroidx/compose/ui/input/pointer/PointerInputScope;LS7/k;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function0;", "block", "onClearSelectionRequested", "(Landroidx/compose/ui/Modifier;LS7/a;)Landroidx/compose/ui/Modifier;", "layoutCoordinates", TypedValues.CycleType.S_WAVE_OFFSET, "convertToContainerCoordinates-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "convertToContainerCoordinates", "startSelection-9KIMszo", "(JZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)V", "startSelection", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getSelectionLayout-Wko1d7g", "(JJZ)Landroidx/compose/foundation/text/selection/SelectionLayout;", "getSelectionLayout", "selectionLayout", "newSelection", "selectionChanged", "(Landroidx/compose/foundation/text/selection/SelectionLayout;Landroidx/compose/foundation/text/selection/Selection;)V", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/runtime/MutableState;", "_selection", "Landroidx/compose/runtime/MutableState;", "_isInTouchMode", "newOnSelectionChange", "onSelectionChange", "LS7/k;", "getOnSelectionChange", "()LS7/k;", "setOnSelectionChange", "(LS7/k;)V", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "hasFocus$delegate", "getHasFocus", "setHasFocus", "(Z)V", "hasFocus", "Landroidx/compose/ui/geometry/Offset;", "value", "containerLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getContainerLayoutCoordinates", "setContainerLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "dragBeginPosition$delegate", "getDragBeginPosition-F1C5BW0$foundation_release", "()J", "setDragBeginPosition-k-4lQ0M", "dragBeginPosition", "dragTotalDistance$delegate", "getDragTotalDistance-F1C5BW0$foundation_release", "setDragTotalDistance-k-4lQ0M", "dragTotalDistance", "startHandlePosition$delegate", "getStartHandlePosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setStartHandlePosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "startHandlePosition", "endHandlePosition$delegate", "getEndHandlePosition-_m7T9-E", "setEndHandlePosition-_kEHs6E", "endHandlePosition", "Landroidx/compose/foundation/text/Handle;", "draggingHandle$delegate", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle", "currentDragPosition$delegate", "getCurrentDragPosition-_m7T9-E", "setCurrentDragPosition-_kEHs6E", "currentDragPosition", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "getPreviousSelectionLayout$foundation_release", "()Landroidx/compose/foundation/text/selection/SelectionLayout;", "setPreviousSelectionLayout$foundation_release", "(Landroidx/compose/foundation/text/selection/SelectionLayout;)V", "getPreviousSelectionLayout$foundation_release$annotations", "showToolbar", "Z", "getShowToolbar$foundation_release", "setShowToolbar$foundation_release", "getSelection", "()Landroidx/compose/foundation/text/selection/Selection;", "setSelection", "(Landroidx/compose/foundation/text/selection/Selection;)V", "selection", "isInTouchMode", "setInTouchMode", "getModifier", "()Landroidx/compose/ui/Modifier;", "modifier", "getShouldShowMagnifier", "shouldShowMagnifier", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectionManager {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private LayoutCoordinates containerLayoutCoordinates;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;

    /* renamed from: dragBeginPosition$delegate, reason: from kotlin metadata */
    private final MutableState dragBeginPosition;

    /* renamed from: dragTotalDistance$delegate, reason: from kotlin metadata */
    private final MutableState dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: endHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState endHandlePosition;
    private HapticFeedback hapticFeedBack;
    private Offset previousPosition;
    private SelectionLayout previousSelectionLayout;
    private final SelectionRegistrarImpl selectionRegistrar;
    private boolean showToolbar;

    /* renamed from: startHandlePosition$delegate, reason: from kotlin metadata */
    private final MutableState startHandlePosition;
    private TextToolbar textToolbar;
    private final MutableState<Selection> _selection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private final MutableState<Boolean> _isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    private k onSelectionChange = new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Selection) obj);
            return r.f317a;
        }

        public final void invoke(Selection selection) {
            this.this$0.setSelection(selection);
        }
    };
    private FocusRequester focusRequester = new FocusRequester();

    /* renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    @c(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2", f = "SelectionManager.kt", l = {739}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05332 extends RestrictedSuspendLambda implements n {
        final /* synthetic */ k $onTap;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05332(k kVar, H7.c<? super C05332> cVar) {
            super(2, cVar);
            this.$onTap = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C05332 c05332 = new C05332(this.$onTap, cVar);
            c05332.L$0 = obj;
            return c05332;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((C05332) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.label = 1;
                obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            PointerInputChange pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange != null) {
                this.$onTap.invoke(Offset.m3884boximpl(pointerInputChange.getPosition()));
            }
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1", f = "SelectionManager.kt", l = {746}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.selection.SelectionManager$onClearSelectionRequested$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05351 extends SuspendLambda implements n {
        final /* synthetic */ S7.a $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05351(S7.a aVar, H7.c<? super C05351> cVar) {
            super(2, cVar);
            this.$block = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C05351 c05351 = SelectionManager.this.new C05351(this.$block, cVar);
            c05351.L$0 = obj;
            return c05351;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((C05351) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                SelectionManager selectionManager = SelectionManager.this;
                final S7.a aVar = this.$block;
                k kVar = new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager.onClearSelectionRequested.1.1
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        m1428invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                        return r.f317a;
                    }

                    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m1428invokek4lQ0M(long j5) {
                        aVar.invoke();
                    }
                };
                this.label = 1;
                if (selectionManager.detectNonConsumingTap(pointerInputScope, kVar, this) == coroutineSingletons) {
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

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.selection.SelectionManager$updateSelectionToolbar$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C05361 extends FunctionReferenceImpl implements S7.a {
        public C05361(Object obj) {
            super(0, obj, SelectionManager.class, "toolbarCopy", "toolbarCopy()V", 0);
        }

        @Override // S7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m1429invoke();
            return r.f317a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m1429invoke() {
            ((SelectionManager) this.receiver).toolbarCopy();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.selection.SelectionManager$updateSelectionToolbar$2, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C05372 extends FunctionReferenceImpl implements S7.a {
        public C05372(Object obj) {
            super(0, obj, SelectionManager.class, "selectAll", "selectAll$foundation_release()V", 0);
        }

        @Override // S7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m1430invoke();
            return r.f317a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m1430invoke() {
            ((SelectionManager) this.receiver).selectAll$foundation_release();
        }
    }

    public SelectionManager(SelectionRegistrarImpl selectionRegistrarImpl) {
        this.selectionRegistrar = selectionRegistrarImpl;
        Offset.Companion companion = Offset.INSTANCE;
        this.dragBeginPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3884boximpl(companion.m3911getZeroF1C5BW0()), null, 2, null);
        this.dragTotalDistance = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3884boximpl(companion.m3911getZeroF1C5BW0()), null, 2, null);
        this.startHandlePosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.endHandlePosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        selectionRegistrarImpl.setOnPositionChangeCallback$foundation_release(new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager.1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return r.f317a;
            }

            public final void invoke(long j5) {
                if (SelectionManager.this.selectionRegistrar.getSubselections().contains(j5)) {
                    SelectionManager.this.updateHandleOffsets();
                    SelectionManager.this.updateSelectionToolbar();
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateStartCallback$foundation_release(new p() { // from class: androidx.compose.foundation.text.selection.SelectionManager.2
            {
                super(4);
            }

            @Override // S7.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                m1423invokeRg1IO4c(((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, ((Offset) obj3).m3905unboximpl(), (SelectionAdjustment) obj4);
                return r.f317a;
            }

            /* renamed from: invoke-Rg1IO4c, reason: not valid java name */
            public final void m1423invokeRg1IO4c(boolean z10, LayoutCoordinates layoutCoordinates, long j5, SelectionAdjustment selectionAdjustment) {
                long jMo5557getSizeYbymL2g = layoutCoordinates.mo5557getSizeYbymL2g();
                Rect rect = new Rect(0.0f, 0.0f, IntSize.m7015getWidthimpl(jMo5557getSizeYbymL2g), IntSize.m7014getHeightimpl(jMo5557getSizeYbymL2g));
                if (!SelectionManagerKt.m1432containsInclusiveUv8p0NA(rect, j5)) {
                    j5 = TextLayoutStateKt.m1255coerceIn3MmeM6k(j5, rect);
                }
                long jM1407convertToContainerCoordinatesR5De75A = SelectionManager.this.m1407convertToContainerCoordinatesR5De75A(layoutCoordinates, j5);
                if (OffsetKt.m3914isSpecifiedk4lQ0M(jM1407convertToContainerCoordinatesR5De75A)) {
                    SelectionManager.this.setInTouchMode(z10);
                    SelectionManager.this.m1414startSelection9KIMszo(jM1407convertToContainerCoordinatesR5De75A, false, selectionAdjustment);
                    SelectionManager.this.getFocusRequester().requestFocus();
                    SelectionManager.this.setShowToolbar$foundation_release(false);
                }
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateSelectAll$foundation_release(new n() { // from class: androidx.compose.foundation.text.selection.SelectionManager.3
            {
                super(2);
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), ((Number) obj2).longValue());
                return r.f317a;
            }

            public final void invoke(boolean z10, long j5) {
                SelectionManager selectionManager = SelectionManager.this;
                Pair<Selection, LongObjectMap<Selection>> pairSelectAllInSelectable$foundation_release = selectionManager.selectAllInSelectable$foundation_release(j5, selectionManager.getSelection());
                Selection selection = (Selection) pairSelectAllInSelectable$foundation_release.f4886a;
                LongObjectMap<Selection> longObjectMap = (LongObjectMap) pairSelectAllInSelectable$foundation_release.b;
                if (!kotlin.jvm.internal.k.b(selection, SelectionManager.this.getSelection())) {
                    SelectionManager.this.selectionRegistrar.setSubselections(longObjectMap);
                    SelectionManager.this.getOnSelectionChange().invoke(selection);
                }
                SelectionManager.this.setInTouchMode(z10);
                SelectionManager.this.getFocusRequester().requestFocus();
                SelectionManager.this.setShowToolbar$foundation_release(false);
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateCallback$foundation_release(new S7.r() { // from class: androidx.compose.foundation.text.selection.SelectionManager.4
            {
                super(6);
            }

            @Override // S7.r
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return m1424invokepGV3PM0(((Boolean) obj).booleanValue(), (LayoutCoordinates) obj2, ((Offset) obj3).m3905unboximpl(), ((Offset) obj4).m3905unboximpl(), ((Boolean) obj5).booleanValue(), (SelectionAdjustment) obj6);
            }

            /* renamed from: invoke-pGV3PM0, reason: not valid java name */
            public final Boolean m1424invokepGV3PM0(boolean z10, LayoutCoordinates layoutCoordinates, long j5, long j6, boolean z11, SelectionAdjustment selectionAdjustment) {
                long jM1407convertToContainerCoordinatesR5De75A = SelectionManager.this.m1407convertToContainerCoordinatesR5De75A(layoutCoordinates, j5);
                long jM1407convertToContainerCoordinatesR5De75A2 = SelectionManager.this.m1407convertToContainerCoordinatesR5De75A(layoutCoordinates, j6);
                SelectionManager.this.setInTouchMode(z10);
                return Boolean.valueOf(SelectionManager.this.m1422updateSelectionqNKwrvQ$foundation_release(Offset.m3884boximpl(jM1407convertToContainerCoordinatesR5De75A), jM1407convertToContainerCoordinatesR5De75A2, z11, selectionAdjustment));
            }
        });
        selectionRegistrarImpl.setOnSelectionUpdateEndCallback$foundation_release(new S7.a() { // from class: androidx.compose.foundation.text.selection.SelectionManager.5
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m1425invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1425invoke() {
                SelectionManager.this.setShowToolbar$foundation_release(true);
                SelectionManager.this.setDraggingHandle(null);
                SelectionManager.this.m1409setCurrentDragPosition_kEHs6E(null);
            }
        });
        selectionRegistrarImpl.setOnSelectableChangeCallback$foundation_release(new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager.6
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return r.f317a;
            }

            public final void invoke(long j5) {
                if (SelectionManager.this.selectionRegistrar.getSubselections().contains(j5)) {
                    SelectionManager.this.onRelease();
                    SelectionManager.this.setSelection(null);
                }
            }
        });
        selectionRegistrarImpl.setAfterSelectableUnsubscribe$foundation_release(new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager.7
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return r.f317a;
            }

            public final void invoke(long j5) {
                Selection.AnchorInfo end;
                Selection.AnchorInfo start;
                Selection selection = SelectionManager.this.getSelection();
                if (selection != null && (start = selection.getStart()) != null && j5 == start.getSelectableId()) {
                    SelectionManager.this.m1413setStartHandlePosition_kEHs6E(null);
                }
                Selection selection2 = SelectionManager.this.getSelection();
                if (selection2 != null && (end = selection2.getEnd()) != null && j5 == end.getSelectableId()) {
                    SelectionManager.this.m1412setEndHandlePosition_kEHs6E(null);
                }
                if (SelectionManager.this.selectionRegistrar.getSubselections().contains(j5)) {
                    SelectionManager.this.updateSelectionToolbar();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: convertToContainerCoordinates-R5De75A, reason: not valid java name */
    public final long m1407convertToContainerCoordinatesR5De75A(LayoutCoordinates layoutCoordinates, long offset) {
        LayoutCoordinates layoutCoordinates2 = this.containerLayoutCoordinates;
        return (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) ? Offset.INSTANCE.m3910getUnspecifiedF1C5BW0() : requireContainerCoordinates$foundation_release().mo5558localPositionOfR5De75A(layoutCoordinates, offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object detectNonConsumingTap(PointerInputScope pointerInputScope, k kVar, H7.c<? super r> cVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C05332(kVar, null), cVar);
        return objAwaitEachGesture == CoroutineSingletons.f4909a ? objAwaitEachGesture : r.f317a;
    }

    private final Rect getContentRect() {
        LayoutCoordinates layoutCoordinates;
        if (getSelection() == null || (layoutCoordinates = this.containerLayoutCoordinates) == null || !layoutCoordinates.isAttached()) {
            return null;
        }
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        ArrayList arrayList = new ArrayList(listSort.size());
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
            Pair pair = selection != null ? new Pair(selectable, selection) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        List listFirstAndLast = SelectionManagerKt.firstAndLast(arrayList);
        if (listFirstAndLast.isEmpty()) {
            return null;
        }
        Rect selectedRegionRect = SelectionManagerKt.getSelectedRegionRect(listFirstAndLast, layoutCoordinates);
        if (kotlin.jvm.internal.k.b(selectedRegionRect, SelectionManagerKt.invertedInfiniteRect)) {
            return null;
        }
        Rect rectIntersect = SelectionManagerKt.visibleBounds(layoutCoordinates).intersect(selectedRegionRect);
        if (rectIntersect.getWidth() < 0.0f || rectIntersect.getHeight() < 0.0f) {
            return null;
        }
        Rect rectM3932translatek4lQ0M = rectIntersect.m3932translatek4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
        return Rect.copy$default(rectM3932translatek4lQ0M, 0.0f, 0.0f, 0.0f, (SelectionHandlesKt.getHandleHeight() * 4) + rectM3932translatek4lQ0M.getBottom(), 7, null);
    }

    @VisibleForTesting
    public static /* synthetic */ void getPreviousSelectionLayout$foundation_release$annotations() {
    }

    /* renamed from: getSelectionLayout-Wko1d7g, reason: not valid java name */
    private final SelectionLayout m1408getSelectionLayoutWko1d7g(long position, long previousHandlePosition, boolean isStartHandle) {
        LayoutCoordinates layoutCoordinatesRequireContainerCoordinates$foundation_release = requireContainerCoordinates$foundation_release();
        List<Selectable> listSort = this.selectionRegistrar.sort(layoutCoordinatesRequireContainerCoordinates$foundation_release);
        final MutableLongIntMap mutableLongIntMapMutableLongIntMapOf = LongIntMapKt.mutableLongIntMapOf();
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            mutableLongIntMapMutableLongIntMapOf.set(listSort.get(i).getSelectableId(), i);
        }
        SelectionLayoutBuilder selectionLayoutBuilder = new SelectionLayoutBuilder(position, previousHandlePosition, layoutCoordinatesRequireContainerCoordinates$foundation_release, isStartHandle, OffsetKt.m3916isUnspecifiedk4lQ0M(previousHandlePosition) ? null : getSelection(), new Comparator() { // from class: androidx.compose.foundation.text.selection.SelectionManager$getSelectionLayout-Wko1d7g$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m(Integer.valueOf(mutableLongIntMapMutableLongIntMapOf.get(((Number) t9).longValue())), Integer.valueOf(mutableLongIntMapMutableLongIntMapOf.get(((Number) t10).longValue())));
            }
        }, null);
        int size2 = listSort.size();
        for (int i6 = 0; i6 < size2; i6++) {
            listSort.get(i6).appendSelectableInfoToBuilder(selectionLayoutBuilder);
        }
        return selectionLayoutBuilder.build();
    }

    private final boolean getShouldShowMagnifier() {
        return (getDraggingHandle() == null || !isInTouchMode() || isTriviallyCollapsedSelection$foundation_release()) ? false : true;
    }

    private final Modifier onClearSelectionRequested(Modifier modifier, S7.a aVar) {
        if (!getHasFocus()) {
            return modifier;
        }
        return modifier.then(new SuspendPointerInputElement(r.f317a, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new C05351(aVar, null)), 6, null));
    }

    private final void selectionChanged(SelectionLayout selectionLayout, Selection newSelection) {
        HapticFeedback hapticFeedback;
        if (shouldPerformHaptics$foundation_release() && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
        }
        this.selectionRegistrar.setSubselections(selectionLayout.createSubSelections(newSelection));
        this.onSelectionChange.invoke(newSelection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m1409setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragBeginPosition-k-4lQ0M, reason: not valid java name */
    public final void m1410setDragBeginPositionk4lQ0M(long j5) {
        this.dragBeginPosition.setValue(Offset.m3884boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDragTotalDistance-k-4lQ0M, reason: not valid java name */
    public final void m1411setDragTotalDistancek4lQ0M(long j5) {
        this.dragTotalDistance.setValue(Offset.m3884boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setEndHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m1412setEndHandlePosition_kEHs6E(Offset offset) {
        this.endHandlePosition.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setStartHandlePosition-_kEHs6E, reason: not valid java name */
    public final void m1413setStartHandlePosition_kEHs6E(Offset offset) {
        this.startHandlePosition.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startSelection-9KIMszo, reason: not valid java name */
    public final void m1414startSelection9KIMszo(long position, boolean isStartHandle, SelectionAdjustment adjustment) {
        this.previousSelectionLayout = null;
        m1421updateSelectionjyLRC_s$foundation_release(position, Offset.INSTANCE.m3910getUnspecifiedF1C5BW0(), isStartHandle, adjustment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toolbarCopy() {
        copy$foundation_release();
        onRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateHandleOffsets() {
        /*
            r11 = this;
            androidx.compose.foundation.text.selection.Selection r0 = r11.getSelection()
            androidx.compose.ui.layout.LayoutCoordinates r1 = r11.containerLayoutCoordinates
            r2 = 0
            if (r0 == 0) goto L14
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r3 = r0.getStart()
            if (r3 == 0) goto L14
            androidx.compose.foundation.text.selection.Selectable r3 = r11.getAnchorSelectable$foundation_release(r3)
            goto L15
        L14:
            r3 = r2
        L15:
            if (r0 == 0) goto L22
            androidx.compose.foundation.text.selection.Selection$AnchorInfo r4 = r0.getEnd()
            if (r4 == 0) goto L22
            androidx.compose.foundation.text.selection.Selectable r4 = r11.getAnchorSelectable$foundation_release(r4)
            goto L23
        L22:
            r4 = r2
        L23:
            if (r3 == 0) goto L2a
            androidx.compose.ui.layout.LayoutCoordinates r5 = r3.getLayoutCoordinates()
            goto L2b
        L2a:
            r5 = r2
        L2b:
            if (r4 == 0) goto L32
            androidx.compose.ui.layout.LayoutCoordinates r6 = r4.getLayoutCoordinates()
            goto L33
        L32:
            r6 = r2
        L33:
            if (r0 == 0) goto La0
            if (r1 == 0) goto La0
            boolean r7 = r1.isAttached()
            if (r7 == 0) goto La0
            if (r5 != 0) goto L42
            if (r6 != 0) goto L42
            goto La0
        L42:
            androidx.compose.ui.geometry.Rect r7 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r1)
            if (r5 == 0) goto L6f
            r8 = 1
            long r8 = r3.mo1377getHandlePositiondBAh8RU(r0, r8)
            boolean r3 = androidx.compose.ui.geometry.OffsetKt.m3916isUnspecifiedk4lQ0M(r8)
            if (r3 == 0) goto L54
            goto L6f
        L54:
            long r8 = r1.mo5558localPositionOfR5De75A(r5, r8)
            androidx.compose.ui.geometry.Offset r3 = androidx.compose.ui.geometry.Offset.m3884boximpl(r8)
            long r8 = r3.m3905unboximpl()
            androidx.compose.foundation.text.Handle r5 = r11.getDraggingHandle()
            androidx.compose.foundation.text.Handle r10 = androidx.compose.foundation.text.Handle.SelectionStart
            if (r5 == r10) goto L70
            boolean r5 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1432containsInclusiveUv8p0NA(r7, r8)
            if (r5 == 0) goto L6f
            goto L70
        L6f:
            r3 = r2
        L70:
            r11.m1413setStartHandlePosition_kEHs6E(r3)
            if (r6 == 0) goto L9c
            r3 = 0
            long r3 = r4.mo1377getHandlePositiondBAh8RU(r0, r3)
            boolean r0 = androidx.compose.ui.geometry.OffsetKt.m3916isUnspecifiedk4lQ0M(r3)
            if (r0 == 0) goto L81
            goto L9c
        L81:
            long r0 = r1.mo5558localPositionOfR5De75A(r6, r3)
            androidx.compose.ui.geometry.Offset r0 = androidx.compose.ui.geometry.Offset.m3884boximpl(r0)
            long r3 = r0.m3905unboximpl()
            androidx.compose.foundation.text.Handle r1 = r11.getDraggingHandle()
            androidx.compose.foundation.text.Handle r5 = androidx.compose.foundation.text.Handle.SelectionEnd
            if (r1 == r5) goto L9b
            boolean r1 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1432containsInclusiveUv8p0NA(r7, r3)
            if (r1 == 0) goto L9c
        L9b:
            r2 = r0
        L9c:
            r11.m1412setEndHandlePosition_kEHs6E(r2)
            return
        La0:
            r11.m1413setStartHandlePosition_kEHs6E(r2)
            r11.m1412setEndHandlePosition_kEHs6E(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManager.updateHandleOffsets():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionToolbar() {
        TextToolbar textToolbar;
        if (getHasFocus() && (textToolbar = this.textToolbar) != null) {
            if (!this.showToolbar || !isInTouchMode()) {
                if (textToolbar.getStatus() == TextToolbarStatus.Shown) {
                    textToolbar.hide();
                }
            } else {
                Rect contentRect = getContentRect();
                if (contentRect == null) {
                    return;
                }
                TextToolbar.showMenu$default(textToolbar, contentRect, isNonEmptySelection$foundation_release() ? new C05361(this) : null, null, null, isEntireContainerSelected$foundation_release() ? null : new C05372(this), 12, null);
            }
        }
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m1415contextMenuOpenAdjustmentk4lQ0M(long position) {
        Selection selection = getSelection();
        if (selection != null ? TextRange.m6305getCollapsedimpl(selection.m1383toTextRanged9O1mEE()) : true) {
            m1414startSelection9KIMszo(position, true, SelectionAdjustment.INSTANCE.getWord());
        }
    }

    public final void copy$foundation_release() {
        ClipboardManager clipboardManager;
        AnnotatedString selectedText$foundation_release = getSelectedText$foundation_release();
        if (selectedText$foundation_release != null) {
            if (selectedText$foundation_release.length() <= 0) {
                selectedText$foundation_release = null;
            }
            if (selectedText$foundation_release == null || (clipboardManager = this.clipboardManager) == null) {
                return;
            }
            clipboardManager.setText(selectedText$foundation_release);
        }
    }

    public final Selectable getAnchorSelectable$foundation_release(Selection.AnchorInfo anchor) {
        return this.selectionRegistrar.getSelectableMap$foundation_release().get(anchor.getSelectableId());
    }

    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    public final LayoutCoordinates getContainerLayoutCoordinates() {
        return this.containerLayoutCoordinates;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1416getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getDragBeginPosition-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1417getDragBeginPositionF1C5BW0$foundation_release() {
        return ((Offset) this.dragBeginPosition.getValue()).m3905unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getDragTotalDistance-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m1418getDragTotalDistanceF1C5BW0$foundation_release() {
        return ((Offset) this.dragTotalDistance.getValue()).m3905unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getEndHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m1419getEndHandlePosition_m7T9E() {
        return (Offset) this.endHandlePosition.getValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    public final Modifier getModifier() {
        Modifier modifierSelectionMagnifier = Modifier.INSTANCE;
        Modifier modifierOnKeyEvent = KeyInputModifierKt.onKeyEvent(SelectionGesturesKt.updateSelectionTouchMode(FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(FocusRequesterModifierKt.focusRequester(OnGloballyPositionedModifierKt.onGloballyPositioned(onClearSelectionRequested(modifierSelectionMagnifier, new S7.a() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m1426invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1426invoke() {
                this.this$0.onRelease();
            }
        }), new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$2
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((LayoutCoordinates) obj);
                return r.f317a;
            }

            public final void invoke(LayoutCoordinates layoutCoordinates) {
                this.this$0.setContainerLayoutCoordinates(layoutCoordinates);
            }
        }), this.focusRequester), new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$3
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusState) obj);
                return r.f317a;
            }

            public final void invoke(FocusState focusState) {
                if (!focusState.isFocused() && this.this$0.getHasFocus()) {
                    this.this$0.onRelease();
                }
                this.this$0.setHasFocus(focusState.isFocused());
            }
        }), false, null, 3, null), new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$4
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return r.f317a;
            }

            public final void invoke(boolean z10) {
                this.this$0.setInTouchMode(z10);
            }
        }), new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager$modifier$5
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m1427invokeZmokQxo(((KeyEvent) obj).m5264unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m1427invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z10;
                if (SelectionManager_androidKt.m1434isCopyKeyEventZmokQxo(keyEvent)) {
                    this.this$0.copy$foundation_release();
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        });
        if (getShouldShowMagnifier()) {
            modifierSelectionMagnifier = SelectionManager_androidKt.selectionMagnifier(modifierSelectionMagnifier, this);
        }
        return modifierOnKeyEvent.then(modifierSelectionMagnifier);
    }

    public final k getOnSelectionChange() {
        return this.onSelectionChange;
    }

    /* renamed from: getPreviousSelectionLayout$foundation_release, reason: from getter */
    public final SelectionLayout getPreviousSelectionLayout() {
        return this.previousSelectionLayout;
    }

    public final AnnotatedString getSelectedText$foundation_release() {
        if (getSelection() == null || this.selectionRegistrar.getSubselections().isEmpty()) {
            return null;
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId());
            if (selection != null) {
                AnnotatedString text = selectable.getText();
                builder.append(selection.getHandlesCrossed() ? text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset()) : text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset()));
            }
        }
        return builder.toAnnotatedString();
    }

    public final Selection getSelection() {
        return this._selection.getValue();
    }

    /* renamed from: getShowToolbar$foundation_release, reason: from getter */
    public final boolean getShowToolbar() {
        return this.showToolbar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getStartHandlePosition-_m7T9-E, reason: not valid java name */
    public final Offset m1420getStartHandlePosition_m7T9E() {
        return (Offset) this.startHandlePosition.getValue();
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final TextDragObserver handleDragObserver(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.SelectionManager.handleDragObserver.1
            private final void done() {
                this.setShowToolbar$foundation_release(true);
                this.setDraggingHandle(null);
                this.m1409setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                done();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1091onDownk4lQ0M(long point) {
                LayoutCoordinates layoutCoordinates;
                Offset offsetM1420getStartHandlePosition_m7T9E = isStartHandle ? this.m1420getStartHandlePosition_m7T9E() : this.m1419getEndHandlePosition_m7T9E();
                if (offsetM1420getStartHandlePosition_m7T9E != null) {
                    offsetM1420getStartHandlePosition_m7T9E.m3905unboximpl();
                    Selection selection = this.getSelection();
                    if (selection == null) {
                        return;
                    }
                    Selectable anchorSelectable$foundation_release = this.getAnchorSelectable$foundation_release(isStartHandle ? selection.getStart() : selection.getEnd());
                    if (anchorSelectable$foundation_release == null || (layoutCoordinates = anchorSelectable$foundation_release.getLayoutCoordinates()) == null) {
                        return;
                    }
                    long jMo1377getHandlePositiondBAh8RU = anchorSelectable$foundation_release.mo1377getHandlePositiondBAh8RU(selection, isStartHandle);
                    if (OffsetKt.m3916isUnspecifiedk4lQ0M(jMo1377getHandlePositiondBAh8RU)) {
                        return;
                    }
                    long jM1391getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1391getAdjustedCoordinatesk4lQ0M(jMo1377getHandlePositiondBAh8RU);
                    SelectionManager selectionManager = this;
                    selectionManager.m1409setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(selectionManager.requireContainerCoordinates$foundation_release().mo5558localPositionOfR5De75A(layoutCoordinates, jM1391getAdjustedCoordinatesk4lQ0M)));
                    this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                    this.setShowToolbar$foundation_release(false);
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1092onDragk4lQ0M(long delta) {
                if (this.getDraggingHandle() == null) {
                    return;
                }
                SelectionManager selectionManager = this;
                selectionManager.m1411setDragTotalDistancek4lQ0M(Offset.m3900plusMKHz9U(selectionManager.m1418getDragTotalDistanceF1C5BW0$foundation_release(), delta));
                long jM3900plusMKHz9U = Offset.m3900plusMKHz9U(this.m1417getDragBeginPositionF1C5BW0$foundation_release(), this.m1418getDragTotalDistanceF1C5BW0$foundation_release());
                if (this.m1422updateSelectionqNKwrvQ$foundation_release(Offset.m3884boximpl(jM3900plusMKHz9U), this.m1417getDragBeginPositionF1C5BW0$foundation_release(), isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate())) {
                    this.m1410setDragBeginPositionk4lQ0M(jM3900plusMKHz9U);
                    this.m1411setDragTotalDistancek4lQ0M(Offset.INSTANCE.m3911getZeroF1C5BW0());
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1093onStartk4lQ0M(long startPoint) {
                if (this.getDraggingHandle() == null) {
                    return;
                }
                Selection selection = this.getSelection();
                kotlin.jvm.internal.k.c(selection);
                Selectable selectable = this.selectionRegistrar.getSelectableMap$foundation_release().get((isStartHandle ? selection.getStart() : selection.getEnd()).getSelectableId());
                if (selectable == null) {
                    throw new IllegalStateException("SelectionRegistrar should contain the current selection's selectableIds");
                }
                Selectable selectable2 = selectable;
                LayoutCoordinates layoutCoordinates = selectable2.getLayoutCoordinates();
                if (layoutCoordinates == null) {
                    throw new IllegalStateException("Current selectable should have layout coordinates.");
                }
                long jMo1377getHandlePositiondBAh8RU = selectable2.mo1377getHandlePositiondBAh8RU(selection, isStartHandle);
                if (OffsetKt.m3916isUnspecifiedk4lQ0M(jMo1377getHandlePositiondBAh8RU)) {
                    return;
                }
                long jM1391getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1391getAdjustedCoordinatesk4lQ0M(jMo1377getHandlePositiondBAh8RU);
                SelectionManager selectionManager = this;
                selectionManager.m1410setDragBeginPositionk4lQ0M(selectionManager.requireContainerCoordinates$foundation_release().mo5558localPositionOfR5De75A(layoutCoordinates, jM1391getAdjustedCoordinatesk4lQ0M));
                this.m1411setDragTotalDistancek4lQ0M(Offset.INSTANCE.m3911getZeroF1C5BW0());
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                done();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                done();
            }
        };
    }

    public final boolean isEntireContainerSelected$foundation_release() {
        Selection selection;
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        if (listSort.isEmpty()) {
            return true;
        }
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            AnnotatedString text = selectable.getText();
            if (text.length() != 0 && ((selection = this.selectionRegistrar.getSubselections().get(selectable.getSelectableId())) == null || Math.abs(selection.getStart().getOffset() - selection.getEnd().getOffset()) != text.length())) {
                return false;
            }
        }
        return true;
    }

    public final boolean isInTouchMode() {
        return this._isInTouchMode.getValue().booleanValue();
    }

    public final boolean isNonEmptySelection$foundation_release() {
        Selection selection = getSelection();
        if (selection == null || kotlin.jvm.internal.k.b(selection.getStart(), selection.getEnd())) {
            return false;
        }
        if (selection.getStart().getSelectableId() == selection.getEnd().getSelectableId()) {
            return true;
        }
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        for (int i = 0; i < size; i++) {
            Selection selection2 = this.selectionRegistrar.getSubselections().get(listSort.get(i).getSelectableId());
            if (selection2 != null && selection2.getStart().getOffset() != selection2.getEnd().getOffset()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isTriviallyCollapsedSelection$foundation_release() {
        Selection selection = getSelection();
        if (selection == null) {
            return true;
        }
        return kotlin.jvm.internal.k.b(selection.getStart(), selection.getEnd());
    }

    public final void onRelease() {
        HapticFeedback hapticFeedback;
        this.selectionRegistrar.setSubselections(LongObjectMapKt.emptyLongObjectMap());
        setShowToolbar$foundation_release(false);
        if (getSelection() != null) {
            this.onSelectionChange.invoke(null);
            if (!isInTouchMode() || (hapticFeedback = this.hapticFeedBack) == null) {
                return;
            }
            hapticFeedback.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
        }
    }

    public final LayoutCoordinates requireContainerCoordinates$foundation_release() {
        LayoutCoordinates layoutCoordinates = this.containerLayoutCoordinates;
        if (layoutCoordinates == null) {
            throw new IllegalArgumentException("null coordinates");
        }
        if (layoutCoordinates.isAttached()) {
            return layoutCoordinates;
        }
        throw new IllegalArgumentException("unattached coordinates");
    }

    public final void selectAll$foundation_release() {
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        if (listSort.isEmpty()) {
            return;
        }
        MutableLongObjectMap mutableLongObjectMapMutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        int size = listSort.size();
        Selection selection = null;
        Selection selection2 = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selectAllSelection = selectable.getSelectAllSelection();
            if (selectAllSelection != null) {
                if (selection == null) {
                    selection = selectAllSelection;
                }
                mutableLongObjectMapMutableLongObjectMapOf.put(selectable.getSelectableId(), selectAllSelection);
                selection2 = selectAllSelection;
            }
        }
        if (mutableLongObjectMapMutableLongObjectMapOf.isEmpty()) {
            return;
        }
        if (selection != selection2) {
            kotlin.jvm.internal.k.c(selection);
            Selection.AnchorInfo start = selection.getStart();
            kotlin.jvm.internal.k.c(selection2);
            selection = new Selection(start, selection2.getEnd(), false);
        }
        this.selectionRegistrar.setSubselections(mutableLongObjectMapMutableLongObjectMapOf);
        this.onSelectionChange.invoke(selection);
        this.previousSelectionLayout = null;
    }

    public final Pair<Selection, LongObjectMap<Selection>> selectAllInSelectable$foundation_release(long selectableId, Selection previousSelection) {
        HapticFeedback hapticFeedback;
        MutableLongObjectMap mutableLongObjectMapMutableLongObjectMapOf = LongObjectMapKt.mutableLongObjectMapOf();
        List<Selectable> listSort = this.selectionRegistrar.sort(requireContainerCoordinates$foundation_release());
        int size = listSort.size();
        Selection selectionMerge = null;
        for (int i = 0; i < size; i++) {
            Selectable selectable = listSort.get(i);
            Selection selectAllSelection = selectable.getSelectableId() == selectableId ? selectable.getSelectAllSelection() : null;
            if (selectAllSelection != null) {
                mutableLongObjectMapMutableLongObjectMapOf.set(selectable.getSelectableId(), selectAllSelection);
            }
            selectionMerge = SelectionManagerKt.merge(selectionMerge, selectAllSelection);
        }
        if (isInTouchMode() && !kotlin.jvm.internal.k.b(selectionMerge, previousSelection) && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
        }
        return new Pair<>(selectionMerge, mutableLongObjectMapMutableLongObjectMapOf);
    }

    public final void setClipboardManager(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    public final void setContainerLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.containerLayoutCoordinates = layoutCoordinates;
        if (!getHasFocus() || getSelection() == null) {
            return;
        }
        Offset offsetM3884boximpl = layoutCoordinates != null ? Offset.m3884boximpl(LayoutCoordinatesKt.positionInWindow(layoutCoordinates)) : null;
        if (kotlin.jvm.internal.k.b(this.previousPosition, offsetM3884boximpl)) {
            return;
        }
        this.previousPosition = offsetM3884boximpl;
        updateHandleOffsets();
        updateSelectionToolbar();
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setHasFocus(boolean z10) {
        this.hasFocus.setValue(Boolean.valueOf(z10));
    }

    public final void setInTouchMode(boolean z10) {
        if (this._isInTouchMode.getValue().booleanValue() != z10) {
            this._isInTouchMode.setValue(Boolean.valueOf(z10));
            updateSelectionToolbar();
        }
    }

    public final void setOnSelectionChange(final k kVar) {
        this.onSelectionChange = new k() { // from class: androidx.compose.foundation.text.selection.SelectionManager$onSelectionChange$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Selection) obj);
                return r.f317a;
            }

            public final void invoke(Selection selection) {
                this.this$0.setSelection(selection);
                kVar.invoke(selection);
            }
        };
    }

    public final void setPreviousSelectionLayout$foundation_release(SelectionLayout selectionLayout) {
        this.previousSelectionLayout = selectionLayout;
    }

    public final void setSelection(Selection selection) {
        this._selection.setValue(selection);
        if (selection != null) {
            updateHandleOffsets();
        }
    }

    public final void setShowToolbar$foundation_release(boolean z10) {
        this.showToolbar = z10;
        updateSelectionToolbar();
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    @VisibleForTesting
    public final boolean shouldPerformHaptics$foundation_release() {
        if (isInTouchMode()) {
            List<Selectable> selectables$foundation_release = this.selectionRegistrar.getSelectables$foundation_release();
            int size = selectables$foundation_release.size();
            for (int i = 0; i < size; i++) {
                if (selectables$foundation_release.get(i).getText().length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: updateSelection-jyLRC_s$foundation_release, reason: not valid java name */
    public final boolean m1421updateSelectionjyLRC_s$foundation_release(long position, long previousHandlePosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
        m1409setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(position));
        SelectionLayout selectionLayoutM1408getSelectionLayoutWko1d7g = m1408getSelectionLayoutWko1d7g(position, previousHandlePosition, isStartHandle);
        if (!selectionLayoutM1408getSelectionLayoutWko1d7g.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return false;
        }
        Selection selectionAdjust = adjustment.adjust(selectionLayoutM1408getSelectionLayoutWko1d7g);
        if (!kotlin.jvm.internal.k.b(selectionAdjust, getSelection())) {
            selectionChanged(selectionLayoutM1408getSelectionLayoutWko1d7g, selectionAdjust);
        }
        this.previousSelectionLayout = selectionLayoutM1408getSelectionLayoutWko1d7g;
        return true;
    }

    /* renamed from: updateSelection-qNKwrvQ$foundation_release, reason: not valid java name */
    public final boolean m1422updateSelectionqNKwrvQ$foundation_release(Offset newPosition, long previousPosition, boolean isStartHandle, SelectionAdjustment adjustment) {
        if (newPosition == null) {
            return false;
        }
        return m1421updateSelectionjyLRC_s$foundation_release(newPosition.m3905unboximpl(), previousPosition, isStartHandle, adjustment);
    }
}
