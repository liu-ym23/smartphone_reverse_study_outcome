package androidx.compose.foundation.text.selection;

import C7.r;
import S7.k;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursorKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0000ø\u0001\u0000¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010$\u001a\u00020\u0010H\u0000¢\u0006\u0004\b#\u0010\u0015J\u0019\u0010'\u001a\u00020\u00102\b\b\u0002\u0010%\u001a\u00020\u0006H\u0000¢\u0006\u0004\b&\u0010\u0012J\u000f\u0010)\u001a\u00020\u0010H\u0000¢\u0006\u0004\b(\u0010\u0015J\u000f\u0010+\u001a\u00020\u0010H\u0000¢\u0006\u0004\b*\u0010\u0015J\u000f\u0010-\u001a\u00020\u0010H\u0000¢\u0006\u0004\b,\u0010\u0015J\u001d\u00100\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u0006H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001d\u00105\u001a\u00020\u00172\u0006\u00102\u001a\u000201H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u00020\u0010H\u0000¢\u0006\u0004\b6\u0010\u0015J\u000f\u00109\u001a\u00020\u0010H\u0000¢\u0006\u0004\b8\u0010\u0015J\u0018\u0010;\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u000f\u0010>\u001a\u00020\u0006H\u0000¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0012J\u000f\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bB\u0010CJB\u0010M\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u0017\u0010P\u001a\u00020\u00102\u0006\u0010O\u001a\u00020NH\u0002¢\u0006\u0004\bP\u0010QJ\"\u0010W\u001a\u00020D2\u0006\u0010S\u001a\u00020R2\u0006\u0010T\u001a\u00020\u001cH\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010VR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010X\u001a\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR.\u0010c\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00100b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR+\u0010E\u001a\u00020D2\u0006\u0010p\u001a\u00020D8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R)\u0010\u007f\u001a\u0004\u0018\u00010~8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R,\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R,\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R,\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R/\u0010\u009d\u0001\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010r\u001a\u0005\b\u009b\u0001\u0010=\"\u0005\b\u009c\u0001\u0010\u0012R/\u0010¡\u0001\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b\u009e\u0001\u0010r\u001a\u0005\b\u009f\u0001\u0010=\"\u0005\b \u0001\u0010\u0012R\u001f\u0010¢\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u001c\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010§\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b§\u0001\u0010£\u0001R7\u0010®\u0001\u001a\u0005\u0018\u00010¨\u00012\t\u0010p\u001a\u0005\u0018\u00010¨\u00018F@BX\u0086\u008e\u0002¢\u0006\u0017\n\u0005\b©\u0001\u0010r\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R:\u0010³\u0001\u001a\u0004\u0018\u00010\u00172\b\u0010p\u001a\u0004\u0018\u00010\u00178F@BX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0016\n\u0005\b¯\u0001\u0010r\u001a\u0006\b°\u0001\u0010±\u0001\"\u0005\b²\u0001\u0010\u001aR\u001a\u0010´\u0001\u001a\u00030¤\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b´\u0001\u0010µ\u0001R\u0019\u0010¶\u0001\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001c\u0010¹\u0001\u001a\u0005\u0018\u00010¸\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001e\u0010»\u0001\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\u000f\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0005\b½\u0001\u0010\rR \u0010¿\u0001\u001a\u00030¾\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001R\u0019\u0010Å\u0001\u001a\u0004\u0018\u00010R8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Æ\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "Landroidx/compose/foundation/text/UndoManager;", "undoManager", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/UndoManager;)V", "", "isStartHandle", "Landroidx/compose/foundation/text/TextDragObserver;", "handleDragObserver$foundation_release", "(Z)Landroidx/compose/foundation/text/TextDragObserver;", "handleDragObserver", "cursorDragObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "cursorDragObserver", "showFloatingToolbar", "LC7/r;", "enterSelectionMode$foundation_release", "(Z)V", "enterSelectionMode", "exitSelectionMode$foundation_release", "()V", "exitSelectionMode", "Landroidx/compose/ui/geometry/Offset;", "position", "deselect-_kEHs6E$foundation_release", "(Landroidx/compose/ui/geometry/Offset;)V", "deselect", "Landroidx/compose/ui/text/TextRange;", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "(J)V", "setSelectionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "setDeletionPreviewHighlight", "clearPreviewHighlight$foundation_release", "clearPreviewHighlight", "cancelSelection", "copy$foundation_release", "copy", "paste$foundation_release", "paste", "cut$foundation_release", "cut", "selectAll$foundation_release", "selectAll", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "getHandlePosition", "Landroidx/compose/ui/unit/Density;", "density", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "getCursorPosition", "showSelectionToolbar$foundation_release", "showSelectionToolbar", "hideSelectionToolbar$foundation_release", "hideSelectionToolbar", "contextMenuOpenAdjustment-k-4lQ0M", "contextMenuOpenAdjustment", "isTextChanged$foundation_release", "()Z", "isTextChanged", "show", "updateFloatingToolbar", "Landroidx/compose/ui/geometry/Rect;", "getContentRect", "()Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", "currentPosition", "isStartOfSelection", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "adjustment", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "updateSelection", "Landroidx/compose/foundation/text/HandleState;", "handleState", "setHandleState", "(Landroidx/compose/foundation/text/HandleState;)V", "Landroidx/compose/ui/text/AnnotatedString;", "annotatedString", "selection", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "createTextFieldValue", "Landroidx/compose/foundation/text/UndoManager;", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "Lkotlin/Function1;", "onValueChange", "LS7/k;", "getOnValueChange$foundation_release", "()LS7/k;", "setOnValueChange$foundation_release", "(LS7/k;)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager$foundation_release", "()Landroidx/compose/ui/platform/ClipboardManager;", "setClipboardManager$foundation_release", "(Landroidx/compose/ui/platform/ClipboardManager;)V", "Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "editable$delegate", "getEditable", "setEditable", "editable", "enabled$delegate", "getEnabled", "setEnabled", "enabled", "dragBeginPosition", "J", "", "dragBeginOffsetInText", "Ljava/lang/Integer;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle$delegate", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle", "currentDragPosition$delegate", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "currentDragPosition", "previousRawDragOffset", "I", "oldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "transformedText", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;
    private ClipboardManager clipboardManager;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private Integer dragBeginOffsetInText;
    private long dragBeginPosition;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;

    /* renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private k onValueChange;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;
    private VisualTransformation visualTransformation;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldSelectionManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        textFieldSelectionManager.copy$foundation_release(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m1448createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (e) null);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m1449deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m1453deselect_kEHs6E$foundation_release(offset);
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z10);
    }

    private final Rect getContentRect() {
        float fM3896getYimpl;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getIsLayoutResultStale()) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6311getStartimpl(getValue$foundation_release().getSelection()));
                int iOriginalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.m6306getEndimpl(getValue$foundation_release().getSelection()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long jM3911getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m3911getZeroF1C5BW0() : layoutCoordinates4.mo5560localToRootMKHz9U(m1456getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long jM3911getZeroF1C5BW02 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m3911getZeroF1C5BW0() : layoutCoordinates3.mo5560localToRootMKHz9U(m1456getHandlePositiontuRUvjQ$foundation_release(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float fM3896getYimpl2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    fM3896getYimpl = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    fM3896getYimpl = Offset.m3896getYimpl(layoutCoordinates2.mo5560localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(iOriginalToTransformed)) == null) ? 0.0f : cursorRect2.getTop())));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    fM3896getYimpl2 = Offset.m3896getYimpl(layoutCoordinates.mo5560localToRootMKHz9U(OffsetKt.Offset(0.0f, (layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(iOriginalToTransformed2)) == null) ? 0.0f : cursorRect.getTop())));
                }
                return new Rect(Math.min(Offset.m3895getXimpl(jM3911getZeroF1C5BW0), Offset.m3895getXimpl(jM3911getZeroF1C5BW02)), Math.min(fM3896getYimpl, fM3896getYimpl2), Math.max(Offset.m3895getXimpl(jM3911getZeroF1C5BW0), Offset.m3895getXimpl(jM3911getZeroF1C5BW02)), (legacyTextFieldState.getTextDelegate().getDensity().getDensity() * Dp.m6844constructorimpl(25)) + Math.max(Offset.m3896getYimpl(jM3911getZeroF1C5BW0), Offset.m3896getYimpl(jM3911getZeroF1C5BW02)));
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m1450setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m1451updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        int i;
        HapticFeedback hapticFeedback;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.INSTANCE.m6316getZerod9O1mEE();
        }
        long jTextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.m6311getStartimpl(value.getSelection())), this.offsetMapping.originalToTransformed(TextRange.m6306getEndimpl(value.getSelection())));
        boolean z10 = false;
        int iM1124getOffsetForPosition3MmeM6k = layoutResult.m1124getOffsetForPosition3MmeM6k(currentPosition, false);
        int iM6311getStartimpl = (isStartHandle || isStartOfSelection) ? iM1124getOffsetForPosition3MmeM6k : TextRange.m6311getStartimpl(jTextRange);
        int iM6306getEndimpl = (!isStartHandle || isStartOfSelection) ? iM1124getOffsetForPosition3MmeM6k : TextRange.m6306getEndimpl(jTextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        if (isStartOfSelection || selectionLayout == null || (i = this.previousRawDragOffset) == -1) {
            i = -1;
        }
        SelectionLayout selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m1394getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), iM6311getStartimpl, iM6306getEndimpl, i, jTextRange, isStartOfSelection, isStartHandle);
        if (!selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return value.getSelection();
        }
        this.previousSelectionLayout = selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = iM1124getOffsetForPosition3MmeM6k;
        Selection selectionAdjust = adjustment.adjust(selectionLayoutM1394getTextFieldSelectionLayoutRcvTLA);
        long jTextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(selectionAdjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(selectionAdjust.getEnd().getOffset()));
        if (TextRange.m6304equalsimpl0(jTextRange2, value.getSelection())) {
            return value.getSelection();
        }
        boolean z11 = TextRange.m6310getReversedimpl(jTextRange2) != TextRange.m6310getReversedimpl(value.getSelection()) && TextRange.m6304equalsimpl0(TextRangeKt.TextRange(TextRange.m6306getEndimpl(jTextRange2), TextRange.m6311getStartimpl(jTextRange2)), value.getSelection());
        boolean z12 = TextRange.m6305getCollapsedimpl(jTextRange2) && TextRange.m6305getCollapsedimpl(value.getSelection());
        if (isTouchBasedSelection && value.getText().length() > 0 && !z11 && !z12 && (hapticFeedback = this.hapticFeedBack) != null) {
            hapticFeedback.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
        }
        this.onValueChange.invoke(m1448createTextFieldValueFDrldGo(value.getAnnotatedString(), jTextRange2));
        if (!isTouchBasedSelection) {
            updateFloatingToolbar(!TextRange.m6305getCollapsedimpl(jTextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.m6305getCollapsedimpl(jTextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.m6305getCollapsedimpl(jTextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 == null) {
            return jTextRange2;
        }
        if (TextRange.m6305getCollapsedimpl(jTextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
            z10 = true;
        }
        legacyTextFieldState5.setShowCursorHandle(z10);
        return jTextRange2;
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1046setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6316getZerod9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 == null) {
            return;
        }
        legacyTextFieldState2.m1049setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6316getZerod9O1mEE());
    }

    /* renamed from: contextMenuOpenAdjustment-k-4lQ0M, reason: not valid java name */
    public final void m1452contextMenuOpenAdjustmentk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return;
        }
        if (TextRange.m6302containsimpl(getValue$foundation_release().getSelection(), TextLayoutResultProxy.m1123getOffsetForPosition3MmeM6k$default(layoutResult, position, false, 2, null))) {
            return;
        }
        this.previousRawDragOffset = -1;
        m1451updateSelection8UEBfa8(getValue$foundation_release(), position, true, false, SelectionAdjustment.INSTANCE.getWord(), false);
    }

    public final void copy$foundation_release(boolean cancelSelection) {
        if (TextRange.m6305getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        if (cancelSelection) {
            int iM6308getMaximpl = TextRange.m6308getMaximpl(getValue$foundation_release().getSelection());
            this.onValueChange.invoke(m1448createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(iM6308getMaximpl, iM6308getMaximpl)));
            setHandleState(HandleState.None);
        }
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1091onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1092onDragk4lQ0M(long delta) {
                TextLayoutResultProxy layoutResult;
                HapticFeedback hapticFeedBack;
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m3900plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m1450setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(Offset.m3900plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, textFieldSelectionManager2.dragTotalDistance)));
                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                Offset offsetM1454getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m1454getCurrentDragPosition_m7T9E();
                kotlin.jvm.internal.k.c(offsetM1454getCurrentDragPosition_m7T9E);
                int iTransformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1123getOffsetForPosition3MmeM6k$default(layoutResult, offsetM1454getCurrentDragPosition_m7T9E.m3905unboximpl(), false, 2, null));
                long jTextRange = TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal);
                if (TextRange.m6304equalsimpl0(jTextRange, textFieldSelectionManager2.getValue$foundation_release().getSelection())) {
                    return;
                }
                LegacyTextFieldState state2 = textFieldSelectionManager2.getState();
                if ((state2 == null || state2.isInTouchMode()) && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
                }
                textFieldSelectionManager2.getOnValueChange().invoke(textFieldSelectionManager2.m1448createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), jTextRange));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1093onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                long jM1391getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1391getAdjustedCoordinatesk4lQ0M(this.this$0.m1456getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long jM1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release(jM1391getAdjustedCoordinatesk4lQ0M);
                this.this$0.dragBeginPosition = jM1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                this.this$0.m1450setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(jM1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m3911getZeroF1C5BW0();
                this.this$0.setDraggingHandle(Handle.Cursor);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1450setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1450setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public final void cut$foundation_release() {
        if (TextRange.m6305getCollapsedimpl(getValue$foundation_release().getSelection())) {
            return;
        }
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager != null) {
            clipboardManager.setText(TextFieldValueKt.getSelectedText(getValue$foundation_release()));
        }
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int iM6309getMinimpl = TextRange.m6309getMinimpl(getValue$foundation_release().getSelection());
        this.onValueChange.invoke(m1448createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(iM6309getMinimpl, iM6309getMinimpl)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m1453deselect_kEHs6E$foundation_release(Offset position) {
        if (!TextRange.m6305getCollapsedimpl(getValue$foundation_release().getSelection())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            this.onValueChange.invoke(TextFieldValue.m6554copy3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange((position == null || layoutResult == null) ? TextRange.m6308getMaximpl(getValue$foundation_release().getSelection()) : this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1123getOffsetForPosition3MmeM6k$default(layoutResult, position.m3905unboximpl(), false, 2, null))), (TextRange) null, 5, (Object) null));
        }
        setHandleState((position == null || getValue$foundation_release().getText().length() <= 0) ? HandleState.None : HandleState.Cursor);
        updateFloatingToolbar(false);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null && !legacyTextFieldState.getHasFocus() && (focusRequester = this.focusRequester) != null) {
            focusRequester.requestFocus();
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: getClipboardManager$foundation_release, reason: from getter */
    public final ClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m1454getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1455getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int iOriginalToTransformed = this.offsetMapping.originalToTransformed(TextRange.m6311getStartimpl(getValue$foundation_release().getSelection()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        kotlin.jvm.internal.k.c(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(AbstractC1451a.u(iOriginalToTransformed, 0, value.getLayoutInput().getText().length()));
        return OffsetKt.Offset((density.mo381toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness()) / 2) + cursorRect.getLeft(), cursorRect.getBottom());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m1456getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
        }
        if (!kotlin.jvm.internal.k.b(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.INSTANCE.m3910getUnspecifiedF1C5BW0();
        }
        long selection = getValue$foundation_release().getSelection();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(isStartHandle ? TextRange.m6311getStartimpl(selection) : TextRange.m6306getEndimpl(selection)), isStartHandle, TextRange.m6310getReversedimpl(getValue$foundation_release().getSelection()));
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    /* renamed from: getOnValueChange$foundation_release, reason: from getter */
    public final k getOnValueChange() {
        return this.onValueChange;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldValue getValue$foundation_release() {
        return (TextFieldValue) this.value.getValue();
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1091onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                this.this$0.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long jM1391getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m1391getAdjustedCoordinatesk4lQ0M(this.this$0.m1456getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long jM1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release(jM1391getAdjustedCoordinatesk4lQ0M);
                this.this$0.dragBeginPosition = jM1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                this.this$0.m1450setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(jM1127translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                this.this$0.dragTotalDistance = Offset.INSTANCE.m3911getZeroF1C5BW0();
                this.this$0.previousRawDragOffset = -1;
                LegacyTextFieldState state2 = this.this$0.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1092onDragk4lQ0M(long delta) {
                TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                textFieldSelectionManager.dragTotalDistance = Offset.m3900plusMKHz9U(textFieldSelectionManager.dragTotalDistance, delta);
                TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                textFieldSelectionManager2.m1450setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(Offset.m3900plusMKHz9U(textFieldSelectionManager2.dragBeginPosition, this.this$0.dragTotalDistance)));
                TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset offsetM1454getCurrentDragPosition_m7T9E = this.this$0.m1454getCurrentDragPosition_m7T9E();
                kotlin.jvm.internal.k.c(offsetM1454getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m1451updateSelection8UEBfa8(value$foundation_release, offsetM1454getCurrentDragPosition_m7T9E.m3905unboximpl(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                this.this$0.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1093onStartk4lQ0M(long startPoint) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1450setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1450setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
            }
        };
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    public final boolean isTextChanged$foundation_release() {
        return !kotlin.jvm.internal.k.b(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    public final void paste$foundation_release() {
        AnnotatedString text;
        ClipboardManager clipboardManager = this.clipboardManager;
        if (clipboardManager == null || (text = clipboardManager.getText()) == null) {
            return;
        }
        AnnotatedString annotatedStringPlus = TextFieldValueKt.getTextBeforeSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()).plus(text).plus(TextFieldValueKt.getTextAfterSelection(getValue$foundation_release(), getValue$foundation_release().getText().length()));
        int length = text.length() + TextRange.m6309getMinimpl(getValue$foundation_release().getSelection());
        this.onValueChange.invoke(m1448createTextFieldValueFDrldGo(annotatedStringPlus, TextRangeKt.TextRange(length, length)));
        setHandleState(HandleState.None);
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
    }

    public final void selectAll$foundation_release() {
        TextFieldValue textFieldValueM1448createTextFieldValueFDrldGo = m1448createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(textFieldValueM1448createTextFieldValueFDrldGo);
        this.oldValue = TextFieldValue.m6554copy3r_uNRQ$default(this.oldValue, (AnnotatedString) null, textFieldValueM1448createTextFieldValueFDrldGo.getSelection(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void setClipboardManager$foundation_release(ClipboardManager clipboardManager) {
        this.clipboardManager = clipboardManager;
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m1457setDeletionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1046setDeletionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1049setSelectionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6316getZerod9O1mEE());
        }
        if (TextRange.m6305getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void setEditable(boolean z10) {
        this.editable.setValue(Boolean.valueOf(z10));
    }

    public final void setEnabled(boolean z10) {
        this.enabled.setValue(Boolean.valueOf(z10));
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    public final void setOnValueChange$foundation_release(k kVar) {
        this.onValueChange = kVar;
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m1458setSelectionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1049setSelectionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1046setDeletionPreviewHighlightRange5zctL8(TextRange.INSTANCE.m6316getZerod9O1mEE());
        }
        if (TextRange.m6305getCollapsedimpl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.value.setValue(textFieldValue);
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final void showSelectionToolbar$foundation_release() {
        ClipboardManager clipboardManager;
        if (getEnabled()) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            if (legacyTextFieldState == null || legacyTextFieldState.isInTouchMode()) {
                boolean z10 = this.visualTransformation instanceof PasswordVisualTransformation;
                S7.a aVar = (TextRange.m6305getCollapsedimpl(getValue$foundation_release().getSelection()) || z10) ? null : new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$copy$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1459invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1459invoke() {
                        TextFieldSelectionManager.copy$foundation_release$default(this.this$0, false, 1, null);
                        this.this$0.hideSelectionToolbar$foundation_release();
                    }
                };
                S7.a aVar2 = (TextRange.m6305getCollapsedimpl(getValue$foundation_release().getSelection()) || !getEditable() || z10) ? null : new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$cut$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1460invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1460invoke() {
                        this.this$0.cut$foundation_release();
                        this.this$0.hideSelectionToolbar$foundation_release();
                    }
                };
                S7.a aVar3 = (getEditable() && (clipboardManager = this.clipboardManager) != null && clipboardManager.hasText()) ? new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$paste$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1461invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1461invoke() {
                        this.this$0.paste$foundation_release();
                        this.this$0.hideSelectionToolbar$foundation_release();
                    }
                } : null;
                S7.a aVar4 = TextRange.m6307getLengthimpl(getValue$foundation_release().getSelection()) != getValue$foundation_release().getText().length() ? new S7.a() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$showSelectionToolbar$selectAll$1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1462invoke();
                        return r.f317a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1462invoke() {
                        this.this$0.selectAll$foundation_release();
                    }
                } : null;
                TextToolbar textToolbar = this.textToolbar;
                if (textToolbar != null) {
                    textToolbar.showMenu(getContentRect(), aVar, aVar3, aVar2, aVar4);
                }
            }
        }
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new k() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$onValueChange$1
            public final void invoke(TextFieldValue textFieldValue) {
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TextFieldValue) obj);
                return r.f317a;
            }
        };
        this.value = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (e) null), null, 2, null);
        this.visualTransformation = VisualTransformation.INSTANCE.getNone();
        Boolean bool = Boolean.TRUE;
        this.editable = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.enabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        Offset.Companion companion = Offset.INSTANCE;
        this.dragBeginPosition = companion.m3911getZeroF1C5BW0();
        this.dragTotalDistance = companion.m3911getZeroF1C5BW0();
        this.draggingHandle = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (e) null);
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            private final void onEnd() {
                this.this$0.setDraggingHandle(null);
                this.this$0.m1450setCurrentDragPosition_kEHs6E(null);
                this.this$0.updateFloatingToolbar(true);
                this.this$0.dragBeginOffsetInText = null;
                boolean zM6305getCollapsedimpl = TextRange.m6305getCollapsedimpl(this.this$0.getValue$foundation_release().getSelection());
                this.this$0.setHandleState(zM6305getCollapsedimpl ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state = this.this$0.getState();
                if (state != null) {
                    state.setShowSelectionHandleStart(!zM6305getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, true));
                }
                LegacyTextFieldState state2 = this.this$0.getState();
                if (state2 != null) {
                    state2.setShowSelectionHandleEnd(!zM6305getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, false));
                }
                LegacyTextFieldState state3 = this.this$0.getState();
                if (state3 == null) {
                    return;
                }
                state3.setShowCursorHandle(zM6305getCollapsedimpl && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this.this$0, true));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1091onDownk4lQ0M(long point) {
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x00b4  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void mo1092onDragk4lQ0M(long r10) {
                /*
                    r9 = this;
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r9.this$0
                    boolean r0 = r0.getEnabled()
                    if (r0 == 0) goto L104
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r9.this$0
                    androidx.compose.ui.text.input.TextFieldValue r0 = r0.getValue$foundation_release()
                    java.lang.String r0 = r0.getText()
                    int r0 = r0.length()
                    if (r0 != 0) goto L19
                    return
                L19:
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r0 = r9.this$0
                    long r1 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragTotalDistance$p(r0)
                    long r10 = androidx.compose.ui.geometry.Offset.m3900plusMKHz9U(r1, r10)
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$setDragTotalDistance$p(r0, r10)
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = r9.this$0
                    androidx.compose.foundation.text.LegacyTextFieldState r10 = r10.getState()
                    r11 = 0
                    if (r10 == 0) goto Lff
                    androidx.compose.foundation.text.TextLayoutResultProxy r0 = r10.getLayoutResult()
                    if (r0 == 0) goto Lff
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r10 = r9.this$0
                    long r1 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragBeginPosition$p(r10)
                    long r3 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragTotalDistance$p(r10)
                    long r1 = androidx.compose.ui.geometry.Offset.m3900plusMKHz9U(r1, r3)
                    androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m3884boximpl(r1)
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager.m1446access$setCurrentDragPosition_kEHs6E(r10, r1)
                    java.lang.Integer r1 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragBeginOffsetInText$p(r10)
                    if (r1 != 0) goto Lb4
                    androidx.compose.ui.geometry.Offset r1 = r10.m1454getCurrentDragPosition_m7T9E()
                    kotlin.jvm.internal.k.c(r1)
                    long r1 = r1.m3905unboximpl()
                    boolean r1 = r0.m1125isPositionOnTextk4lQ0M(r1)
                    if (r1 != 0) goto Lb4
                    androidx.compose.ui.text.input.OffsetMapping r6 = r10.getOffsetMapping()
                    long r1 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragBeginPosition$p(r10)
                    r4 = 2
                    r5 = 0
                    r3 = 0
                    int r1 = androidx.compose.foundation.text.TextLayoutResultProxy.m1123getOffsetForPosition3MmeM6k$default(r0, r1, r3, r4, r5)
                    int r6 = r6.transformedToOriginal(r1)
                    androidx.compose.ui.text.input.OffsetMapping r7 = r10.getOffsetMapping()
                    androidx.compose.ui.geometry.Offset r1 = r10.m1454getCurrentDragPosition_m7T9E()
                    kotlin.jvm.internal.k.c(r1)
                    long r1 = r1.m3905unboximpl()
                    int r0 = androidx.compose.foundation.text.TextLayoutResultProxy.m1123getOffsetForPosition3MmeM6k$default(r0, r1, r3, r4, r5)
                    int r0 = r7.transformedToOriginal(r0)
                    if (r6 != r0) goto L95
                    androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r0 = androidx.compose.foundation.text.selection.SelectionAdjustment.INSTANCE
                    androidx.compose.foundation.text.selection.SelectionAdjustment r0 = r0.getNone()
                L93:
                    r7 = r0
                    goto L9c
                L95:
                    androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r0 = androidx.compose.foundation.text.selection.SelectionAdjustment.INSTANCE
                    androidx.compose.foundation.text.selection.SelectionAdjustment r0 = r0.getWord()
                    goto L93
                L9c:
                    androidx.compose.ui.text.input.TextFieldValue r2 = r10.getValue$foundation_release()
                    androidx.compose.ui.geometry.Offset r0 = r10.m1454getCurrentDragPosition_m7T9E()
                    kotlin.jvm.internal.k.c(r0)
                    long r3 = r0.m3905unboximpl()
                    r6 = 0
                    r8 = 1
                    r5 = 0
                    r1 = r10
                    long r0 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.m1447access$updateSelection8UEBfa8(r1, r2, r3, r5, r6, r7, r8)
                    goto Lfc
                Lb4:
                    r1 = r10
                    java.lang.Integer r10 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragBeginOffsetInText$p(r1)
                    if (r10 == 0) goto Lc0
                    int r10 = r10.intValue()
                    goto Lc8
                Lc0:
                    long r2 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragBeginPosition$p(r1)
                    int r10 = r0.m1124getOffsetForPosition3MmeM6k(r2, r11)
                Lc8:
                    androidx.compose.ui.geometry.Offset r2 = r1.m1454getCurrentDragPosition_m7T9E()
                    kotlin.jvm.internal.k.c(r2)
                    long r2 = r2.m3905unboximpl()
                    int r0 = r0.m1124getOffsetForPosition3MmeM6k(r2, r11)
                    java.lang.Integer r2 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$getDragBeginOffsetInText$p(r1)
                    if (r2 != 0) goto Le0
                    if (r10 != r0) goto Le0
                    goto L104
                Le0:
                    androidx.compose.ui.text.input.TextFieldValue r2 = r1.getValue$foundation_release()
                    androidx.compose.ui.geometry.Offset r10 = r1.m1454getCurrentDragPosition_m7T9E()
                    kotlin.jvm.internal.k.c(r10)
                    long r3 = r10.m3905unboximpl()
                    androidx.compose.foundation.text.selection.SelectionAdjustment$Companion r10 = androidx.compose.foundation.text.selection.SelectionAdjustment.INSTANCE
                    androidx.compose.foundation.text.selection.SelectionAdjustment r7 = r10.getWord()
                    r8 = 1
                    r5 = 0
                    r6 = 0
                    long r0 = androidx.compose.foundation.text.selection.TextFieldSelectionManager.m1447access$updateSelection8UEBfa8(r1, r2, r3, r5, r6, r7, r8)
                Lfc:
                    androidx.compose.ui.text.TextRange.m6299boximpl(r0)
                Lff:
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager r9 = r9.this$0
                    androidx.compose.foundation.text.selection.TextFieldSelectionManager.access$updateFloatingToolbar(r9, r11)
                L104:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1.mo1092onDragk4lQ0M(long):void");
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1093onStartk4lQ0M(long startPoint) {
                long j5;
                TextLayoutResultProxy layoutResult;
                TextLayoutResultProxy layoutResult2;
                if (this.this$0.getEnabled() && this.this$0.getDraggingHandle() == null) {
                    this.this$0.setDraggingHandle(Handle.SelectionEnd);
                    this.this$0.previousRawDragOffset = -1;
                    this.this$0.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state = this.this$0.getState();
                    if (state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m1125isPositionOnTextk4lQ0M(startPoint)) {
                        j5 = startPoint;
                        LegacyTextFieldState state2 = this.this$0.getState();
                        if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = this.this$0;
                            int iTransformedToOriginal = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m1123getOffsetForPosition3MmeM6k$default(layoutResult, j5, false, 2, null));
                            TextFieldValue textFieldValueM1448createTextFieldValueFDrldGo = textFieldSelectionManager.m1448createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(iTransformedToOriginal, iTransformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo4903performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m4920getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange().invoke(textFieldValueM1448createTextFieldValueFDrldGo);
                        }
                    } else {
                        if (this.this$0.getValue$foundation_release().getText().length() == 0) {
                            return;
                        }
                        this.this$0.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = this.this$0;
                        j5 = startPoint;
                        this.this$0.dragBeginOffsetInText = Integer.valueOf(TextRange.m6311getStartimpl(textFieldSelectionManager2.m1451updateSelection8UEBfa8(TextFieldValue.m6554copy3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.INSTANCE.m6316getZerod9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, SelectionAdjustment.INSTANCE.getWord(), true)));
                    }
                    this.this$0.setHandleState(HandleState.None);
                    this.this$0.dragBeginPosition = j5;
                    TextFieldSelectionManager textFieldSelectionManager3 = this.this$0;
                    textFieldSelectionManager3.m1450setCurrentDragPosition_kEHs6E(Offset.m3884boximpl(textFieldSelectionManager3.dragBeginPosition));
                    this.this$0.dragTotalDistance = Offset.INSTANCE.m3911getZeroF1C5BW0();
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1311onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0 || (state = this.this$0.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(this.this$0.getValue$foundation_release(), dragPosition, false, adjustment);
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1312onExtendk4lQ0M(long downPosition) {
                LegacyTextFieldState state = this.this$0.getState();
                if (state == null || state.getLayoutResult() == null || !this.this$0.getEnabled()) {
                    return false;
                }
                this.this$0.previousRawDragOffset = -1;
                updateMouseSelection(this.this$0.getValue$foundation_release(), downPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo1313onExtendDragk4lQ0M(long dragPosition) {
                LegacyTextFieldState state;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0 || (state = this.this$0.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                updateMouseSelection(this.this$0.getValue$foundation_release(), dragPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-3MmeM6k */
            public boolean mo1314onStart3MmeM6k(long downPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                if (!this.this$0.getEnabled() || this.this$0.getValue$foundation_release().getText().length() == 0 || (state = this.this$0.getState()) == null || state.getLayoutResult() == null) {
                    return false;
                }
                FocusRequester focusRequester = this.this$0.getFocusRequester();
                if (focusRequester != null) {
                    focusRequester.requestFocus();
                }
                this.this$0.dragBeginPosition = downPosition;
                this.this$0.previousRawDragOffset = -1;
                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(this.this$0, false, 1, null);
                updateMouseSelection(this.this$0.getValue$foundation_release(), this.this$0.dragBeginPosition, true, adjustment);
                return true;
            }

            public final void updateMouseSelection(TextFieldValue value, long currentPosition, boolean isStartOfSelection, SelectionAdjustment adjustment) {
                this.this$0.setHandleState(TextRange.m6305getCollapsedimpl(this.this$0.m1451updateSelection8UEBfa8(value, currentPosition, isStartOfSelection, false, adjustment, false)) ? HandleState.Cursor : HandleState.Selection);
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, e eVar) {
        this((i & 1) != 0 ? null : undoManager);
    }
}
