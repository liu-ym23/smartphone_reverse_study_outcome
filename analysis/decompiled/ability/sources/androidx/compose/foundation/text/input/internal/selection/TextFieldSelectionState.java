package androidx.compose.foundation.text.input.internal.selection;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text.input.internal.IndexTransformationType;
import androidx.compose.foundation.text.input.internal.MathUtilsKt;
import androidx.compose.foundation.text.input.internal.SelectionWedgeAffinity;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TextLayoutStateKt;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.WedgeAffinity;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SelectionLayout;
import androidx.compose.foundation.text.selection.SelectionLayoutKt;
import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.foundation.text.selection.TextSelectionDelegateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.CoroutineStart;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;
import p9.d;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0006¾\u0001¿\u0001À\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010!\u001a\u00020\u001d*\u00020 H\u0086@¢\u0006\u0004\b!\u0010\"J\u001c\u0010$\u001a\u00020\u001d*\u00020 2\u0006\u0010#\u001a\u00020\bH\u0086@¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b&\u0010'J\u0015\u0010*\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u001d¢\u0006\u0004\b,\u0010-J\u0014\u0010.\u001a\u00020\u001d*\u00020 H\u0086@¢\u0006\u0004\b.\u0010\"J:\u00104\u001a\u00020\u001d*\u00020 2\b\u00100\u001a\u0004\u0018\u00010/2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d01H\u0086@¢\u0006\u0004\b4\u00105J\"\u00106\u001a\u00020\u001d*\u00020 2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d01H\u0086@¢\u0006\u0004\b6\u00107J\u001f\u0010:\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0004\b8\u00109J \u0010A\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\r\u0010B\u001a\u00020\u001d¢\u0006\u0004\bB\u0010-J\r\u0010C\u001a\u00020\b¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u001d¢\u0006\u0004\bE\u0010-J\r\u0010F\u001a\u00020\b¢\u0006\u0004\bF\u0010DJ\u0017\u0010H\u001a\u00020\u001d2\b\b\u0002\u0010G\u001a\u00020\b¢\u0006\u0004\bH\u0010IJ\r\u0010J\u001a\u00020\b¢\u0006\u0004\bJ\u0010DJ\r\u0010K\u001a\u00020\u001d¢\u0006\u0004\bK\u0010-J\r\u0010L\u001a\u00020\b¢\u0006\u0004\bL\u0010DJ\r\u0010M\u001a\u00020\u001d¢\u0006\u0004\bM\u0010-J\r\u0010N\u001a\u00020\u001d¢\u0006\u0004\bN\u0010-J\u000f\u0010O\u001a\u00020\bH\u0002¢\u0006\u0004\bO\u0010DJ\u001a\u0010S\u001a\u00020\b2\u0006\u0010P\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\u0014\u0010T\u001a\u00020\u001d*\u00020 H\u0082@¢\u0006\u0004\bT\u0010\"J\u001c\u0010U\u001a\u00020\u001d*\u00020 2\u0006\u0010#\u001a\u00020\bH\u0082@¢\u0006\u0004\bU\u0010%J\u0010\u0010V\u001a\u00020\u001dH\u0082@¢\u0006\u0004\bV\u0010'J\u0010\u0010W\u001a\u00020\u001dH\u0082@¢\u0006\u0004\bW\u0010'J\u000f\u0010X\u001a\u00020\u0014H\u0002¢\u0006\u0004\bX\u0010\u0016J\u001d\u0010[\u001a\u00020=2\u0006\u0010#\u001a\u00020\bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\\\u0010-J\u000f\u0010]\u001a\u00020\u001dH\u0002¢\u0006\u0004\b]\u0010-J\u0017\u0010_\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u0014H\u0002¢\u0006\u0004\b_\u0010`J8\u0010c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u0001012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010a\u001a\u00020(2\u000e\b\u0004\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001d01H\u0082\b¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u001dH\u0002¢\u0006\u0004\be\u0010-JQ\u0010r\u001a\u00020o2\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020h2\u0006\u0010j\u001a\u00020h2\u0006\u0010#\u001a\u00020\b2\u0006\u0010l\u001a\u00020k2\b\b\u0002\u0010m\u001a\u00020\b2\b\b\u0002\u0010n\u001a\u00020\bH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ<\u0010x\u001a\u00020o2\u0006\u0010s\u001a\u00020h2\u0006\u0010t\u001a\u00020h2\b\u0010u\u001a\u0004\u0018\u00010o2\u0006\u0010#\u001a\u00020\b2\u0006\u0010l\u001a\u00020kH\u0002ø\u0001\u0000¢\u0006\u0004\bv\u0010wR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010yR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010zR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010{R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010|R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010|R\"\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010|\u001a\u0004\b\u000b\u0010D\"\u0004\b}\u0010IR\u0016\u0010\f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010|R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010~R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u007fR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010\u0080\u0001R1\u0010\u0084\u0001\u001a\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\b8F@FX\u0086\u008e\u0002¢\u0006\u0016\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010D\"\u0005\b\u0085\u0001\u0010IR4\u0010\u0087\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u0086\u0001\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R9\u0010\u0092\u0001\u001a\u00020=2\u0007\u0010\u0081\u0001\u001a\u00020=8B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u0083\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R9\u0010\u0096\u0001\u001a\u00020=2\u0007\u0010\u0081\u0001\u001a\u00020=8B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0083\u0001\u001a\u0006\b\u0094\u0001\u0010\u008f\u0001\"\u0006\b\u0095\u0001\u0010\u0091\u0001R7\u0010\u009c\u0001\u001a\u0004\u0018\u00010;2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010;8F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b\u0097\u0001\u0010\u0083\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R5\u0010£\u0001\u001a\u00030\u009d\u00012\b\u0010\u0081\u0001\u001a\u00030\u009d\u00018F@FX\u0086\u008e\u0002¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u0083\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R1\u0010§\u0001\u001a\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\b8B@BX\u0082\u008e\u0002¢\u0006\u0016\n\u0006\b¤\u0001\u0010\u0083\u0001\u001a\u0005\b¥\u0001\u0010D\"\u0005\b¦\u0001\u0010IR1\u0010)\u001a\u00020(2\u0007\u0010\u0081\u0001\u001a\u00020(8B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0006\b¨\u0001\u0010\u0083\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0005\b«\u0001\u0010+R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u00ad\u0001\u0010®\u0001R\u0019\u0010¯\u0001\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001a\u0010µ\u0001\u001a\u00020=8Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b´\u0001\u0010\u008f\u0001R\u001d\u0010·\u0001\u001a\u00020=8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b¶\u0001\u0010\u008f\u0001R\u001a\u0010»\u0001\u001a\u0005\u0018\u00010¸\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¹\u0001\u0010º\u0001R\u0016\u0010½\u0001\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010D\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Á\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textLayoutState", "Landroidx/compose/ui/unit/Density;", "density", "", "enabled", "readOnly", "isFocused", "isPassword", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/unit/Density;ZZZZ)V", "includePosition", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getCursorHandleState$foundation_release", "(Z)Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getCursorHandleState", "Landroidx/compose/ui/geometry/Rect;", "getCursorRect", "()Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "LC7/r;", "update", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;Landroidx/compose/ui/platform/ClipboardManager;Landroidx/compose/ui/platform/TextToolbar;Landroidx/compose/ui/unit/Density;ZZZ)V", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "cursorHandleGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;LH7/c;)Ljava/lang/Object;", "isStartHandle", "selectionHandleGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLH7/c;)Ljava/lang/Object;", "observeChanges", "(LH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "textToolbarState", "updateTextToolbarState", "(Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;)V", "dispose", "()V", "detectTouchMode", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Lkotlin/Function0;", "requestFocus", "showKeyboard", "detectTextFieldTapGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/interaction/MutableInteractionSource;LS7/a;LS7/a;LH7/c;)Ljava/lang/Object;", "textFieldSelectionGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;LS7/a;LH7/c;)Ljava/lang/Object;", "getSelectionHandleState$foundation_release", "(ZZ)Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "getSelectionHandleState", "Landroidx/compose/foundation/text/Handle;", "handle", "Landroidx/compose/ui/geometry/Offset;", "position", "updateHandleDragging-Uv8p0NA", "(Landroidx/compose/foundation/text/Handle;J)V", "updateHandleDragging", "clearHandleDragging", "canCut", "()Z", "cut", "canCopy", "cancelSelection", "copy", "(Z)V", "canPaste", "paste", "canSelectAll", "selectAll", "deselect", "isCursorHandleInVisibleBounds", TypedValues.CycleType.S_WAVE_OFFSET, "placeCursorAtNearestOffset-k-4lQ0M", "(J)Z", "placeCursorAtNearestOffset", "detectCursorHandleDragGestures", "detectSelectionHandleDragGestures", "observeTextChanges", "observeTextToolbarVisibility", "getContentRect", "getHandlePosition-tuRUvjQ", "(Z)J", "getHandlePosition", "markStartContentVisibleOffset", "pasteAsPlainText", "contentRect", "showTextToolbar", "(Landroidx/compose/ui/geometry/Rect;)V", "desiredState", "operation", "menuItem", "(ZLandroidx/compose/foundation/text/input/internal/selection/TextToolbarState;LS7/a;)LS7/a;", "hideTextToolbar", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "textFieldCharSequence", "", "startOffset", "endOffset", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjustment", "allowPreviousSelectionCollapsed", "isStartOfSelection", "Landroidx/compose/ui/text/TextRange;", "updateSelection-SsL-Rf8", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;IIZLandroidx/compose/foundation/text/selection/SelectionAdjustment;ZZ)J", "updateSelection", "rawStartOffset", "rawEndOffset", "previousSelection", "getTextFieldSelection-qeG_v_k", "(IILandroidx/compose/ui/text/TextRange;ZLandroidx/compose/foundation/text/selection/SelectionAdjustment;)J", "getTextFieldSelection", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "Landroidx/compose/ui/unit/Density;", "Z", "setFocused", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "Landroidx/compose/ui/platform/TextToolbar;", "Landroidx/compose/ui/platform/ClipboardManager;", "<set-?>", "isInTouchMode$delegate", "Landroidx/compose/runtime/MutableState;", "isInTouchMode", "setInTouchMode", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentConfiguration", "LS7/a;", "getReceiveContentConfiguration", "()LS7/a;", "setReceiveContentConfiguration", "(LS7/a;)V", "startTextLayoutPositionInWindow$delegate", "getStartTextLayoutPositionInWindow-F1C5BW0", "()J", "setStartTextLayoutPositionInWindow-k-4lQ0M", "(J)V", "startTextLayoutPositionInWindow", "rawHandleDragPosition$delegate", "getRawHandleDragPosition-F1C5BW0", "setRawHandleDragPosition-k-4lQ0M", "rawHandleDragPosition", "draggingHandle$delegate", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "directDragGestureInitiator$delegate", "getDirectDragGestureInitiator", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "setDirectDragGestureInitiator", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;)V", "directDragGestureInitiator", "showCursorHandle$delegate", "getShowCursorHandle", "setShowCursorHandle", "showCursorHandle", "textToolbarState$delegate", "getTextToolbarState", "()Landroidx/compose/foundation/text/input/internal/selection/TextToolbarState;", "setTextToolbarState", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousRawDragOffset", "I", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "pressInteraction", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "getHandleDragPosition-F1C5BW0", "handleDragPosition", "getCurrentTextLayoutPositionInWindow-F1C5BW0", "currentTextLayoutPositionInWindow", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getTextLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "textLayoutCoordinates", "getEditable", "editable", "InputType", "TextFieldMouseSelectionObserver", "TextFieldTextDragObserver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionState {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;
    private Density density;

    /* renamed from: directDragGestureInitiator$delegate, reason: from kotlin metadata */
    private final MutableState directDragGestureInitiator;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;
    private boolean enabled;
    private HapticFeedback hapticFeedBack;
    private boolean isFocused;

    /* renamed from: isInTouchMode$delegate, reason: from kotlin metadata */
    private final MutableState isInTouchMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    private boolean isPassword;
    private PressInteraction.Press pressInteraction;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;

    /* renamed from: rawHandleDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState rawHandleDragPosition;
    private boolean readOnly;
    private a receiveContentConfiguration;

    /* renamed from: showCursorHandle$delegate, reason: from kotlin metadata */
    private final MutableState showCursorHandle;

    /* renamed from: startTextLayoutPositionInWindow$delegate, reason: from kotlin metadata */
    private final MutableState startTextLayoutPositionInWindow;
    private final TransformedTextFieldState textFieldState;
    private final TextLayoutState textLayoutState;
    private TextToolbar textToolbar;

    /* renamed from: textToolbarState$delegate, reason: from kotlin metadata */
    private final MutableState textToolbarState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$InputType;", "", "(Ljava/lang/String;I)V", "None", "Touch", "Mouse", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum InputType {
        None,
        Touch,
        Mouse
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u0010\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldMouseSelectionObserver;", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "Lkotlin/Function0;", "LC7/r;", "requestFocus", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;LS7/a;)V", "Landroidx/compose/ui/geometry/Offset;", "dragPosition", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjustment", "", "isStartOfSelection", "Landroidx/compose/ui/text/TextRange;", "updateSelection-r1Wruf4", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateSelection", "downPosition", "onStart-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onStart", "onDrag-3MmeM6k", "onDrag", "onDragDone", "()V", "onExtend-k-4lQ0M", "(J)Z", "onExtend", "onExtendDrag-k-4lQ0M", "onExtendDrag", "LS7/a;", "", "dragBeginOffsetInText", "I", "dragBeginPosition", "J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class TextFieldMouseSelectionObserver implements MouseSelectionObserver {
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition = Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
        private final a requestFocus;

        public TextFieldMouseSelectionObserver(a aVar) {
            this.requestFocus = aVar;
        }

        /* renamed from: updateSelection-r1Wruf4, reason: not valid java name */
        private final long m1310updateSelectionr1Wruf4(long dragPosition, SelectionAdjustment adjustment, boolean isStartOfSelection) {
            Integer numValueOf = Integer.valueOf(this.dragBeginOffsetInText);
            if (numValueOf.intValue() < 0) {
                numValueOf = null;
            }
            int iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1251getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
            int iM1251getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1251getOffsetForPosition3MmeM6k(dragPosition, false);
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jM1302updateSelectionSsLRf8 = textFieldSelectionState.m1302updateSelectionSsLRf8(textFieldSelectionState.textFieldState.getVisualText(), iIntValue, iM1251getOffsetForPosition3MmeM6k, false, adjustment, false, isStartOfSelection);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6305getCollapsedimpl(jM1302updateSelectionSsLRf8)) {
                this.dragBeginOffsetInText = TextRange.m6311getStartimpl(jM1302updateSelectionSsLRf8);
            }
            if (TextRange.m6310getReversedimpl(jM1302updateSelectionSsLRf8)) {
                jM1302updateSelectionSsLRf8 = TextFieldSelectionStateKt.m1329reverse5zctL8(jM1302updateSelectionSsLRf8);
            }
            TextFieldSelectionState.this.textFieldState.m1268selectCharsIn5zctL8(jM1302updateSelectionSsLRf8);
            TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            return jM1302updateSelectionSsLRf8;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onDrag-3MmeM6k, reason: not valid java name */
        public boolean mo1311onDrag3MmeM6k(final long dragPosition, SelectionAdjustment adjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final String invoke() {
                    return "Mouse.onDrag " + ((Object) Offset.m3903toStringimpl(dragPosition));
                }
            });
            m1310updateSelectionr1Wruf4(dragPosition, adjustment, false);
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        public void onDragDone() {
            TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onDragDone$1
                @Override // S7.a
                public final String invoke() {
                    return "Mouse.onDragDone";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtend-k-4lQ0M, reason: not valid java name */
        public boolean mo1312onExtendk4lQ0M(long downPosition) {
            TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtend$1
                @Override // S7.a
                public final String invoke() {
                    return "Mouse.onExtend";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onExtendDrag-k-4lQ0M, reason: not valid java name */
        public boolean mo1313onExtendDragk4lQ0M(long dragPosition) {
            TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onExtendDrag$1
                @Override // S7.a
                public final String invoke() {
                    return "Mouse.onExtendDrag";
                }
            });
            return true;
        }

        @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
        /* renamed from: onStart-3MmeM6k, reason: not valid java name */
        public boolean mo1314onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return false;
            }
            TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldMouseSelectionObserver$onStart$1
                @Override // S7.a
                public final String invoke() {
                    return "Mouse.onStart";
                }
            });
            TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Mouse);
            this.requestFocus.invoke();
            TextFieldSelectionState.this.previousRawDragOffset = -1;
            this.dragBeginOffsetInText = -1;
            this.dragBeginPosition = downPosition;
            this.dragBeginOffsetInText = TextRange.m6311getStartimpl(m1310updateSelectionr1Wruf4(downPosition, adjustment, true));
            return true;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\fJ\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState$TextFieldTextDragObserver;", "Landroidx/compose/foundation/text/TextDragObserver;", "Lkotlin/Function0;", "LC7/r;", "requestFocus", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;LS7/a;)V", "onDragStop", "()V", "Landroidx/compose/ui/geometry/Offset;", "point", "onDown-k-4lQ0M", "(J)V", "onDown", "onUp", "onStop", "onCancel", "startPoint", "onStart-k-4lQ0M", "onStart", "delta", "onDrag-k-4lQ0M", "onDrag", "LS7/a;", "", "dragBeginOffsetInText", "I", "dragBeginPosition", "J", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "actingHandle", "Landroidx/compose/foundation/text/Handle;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class TextFieldTextDragObserver implements TextDragObserver {
        private Handle actingHandle;
        private int dragBeginOffsetInText = -1;
        private long dragBeginPosition;
        private long dragTotalDistance;
        private final a requestFocus;

        public TextFieldTextDragObserver(a aVar) {
            this.requestFocus = aVar;
            Offset.Companion companion = Offset.INSTANCE;
            this.dragBeginPosition = companion.m3910getUnspecifiedF1C5BW0();
            this.dragTotalDistance = companion.m3911getZeroF1C5BW0();
            this.actingHandle = Handle.SelectionEnd;
        }

        private final void onDragStop() {
            if (OffsetKt.m3914isSpecifiedk4lQ0M(this.dragBeginPosition)) {
                TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDragStop$1
                    @Override // S7.a
                    public final String invoke() {
                        return "Touch.onDragStop";
                    }
                });
                TextFieldSelectionState.this.clearHandleDragging();
                this.dragBeginOffsetInText = -1;
                Offset.Companion companion = Offset.INSTANCE;
                this.dragBeginPosition = companion.m3910getUnspecifiedF1C5BW0();
                this.dragTotalDistance = companion.m3911getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.None);
                this.requestFocus.invoke();
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onCancel() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDown-k-4lQ0M */
        public void mo1091onDownk4lQ0M(long point) {
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onDrag-k-4lQ0M */
        public void mo1092onDragk4lQ0M(long delta) {
            int iIntValue;
            int iM1251getOffsetForPosition3MmeM6k;
            SelectionAdjustment word;
            Handle handle;
            if (!TextFieldSelectionState.this.enabled || TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                return;
            }
            long jM3900plusMKHz9U = Offset.m3900plusMKHz9U(this.dragTotalDistance, delta);
            this.dragTotalDistance = jM3900plusMKHz9U;
            final long jM3900plusMKHz9U2 = Offset.m3900plusMKHz9U(this.dragBeginPosition, jM3900plusMKHz9U);
            TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onDrag$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final String invoke() {
                    return "Touch.onDrag at " + ((Object) Offset.m3903toStringimpl(jM3900plusMKHz9U2));
                }
            });
            if (this.dragBeginOffsetInText >= 0 || TextFieldSelectionState.this.textLayoutState.m1252isPositionOnTextk4lQ0M(jM3900plusMKHz9U2)) {
                Integer numValueOf = Integer.valueOf(this.dragBeginOffsetInText);
                if (numValueOf.intValue() < 0) {
                    numValueOf = null;
                }
                iIntValue = numValueOf != null ? numValueOf.intValue() : TextFieldSelectionState.this.textLayoutState.m1251getOffsetForPosition3MmeM6k(this.dragBeginPosition, false);
                iM1251getOffsetForPosition3MmeM6k = TextFieldSelectionState.this.textLayoutState.m1251getOffsetForPosition3MmeM6k(jM3900plusMKHz9U2, false);
                if (this.dragBeginOffsetInText < 0 && iIntValue == iM1251getOffsetForPosition3MmeM6k) {
                    return;
                }
                word = SelectionAdjustment.INSTANCE.getWord();
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
            } else {
                iIntValue = TextLayoutState.m1248getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, this.dragBeginPosition, false, 2, null);
                iM1251getOffsetForPosition3MmeM6k = TextLayoutState.m1248getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, jM3900plusMKHz9U2, false, 2, null);
                word = iIntValue == iM1251getOffsetForPosition3MmeM6k ? SelectionAdjustment.INSTANCE.getNone() : SelectionAdjustment.INSTANCE.getWord();
            }
            int i = iIntValue;
            int i6 = iM1251getOffsetForPosition3MmeM6k;
            SelectionAdjustment selectionAdjustment = word;
            long selection = TextFieldSelectionState.this.textFieldState.getVisualText().getSelection();
            TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
            long jM1303updateSelectionSsLRf8$default = TextFieldSelectionState.m1303updateSelectionSsLRf8$default(textFieldSelectionState, textFieldSelectionState.textFieldState.getVisualText(), i, i6, false, selectionAdjustment, false, false, 64, null);
            if (this.dragBeginOffsetInText == -1 && !TextRange.m6305getCollapsedimpl(jM1303updateSelectionSsLRf8$default)) {
                this.dragBeginOffsetInText = TextRange.m6311getStartimpl(jM1303updateSelectionSsLRf8$default);
            }
            if (TextRange.m6310getReversedimpl(jM1303updateSelectionSsLRf8$default)) {
                jM1303updateSelectionSsLRf8$default = TextFieldSelectionStateKt.m1329reverse5zctL8(jM1303updateSelectionSsLRf8$default);
            }
            if (!TextRange.m6304equalsimpl0(jM1303updateSelectionSsLRf8$default, selection)) {
                if (TextRange.m6311getStartimpl(jM1303updateSelectionSsLRf8$default) != TextRange.m6311getStartimpl(selection) && TextRange.m6306getEndimpl(jM1303updateSelectionSsLRf8$default) == TextRange.m6306getEndimpl(selection)) {
                    handle = Handle.SelectionStart;
                } else if (TextRange.m6311getStartimpl(jM1303updateSelectionSsLRf8$default) != TextRange.m6311getStartimpl(selection) || TextRange.m6306getEndimpl(jM1303updateSelectionSsLRf8$default) == TextRange.m6306getEndimpl(selection)) {
                    handle = ((float) (TextRange.m6306getEndimpl(jM1303updateSelectionSsLRf8$default) + TextRange.m6311getStartimpl(jM1303updateSelectionSsLRf8$default))) / 2.0f > ((float) (TextRange.m6306getEndimpl(selection) + TextRange.m6311getStartimpl(selection))) / 2.0f ? Handle.SelectionEnd : Handle.SelectionStart;
                } else {
                    handle = Handle.SelectionEnd;
                }
                this.actingHandle = handle;
            }
            if (TextRange.m6305getCollapsedimpl(selection) || !TextRange.m6305getCollapsedimpl(jM1303updateSelectionSsLRf8$default)) {
                TextFieldSelectionState.this.textFieldState.m1268selectCharsIn5zctL8(jM1303updateSelectionSsLRf8$default);
            }
            TextFieldSelectionState.this.m1305updateHandleDraggingUv8p0NA(this.actingHandle, jM3900plusMKHz9U2);
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        /* renamed from: onStart-k-4lQ0M */
        public void mo1093onStartk4lQ0M(final long startPoint) {
            if (TextFieldSelectionState.this.enabled) {
                TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$TextFieldTextDragObserver$onStart$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final String invoke() {
                        return "Touch.onDragStart after longPress at " + ((Object) Offset.m3903toStringimpl(startPoint));
                    }
                });
                TextFieldSelectionState.this.m1305updateHandleDraggingUv8p0NA(this.actingHandle, startPoint);
                TextFieldSelectionState.this.setShowCursorHandle(false);
                TextFieldSelectionState.this.setDirectDragGestureInitiator(InputType.Touch);
                this.dragBeginPosition = startPoint;
                this.dragTotalDistance = Offset.INSTANCE.m3911getZeroF1C5BW0();
                TextFieldSelectionState.this.previousRawDragOffset = -1;
                if (!TextFieldSelectionState.this.textLayoutState.m1252isPositionOnTextk4lQ0M(startPoint)) {
                    int iM1248getOffsetForPosition3MmeM6k$default = TextLayoutState.m1248getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, startPoint, false, 2, null);
                    HapticFeedback hapticFeedback = TextFieldSelectionState.this.hapticFeedBack;
                    if (hapticFeedback != null) {
                        hapticFeedback.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
                    }
                    TextFieldSelectionState.this.textFieldState.placeCursorBeforeCharAt(iM1248getOffsetForPosition3MmeM6k$default);
                    TextFieldSelectionState.this.setShowCursorHandle(true);
                    TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Cursor);
                    return;
                }
                if (TextFieldSelectionState.this.textFieldState.getVisualText().length() == 0) {
                    return;
                }
                int iM1248getOffsetForPosition3MmeM6k$default2 = TextLayoutState.m1248getOffsetForPosition3MmeM6k$default(TextFieldSelectionState.this.textLayoutState, startPoint, false, 2, null);
                TextFieldSelectionState textFieldSelectionState = TextFieldSelectionState.this;
                long jM1303updateSelectionSsLRf8$default = TextFieldSelectionState.m1303updateSelectionSsLRf8$default(textFieldSelectionState, new TextFieldCharSequence(textFieldSelectionState.textFieldState.getVisualText(), TextRange.INSTANCE.m6316getZerod9O1mEE(), null, null, 12, null), iM1248getOffsetForPosition3MmeM6k$default2, iM1248getOffsetForPosition3MmeM6k$default2, false, SelectionAdjustment.INSTANCE.getWord(), false, false, 96, null);
                TextFieldSelectionState.this.textFieldState.m1268selectCharsIn5zctL8(jM1303updateSelectionSsLRf8$default);
                TextFieldSelectionState.this.updateTextToolbarState(TextToolbarState.Selection);
                this.dragBeginOffsetInText = TextRange.m6311getStartimpl(jM1303updateSelectionSsLRf8$default);
            }
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onStop() {
            onDragStop();
        }

        @Override // androidx.compose.foundation.text.TextDragObserver
        public void onUp() {
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IndexTransformationType.values().length];
            try {
                iArr[IndexTransformationType.Untransformed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexTransformationType.Deletion.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexTransformationType.Insertion.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexTransformationType.Replacement.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", f = "TextFieldSelectionState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lm9/c0;", "<anonymous>", "(Lm9/z;)Lm9/c0;"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", f = "TextFieldSelectionState.kt", l = {368}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$this_cursorHandleGestures, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    this.label = 1;
                    if (textFieldSelectionState.detectTouchMode(pointerInputScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", f = "TextFieldSelectionState.kt", l = {371}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00562 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00562(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, H7.c<? super C00562> cVar) {
                super(2, cVar);
                this.this$0 = textFieldSelectionState;
                this.$this_cursorHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C00562(this.this$0, this.$this_cursorHandleGestures, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    this.label = 1;
                    if (textFieldSelectionState.detectCursorHandleDragGestures(pointerInputScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00562) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", f = "TextFieldSelectionState.kt", l = {374}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, H7.c<? super AnonymousClass3> cVar) {
                super(2, cVar);
                this.$this_cursorHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass3(this.$this_cursorHandleGestures, this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0;
                    k kVar = new k() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.cursorHandleGestures.2.3.1
                        {
                            super(1);
                        }

                        @Override // S7.k
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            m1315invokek4lQ0M(((Offset) obj2).m3905unboximpl());
                            return r.f317a;
                        }

                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m1315invokek4lQ0M(long j5) {
                            TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                            TextToolbarState textToolbarState = textFieldSelectionState2.getTextToolbarState();
                            TextToolbarState textToolbarState2 = TextToolbarState.Cursor;
                            if (textToolbarState == textToolbarState2) {
                                textToolbarState2 = TextToolbarState.None;
                            }
                            textFieldSelectionState2.setTextToolbarState(textToolbarState2);
                        }
                    };
                    this.label = 1;
                    if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, kVar, this, 7, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PointerInputScope pointerInputScope, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = TextFieldSelectionState.this.new AnonymousClass2(this.$this_cursorHandleGestures, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            CoroutineStart coroutineStart = CoroutineStart.f5175a;
            AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1);
            AbstractC1683A.n(interfaceC1733z, null, new C00562(TextFieldSelectionState.this, this.$this_cursorHandleGestures, null), 1);
            return AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass3(this.$this_cursorHandleGestures, TextFieldSelectionState.this, null), 1);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super c0> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", l = {614}, m = "detectCursorHandleDragGestures")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectCursorHandleDragGestures(null, this);
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", l = {980}, m = "detectSelectionHandleDragGestures")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectSelectionHandleDragGestures$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C05061(H7.c<? super C05061> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.detectSelectionHandleDragGestures(null, false, this);
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2", f = "TextFieldSelectionState.kt", l = {491}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/PressGestureScope;Landroidx/compose/ui/geometry/Offset;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05112 extends SuspendLambda implements o {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05112(MutableInteractionSource mutableInteractionSource, TextFieldSelectionState textFieldSelectionState, H7.c<? super C05112> cVar) {
            super(3, cVar);
            this.$interactionSource = mutableInteractionSource;
            this.this$0 = textFieldSelectionState;
        }

        @Override // S7.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m1324invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m3905unboximpl(), (H7.c) obj3);
        }

        /* renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m1324invoked4ec7I(PressGestureScope pressGestureScope, long j5, H7.c<? super r> cVar) {
            C05112 c05112 = new C05112(this.$interactionSource, this.this$0, cVar);
            c05112.L$0 = pressGestureScope;
            c05112.J$0 = j5;
            return c05112.invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j5 = this.J$0;
                MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                if (mutableInteractionSource != null) {
                    TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(pressGestureScope, this.this$0, j5, mutableInteractionSource, null);
                    this.label = 1;
                    if (AbstractC1683A.f(textFieldSelectionState$detectTextFieldTapGestures$2$1$1, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", f = "TextFieldSelectionState.kt", l = {455}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05132 extends RestrictedSuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        public C05132(H7.c<? super C05132> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C05132 c05132 = TextFieldSelectionState.this.new C05132(cVar);
            c05132.L$0 = obj;
            return c05132;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((C05132) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:11:0x002d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:12:0x002e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r4.label
                r2 = 1
                if (r1 == 0) goto L19
                if (r1 != r2) goto L11
                java.lang.Object r1 = r4.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.b.b(r5)
                goto L2e
            L11:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L19:
                kotlin.b.b(r5)
                java.lang.Object r5 = r4.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                r1 = r5
            L21:
                androidx.compose.ui.input.pointer.PointerEventPass r5 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                r4.L$0 = r1
                r4.label = r2
                java.lang.Object r5 = r1.awaitPointerEvent(r5, r4)
                if (r5 != r0) goto L2e
                return r0
            L2e:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r3 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.this
                boolean r5 = androidx.compose.foundation.text.selection.SelectionGesturesKt.isPrecisePointer(r5)
                r5 = r5 ^ r2
                r3.setInTouchMode(r5)
                goto L21
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C05132.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", l = {TypedValues.CycleType.TYPE_WAVE_PERIOD}, m = "observeChanges")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05151 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C05151(H7.c<? super C05151> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TextFieldSelectionState.this.observeChanges(this);
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2", f = "TextFieldSelectionState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lm9/c0;", "<anonymous>", "(Lm9/z;)Lm9/c0;"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05162 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$1", f = "TextFieldSelectionState.kt", l = {TypedValues.CycleType.TYPE_WAVE_OFFSET}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    this.label = 1;
                    if (textFieldSelectionState.observeTextChanges(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$2", f = "TextFieldSelectionState.kt", l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00572 extends SuspendLambda implements n {
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00572(TextFieldSelectionState textFieldSelectionState, H7.c<? super C00572> cVar) {
                super(2, cVar);
                this.this$0 = textFieldSelectionState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C00572(this.this$0, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    this.label = 1;
                    if (textFieldSelectionState.observeTextToolbarVisibility(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00572) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public C05162(H7.c<? super C05162> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C05162 c05162 = TextFieldSelectionState.this.new C05162(cVar);
            c05162.L$0 = obj;
            return c05162;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(TextFieldSelectionState.this, null), 3);
            return AbstractC1683A.n(interfaceC1733z, null, new C00572(TextFieldSelectionState.this, null), 3);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super c0> cVar) {
            return ((C05162) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$3, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C05183 extends FunctionReferenceImpl implements n {
        public static final C05183 INSTANCE = new C05183();

        public C05183() {
            super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
        }

        @Override // S7.n
        public final Boolean invoke(TextFieldCharSequence textFieldCharSequence, CharSequence charSequence) {
            return Boolean.valueOf(textFieldCharSequence.contentEquals(charSequence));
        }
    }

    @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2", f = "TextFieldSelectionState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lm9/c0;", "<anonymous>", "(Lm9/z;)Lm9/c0;"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05222 extends SuspendLambda implements n {
        final /* synthetic */ boolean $isStartHandle;
        final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1", f = "TextFieldSelectionState.kt", l = {391}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$this_selectionHandleGestures, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    this.label = 1;
                    if (textFieldSelectionState.detectTouchMode(pointerInputScope, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2", f = "TextFieldSelectionState.kt", l = {394}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00582 extends SuspendLambda implements n {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00582(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, boolean z10, H7.c<? super C00582> cVar) {
                super(2, cVar);
                this.$this_selectionHandleGestures = pointerInputScope;
                this.this$0 = textFieldSelectionState;
                this.$isStartHandle = z10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C00582(this.$this_selectionHandleGestures, this.this$0, this.$isStartHandle, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    final TextFieldSelectionState textFieldSelectionState = this.this$0;
                    final boolean z10 = this.$isStartHandle;
                    TapOnPosition tapOnPosition = new TapOnPosition() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.1
                        @Override // androidx.compose.foundation.text.input.internal.selection.TapOnPosition
                        /* renamed from: onEvent-k-4lQ0M */
                        public final void mo1275onEventk4lQ0M(long j5) {
                            textFieldSelectionState.markStartContentVisibleOffset();
                            TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                            boolean z11 = z10;
                            textFieldSelectionState2.m1305updateHandleDraggingUv8p0NA(z11 ? Handle.SelectionStart : Handle.SelectionEnd, SelectionHandlesKt.m1391getAdjustedCoordinatesk4lQ0M(textFieldSelectionState2.m1295getHandlePositiontuRUvjQ(z11)));
                        }
                    };
                    final TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                    a aVar = new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.selectionHandleGestures.2.2.2
                        {
                            super(0);
                        }

                        @Override // S7.a
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1327invoke();
                            return r.f317a;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m1327invoke() {
                            textFieldSelectionState2.clearHandleDragging();
                        }
                    };
                    this.label = 1;
                    if (PressDownGestureKt.detectPressDownGesture(pointerInputScope, tapOnPosition, aVar, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00582) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        @c(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3", f = "TextFieldSelectionState.kt", l = {412}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$selectionHandleGestures$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends SuspendLambda implements n {
            final /* synthetic */ boolean $isStartHandle;
            final /* synthetic */ PointerInputScope $this_selectionHandleGestures;
            int label;
            final /* synthetic */ TextFieldSelectionState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, boolean z10, H7.c<? super AnonymousClass3> cVar) {
                super(2, cVar);
                this.this$0 = textFieldSelectionState;
                this.$this_selectionHandleGestures = pointerInputScope;
                this.$isStartHandle = z10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass3(this.this$0, this.$this_selectionHandleGestures, this.$isStartHandle, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    TextFieldSelectionState textFieldSelectionState = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_selectionHandleGestures;
                    boolean z10 = this.$isStartHandle;
                    this.label = 1;
                    if (textFieldSelectionState.detectSelectionHandleDragGestures(pointerInputScope, z10, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05222(PointerInputScope pointerInputScope, boolean z10, H7.c<? super C05222> cVar) {
            super(2, cVar);
            this.$this_selectionHandleGestures = pointerInputScope;
            this.$isStartHandle = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C05222 c05222 = TextFieldSelectionState.this.new C05222(this.$this_selectionHandleGestures, this.$isStartHandle, cVar);
            c05222.L$0 = obj;
            return c05222;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            CoroutineStart coroutineStart = CoroutineStart.f5175a;
            AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass1(TextFieldSelectionState.this, this.$this_selectionHandleGestures, null), 1);
            AbstractC1683A.n(interfaceC1733z, null, new C00582(this.$this_selectionHandleGestures, TextFieldSelectionState.this, this.$isStartHandle, null), 1);
            return AbstractC1683A.n(interfaceC1733z, null, new AnonymousClass3(TextFieldSelectionState.this, this.$this_selectionHandleGestures, this.$isStartHandle, null), 1);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super c0> cVar) {
            return ((C05222) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public TextFieldSelectionState(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, Density density, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.density = density;
        this.enabled = z10;
        this.readOnly = z11;
        this.isFocused = z12;
        this.isPassword = z13;
        Offset.Companion companion = Offset.INSTANCE;
        this.startTextLayoutPositionInWindow = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3884boximpl(companion.m3910getUnspecifiedF1C5BW0()), null, 2, null);
        this.rawHandleDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3884boximpl(companion.m3910getUnspecifiedF1C5BW0()), null, 2, null);
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.directDragGestureInitiator = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputType.None, null, 2, null);
        this.showCursorHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.textToolbarState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextToolbarState.None, null, 2, null);
        this.previousRawDragOffset = -1;
    }

    public static /* synthetic */ void copy$default(TextFieldSelectionState textFieldSelectionState, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        textFieldSelectionState.copy(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r9, H7.c<? super C7.r> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r10
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.AnonymousClass1) r0
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
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$1
            r0.<init>(r10)
            goto L12
        L1a:
            java.lang.Object r10 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L41
            if (r1 != r2) goto L39
            java.lang.Object r8 = r6.L$2
            kotlin.jvm.internal.Ref$LongRef r8 = (kotlin.jvm.internal.Ref$LongRef) r8
            java.lang.Object r9 = r6.L$1
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref$LongRef) r9
            java.lang.Object r0 = r6.L$0
            r1 = r0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r1 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r1
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L36
            goto L84
        L36:
            r0 = move-exception
            r10 = r0
            goto L91
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            kotlin.b.b(r10)
            kotlin.jvm.internal.Ref$LongRef r10 = new kotlin.jvm.internal.Ref$LongRef
            r10.<init>()
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r3 = r1.m3910getUnspecifiedF1C5BW0()
            r10.f4919a = r3
            kotlin.jvm.internal.Ref$LongRef r7 = new kotlin.jvm.internal.Ref$LongRef
            r7.<init>()
            long r3 = r1.m3910getUnspecifiedF1C5BW0()
            r7.f4919a = r3
            r1 = r2
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2 r2 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$2     // Catch: java.lang.Throwable -> L8a
            r2.<init>()     // Catch: java.lang.Throwable -> L8a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3 r3 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$3     // Catch: java.lang.Throwable -> L8a
            r3.<init>()     // Catch: java.lang.Throwable -> L8a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4 r4 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$4     // Catch: java.lang.Throwable -> L8a
            r4.<init>()     // Catch: java.lang.Throwable -> L8a
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5 r5 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectCursorHandleDragGestures$5     // Catch: java.lang.Throwable -> L8a
            r5.<init>()     // Catch: java.lang.Throwable -> L8a
            r6.L$0 = r8     // Catch: java.lang.Throwable -> L8a
            r6.L$1 = r10     // Catch: java.lang.Throwable -> L8a
            r6.L$2 = r7     // Catch: java.lang.Throwable -> L8a
            r6.label = r1     // Catch: java.lang.Throwable -> L8a
            r1 = r9
            java.lang.Object r9 = androidx.compose.foundation.gestures.DragGestureDetectorKt.detectDragGestures(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L8a
            if (r9 != r0) goto L81
            return r0
        L81:
            r1 = r8
            r9 = r10
            r8 = r7
        L84:
            detectCursorHandleDragGestures$onDragStop(r9, r8, r1)
            C7.r r8 = C7.r.f317a
            return r8
        L8a:
            r0 = move-exception
            r9 = r0
            r1 = r10
            r10 = r9
            r9 = r1
            r1 = r8
            r8 = r7
        L91:
            detectCursorHandleDragGestures$onDragStop(r9, r8, r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectCursorHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectCursorHandleDragGestures$onDragStop(Ref$LongRef ref$LongRef, Ref$LongRef ref$LongRef2, TextFieldSelectionState textFieldSelectionState) {
        if (OffsetKt.m3914isSpecifiedk4lQ0M(ref$LongRef.f4919a)) {
            Offset.Companion companion = Offset.INSTANCE;
            ref$LongRef.f4919a = companion.m3910getUnspecifiedF1C5BW0();
            ref$LongRef2.f4919a = companion.m3910getUnspecifiedF1C5BW0();
            textFieldSelectionState.clearHandleDragging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope r15, final boolean r16, H7.c<? super C7.r> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectSelectionHandleDragGestures(androidx.compose.ui.input.pointer.PointerInputScope, boolean, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detectSelectionHandleDragGestures$onDragStop$5(Ref$LongRef ref$LongRef, TextFieldSelectionState textFieldSelectionState, Ref$LongRef ref$LongRef2) {
        if (OffsetKt.m3914isSpecifiedk4lQ0M(ref$LongRef.f4919a)) {
            textFieldSelectionState.clearHandleDragging();
            Offset.Companion companion = Offset.INSTANCE;
            ref$LongRef.f4919a = companion.m3910getUnspecifiedF1C5BW0();
            ref$LongRef2.f4919a = companion.m3911getZeroF1C5BW0();
            textFieldSelectionState.previousRawDragOffset = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        float fM3896getYimpl;
        Rect cursorRect;
        Rect cursorRect2;
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6305getCollapsedimpl(visualText.getSelection())) {
            Rect cursorRect3 = getCursorRect();
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            return RectKt.m3935Recttz77jQw(textLayoutCoordinates != null ? textLayoutCoordinates.mo5560localToRootMKHz9U(cursorRect3.m3930getTopLeftF1C5BW0()) : Offset.INSTANCE.m3911getZeroF1C5BW0(), cursorRect3.m3928getSizeNHjbRc());
        }
        LayoutCoordinates textLayoutCoordinates2 = getTextLayoutCoordinates();
        long jMo5560localToRootMKHz9U = textLayoutCoordinates2 != null ? textLayoutCoordinates2.mo5560localToRootMKHz9U(m1295getHandlePositiontuRUvjQ(true)) : Offset.INSTANCE.m3911getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates3 = getTextLayoutCoordinates();
        long jMo5560localToRootMKHz9U2 = textLayoutCoordinates3 != null ? textLayoutCoordinates3.mo5560localToRootMKHz9U(m1295getHandlePositiontuRUvjQ(false)) : Offset.INSTANCE.m3911getZeroF1C5BW0();
        LayoutCoordinates textLayoutCoordinates4 = getTextLayoutCoordinates();
        float fM3896getYimpl2 = 0.0f;
        if (textLayoutCoordinates4 != null) {
            TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
            fM3896getYimpl = Offset.m3896getYimpl(textLayoutCoordinates4.mo5560localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (cursorRect2 = layoutResult.getCursorRect(TextRange.m6311getStartimpl(visualText.getSelection()))) == null) ? 0.0f : cursorRect2.getTop())));
        } else {
            fM3896getYimpl = 0.0f;
        }
        LayoutCoordinates textLayoutCoordinates5 = getTextLayoutCoordinates();
        if (textLayoutCoordinates5 != null) {
            TextLayoutResult layoutResult2 = this.textLayoutState.getLayoutResult();
            fM3896getYimpl2 = Offset.m3896getYimpl(textLayoutCoordinates5.mo5560localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (cursorRect = layoutResult2.getCursorRect(TextRange.m6306getEndimpl(visualText.getSelection()))) == null) ? 0.0f : cursorRect.getTop())));
        }
        return new Rect(Math.min(Offset.m3895getXimpl(jMo5560localToRootMKHz9U), Offset.m3895getXimpl(jMo5560localToRootMKHz9U2)), Math.min(fM3896getYimpl, fM3896getYimpl2), Math.max(Offset.m3895getXimpl(jMo5560localToRootMKHz9U), Offset.m3895getXimpl(jMo5560localToRootMKHz9U2)), Math.max(Offset.m3896getYimpl(jMo5560localToRootMKHz9U), Offset.m3896getYimpl(jMo5560localToRootMKHz9U2)));
    }

    /* renamed from: getCurrentTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m1294getCurrentTextLayoutPositionInWindowF1C5BW0() {
        LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
        return textLayoutCoordinates != null ? LayoutCoordinatesKt.positionInWindow(textLayoutCoordinates) : Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
    }

    private final boolean getEditable() {
        return this.enabled && !this.readOnly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getHandlePosition-tuRUvjQ, reason: not valid java name */
    public final long m1295getHandlePositiontuRUvjQ(boolean isStartHandle) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Offset.INSTANCE.m3911getZeroF1C5BW0();
        }
        long selection = this.textFieldState.getVisualText().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(layoutResult, isStartHandle ? TextRange.m6311getStartimpl(selection) : TextRange.m6306getEndimpl(selection), isStartHandle, TextRange.m6310getReversedimpl(selection));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getRawHandleDragPosition-F1C5BW0, reason: not valid java name */
    private final long m1296getRawHandleDragPositionF1C5BW0() {
        return ((Offset) this.rawHandleDragPosition.getValue()).m3905unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getShowCursorHandle() {
        return ((Boolean) this.showCursorHandle.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getStartTextLayoutPositionInWindow-F1C5BW0, reason: not valid java name */
    private final long m1297getStartTextLayoutPositionInWindowF1C5BW0() {
        return ((Offset) this.startTextLayoutPositionInWindow.getValue()).m3905unboximpl();
    }

    /* renamed from: getTextFieldSelection-qeG_v_k, reason: not valid java name */
    private final long m1298getTextFieldSelectionqeG_v_k(int rawStartOffset, int rawEndOffset, TextRange previousSelection, boolean isStartHandle, SelectionAdjustment adjustment) {
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return TextRange.INSTANCE.m6316getZerod9O1mEE();
        }
        if (previousSelection == null && kotlin.jvm.internal.k.b(adjustment, SelectionAdjustment.INSTANCE.getCharacter())) {
            return TextRangeKt.TextRange(rawStartOffset, rawEndOffset);
        }
        SelectionLayout selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1394getTextFieldSelectionLayoutRcvTLA(layoutResult, rawStartOffset, rawEndOffset, this.previousRawDragOffset, previousSelection != null ? previousSelection.getPackedValue() : TextRange.INSTANCE.m6316getZerod9O1mEE(), previousSelection == null, isStartHandle);
        if (previousSelection != null && !selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(this.previousSelectionLayout)) {
            return previousSelection.getPackedValue();
        }
        long jM1383toTextRanged9O1mEE = adjustment.adjust(selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA).m1383toTextRanged9O1mEE();
        this.previousSelectionLayout = selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = isStartHandle ? rawStartOffset : rawEndOffset;
        return jM1383toTextRanged9O1mEE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getTextLayoutCoordinates() {
        LayoutCoordinates textLayoutNodeCoordinates = this.textLayoutState.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates == null || !textLayoutNodeCoordinates.isAttached()) {
            return null;
        }
        return textLayoutNodeCoordinates;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final TextToolbarState getTextToolbarState() {
        return (TextToolbarState) this.textToolbarState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTextToolbar() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    private final boolean isCursorHandleInVisibleBounds() {
        Rect rectVisibleBounds;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            long jM3922getBottomCenterF1C5BW0 = getCursorRect().m3922getBottomCenterF1C5BW0();
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            LayoutCoordinates textLayoutCoordinates = getTextLayoutCoordinates();
            if (textLayoutCoordinates == null || (rectVisibleBounds = SelectionManagerKt.visibleBounds(textLayoutCoordinates)) == null) {
                return false;
            }
            return SelectionManagerKt.m1432containsInclusiveUv8p0NA(rectVisibleBounds, jM3922getBottomCenterF1C5BW0);
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markStartContentVisibleOffset() {
        m1301setStartTextLayoutPositionInWindowk4lQ0M(m1294getCurrentTextLayoutPositionInWindowF1C5BW0());
    }

    private final a menuItem(boolean enabled, final TextToolbarState desiredState, final a operation) {
        if (enabled) {
            return new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.menuItem.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1326invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1326invoke() {
                    operation.invoke();
                    this.updateTextToolbarState(desiredState);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object observeTextChanges(H7.c<? super C7.r> r4) {
        /*
            r3 = this;
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$2 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$2
            r0.<init>()
            p9.c r0 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r0)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$3 r1 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C05183.INSTANCE
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>"
            kotlin.jvm.internal.k.d(r1, r2)
            r2 = 2
            kotlin.jvm.internal.p.e(r2, r1)
            boolean r2 = r0 instanceof p9.b
            if (r2 == 0) goto L25
            r2 = r0
            p9.b r2 = (p9.b) r2
            r2.getClass()
            S7.n r2 = r2.b
            if (r2 != r1) goto L25
            p9.b r0 = (p9.b) r0
            goto L2b
        L25:
            p9.b r2 = new p9.b
            r2.<init>(r0, r1)
            r0 = r2
        L2b:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$4 r1 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeTextChanges$4
            r1.<init>()
            kotlin.jvm.internal.Ref$IntRef r3 = new kotlin.jvm.internal.Ref$IntRef
            r3.<init>()
            kotlinx.coroutines.flow.f r2 = new kotlinx.coroutines.flow.f
            r2.<init>(r3, r1)
            java.lang.Object r3 = r0.collect(r2, r4)
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            C7.r r0 = C7.r.f317a
            if (r3 != r4) goto L45
            goto L46
        L45:
            r3 = r0
        L46:
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            if (r3 != r4) goto L4b
            return r3
        L4b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextChanges(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeTextToolbarVisibility(H7.c<? super r> cVar) {
        Object objCollect = SnapshotStateKt.snapshotFlow(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.2
            {
                super(0);
            }

            @Override // S7.a
            public final Rect invoke() {
                Rect rectIntersect;
                boolean zM6305getCollapsedimpl = TextRange.m6305getCollapsedimpl(TextFieldSelectionState.this.textFieldState.getVisualText().getSelection());
                if (((!zM6305getCollapsedimpl || TextFieldSelectionState.this.getTextToolbarState() != TextToolbarState.Cursor) && (zM6305getCollapsedimpl || TextFieldSelectionState.this.getTextToolbarState() != TextToolbarState.Selection)) || TextFieldSelectionState.this.getDraggingHandle() != null || !TextFieldSelectionState.this.isInTouchMode()) {
                    return Rect.INSTANCE.getZero();
                }
                LayoutCoordinates textLayoutCoordinates = TextFieldSelectionState.this.getTextLayoutCoordinates();
                Rect rectVisibleBounds = textLayoutCoordinates != null ? SelectionManagerKt.visibleBounds(textLayoutCoordinates) : null;
                if (rectVisibleBounds == null) {
                    return Rect.INSTANCE.getZero();
                }
                LayoutCoordinates textLayoutCoordinates2 = TextFieldSelectionState.this.getTextLayoutCoordinates();
                Offset offsetM3884boximpl = textLayoutCoordinates2 != null ? Offset.m3884boximpl(textLayoutCoordinates2.mo5560localToRootMKHz9U(rectVisibleBounds.m3930getTopLeftF1C5BW0())) : null;
                kotlin.jvm.internal.k.c(offsetM3884boximpl);
                Rect rectM3935Recttz77jQw = RectKt.m3935Recttz77jQw(offsetM3884boximpl.m3905unboximpl(), rectVisibleBounds.m3928getSizeNHjbRc());
                Rect contentRect = TextFieldSelectionState.this.getContentRect();
                Rect rect = rectM3935Recttz77jQw.overlaps(contentRect) ? contentRect : null;
                return (rect == null || (rectIntersect = rect.intersect(rectM3935Recttz77jQw)) == null) ? Rect.INSTANCE.getZero() : rectIntersect;
            }
        }).collect(new d() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeTextToolbarVisibility.3
            @Override // p9.d
            public /* bridge */ /* synthetic */ Object emit(Object obj, H7.c cVar2) {
                return emit((Rect) obj, (H7.c<? super r>) cVar2);
            }

            public final Object emit(Rect rect, H7.c<? super r> cVar2) {
                if (kotlin.jvm.internal.k.b(rect, Rect.INSTANCE.getZero())) {
                    TextFieldSelectionState.this.hideTextToolbar();
                } else {
                    TextFieldSelectionState.this.showTextToolbar(rect);
                }
                return r.f317a;
            }
        }, cVar);
        return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
    }

    private final void pasteAsPlainText() {
        AnnotatedString text;
        String text2;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null || (text2 = text.getText()) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, text2, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeCursorAtNearestOffset-k-4lQ0M, reason: not valid java name */
    public final boolean m1299placeCursorAtNearestOffsetk4lQ0M(long offset) {
        int iM6281getOffsetForPositionk4lQ0M;
        int iM6311getStartimpl;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null || (iM6281getOffsetForPositionk4lQ0M = layoutResult.m6281getOffsetForPositionk4lQ0M(offset)) == -1) {
            return false;
        }
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        long jM1263mapFromTransformedjx7JFs = transformedTextFieldState.m1263mapFromTransformedjx7JFs(iM6281getOffsetForPositionk4lQ0M);
        long jM1266mapToTransformedGEjPoXI = transformedTextFieldState.m1266mapToTransformedGEjPoXI(jM1263mapFromTransformedjx7JFs);
        int i = WhenMappings.$EnumSwitchMapping$0[((TextRange.m6305getCollapsedimpl(jM1263mapFromTransformedjx7JFs) && TextRange.m6305getCollapsedimpl(jM1266mapToTransformedGEjPoXI)) ? IndexTransformationType.Untransformed : (TextRange.m6305getCollapsedimpl(jM1263mapFromTransformedjx7JFs) || TextRange.m6305getCollapsedimpl(jM1266mapToTransformedGEjPoXI)) ? (!TextRange.m6305getCollapsedimpl(jM1263mapFromTransformedjx7JFs) || TextRange.m6305getCollapsedimpl(jM1266mapToTransformedGEjPoXI)) ? IndexTransformationType.Deletion : IndexTransformationType.Insertion : IndexTransformationType.Replacement).ordinal()];
        SelectionWedgeAffinity selectionWedgeAffinity = null;
        if (i == 1 || i == 2) {
            iM6311getStartimpl = TextRange.m6311getStartimpl(jM1263mapFromTransformedjx7JFs);
        } else if (i == 3) {
            selectionWedgeAffinity = MathUtilsKt.m1206findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m6311getStartimpl(jM1266mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6306getEndimpl(jM1266mapToTransformedGEjPoXI))) < 0 ? new SelectionWedgeAffinity(WedgeAffinity.Start) : new SelectionWedgeAffinity(WedgeAffinity.End);
            iM6311getStartimpl = TextRange.m6311getStartimpl(jM1263mapFromTransformedjx7JFs);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            iM6311getStartimpl = MathUtilsKt.m1206findClosestRect9KIMszo(offset, layoutResult.getCursorRect(TextRange.m6311getStartimpl(jM1266mapToTransformedGEjPoXI)), layoutResult.getCursorRect(TextRange.m6306getEndimpl(jM1266mapToTransformedGEjPoXI))) < 0 ? TextRange.m6311getStartimpl(jM1263mapFromTransformedjx7JFs) : TextRange.m6306getEndimpl(jM1263mapFromTransformedjx7JFs);
        }
        long jTextRange = TextRangeKt.TextRange(iM6311getStartimpl);
        if (TextRange.m6304equalsimpl0(jTextRange, this.textFieldState.getUntransformedText().getSelection()) && (selectionWedgeAffinity == null || selectionWedgeAffinity.equals(this.textFieldState.getSelectionWedgeAffinity()))) {
            return false;
        }
        this.textFieldState.m1269selectUntransformedCharsIn5zctL8(jTextRange);
        if (selectionWedgeAffinity != null) {
            this.textFieldState.setSelectionWedgeAffinity(selectionWedgeAffinity);
        }
        return true;
    }

    /* renamed from: setRawHandleDragPosition-k-4lQ0M, reason: not valid java name */
    private final void m1300setRawHandleDragPositionk4lQ0M(long j5) {
        this.rawHandleDragPosition.setValue(Offset.m3884boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShowCursorHandle(boolean z10) {
        this.showCursorHandle.setValue(Boolean.valueOf(z10));
    }

    /* renamed from: setStartTextLayoutPositionInWindow-k-4lQ0M, reason: not valid java name */
    private final void m1301setStartTextLayoutPositionInWindowk4lQ0M(long j5) {
        this.startTextLayoutPositionInWindow.setValue(Offset.m3884boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTextToolbarState(TextToolbarState textToolbarState) {
        this.textToolbarState.setValue(textToolbarState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTextToolbar(Rect contentRect) {
        TextToolbar textToolbar = this.textToolbar;
        if (textToolbar != null) {
            boolean zCanCopy = canCopy();
            final TextToolbarState textToolbarState = TextToolbarState.None;
            a aVar = !zCanCopy ? null : new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1306invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1306invoke() {
                    TextFieldSelectionState.copy$default(this, false, 1, null);
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState);
                }
            };
            a aVar2 = !canPaste() ? null : new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1307invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1307invoke() {
                    this.paste();
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState);
                }
            };
            a aVar3 = !canCut() ? null : new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1308invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1308invoke() {
                    this.cut();
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState);
                }
            };
            boolean zCanSelectAll = canSelectAll();
            final TextToolbarState textToolbarState2 = TextToolbarState.Selection;
            textToolbar.showMenu(contentRect, aVar, aVar2, aVar3, zCanSelectAll ? new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$showTextToolbar$$inlined$menuItem$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1309invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1309invoke() {
                    this.selectAll();
                    this.this$0$inline_fun.updateTextToolbarState(textToolbarState2);
                }
            } : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-SsL-Rf8, reason: not valid java name */
    public final long m1302updateSelectionSsLRf8(TextFieldCharSequence textFieldCharSequence, int startOffset, int endOffset, boolean isStartHandle, SelectionAdjustment adjustment, boolean allowPreviousSelectionCollapsed, boolean isStartOfSelection) {
        HapticFeedback hapticFeedback;
        TextRange textRangeM6299boximpl = TextRange.m6299boximpl(textFieldCharSequence.getSelection());
        long packedValue = textRangeM6299boximpl.getPackedValue();
        if (isStartOfSelection || (!allowPreviousSelectionCollapsed && TextRange.m6305getCollapsedimpl(packedValue))) {
            textRangeM6299boximpl = null;
        }
        long jM1298getTextFieldSelectionqeG_v_k = m1298getTextFieldSelectionqeG_v_k(startOffset, endOffset, textRangeM6299boximpl, isStartHandle, adjustment);
        if (!TextRange.m6304equalsimpl0(jM1298getTextFieldSelectionqeG_v_k, textFieldCharSequence.getSelection())) {
            boolean z10 = TextRange.m6310getReversedimpl(jM1298getTextFieldSelectionqeG_v_k) != TextRange.m6310getReversedimpl(textFieldCharSequence.getSelection()) && TextRange.m6304equalsimpl0(TextRangeKt.TextRange(TextRange.m6306getEndimpl(jM1298getTextFieldSelectionqeG_v_k), TextRange.m6311getStartimpl(jM1298getTextFieldSelectionqeG_v_k)), textFieldCharSequence.getSelection());
            if (isInTouchMode() && !z10 && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
            }
        }
        return jM1298getTextFieldSelectionqeG_v_k;
    }

    /* renamed from: updateSelection-SsL-Rf8$default, reason: not valid java name */
    public static /* synthetic */ long m1303updateSelectionSsLRf8$default(TextFieldSelectionState textFieldSelectionState, TextFieldCharSequence textFieldCharSequence, int i, int i6, boolean z10, SelectionAdjustment selectionAdjustment, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            z11 = false;
        }
        if ((i10 & 64) != 0) {
            z12 = false;
        }
        return textFieldSelectionState.m1302updateSelectionSsLRf8(textFieldCharSequence, i, i6, z10, selectionAdjustment, z11, z12);
    }

    public final boolean canCopy() {
        return (TextRange.m6305getCollapsedimpl(this.textFieldState.getVisualText().getSelection()) || this.isPassword) ? false : true;
    }

    public final boolean canCut() {
        return (TextRange.m6305getCollapsedimpl(this.textFieldState.getVisualText().getSelection()) || !getEditable() || this.isPassword) ? false : true;
    }

    public final boolean canPaste() {
        if (!getEditable()) {
            return false;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null && clipboardManager.hasText()) {
            return true;
        }
        a aVar = this.receiveContentConfiguration;
        if ((aVar != null ? (ReceiveContentConfiguration) aVar.invoke() : null) != null) {
            ClipboardManager clipboardManager2 = this.clipboardManager;
            if ((clipboardManager2 != null ? clipboardManager2.getClip() : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean canSelectAll() {
        return TextRange.m6307getLengthimpl(this.textFieldState.getVisualText().getSelection()) != this.textFieldState.getVisualText().length();
    }

    public final void clearHandleDragging() {
        setDraggingHandle(null);
        Offset.Companion companion = Offset.INSTANCE;
        m1300setRawHandleDragPositionk4lQ0M(companion.m3910getUnspecifiedF1C5BW0());
        m1301setStartTextLayoutPositionInWindowk4lQ0M(companion.m3910getUnspecifiedF1C5BW0());
    }

    public final void copy(boolean cancelSelection) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6305getCollapsedimpl(visualText.getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), null, null, 6, null));
        }
        if (cancelSelection) {
            this.textFieldState.collapseSelectionToMax();
        }
    }

    public final Object cursorHandleGestures(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(pointerInputScope, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    public final void cut() {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (TextRange.m6305getCollapsedimpl(visualText.getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(new AnnotatedString(TextFieldCharSequenceKt.getSelectedText(visualText).toString(), null, null, 6, null));
        }
        this.textFieldState.deleteSelectedText();
    }

    public final void deselect() {
        if (!TextRange.m6305getCollapsedimpl(this.textFieldState.getVisualText().getSelection())) {
            this.textFieldState.collapseSelectionToEnd();
        }
        setShowCursorHandle(false);
        updateTextToolbarState(TextToolbarState.None);
    }

    public final Object detectTextFieldTapGestures(PointerInputScope pointerInputScope, MutableInteractionSource mutableInteractionSource, final a aVar, final a aVar2, H7.c<? super r> cVar) {
        Object objDetectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, new C05112(mutableInteractionSource, this, null), new k() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1325invokek4lQ0M(((Offset) obj).m3905unboximpl());
                return r.f317a;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m1325invokek4lQ0M(long j5) {
                TextFieldSelectionStateKt.logDebug(new a() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.detectTextFieldTapGestures.3.1
                    @Override // S7.a
                    public final String invoke() {
                        return "onTapTextField";
                    }
                });
                aVar.invoke();
                if (this.enabled && this.getIsFocused()) {
                    if (!this.readOnly) {
                        aVar2.invoke();
                        if (this.textFieldState.getVisualText().length() > 0) {
                            this.setShowCursorHandle(true);
                        }
                    }
                    this.updateTextToolbarState(TextToolbarState.None);
                    long jM1249coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release = this.textLayoutState.m1249coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release(j5);
                    TextFieldSelectionState textFieldSelectionState = this;
                    textFieldSelectionState.m1299placeCursorAtNearestOffsetk4lQ0M(TextLayoutStateKt.m1256fromDecorationToTextLayoutUv8p0NA(textFieldSelectionState.textLayoutState, jM1249coercedInVisibleBoundsOfInputTextMKHz9U$foundation_release));
                }
            }
        }, cVar);
        return objDetectTapAndPress == CoroutineSingletons.f4909a ? objDetectTapAndPress : r.f317a;
    }

    public final Object detectTouchMode(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        Object objAwaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C05132(null), cVar);
        return objAwaitPointerEventScope == CoroutineSingletons.f4909a ? objAwaitPointerEventScope : r.f317a;
    }

    public final void dispose() {
        hideTextToolbar();
        this.textToolbar = null;
        this.clipboardManager = null;
        this.hapticFeedBack = null;
    }

    public final TextFieldHandleState getCursorHandleState$foundation_release(boolean includePosition) {
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        boolean showCursorHandle = getShowCursorHandle();
        boolean z10 = getDirectDragGestureInitiator() == InputType.None;
        Handle draggingHandle = getDraggingHandle();
        if (showCursorHandle && z10 && TextRange.m6305getCollapsedimpl(visualText.getSelection()) && visualText.shouldShowSelection() && visualText.length() > 0 && (draggingHandle == Handle.Cursor || isCursorHandleInVisibleBounds())) {
            return new TextFieldHandleState(true, includePosition ? getCursorRect().m3922getBottomCenterF1C5BW0() : Offset.INSTANCE.m3910getUnspecifiedF1C5BW0(), ResolvedTextDirection.Ltr, false, null);
        }
        return TextFieldHandleState.INSTANCE.getHidden();
    }

    public final Rect getCursorRect() {
        float right;
        TextLayoutResult layoutResult = this.textLayoutState.getLayoutResult();
        if (layoutResult == null) {
            return Rect.INSTANCE.getZero();
        }
        TextFieldCharSequence visualText = this.textFieldState.getVisualText();
        if (!TextRange.m6305getCollapsedimpl(visualText.getSelection())) {
            return Rect.INSTANCE.getZero();
        }
        Rect cursorRect = layoutResult.getCursorRect(TextRange.m6311getStartimpl(visualText.getSelection()));
        float fMo381toPx0680j_4 = this.density.mo381toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
        if (layoutResult.getLayoutInput().getLayoutDirection() == LayoutDirection.Ltr) {
            right = (fMo381toPx0680j_4 / 2) + cursorRect.getLeft();
        } else {
            right = cursorRect.getRight() - (fMo381toPx0680j_4 / 2);
        }
        float f = fMo381toPx0680j_4 / 2;
        float fM7015getWidthimpl = IntSize.m7015getWidthimpl(layoutResult.getSize()) - f;
        if (right > fM7015getWidthimpl) {
            right = fM7015getWidthimpl;
        }
        if (right < f) {
            right = f;
        }
        return new Rect(right - f, cursorRect.getTop(), right + f, cursorRect.getBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InputType getDirectDragGestureInitiator() {
        return (InputType) this.directDragGestureInitiator.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* renamed from: getHandleDragPosition-F1C5BW0, reason: not valid java name */
    public final long m1304getHandleDragPositionF1C5BW0() {
        return OffsetKt.m3916isUnspecifiedk4lQ0M(m1296getRawHandleDragPositionF1C5BW0()) ? Offset.INSTANCE.m3910getUnspecifiedF1C5BW0() : OffsetKt.m3916isUnspecifiedk4lQ0M(m1297getStartTextLayoutPositionInWindowF1C5BW0()) ? TextLayoutStateKt.m1256fromDecorationToTextLayoutUv8p0NA(this.textLayoutState, m1296getRawHandleDragPositionF1C5BW0()) : Offset.m3900plusMKHz9U(m1296getRawHandleDragPositionF1C5BW0(), Offset.m3899minusMKHz9U(m1297getStartTextLayoutPositionInWindowF1C5BW0(), m1294getCurrentTextLayoutPositionInWindowF1C5BW0()));
    }

    public final a getReceiveContentConfiguration() {
        return this.receiveContentConfiguration;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState getSelectionHandleState$foundation_release(boolean r14, boolean r15) {
        /*
            r13 = this;
            if (r14 == 0) goto L5
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionStart
            goto L7
        L5:
            androidx.compose.foundation.text.Handle r0 = androidx.compose.foundation.text.Handle.SelectionEnd
        L7:
            androidx.compose.foundation.text.input.internal.TextLayoutState r1 = r13.textLayoutState
            androidx.compose.ui.text.TextLayoutResult r1 = r1.getLayoutResult()
            if (r1 != 0) goto L16
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r13 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r13 = r13.getHidden()
            return r13
        L16:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r2 = r13.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r2 = r2.getVisualText()
            long r2 = r2.getSelection()
            boolean r4 = androidx.compose.ui.text.TextRange.m6305getCollapsedimpl(r2)
            if (r4 == 0) goto L2d
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r13 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r13 = r13.getHidden()
            return r13
        L2d:
            long r4 = r13.m1295getHandlePositiontuRUvjQ(r14)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r6 = r13.getDirectDragGestureInitiator()
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$InputType r7 = androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.InputType.None
            r8 = 1
            r9 = 0
            if (r6 != r7) goto L57
            androidx.compose.foundation.text.Handle r6 = r13.getDraggingHandle()
            if (r6 == r0) goto L55
            androidx.compose.ui.layout.LayoutCoordinates r0 = r13.getTextLayoutCoordinates()
            if (r0 == 0) goto L52
            androidx.compose.ui.geometry.Rect r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r0)
            if (r0 == 0) goto L52
            boolean r0 = androidx.compose.foundation.text.selection.SelectionManagerKt.m1432containsInclusiveUv8p0NA(r0, r4)
            goto L53
        L52:
            r0 = r9
        L53:
            if (r0 == 0) goto L57
        L55:
            r0 = r8
            goto L58
        L57:
            r0 = r9
        L58:
            if (r0 != 0) goto L61
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r13 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r13 = r13.getHidden()
            return r13
        L61:
            androidx.compose.foundation.text.input.internal.TransformedTextFieldState r0 = r13.textFieldState
            androidx.compose.foundation.text.input.TextFieldCharSequence r0 = r0.getVisualText()
            boolean r0 = r0.shouldShowSelection()
            if (r0 != 0) goto L74
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState$Companion r13 = androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState.INSTANCE
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r13 = r13.getHidden()
            return r13
        L74:
            if (r14 == 0) goto L7b
            int r14 = androidx.compose.ui.text.TextRange.m6311getStartimpl(r2)
            goto L84
        L7b:
            int r14 = androidx.compose.ui.text.TextRange.m6306getEndimpl(r2)
            int r14 = r14 - r8
            int r14 = java.lang.Math.max(r14, r9)
        L84:
            androidx.compose.ui.text.style.ResolvedTextDirection r10 = r1.getBidiRunDirection(r14)
            boolean r11 = androidx.compose.ui.text.TextRange.m6310getReversedimpl(r2)
            if (r15 == 0) goto La0
            androidx.compose.ui.layout.LayoutCoordinates r13 = r13.getTextLayoutCoordinates()
            if (r13 == 0) goto L9e
            androidx.compose.ui.geometry.Rect r13 = androidx.compose.foundation.text.selection.SelectionManagerKt.visibleBounds(r13)
            if (r13 == 0) goto L9e
            long r4 = androidx.compose.foundation.text.input.internal.TextLayoutStateKt.m1255coerceIn3MmeM6k(r4, r13)
        L9e:
            r8 = r4
            goto La7
        La0:
            androidx.compose.ui.geometry.Offset$Companion r13 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r4 = r13.m3910getUnspecifiedF1C5BW0()
            goto L9e
        La7:
            androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState
            r7 = 1
            r12 = 0
            r6.<init>(r7, r8, r10, r11, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.getSelectionHandleState$foundation_release(boolean, boolean):androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState");
    }

    /* renamed from: isFocused, reason: from getter */
    public final boolean getIsFocused() {
        return this.isFocused;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isInTouchMode() {
        return ((Boolean) this.isInTouchMode.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object observeChanges(H7.c<? super C7.r> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C05151
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.C05151) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1 r0 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r5 = (androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState) r5
            kotlin.b.b(r6)     // Catch: java.lang.Throwable -> L2c
            goto L4a
        L2c:
            r6 = move-exception
            goto L5b
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r6)
            androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2 r6 = new androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$observeChanges$2     // Catch: java.lang.Throwable -> L2c
            r2 = 0
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L2c
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2c
            r0.label = r4     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r6 = m9.AbstractC1683A.f(r6, r0)     // Catch: java.lang.Throwable -> L2c
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r5.setShowCursorHandle(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r6 = r5.getTextToolbarState()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r0 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r6 == r0) goto L58
            r5.hideTextToolbar()
        L58:
            C7.r r5 = C7.r.f317a
            return r5
        L5b:
            r5.setShowCursorHandle(r3)
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r0 = r5.getTextToolbarState()
            androidx.compose.foundation.text.input.internal.selection.TextToolbarState r1 = androidx.compose.foundation.text.input.internal.selection.TextToolbarState.None
            if (r0 == r1) goto L69
            r5.hideTextToolbar()
        L69:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState.observeChanges(H7.c):java.lang.Object");
    }

    public final void paste() {
        ReceiveContentConfiguration receiveContentConfiguration;
        ClipEntry clip;
        ClipEntry clipEntry;
        String plainText;
        a aVar = this.receiveContentConfiguration;
        if (aVar == null || (receiveContentConfiguration = (ReceiveContentConfiguration) aVar.invoke()) == null) {
            pasteAsPlainText();
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (clip = clipboardManager.getClip()) == null) {
            pasteAsPlainText();
            return;
        }
        TransferableContent transferableContentOnReceive = receiveContentConfiguration.getReceiveContentListener().onReceive(new TransferableContent(clip, clip.getClipMetadata(), TransferableContent.Source.INSTANCE.m343getClipboardkB6V9T0(), null, 8, null));
        if (transferableContentOnReceive == null || (clipEntry = transferableContentOnReceive.getClipEntry()) == null || (plainText = TransferableContent_androidKt.readPlainText(clipEntry)) == null) {
            return;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.textFieldState, plainText, false, TextFieldEditUndoBehavior.NeverMerge, 2, null);
    }

    public final void selectAll() {
        this.textFieldState.selectAll();
    }

    public final Object selectionHandleGestures(PointerInputScope pointerInputScope, boolean z10, H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new C05222(pointerInputScope, z10, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    public final void setDirectDragGestureInitiator(InputType inputType) {
        this.directDragGestureInitiator.setValue(inputType);
    }

    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    public final void setFocused(boolean z10) {
        this.isFocused = z10;
    }

    public final void setInTouchMode(boolean z10) {
        this.isInTouchMode.setValue(Boolean.valueOf(z10));
    }

    public final void setReceiveContentConfiguration(a aVar) {
        this.receiveContentConfiguration = aVar;
    }

    public final Object textFieldSelectionGestures(PointerInputScope pointerInputScope, a aVar, H7.c<? super r> cVar) {
        Object objSelectionGesturePointerInputBtf2 = SelectionGesturesKt.selectionGesturePointerInputBtf2(pointerInputScope, new TextFieldMouseSelectionObserver(aVar), new TextFieldTextDragObserver(aVar), cVar);
        return objSelectionGesturePointerInputBtf2 == CoroutineSingletons.f4909a ? objSelectionGesturePointerInputBtf2 : r.f317a;
    }

    public final void update(HapticFeedback hapticFeedBack, ClipboardManager clipboardManager, TextToolbar textToolbar, Density density, boolean enabled, boolean readOnly, boolean isPassword) {
        if (!enabled) {
            hideTextToolbar();
        }
        this.hapticFeedBack = hapticFeedBack;
        this.clipboardManager = clipboardManager;
        this.textToolbar = textToolbar;
        this.density = density;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.isPassword = isPassword;
    }

    /* renamed from: updateHandleDragging-Uv8p0NA, reason: not valid java name */
    public final void m1305updateHandleDraggingUv8p0NA(Handle handle, long position) {
        setDraggingHandle(handle);
        m1300setRawHandleDragPositionk4lQ0M(position);
    }

    public final void updateTextToolbarState(TextToolbarState textToolbarState) {
        setTextToolbarState(textToolbarState);
    }
}
