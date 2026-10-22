package androidx.compose.foundation.text.input.internal;

import S7.k;
import android.os.CancellationSignal;
import android.view.inputmethod.DeleteGesture;
import android.view.inputmethod.DeleteRangeGesture;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InsertGesture;
import android.view.inputmethod.JoinOrSplitGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import android.view.inputmethod.RemoveSpaceGesture;
import android.view.inputmethod.SelectGesture;
import android.view.inputmethod.SelectRangeGesture;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.InterfaceC1616j;
import j9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.Regex;

@StabilityInferred(parameters = 1)
@RequiresApi(34)
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000e\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0015\u001a\u00020\u0012*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014JC\u0010\u000e\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0001¢\u0006\u0004\b\f\u0010\u001eJ/\u0010\u0015\u001a\u00020\u0012*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u001fJ#\u0010!\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\u001c*\u00020\u00042\u0006\u0010\u0017\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b#\u0010$J#\u0010&\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u00020%2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u001c*\u00020\u00042\u0006\u0010\u0017\u001a\u00020%2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b(\u0010)J#\u0010+\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u00020*2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b+\u0010,J#\u0010-\u001a\u00020\u001c*\u00020\u00042\u0006\u0010\u0017\u001a\u00020*2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b-\u0010.J#\u00100\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u00020/2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b0\u00101J#\u00102\u001a\u00020\u001c*\u00020\u00042\u0006\u0010\u0017\u001a\u00020/2\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b2\u00103J-\u00105\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u0002042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0004\b5\u00106J-\u00108\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u0002072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0004\b8\u00109J-\u0010;\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u00020:2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0003¢\u0006\u0004\b;\u0010<J&\u0010B\u001a\u00020\u001c*\u00020\u00042\u0006\u0010>\u001a\u00020=2\u0006\u0010?\u001a\u00020\u0012H\u0003ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u001b\u0010C\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0005H\u0003¢\u0006\u0004\bC\u0010DJ&\u0010J\u001a\u00020\u001c*\u00020\u00042\u0006\u0010E\u001a\u00020=2\u0006\u0010G\u001a\u00020FH\u0002ø\u0001\u0000¢\u0006\u0004\bH\u0010IJ9\u0010!\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020 2\b\u0010K\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b!\u0010LJ%\u0010#\u001a\u00020\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020 2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0003¢\u0006\u0004\b#\u0010MJ7\u0010&\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020%2\u0006\u0010O\u001a\u00020N2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b&\u0010PJ%\u0010(\u001a\u00020\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020%2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0003¢\u0006\u0004\b(\u0010QJ9\u0010+\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020*2\b\u0010K\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b+\u0010RJ%\u0010-\u001a\u00020\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020*2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0003¢\u0006\u0004\b-\u0010SJ7\u00100\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020/2\u0006\u0010O\u001a\u00020N2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b0\u0010TJ%\u00102\u001a\u00020\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020/2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0003¢\u0006\u0004\b2\u0010UJA\u00105\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u0002042\u0006\u0010O\u001a\u00020N2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b5\u0010VJ9\u00108\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u0002072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b8\u0010WJA\u0010;\u001a\u00020\u000b*\u00020\u00162\u0006\u0010\u0017\u001a\u00020:2\u0006\u0010O\u001a\u00020N2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b;\u0010XJ3\u0010[\u001a\u00020\u001c2\u0006\u0010Y\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020Z2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\b[\u0010\\J8\u0010_\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020=2\b\u0010K\u001a\u0004\u0018\u00010\u00182\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b]\u0010^J>\u0010b\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020=2\u0006\u0010O\u001a\u00020N2\u0006\u0010?\u001a\u00020\u00122\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b`\u0010aJ+\u0010c\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0003¢\u0006\u0004\bc\u0010dJ\u0019\u0010h\u001a\u00020e*\u00020\u000bH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010g\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/foundation/text/input/internal/HandwritingGestureApi34;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "Landroid/view/inputmethod/HandwritingGesture;", "handwritingGesture", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "layoutState", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "", "performHandwritingGesture$foundation_release", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/HandwritingGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/platform/ViewConfiguration;)I", "performHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "Landroid/os/CancellationSignal;", "cancellationSignal", "", "previewHandwritingGesture$foundation_release", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/PreviewableHandwritingGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroid/os/CancellationSignal;)Z", "previewHandwritingGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "gesture", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "textFieldSelectionManager", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/EditCommand;", "LC7/r;", "editCommandConsumer", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/HandwritingGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/platform/ViewConfiguration;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/PreviewableHandwritingGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroid/os/CancellationSignal;)Z", "Landroid/view/inputmethod/SelectGesture;", "performSelectGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/SelectGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)I", "previewSelectGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/SelectGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "Landroid/view/inputmethod/DeleteGesture;", "performDeleteGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/DeleteGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)I", "previewDeleteGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/DeleteGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "Landroid/view/inputmethod/SelectRangeGesture;", "performSelectRangeGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/SelectRangeGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)I", "previewSelectRangeGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/SelectRangeGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "Landroid/view/inputmethod/DeleteRangeGesture;", "performDeleteRangeGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/DeleteRangeGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)I", "previewDeleteRangeGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/DeleteRangeGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "Landroid/view/inputmethod/JoinOrSplitGesture;", "performJoinOrSplitGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/JoinOrSplitGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/platform/ViewConfiguration;)I", "Landroid/view/inputmethod/InsertGesture;", "performInsertGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/InsertGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/platform/ViewConfiguration;)I", "Landroid/view/inputmethod/RemoveSpaceGesture;", "performRemoveSpaceGesture", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/RemoveSpaceGesture;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/platform/ViewConfiguration;)I", "Landroidx/compose/ui/text/TextRange;", "rangeInTransformedText", "adjustRange", "performDeletion-Sb-Bc2M", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JZ)V", "performDeletion", "fallback", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroid/view/inputmethod/HandwritingGesture;)I", "range", "Landroidx/compose/foundation/text/input/TextHighlightType;", "type", "highlightRange-XJREzCE", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;JI)V", "highlightRange", "textSelectionManager", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/SelectGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/SelectGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "Landroidx/compose/ui/text/AnnotatedString;", "text", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/DeleteGesture;Landroidx/compose/ui/text/AnnotatedString;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/DeleteGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/SelectRangeGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/SelectRangeGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/DeleteRangeGesture;Landroidx/compose/ui/text/AnnotatedString;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/DeleteRangeGesture;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)V", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/JoinOrSplitGesture;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/platform/ViewConfiguration;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/InsertGesture;Landroidx/compose/ui/platform/ViewConfiguration;LS7/k;)I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroid/view/inputmethod/RemoveSpaceGesture;Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/platform/ViewConfiguration;LS7/k;)I", TypedValues.CycleType.S_WAVE_OFFSET, "", "performInsertionOnLegacyTextField", "(ILjava/lang/String;LS7/k;)V", "performSelectionOnLegacyTextField-8ffj60Q", "(JLandroidx/compose/foundation/text/selection/TextFieldSelectionManager;LS7/k;)V", "performSelectionOnLegacyTextField", "performDeletionOnLegacyTextField-vJH6DeI", "(JLandroidx/compose/ui/text/AnnotatedString;ZLS7/k;)V", "performDeletionOnLegacyTextField", "fallbackOnLegacyTextField", "(Landroid/view/inputmethod/HandwritingGesture;LS7/k;)I", "Landroidx/compose/ui/text/TextGranularity;", "toTextGranularity-NUwxegE", "(I)I", "toTextGranularity", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HandwritingGestureApi34 {
    public static final int $stable = 0;
    public static final HandwritingGestureApi34 INSTANCE = new HandwritingGestureApi34();

    private HandwritingGestureApi34() {
    }

    @DoNotInline
    private final int fallback(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().clearHighlight();
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
        String fallbackText = handwritingGesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        TransformedTextFieldState.replaceSelectedText$default(transformedTextFieldState, fallbackText, true, null, 4, null);
        return 5;
    }

    @DoNotInline
    private final int fallbackOnLegacyTextField(HandwritingGesture gesture, k editCommandConsumer) {
        String fallbackText = gesture.getFallbackText();
        if (fallbackText == null) {
            return 3;
        }
        editCommandConsumer.invoke(new CommitTextCommand(fallbackText, 1));
        return 5;
    }

    /* renamed from: highlightRange-XJREzCE, reason: not valid java name */
    private final void m1178highlightRangeXJREzCE(TransformedTextFieldState transformedTextFieldState, long j5, int i) {
        if (!TextRange.m6305getCollapsedimpl(j5)) {
            transformedTextFieldState.m1262highlightCharsIn7RAjNK8(i, j5);
            return;
        }
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().clearHighlight();
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    @DoNotInline
    private final int performDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        int iM1182toTextGranularityNUwxegE = m1182toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM1200getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1200getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM1182toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1200getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, e.n(deleteGesture));
        }
        m1179performDeletionSbBc2M(transformedTextFieldState, jM1200getRangeForScreenRectOH9lIzo, TextGranularity.m6269equalsimpl0(iM1182toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6274getWordDRrd7Zo()));
        return 1;
    }

    @DoNotInline
    private final int performDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        int iM1182toTextGranularityNUwxegE = m1182toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM1202getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1202getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM1182toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1202getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, e.n(deleteRangeGesture));
        }
        m1179performDeletionSbBc2M(transformedTextFieldState, jM1202getRangeForScreenRectsO048IG0, TextGranularity.m6269equalsimpl0(iM1182toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6274getWordDRrd7Zo()));
        return 1;
    }

    @DoNotInline
    /* renamed from: performDeletion-Sb-Bc2M, reason: not valid java name */
    private final void m1179performDeletionSbBc2M(TransformedTextFieldState transformedTextFieldState, long j5, boolean z10) {
        if (z10) {
            j5 = HandwritingGesture_androidKt.m1191adjustHandwritingDeleteGestureRange72CqOWE(j5, transformedTextFieldState.getVisualText());
        }
        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(transformedTextFieldState, "", j5, null, false, 12, null);
    }

    @DoNotInline
    /* renamed from: performDeletionOnLegacyTextField-vJH6DeI, reason: not valid java name */
    private final void m1180performDeletionOnLegacyTextFieldvJH6DeI(long range, AnnotatedString text, boolean adjustRange, k editCommandConsumer) {
        if (adjustRange) {
            range = HandwritingGesture_androidKt.m1191adjustHandwritingDeleteGestureRange72CqOWE(range, text);
        }
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(TextRange.m6306getEndimpl(range), TextRange.m6306getEndimpl(range)), new DeleteSurroundingTextCommand(TextRange.m6307getLengthimpl(range), 0)));
    }

    @DoNotInline
    private final int performInsertGesture(TransformedTextFieldState transformedTextFieldState, InsertGesture insertGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        int iM1195getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1195getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
        if (iM1195getOffsetForHandwritingGestured4ec7I == -1) {
            return fallback(transformedTextFieldState, e.n(insertGesture));
        }
        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(transformedTextFieldState, insertGesture.getTextToInsert(), TextRangeKt.TextRange(iM1195getOffsetForHandwritingGestured4ec7I), null, false, 12, null);
        return 1;
    }

    @DoNotInline
    private final void performInsertionOnLegacyTextField(int offset, String text, k editCommandConsumer) {
        editCommandConsumer.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(offset, offset), new CommitTextCommand(text, 1)));
    }

    @DoNotInline
    private final int performJoinOrSplitGesture(TransformedTextFieldState transformedTextFieldState, JoinOrSplitGesture joinOrSplitGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        TextLayoutResult layoutResult;
        if (transformedTextFieldState.getOutputText() != transformedTextFieldState.getUntransformedText()) {
            return 3;
        }
        int iM1195getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1195getOffsetForHandwritingGestured4ec7I(textLayoutState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
        if (iM1195getOffsetForHandwritingGestured4ec7I == -1 || ((layoutResult = textLayoutState.getLayoutResult()) != null && HandwritingGesture_androidKt.isBiDiBoundary(layoutResult, iM1195getOffsetForHandwritingGestured4ec7I))) {
            return fallback(transformedTextFieldState, e.n(joinOrSplitGesture));
        }
        long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(transformedTextFieldState.getVisualText(), iM1195getOffsetForHandwritingGestured4ec7I);
        if (TextRange.m6305getCollapsedimpl(jRangeOfWhitespaces)) {
            TransformedTextFieldState.m1261replaceTextM8tDOmk$default(transformedTextFieldState, " ", jRangeOfWhitespaces, null, false, 12, null);
            return 1;
        }
        m1179performDeletionSbBc2M(transformedTextFieldState, jRangeOfWhitespaces, false);
        return 1;
    }

    @DoNotInline
    private final int performRemoveSpaceGesture(TransformedTextFieldState transformedTextFieldState, RemoveSpaceGesture removeSpaceGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        long jM1197getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1197getRangeForRemoveSpaceGesture5iVPX68(textLayoutState.getLayoutResult(), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
        if (TextRange.m6305getCollapsedimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallback(transformedTextFieldState, e.n(removeSpaceGesture));
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f4918a = -1;
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.f4918a = -1;
        String strE = new Regex("\\s+").e(new k() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final CharSequence invoke(InterfaceC1616j interfaceC1616j) {
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                if (ref$IntRef3.f4918a == -1) {
                    ref$IntRef3.f4918a = ((l) interfaceC1616j).b().f1569a;
                }
                ref$IntRef2.f4918a = ((l) interfaceC1616j).b().b + 1;
                return "";
            }
        }, TextRangeKt.m6318substringFDrldGo(transformedTextFieldState.getVisualText(), jM1197getRangeForRemoveSpaceGesture5iVPX68));
        if (ref$IntRef.f4918a == -1 || ref$IntRef2.f4918a == -1) {
            return fallback(transformedTextFieldState, e.n(removeSpaceGesture));
        }
        long jTextRange = TextRangeKt.TextRange(TextRange.m6311getStartimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef.f4918a, TextRange.m6311getStartimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef2.f4918a);
        String strSubstring = strE.substring(ref$IntRef.f4918a, strE.length() - (TextRange.m6307getLengthimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68) - ref$IntRef2.f4918a));
        kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        TransformedTextFieldState.m1261replaceTextM8tDOmk$default(transformedTextFieldState, strSubstring, jTextRange, null, false, 12, null);
        return 1;
    }

    @DoNotInline
    private final int performSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        long jM1200getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1200getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1182toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1200getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallback(transformedTextFieldState, e.n(selectGesture));
        }
        transformedTextFieldState.m1268selectCharsIn5zctL8(jM1200getRangeForScreenRectOH9lIzo);
        return 1;
    }

    @DoNotInline
    private final int performSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        long jM1202getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1202getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1182toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1202getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallback(transformedTextFieldState, e.n(selectRangeGesture));
        }
        transformedTextFieldState.m1268selectCharsIn5zctL8(jM1202getRangeForScreenRectsO048IG0);
        return 1;
    }

    @DoNotInline
    /* renamed from: performSelectionOnLegacyTextField-8ffj60Q, reason: not valid java name */
    private final void m1181performSelectionOnLegacyTextField8ffj60Q(long range, TextFieldSelectionManager textSelectionManager, k editCommandConsumer) {
        editCommandConsumer.invoke(new SetSelectionCommand(TextRange.m6311getStartimpl(range), TextRange.m6306getEndimpl(range)));
        if (textSelectionManager != null) {
            textSelectionManager.enterSelectionMode$foundation_release(true);
        }
    }

    @DoNotInline
    private final void previewDeleteGesture(TransformedTextFieldState transformedTextFieldState, DeleteGesture deleteGesture, TextLayoutState textLayoutState) {
        m1178highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1200getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1182toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1154getHandwritingDeletePreviewsxJuwY());
    }

    @DoNotInline
    private final void previewDeleteRangeGesture(TransformedTextFieldState transformedTextFieldState, DeleteRangeGesture deleteRangeGesture, TextLayoutState textLayoutState) {
        m1178highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1202getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1182toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1154getHandwritingDeletePreviewsxJuwY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$1(TransformedTextFieldState transformedTextFieldState) {
        TextFieldState textFieldState = transformedTextFieldState.textFieldState;
        InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        textFieldState.getMainBuffer().clearHighlight();
        textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void previewHandwritingGesture$lambda$9(TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.clearPreviewHighlight$foundation_release();
        }
    }

    @DoNotInline
    private final void previewSelectGesture(TransformedTextFieldState transformedTextFieldState, SelectGesture selectGesture, TextLayoutState textLayoutState) {
        m1178highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1200getRangeForScreenRectOH9lIzo(textLayoutState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1182toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1155getHandwritingSelectPreviewsxJuwY());
    }

    @DoNotInline
    private final void previewSelectRangeGesture(TransformedTextFieldState transformedTextFieldState, SelectRangeGesture selectRangeGesture, TextLayoutState textLayoutState) {
        m1178highlightRangeXJREzCE(transformedTextFieldState, HandwritingGesture_androidKt.m1202getRangeForScreenRectsO048IG0(textLayoutState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1182toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()), TextHighlightType.INSTANCE.m1155getHandwritingSelectPreviewsxJuwY());
    }

    @DoNotInline
    /* renamed from: toTextGranularity-NUwxegE, reason: not valid java name */
    private final int m1182toTextGranularityNUwxegE(int i) {
        return i != 1 ? i != 2 ? TextGranularity.INSTANCE.m6273getCharacterDRrd7Zo() : TextGranularity.INSTANCE.m6273getCharacterDRrd7Zo() : TextGranularity.INSTANCE.m6274getWordDRrd7Zo();
    }

    @DoNotInline
    public final int performHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, HandwritingGesture handwritingGesture, TextLayoutState textLayoutState, ViewConfiguration viewConfiguration) {
        if (e.w(handwritingGesture)) {
            return performSelectGesture(transformedTextFieldState, e.o(handwritingGesture), textLayoutState);
        }
        if (d.r(handwritingGesture)) {
            return performDeleteGesture(transformedTextFieldState, d.h(handwritingGesture), textLayoutState);
        }
        if (d.u(handwritingGesture)) {
            return performSelectRangeGesture(transformedTextFieldState, d.m(handwritingGesture), textLayoutState);
        }
        if (d.w(handwritingGesture)) {
            return performDeleteRangeGesture(transformedTextFieldState, d.i(handwritingGesture), textLayoutState);
        }
        if (d.C(handwritingGesture)) {
            return performJoinOrSplitGesture(transformedTextFieldState, d.k(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (d.y(handwritingGesture)) {
            return performInsertGesture(transformedTextFieldState, d.j(handwritingGesture), textLayoutState, viewConfiguration);
        }
        if (d.A(handwritingGesture)) {
            return performRemoveSpaceGesture(transformedTextFieldState, d.l(handwritingGesture), textLayoutState, viewConfiguration);
        }
        return 2;
    }

    @DoNotInline
    public final boolean previewHandwritingGesture$foundation_release(TransformedTextFieldState transformedTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextLayoutState textLayoutState, CancellationSignal cancellationSignal) {
        if (e.w(previewableHandwritingGesture)) {
            previewSelectGesture(transformedTextFieldState, e.o(previewableHandwritingGesture), textLayoutState);
        } else if (d.r(previewableHandwritingGesture)) {
            previewDeleteGesture(transformedTextFieldState, d.h(previewableHandwritingGesture), textLayoutState);
        } else if (d.u(previewableHandwritingGesture)) {
            previewSelectRangeGesture(transformedTextFieldState, d.m(previewableHandwritingGesture), textLayoutState);
        } else {
            if (!d.w(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(transformedTextFieldState, d.i(previewableHandwritingGesture), textLayoutState);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new f(transformedTextFieldState, 1));
        return true;
    }

    @DoNotInline
    private final int performInsertGesture(LegacyTextFieldState legacyTextFieldState, InsertGesture insertGesture, ViewConfiguration viewConfiguration, k kVar) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM1194getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1194getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(insertGesture.getInsertionPoint()), viewConfiguration);
            if (iM1194getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, iM1194getOffsetForHandwritingGestured4ec7I))) {
                performInsertionOnLegacyTextField(iM1194getOffsetForHandwritingGestured4ec7I, insertGesture.getTextToInsert(), kVar);
                return 1;
            }
            return fallbackOnLegacyTextField(e.n(insertGesture), kVar);
        }
        return fallbackOnLegacyTextField(e.n(insertGesture), kVar);
    }

    @DoNotInline
    public final boolean previewHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, PreviewableHandwritingGesture previewableHandwritingGesture, TextFieldSelectionManager textFieldSelectionManager, CancellationSignal cancellationSignal) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return false;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!untransformedText.equals((layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return false;
        }
        if (e.w(previewableHandwritingGesture)) {
            previewSelectGesture(legacyTextFieldState, e.o(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (d.r(previewableHandwritingGesture)) {
            previewDeleteGesture(legacyTextFieldState, d.h(previewableHandwritingGesture), textFieldSelectionManager);
        } else if (d.u(previewableHandwritingGesture)) {
            previewSelectRangeGesture(legacyTextFieldState, d.m(previewableHandwritingGesture), textFieldSelectionManager);
        } else {
            if (!d.w(previewableHandwritingGesture)) {
                return false;
            }
            previewDeleteRangeGesture(legacyTextFieldState, d.i(previewableHandwritingGesture), textFieldSelectionManager);
        }
        if (cancellationSignal == null) {
            return true;
        }
        cancellationSignal.setOnCancelListener(new f(textFieldSelectionManager, 0));
        return true;
    }

    @DoNotInline
    private final int performSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager, k kVar) {
        long jM1199getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1199getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1182toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1199getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(e.n(selectGesture), kVar);
        }
        m1181performSelectionOnLegacyTextField8ffj60Q(jM1199getRangeForScreenRectOH9lIzo, textFieldSelectionManager, kVar);
        return 1;
    }

    @DoNotInline
    private final void previewDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1457setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1199getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), m1182toTextGranularityNUwxegE(deleteGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final void previewSelectGesture(LegacyTextFieldState legacyTextFieldState, SelectGesture selectGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1458setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1199getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectGesture.getSelectionArea()), m1182toTextGranularityNUwxegE(selectGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final int performDeleteGesture(LegacyTextFieldState legacyTextFieldState, DeleteGesture deleteGesture, AnnotatedString annotatedString, k kVar) {
        int iM1182toTextGranularityNUwxegE = m1182toTextGranularityNUwxegE(deleteGesture.getGranularity());
        long jM1199getRangeForScreenRectOH9lIzo = HandwritingGesture_androidKt.m1199getRangeForScreenRectOH9lIzo(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteGesture.getDeletionArea()), iM1182toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1199getRangeForScreenRectOH9lIzo)) {
            return INSTANCE.fallbackOnLegacyTextField(e.n(deleteGesture), kVar);
        }
        m1180performDeletionOnLegacyTextFieldvJH6DeI(jM1199getRangeForScreenRectOH9lIzo, annotatedString, TextGranularity.m6269equalsimpl0(iM1182toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6274getWordDRrd7Zo()), kVar);
        return 1;
    }

    @DoNotInline
    private final int performSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager, k kVar) {
        long jM1201getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1201getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1182toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1201getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(e.n(selectRangeGesture), kVar);
        }
        m1181performSelectionOnLegacyTextField8ffj60Q(jM1201getRangeForScreenRectsO048IG0, textFieldSelectionManager, kVar);
        return 1;
    }

    @DoNotInline
    private final void previewDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1457setDeletionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1201getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), m1182toTextGranularityNUwxegE(deleteRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final void previewSelectRangeGesture(LegacyTextFieldState legacyTextFieldState, SelectRangeGesture selectRangeGesture, TextFieldSelectionManager textFieldSelectionManager) {
        if (textFieldSelectionManager != null) {
            textFieldSelectionManager.m1458setSelectionPreviewHighlight5zctL8$foundation_release(HandwritingGesture_androidKt.m1201getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionStartArea()), RectHelper_androidKt.toComposeRect(selectRangeGesture.getSelectionEndArea()), m1182toTextGranularityNUwxegE(selectRangeGesture.getGranularity()), TextInclusionStrategy.INSTANCE.getContainsCenter()));
        }
    }

    @DoNotInline
    private final int performDeleteRangeGesture(LegacyTextFieldState legacyTextFieldState, DeleteRangeGesture deleteRangeGesture, AnnotatedString annotatedString, k kVar) {
        int iM1182toTextGranularityNUwxegE = m1182toTextGranularityNUwxegE(deleteRangeGesture.getGranularity());
        long jM1201getRangeForScreenRectsO048IG0 = HandwritingGesture_androidKt.m1201getRangeForScreenRectsO048IG0(legacyTextFieldState, RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionStartArea()), RectHelper_androidKt.toComposeRect(deleteRangeGesture.getDeletionEndArea()), iM1182toTextGranularityNUwxegE, TextInclusionStrategy.INSTANCE.getContainsCenter());
        if (TextRange.m6305getCollapsedimpl(jM1201getRangeForScreenRectsO048IG0)) {
            return INSTANCE.fallbackOnLegacyTextField(e.n(deleteRangeGesture), kVar);
        }
        m1180performDeletionOnLegacyTextFieldvJH6DeI(jM1201getRangeForScreenRectsO048IG0, annotatedString, TextGranularity.m6269equalsimpl0(iM1182toTextGranularityNUwxegE, TextGranularity.INSTANCE.m6274getWordDRrd7Zo()), kVar);
        return 1;
    }

    @DoNotInline
    private final int performJoinOrSplitGesture(LegacyTextFieldState legacyTextFieldState, JoinOrSplitGesture joinOrSplitGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, k kVar) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        if (viewConfiguration != null) {
            int iM1194getOffsetForHandwritingGestured4ec7I = HandwritingGesture_androidKt.m1194getOffsetForHandwritingGestured4ec7I(legacyTextFieldState, HandwritingGesture_androidKt.toOffset(joinOrSplitGesture.getJoinOrSplitPoint()), viewConfiguration);
            if (iM1194getOffsetForHandwritingGestured4ec7I != -1 && ((layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null || !HandwritingGesture_androidKt.isBiDiBoundary(value, iM1194getOffsetForHandwritingGestured4ec7I))) {
                long jRangeOfWhitespaces = HandwritingGesture_androidKt.rangeOfWhitespaces(annotatedString, iM1194getOffsetForHandwritingGestured4ec7I);
                if (TextRange.m6305getCollapsedimpl(jRangeOfWhitespaces)) {
                    performInsertionOnLegacyTextField(TextRange.m6311getStartimpl(jRangeOfWhitespaces), " ", kVar);
                    return 1;
                }
                m1180performDeletionOnLegacyTextFieldvJH6DeI(jRangeOfWhitespaces, annotatedString, false, kVar);
                return 1;
            }
            return fallbackOnLegacyTextField(e.n(joinOrSplitGesture), kVar);
        }
        return fallbackOnLegacyTextField(e.n(joinOrSplitGesture), kVar);
    }

    @DoNotInline
    public final int performHandwritingGesture$foundation_release(LegacyTextFieldState legacyTextFieldState, HandwritingGesture handwritingGesture, TextFieldSelectionManager textFieldSelectionManager, ViewConfiguration viewConfiguration, k kVar) {
        TextLayoutResult value;
        TextLayoutInput layoutInput;
        AnnotatedString untransformedText = legacyTextFieldState.getUntransformedText();
        if (untransformedText == null) {
            return 3;
        }
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (!untransformedText.equals((layoutResult == null || (value = layoutResult.getValue()) == null || (layoutInput = value.getLayoutInput()) == null) ? null : layoutInput.getText())) {
            return 3;
        }
        if (e.w(handwritingGesture)) {
            return performSelectGesture(legacyTextFieldState, e.o(handwritingGesture), textFieldSelectionManager, kVar);
        }
        if (d.r(handwritingGesture)) {
            return performDeleteGesture(legacyTextFieldState, d.h(handwritingGesture), untransformedText, kVar);
        }
        if (d.u(handwritingGesture)) {
            return performSelectRangeGesture(legacyTextFieldState, d.m(handwritingGesture), textFieldSelectionManager, kVar);
        }
        if (d.w(handwritingGesture)) {
            return performDeleteRangeGesture(legacyTextFieldState, d.i(handwritingGesture), untransformedText, kVar);
        }
        if (d.C(handwritingGesture)) {
            return performJoinOrSplitGesture(legacyTextFieldState, d.k(handwritingGesture), untransformedText, viewConfiguration, kVar);
        }
        if (d.y(handwritingGesture)) {
            return performInsertGesture(legacyTextFieldState, d.j(handwritingGesture), viewConfiguration, kVar);
        }
        if (d.A(handwritingGesture)) {
            return performRemoveSpaceGesture(legacyTextFieldState, d.l(handwritingGesture), untransformedText, viewConfiguration, kVar);
        }
        return 2;
    }

    @DoNotInline
    private final int performRemoveSpaceGesture(LegacyTextFieldState legacyTextFieldState, RemoveSpaceGesture removeSpaceGesture, AnnotatedString annotatedString, ViewConfiguration viewConfiguration, k kVar) {
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        long jM1197getRangeForRemoveSpaceGesture5iVPX68 = HandwritingGesture_androidKt.m1197getRangeForRemoveSpaceGesture5iVPX68(layoutResult != null ? layoutResult.getValue() : null, HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getStartPoint()), HandwritingGesture_androidKt.toOffset(removeSpaceGesture.getEndPoint()), legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
        if (TextRange.m6305getCollapsedimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68)) {
            return INSTANCE.fallbackOnLegacyTextField(e.n(removeSpaceGesture), kVar);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f4918a = -1;
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.f4918a = -1;
        String strE = new Regex("\\s+").e(new k() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGestureApi34$performRemoveSpaceGesture$newText$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final CharSequence invoke(InterfaceC1616j interfaceC1616j) {
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                if (ref$IntRef3.f4918a == -1) {
                    ref$IntRef3.f4918a = ((l) interfaceC1616j).b().f1569a;
                }
                ref$IntRef2.f4918a = ((l) interfaceC1616j).b().b + 1;
                return "";
            }
        }, TextRangeKt.m6318substringFDrldGo(annotatedString, jM1197getRangeForRemoveSpaceGesture5iVPX68));
        if (ref$IntRef.f4918a != -1 && ref$IntRef2.f4918a != -1) {
            int iM6311getStartimpl = TextRange.m6311getStartimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef.f4918a;
            int iM6311getStartimpl2 = TextRange.m6311getStartimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68) + ref$IntRef2.f4918a;
            String strSubstring = strE.substring(ref$IntRef.f4918a, strE.length() - (TextRange.m6307getLengthimpl(jM1197getRangeForRemoveSpaceGesture5iVPX68) - ref$IntRef2.f4918a));
            kotlin.jvm.internal.k.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            kVar.invoke(HandwritingGesture_androidKt.compoundEditCommand(new SetSelectionCommand(iM6311getStartimpl, iM6311getStartimpl2), new CommitTextCommand(strSubstring, 1)));
            return 1;
        }
        return fallbackOnLegacyTextField(e.n(removeSpaceGesture), kVar);
    }
}
