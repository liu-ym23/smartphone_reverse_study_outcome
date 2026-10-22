package androidx.compose.runtime.changelist;

import S7.k;
import S7.n;
import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 ¡\u00012\u00020\u0001:\u0002¡\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001eJ\u001f\u0010\"\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010!\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\n2\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\b+\u0010\fJ\r\u0010,\u001a\u00020\n¢\u0006\u0004\b,\u0010\u000fJ\u0017\u0010.\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b.\u0010/J\r\u00100\u001a\u00020\n¢\u0006\u0004\b0\u0010\u000fJ\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u0010\u000fJ\r\u00102\u001a\u00020\n¢\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\n¢\u0006\u0004\b3\u0010\u000fJ\u001d\u00106\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J%\u00106\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u00105\u001a\u0002042\u0006\u00109\u001a\u000208¢\u0006\u0004\b6\u0010:J\u0015\u0010<\u001a\u00020\n2\u0006\u0010;\u001a\u00020\b¢\u0006\u0004\b<\u0010\fJ)\u0010A\u001a\u00020\n2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\n0=2\u0006\u0010@\u001a\u00020>¢\u0006\u0004\bA\u0010BJ\u0017\u0010D\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bD\u0010/J;\u0010H\u001a\u00020\n\"\u0004\b\u0000\u0010E\"\u0004\b\u0001\u0010F2\u0006\u0010\u0018\u001a\u00028\u00012\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0G¢\u0006\u0004\bH\u0010IJ\u001d\u0010K\u001a\u00020\n2\u0006\u0010J\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\bK\u0010LJ%\u0010N\u001a\u00020\n2\u0006\u00105\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020\n¢\u0006\u0004\bP\u0010\u000fJ\r\u0010Q\u001a\u00020\n¢\u0006\u0004\bQ\u0010\u000fJ\u001d\u0010S\u001a\u00020\n2\u0006\u0010J\u001a\u00020\b2\u0006\u0010R\u001a\u00020\b¢\u0006\u0004\bS\u0010LJ\r\u0010T\u001a\u00020\n¢\u0006\u0004\bT\u0010\u000fJ\u0017\u0010U\u001a\u00020\n2\b\u0010C\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bU\u0010/J\u001b\u0010W\u001a\u00020\n2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\u0004\bW\u0010\u0016J\u001d\u0010Z\u001a\u00020\n2\u0006\u0010Y\u001a\u00020X2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\bZ\u0010[J%\u0010_\u001a\u00020\n2\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\\2\u0006\u0010^\u001a\u00020X¢\u0006\u0004\b_\u0010`J/\u0010f\u001a\u00020\n2\b\u0010b\u001a\u0004\u0018\u00010a2\u0006\u0010d\u001a\u00020c2\u0006\u00105\u001a\u00020e2\u0006\u0010M\u001a\u00020e¢\u0006\u0004\bf\u0010gJ%\u0010j\u001a\u00020\n2\u0006\u0010@\u001a\u00020h2\u0006\u0010d\u001a\u00020c2\u0006\u0010i\u001a\u00020e¢\u0006\u0004\bj\u0010kJ\r\u0010l\u001a\u00020\n¢\u0006\u0004\bl\u0010\u000fJ!\u0010n\u001a\u00020\n2\u0006\u0010m\u001a\u00020\u00042\n\b\u0002\u0010^\u001a\u0004\u0018\u00010X¢\u0006\u0004\bn\u0010oJ\r\u0010p\u001a\u00020\n¢\u0006\u0004\bp\u0010\u000fJ\r\u0010q\u001a\u00020\n¢\u0006\u0004\bq\u0010\u000fJ\r\u0010r\u001a\u00020\n¢\u0006\u0004\br\u0010\u000fJ\u000f\u0010s\u001a\u00020\nH\u0002¢\u0006\u0004\bs\u0010\u000fJ\u000f\u0010t\u001a\u00020\nH\u0002¢\u0006\u0004\bt\u0010\u000fJ\u0019\u0010w\u001a\u00020\n2\b\b\u0002\u0010v\u001a\u00020uH\u0002¢\u0006\u0004\bw\u0010xJ\u000f\u0010y\u001a\u00020\nH\u0002¢\u0006\u0004\by\u0010\u000fJ\u0017\u0010z\u001a\u00020\n2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\bz\u0010{J\u0019\u0010}\u001a\u00020\n2\b\b\u0002\u0010|\u001a\u00020uH\u0002¢\u0006\u0004\b}\u0010xJ\u000f\u0010~\u001a\u00020\nH\u0002¢\u0006\u0004\b~\u0010\u000fJ\"\u0010\u0081\u0001\u001a\u00020\n2\u0006\u0010\u007f\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0002¢\u0006\u0005\b\u0081\u0001\u0010LJ)\u0010\u0082\u0001\u001a\u00020\n2\u0006\u0010M\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002¢\u0006\u0005\b\u0082\u0001\u0010OJ\u0011\u0010\u0083\u0001\u001a\u00020\nH\u0002¢\u0006\u0005\b\u0083\u0001\u0010\u000fR\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010\u0084\u0001R'\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0005\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020u8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R(\u0010\u008f\u0001\u001a\u00020u8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u008f\u0001\u0010\u008b\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0005\b\u0092\u0001\u0010xR\u0019\u0010\u0093\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0094\u0001R \u0010\u0097\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0096\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u007f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0094\u0001R\u0019\u0010\u0099\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0094\u0001R\u0019\u0010\u009a\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u0094\u0001R\u0019\u0010\u0080\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0094\u0001R\u0014\u0010\u009c\u0001\u001a\u00020u8F¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u0091\u0001R\u0018\u0010 \u0001\u001a\u00030\u009d\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001¨\u0006¢\u0001"}, d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "", "Landroidx/compose/runtime/ComposerImpl;", "composer", "Landroidx/compose/runtime/changelist/ChangeList;", "changeList", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/ComposerImpl;Landroidx/compose/runtime/changelist/ChangeList;)V", "", "location", "LC7/r;", "moveReaderRelativeTo", "(I)V", "moveReaderToAbsolute", "recordSlotEditing", "()V", "newChangeList", "Lkotlin/Function0;", "block", "withChangeList", "(Landroidx/compose/runtime/changelist/ChangeList;LS7/a;)V", "withoutImplicitRootStart", "(LS7/a;)V", "Landroidx/compose/runtime/RememberObserverHolder;", "value", "remember", "(Landroidx/compose/runtime/RememberObserverHolder;)V", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "rememberPausingScope", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "startResumingScope", "endResumingScope", "groupSlotIndex", "updateValue", "(Ljava/lang/Object;I)V", "Landroidx/compose/runtime/Anchor;", "anchor", "updateAnchoredValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Anchor;I)V", "appendValue", "(Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)V", "count", "trimValues", "resetSlots", SettingsConfig.KEY_DATA, "updateAuxData", "(Ljava/lang/Object;)V", "endRoot", "endCurrentGroup", "skipToEndOfCurrentGroup", "removeCurrentGroup", "Landroidx/compose/runtime/SlotTable;", TypedValues.TransitionType.S_FROM, "insertSlots", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/SlotTable;)V", "Landroidx/compose/runtime/changelist/FixupList;", "fixups", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/changelist/FixupList;)V", TypedValues.CycleType.S_WAVE_OFFSET, "moveCurrentGroup", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "composition", "endCompositionScope", "(LS7/k;Landroidx/compose/runtime/Composition;)V", "node", "useNode", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Function2;", "updateNode", "(Ljava/lang/Object;LS7/n;)V", "nodeIndex", "removeNode", "(II)V", TypedValues.TransitionType.S_TO, "moveNode", "(III)V", "releaseMovableContent", "endNodeMovement", "group", "endNodeMovementAndDeleteNode", "moveUp", "moveDown", "effect", "sideEffect", "Landroidx/compose/runtime/internal/IntRef;", "effectiveNodeIndexOut", "determineMovableContentNodeIndex", "(Landroidx/compose/runtime/internal/IntRef;Landroidx/compose/runtime/Anchor;)V", "", "nodes", "effectiveNodeIndex", "copyNodesToNewAnchorLocation", "(Ljava/util/List;Landroidx/compose/runtime/internal/IntRef;)V", "Landroidx/compose/runtime/MovableContentState;", "resolvedState", "Landroidx/compose/runtime/CompositionContext;", "parentContext", "Landroidx/compose/runtime/MovableContentStateReference;", "copySlotTableToAnchorLocation", "(Landroidx/compose/runtime/MovableContentState;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentStateReference;)V", "Landroidx/compose/runtime/ControlledComposition;", TypedValues.Custom.S_REFERENCE, "releaseMovableGroupAtCurrent", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/MovableContentStateReference;)V", "endMovableContentPlacement", "other", "includeOperationsIn", "(Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/internal/IntRef;)V", "finalizeComposition", "resetTransientState", "deactivateCurrentGroup", "pushApplierOperationPreamble", "pushSlotEditingOperationPreamble", "", "useParentSlot", "pushSlotTableOperationPreamble", "(Z)V", "ensureRootStarted", "ensureGroupStarted", "(Landroidx/compose/runtime/Anchor;)V", "forParent", "realizeOperationLocation", "realizeNodeMovementOperations", "removeFrom", "moveCount", "realizeRemoveNode", "realizeMoveNode", "pushPendingUpsAndDowns", "Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/changelist/ChangeList;", "getChangeList", "()Landroidx/compose/runtime/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "startedGroup", "Z", "Landroidx/compose/runtime/IntStack;", "startedGroups", "Landroidx/compose/runtime/IntStack;", "implicitRootStart", "getImplicitRootStart", "()Z", "setImplicitRootStart", "writersReaderDelta", "I", "pendingUps", "Landroidx/compose/runtime/Stack;", "pendingDownNodes", "Ljava/util/ArrayList;", "moveFrom", "moveTo", "getPastParent", "pastParent", "Landroidx/compose/runtime/SlotReader;", "getReader", "()Landroidx/compose/runtime/SlotReader;", "reader", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerChangeListWriter {
    private static final int invalidGroupLocation = -2;
    private ChangeList changeList;
    private final ComposerImpl composer;
    private int moveCount;
    private int pendingUps;
    private boolean startedGroup;
    private int writersReaderDelta;
    public static final int $stable = 8;
    private final IntStack startedGroups = new IntStack();
    private boolean implicitRootStart = true;
    private final ArrayList pendingDownNodes = Stack.m3459constructorimpl$default(null, 1, null);
    private int removeFrom = -1;
    private int moveFrom = -1;
    private int moveTo = -1;

    public ComposerChangeListWriter(ComposerImpl composerImpl, ChangeList changeList) {
        this.composer = composerImpl;
        this.changeList = changeList;
    }

    private final void ensureGroupStarted(Anchor anchor) {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureGroupStarted(anchor);
        this.startedGroup = true;
    }

    private final void ensureRootStarted() {
        if (this.startedGroup || !this.implicitRootStart) {
            return;
        }
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureRootStarted();
        this.startedGroup = true;
    }

    private final SlotReader getReader() {
        return this.composer.getReader();
    }

    public static /* synthetic */ void includeOperationsIn$default(ComposerChangeListWriter composerChangeListWriter, ChangeList changeList, IntRef intRef, int i, Object obj) {
        if ((i & 2) != 0) {
            intRef = null;
        }
        composerChangeListWriter.includeOperationsIn(changeList, intRef);
    }

    private final void pushApplierOperationPreamble() {
        pushPendingUpsAndDowns();
    }

    private final void pushPendingUpsAndDowns() {
        int i = this.pendingUps;
        if (i > 0) {
            this.changeList.pushUps(i);
            this.pendingUps = 0;
        }
        if (Stack.m3465isNotEmptyimpl(this.pendingDownNodes)) {
            this.changeList.pushDowns(Stack.m3470toArrayimpl(this.pendingDownNodes));
            Stack.m3457clearimpl(this.pendingDownNodes);
        }
    }

    private final void pushSlotEditingOperationPreamble() {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
    }

    private final void pushSlotTableOperationPreamble(boolean useParentSlot) {
        realizeOperationLocation(useParentSlot);
    }

    public static /* synthetic */ void pushSlotTableOperationPreamble$default(ComposerChangeListWriter composerChangeListWriter, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        composerChangeListWriter.pushSlotTableOperationPreamble(z10);
    }

    private final void realizeMoveNode(int to, int from, int count) {
        pushApplierOperationPreamble();
        this.changeList.pushMoveNode(to, from, count);
    }

    private final void realizeNodeMovementOperations() {
        int i = this.moveCount;
        if (i > 0) {
            int i6 = this.removeFrom;
            if (i6 >= 0) {
                realizeRemoveNode(i6, i);
                this.removeFrom = -1;
            } else {
                realizeMoveNode(this.moveTo, this.moveFrom, i);
                this.moveFrom = -1;
                this.moveTo = -1;
            }
            this.moveCount = 0;
        }
    }

    private final void realizeOperationLocation(boolean forParent) {
        int parent = forParent ? getReader().getParent() : getReader().getCurrentGroup();
        int i = parent - this.writersReaderDelta;
        if (!(i >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Tried to seek backward");
        }
        if (i > 0) {
            this.changeList.pushAdvanceSlotsBy(i);
            this.writersReaderDelta = parent;
        }
    }

    public static /* synthetic */ void realizeOperationLocation$default(ComposerChangeListWriter composerChangeListWriter, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        composerChangeListWriter.realizeOperationLocation(z10);
    }

    private final void realizeRemoveNode(int removeFrom, int moveCount) {
        pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(removeFrom, moveCount);
    }

    public final void appendValue(Anchor anchor, Object value) {
        this.changeList.pushAppendValue(anchor, value);
    }

    public final void copyNodesToNewAnchorLocation(List<? extends Object> nodes, IntRef effectiveNodeIndex) {
        this.changeList.pushCopyNodesToNewAnchorLocation(nodes, effectiveNodeIndex);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState resolvedState, CompositionContext parentContext, MovableContentStateReference from, MovableContentStateReference to) {
        this.changeList.pushCopySlotTableToAnchorLocation(resolvedState, parentContext, from, to);
    }

    public final void deactivateCurrentGroup() {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushDeactivateCurrentGroup();
    }

    public final void determineMovableContentNodeIndex(IntRef effectiveNodeIndexOut, Anchor anchor) {
        pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(effectiveNodeIndexOut, anchor);
    }

    public final void endCompositionScope(k action, Composition composition) {
        this.changeList.pushEndCompositionScope(action, composition);
    }

    public final void endCurrentGroup() {
        int parent = getReader().getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup");
        }
        if (this.startedGroups.peekOr(-1) == parent) {
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.startedGroups.pop();
            this.changeList.pushEndCurrentGroup();
        }
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.writersReaderDelta = 0;
    }

    public final void endNodeMovement() {
        realizeNodeMovementOperations();
    }

    public final void endNodeMovementAndDeleteNode(int nodeIndex, int group) {
        endNodeMovement();
        pushPendingUpsAndDowns();
        int iNodeCount = getReader().isNode(group) ? 1 : getReader().nodeCount(group);
        if (iNodeCount > 0) {
            removeNode(nodeIndex, iNodeCount);
        }
    }

    public final void endResumingScope(RecomposeScopeImpl scope) {
        this.changeList.pushEndResumingScope(scope);
    }

    public final void endRoot() {
        if (this.startedGroup) {
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.changeList.pushEndCurrentGroup();
            this.startedGroup = false;
        }
    }

    public final void finalizeComposition() {
        pushPendingUpsAndDowns();
        if (this.startedGroups.tos == 0) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup()");
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final boolean getPastParent() {
        return getReader().getParent() - this.writersReaderDelta < 0;
    }

    public final void includeOperationsIn(ChangeList other, IntRef effectiveNodeIndex) {
        this.changeList.pushExecuteOperationsIn(other, effectiveNodeIndex);
    }

    public final void insertSlots(Anchor anchor, SlotTable from) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, from);
    }

    public final void moveCurrentGroup(int offset) {
        pushSlotEditingOperationPreamble();
        this.changeList.pushMoveCurrentGroup(offset);
    }

    public final void moveDown(Object node) {
        realizeNodeMovementOperations();
        Stack.m3469pushimpl(this.pendingDownNodes, node);
    }

    public final void moveNode(int from, int to, int count) {
        if (count > 0) {
            int i = this.moveCount;
            if (i > 0 && this.moveFrom == from - i && this.moveTo == to - i) {
                this.moveCount = i + count;
                return;
            }
            realizeNodeMovementOperations();
            this.moveFrom = from;
            this.moveTo = to;
            this.moveCount = count;
        }
    }

    public final void moveReaderRelativeTo(int location) {
        this.writersReaderDelta = (location - getReader().getCurrentGroup()) + this.writersReaderDelta;
    }

    public final void moveReaderToAbsolute(int location) {
        this.writersReaderDelta = location;
    }

    public final void moveUp() {
        realizeNodeMovementOperations();
        if (Stack.m3465isNotEmptyimpl(this.pendingDownNodes)) {
            Stack.m3468popimpl(this.pendingDownNodes);
        } else {
            this.pendingUps++;
        }
    }

    public final void recordSlotEditing() {
        SlotReader reader;
        int parent;
        if (getReader().getGroupsSize() <= 0 || this.startedGroups.peekOr(-2) == (parent = (reader = getReader()).getParent())) {
            return;
        }
        ensureRootStarted();
        if (parent > 0) {
            Anchor anchor = reader.anchor(parent);
            this.startedGroups.push(parent);
            ensureGroupStarted(anchor);
        }
    }

    public final void releaseMovableContent() {
        pushPendingUpsAndDowns();
        if (this.startedGroup) {
            skipToEndOfCurrentGroup();
            endRoot();
        }
    }

    public final void releaseMovableGroupAtCurrent(ControlledComposition composition, CompositionContext parentContext, MovableContentStateReference reference) {
        this.changeList.pushReleaseMovableGroupAtCurrent(composition, parentContext, reference);
    }

    public final void remember(RememberObserverHolder value) {
        this.changeList.pushRemember(value);
    }

    public final void rememberPausingScope(RecomposeScopeImpl scope) {
        this.changeList.pushRememberPausingScope(scope);
    }

    public final void removeCurrentGroup() {
        pushSlotEditingOperationPreamble();
        this.changeList.pushRemoveCurrentGroup();
        this.writersReaderDelta = getReader().getGroupSize() + this.writersReaderDelta;
    }

    public final void removeNode(int nodeIndex, int count) {
        if (count > 0) {
            if (!(nodeIndex >= 0)) {
                ComposerKt.composeImmediateRuntimeError("Invalid remove index " + nodeIndex);
            }
            if (this.removeFrom == nodeIndex) {
                this.moveCount += count;
                return;
            }
            realizeNodeMovementOperations();
            this.removeFrom = nodeIndex;
            this.moveCount = count;
        }
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
    }

    public final void resetTransientState() {
        this.startedGroup = false;
        this.startedGroups.clear();
        this.writersReaderDelta = 0;
        this.implicitRootStart = true;
        this.pendingUps = 0;
        Stack.m3457clearimpl(this.pendingDownNodes);
        this.removeFrom = -1;
        this.moveFrom = -1;
        this.moveTo = -1;
        this.moveCount = 0;
    }

    public final void setChangeList(ChangeList changeList) {
        this.changeList = changeList;
    }

    public final void setImplicitRootStart(boolean z10) {
        this.implicitRootStart = z10;
    }

    public final void sideEffect(S7.a effect) {
        this.changeList.pushSideEffect(effect);
    }

    public final void skipToEndOfCurrentGroup() {
        this.changeList.pushSkipToEndOfCurrentGroup();
    }

    public final void startResumingScope(RecomposeScopeImpl scope) {
        this.changeList.pushStartResumingScope(scope);
    }

    public final void trimValues(int count) {
        if (count > 0) {
            pushSlotEditingOperationPreamble();
            this.changeList.pushTrimValues(count);
        }
    }

    public final void updateAnchoredValue(Object value, Anchor anchor, int groupSlotIndex) {
        this.changeList.pushUpdateAnchoredValue(value, anchor, groupSlotIndex);
    }

    public final void updateAuxData(Object data) {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushUpdateAuxData(data);
    }

    public final <T, V> void updateNode(V value, n block) {
        pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(value, block);
    }

    public final void updateValue(Object value, int groupSlotIndex) {
        pushSlotTableOperationPreamble(true);
        this.changeList.pushUpdateValue(value, groupSlotIndex);
    }

    public final void useNode(Object node) {
        pushApplierOperationPreamble();
        this.changeList.pushUseNode(node);
    }

    public final void withChangeList(ChangeList newChangeList, S7.a block) {
        ChangeList changeList = getChangeList();
        try {
            setChangeList(newChangeList);
            block.invoke();
        } finally {
            setChangeList(changeList);
        }
    }

    public final void withoutImplicitRootStart(S7.a block) {
        boolean implicitRootStart = getImplicitRootStart();
        try {
            setImplicitRootStart(false);
            block.invoke();
        } finally {
            setImplicitRootStart(implicitRootStart);
        }
    }

    public final void insertSlots(Anchor anchor, SlotTable from, FixupList fixups) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, from, fixups);
    }
}
